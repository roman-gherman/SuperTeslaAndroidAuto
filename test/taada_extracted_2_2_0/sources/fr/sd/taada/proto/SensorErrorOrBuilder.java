package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface SensorErrorOrBuilder extends MessageLiteOrBuilder {
    SensorErrorType getSensorErrorType();

    SensorType getSensorType();

    boolean hasSensorErrorType();

    boolean hasSensorType();
}
