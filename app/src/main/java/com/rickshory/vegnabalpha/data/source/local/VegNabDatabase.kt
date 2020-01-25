package com.rickshory.vegnabalpha.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rickshory.vegnabalpha.data.Visit

/**
 * The Room Database that contains the VegNab tables
 * Make exportSchema = true in production database
 */
@Database(entities = [Visit::class], version = 1, exportSchema = false)
abstract class VegNabDatabase : RoomDatabase() {
    abstract fun visitDao(): VisitsDao
}