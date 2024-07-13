package com.sheltek.kwikstart.utils.sharedPrefs

class MemoryPreferenceStore() : PreferenceStore {
    private val map = mutableMapOf<String, Any>()

    override fun string(key: String) = map[key] as? String
    override fun set(key: String, value: String) {
        map[key] = value
    }

    override fun bool(forKey: String) = map[forKey] as? Boolean
    override fun set(key: String, value: Boolean) {
        map[key] = value
    }

    override fun int(key: String) = map[key] as? Int
    override fun set(key: String, value: Int) {
        map[key] = value
    }

    override fun float(key: String) = map[key] as? Float
    override fun set(key: String, value: Float) {
        map[key] = value
    }

    override fun long(key: String) = map[key] as? Long
    override fun set(key: String, value: Long) {
        map[key] = value
    }
}