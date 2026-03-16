package fr.sd.taada.core;

import kotlin.jvm.functions.Function1;
import m1.C0637f;
import m1.M;
import o1.C0736b;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3273a;

    public /* synthetic */ a(int i) {
        this.f3273a = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f3273a) {
            case 0:
                return AnalyticsHttpClient.httpClient$lambda$4$lambda$1((C0736b) obj);
            case 1:
                return AnalyticsHttpClient.httpClient$lambda$4$lambda$2((M) obj);
            default:
                return AnalyticsHttpClient.httpClient$lambda$4$lambda$3((C0637f) obj);
        }
    }
}
