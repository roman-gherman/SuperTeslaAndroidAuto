package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class MediaGetNode extends GeneratedMessageLite<MediaGetNode, Builder> implements MediaGetNodeOrBuilder {
    private static final MediaGetNode DEFAULT_INSTANCE;
    public static final int GET_ALBUM_ART_FIELD_NUMBER = 3;
    private static volatile Parser<MediaGetNode> PARSER = null;
    public static final int PATH_FIELD_NUMBER = 1;
    public static final int START_FIELD_NUMBER = 2;
    private int bitField0_;
    private int start_;
    private byte memoizedIsInitialized = 2;
    private String path_ = "";
    private boolean getAlbumArt_ = true;

    /* JADX INFO: renamed from: fr.sd.taada.proto.MediaGetNode$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<MediaGetNode, Builder> implements MediaGetNodeOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearGetAlbumArt() {
            copyOnWrite();
            ((MediaGetNode) this.instance).clearGetAlbumArt();
            return this;
        }

        public Builder clearPath() {
            copyOnWrite();
            ((MediaGetNode) this.instance).clearPath();
            return this;
        }

        public Builder clearStart() {
            copyOnWrite();
            ((MediaGetNode) this.instance).clearStart();
            return this;
        }

        @Override // fr.sd.taada.proto.MediaGetNodeOrBuilder
        public boolean getGetAlbumArt() {
            return ((MediaGetNode) this.instance).getGetAlbumArt();
        }

        @Override // fr.sd.taada.proto.MediaGetNodeOrBuilder
        public String getPath() {
            return ((MediaGetNode) this.instance).getPath();
        }

        @Override // fr.sd.taada.proto.MediaGetNodeOrBuilder
        public ByteString getPathBytes() {
            return ((MediaGetNode) this.instance).getPathBytes();
        }

        @Override // fr.sd.taada.proto.MediaGetNodeOrBuilder
        public int getStart() {
            return ((MediaGetNode) this.instance).getStart();
        }

        @Override // fr.sd.taada.proto.MediaGetNodeOrBuilder
        public boolean hasGetAlbumArt() {
            return ((MediaGetNode) this.instance).hasGetAlbumArt();
        }

        @Override // fr.sd.taada.proto.MediaGetNodeOrBuilder
        public boolean hasPath() {
            return ((MediaGetNode) this.instance).hasPath();
        }

        @Override // fr.sd.taada.proto.MediaGetNodeOrBuilder
        public boolean hasStart() {
            return ((MediaGetNode) this.instance).hasStart();
        }

        public Builder setGetAlbumArt(boolean z6) {
            copyOnWrite();
            ((MediaGetNode) this.instance).setGetAlbumArt(z6);
            return this;
        }

        public Builder setPath(String str) {
            copyOnWrite();
            ((MediaGetNode) this.instance).setPath(str);
            return this;
        }

        public Builder setPathBytes(ByteString byteString) {
            copyOnWrite();
            ((MediaGetNode) this.instance).setPathBytes(byteString);
            return this;
        }

        public Builder setStart(int i) {
            copyOnWrite();
            ((MediaGetNode) this.instance).setStart(i);
            return this;
        }

        private Builder() {
            super(MediaGetNode.DEFAULT_INSTANCE);
        }
    }

    static {
        MediaGetNode mediaGetNode = new MediaGetNode();
        DEFAULT_INSTANCE = mediaGetNode;
        GeneratedMessageLite.registerDefaultInstance(MediaGetNode.class, mediaGetNode);
    }

    private MediaGetNode() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGetAlbumArt() {
        this.bitField0_ &= -5;
        this.getAlbumArt_ = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPath() {
        this.bitField0_ &= -2;
        this.path_ = getDefaultInstance().getPath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStart() {
        this.bitField0_ &= -3;
        this.start_ = 0;
    }

    public static MediaGetNode getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MediaGetNode parseDelimitedFrom(InputStream inputStream) {
        return (MediaGetNode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MediaGetNode parseFrom(ByteBuffer byteBuffer) {
        return (MediaGetNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MediaGetNode> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGetAlbumArt(boolean z6) {
        this.bitField0_ |= 4;
        this.getAlbumArt_ = z6;
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
    public void setStart(int i) {
        this.bitField0_ |= 2;
        this.start_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new MediaGetNode();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\u0004\u0001\u0003\u0007\u0002", new Object[]{"bitField0_", "path_", "start_", "getAlbumArt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MediaGetNode> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MediaGetNode.class) {
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

    @Override // fr.sd.taada.proto.MediaGetNodeOrBuilder
    public boolean getGetAlbumArt() {
        return this.getAlbumArt_;
    }

    @Override // fr.sd.taada.proto.MediaGetNodeOrBuilder
    public String getPath() {
        return this.path_;
    }

    @Override // fr.sd.taada.proto.MediaGetNodeOrBuilder
    public ByteString getPathBytes() {
        return ByteString.copyFromUtf8(this.path_);
    }

    @Override // fr.sd.taada.proto.MediaGetNodeOrBuilder
    public int getStart() {
        return this.start_;
    }

    @Override // fr.sd.taada.proto.MediaGetNodeOrBuilder
    public boolean hasGetAlbumArt() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.MediaGetNodeOrBuilder
    public boolean hasPath() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.MediaGetNodeOrBuilder
    public boolean hasStart() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(MediaGetNode mediaGetNode) {
        return DEFAULT_INSTANCE.createBuilder(mediaGetNode);
    }

    public static MediaGetNode parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaGetNode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MediaGetNode parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaGetNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MediaGetNode parseFrom(ByteString byteString) {
        return (MediaGetNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MediaGetNode parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaGetNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MediaGetNode parseFrom(byte[] bArr) {
        return (MediaGetNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MediaGetNode parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaGetNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MediaGetNode parseFrom(InputStream inputStream) {
        return (MediaGetNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MediaGetNode parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaGetNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MediaGetNode parseFrom(CodedInputStream codedInputStream) {
        return (MediaGetNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MediaGetNode parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaGetNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
