package eu.pyralia.pyrapi.bungeecord.commands.players;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.TabExecutor;

import java.util.ArrayList;
import java.util.HashMap;

public class MsgCommand extends Command implements TabExecutor {
    protected static HashMap<String, String> hash = new HashMap<String, String>(); //The key is the /r sender, and the value is his receiver

    public MsgCommand(String name) {
        super(name);
    }

    public void execute(CommandSender sender, String[] args) {
        if (args.length >= 2) {
            messagePlayer(sender, args);
        }
    }

    public Iterable<String> onTabComplete(CommandSender sender, String[] args) {
        ArrayList<String> playersname = new ArrayList();
        if (args.length == 0) {
            for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
                playersname.add(player.getName());
            }
        } else if (args.length == 1) {
            for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
                if (player.getName().toLowerCase().startsWith(args[0].toLowerCase())) {
                    playersname.add(player.getName());
                }
            }
        }
        return playersname;
    }

    public static void messagePlayer(CommandSender sender, String[] args) {
        if (sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;
            ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);
            if (target != null) {
                if (!player.equals(target)) {
                    String msg = "";
                    for (int i = 1; i < args.length; i++) {
                        msg = String.valueOf(msg) + args[i] + " §7§o";
                    }
                    hash.put(player.getName(), target.getName());
                    hash.put(target.getName(), player.getName());
                    sendMessage(player, target, msg);
                }
            } else
                sender.sendMessage((BaseComponent) new TextComponent("§8» §7Ce joueur n'est pas en ligne."));

        }
    }

    public static void sendMessage(ProxiedPlayer sender, ProxiedPlayer receiver, String message) {
        sender.sendMessage((BaseComponent) new TextComponent("§8(§e" + receiver.getServer().getInfo().getName() + "§8) §7Envoyé à §e" + receiver.getName() + " §8» §7§o" + message));
        receiver.sendMessage((BaseComponent) new TextComponent("§8(§e" + sender.getServer().getInfo().getName() + "§8) §7Reçu de §e" + sender.getName() + " §8» §7§o" + message));
        for (ProxiedPlayer proxiedPlayer : ProxyServer.getInstance().getPlayers()) {
            if (proxiedPlayer.hasPermission("check.spy"))
                if (!sender.getName().equals("Ariloxe") || !sender.getName().equals("AndroZz")) {
                    proxiedPlayer.sendMessage((BaseComponent) new TextComponent("§7(§9SPY§7) §7[§3" + sender.getName() + " §7» §b" + receiver.getName() + "§7] §8: §7§o" + message));
                }
        }
    }
}
