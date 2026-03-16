package V1;

import A2.C0022d;
import java.io.Serializable;
import kotlin.collections.AbstractC0598e;
import kotlin.collections.j;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends AbstractC0598e implements EnumEntries, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0022d f1369a;
    public volatile Enum[] b;

    public a(C0022d c0022d) {
        this.f1369a = c0022d;
    }

    private final Object writeReplace() {
        return new b(b());
    }

    @Override // kotlin.collections.AbstractC0594a
    public final int a() {
        return b().length;
    }

    public final Enum[] b() {
        Enum[] enumArr = this.b;
        if (enumArr != null) {
            return enumArr;
        }
        Enum[] enumArr2 = (Enum[]) this.f1369a.b;
        this.b = enumArr2;
        return enumArr2;
    }

    @Override // kotlin.collections.AbstractC0594a, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum element = (Enum) obj;
        h.f(element, "element");
        return ((Enum) j.D(element.ordinal(), b())) == element;
    }

    @Override // java.util.List
    public final Object get(int i) {
        Enum[] enumArrB = b();
        int length = enumArrB.length;
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException(androidx.constraintlayout.core.motion.a.n("index: ", i, ", size: ", length));
        }
        return enumArrB[i];
    }

    @Override // kotlin.collections.AbstractC0598e, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum element = (Enum) obj;
        h.f(element, "element");
        int iOrdinal = element.ordinal();
        if (((Enum) j.D(iOrdinal, b())) == element) {
            return iOrdinal;
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractC0598e, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum element = (Enum) obj;
        h.f(element, "element");
        return indexOf(element);
    }
}
