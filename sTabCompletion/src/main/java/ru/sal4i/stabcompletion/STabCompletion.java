package ru.sal4i.stabcompletion;

import com.gmail.visualbukkit.blocks.BlockRegistry;
import com.gmail.visualbukkit.extensions.VisualBukkitExtension;
import com.gmail.visualbukkit.project.Project;

import java.util.List;

@SuppressWarnings("unused")
public class STabCompletion extends VisualBukkitExtension {
    public STabCompletion() {
        BlockRegistry.register(this, "ru.sal4i.stabcompletion");
    }

    @Override
    public void activate(Project project) {
        super.activate(project);

        List.of(" ", "Order plugins and extensions from Sal4iDev",
                "Discord: Sal4iDev#4767", "Have a nice day <3!", " ").forEach(System.out::println);
    }

    @Override
    public String getName() {
        return "sTabCompletion";
    }

    @Override
    public String getVersion() {
        return "1.2";
    }

    @Override
    public String getAuthor() {
        return "Sal4iDev";
    }

    @Override
    public String getDescription() {
        return "Adds the ability to make a simple tab completion for your command";
    }
}