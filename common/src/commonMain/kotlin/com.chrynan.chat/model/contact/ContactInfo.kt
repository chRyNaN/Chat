package com.chrynan.chat.model.contact

data class ContactInfo(
    val addresses: List<FullAddress> = emptyList(),
    val webAddresses: List<WebAddress> = emptyList(),
    val importantDates: List<ImportantDate> = emptyList(),
    val places: List<Place> = emptyList(),
    val phoneNumbers: List<PhoneNumber> = emptyList(),
    val emails: List<Email> = emptyList(),
    val interests: List<String> = emptyList(),
    val notes: List<String> = emptyList()
)