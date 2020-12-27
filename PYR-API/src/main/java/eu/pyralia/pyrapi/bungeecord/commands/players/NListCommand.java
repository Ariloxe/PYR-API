package eu.pyralia.pyrapi.bungeecord.commands.players;

import eu.pyralia.pyrapi.PyraliaAPI;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class NListCommand extends Command {
    public NListCommand(String name) {
        super(name);
    }


    public void execute(CommandSender commandSender, String[] strings) {
        if (commandSender instanceof ProxiedPlayer) {
            commandSender.sendMessage((BaseComponent)new TextComponent(""));
            commandSender.sendMessage((BaseComponent)new TextComponent(PyraliaAPI.PREFIX + ChatColor.GRAY + "Joueurs actuellement connectés sur l'infrastructure: §e" + ProxyServer.getInstance().getOnlineCount() + "§8/§6300"));
            commandSender.sendMessage((BaseComponent)new TextComponent(""));
        }
    }
}