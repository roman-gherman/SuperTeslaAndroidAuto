package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface MediaBrowserInputOrBuilder extends MessageLiteOrBuilder {
    InstrumentClusterInput getInput();

    String getPath();

    ByteString getPathBytes();

    boolean hasInput();

    boolean hasPath();
}
