package com.sheltek.kwikstart.utils.sharedPrefs

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class StringPreferenceDelegate(private val store: PreferenceStore) : ReadWriteProperty<Any, String> {
    override fun getValue(thisRef: Any, property: KProperty<*>) = store.string(property.name).orEmpty()

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) =
        store.set(property.name, value)
}
