package com.example.facebooklogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.facebooklogin.databinding.ActivityHomeBinding
import com.facebook.AccessToken
import com.facebook.GraphRequest
import com.facebook.GraphResponse
import com.facebook.login.LoginManager
import org.json.JSONObject

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var accessToken = AccessToken.getCurrentAccessToken()

        binding.btnLogout.setOnClickListener {
            LoginManager.getInstance().logOut()
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }

        accessToken?.let {

            val request = GraphRequest.newMeRequest(it, object : GraphRequest.GraphJSONObjectCallback {
                override fun onCompleted(jsonobject: JSONObject?, response: GraphResponse?)
                {
                    jsonobject?.let {

                        var id = it.getString("id")
                        var name = it.getString("name")
                        var profileUrl = it.getJSONObject("picture").getJSONObject("data").getString("url")

                        Glide
                            .with(applicationContext)
                            .load(profileUrl)
                            .centerCrop()
                            .placeholder(R.drawable.ic_launcher_foreground)
                            .into(binding.ivProfile);

                        binding.tvResult.text = "id : $id\nname : $name`"
                    }

                    Log.d("PROFILE", "$jsonobject")
                }
            })

            val parameters = Bundle()
            parameters.putString("fields","id,name,link,picture.type(large),email,birthday")
            request.parameters = parameters
            request.executeAsync()
        }
    }
}