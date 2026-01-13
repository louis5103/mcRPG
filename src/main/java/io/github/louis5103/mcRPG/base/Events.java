package io.github.louis5103.mcRPG.base;

import io.github.louis5103.mcRPG.McRPG;
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

}
