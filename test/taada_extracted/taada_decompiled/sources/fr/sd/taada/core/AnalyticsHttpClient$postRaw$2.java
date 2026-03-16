package fr.sd.taada.core;

import N1.h;
import N1.m;
import U1.g;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.l;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "LN1/h;", "", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)LN1/h;"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "fr.sd.taada.core.AnalyticsHttpClient$postRaw$2", f = "AnalyticsHttpClient.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
public final class AnalyticsHttpClient$postRaw$2 extends g implements Function2<CoroutineScope, Continuation<? super h>, Object> {
    final /* synthetic */ Object $body;
    final /* synthetic */ String $endpoint;
    int label;
    final /* synthetic */ AnalyticsHttpClient this$0;

    /* JADX INFO: renamed from: fr.sd.taada.core.AnalyticsHttpClient$postRaw$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "fr.sd.taada.core.AnalyticsHttpClient$postRaw$2$1", f = "AnalyticsHttpClient.kt", i = {}, l = {186, 98}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nAnalyticsHttpClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnalyticsHttpClient.kt\nfr/sd/taada/core/AnalyticsHttpClient$postRaw$2$1\n+ 2 builders.kt\nio/ktor/client/request/BuildersKt\n+ 3 RequestBody.kt\nio/ktor/client/request/RequestBodyKt\n+ 4 TypeInfoJvm.kt\nio/ktor/util/reflect/TypeInfoJvmKt\n*L\n1#1,164:1\n343#2:165\n233#2:166\n109#2,2:184\n22#2:186\n16#3,4:167\n21#3,10:174\n17#4,3:171\n*S KotlinDebug\n*F\n+ 1 AnalyticsHttpClient.kt\nfr/sd/taada/core/AnalyticsHttpClient$postRaw$2$1\n*L\n89#1:165\n89#1:166\n89#1:184,2\n89#1:186\n90#1:167,4\n90#1:174,10\n90#1:171,3\n*E\n"})
    public static final class AnonymousClass1 extends g implements Function1<Continuation<? super String>, Object> {
        final /* synthetic */ Object $body;
        final /* synthetic */ String $endpoint;
        int label;
        final /* synthetic */ AnalyticsHttpClient this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, AnalyticsHttpClient analyticsHttpClient, Object obj, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$endpoint = str;
            this.this$0 = analyticsHttpClient;
            this.$body = obj;
        }

        @Override // U1.a
        public final Continuation<m> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$endpoint, this.this$0, this.$body, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x00e8, code lost:
        
            if (r11 == r0) goto L29;
         */
        @Override // U1.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws A.a, fr.sd.taada.core.HttpException {
            /*
                Method dump skipped, instruction units count: 289
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: fr.sd.taada.core.AnalyticsHttpClient$postRaw$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super String> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(m.f1129a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnalyticsHttpClient$postRaw$2(AnalyticsHttpClient analyticsHttpClient, String str, Object obj, Continuation<? super AnalyticsHttpClient$postRaw$2> continuation) {
        super(2, continuation);
        this.this$0 = analyticsHttpClient;
        this.$endpoint = str;
        this.$body = obj;
    }

    @Override // U1.a
    public final Continuation<m> create(Object obj, Continuation<?> continuation) {
        return new AnalyticsHttpClient$postRaw$2(this.this$0, this.$endpoint, this.$body, continuation);
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        Object objM94executegIAlus;
        T1.a aVar = T1.a.f1304a;
        int i = this.label;
        if (i == 0) {
            l.e0(obj);
            CircuitBreaker circuitBreaker = this.this$0.circuitBreaker;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$endpoint, this.this$0, this.$body, null);
            this.label = 1;
            objM94executegIAlus = circuitBreaker.m94executegIAlus(anonymousClass1, this);
            if (objM94executegIAlus == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.e0(obj);
            objM94executegIAlus = ((h) obj).f1124a;
        }
        return new h(objM94executegIAlus);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo5invoke(CoroutineScope coroutineScope, Continuation<? super h> continuation) {
        return ((AnalyticsHttpClient$postRaw$2) create(coroutineScope, continuation)).invokeSuspend(m.f1129a);
    }
}
