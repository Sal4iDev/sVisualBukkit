package ru.sal4i.stabcompletion;

import com.gmail.visualbukkit.blocks.PluginComponent;
import com.gmail.visualbukkit.blocks.parameters.InputParameter;
import com.gmail.visualbukkit.project.BuildContext;
import javafx.beans.binding.Bindings;
import org.apache.commons.text.StringEscapeUtils;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.jboss.forge.roaster.model.source.MethodSource;

import java.util.regex.Pattern;

public class CompTabComplete extends PluginComponent {
    private static final Pattern WHITE_SPACE_PATTERN = Pattern.compile("\\S*");

    private final static String METHOD = """
            @Override
            public java.util.List<String> onTabComplete(CommandSender commandSender, Command command, String alias, String[] commandArgs) {
                return null;
            }
            """;

    public CompTabComplete() {
        super("comp-stabcomplete", "Tab Completion", "Bukkit",
                "Sets tab completion for your command");
    }

    @Override
    public Block createBlock() {
        InputParameter nameParameter = new InputParameter("Name");
        nameParameter.getControl().textProperty().addListener(((o, oldValue, newValue) -> {
            if (!WHITE_SPACE_PATTERN.matcher(newValue).matches()) {
                nameParameter.getControl().setText(oldValue);
            }
        }));

        return new Block(this, nameParameter) {
            @Override
            public void prepareBuild(BuildContext buildContext) {
                super.prepareBuild(buildContext);

                MethodSource<JavaClassSource> tabComplete =
                        buildContext.getMainClass().getMethod("onTabComplete", "CommandSender", "Command", "String", "String[]");
                if (tabComplete == null) {
                    buildContext.getMainClass().addMethod(METHOD);
                }

                tabComplete = buildContext.getMainClass().getMethod("onTabComplete", "CommandSender", "Command", "String", "String[]");
                try {
                    tabComplete.setBody("if (command.getName().equalsIgnoreCase(\"" + StringEscapeUtils.escapeJava(arg(0)) + "\")){ " +
                            buildContext.getLocalVariableDeclarations() +
                            "try {" +
                            getChildJava() +
                            "} catch (Exception exception) { exception.printStackTrace(); }" +
                            "return null; }" +
                            tabComplete.getBody()
                    );
                } catch (Exception exception) {
                    System.out.println("An error occurred while creating tab complete!");
                    System.out.println("Please try build plugin again!");
                }
            }
        };
    }

    public class Block extends PluginComponent.Block {
        private final InputParameter name;

        public Block(CompTabComplete compTabComplete, InputParameter name) {
            super(CompTabComplete.this, name);
            this.name = name;

            getTab().textProperty().bind(Bindings
                    .when(name.getControl().textProperty().isNotEmpty())
                    .then(Bindings.concat("TabCompletion /", name.getControl().textProperty()))
                    .otherwise("Tab Completion"));
        }

        public String getName() {
            return name.toJava();
        }
    }
}