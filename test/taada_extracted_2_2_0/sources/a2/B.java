package A2;

import com.google.android.datatransport.Transport;
import com.google.android.gms.internal.play_billing.AbstractC0289j0;
import com.google.android.gms.internal.play_billing.a2;
import io.ktor.http.Parameters;
import io.ktor.http.ParametersBuilder;
import io.ktor.util.StringValues;
import io.ktor.utils.io.Z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k.C0568a;
import u1.AbstractC0837b;

/* JADX INFO: loaded from: classes2.dex */
public final class B implements ParametersBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5a;
    public boolean b;
    public Object c;

    public /* synthetic */ B() {
        this.f5a = 3;
    }

    public void a(a2 a2Var) {
        if (this.b) {
            AbstractC0289j0.f("BillingLogger", "Skipping logging since initialization failed.");
            return;
        }
        try {
            ((Transport) this.c).send(new C0568a(a2Var));
        } catch (Throwable unused) {
            AbstractC0289j0.f("BillingLogger", "logging failed.");
        }
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void append(String name, String value) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(value, "value");
        ((u1.w) this.c).append(AbstractC0837b.f(name, false), AbstractC0837b.f(value, true));
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void appendAll(StringValues stringValues) {
        kotlin.jvm.internal.h.f(stringValues, "stringValues");
        k1.j.b((u1.w) this.c, stringValues);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void appendMissing(StringValues stringValues) {
        kotlin.jvm.internal.h.f(stringValues, "stringValues");
        u1.w wVarA = Z.a();
        k1.j.b(wVarA, stringValues);
        ((u1.w) this.c).appendMissing(wVarA.build());
    }

    @Override // io.ktor.http.ParametersBuilder, io.ktor.util.StringValuesBuilder
    public Parameters build() {
        return k1.j.g((u1.w) this.c);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void clear() {
        ((u1.w) this.c).clear();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean contains(String name) {
        kotlin.jvm.internal.h.f(name, "name");
        return ((u1.w) this.c).contains(AbstractC0837b.f(name, false));
    }

    @Override // io.ktor.util.StringValuesBuilder
    public Set entries() {
        return ((z1.n) k1.j.g((u1.w) this.c)).entries();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public String get(String name) {
        kotlin.jvm.internal.h.f(name, "name");
        String str = ((u1.w) this.c).get(AbstractC0837b.f(name, false));
        if (str != null) {
            return AbstractC0837b.e(str, 0, 0, 11);
        }
        return null;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public List getAll(String name) {
        kotlin.jvm.internal.h.f(name, "name");
        List all = ((u1.w) this.c).getAll(AbstractC0837b.f(name, false));
        if (all == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(all));
        Iterator it = all.iterator();
        while (it.hasNext()) {
            arrayList.add(AbstractC0837b.e((String) it.next(), 0, 0, 11));
        }
        return arrayList;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean getCaseInsensitiveName() {
        return this.b;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean isEmpty() {
        return ((Map) ((u1.w) this.c).f4280a).isEmpty();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public Set names() {
        Set setKeySet = ((Map) ((u1.w) this.c).f4280a).keySet();
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(setKeySet));
        Iterator it = setKeySet.iterator();
        while (it.hasNext()) {
            arrayList.add(AbstractC0837b.e((String) it.next(), 0, 0, 15));
        }
        return kotlin.collections.m.s0(arrayList);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void remove(String name) {
        kotlin.jvm.internal.h.f(name, "name");
        ((u1.w) this.c).remove(AbstractC0837b.f(name, false));
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void removeKeysWithNoEntries() {
        ((u1.w) this.c).removeKeysWithNoEntries();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void set(String name, String value) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(value, "value");
        ((u1.w) this.c).set(AbstractC0837b.f(name, false), AbstractC0837b.f(value, true));
    }

    public String toString() {
        switch (this.f5a) {
            case 2:
                return this.b ? "FALL_THROUGH" : String.valueOf(this.c);
            default:
                return super.toString();
        }
    }

    public /* synthetic */ B(Object obj, int i, boolean z6) {
        this.f5a = i;
        this.c = obj;
        this.b = z6;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void appendAll(String name, Iterable values) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(values, "values");
        String strF = AbstractC0837b.f(name, false);
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(values));
        Iterator it = values.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            kotlin.jvm.internal.h.f(str, "<this>");
            arrayList.add(AbstractC0837b.f(str, true));
        }
        ((u1.w) this.c).appendAll(strF, arrayList);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public StringValues build() {
        return k1.j.g((u1.w) this.c);
    }

    public B(u1.w encodedParametersBuilder) {
        this.f5a = 4;
        kotlin.jvm.internal.h.f(encodedParametersBuilder, "encodedParametersBuilder");
        this.c = encodedParametersBuilder;
        this.b = true;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean contains(String name, String value) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(value, "value");
        return ((u1.w) this.c).contains(AbstractC0837b.f(name, false), AbstractC0837b.f(value, true));
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean remove(String name, String value) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(value, "value");
        return ((u1.w) this.c).remove(AbstractC0837b.f(name, false), AbstractC0837b.f(value, true));
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void appendMissing(String name, Iterable values) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(values, "values");
        String strF = AbstractC0837b.f(name, false);
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(values));
        Iterator it = values.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            kotlin.jvm.internal.h.f(str, "<this>");
            arrayList.add(AbstractC0837b.f(str, true));
        }
        ((u1.w) this.c).appendMissing(strF, arrayList);
    }
}
