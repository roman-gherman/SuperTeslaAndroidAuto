package fr.sd.taada.core;

import A2.C0019a;
import N1.m;
import U1.g;
import android.util.Log;
import androidx.work.WorkRequest;
import com.google.gson.n;
import fr.sd.taada.core.CircuitBreaker;
import g1.f;
import io.ktor.utils.io.internal.t;
import java.util.List;
import k1.C0578c;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.w;
import kotlin.reflect.KType;
import kotlin.reflect.l;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import m1.AbstractC0640i;
import m1.C0637f;
import m1.C0639h;
import m1.M;
import m1.P;
import m3.AbstractC0690y;
import m3.G;
import net.bytebuddy.description.method.MethodDescription;
import o1.C0736b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import q1.c;
import r1.j;
import u1.AbstractC0838c;
import u1.C0840e;
import u1.q;
import u1.r;
import u1.z;
import x1.C0912a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\b\u001a\u00020\u0002H\u0086@¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0012\u0010\fJ\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u001c\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lfr/sd/taada/core/AnalyticsHttpClient;", "", "", "baseUrl", "Lkotlin/Function0;", "tokenProvider", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "endpoint", "body", "LN1/h;", "postRaw-0E7RQCE", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postRaw", "getRaw-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRaw", "LN1/m;", "fireAndForget", "Lfr/sd/taada/core/CircuitBreaker$State;", "getCircuitState", "()Lfr/sd/taada/core/CircuitBreaker$State;", "Ljava/lang/String;", "Lkotlin/jvm/functions/Function0;", "Lfr/sd/taada/core/CircuitBreaker;", "circuitBreaker", "Lfr/sd/taada/core/CircuitBreaker;", "Lg1/f;", "httpClient", "Lg1/f;", "Companion", "common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnalyticsHttpClient {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final long DEFAULT_TIMEOUT_MS = 30000;

    @NotNull
    private static final String TAG = "Core/HttpClient";

    @Nullable
    private static volatile AnalyticsHttpClient instance;

    @NotNull
    private final String baseUrl;

    @NotNull
    private final CircuitBreaker circuitBreaker;

    @NotNull
    private final f httpClient;

    @NotNull
    private final Function0<String> tokenProvider;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lfr/sd/taada/core/AnalyticsHttpClient$Companion;", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "", "baseUrl", "Lkotlin/Function0;", "tokenProvider", "LN1/m;", "initialize", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "Lfr/sd/taada/core/AnalyticsHttpClient;", "getInstance", "()Lfr/sd/taada/core/AnalyticsHttpClient;", "", "isInitialized", "()Z", "TAG", "Ljava/lang/String;", "", "DEFAULT_TIMEOUT_MS", "J", "instance", "Lfr/sd/taada/core/AnalyticsHttpClient;", "common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(d dVar) {
            this();
        }

        @NotNull
        public final AnalyticsHttpClient getInstance() {
            AnalyticsHttpClient analyticsHttpClient = AnalyticsHttpClient.instance;
            if (analyticsHttpClient != null) {
                return analyticsHttpClient;
            }
            throw new IllegalStateException("AnalyticsHttpClient not initialized. Call initialize() first.");
        }

        public final void initialize(@NotNull String baseUrl, @NotNull Function0<String> tokenProvider) {
            h.f(baseUrl, "baseUrl");
            h.f(tokenProvider, "tokenProvider");
            synchronized (this) {
                if (AnalyticsHttpClient.instance == null) {
                    AnalyticsHttpClient.instance = new AnalyticsHttpClient(baseUrl, tokenProvider, null);
                }
            }
        }

        public final boolean isInitialized() {
            return AnalyticsHttpClient.instance != null;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: fr.sd.taada.core.AnalyticsHttpClient$fireAndForget$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "fr.sd.taada.core.AnalyticsHttpClient$fireAndForget$2", f = "AnalyticsHttpClient.kt", i = {}, l = {186}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nAnalyticsHttpClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnalyticsHttpClient.kt\nfr/sd/taada/core/AnalyticsHttpClient$fireAndForget$2\n+ 2 builders.kt\nio/ktor/client/request/BuildersKt\n+ 3 RequestBody.kt\nio/ktor/client/request/RequestBodyKt\n+ 4 TypeInfoJvm.kt\nio/ktor/util/reflect/TypeInfoJvmKt\n*L\n1#1,164:1\n343#2:165\n233#2:166\n109#2,2:184\n22#2:186\n16#3,4:167\n21#3,10:174\n17#4,3:171\n*S KotlinDebug\n*F\n+ 1 AnalyticsHttpClient.kt\nfr/sd/taada/core/AnalyticsHttpClient$fireAndForget$2\n*L\n141#1:165\n141#1:166\n141#1:184,2\n141#1:186\n142#1:167,4\n142#1:174,10\n142#1:171,3\n*E\n"})
    public static final class AnonymousClass2 extends g implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
        final /* synthetic */ Object $body;
        final /* synthetic */ String $endpoint;
        int label;
        final /* synthetic */ AnalyticsHttpClient this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, AnalyticsHttpClient analyticsHttpClient, Object obj, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$endpoint = str;
            this.this$0 = analyticsHttpClient;
            this.$body = obj;
        }

        @Override // U1.a
        public final Continuation<m> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$endpoint, this.this$0, this.$body, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo5invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, (Continuation<Object>) continuation);
        }

        @Override // U1.a
        public final Object invokeSuspend(Object obj) {
            T1.a aVar = T1.a.f1304a;
            int i = this.label;
            try {
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    l.e0(obj);
                    return obj;
                }
                l.e0(obj);
                f fVar = this.this$0.httpClient;
                String urlString = this.this$0.baseUrl + this.$endpoint;
                Object obj2 = this.$body;
                AnalyticsHttpClient analyticsHttpClient = this.this$0;
                c cVar = new c();
                h.f(urlString, "urlString");
                z.b(cVar.f4513a, urlString);
                if (obj2 == null) {
                    cVar.d = v1.d.f4928a;
                    KType kTypeA = w.a(Object.class);
                    cVar.a(l.i0(l.F(kTypeA), w.f3818a.b(Object.class), kTypeA));
                } else if (obj2 instanceof v1.g) {
                    cVar.d = obj2;
                    cVar.a(null);
                } else {
                    cVar.d = obj2;
                    KType kTypeA2 = w.a(Object.class);
                    cVar.a(l.i0(l.F(kTypeA2), w.f3818a.b(Object.class), kTypeA2));
                }
                String str = (String) analyticsHttpClient.tokenProvider.invoke();
                if (str != null) {
                    List list = q.f4870a;
                    t.m(cVar, "Bearer ".concat(str));
                }
                r rVar = r.c;
                h.f(rVar, "<set-?>");
                cVar.b = rVar;
                j jVar = new j(cVar, fVar);
                this.label = 1;
                Object objB = jVar.b(new r1.h(2, null), this);
                return objB == aVar ? aVar : objB;
            } catch (Exception e) {
                return new Integer(Log.d(AnalyticsHttpClient.TAG, "Fire-and-forget failed (expected): " + e.getMessage()));
            }
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<Object> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(m.f1129a);
        }
    }

    public /* synthetic */ AnalyticsHttpClient(String str, Function0 function0, d dVar) {
        this(str, function0);
    }

    private static final m httpClient$lambda$4(g1.h HttpClient) {
        h.f(HttpClient, "$this$HttpClient");
        HttpClient.a(o1.g.c, new a(0));
        HttpClient.a(P.d, new a(1));
        a aVar = new a(2);
        Logger logger = AbstractC0640i.f4055a;
        HttpClient.a(C0639h.b, new C0019a(aVar, 24));
        return m.f1129a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final m httpClient$lambda$4$lambda$1(C0736b install) {
        h.f(install, "$this$install");
        C0840e contentType = AbstractC0838c.f4860a;
        h.f(contentType, "contentType");
        n nVar = new n();
        httpClient$lambda$4$lambda$1$lambda$0(nVar);
        install.register(contentType, new y1.g(nVar.a()), C0912a.f5105a);
        return m.f1129a;
    }

    private static final m httpClient$lambda$4$lambda$1$lambda$0(n gson) {
        h.f(gson, "$this$gson");
        gson.f3033j = true;
        gson.f3034k = true;
        return m.f1129a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final m httpClient$lambda$4$lambda$2(M install) {
        h.f(install, "$this$install");
        M.a(30000L);
        install.f4044a = 30000L;
        Long lValueOf = Long.valueOf(WorkRequest.MIN_BACKOFF_MILLIS);
        M.a(lValueOf);
        install.b = lValueOf;
        M.a(30000L);
        install.c = 30000L;
        return m.f1129a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final m httpClient$lambda$4$lambda$3(C0637f defaultRequest) {
        h.f(defaultRequest, "$this$defaultRequest");
        C0840e c0840e = AbstractC0838c.f4860a;
        C0840e type = AbstractC0838c.f4860a;
        h.f(type, "type");
        u1.m headers = defaultRequest.getHeaders();
        List list = q.f4870a;
        headers.set("Content-Type", type.toString());
        return m.f1129a;
    }

    @Nullable
    public final Object fireAndForget(@NotNull String str, @NotNull Object obj, @NotNull Continuation<? super m> continuation) throws Throwable {
        Object objM = AbstractC0690y.m(G.c, new AnonymousClass2(str, this, obj, null), continuation);
        return objM == T1.a.f1304a ? objM : m.f1129a;
    }

    @NotNull
    public final CircuitBreaker.State getCircuitState() {
        return this.circuitBreaker.getState();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /* JADX INFO: renamed from: getRaw-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m90getRawgIAlus(@org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super N1.h> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof fr.sd.taada.core.AnalyticsHttpClient$getRaw$1
            if (r0 == 0) goto L13
            r0 = r7
            fr.sd.taada.core.AnalyticsHttpClient$getRaw$1 r0 = (fr.sd.taada.core.AnalyticsHttpClient$getRaw$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            fr.sd.taada.core.AnalyticsHttpClient$getRaw$1 r0 = new fr.sd.taada.core.AnalyticsHttpClient$getRaw$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            T1.a r1 = T1.a.f1304a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.reflect.l.e0(r7)
            goto L43
        L27:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L2f:
            kotlin.reflect.l.e0(r7)
            t3.c r7 = m3.G.c
            fr.sd.taada.core.AnalyticsHttpClient$getRaw$2 r2 = new fr.sd.taada.core.AnalyticsHttpClient$getRaw$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.label = r3
            java.lang.Object r7 = m3.AbstractC0690y.m(r7, r2, r0)
            if (r7 != r1) goto L43
            return r1
        L43:
            N1.h r7 = (N1.h) r7
            java.lang.Object r6 = r7.f1124a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.sd.taada.core.AnalyticsHttpClient.m90getRawgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /* JADX INFO: renamed from: postRaw-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m91postRaw0E7RQCE(@org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull java.lang.Object r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super N1.h> r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof fr.sd.taada.core.AnalyticsHttpClient$postRaw$1
            if (r0 == 0) goto L13
            r0 = r8
            fr.sd.taada.core.AnalyticsHttpClient$postRaw$1 r0 = (fr.sd.taada.core.AnalyticsHttpClient$postRaw$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            fr.sd.taada.core.AnalyticsHttpClient$postRaw$1 r0 = new fr.sd.taada.core.AnalyticsHttpClient$postRaw$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            T1.a r1 = T1.a.f1304a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.reflect.l.e0(r8)
            goto L43
        L27:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L2f:
            kotlin.reflect.l.e0(r8)
            t3.c r8 = m3.G.c
            fr.sd.taada.core.AnalyticsHttpClient$postRaw$2 r2 = new fr.sd.taada.core.AnalyticsHttpClient$postRaw$2
            r4 = 0
            r2.<init>(r5, r6, r7, r4)
            r0.label = r3
            java.lang.Object r8 = m3.AbstractC0690y.m(r8, r2, r0)
            if (r8 != r1) goto L43
            return r1
        L43:
            N1.h r8 = (N1.h) r8
            java.lang.Object r6 = r8.f1124a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.sd.taada.core.AnalyticsHttpClient.m91postRaw0E7RQCE(java.lang.String, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private AnalyticsHttpClient(String str, Function0<String> function0) {
        this.baseUrl = str;
        this.tokenProvider = function0;
        this.circuitBreaker = new CircuitBreaker("HttpClient", 0, 0L, 6, null);
        g1.h hVar = new g1.h();
        httpClient$lambda$4(hVar);
        g1.c block = hVar.d;
        h.f(block, "block");
        k1.h hVar2 = new k1.h();
        hVar2.f3699a = k1.g.c;
        hVar2.b = k1.g.b;
        block.invoke(hVar2);
        C0578c c0578c = new C0578c(hVar2);
        f fVar = new f(c0578c, hVar);
        CoroutineContext.Element element = fVar.d.get(Job.Key);
        h.c(element);
        ((Job) element).invokeOnCompletion(new C0019a(c0578c, 16));
        this.httpClient = fVar;
    }
}
