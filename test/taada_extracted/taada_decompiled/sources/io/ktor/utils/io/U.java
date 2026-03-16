package io.ktor.utils.io;

import a.AbstractC0132a;
import c4.AbstractC0246d;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class U implements ByteChannel, ByteReadChannel, ByteWriteChannel, LookAheadSuspendSession, HasReadSession, HasWriteSession {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3533k = AtomicReferenceFieldUpdater.newUpdater(U.class, Object.class, "_state");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3534l = AtomicReferenceFieldUpdater.newUpdater(U.class, Object.class, "_closed");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3535m = AtomicReferenceFieldUpdater.newUpdater(U.class, Object.class, "_readOp");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3536n = AtomicReferenceFieldUpdater.newUpdater(U.class, Object.class, "_writeOp");

    @NotNull
    private volatile /* synthetic */ Object _closed;

    @NotNull
    private volatile /* synthetic */ Object _readOp;

    @NotNull
    private volatile /* synthetic */ Object _state;

    @NotNull
    volatile /* synthetic */ Object _writeOp;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3537a;

    @Nullable
    private volatile Job attachedJob;
    public final ObjectPool b;
    public final int c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final M3.a f3538f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Y0.b f3539g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final io.ktor.utils.io.internal.b f3540h;
    public final io.ktor.utils.io.internal.b i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final S f3541j;

    @Nullable
    private volatile io.ktor.utils.io.internal.e joining;
    private volatile long totalBytesRead;
    private volatile long totalBytesWritten;
    private volatile int writeSuspensionSize;

    public U(boolean z6) {
        this(z6, io.ktor.utils.io.internal.h.c, 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object G(io.ktor.utils.io.U r5, int r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.A
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.A r0 = (io.ktor.utils.io.A) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            io.ktor.utils.io.A r0 = new io.ktor.utils.io.A
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.b
            T1.a r1 = T1.a.f1304a
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            java.lang.StringBuilder r5 = r0.f3480a
            kotlin.reflect.l.e0(r7)
            goto L47
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.reflect.l.e0(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r0.f3480a = r7
            r0.d = r3
            java.lang.Object r5 = r5.readUTF8LineTo(r7, r6, r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            r4 = r7
            r7 = r5
            r5 = r4
        L47:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r6 = r7.booleanValue()
            if (r6 != 0) goto L51
            r5 = 0
            return r5
        L51:
            java.lang.String r5 = r5.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.G(io.ktor.utils.io.U, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static void N(ByteBuffer byteBuffer, int i) {
        int iRemaining = byteBuffer.remaining();
        byteBuffer.limit(byteBuffer.position() + i);
        int i3 = i - iRemaining;
        for (int i4 = 0; i4 < i3; i4++) {
            byteBuffer.put((byteBuffer.capacity() - 8) + i4, byteBuffer.get(i4));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object U(io.ktor.utils.io.U r5, int r6, kotlin.jvm.functions.Function1 r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.D
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.utils.io.D r0 = (io.ktor.utils.io.D) r0
            int r1 = r0.f3494f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3494f = r1
            goto L18
        L13:
            io.ktor.utils.io.D r0 = new io.ktor.utils.io.D
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.d
            T1.a r1 = T1.a.f1304a
            int r2 = r0.f3494f
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            int r5 = r0.c
            kotlin.jvm.functions.Function1 r6 = r0.b
            io.ktor.utils.io.U r7 = r0.f3493a
            kotlin.reflect.l.e0(r8)
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
            goto L42
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.reflect.l.e0(r8)
            if (r6 <= 0) goto L6c
            r8 = 4088(0xff8, float:5.729E-42)
            if (r6 > r8) goto L5a
        L42:
            int r8 = r5.writeAvailable(r6, r7)
            if (r8 < 0) goto L4b
            N1.m r5 = N1.m.f1129a
            return r5
        L4b:
            r0.f3493a = r5
            r0.b = r7
            r0.c = r6
            r0.f3494f = r3
            java.lang.Object r8 = r5.e(r6, r7, r0)
            if (r8 != r1) goto L42
            return r1
        L5a:
            java.lang.String r5 = "Min("
            java.lang.String r7 = ") should'nt be greater than (4088)"
            java.lang.String r5 = B2.b.d(r6, r5, r7)
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r5 = r5.toString()
            r6.<init>(r5)
            throw r6
        L6c:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "min should be positive"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.U(io.ktor.utils.io.U, int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final io.ktor.utils.io.internal.c a(U u) {
        return (io.ktor.utils.io.internal.c) u._closed;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c4, code lost:
    
        if (r6.i0(r7, r0) != r1) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00c4 -> B:46:0x00c7). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object a0(io.ktor.utils.io.U r6, byte r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.a0(io.ktor.utils.io.U, byte, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c2, code lost:
    
        if (r7.i0(r3, r0) != r1) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00c2 -> B:46:0x00c5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object e0(io.ktor.utils.io.U r7, int r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.e0(io.ktor.utils.io.U, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c2, code lost:
    
        if (r7.i0(r3, r0) != r1) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00c2 -> B:46:0x00c5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object f0(io.ktor.utils.io.U r7, long r8, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.f0(io.ktor.utils.io.U, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c3, code lost:
    
        if (r7.i0(r4, r0) != r1) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00c3 -> B:46:0x00c6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object h0(io.ktor.utils.io.U r7, short r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.h0(io.ktor.utils.io.U, short, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v4, types: [N1.m, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object l0(io.ktor.utils.io.U r4, kotlin.coroutines.Continuation r5, kotlin.jvm.functions.Function2 r6) {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.io.Q
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.utils.io.Q r0 = (io.ktor.utils.io.Q) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            io.ktor.utils.io.Q r0 = new io.ktor.utils.io.Q
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.b
            T1.a r1 = T1.a.f1304a
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            Y0.b r4 = r0.f3523a
            kotlin.reflect.l.e0(r5)     // Catch: java.lang.Throwable -> L29
            goto L46
        L29:
            r5 = move-exception
            goto L4c
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.reflect.l.e0(r5)
            Y0.b r4 = r4.f3539g
            r4.b()
            r0.f3523a = r4     // Catch: java.lang.Throwable -> L29
            r0.d = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r5 = r6.mo5invoke(r4, r0)     // Catch: java.lang.Throwable -> L29
            if (r5 != r1) goto L46
            return r1
        L46:
            r4.c()
            N1.m r4 = N1.m.f1129a
            return r4
        L4c:
            r4.c()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.l0(io.ktor.utils.io.U, kotlin.coroutines.Continuation, kotlin.jvm.functions.Function2):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0163  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object n(io.ktor.utils.io.U r7, kotlin.coroutines.Continuation r8, kotlin.jvm.functions.Function2 r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.n(io.ktor.utils.io.U, kotlin.coroutines.Continuation, kotlin.jvm.functions.Function2):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object o(io.ktor.utils.io.U r14, java.nio.ByteBuffer r15, long r16, long r18, long r20, long r22, kotlin.coroutines.Continuation r24) {
        /*
            r0 = r24
            boolean r1 = r0 instanceof io.ktor.utils.io.C0540f
            if (r1 == 0) goto L15
            r1 = r0
            io.ktor.utils.io.f r1 = (io.ktor.utils.io.C0540f) r1
            int r2 = r1.d
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.d = r2
            goto L1a
        L15:
            io.ktor.utils.io.f r1 = new io.ktor.utils.io.f
            r1.<init>(r14, r0)
        L1a:
            java.lang.Object r0 = r1.b
            T1.a r2 = T1.a.f1304a
            int r3 = r1.d
            r4 = 1
            if (r3 == 0) goto L33
            if (r3 != r4) goto L2b
            kotlin.jvm.internal.t r14 = r1.f3570a
            kotlin.reflect.l.e0(r0)     // Catch: java.io.EOFException -> L5d
            goto L5d
        L2b:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L33:
            kotlin.reflect.l.e0(r0)
            kotlin.jvm.internal.t r13 = new kotlin.jvm.internal.t
            r13.<init>()
            long r5 = r20 + r18
            r7 = 4088(0xff8, double:2.0197E-320)
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 <= 0) goto L44
            r5 = r7
        L44:
            int r0 = (int) r5
            io.ktor.utils.io.g r5 = new io.ktor.utils.io.g     // Catch: java.io.EOFException -> L5c
            r10 = r15
            r11 = r16
            r6 = r18
            r8 = r22
            r5.<init>(r6, r8, r10, r11, r13)     // Catch: java.io.EOFException -> L5c
            r1.f3570a = r13     // Catch: java.io.EOFException -> L5c
            r1.d = r4     // Catch: java.io.EOFException -> L5c
            java.lang.Object r14 = r14.read(r0, r5, r1)     // Catch: java.io.EOFException -> L5c
            if (r14 != r2) goto L5c
            return r2
        L5c:
            r14 = r13
        L5d:
            int r14 = r14.f3814a
            long r0 = (long) r14
            java.lang.Long r14 = new java.lang.Long
            r14.<init>(r0)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.o(io.ktor.utils.io.U, java.nio.ByteBuffer, long, long, long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static int t(U u, J1.b bVar, int i, int i3) throws Throwable {
        int iH;
        boolean z6;
        if ((i3 & 4) != 0) {
            i = bVar.e - bVar.c;
        }
        int i4 = 0;
        do {
            ByteBuffer byteBufferO = u.O();
            if (byteBufferO == null) {
                z6 = false;
                iH = 0;
            } else {
                io.ktor.utils.io.internal.r rVar = ((io.ktor.utils.io.internal.p) u._state).b;
                try {
                    if (rVar._availableForRead$internal == 0) {
                        u.J();
                        u.R();
                        z6 = false;
                        iH = 0;
                    } else {
                        int i5 = bVar.e - bVar.c;
                        iH = rVar.h(Math.min(byteBufferO.remaining(), Math.min(i5, i)));
                        if (iH <= 0) {
                            z6 = false;
                        } else {
                            if (i5 < byteBufferO.remaining()) {
                                byteBufferO.limit(byteBufferO.position() + i5);
                            }
                            AbstractC0246d.O0(bVar, byteBufferO);
                            u.f(byteBufferO, rVar, iH);
                            z6 = true;
                        }
                    }
                } finally {
                    u.J();
                    u.R();
                }
            }
            i4 += iH;
            i -= iH;
            if (!z6 || bVar.e <= bVar.c) {
                break;
            }
        } while (((io.ktor.utils.io.internal.p) u._state).b._availableForRead$internal > 0);
        return i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0050 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0051 -> B:19:0x0058). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object A(byte[] r7, int r8, int r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.r
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.utils.io.r r0 = (io.ktor.utils.io.r) r0
            int r1 = r0.f3630h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3630h = r1
            goto L18
        L13:
            io.ktor.utils.io.r r0 = new io.ktor.utils.io.r
            r0.<init>(r6, r10)
        L18:
            java.lang.Object r10 = r0.f3628f
            T1.a r1 = T1.a.f1304a
            int r2 = r0.f3630h
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            int r7 = r0.e
            int r8 = r0.d
            int r9 = r0.c
            byte[] r2 = r0.b
            io.ktor.utils.io.U r4 = r0.f3627a
            kotlin.reflect.l.e0(r10)
            goto L58
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            kotlin.reflect.l.e0(r10)
            r10 = 0
            r4 = r6
        L3e:
            r0.f3627a = r4
            r0.b = r7
            r0.c = r8
            r0.d = r9
            r0.e = r10
            r0.f3630h = r3
            java.lang.Object r2 = r4.D(r3, r0)
            if (r2 != r1) goto L51
            return r1
        L51:
            r5 = r2
            r2 = r7
            r7 = r10
            r10 = r5
            r5 = r9
            r9 = r8
            r8 = r5
        L58:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L70
            int r9 = r9 + r7
            int r7 = r8 - r7
            int r10 = r4.s(r2, r9, r7)
            if (r10 < r7) goto L6c
            N1.m r7 = N1.m.f1129a
            return r7
        L6c:
            r8 = r9
            r9 = r7
            r7 = r2
            goto L3e
        L70:
            o3.x r7 = new o3.x
            java.lang.String r9 = "Unexpected EOF: expected "
            java.lang.String r10 = " more bytes"
            java.lang.String r8 = B2.b.d(r8, r9, r10)
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.A(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0042 A[Catch: all -> 0x004f, TRY_ENTER, TryCatch #2 {all -> 0x004f, blocks: (B:28:0x0065, B:20:0x0042, B:22:0x004b, B:25:0x0054, B:29:0x0073), top: B:41:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0073 A[Catch: all -> 0x004f, TRY_LEAVE, TryCatch #2 {all -> 0x004f, blocks: (B:28:0x0065, B:20:0x0042, B:22:0x004b, B:25:0x0054, B:29:0x0073), top: B:41:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0062 -> B:41:0x0065). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object B(int r6, I1.c r7, java.nio.ByteBuffer r8, kotlin.coroutines.Continuation r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof io.ktor.utils.io.C0554u
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.utils.io.u r0 = (io.ktor.utils.io.C0554u) r0
            int r1 = r0.f3635g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3635g = r1
            goto L18
        L13:
            io.ktor.utils.io.u r0 = new io.ktor.utils.io.u
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.e
            T1.a r1 = T1.a.f1304a
            int r2 = r0.f3635g
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            int r6 = r0.d
            java.nio.ByteBuffer r7 = r0.c
            I1.c r8 = r0.b
            io.ktor.utils.io.U r2 = r0.f3633a
            kotlin.reflect.l.e0(r9)     // Catch: java.lang.Throwable -> L32
            r4 = r8
            r8 = r7
            r7 = r4
            goto L65
        L32:
            r6 = move-exception
            goto L7d
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.reflect.l.e0(r9)
            r2 = r5
        L40:
            if (r6 <= 0) goto L73
            r8.clear()     // Catch: java.lang.Throwable -> L4f
            int r9 = r8.remaining()     // Catch: java.lang.Throwable -> L4f
            if (r9 <= r6) goto L54
            r8.limit(r6)     // Catch: java.lang.Throwable -> L4f
            goto L54
        L4f:
            r6 = move-exception
            r4 = r8
            r8 = r7
            r7 = r4
            goto L7d
        L54:
            r0.f3633a = r2     // Catch: java.lang.Throwable -> L4f
            r0.b = r7     // Catch: java.lang.Throwable -> L4f
            r0.c = r8     // Catch: java.lang.Throwable -> L4f
            r0.d = r6     // Catch: java.lang.Throwable -> L4f
            r0.f3635g = r3     // Catch: java.lang.Throwable -> L4f
            java.lang.Object r9 = r2.readFully(r8, r0)     // Catch: java.lang.Throwable -> L4f
            if (r9 != r1) goto L65
            return r1
        L65:
            java.lang.Number r9 = (java.lang.Number) r9     // Catch: java.lang.Throwable -> L4f
            int r9 = r9.intValue()     // Catch: java.lang.Throwable -> L4f
            r8.flip()     // Catch: java.lang.Throwable -> L4f
            E1.k.t0(r7, r8)     // Catch: java.lang.Throwable -> L4f
            int r6 = r6 - r9
            goto L40
        L73:
            I1.d r6 = r7.c()     // Catch: java.lang.Throwable -> L4f
            K1.f r7 = io.ktor.utils.io.internal.h.b
            r7.recycle(r8)
            return r6
        L7d:
            r8.close()     // Catch: java.lang.Throwable -> L81
            throw r6     // Catch: java.lang.Throwable -> L81
        L81:
            r6 = move-exception
            K1.f r8 = io.ktor.utils.io.internal.h.b
            r8.recycle(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.B(int, I1.c, java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0060 A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:12:0x002e, B:31:0x008e, B:36:0x009b, B:21:0x0054, B:23:0x0060, B:24:0x0064, B:26:0x0075, B:28:0x007b), top: B:50:0x002e, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009b A[Catch: all -> 0x0032, TRY_LEAVE, TryCatch #0 {all -> 0x0032, blocks: (B:12:0x002e, B:31:0x008e, B:36:0x009b, B:21:0x0054, B:23:0x0060, B:24:0x0064, B:26:0x0075, B:28:0x007b), top: B:50:0x002e, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a0 A[Catch: all -> 0x00ae, TRY_ENTER, TryCatch #2 {all -> 0x00ae, blocks: (B:38:0x00a0, B:40:0x00a9, B:44:0x00b1, B:45:0x00b2, B:46:0x00b5, B:12:0x002e, B:31:0x008e, B:36:0x009b, B:21:0x0054, B:23:0x0060, B:24:0x0064, B:26:0x0075, B:28:0x007b), top: B:50:0x002e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x008b -> B:31:0x008e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0098 -> B:35:0x0099). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object C(long r12, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r14 instanceof io.ktor.utils.io.C0555v
            if (r0 == 0) goto L13
            r0 = r14
            io.ktor.utils.io.v r0 = (io.ktor.utils.io.C0555v) r0
            int r1 = r0.f3639h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3639h = r1
            goto L18
        L13:
            io.ktor.utils.io.v r0 = new io.ktor.utils.io.v
            r0.<init>(r11, r14)
        L18:
            java.lang.Object r14 = r0.f3637f
            T1.a r1 = T1.a.f1304a
            int r2 = r0.f3639h
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 != r4) goto L35
            J1.b r12 = r0.e
            I1.c r13 = r0.d
            kotlin.jvm.internal.u r2 = r0.c
            I1.c r5 = r0.b
            io.ktor.utils.io.U r6 = r0.f3636a
            kotlin.reflect.l.e0(r14)     // Catch: java.lang.Throwable -> L32
            goto L8e
        L32:
            r12 = move-exception
            goto Lb2
        L35:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3d:
            kotlin.reflect.l.e0(r14)
            I1.c r14 = new I1.c
            r14.<init>()
            kotlin.jvm.internal.u r2 = new kotlin.jvm.internal.u     // Catch: java.lang.Throwable -> Lb6
            r2.<init>()     // Catch: java.lang.Throwable -> Lb6
            r2.f3815a = r12     // Catch: java.lang.Throwable -> Lb6
            r12 = 0
            J1.b r12 = J1.c.f(r14, r4, r12)     // Catch: java.lang.Throwable -> Lb6
            r6 = r11
            r13 = r14
            r5 = r13
        L54:
            int r14 = r12.e     // Catch: java.lang.Throwable -> L32
            int r7 = r12.c     // Catch: java.lang.Throwable -> L32
            int r14 = r14 - r7
            long r7 = (long) r14     // Catch: java.lang.Throwable -> L32
            long r9 = r2.f3815a     // Catch: java.lang.Throwable -> L32
            int r14 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r14 <= 0) goto L64
            int r14 = (int) r9     // Catch: java.lang.Throwable -> L32
            r12.f(r14)     // Catch: java.lang.Throwable -> L32
        L64:
            r14 = 6
            int r14 = t(r6, r12, r3, r14)     // Catch: java.lang.Throwable -> L32
            long r7 = r2.f3815a     // Catch: java.lang.Throwable -> L32
            long r9 = (long) r14     // Catch: java.lang.Throwable -> L32
            long r7 = r7 - r9
            r2.f3815a = r7     // Catch: java.lang.Throwable -> L32
            r9 = 0
            int r14 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r14 <= 0) goto L98
            boolean r14 = r6.isClosedForRead()     // Catch: java.lang.Throwable -> L32
            if (r14 != 0) goto L98
            r0.f3636a = r6     // Catch: java.lang.Throwable -> L32
            r0.b = r5     // Catch: java.lang.Throwable -> L32
            r0.c = r2     // Catch: java.lang.Throwable -> L32
            r0.d = r13     // Catch: java.lang.Throwable -> L32
            r0.e = r12     // Catch: java.lang.Throwable -> L32
            r0.f3639h = r4     // Catch: java.lang.Throwable -> L32
            java.lang.Object r14 = r6.D(r4, r0)     // Catch: java.lang.Throwable -> L32
            if (r14 != r1) goto L8e
            return r1
        L8e:
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch: java.lang.Throwable -> L32
            boolean r14 = r14.booleanValue()     // Catch: java.lang.Throwable -> L32
            if (r14 == 0) goto L98
            r14 = r4
            goto L99
        L98:
            r14 = r3
        L99:
            if (r14 == 0) goto La0
            J1.b r12 = J1.c.f(r13, r4, r12)     // Catch: java.lang.Throwable -> L32
            goto L54
        La0:
            r13.a()     // Catch: java.lang.Throwable -> Lae
            java.lang.Throwable r12 = r6.getClosedCause()     // Catch: java.lang.Throwable -> Lae
            if (r12 != 0) goto Lb1
            I1.d r12 = r5.c()     // Catch: java.lang.Throwable -> Lae
            return r12
        Lae:
            r12 = move-exception
            r14 = r5
            goto Lb7
        Lb1:
            throw r12     // Catch: java.lang.Throwable -> Lae
        Lb2:
            r13.a()     // Catch: java.lang.Throwable -> Lae
            throw r12     // Catch: java.lang.Throwable -> Lae
        Lb6:
            r12 = move-exception
        Lb7:
            r14.close()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.C(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object D(int i, Continuation continuation) throws Throwable {
        if (((io.ktor.utils.io.internal.p) this._state).b._availableForRead$internal >= i) {
            return Boolean.TRUE;
        }
        io.ktor.utils.io.internal.c cVar = (io.ktor.utils.io.internal.c) this._closed;
        if (cVar == null) {
            return i == 1 ? E(1, continuation) : F(i, continuation);
        }
        Throwable th = cVar.f3582a;
        if (th != null) {
            AbstractC0132a.b(th);
            throw null;
        }
        io.ktor.utils.io.internal.r rVar = ((io.ktor.utils.io.internal.p) this._state).b;
        boolean z6 = rVar.c() && rVar._availableForRead$internal >= i;
        if (((Continuation) this._readOp) == null) {
            return Boolean.valueOf(z6);
        }
        throw new IllegalStateException("Read operation is already in progress");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object E(int r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.C0557x
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.x r0 = (io.ktor.utils.io.C0557x) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            io.ktor.utils.io.x r0 = new io.ktor.utils.io.x
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.b
            T1.a r1 = T1.a.f1304a
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            io.ktor.utils.io.U r5 = r0.f3641a
            kotlin.reflect.l.e0(r6)     // Catch: java.lang.Throwable -> L29
            return r6
        L29:
            r6 = move-exception
            goto L57
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.reflect.l.e0(r6)
            java.lang.Object r6 = r4._state
            io.ktor.utils.io.internal.p r6 = (io.ktor.utils.io.internal.p) r6
            io.ktor.utils.io.internal.r r6 = r6.b
            int r6 = r6._availableForRead$internal
            if (r6 >= r5) goto L5b
            r0.f3641a = r4     // Catch: java.lang.Throwable -> L55
            r0.d = r3     // Catch: java.lang.Throwable -> L55
            io.ktor.utils.io.internal.b r6 = r4.f3540h     // Catch: java.lang.Throwable -> L55
            r4.Q(r5, r6)     // Catch: java.lang.Throwable -> L55
            kotlin.coroutines.Continuation r5 = C5.f.J(r0)     // Catch: java.lang.Throwable -> L55
            java.lang.Object r5 = r6.c(r5)     // Catch: java.lang.Throwable -> L55
            if (r5 != r1) goto L54
            return r1
        L54:
            return r5
        L55:
            r6 = move-exception
            r5 = r4
        L57:
            r0 = 0
            r5._readOp = r0
            throw r6
        L5b:
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.E(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0082 -> B:40:0x0085). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object F(int r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.C0558y
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.y r0 = (io.ktor.utils.io.C0558y) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            io.ktor.utils.io.y r0 = new io.ktor.utils.io.y
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.c
            T1.a r1 = T1.a.f1304a
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            int r5 = r0.b
            io.ktor.utils.io.U r2 = r0.f3642a
            kotlin.reflect.l.e0(r6)
            goto L85
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.reflect.l.e0(r6)
            r2 = r4
        L37:
            java.lang.Object r6 = r2._state
            io.ktor.utils.io.internal.p r6 = (io.ktor.utils.io.internal.p) r6
            io.ktor.utils.io.internal.r r6 = r6.b
            int r6 = r6._availableForRead$internal
            if (r6 < r5) goto L44
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            return r5
        L44:
            java.lang.Object r6 = r2._closed
            io.ktor.utils.io.internal.c r6 = (io.ktor.utils.io.internal.c) r6
            if (r6 == 0) goto L78
            java.lang.Throwable r6 = r6.f3582a
            if (r6 != 0) goto L73
            java.lang.Object r6 = r2._state
            io.ktor.utils.io.internal.p r6 = (io.ktor.utils.io.internal.p) r6
            io.ktor.utils.io.internal.r r6 = r6.b
            boolean r0 = r6.c()
            if (r0 == 0) goto L5f
            int r6 = r6._availableForRead$internal
            if (r6 < r5) goto L5f
            goto L60
        L5f:
            r3 = 0
        L60:
            java.lang.Object r5 = r2._readOp
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            if (r5 != 0) goto L6b
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
            return r5
        L6b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "Read operation is already in progress"
            r5.<init>(r6)
            throw r5
        L73:
            a.AbstractC0132a.b(r6)
            r5 = 0
            throw r5
        L78:
            r0.f3642a = r2
            r0.b = r5
            r0.e = r3
            java.lang.Object r6 = r2.E(r5, r0)
            if (r6 != r1) goto L85
            return r1
        L85:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L37
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.F(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:(1:82)|35|36|80|37|38|88|39|(9:42|20|43|23|(7:25|34|49|(0)|52|(1:54)|63)(0)|64|(0)(0)|74|75)) */
    /* JADX WARN: Can't wrap try/catch for region: R(9:82|35|36|80|37|38|88|39|(9:42|20|43|23|(7:25|34|49|(0)|52|(1:54)|63)(0)|64|(0)(0)|74|75)) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0116, code lost:
    
        r20 = r9;
        r21 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x011a, code lost:
    
        r9 = r18;
        r8 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x011e, code lost:
    
        r0 = r16;
        r12 = r17;
        r8 = r18;
        r7 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0166, code lost:
    
        if (r1.read(1, r5, r4) == r3) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0070, code lost:
    
        r9 = r8;
        r8 = r7;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x010c -> B:20:0x0070). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object H(java.lang.Appendable r23, int r24, kotlin.coroutines.Continuation r25) {
        /*
            Method dump skipped, instruction units count: 395
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.H(java.lang.Appendable, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void I(io.ktor.utils.io.internal.k kVar) {
        this.b.recycle(kVar);
    }

    public final void J() {
        io.ktor.utils.io.internal.p pVarF;
        io.ktor.utils.io.internal.p pVar = null;
        loop0: while (true) {
            Object obj = this._state;
            io.ktor.utils.io.internal.p pVar2 = (io.ktor.utils.io.internal.p) obj;
            io.ktor.utils.io.internal.j jVar = (io.ktor.utils.io.internal.j) pVar;
            if (jVar != null) {
                jVar.b.f();
                M();
                pVar = null;
            }
            pVarF = pVar2.f();
            if ((pVarF instanceof io.ktor.utils.io.internal.j) && ((io.ktor.utils.io.internal.p) this._state) == pVar2 && pVarF.b.g()) {
                pVarF = io.ktor.utils.io.internal.i.c;
                pVar = pVarF;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3533k;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, pVarF)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
        }
        io.ktor.utils.io.internal.i iVar = io.ktor.utils.io.internal.i.c;
        if (pVarF == iVar) {
            io.ktor.utils.io.internal.j jVar2 = (io.ktor.utils.io.internal.j) pVar;
            if (jVar2 != null) {
                I(jVar2.c);
            }
            M();
            return;
        }
        if (pVarF instanceof io.ktor.utils.io.internal.j) {
            io.ktor.utils.io.internal.r rVar = pVarF.b;
            if (rVar._availableForWrite$internal == rVar.f3590a && pVarF.b.g()) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f3533k;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, pVarF, iVar)) {
                    if (atomicReferenceFieldUpdater2.get(this) != pVarF) {
                        return;
                    }
                }
                pVarF.b.f();
                I(((io.ktor.utils.io.internal.j) pVarF).c);
                M();
            }
        }
    }

    public final void K() {
        io.ktor.utils.io.internal.p pVarG;
        io.ktor.utils.io.internal.j jVar;
        io.ktor.utils.io.internal.p pVar = null;
        loop0: while (true) {
            Object obj = this._state;
            pVarG = ((io.ktor.utils.io.internal.p) obj).g();
            if (pVarG instanceof io.ktor.utils.io.internal.j) {
                io.ktor.utils.io.internal.r rVar = pVarG.b;
                if (rVar._availableForWrite$internal == rVar.f3590a) {
                    pVarG = io.ktor.utils.io.internal.i.c;
                    pVar = pVarG;
                }
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3533k;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, pVarG)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
        }
        if (pVarG != io.ktor.utils.io.internal.i.c || (jVar = (io.ktor.utils.io.internal.j) pVar) == null) {
            return;
        }
        I(jVar.c);
    }

    public final void L() {
        Continuation continuation = (Continuation) f3535m.getAndSet(this, null);
        if (continuation != null) {
            io.ktor.utils.io.internal.c cVar = (io.ktor.utils.io.internal.c) this._closed;
            Throwable th = cVar != null ? cVar.f3582a : null;
            if (th != null) {
                continuation.resumeWith(kotlin.reflect.l.n(th));
            } else {
                continuation.resumeWith(Boolean.TRUE);
            }
        }
    }

    public final void M() {
        while (true) {
            Continuation continuation = (Continuation) this._writeOp;
            if (continuation == null) {
                return;
            }
            io.ktor.utils.io.internal.c cVar = (io.ktor.utils.io.internal.c) this._closed;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3536n;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, continuation, null)) {
                if (atomicReferenceFieldUpdater.get(this) != continuation) {
                    break;
                }
            }
            if (cVar == null) {
                continuation.resumeWith(N1.m.f1129a);
                return;
            } else {
                continuation.resumeWith(kotlin.reflect.l.n(cVar.a()));
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x003c, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.nio.ByteBuffer O() throws java.lang.Throwable {
        /*
            r4 = this;
        L0:
            java.lang.Object r0 = r4._state
            r1 = r0
            io.ktor.utils.io.internal.p r1 = (io.ktor.utils.io.internal.p) r1
            io.ktor.utils.io.internal.n r2 = io.ktor.utils.io.internal.n.c
            boolean r2 = kotlin.jvm.internal.h.a(r1, r2)
            if (r2 == 0) goto Lf
            r2 = 1
            goto L15
        Lf:
            io.ktor.utils.io.internal.i r2 = io.ktor.utils.io.internal.i.c
            boolean r2 = kotlin.jvm.internal.h.a(r1, r2)
        L15:
            r3 = 0
            if (r2 == 0) goto L27
            java.lang.Object r0 = r4._closed
            io.ktor.utils.io.internal.c r0 = (io.ktor.utils.io.internal.c) r0
            if (r0 == 0) goto L3c
            java.lang.Throwable r0 = r0.f3582a
            if (r0 != 0) goto L23
            goto L3c
        L23:
            a.AbstractC0132a.b(r0)
            throw r3
        L27:
            java.lang.Object r2 = r4._closed
            io.ktor.utils.io.internal.c r2 = (io.ktor.utils.io.internal.c) r2
            if (r2 == 0) goto L36
            java.lang.Throwable r2 = r2.f3582a
            if (r2 != 0) goto L32
            goto L36
        L32:
            a.AbstractC0132a.b(r2)
            throw r3
        L36:
            io.ktor.utils.io.internal.r r2 = r1.b
            int r2 = r2._availableForRead$internal
            if (r2 != 0) goto L3d
        L3c:
            return r3
        L3d:
            io.ktor.utils.io.internal.p r1 = r1.d()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = io.ktor.utils.io.U.f3533k
        L43:
            boolean r3 = r2.compareAndSet(r4, r0, r1)
            if (r3 == 0) goto L57
            java.nio.ByteBuffer r0 = r1.b()
            int r2 = r4.d
            io.ktor.utils.io.internal.r r1 = r1.b
            int r1 = r1._availableForRead$internal
            r4.p(r0, r2, r1)
            return r0
        L57:
            java.lang.Object r3 = r2.get(r4)
            if (r3 == r0) goto L43
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.O():java.nio.ByteBuffer");
    }

    public final ByteBuffer P() throws Throwable {
        io.ktor.utils.io.internal.p pVarE;
        io.ktor.utils.io.internal.k kVar;
        Continuation continuation = (Continuation) this._writeOp;
        if (continuation != null) {
            throw new IllegalStateException("Write operation is already in progress: " + continuation);
        }
        io.ktor.utils.io.internal.k kVar2 = null;
        while (true) {
            Object obj = this._state;
            io.ktor.utils.io.internal.p pVar = (io.ktor.utils.io.internal.p) obj;
            if (((io.ktor.utils.io.internal.c) this._closed) != null) {
                if (kVar2 != null) {
                    I(kVar2);
                }
                io.ktor.utils.io.internal.c cVar = (io.ktor.utils.io.internal.c) this._closed;
                kotlin.jvm.internal.h.c(cVar);
                AbstractC0132a.b(cVar.a());
                throw null;
            }
            if (pVar == io.ktor.utils.io.internal.i.c) {
                if (kVar2 == null) {
                    kVar2 = (io.ktor.utils.io.internal.k) this.b.borrow();
                    kVar2.b.f();
                }
                pVarE = kVar2.f3586g;
            } else {
                if (pVar == io.ktor.utils.io.internal.n.c) {
                    if (kVar2 != null) {
                        I(kVar2);
                    }
                    io.ktor.utils.io.internal.c cVar2 = (io.ktor.utils.io.internal.c) this._closed;
                    kotlin.jvm.internal.h.c(cVar2);
                    AbstractC0132a.b(cVar2.a());
                    throw null;
                }
                pVarE = pVar.e();
            }
            io.ktor.utils.io.internal.p pVar2 = pVarE;
            kVar = kVar2;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3533k;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, pVar2)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            if (((io.ktor.utils.io.internal.c) this._closed) != null) {
                K();
                R();
                io.ktor.utils.io.internal.c cVar3 = (io.ktor.utils.io.internal.c) this._closed;
                kotlin.jvm.internal.h.c(cVar3);
                AbstractC0132a.b(cVar3.a());
                throw null;
            }
            ByteBuffer byteBufferC = pVar2.c();
            if (kVar != null) {
                if (pVar == null) {
                    kotlin.jvm.internal.h.n("old");
                    throw null;
                }
                if (pVar != io.ktor.utils.io.internal.i.c) {
                    I(kVar);
                }
            }
            p(byteBufferC, this.e, pVar2.b._availableForWrite$internal);
            return byteBufferC;
            kVar2 = kVar;
        }
    }

    public final void Q(int i, Continuation continuation) {
        while (((io.ktor.utils.io.internal.p) this._state).b._availableForRead$internal < i) {
            io.ktor.utils.io.internal.c cVar = (io.ktor.utils.io.internal.c) this._closed;
            if (cVar != null) {
                Throwable th = cVar.f3582a;
                if (th != null) {
                    continuation.resumeWith(kotlin.reflect.l.n(th));
                    return;
                }
                boolean zC = ((io.ktor.utils.io.internal.p) this._state).b.c();
                boolean z6 = false;
                boolean z7 = ((io.ktor.utils.io.internal.p) this._state).b._availableForRead$internal >= i;
                if (zC && z7) {
                    z6 = true;
                }
                continuation.resumeWith(Boolean.valueOf(z6));
                return;
            }
            while (((Continuation) this._readOp) == null) {
                if (((io.ktor.utils.io.internal.c) this._closed) != null || ((io.ktor.utils.io.internal.p) this._state).b._availableForRead$internal >= i) {
                    break;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3535m;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, null, continuation)) {
                    if (atomicReferenceFieldUpdater.get(this) != null) {
                        break;
                    }
                }
                if (((io.ktor.utils.io.internal.c) this._closed) == null && ((io.ktor.utils.io.internal.p) this._state).b._availableForRead$internal < i) {
                    return;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f3535m;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, continuation, null)) {
                    if (atomicReferenceFieldUpdater2.get(this) != continuation) {
                        return;
                    }
                }
            }
            throw new IllegalStateException("Operation is already in progress");
        }
        continuation.resumeWith(Boolean.TRUE);
    }

    public final void R() {
        if (((io.ktor.utils.io.internal.c) this._closed) != null) {
            io.ktor.utils.io.internal.k kVar = null;
            while (true) {
                Object obj = this._state;
                io.ktor.utils.io.internal.p pVar = (io.ktor.utils.io.internal.p) obj;
                io.ktor.utils.io.internal.c cVar = (io.ktor.utils.io.internal.c) this._closed;
                if (kVar != null) {
                    if ((cVar != null ? cVar.f3582a : null) == null) {
                        kVar.b.f();
                    }
                    M();
                    kVar = null;
                }
                io.ktor.utils.io.internal.n nVar = io.ktor.utils.io.internal.n.c;
                if (pVar == nVar) {
                    break;
                }
                if (pVar != io.ktor.utils.io.internal.i.c) {
                    if (cVar == null || !(pVar instanceof io.ktor.utils.io.internal.j)) {
                        return;
                    }
                    if (!pVar.b.g() && cVar.f3582a == null) {
                        return;
                    }
                    if (cVar.f3582a != null) {
                        io.ktor.utils.io.internal.r rVar = pVar.b;
                        rVar.getClass();
                        io.ktor.utils.io.internal.r.c.getAndSet(rVar, 0);
                    }
                    kVar = ((io.ktor.utils.io.internal.j) pVar).c;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3533k;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, nVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                if (kVar != null && ((io.ktor.utils.io.internal.p) this._state) == io.ktor.utils.io.internal.n.c) {
                    I(kVar);
                }
            }
            L();
            M();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0040 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int S(I1.d r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.nio.ByteBuffer r0 = r7.P()
            java.lang.Object r1 = r7._state
            io.ktor.utils.io.internal.p r1 = (io.ktor.utils.io.internal.p) r1
            io.ktor.utils.io.internal.r r1 = r1.b
            r2 = 1
            java.lang.Object r3 = r7._closed     // Catch: java.lang.Throwable -> L34
            io.ktor.utils.io.internal.c r3 = (io.ktor.utils.io.internal.c) r3     // Catch: java.lang.Throwable -> L34
            if (r3 != 0) goto L4a
            long r3 = r8.f()     // Catch: java.lang.Throwable -> L34
            int r5 = r0.remaining()     // Catch: java.lang.Throwable -> L34
            long r5 = (long) r5     // Catch: java.lang.Throwable -> L34
            long r3 = java.lang.Math.min(r3, r5)     // Catch: java.lang.Throwable -> L34
            int r3 = (int) r3     // Catch: java.lang.Throwable -> L34
            int r3 = r1.j(r3)     // Catch: java.lang.Throwable -> L34
            if (r3 <= 0) goto L36
            int r4 = r0.position()     // Catch: java.lang.Throwable -> L34
            int r4 = r4 + r3
            r0.limit(r4)     // Catch: java.lang.Throwable -> L34
            C5.f.X(r8, r0)     // Catch: java.lang.Throwable -> L34
            r7.g(r0, r1, r3)     // Catch: java.lang.Throwable -> L34
            goto L36
        L34:
            r8 = move-exception
            goto L53
        L36:
            boolean r8 = r1.d()
            if (r8 != 0) goto L40
            boolean r8 = r7.f3537a
            if (r8 == 0) goto L43
        L40:
            r7.m(r2)
        L43:
            r7.K()
            r7.R()
            return r3
        L4a:
            java.lang.Throwable r8 = r3.a()     // Catch: java.lang.Throwable -> L34
            a.AbstractC0132a.b(r8)     // Catch: java.lang.Throwable -> L34
            r8 = 0
            throw r8     // Catch: java.lang.Throwable -> L34
        L53:
            boolean r0 = r1.d()
            if (r0 != 0) goto L5d
            boolean r0 = r7.f3537a
            if (r0 == 0) goto L60
        L5d:
            r7.m(r2)
        L60:
            r7.K()
            r7.R()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.S(I1.d):int");
    }

    public final Object T(int i, Continuation continuation) {
        boolean zK0 = k0(i);
        N1.m mVar = N1.m.f1129a;
        if (zK0) {
            this.writeSuspensionSize = i;
            Job job = this.attachedJob;
            T1.a aVar = T1.a.f1304a;
            if (job != null) {
                this.f3541j.invoke(continuation);
                U1.d.a(continuation);
                return aVar;
            }
            io.ktor.utils.io.internal.b bVar = this.i;
            this.f3541j.invoke(bVar);
            Object objC = bVar.c(C5.f.J(continuation));
            if (objC == aVar) {
                return objC;
            }
        } else {
            io.ktor.utils.io.internal.c cVar = (io.ktor.utils.io.internal.c) this._closed;
            if (cVar != null) {
                AbstractC0132a.b(cVar.a());
                throw null;
            }
        }
        return mVar;
    }

    public final int V(I1.a aVar) throws Throwable {
        ByteBuffer byteBufferP = P();
        io.ktor.utils.io.internal.r rVar = ((io.ktor.utils.io.internal.p) this._state).b;
        try {
            io.ktor.utils.io.internal.c cVar = (io.ktor.utils.io.internal.c) this._closed;
            if (cVar != null) {
                AbstractC0132a.b(cVar.a());
                throw null;
            }
            int i = 0;
            while (true) {
                int iJ = rVar.j(Math.min(aVar.c - aVar.b, byteBufferP.remaining()));
                if (iJ == 0) {
                    break;
                }
                kotlin.reflect.l.U(aVar, byteBufferP, iJ);
                i += iJ;
                p(byteBufferP, i(byteBufferP, this.e + i), rVar._availableForWrite$internal);
            }
            g(byteBufferP, rVar, i);
            if (rVar.d() || this.f3537a) {
                m(1);
            }
            K();
            R();
            return i;
        } catch (Throwable th) {
            if (rVar.d() || this.f3537a) {
                m(1);
            }
            K();
            R();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:
    
        r8.limit(r3);
        g(r0, r1, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
    
        if (r1.d() != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005f, code lost:
    
        if (r7.f3537a == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0061, code lost:
    
        m(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0064, code lost:
    
        K();
        R();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006a, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int W(java.nio.ByteBuffer r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.nio.ByteBuffer r0 = r7.P()
            java.lang.Object r1 = r7._state
            io.ktor.utils.io.internal.p r1 = (io.ktor.utils.io.internal.p) r1
            io.ktor.utils.io.internal.r r1 = r1.b
            r2 = 1
            java.lang.Object r3 = r7._closed     // Catch: java.lang.Throwable -> L47
            io.ktor.utils.io.internal.c r3 = (io.ktor.utils.io.internal.c) r3     // Catch: java.lang.Throwable -> L47
            if (r3 != 0) goto L6b
            int r3 = r8.limit()     // Catch: java.lang.Throwable -> L47
            r4 = 0
        L16:
            int r5 = r8.position()     // Catch: java.lang.Throwable -> L47
            int r5 = r3 - r5
            if (r5 == 0) goto L51
            int r6 = r0.remaining()     // Catch: java.lang.Throwable -> L47
            int r5 = java.lang.Math.min(r5, r6)     // Catch: java.lang.Throwable -> L47
            int r5 = r1.j(r5)     // Catch: java.lang.Throwable -> L47
            if (r5 == 0) goto L51
            if (r5 <= 0) goto L49
            int r6 = r8.position()     // Catch: java.lang.Throwable -> L47
            int r6 = r6 + r5
            r8.limit(r6)     // Catch: java.lang.Throwable -> L47
            r0.put(r8)     // Catch: java.lang.Throwable -> L47
            int r4 = r4 + r5
            int r5 = r7.e     // Catch: java.lang.Throwable -> L47
            int r5 = r5 + r4
            int r5 = r7.i(r0, r5)     // Catch: java.lang.Throwable -> L47
            int r6 = r1._availableForWrite$internal     // Catch: java.lang.Throwable -> L47
            r7.p(r0, r5, r6)     // Catch: java.lang.Throwable -> L47
            goto L16
        L47:
            r8 = move-exception
            goto L74
        L49:
            java.lang.String r8 = "Failed requirement."
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L47
            r0.<init>(r8)     // Catch: java.lang.Throwable -> L47
            throw r0     // Catch: java.lang.Throwable -> L47
        L51:
            r8.limit(r3)     // Catch: java.lang.Throwable -> L47
            r7.g(r0, r1, r4)     // Catch: java.lang.Throwable -> L47
            boolean r8 = r1.d()
            if (r8 != 0) goto L61
            boolean r8 = r7.f3537a
            if (r8 == 0) goto L64
        L61:
            r7.m(r2)
        L64:
            r7.K()
            r7.R()
            return r4
        L6b:
            java.lang.Throwable r8 = r3.a()     // Catch: java.lang.Throwable -> L47
            a.AbstractC0132a.b(r8)     // Catch: java.lang.Throwable -> L47
            r8 = 0
            throw r8     // Catch: java.lang.Throwable -> L47
        L74:
            boolean r0 = r1.d()
            if (r0 != 0) goto L7e
            boolean r0 = r7.f3537a
            if (r0 == 0) goto L81
        L7e:
            r7.m(r2)
        L81:
            r7.K()
            r7.R()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.W(java.nio.ByteBuffer):int");
    }

    public final int X(byte[] bArr, int i, int i3) throws Throwable {
        ByteBuffer byteBufferP = P();
        io.ktor.utils.io.internal.r rVar = ((io.ktor.utils.io.internal.p) this._state).b;
        try {
            io.ktor.utils.io.internal.c cVar = (io.ktor.utils.io.internal.c) this._closed;
            if (cVar != null) {
                AbstractC0132a.b(cVar.a());
                throw null;
            }
            int i4 = 0;
            while (true) {
                int iJ = rVar.j(Math.min(i3 - i4, byteBufferP.remaining()));
                if (iJ == 0) {
                    g(byteBufferP, rVar, i4);
                    if (rVar.d() || this.f3537a) {
                        m(1);
                    }
                    K();
                    R();
                    return i4;
                }
                if (iJ <= 0) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                byteBufferP.put(bArr, i + i4, iJ);
                i4 += iJ;
                p(byteBufferP, i(byteBufferP, this.e + i4), rVar._availableForWrite$internal);
            }
        } catch (Throwable th) {
            if (rVar.d() || this.f3537a) {
                m(1);
            }
            K();
            R();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Y(J1.b r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.F
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.F r0 = (io.ktor.utils.io.F) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            io.ktor.utils.io.F r0 = new io.ktor.utils.io.F
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.c
            T1.a r1 = T1.a.f1304a
            int r2 = r0.e
            r3 = 3
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L39
            r6 = 2
            if (r2 == r6) goto L35
            if (r2 != r3) goto L2d
            kotlin.reflect.l.e0(r7)
            return r7
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            kotlin.reflect.l.e0(r7)
            return r7
        L39:
            J1.b r6 = r0.b
            io.ktor.utils.io.U r2 = r0.f3496a
            kotlin.reflect.l.e0(r7)
            goto L52
        L41:
            kotlin.reflect.l.e0(r7)
            r0.f3496a = r5
            r0.b = r6
            r0.e = r4
            java.lang.Object r7 = r5.i0(r4, r0)
            if (r7 != r1) goto L51
            goto L62
        L51:
            r2 = r5
        L52:
            r2.getClass()
            r7 = 0
            r0.f3496a = r7
            r0.b = r7
            r0.e = r3
            java.lang.Object r6 = r2.writeAvailable(r6, r0)
            if (r6 != r1) goto L63
        L62:
            return r1
        L63:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.Y(J1.b, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Z(java.nio.ByteBuffer r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.E
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.E r0 = (io.ktor.utils.io.E) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            io.ktor.utils.io.E r0 = new io.ktor.utils.io.E
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.c
            T1.a r1 = T1.a.f1304a
            int r2 = r0.e
            r3 = 3
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L39
            r6 = 2
            if (r2 == r6) goto L35
            if (r2 != r3) goto L2d
            kotlin.reflect.l.e0(r7)
            return r7
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            kotlin.reflect.l.e0(r7)
            return r7
        L39:
            java.nio.ByteBuffer r6 = r0.b
            io.ktor.utils.io.U r2 = r0.f3495a
            kotlin.reflect.l.e0(r7)
            goto L52
        L41:
            kotlin.reflect.l.e0(r7)
            r0.f3495a = r5
            r0.b = r6
            r0.e = r4
            java.lang.Object r7 = r5.i0(r4, r0)
            if (r7 != r1) goto L51
            goto L62
        L51:
            r2 = r5
        L52:
            r2.getClass()
            r7 = 0
            r0.f3495a = r7
            r0.b = r7
            r0.e = r3
            java.lang.Object r6 = r2.writeAvailable(r6, r0)
            if (r6 != r1) goto L63
        L62:
            return r1
        L63:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.Z(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteChannel
    public final void attachJob(Job job) {
        kotlin.jvm.internal.h.f(job, "job");
        Job job2 = this.attachedJob;
        if (job2 != null) {
            job2.cancel((CancellationException) null);
        }
        this.attachedJob = job;
        job.invokeOnCompletion((1 & 1) == 0, (1 & 2) != 0, new S(this, 1));
    }

    @Override // io.ktor.utils.io.LookAheadSuspendSession
    public final Object awaitAtLeast(int i, Continuation continuation) throws Throwable {
        if (i < 0) {
            throw new IllegalArgumentException(B2.b.c(i, "atLeast parameter shouldn't be negative: ").toString());
        }
        if (i > 4088) {
            throw new IllegalArgumentException(B2.b.c(i, "atLeast parameter shouldn't be larger than max buffer size of 4088: ").toString());
        }
        if (((io.ktor.utils.io.internal.p) this._state).b._availableForRead$internal < i) {
            return (((io.ktor.utils.io.internal.p) this._state).a() || (((io.ktor.utils.io.internal.p) this._state) instanceof io.ktor.utils.io.internal.o)) ? d(i, continuation) : i == 1 ? E(1, continuation) : D(i, continuation);
        }
        if (((io.ktor.utils.io.internal.p) this._state).a() || (((io.ktor.utils.io.internal.p) this._state) instanceof io.ktor.utils.io.internal.o)) {
            O();
        }
        return Boolean.TRUE;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object awaitContent(Continuation continuation) throws Throwable {
        Object objD = D(1, continuation);
        return objD == T1.a.f1304a ? objD : N1.m.f1129a;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object awaitFreeSpace(Continuation continuation) throws Throwable {
        Object objI0 = i0(1, continuation);
        return objI0 == T1.a.f1304a ? objI0 : N1.m.f1129a;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0050 -> B:24:0x0053). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b0(I1.a r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.I
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.utils.io.I r0 = (io.ktor.utils.io.I) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            io.ktor.utils.io.I r0 = new io.ktor.utils.io.I
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.c
            T1.a r1 = T1.a.f1304a
            int r2 = r0.e
            N1.m r3 = N1.m.f1129a
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            r7 = 2
            if (r2 != r7) goto L2c
            kotlin.reflect.l.e0(r8)
            return r3
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            I1.a r7 = r0.b
            io.ktor.utils.io.U r2 = r0.f3502a
            kotlin.reflect.l.e0(r8)
            goto L53
        L3c:
            kotlin.reflect.l.e0(r8)
            r2 = r6
        L40:
            int r8 = r7.c
            int r5 = r7.b
            if (r8 <= r5) goto L5a
            r0.f3502a = r2
            r0.b = r7
            r0.e = r4
            java.lang.Object r8 = r2.T(r4, r0)
            if (r8 != r1) goto L53
            return r1
        L53:
            r2.getClass()
            r2.V(r7)
            goto L40
        L5a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.b0(I1.a, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.HasWriteSession
    public final WriterSuspendSession beginWriteSession() {
        Y0.b bVar = this.f3539g;
        bVar.b();
        return bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0050 -> B:24:0x0053). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c0(java.nio.ByteBuffer r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.H
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.H r0 = (io.ktor.utils.io.H) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            io.ktor.utils.io.H r0 = new io.ktor.utils.io.H
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.c
            T1.a r1 = T1.a.f1304a
            int r2 = r0.e
            N1.m r3 = N1.m.f1129a
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            r6 = 2
            if (r2 != r6) goto L2c
            kotlin.reflect.l.e0(r7)
            return r3
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            java.nio.ByteBuffer r6 = r0.b
            io.ktor.utils.io.U r2 = r0.f3501a
            kotlin.reflect.l.e0(r7)
            goto L53
        L3c:
            kotlin.reflect.l.e0(r7)
            r2 = r5
        L40:
            boolean r7 = r6.hasRemaining()
            if (r7 == 0) goto L5a
            r0.f3501a = r2
            r0.b = r6
            r0.e = r4
            java.lang.Object r7 = r2.T(r4, r0)
            if (r7 != r1) goto L53
            return r1
        L53:
            r2.getClass()
            r2.W(r6)
            goto L40
        L5a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.c0(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final boolean cancel(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel has been cancelled");
        }
        return close(th);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean close(Throwable th) {
        if (((io.ktor.utils.io.internal.c) this._closed) == null) {
            io.ktor.utils.io.internal.c cVar = th == null ? io.ktor.utils.io.internal.c.b : new io.ktor.utils.io.internal.c(th);
            ((io.ktor.utils.io.internal.p) this._state).b.c();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3534l;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, cVar)) {
                if (atomicReferenceFieldUpdater.get(this) != null) {
                }
            }
            ((io.ktor.utils.io.internal.p) this._state).b.c();
            io.ktor.utils.io.internal.r rVar = ((io.ktor.utils.io.internal.p) this._state).b;
            if (rVar._availableForWrite$internal == rVar.f3590a || th != null) {
                R();
            }
            Continuation continuation = (Continuation) f3535m.getAndSet(this, null);
            if (continuation != null) {
                if (th != null) {
                    continuation.resumeWith(kotlin.reflect.l.n(th));
                } else {
                    continuation.resumeWith(Boolean.valueOf(((io.ktor.utils.io.internal.p) this._state).b._availableForRead$internal > 0));
                }
            }
            Continuation continuation2 = (Continuation) f3536n.getAndSet(this, null);
            if (continuation2 != null) {
                continuation2.resumeWith(kotlin.reflect.l.n(th == null ? new e0("Byte channel was closed") : th));
            }
            io.ktor.utils.io.internal.n nVar = io.ktor.utils.io.internal.n.c;
            if (th != null) {
                Job job = this.attachedJob;
                if (job != null) {
                    job.cancel((CancellationException) null);
                }
                this.f3540h.b(th);
                this.i.b(th);
                return true;
            }
            this.i.b(new e0("Byte channel was closed"));
            io.ktor.utils.io.internal.b bVar = this.f3540h;
            Boolean boolValueOf = Boolean.valueOf(((io.ktor.utils.io.internal.p) this._state).b.c());
            bVar.getClass();
            bVar.resumeWith(boolValueOf);
            io.ktor.utils.io.internal.a aVar = (io.ktor.utils.io.internal.a) io.ktor.utils.io.internal.b.b.getAndSet(bVar, null);
            if (aVar != null) {
                aVar.a();
            }
            return true;
        }
        return false;
    }

    @Override // io.ktor.utils.io.LookAheadSession
    public final void consumed(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        io.ktor.utils.io.internal.p pVar = (io.ktor.utils.io.internal.p) this._state;
        if (!pVar.b.i(i)) {
            throw new IllegalStateException(B2.b.d(i, "Unable to consume ", " bytes: not enough available bytes"));
        }
        if (i > 0) {
            f(pVar.b(), pVar.b, i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(int r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.C0535a
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.a r0 = (io.ktor.utils.io.C0535a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            io.ktor.utils.io.a r0 = new io.ktor.utils.io.a
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.b
            T1.a r1 = T1.a.f1304a
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            io.ktor.utils.io.U r5 = r0.f3549a
            kotlin.reflect.l.e0(r6)
            goto L40
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.reflect.l.e0(r6)
            r0.f3549a = r4
            r0.d = r3
            java.lang.Object r6 = r4.D(r5, r0)
            if (r6 != r1) goto L3f
            return r1
        L3f:
            r5 = r4
        L40:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r0 = r6.booleanValue()
            if (r0 == 0) goto L55
            java.lang.Object r0 = r5._state
            io.ktor.utils.io.internal.p r0 = (io.ktor.utils.io.internal.p) r0
            boolean r0 = r0.a()
            if (r0 == 0) goto L55
            r5.O()
        L55:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.d(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004e -> B:20:0x0051). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d0(byte[] r6, int r7, int r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r9 instanceof io.ktor.utils.io.J
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.utils.io.J r0 = (io.ktor.utils.io.J) r0
            int r1 = r0.f3505g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3505g = r1
            goto L18
        L13:
            io.ktor.utils.io.J r0 = new io.ktor.utils.io.J
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.e
            T1.a r1 = T1.a.f1304a
            int r2 = r0.f3505g
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            int r6 = r0.d
            int r7 = r0.c
            byte[] r8 = r0.b
            io.ktor.utils.io.U r2 = r0.f3503a
            kotlin.reflect.l.e0(r9)
            goto L51
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            kotlin.reflect.l.e0(r9)
            r2 = r5
        L3b:
            if (r8 <= 0) goto L5d
            r0.f3503a = r2
            r0.b = r6
            r0.c = r7
            r0.d = r8
            r0.f3505g = r3
            java.lang.Object r9 = r2.writeAvailable(r6, r7, r8, r0)
            if (r9 != r1) goto L4e
            return r1
        L4e:
            r4 = r8
            r8 = r6
            r6 = r4
        L51:
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            int r7 = r7 + r9
            int r6 = r6 - r9
            r4 = r8
            r8 = r6
            r6 = r4
            goto L3b
        L5d:
            N1.m r6 = N1.m.f1129a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.d0(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object discard(long j6, Continuation continuation) throws Throwable {
        long j7 = 0;
        if (j6 < 0) {
            throw new IllegalArgumentException(("max shouldn't be negative: " + j6).toString());
        }
        ByteBuffer byteBufferO = O();
        if (byteBufferO != null) {
            io.ktor.utils.io.internal.r rVar = ((io.ktor.utils.io.internal.p) this._state).b;
            try {
                if (rVar._availableForRead$internal != 0) {
                    int iH = rVar.h((int) Math.min(2147483647L, j6));
                    f(byteBufferO, rVar, iH);
                    j7 = iH;
                }
            } finally {
                J();
                R();
            }
        }
        long j8 = j7;
        return (j8 == j6 || isClosedForRead()) ? new Long(j8) : l(j8, j6, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(int r6, kotlin.jvm.functions.Function1 r7, U1.c r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.C0536b
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.utils.io.b r0 = (io.ktor.utils.io.C0536b) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            io.ktor.utils.io.b r0 = new io.ktor.utils.io.b
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.c
            T1.a r1 = T1.a.f1304a
            int r2 = r0.e
            N1.m r3 = N1.m.f1129a
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L34
            r6 = 2
            if (r2 != r6) goto L2c
            kotlin.reflect.l.e0(r8)
            return r3
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            io.ktor.utils.io.U r6 = r0.f3551a
            kotlin.reflect.l.e0(r8)
            goto L4b
        L3a:
            kotlin.reflect.l.e0(r8)
            r0.f3551a = r5
            r0.b = r7
            r0.e = r4
            java.lang.Object r6 = r5.i0(r6, r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            r6 = r5
        L4b:
            r6.getClass()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.e(int, kotlin.jvm.functions.Function1, U1.c):java.lang.Object");
    }

    @Override // io.ktor.utils.io.HasReadSession
    public final void endReadSession() {
        this.f3538f.b();
        io.ktor.utils.io.internal.p pVar = (io.ktor.utils.io.internal.p) this._state;
        if ((pVar instanceof io.ktor.utils.io.internal.l) || (pVar instanceof io.ktor.utils.io.internal.m)) {
            J();
            R();
        }
    }

    @Override // io.ktor.utils.io.HasWriteSession
    public final void endWriteSession(int i) {
        Y0.b bVar = this.f3539g;
        bVar.written(i);
        bVar.c();
    }

    public final void f(ByteBuffer byteBuffer, io.ktor.utils.io.internal.r rVar, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.d = i(byteBuffer, this.d + i);
        rVar.a(i);
        this.totalBytesRead += (long) i;
        M();
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final void flush() {
        m(1);
    }

    public final void g(ByteBuffer byteBuffer, io.ktor.utils.io.internal.r rVar, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.e = i(byteBuffer, this.e + i);
        rVar.b(i);
        this.totalBytesWritten += (long) i;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004f A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:14:0x002c, B:22:0x0041, B:30:0x005c, B:25:0x0049, B:27:0x004f), top: B:36:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0063 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0059 -> B:30:0x005c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g0(I1.d r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.M
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.M r0 = (io.ktor.utils.io.M) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            io.ktor.utils.io.M r0 = new io.ktor.utils.io.M
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.c
            T1.a r1 = T1.a.f1304a
            int r2 = r0.e
            N1.m r3 = N1.m.f1129a
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 == r4) goto L3d
            r6 = 2
            if (r2 != r6) goto L35
            io.ktor.utils.io.U r6 = r0.f3514a
            I1.d r6 = (I1.d) r6
            kotlin.reflect.l.e0(r7)     // Catch: java.lang.Throwable -> L33
            r6.release()
            return r3
        L33:
            r7 = move-exception
            goto L67
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            I1.d r6 = r0.b
            io.ktor.utils.io.U r2 = r0.f3514a
            kotlin.reflect.l.e0(r7)     // Catch: java.lang.Throwable -> L33
            goto L5c
        L45:
            kotlin.reflect.l.e0(r7)
            r2 = r5
        L49:
            boolean r7 = r6.d()     // Catch: java.lang.Throwable -> L33
            if (r7 != 0) goto L63
            r0.f3514a = r2     // Catch: java.lang.Throwable -> L33
            r0.b = r6     // Catch: java.lang.Throwable -> L33
            r0.e = r4     // Catch: java.lang.Throwable -> L33
            java.lang.Object r7 = r2.i0(r4, r0)     // Catch: java.lang.Throwable -> L33
            if (r7 != r1) goto L5c
            return r1
        L5c:
            r2.getClass()     // Catch: java.lang.Throwable -> L33
            r2.S(r6)     // Catch: java.lang.Throwable -> L33
            goto L49
        L63:
            r6.release()
            return r3
        L67:
            r6.release()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.g0(I1.d, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final boolean getAutoFlush() {
        return this.f3537a;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final int getAvailableForRead() {
        return ((io.ktor.utils.io.internal.p) this._state).b._availableForRead$internal;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final int getAvailableForWrite() {
        return ((io.ktor.utils.io.internal.p) this._state).b._availableForWrite$internal;
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
    public final Throwable getClosedCause() {
        io.ktor.utils.io.internal.c cVar = (io.ktor.utils.io.internal.c) this._closed;
        if (cVar != null) {
            return cVar.f3582a;
        }
        return null;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final long getTotalBytesRead() {
        return this.totalBytesRead;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final long getTotalBytesWritten() {
        return this.totalBytesWritten;
    }

    public final void h(ByteBuffer byteBuffer) {
        int iCapacity = byteBuffer.capacity() - this.c;
        int iPosition = byteBuffer.position();
        for (int i = iCapacity; i < iPosition; i++) {
            byteBuffer.put(i - iCapacity, byteBuffer.get(i));
        }
    }

    public final int i(ByteBuffer byteBuffer, int i) {
        int iCapacity = byteBuffer.capacity();
        int i3 = this.c;
        return i >= iCapacity - i3 ? i - (byteBuffer.capacity() - i3) : i;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i0(int r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.P
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.utils.io.P r0 = (io.ktor.utils.io.P) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            io.ktor.utils.io.P r0 = new io.ktor.utils.io.P
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.c
            T1.a r1 = T1.a.f1304a
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            int r9 = r0.b
            io.ktor.utils.io.U r2 = r0.f3522a
            kotlin.reflect.l.e0(r10)
            goto L37
        L2b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L33:
            kotlin.reflect.l.e0(r10)
            r2 = r8
        L37:
            boolean r10 = r2.k0(r9)
            N1.m r4 = N1.m.f1129a
            r5 = 0
            if (r10 == 0) goto Lad
            r0.f3522a = r2
            r0.b = r9
            r0.e = r3
            m3.f r10 = new m3.f
            kotlin.coroutines.Continuation r6 = C5.f.J(r0)
            r10.<init>(r3, r6)
            r10.initCancellability()
        L52:
            java.lang.Object r6 = r2._closed
            io.ktor.utils.io.internal.c r6 = (io.ktor.utils.io.internal.c) r6
            if (r6 != 0) goto La5
            boolean r6 = r2.k0(r9)
            if (r6 != 0) goto L62
            r10.resumeWith(r4)
            goto L8c
        L62:
            java.lang.Object r6 = r2._writeOp
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            if (r6 != 0) goto L9d
            boolean r6 = r2.k0(r9)
            if (r6 != 0) goto L6f
            goto L52
        L6f:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = io.ktor.utils.io.U.f3536n
        L71:
            boolean r7 = r6.compareAndSet(r2, r5, r10)
            if (r7 == 0) goto L96
            boolean r6 = r2.k0(r9)
            if (r6 != 0) goto L8c
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = io.ktor.utils.io.U.f3536n
        L7f:
            boolean r7 = r6.compareAndSet(r2, r10, r5)
            if (r7 == 0) goto L86
            goto L52
        L86:
            java.lang.Object r7 = r6.get(r2)
            if (r7 == r10) goto L7f
        L8c:
            r2.m(r9)
            java.lang.Object r10 = r10.m()
            if (r10 != r1) goto L37
            return r1
        L96:
            java.lang.Object r7 = r6.get(r2)
            if (r7 == 0) goto L71
            goto L62
        L9d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Operation is already in progress"
            r9.<init>(r10)
            throw r9
        La5:
            java.lang.Throwable r9 = r6.a()
            a.AbstractC0132a.b(r9)
            throw r5
        Lad:
            java.lang.Object r9 = r2._closed
            io.ktor.utils.io.internal.c r9 = (io.ktor.utils.io.internal.c) r9
            if (r9 != 0) goto Lb4
            return r4
        Lb4:
            java.lang.Throwable r9 = r9.a()
            a.AbstractC0132a.b(r9)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.i0(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final boolean isClosedForRead() {
        return ((io.ktor.utils.io.internal.p) this._state) == io.ktor.utils.io.internal.n.c && ((io.ktor.utils.io.internal.c) this._closed) != null;
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
    public final boolean isClosedForWrite() {
        return ((io.ktor.utils.io.internal.c) this._closed) != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:194:0x00d7, code lost:
    
        r2 = r26;
        r4 = r27;
        r0 = r1;
        r1 = r17;
        r25 = r18;
        r5 = r20;
        r10 = r21;
        r3 = r23;
     */
    /* JADX WARN: Path cross not found for [B:117:0x0212, B:119:0x0216], limit reached: 189 */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0220 A[Catch: all -> 0x0273, TryCatch #7 {all -> 0x0273, blocks: (B:115:0x020c, B:117:0x0212, B:123:0x0220, B:124:0x022b, B:126:0x0237, B:128:0x0241, B:121:0x021b), top: B:179:0x020c }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0237 A[Catch: all -> 0x0273, TryCatch #7 {all -> 0x0273, blocks: (B:115:0x020c, B:117:0x0212, B:123:0x0220, B:124:0x022b, B:126:0x0237, B:128:0x0241, B:121:0x021b), top: B:179:0x020c }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x029d A[Catch: all -> 0x003c, TryCatch #13 {all -> 0x003c, blocks: (B:15:0x0037, B:39:0x00b1, B:41:0x00b7, B:133:0x026a, B:139:0x027c, B:147:0x0297, B:149:0x029d, B:153:0x02a7, B:154:0x02af, B:155:0x02b5, B:151:0x02a1, B:157:0x02b8, B:158:0x02bc, B:22:0x0051), top: B:191:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02a1 A[Catch: all -> 0x003c, TryCatch #13 {all -> 0x003c, blocks: (B:15:0x0037, B:39:0x00b1, B:41:0x00b7, B:133:0x026a, B:139:0x027c, B:147:0x0297, B:149:0x029d, B:153:0x02a7, B:154:0x02af, B:155:0x02b5, B:151:0x02a1, B:157:0x02b8, B:158:0x02bc, B:22:0x0051), top: B:191:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02a7 A[Catch: all -> 0x003c, TryCatch #13 {all -> 0x003c, blocks: (B:15:0x0037, B:39:0x00b1, B:41:0x00b7, B:133:0x026a, B:139:0x027c, B:147:0x0297, B:149:0x029d, B:153:0x02a7, B:154:0x02af, B:155:0x02b5, B:151:0x02a1, B:157:0x02b8, B:158:0x02bc, B:22:0x0051), top: B:191:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02b8 A[Catch: all -> 0x003c, TryCatch #13 {all -> 0x003c, blocks: (B:15:0x0037, B:39:0x00b1, B:41:0x00b7, B:133:0x026a, B:139:0x027c, B:147:0x0297, B:149:0x029d, B:153:0x02a7, B:154:0x02af, B:155:0x02b5, B:151:0x02a1, B:157:0x02b8, B:158:0x02bc, B:22:0x0051), top: B:191:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x01b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00dd A[Catch: all -> 0x01fa, TRY_LEAVE, TryCatch #11 {all -> 0x01fa, blocks: (B:45:0x00d7, B:47:0x00dd), top: B:187:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0148 A[Catch: all -> 0x01f6, TRY_LEAVE, TryCatch #9 {all -> 0x01f6, blocks: (B:69:0x0131, B:73:0x0148), top: B:183:0x0131 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01a7  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:140:0x027f -> B:39:0x00b1). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(io.ktor.utils.io.U r25, long r26, U1.c r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 717
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.j(io.ktor.utils.io.U, long, U1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0055 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0053 -> B:22:0x0056). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j0(byte[] r6, int r7, int r8, kotlin.coroutines.Continuation r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof io.ktor.utils.io.O
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.utils.io.O r0 = (io.ktor.utils.io.O) r0
            int r1 = r0.f3521g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3521g = r1
            goto L18
        L13:
            io.ktor.utils.io.O r0 = new io.ktor.utils.io.O
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.e
            T1.a r1 = T1.a.f1304a
            int r2 = r0.f3521g
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 == r3) goto L32
            r6 = 2
            if (r2 != r6) goto L2a
            kotlin.reflect.l.e0(r9)
            return r9
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            int r6 = r0.d
            int r7 = r0.c
            byte[] r8 = r0.b
            io.ktor.utils.io.U r2 = r0.f3519a
            kotlin.reflect.l.e0(r9)
            r4 = r8
            r8 = r6
            r6 = r4
            goto L56
        L41:
            kotlin.reflect.l.e0(r9)
            r2 = r5
        L45:
            r0.f3519a = r2
            r0.b = r6
            r0.c = r7
            r0.d = r8
            r0.f3521g = r3
            java.lang.Object r9 = r2.T(r3, r0)
            if (r9 != r1) goto L56
            return r1
        L56:
            r2.getClass()
            int r9 = r2.X(r6, r7, r8)
            if (r9 <= 0) goto L45
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r9)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.j0(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final io.ktor.utils.io.internal.p k() {
        return (io.ktor.utils.io.internal.p) this._state;
    }

    public final boolean k0(int i) {
        io.ktor.utils.io.internal.p pVar = (io.ktor.utils.io.internal.p) this._state;
        return ((io.ktor.utils.io.internal.c) this._closed) == null && pVar.b._availableForWrite$internal < i && pVar != io.ktor.utils.io.internal.i.c;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[PHI: r10 r12 r13
      PHI (r10v2 long) = (r10v1 long), (r10v5 long) binds: [B:14:0x0035, B:30:0x007a] A[DONT_GENERATE, DONT_INLINE]
      PHI (r12v2 kotlin.jvm.internal.u) = (r12v1 kotlin.jvm.internal.u), (r12v5 kotlin.jvm.internal.u) binds: [B:14:0x0035, B:30:0x007a] A[DONT_GENERATE, DONT_INLINE]
      PHI (r13v1 io.ktor.utils.io.U) = (r13v0 io.ktor.utils.io.U), (r13v2 io.ktor.utils.io.U) binds: [B:14:0x0035, B:30:0x007a] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0071 -> B:29:0x0074). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(long r10, long r12, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r14 instanceof io.ktor.utils.io.C0538d
            if (r0 == 0) goto L13
            r0 = r14
            io.ktor.utils.io.d r0 = (io.ktor.utils.io.C0538d) r0
            int r1 = r0.f3564f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3564f = r1
            goto L18
        L13:
            io.ktor.utils.io.d r0 = new io.ktor.utils.io.d
            r0.<init>(r9, r14)
        L18:
            java.lang.Object r14 = r0.d
            T1.a r1 = T1.a.f1304a
            int r2 = r0.f3564f
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            long r10 = r0.c
            kotlin.jvm.internal.u r12 = r0.b
            io.ktor.utils.io.U r13 = r0.f3563a
            kotlin.reflect.l.e0(r14)
            goto L74
        L2d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L35:
            kotlin.reflect.l.e0(r14)
            kotlin.jvm.internal.u r14 = new kotlin.jvm.internal.u
            r14.<init>()
            r14.f3815a = r10
            r10 = r12
            r12 = r14
            r13 = r9
        L42:
            long r4 = r12.f3815a
            int r14 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r14 >= 0) goto La5
            java.nio.ByteBuffer r14 = r13.O()
            if (r14 != 0) goto L4f
            goto L5f
        L4f:
            java.lang.Object r2 = r13._state
            io.ktor.utils.io.internal.p r2 = (io.ktor.utils.io.internal.p) r2
            io.ktor.utils.io.internal.r r2 = r2.b
            int r4 = r2._availableForRead$internal     // Catch: java.lang.Throwable -> L9d
            if (r4 != 0) goto L7d
            r13.J()
            r13.R()
        L5f:
            boolean r14 = r13.isClosedForRead()
            if (r14 != 0) goto La5
            r0.f3563a = r13
            r0.b = r12
            r0.c = r10
            r0.f3564f = r3
            java.lang.Object r14 = r13.D(r3, r0)
            if (r14 != r1) goto L74
            return r1
        L74:
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 != 0) goto L42
            goto La5
        L7d:
            long r4 = r12.f3815a     // Catch: java.lang.Throwable -> L9d
            long r4 = r10 - r4
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r4 = java.lang.Math.min(r6, r4)     // Catch: java.lang.Throwable -> L9d
            int r4 = (int) r4     // Catch: java.lang.Throwable -> L9d
            int r4 = r2.h(r4)     // Catch: java.lang.Throwable -> L9d
            r13.f(r14, r2, r4)     // Catch: java.lang.Throwable -> L9d
            long r5 = r12.f3815a     // Catch: java.lang.Throwable -> L9d
            long r7 = (long) r4     // Catch: java.lang.Throwable -> L9d
            long r5 = r5 + r7
            r12.f3815a = r5     // Catch: java.lang.Throwable -> L9d
            r13.J()
            r13.R()
            goto L42
        L9d:
            r10 = move-exception
            r13.J()
            r13.R()
            throw r10
        La5:
            long r10 = r12.f3815a
            java.lang.Long r12 = new java.lang.Long
            r12.<init>(r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.l(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object lookAhead(Function1 visitor) {
        kotlin.jvm.internal.h.f(visitor, "visitor");
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            return visitor.invoke(new io.ktor.utils.io.internal.d(closedCause));
        }
        io.ktor.utils.io.internal.p pVar = (io.ktor.utils.io.internal.p) this._state;
        io.ktor.utils.io.internal.n nVar = io.ktor.utils.io.internal.n.c;
        io.ktor.utils.io.internal.s sVar = io.ktor.utils.io.internal.s.f3591a;
        if (pVar == nVar) {
            return visitor.invoke(sVar);
        }
        boolean z6 = false;
        Object objInvoke = null;
        if (O() != null) {
            try {
                if (((io.ktor.utils.io.internal.p) this._state).b._availableForRead$internal != 0) {
                    objInvoke = visitor.invoke(this);
                    J();
                    R();
                    z6 = true;
                }
            } finally {
                J();
                R();
            }
        }
        if (z6) {
            kotlin.jvm.internal.h.c(objInvoke);
            return objInvoke;
        }
        Throwable closedCause2 = getClosedCause();
        return closedCause2 != null ? visitor.invoke(new io.ktor.utils.io.internal.d(closedCause2)) : visitor.invoke(sVar);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object lookAheadSuspend(Function2 function2, Continuation continuation) {
        return n(this, continuation, function2);
    }

    public final void m(int i) {
        io.ktor.utils.io.internal.p pVar;
        do {
            pVar = (io.ktor.utils.io.internal.p) this._state;
            if (pVar == io.ktor.utils.io.internal.n.c) {
                return;
            } else {
                pVar.b.c();
            }
        } while (pVar != ((io.ktor.utils.io.internal.p) this._state));
        int i3 = pVar.b._availableForWrite$internal;
        if (pVar.b._availableForRead$internal >= 1) {
            L();
        }
        if (i3 >= i) {
            M();
        }
    }

    public final boolean m0(ByteBuffer byteBuffer, io.ktor.utils.io.internal.r rVar, Function1 function1) {
        int i;
        int iCapacity = byteBuffer.capacity() - this.c;
        boolean z6 = true;
        while (z6) {
            while (true) {
                i = rVar._availableForWrite$internal;
                if (i < 1) {
                    i = 0;
                    break;
                }
                if (io.ktor.utils.io.internal.r.c.compareAndSet(rVar, i, 0)) {
                    break;
                }
            }
            if (i == 0) {
                break;
            }
            int i3 = this.e;
            int i4 = i3 + i;
            if (i4 > iCapacity) {
                i4 = iCapacity;
            }
            byteBuffer.limit(i4);
            byteBuffer.position(i3);
            try {
                boolean zBooleanValue = ((Boolean) function1.invoke(byteBuffer)).booleanValue();
                if (byteBuffer.limit() != i4) {
                    throw new IllegalStateException("Buffer limit modified.");
                }
                int iPosition = byteBuffer.position() - i3;
                if (iPosition < 0) {
                    throw new IllegalStateException("Position has been moved backward: pushback is not supported.");
                }
                g(byteBuffer, rVar, iPosition);
                if (iPosition < i) {
                    rVar.a(i - iPosition);
                }
                z6 = zBooleanValue;
            } catch (Throwable th) {
                rVar.a(i);
                throw th;
            }
        }
        return z6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b1, code lost:
    
        if (((io.ktor.utils.io.internal.c) r4._closed) != null) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a9 A[Catch: all -> 0x0053, TryCatch #1 {all -> 0x0053, blocks: (B:18:0x004e, B:30:0x00a0, B:32:0x00a9, B:33:0x00ad, B:26:0x007e), top: B:66:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ad A[Catch: all -> 0x0053, TRY_LEAVE, TryCatch #1 {all -> 0x0053, blocks: (B:18:0x004e, B:30:0x00a0, B:32:0x00a9, B:33:0x00ad, B:26:0x007e), top: B:66:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x009e -> B:30:0x00a0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n0(kotlin.jvm.functions.Function1 r17, kotlin.coroutines.Continuation r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.n0(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void p(ByteBuffer byteBuffer, int i, int i3) {
        if (i < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int iCapacity = byteBuffer.capacity() - this.c;
        int i4 = i3 + i;
        if (i4 <= iCapacity) {
            iCapacity = i4;
        }
        byteBuffer.limit(iCapacity);
        byteBuffer.position(i);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    /* JADX INFO: renamed from: peekTo-lBXzO7A */
    public final Object mo95peekTolBXzO7A(ByteBuffer byteBuffer, long j6, long j7, long j8, long j9, Continuation continuation) {
        return o(this, byteBuffer, j6, j7, j8, j9, continuation);
    }

    public final void q(ByteBuffer buffer, int i) {
        kotlin.jvm.internal.h.f(buffer, "buffer");
        p(buffer, this.e, i);
    }

    public final int r(ByteBuffer byteBuffer) throws Throwable {
        ByteBuffer byteBufferO = O();
        int i = 0;
        if (byteBufferO == null) {
            return 0;
        }
        io.ktor.utils.io.internal.r rVar = ((io.ktor.utils.io.internal.p) this._state).b;
        try {
            if (rVar._availableForRead$internal != 0) {
                int iCapacity = byteBufferO.capacity() - this.c;
                while (true) {
                    int iRemaining = byteBuffer.remaining();
                    if (iRemaining == 0) {
                        break;
                    }
                    int i3 = this.d;
                    int iH = rVar.h(Math.min(iCapacity - i3, iRemaining));
                    if (iH == 0) {
                        break;
                    }
                    byteBufferO.limit(i3 + iH);
                    byteBufferO.position(i3);
                    byteBuffer.put(byteBufferO);
                    f(byteBufferO, rVar, iH);
                    i += iH;
                }
            }
            return i;
        } finally {
            J();
            R();
        }
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object read(int i, Function1 function1, Continuation continuation) throws Throwable {
        int i3;
        if (i < 0) {
            throw new IllegalArgumentException("min should be positive or zero");
        }
        ByteBuffer byteBufferO = O();
        boolean z6 = false;
        if (byteBufferO != null) {
            io.ktor.utils.io.internal.r rVar = ((io.ktor.utils.io.internal.p) this._state).b;
            try {
                if (rVar._availableForRead$internal != 0 && (i3 = rVar._availableForRead$internal) > 0 && i3 >= i) {
                    int iPosition = byteBufferO.position();
                    int iLimit = byteBufferO.limit();
                    function1.invoke(byteBufferO);
                    if (iLimit != byteBufferO.limit()) {
                        throw new IllegalStateException("Buffer limit modified.");
                    }
                    int iPosition2 = byteBufferO.position() - iPosition;
                    if (iPosition2 < 0) {
                        throw new IllegalStateException("Position has been moved backward: pushback is not supported.");
                    }
                    if (!rVar.i(iPosition2)) {
                        throw new IllegalStateException("Check failed.");
                    }
                    f(byteBufferO, rVar, iPosition2);
                    z6 = true;
                }
            } finally {
                J();
                R();
            }
        }
        N1.m mVar = N1.m.f1129a;
        if (!z6) {
            if (isClosedForRead() && i > 0) {
                throw new EOFException(B2.b.d(i, "Got EOF but at least ", " bytes were expected"));
            }
            Object objX = x(i, function1, continuation);
            if (objX == T1.a.f1304a) {
                return objX;
            }
        }
        return mVar;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object readAvailable(byte[] bArr, int i, int i3, Continuation continuation) throws Throwable {
        int iS = s(bArr, i, i3);
        if (iS == 0 && ((io.ktor.utils.io.internal.c) this._closed) != null) {
            iS = ((io.ktor.utils.io.internal.p) this._state).b.c() ? s(bArr, i, i3) : -1;
        } else if (iS <= 0 && i3 != 0) {
            return w(bArr, i, i3, continuation);
        }
        return new Integer(iS);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.utils.io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readBoolean(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof io.ktor.utils.io.C0546l
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.utils.io.l r0 = (io.ktor.utils.io.C0546l) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            io.ktor.utils.io.l r0 = new io.ktor.utils.io.l
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f3618a
            T1.a r1 = T1.a.f1304a
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.reflect.l.e0(r5)
            goto L3b
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L2f:
            kotlin.reflect.l.e0(r5)
            r0.c = r3
            java.lang.Object r5 = r4.readByte(r0)
            if (r5 != r1) goto L3b
            return r1
        L3b:
            java.lang.Number r5 = (java.lang.Number) r5
            byte r5 = r5.byteValue()
            if (r5 == 0) goto L44
            goto L45
        L44:
            r3 = 0
        L45:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.readBoolean(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Path cross not found for [B:17:0x0041, B:18:0x0043], limit reached: 48 */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x008d -> B:39:0x0090). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readByte(kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.C0547m
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.utils.io.m r0 = (io.ktor.utils.io.C0547m) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            io.ktor.utils.io.m r0 = new io.ktor.utils.io.m
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.c
            T1.a r1 = T1.a.f1304a
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            int r2 = r0.b
            io.ktor.utils.io.U r4 = r0.f3619a
            kotlin.reflect.l.e0(r10)
            goto L90
        L2c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L34:
            kotlin.reflect.l.e0(r10)
            r4 = r9
            r2 = r3
        L39:
            java.nio.ByteBuffer r10 = r4.O()
            r5 = 0
            r6 = 0
            if (r10 != 0) goto L43
        L41:
            r10 = r5
            goto L78
        L43:
            java.lang.Object r7 = r4._state
            io.ktor.utils.io.internal.p r7 = (io.ktor.utils.io.internal.p) r7
            io.ktor.utils.io.internal.r r7 = r7.b
            int r8 = r7._availableForRead$internal     // Catch: java.lang.Throwable -> La7
            if (r8 != 0) goto L54
            r4.J()
            r4.R()
            goto L41
        L54:
            boolean r8 = r7.i(r2)     // Catch: java.lang.Throwable -> La7
            if (r8 != 0) goto L5c
            r10 = r5
            goto L72
        L5c:
            int r6 = r10.remaining()     // Catch: java.lang.Throwable -> La7
            if (r6 >= r2) goto L65
            N(r10, r2)     // Catch: java.lang.Throwable -> La7
        L65:
            byte r6 = r10.get()     // Catch: java.lang.Throwable -> La7
            java.lang.Byte r6 = java.lang.Byte.valueOf(r6)     // Catch: java.lang.Throwable -> La7
            r4.f(r10, r7, r2)     // Catch: java.lang.Throwable -> La7
            r10 = r6
            r6 = r3
        L72:
            r4.J()
            r4.R()
        L78:
            if (r6 == 0) goto L83
            if (r10 == 0) goto L7d
            return r10
        L7d:
            java.lang.String r10 = "result"
            kotlin.jvm.internal.h.n(r10)
            throw r5
        L83:
            r0.f3619a = r4
            r0.b = r2
            r0.e = r3
            java.lang.Object r10 = r4.D(r2, r0)
            if (r10 != r1) goto L90
            return r1
        L90:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L99
            goto L39
        L99:
            o3.x r10 = new o3.x
            java.lang.String r0 = "EOF while "
            java.lang.String r1 = " bytes expected"
            java.lang.String r0 = B2.b.d(r2, r0, r1)
            r10.<init>(r0)
            throw r10
        La7:
            r10 = move-exception
            r4.J()
            r4.R()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.readByte(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Path cross not found for [B:17:0x0043, B:18:0x0045], limit reached: 49 */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x009d -> B:40:0x00a0). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readDouble(kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof io.ktor.utils.io.C0548n
            if (r0 == 0) goto L13
            r0 = r11
            io.ktor.utils.io.n r0 = (io.ktor.utils.io.C0548n) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            io.ktor.utils.io.n r0 = new io.ktor.utils.io.n
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.c
            T1.a r1 = T1.a.f1304a
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            int r2 = r0.b
            io.ktor.utils.io.U r4 = r0.f3620a
            kotlin.reflect.l.e0(r11)
            goto La0
        L2c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L34:
            kotlin.reflect.l.e0(r11)
            r11 = 8
            r4 = r10
            r2 = r11
        L3b:
            java.nio.ByteBuffer r11 = r4.O()
            r5 = 0
            r6 = 0
            if (r11 != 0) goto L45
        L43:
            r11 = r5
            goto L7b
        L45:
            java.lang.Object r7 = r4._state
            io.ktor.utils.io.internal.p r7 = (io.ktor.utils.io.internal.p) r7
            io.ktor.utils.io.internal.r r7 = r7.b
            int r8 = r7._availableForRead$internal     // Catch: java.lang.Throwable -> Lb7
            if (r8 != 0) goto L56
            r4.J()
            r4.R()
            goto L43
        L56:
            boolean r8 = r7.i(r2)     // Catch: java.lang.Throwable -> Lb7
            if (r8 != 0) goto L5e
            r11 = r5
            goto L75
        L5e:
            int r6 = r11.remaining()     // Catch: java.lang.Throwable -> Lb7
            if (r6 >= r2) goto L67
            N(r11, r2)     // Catch: java.lang.Throwable -> Lb7
        L67:
            long r8 = r11.getLong()     // Catch: java.lang.Throwable -> Lb7
            java.lang.Long r6 = new java.lang.Long     // Catch: java.lang.Throwable -> Lb7
            r6.<init>(r8)     // Catch: java.lang.Throwable -> Lb7
            r4.f(r11, r7, r2)     // Catch: java.lang.Throwable -> Lb7
            r11 = r6
            r6 = r3
        L75:
            r4.J()
            r4.R()
        L7b:
            if (r6 == 0) goto L93
            if (r11 == 0) goto L8d
            long r0 = r11.longValue()
            double r0 = java.lang.Double.longBitsToDouble(r0)
            java.lang.Double r11 = new java.lang.Double
            r11.<init>(r0)
            return r11
        L8d:
            java.lang.String r11 = "result"
            kotlin.jvm.internal.h.n(r11)
            throw r5
        L93:
            r0.f3620a = r4
            r0.b = r2
            r0.e = r3
            java.lang.Object r11 = r4.D(r2, r0)
            if (r11 != r1) goto La0
            return r1
        La0:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto La9
            goto L3b
        La9:
            o3.x r11 = new o3.x
            java.lang.String r0 = "EOF while "
            java.lang.String r1 = " bytes expected"
            java.lang.String r0 = B2.b.d(r2, r0, r1)
            r11.<init>(r0)
            throw r11
        Lb7:
            r11 = move-exception
            r4.J()
            r4.R()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.readDouble(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Path cross not found for [B:17:0x0042, B:18:0x0044], limit reached: 49 */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x009b -> B:40:0x009e). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readFloat(kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.C0549o
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.utils.io.o r0 = (io.ktor.utils.io.C0549o) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            io.ktor.utils.io.o r0 = new io.ktor.utils.io.o
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.c
            T1.a r1 = T1.a.f1304a
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            int r2 = r0.b
            io.ktor.utils.io.U r4 = r0.f3621a
            kotlin.reflect.l.e0(r10)
            goto L9e
        L2c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L34:
            kotlin.reflect.l.e0(r10)
            r10 = 4
            r4 = r9
            r2 = r10
        L3a:
            java.nio.ByteBuffer r10 = r4.O()
            r5 = 0
            r6 = 0
            if (r10 != 0) goto L44
        L42:
            r8 = r5
            goto L79
        L44:
            java.lang.Object r7 = r4._state
            io.ktor.utils.io.internal.p r7 = (io.ktor.utils.io.internal.p) r7
            io.ktor.utils.io.internal.r r7 = r7.b
            int r8 = r7._availableForRead$internal     // Catch: java.lang.Throwable -> Lb5
            if (r8 != 0) goto L55
            r4.J()
            r4.R()
            goto L42
        L55:
            boolean r8 = r7.i(r2)     // Catch: java.lang.Throwable -> Lb5
            if (r8 != 0) goto L5d
            r8 = r5
            goto L73
        L5d:
            int r6 = r10.remaining()     // Catch: java.lang.Throwable -> Lb5
            if (r6 >= r2) goto L66
            N(r10, r2)     // Catch: java.lang.Throwable -> Lb5
        L66:
            int r6 = r10.getInt()     // Catch: java.lang.Throwable -> Lb5
            java.lang.Integer r8 = new java.lang.Integer     // Catch: java.lang.Throwable -> Lb5
            r8.<init>(r6)     // Catch: java.lang.Throwable -> Lb5
            r4.f(r10, r7, r2)     // Catch: java.lang.Throwable -> Lb5
            r6 = r3
        L73:
            r4.J()
            r4.R()
        L79:
            if (r6 == 0) goto L91
            if (r8 == 0) goto L8b
            int r10 = r8.intValue()
            float r10 = java.lang.Float.intBitsToFloat(r10)
            java.lang.Float r0 = new java.lang.Float
            r0.<init>(r10)
            return r0
        L8b:
            java.lang.String r10 = "result"
            kotlin.jvm.internal.h.n(r10)
            throw r5
        L91:
            r0.f3621a = r4
            r0.b = r2
            r0.e = r3
            java.lang.Object r10 = r4.D(r2, r0)
            if (r10 != r1) goto L9e
            return r1
        L9e:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto La7
            goto L3a
        La7:
            o3.x r10 = new o3.x
            java.lang.String r0 = "EOF while "
            java.lang.String r1 = " bytes expected"
            java.lang.String r0 = B2.b.d(r2, r0, r1)
            r10.<init>(r0)
            throw r10
        Lb5:
            r10 = move-exception
            r4.J()
            r4.R()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.readFloat(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object readFully(byte[] bArr, int i, int i3, Continuation continuation) throws Throwable {
        Object objA;
        int iS = s(bArr, i, i3);
        return (iS >= i3 || (objA = A(bArr, i + iS, i3 - iS, continuation)) != T1.a.f1304a) ? N1.m.f1129a : objA;
    }

    /* JADX WARN: Path cross not found for [B:17:0x0041, B:18:0x0043], limit reached: 48 */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x008d -> B:39:0x0090). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readInt(kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.C0552s
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.utils.io.s r0 = (io.ktor.utils.io.C0552s) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            io.ktor.utils.io.s r0 = new io.ktor.utils.io.s
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.c
            T1.a r1 = T1.a.f1304a
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            int r2 = r0.b
            io.ktor.utils.io.U r4 = r0.f3631a
            kotlin.reflect.l.e0(r10)
            goto L90
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L33:
            kotlin.reflect.l.e0(r10)
            r10 = 4
            r4 = r9
            r2 = r10
        L39:
            java.nio.ByteBuffer r10 = r4.O()
            r5 = 0
            r6 = 0
            if (r10 != 0) goto L43
        L41:
            r8 = r5
            goto L78
        L43:
            java.lang.Object r7 = r4._state
            io.ktor.utils.io.internal.p r7 = (io.ktor.utils.io.internal.p) r7
            io.ktor.utils.io.internal.r r7 = r7.b
            int r8 = r7._availableForRead$internal     // Catch: java.lang.Throwable -> La7
            if (r8 != 0) goto L54
            r4.J()
            r4.R()
            goto L41
        L54:
            boolean r8 = r7.i(r2)     // Catch: java.lang.Throwable -> La7
            if (r8 != 0) goto L5c
            r8 = r5
            goto L72
        L5c:
            int r6 = r10.remaining()     // Catch: java.lang.Throwable -> La7
            if (r6 >= r2) goto L65
            N(r10, r2)     // Catch: java.lang.Throwable -> La7
        L65:
            int r6 = r10.getInt()     // Catch: java.lang.Throwable -> La7
            java.lang.Integer r8 = new java.lang.Integer     // Catch: java.lang.Throwable -> La7
            r8.<init>(r6)     // Catch: java.lang.Throwable -> La7
            r4.f(r10, r7, r2)     // Catch: java.lang.Throwable -> La7
            r6 = r3
        L72:
            r4.J()
            r4.R()
        L78:
            if (r6 == 0) goto L83
            if (r8 == 0) goto L7d
            return r8
        L7d:
            java.lang.String r10 = "result"
            kotlin.jvm.internal.h.n(r10)
            throw r5
        L83:
            r0.f3631a = r4
            r0.b = r2
            r0.e = r3
            java.lang.Object r10 = r4.D(r2, r0)
            if (r10 != r1) goto L90
            return r1
        L90:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L99
            goto L39
        L99:
            o3.x r10 = new o3.x
            java.lang.String r0 = "EOF while "
            java.lang.String r1 = " bytes expected"
            java.lang.String r0 = B2.b.d(r2, r0, r1)
            r10.<init>(r0)
            throw r10
        La7:
            r10 = move-exception
            r4.J()
            r4.R()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.readInt(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Path cross not found for [B:17:0x0043, B:18:0x0045], limit reached: 48 */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0090 -> B:39:0x0093). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readLong(kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof io.ktor.utils.io.C0553t
            if (r0 == 0) goto L13
            r0 = r11
            io.ktor.utils.io.t r0 = (io.ktor.utils.io.C0553t) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            io.ktor.utils.io.t r0 = new io.ktor.utils.io.t
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.c
            T1.a r1 = T1.a.f1304a
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            int r2 = r0.b
            io.ktor.utils.io.U r4 = r0.f3632a
            kotlin.reflect.l.e0(r11)
            goto L93
        L2c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L34:
            kotlin.reflect.l.e0(r11)
            r11 = 8
            r4 = r10
            r2 = r11
        L3b:
            java.nio.ByteBuffer r11 = r4.O()
            r5 = 0
            r6 = 0
            if (r11 != 0) goto L45
        L43:
            r11 = r5
            goto L7b
        L45:
            java.lang.Object r7 = r4._state
            io.ktor.utils.io.internal.p r7 = (io.ktor.utils.io.internal.p) r7
            io.ktor.utils.io.internal.r r7 = r7.b
            int r8 = r7._availableForRead$internal     // Catch: java.lang.Throwable -> Laa
            if (r8 != 0) goto L56
            r4.J()
            r4.R()
            goto L43
        L56:
            boolean r8 = r7.i(r2)     // Catch: java.lang.Throwable -> Laa
            if (r8 != 0) goto L5e
            r11 = r5
            goto L75
        L5e:
            int r6 = r11.remaining()     // Catch: java.lang.Throwable -> Laa
            if (r6 >= r2) goto L67
            N(r11, r2)     // Catch: java.lang.Throwable -> Laa
        L67:
            long r8 = r11.getLong()     // Catch: java.lang.Throwable -> Laa
            java.lang.Long r6 = new java.lang.Long     // Catch: java.lang.Throwable -> Laa
            r6.<init>(r8)     // Catch: java.lang.Throwable -> Laa
            r4.f(r11, r7, r2)     // Catch: java.lang.Throwable -> Laa
            r11 = r6
            r6 = r3
        L75:
            r4.J()
            r4.R()
        L7b:
            if (r6 == 0) goto L86
            if (r11 == 0) goto L80
            return r11
        L80:
            java.lang.String r11 = "result"
            kotlin.jvm.internal.h.n(r11)
            throw r5
        L86:
            r0.f3632a = r4
            r0.b = r2
            r0.e = r3
            java.lang.Object r11 = r4.D(r2, r0)
            if (r11 != r1) goto L93
            return r1
        L93:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L9c
            goto L3b
        L9c:
            o3.x r11 = new o3.x
            java.lang.String r0 = "EOF while "
            java.lang.String r1 = " bytes expected"
            java.lang.String r0 = B2.b.d(r2, r0, r1)
            r11.<init>(r0)
            throw r11
        Laa:
            r11 = move-exception
            r4.J()
            r4.R()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.readLong(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object readPacket(int i, Continuation continuation) throws Throwable {
        Throwable th;
        io.ktor.utils.io.internal.c cVar = (io.ktor.utils.io.internal.c) this._closed;
        if (cVar != null && (th = cVar.f3582a) != null) {
            AbstractC0132a.b(th);
            throw null;
        }
        if (i == 0) {
            return I1.d.f757h;
        }
        I1.c cVar2 = new I1.c();
        ByteBuffer byteBuffer = (ByteBuffer) io.ktor.utils.io.internal.h.b.borrow();
        while (i > 0) {
            try {
                byteBuffer.clear();
                if (byteBuffer.remaining() > i) {
                    byteBuffer.limit(i);
                }
                int iR = r(byteBuffer);
                if (iR == 0) {
                    break;
                }
                byteBuffer.flip();
                E1.k.t0(cVar2, byteBuffer);
                i -= iR;
            } catch (Throwable th2) {
                io.ktor.utils.io.internal.h.b.recycle(byteBuffer);
                cVar2.close();
                throw th2;
            }
        }
        if (i != 0) {
            return B(i, cVar2, byteBuffer, continuation);
        }
        io.ktor.utils.io.internal.h.b.recycle(byteBuffer);
        return cVar2.c();
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object readRemaining(long j6, Continuation continuation) throws Throwable {
        if (!isClosedForWrite()) {
            return C(j6, continuation);
        }
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            AbstractC0132a.b(closedCause);
            throw null;
        }
        I1.c cVar = new I1.c();
        try {
            J1.b bVarF = J1.c.f(cVar, 1, null);
            while (true) {
                try {
                    if (bVarF.e - bVarF.c > j6) {
                        bVarF.f((int) j6);
                    }
                    j6 -= (long) t(this, bVarF, 0, 6);
                    if (j6 <= 0 || isClosedForRead()) {
                        break;
                    }
                    bVarF = J1.c.f(cVar, 1, bVarF);
                } catch (Throwable th) {
                    cVar.a();
                    throw th;
                }
            }
            cVar.a();
            return cVar.c();
        } catch (Throwable th2) {
            cVar.close();
            throw th2;
        }
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final void readSession(Function1 consumer) {
        kotlin.jvm.internal.h.f(consumer, "consumer");
        lookAhead(new A2.q(7, consumer, this));
    }

    /* JADX WARN: Path cross not found for [B:17:0x0041, B:18:0x0043], limit reached: 48 */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x008d -> B:39:0x0090). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readShort(kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.C0556w
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.utils.io.w r0 = (io.ktor.utils.io.C0556w) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            io.ktor.utils.io.w r0 = new io.ktor.utils.io.w
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.c
            T1.a r1 = T1.a.f1304a
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            int r2 = r0.b
            io.ktor.utils.io.U r4 = r0.f3640a
            kotlin.reflect.l.e0(r10)
            goto L90
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L33:
            kotlin.reflect.l.e0(r10)
            r10 = 2
            r4 = r9
            r2 = r10
        L39:
            java.nio.ByteBuffer r10 = r4.O()
            r5 = 0
            r6 = 0
            if (r10 != 0) goto L43
        L41:
            r8 = r5
            goto L78
        L43:
            java.lang.Object r7 = r4._state
            io.ktor.utils.io.internal.p r7 = (io.ktor.utils.io.internal.p) r7
            io.ktor.utils.io.internal.r r7 = r7.b
            int r8 = r7._availableForRead$internal     // Catch: java.lang.Throwable -> La7
            if (r8 != 0) goto L54
            r4.J()
            r4.R()
            goto L41
        L54:
            boolean r8 = r7.i(r2)     // Catch: java.lang.Throwable -> La7
            if (r8 != 0) goto L5c
            r8 = r5
            goto L72
        L5c:
            int r6 = r10.remaining()     // Catch: java.lang.Throwable -> La7
            if (r6 >= r2) goto L65
            N(r10, r2)     // Catch: java.lang.Throwable -> La7
        L65:
            short r6 = r10.getShort()     // Catch: java.lang.Throwable -> La7
            java.lang.Short r8 = new java.lang.Short     // Catch: java.lang.Throwable -> La7
            r8.<init>(r6)     // Catch: java.lang.Throwable -> La7
            r4.f(r10, r7, r2)     // Catch: java.lang.Throwable -> La7
            r6 = r3
        L72:
            r4.J()
            r4.R()
        L78:
            if (r6 == 0) goto L83
            if (r8 == 0) goto L7d
            return r8
        L7d:
            java.lang.String r10 = "result"
            kotlin.jvm.internal.h.n(r10)
            throw r5
        L83:
            r0.f3640a = r4
            r0.b = r2
            r0.e = r3
            java.lang.Object r10 = r4.D(r2, r0)
            if (r10 != r1) goto L90
            return r1
        L90:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L99
            goto L39
        L99:
            o3.x r10 = new o3.x
            java.lang.String r0 = "EOF while "
            java.lang.String r1 = " bytes expected"
            java.lang.String r0 = B2.b.d(r2, r0, r1)
            r10.<init>(r0)
            throw r10
        La7:
            r10 = move-exception
            r4.J()
            r4.R()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.readShort(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object readSuspendableSession(Function2 function2, Continuation continuation) throws Throwable {
        Object objN = n(this, continuation, new C0559z(this, null, function2));
        return objN == T1.a.f1304a ? objN : N1.m.f1129a;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object readUTF8Line(int i, Continuation continuation) {
        return G(this, i, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object readUTF8LineTo(Appendable appendable, int i, Continuation continuation) throws Throwable {
        if (((io.ktor.utils.io.internal.p) this._state) != io.ktor.utils.io.internal.n.c) {
            return H(appendable, i, continuation);
        }
        Throwable closedCause = getClosedCause();
        if (closedCause == null) {
            return Boolean.FALSE;
        }
        throw closedCause;
    }

    @Override // io.ktor.utils.io.LookAheadSession
    public final ByteBuffer request(int i, int i3) {
        io.ktor.utils.io.internal.p pVar = (io.ktor.utils.io.internal.p) this._state;
        int i4 = pVar.b._availableForRead$internal;
        int i5 = this.d;
        if (i4 < i3 + i) {
            return null;
        }
        if (pVar.a() || !((pVar instanceof io.ktor.utils.io.internal.l) || (pVar instanceof io.ktor.utils.io.internal.m))) {
            if (O() == null) {
                return null;
            }
            return request(i, i3);
        }
        ByteBuffer byteBufferB = pVar.b();
        p(byteBufferB, i(byteBufferB, i5 + i), i4 - i);
        if (byteBufferB.remaining() >= i3) {
            return byteBufferB;
        }
        return null;
    }

    public final int s(byte[] bArr, int i, int i3) throws Throwable {
        ByteBuffer byteBufferO = O();
        int i4 = 0;
        if (byteBufferO == null) {
            return 0;
        }
        io.ktor.utils.io.internal.r rVar = ((io.ktor.utils.io.internal.p) this._state).b;
        try {
            if (rVar._availableForRead$internal != 0) {
                int iCapacity = byteBufferO.capacity() - this.c;
                while (true) {
                    int i5 = i3 - i4;
                    if (i5 == 0) {
                        break;
                    }
                    int i6 = this.d;
                    int iH = rVar.h(Math.min(iCapacity - i6, i5));
                    if (iH == 0) {
                        break;
                    }
                    byteBufferO.limit(i6 + iH);
                    byteBufferO.position(i6);
                    byteBufferO.get(bArr, i + i4, iH);
                    f(byteBufferO, rVar, iH);
                    i4 += iH;
                }
            }
            return i4;
        } finally {
            J();
            R();
        }
    }

    @Override // io.ktor.utils.io.HasReadSession
    public final SuspendableReadSession startReadSession() {
        return this.f3538f;
    }

    public final String toString() {
        return "ByteBufferChannel(" + hashCode() + ", " + ((io.ktor.utils.io.internal.p) this._state) + ')';
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u(J1.b r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.C0544j
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.j r0 = (io.ktor.utils.io.C0544j) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            io.ktor.utils.io.j r0 = new io.ktor.utils.io.j
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.c
            T1.a r1 = T1.a.f1304a
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.reflect.l.e0(r7)
            return r7
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            J1.b r6 = r0.b
            io.ktor.utils.io.U r2 = r0.f3592a
            kotlin.reflect.l.e0(r7)
            goto L4b
        L3a:
            kotlin.reflect.l.e0(r7)
            r0.f3592a = r5
            r0.b = r6
            r0.e = r4
            java.lang.Object r7 = r5.D(r4, r0)
            if (r7 != r1) goto L4a
            goto L67
        L4a:
            r2 = r5
        L4b:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L5a
            java.lang.Integer r6 = new java.lang.Integer
            r7 = -1
            r6.<init>(r7)
            return r6
        L5a:
            r7 = 0
            r0.f3592a = r7
            r0.b = r7
            r0.e = r3
            java.lang.Object r6 = r2.readAvailable(r6, r0)
            if (r6 != r1) goto L68
        L67:
            return r1
        L68:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.u(J1.b, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(java.nio.ByteBuffer r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.C0543i
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.i r0 = (io.ktor.utils.io.C0543i) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            io.ktor.utils.io.i r0 = new io.ktor.utils.io.i
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.c
            T1.a r1 = T1.a.f1304a
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.reflect.l.e0(r7)
            return r7
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            java.nio.ByteBuffer r6 = r0.b
            io.ktor.utils.io.U r2 = r0.f3578a
            kotlin.reflect.l.e0(r7)
            goto L4b
        L3a:
            kotlin.reflect.l.e0(r7)
            r0.f3578a = r5
            r0.b = r6
            r0.e = r4
            java.lang.Object r7 = r5.D(r4, r0)
            if (r7 != r1) goto L4a
            goto L67
        L4a:
            r2 = r5
        L4b:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L5a
            java.lang.Integer r6 = new java.lang.Integer
            r7 = -1
            r6.<init>(r7)
            return r6
        L5a:
            r7 = 0
            r0.f3578a = r7
            r0.b = r7
            r0.e = r3
            java.lang.Object r6 = r2.readAvailable(r6, r0)
            if (r6 != r1) goto L68
        L67:
            return r1
        L68:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.v(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w(byte[] r6, int r7, int r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r9 instanceof io.ktor.utils.io.C0542h
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.utils.io.h r0 = (io.ktor.utils.io.C0542h) r0
            int r1 = r0.f3576g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3576g = r1
            goto L18
        L13:
            io.ktor.utils.io.h r0 = new io.ktor.utils.io.h
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.e
            T1.a r1 = T1.a.f1304a
            int r2 = r0.f3576g
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.reflect.l.e0(r9)
            return r9
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            int r8 = r0.d
            int r7 = r0.c
            byte[] r6 = r0.b
            io.ktor.utils.io.U r2 = r0.f3574a
            kotlin.reflect.l.e0(r9)
            goto L53
        L3e:
            kotlin.reflect.l.e0(r9)
            r0.f3574a = r5
            r0.b = r6
            r0.c = r7
            r0.d = r8
            r0.f3576g = r4
            java.lang.Object r9 = r5.D(r4, r0)
            if (r9 != r1) goto L52
            goto L6f
        L52:
            r2 = r5
        L53:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L62
            java.lang.Integer r6 = new java.lang.Integer
            r7 = -1
            r6.<init>(r7)
            return r6
        L62:
            r9 = 0
            r0.f3574a = r9
            r0.b = r9
            r0.f3576g = r3
            java.lang.Object r6 = r2.readAvailable(r6, r7, r8, r0)
            if (r6 != r1) goto L70
        L6f:
            return r1
        L70:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.w(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object write(int i, Function1 function1, Continuation continuation) {
        return U(this, i, function1, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object writeAvailable(ByteBuffer byteBuffer, Continuation continuation) throws Throwable {
        int iW = W(byteBuffer);
        return iW > 0 ? new Integer(iW) : Z(byteBuffer, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object writeByte(byte b, Continuation continuation) {
        return a0(this, b, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object writeDouble(double d, Continuation continuation) throws Throwable {
        Object objF0 = f0(this, Double.doubleToRawLongBits(d), continuation);
        return objF0 == T1.a.f1304a ? objF0 : N1.m.f1129a;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object writeFloat(float f6, Continuation continuation) throws Throwable {
        Object objE0 = e0(this, Float.floatToRawIntBits(f6), continuation);
        return objE0 == T1.a.f1304a ? objE0 : N1.m.f1129a;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object writeFully(ByteBuffer byteBuffer, Continuation continuation) throws Throwable {
        Object objC0;
        W(byteBuffer);
        return (byteBuffer.hasRemaining() && (objC0 = c0(byteBuffer, continuation)) == T1.a.f1304a) ? objC0 : N1.m.f1129a;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    /* JADX INFO: renamed from: writeFully-JT6ljtQ */
    public final Object mo96writeFullyJT6ljtQ(ByteBuffer byteBuffer, int i, int i3, Continuation continuation) throws Throwable {
        ByteBuffer byteBuffer2 = G1.b.f421a;
        Object objWriteFully = writeFully(C5.f.c0(byteBuffer, i, i3 - i), continuation);
        return objWriteFully == T1.a.f1304a ? objWriteFully : N1.m.f1129a;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object writeInt(int i, Continuation continuation) {
        return e0(this, i, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object writeLong(long j6, Continuation continuation) {
        return f0(this, j6, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object writePacket(I1.d dVar, Continuation continuation) {
        Object objG0;
        while (!dVar.d() && S(dVar) != 0) {
            try {
            } catch (Throwable th) {
                dVar.release();
                throw th;
            }
        }
        return (dVar.f() <= 0 || (objG0 = g0(dVar, continuation)) != T1.a.f1304a) ? N1.m.f1129a : objG0;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object writeShort(short s3, Continuation continuation) {
        return h0(this, s3, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object writeSuspendSession(Function2 function2, Continuation continuation) {
        return l0(this, continuation, function2);
    }

    /* JADX WARN: Finally extract failed */
    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object writeWhile(Function1 function1, Continuation continuation) throws Throwable {
        ByteBuffer byteBufferP = P();
        io.ktor.utils.io.internal.r rVar = ((io.ktor.utils.io.internal.p) this._state).b;
        try {
            io.ktor.utils.io.internal.c cVar = (io.ktor.utils.io.internal.c) this._closed;
            if (cVar != null) {
                AbstractC0132a.b(cVar.a());
                throw null;
            }
            boolean zM0 = m0(byteBufferP, rVar, function1);
            if (rVar.d() || this.f3537a) {
                m(1);
            }
            K();
            R();
            N1.m mVar = N1.m.f1129a;
            if (zM0) {
                io.ktor.utils.io.internal.c cVar2 = (io.ktor.utils.io.internal.c) this._closed;
                if (cVar2 != null) {
                    AbstractC0132a.b(cVar2.a());
                    throw null;
                }
                Object objN0 = n0(function1, continuation);
                if (objN0 == T1.a.f1304a) {
                    return objN0;
                }
            }
            return mVar;
        } catch (Throwable th) {
            if (rVar.d() || this.f3537a) {
                m(1);
            }
            K();
            R();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x(int r7, kotlin.jvm.functions.Function1 r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r9 instanceof io.ktor.utils.io.C0545k
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.utils.io.k r0 = (io.ktor.utils.io.C0545k) r0
            int r1 = r0.f3617f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3617f = r1
            goto L18
        L13:
            io.ktor.utils.io.k r0 = new io.ktor.utils.io.k
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.d
            T1.a r1 = T1.a.f1304a
            int r2 = r0.f3617f
            N1.m r3 = N1.m.f1129a
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3e
            if (r2 == r5) goto L34
            if (r2 != r4) goto L2c
            kotlin.reflect.l.e0(r9)
            return r3
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            int r7 = r0.c
            kotlin.jvm.functions.Function1 r8 = r0.b
            io.ktor.utils.io.U r2 = r0.f3616a
            kotlin.reflect.l.e0(r9)
            goto L56
        L3e:
            kotlin.reflect.l.e0(r9)
            if (r7 >= r5) goto L45
            r9 = r5
            goto L46
        L45:
            r9 = r7
        L46:
            r0.f3616a = r6
            r0.b = r8
            r0.c = r7
            r0.f3617f = r5
            java.lang.Object r9 = r6.D(r9, r0)
            if (r9 != r1) goto L55
            goto L7c
        L55:
            r2 = r6
        L56:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L6f
            if (r7 > 0) goto L61
            goto L7d
        L61:
            java.io.EOFException r8 = new java.io.EOFException
            java.lang.String r9 = "Got EOF but at least "
            java.lang.String r0 = " bytes were expected"
            java.lang.String r7 = B2.b.d(r7, r9, r0)
            r8.<init>(r7)
            throw r8
        L6f:
            r9 = 0
            r0.f3616a = r9
            r0.b = r9
            r0.f3617f = r4
            java.lang.Object r7 = r2.read(r7, r8, r0)
            if (r7 != r1) goto L7d
        L7c:
            return r1
        L7d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.x(int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0055 -> B:22:0x0059). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y(J1.b r8, int r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.C0551q
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.utils.io.q r0 = (io.ktor.utils.io.C0551q) r0
            int r1 = r0.f3626g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3626g = r1
            goto L18
        L13:
            io.ktor.utils.io.q r0 = new io.ktor.utils.io.q
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.e
            T1.a r1 = T1.a.f1304a
            int r2 = r0.f3626g
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            int r8 = r0.d
            int r9 = r0.c
            J1.b r2 = r0.b
            io.ktor.utils.io.U r4 = r0.f3624a
            kotlin.reflect.l.e0(r10)
            goto L59
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            kotlin.reflect.l.e0(r10)
            r10 = 0
            r4 = r7
        L3c:
            int r2 = r8.e
            int r5 = r8.c
            if (r2 <= r5) goto L85
            if (r10 >= r9) goto L85
            r0.f3624a = r4
            r0.b = r8
            r0.c = r9
            r0.d = r10
            r0.f3626g = r3
            java.lang.Object r2 = r4.D(r3, r0)
            if (r2 != r1) goto L55
            return r1
        L55:
            r6 = r2
            r2 = r8
            r8 = r10
            r10 = r6
        L59:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L6b
            int r10 = r9 - r8
            r5 = 2
            int r10 = t(r4, r2, r10, r5)
            int r10 = r10 + r8
            r8 = r2
            goto L3c
        L6b:
            o3.x r10 = new o3.x
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unexpected EOF: expected "
            r0.<init>(r1)
            int r9 = r9 - r8
            r0.append(r9)
            java.lang.String r8 = " more bytes"
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r10.<init>(r8)
            throw r10
        L85:
            N1.m r8 = N1.m.f1129a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.y(J1.b, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x004e -> B:21:0x0051). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z(java.nio.ByteBuffer r6, int r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.C0550p
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.utils.io.p r0 = (io.ktor.utils.io.C0550p) r0
            int r1 = r0.f3623f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3623f = r1
            goto L18
        L13:
            io.ktor.utils.io.p r0 = new io.ktor.utils.io.p
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.d
            T1.a r1 = T1.a.f1304a
            int r2 = r0.f3623f
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            int r6 = r0.c
            java.nio.ByteBuffer r7 = r0.b
            io.ktor.utils.io.U r2 = r0.f3622a
            kotlin.reflect.l.e0(r8)
            goto L51
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            kotlin.reflect.l.e0(r8)
            r2 = r5
        L39:
            boolean r8 = r6.hasRemaining()
            if (r8 == 0) goto L7f
            r0.f3622a = r2
            r0.b = r6
            r0.c = r7
            r0.f3623f = r3
            java.lang.Object r8 = r2.D(r3, r0)
            if (r8 != r1) goto L4e
            return r1
        L4e:
            r4 = r7
            r7 = r6
            r6 = r4
        L51:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L62
            int r8 = r2.r(r7)
            int r6 = r6 + r8
            r4 = r7
            r7 = r6
            r6 = r4
            goto L39
        L62:
            o3.x r6 = new o3.x
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "Unexpected EOF: expected "
            r8.<init>(r0)
            int r7 = r7.remaining()
            r8.append(r7)
            java.lang.String r7 = " more bytes"
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            r6.<init>(r7)
            throw r6
        L7f:
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.z(java.nio.ByteBuffer, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public U(ByteBuffer byteBuffer) {
        this(false, io.ktor.utils.io.internal.h.d, 0);
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        kotlin.jvm.internal.h.e(byteBufferSlice, "content.slice()");
        io.ktor.utils.io.internal.k kVar = new io.ktor.utils.io.internal.k(byteBufferSlice, 0);
        kVar.b.e();
        this._state = kVar.f3586g;
        K();
        close(null);
        R();
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object readFully(ByteBuffer byteBuffer, Continuation continuation) throws Throwable {
        int iR = r(byteBuffer);
        if (!byteBuffer.hasRemaining()) {
            return new Integer(iR);
        }
        return z(byteBuffer, iR, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object writeAvailable(J1.b bVar, Continuation continuation) throws Throwable {
        int iV = V(bVar);
        if (iV > 0) {
            return new Integer(iV);
        }
        return Y(bVar, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object writeFully(I1.a aVar, Continuation continuation) throws Throwable {
        Object objB0;
        V(aVar);
        return (aVar.c <= aVar.b || (objB0 = b0(aVar, continuation)) != T1.a.f1304a) ? N1.m.f1129a : objB0;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object writeAvailable(byte[] bArr, int i, int i3, Continuation continuation) throws Throwable {
        int iX = X(bArr, i, i3);
        if (iX > 0) {
            return new Integer(iX);
        }
        return j0(bArr, i, i3, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object readAvailable(ByteBuffer byteBuffer, Continuation continuation) throws Throwable {
        int iR = r(byteBuffer);
        if (iR == 0 && ((io.ktor.utils.io.internal.c) this._closed) != null) {
            iR = ((io.ktor.utils.io.internal.p) this._state).b.c() ? r(byteBuffer) : -1;
        } else if (iR <= 0 && byteBuffer.hasRemaining()) {
            return v(byteBuffer, continuation);
        }
        return new Integer(iR);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object readFully(J1.b bVar, int i, Continuation continuation) throws Throwable {
        Object objY;
        int iT = t(this, bVar, i, 2);
        return (iT != i && (objY = y(bVar, i - iT, continuation)) == T1.a.f1304a) ? objY : N1.m.f1129a;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object writeFully(byte[] bArr, int i, int i3, Continuation continuation) throws Throwable {
        Object objD0;
        while (i3 > 0) {
            int iX = X(bArr, i, i3);
            if (iX == 0) {
                break;
            }
            i += iX;
            i3 -= iX;
        }
        return (i3 != 0 && (objD0 = d0(bArr, i, i3, continuation)) == T1.a.f1304a) ? objD0 : N1.m.f1129a;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0066 A[DONT_GENERATE] */
    @Override // io.ktor.utils.io.ByteWriteChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int writeAvailable(int r7, kotlin.jvm.functions.Function1 r8) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.String r0 = "block"
            kotlin.jvm.internal.h.f(r8, r0)
            if (r7 <= 0) goto Lb9
            r0 = 4088(0xff8, float:5.729E-42)
            if (r7 > r0) goto La7
            java.nio.ByteBuffer r0 = r6.P()
            java.lang.Object r1 = r6._state
            io.ktor.utils.io.internal.p r1 = (io.ktor.utils.io.internal.p) r1
            io.ktor.utils.io.internal.r r1 = r1.b
            r2 = 1
            java.lang.Object r3 = r6._closed     // Catch: java.lang.Throwable -> L59
            io.ktor.utils.io.internal.c r3 = (io.ktor.utils.io.internal.c) r3     // Catch: java.lang.Throwable -> L59
            if (r3 != 0) goto L8a
        L1c:
            int r3 = r1._availableForWrite$internal     // Catch: java.lang.Throwable -> L59
            r4 = 0
            if (r3 >= r7) goto L23
            r3 = r4
            goto L2b
        L23:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r5 = io.ktor.utils.io.internal.r.c     // Catch: java.lang.Throwable -> L59
            boolean r5 = r5.compareAndSet(r1, r3, r4)     // Catch: java.lang.Throwable -> L59
            if (r5 == 0) goto L1c
        L2b:
            if (r3 > 0) goto L2f
            r7 = r4
            goto L5c
        L2f:
            int r7 = r6.e     // Catch: java.lang.Throwable -> L59
            r6.p(r0, r7, r3)     // Catch: java.lang.Throwable -> L59
            int r7 = r0.position()     // Catch: java.lang.Throwable -> L59
            int r4 = r0.limit()     // Catch: java.lang.Throwable -> L59
            r8.invoke(r0)     // Catch: java.lang.Throwable -> L59
            int r8 = r0.limit()     // Catch: java.lang.Throwable -> L59
            if (r4 != r8) goto L82
            int r8 = r0.position()     // Catch: java.lang.Throwable -> L59
            int r4 = r8 - r7
            if (r4 < 0) goto L7a
            if (r4 < 0) goto L74
            r6.g(r0, r1, r4)     // Catch: java.lang.Throwable -> L59
            if (r4 >= r3) goto L5b
            int r3 = r3 - r4
            r1.a(r3)     // Catch: java.lang.Throwable -> L59
            goto L5b
        L59:
            r7 = move-exception
            goto L93
        L5b:
            r7 = r2
        L5c:
            boolean r8 = r1.d()
            if (r8 != 0) goto L66
            boolean r8 = r6.f3537a
            if (r8 == 0) goto L69
        L66:
            r6.m(r2)
        L69:
            r6.K()
            r6.R()
            if (r7 != 0) goto L73
            r7 = -1
            return r7
        L73:
            return r4
        L74:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L59
            r7.<init>()     // Catch: java.lang.Throwable -> L59
            throw r7     // Catch: java.lang.Throwable -> L59
        L7a:
            java.lang.String r7 = "Position has been moved backward: pushback is not supported"
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L59
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L59
            throw r8     // Catch: java.lang.Throwable -> L59
        L82:
            java.lang.String r7 = "Buffer limit modified"
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L59
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L59
            throw r8     // Catch: java.lang.Throwable -> L59
        L8a:
            java.lang.Throwable r7 = r3.a()     // Catch: java.lang.Throwable -> L59
            a.AbstractC0132a.b(r7)     // Catch: java.lang.Throwable -> L59
            r7 = 0
            throw r7     // Catch: java.lang.Throwable -> L59
        L93:
            boolean r8 = r1.d()
            if (r8 != 0) goto L9d
            boolean r8 = r6.f3537a
            if (r8 == 0) goto La0
        L9d:
            r6.m(r2)
        La0:
            r6.K()
            r6.R()
            throw r7
        La7:
            java.lang.String r8 = "Min("
            java.lang.String r0 = ") shouldn't be greater than 4088"
            java.lang.String r7 = B2.b.d(r7, r8, r0)
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            throw r8
        Lb9:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "min should be positive"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.U.writeAvailable(int, kotlin.jvm.functions.Function1):int");
    }

    public U(boolean z6, ObjectPool pool, int i) {
        kotlin.jvm.internal.h.f(pool, "pool");
        this.f3537a = z6;
        this.b = pool;
        this.c = i;
        this._state = io.ktor.utils.io.internal.i.c;
        this._closed = null;
        this._readOp = null;
        this._writeOp = null;
        this.f3538f = new M3.a(this);
        Y0.b bVar = new Y0.b();
        bVar.b = this;
        J1.b bVar2 = J1.b.f828k;
        bVar.c = bVar2.f750a;
        bVar.d = bVar2;
        bVar.e = ((io.ktor.utils.io.internal.p) this._state).b;
        this.f3539g = bVar;
        this.f3540h = new io.ktor.utils.io.internal.b();
        this.i = new io.ktor.utils.io.internal.b();
        this.f3541j = new S(this, 0);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object readAvailable(J1.b bVar, Continuation continuation) throws Throwable {
        int iT = t(this, bVar, 0, 6);
        if (iT == 0 && ((io.ktor.utils.io.internal.c) this._closed) != null) {
            iT = ((io.ktor.utils.io.internal.p) this._state).b.c() ? t(this, bVar, 0, 6) : -1;
        } else if (iT <= 0 && bVar.e > bVar.c) {
            return u(bVar, continuation);
        }
        return new Integer(iT);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final int readAvailable(int i, Function1 block) throws Throwable {
        int i3;
        int i4;
        kotlin.jvm.internal.h.f(block, "block");
        if (i <= 0) {
            throw new IllegalArgumentException("min should be positive");
        }
        if (i <= 4088) {
            ByteBuffer byteBufferO = O();
            boolean z6 = false;
            if (byteBufferO == null) {
                i4 = 0;
            } else {
                io.ktor.utils.io.internal.r rVar = ((io.ktor.utils.io.internal.p) this._state).b;
                try {
                    if (rVar._availableForRead$internal == 0) {
                        J();
                        R();
                        i4 = 0;
                    } else {
                        while (true) {
                            i3 = rVar._availableForRead$internal;
                            if (i3 < i) {
                                i3 = 0;
                                break;
                            }
                            if (io.ktor.utils.io.internal.r.b.compareAndSet(rVar, i3, 0)) {
                                break;
                            }
                        }
                        if (i3 <= 0 || i3 < i) {
                            i4 = 0;
                        } else {
                            int iPosition = byteBufferO.position();
                            int iLimit = byteBufferO.limit();
                            block.invoke(byteBufferO);
                            if (iLimit == byteBufferO.limit()) {
                                int iPosition2 = byteBufferO.position() - iPosition;
                                if (iPosition2 >= 0) {
                                    f(byteBufferO, rVar, iPosition2);
                                    if (iPosition2 < i3) {
                                        rVar.b(i3 - iPosition2);
                                        rVar.c();
                                    }
                                    z6 = true;
                                    i4 = iPosition2;
                                } else {
                                    throw new IllegalStateException("Position shouldn't been moved backwards.");
                                }
                            } else {
                                throw new IllegalStateException("Buffer limit shouldn't be modified.");
                            }
                        }
                    }
                } finally {
                    J();
                    R();
                }
            }
            if (z6) {
                return i4;
            }
            return -1;
        }
        throw new IllegalArgumentException(B2.b.d(i, "Min(", ") shouldn't be greater than 4088").toString());
    }
}
