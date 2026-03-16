package c3;

import a3.AbstractC0162z;
import a3.F;
import a3.M;
import a3.c0;
import java.util.Arrays;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends F {
    public final TypeConstructor b;
    public final f c;
    public final i d;
    public final List e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f1750f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String[] f1751g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f1752h;

    public g(TypeConstructor typeConstructor, f fVar, i kind, List arguments, boolean z6, String... formatParams) {
        kotlin.jvm.internal.h.f(kind, "kind");
        kotlin.jvm.internal.h.f(arguments, "arguments");
        kotlin.jvm.internal.h.f(formatParams, "formatParams");
        this.b = typeConstructor;
        this.c = fVar;
        this.d = kind;
        this.e = arguments;
        this.f1750f = z6;
        this.f1751g = formatParams;
        Object[] objArrCopyOf = Arrays.copyOf(formatParams, formatParams.length);
        this.f1752h = String.format(kind.f1774a, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
    }

    @Override // a3.AbstractC0162z
    public final List a() {
        return this.e;
    }

    @Override // a3.AbstractC0162z
    public final M b() {
        M.b.getClass();
        return M.c;
    }

    @Override // a3.AbstractC0162z
    public final TypeConstructor c() {
        return this.b;
    }

    @Override // a3.AbstractC0162z
    public final boolean d() {
        return this.f1750f;
    }

    @Override // a3.AbstractC0162z
    /* JADX INFO: renamed from: e */
    public final AbstractC0162z h(b3.d kotlinTypeRefiner) {
        kotlin.jvm.internal.h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // a3.AbstractC0162z
    public final MemberScope getMemberScope() {
        return this.c;
    }

    @Override // a3.c0
    public final c0 h(b3.d kotlinTypeRefiner) {
        kotlin.jvm.internal.h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // a3.F, a3.c0
    public final c0 i(M newAttributes) {
        kotlin.jvm.internal.h.f(newAttributes, "newAttributes");
        return this;
    }

    @Override // a3.F
    /* JADX INFO: renamed from: j */
    public final F g(boolean z6) {
        String[] strArr = this.f1751g;
        return new g(this.b, this.c, this.d, this.e, z6, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Override // a3.F
    /* JADX INFO: renamed from: k */
    public final F i(M newAttributes) {
        kotlin.jvm.internal.h.f(newAttributes, "newAttributes");
        return this;
    }
}
