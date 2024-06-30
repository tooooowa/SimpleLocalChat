package com.github.tooooowa.simplelocalchat

import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import java.util.*
import kotlin.collections.HashMap

class SimpleLocalChat : JavaPlugin() {
    companion object{
        lateinit var PLUGIN: Plugin
            private set
        val chatRange: MutableMap<UUID, String> = HashMap()
    }
    override fun onEnable() {
        PLUGIN = this
        getCommand("range")?.setExecutor(ChatRangeCommand)
        server.pluginManager.registerEvents(ChatEventListener, this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
