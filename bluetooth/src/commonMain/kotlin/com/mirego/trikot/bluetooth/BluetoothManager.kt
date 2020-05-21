package com.mirego.trikot.bluetooth

import com.mirego.trikot.foundation.CommonJSExport
import com.mirego.trikot.streams.cancellable.CancellableManager
import org.reactivestreams.Publisher

@CommonJSExport
interface BluetoothManager {
    val statePublisher: Publisher<State>
    val missingPermissionsPublisher: Publisher<List<Permission>>

    fun scanForDevices(cancellableManager: CancellableManager, serviceUUIDs: List<String>): Publisher<List<BluetoothScanResult>>

    enum class State {
        ON,
        OFF
    }

    enum class Permission {
        BLUETOOTH,
        LOCATION
    }
}
