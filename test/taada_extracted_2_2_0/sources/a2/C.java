package A2;

import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import v2.EnumC0851b;

/* JADX INFO: loaded from: classes2.dex */
public final class C extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6a;
    public final /* synthetic */ G b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C(G g6, int i) {
        super(0);
        this.f6a = i;
        this.b = g6;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f6a) {
            case 0:
                U2.f kindFilter = U2.f.f1326m;
                MemberScope.Companion.getClass();
                U2.k nameFilter = U2.l.b;
                G g6 = this.b;
                g6.getClass();
                kotlin.jvm.internal.h.f(kindFilter, "kindFilter");
                kotlin.jvm.internal.h.f(nameFilter, "nameFilter");
                EnumC0851b enumC0851b = EnumC0851b.d;
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                if (kindFilter.a(U2.f.f1325l)) {
                    for (L2.f fVar : g6.a(kindFilter, nameFilter)) {
                        nameFilter.invoke(fVar);
                        ClassifierDescriptor contributedClassifier = g6.getContributedClassifier(fVar, enumC0851b);
                        if (contributedClassifier != null) {
                            linkedHashSet.add(contributedClassifier);
                        }
                    }
                }
                boolean zA = kindFilter.a(U2.f.i);
                List list = kindFilter.f1332a;
                if (zA && !list.contains(U2.b.f1317a)) {
                    for (L2.f fVar2 : g6.b(kindFilter, nameFilter)) {
                        nameFilter.invoke(fVar2);
                        linkedHashSet.addAll(g6.getContributedFunctions(fVar2, enumC0851b));
                    }
                }
                if (kindFilter.a(U2.f.f1323j) && !list.contains(U2.b.f1317a)) {
                    for (L2.f fVar3 : g6.h(kindFilter)) {
                        nameFilter.invoke(fVar3);
                        linkedHashSet.addAll(g6.getContributedVariables(fVar3, enumC0851b));
                    }
                }
                return kotlin.collections.m.o0(linkedHashSet);
            case 1:
                return this.b.a(U2.f.f1328o, null);
            case 2:
                return this.b.d();
            case 3:
                return this.b.b(U2.f.f1329p, null);
            default:
                return this.b.h(U2.f.q);
        }
    }
}
