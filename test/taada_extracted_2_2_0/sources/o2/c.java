package O2;

import a3.AbstractC0162z;
import a3.W;
import a3.d0;
import c4.AbstractC0246d;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends W {
    public final /* synthetic */ int b;
    public final W c;

    public /* synthetic */ c(W w5, int i) {
        this.b = i;
        this.c = w5;
    }

    @Override // a3.W
    public boolean a() {
        switch (this.b) {
            case 0:
                return this.c.a();
            default:
                return super.a();
        }
    }

    @Override // a3.W
    public boolean b() {
        switch (this.b) {
            case 0:
                return true;
            default:
                return super.b();
        }
    }

    @Override // a3.W
    public final Annotations c(Annotations annotations) {
        switch (this.b) {
            case 0:
                h.f(annotations, "annotations");
                break;
            default:
                h.f(annotations, "annotations");
                break;
        }
        return this.c.c(annotations);
    }

    @Override // a3.W
    public final TypeProjection d(AbstractC0162z abstractC0162z) {
        switch (this.b) {
            case 0:
                TypeProjection typeProjectionD = this.c.d(abstractC0162z);
                if (typeProjectionD == null) {
                    return null;
                }
                ClassifierDescriptor declarationDescriptor = abstractC0162z.c().getDeclarationDescriptor();
                return AbstractC0246d.v(typeProjectionD, declarationDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) declarationDescriptor : null);
            default:
                return this.c.d(abstractC0162z);
        }
    }

    @Override // a3.W
    public final boolean e() {
        switch (this.b) {
        }
        return this.c.e();
    }

    @Override // a3.W
    public final AbstractC0162z f(AbstractC0162z topLevelType, d0 position) {
        switch (this.b) {
            case 0:
                h.f(topLevelType, "topLevelType");
                h.f(position, "position");
                break;
            default:
                h.f(topLevelType, "topLevelType");
                h.f(position, "position");
                break;
        }
        return this.c.f(topLevelType, position);
    }
}
