package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class BluetoothAuthenticationResult extends GeneratedMessageLite<BluetoothAuthenticationResult, Builder> implements BluetoothAuthenticationResultOrBuilder {
    private static final BluetoothAuthenticationResult DEFAULT_INSTANCE;
    private static volatile Parser<BluetoothAuthenticationResult> PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 1;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int status_ = 1;

    /* JADX INFO: renamed from: fr.sd.taada.proto.BluetoothAuthenticationResult$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<BluetoothAuthenticationResult, Builder> implements BluetoothAuthenticationResultOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearStatus() {
            copyOnWrite();
            ((BluetoothAuthenticationResult) this.instance).clearStatus();
            return this;
        }

        @Override // fr.sd.taada.proto.BluetoothAuthenticationResultOrBuilder
        public MessageStatus getStatus() {
            return ((BluetoothAuthenticationResult) this.instance).getStatus();
        }

        @Override // fr.sd.taada.proto.BluetoothAuthenticationResultOrBuilder
        public boolean hasStatus() {
            return ((BluetoothAuthenticationResult) this.instance).hasStatus();
        }

        public Builder setStatus(MessageStatus messageStatus) {
            copyOnWrite();
            ((BluetoothAuthenticationResult) this.instance).setStatus(messageStatus);
            return this;
        }

        private Builder() {
            super(BluetoothAuthenticationResult.DEFAULT_INSTANCE);
        }
    }

    static {
        BluetoothAuthenticationResult bluetoothAuthenticationResult = new BluetoothAuthenticationResult();
        DEFAULT_INSTANCE = bluetoothAuthenticationResult;
        GeneratedMessageLite.registerDefaultInstance(BluetoothAuthenticationResult.class, bluetoothAuthenticationResult);
    }

    private BluetoothAuthenticationResult() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.bitField0_ &= -2;
        this.status_ = 1;
    }

    public static BluetoothAuthenticationResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static BluetoothAuthenticationResult parseDelimitedFrom(InputStream inputStream) {
        return (BluetoothAuthenticationResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BluetoothAuthenticationResult parseFrom(ByteBuffer byteBuffer) {
        return (BluetoothAuthenticationResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<BluetoothAuthenticationResult> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(MessageStatus messageStatus) {
        messageStatus.getClass();
        this.bitField0_ |= 1;
        this.status_ = messageStatus.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new BluetoothAuthenticationResult();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001Ԍ\u0000", new Object[]{"bitField0_", "status_", MessageStatus.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<BluetoothAuthenticationResult> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (BluetoothAuthenticationResult.class) {
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

    @Override // fr.sd.taada.proto.BluetoothAuthenticationResultOrBuilder
    public MessageStatus getStatus() {
        MessageStatus messageStatusForNumber = MessageStatus.forNumber(this.status_);
        return messageStatusForNumber == null ? MessageStatus.STATUS_UNSOLICITED_MESSAGE : messageStatusForNumber;
    }

    @Override // fr.sd.taada.proto.BluetoothAuthenticationResultOrBuilder
    public boolean hasStatus() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(BluetoothAuthenticationResult bluetoothAuthenticationResult) {
        return DEFAULT_INSTANCE.createBuilder(bluetoothAuthenticationResult);
    }

    public static BluetoothAuthenticationResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothAuthenticationResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BluetoothAuthenticationResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothAuthenticationResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static BluetoothAuthenticationResult parseFrom(ByteString byteString) {
        return (BluetoothAuthenticationResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static BluetoothAuthenticationResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothAuthenticationResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static BluetoothAuthenticationResult parseFrom(byte[] bArr) {
        return (BluetoothAuthenticationResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BluetoothAuthenticationResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothAuthenticationResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static BluetoothAuthenticationResult parseFrom(InputStream inputStream) {
        return (BluetoothAuthenticationResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BluetoothAuthenticationResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothAuthenticationResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BluetoothAuthenticationResult parseFrom(CodedInputStream codedInputStream) {
        return (BluetoothAuthenticationResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static BluetoothAuthenticationResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothAuthenticationResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
