package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface PingResponseOrBuilder extends MessageLiteOrBuilder {
    ByteString getData();

    long getTimestamp();

    boolean hasData();

    boolean hasTimestamp();
}
