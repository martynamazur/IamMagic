package com.example.immagic.nawigation.myprofile.settings
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R

class SettingsFragment : Fragment(), OnSettingItemClickListener {

    private lateinit var settingsListRc : RecyclerView
    private lateinit var settingsAdapter: SettingsAdapter
    private lateinit var settingsListObject :  ArrayList<SettingsModel>



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        settingsListRc = view.findViewById(R.id.settingsRC)
        settingsListObject = ArrayList()
        val editProfil = SettingsModel(resources.getString(R.string.settings_edit_profile),"sun")
        val theme = SettingsModel(resources.getString(R.string.settings_theme),"sun")
        val language = SettingsModel(resources.getString(R.string.settings_language),"sun")
        val privacyPolicy = SettingsModel(resources.getString(R.string.settings_privacy_policy),"sun")
        val rateUs = SettingsModel(resources.getString(R.string.settings_rate_us),"sun")
        val credits = SettingsModel(resources.getString(R.string.settings_credits),"sun")
        val aboutUs = SettingsModel(resources.getString(R.string.settings_about_app),"sun")
        val resetProgress= SettingsModel(resources.getString(R.string.settings_reset_progress),"sun")

        settingsListObject.addAll(listOf(editProfil,theme,language,rateUs, privacyPolicy,credits,aboutUs,resetProgress))

        val layoutManager = LinearLayoutManager(requireContext())
        settingsListRc.layoutManager = layoutManager
        settingsAdapter = SettingsAdapter(this,requireContext(), settingsListObject)
        settingsListRc.adapter = settingsAdapter



        return view
    }

     override fun onSettingItemClicked(position: Int) {
        // Tutaj dodaj przejście do odpowiedniej aktywności na podstawie pozycji
        when (position) {
            0 -> {
                //Edit Profile
                val intent = Intent(requireContext(), EditProfile::class.java)
                startActivity(intent)
            }
            1 -> {
                // Theme
                val intent = Intent(requireContext(), Theme::class.java)
                startActivity(intent)
            }
            2 -> {
                //Language
                val intent = Intent(requireContext(), SetLanguage::class.java)
                startActivity(intent)
            }
            3 -> {
                //Rate us
                //val rateUsController = RateUsController()
                //rateUsController.rateUs(requireActivity())
            }
            4 -> {
                //Privacy Policy
                val intent = Intent(requireContext(), PrivacyPolicy::class.java)
                startActivity(intent)

            }
            5 -> {
                //Terms of service
                val intent = Intent(requireContext(), TermsOfService::class.java)
                startActivity(intent)


            }
            6 -> {
                //About us
                val intent = Intent(requireContext(), AboutUs::class.java)
                startActivity(intent)

            }
            7 -> {
                //Credits / Patrons

            }

            8 ->{
                // Reset app

            }
        }
    }
}

