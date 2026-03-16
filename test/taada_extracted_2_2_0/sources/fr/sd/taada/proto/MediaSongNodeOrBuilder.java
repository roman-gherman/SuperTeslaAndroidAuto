package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface MediaSongNodeOrBuilder extends MessageLiteOrBuilder {
    ByteString getAlbumArt();

    int getDurationSeconds();

    MediaSong getSong();

    boolean hasAlbumArt();

    boolean hasDurationSeconds();

    boolean hasSong();
}
