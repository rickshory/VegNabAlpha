package com.rickshory.vegnabalpha.data
/**
 * Immutable model class for a Visit. In order to compile with Room, we can't use @JvmOverloads to
 * generate multiple constructors.
 *
 * @param name       name of the visit
 * @param notes  notes on the visit
 * @param isDone whether or not this visit is finished
 * @param id          id of the visit
 */
data class Visit @JvmOverloads constructor {

}