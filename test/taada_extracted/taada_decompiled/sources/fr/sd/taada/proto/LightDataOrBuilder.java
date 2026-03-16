package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface LightDataOrBuilder extends MessageLiteOrBuilder {
    boolean getHazardLightsOn();

    HeadLightState getHeadLightState();

    TurnIndicatorState getTurnIndicatorState();

    boolean hasHazardLightsOn();

    boolean hasHeadLightState();

    boolean hasTurnIndicatorState();
}
