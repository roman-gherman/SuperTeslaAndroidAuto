package K2;

import J2.j;
import J2.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import k3.q;
import kotlin.collections.B;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.o;
import kotlin.collections.w;
import kotlin.collections.x;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import net.bytebuddy.asm.Advice;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements NameResolver {
    public static final List d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f941a;
    public final Set b;
    public final ArrayList c;

    static {
        String strV = m.V(n.y('k', 'o', Character.valueOf(Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL), 'l', 'i', 'n'), "", null, null, null, 62);
        List listY = n.y(strV.concat("/Any"), strV.concat("/Nothing"), strV.concat("/Unit"), strV.concat("/Throwable"), strV.concat("/Number"), strV.concat("/Byte"), strV.concat("/Double"), strV.concat("/Float"), strV.concat("/Int"), strV.concat("/Long"), strV.concat("/Short"), strV.concat("/Boolean"), strV.concat("/Char"), strV.concat("/CharSequence"), strV.concat("/String"), strV.concat("/Comparable"), strV.concat("/Enum"), strV.concat("/Array"), strV.concat("/ByteArray"), strV.concat("/DoubleArray"), strV.concat("/FloatArray"), strV.concat("/IntArray"), strV.concat("/LongArray"), strV.concat("/ShortArray"), strV.concat("/BooleanArray"), strV.concat("/CharArray"), strV.concat("/Cloneable"), strV.concat("/Annotation"), strV.concat("/collections/Iterable"), strV.concat("/collections/MutableIterable"), strV.concat("/collections/Collection"), strV.concat("/collections/MutableCollection"), strV.concat("/collections/List"), strV.concat("/collections/MutableList"), strV.concat("/collections/Set"), strV.concat("/collections/MutableSet"), strV.concat("/collections/Map"), strV.concat("/collections/MutableMap"), strV.concat("/collections/Map.Entry"), strV.concat("/collections/MutableMap.MutableEntry"), strV.concat("/collections/Iterator"), strV.concat("/collections/MutableIterator"), strV.concat("/collections/ListIterator"), strV.concat("/collections/MutableListIterator"));
        d = listY;
        q qVarT0 = m.t0(listY);
        int iF = B.F(o.D(qVarT0));
        if (iF < 16) {
            iF = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iF);
        Iterator it = qVarT0.iterator();
        while (true) {
            k3.b bVar = (k3.b) it;
            if (!bVar.c.hasNext()) {
                return;
            }
            x xVar = (x) bVar.next();
            linkedHashMap.put((String) xVar.b, Integer.valueOf(xVar.f3807a));
        }
    }

    public g(k kVar, String[] strings) {
        kotlin.jvm.internal.h.f(strings, "strings");
        List list = kVar.c;
        Set setS0 = list.isEmpty() ? w.f3806a : m.s0(list);
        List<j> list2 = kVar.b;
        kotlin.jvm.internal.h.e(list2, "types.recordList");
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(list2.size());
        for (j jVar : list2) {
            int i = jVar.c;
            for (int i3 = 0; i3 < i; i3++) {
                arrayList.add(jVar);
            }
        }
        arrayList.trimToSize();
        this.f941a = strings;
        this.b = setS0;
        this.c = arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public final String getQualifiedClassName(int i) {
        return getString(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String getString(int r10) {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: K2.g.getString(int):java.lang.String");
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public final boolean isLocalClassName(int i) {
        return this.b.contains(Integer.valueOf(i));
    }
}
