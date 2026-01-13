package io.github.louis5103.mcRPG.quest;

import io.github.louis5103.mcRPG.McRPG;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BlockDestroyedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)) return false;

        Player player = (Player) sender;
        McRPG.instance.startTime = player.getWorld().getTime();

        McRPG.instance.blockList.add(Material.GRASS_BLOCK);
        McRPG.instance.blockList.add(Material.GRAY_WOOL);
        McRPG.instance.blockList.add(Material.STONE);
        McRPG.instance.blockList.add(Material.OAK_PLANKS);

        player.sendMessage("다음 블록을 순서대로 부숴주세요.");
        player.sendMessage(McRPG.instance.blockList.toString());
        McRPG.instance.onGame = true;
        return false;
    }
}
