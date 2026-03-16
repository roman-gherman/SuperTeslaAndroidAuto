package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class MediaSong extends GeneratedMessageLite<MediaSong, Builder> implements MediaSongOrBuilder {
    public static final int ALBUM_FIELD_NUMBER = 4;
    public static final int ARTIST_FIELD_NUMBER = 3;
    private static final MediaSong DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile Parser<MediaSong> PARSER = null;
    public static final int PATH_FIELD_NUMBER = 1;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private String path_ = "";
    private String name_ = "";
    private String artist_ = "";
    private String album_ = "";

    /* JADX INFO: renamed from: fr.sd.taada.proto.MediaSong$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<MediaSong, Builder> implements MediaSongOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAlbum() {
            copyOnWrite();
            ((MediaSong) this.instance).clearAlbum();
            return this;
        }

        public Builder clearArtist() {
            copyOnWrite();
            ((MediaSong) this.instance).clearArtist();
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((MediaSong) this.instance).clearName();
            return this;
        }

        public Builder clearPath() {
            copyOnWrite();
            ((MediaSong) this.instance).clearPath();
            return this;
        }

        @Override // fr.sd.taada.proto.MediaSongOrBuilder
        public String getAlbum() {
            return ((MediaSong) this.instance).getAlbum();
        }

        @Override // fr.sd.taada.proto.MediaSongOrBuilder
        public ByteString getAlbumBytes() {
            return ((MediaSong) this.instance).getAlbumBytes();
        }

        @Override // fr.sd.taada.proto.MediaSongOrBuilder
        public String getArtist() {
            return ((MediaSong) this.instance).getArtist();
        }

        @Override // fr.sd.taada.proto.MediaSongOrBuilder
        public ByteString getArtistBytes() {
            return ((MediaSong) this.instance).getArtistBytes();
        }

        @Override // fr.sd.taada.proto.MediaSongOrBuilder
        public String getName() {
            return ((MediaSong) this.instance).getName();
        }

        @Override // fr.sd.taada.proto.MediaSongOrBuilder
        public ByteString getNameBytes() {
            return ((MediaSong) this.instance).getNameBytes();
        }

        @Override // fr.sd.taada.proto.MediaSongOrBuilder
        public String getPath() {
            return ((MediaSong) this.instance).getPath();
        }

        @Override // fr.sd.taada.proto.MediaSongOrBuilder
        public ByteString getPathBytes() {
            return ((MediaSong) this.instance).getPathBytes();
        }

        @Override // fr.sd.taada.proto.MediaSongOrBuilder
        public boolean hasAlbum() {
            return ((MediaSong) this.instance).hasAlbum();
        }

        @Override // fr.sd.taada.proto.MediaSongOrBuilder
        public boolean hasArtist() {
            return ((MediaSong) this.instance).hasArtist();
        }

        @Override // fr.sd.taada.proto.MediaSongOrBuilder
        public boolean hasName() {
            return ((MediaSong) this.instance).hasName();
        }

        @Override // fr.sd.taada.proto.MediaSongOrBuilder
        public boolean hasPath() {
            return ((MediaSong) this.instance).hasPath();
        }

        public Builder setAlbum(String str) {
            copyOnWrite();
            ((MediaSong) this.instance).setAlbum(str);
            return this;
        }

        public Builder setAlbumBytes(ByteString byteString) {
            copyOnWrite();
            ((MediaSong) this.instance).setAlbumBytes(byteString);
            return this;
        }

        public Builder setArtist(String str) {
            copyOnWrite();
            ((MediaSong) this.instance).setArtist(str);
            return this;
        }

        public Builder setArtistBytes(ByteString byteString) {
            copyOnWrite();
            ((MediaSong) this.instance).setArtistBytes(byteString);
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((MediaSong) this.instance).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((MediaSong) this.instance).setNameBytes(byteString);
            return this;
        }

        public Builder setPath(String str) {
            copyOnWrite();
            ((MediaSong) this.instance).setPath(str);
            return this;
        }

        public Builder setPathBytes(ByteString byteString) {
            copyOnWrite();
            ((MediaSong) this.instance).setPathBytes(byteString);
            return this;
        }

        private Builder() {
            super(MediaSong.DEFAULT_INSTANCE);
        }
    }

    static {
        MediaSong mediaSong = new MediaSong();
        DEFAULT_INSTANCE = mediaSong;
        GeneratedMessageLite.registerDefaultInstance(MediaSong.class, mediaSong);
    }

    private MediaSong() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAlbum() {
        this.bitField0_ &= -9;
        this.album_ = getDefaultInstance().getAlbum();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearArtist() {
        this.bitField0_ &= -5;
        this.artist_ = getDefaultInstance().getArtist();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.bitField0_ &= -3;
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPath() {
        this.bitField0_ &= -2;
        this.path_ = getDefaultInstance().getPath();
    }

    public static MediaSong getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MediaSong parseDelimitedFrom(InputStream inputStream) {
        return (MediaSong) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MediaSong parseFrom(ByteBuffer byteBuffer) {
        return (MediaSong) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MediaSong> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlbum(String str) {
        str.getClass();
        this.bitField0_ |= 8;
        this.album_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlbumBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 8;
        this.album_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setArtist(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.artist_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setArtistBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 4;
        this.artist_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 2;
        this.name_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPath(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.path_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPathBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.path_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new MediaSong();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0002\u0001Ԉ\u0000\u0002Ԉ\u0001\u0003\b\u0002\u0004\b\u0003", new Object[]{"bitField0_", "path_", "name_", "artist_", "album_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MediaSong> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MediaSong.class) {
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
                return Byte.valueOf(this.memoizedIsInitialized);
            case 7:
                this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // fr.sd.taada.proto.MediaSongOrBuilder
    public String getAlbum() {
        return this.album_;
    }

    @Override // fr.sd.taada.proto.MediaSongOrBuilder
    public ByteString getAlbumBytes() {
        return ByteString.copyFromUtf8(this.album_);
    }

    @Override // fr.sd.taada.proto.MediaSongOrBuilder
    public String getArtist() {
        return this.artist_;
    }

    @Override // fr.sd.taada.proto.MediaSongOrBuilder
    public ByteString getArtistBytes() {
        return ByteString.copyFromUtf8(this.artist_);
    }

    @Override // fr.sd.taada.proto.MediaSongOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // fr.sd.taada.proto.MediaSongOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // fr.sd.taada.proto.MediaSongOrBuilder
    public String getPath() {
        return this.path_;
    }

    @Override // fr.sd.taada.proto.MediaSongOrBuilder
    public ByteString getPathBytes() {
        return ByteString.copyFromUtf8(this.path_);
    }

    @Override // fr.sd.taada.proto.MediaSongOrBuilder
    public boolean hasAlbum() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // fr.sd.taada.proto.MediaSongOrBuilder
    public boolean hasArtist() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.MediaSongOrBuilder
    public boolean hasName() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.MediaSongOrBuilder
    public boolean hasPath() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(MediaSong mediaSong) {
        return DEFAULT_INSTANCE.createBuilder(mediaSong);
    }

    public static MediaSong parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSong) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MediaSong parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSong) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MediaSong parseFrom(ByteString byteString) {
        return (MediaSong) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MediaSong parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSong) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MediaSong parseFrom(byte[] bArr) {
        return (MediaSong) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MediaSong parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSong) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MediaSong parseFrom(InputStream inputStream) {
        return (MediaSong) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MediaSong parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSong) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MediaSong parseFrom(CodedInputStream codedInputStream) {
        return (MediaSong) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MediaSong parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSong) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
