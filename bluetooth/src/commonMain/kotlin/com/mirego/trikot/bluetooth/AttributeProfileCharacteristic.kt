package com.mirego.trikot.bluetooth

import com.mirego.trikot.foundation.CommonJSExport
import com.mirego.trikot.streams.reactive.filter
import com.mirego.trikot.streams.reactive.map
import org.reactivestreams.Publisher

@CommonJSExport
data class AttributeProfileCharacteristicEvent(val value: ByteArray?, val error: Throwable?)

@CommonJSExport
interface AttributeProfileCharacteristic {
    val uuid: String
    val event: Publisher<AttributeProfileCharacteristicEvent>
    fun read()
    fun write(data: ByteArray)
    fun watch()
    fun watchWithIndication()
}

@CommonJSExport
val AttributeProfileCharacteristic.value: Publisher<ByteArray> get() = event
    .filter { it.value != null }.map { it.value!! }

@CommonJSExport
val AttributeProfileCharacteristic.error: Publisher<Throwable> get() = event
    .filter { it.error != null }.map { it.error!! }
