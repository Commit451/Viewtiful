package com.commit451.viewtiful.kotlin

import android.view.View
import android.view.ViewGroup
import com.commit451.viewtiful.Viewtiful

fun View.topMargin(margin: Int) {
    (layoutParams as ViewGroup.MarginLayoutParams).topMargin = margin
}

fun View.bottomMargin(margin: Int) {
    (layoutParams as ViewGroup.MarginLayoutParams).bottomMargin = margin
}

fun View.leftMargin(margin: Int) {
    (layoutParams as ViewGroup.MarginLayoutParams).leftMargin = margin
}

fun View.rightMargin(margin: Int) {
    (layoutParams as ViewGroup.MarginLayoutParams).rightMargin = margin
}

fun View.setPaddingTop(padding: Int) {
    Viewtiful.setPaddingTop(this, padding)
}

fun View.setPaddingBottom(padding: Int) {
    Viewtiful.setPaddingBottom(this, padding)
}

fun View.setPaddingLeft(padding: Int) {
    Viewtiful.setPaddingLeft(this, padding)
}

fun View.setPaddingRight(padding: Int) {
    Viewtiful.setPaddingRight(this, padding)
}

fun View.onViewPreDraw(runnable: Runnable) {
    Viewtiful.onPreDraw(this, runnable)
}

fun View.onGlobalLayout(runnable: Runnable) {
    Viewtiful.onGlobalLayout(this, runnable)
}
