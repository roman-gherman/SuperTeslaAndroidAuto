package a3;

import A2.C0022d;
import a.AbstractC0132a;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes2.dex */
public final class K extends U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1533a = 1;
    public final Object b;
    public final Object c;

    public K(AbstractC0162z abstractC0162z, d0 d0Var) {
        if (d0Var == null) {
            a(0);
            throw null;
        }
        if (abstractC0162z == null) {
            a(1);
            throw null;
        }
        this.b = d0Var;
        this.c = abstractC0162z;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5) ? 2 : 3];
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "type";
                break;
            case 4:
            case 5:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
                break;
            case 6:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "projection";
                break;
        }
        if (i == 4) {
            objArr[1] = "getProjectionKind";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        } else {
            objArr[1] = "getType";
        }
        if (i == 3) {
            objArr[2] = "replaceType";
        } else if (i != 4 && i != 5) {
            if (i != 6) {
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
            } else {
                objArr[2] = "refine";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public final d0 getProjectionKind() {
        switch (this.f1533a) {
            case 0:
                return d0.OUT_VARIANCE;
            default:
                d0 d0Var = (d0) this.b;
                if (d0Var != null) {
                    return d0Var;
                }
                a(4);
                throw null;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public final AbstractC0162z getType() {
        switch (this.f1533a) {
            case 0:
                return (AbstractC0162z) this.c.getValue();
            default:
                AbstractC0162z abstractC0162z = (AbstractC0162z) this.c;
                if (abstractC0162z != null) {
                    return abstractC0162z;
                }
                a(5);
                throw null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public final boolean isStarProjection() {
        switch (this.f1533a) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public final TypeProjection refine(b3.d kotlinTypeRefiner) {
        switch (this.f1533a) {
            case 0:
                kotlin.jvm.internal.h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
                return this;
            default:
                if (kotlinTypeRefiner == null) {
                    a(6);
                    throw null;
                }
                ((b3.c) kotlinTypeRefiner).getClass();
                AbstractC0162z type = (AbstractC0162z) this.c;
                kotlin.jvm.internal.h.f(type, "type");
                return new K(type, (d0) this.b);
        }
    }

    public K(TypeParameterDescriptor typeParameter) {
        kotlin.jvm.internal.h.f(typeParameter, "typeParameter");
        this.b = typeParameter;
        this.c = AbstractC0132a.N(2, new C0022d(this, 11));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public K(AbstractC0162z abstractC0162z) {
        this(abstractC0162z, d0.INVARIANT);
        if (abstractC0162z != null) {
        } else {
            a(2);
            throw null;
        }
    }
}
