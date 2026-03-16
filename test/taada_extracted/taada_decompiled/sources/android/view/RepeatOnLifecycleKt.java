package android.view;

import N1.m;
import T1.a;
import U1.g;
import android.view.Lifecycle;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.l;
import kotlinx.coroutines.CoroutineScope;
import m3.AbstractC0690y;
import m3.G;
import n3.C0729d;
import r3.o;
import r3.t;
import t3.d;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aE\u0010\n\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0002\b\bH\u0086@¢\u0006\u0004\b\n\u0010\u000b\u001aE\u0010\n\u001a\u00020\u0006*\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00012'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0002\b\bH\u0086@¢\u0006\u0004\b\n\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/Lifecycle$State;", "state", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "LN1/m;", "", "Lkotlin/ExtensionFunctionType;", "block", "repeatOnLifecycle", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RepeatOnLifecycleKt {

    /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "LN1/m;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends g implements Function2<CoroutineScope, Continuation<? super m>, Object> {
        final /* synthetic */ Function2<CoroutineScope, Continuation<? super m>, Object> $block;
        final /* synthetic */ Lifecycle.State $state;
        final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "LN1/m;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {1, 8, 0})
        @DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", i = {0, 0}, l = {166}, m = "invokeSuspend", n = {"launchedJob", "observer"}, s = {"L$0", "L$1"})
        public static final class AnonymousClass1 extends g implements Function2<CoroutineScope, Continuation<? super m>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function2<CoroutineScope, Continuation<? super m>, Object> $block;
            final /* synthetic */ Lifecycle.State $state;
            final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(Lifecycle lifecycle, Lifecycle.State state, CoroutineScope coroutineScope, Function2<? super CoroutineScope, ? super Continuation<? super m>, ? extends Object> function2, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$this_repeatOnLifecycle = lifecycle;
                this.$state = state;
                this.$$this$coroutineScope = coroutineScope;
                this.$block = function2;
            }

            @Override // U1.a
            public final Continuation<m> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, this.$$this$coroutineScope, this.$block, continuation);
            }

            /* JADX WARN: Removed duplicated region for block: B:22:0x0097  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x00a0  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x00af  */
            /* JADX WARN: Removed duplicated region for block: B:34:0x00b8  */
            /* JADX WARN: Removed duplicated region for block: B:40:? A[SYNTHETIC] */
            @Override // U1.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
                /*
                    r14 = this;
                    T1.a r0 = T1.a.f1304a
                    int r1 = r14.label
                    N1.m r2 = N1.m.f1129a
                    r3 = 0
                    r4 = 1
                    if (r1 == 0) goto L36
                    if (r1 != r4) goto L2e
                    java.lang.Object r0 = r14.L$5
                    kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
                    java.lang.Object r0 = r14.L$4
                    kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
                    java.lang.Object r0 = r14.L$3
                    androidx.lifecycle.Lifecycle r0 = (android.view.Lifecycle) r0
                    java.lang.Object r0 = r14.L$2
                    androidx.lifecycle.Lifecycle$State r0 = (androidx.lifecycle.Lifecycle.State) r0
                    java.lang.Object r0 = r14.L$1
                    r1 = r0
                    kotlin.jvm.internal.v r1 = (kotlin.jvm.internal.v) r1
                    java.lang.Object r0 = r14.L$0
                    r4 = r0
                    kotlin.jvm.internal.v r4 = (kotlin.jvm.internal.v) r4
                    kotlin.reflect.l.e0(r15)     // Catch: java.lang.Throwable -> L2a
                    goto L91
                L2a:
                    r0 = move-exception
                    r15 = r0
                    goto La9
                L2e:
                    java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r15.<init>(r0)
                    throw r15
                L36:
                    kotlin.reflect.l.e0(r15)
                    androidx.lifecycle.Lifecycle r15 = r14.$this_repeatOnLifecycle
                    androidx.lifecycle.Lifecycle$State r15 = r15.getState()
                    androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.DESTROYED
                    if (r15 != r1) goto L44
                    goto La5
                L44:
                    kotlin.jvm.internal.v r7 = new kotlin.jvm.internal.v
                    r7.<init>()
                    kotlin.jvm.internal.v r1 = new kotlin.jvm.internal.v
                    r1.<init>()
                    androidx.lifecycle.Lifecycle$State r15 = r14.$state     // Catch: java.lang.Throwable -> La6
                    androidx.lifecycle.Lifecycle r13 = r14.$this_repeatOnLifecycle     // Catch: java.lang.Throwable -> La6
                    kotlinx.coroutines.CoroutineScope r8 = r14.$$this$coroutineScope     // Catch: java.lang.Throwable -> La6
                    kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super N1.m>, java.lang.Object> r12 = r14.$block     // Catch: java.lang.Throwable -> La6
                    r14.L$0 = r7     // Catch: java.lang.Throwable -> La6
                    r14.L$1 = r1     // Catch: java.lang.Throwable -> La6
                    r14.L$2 = r15     // Catch: java.lang.Throwable -> La6
                    r14.L$3 = r13     // Catch: java.lang.Throwable -> La6
                    r14.L$4 = r8     // Catch: java.lang.Throwable -> La6
                    r14.L$5 = r12     // Catch: java.lang.Throwable -> La6
                    r14.label = r4     // Catch: java.lang.Throwable -> La6
                    m3.f r10 = new m3.f     // Catch: java.lang.Throwable -> La6
                    kotlin.coroutines.Continuation r5 = C5.f.J(r14)     // Catch: java.lang.Throwable -> La6
                    r10.<init>(r4, r5)     // Catch: java.lang.Throwable -> La6
                    r10.initCancellability()     // Catch: java.lang.Throwable -> La6
                    androidx.lifecycle.Lifecycle$Event$Companion r4 = androidx.lifecycle.Lifecycle.Event.INSTANCE     // Catch: java.lang.Throwable -> La6
                    androidx.lifecycle.Lifecycle$Event r6 = r4.upTo(r15)     // Catch: java.lang.Throwable -> La6
                    androidx.lifecycle.Lifecycle$Event r9 = r4.downFrom(r15)     // Catch: java.lang.Throwable -> La6
                    v3.g r11 = new v3.g     // Catch: java.lang.Throwable -> La6
                    r11.<init>()     // Catch: java.lang.Throwable -> La6
                    androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 r5 = new androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1     // Catch: java.lang.Throwable -> La6
                    r5.<init>()     // Catch: java.lang.Throwable -> La6
                    r1.f3816a = r5     // Catch: java.lang.Throwable -> La6
                    r13.addObserver(r5)     // Catch: java.lang.Throwable -> La6
                    java.lang.Object r15 = r10.m()     // Catch: java.lang.Throwable -> La6
                    if (r15 != r0) goto L90
                    return r0
                L90:
                    r4 = r7
                L91:
                    java.lang.Object r15 = r4.f3816a
                    kotlinx.coroutines.Job r15 = (kotlinx.coroutines.Job) r15
                    if (r15 == 0) goto L9a
                    r15.cancel(r3)
                L9a:
                    java.lang.Object r15 = r1.f3816a
                    androidx.lifecycle.LifecycleEventObserver r15 = (android.view.LifecycleEventObserver) r15
                    if (r15 == 0) goto La5
                    androidx.lifecycle.Lifecycle r0 = r14.$this_repeatOnLifecycle
                    r0.removeObserver(r15)
                La5:
                    return r2
                La6:
                    r0 = move-exception
                    r15 = r0
                    r4 = r7
                La9:
                    java.lang.Object r0 = r4.f3816a
                    kotlinx.coroutines.Job r0 = (kotlinx.coroutines.Job) r0
                    if (r0 == 0) goto Lb2
                    r0.cancel(r3)
                Lb2:
                    java.lang.Object r0 = r1.f3816a
                    androidx.lifecycle.LifecycleEventObserver r0 = (android.view.LifecycleEventObserver) r0
                    if (r0 == 0) goto Lbd
                    androidx.lifecycle.Lifecycle r1 = r14.$this_repeatOnLifecycle
                    r1.removeObserver(r0)
                Lbd:
                    throw r15
                */
                throw new UnsupportedOperationException("Method not decompiled: android.view.RepeatOnLifecycleKt.AnonymousClass3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo5invoke(CoroutineScope coroutineScope, Continuation<? super m> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(m.f1129a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Lifecycle lifecycle, Lifecycle.State state, Function2<? super CoroutineScope, ? super Continuation<? super m>, ? extends Object> function2, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$this_repeatOnLifecycle = lifecycle;
            this.$state = state;
            this.$block = function2;
        }

        @Override // U1.a
        public final Continuation<m> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$this_repeatOnLifecycle, this.$state, this.$block, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // U1.a
        public final Object invokeSuspend(Object obj) {
            a aVar = a.f1304a;
            int i = this.label;
            if (i == 0) {
                l.e0(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                d dVar = G.f4104a;
                C0729d c0729d = ((C0729d) o.f4718a).c;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, coroutineScope, this.$block, null);
                this.label = 1;
                if (AbstractC0690y.m(c0729d, anonymousClass1, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.e0(obj);
            }
            return m.f1129a;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo5invoke(CoroutineScope coroutineScope, Continuation<? super m> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(m.f1129a);
        }
    }

    public static final Object repeatOnLifecycle(Lifecycle lifecycle, Lifecycle.State state, Function2<? super CoroutineScope, ? super Continuation<? super m>, ? extends Object> function2, Continuation<? super m> continuation) throws Throwable {
        if (state == Lifecycle.State.INITIALIZED) {
            throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.");
        }
        Lifecycle.State state2 = lifecycle.getState();
        Lifecycle.State state3 = Lifecycle.State.DESTROYED;
        m mVar = m.f1129a;
        if (state2 != state3) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(lifecycle, state, function2, null);
            t tVar = new t(continuation, continuation.getContext());
            Object objQ = io.ktor.utils.io.internal.t.q(tVar, tVar, anonymousClass3);
            if (objQ == a.f1304a) {
                return objQ;
            }
        }
        return mVar;
    }

    public static final Object repeatOnLifecycle(LifecycleOwner lifecycleOwner, Lifecycle.State state, Function2<? super CoroutineScope, ? super Continuation<? super m>, ? extends Object> function2, Continuation<? super m> continuation) throws Throwable {
        Object objRepeatOnLifecycle = repeatOnLifecycle(lifecycleOwner.getLifecycle(), state, function2, continuation);
        return objRepeatOnLifecycle == a.f1304a ? objRepeatOnLifecycle : m.f1129a;
    }
}
