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
public final class InstrumentClusterInput extends GeneratedMessageLite<InstrumentClusterInput, Builder> implements InstrumentClusterInputOrBuilder {
    public static final int ACTION_FIELD_NUMBER = 1;
    private static final InstrumentClusterInput DEFAULT_INSTANCE;
    private static volatile Parser<InstrumentClusterInput> PARSER;
    private int action_;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;

    /* JADX INFO: renamed from: fr.sd.taada.proto.InstrumentClusterInput$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<InstrumentClusterInput, Builder> implements InstrumentClusterInputOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAction() {
            copyOnWrite();
            ((InstrumentClusterInput) this.instance).clearAction();
            return this;
        }

        @Override // fr.sd.taada.proto.InstrumentClusterInputOrBuilder
        public InstrumentClusterAction getAction() {
            return ((InstrumentClusterInput) this.instance).getAction();
        }

        @Override // fr.sd.taada.proto.InstrumentClusterInputOrBuilder
        public boolean hasAction() {
            return ((InstrumentClusterInput) this.instance).hasAction();
        }

        public Builder setAction(InstrumentClusterAction instrumentClusterAction) {
            copyOnWrite();
            ((InstrumentClusterInput) this.instance).setAction(instrumentClusterAction);
            return this;
        }

        private Builder() {
            super(InstrumentClusterInput.DEFAULT_INSTANCE);
        }
    }

    public enum InstrumentClusterAction implements Internal.EnumLite {
        UNKNOWN(0),
        UP(1),
        DOWN(2),
        LEFT(3),
        RIGHT(4),
        ENTER(5),
        BACK(6),
        CALL(7);

        public static final int BACK_VALUE = 6;
        public static final int CALL_VALUE = 7;
        public static final int DOWN_VALUE = 2;
        public static final int ENTER_VALUE = 5;
        public static final int LEFT_VALUE = 3;
        public static final int RIGHT_VALUE = 4;
        public static final int UNKNOWN_VALUE = 0;
        public static final int UP_VALUE = 1;
        private static final Internal.EnumLiteMap<InstrumentClusterAction> internalValueMap = new Internal.EnumLiteMap<InstrumentClusterAction>() { // from class: fr.sd.taada.proto.InstrumentClusterInput.InstrumentClusterAction.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public InstrumentClusterAction findValueByNumber(int i) {
                return InstrumentClusterAction.forNumber(i);
            }
        };
        private final int value;

        public static final class InstrumentClusterActionVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new InstrumentClusterActionVerifier();

            private InstrumentClusterActionVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return InstrumentClusterAction.forNumber(i) != null;
            }
        }

        InstrumentClusterAction(int i) {
            this.value = i;
        }

        public static InstrumentClusterAction forNumber(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN;
                case 1:
                    return UP;
                case 2:
                    return DOWN;
                case 3:
                    return LEFT;
                case 4:
                    return RIGHT;
                case 5:
                    return ENTER;
                case 6:
                    return BACK;
                case 7:
                    return CALL;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<InstrumentClusterAction> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return InstrumentClusterActionVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static InstrumentClusterAction valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        InstrumentClusterInput instrumentClusterInput = new InstrumentClusterInput();
        DEFAULT_INSTANCE = instrumentClusterInput;
        GeneratedMessageLite.registerDefaultInstance(InstrumentClusterInput.class, instrumentClusterInput);
    }

    private InstrumentClusterInput() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAction() {
        this.bitField0_ &= -2;
        this.action_ = 0;
    }

    public static InstrumentClusterInput getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static InstrumentClusterInput parseDelimitedFrom(InputStream inputStream) {
        return (InstrumentClusterInput) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static InstrumentClusterInput parseFrom(ByteBuffer byteBuffer) {
        return (InstrumentClusterInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<InstrumentClusterInput> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAction(InstrumentClusterAction instrumentClusterAction) {
        instrumentClusterAction.getClass();
        this.bitField0_ |= 1;
        this.action_ = instrumentClusterAction.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new InstrumentClusterInput();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001Ԍ\u0000", new Object[]{"bitField0_", "action_", InstrumentClusterAction.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<InstrumentClusterInput> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (InstrumentClusterInput.class) {
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

    @Override // fr.sd.taada.proto.InstrumentClusterInputOrBuilder
    public InstrumentClusterAction getAction() {
        InstrumentClusterAction instrumentClusterActionForNumber = InstrumentClusterAction.forNumber(this.action_);
        return instrumentClusterActionForNumber == null ? InstrumentClusterAction.UNKNOWN : instrumentClusterActionForNumber;
    }

    @Override // fr.sd.taada.proto.InstrumentClusterInputOrBuilder
    public boolean hasAction() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(InstrumentClusterInput instrumentClusterInput) {
        return DEFAULT_INSTANCE.createBuilder(instrumentClusterInput);
    }

    public static InstrumentClusterInput parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (InstrumentClusterInput) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static InstrumentClusterInput parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (InstrumentClusterInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static InstrumentClusterInput parseFrom(ByteString byteString) {
        return (InstrumentClusterInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static InstrumentClusterInput parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (InstrumentClusterInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static InstrumentClusterInput parseFrom(byte[] bArr) {
        return (InstrumentClusterInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static InstrumentClusterInput parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (InstrumentClusterInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static InstrumentClusterInput parseFrom(InputStream inputStream) {
        return (InstrumentClusterInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static InstrumentClusterInput parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (InstrumentClusterInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static InstrumentClusterInput parseFrom(CodedInputStream codedInputStream) {
        return (InstrumentClusterInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static InstrumentClusterInput parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (InstrumentClusterInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
