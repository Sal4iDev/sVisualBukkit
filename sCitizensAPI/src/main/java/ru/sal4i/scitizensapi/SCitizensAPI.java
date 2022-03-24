package ru.sal4i.scitizensapi;

import com.gmail.visualbukkit.blocks.BlockRegistry;
import com.gmail.visualbukkit.extensions.VisualBukkitExtension;
import com.gmail.visualbukkit.project.BuildContext;
import com.gmail.visualbukkit.project.PluginModule;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.jboss.forge.roaster.model.source.MethodSource;
import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;

public class SCitizensAPI extends VisualBukkitExtension {
    private static final PluginModule MODULE = new PluginModule() {
        @Override
        public void prepareBuild(BuildContext buildContext) {
            buildContext.addMavenRepository(
                    "<id>everything</id>\n" +
                            "<url>https://repo.citizensnpcs.co/</url>");
            buildContext.addMavenDependency(
                    "<groupId>net.citizensnpcs</groupId>\n" +
                            "<artifactId>citizensapi</artifactId>" +
                            "<version>2.0.29-SNAPSHOT</version>\n" +
                            "<type>jar</type>\n" +
                            "<scope>compile</scope>");
        }
    };

    public SCitizensAPI() throws IOException {
        PluginModule.register("sCitizensAPI", MODULE);
        try (InputStream inputStream = SCitizensAPI.class.getResourceAsStream("/Blocks.json")) {
            BlockRegistry.register(this, new JSONArray(new JSONTokener(inputStream)));
        }
        BlockRegistry.register(this, "ru.sal4i.scitizensapi");
    }

    @Override
    public String getName() {
        return "sCitizensAPI";
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
        return "https://github.com/CitizensDev/CitizensAPI";
    }
}
