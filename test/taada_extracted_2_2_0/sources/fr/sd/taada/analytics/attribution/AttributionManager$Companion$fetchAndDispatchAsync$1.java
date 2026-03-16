package fr.sd.taada.analytics.attribution;

import N1.m;
import T1.a;
import U1.g;
import android.util.Log;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.l;
import kotlinx.coroutines.CoroutineScope;
import m3.AbstractC0690y;
import m3.v0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "LN1/m;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "fr.sd.taada.analytics.attribution.AttributionManager$Companion$fetchAndDispatchAsync$1", f = "AttributionManager.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
public final class AttributionManager$Companion$fetchAndDispatchAsync$1 extends g implements Function2<CoroutineScope, Continuation<? super m>, Object> {
    int label;

    /* JADX INFO: renamed from: fr.sd.taada.analytics.attribution.AttributionManager$Companion$fetchAndDispatchAsync$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "fr.sd.taada.analytics.attribution.AttributionManager$Companion$fetchAndDispatchAsync$1$1", f = "AttributionManager.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends g implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // U1.a
        public final Continuation<m> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // U1.a
        public final Object invokeSuspend(Object obj) {
            a aVar = a.f1304a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.e0(obj);
                return obj;
            }
            l.e0(obj);
            AttributionManager companion = AttributionManager.INSTANCE.getInstance();
            this.label = 1;
            Object objFetchAndDispatch = companion.fetchAndDispatch(this);
            return objFetchAndDispatch == aVar ? aVar : objFetchAndDispatch;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo5invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(m.f1129a);
        }
    }

    public AttributionManager$Companion$fetchAndDispatchAsync$1(Continuation<? super AttributionManager$Companion$fetchAndDispatchAsync$1> continuation) {
        super(2, continuation);
    }

    @Override // U1.a
    public final Continuation<m> create(Object obj, Continuation<?> continuation) {
        return new AttributionManager$Companion$fetchAndDispatchAsync$1(continuation);
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        a aVar = a.f1304a;
        int i = this.label;
        try {
            if (i == 0) {
                l.e0(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
                this.label = 1;
                if (AbstractC0690y.n(anonymousClass1, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.e0(obj);
            }
        } catch (v0 unused) {
            Log.w("Attribution/Manager", "fetchAndDispatchAsync timed out after 30s (unstable network)");
        } catch (Exception e) {
            Log.w("Attribution/Manager", "fetchAndDispatchAsync failed: " + e.getMessage());
        }
        return m.f1129a;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo5invoke(CoroutineScope coroutineScope, Continuation<? super m> continuation) {
        return ((AttributionManager$Companion$fetchAndDispatchAsync$1) create(coroutineScope, continuation)).invokeSuspend(m.f1129a);
    }
}
