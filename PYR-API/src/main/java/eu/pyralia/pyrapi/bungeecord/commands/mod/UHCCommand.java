package eu.pyralia.pyrapi.bungeecord.commands.mod;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class UHCCommand extends Command {
    public UHCCommand(String name) {
        super(name);
    }


    public void execute(CommandSender commandSender, String[] args) {
        if (commandSender.hasPermission("staff.uhcopen")){
            if (args.length == 0) {
                commandSender.sendMessage((BaseComponent)new TextComponent("§6Pyralia §8»" + ChatColor.RED + "Erreur, veuillez préciser un était (open)"));
            }
            if (args.length == 1) {
                ProxiedPlayer player = (ProxiedPlayer) commandSender;
                if(args[0].equals("open")){
                    for (ProxiedPlayer players : ProxyServer.getInstance().getPlayers()) {
                        players.sendMessage((BaseComponent)new TextComponent(""));
                        players.sendMessage((BaseComponent)new TextComponent("          §6Ouverture d'Host ! "));
                        players.sendMessage((BaseComponent)new TextComponent(" §8§l➠ §e" + player.getServer().getInfo().getName()));
                        players.sendMessage((BaseComponent)new TextComponent("§7Allez dans la boussole pour rejoindre cet host !"));
                        players.sendMessage((BaseComponent)new TextComponent(""));
                    }

                } else {
                    player.sendMessage((BaseComponent)new TextComponent("§6Pyralia §8»" + ChatColor.RED + "Erreur, veuillez préciser un était (open)"));
                }

            }
        } else {
            commandSender.sendMessage(ChatColor.RED + "Vous n'avez pas la permission !");
        }
    }
}
