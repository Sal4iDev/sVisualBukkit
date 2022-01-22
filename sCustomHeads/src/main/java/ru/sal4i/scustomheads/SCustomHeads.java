package ru.sal4i.scustomheads;

import com.gmail.visualbukkit.blocks.BlockRegistry;
import com.gmail.visualbukkit.extensions.VisualBukkitExtension;

@SuppressWarnings("unused")
public class SCustomHeads extends VisualBukkitExtension {

    public SCustomHeads() {
        BlockRegistry.register(this, "ru.sal4i.scustomheads");
    }

    @Override
    public String getName() {
        return "sCustomHeads";
    }

    @Override
    public String getVersion() {
        return "1.3";
    }

    @Override
    public String getAuthor() {
        return "Sal4iDev";
    }

    @Override
    public String getDescription() {
        return "Adds the ability to create custom heads";
    }
}
