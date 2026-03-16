package io.ktor.websocket;

import N1.m;
import io.ktor.websocket.WebSocketExtension;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import z1.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0001J(\u0010\t\u001a\u00028\u00012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007H&¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u000f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011¨\u0006\u0017"}, d2 = {"Lio/ktor/websocket/WebSocketExtensionFactory;", "", "ConfigType", "Lio/ktor/websocket/WebSocketExtension;", "ExtensionType", "Lkotlin/Function1;", "LN1/m;", "Lkotlin/ExtensionFunctionType;", "config", "install", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/websocket/WebSocketExtension;", "Lz1/a;", "getKey", "()Lz1/a;", "key", "", "getRsv1", "()Z", "rsv1", "getRsv2", "rsv2", "getRsv3", "rsv3", "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface WebSocketExtensionFactory<ConfigType, ExtensionType extends WebSocketExtension<ConfigType>> {
    @NotNull
    a getKey();

    boolean getRsv1();

    boolean getRsv2();

    boolean getRsv3();

    @NotNull
    ExtensionType install(@NotNull Function1<? super ConfigType, m> config);
}
