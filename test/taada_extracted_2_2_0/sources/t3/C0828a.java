package t3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: t3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0828a extends Thread {
    public static final AtomicIntegerFieldUpdater i = AtomicIntegerFieldUpdater.newUpdater(C0828a.class, "workerCtl");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f4821a;
    public final v b;
    public int c;
    public long d;
    public long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4822f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4823g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ b f4824h;
    private volatile int indexInArray;

    @Nullable
    private volatile Object nextParkedWorker;

    @Volatile
    private volatile int workerCtl;

    public C0828a(b bVar, int i3) {
        this.f4824h = bVar;
        setDaemon(true);
        this.f4821a = new m();
        this.b = new v();
        this.c = 4;
        this.nextParkedWorker = b.f4827k;
        this.f4822f = c2.f.b.a();
        f(i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
    
        r12 = t3.m.d.get(r3);
        r0 = t3.m.c.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
    
        if (r12 == r0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0057, code lost:
    
        if (t3.m.e.get(r3) != 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
    
        r0 = r0 - 1;
        r5 = r3.c(r0, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0060, code lost:
    
        if (r5 == null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
    
        r2 = r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final t3.h a(boolean r12) {
        /*
            r11 = this;
            int r0 = r11.c
            r1 = 1
            r2 = 0
            t3.m r3 = r11.f4821a
            t3.b r4 = r11.f4824h
            if (r0 != r1) goto Lc
            goto L86
        Lc:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = t3.b.i
        Le:
            t3.b r6 = r11.f4824h
            long r7 = r0.get(r6)
            r9 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
            long r9 = r9 & r7
            r5 = 42
            long r9 = r9 >> r5
            int r5 = (int) r9
            if (r5 != 0) goto L75
            r3.getClass()
        L23:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = t3.m.b
            java.lang.Object r0 = r12.get(r3)
            t3.h r0 = (t3.h) r0
            if (r0 != 0) goto L2e
            goto L43
        L2e:
            t3.i r5 = r0.b
            int r5 = r5.f4835a
            if (r5 != r1) goto L43
        L34:
            boolean r5 = r12.compareAndSet(r3, r0, r2)
            if (r5 == 0) goto L3c
            r2 = r0
            goto L63
        L3c:
            java.lang.Object r5 = r12.get(r3)
            if (r5 == r0) goto L34
            goto L23
        L43:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r12 = t3.m.d
            int r12 = r12.get(r3)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = t3.m.c
            int r0 = r0.get(r3)
        L4f:
            if (r12 == r0) goto L63
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r5 = t3.m.e
            int r5 = r5.get(r3)
            if (r5 != 0) goto L5a
            goto L63
        L5a:
            int r0 = r0 + (-1)
            t3.h r5 = r3.c(r0, r1)
            if (r5 == 0) goto L4f
            r2 = r5
        L63:
            if (r2 != 0) goto L74
            t3.e r12 = r4.f4829f
            java.lang.Object r12 = r12.d()
            t3.h r12 = (t3.h) r12
            if (r12 != 0) goto L73
            t3.h r12 = r11.i(r1)
        L73:
            return r12
        L74:
            return r2
        L75:
            r9 = 4398046511104(0x40000000000, double:2.1729236899484E-311)
            long r9 = r7 - r9
            java.util.concurrent.atomic.AtomicLongFieldUpdater r5 = t3.b.i
            boolean r5 = r5.compareAndSet(r6, r7, r9)
            if (r5 == 0) goto Le
            r11.c = r1
        L86:
            if (r12 == 0) goto Lba
            int r12 = r4.f4828a
            int r12 = r12 * 2
            int r12 = r11.d(r12)
            if (r12 != 0) goto L93
            goto L94
        L93:
            r1 = 0
        L94:
            if (r1 == 0) goto L9d
            t3.h r12 = r11.e()
            if (r12 == 0) goto L9d
            return r12
        L9d:
            r3.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = t3.m.b
            java.lang.Object r12 = r12.getAndSet(r3, r2)
            t3.h r12 = (t3.h) r12
            if (r12 != 0) goto Lae
            t3.h r12 = r3.b()
        Lae:
            if (r12 == 0) goto Lb1
            return r12
        Lb1:
            if (r1 != 0) goto Lc1
            t3.h r12 = r11.e()
            if (r12 == 0) goto Lc1
            return r12
        Lba:
            t3.h r12 = r11.e()
            if (r12 == 0) goto Lc1
            return r12
        Lc1:
            r12 = 3
            t3.h r12 = r11.i(r12)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.C0828a.a(boolean):t3.h");
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i3) {
        int i4 = this.f4822f;
        int i5 = i4 ^ (i4 << 13);
        int i6 = i5 ^ (i5 >> 17);
        int i7 = i6 ^ (i6 << 5);
        this.f4822f = i7;
        int i8 = i3 - 1;
        return (i8 & i3) == 0 ? i7 & i8 : (i7 & Integer.MAX_VALUE) % i3;
    }

    public final h e() {
        int iD = d(2);
        b bVar = this.f4824h;
        if (iD == 0) {
            h hVar = (h) bVar.e.d();
            return hVar != null ? hVar : (h) bVar.f4829f.d();
        }
        h hVar2 = (h) bVar.f4829f.d();
        return hVar2 != null ? hVar2 : (h) bVar.e.d();
    }

    public final void f(int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4824h.d);
        sb.append("-worker-");
        sb.append(i3 == 0 ? "TERMINATED" : String.valueOf(i3));
        setName(sb.toString());
        this.indexInArray = i3;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(int i3) {
        int i4 = this.c;
        boolean z6 = i4 == 1;
        if (z6) {
            b.i.addAndGet(this.f4824h, 4398046511104L);
        }
        if (i4 != i3) {
            this.c = i3;
        }
        return z6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006b, code lost:
    
        r7 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a2, code lost:
    
        r7 = -2;
        r23 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final t3.h i(int r26) {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.C0828a.i(int):t3.h");
    }

    /* JADX WARN: Code restructure failed: missing block: B:122:0x0004, code lost:
    
        continue;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.C0828a.run():void");
    }
}
