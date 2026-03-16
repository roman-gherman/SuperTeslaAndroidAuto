package k2;

import a3.F;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: k2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0586e implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3706a;
    public final /* synthetic */ i b;

    public /* synthetic */ C0586e(i iVar, int i) {
        this.f3706a = i;
        this.b = iVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        i iVar = this.b;
        switch (this.f3706a) {
            case 0:
                return Arrays.asList(iVar.k().getPackage(p.f3768k), iVar.k().getPackage(p.f3770m), iVar.k().getPackage(p.f3771n), iVar.k().getPackage(p.f3769l));
            default:
                EnumMap enumMap = new EnumMap(k.class);
                HashMap map = new HashMap();
                HashMap map2 = new HashMap();
                for (k kVar : k.values()) {
                    String strB = kVar.f3721a.b();
                    if (strB == null) {
                        iVar.getClass();
                        i.a(46);
                        throw null;
                    }
                    F defaultType = iVar.j(strB).getDefaultType();
                    if (defaultType == null) {
                        i.a(47);
                        throw null;
                    }
                    String strB2 = kVar.b.b();
                    if (strB2 == null) {
                        i.a(46);
                        throw null;
                    }
                    F defaultType2 = iVar.j(strB2).getDefaultType();
                    if (defaultType2 == null) {
                        i.a(47);
                        throw null;
                    }
                    enumMap.put(kVar, defaultType2);
                    map.put(defaultType, defaultType2);
                    map2.put(defaultType2, defaultType);
                }
                return new C0589h(enumMap, map, map2);
        }
    }
}
