package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface BatteryStatusNotificationOrBuilder extends MessageLiteOrBuilder {
    int getBatteryLevel();

    boolean getCriticalBattery();

    int getTimeRemainingS();

    boolean hasBatteryLevel();

    boolean hasCriticalBattery();

    boolean hasTimeRemainingS();
}
