package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface PingConfigurationOrBuilder extends MessageLiteOrBuilder {
    int getHighLatencyThresholdMs();

    int getIntervalMs();

    int getTimeoutMs();

    int getTrackedPingCount();

    boolean hasHighLatencyThresholdMs();

    boolean hasIntervalMs();

    boolean hasTimeoutMs();

    boolean hasTrackedPingCount();
}
