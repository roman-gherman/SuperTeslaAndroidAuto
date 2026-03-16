package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface UserSwitchResponseOrBuilder extends MessageLiteOrBuilder {
    ConnectedDevice getSelectedDevice();

    UserSwitchStatus getStatus();

    boolean hasSelectedDevice();

    boolean hasStatus();
}
