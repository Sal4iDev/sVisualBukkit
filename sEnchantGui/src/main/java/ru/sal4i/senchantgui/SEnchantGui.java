package ru.sal4i.senchantgui;

import com.gmail.visualbukkit.blocks.BlockRegistry;
import com.gmail.visualbukkit.extensions.VisualBukkitExtension;
import com.gmail.visualbukkit.project.BuildContext;
import com.gmail.visualbukkit.project.PluginModule;
import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;

public class SEnchantGui extends VisualBukkitExtension {
    private static final PluginModule MODULE = new PluginModule() {
        @Override
        public void prepareBuild(BuildContext buildContext) {
            buildContext.addMavenDependency(
                    "<groupId>com.github.LegameMc</groupId>\n" +
                            "<artifactId>EnchantGui-API</artifactId>\n" +
                            "<version>1.0</version>");
        }
    };

    public SEnchantGui() throws IOException {
        PluginModule.register("sEnchantGui", MODULE);
        try (InputStream inputStream = getClass().getResourceAsStream("/Blocks.json")) {
            BlockRegistry.register(this, new JSONArray(new JSONTokener(inputStream)));
        }
        BlockRegistry.register(this, "ru.sal4i.senchantgui");
    }

    @Override
    public String getName() {
        return "sEnchantGui";
    }

    @Override
    public String getVersion() {
        return "2.0";
    }

    @Override
    public String getAuthor() {
        return "Sal4iDev";
    }

    @Override
    public String getDescription() {
        return "https://github.com/LegameMc/EnchantGui-API";
    }
}
