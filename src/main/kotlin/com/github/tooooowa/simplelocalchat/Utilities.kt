package com.github.tooooowa.simplelocalchat

import com.github.tooooowa.simplelocalchat.SimpleLocalChat.Companion.PLUGIN
import net.md_5.bungee.api.ChatMessageType
import net.md_5.bungee.api.chat.BaseComponent
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player


object Utilities {
    fun getColored(text: String) : String {
        return ChatColor.translateAlternateColorCodes('&', text)
    }
    fun sendActionBar(player: Player, message: String){
        val baseComponents = TextComponent.fromLegacyText(message) as BaseComponent
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, baseComponents)
    }
    fun transferPlayer(player: Player, targetServer: String){
        Bukkit.getServer().messenger.registerOutgoingPluginChannel(PLUGIN, "BungeeCord")
        player.sendPluginMessage(PLUGIN, "BungeeCord", "Connect$targetServer".toByteArray())
    }
    fun runCommandAsConsole(command: String) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command)
    }
}