package com.google.common.base;

import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class l implements Splitter$Strategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2775a;

    public void a(StringBuilder sb, Iterator it) {
        try {
            if (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                sb.append(next instanceof CharSequence ? (CharSequence) next : next.toString());
                while (it.hasNext()) {
                    sb.append((CharSequence) this.f2775a);
                    Object next2 = it.next();
                    next2.getClass();
                    sb.append(next2 instanceof CharSequence ? (CharSequence) next2 : next2.toString());
                }
            }
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.common.base.Splitter$Strategy
    public Iterator iterator(n nVar, CharSequence charSequence) {
        return new k(this, nVar, charSequence);
    }
}
