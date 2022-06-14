package ru.sal4i.sstringisnumber;

import com.gmail.visualbukkit.blocks.ClassInfo;
import com.gmail.visualbukkit.blocks.Expression;
import com.gmail.visualbukkit.blocks.parameters.ExpressionParameter;

public class ExprStringIsNumber extends Expression {
    public ExprStringIsNumber() {
        super("expr-sstring-is-number", "Is Number", "String", "Checks if the string is a number");
    }

    @Override
    public ClassInfo getReturnType() {
        return ClassInfo.BOOLEAN;
    }

    @Override
    public Block createBlock() {
        return new Block(this, new ExpressionParameter("String", ClassInfo.STRING)) {
            @Override
            public String toJava() {
                return arg(0) + ".matches(\"-?\\\\d+(\\\\.\\\\d+)?\")";
            }
        };
    }
}
