package com.example.immagic.homepage

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.core.content.ContextCompat.startActivity
import androidx.core.graphics.drawable.toBitmap
import com.example.immagic.R
import java.io.File

class ShareFileManager(private val context: Context) {

    fun shareFile() {
        // Pobierz referencję do Drawable
        val drawable: Drawable? = ContextCompat.getDrawable(context, R.drawable.alchemy_bottle)

        // Skonwertuj Drawable na Bitmap
        val bitmap: Bitmap? = drawable?.toBitmap()

        // Zapisz Bitmap do pliku tymczasowego
        val tempFile: File = File.createTempFile("temp_image", ".png", context.cacheDir)

        // Uzyskaj URI zapisanego pliku tymczasowego
        val uriToImage: Uri = FileProvider.getUriForFile(
            context,
            context.applicationContext.packageName + ".provider",
            tempFile
        )

        // Teraz możesz użyć uriToImage w Twoim Intencie udostępniania
        val shareIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_STREAM, uriToImage)
            type = "image/png" // Ustaw odpowiedni typ MIME dla Twojego obrazu
        }
        startActivity(context, Intent.createChooser(shareIntent, null), null)
    }
}
