package com.google.android.datatransport.runtime.scheduling.persistence;

import C0.t;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import com.google.android.datatransport.runtime.n;
import com.google.android.datatransport.runtime.o;
import com.google.android.datatransport.runtime.u;
import io.ktor.utils.io.b0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k.C0569b;
import p.C0751a;
import p.C0752b;
import v.AbstractC0846a;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements SQLiteEventStore$Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1900a;
    public final /* synthetic */ k b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ f(k kVar, Object obj, Object obj2, int i) {
        this.f1900a = i;
        this.b = kVar;
        this.d = obj;
        this.c = obj2;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$Function
    public final Object apply(Object obj) throws Throwable {
        long jInsert;
        Cursor cursor;
        int i;
        p.c cVar;
        p.c cVar2;
        int i3 = 5;
        int i4 = 4;
        int i5 = 3;
        p.c cVar3 = p.c.CACHE_FULL;
        int i6 = 2;
        Object obj2 = this.c;
        int i7 = 0;
        Object obj3 = this.d;
        k kVar = this.b;
        int i8 = 1;
        switch (this.f1900a) {
            case 0:
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                long jSimpleQueryForLong = kVar.a().compileStatement("PRAGMA page_size").simpleQueryForLong() * kVar.a().compileStatement("PRAGMA page_count").simpleQueryForLong();
                a aVar = kVar.d;
                o oVar = (o) obj3;
                if (jSimpleQueryForLong >= aVar.f1896a) {
                    kVar.recordLogEventDropped(1L, cVar3, ((com.google.android.datatransport.runtime.i) oVar).f1880a);
                    return -1L;
                }
                u uVar = (u) obj2;
                Long lB = k.b(sQLiteDatabase, uVar);
                if (lB != null) {
                    jInsert = lB.longValue();
                } else {
                    ContentValues contentValues = new ContentValues();
                    com.google.android.datatransport.runtime.k kVar2 = (com.google.android.datatransport.runtime.k) uVar;
                    contentValues.put("backend_name", kVar2.f1883a);
                    contentValues.put("priority", Integer.valueOf(AbstractC0846a.a(kVar2.c)));
                    contentValues.put("next_request_ms", (Integer) 0);
                    byte[] bArr = kVar2.b;
                    if (bArr != null) {
                        contentValues.put("extras", Base64.encodeToString(bArr, 0));
                    }
                    jInsert = sQLiteDatabase.insert("transport_contexts", null, contentValues);
                }
                com.google.android.datatransport.runtime.i iVar = (com.google.android.datatransport.runtime.i) oVar;
                n nVar = iVar.c;
                byte[] bArr2 = nVar.b;
                int length = bArr2.length;
                int i9 = aVar.e;
                boolean z6 = length <= i9;
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("context_id", Long.valueOf(jInsert));
                contentValues2.put("transport_name", iVar.f1880a);
                contentValues2.put("timestamp_ms", Long.valueOf(iVar.d));
                contentValues2.put("uptime_ms", Long.valueOf(iVar.e));
                contentValues2.put("payload_encoding", nVar.f1888a.f3677a);
                contentValues2.put("code", iVar.b);
                contentValues2.put("num_attempts", (Integer) 0);
                contentValues2.put("inline", Boolean.valueOf(z6));
                contentValues2.put("payload", z6 ? bArr2 : new byte[0]);
                long jInsert2 = sQLiteDatabase.insert("events", null, contentValues2);
                if (!z6) {
                    int iCeil = (int) Math.ceil(((double) bArr2.length) / ((double) i9));
                    for (int i10 = 1; i10 <= iCeil; i10++) {
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr2, (i10 - 1) * i9, Math.min(i10 * i9, bArr2.length));
                        ContentValues contentValues3 = new ContentValues();
                        contentValues3.put("event_id", Long.valueOf(jInsert2));
                        contentValues3.put("sequence_num", Integer.valueOf(i10));
                        contentValues3.put("bytes", bArrCopyOfRange);
                        sQLiteDatabase.insert("event_payloads", null, contentValues3);
                    }
                }
                for (Map.Entry entry : Collections.unmodifiableMap(iVar.f1881f).entrySet()) {
                    ContentValues contentValues4 = new ContentValues();
                    contentValues4.put("event_id", Long.valueOf(jInsert2));
                    contentValues4.put("name", (String) entry.getKey());
                    contentValues4.put("value", (String) entry.getValue());
                    sQLiteDatabase.insert("event_metadata", null, contentValues4);
                }
                return Long.valueOf(jInsert2);
            case 1:
                Cursor cursor2 = (Cursor) obj;
                kVar.getClass();
                while (cursor2.moveToNext()) {
                    long j6 = cursor2.getLong(0);
                    int i11 = cursor2.getInt(7) != 0 ? i8 : 0;
                    com.google.android.datatransport.runtime.h hVar = new com.google.android.datatransport.runtime.h();
                    hVar.f1879f = new HashMap();
                    String string = cursor2.getString(i8);
                    if (string == null) {
                        throw new NullPointerException("Null transportName");
                    }
                    hVar.f1878a = string;
                    hVar.d = Long.valueOf(cursor2.getLong(i6));
                    hVar.e = Long.valueOf(cursor2.getLong(3));
                    if (i11 != 0) {
                        String string2 = cursor2.getString(4);
                        hVar.c = new n(string2 == null ? k.f1904f : new C0569b(string2), cursor2.getBlob(5));
                        i = i8;
                    } else {
                        String string3 = cursor2.getString(4);
                        C0569b c0569b = string3 == null ? k.f1904f : new C0569b(string3);
                        Cursor cursorQuery = kVar.a().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j6)}, null, null, "sequence_num");
                        try {
                            ArrayList arrayList = new ArrayList();
                            int length2 = 0;
                            while (cursorQuery.moveToNext()) {
                                int i12 = i8;
                                byte[] blob = cursorQuery.getBlob(0);
                                arrayList.add(blob);
                                length2 += blob.length;
                                i8 = i12;
                                break;
                            }
                            i = i8;
                            byte[] bArr3 = new byte[length2];
                            int i13 = 0;
                            int length3 = 0;
                            while (i13 < arrayList.size()) {
                                byte[] bArr4 = (byte[]) arrayList.get(i13);
                                cursor = cursorQuery;
                                try {
                                    ArrayList arrayList2 = arrayList;
                                    System.arraycopy(bArr4, 0, bArr3, length3, bArr4.length);
                                    length3 += bArr4.length;
                                    i13++;
                                    cursorQuery = cursor;
                                    arrayList = arrayList2;
                                } catch (Throwable th) {
                                    th = th;
                                    cursor.close();
                                    throw th;
                                }
                            }
                            cursorQuery.close();
                            hVar.c = new n(c0569b, bArr3);
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = cursorQuery;
                        }
                    }
                    if (!cursor2.isNull(6)) {
                        hVar.b = Integer.valueOf(cursor2.getInt(6));
                    }
                    ((ArrayList) obj3).add(new b(j6, (u) obj2, hVar.b()));
                    i8 = i;
                    i6 = 2;
                }
                return null;
            default:
                Cursor cursor3 = (Cursor) obj;
                while (true) {
                    HashMap map = (HashMap) obj3;
                    if (cursor3.moveToNext()) {
                        String string4 = cursor3.getString(i7);
                        int i14 = cursor3.getInt(1);
                        p.c cVar4 = p.c.REASON_UNKNOWN;
                        if (i14 != 0) {
                            if (i14 == 1) {
                                cVar4 = p.c.MESSAGE_TOO_OLD;
                            } else if (i14 == 2) {
                                cVar = cVar3;
                                cVar2 = cVar;
                            } else if (i14 == i5) {
                                cVar4 = p.c.PAYLOAD_TOO_BIG;
                            } else if (i14 == i4) {
                                cVar4 = p.c.MAX_RETRIES_REACHED;
                            } else if (i14 == i3) {
                                cVar4 = p.c.INVALID_PAYLOD;
                            } else if (i14 == 6) {
                                cVar4 = p.c.SERVER_ERROR;
                            } else {
                                b0.j(Integer.valueOf(i14), "SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN");
                            }
                            cVar2 = cVar3;
                            cVar = cVar4;
                        } else {
                            cVar2 = cVar3;
                            cVar = cVar4;
                        }
                        long j7 = cursor3.getLong(2);
                        if (!map.containsKey(string4)) {
                            map.put(string4, new ArrayList());
                        }
                        ((List) map.get(string4)).add(new p.d(j7, cVar));
                        cVar3 = cVar2;
                        i3 = 5;
                        i4 = 4;
                        i5 = 3;
                        i7 = 0;
                    } else {
                        Iterator it = map.entrySet().iterator();
                        while (true) {
                            t tVar = (t) obj2;
                            if (!it.hasNext()) {
                                long time = kVar.b.getTime();
                                SQLiteDatabase sQLiteDatabaseA = kVar.a();
                                sQLiteDatabaseA.beginTransaction();
                                try {
                                    Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]);
                                    try {
                                        cursorRawQuery.moveToNext();
                                        p.g gVar = new p.g(cursorRawQuery.getLong(0), time);
                                        cursorRawQuery.close();
                                        sQLiteDatabaseA.setTransactionSuccessful();
                                        sQLiteDatabaseA.endTransaction();
                                        tVar.b = gVar;
                                        tVar.d = new C0752b(new p.f(kVar.a().compileStatement("PRAGMA page_size").simpleQueryForLong() * kVar.a().compileStatement("PRAGMA page_count").simpleQueryForLong(), a.f1895f.f1896a));
                                        tVar.e = (String) kVar.e.get();
                                        return new C0751a((p.g) tVar.b, Collections.unmodifiableList((ArrayList) tVar.c), (C0752b) tVar.d, (String) tVar.e);
                                    } catch (Throwable th3) {
                                        cursorRawQuery.close();
                                        throw th3;
                                    }
                                } catch (Throwable th4) {
                                    sQLiteDatabaseA.endTransaction();
                                    throw th4;
                                }
                            }
                            Map.Entry entry2 = (Map.Entry) it.next();
                            int i15 = p.e.c;
                            new ArrayList();
                            ((ArrayList) tVar.c).add(new p.e((String) entry2.getKey(), Collections.unmodifiableList((List) entry2.getValue())));
                        }
                    }
                }
                break;
        }
    }
}
