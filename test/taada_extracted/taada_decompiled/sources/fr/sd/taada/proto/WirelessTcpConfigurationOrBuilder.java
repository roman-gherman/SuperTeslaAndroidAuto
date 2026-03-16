package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface WirelessTcpConfigurationOrBuilder extends MessageLiteOrBuilder {
    int getSocketReadTimeoutMs();

    int getSocketReceiveBufferSizeKb();

    int getSocketSendBufferSizeKb();

    boolean hasSocketReadTimeoutMs();

    boolean hasSocketReceiveBufferSizeKb();

    boolean hasSocketSendBufferSizeKb();
}
