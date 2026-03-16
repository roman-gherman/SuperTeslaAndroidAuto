package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import fr.sd.taada.proto.Config;

/* JADX INFO: loaded from: classes2.dex */
public interface GalVerificationMediaSinkStatusOrBuilder extends MessageLiteOrBuilder {
    int getChannel();

    Config.Status getStatus();

    boolean hasChannel();

    boolean hasStatus();
}
