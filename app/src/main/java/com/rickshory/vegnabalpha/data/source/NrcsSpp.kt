package com.rickshory.vegnabalpha.data.source

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Immutable model class for an NRCS Species record. In order to compile with Room, we can't use @JvmOverloads to
 * generate multiple constructors.
 *
 * @param id          id of the record
 * @param code       standard code for the plant
 * @param genus       plant genus
 * @param species  species of the plant
 * @param vernacular common names(s) of the plant
 */

@Entity(tableName = "nrcsspp")
data class NrcsSpp @JvmOverloads constructor  (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "sppid") var id: Long = 0,
    @ColumnInfo(name = "code") var code: String = "",
    @ColumnInfo(name = "genus") var genus: String = "",
    @ColumnInfo(name = "species") var species: String = "",
    @ColumnInfo(name = "vernacular") var vernacular: String = ""
)  {
}