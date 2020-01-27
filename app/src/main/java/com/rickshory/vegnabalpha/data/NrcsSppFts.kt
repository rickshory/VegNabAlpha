package com.rickshory.vegnabalpha.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Fts4

/**
 * Immutable model class for an NRCS Species record. In order to compile with Room, we can't use @JvmOverloads to
 * generate multiple constructors.
 * Full Text Search virtual table, based on NrcsSpp
 *
 * @param id          id of the record
 * @param code       standard code for the plant
 * @param genus       plant genus
 * @param species  species of the plant
 * @param vernacular common names(s) of the plant
 */

@Fts4(contentEntity = NrcsSpp::class)
@Entity(tableName = "nrcsspp_fts")
data class NrcsSppFts @JvmOverloads constructor  (
//    @PrimaryKey @ColumnInfo(name = "rowid") val id: Int, // understood, don't need explicit for FTS tables
    @ColumnInfo(name = "code") var code: String = "",
    @ColumnInfo(name = "genus") var genus: String = "",
    @ColumnInfo(name = "species") var species: String = "",
    @ColumnInfo(name = "vernacular") var vernacular: String = ""
)   {
}