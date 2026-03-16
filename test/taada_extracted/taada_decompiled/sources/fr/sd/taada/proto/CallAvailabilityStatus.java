package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class CallAvailabilityStatus extends GeneratedMessageLite<CallAvailabilityStatus, Builder> implements CallAvailabilityStatusOrBuilder {
    public static final int CALL_AVAILABLE_FIELD_NUMBER = 1;
    private static final CallAvailabilityStatus DEFAULT_INSTANCE;
    private static volatile Parser<CallAvailabilityStatus> PARSER;
    private int bitField0_;
    private boolean callAvailable_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.CallAvailabilityStatus$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<CallAvailabilityStatus, Builder> implements CallAvailabilityStatusOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCallAvailable() {
            copyOnWrite();
            ((CallAvailabilityStatus) this.instance).clearCallAvailable();
            return this;
        }

        @Override // fr.sd.taada.proto.CallAvailabilityStatusOrBuilder
        public boolean getCallAvailable() {
            return ((CallAvailabilityStatus) this.instance).getCallAvailable();
        }

        @Override // fr.sd.taada.proto.CallAvailabilityStatusOrBuilder
        public boolean hasCallAvailable() {
            return ((CallAvailabilityStatus) this.instance).hasCallAvailable();
        }

        public Builder setCallAvailable(boolean z6) {
            copyOnWrite();
            ((CallAvailabilityStatus) this.instance).setCallAvailable(z6);
            return this;
        }

        private Builder() {
            super(CallAvailabilityStatus.DEFAULT_INSTANCE);
        }
    }

    static {
        CallAvailabilityStatus callAvailabilityStatus = new CallAvailabilityStatus();
        DEFAULT_INSTANCE = callAvailabilityStatus;
        GeneratedMessageLite.registerDefaultInstance(CallAvailabilityStatus.class, callAvailabilityStatus);
    }

    private CallAvailabilityStatus() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCallAvailable() {
        this.bitField0_ &= -2;
        this.callAvailable_ = false;
    }

    public static CallAvailabilityStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static CallAvailabilityStatus parseDelimitedFrom(InputStream inputStream) {
        return (CallAvailabilityStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CallAvailabilityStatus parseFrom(ByteBuffer byteBuffer) {
        return (CallAvailabilityStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<CallAvailabilityStatus> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallAvailable(boolean z6) {
        this.bitField0_ |= 1;
        this.callAvailable_ = z6;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new CallAvailabilityStatus();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007\u0000", new Object[]{"bitField0_", "callAvailable_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CallAvailabilityStatus> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (CallAvailabilityStatus.class) {
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

    @Override // fr.sd.taada.proto.CallAvailabilityStatusOrBuilder
    public boolean getCallAvailable() {
        return this.callAvailable_;
    }

    @Override // fr.sd.taada.proto.CallAvailabilityStatusOrBuilder
    public boolean hasCallAvailable() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(CallAvailabilityStatus callAvailabilityStatus) {
        return DEFAULT_INSTANCE.createBuilder(callAvailabilityStatus);
    }

    public static CallAvailabilityStatus parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CallAvailabilityStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CallAvailabilityStatus parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (CallAvailabilityStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CallAvailabilityStatus parseFrom(ByteString byteString) {
        return (CallAvailabilityStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static CallAvailabilityStatus parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (CallAvailabilityStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CallAvailabilityStatus parseFrom(byte[] bArr) {
        return (CallAvailabilityStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CallAvailabilityStatus parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (CallAvailabilityStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static CallAvailabilityStatus parseFrom(InputStream inputStream) {
        return (CallAvailabilityStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CallAvailabilityStatus parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CallAvailabilityStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CallAvailabilityStatus parseFrom(CodedInputStream codedInputStream) {
        return (CallAvailabilityStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CallAvailabilityStatus parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CallAvailabilityStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
