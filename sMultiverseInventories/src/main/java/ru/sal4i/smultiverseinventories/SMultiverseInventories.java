package ru.sal4i.smultiverseinventories;

import com.gmail.visualbukkit.blocks.BlockRegistry;
import com.gmail.visualbukkit.extensions.VisualBukkitExtension;
import com.gmail.visualbukkit.project.BuildContext;
import com.gmail.visualbukkit.project.PluginModule;
import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;

public class SMultiverseInventories extends VisualBukkitExtension {
    private static final PluginModule MODULE = new PluginModule() {
        @Override
        public void prepareBuild(BuildContext buildContext) {
            buildContext.addMavenRepository(
                    "<id>OnARandomBox</id>\n" +
                            "<url>https://repo.onarandombox.com/content/groups/public/</url>");
            buildContext.addMavenDependency(
                    "<groupId>com.onarandombox.multiverseinventories</groupId>\n" +
                            "<artifactId>Multiverse-Inventories</artifactId>\n" +
                            "<version>4.3.1</version>\n" +
                            "<scope>provided</scope>");
        }
    };

    public SMultiverseInventories() throws IOException {
        PluginModule.register("sMultiverseInventories", MODULE);
        try (InputStream inputStream = getClass().getResourceAsStream("/Blocks.json")) {
            BlockRegistry.register(this, new JSONArray(new JSONTokener(inputStream)));
        }
    }

    @Override
    public String getName() {
        return "sMultiverseInventories";
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
