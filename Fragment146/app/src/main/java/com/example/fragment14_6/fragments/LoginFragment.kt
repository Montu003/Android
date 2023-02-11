package com.example.fragment14_6.fragments

import android.content.Intent
import android.os.Build.VERSION_CODES.S
import android.os.Bundle
import android.service.autofill.FieldClassification
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.viewbinding.ViewBindings
import com.example.fragment14_6.R
import com.example.fragment14_6.databinding.FragmentLoginBinding
import java.util.regex.Pattern
import javax.crypto.Mac

class LoginFragment : Fragment() {


    private lateinit var binding:FragmentLoginBinding

    private val REGEX = ("^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSignup.setOnClickListener {

            var fragment = SignUpFragment()
            var manager = requireActivity().supportFragmentManager
            var transaction = manager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.btnLogin.setOnClickListener {

            var email = binding.etEmail.text.toString().trim()
            var password = binding.etPassword.text.toString().trim()

       /*     if(isvalideemail(email) && isvalidepassword(password)){
                val intent=Intent(requireActivity(),LoginFragment::class.java)
                intent.putExtra("email",binding.etEmail.text.toString())
                intent.putExtra("password",binding.etPassword.text.toString())
                startActivity(intent)
            }else{
                Toast.makeText(requireActivity(), "error in email or password", Toast.LENGTH_SHORT).show()
            }*/
            if (!isvalideemail(email))
            {
                binding.etEmail.error = "Enter your email"
                Toast.makeText(requireActivity(),"error email",Toast.LENGTH_SHORT).show()
            }else if (!isvalidepassword(password))
            {
                binding.etPassword.error = "Enter valid password"
                Toast.makeText(requireActivity(),"error password",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(requireActivity(), "All fields are validated", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun isvalideemail(email:String):Boolean
    {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    private fun isvalidepassword(password:String):Boolean
    {
        return  Pattern.compile(REGEX).matcher(password).matches()
    }
}