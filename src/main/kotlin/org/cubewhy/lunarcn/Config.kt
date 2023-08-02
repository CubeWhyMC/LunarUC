package org.cubewhy.lunarcn

import kotlinx.serialization.Serializable

@Serializable
class Config {
    val cosmeticsEnabled: Boolean = false
    val freelookEnabled: Boolean = false
    val crackedEnabled: Boolean = false
    val noHitDelayEnabled: Boolean = false
}