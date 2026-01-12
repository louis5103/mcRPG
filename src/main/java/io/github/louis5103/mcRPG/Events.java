package io.github.louis5103.mcRPG;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events implements Listener {
    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.sendMessage("Hello, " + player.getName());

        Audience audience = Audience.audience(player);
        audience.sendMessage(MiniMessage.miniMessage().deserialize(
                "Hello <rainbow> world </rainbow>, isn't <blue><u><click:open_url:'https://docs.advntr.dev/minimessage'>MiniMessage</click></u><blue> fun?"
        ));
    }

    @EventHandler
    public void OnPlayerDestroyBlock(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        player.sendMessage(block.getType().toString() + "을 부셨습니다.");

        if(block.getType() == McRPG.instance.blockList.get(0)) {
            McRPG.instance.blockList.removeFirst();
            player.sendMessage(McRPG.instance.blockList.toString());
            if(McRPG.instance.blockList.size() == 0) {
                player.sendMessage("Game Clear!");
                player.sendMessage("걸린 시간: " + (player.getWorld().getTime() - McRPG.instance.startTime));
                McRPG.instance.onGame = false;
            }
        } else {
            player.sendMessage("이 블록이 아닙니다.");
        }
    }
}
