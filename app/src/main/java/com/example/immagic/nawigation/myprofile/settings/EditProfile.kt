package com.example.immagic.nawigation.myprofile.settings

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.immagic.R
import kotlinx.coroutines.launch

class EditProfile : AppCompatActivity() {

    private lateinit var goBackBtn: ImageButton
    private lateinit var inputNewName: EditText
    private lateinit var saveBtn: Button
    private lateinit var newName: String

    private lateinit var uploadNewIcon: ImageButton
    private lateinit var settingsRepository: SettingsRepository
    private lateinit var iconView: ImageView


    // Dodaj ActivityResultLauncher
    private lateinit var getContent: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_profile_layout)

        settingsRepository = SettingsImpl(this@EditProfile)
        goBackBtn = findViewById(R.id.equipmentGoBackBtn)
        inputNewName = findViewById(R.id.editTextTextPersonName)
        saveBtn = findViewById(R.id.saveBtnEditProfile)
        uploadNewIcon = findViewById(R.id.uploadNewIcon)
        iconView = findViewById(R.id.iconView)
        iconView.scaleType = ImageView.ScaleType.FIT_CENTER


        uploadNewIcon.setOnClickListener {
            openImageChooser()
        }

        saveBtn.setOnClickListener {
            newName = inputNewName.text.toString()
            lifecycleScope.launch {
                settingsRepository.updateUsername(newName)
                finish()
            }
        }

        goBackBtn.setOnClickListener {
            finish()
        }

        // Zarejestruj ActivityResultLauncher
        getContent = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val imageUri = result.data?.data
                lifecycleScope.launch {
                    if (imageUri != null) {
                        val imageUriString = imageUri.toString()
                        settingsRepository.updateUserIcon(imageUriString)
                    }
                    Log.d("EditProfile", "udalo sie")
                    iconView.setImageURI(imageUri)

                }
            }
        }

    }

    private fun openImageChooser() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        getContent.launch(intent)

    }
}
