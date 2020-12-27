package eu.pyralia.pyrapi.bungeecord.commands.admin;


import eu.pyralia.pyrapi.PyraliaAPI;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class AdmCommand extends Command {
    public AdmCommand(String name) {
        super(name);
    }


    @SuppressWarnings("deprecation")
    public void execute(CommandSender commandSender, String[] strings) {
        if(commandSender instanceof ProxiedPlayer) {
            ProxiedPlayer proxiedPlayer = (ProxiedPlayer)commandSender;
            if (proxiedPlayer.hasPermission("admin.chat")) {
                if (strings.length > 0) {
                    String string = "";
                    for (int i = 0; i < strings.length; i++) {
                        string = String.valueOf(string) + " §e§o" + strings[i];
                    }

                    for (ProxiedPlayer players : ProxyServer.getInstance().getPlayers()) {
                        if (players.hasPermission("admin.chat")) {
                            players.sendMessage((BaseComponent)new TextComponent("§4AdmChat §8➧ §7(§c" + proxiedPlayer.getServer().getInfo().getName() + "§7) '§6" + proxiedPlayer.getName() + "§7' §8» §e§o" + string));
                        }
                    }
                } else {
                    proxiedPlayer.sendMessage(ChatColor.RED + "Erreur: précisez un message");

                }
            } else {
                proxiedPlayer.sendMessage(PyraliaAPI.NOPERM);
            }
        }
    }
}

