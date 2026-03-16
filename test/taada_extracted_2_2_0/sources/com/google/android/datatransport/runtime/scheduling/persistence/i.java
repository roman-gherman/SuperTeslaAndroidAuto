package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import android.util.Base64;
import java.util.ArrayList;
import v.AbstractC0846a;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements SQLiteEventStore$Function {
    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$Function
    public final Object apply(Object obj) {
        Cursor cursor = (Cursor) obj;
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            String string = cursor.getString(1);
            if (string == null) {
                throw new NullPointerException("Null backendName");
            }
            k.d dVarB = AbstractC0846a.b(cursor.getInt(2));
            String string2 = cursor.getString(3);
            arrayList.add(new com.google.android.datatransport.runtime.k(string, string2 == null ? null : Base64.decode(string2, 0), dVarB));
        }
        return arrayList;
    }
}
