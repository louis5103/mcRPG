package io.github.louis5103.mcRPG.quest;

import io.github.louis5103.mcRPG.McRPG;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class QuestEvent implements Listener {
    @EventHandler
    public void OnPlayerDestroyBlock(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();

        QuestManager.getInstance()
                .checkAndUpdateQuest(player.getUniqueId(), block.getType())
                .ifPresentOrElse(
                        validBlock -> player.sendMessage(validBlock+ "을 부셨습니다!"),
                        () -> player.sendMessage("유효한 블럭을 부셔주세요!")
                );
    }
}
