package com.commit451.viewtiful.kotlin

import android.support.annotation.Px
import android.view.View
import android.view.ViewGroup
import com.commit451.viewtiful.Viewtiful

fun View.topMargin(@Px margin: Int) {
    (layoutParams as ViewGroup.MarginLayoutParams).topMargin = margin
}

fun View.bottomMargin(@Px margin: Int) {
    (layoutParams as ViewGroup.MarginLayoutParams).bottomMargin = margin
}

fun View.leftMargin(@Px margin: Int) {
    (layoutParams as ViewGroup.MarginLayoutParams).leftMargin = margin
}

fun View.rightMargin(@Px margin: Int) {
    (layoutParams as ViewGroup.MarginLayoutParams).rightMargin = margin
}

fun View.setPaddingTop(@Px padding: Int) {
    Viewtiful.setPaddingTop(this, padding)
}

fun View.setPaddingBottom(@Px padding: Int) {
    Viewtiful.setPaddingBottom(this, padding)
}

fun View.setPaddingLeft(@Px padding: Int) {
    Viewtiful.setPaddingLeft(this, padding)
}

fun View.setPaddingRight(@Px padding: Int) {
    Viewtiful.setPaddingRight(this, padding)
}

fun View.setPadding(@Px padding: Int) {
    Viewtiful.setPadding(this, padding)
}

fun View.onViewPreDraw(runnable: Runnable) {
    Viewtiful.onPreDraw(this, runnable)
}

fun View.onGlobalLayout(runnable: Runnable) {
    Viewtiful.onGlobalLayout(this, runnable)
}
