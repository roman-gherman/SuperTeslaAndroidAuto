package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface MediaSourceOrBuilder extends MessageLiteOrBuilder {
    ByteString getAlbumArt();

    String getName();

    ByteString getNameBytes();

    String getPath();

    ByteString getPathBytes();

    boolean hasAlbumArt();

    boolean hasName();

    boolean hasPath();
}
