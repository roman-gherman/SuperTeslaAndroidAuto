package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import a3.AbstractC0147j;
import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3890a;
    public final /* synthetic */ e b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(e eVar, int i) {
        super(0);
        this.f3890a = i;
        this.b = eVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f3890a) {
            case 0:
                U2.f fVar = U2.f.f1326m;
                MemberScope.Companion.getClass();
                return this.b.b(fVar, U2.l.b);
            default:
                e eVar = this.b;
                ((b3.c) eVar.f3891f).getClass();
                g classDescriptor = eVar.i;
                kotlin.jvm.internal.h.f(classDescriptor, "classDescriptor");
                Collection supertypes = ((AbstractC0147j) classDescriptor.getTypeConstructor()).getSupertypes();
                kotlin.jvm.internal.h.e(supertypes, "classDescriptor.typeConstructor.supertypes");
                return supertypes;
        }
    }
}
