package w2;

import io.ktor.utils.io.Z;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: w2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0869c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final L2.c f5004a = new L2.c("javax.annotation.meta.TypeQualifierNickname");
    public static final L2.c b = new L2.c("javax.annotation.meta.TypeQualifier");
    public static final L2.c c = new L2.c("javax.annotation.meta.TypeQualifierDefault");
    public static final L2.c d = new L2.c("kotlin.annotations.jvm.UnderMigration");
    public static final List e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f5005f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final LinkedHashMap f5006g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Set f5007h;

    static {
        EnumC0868b enumC0868b = EnumC0868b.FIELD;
        EnumC0868b enumC0868b2 = EnumC0868b.METHOD_RETURN_TYPE;
        EnumC0868b enumC0868b3 = EnumC0868b.VALUE_PARAMETER;
        List listY = kotlin.collections.n.y(enumC0868b, enumC0868b2, enumC0868b3, EnumC0868b.TYPE_PARAMETER_BOUNDS, EnumC0868b.TYPE_USE);
        e = listY;
        L2.c cVar = E.c;
        D2.h hVar = D2.h.c;
        Map mapI = kotlin.collections.A.I(new N1.e(cVar, new s(new D2.i(hVar), listY, false)), new N1.e(E.f4976f, new s(new D2.i(hVar), listY, false)));
        f5005f = mapI;
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.collections.A.I(new N1.e(new L2.c("javax.annotation.ParametersAreNullableByDefault"), new s(new D2.i(D2.h.b), Z.p(enumC0868b3))), new N1.e(new L2.c("javax.annotation.ParametersAreNonnullByDefault"), new s(new D2.i(hVar), Z.p(enumC0868b3)))));
        linkedHashMap.putAll(mapI);
        f5006g = linkedHashMap;
        f5007h = kotlin.collections.j.N(new L2.c[]{E.f4978h, E.i});
    }
}
