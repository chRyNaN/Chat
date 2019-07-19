package com.chrynan.chat.view

interface VerificationInfoView : View {

    fun showVerification(wasSent: Boolean, wasSeen: Boolean)

    fun hideVerification()
}