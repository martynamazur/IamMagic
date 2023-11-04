package com.example.immagic.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.immagic.first_use.SetName
import com.example.immagic.R
import com.example.immagic.nawigation.ManageNawigation

class OnboardingFragment4 : Fragment() {

    private lateinit var continuueBtnEndOnboarding: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_onboarding4, container, false)
        continuueBtnEndOnboarding = view.findViewById(R.id.continuueBtnOnboarding)
        continuueBtnEndOnboarding.setOnClickListener {
            val intent = Intent(requireContext(), SetName::class.java)
            startActivity(intent)

        }
        return view
    }
}
