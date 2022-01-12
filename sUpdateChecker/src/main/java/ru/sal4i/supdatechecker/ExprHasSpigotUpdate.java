package ru.sal4i.supdatechecker;

import com.gmail.visualbukkit.blocks.ClassInfo;
import com.gmail.visualbukkit.blocks.Expression;
import com.gmail.visualbukkit.blocks.parameters.ExpressionParameter;
import com.gmail.visualbukkit.project.BuildContext;

public class ExprHasSpigotUpdate extends Expression {
    private static final String METHOD = """
            public static boolean hasSpigotUpdate(String resourceId) {
                    boolean hasUpdate = false;
                    try (java.io.InputStream inputStream =
                                 new java.net.URL("https://api.spigotmc.org/legacy/update.php?resource=" + resourceId).openStream();
                         java.util.Scanner scanner = new java.util.Scanner(inputStream)) {
                        if (scanner.hasNext())
                            hasUpdate = !PluginMain.getInstance().getDescription().getVersion().equalsIgnoreCase(scanner.next());
                    } catch (java.io.IOException ioException) {
                        ioException.printStackTrace();
                        hasUpdate = false;
                    }
                    return hasUpdate;
                }
                        """;


    public ExprHasSpigotUpdate() {
        super("expr-has-spigot-update", "Has Spigot Update", "SAL4i", "Checks if there is a newer " +
                "version of the plugin than the current one" +
                "\nLink format: \"https://api.spigotmc.org/legacy/update.php?resource=YOUR_RESOURCE_ID\"");
    }

    @Override
    public ClassInfo getReturnType() {
        return ClassInfo.BOOLEAN;
    }

    @Override
    public Block createBlock() {
        return new Block(this,
                new ExpressionParameter("Resourde Id", ClassInfo.STRING)
        ) {
            @Override
            public void prepareBuild(BuildContext buildContext) {
                super.prepareBuild(buildContext);

                buildContext.addUtilMethod(METHOD);
            }

            @Override
            public String toJava() {
//                return "PluginMain.hasSpigotUpdate(" + arg(0) + ", " + arg(1) + ")";
                return String.format("PluginMain.hasSpigotUpdate(%s)",
                        arg(0));
            }
        };
    }
}
