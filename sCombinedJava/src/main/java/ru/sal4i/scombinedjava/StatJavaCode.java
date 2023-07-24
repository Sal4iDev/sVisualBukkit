package ru.sal4i.scombinedjava;

import com.gmail.visualbukkit.blocks.ClassInfo;
import com.gmail.visualbukkit.blocks.Statement;
import com.gmail.visualbukkit.blocks.parameters.ExpressionParameter;

public class StatJavaCode extends Statement {
    public StatJavaCode() {
        super("stat-sjava-code", "Java Code", "SAL4I", "Raw Java code");
    }

    @Override
    public Block createBlock() {
        return new Block(this, new ExpressionParameter("Java", ClassInfo.OBJECT)) {
            @Override
            public String toJava() {
                return arg(0);
            }
        };
    }
}
