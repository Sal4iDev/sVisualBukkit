package ru.sal4i.stabcompletion;

import com.gmail.visualbukkit.blocks.BlockRegistry;
import com.gmail.visualbukkit.extensions.VisualBukkitExtension;
import com.gmail.visualbukkit.project.Project;

public class STabComplete extends VisualBukkitExtension {
    public STabComplete() {
        BlockRegistry.register(this, "ru.sal4i.stabcomplete");
    }

    @Override
    public void activate(Project project) {
        super.activate(project);
        System.out.println(" ");
        System.out.println("Order plugins and extensions from Sal4iDev");
        System.out.println("Discord: Sal4iDev#4767");
        System.out.println("Have a nice day <3!");
        System.out.println(" ");
    }

    @Override
    public String getName() {
        return "sTabCompletion";
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
        return "Adds the ability to make a simple tab completion for your command";
    }
}