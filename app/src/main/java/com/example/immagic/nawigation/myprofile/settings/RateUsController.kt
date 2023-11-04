package com.example.immagic.nawigation.myprofile.settings

import android.content.Context
import android.app.Activity
import com.google.android.play.core.review.ReviewManagerFactory
import com.google.android.play.core.review.ReviewInfo
import com.google.android.play.core.review.ReviewManager

import com.google.android.play.core.review.ReviewException
import com.google.android.play.core.review.model.ReviewErrorCode

class RateUsController {

    fun rateUs(activity: Activity) {
        val manager: ReviewManager = ReviewManagerFactory.create(activity)
        val request = manager.requestReviewFlow()

        request.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val reviewInfo: ReviewInfo = task.result

                val flow = manager.launchReviewFlow(activity, reviewInfo)
                flow.addOnCompleteListener { _ ->
                    // The flow has finished. The API does not indicate whether the user
                    // reviewed or not, or even whether the review dialog was shown.
                    // Thus, no matter the result, we continue our app flow.
                }
            } else {
                val reviewErrorCode = (task.exception as ReviewException).errorCode
                // Handle the error code, log, or display an appropriate message to the user
            }
        }
    }
}
