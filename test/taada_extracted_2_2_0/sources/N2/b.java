package N2;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.t;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends kotlin.jvm.internal.i implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1132a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i, Object obj, Object obj2) {
        super(2);
        this.f1132a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        switch (this.f1132a) {
            case 0:
                return Boolean.valueOf(kotlin.jvm.internal.h.a((DeclarationDescriptor) obj, (CallableDescriptor) this.b) && kotlin.jvm.internal.h.a((DeclarationDescriptor) obj2, (CallableDescriptor) this.c));
            default:
                CoroutineContext.Element element = (CoroutineContext.Element) obj2;
                kotlin.jvm.internal.h.f((N1.m) obj, "<anonymous parameter 0>");
                kotlin.jvm.internal.h.f(element, "element");
                t tVar = (t) this.c;
                int i = tVar.f3815a;
                tVar.f3815a = i + 1;
                ((CoroutineContext[]) this.b)[i] = element;
                return N1.m.f1129a;
        }
    }
}
