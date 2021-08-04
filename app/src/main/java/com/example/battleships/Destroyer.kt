package com.example.battleships

import android.util.Log

class Destroyer (incomingName:String){
    var name = ""
    private set

    //ship will always be a destroyer
    val type = "Destroyer"

    //how much ship can take before sinking
    private var hullIntegrity = 200

    //how many shots left in the arsenal
    var ammo = 1
    private set

    private var shotPower = 60

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

    fun shootShell(): Int
    {
        //can only shoot id you have ammo
        return if(ammo > 0)
        {
            ammo--
            shotPower
        }
        else
        {
            0
        }
    }

    fun serviceShip()
    {
        ammo = 10
        hullIntegrity += 100
    }

}