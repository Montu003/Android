package com.app.navigationcom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.app.navigationcom.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var Controller = Navigation.findNavController(requireActivity(),R.id.fragmentContainerView)

        binding.btnNavigateHome.setOnClickListener {

            Controller.navigate(R.id.action_loginFragment_to_homeFragment)
        }

        binding.btnNavigateRegister.setOnClickListener {

            var bundle = Bundle()
            bundle.putString("name","khodal")
            bundle.putString("email","khodal@gmail.com")
            bundle.putInt("id",15)

            Controller.navigate(R.id.action_loginFragment_to_registerFragment,bundle)
        }
    }

}