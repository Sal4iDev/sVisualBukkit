package ru.sal4i.sworldedit;

import com.gmail.visualbukkit.blocks.BlockRegistry;
import com.gmail.visualbukkit.extensions.VisualBukkitExtension;
import com.gmail.visualbukkit.project.BuildContext;
import com.gmail.visualbukkit.project.PluginModule;
import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;

public class SWorldEdit extends VisualBukkitExtension {
    private static final PluginModule MODULE = new PluginModule() {
        @Override
        public void prepareBuild(BuildContext buildContext) {
            buildContext.addMavenRepository("<id>enginehub-maven</id>\n" +
                    "<url>https://maven.enginehub.org/repo/</url>");
            buildContext.addMavenDependency("<groupId>com.sk89q.worldedit</groupId>\n" +
                    "<artifactId>worldedit-bukkit</artifactId>\n" +
                    "<version>7.2.0-SNAPSHOT</version>\n" +
                    "<scope>provided</scope>");
        }
    };

    public SWorldEdit() {
        PluginModule.register("sWorldEdit", MODULE);
        try (InputStream inputStream = SWorldEdit.class.getResourceAsStream("/WorldEditBlocks.json")) {
            BlockRegistry.register(this, new JSONArray(new JSONTokener(inputStream)));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return "sWorldEdit";
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
