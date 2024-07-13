package com.sheltek.kwikstart.utils.sharedPrefs

import com.sheltek.kwikstart.utils.sharedPrefs.PreferenceStore
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class FloatPreferenceDelegate(private val store: PreferenceStore) : ReadWriteProperty<Any, Float> {
    override fun getValue(thisRef: Any, property: KProperty<*>) = store.float(property.name) ?: 0f

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Float) {
        store.set(property.name, value)
    }
}
