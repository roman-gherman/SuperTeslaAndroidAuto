package io.ktor.client.plugins.websocket;

import androidx.core.app.NotificationCompat;
import h1.C0494b;
import io.ktor.websocket.WebSocketSession;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lio/ktor/client/plugins/websocket/ClientWebSocketSession;", "Lio/ktor/websocket/WebSocketSession;", "Lh1/b;", "getCall", "()Lh1/b;", NotificationCompat.CATEGORY_CALL, "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ClientWebSocketSession extends WebSocketSession {
    @NotNull
    C0494b getCall();
}
