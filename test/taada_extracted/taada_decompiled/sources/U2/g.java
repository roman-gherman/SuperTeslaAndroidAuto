package U2;

import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends N2.q {
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ h c;

    public g(ArrayList arrayList, h hVar) {
        this.b = arrayList;
        this.c = hVar;
    }

    @Override // N2.q
    public final void b(CallableMemberDescriptor fakeOverride) {
        kotlin.jvm.internal.h.f(fakeOverride, "fakeOverride");
        N2.o.r(fakeOverride, null);
        this.b.add(fakeOverride);
    }

    @Override // N2.q
    public final void d(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor fromCurrent) {
        kotlin.jvm.internal.h.f(fromCurrent, "fromCurrent");
        throw new IllegalStateException(("Conflict in scope of " + this.c.f1333a + ": " + callableMemberDescriptor + " vs " + fromCurrent).toString());
    }
}
