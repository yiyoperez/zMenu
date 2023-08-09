package fr.maxlego08.menu.command.commands;

import fr.maxlego08.menu.MenuPlugin;
import fr.maxlego08.menu.command.VCommand;
import fr.maxlego08.menu.command.commands.players.CommandMenuPlayers;
import fr.maxlego08.menu.command.commands.reload.CommandMenuReload;
import fr.maxlego08.menu.zcore.enums.Permission;
import fr.maxlego08.menu.zcore.utils.commands.CommandType;
import fr.maxlego08.menu.zcore.utils.players.ActionBar;
import org.bukkit.Bukkit;

public class CommandMenu extends VCommand {

    public CommandMenu(MenuPlugin plugin) {
        super(plugin);
        this.setPermission(Permission.ZMENU_USE);
        this.addSubCommand(new CommandMenuOpen(plugin));
        this.addSubCommand(new CommandMenuReload(plugin));
        this.addSubCommand(new CommandMenuVersion(plugin));
        this.addSubCommand(new CommandMenuPlayers(plugin));
        this.addSubCommand(new CommandMenuOpenMainMenu(plugin));

		/* Disable website connexion for beta
		this.addSubCommand(new CommandMenuDownload(plugin));
		this.addSubCommand(new CommandMenuLogin(plugin));
		this.addSubCommand(new CommandMenuDisconnect(plugin));
		 */

        if (Bukkit.getPluginManager().getPlugin("zMenuConvert") == null) {
            this.addSubCommand(new CommandMenuConvert(plugin));
        }
    }

    @Override
    protected CommandType perform(MenuPlugin plugin) {

        ActionBar.sendActionBar(player, "§cTest §ede §bmessage");

        sendSyntax();
        return CommandType.SUCCESS;
    }

}
