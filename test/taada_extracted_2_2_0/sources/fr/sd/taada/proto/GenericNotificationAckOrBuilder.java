package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface GenericNotificationAckOrBuilder extends MessageLiteOrBuilder {
    boolean getHandled();

    String getId();

    ByteString getIdBytes();

    boolean hasHandled();

    boolean hasId();
}
