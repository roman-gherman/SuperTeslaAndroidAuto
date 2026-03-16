package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface MediaSongOrBuilder extends MessageLiteOrBuilder {
    String getAlbum();

    ByteString getAlbumBytes();

    String getArtist();

    ByteString getArtistBytes();

    String getName();

    ByteString getNameBytes();

    String getPath();

    ByteString getPathBytes();

    boolean hasAlbum();

    boolean hasArtist();

    boolean hasName();

    boolean hasPath();
}
