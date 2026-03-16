package org.java_websocket.handshake;

/* JADX INFO: loaded from: classes.dex */
public interface ServerHandshakeBuilder extends HandshakeBuilder, ServerHandshake {
    void setHttpStatus(short s3);

    void setHttpStatusMessage(String str);
}
