package eu.pyralia.pyrapi.bungeecord.commands;

import eu.pyralia.pyrapi.BungeeCordAPI;

import eu.pyralia.pyrapi.bungeecord.commands.admin.AdmCommand;
import eu.pyralia.pyrapi.bungeecord.commands.admin.AnnonceCommand;
import eu.pyralia.pyrapi.bungeecord.commands.admin.DebugCommand;
import eu.pyralia.pyrapi.bungeecord.commands.admin.MaintenanceCommand;
import eu.pyralia.pyrapi.bungeecord.commands.admin.RebootCommand;
import eu.pyralia.pyrapi.bungeecord.commands.mod.GTPCommand;
import eu.pyralia.pyrapi.bungeecord.commands.mod.ModCommand;
import eu.pyralia.pyrapi.bungeecord.commands.mod.UHCCommand;
import eu.pyralia.pyrapi.bungeecord.commands.players.HubCommand;
import eu.pyralia.pyrapi.bungeecord.commands.players.MsgCommand;
import eu.pyralia.pyrapi.bungeecord.commands.players.NListCommand;
import eu.pyralia.pyrapi.bungeecord.commands.players.ReplyCommand;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

public class CommandManager extends Plugin{

    public static void register(BungeeCordAPI plugin){
        PluginManager pluginManager = plugin.getProxy().getPluginManager();

        pluginManager.registerCommand(plugin, new ModCommand("mod"));
        pluginManager.registerCommand(plugin, new AdmCommand("adm"));
        pluginManager.registerCommand(plugin, new MaintenanceCommand());
        pluginManager.registerCommand(plugin, new RebootCommand("reboot"));
        pluginManager.registerCommand(plugin, new HubCommand("hub"));
        pluginManager.registerCommand(plugin, new MsgCommand("msg"));
        pluginManager.registerCommand(plugin, new AnnonceCommand("alert"));
        pluginManager.registerCommand(plugin, new DebugCommand());
        pluginManager.registerCommand(plugin, new ReplyCommand("r"));
        pluginManager.registerCommand(plugin, new NListCommand("nlist"));
        pluginManager.registerCommand(plugin, new GTPCommand("gtp"));
        pluginManager.registerCommand(plugin, new UHCCommand("uhc"));

    }
 
}
