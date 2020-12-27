package eu.pyralia.pyrapi.bungeecord.commands.admin;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class AnnonceCommand extends Command {
    public AnnonceCommand(String name) {
        super(name);
     }


    public void execute(CommandSender commandSender, String[] args) {
        if (commandSender.hasPermission("bungeecord.command.alert")){
            if (args.length == 0) {
                commandSender.sendMessage((BaseComponent)new TextComponent("§6Pyralia §8»" + ChatColor.RED + "Erreur, veuillez préciser un texte !"));
            }
            if (args.length >= 1) {
                StringBuilder bc = new StringBuilder(); byte b; int i; String[] arrayOfString;
                for (i = (arrayOfString = args).length, b = 0; b < i; ) {
                    String part = arrayOfString[b];
                    bc.append(String.valueOf(part) + " §c§o");
                 b++;
             }

                ProxiedPlayer player = (ProxiedPlayer) commandSender;

                for (ProxiedPlayer players : ProxyServer.getInstance().getPlayers()) {
                     players.sendMessage((BaseComponent)new TextComponent(""));
                     players.sendMessage((BaseComponent)new TextComponent("  §6Pyralia §8» §e" + bc.toString()));
                     players.sendMessage((BaseComponent)new TextComponent(""));
                }
            }
        } else {
            commandSender.sendMessage(ChatColor.RED + "Vous n'avez pas la permission !");
        }
    }
}
