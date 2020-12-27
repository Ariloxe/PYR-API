package eu.pyralia.pyrapi.bungeecord.commands.players;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.util.ArrayList;
import java.util.Arrays;

public class ReplyCommand extends Command {
    public ReplyCommand(String name) {
        super(name);
    }


    public void execute(CommandSender commandSender, String[] args) {
        ArrayList<String> al = new ArrayList<String>(Arrays.asList(args));
        String playerToSend = null;
        if (commandSender instanceof ProxiedPlayer) {
            if (args.length >= 1) {
                playerToSend = MsgCommand.hash.get(commandSender.getName());
                if (playerToSend != null) {
                    al.add(0, playerToSend);
                    String[] argumentsWithSender = al.toArray(new String[al.size()]);
                    MsgCommand.messagePlayer(commandSender, argumentsWithSender);
                } else
                    commandSender.sendMessage((BaseComponent) new TextComponent("§8» §7Vous n'avez personne à qui répondre"));
            }
        }
    }
}
