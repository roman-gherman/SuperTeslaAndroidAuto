package M2;

import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public enum t {
    VISIBILITY(true),
    MODALITY(true),
    OVERRIDE(true),
    ANNOTATIONS(false),
    INNER(true),
    MEMBER_KIND(true),
    DATA(true),
    INLINE(true),
    EXPECT(true),
    ACTUAL(true),
    CONST(true),
    LATEINIT(true),
    FUN(true),
    VALUE(true);

    public static final Set b;
    public static final Set c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1076a;

    static {
        t[] tVarArrValues = values();
        ArrayList arrayList = new ArrayList();
        for (t tVar : tVarArrValues) {
            if (tVar.f1076a) {
                arrayList.add(tVar);
            }
        }
        b = kotlin.collections.m.s0(arrayList);
        c = kotlin.collections.j.N(values());
    }

    t(boolean z6) {
        this.f1076a = z6;
    }
}
