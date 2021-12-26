package com.techyourchance.coroutines.common.dependencyinjection

import androidx.fragment.app.FragmentActivity
import com.ncapdevi.fragnav.FragNavController
import com.techyourchance.coroutines.common.ScreensNavigator
import com.techyourchance.coroutines.common.ToolbarDelegate
import com.techyourchance.coroutines.exercises.exercise1.GetReputationEndpoint
import com.test.mycoroutineapp_1.R
import com.test.mycoroutineapp_1.coroutines.demonstrations.design.BenchmarkUseCase
import com.test.mycoroutineapp_1.coroutines.exercises.exercise5.GetReputationUseCase

class ActivityCompositionRoot(
        private val activity: FragmentActivity,
        private val appCompositionRoot: ApplicationCompositionRoot
) {

    val toolbarManipulator get() = activity as ToolbarDelegate

    val screensNavigator: ScreensNavigator by lazy {
        ScreensNavigator(fragNavController)
    }

    private val fragNavController get() = FragNavController(fragmentManager, R.id.frame_content)

    private val fragmentManager get() = activity.supportFragmentManager

    val getReputationEndpoint get() = GetReputationEndpoint()

    val benchmarkUseCase get() = BenchmarkUseCase()

    val getReputationUseCase get() = GetReputationUseCase(getReputationEndpoint)
}