package ru.sal4i.smultiversecore;

import com.gmail.visualbukkit.blocks.BlockRegistry;
import com.gmail.visualbukkit.extensions.VisualBukkitExtension;
import com.gmail.visualbukkit.project.BuildContext;
import com.gmail.visualbukkit.project.PluginModule;
import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;

public class SMultiverseCore extends VisualBukkitExtension {
    private static final PluginModule MODULE = new PluginModule() {
        @Override
        public void prepareBuild(BuildContext buildContext) {
            buildContext.addMavenRepository(
                    "<id>OnARandomBox</id>\n" +
                            "<url>https://repo.onarandombox.com/content/groups/public/</url>");
            buildContext.addMavenDependency(
                    "<groupId>com.onarandombox.multiversecore</groupId>\n" +
                            "<artifactId>Multiverse-Core</artifactId>\n" +
                            "<version>4.3.1</version>\n" +
                            "<scope>provided</scope>");
        }
    };

    public SMultiverseCore() throws IOException {
        PluginModule.register("sMultiverseCore", MODULE);
        try (InputStream inputStream = SMultiverseCore.class.getResourceAsStream("/sMultiverseCore.json")) {
            BlockRegistry.register(this, new JSONArray(new JSONTokener(inputStream)));
        }
        BlockRegistry.register(this, "ru.sal4i.smultiversecore");
    }

    @Override
    public String getName() {
        return "sMultiverse-Core";
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
        return null;
    }
}
