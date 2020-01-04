package com.chrynan.chat.resources

import com.chrynan.chat.R
import com.chrynan.chat.di.Inject

class StringProvider @Inject constructor(private val resourceAccessor: ResourceAccessor) :
    ResourceAccessor by resourceAccessor,
    Strings {

    override val appName by string(R.string.app_name)

    override val menuBottomTitleFeed by string(R.string.menu_bottom_title_contacts)
    override val menuBottomTitleConversations by string(R.string.menu_bottom_title_conversations)
    override val menuBottomTitleSettings by string(R.string.menu_bottom_title_settings)

    override val appBarTitleFeed by string(R.string.app_bar_title_feed)
    override val appBarTitleConversations by string(R.string.app_bar_title_conversations)
    override val appBarTitleSettings by string(R.string.app_bar_title_settings)
    override val appBarTitleOpenSourceLicenses by string(R.string.open_source_licenses_title)

    override val widgetMessageEditorHint by string(R.string.widget_message_editor_hint)

    override val openSourceLicensesGroupCommon by string(R.string.open_source_licenses_group_common)
    override val openSourceLicensesGroupAndroid by string(R.string.open_source_licenses_group_android)
    override val openSourceLicensesItemKotlin by string(R.string.open_source_licenses_item_kotlin)
    override val openSourceLicensesItemAndroidSupport by string(R.string.open_source_licenses_item_android_support)

    override val appInfoVersionLabel by string(R.string.app_info_version_label)
    override val appInfoVersionCodeLabel by string(R.string.app_info_version_code_label)
    override val appInfoUpdateAvailableLabel by string(R.string.app_info_update_available_label)
    override val appInfoAppStoreIDLabel by string(R.string.app_info_app_store_id_label)
    override val appInfoLicenseLabel by string(R.string.app_info_license_label)
    override val appInfoSourceCodeLabel by string(R.string.app_info_source_code_label)
    override val appInfoSourceCodeTitle by string(R.string.app_info_source_code_title)
}