{package}

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.util.StringUtil;

public class Command{$} {
    public Command{$}(String name, String description, String usageMessage, java.util.List<String> aliases, String permission, String permissionMessage) {
        super(name, description, usageMessage, aliases);

        setPermission(permission);
        permissionMessage(permissionMessage);

        register();
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args){
            {command_code}
            return true;
        }

    @Override
    public @NotNull List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) {
        return null;
    }

    protected void register() {
        Bukkit.getCommandMap().register("{plugin_name}", this);
    }
}