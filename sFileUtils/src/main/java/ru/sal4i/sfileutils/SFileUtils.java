package ru.sal4i.sfileutils;

import com.gmail.visualbukkit.blocks.BlockRegistry;
import com.gmail.visualbukkit.extensions.VisualBukkitExtension;

public class SFileUtils extends VisualBukkitExtension {
    public SFileUtils() {
        BlockRegistry.register(this, "ru.sal4i.sfileutils");
    }

    @Override
    public String getName() {
        return "sFileUtils";
    }

    @Override
    public String getVersion() {
        return "2.0";
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
