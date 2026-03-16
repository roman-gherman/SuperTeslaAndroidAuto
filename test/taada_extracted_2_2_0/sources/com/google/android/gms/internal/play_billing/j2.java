package com.google.android.gms.internal.play_billing;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes.dex */
public class j2 implements zzeu {
    public static final boolean d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Logger e = Logger.getLogger(j2.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AbstractC0263a1 f2094f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f2095g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f2096a;
    public volatile C0328w1 b;
    public volatile i2 c;

    static {
        AbstractC0263a1 h2Var;
        try {
            h2Var = new V1(AtomicReferenceFieldUpdater.newUpdater(i2.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(i2.class, i2.class, "b"), AtomicReferenceFieldUpdater.newUpdater(j2.class, i2.class, "c"), AtomicReferenceFieldUpdater.newUpdater(j2.class, C0328w1.class, "b"), AtomicReferenceFieldUpdater.newUpdater(j2.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            h2Var = new h2(10);
        }
        Throwable th2 = th;
        f2094f = h2Var;
        if (th2 != null) {
            e.logp(Level.SEVERE, "com.android.billingclient.util.concurrent.AbstractResolvableFuture", MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME, "SafeAtomicHelper is broken!", th2);
        }
        f2095g = new Object();
    }

    public static void b(j2 j2Var) {
        i2 i2Var;
        C0328w1 c0328w1;
        C0328w1 c0328w12;
        C0328w1 c0328w13;
        do {
            i2Var = j2Var.c;
        } while (!f2094f.z(j2Var, i2Var, i2.c));
        while (true) {
            c0328w1 = null;
            if (i2Var == null) {
                break;
            }
            Thread thread = i2Var.f2090a;
            if (thread != null) {
                i2Var.f2090a = null;
                LockSupport.unpark(thread);
            }
            i2Var = i2Var.b;
        }
        do {
            c0328w12 = j2Var.b;
        } while (!f2094f.s(j2Var, c0328w12, C0328w1.d));
        while (true) {
            c0328w13 = c0328w1;
            c0328w1 = c0328w12;
            if (c0328w1 == null) {
                break;
            }
            c0328w12 = c0328w1.c;
            c0328w1.c = c0328w13;
        }
        while (c0328w13 != null) {
            Runnable runnable = c0328w13.f2132a;
            C0328w1 c0328w14 = c0328w13.c;
            d(runnable, c0328w13.b);
            c0328w13 = c0328w14;
        }
    }

    public static void d(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e6) {
            e.logp(Level.SEVERE, "com.android.billingclient.util.concurrent.AbstractResolvableFuture", "executeListener", androidx.constraintlayout.core.motion.a.r("RuntimeException while executing runnable ", String.valueOf(runnable), " with executor ", String.valueOf(executor)), (Throwable) e6);
        }
    }

    public static final Object f(Object obj) throws ExecutionException {
        if (obj instanceof O0) {
            CancellationException cancellationException = ((O0) obj).f2047a;
            CancellationException cancellationException2 = new CancellationException("Task was cancelled.");
            cancellationException2.initCause(cancellationException);
            throw cancellationException2;
        }
        if (obj instanceof C0290j1) {
            throw new ExecutionException(((C0290j1) obj).f2093a);
        }
        if (obj == f2095g) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String a() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void c(StringBuilder sb) {
        Object obj;
        boolean z6 = false;
        while (true) {
            try {
                try {
                    obj = get();
                    break;
                } catch (InterruptedException unused) {
                    z6 = true;
                } catch (Throwable th) {
                    if (z6) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (CancellationException unused2) {
                sb.append("CANCELLED");
                return;
            } catch (RuntimeException e6) {
                sb.append("UNKNOWN, cause=[");
                sb.append(e6.getClass());
                sb.append(" thrown from get()]");
                return;
            } catch (ExecutionException e7) {
                sb.append("FAILURE, cause=[");
                sb.append(e7.getCause());
                sb.append("]");
                return;
            }
        }
        if (z6) {
            Thread.currentThread().interrupt();
        }
        sb.append("SUCCESS, result=[");
        sb.append(obj == this ? "this future" : String.valueOf(obj));
        sb.append("]");
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z6) {
        Object obj = this.f2096a;
        if (obj != null) {
            return false;
        }
        if (!f2094f.u(this, obj, d ? new O0(new CancellationException("Future.cancel() was called.")) : z6 ? O0.b : O0.c)) {
            return false;
        }
        b(this);
        return true;
    }

    public final void e(i2 i2Var) {
        i2Var.f2090a = null;
        while (true) {
            i2 i2Var2 = this.c;
            if (i2Var2 != i2.c) {
                i2 i2Var3 = null;
                while (i2Var2 != null) {
                    i2 i2Var4 = i2Var2.b;
                    if (i2Var2.f2090a != null) {
                        i2Var3 = i2Var2;
                    } else if (i2Var3 != null) {
                        i2Var3.b = i2Var4;
                        if (i2Var3.f2090a == null) {
                            break;
                        }
                    } else if (!f2094f.z(this, i2Var2, i2Var4)) {
                        break;
                    }
                    i2Var2 = i2Var4;
                }
                return;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f2096a;
        if (obj2 != null) {
            return f(obj2);
        }
        i2 i2Var = this.c;
        i2 i2Var2 = i2.c;
        if (i2Var != i2Var2) {
            i2 i2Var3 = new i2();
            do {
                AbstractC0263a1 abstractC0263a1 = f2094f;
                abstractC0263a1.h(i2Var3, i2Var);
                if (abstractC0263a1.z(this, i2Var, i2Var3)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            e(i2Var3);
                            throw new InterruptedException();
                        }
                        obj = this.f2096a;
                    } while (obj == null);
                    return f(obj);
                }
                i2Var = this.c;
            } while (i2Var != i2Var2);
        }
        return f(this.f2096a);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f2096a instanceof O0;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f2096a != null;
    }

    public final String toString() {
        String strConcat;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.f2096a instanceof O0) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            c(sb);
        } else {
            try {
                strConcat = a();
            } catch (RuntimeException e6) {
                strConcat = "Exception thrown from implementation: ".concat(String.valueOf(e6.getClass()));
            }
            if (strConcat != null && !strConcat.isEmpty()) {
                B2.b.r(sb, "PENDING, info=[", strConcat, "]");
            } else if (isDone()) {
                c(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.play_billing.zzeu
    public final void zzb(Runnable runnable, Executor executor) {
        executor.getClass();
        C0328w1 c0328w1 = this.b;
        C0328w1 c0328w12 = C0328w1.d;
        if (c0328w1 != c0328w12) {
            C0328w1 c0328w13 = new C0328w1(runnable, executor);
            do {
                c0328w13.c = c0328w1;
                if (f2094f.s(this, c0328w1, c0328w13)) {
                    return;
                } else {
                    c0328w1 = this.b;
                }
            } while (c0328w1 != c0328w12);
        }
        d(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j6, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j6);
        if (!Thread.interrupted()) {
            Object obj = this.f2096a;
            if (obj != null) {
                return f(obj);
            }
            long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                i2 i2Var = this.c;
                i2 i2Var2 = i2.c;
                if (i2Var != i2Var2) {
                    i2 i2Var3 = new i2();
                    do {
                        AbstractC0263a1 abstractC0263a1 = f2094f;
                        abstractC0263a1.h(i2Var3, i2Var);
                        if (abstractC0263a1.z(this, i2Var, i2Var3)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f2096a;
                                    if (obj2 != null) {
                                        return f(obj2);
                                    }
                                    nanos = jNanoTime - System.nanoTime();
                                } else {
                                    e(i2Var3);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            e(i2Var3);
                        } else {
                            i2Var = this.c;
                        }
                    } while (i2Var != i2Var2);
                }
                return f(this.f2096a);
            }
            while (nanos > 0) {
                Object obj3 = this.f2096a;
                if (obj3 != null) {
                    return f(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = jNanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String string = toString();
            String string2 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = string2.toLowerCase(locale);
            String strConcat = "Waited " + j6 + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String strConcat2 = strConcat.concat(" (plus ");
                long j7 = -nanos;
                long jConvert = timeUnit.convert(j7, TimeUnit.NANOSECONDS);
                long nanos2 = j7 - timeUnit.toNanos(jConvert);
                boolean z6 = true;
                if (jConvert != 0 && nanos2 <= 1000) {
                    z6 = false;
                }
                if (jConvert > 0) {
                    String strConcat3 = strConcat2 + jConvert + " " + lowerCase;
                    if (z6) {
                        strConcat3 = strConcat3.concat(",");
                    }
                    strConcat2 = strConcat3.concat(" ");
                }
                if (z6) {
                    strConcat2 = strConcat2 + nanos2 + " nanoseconds ";
                }
                strConcat = strConcat2.concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(strConcat.concat(" but future completed as timeout expired"));
            }
            throw new TimeoutException(B2.b.f(strConcat, " for ", string));
        }
        throw new InterruptedException();
    }
}
