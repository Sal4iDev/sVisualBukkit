package ru.sal4i.sutils;

import com.gmail.visualbukkit.blocks.BlockRegistry;
import com.gmail.visualbukkit.extensions.VisualBukkitExtension;

public class SUtils extends VisualBukkitExtension {

    public SUtils() {
        BlockRegistry.register(this, "ru.sal4i.sutils.blocks.itemstack");
    }

    @Override
    public String getName() {
        return "sUtils";
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
