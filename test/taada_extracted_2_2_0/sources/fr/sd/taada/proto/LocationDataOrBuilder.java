package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface LocationDataOrBuilder extends MessageLiteOrBuilder {
    int getAccuracyE3();

    int getAltitudeE2();

    int getBearingE6();

    int getLatitudeE7();

    int getLongitudeE7();

    int getSpeedE3();

    @Deprecated
    long getTimestamp();

    boolean hasAccuracyE3();

    boolean hasAltitudeE2();

    boolean hasBearingE6();

    boolean hasLatitudeE7();

    boolean hasLongitudeE7();

    boolean hasSpeedE3();

    @Deprecated
    boolean hasTimestamp();
}
