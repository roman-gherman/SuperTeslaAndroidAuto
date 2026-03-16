package a3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import net.bytebuddy.description.method.MethodDescription;
import q2.AbstractC0762A;

/* JADX INFO: renamed from: a3.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0150m extends AbstractC0139b {
    public final AbstractC0762A c;
    public final List d;
    public final Collection e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0150m(AbstractC0762A abstractC0762A, List list, Collection collection, StorageManager storageManager) {
        super(storageManager);
        if (list == null) {
            i(1);
            throw null;
        }
        if (collection == null) {
            i(2);
            throw null;
        }
        if (storageManager == null) {
            i(3);
            throw null;
        }
        this.c = abstractC0762A;
        this.d = Collections.unmodifiableList(new ArrayList(list));
        this.e = Collections.unmodifiableCollection(collection);
    }

    public static /* synthetic */ void i(int i) {
        String str = (i == 4 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5 || i == 6 || i == 7) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "parameters";
                break;
            case 2:
                objArr[0] = "supertypes";
                break;
            case 3:
                objArr[0] = "storageManager";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
                break;
            default:
                objArr[0] = "classDescriptor";
                break;
        }
        if (i == 4) {
            objArr[1] = "getParameters";
        } else if (i == 5) {
            objArr[1] = "getDeclarationDescriptor";
        } else if (i == 6) {
            objArr[1] = "computeSupertypes";
        } else if (i != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
        } else {
            objArr[1] = "getSupertypeLoopChecker";
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

    @Override // a3.AbstractC0147j
    public final Collection a() {
        Collection collection = this.e;
        if (collection != null) {
            return collection;
        }
        i(6);
        throw null;
    }

    @Override // a3.AbstractC0147j
    public final SupertypeLoopChecker d() {
        return n2.v.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final List getParameters() {
        List list = this.d;
        if (list != null) {
            return list;
        }
        i(4);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final boolean isDenotable() {
        return true;
    }

    @Override // a3.AbstractC0139b
    /* JADX INFO: renamed from: j */
    public final ClassDescriptor getDeclarationDescriptor() {
        AbstractC0762A abstractC0762A = this.c;
        if (abstractC0762A != null) {
            return abstractC0762A;
        }
        i(5);
        throw null;
    }

    public final String toString() {
        String str = N2.f.g(this.c).f961a;
        if (str != null) {
            return str;
        }
        L2.e.a(4);
        throw null;
    }
}
