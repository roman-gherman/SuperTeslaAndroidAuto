package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface BluetoothPairingResponseOrBuilder extends MessageLiteOrBuilder {
    boolean getAlreadyPaired();

    MessageStatus getStatus();

    boolean hasAlreadyPaired();

    boolean hasStatus();
}
