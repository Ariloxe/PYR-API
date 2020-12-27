package eu.pyralia.pyrapi.bungeecord.event;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class TabCompleteEvent implements Listener {
    @EventHandler
    public void onTabComplete(net.md_5.bungee.api.event.TabCompleteEvent tabCompleteEvent) {
        String args = tabCompleteEvent.getCursor().toLowerCase();
        ProxiedPlayer proxiedPlayer = ProxyServer.getInstance().getPlayer(String.valueOf(tabCompleteEvent.getSender()));
        if (!proxiedPlayer.hasPermission("staff.use")) {
            if (args.startsWith("/") && !args.contains(" ")) {
                tabCompleteEvent.getSuggestions().clear();
                tabCompleteEvent.getSuggestions().add("msg");
                tabCompleteEvent.getSuggestions().add("r");
                tabCompleteEvent.getSuggestions().add("nlist");
                tabCompleteEvent.getSuggestions().add("hub");
                tabCompleteEvent.setCancelled(true);
            }
        }

        String partialPlayerName = tabCompleteEvent.getCursor().toLowerCase();
        int lastSpaceIndex = partialPlayerName.lastIndexOf(' ');
        if (lastSpaceIndex >= 0) {
            partialPlayerName = partialPlayerName.substring(lastSpaceIndex + 1);
        }
        for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
            if (p.getName().toLowerCase().startsWith(partialPlayerName))
                tabCompleteEvent.getSuggestions().add(p.getName());
            }
        }

}
