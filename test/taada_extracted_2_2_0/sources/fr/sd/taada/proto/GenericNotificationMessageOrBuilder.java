package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface GenericNotificationMessageOrBuilder extends MessageLiteOrBuilder {
    ByteString getIcon();

    String getId();

    ByteString getIdBytes();

    String getText();

    ByteString getTextBytes();

    boolean hasIcon();

    boolean hasId();

    boolean hasText();
}
