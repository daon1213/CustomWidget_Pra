package com.daon.customwidget_pra

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class CustomText : AppCompatTextView {

    constructor(context: Context) : super(context) { }
    constructor(context: Context, attrs:AttributeSet) : super(context, attrs) {
        val attrList = context.obtainStyledAttributes(attrs, R.styleable.CustomText) // 정의된 것들만 꺼내서 처리

        for (i in 0 until attrList.indexCount) {

            val attr = attrList.getIndex(i)

            when(attr) {
                R.styleable.CustomText_delimeter -> {
                    attrList.getString(attr)?.let {
                        process(it)
                    }
                }
            }
        }
    }
    constructor(context: Context, attrs:AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) { }

    @SuppressLint("SetTextI18n")
    fun process(delimeter: String) {
        if(text.length == 8) {
            val Year = text.substring(0, 4)
            val Month = text.substring(4, 6)
            val Day = text.substring(6)

            text = "$Year$delimeter$Month$delimeter$Day"
        }
    }
}