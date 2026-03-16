package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class MediaPlaybackMetadata extends GeneratedMessageLite<MediaPlaybackMetadata, Builder> implements MediaPlaybackMetadataOrBuilder {
    public static final int ALBUM_ART_FIELD_NUMBER = 4;
    public static final int ALBUM_FIELD_NUMBER = 3;
    public static final int ARTIST_FIELD_NUMBER = 2;
    private static final MediaPlaybackMetadata DEFAULT_INSTANCE;
    public static final int DURATION_SECONDS_FIELD_NUMBER = 6;
    private static volatile Parser<MediaPlaybackMetadata> PARSER = null;
    public static final int PLAYLIST_FIELD_NUMBER = 5;
    public static final int RATING_FIELD_NUMBER = 7;
    public static final int SONG_FIELD_NUMBER = 1;
    private int bitField0_;
    private int durationSeconds_;
    private int rating_;
    private String song_ = "";
    private String artist_ = "";
    private String album_ = "";
    private ByteString albumArt_ = ByteString.EMPTY;
    private String playlist_ = "";

    /* JADX INFO: renamed from: fr.sd.taada.proto.MediaPlaybackMetadata$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<MediaPlaybackMetadata, Builder> implements MediaPlaybackMetadataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAlbum() {
            copyOnWrite();
            ((MediaPlaybackMetadata) this.instance).clearAlbum();
            return this;
        }

        public Builder clearAlbumArt() {
            copyOnWrite();
            ((MediaPlaybackMetadata) this.instance).clearAlbumArt();
            return this;
        }

        public Builder clearArtist() {
            copyOnWrite();
            ((MediaPlaybackMetadata) this.instance).clearArtist();
            return this;
        }

        public Builder clearDurationSeconds() {
            copyOnWrite();
            ((MediaPlaybackMetadata) this.instance).clearDurationSeconds();
            return this;
        }

        public Builder clearPlaylist() {
            copyOnWrite();
            ((MediaPlaybackMetadata) this.instance).clearPlaylist();
            return this;
        }

        public Builder clearRating() {
            copyOnWrite();
            ((MediaPlaybackMetadata) this.instance).clearRating();
            return this;
        }

        public Builder clearSong() {
            copyOnWrite();
            ((MediaPlaybackMetadata) this.instance).clearSong();
            return this;
        }

        @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
        public String getAlbum() {
            return ((MediaPlaybackMetadata) this.instance).getAlbum();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
        public ByteString getAlbumArt() {
            return ((MediaPlaybackMetadata) this.instance).getAlbumArt();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
        public ByteString getAlbumBytes() {
            return ((MediaPlaybackMetadata) this.instance).getAlbumBytes();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
        public String getArtist() {
            return ((MediaPlaybackMetadata) this.instance).getArtist();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
        public ByteString getArtistBytes() {
            return ((MediaPlaybackMetadata) this.instance).getArtistBytes();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
        public int getDurationSeconds() {
            return ((MediaPlaybackMetadata) this.instance).getDurationSeconds();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
        public String getPlaylist() {
            return ((MediaPlaybackMetadata) this.instance).getPlaylist();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
        public ByteString getPlaylistBytes() {
            return ((MediaPlaybackMetadata) this.instance).getPlaylistBytes();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
        public int getRating() {
            return ((MediaPlaybackMetadata) this.instance).getRating();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
        public String getSong() {
            return ((MediaPlaybackMetadata) this.instance).getSong();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
        public ByteString getSongBytes() {
            return ((MediaPlaybackMetadata) this.instance).getSongBytes();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
        public boolean hasAlbum() {
            return ((MediaPlaybackMetadata) this.instance).hasAlbum();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
        public boolean hasAlbumArt() {
            return ((MediaPlaybackMetadata) this.instance).hasAlbumArt();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
        public boolean hasArtist() {
            return ((MediaPlaybackMetadata) this.instance).hasArtist();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
        public boolean hasDurationSeconds() {
            return ((MediaPlaybackMetadata) this.instance).hasDurationSeconds();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
        public boolean hasPlaylist() {
            return ((MediaPlaybackMetadata) this.instance).hasPlaylist();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
        public boolean hasRating() {
            return ((MediaPlaybackMetadata) this.instance).hasRating();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
        public boolean hasSong() {
            return ((MediaPlaybackMetadata) this.instance).hasSong();
        }

        public Builder setAlbum(String str) {
            copyOnWrite();
            ((MediaPlaybackMetadata) this.instance).setAlbum(str);
            return this;
        }

        public Builder setAlbumArt(ByteString byteString) {
            copyOnWrite();
            ((MediaPlaybackMetadata) this.instance).setAlbumArt(byteString);
            return this;
        }

        public Builder setAlbumBytes(ByteString byteString) {
            copyOnWrite();
            ((MediaPlaybackMetadata) this.instance).setAlbumBytes(byteString);
            return this;
        }

        public Builder setArtist(String str) {
            copyOnWrite();
            ((MediaPlaybackMetadata) this.instance).setArtist(str);
            return this;
        }

        public Builder setArtistBytes(ByteString byteString) {
            copyOnWrite();
            ((MediaPlaybackMetadata) this.instance).setArtistBytes(byteString);
            return this;
        }

        public Builder setDurationSeconds(int i) {
            copyOnWrite();
            ((MediaPlaybackMetadata) this.instance).setDurationSeconds(i);
            return this;
        }

        public Builder setPlaylist(String str) {
            copyOnWrite();
            ((MediaPlaybackMetadata) this.instance).setPlaylist(str);
            return this;
        }

        public Builder setPlaylistBytes(ByteString byteString) {
            copyOnWrite();
            ((MediaPlaybackMetadata) this.instance).setPlaylistBytes(byteString);
            return this;
        }

        public Builder setRating(int i) {
            copyOnWrite();
            ((MediaPlaybackMetadata) this.instance).setRating(i);
            return this;
        }

        public Builder setSong(String str) {
            copyOnWrite();
            ((MediaPlaybackMetadata) this.instance).setSong(str);
            return this;
        }

        public Builder setSongBytes(ByteString byteString) {
            copyOnWrite();
            ((MediaPlaybackMetadata) this.instance).setSongBytes(byteString);
            return this;
        }

        private Builder() {
            super(MediaPlaybackMetadata.DEFAULT_INSTANCE);
        }
    }

    static {
        MediaPlaybackMetadata mediaPlaybackMetadata = new MediaPlaybackMetadata();
        DEFAULT_INSTANCE = mediaPlaybackMetadata;
        GeneratedMessageLite.registerDefaultInstance(MediaPlaybackMetadata.class, mediaPlaybackMetadata);
    }

    private MediaPlaybackMetadata() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAlbum() {
        this.bitField0_ &= -5;
        this.album_ = getDefaultInstance().getAlbum();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAlbumArt() {
        this.bitField0_ &= -9;
        this.albumArt_ = getDefaultInstance().getAlbumArt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearArtist() {
        this.bitField0_ &= -3;
        this.artist_ = getDefaultInstance().getArtist();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDurationSeconds() {
        this.bitField0_ &= -33;
        this.durationSeconds_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPlaylist() {
        this.bitField0_ &= -17;
        this.playlist_ = getDefaultInstance().getPlaylist();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRating() {
        this.bitField0_ &= -65;
        this.rating_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSong() {
        this.bitField0_ &= -2;
        this.song_ = getDefaultInstance().getSong();
    }

    public static MediaPlaybackMetadata getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MediaPlaybackMetadata parseDelimitedFrom(InputStream inputStream) {
        return (MediaPlaybackMetadata) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MediaPlaybackMetadata parseFrom(ByteBuffer byteBuffer) {
        return (MediaPlaybackMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MediaPlaybackMetadata> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlbum(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.album_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlbumArt(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 8;
        this.albumArt_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlbumBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 4;
        this.album_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setArtist(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.artist_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setArtistBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 2;
        this.artist_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDurationSeconds(int i) {
        this.bitField0_ |= 32;
        this.durationSeconds_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaylist(String str) {
        str.getClass();
        this.bitField0_ |= 16;
        this.playlist_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaylistBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 16;
        this.playlist_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRating(int i) {
        this.bitField0_ |= 64;
        this.rating_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSong(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.song_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSongBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.song_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new MediaPlaybackMetadata();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\n\u0003\u0005\b\u0004\u0006\u000b\u0005\u0007\u0004\u0006", new Object[]{"bitField0_", "song_", "artist_", "album_", "albumArt_", "playlist_", "durationSeconds_", "rating_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MediaPlaybackMetadata> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MediaPlaybackMetadata.class) {
                    try {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
    public String getAlbum() {
        return this.album_;
    }

    @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
    public ByteString getAlbumArt() {
        return this.albumArt_;
    }

    @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
    public ByteString getAlbumBytes() {
        return ByteString.copyFromUtf8(this.album_);
    }

    @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
    public String getArtist() {
        return this.artist_;
    }

    @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
    public ByteString getArtistBytes() {
        return ByteString.copyFromUtf8(this.artist_);
    }

    @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
    public int getDurationSeconds() {
        return this.durationSeconds_;
    }

    @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
    public String getPlaylist() {
        return this.playlist_;
    }

    @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
    public ByteString getPlaylistBytes() {
        return ByteString.copyFromUtf8(this.playlist_);
    }

    @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
    public int getRating() {
        return this.rating_;
    }

    @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
    public String getSong() {
        return this.song_;
    }

    @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
    public ByteString getSongBytes() {
        return ByteString.copyFromUtf8(this.song_);
    }

    @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
    public boolean hasAlbum() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
    public boolean hasAlbumArt() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
    public boolean hasArtist() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
    public boolean hasDurationSeconds() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
    public boolean hasPlaylist() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
    public boolean hasRating() {
        return (this.bitField0_ & 64) != 0;
    }

    @Override // fr.sd.taada.proto.MediaPlaybackMetadataOrBuilder
    public boolean hasSong() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(MediaPlaybackMetadata mediaPlaybackMetadata) {
        return DEFAULT_INSTANCE.createBuilder(mediaPlaybackMetadata);
    }

    public static MediaPlaybackMetadata parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaPlaybackMetadata) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MediaPlaybackMetadata parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaPlaybackMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MediaPlaybackMetadata parseFrom(ByteString byteString) {
        return (MediaPlaybackMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MediaPlaybackMetadata parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaPlaybackMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MediaPlaybackMetadata parseFrom(byte[] bArr) {
        return (MediaPlaybackMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MediaPlaybackMetadata parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaPlaybackMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MediaPlaybackMetadata parseFrom(InputStream inputStream) {
        return (MediaPlaybackMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MediaPlaybackMetadata parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaPlaybackMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MediaPlaybackMetadata parseFrom(CodedInputStream codedInputStream) {
        return (MediaPlaybackMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MediaPlaybackMetadata parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaPlaybackMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
