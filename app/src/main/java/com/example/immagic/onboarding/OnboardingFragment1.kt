package com.example.immagic.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.immagic.R

class OnboardingFragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Tutaj inflatuj układ XML dla pierwszego ekranu onboardingu
        return inflater.inflate(R.layout.fragment_onboarding1, container, false)
    }
}
