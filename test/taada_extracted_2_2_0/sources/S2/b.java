package S2;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import k2.k;

/* JADX INFO: loaded from: classes2.dex */
public enum b {
    BOOLEAN(k.BOOLEAN, TypedValues.Custom.S_BOOLEAN, "Z", "java.lang.Boolean"),
    CHAR(k.CHAR, "char", "C", "java.lang.Character"),
    BYTE(k.BYTE, "byte", "B", "java.lang.Byte"),
    SHORT(k.SHORT, "short", "S", "java.lang.Short"),
    INT(k.INT, "int", "I", "java.lang.Integer"),
    FLOAT(k.FLOAT, TypedValues.Custom.S_FLOAT, "F", "java.lang.Float"),
    LONG(k.LONG, "long", "J", "java.lang.Long"),
    DOUBLE(k.DOUBLE, "double", "D", "java.lang.Double");


    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final HashSet f1290m = new HashSet();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final HashMap f1291n = new HashMap();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final EnumMap f1292o = new EnumMap(k.class);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final HashMap f1293p = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f1294a;
    public final String b;
    public final String c;
    public final L2.c d;

    static {
        for (b bVar : values()) {
            f1290m.add(bVar.e());
            f1291n.put(bVar.b, bVar);
            f1292o.put(bVar.d(), bVar);
            f1293p.put(bVar.c(), bVar);
        }
    }

    b(k kVar, String str, String str2, String str3) {
        if (kVar == null) {
            a(6);
            throw null;
        }
        this.f1294a = kVar;
        this.b = str;
        this.c = str2;
        this.d = new L2.c(str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r7) {
        /*
            Method dump skipped, instruction units count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S2.b.a(int):void");
    }

    public static b b(String str) {
        b bVar = (b) f1291n.get(str);
        if (bVar != null) {
            return bVar;
        }
        throw new AssertionError("Non-primitive type name passed: ".concat(str));
    }

    public final String c() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        a(12);
        throw null;
    }

    public final k d() {
        k kVar = this.f1294a;
        if (kVar != null) {
            return kVar;
        }
        a(10);
        throw null;
    }

    public final L2.c e() {
        L2.c cVar = this.d;
        if (cVar != null) {
            return cVar;
        }
        a(13);
        throw null;
    }
}
