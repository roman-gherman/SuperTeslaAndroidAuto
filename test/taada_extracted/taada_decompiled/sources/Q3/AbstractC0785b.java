package q3;

import java.util.Arrays;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: renamed from: q3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0785b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbstractC0787d[] f4651a;
    public int b;
    public int c;
    public y d;

    public final AbstractC0787d a() {
        AbstractC0787d abstractC0787dB;
        y yVar;
        synchronized (this) {
            try {
                AbstractC0787d[] abstractC0787dArrC = this.f4651a;
                if (abstractC0787dArrC == null) {
                    abstractC0787dArrC = c();
                    this.f4651a = abstractC0787dArrC;
                } else if (this.b >= abstractC0787dArrC.length) {
                    Object[] objArrCopyOf = Arrays.copyOf(abstractC0787dArrC, abstractC0787dArrC.length * 2);
                    kotlin.jvm.internal.h.e(objArrCopyOf, "copyOf(this, newSize)");
                    this.f4651a = (AbstractC0787d[]) objArrCopyOf;
                    abstractC0787dArrC = (AbstractC0787d[]) objArrCopyOf;
                }
                int i = this.c;
                do {
                    abstractC0787dB = abstractC0787dArrC[i];
                    if (abstractC0787dB == null) {
                        abstractC0787dB = b();
                        abstractC0787dArrC[i] = abstractC0787dB;
                    }
                    i++;
                    if (i >= abstractC0787dArrC.length) {
                        i = 0;
                    }
                } while (!abstractC0787dB.a(this));
                this.c = i;
                this.b++;
                yVar = this.d;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (yVar != null) {
            yVar.r(1);
        }
        return abstractC0787dB;
    }

    public abstract AbstractC0787d b();

    public abstract AbstractC0787d[] c();

    public final void d(AbstractC0787d abstractC0787d) {
        y yVar;
        int i;
        Continuation[] continuationArrB;
        synchronized (this) {
            try {
                int i3 = this.b - 1;
                this.b = i3;
                yVar = this.d;
                if (i3 == 0) {
                    this.c = 0;
                }
                kotlin.jvm.internal.h.d(abstractC0787d, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                continuationArrB = abstractC0787d.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (Continuation continuation : continuationArrB) {
            if (continuation != null) {
                continuation.resumeWith(N1.m.f1129a);
            }
        }
        if (yVar != null) {
            yVar.r(-1);
        }
    }

    public final StateFlow getSubscriptionCount() {
        y yVar;
        synchronized (this) {
            yVar = this.d;
            if (yVar == null) {
                yVar = new y(this.b);
                this.d = yVar;
            }
        }
        return yVar;
    }
}
