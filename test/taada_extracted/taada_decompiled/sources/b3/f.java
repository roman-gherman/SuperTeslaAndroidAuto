package b3;

import a3.F;
import a3.M;
import a3.c0;
import d3.EnumC0418b;
import java.util.List;
import kotlin.collections.u;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends F implements CapturedTypeMarker {
    public final EnumC0418b b;
    public final h c;
    public final c0 d;
    public final M e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f1701f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f1702g;

    public f(EnumC0418b captureStatus, h constructor, c0 c0Var, M attributes, boolean z6, boolean z7) {
        kotlin.jvm.internal.h.f(captureStatus, "captureStatus");
        kotlin.jvm.internal.h.f(constructor, "constructor");
        kotlin.jvm.internal.h.f(attributes, "attributes");
        this.b = captureStatus;
        this.c = constructor;
        this.d = c0Var;
        this.e = attributes;
        this.f1701f = z6;
        this.f1702g = z7;
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
        return this.f1701f;
    }

    @Override // a3.F, a3.c0
    public final c0 g(boolean z6) {
        return new f(this.b, this.c, this.d, this.e, z6, 32);
    }

    @Override // a3.AbstractC0162z
    public final MemberScope getMemberScope() {
        return c3.j.a(1, true, new String[0]);
    }

    @Override // a3.F
    /* JADX INFO: renamed from: j */
    public final F g(boolean z6) {
        return new f(this.b, this.c, this.d, this.e, z6, 32);
    }

    @Override // a3.F
    /* JADX INFO: renamed from: k */
    public final F i(M newAttributes) {
        kotlin.jvm.internal.h.f(newAttributes, "newAttributes");
        return new f(this.b, this.c, this.d, newAttributes, this.f1701f, this.f1702g);
    }

    @Override // a3.c0
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public final f e(d kotlinTypeRefiner) {
        kotlin.jvm.internal.h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        h hVarRefine = this.c.refine(kotlinTypeRefiner);
        c0 c0Var = this.d;
        if (c0Var == null) {
            c0Var = null;
        }
        return new f(this.b, hVarRefine, c0Var, this.e, this.f1701f, 32);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public f(EnumC0418b enumC0418b, h hVar, c0 c0Var, M m6, boolean z6, int i) {
        if ((i & 8) != 0) {
            M.b.getClass();
            m6 = M.c;
        }
        this(enumC0418b, hVar, c0Var, m6, (i & 16) != 0 ? false : z6, false);
    }
}
