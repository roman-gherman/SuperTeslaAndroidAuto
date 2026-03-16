package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.o;
import com.google.android.datatransport.runtime.u;

/* JADX INFO: loaded from: classes.dex */
public final class b extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1897a;
    public final u b;
    public final o c;

    public b(long j6, u uVar, o oVar) {
        this.f1897a = j6;
        if (uVar == null) {
            throw new NullPointerException("Null transportContext");
        }
        this.b = uVar;
        this.c = oVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.f1897a == ((b) dVar).f1897a) {
                b bVar = (b) dVar;
                if (this.b.equals(bVar.b) && this.c.equals(bVar.c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        long j6 = this.f1897a;
        return ((((((int) ((j6 >>> 32) ^ j6)) ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode();
    }

    public final String toString() {
        return "PersistedEvent{id=" + this.f1897a + ", transportContext=" + this.b + ", event=" + this.c + "}";
    }
}
