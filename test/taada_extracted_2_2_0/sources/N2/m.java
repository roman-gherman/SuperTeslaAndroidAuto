package N2;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f1140a;
    public final /* synthetic */ CallableMemberDescriptor b;

    public m(q qVar, CallableMemberDescriptor callableMemberDescriptor) {
        this.f1140a = qVar;
        this.b = callableMemberDescriptor;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        CallableMemberDescriptor second = (CallableMemberDescriptor) obj;
        q qVar = this.f1140a;
        CallableMemberDescriptor callableMemberDescriptor = this.b;
        kotlin.jvm.internal.h.f(second, "second");
        qVar.d(callableMemberDescriptor, second);
        return N1.m.f1129a;
    }
}
