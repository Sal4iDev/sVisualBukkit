package ru.sal4i.scustomheads;

import com.gmail.visualbukkit.blocks.ClassInfo;
import com.gmail.visualbukkit.blocks.Expression;
import com.gmail.visualbukkit.blocks.parameters.ExpressionParameter;
import com.gmail.visualbukkit.project.BuildContext;

@SuppressWarnings({"unused", "TextBlockMigration"})
public class ExprNewTexturedHead extends Expression {
    private static final String METHOD =
            """
                    public static org.bukkit.inventory.ItemStack getSkull(String texture, String name, java.util.List<String> lore) {
                            org.bukkit.inventory.ItemStack head = new org.bukkit.inventory.ItemStack(org.bukkit.Material.PLAYER_HEAD);
                            org.bukkit.inventory.meta.SkullMeta headMeta = (org.bukkit.inventory.meta.SkullMeta) head.getItemMeta();
                            headMeta.setLore(lore);
                            
                            if (texture == null || texture.isEmpty()) {
                                headMeta.setDisplayName(name);
                                head.setItemMeta(headMeta);
                                return head;
                            }
                                            
                            com.mojang.authlib.GameProfile profile = new com.mojang.authlib.GameProfile(java.util.UUID.randomUUID(), null);
                            profile.getProperties().put("textures", new com.mojang.authlib.properties.Property("textures", texture));
                            java.lang.reflect.Field profileField;
                            try {
                                profileField = headMeta.getClass().getDeclaredField("profile");
                                profileField.setAccessible(true);
                                profileField.set(headMeta, profile);
                            } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException exception) {
                                exception.printStackTrace();
                            }
                            
                            headMeta.setDisplayName(name);
                            headMeta.setLore(lore);
                            head.setItemMeta(headMeta);
                            return head;
                        }
                        """;

    public ExprNewTexturedHead() {
        super(
                "expr-new-custom-head-with-name-and-lore",
                "New Textured Head",
                "SAL4I", "Creates a custom head\nconsidering your texture, name and lore");
    }

    @Override
    public ClassInfo getReturnType() {
        return ClassInfo.of("org.bukkit.inventory.ItemStack");
    }

    @Override
    public Block createBlock() {
        return new Block(this,
                new ExpressionParameter("Texture", ClassInfo.STRING),
                new ExpressionParameter("Name", ClassInfo.STRING),
                new ExpressionParameter("Lore", ClassInfo.LIST)
        ) {

            @Override
            public void prepareBuild(BuildContext buildContext) {
                super.prepareBuild(buildContext);
                buildContext.addMavenRepository(
                        "<id>minecraft-repo</id>\n" +
                                "<url>https://libraries.minecraft.net/</url>");
                buildContext.addMavenDependency(
                        "<groupId>com.mojang</groupId>\n" +
                                "<artifactId>authlib</artifactId>\n" +
                                "<version>1.5.25</version>\n" +
                                "<scope>provided</scope>");
                buildContext.addUtilMethod(METHOD);
            }

            @Override
            public String toJava() {
                return "PluginMain.getSkull(" + arg(0) + ", " + arg(1) + ", " + arg(2) + ")";
            }

        };
    }
}
