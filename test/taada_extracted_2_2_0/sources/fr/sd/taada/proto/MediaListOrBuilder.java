package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import fr.sd.taada.proto.MediaList;

/* JADX INFO: loaded from: classes2.dex */
public interface MediaListOrBuilder extends MessageLiteOrBuilder {
    ByteString getAlbumArt();

    String getName();

    ByteString getNameBytes();

    String getPath();

    ByteString getPathBytes();

    MediaList.Type getType();

    boolean hasAlbumArt();

    boolean hasName();

    boolean hasPath();

    boolean hasType();
}
