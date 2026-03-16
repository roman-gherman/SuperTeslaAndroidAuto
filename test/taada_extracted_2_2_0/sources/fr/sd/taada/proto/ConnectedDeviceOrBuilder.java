package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface ConnectedDeviceOrBuilder extends MessageLiteOrBuilder {
    int getDeviceId();

    String getDeviceName();

    ByteString getDeviceNameBytes();

    boolean hasDeviceId();

    boolean hasDeviceName();
}
