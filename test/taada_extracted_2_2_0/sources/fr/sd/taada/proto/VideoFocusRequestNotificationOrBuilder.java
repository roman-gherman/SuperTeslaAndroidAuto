package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface VideoFocusRequestNotificationOrBuilder extends MessageLiteOrBuilder {
    @Deprecated
    int getDispChannelId();

    VideoFocusMode getMode();

    VideoFocusReason getReason();

    @Deprecated
    boolean hasDispChannelId();

    boolean hasMode();

    boolean hasReason();
}
