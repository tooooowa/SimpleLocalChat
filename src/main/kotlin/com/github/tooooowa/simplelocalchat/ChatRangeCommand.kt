package com.github.tooooowa.simplelocalchat

import com.github.tooooowa.simplelocalchat.Utilities.getColored
import com.github.tooooowa.simplelocalchat.Utilities.sendActionBar
import org.bukkit.Sound
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object ChatRangeCommand: CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        val player = sender as Player
        val chatRangeManager = ChatRangeManager()
        chatRangeManager.switchChatRange(player)
        sendActionBar(player, getColored("&f現在の設定: &e${chatRangeManager.getChatRangeJp(player)}"))
        player.playSound(player, Sound.BLOCK_DISPENSER_DISPENSE, 1.5f, 1.0f)
        return true
    }
}