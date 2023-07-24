package ru.sal4i.scombinedjava;

import com.gmail.visualbukkit.blocks.BlockRegistry;
import com.gmail.visualbukkit.extensions.VisualBukkitExtension;

public class SCombinedJava extends VisualBukkitExtension {
    public SCombinedJava() {
        BlockRegistry.register(this, "ru.sal4i.scombinedjava");
    }

    @Override
    public String getName() {
        return "sCombinedJava";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public String getAuthor() {
        return "Sal4iDev";
    }

    @Override
    public String getDescription() {
        return null;
    }
}
