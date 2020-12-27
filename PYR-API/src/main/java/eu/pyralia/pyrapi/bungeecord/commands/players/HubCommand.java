package eu.pyralia.pyrapi.bungeecord.commands.players;


import eu.pyralia.pyrapi.PyraliaAPI;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class HubCommand extends Command {
    public HubCommand(String name) {
        super(name);
    }


    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer)sender;
            if (player.getServer().getInfo().getName().equals("lobby")) {
                player.sendMessage(TextComponent.fromLegacyText(PyraliaAPI.PREFIX + ChatColor.GRAY + "Vous " + ChatColor.RED + "êtes déjà " + ChatColor.GRAY + "connecté(e) dessus :o"));
            } else {
                player.sendMessage((BaseComponent)new TextComponent(PyraliaAPI.PREFIX + ChatColor.GRAY + "Connexion en cours au serveur '" + ChatColor.GREEN + "lobby " + ChatColor.GRAY + "' ..."));
                player.connect(ProxyServer.getInstance().getServerInfo("lobby"));
                return;
            }
        }
    }
}
