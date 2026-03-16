package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class MicrophoneRequest extends GeneratedMessageLite<MicrophoneRequest, Builder> implements MicrophoneRequestOrBuilder {
    public static final int ANC_ENABLED_FIELD_NUMBER = 2;
    private static final MicrophoneRequest DEFAULT_INSTANCE;
    public static final int EC_ENABLED_FIELD_NUMBER = 3;
    public static final int MAX_UNACKED_FIELD_NUMBER = 4;
    public static final int OPEN_FIELD_NUMBER = 1;
    private static volatile Parser<MicrophoneRequest> PARSER;
    private boolean ancEnabled_;
    private int bitField0_;
    private boolean ecEnabled_;
    private int maxUnacked_;
    private byte memoizedIsInitialized = 2;
    private boolean open_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.MicrophoneRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<MicrophoneRequest, Builder> implements MicrophoneRequestOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAncEnabled() {
            copyOnWrite();
            ((MicrophoneRequest) this.instance).clearAncEnabled();
            return this;
        }

        public Builder clearEcEnabled() {
            copyOnWrite();
            ((MicrophoneRequest) this.instance).clearEcEnabled();
            return this;
        }

        public Builder clearMaxUnacked() {
            copyOnWrite();
            ((MicrophoneRequest) this.instance).clearMaxUnacked();
            return this;
        }

        public Builder clearOpen() {
            copyOnWrite();
            ((MicrophoneRequest) this.instance).clearOpen();
            return this;
        }

        @Override // fr.sd.taada.proto.MicrophoneRequestOrBuilder
        public boolean getAncEnabled() {
            return ((MicrophoneRequest) this.instance).getAncEnabled();
        }

        @Override // fr.sd.taada.proto.MicrophoneRequestOrBuilder
        public boolean getEcEnabled() {
            return ((MicrophoneRequest) this.instance).getEcEnabled();
        }

        @Override // fr.sd.taada.proto.MicrophoneRequestOrBuilder
        public int getMaxUnacked() {
            return ((MicrophoneRequest) this.instance).getMaxUnacked();
        }

        @Override // fr.sd.taada.proto.MicrophoneRequestOrBuilder
        public boolean getOpen() {
            return ((MicrophoneRequest) this.instance).getOpen();
        }

        @Override // fr.sd.taada.proto.MicrophoneRequestOrBuilder
        public boolean hasAncEnabled() {
            return ((MicrophoneRequest) this.instance).hasAncEnabled();
        }

        @Override // fr.sd.taada.proto.MicrophoneRequestOrBuilder
        public boolean hasEcEnabled() {
            return ((MicrophoneRequest) this.instance).hasEcEnabled();
        }

        @Override // fr.sd.taada.proto.MicrophoneRequestOrBuilder
        public boolean hasMaxUnacked() {
            return ((MicrophoneRequest) this.instance).hasMaxUnacked();
        }

        @Override // fr.sd.taada.proto.MicrophoneRequestOrBuilder
        public boolean hasOpen() {
            return ((MicrophoneRequest) this.instance).hasOpen();
        }

        public Builder setAncEnabled(boolean z6) {
            copyOnWrite();
            ((MicrophoneRequest) this.instance).setAncEnabled(z6);
            return this;
        }

        public Builder setEcEnabled(boolean z6) {
            copyOnWrite();
            ((MicrophoneRequest) this.instance).setEcEnabled(z6);
            return this;
        }

        public Builder setMaxUnacked(int i) {
            copyOnWrite();
            ((MicrophoneRequest) this.instance).setMaxUnacked(i);
            return this;
        }

        public Builder setOpen(boolean z6) {
            copyOnWrite();
            ((MicrophoneRequest) this.instance).setOpen(z6);
            return this;
        }

        private Builder() {
            super(MicrophoneRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        MicrophoneRequest microphoneRequest = new MicrophoneRequest();
        DEFAULT_INSTANCE = microphoneRequest;
        GeneratedMessageLite.registerDefaultInstance(MicrophoneRequest.class, microphoneRequest);
    }

    private MicrophoneRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAncEnabled() {
        this.bitField0_ &= -3;
        this.ancEnabled_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEcEnabled() {
        this.bitField0_ &= -5;
        this.ecEnabled_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMaxUnacked() {
        this.bitField0_ &= -9;
        this.maxUnacked_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOpen() {
        this.bitField0_ &= -2;
        this.open_ = false;
    }

    public static MicrophoneRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MicrophoneRequest parseDelimitedFrom(InputStream inputStream) {
        return (MicrophoneRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MicrophoneRequest parseFrom(ByteBuffer byteBuffer) {
        return (MicrophoneRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MicrophoneRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAncEnabled(boolean z6) {
        this.bitField0_ |= 2;
        this.ancEnabled_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEcEnabled(boolean z6) {
        this.bitField0_ |= 4;
        this.ecEnabled_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaxUnacked(int i) {
        this.bitField0_ |= 8;
        this.maxUnacked_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOpen(boolean z6) {
        this.bitField0_ |= 1;
        this.open_ = z6;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new MicrophoneRequest();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001ԇ\u0000\u0002\u0007\u0001\u0003\u0007\u0002\u0004\u0004\u0003", new Object[]{"bitField0_", "open_", "ancEnabled_", "ecEnabled_", "maxUnacked_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MicrophoneRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MicrophoneRequest.class) {
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

    @Override // fr.sd.taada.proto.MicrophoneRequestOrBuilder
    public boolean getAncEnabled() {
        return this.ancEnabled_;
    }

    @Override // fr.sd.taada.proto.MicrophoneRequestOrBuilder
    public boolean getEcEnabled() {
        return this.ecEnabled_;
    }

    @Override // fr.sd.taada.proto.MicrophoneRequestOrBuilder
    public int getMaxUnacked() {
        return this.maxUnacked_;
    }

    @Override // fr.sd.taada.proto.MicrophoneRequestOrBuilder
    public boolean getOpen() {
        return this.open_;
    }

    @Override // fr.sd.taada.proto.MicrophoneRequestOrBuilder
    public boolean hasAncEnabled() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.MicrophoneRequestOrBuilder
    public boolean hasEcEnabled() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.MicrophoneRequestOrBuilder
    public boolean hasMaxUnacked() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // fr.sd.taada.proto.MicrophoneRequestOrBuilder
    public boolean hasOpen() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(MicrophoneRequest microphoneRequest) {
        return DEFAULT_INSTANCE.createBuilder(microphoneRequest);
    }

    public static MicrophoneRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MicrophoneRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MicrophoneRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MicrophoneRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MicrophoneRequest parseFrom(ByteString byteString) {
        return (MicrophoneRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MicrophoneRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MicrophoneRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MicrophoneRequest parseFrom(byte[] bArr) {
        return (MicrophoneRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MicrophoneRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MicrophoneRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MicrophoneRequest parseFrom(InputStream inputStream) {
        return (MicrophoneRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MicrophoneRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MicrophoneRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MicrophoneRequest parseFrom(CodedInputStream codedInputStream) {
        return (MicrophoneRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MicrophoneRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MicrophoneRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
