package ru.sal4i.supdatechecker;

import com.gmail.visualbukkit.blocks.BlockRegistry;
import com.gmail.visualbukkit.extensions.VisualBukkitExtension;

public class SUpdateChecker extends VisualBukkitExtension {

    public SUpdateChecker() {
        BlockRegistry.register(this, "ru.sal4i.supdatechecker");
    }

    @Override
    public String getName() {
        return "sUpdateChecker";
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
        return "Adds the ability to check your plugin for new versions";
    }
}
