package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface ServiceDiscoveryRequestOrBuilder extends MessageLiteOrBuilder {
    String getDeviceName();

    ByteString getDeviceNameBytes();

    String getLabelText();

    ByteString getLabelTextBytes();

    ByteString getLargeIcon();

    ByteString getMediumIcon();

    PhoneInfo getPhoneInfo();

    ByteString getSmallIcon();

    boolean hasDeviceName();

    boolean hasLabelText();

    boolean hasLargeIcon();

    boolean hasMediumIcon();

    boolean hasPhoneInfo();

    boolean hasSmallIcon();
}
