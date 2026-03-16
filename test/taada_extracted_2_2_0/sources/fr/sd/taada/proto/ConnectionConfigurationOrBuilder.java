package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface ConnectionConfigurationOrBuilder extends MessageLiteOrBuilder {
    PingConfiguration getPingConfiguration();

    WirelessTcpConfiguration getWirelessTcpConfiguration();

    boolean hasPingConfiguration();

    boolean hasWirelessTcpConfiguration();
}
