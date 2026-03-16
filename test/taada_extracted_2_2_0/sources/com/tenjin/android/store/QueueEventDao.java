package com.tenjin.android.store;

import X0.a;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Dao
public interface QueueEventDao {
    @Delete
    void delete(a aVar);

    @Query("DELETE FROM QueueEvent")
    void deleteAllEvents();

    @Query("DELETE FROM QueueEvent WHERE date < :date")
    void deleteOldEvents(Date date);

    @Query("SELECT * FROM QueueEvent WHERE date >= :date ORDER BY date DESC")
    List<a> getAllEvents(Date date);

    @Query("SELECT * FROM QueueEvent WHERE params == :params")
    List<a> getEventsFromParams(String str);

    @Insert
    long insert(a aVar);
}
