package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface SpeedDataOrBuilder extends MessageLiteOrBuilder {
    boolean getCruiseEngaged();

    int getCruiseSetSpeed();

    int getSpeedE3();

    boolean hasCruiseEngaged();

    boolean hasCruiseSetSpeed();

    boolean hasSpeedE3();
}
