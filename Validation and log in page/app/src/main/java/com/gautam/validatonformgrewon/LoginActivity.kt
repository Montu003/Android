package com.gautam.validatonformgrewon

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.gautam.validatonformgrewon.databinding.ActivityLoginBinding
import com.gautam.validatonformgrewon.entiy.AppDataBase
import com.gautam.validatonformgrewon.modal.RememberMe
import com.gautam.validatonformgrewon.modal.Users
import com.gautam.validatonformgrewon.shareprefrence.PrefManager
import com.gautam.validatonformgrewon.utils.Utils
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.gson.Gson


class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var db: AppDataBase
    lateinit var prefManager: PrefManager
    lateinit var gso: GoogleSignInOptions
    lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth

    var RC_SIGN_IN = 100
    lateinit var callbackManager: CallbackManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = AppDataBase.getInstance(this)
        prefManager = PrefManager(this)
        //FirebaseAuth.getInstance().signOut();
        googleLogin()

        val accessToken = AccessToken.getCurrentAccessToken()
        val isLoggedIn = accessToken != null && !accessToken.isExpired

        callbackManager = CallbackManager.Factory.create()
        facebook()
        val account = GoogleSignIn.getLastSignedInAccount(this)
        auth = FirebaseAuth.getInstance()

        if (prefManager.getRememberMe() != null) {
            binding.remember.isChecked = prefManager.getRememberMe()!!.isRemember
            if (prefManager.getRememberMe()!!.isRemember) {
                binding.logEmail.setText(prefManager.getRememberMe()?.email)
                binding.logLconpassworld.setText(prefManager.getRememberMe()?.passworld)
            }
        }

        binding.tvForgetpassword.setOnClickListener {
            val i = Intent(this, ForgotpassActivity::class.java)
            startActivity(i)
            finish()
        }

        binding.tvLoginmobile.setOnClickListener {
            var i = Intent(this, PhoneSmsActivity::class.java)
            startActivity(i)

        }


        binding.tvYounotaccount.setOnClickListener {
            val i = Intent(this, SignupActivity::class.java)
            startActivity(i)
        }

        binding.btLogin.setOnClickListener {
            val email = binding.logEmail.text.toString().trim()
            val password = binding.logLconpassworld.text.toString().trim()

            if (email.isEmpty()) {
                binding.logEmail.error = getString(R.string.Enter_email)
                binding.logEmail.requestFocus()
            } else if (!Utils.isValidEmail(email)) {
                binding.logEmail.error = getString(R.string.Enter_valid_format_email)
                binding.logEmail.requestFocus()
            } else if (password.isEmpty()) {
                binding.logLconpassworld.error = getString(R.string.enter_register_password)
                binding.logLconpassworld.requestFocus()
            } else if (!Utils.isValidpassword(password)) {
                binding.logLconpassworld.error =
                    getString(R.string.Upper_case_with_lover_case_character)
                binding.logLconpassworld.requestFocus()
            } else {
                doLogin(

                    binding.logEmail.text.toString().trim(),
                    binding.logLconpassworld.text.toString().trim()
                )
            }
        }
    }


    private fun facebook() {

        binding.ivFacebook.setOnClickListener {
            LoginManager.getInstance()
                .logInWithReadPermissions(this, listOf("email", "public_profile", "user_friends"));
        }
        LoginManager.getInstance()
            .registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
                override fun onCancel() {
                    Log.e("TAG", "onCancel: ")
                }

                override fun onError(error: FacebookException) {
                    Log.e("TAG", "onError: " + error.message)

                }

                override fun onSuccess(result: LoginResult) {
                    Log.e("TAG", "onSuccess: ")
                    handleFacebookAccessToken(result.accessToken)
                }

            })

    }


    private fun googleLogin() {

        gso =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("509451970679-26oq01c5hpvdmjcr4da95usup116jogc.apps.googleusercontent.com")
                .requestEmail().build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        val account = GoogleSignIn.getLastSignedInAccount(this)
        if (account != null) {
            var user = Users(googlefacebook = account.email, name = account.givenName)
            db.userDao().insertRecord(user)
        }
        binding.ivGoogle.setOnClickListener {

            val account = GoogleSignIn.getLastSignedInAccount(this)
            if (account != null) {
                account.email
                account.givenName
                account.photoUrl
                var user = Users(googlefacebook = account.email, name = account.givenName)
                db.userDao().insertRecord(user)
            }

            val signInIntent = mGoogleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN);
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
        //  handleFacebookAccessToken()
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.


            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)

        }

    }

    fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            Log.e("PPPPPPP", "handleSignInResult: " + Gson().toJson(account))
            Log.e("PPPPPPP", "handleSignInResult: " + account.idToken)
            account?.let {
                val credential = GoogleAuthProvider.getCredential(it.idToken, null)
                auth.signInWithCredential(credential).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show()
                        Log.e("TAG", "google: " + account.id)
                        val user =
                            Users(googlefacebook = account.email.toString(), google = account.id)
                        prefManager.saveLoginCredentials(user)
                        db.userDao().insertRecord(user)
                        startActivity(Intent(applicationContext, MainActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }

            }
        } catch (e: ApiException) {

        }
    }

    private fun doLogin(email: String, pass: String) {
        db.userDao().getUserList().observe(this) {
            var userData: Users? = null
            for (data in it) {
                if (data.email == email) {
                    userData = data
                }
            }
            if (userData != null) {
                if (userData.passworld == pass) {
                    prefManager.saveLoginCredentials(userData)
                    rememberMe()
                    startActivity(Intent(this, MainActivity::class.java))

                    finishAffinity()
                } else {
                    Toast.makeText(
                        applicationContext,
                        getString(R.string.password_is_wrong),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.your_email_address_is_not_exist),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }


    private fun rememberMe() {
        val rememberMe = RememberMe(
            binding.logEmail.text.toString(),
            binding.logLconpassworld.text.toString(),
            binding.remember.isChecked
        )
        prefManager.saveRememberMe(rememberMe)
    }

    private fun handleFacebookAccessToken(token: AccessToken) {
        Log.e(TAG, "handleFacebookAccessToken:$token")

        val credential = FacebookAuthProvider.getCredential(token.token)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")
                    val user = auth.currentUser
                    updateUI(user)
                    Log.e("facebookuii", "handleFacebookAccessToken: " + updateUI(user))
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    updateUI(null)

                }
            }
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            var i = Intent(this, MainActivity::class.java)
            startActivity(i)
        } else {
            Toast.makeText(this, "not successfully", Toast.LENGTH_SHORT).show()
        }

    }
}
