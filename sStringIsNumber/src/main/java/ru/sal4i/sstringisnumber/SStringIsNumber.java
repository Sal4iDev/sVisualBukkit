package ru.sal4i.sstringisnumber;

import com.gmail.visualbukkit.blocks.BlockRegistry;
import com.gmail.visualbukkit.extensions.VisualBukkitExtension;

public class SStringIsNumber extends VisualBukkitExtension {
    public SStringIsNumber() {
        BlockRegistry.register(this, "ru.sal4i.sstringisnumber");
    }

    @Override
    public String getName() {
        return "sStringIsNumber";
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
