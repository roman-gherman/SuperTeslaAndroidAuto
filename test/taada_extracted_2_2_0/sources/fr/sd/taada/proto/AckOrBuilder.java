package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface AckOrBuilder extends MessageLiteOrBuilder {
    int getAck();

    long getReceiveTimestampNs(int i);

    int getReceiveTimestampNsCount();

    List<Long> getReceiveTimestampNsList();

    int getSessionId();

    boolean hasAck();

    boolean hasSessionId();
}
