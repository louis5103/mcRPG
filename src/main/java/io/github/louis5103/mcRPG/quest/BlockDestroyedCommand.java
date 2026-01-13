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
        QuestManager.getInstance().validAndCreateQuestUser(player.getUniqueId());
        player.sendMessage("퀘스트 시작!");
        return false;
    }
}
