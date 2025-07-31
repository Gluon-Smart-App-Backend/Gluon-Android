package com.gluon.gluonapp.utils

import android.util.Log
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun getCurrentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

/**
 * Utility class to handle safe navigation and prevent rapid navigation calls
 */
object NavigationUtils {
    
    private const val TAG = "NavigationUtils"
    private var isNavigating = false
    
    /**
     * Safely navigate to a route with debouncing to prevent rapid clicks
     */
    fun safeNavigate(
        navController: NavController,
        route: String,
        coroutineScope: CoroutineScope,
        debounceTime: Long = 500L
    ) {
        if (isNavigating) {
            Log.d(TAG, "Navigation already in progress, skipping: $route")
            return
        }
        
        coroutineScope.launch {
            try {
                isNavigating = true
                Log.d(TAG, "Navigating to: $route")
                navController.navigate(route)
                delay(debounceTime)
            } catch (e: Exception) {
                Log.e(TAG, "Navigation error to $route: ${e.message}", e)
            } finally {
                isNavigating = false
            }
        }
    }
    
    /**
     * Safely pop back stack with debouncing
     */
    fun safePopBackStack(
        navController: NavController,
        coroutineScope: CoroutineScope,
        debounceTime: Long = 500L,
        fallbackRoute: String = "Home/Guest"
    ) {
        if (isNavigating) {
            Log.d(TAG, "Navigation already in progress, skipping popBackStack")
            return
        }
        
        coroutineScope.launch {
            try {
                isNavigating = true
                // Check if there's a previous destination before popping
                val currentDestination = navController.currentBackStackEntry?.destination
                val previousDestination = navController.previousBackStackEntry?.destination
                
                if (previousDestination != null) {
                    Log.d(TAG, "Popping back stack from ${currentDestination?.route} to ${previousDestination.route}")
                    navController.popBackStack()
                    delay(debounceTime)
                } else {
                    Log.w(TAG, "Cannot pop back stack - no previous destination available")
                    // If no previous destination, navigate to fallback route instead
                    Log.d(TAG, "Navigating to fallback route instead: $fallbackRoute")
                    navController.navigate(fallbackRoute) {
                        // Clear the entire back stack and make fallback the only destination
                        popUpTo(0) { inclusive = true }
                    }
                    delay(debounceTime)
                }
            } catch (e: Exception) {
                Log.e(TAG, "PopBackStack error: ${e.message}", e)
                // Fallback: try to navigate to fallback route if popBackStack fails
                try {
                    Log.d(TAG, "Fallback: navigating to fallback route: $fallbackRoute")
                    navController.navigate(fallbackRoute) {
                        popUpTo(0) { inclusive = true }
                    }
                } catch (fallbackError: Exception) {
                    Log.e(TAG, "Fallback navigation also failed: ${fallbackError.message}", fallbackError)
                }
            } finally {
                isNavigating = false
            }
        }
    }
    
    /**
     * Check if navigation is currently in progress
     */
    fun isNavigating(navController: NavController): Boolean {
        return navController.currentBackStackEntry?.destination?.route != null
    }
    
    /**
     * Get current route safely
     */
    fun getCurrentRoute(navController: NavController): String? {
        return try {
            navController.currentBackStackEntry?.destination?.route
        } catch (e: Exception) {
            Log.e(TAG, "Error getting current route: ${e.message}", e)
            null
        }
    }
}
