package eu.pyralia.pyrapi.bungeecord.event;

import eu.pyralia.pyrapi.BungeeCordAPI;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;


public class PingEvent implements Listener {
    @EventHandler
    public void onProxyPing(ProxyPingEvent event) {
        ServerPing ping = event.getResponse();
        ServerPing.Players players = ping.getPlayers();

        int i = ProxyServer.getInstance().getOnlineCount();
        if (i == 0) {
            players.setOnline(0);
        } else {
            players.setOnline(ProxyServer.getInstance().getOnlineCount());
        }
        players.setMax(ProxyServer.getInstance().getOnlineCount() + 1);

        if (!BungeeCordAPI.getInstance().getStarted()) {
            ping.setVersion(new ServerPing.Protocol("§c§lChargement...", ping.getVersion().getProtocol() - 1));
            ping.setDescription("§e§l✪ §8§l➢ §6§lPyralia [1.8-1.16]   §f-   §b@PyraliaNetwork §e§l✪\n         §c§oInfrastructure en cours de démarrage !");
        }
        else if (BungeeCordAPI.getInstance().getMaintenanceStatut()) {
            ping.setVersion(new ServerPing.Protocol("§c§lMaintenance active !", ping.getVersion().getProtocol() - 1));
            String reason = BungeeCordAPI.getInstance().getMaintenancemess();
            ping.setDescription("§e§l✪ §8§l➢ §6§lPyralia [1.8-1.16]   §f-   §b@PyraliaNetwork §e§l✪\n" + reason);
        }
        else if (!BungeeCordAPI.getInstance().getMaintenanceStatut()) {
            ping.setDescription("§e§l✪ §8§l➢ §6§lPyralia [1.8-1.16]   §f-   §b@PyraliaNetwork §e§l✪\n §7Serveur UHCs Hosts (§cSNK§7, §bSAO§7, ...) ! §2Joyeuses §cFêtes §7!");
        }

        else if (ProxyServer.getInstance().getOnlineCount() >= 300) {
           ping.setDescription("§e§l✪ §8§l➢ §6§lPyralia [1.8-1.16]   §f-   §b@PyraliaNetwork §e§l✪\n         §c§oServeur complet, merci de patienter !");
         }
    }
}


