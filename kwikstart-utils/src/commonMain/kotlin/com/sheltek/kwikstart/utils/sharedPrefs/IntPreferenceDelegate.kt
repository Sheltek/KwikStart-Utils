package com.sheltek.kwikstart.utils.sharedPrefs

import com.sheltek.kwikstart.utils.sharedPrefs.PreferenceStore
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class IntPreferenceDelegate(private val store: PreferenceStore) : ReadWriteProperty<Any, Int> {
    override fun getValue(thisRef: Any, property: KProperty<*>) = store.int(property.name) ?: 0

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Int) =
        store.set(property.name, value)
}
