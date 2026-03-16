package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class MediaList extends GeneratedMessageLite<MediaList, Builder> implements MediaListOrBuilder {
    public static final int ALBUM_ART_FIELD_NUMBER = 4;
    private static final MediaList DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 3;
    private static volatile Parser<MediaList> PARSER = null;
    public static final int PATH_FIELD_NUMBER = 1;
    public static final int TYPE_FIELD_NUMBER = 2;
    private int bitField0_;
    private int type_;
    private byte memoizedIsInitialized = 2;
    private String path_ = "";
    private String name_ = "";
    private ByteString albumArt_ = ByteString.EMPTY;

    /* JADX INFO: renamed from: fr.sd.taada.proto.MediaList$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<MediaList, Builder> implements MediaListOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAlbumArt() {
            copyOnWrite();
            ((MediaList) this.instance).clearAlbumArt();
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((MediaList) this.instance).clearName();
            return this;
        }

        public Builder clearPath() {
            copyOnWrite();
            ((MediaList) this.instance).clearPath();
            return this;
        }

        public Builder clearType() {
            copyOnWrite();
            ((MediaList) this.instance).clearType();
            return this;
        }

        @Override // fr.sd.taada.proto.MediaListOrBuilder
        public ByteString getAlbumArt() {
            return ((MediaList) this.instance).getAlbumArt();
        }

        @Override // fr.sd.taada.proto.MediaListOrBuilder
        public String getName() {
            return ((MediaList) this.instance).getName();
        }

        @Override // fr.sd.taada.proto.MediaListOrBuilder
        public ByteString getNameBytes() {
            return ((MediaList) this.instance).getNameBytes();
        }

        @Override // fr.sd.taada.proto.MediaListOrBuilder
        public String getPath() {
            return ((MediaList) this.instance).getPath();
        }

        @Override // fr.sd.taada.proto.MediaListOrBuilder
        public ByteString getPathBytes() {
            return ((MediaList) this.instance).getPathBytes();
        }

        @Override // fr.sd.taada.proto.MediaListOrBuilder
        public Type getType() {
            return ((MediaList) this.instance).getType();
        }

        @Override // fr.sd.taada.proto.MediaListOrBuilder
        public boolean hasAlbumArt() {
            return ((MediaList) this.instance).hasAlbumArt();
        }

        @Override // fr.sd.taada.proto.MediaListOrBuilder
        public boolean hasName() {
            return ((MediaList) this.instance).hasName();
        }

        @Override // fr.sd.taada.proto.MediaListOrBuilder
        public boolean hasPath() {
            return ((MediaList) this.instance).hasPath();
        }

        @Override // fr.sd.taada.proto.MediaListOrBuilder
        public boolean hasType() {
            return ((MediaList) this.instance).hasType();
        }

        public Builder setAlbumArt(ByteString byteString) {
            copyOnWrite();
            ((MediaList) this.instance).setAlbumArt(byteString);
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((MediaList) this.instance).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((MediaList) this.instance).setNameBytes(byteString);
            return this;
        }

        public Builder setPath(String str) {
            copyOnWrite();
            ((MediaList) this.instance).setPath(str);
            return this;
        }

        public Builder setPathBytes(ByteString byteString) {
            copyOnWrite();
            ((MediaList) this.instance).setPathBytes(byteString);
            return this;
        }

        public Builder setType(Type type) {
            copyOnWrite();
            ((MediaList) this.instance).setType(type);
            return this;
        }

        private Builder() {
            super(MediaList.DEFAULT_INSTANCE);
        }
    }

    public enum Type implements Internal.EnumLite {
        UNKNOWN(0),
        PLAYLIST(1),
        ALBUM(2),
        ARTIST(3),
        STATION(4),
        GENRE(5);

        public static final int ALBUM_VALUE = 2;
        public static final int ARTIST_VALUE = 3;
        public static final int GENRE_VALUE = 5;
        public static final int PLAYLIST_VALUE = 1;
        public static final int STATION_VALUE = 4;
        public static final int UNKNOWN_VALUE = 0;
        private static final Internal.EnumLiteMap<Type> internalValueMap = new Internal.EnumLiteMap<Type>() { // from class: fr.sd.taada.proto.MediaList.Type.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Type findValueByNumber(int i) {
                return Type.forNumber(i);
            }
        };
        private final int value;

        public static final class TypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new TypeVerifier();

            private TypeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return Type.forNumber(i) != null;
            }
        }

        Type(int i) {
            this.value = i;
        }

        public static Type forNumber(int i) {
            if (i == 0) {
                return UNKNOWN;
            }
            if (i == 1) {
                return PLAYLIST;
            }
            if (i == 2) {
                return ALBUM;
            }
            if (i == 3) {
                return ARTIST;
            }
            if (i == 4) {
                return STATION;
            }
            if (i != 5) {
                return null;
            }
            return GENRE;
        }

        public static Internal.EnumLiteMap<Type> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return TypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static Type valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        MediaList mediaList = new MediaList();
        DEFAULT_INSTANCE = mediaList;
        GeneratedMessageLite.registerDefaultInstance(MediaList.class, mediaList);
    }

    private MediaList() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAlbumArt() {
        this.bitField0_ &= -9;
        this.albumArt_ = getDefaultInstance().getAlbumArt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.bitField0_ &= -5;
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPath() {
        this.bitField0_ &= -2;
        this.path_ = getDefaultInstance().getPath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.bitField0_ &= -3;
        this.type_ = 0;
    }

    public static MediaList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MediaList parseDelimitedFrom(InputStream inputStream) {
        return (MediaList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MediaList parseFrom(ByteBuffer byteBuffer) {
        return (MediaList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MediaList> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlbumArt(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 8;
        this.albumArt_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 4;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(Type type) {
        type.getClass();
        this.bitField0_ |= 2;
        this.type_ = type.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new MediaList();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0002\u0001Ԉ\u0000\u0002Ԍ\u0001\u0003\b\u0002\u0004\n\u0003", new Object[]{"bitField0_", "path_", "type_", Type.internalGetVerifier(), "name_", "albumArt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MediaList> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MediaList.class) {
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

    @Override // fr.sd.taada.proto.MediaListOrBuilder
    public ByteString getAlbumArt() {
        return this.albumArt_;
    }

    @Override // fr.sd.taada.proto.MediaListOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // fr.sd.taada.proto.MediaListOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // fr.sd.taada.proto.MediaListOrBuilder
    public String getPath() {
        return this.path_;
    }

    @Override // fr.sd.taada.proto.MediaListOrBuilder
    public ByteString getPathBytes() {
        return ByteString.copyFromUtf8(this.path_);
    }

    @Override // fr.sd.taada.proto.MediaListOrBuilder
    public Type getType() {
        Type typeForNumber = Type.forNumber(this.type_);
        return typeForNumber == null ? Type.UNKNOWN : typeForNumber;
    }

    @Override // fr.sd.taada.proto.MediaListOrBuilder
    public boolean hasAlbumArt() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // fr.sd.taada.proto.MediaListOrBuilder
    public boolean hasName() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.MediaListOrBuilder
    public boolean hasPath() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.MediaListOrBuilder
    public boolean hasType() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(MediaList mediaList) {
        return DEFAULT_INSTANCE.createBuilder(mediaList);
    }

    public static MediaList parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MediaList parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MediaList parseFrom(ByteString byteString) {
        return (MediaList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MediaList parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MediaList parseFrom(byte[] bArr) {
        return (MediaList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MediaList parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MediaList parseFrom(InputStream inputStream) {
        return (MediaList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MediaList parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MediaList parseFrom(CodedInputStream codedInputStream) {
        return (MediaList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MediaList parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
