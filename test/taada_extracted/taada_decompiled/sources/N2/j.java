package N2;

import java.util.Comparator;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements Comparator {
    public static final j b = new j(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1138a;

    public /* synthetic */ j(int i) {
        this.f1138a = i;
    }

    public static int a(DeclarationDescriptor declarationDescriptor) {
        if (f.m(declarationDescriptor)) {
            return 8;
        }
        if (declarationDescriptor instanceof ConstructorDescriptor) {
            return 7;
        }
        if (declarationDescriptor instanceof PropertyDescriptor) {
            return ((PropertyDescriptor) declarationDescriptor).getExtensionReceiverParameter() == null ? 6 : 5;
        }
        if (declarationDescriptor instanceof FunctionDescriptor) {
            return ((FunctionDescriptor) declarationDescriptor).getExtensionReceiverParameter() == null ? 4 : 3;
        }
        if (declarationDescriptor instanceof ClassDescriptor) {
            return 2;
        }
        return declarationDescriptor instanceof TypeAliasDescriptor ? 1 : 0;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Integer numValueOf;
        switch (this.f1138a) {
            case 0:
                DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor) obj;
                DeclarationDescriptor declarationDescriptor2 = (DeclarationDescriptor) obj2;
                int iA = a(declarationDescriptor2) - a(declarationDescriptor);
                if (iA != 0) {
                    numValueOf = Integer.valueOf(iA);
                } else if (f.m(declarationDescriptor) && f.m(declarationDescriptor2)) {
                    numValueOf = 0;
                } else {
                    int iCompareTo = declarationDescriptor.getName().f962a.compareTo(declarationDescriptor2.getName().f962a);
                    numValueOf = iCompareTo != 0 ? Integer.valueOf(iCompareTo) : null;
                }
                if (numValueOf != null) {
                    return numValueOf.intValue();
                }
                return 0;
            default:
                return E1.k.n(R2.e.g((ClassDescriptor) obj).b(), R2.e.g((ClassDescriptor) obj2).b());
        }
    }
}
