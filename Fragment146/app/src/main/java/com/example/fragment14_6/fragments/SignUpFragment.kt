package com.example.fragment14_6.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fragment14_6.R
import com.example.fragment14_6.databinding.FragmentSignUpActivityBinding
import java.util.regex.Pattern

class SignUpFragment : Fragment() {

    private val REGEX = ("^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$")

    private lateinit var binding:FragmentSignUpActivityBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpActivityBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {

            var name = binding.tvName.text.toString().trim()
            var contact = binding.tvContact.text.toString().trim()
            var email = binding.tvEmail.text.toString().trim()
            var password = binding.tvPassword.text.toString().trim()
            var Confirmpassword = binding.tvConfirmpassword.text.toString().trim()
/*
            if (isValidContact(contact) && isValidEmail(email) && isValidPassword(password) && isValidConfirmpassword(Confirmpassword))
            {
                val intent= Intent(requireActivity(),SignUpFragment::class.java)
                intent.putExtra("name",binding.tvName.text.toString())
                intent.putExtra("contact",binding.tvContact.text.toString())
                intent.putExtra("email",binding.tvEmail.text.toString())
                intent.putExtra("password",binding.tvPassword.text.toString())
                intent.putExtra("Confirmpassword",binding.tvConfirmpassword.text.toString())
                startActivity(intent)
            }else
            {
                Toast.makeText(requireActivity(), "error in name or contact or email or password or confirmpassword", Toast.LENGTH_SHORT).show()
            }*/
            if(name.isEmpty()){
                binding.tvName.error = "Enter your name"
                Toast.makeText(requireActivity(),"error name",Toast.LENGTH_SHORT).show()
            }else if(!isValidContact(contact)){
                binding.tvContact.error = "Enter valid contact number"
                Toast.makeText(requireActivity(),"error contact",Toast.LENGTH_SHORT).show()
            }else if(!isValidEmail(email)){
                binding.tvEmail.error = "Enter valid email address"
                Toast.makeText(requireActivity(),"error email",Toast.LENGTH_SHORT).show()
            }else if(!isValidPassword(password)) {
                binding.tvPassword.error = "Enter valid password"
                Toast.makeText(requireActivity(),"error password",Toast.LENGTH_SHORT).show()
            }else if (!isValidConfirmpassword(Confirmpassword)) {
                binding.tvConfirmpassword.error = "Enter valid Confirmpassword"
                Toast.makeText(requireActivity(),"error confirmpassword",Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(requireActivity(), "All fields are validated", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun isValidContact(contact:String):Boolean
    {
        return contact.length==10
    }
    private fun isValidEmail(email:String):Boolean
    {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    private fun isValidPassword(password:String) : Boolean
    {
        return Pattern.compile(REGEX).matcher(password).matches()
    }
    private fun isValidConfirmpassword(Confirmpassword:String):Boolean
    {
        return  Pattern.compile(REGEX).matcher(Confirmpassword).matches()
    }
}