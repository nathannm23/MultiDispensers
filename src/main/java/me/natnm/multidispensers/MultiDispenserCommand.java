package me.natnm.multidispensers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class MultiDispenserCommand implements CommandExecutor {

    private final JavaPlugin plugin;

    public MultiDispenserCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used by players.");
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage("Usage: /multidispenser <power>");
            return true;
        }

        int power;
        try {
            power = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            sender.sendMessage("Power must be a valid integer.");
            return true;
        }

        if (power <= 0) {
            sender.sendMessage("Power must be greater than 0.");
            return true;
        }

        // give the player a multi-dispenser with the specified power
        Player player = (Player) sender;
        ItemStack multiDispenser = Util.createMultiDispenser(power);
        player.getInventory().addItem(multiDispenser);
        sender.sendMessage("You have been given a Multi-Dispenser with power: " + power + ".");

        return true;
    }
}