package com.rickshory.vegnabalpha.data
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

/**
 * Immutable model class for a Visit. In order to compile with Room, we can't use @JvmOverloads to
 * generate multiple constructors.
 *
 * @param id          id of the visit
 * @param name       name of the visit
 * @param notes  notes on the visit
 * @param isDone whether or not this visit is finished
 */
@Entity(tableName = "visits")
data class Visit @JvmOverloads constructor (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "visitid") var id: Long = 0,
    @ColumnInfo(name = "name") var name: String = "",
    @ColumnInfo(name = "notes") var notes: String = "",
    @ColumnInfo(name = "isDone") var isDone: Boolean = false
) {

}