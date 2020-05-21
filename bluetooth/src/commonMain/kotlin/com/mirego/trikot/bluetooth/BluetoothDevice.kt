package com.mirego.trikot.bluetooth

import com.mirego.trikot.foundation.CommonJSExport
import org.reactivestreams.Publisher

@CommonJSExport
interface BluetoothDevice {
    val name: String

    val physicalAddress: String

    val attributeProfileServices: Publisher<Map<String, AttributeProfileService>>

    val isConnected: Publisher<Boolean>
}
