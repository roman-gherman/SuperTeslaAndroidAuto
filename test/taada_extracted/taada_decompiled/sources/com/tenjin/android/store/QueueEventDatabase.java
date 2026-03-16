package com.tenjin.android.store;

import X0.a;
import a.AbstractC0132a;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

/* JADX INFO: loaded from: classes2.dex */
@TypeConverters({AbstractC0132a.class})
@Database(entities = {a.class}, exportSchema = false, version = 1)
public abstract class QueueEventDatabase extends RoomDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile QueueEventDatabase f3066a;

    public abstract QueueEventDao a();
}
