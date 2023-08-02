package org.cubewhy.lunarcn;

import org.cubewhy.lunarcn.patches.CosmeticsPatch;

import java.io.File;
import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.List;

public class Agent {
    public static File configFile;
    public static void premain(String arg, Instrumentation instrumentation) {
        configFile = new File(AgentConfig.INSTANCE.getCONFIG_PATH());
        configFile.getParentFile().mkdirs();

        List<Patch> patches = new ArrayList<>();
        patches.add(new CosmeticsPatch());



        System.out.println("Apply unlocker");

        instrumentation.addTransformer(new Transformer(patches));
    }
}
