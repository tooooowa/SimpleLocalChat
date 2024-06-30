package com.github.tooooowa.simplelocalchat

import com.github.tooooowa.simplelocalchat.Utilities.getColored
import com.github.tooooowa.simplelocalchat.Utilities.sendActionBar
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerChatEvent

object ChatEventListener: Listener {
    @EventHandler
    fun onChat(event: PlayerChatEvent) {
        event.isCancelled = true
        Bukkit.broadcastMessage(getColored("${event.player.name}: ${event.message}"))

        val player = event.player
        val playerLocation = player.location
        val nearByPlayer = mutableListOf<Player>()
        val chatRangeManager = ChatRangeManager()
        val rangeInt = when(chatRangeManager.getChatRange(player)) {
            "Whisper" -> 3
            "Normal" -> 10
            else -> 20
        }

        for (onlinePlayer in player.world.players) {
            val location = onlinePlayer.location
            val distance = location.distance(playerLocation)
            if (distance <= rangeInt) nearByPlayer.add(onlinePlayer)
        }

        if (nearByPlayer.size == 1) {
            player.sendMessage(getColored("&7${player.name}: ${event.message}"))
            return
        }

        val receiverNames = mutableListOf<String>()
        for (receiver in nearByPlayer) {
            receiver.sendMessage("${player.name}: ${event.message}")
            if (receiver == player) continue
            receiverNames.add(receiver.name)
        }
        val receiverName = receiverNames.joinToString(getColored(" &7| &b"))
        sendActionBar(player, getColored("&7[ &b${receiverName} &7]"))

    }
}