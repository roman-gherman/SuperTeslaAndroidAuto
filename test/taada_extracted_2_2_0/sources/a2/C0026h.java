package A2;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import n2.AbstractC0718j;

/* JADX INFO: renamed from: A2.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0026h extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f38a;
    public final /* synthetic */ C0029k b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0026h(C0029k c0029k, int i) {
        super(0);
        this.f38a = i;
        this.b = c0029k;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f38a) {
            case 0:
                return AbstractC0718j.c(this.b);
            case 1:
                C0029k c0029k = this.b;
                List<JavaTypeParameter> typeParameters = c0029k.f40h.getTypeParameters();
                ArrayList arrayList = new ArrayList(kotlin.collections.o.D(typeParameters));
                for (JavaTypeParameter javaTypeParameter : typeParameters) {
                    TypeParameterDescriptor typeParameterDescriptorResolveTypeParameter = c0029k.f41j.b.resolveTypeParameter(javaTypeParameter);
                    if (typeParameterDescriptorResolveTypeParameter == null) {
                        throw new AssertionError("Parameter " + javaTypeParameter + " surely belongs to class " + c0029k.f40h + ", so it must be resolved");
                    }
                    arrayList.add(typeParameterDescriptorResolveTypeParameter);
                }
                return arrayList;
            default:
                C0029k c0029k2 = this.b;
                if (R2.e.f(c0029k2) != null) {
                    c0029k2.f39g.f5204a.f5199w.getClass();
                }
                return null;
        }
    }
}
