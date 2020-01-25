package com.rickshory.vegnabalpha.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.rickshory.vegnabalpha.data.Visit

/**
 * Data Access Object for the visits table.
 */
@Dao
interface VisitsDao {
    /**
     * Observes list of visits.
     * @return all visits.
     */
    @Query("SELECT * FROM Visits")
    fun observeVisits(): LiveData<List<Visit>>

}