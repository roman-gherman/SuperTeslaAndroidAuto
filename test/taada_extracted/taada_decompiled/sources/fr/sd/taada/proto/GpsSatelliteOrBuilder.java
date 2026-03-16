package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface GpsSatelliteOrBuilder extends MessageLiteOrBuilder {
    int getAzimuthE3();

    int getElevationE3();

    int getPrn();

    int getSnrE3();

    boolean getUsedInFix();

    boolean hasAzimuthE3();

    boolean hasElevationE3();

    boolean hasPrn();

    boolean hasSnrE3();

    boolean hasUsedInFix();
}
