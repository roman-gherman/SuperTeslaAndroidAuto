package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface PingRequestOrBuilder extends MessageLiteOrBuilder {
    boolean getBugReport();

    ByteString getData();

    long getTimestamp();

    boolean hasBugReport();

    boolean hasData();

    boolean hasTimestamp();
}
