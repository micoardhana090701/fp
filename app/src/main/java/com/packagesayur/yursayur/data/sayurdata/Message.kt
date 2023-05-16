package com.packagesayur.yursayur.data.sayurdata

import com.google.firebase.database.IgnoreExtraProperties
import java.sql.Timestamp

@IgnoreExtraProperties
data class Message (
    val text: String? = null,
    val email: String? = null,
    val timestamp: Long? = null,
)