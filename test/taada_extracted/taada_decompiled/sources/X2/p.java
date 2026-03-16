package X2;

import G2.C0111k;
import G2.EnumC0110j;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends r {
    public final C0111k d;
    public final p e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final L2.b f1445f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final EnumC0110j f1446g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f1447h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(C0111k classProto, NameResolver nameResolver, I2.f fVar, SourceElement sourceElement, p pVar) {
        super(nameResolver, fVar, sourceElement);
        kotlin.jvm.internal.h.f(classProto, "classProto");
        kotlin.jvm.internal.h.f(nameResolver, "nameResolver");
        this.d = classProto;
        this.e = pVar;
        this.f1445f = kotlin.reflect.l.w(nameResolver, classProto.e);
        EnumC0110j enumC0110j = (EnumC0110j) I2.e.f774f.c(classProto.d);
        this.f1446g = enumC0110j == null ? EnumC0110j.CLASS : enumC0110j;
        this.f1447h = I2.e.f775g.c(classProto.d).booleanValue();
    }

    @Override // X2.r
    public final L2.c a() {
        return this.f1445f.b();
    }
}
