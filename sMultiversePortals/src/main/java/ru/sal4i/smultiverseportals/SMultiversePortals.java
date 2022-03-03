package ru.sal4i.smultiverseportals;

import com.gmail.visualbukkit.blocks.BlockRegistry;
import com.gmail.visualbukkit.extensions.VisualBukkitExtension;
import com.gmail.visualbukkit.project.BuildContext;
import com.gmail.visualbukkit.project.PluginModule;
import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;

public class SMultiversePortals extends VisualBukkitExtension {
    private static final PluginModule MODULE = new PluginModule() {
        @Override
        public void prepareBuild(BuildContext buildContext) {
            buildContext.addMavenRepository(
                    "<id>OnARandomBox</id>\n" +
                            "<url>https://repo.onarandombox.com/content/groups/public/</url>");
            buildContext.addMavenDependency(
                    "<groupId>com.onarandombox.multiverseportals</groupId>\n" +
                            "<artifactId>Multiverse-Portals</artifactId>\n" +
                            "<version>4.2.0</version>\n" +
                            "<scope>provided</scope>");
        }
    };

    public SMultiversePortals() throws IOException {
        PluginModule.register("sMultiversePortals", MODULE);
        try (InputStream inputStream = getClass().getResourceAsStream("/Blocks.json")) {
            BlockRegistry.register(this, new JSONArray(new JSONTokener(inputStream)));
        }
    }

    @Override
    public String getName() {
        return "sMultiversePortals";
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
