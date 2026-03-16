package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.InstrumentClusterInput;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class MediaBrowserInput extends GeneratedMessageLite<MediaBrowserInput, Builder> implements MediaBrowserInputOrBuilder {
    private static final MediaBrowserInput DEFAULT_INSTANCE;
    public static final int INPUT_FIELD_NUMBER = 1;
    private static volatile Parser<MediaBrowserInput> PARSER = null;
    public static final int PATH_FIELD_NUMBER = 2;
    private int bitField0_;
    private InstrumentClusterInput input_;
    private byte memoizedIsInitialized = 2;
    private String path_ = "";

    /* JADX INFO: renamed from: fr.sd.taada.proto.MediaBrowserInput$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<MediaBrowserInput, Builder> implements MediaBrowserInputOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearInput() {
            copyOnWrite();
            ((MediaBrowserInput) this.instance).clearInput();
            return this;
        }

        public Builder clearPath() {
            copyOnWrite();
            ((MediaBrowserInput) this.instance).clearPath();
            return this;
        }

        @Override // fr.sd.taada.proto.MediaBrowserInputOrBuilder
        public InstrumentClusterInput getInput() {
            return ((MediaBrowserInput) this.instance).getInput();
        }

        @Override // fr.sd.taada.proto.MediaBrowserInputOrBuilder
        public String getPath() {
            return ((MediaBrowserInput) this.instance).getPath();
        }

        @Override // fr.sd.taada.proto.MediaBrowserInputOrBuilder
        public ByteString getPathBytes() {
            return ((MediaBrowserInput) this.instance).getPathBytes();
        }

        @Override // fr.sd.taada.proto.MediaBrowserInputOrBuilder
        public boolean hasInput() {
            return ((MediaBrowserInput) this.instance).hasInput();
        }

        @Override // fr.sd.taada.proto.MediaBrowserInputOrBuilder
        public boolean hasPath() {
            return ((MediaBrowserInput) this.instance).hasPath();
        }

        public Builder mergeInput(InstrumentClusterInput instrumentClusterInput) {
            copyOnWrite();
            ((MediaBrowserInput) this.instance).mergeInput(instrumentClusterInput);
            return this;
        }

        public Builder setInput(InstrumentClusterInput instrumentClusterInput) {
            copyOnWrite();
            ((MediaBrowserInput) this.instance).setInput(instrumentClusterInput);
            return this;
        }

        public Builder setPath(String str) {
            copyOnWrite();
            ((MediaBrowserInput) this.instance).setPath(str);
            return this;
        }

        public Builder setPathBytes(ByteString byteString) {
            copyOnWrite();
            ((MediaBrowserInput) this.instance).setPathBytes(byteString);
            return this;
        }

        private Builder() {
            super(MediaBrowserInput.DEFAULT_INSTANCE);
        }

        public Builder setInput(InstrumentClusterInput.Builder builder) {
            copyOnWrite();
            ((MediaBrowserInput) this.instance).setInput(builder);
            return this;
        }
    }

    static {
        MediaBrowserInput mediaBrowserInput = new MediaBrowserInput();
        DEFAULT_INSTANCE = mediaBrowserInput;
        GeneratedMessageLite.registerDefaultInstance(MediaBrowserInput.class, mediaBrowserInput);
    }

    private MediaBrowserInput() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInput() {
        this.input_ = null;
        this.bitField0_ &= -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPath() {
        this.bitField0_ &= -3;
        this.path_ = getDefaultInstance().getPath();
    }

    public static MediaBrowserInput getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeInput(InstrumentClusterInput instrumentClusterInput) {
        instrumentClusterInput.getClass();
        InstrumentClusterInput instrumentClusterInput2 = this.input_;
        if (instrumentClusterInput2 == null || instrumentClusterInput2 == InstrumentClusterInput.getDefaultInstance()) {
            this.input_ = instrumentClusterInput;
        } else {
            this.input_ = InstrumentClusterInput.newBuilder(this.input_).mergeFrom(instrumentClusterInput).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MediaBrowserInput parseDelimitedFrom(InputStream inputStream) {
        return (MediaBrowserInput) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MediaBrowserInput parseFrom(ByteBuffer byteBuffer) {
        return (MediaBrowserInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MediaBrowserInput> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInput(InstrumentClusterInput instrumentClusterInput) {
        instrumentClusterInput.getClass();
        this.input_ = instrumentClusterInput;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPath(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.path_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPathBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 2;
        this.path_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new MediaBrowserInput();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ԉ\u0000\u0002Ԉ\u0001", new Object[]{"bitField0_", "input_", "path_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MediaBrowserInput> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MediaBrowserInput.class) {
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

    @Override // fr.sd.taada.proto.MediaBrowserInputOrBuilder
    public InstrumentClusterInput getInput() {
        InstrumentClusterInput instrumentClusterInput = this.input_;
        return instrumentClusterInput == null ? InstrumentClusterInput.getDefaultInstance() : instrumentClusterInput;
    }

    @Override // fr.sd.taada.proto.MediaBrowserInputOrBuilder
    public String getPath() {
        return this.path_;
    }

    @Override // fr.sd.taada.proto.MediaBrowserInputOrBuilder
    public ByteString getPathBytes() {
        return ByteString.copyFromUtf8(this.path_);
    }

    @Override // fr.sd.taada.proto.MediaBrowserInputOrBuilder
    public boolean hasInput() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.MediaBrowserInputOrBuilder
    public boolean hasPath() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(MediaBrowserInput mediaBrowserInput) {
        return DEFAULT_INSTANCE.createBuilder(mediaBrowserInput);
    }

    public static MediaBrowserInput parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaBrowserInput) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MediaBrowserInput parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaBrowserInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MediaBrowserInput parseFrom(ByteString byteString) {
        return (MediaBrowserInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MediaBrowserInput parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaBrowserInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInput(InstrumentClusterInput.Builder builder) {
        this.input_ = builder.build();
        this.bitField0_ |= 1;
    }

    public static MediaBrowserInput parseFrom(byte[] bArr) {
        return (MediaBrowserInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MediaBrowserInput parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaBrowserInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MediaBrowserInput parseFrom(InputStream inputStream) {
        return (MediaBrowserInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MediaBrowserInput parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaBrowserInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MediaBrowserInput parseFrom(CodedInputStream codedInputStream) {
        return (MediaBrowserInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MediaBrowserInput parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaBrowserInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
