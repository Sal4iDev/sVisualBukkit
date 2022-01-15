package ru.sal4i.supdatechecker;

import com.gmail.visualbukkit.blocks.ClassInfo;
import com.gmail.visualbukkit.blocks.Expression;
import com.gmail.visualbukkit.blocks.parameters.ExpressionParameter;
import com.gmail.visualbukkit.project.BuildContext;

public class ExprSpigotVersion extends Expression {
    private static final String METHOD = """
            public static String getSpigotVersion(String resourceId) {
                    String newVersion = PluginMain.getInstance().getDescription().getVersion();
                    try (java.io.InputStream inputStream =
                                 new java.net.URL("https://api.spigotmc.org/legacy/update.php?resource=" + resourceId).openStream();
                         java.util.Scanner scanner = new java.util.Scanner(inputStream)) {
                        if (scanner.hasNext()) newVersion = String.valueOf(scanner.next());
                    } catch (java.io.IOException ioException) {
                        ioException.printStackTrace();
                    }
                    return newVersion;
                }
                        """;

    public ExprSpigotVersion() {
        super("expr-spigot-version", "Spigot Version", "SAL4I", "Checks if there is a newer " +
                "version of the plugin than the current one\nand returns the version found on the website." +
                "\nLink format: \"https://api.spigotmc.org/legacy/update.php?resource=YOUR_RESOURCE_ID\"");
    }

    @Override
    public ClassInfo getReturnType() {
        return ClassInfo.STRING;
    }

    @Override
    public Block createBlock() {
        return new Block(this,
                new ExpressionParameter("Resource Id", ClassInfo.STRING)
        ) {
            @Override
            public void prepareBuild(BuildContext buildContext) {
                super.prepareBuild(buildContext);

                buildContext.addUtilMethod(METHOD);
            }

            @Override
            public String toJava() {
                return String.format("PluginMain.getSpigotVersion(%s)",
                        arg(0));
            }
        };
    }
}
