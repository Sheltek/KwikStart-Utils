package com.bottlerocketstudios.launchpad.utils.sharedPrefs

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class StringSetPreferenceDelegate(private val store: PreferenceStore) : ReadWriteProperty<Any, Set<String>> {

    override fun getValue(thisRef: Any, property: KProperty<*>): Set<String> =
        Json.decodeFromString(store.string(property.name).orEmpty())

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Set<String>) =
        store.set(property.name, Json.encodeToString<Set<String>>(value))
}
