package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface PhoneInfoOrBuilder extends MessageLiteOrBuilder {
    String getConnectivityLifetimeId();

    ByteString getConnectivityLifetimeIdBytes();

    String getInstanceId();

    ByteString getInstanceIdBytes();

    boolean hasConnectivityLifetimeId();

    boolean hasInstanceId();
}
