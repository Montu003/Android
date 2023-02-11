package com.example.vegiapp.activity

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import com.example.vegiapp.R
import com.example.vegiapp.adapter.MainViewPagerAdapter
import com.example.vegiapp.api.Const
import com.example.vegiapp.api.RetrofitApiBuilder
import com.example.vegiapp.databinding.ActivityHomeBinding
import com.example.vegiapp.databinding.LoginBottomSheetDialogBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

//mvc small
//mvp large
class HomeActivity : BaseActivity() {

    private lateinit var binding: ActivityHomeBinding
    var token = ""

    val disposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        FirebaseApp.initializeApp(this)

        // firebase option add
        val options = FirebaseOptions.Builder().setApplicationId("APP_ID")
            .setGcmSenderId("SENDER_ID").build()

        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("TAG", "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            token = task.result

        })
        initView()
        initListener()
    }

    private fun initView() {
        val mainViewPagerAdapter = MainViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = mainViewPagerAdapter
        binding.viewPager.isUserInputEnabled = false
    }

    private fun initListener() {
        binding.ivMenu.setOnClickListener {
            binding.drawer.openDrawer(GravityCompat.START)
        }

//        binding.bottomNavigation.itemActiveIndicatorColor = ColorStateList.valueOf(ContextCompat.getColor(this,R.color.white))
        //   binding.btnProgressBar.visibility = View.VISIBLE
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_Home -> {

                    binding.viewPager.setCurrentItem(0, false)
                    true
                }
                R.id.action_Category -> {

                    binding.viewPager.setCurrentItem(1, false)
                    true
                }
                R.id.action_Cart -> {

                    binding.viewPager.setCurrentItem(2, false)
                    true
                }

                R.id.action_Profile -> {

                    if (sessionManager.getBooleanValue(Const.IS_LOGGEDIN)) {

                        binding.viewPager.setCurrentItem(3, false)

                    } else {

                        val dialog = BottomSheetDialog(this)
                        val loginBottomSheetBinding: LoginBottomSheetDialogBinding =
                            DataBindingUtil.inflate(
                                LayoutInflater.from(this),
                                R.layout.login_bottom_sheet_dialog,
                                null,
                                false
                            )
                        dialog.setContentView(loginBottomSheetBinding.root)

                        dialog.window?.decorView?.setBackgroundColor(Color.TRANSPARENT)
                        loginBottomSheetBinding.ivCancel.setOnClickListener { dialog.dismiss() }
                        loginBottomSheetBinding.btnGoogle.setOnClickListener { dialog.dismiss() }
                        dialog.show()

                        loginBottomSheetBinding.btnGoogle.setOnClickListener {
                            googleSignIn()
                        }
                        true
                    }
                    true
                }

                else -> true
            }
        }

        binding.ivSearch.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            // intent.putExtra("title", title)
            startActivity(intent)
        }
    }

    private fun googleSignIn() {

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        val googleSignInClient = GoogleSignIn.getClient(this, gso)
        val signInIntent: Intent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100) {

            val task: Task<GoogleSignInAccount> =
                GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(task: Task<GoogleSignInAccount>) {

        task.addOnSuccessListener {

            val acct = GoogleSignIn.getLastSignedInAccount(this)
            if (acct != null) {
                val personName = acct.displayName
                val personEmail = acct.email

                val map = HashMap<String, RequestBody>()

                map.put(
                    Const.IDENTITY,
                    personEmail!!.toRequestBody("text/plain".toMediaTypeOrNull())
                )
                map.put(
                    Const.FIRSTNAME,
                    personName!!.toRequestBody("text/plain".toMediaTypeOrNull())
                )
                map.put(
                    Const.LOGIN_TYPE,
                    1.toString().toRequestBody("text/plain".toMediaTypeOrNull())
                )
                map.put(
                    Const.DEVICE_TYPE,
                    1.toString().toRequestBody("text/plain".toMediaTypeOrNull())
                )
                map.put(Const.DEVICE_TOKEN, token.toRequestBody("text/plain".toMediaTypeOrNull()))

                callregistra(map)

            }
        }.addOnFailureListener {
            Log.i("TAG", "handleSignInResult: " + it.cause)
        }
    }

    private fun callregistra(map: HashMap<String, RequestBody>) {

        RetrofitApiBuilder.service.registration(
            Const.KEY_VALUE, map
        )

            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.unsubscribeOn(Schedulers.io())

            ?.subscribe { user, throwable ->

                val sharedPreferences: SharedPreferences = getSharedPreferences(
                    "vegi",
                    MODE_PRIVATE
                )
                val editor = sharedPreferences.edit()

                val data = Gson().toJson(user!!.data)
                editor.putString("user",   data)
                editor.putBoolean(Const.IS_LOGGEDIN,  true)
                editor.apply()

                Log.d("TAG", "callregistra: " + Gson().toJson(user))
                Log.i("TAG", "callregistra:${user.data}")

            }?.let {
                disposable.add(
                    it
                )
            }
    }
}