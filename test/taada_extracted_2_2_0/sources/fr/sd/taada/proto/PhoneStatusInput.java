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
public final class PhoneStatusInput extends GeneratedMessageLite<PhoneStatusInput, Builder> implements PhoneStatusInputOrBuilder {
    public static final int CALLER_ID_FIELD_NUMBER = 3;
    public static final int CALLER_NUMBER_FIELD_NUMBER = 2;
    private static final PhoneStatusInput DEFAULT_INSTANCE;
    public static final int INPUT_FIELD_NUMBER = 1;
    private static volatile Parser<PhoneStatusInput> PARSER;
    private int bitField0_;
    private InstrumentClusterInput input_;
    private byte memoizedIsInitialized = 2;
    private String callerNumber_ = "";
    private String callerId_ = "";

    /* JADX INFO: renamed from: fr.sd.taada.proto.PhoneStatusInput$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<PhoneStatusInput, Builder> implements PhoneStatusInputOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCallerId() {
            copyOnWrite();
            ((PhoneStatusInput) this.instance).clearCallerId();
            return this;
        }

        public Builder clearCallerNumber() {
            copyOnWrite();
            ((PhoneStatusInput) this.instance).clearCallerNumber();
            return this;
        }

        public Builder clearInput() {
            copyOnWrite();
            ((PhoneStatusInput) this.instance).clearInput();
            return this;
        }

        @Override // fr.sd.taada.proto.PhoneStatusInputOrBuilder
        public String getCallerId() {
            return ((PhoneStatusInput) this.instance).getCallerId();
        }

        @Override // fr.sd.taada.proto.PhoneStatusInputOrBuilder
        public ByteString getCallerIdBytes() {
            return ((PhoneStatusInput) this.instance).getCallerIdBytes();
        }

        @Override // fr.sd.taada.proto.PhoneStatusInputOrBuilder
        public String getCallerNumber() {
            return ((PhoneStatusInput) this.instance).getCallerNumber();
        }

        @Override // fr.sd.taada.proto.PhoneStatusInputOrBuilder
        public ByteString getCallerNumberBytes() {
            return ((PhoneStatusInput) this.instance).getCallerNumberBytes();
        }

        @Override // fr.sd.taada.proto.PhoneStatusInputOrBuilder
        public InstrumentClusterInput getInput() {
            return ((PhoneStatusInput) this.instance).getInput();
        }

        @Override // fr.sd.taada.proto.PhoneStatusInputOrBuilder
        public boolean hasCallerId() {
            return ((PhoneStatusInput) this.instance).hasCallerId();
        }

        @Override // fr.sd.taada.proto.PhoneStatusInputOrBuilder
        public boolean hasCallerNumber() {
            return ((PhoneStatusInput) this.instance).hasCallerNumber();
        }

        @Override // fr.sd.taada.proto.PhoneStatusInputOrBuilder
        public boolean hasInput() {
            return ((PhoneStatusInput) this.instance).hasInput();
        }

        public Builder mergeInput(InstrumentClusterInput instrumentClusterInput) {
            copyOnWrite();
            ((PhoneStatusInput) this.instance).mergeInput(instrumentClusterInput);
            return this;
        }

        public Builder setCallerId(String str) {
            copyOnWrite();
            ((PhoneStatusInput) this.instance).setCallerId(str);
            return this;
        }

        public Builder setCallerIdBytes(ByteString byteString) {
            copyOnWrite();
            ((PhoneStatusInput) this.instance).setCallerIdBytes(byteString);
            return this;
        }

        public Builder setCallerNumber(String str) {
            copyOnWrite();
            ((PhoneStatusInput) this.instance).setCallerNumber(str);
            return this;
        }

        public Builder setCallerNumberBytes(ByteString byteString) {
            copyOnWrite();
            ((PhoneStatusInput) this.instance).setCallerNumberBytes(byteString);
            return this;
        }

        public Builder setInput(InstrumentClusterInput instrumentClusterInput) {
            copyOnWrite();
            ((PhoneStatusInput) this.instance).setInput(instrumentClusterInput);
            return this;
        }

        private Builder() {
            super(PhoneStatusInput.DEFAULT_INSTANCE);
        }

        public Builder setInput(InstrumentClusterInput.Builder builder) {
            copyOnWrite();
            ((PhoneStatusInput) this.instance).setInput(builder);
            return this;
        }
    }

    static {
        PhoneStatusInput phoneStatusInput = new PhoneStatusInput();
        DEFAULT_INSTANCE = phoneStatusInput;
        GeneratedMessageLite.registerDefaultInstance(PhoneStatusInput.class, phoneStatusInput);
    }

    private PhoneStatusInput() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCallerId() {
        this.bitField0_ &= -5;
        this.callerId_ = getDefaultInstance().getCallerId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCallerNumber() {
        this.bitField0_ &= -3;
        this.callerNumber_ = getDefaultInstance().getCallerNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInput() {
        this.input_ = null;
        this.bitField0_ &= -2;
    }

    public static PhoneStatusInput getDefaultInstance() {
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

    public static PhoneStatusInput parseDelimitedFrom(InputStream inputStream) {
        return (PhoneStatusInput) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PhoneStatusInput parseFrom(ByteBuffer byteBuffer) {
        return (PhoneStatusInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PhoneStatusInput> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallerId(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.callerId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallerIdBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 4;
        this.callerId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallerNumber(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.callerNumber_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallerNumberBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 2;
        this.callerNumber_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInput(InstrumentClusterInput instrumentClusterInput) {
        instrumentClusterInput.getClass();
        this.input_ = instrumentClusterInput;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new PhoneStatusInput();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ԉ\u0000\u0002\b\u0001\u0003\b\u0002", new Object[]{"bitField0_", "input_", "callerNumber_", "callerId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PhoneStatusInput> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PhoneStatusInput.class) {
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

    @Override // fr.sd.taada.proto.PhoneStatusInputOrBuilder
    public String getCallerId() {
        return this.callerId_;
    }

    @Override // fr.sd.taada.proto.PhoneStatusInputOrBuilder
    public ByteString getCallerIdBytes() {
        return ByteString.copyFromUtf8(this.callerId_);
    }

    @Override // fr.sd.taada.proto.PhoneStatusInputOrBuilder
    public String getCallerNumber() {
        return this.callerNumber_;
    }

    @Override // fr.sd.taada.proto.PhoneStatusInputOrBuilder
    public ByteString getCallerNumberBytes() {
        return ByteString.copyFromUtf8(this.callerNumber_);
    }

    @Override // fr.sd.taada.proto.PhoneStatusInputOrBuilder
    public InstrumentClusterInput getInput() {
        InstrumentClusterInput instrumentClusterInput = this.input_;
        return instrumentClusterInput == null ? InstrumentClusterInput.getDefaultInstance() : instrumentClusterInput;
    }

    @Override // fr.sd.taada.proto.PhoneStatusInputOrBuilder
    public boolean hasCallerId() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.PhoneStatusInputOrBuilder
    public boolean hasCallerNumber() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.PhoneStatusInputOrBuilder
    public boolean hasInput() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(PhoneStatusInput phoneStatusInput) {
        return DEFAULT_INSTANCE.createBuilder(phoneStatusInput);
    }

    public static PhoneStatusInput parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PhoneStatusInput) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PhoneStatusInput parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PhoneStatusInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PhoneStatusInput parseFrom(ByteString byteString) {
        return (PhoneStatusInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PhoneStatusInput parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PhoneStatusInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInput(InstrumentClusterInput.Builder builder) {
        this.input_ = builder.build();
        this.bitField0_ |= 1;
    }

    public static PhoneStatusInput parseFrom(byte[] bArr) {
        return (PhoneStatusInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PhoneStatusInput parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PhoneStatusInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PhoneStatusInput parseFrom(InputStream inputStream) {
        return (PhoneStatusInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PhoneStatusInput parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PhoneStatusInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PhoneStatusInput parseFrom(CodedInputStream codedInputStream) {
        return (PhoneStatusInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PhoneStatusInput parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PhoneStatusInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
