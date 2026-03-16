package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import q2.v;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends N2.q {
    public final /* synthetic */ ArrayList b;

    public d(ArrayList arrayList) {
        this.b = arrayList;
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
        if (fromCurrent instanceof v) {
            ((v) fromCurrent).n(kotlin.reflect.jvm.internal.impl.descriptors.a.f3829a, callableMemberDescriptor);
        }
    }
}
