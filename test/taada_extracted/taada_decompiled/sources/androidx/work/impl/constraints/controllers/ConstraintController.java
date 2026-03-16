package androidx.work.impl.constraints.controllers;

import N1.m;
import T1.a;
import U1.g;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.i;
import kotlin.reflect.l;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import o3.AbstractC0740A;
import p3.v;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0015\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014R\u0018\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/work/impl/constraints/controllers/ConstraintController;", "T", "", "tracker", "Landroidx/work/impl/constraints/trackers/ConstraintTracker;", "(Landroidx/work/impl/constraints/trackers/ConstraintTracker;)V", "reason", "", "getReason$annotations", "()V", "getReason", "()I", "hasConstraint", "", "workSpec", "Landroidx/work/impl/model/WorkSpec;", "isConstrained", "value", "(Ljava/lang/Object;)Z", "track", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/work/impl/constraints/ConstraintsState;", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ConstraintController<T> {
    private final ConstraintTracker<T> tracker;

    /* JADX INFO: renamed from: androidx.work.impl.constraints.controllers.ConstraintController$track$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "Lkotlinx/coroutines/channels/ProducerScope;", "Landroidx/work/impl/constraints/ConstraintsState;", "LN1/m;", "<anonymous>", "(Lkotlinx/coroutines/channels/ProducerScope;)V"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "androidx.work.impl.constraints.controllers.ConstraintController$track$1", f = "ContraintControllers.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends g implements Function2<ProducerScope<? super ConstraintsState>, Continuation<? super m>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ConstraintController<T> this$0;

        /* JADX INFO: renamed from: androidx.work.impl.constraints.controllers.ConstraintController$track$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "LN1/m;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        public static final class C00151 extends i implements Function0<m> {
            final /* synthetic */ ConstraintController$track$1$listener$1 $listener;
            final /* synthetic */ ConstraintController<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00151(ConstraintController constraintController, ConstraintController$track$1$listener$1 constraintController$track$1$listener$1) {
                super(0);
                this.this$0 = constraintController;
                this.$listener = constraintController$track$1$listener$1;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ m invoke() {
                invoke2();
                return m.f1129a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ((ConstraintController) this.this$0).tracker.removeListener(this.$listener);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ConstraintController<T> constraintController, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = constraintController;
        }

        @Override // U1.a
        public final Continuation<m> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // U1.a
        public final Object invokeSuspend(Object obj) {
            a aVar = a.f1304a;
            int i = this.label;
            if (i == 0) {
                l.e0(obj);
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                final ConstraintController<T> constraintController = this.this$0;
                ConstraintListener<T> constraintListener = new ConstraintListener<T>() { // from class: androidx.work.impl.constraints.controllers.ConstraintController$track$1$listener$1
                    @Override // androidx.work.impl.constraints.ConstraintListener
                    public void onConstraintChanged(T newValue) {
                        producerScope.getChannel().mo106trySendJP2dKIU(constraintController.isConstrained(newValue) ? new ConstraintsState.ConstraintsNotMet(constraintController.getReason()) : ConstraintsState.ConstraintsMet.INSTANCE);
                    }
                };
                ((ConstraintController) this.this$0).tracker.addListener(constraintListener);
                C00151 c00151 = new C00151(this.this$0, constraintListener);
                this.label = 1;
                if (AbstractC0740A.a(producerScope, c00151, this) == aVar) {
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
        public final Object mo5invoke(ProducerScope<? super ConstraintsState> producerScope, Continuation<? super m> continuation) {
            return ((AnonymousClass1) create(producerScope, continuation)).invokeSuspend(m.f1129a);
        }
    }

    public ConstraintController(ConstraintTracker<T> tracker) {
        h.f(tracker, "tracker");
        this.tracker = tracker;
    }

    public static /* synthetic */ void getReason$annotations() {
    }

    public abstract int getReason();

    public abstract boolean hasConstraint(WorkSpec workSpec);

    public final boolean isConstrained(WorkSpec workSpec) {
        h.f(workSpec, "workSpec");
        return hasConstraint(workSpec) && isConstrained(this.tracker.readSystemState());
    }

    public abstract boolean isConstrained(T value);

    public final Flow<ConstraintsState> track() {
        return v.c(new AnonymousClass1(this, null));
    }
}
