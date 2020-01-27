package com.rickshory.vegnabalpha.data.source

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Fts4
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

@Fts4
@Entity(tableName = "nrcsspp")
data class NrcsSpp @JvmOverloads constructor  (
//    @PrimaryKey @ColumnInfo(name = "rowid") val id: Int, // understood, don't need explicit for FTS tables
    @ColumnInfo(name = "code") var code: String = "",
    @ColumnInfo(name = "genus") var genus: String = "",
    @ColumnInfo(name = "species") var species: String = "",
    @ColumnInfo(name = "vernacular") var vernacular: String = ""
)  {
}