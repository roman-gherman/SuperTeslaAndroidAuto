package k2;

import a3.C;
import a3.M;
import a3.Z;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import m2.C0657i;
import q2.AbstractC0772i;
import q2.C0763B;
import q2.C0770g;
import q2.v;

/* JADX INFO: renamed from: k2.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0588g implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3708a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ C0588g(int i, Object obj, Object obj2) {
        this.f3708a = i;
        this.c = obj;
        this.b = obj2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f3708a) {
            case 0:
                C0657i c0657i = (C0657i) this.c;
                C0763B c0763b = c0657i.f3711a;
                C0763B c0763b2 = (C0763B) this.b;
                if (c0763b == null) {
                    c0657i.f3711a = c0763b2;
                    return null;
                }
                throw new AssertionError("Built-ins module is already set: " + c0657i.f3711a + " (attempting to reset to " + c0763b2 + ")");
            case 1:
                M.b.getClass();
                M m6 = M.c;
                TypeConstructor typeConstructor = ((AbstractC0772i) this.c).getTypeConstructor();
                List list = Collections.EMPTY_LIST;
                C0770g c0770g = new C0770g(this, 0);
                Z2.b NO_LOCKS = Z2.n.e;
                kotlin.jvm.internal.h.e(NO_LOCKS, "NO_LOCKS");
                return C.d(m6, list, new U2.j(NO_LOCKS, c0770g), typeConstructor, false);
            default:
                j3.j jVar = new j3.j();
                Iterator it = ((v) this.c).getOverriddenDescriptors().iterator();
                while (it.hasNext()) {
                    jVar.add(((FunctionDescriptor) it.next()).substitute((Z) this.b));
                }
                return jVar;
        }
    }
}
