package eu.pyralia.pyrapi.bungeecord.commands.admin;

	import java.util.concurrent.TimeUnit;

	import eu.pyralia.pyrapi.BungeeCordAPI;
	import net.md_5.bungee.api.CommandSender;
	import net.md_5.bungee.api.ProxyServer;
	import net.md_5.bungee.api.chat.BaseComponent;
	import net.md_5.bungee.api.chat.TextComponent;
	import net.md_5.bungee.api.connection.ProxiedPlayer;
	import net.md_5.bungee.api.plugin.Command;
	import net.md_5.bungee.api.plugin.Plugin;

	public class MaintenanceCommand extends Command {
		private boolean NeedConfirm = false;
		public MaintenanceCommand() {
			super("maintenance");
		}
		

	public void execute(CommandSender sender, String[] args) {
		if (sender instanceof ProxiedPlayer) {
			ProxiedPlayer player = (ProxiedPlayer)sender;
				if (sender.hasPermission("admin.use")) {
					if (args.length == 0) { player.sendMessage((BaseComponent)new TextComponent("§7§l[§c§lMaintenance§7§l] §aUsage: /maintenance toggle <true/false>")); }
						else if (args[0].equalsIgnoreCase("toggle")){
							if (args.length == 1){ 
								player.sendMessage((BaseComponent)new TextComponent("§7§l[§c§lMaintenance§7§l] §aUsage: /maintenance toggle <true/false> <bêta/>"));
								} else { 
									if (!this.NeedConfirm) {
										player.sendMessage((BaseComponent)new TextComponent("§7§l[§c§lMaintenance§7§l] §6§oL'infrastructure Pyralia passera en §6§ostatut §c§l" + args[1] + "§6§o après la confirmation de cette §6§ocommande. §2§lRééxécuter cette commande pour §2§lconfirmer §2§lvotre choix."));
										this.NeedConfirm = true;
										ProxyServer.getInstance().getScheduler().schedule((Plugin) BungeeCordAPI.getInstance(), new Runnable() {
											public void run() {
												MaintenanceCommand.this.NeedConfirm = false;
											}
										},30L, TimeUnit.SECONDS);
									} else {
										this.NeedConfirm = false;
										if(args[1].equals("true")){
											BungeeCordAPI.getInstance().setMaintenanceStatut(true);
												player.sendMessage((BaseComponent)new TextComponent("§7§l[§c§lMaintenance§7§l] §6L'infrastructure Pyralia est désormais en MAINTENANCE !"));
										} else {
											BungeeCordAPI.getInstance().setMaintenanceStatut(false);
											player.sendMessage((BaseComponent)new TextComponent("§7§l[§c§lMaintenance§7§l] §6L'infrastructure Pyralia n'est désormais plus en MAINTENANCE !"));
										}
									}
								}
						}
				}
		}
	}
}
