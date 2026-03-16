package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class H implements zzdf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f2030a;
    public boolean b;
    public Object c;

    public H(Iterator it) {
        it.getClass();
        this.f2030a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b || this.f2030a.hasNext();
    }

    @Override // com.google.android.gms.internal.play_billing.zzdf, java.util.Iterator
    public final Object next() {
        if (!this.b) {
            return this.f2030a.next();
        }
        Object obj = this.c;
        this.b = false;
        this.c = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.b) {
            throw new IllegalStateException("Can't remove after you've peeked at next");
        }
        this.f2030a.remove();
    }

    @Override // com.google.android.gms.internal.play_billing.zzdf
    public final Object zza() {
        if (!this.b) {
            this.c = this.f2030a.next();
            this.b = true;
        }
        return this.c;
    }
}
