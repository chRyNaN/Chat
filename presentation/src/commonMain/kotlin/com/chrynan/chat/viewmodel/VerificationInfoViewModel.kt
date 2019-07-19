package com.chrynan.chat.viewmodel

data class VerificationInfoViewModel(
    val showVerification: Boolean,
    val wasSent: Boolean,
    val wasSeen: Boolean
) : ViewModel