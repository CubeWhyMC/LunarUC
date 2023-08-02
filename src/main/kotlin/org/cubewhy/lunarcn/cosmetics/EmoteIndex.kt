package org.cubewhy.lunarcn.cosmetics

import kotlinx.serialization.*

@Serializable
data class EmoteIndex(val emotes: List<Emote>)

@Serializable
data class Emote(val id: Int, val name: String)