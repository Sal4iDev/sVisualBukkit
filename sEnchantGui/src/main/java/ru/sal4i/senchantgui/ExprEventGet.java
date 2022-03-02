package ru.sal4i.senchantgui;

import com.gmail.visualbukkit.blocks.ClassInfo;
import com.gmail.visualbukkit.blocks.Expression;
import com.gmail.visualbukkit.blocks.parameters.ChoiceParameter;

public class ExprEventGet extends Expression {
    public ExprEventGet() {
        super("expr-sevent-get", "Get", "PlayerEnchantItemEvent", "Returns the object you selected\n\nPlayer - Get the player who enchant the item\nItem - Get the item player enchanted\nEnchantment - Get the enchantment that player enchanted into the item");
    }

    @Override
    public ClassInfo getReturnType() {
        return ClassInfo.OBJECT;
    }

    @Override
    public Block createBlock() {
        return new Block(this, new ChoiceParameter("Object", "Player", "Item", "Enchantment")) {
            @Override
            public String toJava() {
                return "event.get" + arg(0) + "()";
            }
        };
    }
}
