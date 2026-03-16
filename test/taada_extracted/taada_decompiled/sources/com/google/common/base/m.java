package com.google.common.base;

import java.util.Iterator;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes.dex */
public final class m implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2776a;
    public final /* synthetic */ n b;

    public m(n nVar, String str) {
        this.b = nVar;
        this.f2776a = str;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        n nVar = this.b;
        return nVar.b.iterator(nVar, this.f2776a);
    }

    public final String toString() {
        l lVar = new l(", ");
        StringBuilder sb = new StringBuilder();
        sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
        lVar.a(sb, iterator());
        sb.append(']');
        return sb.toString();
    }
}
