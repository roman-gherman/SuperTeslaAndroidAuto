package androidx.room.util;

import B2.b;
import O1.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.room.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.w;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlin.text.i;
import kotlin.text.r;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0006\u0014\u0015\u0016\u0017\u0018\u0019B1\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nBA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/room/util/TableInfo;", "", "name", "", "columns", "", "Landroidx/room/util/TableInfo$Column;", "foreignKeys", "", "Landroidx/room/util/TableInfo$ForeignKey;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Set;)V", "indices", "Landroidx/room/util/TableInfo$Index;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;)V", "equals", "", "other", "hashCode", "", "toString", "Column", "Companion", "CreatedFrom", "ForeignKey", "ForeignKeyWithSequence", "Index", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TableInfo {
    public static final int CREATED_FROM_DATABASE = 2;
    public static final int CREATED_FROM_ENTITY = 1;
    public static final int CREATED_FROM_UNKNOWN = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public final Map<String, Column> columns;
    public final Set<ForeignKey> foreignKeys;
    public final Set<Index> indices;
    public final String name;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/room/util/TableInfo$Companion;", "", "()V", "CREATED_FROM_DATABASE", "", "CREATED_FROM_ENTITY", "CREATED_FROM_UNKNOWN", "read", "Landroidx/room/util/TableInfo;", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "tableName", "", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(d dVar) {
            this();
        }

        @JvmStatic
        public final TableInfo read(SupportSQLiteDatabase database, String tableName) {
            h.f(database, "database");
            h.f(tableName, "tableName");
            return TableInfoKt.readTableInfo(database, tableName);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/room/util/TableInfo$CreatedFrom;", "", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(a.f1178a)
    public @interface CreatedFrom {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/room/util/TableInfo$ForeignKey;", "", "referenceTable", "", "onDelete", "onUpdate", "columnNames", "", "referenceColumnNames", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "equals", "", "other", "hashCode", "", "toString", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ForeignKey {
        public final List<String> columnNames;
        public final String onDelete;
        public final String onUpdate;
        public final List<String> referenceColumnNames;
        public final String referenceTable;

        public ForeignKey(String referenceTable, String onDelete, String onUpdate, List<String> columnNames, List<String> referenceColumnNames) {
            h.f(referenceTable, "referenceTable");
            h.f(onDelete, "onDelete");
            h.f(onUpdate, "onUpdate");
            h.f(columnNames, "columnNames");
            h.f(referenceColumnNames, "referenceColumnNames");
            this.referenceTable = referenceTable;
            this.onDelete = onDelete;
            this.onUpdate = onUpdate;
            this.columnNames = columnNames;
            this.referenceColumnNames = referenceColumnNames;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ForeignKey)) {
                return false;
            }
            ForeignKey foreignKey = (ForeignKey) other;
            if (h.a(this.referenceTable, foreignKey.referenceTable) && h.a(this.onDelete, foreignKey.onDelete) && h.a(this.onUpdate, foreignKey.onUpdate) && h.a(this.columnNames, foreignKey.columnNames)) {
                return h.a(this.referenceColumnNames, foreignKey.referenceColumnNames);
            }
            return false;
        }

        public int hashCode() {
            return this.referenceColumnNames.hashCode() + androidx.constraintlayout.core.motion.a.d(this.columnNames, androidx.constraintlayout.core.motion.a.c(androidx.constraintlayout.core.motion.a.c(this.referenceTable.hashCode() * 31, 31, this.onDelete), 31, this.onUpdate), 31);
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.referenceTable + "', onDelete='" + this.onDelete + " +', onUpdate='" + this.onUpdate + "', columnNames=" + this.columnNames + ", referenceColumnNames=" + this.referenceColumnNames + '}';
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0011\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0011"}, d2 = {"Landroidx/room/util/TableInfo$ForeignKeyWithSequence;", "", "id", "", "sequence", TypedValues.TransitionType.S_FROM, "", TypedValues.TransitionType.S_TO, "(IILjava/lang/String;Ljava/lang/String;)V", "getFrom", "()Ljava/lang/String;", "getId", "()I", "getSequence", "getTo", "compareTo", "other", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ForeignKeyWithSequence implements Comparable<ForeignKeyWithSequence> {
        private final String from;
        private final int id;
        private final int sequence;
        private final String to;

        public ForeignKeyWithSequence(int i, int i3, String from, String to) {
            h.f(from, "from");
            h.f(to, "to");
            this.id = i;
            this.sequence = i3;
            this.from = from;
            this.to = to;
        }

        public final String getFrom() {
            return this.from;
        }

        public final int getId() {
            return this.id;
        }

        public final int getSequence() {
            return this.sequence;
        }

        public final String getTo() {
            return this.to;
        }

        @Override // java.lang.Comparable
        public int compareTo(ForeignKeyWithSequence other) {
            h.f(other, "other");
            int i = this.id - other.id;
            return i == 0 ? this.sequence - other.sequence : i;
        }
    }

    public TableInfo(String name, Map<String, Column> columns, Set<ForeignKey> foreignKeys, Set<Index> set) {
        h.f(name, "name");
        h.f(columns, "columns");
        h.f(foreignKeys, "foreignKeys");
        this.name = name;
        this.columns = columns;
        this.foreignKeys = foreignKeys;
        this.indices = set;
    }

    @JvmStatic
    public static final TableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        return INSTANCE.read(supportSQLiteDatabase, str);
    }

    public boolean equals(Object other) {
        Set<Index> set;
        if (this == other) {
            return true;
        }
        if (!(other instanceof TableInfo)) {
            return false;
        }
        TableInfo tableInfo = (TableInfo) other;
        if (!h.a(this.name, tableInfo.name) || !h.a(this.columns, tableInfo.columns) || !h.a(this.foreignKeys, tableInfo.foreignKeys)) {
            return false;
        }
        Set<Index> set2 = this.indices;
        if (set2 == null || (set = tableInfo.indices) == null) {
            return true;
        }
        return h.a(set2, set);
    }

    public int hashCode() {
        return this.foreignKeys.hashCode() + ((this.columns.hashCode() + (this.name.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "TableInfo{name='" + this.name + "', columns=" + this.columns + ", foreignKeys=" + this.foreignKeys + ", indices=" + this.indices + '}';
    }

    public /* synthetic */ TableInfo(String str, Map map, Set set, Set set2, int i, d dVar) {
        this(str, map, set, (i & 8) != 0 ? null : set2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TableInfo(String name, Map<String, Column> columns, Set<ForeignKey> foreignKeys) {
        this(name, columns, foreignKeys, w.f3806a);
        h.f(name, "name");
        h.f(columns, "columns");
        h.f(foreignKeys, "foreignKeys");
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0003J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u0016\u0010\r\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000fR\u0010\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/room/util/TableInfo$Column;", "", "name", "", "type", "notNull", "", "primaryKeyPosition", "", "(Ljava/lang/String;Ljava/lang/String;ZI)V", "defaultValue", "createdFrom", "(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;I)V", "affinity", "getAffinity$annotations", "()V", "isPrimaryKey", "()Z", "equals", "other", "findAffinity", "hashCode", "toString", "Companion", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Column {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public final int affinity;
        public final int createdFrom;
        public final String defaultValue;
        public final String name;
        public final boolean notNull;
        public final int primaryKeyPosition;
        public final String type;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\t"}, d2 = {"Landroidx/room/util/TableInfo$Column$Companion;", "", "()V", "containsSurroundingParenthesis", "", "current", "", "defaultValueEquals", "other", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(d dVar) {
                this();
            }

            private final boolean containsSurroundingParenthesis(String current) {
                if (current.length() == 0) {
                    return false;
                }
                int i = 0;
                int i3 = 0;
                int i4 = 0;
                while (i < current.length()) {
                    char cCharAt = current.charAt(i);
                    int i5 = i4 + 1;
                    if (i4 == 0 && cCharAt != '(') {
                        return false;
                    }
                    if (cCharAt == '(') {
                        i3++;
                    } else if (cCharAt == ')' && i3 - 1 == 0 && i4 != current.length() - 1) {
                        return false;
                    }
                    i++;
                    i4 = i5;
                }
                return i3 == 0;
            }

            @JvmStatic
            public final boolean defaultValueEquals(String current, String other) {
                h.f(current, "current");
                if (current.equals(other)) {
                    return true;
                }
                if (!containsSurroundingParenthesis(current)) {
                    return false;
                }
                String strSubstring = current.substring(1, current.length() - 1);
                h.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                return h.a(i.X(strSubstring).toString(), other);
            }

            private Companion() {
            }
        }

        public Column(String name, String type, boolean z6, int i, String str, int i3) {
            h.f(name, "name");
            h.f(type, "type");
            this.name = name;
            this.type = type;
            this.notNull = z6;
            this.primaryKeyPosition = i;
            this.defaultValue = str;
            this.createdFrom = i3;
            this.affinity = findAffinity(type);
        }

        @JvmStatic
        public static final boolean defaultValueEquals(String str, String str2) {
            return INSTANCE.defaultValueEquals(str, str2);
        }

        private final int findAffinity(String type) {
            if (type == null) {
                return 5;
            }
            Locale US = Locale.US;
            h.e(US, "US");
            String upperCase = type.toUpperCase(US);
            h.e(upperCase, "this as java.lang.String).toUpperCase(locale)");
            if (i.D(upperCase, "INT", false)) {
                return 3;
            }
            if (i.D(upperCase, "CHAR", false) || i.D(upperCase, "CLOB", false) || i.D(upperCase, "TEXT", false)) {
                return 2;
            }
            if (i.D(upperCase, "BLOB", false)) {
                return 5;
            }
            return (i.D(upperCase, "REAL", false) || i.D(upperCase, "FLOA", false) || i.D(upperCase, "DOUB", false)) ? 4 : 1;
        }

        public static /* synthetic */ void getAffinity$annotations() {
        }

        public boolean equals(Object other) {
            String str;
            String str2;
            String str3;
            if (this == other) {
                return true;
            }
            if (!(other instanceof Column) || this.primaryKeyPosition != ((Column) other).primaryKeyPosition) {
                return false;
            }
            Column column = (Column) other;
            if (!h.a(this.name, column.name) || this.notNull != column.notNull) {
                return false;
            }
            if (this.createdFrom == 1 && column.createdFrom == 2 && (str3 = this.defaultValue) != null && !INSTANCE.defaultValueEquals(str3, column.defaultValue)) {
                return false;
            }
            if (this.createdFrom == 2 && column.createdFrom == 1 && (str2 = column.defaultValue) != null && !INSTANCE.defaultValueEquals(str2, this.defaultValue)) {
                return false;
            }
            int i = this.createdFrom;
            return (i == 0 || i != column.createdFrom || ((str = this.defaultValue) == null ? column.defaultValue == null : INSTANCE.defaultValueEquals(str, column.defaultValue))) && this.affinity == column.affinity;
        }

        public int hashCode() {
            return (((((this.name.hashCode() * 31) + this.affinity) * 31) + (this.notNull ? 1231 : 1237)) * 31) + this.primaryKeyPosition;
        }

        public final boolean isPrimaryKey() {
            return this.primaryKeyPosition > 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Column{name='");
            sb.append(this.name);
            sb.append("', type='");
            sb.append(this.type);
            sb.append("', affinity='");
            sb.append(this.affinity);
            sb.append("', notNull=");
            sb.append(this.notNull);
            sb.append(", primaryKeyPosition=");
            sb.append(this.primaryKeyPosition);
            sb.append(", defaultValue='");
            String str = this.defaultValue;
            if (str == null) {
                str = "undefined";
            }
            return b.h(sb, str, "'}");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @Deprecated(message = "Use {@link Column#Column(String, String, boolean, int, String, int)} instead.")
        public Column(String name, String type, boolean z6, int i) {
            this(name, type, z6, i, null, 0);
            h.f(name, "name");
            h.f(type, "type");
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/room/util/TableInfo$Index;", "", "name", "", "unique", "", "columns", "", "(Ljava/lang/String;ZLjava/util/List;)V", "orders", "(Ljava/lang/String;ZLjava/util/List;Ljava/util/List;)V", "equals", "other", "hashCode", "", "toString", "Companion", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Index {
        public static final String DEFAULT_PREFIX = "index_";
        public final List<String> columns;
        public final String name;
        public List<String> orders;
        public final boolean unique;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, java.util.Collection, java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r5v2, types: [java.util.ArrayList] */
        public Index(String name, boolean z6, List<String> columns, List<String> orders) {
            h.f(name, "name");
            h.f(columns, "columns");
            h.f(orders, "orders");
            this.name = name;
            this.unique = z6;
            this.columns = columns;
            this.orders = orders;
            if (orders.isEmpty()) {
                int size = columns.size();
                orders = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    orders.add(Index.Order.ASC.name());
                }
            }
            this.orders = orders;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Index)) {
                return false;
            }
            Index index = (Index) other;
            if (this.unique == index.unique && h.a(this.columns, index.columns) && h.a(this.orders, index.orders)) {
                return r.C(this.name, DEFAULT_PREFIX) ? r.C(index.name, DEFAULT_PREFIX) : h.a(this.name, index.name);
            }
            return false;
        }

        public int hashCode() {
            return this.orders.hashCode() + androidx.constraintlayout.core.motion.a.d(this.columns, (((r.C(this.name, DEFAULT_PREFIX) ? -1184239155 : this.name.hashCode()) * 31) + (this.unique ? 1 : 0)) * 31, 31);
        }

        public String toString() {
            return "Index{name='" + this.name + "', unique=" + this.unique + ", columns=" + this.columns + ", orders=" + this.orders + "'}";
        }

        @Deprecated(message = "Use {@link #Index(String, boolean, List, List)}")
        public Index(String name, boolean z6, List<String> columns) {
            h.f(name, "name");
            h.f(columns, "columns");
            int size = columns.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                arrayList.add(Index.Order.ASC.name());
            }
            this(name, z6, columns, arrayList);
        }
    }
}
