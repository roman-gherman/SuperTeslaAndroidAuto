package com.google.android.gms.internal.play_billing;

import java.util.Locale;
import java.util.Objects;
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

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.i0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0286i0 extends C0 implements zzeu {
    public static final boolean d;
    public static final C0315s0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AbstractC0263a1 f2081f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f2082g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f2083a;
    public volatile C0265b0 b;
    public volatile C0283h0 c;

    static {
        boolean z6;
        AbstractC0263a1 c0274e0;
        Throwable th;
        int i = 8;
        try {
            z6 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z6 = false;
        }
        d = z6;
        e = new C0315s0(AbstractC0286i0.class);
        Throwable th2 = null;
        try {
            c0274e0 = new C0280g0(i);
            th = null;
        } catch (Error | Exception e6) {
            try {
                th = e6;
                c0274e0 = new C0268c0(AtomicReferenceFieldUpdater.newUpdater(C0283h0.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(C0283h0.class, C0283h0.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractC0286i0.class, C0283h0.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractC0286i0.class, C0265b0.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractC0286i0.class, Object.class, "a"));
            } catch (Error | Exception e7) {
                th2 = e7;
                c0274e0 = new C0274e0(i);
                th = e6;
            }
        }
        f2081f = c0274e0;
        if (th2 != null) {
            C0315s0 c0315s0 = e;
            Logger loggerA = c0315s0.a();
            Level level = Level.SEVERE;
            loggerA.logp(level, "com.google.common.util.concurrent.AbstractFuture", MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME, "UnsafeAtomicHelper is broken!", th);
            c0315s0.a().logp(level, "com.google.common.util.concurrent.AbstractFuture", MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME, "SafeAtomicHelper is broken!", th2);
        }
        f2082g = new Object();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object d(com.google.android.gms.internal.play_billing.zzeu r6) {
        /*
            java.lang.String r0 = "get() did not throw CancellationException, despite reporting isCancelled() == true: "
            boolean r1 = r6 instanceof com.google.android.gms.internal.play_billing.zzdy$zzh
            r2 = 0
            if (r1 == 0) goto L27
            com.google.android.gms.internal.play_billing.i0 r6 = (com.google.android.gms.internal.play_billing.AbstractC0286i0) r6
            java.lang.Object r6 = r6.f2083a
            boolean r0 = r6 instanceof com.google.android.gms.internal.play_billing.Z
            if (r0 == 0) goto L23
            r0 = r6
            com.google.android.gms.internal.play_billing.Z r0 = (com.google.android.gms.internal.play_billing.Z) r0
            boolean r1 = r0.f2065a
            if (r1 == 0) goto L23
            java.lang.RuntimeException r6 = r0.b
            if (r6 == 0) goto L21
            com.google.android.gms.internal.play_billing.Z r0 = new com.google.android.gms.internal.play_billing.Z
            r0.<init>(r2, r6)
            r6 = r0
            goto L23
        L21:
            com.google.android.gms.internal.play_billing.Z r6 = com.google.android.gms.internal.play_billing.Z.d
        L23:
            java.util.Objects.requireNonNull(r6)
            return r6
        L27:
            boolean r1 = r6 instanceof com.google.android.gms.internal.play_billing.C0
            if (r1 == 0) goto L4c
            r1 = r6
            com.google.android.gms.internal.play_billing.C0 r1 = (com.google.android.gms.internal.play_billing.C0) r1
            com.google.android.gms.internal.play_billing.i0 r1 = (com.google.android.gms.internal.play_billing.AbstractC0286i0) r1
            r1.getClass()
            boolean r3 = r1 instanceof com.google.android.gms.internal.play_billing.zzdy$zzh
            if (r3 == 0) goto L42
            java.lang.Object r1 = r1.f2083a
            boolean r3 = r1 instanceof com.google.android.gms.internal.play_billing.C0262a0
            if (r3 == 0) goto L42
            com.google.android.gms.internal.play_billing.a0 r1 = (com.google.android.gms.internal.play_billing.C0262a0) r1
            java.lang.Throwable r1 = r1.f2068a
            goto L43
        L42:
            r1 = 0
        L43:
            if (r1 != 0) goto L46
            goto L4c
        L46:
            com.google.android.gms.internal.play_billing.a0 r6 = new com.google.android.gms.internal.play_billing.a0
            r6.<init>(r1)
            return r6
        L4c:
            boolean r1 = r6.isCancelled()
            boolean r3 = com.google.android.gms.internal.play_billing.AbstractC0286i0.d
            r3 = r3 ^ 1
            r3 = r3 & r1
            if (r3 == 0) goto L5d
            com.google.android.gms.internal.play_billing.Z r6 = com.google.android.gms.internal.play_billing.Z.d
            java.util.Objects.requireNonNull(r6)
            return r6
        L5d:
            java.lang.Object r3 = e(r6)     // Catch: java.lang.Error -> L76 java.util.concurrent.CancellationException -> L78 java.util.concurrent.ExecutionException -> L7a java.lang.Throwable -> L81
            if (r1 == 0) goto L7c
            com.google.android.gms.internal.play_billing.Z r3 = new com.google.android.gms.internal.play_billing.Z     // Catch: java.util.concurrent.CancellationException -> L78 java.util.concurrent.ExecutionException -> L7a java.lang.Throwable -> L81
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch: java.util.concurrent.CancellationException -> L78 java.util.concurrent.ExecutionException -> L7a java.lang.Throwable -> L81
            java.lang.String r5 = java.lang.String.valueOf(r6)     // Catch: java.util.concurrent.CancellationException -> L78 java.util.concurrent.ExecutionException -> L7a java.lang.Throwable -> L81
            java.lang.String r5 = r0.concat(r5)     // Catch: java.util.concurrent.CancellationException -> L78 java.util.concurrent.ExecutionException -> L7a java.lang.Throwable -> L81
            r4.<init>(r5)     // Catch: java.util.concurrent.CancellationException -> L78 java.util.concurrent.ExecutionException -> L7a java.lang.Throwable -> L81
            r3.<init>(r2, r4)     // Catch: java.lang.Error -> L76 java.util.concurrent.CancellationException -> L78 java.util.concurrent.ExecutionException -> L7a java.lang.Throwable -> L81
            return r3
        L76:
            r6 = move-exception
            goto L84
        L78:
            r0 = move-exception
            goto L8a
        L7a:
            r3 = move-exception
            goto La7
        L7c:
            if (r3 != 0) goto L83
            java.lang.Object r6 = com.google.android.gms.internal.play_billing.AbstractC0286i0.f2082g     // Catch: java.util.concurrent.CancellationException -> L78 java.util.concurrent.ExecutionException -> L7a java.lang.Throwable -> L81 java.lang.Throwable -> L81
            return r6
        L81:
            r6 = move-exception
            goto L84
        L83:
            return r3
        L84:
            com.google.android.gms.internal.play_billing.a0 r0 = new com.google.android.gms.internal.play_billing.a0
            r0.<init>(r6)
            return r0
        L8a:
            if (r1 != 0) goto La1
            com.google.android.gms.internal.play_billing.a0 r1 = new com.google.android.gms.internal.play_billing.a0
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r3 = "get() threw CancellationException, despite reporting isCancelled() == false: "
            java.lang.String r6 = r3.concat(r6)
            r2.<init>(r6, r0)
            r1.<init>(r2)
            return r1
        La1:
            com.google.android.gms.internal.play_billing.Z r6 = new com.google.android.gms.internal.play_billing.Z
            r6.<init>(r2, r0)
            return r6
        La7:
            if (r1 == 0) goto Lbc
            com.google.android.gms.internal.play_billing.Z r1 = new com.google.android.gms.internal.play_billing.Z
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r6 = r0.concat(r6)
            r4.<init>(r6, r3)
            r1.<init>(r2, r4)
            return r1
        Lbc:
            com.google.android.gms.internal.play_billing.a0 r6 = new com.google.android.gms.internal.play_billing.a0
            java.lang.Throwable r0 = r3.getCause()
            r6.<init>(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.AbstractC0286i0.d(com.google.android.gms.internal.play_billing.zzeu):java.lang.Object");
    }

    public static Object e(zzeu zzeuVar) {
        V v6;
        boolean z6 = false;
        while (true) {
            try {
                v6 = zzeuVar.get();
                break;
            } catch (InterruptedException unused) {
                z6 = true;
            } catch (Throwable th) {
                if (z6) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z6) {
            Thread.currentThread().interrupt();
        }
        return v6;
    }

    public static void g(AbstractC0286i0 abstractC0286i0) {
        C0265b0 c0265b0;
        C0265b0 c0265b02 = null;
        while (true) {
            for (C0283h0 c0283h0N = f2081f.n(abstractC0286i0); c0283h0N != null; c0283h0N = c0283h0N.b) {
                Thread thread = c0283h0N.f2080a;
                if (thread != null) {
                    c0283h0N.f2080a = null;
                    LockSupport.unpark(thread);
                }
            }
            abstractC0286i0.b();
            C0265b0 c0265b03 = c0265b02;
            C0265b0 c0265b0C = f2081f.c(abstractC0286i0);
            C0265b0 c0265b04 = c0265b03;
            while (c0265b0C != null) {
                C0265b0 c0265b05 = c0265b0C.c;
                c0265b0C.c = c0265b04;
                c0265b04 = c0265b0C;
                c0265b0C = c0265b05;
            }
            while (c0265b04 != null) {
                Runnable runnable = c0265b04.f2070a;
                c0265b0 = c0265b04.c;
                Objects.requireNonNull(runnable);
                if (runnable instanceof RunnableC0271d0) {
                    RunnableC0271d0 runnableC0271d0 = (RunnableC0271d0) runnable;
                    abstractC0286i0 = runnableC0271d0.f2075a;
                    if (abstractC0286i0.f2083a == runnableC0271d0) {
                        if (f2081f.C(abstractC0286i0, runnableC0271d0, d(runnableC0271d0.b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = c0265b04.b;
                    Objects.requireNonNull(executor);
                    h(runnable, executor);
                }
                c0265b04 = c0265b0;
            }
            return;
            c0265b02 = c0265b0;
        }
    }

    public static void h(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e6) {
            e.a().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "executeListener", androidx.constraintlayout.core.motion.a.r("RuntimeException while executing runnable ", String.valueOf(runnable), " with executor ", String.valueOf(executor)), (Throwable) e6);
        }
    }

    public static final Object j(Object obj) throws ExecutionException {
        if (obj instanceof Z) {
            RuntimeException runtimeException = ((Z) obj).b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(runtimeException);
            throw cancellationException;
        }
        if (obj instanceof C0262a0) {
            throw new ExecutionException(((C0262a0) obj).f2068a);
        }
        if (obj == f2082g) {
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

    public void b() {
    }

    public final void c(Throwable th) {
        if (f2081f.C(this, null, new C0262a0(th))) {
            g(this);
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z6) {
        Z z7;
        Object obj = this.f2083a;
        if (!(obj instanceof RunnableC0271d0) && !(obj == null)) {
            return false;
        }
        if (d) {
            z7 = new Z(z6, new CancellationException("Future.cancel() was called."));
        } else {
            z7 = z6 ? Z.c : Z.d;
            Objects.requireNonNull(z7);
        }
        AbstractC0286i0 abstractC0286i0 = this;
        boolean z8 = false;
        while (true) {
            if (f2081f.C(abstractC0286i0, obj, z7)) {
                g(abstractC0286i0);
                if (!(obj instanceof RunnableC0271d0)) {
                    break;
                }
                zzeu zzeuVar = ((RunnableC0271d0) obj).b;
                if (!(zzeuVar instanceof zzdy$zzh)) {
                    zzeuVar.cancel(z6);
                    break;
                }
                abstractC0286i0 = (AbstractC0286i0) zzeuVar;
                obj = abstractC0286i0.f2083a;
                if (!(obj == null) && !(obj instanceof RunnableC0271d0)) {
                    break;
                }
                z8 = true;
            } else {
                obj = abstractC0286i0.f2083a;
                if (!(obj instanceof RunnableC0271d0)) {
                    return z8;
                }
            }
        }
        return true;
    }

    public final void f(StringBuilder sb) {
        try {
            Object objE = e(this);
            sb.append("SUCCESS, result=[");
            if (objE == null) {
                sb.append("null");
            } else if (objE == this) {
                sb.append("this future");
            } else {
                sb.append(objE.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(objE)));
            }
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (ExecutionException e6) {
            sb.append("FAILURE, cause=[");
            sb.append(e6.getCause());
            sb.append("]");
        } catch (Exception e7) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e7.getClass());
            sb.append(" thrown from get()]");
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f2083a;
        if ((obj2 != null) && (!(obj2 instanceof RunnableC0271d0))) {
            return j(obj2);
        }
        C0283h0 c0283h0 = this.c;
        C0283h0 c0283h02 = C0283h0.c;
        if (c0283h0 != c0283h02) {
            C0283h0 c0283h03 = new C0283h0();
            do {
                AbstractC0263a1 abstractC0263a1 = f2081f;
                abstractC0263a1.r(c0283h03, c0283h0);
                if (abstractC0263a1.E(this, c0283h0, c0283h03)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            i(c0283h03);
                            throw new InterruptedException();
                        }
                        obj = this.f2083a;
                    } while (!((obj != null) & (!(obj instanceof RunnableC0271d0))));
                    return j(obj);
                }
                c0283h0 = this.c;
            } while (c0283h0 != c0283h02);
        }
        Object obj3 = this.f2083a;
        Objects.requireNonNull(obj3);
        return j(obj3);
    }

    public final void i(C0283h0 c0283h0) {
        c0283h0.f2080a = null;
        while (true) {
            C0283h0 c0283h02 = this.c;
            if (c0283h02 != C0283h0.c) {
                C0283h0 c0283h03 = null;
                while (c0283h02 != null) {
                    C0283h0 c0283h04 = c0283h02.b;
                    if (c0283h02.f2080a != null) {
                        c0283h03 = c0283h02;
                    } else if (c0283h03 != null) {
                        c0283h03.b = c0283h04;
                        if (c0283h03.f2080a == null) {
                            break;
                        }
                    } else if (!f2081f.E(this, c0283h02, c0283h04)) {
                        break;
                    }
                    c0283h02 = c0283h04;
                }
                return;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f2083a instanceof Z;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (this.f2083a != null) & (!(r0 instanceof RunnableC0271d0));
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.AbstractC0286i0.toString():java.lang.String");
    }

    @Override // com.google.android.gms.internal.play_billing.zzeu
    public final void zzb(Runnable runnable, Executor executor) {
        C0265b0 c0265b0;
        C0265b0 c0265b02;
        if (executor == null) {
            throw new NullPointerException("Executor was null.");
        }
        if (!isDone() && (c0265b0 = this.b) != (c0265b02 = C0265b0.d)) {
            C0265b0 c0265b03 = new C0265b0(runnable, executor);
            do {
                c0265b03.c = c0265b0;
                if (f2081f.y(this, c0265b0, c0265b03)) {
                    return;
                } else {
                    c0265b0 = this.b;
                }
            } while (c0265b0 != c0265b02);
        }
        h(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j6, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        boolean z6;
        long j7;
        long nanos = timeUnit.toNanos(j6);
        if (!Thread.interrupted()) {
            Object obj = this.f2083a;
            if ((obj != null) & (!(obj instanceof RunnableC0271d0))) {
                return j(obj);
            }
            long j8 = 0;
            long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                C0283h0 c0283h0 = this.c;
                C0283h0 c0283h02 = C0283h0.c;
                if (c0283h0 != c0283h02) {
                    C0283h0 c0283h03 = new C0283h0();
                    z6 = true;
                    while (true) {
                        AbstractC0263a1 abstractC0263a1 = f2081f;
                        abstractC0263a1.r(c0283h03, c0283h0);
                        if (abstractC0263a1.E(this, c0283h0, c0283h03)) {
                            j7 = j8;
                            do {
                                LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f2083a;
                                    if ((obj2 != null) & (!(obj2 instanceof RunnableC0271d0))) {
                                        return j(obj2);
                                    }
                                    nanos = jNanoTime - System.nanoTime();
                                } else {
                                    i(c0283h03);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            i(c0283h03);
                        } else {
                            long j9 = j8;
                            c0283h0 = this.c;
                            if (c0283h0 == c0283h02) {
                                break;
                            }
                            j8 = j9;
                        }
                    }
                }
                Object obj3 = this.f2083a;
                Objects.requireNonNull(obj3);
                return j(obj3);
            }
            z6 = true;
            j7 = 0;
            while (nanos > j7) {
                Object obj4 = this.f2083a;
                if ((obj4 != null ? z6 : false) & (!(obj4 instanceof RunnableC0271d0))) {
                    return j(obj4);
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
            if (nanos + 1000 < j7) {
                String strConcat2 = strConcat.concat(" (plus ");
                long j10 = -nanos;
                long jConvert = timeUnit.convert(j10, TimeUnit.NANOSECONDS);
                long nanos2 = j10 - timeUnit.toNanos(jConvert);
                if (jConvert != j7 && nanos2 <= 1000) {
                    z6 = false;
                }
                if (jConvert > j7) {
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
