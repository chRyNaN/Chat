package com.chrynan.chat.feature.conversation.util

import android.view.Menu
import android.view.MenuItem
import androidx.annotation.MenuRes
import androidx.appcompat.view.ActionMode
import com.chrynan.chat.resources.ResourceID

class MessageItemActionModeCallback(
    private val title: String? = null,
    private val subtitle: String? = null,
    @MenuRes private val menuResId: ResourceID,
    private val menuItemClickListener: (MenuItem) -> Unit
) : ActionMode.Callback {

    private var actionMode: ActionMode? = null

    override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
        mode?.menuInflater?.inflate(menuResId, menu)
        mode?.title = title
        mode?.subtitle = subtitle

        actionMode = mode

        return true
    }

    override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean = false

    override fun onActionItemClicked(mode: ActionMode?, item: MenuItem): Boolean {
        menuItemClickListener(item)
        finish()
        return true
    }

    override fun onDestroyActionMode(mode: ActionMode?) {
        actionMode = null
    }

    fun finish() {
        actionMode?.finish()
    }
}