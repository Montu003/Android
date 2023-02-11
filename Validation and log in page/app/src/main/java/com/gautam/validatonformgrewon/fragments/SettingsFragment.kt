package com.gautam.validatonformgrewon.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.gautam.validatonformgrewon.LoginActivity
import com.gautam.validatonformgrewon.R
import com.gautam.validatonformgrewon.databinding.FragmentSettingsBinding
import com.gautam.validatonformgrewon.shareprefrence.PrefManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class SettingsFragment : Fragment() {

    lateinit var binding: FragmentSettingsBinding
    lateinit var prefManager: PrefManager
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var gso: GoogleSignInOptions
    lateinit var mGoogleSignInClient: GoogleSignInClient
    val tvResult: TextView
        get() = binding.tvSetgoogleemail


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FirebaseAuth.getInstance().signOut();
        val account = GoogleSignIn.getLastSignedInAccount(requireContext())
        firebaseAuth = FirebaseAuth.getInstance()
        gso =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("509451970679-26oq01c5hpvdmjcr4da95usup116jogc.apps.googleusercontent.com")
                .requestEmail().build()
        mGoogleSignInClient = GoogleSignIn.getClient(requireContext(),gso)



        if (account != null) {

            tvResult.text = """
                 
                  personEmail =${account.email}        
                                
            """.trimIndent()

        }


        binding.btLogout.setOnClickListener {
            PrefManager(requireContext()).clear()
            singout()
        }
    }

    private fun singout() {
        Firebase.auth.signOut()  //facebook after add
        firebaseAuth.signOut()
        mGoogleSignInClient.signOut()
        val i = Intent(requireContext(), LoginActivity::class.java)
        startActivity(i)
        requireActivity().finish()
        Toast.makeText(
            requireContext(), getString(R.string.logout_successfully), Toast.LENGTH_SHORT
        ).show()
    }


}