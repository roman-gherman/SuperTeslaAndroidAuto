package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface AudioFocusNotificationOrBuilder extends MessageLiteOrBuilder {
    AudioFocusStateType getFocusState();

    boolean getUnsolicited();

    boolean hasFocusState();

    boolean hasUnsolicited();
}
