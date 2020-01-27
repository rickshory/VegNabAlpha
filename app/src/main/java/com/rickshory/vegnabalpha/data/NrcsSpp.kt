package com.rickshory.vegnabalpha.data

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
 *
 *  This is the base table. The virtual table for full text search is 'nrcsspp_fts'
 */

@Entity(tableName = "nrcsspp")
data class NrcsSpp @JvmOverloads constructor  (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "sppid") var id: Int = 0,
    @ColumnInfo(name = "code") var code: String = "",
    @ColumnInfo(name = "genus") var genus: String = "",
    @ColumnInfo(name = "species") var species: String = "",
    @ColumnInfo(name = "vernacular") var vernacular: String = ""
)  {
}