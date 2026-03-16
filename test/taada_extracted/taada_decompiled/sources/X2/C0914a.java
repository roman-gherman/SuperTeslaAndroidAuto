package x2;

import N2.o;
import N2.q;
import java.util.Collection;
import java.util.LinkedHashSet;
import k2.C0587f;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import n2.EnumC0709a;

/* JADX INFO: renamed from: x2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0914a extends q {
    public final /* synthetic */ ErrorReporter b;
    public final /* synthetic */ LinkedHashSet c;
    public final /* synthetic */ boolean d;

    public C0914a(ErrorReporter errorReporter, LinkedHashSet linkedHashSet, boolean z6) {
        this.b = errorReporter;
        this.c = linkedHashSet;
        this.d = z6;
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "fromSuper";
        } else if (i == 2) {
            objArr[0] = "fromCurrent";
        } else if (i == 3) {
            objArr[0] = "member";
        } else if (i != 4) {
            objArr[0] = "fakeOverride";
        } else {
            objArr[0] = "overridden";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1";
        if (i == 1 || i == 2) {
            objArr[2] = "conflict";
        } else if (i == 3 || i == 4) {
            objArr[2] = "setOverriddenDescriptors";
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
        o.r(callableMemberDescriptor, new C0587f(this, 2));
        this.c.add(callableMemberDescriptor);
    }

    @Override // N2.q
    public final void d(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
        if (callableMemberDescriptor2 != null) {
            return;
        }
        a(2);
        throw null;
    }

    @Override // N2.q
    public final void p(CallableMemberDescriptor callableMemberDescriptor, Collection collection) {
        if (callableMemberDescriptor == null) {
            a(3);
            throw null;
        }
        if (!this.d || callableMemberDescriptor.getKind() == EnumC0709a.b) {
            callableMemberDescriptor.setOverriddenDescriptors(collection);
        }
    }
}
