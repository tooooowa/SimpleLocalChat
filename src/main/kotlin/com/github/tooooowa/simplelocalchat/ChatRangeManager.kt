package com.github.tooooowa.simplelocalchat

import com.github.tooooowa.simplelocalchat.SimpleLocalChat.Companion.chatRange
import org.bukkit.Particle
import org.bukkit.entity.Player

class ChatRangeManager {
    fun getChatRange(player: Player): String {
        if (chatRange[player.uniqueId] == null) chatRange[player.uniqueId] = "Normal"
        return chatRange[player.uniqueId].toString()
    }
    fun getChatRangeJp(player: Player): String {
        return when(getChatRange(player)){
            "Whisper" -> "小"
            "Normal" -> "中"
            else -> "大"
        }
    }
    fun switchChatRange(player: Player) {
        var range = getChatRange(player)
        range = when(range){
            "Normal" -> "Shouting"
            "Shouting" -> "Whisper"
            "Whisper" -> "Normal"
            else -> "Normal"
        }
        chatRange[player.uniqueId] = range
        Particles.playCircleParticle(player, Particle.FLAME, when(range) {
            "Whisper" -> 3
            "Normal" -> 10
            else -> 20
        })
    }
}