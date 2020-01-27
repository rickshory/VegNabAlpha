package com.rickshory.vegnabalpha.data.source.local

import androidx.room.Dao

/**
 * Data Access Object for the nrcsspp table and nrcsspp_fts virtual table.
 */
@Dao
interface NrcsSppDao {
    // TODO rewrite these examples from java to kotlin
/*
    @Insert
    Long insertNrcsSppRow(NrcsSpp nrcsspp);

    @Insert
    Long[] insertNrcsSppRows(NrcsSpp... nrcsspps);

    @Query("SELECT * FROM nrcsspp")
    List<NrcsSpp> getAllNrcsSppRows();

    // might do this automatically
    @Query("INSERT INTO nrcsspp_fts(nrcsspp_fts) VALUES('rebuild')")
    void rebuild();

    //SEARCH The searchable columns
    @Query("SELECT nrcsspp.code, nrcsspp.genus, nrcsspp.species,
    nrcsspp.vernacular FROM nrcsspp_fts JOIN nrcsspp ON id = docid WHERE nrcsspp_fts MATCH :searchFor")
    List<NrcsSpp> searchFor(String searchFor);
* */
}