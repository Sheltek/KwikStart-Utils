package com.bottlerocketstudios.launchpad.utils.sharedPrefs

interface PreferenceStore {
    // String
    fun string(key: String): String?
    fun set(key: String, value: String)

    // Boolean
    fun bool(forKey: String): Boolean?
    fun set(key: String, value: Boolean)


    // Int
    fun int(key: String): Int?
    fun set(key: String, value: Int)

    // Float
    fun float(key: String): Float?
    fun set(key: String, value: Float)

    // Long
    fun long(key: String): Long?
    fun set(key: String, value: Long)
}