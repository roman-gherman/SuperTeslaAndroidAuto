package k2;

import a3.F;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import q2.AbstractC0765b;
import q2.C0763B;
import q2.C0764a;
import v2.EnumC0851b;
import x2.C0914a;

/* JADX INFO: renamed from: k2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0587f implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3707a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C0587f(Object obj, int i) {
        this.f3707a = i;
        this.b = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f3707a) {
            case 0:
                L2.f fVar = (L2.f) obj;
                C0763B c0763bK = ((i) this.b).k();
                L2.c cVar = p.f3768k;
                MemberScope memberScope = c0763bK.getPackage(cVar).getMemberScope();
                if (memberScope == null) {
                    i.a(11);
                    throw null;
                }
                ClassifierDescriptor contributedClassifier = memberScope.getContributedClassifier(fVar, EnumC0851b.f4934a);
                if (contributedClassifier == null) {
                    throw new AssertionError("Built-in class " + cVar.c(fVar) + " is not found");
                }
                if (contributedClassifier instanceof ClassDescriptor) {
                    return (ClassDescriptor) contributedClassifier;
                }
                throw new AssertionError("Must be a class descriptor " + fVar + ", but was " + contributedClassifier);
            case 1:
                C0764a c0764a = (C0764a) this.b;
                ((b3.c) ((b3.d) obj)).getClass();
                AbstractC0765b descriptor = c0764a.b;
                kotlin.jvm.internal.h.f(descriptor, "descriptor");
                return (F) descriptor.b.invoke();
            default:
                CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) obj;
                if (callableMemberDescriptor == null) {
                    throw new IllegalArgumentException("Argument for @NotNull parameter 'descriptor' of kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1$1.invoke must not be null");
                }
                ((C0914a) this.b).b.reportCannotInferVisibility(callableMemberDescriptor);
                return N1.m.f1129a;
        }
    }
}
