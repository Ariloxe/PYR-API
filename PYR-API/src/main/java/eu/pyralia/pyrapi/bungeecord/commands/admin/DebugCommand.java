package eu.pyralia.pyrapi.bungeecord.commands.admin;

import eu.pyralia.pyrapi.BungeeCordAPI;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class DebugCommand extends Command {
  public DebugCommand() {
    super("debug", "debug.acc", new String[0]);
  }
  
  public void execute(CommandSender sender, String[] args) {
    if (!(sender instanceof net.md_5.bungee.api.connection.ProxiedPlayer)) {
      if (args.length == 0) {
        System.out.println("Commande invalide: /debug <force-open>");
        return;
      } 
      if (args[0].equalsIgnoreCase("force-open")) {
        BungeeCordAPI.getInstance().setStarted(true);
        System.out.println("Ouverture forcée sans protection pour les joueurs.");

      } 
    } 
  }
}
