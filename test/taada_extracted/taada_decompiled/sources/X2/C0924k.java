package x2;

import a3.AbstractC0162z;
import java.util.Collections;
import java.util.List;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: renamed from: x2.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0924k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0162z f5123a;
    public final AbstractC0162z b;
    public final List c;
    public final List d;
    public final List e;

    public C0924k(AbstractC0162z abstractC0162z, AbstractC0162z abstractC0162z2, List list, List list2) {
        List list3 = Collections.EMPTY_LIST;
        if (abstractC0162z == null) {
            a(0);
            throw null;
        }
        if (list == null) {
            a(1);
            throw null;
        }
        if (list2 == null) {
            a(2);
            throw null;
        }
        if (list3 == null) {
            a(3);
            throw null;
        }
        this.f5123a = abstractC0162z;
        this.b = abstractC0162z2;
        this.c = list;
        this.d = list2;
        this.e = list3;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 4 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5 || i == 6 || i == 7) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "valueParameters";
                break;
            case 2:
                objArr[0] = "typeParameters";
                break;
            case 3:
                objArr[0] = "signatureErrors";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
                break;
            default:
                objArr[0] = "returnType";
                break;
        }
        if (i == 4) {
            objArr[1] = "getReturnType";
        } else if (i == 5) {
            objArr[1] = "getValueParameters";
        } else if (i == 6) {
            objArr[1] = "getTypeParameters";
        } else if (i != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
        } else {
            objArr[1] = "getErrors";
        }
        if (i != 4 && i != 5 && i != 6 && i != 7) {
            objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 5 && i != 6 && i != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }
}
