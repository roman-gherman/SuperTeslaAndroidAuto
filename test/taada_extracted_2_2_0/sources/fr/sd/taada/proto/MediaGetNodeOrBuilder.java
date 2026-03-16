package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface MediaGetNodeOrBuilder extends MessageLiteOrBuilder {
    boolean getGetAlbumArt();

    String getPath();

    ByteString getPathBytes();

    int getStart();

    boolean hasGetAlbumArt();

    boolean hasPath();

    boolean hasStart();
}
