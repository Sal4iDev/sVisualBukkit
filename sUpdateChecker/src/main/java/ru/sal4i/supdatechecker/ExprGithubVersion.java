package ru.sal4i.supdatechecker;

import com.gmail.visualbukkit.blocks.ClassInfo;
import com.gmail.visualbukkit.blocks.Expression;
import com.gmail.visualbukkit.blocks.parameters.ExpressionParameter;
import com.gmail.visualbukkit.project.BuildContext;

public class ExprGithubVersion extends Expression {

    private static final String METHOD = """
            public static String getGithubVersion(String owner, String repository) {
                    try (java.io.InputStream inputStream = new java.net.URL(
                            "https://api.github.com/repos/" + owner + "/" + repository + "/releases/latest").openStream()) {
                        org.json.JSONObject response = new org.json.JSONObject(new org.json.JSONTokener(inputStream));
                        return response.getString("tag_name");
                    } catch (Exception exception) {
                        exception.printStackTrace();
                        return PluginMain.getInstance().getDescription().getVersion();
                    }
                }
            """;

    public ExprGithubVersion() {
        super("expr-github-version", "Github Version", "SAL4I", "Checks if there is a newer " +
                "version of the plugin than the current one\nand returns the version found on the website." +
                "\nLink format: \"https://api.github.com/repos/OWNER/REPOSITORY/releases/latest\"");
    }

    @Override
    public ClassInfo getReturnType() {
        return ClassInfo.STRING;
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
                return String.format("PluginMain.getGithubVersion(%s, %s)",
                        arg(0), arg(1));
            }
        };
    }
}
