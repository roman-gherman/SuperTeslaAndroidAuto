package I2;

import androidx.core.os.EnvironmentCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.C0597d;
import kotlin.collections.j;
import kotlin.collections.k;
import kotlin.collections.m;
import kotlin.collections.u;
import kotlin.jvm.internal.h;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f763a;
    public final int b;
    public final int c;
    public final int d;
    public final List e;

    public a(int... numbers) {
        List listO0;
        h.f(numbers, "numbers");
        this.f763a = numbers;
        Integer numC = j.C(0, numbers);
        this.b = numC != null ? numC.intValue() : -1;
        Integer numC2 = j.C(1, numbers);
        this.c = numC2 != null ? numC2.intValue() : -1;
        Integer numC3 = j.C(2, numbers);
        this.d = numC3 != null ? numC3.intValue() : -1;
        if (numbers.length <= 3) {
            listO0 = u.f3805a;
        } else {
            if (numbers.length > 1024) {
                throw new IllegalArgumentException("BinaryVersion with length more than 1024 are not supported. Provided length " + numbers.length + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
            }
            listO0 = m.o0(new C0597d(new k(numbers), 3, numbers.length));
        }
        this.e = listO0;
    }

    public final boolean a(int i, int i3, int i4) {
        int i5 = this.b;
        if (i5 > i) {
            return true;
        }
        if (i5 < i) {
            return false;
        }
        int i6 = this.c;
        if (i6 > i3) {
            return true;
        }
        return i6 >= i3 && this.d >= i4;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        a aVar = (a) obj;
        return this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && h.a(this.e, aVar.e);
    }

    public final int hashCode() {
        int i = this.b;
        int i3 = (i * 31) + this.c + i;
        int i4 = (i3 * 31) + this.d + i3;
        return this.e.hashCode() + (i4 * 31) + i4;
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        for (int i : this.f763a) {
            if (i == -1) {
                break;
            }
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList.isEmpty() ? EnvironmentCompat.MEDIA_UNKNOWN : m.V(arrayList, ".", null, null, null, 62);
    }
}
