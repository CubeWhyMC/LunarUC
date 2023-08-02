package org.cubewhy.lunarcn

import kotlinx.serialization.json.Json
import org.cubewhy.lunarcn.patches.*
import java.io.File
import java.io.FileNotFoundException
import java.lang.instrument.Instrumentation

object Agent {
    val JSON = Json { ignoreUnknownKeys = true; prettyPrint = true }
    lateinit var configFile: File private set

    private val CONFIG_PATH = System.getProperty("user.home") + "/.cubewhy/lunarcn/unlocker/config.json"

    @JvmStatic
    fun premain(arg: String, inst: Instrumentation) {
        configFile = File(CONFIG_PATH)
        configFile.parentFile.mkdirs()

        val patches = mutableListOf<Patch>(ClassloaderPatch())
        patches += CosmeticsPatch()

        println("Apply patches: " + patches.joinToString {
            it::class.simpleName!!
        })

        inst.addTransformer(Transformer(patches))
    }

}