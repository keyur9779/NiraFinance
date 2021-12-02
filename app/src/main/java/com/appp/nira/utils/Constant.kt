package com.appp.nira.utils

object Constant {


    fun updateFormat(value: Int): String = String.format("%,d", value)

    //------limit number of visibleItems to be overlapped
    const val numberOfItemToBeOverlapped = 6

    //------set value of item overlapping in percentage between 0 to 100
    const val overlapWidthInPercentage = 10

    const val PREF = "Nira_Pref"


}
