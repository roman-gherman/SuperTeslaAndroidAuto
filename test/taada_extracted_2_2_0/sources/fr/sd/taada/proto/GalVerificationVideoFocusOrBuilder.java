package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface GalVerificationVideoFocusOrBuilder extends MessageLiteOrBuilder {
    boolean getDeny();

    boolean getUnsolicited();

    VideoFocusMode getVideoFocusMode();

    boolean hasDeny();

    boolean hasUnsolicited();

    boolean hasVideoFocusMode();
}
