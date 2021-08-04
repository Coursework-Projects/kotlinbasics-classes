package com.example.battleships

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val friendlyDestroyer = Destroyer("Invincible")
        val friendlyCarrier = Carrier("Indomitable")

        val enemyDestroyer = Destroyer("Grey Death")
        val enemyCarrier = Carrier("Big Grey Death")

        val friendlyShipyard = ShipYard()

// Uh oh!
        friendlyDestroyer.takeDamage(enemyDestroyer.shootShell())
        friendlyDestroyer.takeDamage(enemyCarrier.launchArialAttack())

// Fight back
        enemyCarrier.takeDamage(friendlyCarrier.launchArialAttack())
        enemyCarrier.takeDamage(friendlyDestroyer.shootShell())

// Take stock of the supplies situation
        Log.d("${friendlyDestroyer.name} ammo = ",
                "${friendlyDestroyer.ammo}")

        Log.d("${friendlyCarrier.name} attacks = ",
                "${friendlyCarrier.attacksRemaining}")

// Dock at the shipyard
        friendlyShipyard.serviceCarrier(friendlyCarrier)
        friendlyShipyard.serviceDestroyer(friendlyDestroyer)

// Take stock of the supplies situation again
        Log.d("${friendlyDestroyer.name} ammo = ",
                "${friendlyDestroyer.ammo}")

        Log.d("${friendlyCarrier.name} attacks = ",
                "${friendlyCarrier.attacksRemaining}")


// Finish off the enemy
        enemyDestroyer.takeDamage(friendlyDestroyer.shootShell())
        enemyDestroyer.takeDamage(friendlyCarrier.launchArialAttack())
        enemyDestroyer.takeDamage(friendlyDestroyer.shootShell())
    }
}