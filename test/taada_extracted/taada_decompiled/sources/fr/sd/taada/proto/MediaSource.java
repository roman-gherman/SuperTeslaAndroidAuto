package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class MediaSource extends GeneratedMessageLite<MediaSource, Builder> implements MediaSourceOrBuilder {
    public static final int ALBUM_ART_FIELD_NUMBER = 3;
    private static final MediaSource DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile Parser<MediaSource> PARSER = null;
    public static final int PATH_FIELD_NUMBER = 1;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private String path_ = "";
    private String name_ = "";
    private ByteString albumArt_ = ByteString.EMPTY;

    /* JADX INFO: renamed from: fr.sd.taada.proto.MediaSource$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<MediaSource, Builder> implements MediaSourceOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAlbumArt() {
            copyOnWrite();
            ((MediaSource) this.instance).clearAlbumArt();
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((MediaSource) this.instance).clearName();
            return this;
        }

        public Builder clearPath() {
            copyOnWrite();
            ((MediaSource) this.instance).clearPath();
            return this;
        }

        @Override // fr.sd.taada.proto.MediaSourceOrBuilder
        public ByteString getAlbumArt() {
            return ((MediaSource) this.instance).getAlbumArt();
        }

        @Override // fr.sd.taada.proto.MediaSourceOrBuilder
        public String getName() {
            return ((MediaSource) this.instance).getName();
        }

        @Override // fr.sd.taada.proto.MediaSourceOrBuilder
        public ByteString getNameBytes() {
            return ((MediaSource) this.instance).getNameBytes();
        }

        @Override // fr.sd.taada.proto.MediaSourceOrBuilder
        public String getPath() {
            return ((MediaSource) this.instance).getPath();
        }

        @Override // fr.sd.taada.proto.MediaSourceOrBuilder
        public ByteString getPathBytes() {
            return ((MediaSource) this.instance).getPathBytes();
        }

        @Override // fr.sd.taada.proto.MediaSourceOrBuilder
        public boolean hasAlbumArt() {
            return ((MediaSource) this.instance).hasAlbumArt();
        }

        @Override // fr.sd.taada.proto.MediaSourceOrBuilder
        public boolean hasName() {
            return ((MediaSource) this.instance).hasName();
        }

        @Override // fr.sd.taada.proto.MediaSourceOrBuilder
        public boolean hasPath() {
            return ((MediaSource) this.instance).hasPath();
        }

        public Builder setAlbumArt(ByteString byteString) {
            copyOnWrite();
            ((MediaSource) this.instance).setAlbumArt(byteString);
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((MediaSource) this.instance).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((MediaSource) this.instance).setNameBytes(byteString);
            return this;
        }

        public Builder setPath(String str) {
            copyOnWrite();
            ((MediaSource) this.instance).setPath(str);
            return this;
        }

        public Builder setPathBytes(ByteString byteString) {
            copyOnWrite();
            ((MediaSource) this.instance).setPathBytes(byteString);
            return this;
        }

        private Builder() {
            super(MediaSource.DEFAULT_INSTANCE);
        }
    }

    static {
        MediaSource mediaSource = new MediaSource();
        DEFAULT_INSTANCE = mediaSource;
        GeneratedMessageLite.registerDefaultInstance(MediaSource.class, mediaSource);
    }

    private MediaSource() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAlbumArt() {
        this.bitField0_ &= -5;
        this.albumArt_ = getDefaultInstance().getAlbumArt();
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

    public static MediaSource getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MediaSource parseDelimitedFrom(InputStream inputStream) {
        return (MediaSource) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MediaSource parseFrom(ByteBuffer byteBuffer) {
        return (MediaSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MediaSource> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlbumArt(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 4;
        this.albumArt_ = byteString;
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
                return new MediaSource();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0002\u0001Ԉ\u0000\u0002Ԉ\u0001\u0003\n\u0002", new Object[]{"bitField0_", "path_", "name_", "albumArt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MediaSource> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MediaSource.class) {
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

    @Override // fr.sd.taada.proto.MediaSourceOrBuilder
    public ByteString getAlbumArt() {
        return this.albumArt_;
    }

    @Override // fr.sd.taada.proto.MediaSourceOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // fr.sd.taada.proto.MediaSourceOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // fr.sd.taada.proto.MediaSourceOrBuilder
    public String getPath() {
        return this.path_;
    }

    @Override // fr.sd.taada.proto.MediaSourceOrBuilder
    public ByteString getPathBytes() {
        return ByteString.copyFromUtf8(this.path_);
    }

    @Override // fr.sd.taada.proto.MediaSourceOrBuilder
    public boolean hasAlbumArt() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.MediaSourceOrBuilder
    public boolean hasName() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.MediaSourceOrBuilder
    public boolean hasPath() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(MediaSource mediaSource) {
        return DEFAULT_INSTANCE.createBuilder(mediaSource);
    }

    public static MediaSource parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSource) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MediaSource parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MediaSource parseFrom(ByteString byteString) {
        return (MediaSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MediaSource parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MediaSource parseFrom(byte[] bArr) {
        return (MediaSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MediaSource parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MediaSource parseFrom(InputStream inputStream) {
        return (MediaSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MediaSource parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MediaSource parseFrom(CodedInputStream codedInputStream) {
        return (MediaSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MediaSource parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
