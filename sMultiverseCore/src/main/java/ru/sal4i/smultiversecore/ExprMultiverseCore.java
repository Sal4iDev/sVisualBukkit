package ru.sal4i.smultiversecore;

import com.gmail.visualbukkit.blocks.ClassInfo;
import com.gmail.visualbukkit.blocks.Expression;

public class ExprMultiverseCore extends Expression {
    public ExprMultiverseCore() {
        super("expr-smultiverse-core", "MultiverseCore Plugin", "MultiverseCore", "Returns MultiverseCore plugin instance. Put it in <MultiverseCore>");
    }

    @Override
    public ClassInfo getReturnType() {
        return ClassInfo.of("com.onarandombox.MultiverseCore.MultiverseCore");
    }

    @Override
    public Block createBlock() {
        return new Block(this) {
            @Override
            public String toJava() {
                return "((com.onarandombox.MultiverseCore.MultiverseCore) Bukkit.getServer().getPluginManager().getPlugin(\"Multiverse-Core\"))";
            }
        };
    }
}
