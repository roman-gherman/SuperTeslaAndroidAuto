package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface PhoneStatusInputOrBuilder extends MessageLiteOrBuilder {
    String getCallerId();

    ByteString getCallerIdBytes();

    String getCallerNumber();

    ByteString getCallerNumberBytes();

    InstrumentClusterInput getInput();

    boolean hasCallerId();

    boolean hasCallerNumber();

    boolean hasInput();
}
