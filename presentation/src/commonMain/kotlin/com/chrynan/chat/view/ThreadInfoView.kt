package com.chrynan.chat.view

interface ThreadInfoView : View {

    fun showThreadMessageCount(count: Int)

    fun hideThreadMessageCount()
}