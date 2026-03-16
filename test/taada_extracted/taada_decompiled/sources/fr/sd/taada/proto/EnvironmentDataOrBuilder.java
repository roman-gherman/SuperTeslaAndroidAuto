package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface EnvironmentDataOrBuilder extends MessageLiteOrBuilder {
    int getPressureE3();

    int getRain();

    int getTemperatureE3();

    boolean hasPressureE3();

    boolean hasRain();

    boolean hasTemperatureE3();
}
