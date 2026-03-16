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

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "LN1/m;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "fr.sd.taada.analytics.attribution.AttributionManager$Companion$initialize$1$1", f = "AttributionManager.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
public final class AttributionManager$Companion$initialize$1$1 extends g implements Function2<CoroutineScope, Continuation<? super m>, Object> {
    final /* synthetic */ IAttributionService $service;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AttributionManager$Companion$initialize$1$1(IAttributionService iAttributionService, Continuation<? super AttributionManager$Companion$initialize$1$1> continuation) {
        super(2, continuation);
        this.$service = iAttributionService;
    }

    @Override // U1.a
    public final Continuation<m> create(Object obj, Continuation<?> continuation) {
        return new AttributionManager$Companion$initialize$1$1(this.$service, continuation);
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        a aVar = a.f1304a;
        int i = this.label;
        try {
            if (i == 0) {
                l.e0(obj);
                IAttributionService iAttributionService = this.$service;
                this.label = 1;
                if (iAttributionService.initialize(this) == aVar) {
                    return aVar;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.e0(obj);
            }
        } catch (Exception e) {
            Log.e("Attribution/Manager", "Failed to initialize attribution service", e);
        }
        return m.f1129a;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo5invoke(CoroutineScope coroutineScope, Continuation<? super m> continuation) {
        return ((AttributionManager$Companion$initialize$1$1) create(coroutineScope, continuation)).invokeSuspend(m.f1129a);
    }
}
