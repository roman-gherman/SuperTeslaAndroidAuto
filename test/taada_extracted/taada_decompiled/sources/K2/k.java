package k2;

import a.AbstractC0132a;
import java.util.Set;
import kotlin.collections.E;

/* JADX INFO: loaded from: classes2.dex */
public enum k {
    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L2.f f3720a;
    public final L2.f b;
    public final Object c = AbstractC0132a.N(2, new j(this, 1));
    public final Object d = AbstractC0132a.N(2, new j(this, 0));
    public static final Set e = E.x(CHAR, BYTE, SHORT, INT, FLOAT, LONG, DOUBLE);

    k(String str) {
        this.f3720a = L2.f.e(str);
        this.b = L2.f.e(str.concat("Array"));
    }
}
