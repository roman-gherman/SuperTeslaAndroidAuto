package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface BluetoothServiceOrBuilder extends MessageLiteOrBuilder {
    String getCarAddress();

    ByteString getCarAddressBytes();

    BluetoothPairingMethod getSupportedPairingMethods(int i);

    int getSupportedPairingMethodsCount();

    List<BluetoothPairingMethod> getSupportedPairingMethodsList();

    boolean hasCarAddress();
}
