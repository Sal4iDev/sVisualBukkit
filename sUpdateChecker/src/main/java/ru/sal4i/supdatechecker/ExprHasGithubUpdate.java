package ru.sal4i.supdatechecker;

import com.gmail.visualbukkit.blocks.ClassInfo;
import com.gmail.visualbukkit.blocks.Expression;
import com.gmail.visualbukkit.blocks.parameters.ExpressionParameter;
import com.gmail.visualbukkit.project.BuildContext;

public class ExprHasGithubUpdate extends Expression {

    private static final String METHOD = """
            public static boolean hasGithubUpdate(String owner, String repository) {
                    try (java.io.InputStream inputStream = new java.net.URL(
                            "https://api.github.com/repos/" + owner + "/" + repository + "/releases/latest").openStream()) {
                        org.json.JSONObject response = new org.json.JSONObject(new org.json.JSONTokener(inputStream));
                        String currentVersion = PluginMain.getInstance().getDescription().getVersion();
                        String latestVersion = response.getString("tag_name");
                        return !currentVersion.equals(latestVersion);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                        return false;
                    }
                }
            """;

    public ExprHasGithubUpdate() {
        super("expr-has-github-update", "Has Github Update", "SAL4I", "Checks if there is a newer " +
                "version of the plugin than the current one" +
                "\nLink format: \"https://api.github.com/repos/Owner/Repository/releases/latest\"");
    }

    @Override
    public ClassInfo getReturnType() {
        return ClassInfo.BOOLEAN;
    }


    @Override
    public Block createBlock() {
        return new Block(this,
                new ExpressionParameter("Owner", ClassInfo.STRING),
                new ExpressionParameter("Repository", ClassInfo.STRING)
        ) {
            @Override
            public void prepareBuild(BuildContext buildContext) {
                super.prepareBuild(buildContext);

                buildContext.addMavenDependency(
                        "<groupId>org.json</groupId>\n" +
                                "<artifactId>json</artifactId>\n" +
                                "<version>20211205</version>");

                buildContext.addUtilMethod(METHOD);
            }

            @Override
            public String toJava() {
                return String.format("PluginMain.hasGithubUpdate(%s, %s)",
                        arg(0), arg(1));
            }
        };
    }
}
