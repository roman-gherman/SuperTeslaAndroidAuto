package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface ChannelOpenRequestOrBuilder extends MessageLiteOrBuilder {
    int getPriority();

    int getServiceId();

    boolean hasPriority();

    boolean hasServiceId();
}
