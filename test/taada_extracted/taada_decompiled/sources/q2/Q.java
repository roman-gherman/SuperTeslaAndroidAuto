package q2;

import A2.C0022d;
import a.AbstractC0132a;
import a3.AbstractC0162z;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: loaded from: classes2.dex */
public final class Q extends S {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final N1.j f4579l;

    public Q(CallableDescriptor callableDescriptor, ValueParameterDescriptor valueParameterDescriptor, int i, Annotations annotations, L2.f fVar, AbstractC0162z abstractC0162z, boolean z6, boolean z7, boolean z8, AbstractC0162z abstractC0162z2, SourceElement sourceElement, Function0 function0) {
        super(callableDescriptor, valueParameterDescriptor, i, annotations, fVar, abstractC0162z, z6, z7, z8, abstractC0162z2, sourceElement);
        this.f4579l = AbstractC0132a.M(function0);
    }

    @Override // q2.S, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public final ValueParameterDescriptor copy(CallableDescriptor newOwner, L2.f newName, int i) {
        kotlin.jvm.internal.h.f(newOwner, "newOwner");
        kotlin.jvm.internal.h.f(newName, "newName");
        Annotations annotations = getAnnotations();
        kotlin.jvm.internal.h.e(annotations, "annotations");
        AbstractC0162z type = getType();
        kotlin.jvm.internal.h.e(type, "type");
        boolean zDeclaresDefaultValue = declaresDefaultValue();
        SourceElement NO_SOURCE = SourceElement.NO_SOURCE;
        kotlin.jvm.internal.h.e(NO_SOURCE, "NO_SOURCE");
        C0022d c0022d = new C0022d(this, 29);
        return new Q(newOwner, null, i, annotations, newName, type, zDeclaresDefaultValue, this.f4582h, this.i, this.f4583j, NO_SOURCE, c0022d);
    }
}
