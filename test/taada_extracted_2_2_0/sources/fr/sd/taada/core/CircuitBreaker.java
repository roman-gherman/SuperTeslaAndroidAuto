package fr.sd.taada.core;

import C0.x;
import C5.f;
import N1.m;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlinx.coroutines.sync.Mutex;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v3.g;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 72\u00020\u0001:\u000278B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ:\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\n2\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bH\u0082@¢\u0006\u0004\b\u000f\u0010\u0010J;\u0010\u0016\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ:\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\n2\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bH\u0086@¢\u0006\u0004\b \u0010\u0010J=\u0010\"\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\"\u0010\u0017J\r\u0010$\u001a\u00020#¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u0004¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\u0014¢\u0006\u0004\b(\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010)R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010*R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010+R\u0016\u0010,\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106¨\u00069"}, d2 = {"Lfr/sd/taada/core/CircuitBreaker;", "", "", "name", "", "failureThreshold", "", "timeoutMs", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;IJ)V", "T", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "block", "LN1/h;", "attemptExecution-gIAlu-s", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "attemptExecution", "Lkotlin/Function0;", "", "LN1/m;", "onError", "attemptExecutionSync", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "onSuccess", "()V", "e", "onFailure", "(Ljava/lang/Throwable;)V", "", "shouldAttemptReset", "()Z", "execute-gIAlu-s", "execute", "executeBlocking", "Lfr/sd/taada/core/CircuitBreaker$State;", "getState", "()Lfr/sd/taada/core/CircuitBreaker$State;", "getFailureCount", "()I", "reset", "Ljava/lang/String;", "I", "J", "state", "Lfr/sd/taada/core/CircuitBreaker$State;", "Ljava/util/concurrent/atomic/AtomicInteger;", "failureCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicLong;", "lastFailureTime", "Ljava/util/concurrent/atomic/AtomicLong;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "Companion", "State", "common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCircuitBreaker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CircuitBreaker.kt\nfr/sd/taada/core/CircuitBreaker\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,184:1\n120#2,10:185\n*S KotlinDebug\n*F\n+ 1 CircuitBreaker.kt\nfr/sd/taada/core/CircuitBreaker\n*L\n50#1:185,10\n*E\n"})
public final class CircuitBreaker {

    @NotNull
    private static final String TAG = "Core/CircuitBreaker";

    @NotNull
    private final AtomicInteger failureCount;
    private final int failureThreshold;

    @NotNull
    private final AtomicLong lastFailureTime;

    @NotNull
    private final Mutex mutex;

    @NotNull
    private final String name;

    @NotNull
    private volatile State state;
    private final long timeoutMs;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lfr/sd/taada/core/CircuitBreaker$State;", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;I)V", "CLOSED", "OPEN", "HALF_OPEN", "common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class State {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State CLOSED = new State("CLOSED", 0);
        public static final State OPEN = new State("OPEN", 1);
        public static final State HALF_OPEN = new State("HALF_OPEN", 2);

        private static final /* synthetic */ State[] $values() {
            return new State[]{CLOSED, OPEN, HALF_OPEN};
        }

        static {
            State[] stateArr$values = $values();
            $VALUES = stateArr$values;
            $ENTRIES = f.w(stateArr$values);
        }

        private State(String str, int i) {
        }

        @NotNull
        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.HALF_OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[State.CLOSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public CircuitBreaker() {
        this(null, 0, 0L, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: attemptExecution-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> java.lang.Object m93attemptExecutiongIAlus(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<? super N1.h> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof fr.sd.taada.core.CircuitBreaker$attemptExecution$1
            if (r0 == 0) goto L13
            r0 = r6
            fr.sd.taada.core.CircuitBreaker$attemptExecution$1 r0 = (fr.sd.taada.core.CircuitBreaker$attemptExecution$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            fr.sd.taada.core.CircuitBreaker$attemptExecution$1 r0 = new fr.sd.taada.core.CircuitBreaker$attemptExecution$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            T1.a r1 = T1.a.f1304a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            fr.sd.taada.core.CircuitBreaker r5 = (fr.sd.taada.core.CircuitBreaker) r5
            kotlin.reflect.l.e0(r6)     // Catch: java.lang.Exception -> L2b
            goto L44
        L2b:
            r6 = move-exception
            goto L4a
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.reflect.l.e0(r6)
            r0.L$0 = r4     // Catch: java.lang.Exception -> L48
            r0.label = r3     // Catch: java.lang.Exception -> L48
            java.lang.Object r6 = r5.invoke(r0)     // Catch: java.lang.Exception -> L48
            if (r6 != r1) goto L43
            return r1
        L43:
            r5 = r4
        L44:
            r5.onSuccess()     // Catch: java.lang.Exception -> L2b
            return r6
        L48:
            r6 = move-exception
            r5 = r4
        L4a:
            r5.onFailure(r6)
            N1.g r5 = kotlin.reflect.l.n(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.sd.taada.core.CircuitBreaker.m93attemptExecutiongIAlus(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final <T> T attemptExecutionSync(Function0<? extends T> block, Function1<? super Throwable, m> onError) {
        try {
            T tInvoke = block.invoke();
            onSuccess();
            return tInvoke;
        } catch (Exception e) {
            onFailure(e);
            if (onError == null) {
                return null;
            }
            onError.invoke(e);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object executeBlocking$default(CircuitBreaker circuitBreaker, Function0 function0, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        return circuitBreaker.executeBlocking(function0, function1);
    }

    private final void onFailure(Throwable e) {
        Log.w(TAG, "[" + this.name + "] Call failed: " + e.getMessage());
        this.lastFailureTime.set(System.currentTimeMillis());
        int iIncrementAndGet = this.failureCount.incrementAndGet();
        int i = WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()];
        if (i != 1) {
            if (i == 2) {
                this.state = State.OPEN;
                return;
            }
            if (i != 3) {
                throw new x();
            }
            if (iIncrementAndGet >= this.failureThreshold) {
                Log.w(TAG, "[" + this.name + "] Failure threshold reached (" + iIncrementAndGet + "), circuit OPEN");
                this.state = State.OPEN;
            }
        }
    }

    private final void onSuccess() {
        State state = State.CLOSED;
        this.state = State.CLOSED;
        this.failureCount.set(0);
    }

    private final boolean shouldAttemptReset() {
        return System.currentTimeMillis() - this.lastFailureTime.get() >= this.timeoutMs;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00cf, code lost:
    
        if (r12 == r1) goto L51;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r12v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r12v29 */
    /* JADX WARN: Type inference failed for: r12v3, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r12v30 */
    /* JADX WARN: Type inference failed for: r12v31 */
    /* JADX WARN: Type inference failed for: r12v32 */
    /* JADX WARN: Type inference failed for: r12v33 */
    /* JADX WARN: Type inference failed for: r12v34 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [fr.sd.taada.core.CircuitBreaker] */
    /* JADX WARN: Type inference failed for: r8v4 */
    @org.jetbrains.annotations.Nullable
    /* JADX INFO: renamed from: execute-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> java.lang.Object m94executegIAlus(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super N1.h> r13) {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.sd.taada.core.CircuitBreaker.m94executegIAlus(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @JvmOverloads
    @Nullable
    public final <T> T executeBlocking(@NotNull Function0<? extends T> block) {
        h.f(block, "block");
        return (T) executeBlocking$default(this, block, null, 2, null);
    }

    public final int getFailureCount() {
        return this.failureCount.get();
    }

    @NotNull
    public final State getState() {
        return this.state;
    }

    public final void reset() {
        this.state = State.CLOSED;
        this.failureCount.set(0);
        this.lastFailureTime.set(0L);
    }

    public CircuitBreaker(@NotNull String name, int i, long j6) {
        h.f(name, "name");
        this.name = name;
        this.failureThreshold = i;
        this.timeoutMs = j6;
        this.state = State.CLOSED;
        this.failureCount = new AtomicInteger(0);
        this.lastFailureTime = new AtomicLong(0L);
        this.mutex = new g();
    }

    @JvmOverloads
    @Nullable
    public final <T> T executeBlocking(@NotNull Function0<? extends T> block, @Nullable Function1<? super Throwable, m> onError) {
        h.f(block, "block");
        try {
            if (WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()] != 1) {
                return (T) attemptExecutionSync(block, onError);
            }
            if (shouldAttemptReset()) {
                this.state = State.HALF_OPEN;
                return (T) attemptExecutionSync(block, onError);
            }
            if (onError != null) {
                onError.invoke(new CircuitOpenException("Circuit breaker is open"));
            }
            return null;
        } catch (Exception e) {
            Log.e(TAG, "[" + this.name + "] Unexpected error in executeBlocking", e);
            if (onError != null) {
                onError.invoke(e);
            }
            return null;
        }
    }

    public /* synthetic */ CircuitBreaker(String str, int i, long j6, int i3, d dVar) {
        this((i3 & 1) != 0 ? "Default" : str, (i3 & 2) != 0 ? 5 : i, (i3 & 4) != 0 ? 60000L : j6);
    }
}
