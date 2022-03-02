package ru.sal4i.sutils;

import java.util.List;

public class SUtils {
    public static void logPromotion(Project project) {
        List<VisualBukkitExtension> collect = project.getExtensions().stream()
                .filter(e -> e.getAuthor().equals("Sal4iDev"))
                .toList();

        if (collect.size() < 2) {
            List.of(" ", "Order plugins and extensions from Sal4iDev",
                    "Discord: Sal4iDev#4767", "Have a nice day <3!", " ").forEach(VisualBukkitApp.getLogger()::print);
        }
    }
}
