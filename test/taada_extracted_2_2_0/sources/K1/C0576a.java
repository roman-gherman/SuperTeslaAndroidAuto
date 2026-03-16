package k1;

import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.engine.HttpClientEngineFactory;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: k1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0576a implements HttpClientEngineFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0576a f3691a = new C0576a();

    @Override // io.ktor.client.engine.HttpClientEngineFactory
    public final HttpClientEngine create(Function1 block) {
        kotlin.jvm.internal.h.f(block, "block");
        h hVar = new h();
        hVar.f3699a = g.c;
        hVar.b = g.b;
        block.invoke(hVar);
        return new C0578c(hVar);
    }
}
