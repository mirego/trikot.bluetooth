package com.mirego.trikot.bluetooth

import com.mirego.trikot.foundation.CommonJSExport
import org.reactivestreams.Publisher

@CommonJSExport
interface AttributeProfileService {
    val characteristics: Publisher<Map<String, AttributeProfileCharacteristic>>
}
