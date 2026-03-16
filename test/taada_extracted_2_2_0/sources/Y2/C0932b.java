package y2;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import n2.EnumC0709a;

/* JADX INFO: renamed from: y2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0932b extends f {
    public final SimpleFunctionDescriptor C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final SimpleFunctionDescriptor f5138D;
    public final PropertyDescriptor E;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0932b(ClassDescriptor ownerDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor2, PropertyDescriptor propertyDescriptor) {
        super(ownerDescriptor, o2.f.b, simpleFunctionDescriptor.getModality(), simpleFunctionDescriptor.getVisibility(), simpleFunctionDescriptor2 != null, propertyDescriptor.getName(), simpleFunctionDescriptor.getSource(), null, EnumC0709a.f4227a, false, null);
        h.f(ownerDescriptor, "ownerDescriptor");
        Annotations.Companion.getClass();
        this.C = simpleFunctionDescriptor;
        this.f5138D = simpleFunctionDescriptor2;
        this.E = propertyDescriptor;
    }
}
