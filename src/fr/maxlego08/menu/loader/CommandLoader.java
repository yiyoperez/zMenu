package fr.maxlego08.menu.loader;

import fr.maxlego08.menu.ZCommand;
import fr.maxlego08.menu.api.command.Command;
import fr.maxlego08.menu.exceptions.InventoryException;
import fr.maxlego08.menu.zcore.utils.loader.Loader;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CommandLoader implements Loader<Command> {

    private final Plugin plugin;

    /**
     * @param plugin the plugin
     */
    public CommandLoader(Plugin plugin) {
        super();
        this.plugin = plugin;
    }

    @Override
    public Command load(YamlConfiguration configuration, String path, Object... args) throws InventoryException {

        String command = configuration.getString(path + "command");
        String permission = configuration.getString(path + "permission");
        String inventory = configuration.getString(path + "inventory");
        List<String> aliases = configuration.getStringList(path + "aliases");
        List<String> arguments = configuration.getStringList(path + "arguments");

        File file = (File) args[0];

        return new ZCommand(this.plugin, command, aliases, permission, inventory, arguments, path, file);
    }

    @Override
    public void save(Command object, YamlConfiguration configuration, String path, File file, Object... objects) {

        configuration.set(path + "command", object.getCommand());
        configuration.set(path + "permission", object.getPermission());
        configuration.set(path + "inventory", object.getInventory());
        configuration.set(path + "aliases", object.getAliases());
        configuration.set(path + "arguments", object.getArguments());

        try {
            configuration.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
