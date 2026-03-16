package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface MediaPlaybackMetadataOrBuilder extends MessageLiteOrBuilder {
    String getAlbum();

    ByteString getAlbumArt();

    ByteString getAlbumBytes();

    String getArtist();

    ByteString getArtistBytes();

    int getDurationSeconds();

    String getPlaylist();

    ByteString getPlaylistBytes();

    int getRating();

    String getSong();

    ByteString getSongBytes();

    boolean hasAlbum();

    boolean hasAlbumArt();

    boolean hasArtist();

    boolean hasDurationSeconds();

    boolean hasPlaylist();

    boolean hasRating();

    boolean hasSong();
}
