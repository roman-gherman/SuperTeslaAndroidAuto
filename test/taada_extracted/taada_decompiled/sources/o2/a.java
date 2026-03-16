package O2;

import a3.AbstractC0162z;
import a3.F;
import a3.M;
import a3.c0;
import b3.d;
import c3.j;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import net.bytebuddy.description.type.TypeDescription;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends F implements CapturedTypeMarker {
    public final TypeProjection b;
    public final b c;
    public final boolean d;
    public final M e;

    public a(TypeProjection typeProjection, b bVar, boolean z6, M attributes) {
        h.f(typeProjection, "typeProjection");
        h.f(attributes, "attributes");
        this.b = typeProjection;
        this.c = bVar;
        this.d = z6;
        this.e = attributes;
    }

    @Override // a3.AbstractC0162z
    public final List a() {
        return u.f3804a;
    }

    @Override // a3.AbstractC0162z
    public final M b() {
        return this.e;
    }

    @Override // a3.AbstractC0162z
    public final TypeConstructor c() {
        return this.c;
    }

    @Override // a3.AbstractC0162z
    public final boolean d() {
        return this.d;
    }

    @Override // a3.AbstractC0162z
    public final AbstractC0162z e(d kotlinTypeRefiner) {
        h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        TypeProjection typeProjectionRefine = this.b.refine(kotlinTypeRefiner);
        h.e(typeProjectionRefine, "typeProjection.refine(kotlinTypeRefiner)");
        return new a(typeProjectionRefine, this.c, this.d, this.e);
    }

    @Override // a3.F, a3.c0
    public final c0 g(boolean z6) {
        if (z6 == this.d) {
            return this;
        }
        return new a(this.b, this.c, z6, this.e);
    }

    @Override // a3.AbstractC0162z
    public final MemberScope getMemberScope() {
        return j.a(1, true, new String[0]);
    }

    @Override // a3.c0
    /* JADX INFO: renamed from: h */
    public final c0 e(d kotlinTypeRefiner) {
        h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        TypeProjection typeProjectionRefine = this.b.refine(kotlinTypeRefiner);
        h.e(typeProjectionRefine, "typeProjection.refine(kotlinTypeRefiner)");
        return new a(typeProjectionRefine, this.c, this.d, this.e);
    }

    @Override // a3.F
    /* JADX INFO: renamed from: j */
    public final F g(boolean z6) {
        if (z6 == this.d) {
            return this;
        }
        return new a(this.b, this.c, z6, this.e);
    }

    @Override // a3.F
    /* JADX INFO: renamed from: k */
    public final F i(M newAttributes) {
        h.f(newAttributes, "newAttributes");
        return new a(this.b, this.c, this.d, newAttributes);
    }

    @Override // a3.F
    public final String toString() {
        StringBuilder sb = new StringBuilder("Captured(");
        sb.append(this.b);
        sb.append(')');
        sb.append(this.d ? TypeDescription.Generic.OfWildcardType.SYMBOL : "");
        return sb.toString();
    }
}
