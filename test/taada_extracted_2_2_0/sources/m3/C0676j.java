package m3;

import java.util.concurrent.CancellationException;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: m3.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0676j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4133a;
    public final C0671e b;
    public final Function1 c;
    public final Object d;
    public final Throwable e;

    public C0676j(Object obj, C0671e c0671e, Function1 function1, Object obj2, Throwable th) {
        this.f4133a = obj;
        this.b = c0671e;
        this.c = function1;
        this.d = obj2;
        this.e = th;
    }

    public static C0676j a(C0676j c0676j, C0671e c0671e, CancellationException cancellationException, int i) {
        Object obj = c0676j.f4133a;
        if ((i & 2) != 0) {
            c0671e = c0676j.b;
        }
        C0671e c0671e2 = c0671e;
        Function1 function1 = c0676j.c;
        Object obj2 = c0676j.d;
        Throwable th = cancellationException;
        if ((i & 16) != 0) {
            th = c0676j.e;
        }
        c0676j.getClass();
        return new C0676j(obj, c0671e2, function1, obj2, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0676j)) {
            return false;
        }
        C0676j c0676j = (C0676j) obj;
        return kotlin.jvm.internal.h.a(this.f4133a, c0676j.f4133a) && kotlin.jvm.internal.h.a(this.b, c0676j.b) && kotlin.jvm.internal.h.a(this.c, c0676j.c) && kotlin.jvm.internal.h.a(this.d, c0676j.d) && kotlin.jvm.internal.h.a(this.e, c0676j.e);
    }

    public final int hashCode() {
        Object obj = this.f4133a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        C0671e c0671e = this.b;
        int iHashCode2 = (iHashCode + (c0671e == null ? 0 : c0671e.hashCode())) * 31;
        Function1 function1 = this.c;
        int iHashCode3 = (iHashCode2 + (function1 == null ? 0 : function1.hashCode())) * 31;
        Object obj2 = this.d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f4133a + ", cancelHandler=" + this.b + ", onCancellation=" + this.c + ", idempotentResume=" + this.d + ", cancelCause=" + this.e + ')';
    }

    public /* synthetic */ C0676j(Object obj, C0671e c0671e, Function1 function1, Object obj2, CancellationException cancellationException, int i) {
        this(obj, (i & 2) != 0 ? null : c0671e, (i & 4) != 0 ? null : function1, (i & 8) != 0 ? null : obj2, (i & 16) != 0 ? null : cancellationException);
    }
}
