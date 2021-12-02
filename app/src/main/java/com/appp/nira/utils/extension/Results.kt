

package com.appp.nira.utils.extension

/**
 * Generic class that holds the network state
 */
sealed class Results<out R> {
    data class Success<out T>(val data: T) : Results<T>()
    object Loading : Results<Nothing>()
    object Error : Results<Nothing>()
}