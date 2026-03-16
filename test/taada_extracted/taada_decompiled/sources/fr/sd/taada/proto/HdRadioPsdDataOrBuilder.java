package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface HdRadioPsdDataOrBuilder extends MessageLiteOrBuilder {
    String getAlbum();

    ByteString getAlbumBytes();

    String getArtist();

    ByteString getArtistBytes();

    HdRadioArtistExperience getArtistExperience();

    HdRadioComment getComment();

    HdRadioCommercial getCommercial();

    String getGenre();

    ByteString getGenreBytes();

    String getTitle();

    ByteString getTitleBytes();

    boolean hasAlbum();

    boolean hasArtist();

    boolean hasArtistExperience();

    boolean hasComment();

    boolean hasCommercial();

    boolean hasGenre();

    boolean hasTitle();
}
