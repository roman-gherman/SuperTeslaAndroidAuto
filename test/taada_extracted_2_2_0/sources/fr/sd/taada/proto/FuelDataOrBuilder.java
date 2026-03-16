package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface FuelDataOrBuilder extends MessageLiteOrBuilder {
    int getFuelLevel();

    boolean getLowFuelWarning();

    int getRange();

    boolean hasFuelLevel();

    boolean hasLowFuelWarning();

    boolean hasRange();
}
