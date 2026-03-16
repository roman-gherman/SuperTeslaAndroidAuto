package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface BluetoothAuthenticationDataOrBuilder extends MessageLiteOrBuilder {
    String getAuthData();

    ByteString getAuthDataBytes();

    BluetoothPairingMethod getPairingMethod();

    boolean hasAuthData();

    boolean hasPairingMethod();
}
