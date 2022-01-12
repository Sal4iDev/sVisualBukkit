package ru.sal4i.stabcompletion;

import com.gmail.visualbukkit.blocks.ClassInfo;
import com.gmail.visualbukkit.blocks.Statement;
import com.gmail.visualbukkit.blocks.parameters.ExpressionParameter;

public class StatCompletionsSet extends Statement {
//    private final static String FORMAT_METHOD = """
//            public static java.util.List<String> formatList(java.util.List<String> list, String[] args) {
//                java.util.List<String> completions = new java.util.ArrayList<>();
//
//                org.bukkit.util.StringUtil.copyPartialMatches(args[0], list, completions);
//                java.util.Collections.sort(completions);
//                return completions;
//            }
//            """;

    public StatCompletionsSet() {
        super("stat-scompletions-set", "Set Completions", "TabCompletion", "Sets tab completion for your command");
    }

    @Override
    public Block createBlock() {
        return new Block(this, new ExpressionParameter("Completions", ClassInfo.LIST)) {
            @Override
            public void update() {
                super.update();
                checkForPluginComponent(CompTabComplete.class);
            }

//            @Override
//            public void prepareBuild(BuildContext buildContext) {
//                super.prepareBuild(buildContext);
//                buildContext.addUtilMethod(FORMAT_METHOD);
//            }

            @Override
            public String toJava() {
//                return "if (true) return PluginMain.formatList(" + arg(0) + ", commandArgs);";
                return "if (true) return " + arg(0) + ";";
            }
        };
    }
}
