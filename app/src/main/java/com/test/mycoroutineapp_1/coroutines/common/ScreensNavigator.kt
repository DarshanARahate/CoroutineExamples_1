package com.techyourchance.coroutines.common

import android.os.Bundle
import com.ncapdevi.fragnav.FragNavController
import com.ncapdevi.fragnav.FragNavController.RootFragmentListener
import com.techyourchance.coroutines.demonstrations.backgroundthread.BackgroundThreadDemoFragment
import com.techyourchance.coroutines.demonstrations.basiccoroutines.BasicCoroutinesDemoFragment
import com.techyourchance.coroutines.demonstrations.uithread.UiThreadDemoFragment
import com.techyourchance.coroutines.exercises.exercise1.Exercise1SolutionFragment
import com.techyourchance.coroutines.exercises.exercise5.Exercise5Fragment
import com.techyourchance.coroutines.home.HomeFragment
import com.test.mycoroutineapp_1.coroutines.demonstrations.concurrentcoroutines.ConcurrentCoroutinesDemoFragment
import com.test.mycoroutineapp_1.coroutines.demonstrations.coroutinescancellation.CoroutinesCancellationDemoFragment
import com.test.mycoroutineapp_1.coroutines.demonstrations.design.DesignDemoFragment
import com.test.mycoroutineapp_1.coroutines.demonstrations.scopecancellation.ScopeCancellationDemoFragment
import com.test.mycoroutineapp_1.coroutines.demonstrations.scopechildrencancellation.ScopeChildrenCancellationDemoFragment
import com.test.mycoroutineapp_1.coroutines.demonstrations.viewmodel.ViewModelDemoFragment
import com.test.mycoroutineapp_1.coroutines.exercises.exercise2.Exercise2Fragment
import com.test.mycoroutineapp_1.coroutines.exercises.exersise3.Exercise3Fragment

class ScreensNavigator(private val fragNavController: FragNavController) {

    fun init(savedInstanceState: Bundle?) {
        fragNavController.rootFragmentListener = object : RootFragmentListener {
            override val numberOfRootFragments get() = 1

            override fun getRootFragment(index: Int) = HomeFragment.newInstance()
        }

        fragNavController.initialize(FragNavController.TAB1, savedInstanceState)
    }

    fun onSaveInstanceState(outState: Bundle?) {
        fragNavController.onSaveInstanceState(outState)
    }

    fun isRootScreen() = fragNavController.isRootFragment

    fun navigateBack(): Boolean {
        if (fragNavController.isRootFragment) {
            return false
        } else {
            fragNavController.popFragment()
            return true
        }
    }

    fun navigateUp() {
        fragNavController.popFragment()
    }

    fun toHomeScreen() {
        fragNavController.clearStack()
        fragNavController.pushFragment(HomeFragment.newInstance())
    }

    fun toUiThreadDemo() {
        fragNavController.pushFragment(UiThreadDemoFragment.newInstance())
    }

    fun toBackgroundThreadDemo() {
        fragNavController.pushFragment(BackgroundThreadDemoFragment.newInstance())
    }

    fun toBasicCoroutinesDemo() {
        fragNavController.pushFragment(BasicCoroutinesDemoFragment.newInstance())
    }

    fun toExercise1() {
        fragNavController.pushFragment(Exercise1SolutionFragment.newInstance())
    }

    fun toCoroutinesCancellationDemo() {
        fragNavController.pushFragment(CoroutinesCancellationDemoFragment.newInstance())
    }

    fun toExercise2() {
        fragNavController.pushFragment(Exercise2Fragment.newInstance())
    }

    fun toConcurrentCoroutines() {
        fragNavController.pushFragment(ConcurrentCoroutinesDemoFragment.newInstance())
    }

    fun toScopeChildrenCancellation() {
        fragNavController.pushFragment(ScopeChildrenCancellationDemoFragment.newInstance())
    }

    fun toExercise3() {
        fragNavController.pushFragment(Exercise3Fragment.newInstance())
    }

    fun toScopeCancellation() {
        fragNavController.pushFragment(ScopeCancellationDemoFragment.newInstance())
    }

    fun toViewModel() {
        fragNavController.pushFragment(ViewModelDemoFragment.newInstance())
    }

    fun toDesignDemo() {
        fragNavController.pushFragment(DesignDemoFragment.newInstance())
    }

    fun toExercise5() {
        fragNavController.pushFragment(Exercise5Fragment.newInstance())
    }

}