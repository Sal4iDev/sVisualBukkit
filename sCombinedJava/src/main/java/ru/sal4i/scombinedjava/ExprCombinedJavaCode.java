package ru.sal4i.scombinedjava;

import com.gmail.visualbukkit.blocks.ClassInfo;
import com.gmail.visualbukkit.blocks.VarArgsExpression;
import com.gmail.visualbukkit.blocks.parameters.ExpressionParameter;

public class ExprCombinedJavaCode extends VarArgsExpression {
    public ExprCombinedJavaCode() {
        super("expr-scombined-java-code", "Combined Java Code", "SAL4I", "Combined raw Java code");
    }

    @Override
    public ClassInfo getReturnType() {
        return ClassInfo.OBJECT;
    }

    @Override
    public Block createBlock() {
        return new Block(this, new ExpressionParameter("Java", ClassInfo.OBJECT)) {
            @Override
            public String toJava() {
                StringBuilder java = new StringBuilder(arg(0));
                for (int i = 1; i < parameters.length; i++) java.append(arg(i));
                return java.toString();
            }

            @Override
            protected void increaseSize() {
                push(new ExpressionParameter("Java", ClassInfo.OBJECT));
            }

            @Override
            protected void decreaseSize() {
                pop();
            }
        };
    }
}
