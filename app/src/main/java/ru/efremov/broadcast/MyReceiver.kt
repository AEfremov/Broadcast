package ru.efremov.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            "loaded" -> {
                val percent = intent.getIntExtra("percent", 0)
                Toast.makeText(context, "loaded $percent", Toast.LENGTH_LONG).show()
            }
            ACTION_CLICKED -> {
                val count = intent.getIntExtra(COUNT, 0)
                Toast.makeText(context, "CLICKED $count", Toast.LENGTH_LONG).show()
            }
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                val turnedOn = intent.getBooleanExtra("state", false)
                Toast.makeText(
                    context,
                    "AIRPLANE_MODE_CHANGED turnedOn=$turnedOn",
                    Toast.LENGTH_LONG
                ).show()
            }
            Intent.ACTION_BATTERY_LOW -> {
                Toast.makeText(context, "BATTERY_LOW", Toast.LENGTH_LONG).show()
            }
        }
    }

    companion object {

        const val ACTION_CLICKED = "clicked"
        const val COUNT = "count"
    }
}