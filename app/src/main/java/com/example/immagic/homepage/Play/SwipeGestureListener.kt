package com.example.immagic.homepage.Play

import android.view.GestureDetector
import android.view.MotionEvent

class SwipeGestureListener(private val onSwipe: () -> Unit) : GestureDetector.SimpleOnGestureListener() {
    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        if (e1 != null) {
            val deltaY = e2.y - e1.y

            if (deltaY < 0) {
                onSwipe()
            }
        }
        return true
    }
}
