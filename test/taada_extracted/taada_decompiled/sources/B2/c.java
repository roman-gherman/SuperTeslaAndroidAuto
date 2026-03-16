package B2;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.i;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f123a;
    public final /* synthetic */ TypeParameterDescriptor b;
    public final /* synthetic */ a c;
    public final /* synthetic */ TypeConstructor d;
    public final /* synthetic */ JavaClassifierType e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, TypeParameterDescriptor typeParameterDescriptor, a aVar, TypeConstructor typeConstructor, JavaClassifierType javaClassifierType) {
        super(0);
        this.f123a = dVar;
        this.b = typeParameterDescriptor;
        this.c = aVar;
        this.d = typeConstructor;
        this.e = javaClassifierType;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        B.h hVar = (B.h) this.f123a.d;
        ClassifierDescriptor declarationDescriptor = this.d.getDeclarationDescriptor();
        return hVar.i(this.b, a.a(a.a(this.c, 0, false, null, declarationDescriptor != null ? declarationDescriptor.getDefaultType() : null, 31), 0, this.e.isRaw(), null, null, 59));
    }
}
