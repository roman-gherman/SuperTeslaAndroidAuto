package androidx.room.util;

import C5.f;
import P1.b;
import P1.e;
import P1.j;
import android.database.Cursor;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import io.ktor.utils.io.Z;
import io.ktor.utils.io.internal.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.collections.m;
import kotlin.collections.v;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0002\u001a\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0002\u001a\"\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a \u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0002\u001a\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0000¨\u0006\u0017"}, d2 = {"readColumns", "", "", "Landroidx/room/util/TableInfo$Column;", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "tableName", "readForeignKeyFieldMappings", "", "Landroidx/room/util/TableInfo$ForeignKeyWithSequence;", "cursor", "Landroid/database/Cursor;", "readForeignKeys", "", "Landroidx/room/util/TableInfo$ForeignKey;", "readIndex", "Landroidx/room/util/TableInfo$Index;", "name", "unique", "", "readIndices", "readTableInfo", "Landroidx/room/util/TableInfo;", "room-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TableInfoKt {
    private static final Map<String, TableInfo.Column> readColumns(SupportSQLiteDatabase supportSQLiteDatabase, String str) throws IOException {
        Cursor cursorQuery = supportSQLiteDatabase.query("PRAGMA table_info(`" + str + "`)");
        try {
            if (cursorQuery.getColumnCount() <= 0) {
                v vVar = v.f3805a;
                cursorQuery.close();
                return vVar;
            }
            int columnIndex = cursorQuery.getColumnIndex("name");
            int columnIndex2 = cursorQuery.getColumnIndex("type");
            int columnIndex3 = cursorQuery.getColumnIndex("notnull");
            int columnIndex4 = cursorQuery.getColumnIndex("pk");
            int columnIndex5 = cursorQuery.getColumnIndex("dflt_value");
            e eVar = new e();
            while (true) {
                if (!cursorQuery.moveToNext()) {
                    eVar.b();
                    eVar.f1210l = true;
                    cursorQuery.close();
                    return eVar;
                }
                String name = cursorQuery.getString(columnIndex);
                String type = cursorQuery.getString(columnIndex2);
                boolean z6 = cursorQuery.getInt(columnIndex3) != 0;
                int i = cursorQuery.getInt(columnIndex4);
                String string = cursorQuery.getString(columnIndex5);
                h.e(name, "name");
                h.e(type, "type");
                eVar.put(name, new TableInfo.Column(name, type, z6, i, string, 2));
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                f.l(cursorQuery, th);
                throw th2;
            }
        }
    }

    private static final List<TableInfo.ForeignKeyWithSequence> readForeignKeyFieldMappings(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex(TypedValues.TransitionType.S_FROM);
        int columnIndex4 = cursor.getColumnIndex(TypedValues.TransitionType.S_TO);
        b bVar = new b();
        while (cursor.moveToNext()) {
            int i = cursor.getInt(columnIndex);
            int i3 = cursor.getInt(columnIndex2);
            String string = cursor.getString(columnIndex3);
            h.e(string, "cursor.getString(fromColumnIndex)");
            String string2 = cursor.getString(columnIndex4);
            h.e(string2, "cursor.getString(toColumnIndex)");
            bVar.add(new TableInfo.ForeignKeyWithSequence(i, i3, string, string2));
        }
        Z.b(bVar);
        return m.j0(bVar);
    }

    private static final Set<TableInfo.ForeignKey> readForeignKeys(SupportSQLiteDatabase supportSQLiteDatabase, String str) throws IOException {
        Cursor cursorQuery = supportSQLiteDatabase.query("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = cursorQuery.getColumnIndex("id");
            int columnIndex2 = cursorQuery.getColumnIndex("seq");
            int columnIndex3 = cursorQuery.getColumnIndex("table");
            int columnIndex4 = cursorQuery.getColumnIndex("on_delete");
            int columnIndex5 = cursorQuery.getColumnIndex("on_update");
            List<TableInfo.ForeignKeyWithSequence> foreignKeyFieldMappings = readForeignKeyFieldMappings(cursorQuery);
            cursorQuery.moveToPosition(-1);
            j jVar = new j();
            while (cursorQuery.moveToNext()) {
                if (cursorQuery.getInt(columnIndex2) == 0) {
                    int i = cursorQuery.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList<TableInfo.ForeignKeyWithSequence> arrayList3 = new ArrayList();
                    for (Object obj : foreignKeyFieldMappings) {
                        if (((TableInfo.ForeignKeyWithSequence) obj).getId() == i) {
                            arrayList3.add(obj);
                        }
                    }
                    for (TableInfo.ForeignKeyWithSequence foreignKeyWithSequence : arrayList3) {
                        arrayList.add(foreignKeyWithSequence.getFrom());
                        arrayList2.add(foreignKeyWithSequence.getTo());
                    }
                    String string = cursorQuery.getString(columnIndex3);
                    h.e(string, "cursor.getString(tableColumnIndex)");
                    String string2 = cursorQuery.getString(columnIndex4);
                    h.e(string2, "cursor.getString(onDeleteColumnIndex)");
                    String string3 = cursorQuery.getString(columnIndex5);
                    h.e(string3, "cursor.getString(onUpdateColumnIndex)");
                    jVar.add(new TableInfo.ForeignKey(string, string2, string3, arrayList, arrayList2));
                }
            }
            t.b(jVar);
            cursorQuery.close();
            return jVar;
        } finally {
        }
    }

    private static final TableInfo.Index readIndex(SupportSQLiteDatabase supportSQLiteDatabase, String str, boolean z6) {
        Cursor cursorQuery = supportSQLiteDatabase.query("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = cursorQuery.getColumnIndex("seqno");
            int columnIndex2 = cursorQuery.getColumnIndex("cid");
            int columnIndex3 = cursorQuery.getColumnIndex("name");
            int columnIndex4 = cursorQuery.getColumnIndex("desc");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex4 != -1) {
                TreeMap treeMap = new TreeMap();
                TreeMap treeMap2 = new TreeMap();
                while (cursorQuery.moveToNext()) {
                    if (cursorQuery.getInt(columnIndex2) >= 0) {
                        int i = cursorQuery.getInt(columnIndex);
                        String columnName = cursorQuery.getString(columnIndex3);
                        String str2 = cursorQuery.getInt(columnIndex4) > 0 ? "DESC" : "ASC";
                        Integer numValueOf = Integer.valueOf(i);
                        h.e(columnName, "columnName");
                        treeMap.put(numValueOf, columnName);
                        treeMap2.put(Integer.valueOf(i), str2);
                    }
                }
                Collection collectionValues = treeMap.values();
                h.e(collectionValues, "columnsMap.values");
                List listO0 = m.o0(collectionValues);
                Collection collectionValues2 = treeMap2.values();
                h.e(collectionValues2, "ordersMap.values");
                TableInfo.Index index = new TableInfo.Index(str, z6, listO0, m.o0(collectionValues2));
                f.l(cursorQuery, null);
                return index;
            }
            f.l(cursorQuery, null);
            return null;
        } finally {
        }
    }

    private static final Set<TableInfo.Index> readIndices(SupportSQLiteDatabase supportSQLiteDatabase, String str) throws IOException {
        Cursor cursorQuery = supportSQLiteDatabase.query("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = cursorQuery.getColumnIndex("name");
            int columnIndex2 = cursorQuery.getColumnIndex("origin");
            int columnIndex3 = cursorQuery.getColumnIndex("unique");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                j jVar = new j();
                while (cursorQuery.moveToNext()) {
                    if ("c".equals(cursorQuery.getString(columnIndex2))) {
                        String name = cursorQuery.getString(columnIndex);
                        boolean z6 = true;
                        if (cursorQuery.getInt(columnIndex3) != 1) {
                            z6 = false;
                        }
                        h.e(name, "name");
                        TableInfo.Index index = readIndex(supportSQLiteDatabase, name, z6);
                        if (index == null) {
                            cursorQuery.close();
                            return null;
                        }
                        jVar.add(index);
                    }
                }
                t.b(jVar);
                cursorQuery.close();
                return jVar;
            }
            cursorQuery.close();
            return null;
        } finally {
        }
    }

    public static final TableInfo readTableInfo(SupportSQLiteDatabase database, String tableName) {
        h.f(database, "database");
        h.f(tableName, "tableName");
        return new TableInfo(tableName, readColumns(database, tableName), readForeignKeys(database, tableName), readIndices(database, tableName));
    }
}
