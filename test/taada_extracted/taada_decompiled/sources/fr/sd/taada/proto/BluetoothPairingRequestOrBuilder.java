package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface BluetoothPairingRequestOrBuilder extends MessageLiteOrBuilder {
    BluetoothPairingMethod getPairingMethod();

    String getPhoneAddress();

    ByteString getPhoneAddressBytes();

    boolean hasPairingMethod();

    boolean hasPhoneAddress();
}
