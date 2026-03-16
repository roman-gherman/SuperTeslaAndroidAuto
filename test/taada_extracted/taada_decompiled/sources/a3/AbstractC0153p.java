package a3;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* JADX INFO: renamed from: a3.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0153p extends F {
    @Override // a3.AbstractC0162z
    public final List a() {
        return l().a();
    }

    @Override // a3.AbstractC0162z
    public M b() {
        return l().b();
    }

    @Override // a3.AbstractC0162z
    public final TypeConstructor c() {
        return l().c();
    }

    @Override // a3.AbstractC0162z
    public boolean d() {
        return l().d();
    }

    @Override // a3.AbstractC0162z
    public final MemberScope getMemberScope() {
        return l().getMemberScope();
    }

    public abstract F l();

    @Override // a3.c0
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public F h(b3.d kotlinTypeRefiner) {
        kotlin.jvm.internal.h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        F type = l();
        kotlin.jvm.internal.h.f(type, "type");
        return n(type);
    }

    public abstract AbstractC0153p n(F f6);
}
