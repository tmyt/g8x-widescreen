package net.refy.android.g8x.widemode.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import net.refy.android.g8x.widemode.utils.ActivityUtils
import net.refy.android.g8x.widemode.utils.DisplayManagerExUtils

class TaskerActionReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, bundle: Intent?) {
        val mode = bundle?.extras?.getInt("mode") ?: return
        val displayUtils = DisplayManagerExUtils()
        val activityUtils = ActivityUtils(context!!)
        if (!activityUtils.canSwitchMode() || !displayUtils.isCoverEnabled()) {
            return
        }
        val isInWideMode = activityUtils.getWideScreenMode()
        when (mode) {
            0 -> activityUtils.setWideScreenMode(true)
            1 -> activityUtils.setWideScreenMode(false)
            else -> activityUtils.setWideScreenMode(!isInWideMode)
        }
    }
}