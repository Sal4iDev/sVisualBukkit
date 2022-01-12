package ru.sal4i.stabcompletion;

import com.gmail.visualbukkit.blocks.ClassInfo;
import com.gmail.visualbukkit.blocks.Expression;

@SuppressWarnings("unused")
public class ExprCommandSender extends Expression {

    public ExprCommandSender() {
        super("expr-scommand-sender", "Command Sender", "TabCompletion", "The player/console who executed a command");
    }

    @Override
    public ClassInfo getReturnType() {
        return ClassInfo.of("org.bukkit.command.CommandSender");
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
                return "commandSender";
            }
        };
    }
}