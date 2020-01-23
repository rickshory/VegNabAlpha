package com.rickshory.vegnabalpha.data
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

/**
 * Immutable model class for a Visit. In order to compile with Room, we can't use @JvmOverloads to
 * generate multiple constructors.
 *
 * @param name       name of the visit
 * @param notes  notes on the visit
 * @param isDone whether or not this visit is finished
 * @param id          id of the visit
 */
@Entity(tableName = "visits")
data class Visit @JvmOverloads constructor (
    @ColumnInfo(name = "name") var name: String = "",
    @ColumnInfo(name = "notes") var notes: String = "",
    @ColumnInfo(name = "isDone") var isDone: Boolean = false,
    @PrimaryKey @ColumnInfo(name = "entryid") var id: String = UUID.randomUUID().toString()
) {

}