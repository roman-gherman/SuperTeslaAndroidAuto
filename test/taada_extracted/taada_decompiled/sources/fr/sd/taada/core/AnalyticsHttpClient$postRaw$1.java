package fr.sd.taada.core;

import N1.h;
import U1.c;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "fr.sd.taada.core.AnalyticsHttpClient", f = "AnalyticsHttpClient.kt", i = {}, l = {85}, m = "postRaw-0E7RQCE", n = {}, s = {})
public final class AnalyticsHttpClient$postRaw$1 extends c {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AnalyticsHttpClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnalyticsHttpClient$postRaw$1(AnalyticsHttpClient analyticsHttpClient, Continuation<? super AnalyticsHttpClient$postRaw$1> continuation) {
        super(continuation);
        this.this$0 = analyticsHttpClient;
    }

    @Override // U1.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM91postRaw0E7RQCE = this.this$0.m91postRaw0E7RQCE(null, null, this);
        return objM91postRaw0E7RQCE == T1.a.f1304a ? objM91postRaw0E7RQCE : new h(objM91postRaw0E7RQCE);
    }
}
