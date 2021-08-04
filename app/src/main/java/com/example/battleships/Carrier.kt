package com.example.battleships

import android.util.Log

class Carrier(incomingName:String) {

    var name = ""
        private set

    //ship will always be a carrier
    val type = "Carrier"

    //how much ship can take before sinking
    private var hullIntegrity = 400

    //how many shots left in the arsenal
    var attacksRemaining = 1
        private set

    private var attackPower = 60

    private var sunk = false

    init{
        this.name = "$type $incomingName"
    }

    fun takeDamage(damageTaken:Int)
    {
        if(!sunk)
        {
            //reduce hull integrity
            if(hullIntegrity > 0)
            {
                hullIntegrity -= damageTaken
                Log.i("$name damage taken =","$damageTaken")
                Log.i("$name hull Integrity = ","$hullIntegrity")
            }
            else
            {
                Log.i("Destroyer ","$name has already sunk")
            }
        }
    }

    fun launchArialAttack(): Int
    {
        //can only shoot id you have ammo
        return if(attacksRemaining > 0)
        {
            attacksRemaining--
            attackPower
        }
        else
        {
            0
        }
    }

    fun serviceShip()
    {
        attacksRemaining = 20
        hullIntegrity += 100
    }
}