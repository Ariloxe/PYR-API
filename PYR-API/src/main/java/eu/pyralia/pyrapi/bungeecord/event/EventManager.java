package eu.pyralia.pyrapi.bungeecord.event;

import eu.pyralia.pyrapi.BungeeCordAPI;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;

public class EventManager {
    public static void register(Plugin plugin) {
        BungeeCordAPI.getInstance().getProxy().getPluginManager().registerListener(plugin, new JoinEvent());
        BungeeCordAPI.getInstance().getProxy().getPluginManager().registerListener(plugin, new PingEvent());
        BungeeCordAPI.getInstance().getProxy().getPluginManager().registerListener(plugin, new TabCompleteEvent());
    }
}
