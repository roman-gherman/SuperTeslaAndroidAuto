package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class MuteRadioRequest extends GeneratedMessageLite<MuteRadioRequest, Builder> implements MuteRadioRequestOrBuilder {
    private static final MuteRadioRequest DEFAULT_INSTANCE;
    public static final int MUTE_FIELD_NUMBER = 2;
    private static volatile Parser<MuteRadioRequest> PARSER = null;
    public static final int RADIO_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private boolean mute_;
    private int radioId_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.MuteRadioRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<MuteRadioRequest, Builder> implements MuteRadioRequestOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearMute() {
            copyOnWrite();
            ((MuteRadioRequest) this.instance).clearMute();
            return this;
        }

        public Builder clearRadioId() {
            copyOnWrite();
            ((MuteRadioRequest) this.instance).clearRadioId();
            return this;
        }

        @Override // fr.sd.taada.proto.MuteRadioRequestOrBuilder
        public boolean getMute() {
            return ((MuteRadioRequest) this.instance).getMute();
        }

        @Override // fr.sd.taada.proto.MuteRadioRequestOrBuilder
        public int getRadioId() {
            return ((MuteRadioRequest) this.instance).getRadioId();
        }

        @Override // fr.sd.taada.proto.MuteRadioRequestOrBuilder
        public boolean hasMute() {
            return ((MuteRadioRequest) this.instance).hasMute();
        }

        @Override // fr.sd.taada.proto.MuteRadioRequestOrBuilder
        public boolean hasRadioId() {
            return ((MuteRadioRequest) this.instance).hasRadioId();
        }

        public Builder setMute(boolean z6) {
            copyOnWrite();
            ((MuteRadioRequest) this.instance).setMute(z6);
            return this;
        }

        public Builder setRadioId(int i) {
            copyOnWrite();
            ((MuteRadioRequest) this.instance).setRadioId(i);
            return this;
        }

        private Builder() {
            super(MuteRadioRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        MuteRadioRequest muteRadioRequest = new MuteRadioRequest();
        DEFAULT_INSTANCE = muteRadioRequest;
        GeneratedMessageLite.registerDefaultInstance(MuteRadioRequest.class, muteRadioRequest);
    }

    private MuteRadioRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMute() {
        this.bitField0_ &= -3;
        this.mute_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRadioId() {
        this.bitField0_ &= -2;
        this.radioId_ = 0;
    }

    public static MuteRadioRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MuteRadioRequest parseDelimitedFrom(InputStream inputStream) {
        return (MuteRadioRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MuteRadioRequest parseFrom(ByteBuffer byteBuffer) {
        return (MuteRadioRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MuteRadioRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMute(boolean z6) {
        this.bitField0_ |= 2;
        this.mute_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRadioId(int i) {
        this.bitField0_ |= 1;
        this.radioId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new MuteRadioRequest();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001\u0004\u0000\u0002ԇ\u0001", new Object[]{"bitField0_", "radioId_", "mute_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MuteRadioRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MuteRadioRequest.class) {
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

    @Override // fr.sd.taada.proto.MuteRadioRequestOrBuilder
    public boolean getMute() {
        return this.mute_;
    }

    @Override // fr.sd.taada.proto.MuteRadioRequestOrBuilder
    public int getRadioId() {
        return this.radioId_;
    }

    @Override // fr.sd.taada.proto.MuteRadioRequestOrBuilder
    public boolean hasMute() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.MuteRadioRequestOrBuilder
    public boolean hasRadioId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(MuteRadioRequest muteRadioRequest) {
        return DEFAULT_INSTANCE.createBuilder(muteRadioRequest);
    }

    public static MuteRadioRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MuteRadioRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MuteRadioRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MuteRadioRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MuteRadioRequest parseFrom(ByteString byteString) {
        return (MuteRadioRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MuteRadioRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MuteRadioRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MuteRadioRequest parseFrom(byte[] bArr) {
        return (MuteRadioRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MuteRadioRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MuteRadioRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MuteRadioRequest parseFrom(InputStream inputStream) {
        return (MuteRadioRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MuteRadioRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MuteRadioRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MuteRadioRequest parseFrom(CodedInputStream codedInputStream) {
        return (MuteRadioRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MuteRadioRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MuteRadioRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
