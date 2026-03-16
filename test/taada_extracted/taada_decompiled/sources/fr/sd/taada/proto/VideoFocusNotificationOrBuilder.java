package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface VideoFocusNotificationOrBuilder extends MessageLiteOrBuilder {
    VideoFocusMode getFocus();

    boolean getUnsolicited();

    boolean hasFocus();

    boolean hasUnsolicited();
}
