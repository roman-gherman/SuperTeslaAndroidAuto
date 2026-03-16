package N2;

import a3.AbstractC0162z;
import a3.F;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import n2.C0717i;
import n2.C0721m;
import n2.z;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {
    static {
        L2.b.j(new L2.c("kotlin.jvm.JvmInline"));
    }

    public static final boolean a(CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.jvm.internal.h.f(callableMemberDescriptor, "<this>");
        if (!(callableMemberDescriptor instanceof PropertyGetterDescriptor)) {
            return false;
        }
        PropertyDescriptor correspondingProperty = ((PropertyGetterDescriptor) callableMemberDescriptor).getCorrespondingProperty();
        kotlin.jvm.internal.h.e(correspondingProperty, "correspondingProperty");
        return d(correspondingProperty);
    }

    public static final boolean b(DeclarationDescriptor declarationDescriptor) {
        kotlin.jvm.internal.h.f(declarationDescriptor, "<this>");
        return (declarationDescriptor instanceof ClassDescriptor) && (((ClassDescriptor) declarationDescriptor).getValueClassRepresentation() instanceof C0717i);
    }

    public static final boolean c(AbstractC0162z abstractC0162z) {
        kotlin.jvm.internal.h.f(abstractC0162z, "<this>");
        ClassifierDescriptor declarationDescriptor = abstractC0162z.c().getDeclarationDescriptor();
        if (declarationDescriptor != null) {
            return b(declarationDescriptor);
        }
        return false;
    }

    public static final boolean d(VariableDescriptor variableDescriptor) {
        if (variableDescriptor.getExtensionReceiverParameter() != null) {
            return false;
        }
        DeclarationDescriptor containingDeclaration = variableDescriptor.getContainingDeclaration();
        L2.f fVar = null;
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor != null) {
            int i = R2.e.f1273a;
            z valueClassRepresentation = classDescriptor.getValueClassRepresentation();
            C0717i c0717i = valueClassRepresentation instanceof C0717i ? (C0717i) valueClassRepresentation : null;
            if (c0717i != null) {
                fVar = c0717i.f4246a;
            }
        }
        return kotlin.jvm.internal.h.a(fVar, variableDescriptor.getName());
    }

    public static final boolean e(DeclarationDescriptor declarationDescriptor) {
        if (b(declarationDescriptor)) {
            return true;
        }
        return (declarationDescriptor instanceof ClassDescriptor) && (((ClassDescriptor) declarationDescriptor).getValueClassRepresentation() instanceof C0721m);
    }

    public static final F f(AbstractC0162z abstractC0162z) {
        kotlin.jvm.internal.h.f(abstractC0162z, "<this>");
        ClassifierDescriptor declarationDescriptor = abstractC0162z.c().getDeclarationDescriptor();
        ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
        if (classDescriptor != null) {
            int i = R2.e.f1273a;
            z valueClassRepresentation = classDescriptor.getValueClassRepresentation();
            C0717i c0717i = valueClassRepresentation instanceof C0717i ? (C0717i) valueClassRepresentation : null;
            if (c0717i != null) {
                return (F) c0717i.b;
            }
        }
        return null;
    }
}
