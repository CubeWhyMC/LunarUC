package org.cubewhy.lunarcn

import kotlinx.serialization.json.Json
import org.cubewhy.lunarcn.patches.*
import java.io.File
import java.lang.instrument.Instrumentation

object AgentConfig {
    val JSON = Json { ignoreUnknownKeys = true; prettyPrint = true }
    private lateinit var configFile: File

    val CONFIG_PATH = System.getProperty("user.home") + "/.cubewhy/lunarcn/unlocker/"

    @JvmStatic
    fun premain(arg: String, inst: Instrumentation) {
        configFile = File(CONFIG_PATH)
        configFile.mkdirs() // create dirs

        val patches = mutableListOf<Patch>(ClassloaderPatch())
        patches += CosmeticsPatch()

        println("Apply patches: " + patches.joinToString {
            it::class.simpleName!!
        })

        inst.addTransformer(Transformer(patches))
    }

}