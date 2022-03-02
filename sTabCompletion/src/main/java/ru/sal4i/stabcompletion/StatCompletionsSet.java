package ru.sal4i.stabcompletion;

import com.gmail.visualbukkit.blocks.ClassInfo;
import com.gmail.visualbukkit.blocks.Statement;
import com.gmail.visualbukkit.blocks.parameters.ExpressionParameter;
import com.gmail.visualbukkit.project.BuildContext;

@SuppressWarnings("unused")
public class StatCompletionsSet extends Statement {
    private static final String FORMAT_METHOD = """
            public static java.util.List<String> formatList(java.util.List<String> list, String[] args) {
                java.util.List<String> completions = new java.util.ArrayList<>();

                org.bukkit.util.StringUtil.copyPartialMatches(args[args.length-1], list, completions);
                java.util.Collections.sort(completions);
                return completions;
            }
            """;

    public StatCompletionsSet() {
        super("stat-scompletions-set", "Set Completions", "TabCompletion", "Sets tab completion for your command");
    }

    @Override
    public Block createBlock() {
        return new Block(this,
                new ExpressionParameter("Completions", ClassInfo.LIST),
                new ExpressionParameter("Format", ClassInfo.BOOLEAN)
        ) {
            @Override
            public void update() {
                super.update();
                checkForPluginComponent(CompTabComplete.class);
            }

            @Override
            public void prepareBuild(BuildContext buildContext) {
                super.prepareBuild(buildContext);
                buildContext.addUtilMethod(FORMAT_METHOD);
            }

            @Override
            public String toJava() {
                return "if (true) return ((" + arg(1) + " ) ? " +
                        "PluginMain.formatList(" + arg(0) + ", commandArgs) : " + arg(0) + ");";
            }
        };
    }
}
