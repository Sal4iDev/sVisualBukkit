package ru.sal4i.sfileutils;

import com.gmail.visualbukkit.blocks.ClassInfo;
import com.gmail.visualbukkit.blocks.Statement;
import com.gmail.visualbukkit.blocks.parameters.ExpressionParameter;

import java.io.File;

public class StatFileCopy extends Statement {
    public StatFileCopy() {
        super("stat-sfile-copy", "Copy", "File", "Copy a file to a target file.\n\nBy Sal4iDev");
    }

    @Override
    public Block createBlock() {
        return new Block(this,
                new ExpressionParameter("From", ClassInfo.of(File.class)),
                new ExpressionParameter("To", ClassInfo.of(File.class))
        ) {
            @Override
            public String toJava() {
                return "try {" +
                        "java.nio.file.Files.copy(" + arg(0) + ".toPath(), " + arg(1) + ".toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);" +
                        "}catch (java.io.IOException e) {e.printStackTrace();}";
            }
        };

    }
}
