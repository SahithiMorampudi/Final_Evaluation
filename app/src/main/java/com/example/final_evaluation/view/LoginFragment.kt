package com.example.final_evaluation.view

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.motion.widget.TransitionBuilder.validate
import androidx.navigation.findNavController
import com.example.final_evaluation.R
import com.example.final_evaluation.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater)



        binding.login.setOnClickListener {
            if (binding.userName.text.isNullOrBlank() && binding.password.text.isNullOrBlank()){
                Toast.makeText(activity,"please fill details",Toast.LENGTH_LONG).show()
            }
            else {
                RegistrationUtil.validate("fweifhiud", "fdsfdsfa")
                view?.findNavController()?.navigate(R.id.homeFragment)
                Toast.makeText(activity,"Logged Successfully",Toast.LENGTH_LONG).show()
            }
        }


        return binding.root

    }

}