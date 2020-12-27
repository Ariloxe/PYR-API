package eu.pyralia.pyrapi.bungeecord.commands.mod;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class GTPCommand extends Command {
    public GTPCommand(String name) {
        super(name);
    }


    @SuppressWarnings("deprecation")
    public void execute(CommandSender commandSender, String[] strings) {
        if (commandSender instanceof ProxiedPlayer) {
            ProxiedPlayer proxiedPlayer = (ProxiedPlayer)commandSender;
            if (proxiedPlayer.hasPermission("staff.gtp")) {
            	if(strings.length == 0) {
            		String server = ProxyServer.getInstance().getPlayer(strings[0]).getServer().getInfo().getName();
            		proxiedPlayer.connect(ProxyServer.getInstance().getServerInfo(server));
                    return;
            	}

            }
        }	
    }
}
