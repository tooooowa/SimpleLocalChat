package com.github.tooooowa.simplelocalchat

import org.bukkit.Location
import org.bukkit.Particle
import org.bukkit.entity.Player

object Particles {
    fun playCircleParticle(player: Player, particleType: Particle, radius: Int) {
        val loc: Location = player.location
        var i = 0.0
        while (i < 360) {
            loc.world?.spawnParticle(
                particleType, loc.x + Math.sin(Math.toRadians(i)) * radius,
                loc.y + 0.3, loc.z + Math.cos(Math.toRadians(i)) * radius, 1,
                0.0, 0.0, 0.0, 0.0)
            i += 5
        }
    }
}