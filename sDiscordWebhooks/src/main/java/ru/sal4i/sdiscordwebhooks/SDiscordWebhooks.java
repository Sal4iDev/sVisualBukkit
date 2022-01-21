package ru.sal4i.sdiscordwebhooks;

import com.gmail.visualbukkit.blocks.BlockRegistry;
import com.gmail.visualbukkit.extensions.VisualBukkitExtension;
import com.gmail.visualbukkit.project.BuildContext;
import com.gmail.visualbukkit.project.PluginModule;
import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;

public class SDiscordWebhooks extends VisualBukkitExtension {

    private final static PluginModule MODULE = new PluginModule() {
        @Override
        public void prepareBuild(BuildContext buildContext) {
            buildContext.addMavenDependency(
                    "<groupId>com.github.Sal4iDev</groupId>" +
                            "<artifactId>sDiscordWebhookJava</artifactId>" +
                            "<version>1.0</version>");
        }
    };

    public SDiscordWebhooks() throws IOException {
        PluginModule.register("sDiscordWebhookJava", MODULE);
        try (InputStream inputStream = SDiscordWebhooks.class.getResourceAsStream("/sDiscordWebhookJavaBlocks.json");
             InputStream inputStream1 = SDiscordWebhooks.class.getResourceAsStream("/awtColor.json")) {
            BlockRegistry.register(this, new JSONArray(new JSONTokener(inputStream)));
            /*
             Adding a java.awt.Color class can damage VisualBukkit
             Specifically, org.bukkit.Color (or whatever the package is.
             In general, I think whoever has read it understands)
            */ 
            BlockRegistry.register(this, new JSONArray(new JSONTokener(inputStream1)));
        }
    }

    @Override
    public String getName() {
        return "sDiscordWebhooks";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public String getAuthor() {
        return "Sal4iDev";
    }

    @Override
    public String getDescription() {
        return null;
    }
}
