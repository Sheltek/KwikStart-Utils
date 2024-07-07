package com.sheltek.kwikstart.utils.sharedPrefs

import com.bottlerocketstudios.launchpad.utils.sharedPrefs.PreferenceStore
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class BooleanPreferenceDelegate(private val store: PreferenceStore) : ReadWriteProperty<Any, Boolean> {
    override fun getValue(thisRef: Any, property: KProperty<*>) = store.bool(property.name) ?: false

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Boolean) {
        store.set(property.name, value)
    }
}
