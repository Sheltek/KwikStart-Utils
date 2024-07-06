package com.sheltek.kwikstart.utils.sharedPrefs

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class LongPreferenceDelegate(private val store: PreferenceStore) : ReadWriteProperty<Any, Long> {
    override fun getValue(thisRef: Any, property: KProperty<*>) = store.long(property.name) ?: 0L

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Long) =
        store.set(property.name, value)
}
