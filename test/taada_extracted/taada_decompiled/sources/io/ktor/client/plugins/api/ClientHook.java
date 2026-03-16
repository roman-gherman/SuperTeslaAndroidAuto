package io.ktor.client.plugins.api;

import g1.f;
import io.ktor.util.KtorDsl;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@KtorDsl
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/client/plugins/api/ClientHook;", "HookHandler", "", "Lg1/f;", "client", "handler", "LN1/m;", "install", "(Lg1/f;Ljava/lang/Object;)V", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ClientHook<HookHandler> {
    void install(@NotNull f client, HookHandler handler);
}
