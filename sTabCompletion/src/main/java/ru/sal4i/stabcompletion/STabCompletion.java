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

//        Platform.runLater(this::checkUpdates);
    }

    @Override
    public String getName() {
        return "sTabCompletion";
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
        return "Adds the ability to make a simple tab completion for your command";
    }
//
//    private void checkUpdates() {
//        try (InputStream inputStream = new URL("https://api.github.com/repos/Sal4iDev/sVisualBukkit/releases/latest").openStream()) {
//            JSONObject response = new JSONObject(new JSONTokener(inputStream));
//            String latestVersion = response.getString("tag_name");
//            if (getVersion().equals(latestVersion)) return;
//            ButtonType viewButton = new ButtonType("View Update");
//            Alert alert = new Alert(Alert.AlertType.INFORMATION, String.format("An update is " +
//                    "available!\nUsing version: %s\nLatest version: %s", getVersion(), latestVersion),
//                    viewButton, new ButtonType("Ignore Update"));
//            VisualBukkitApp.getSettingsManager().style(alert.getDialogPane());
//            alert.setTitle(getName() + " - Update Available!");
//            alert.setGraphic(null);
//            alert.setHeaderText(null);
//            alert.showAndWait().ifPresent(buttonType -> {
//                if (buttonType == viewButton) {
//                    VisualBukkitApp.openURI(URI.create("https://github.com/Sal4iDev/sVisualBukkit/releases"));
//                }
//            });
//        } catch (Exception ignored) {
//        }
//    }
}