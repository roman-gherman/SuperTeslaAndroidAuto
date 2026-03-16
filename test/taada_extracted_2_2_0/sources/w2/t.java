package w2;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import n2.AbstractC0713e;
import n2.C0712d;
import r2.C0794a;
import r2.C0795b;
import r2.C0796c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0712d f5022a;
    public static final C0712d b;
    public static final C0712d c;
    public static final HashMap d;

    static {
        C0794a c0794a = C0794a.c;
        C0712d c0712d = new C0712d(c0794a, 9);
        f5022a = c0712d;
        C0796c c0796c = C0796c.c;
        C0712d c0712d2 = new C0712d(c0796c, 10);
        b = c0712d2;
        C0795b c0795b = C0795b.c;
        C0712d c0712d3 = new C0712d(c0795b, 11);
        c = c0712d3;
        HashMap map = new HashMap();
        d = map;
        map.put(c0794a, c0712d);
        map.put(c0796c, c0712d2);
        map.put(c0795b, c0712d3);
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 5 || i == 6) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = TypedValues.TransitionType.S_FROM;
                break;
            case 2:
                objArr[0] = "first";
                break;
            case 3:
                objArr[0] = "second";
                break;
            case 4:
                objArr[0] = "visibility";
                break;
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
                break;
            default:
                objArr[0] = "what";
                break;
        }
        if (i == 5 || i == 6) {
            objArr[1] = "toDescriptorVisibility";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        }
        if (i == 2 || i == 3) {
            objArr[2] = "areInSamePackage";
        } else if (i == 4) {
            objArr[2] = "toDescriptorVisibility";
        } else if (i != 5 && i != 6) {
            objArr[2] = "isVisibleForProtectedAndPackage";
        }
        String str2 = String.format(str, objArr);
        if (i != 5 && i != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static boolean b(n2.v vVar, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(1);
            throw null;
        }
        int i = N2.f.f1135a;
        if (c(declarationDescriptorWithVisibility instanceof CallableMemberDescriptor ? N2.f.t((CallableMemberDescriptor) declarationDescriptorWithVisibility) : declarationDescriptorWithVisibility, declarationDescriptor)) {
            return true;
        }
        return AbstractC0713e.c.a(vVar, declarationDescriptorWithVisibility, declarationDescriptor);
    }

    public static boolean c(DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptorWithVisibility == null) {
            a(2);
            throw null;
        }
        if (declarationDescriptor == null) {
            a(3);
            throw null;
        }
        PackageFragmentDescriptor packageFragmentDescriptor = (PackageFragmentDescriptor) N2.f.i(declarationDescriptorWithVisibility, PackageFragmentDescriptor.class, false);
        PackageFragmentDescriptor packageFragmentDescriptor2 = (PackageFragmentDescriptor) N2.f.i(declarationDescriptor, PackageFragmentDescriptor.class, false);
        return (packageFragmentDescriptor2 == null || packageFragmentDescriptor == null || !packageFragmentDescriptor.getFqName().equals(packageFragmentDescriptor2.getFqName())) ? false : true;
    }
}
