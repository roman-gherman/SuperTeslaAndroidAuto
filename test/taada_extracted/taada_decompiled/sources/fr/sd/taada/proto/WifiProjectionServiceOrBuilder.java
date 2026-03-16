package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface WifiProjectionServiceOrBuilder extends MessageLiteOrBuilder {
    String getCarWifiBssid();

    ByteString getCarWifiBssidBytes();

    boolean hasCarWifiBssid();
}
