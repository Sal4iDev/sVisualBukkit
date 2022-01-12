package ru.sal4i.stabcompletion;

import com.gmail.visualbukkit.blocks.ClassInfo;
import com.gmail.visualbukkit.blocks.Expression;

@SuppressWarnings("unused")
public class ExprCommandArguments extends Expression {

    public ExprCommandArguments() {
        super("expr-scommand-arguments", "Command Arguments", "TabCompletion", "The arguments of a command");
    }

    @Override
    public ClassInfo getReturnType() {
        return ClassInfo.LIST;
    }

    @Override
    public Block createBlock() {
        return new Block(this) {
            @Override
            public void update() {
                super.update();
                checkForPluginComponent(CompTabComplete.class);
            }

            @Override
            public String toJava() {
                return "PluginMain.createList(commandArgs)";
            }
        };
    }
}