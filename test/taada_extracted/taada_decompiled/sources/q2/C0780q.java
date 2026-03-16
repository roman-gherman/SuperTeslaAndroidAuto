package q2;

import java.util.LinkedHashSet;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* JADX INFO: renamed from: q2.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0780q extends N2.q {
    public final /* synthetic */ LinkedHashSet b;

    public C0780q(LinkedHashSet linkedHashSet) {
        this.b = linkedHashSet;
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "fromSuper";
        } else if (i != 2) {
            objArr[0] = "fakeOverride";
        } else {
            objArr[0] = "fromCurrent";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4";
        if (i == 1 || i == 2) {
            objArr[2] = "conflict";
        } else {
            objArr[2] = "addFakeOverride";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // N2.q
    public final void b(CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            a(0);
            throw null;
        }
        N2.o.r(callableMemberDescriptor, null);
        this.b.add(callableMemberDescriptor);
    }

    @Override // N2.q
    public final void d(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
        if (callableMemberDescriptor2 != null) {
            return;
        }
        a(2);
        throw null;
    }
}
