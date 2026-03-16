package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface SensorRequestOrBuilder extends MessageLiteOrBuilder {
    long getMinUpdatePeriod();

    SensorType getType();

    boolean hasMinUpdatePeriod();

    boolean hasType();
}
