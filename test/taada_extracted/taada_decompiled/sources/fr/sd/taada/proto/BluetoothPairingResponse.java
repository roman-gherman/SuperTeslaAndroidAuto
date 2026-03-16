package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class BluetoothPairingResponse extends GeneratedMessageLite<BluetoothPairingResponse, Builder> implements BluetoothPairingResponseOrBuilder {
    public static final int ALREADY_PAIRED_FIELD_NUMBER = 2;
    private static final BluetoothPairingResponse DEFAULT_INSTANCE;
    private static volatile Parser<BluetoothPairingResponse> PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 1;
    private boolean alreadyPaired_;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int status_ = 1;

    /* JADX INFO: renamed from: fr.sd.taada.proto.BluetoothPairingResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<BluetoothPairingResponse, Builder> implements BluetoothPairingResponseOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAlreadyPaired() {
            copyOnWrite();
            ((BluetoothPairingResponse) this.instance).clearAlreadyPaired();
            return this;
        }

        public Builder clearStatus() {
            copyOnWrite();
            ((BluetoothPairingResponse) this.instance).clearStatus();
            return this;
        }

        @Override // fr.sd.taada.proto.BluetoothPairingResponseOrBuilder
        public boolean getAlreadyPaired() {
            return ((BluetoothPairingResponse) this.instance).getAlreadyPaired();
        }

        @Override // fr.sd.taada.proto.BluetoothPairingResponseOrBuilder
        public MessageStatus getStatus() {
            return ((BluetoothPairingResponse) this.instance).getStatus();
        }

        @Override // fr.sd.taada.proto.BluetoothPairingResponseOrBuilder
        public boolean hasAlreadyPaired() {
            return ((BluetoothPairingResponse) this.instance).hasAlreadyPaired();
        }

        @Override // fr.sd.taada.proto.BluetoothPairingResponseOrBuilder
        public boolean hasStatus() {
            return ((BluetoothPairingResponse) this.instance).hasStatus();
        }

        public Builder setAlreadyPaired(boolean z6) {
            copyOnWrite();
            ((BluetoothPairingResponse) this.instance).setAlreadyPaired(z6);
            return this;
        }

        public Builder setStatus(MessageStatus messageStatus) {
            copyOnWrite();
            ((BluetoothPairingResponse) this.instance).setStatus(messageStatus);
            return this;
        }

        private Builder() {
            super(BluetoothPairingResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        BluetoothPairingResponse bluetoothPairingResponse = new BluetoothPairingResponse();
        DEFAULT_INSTANCE = bluetoothPairingResponse;
        GeneratedMessageLite.registerDefaultInstance(BluetoothPairingResponse.class, bluetoothPairingResponse);
    }

    private BluetoothPairingResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAlreadyPaired() {
        this.bitField0_ &= -3;
        this.alreadyPaired_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.bitField0_ &= -2;
        this.status_ = 1;
    }

    public static BluetoothPairingResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static BluetoothPairingResponse parseDelimitedFrom(InputStream inputStream) {
        return (BluetoothPairingResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BluetoothPairingResponse parseFrom(ByteBuffer byteBuffer) {
        return (BluetoothPairingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<BluetoothPairingResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlreadyPaired(boolean z6) {
        this.bitField0_ |= 2;
        this.alreadyPaired_ = z6;
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
                return new BluetoothPairingResponse();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001Ԍ\u0000\u0002ԇ\u0001", new Object[]{"bitField0_", "status_", MessageStatus.internalGetVerifier(), "alreadyPaired_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<BluetoothPairingResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (BluetoothPairingResponse.class) {
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

    @Override // fr.sd.taada.proto.BluetoothPairingResponseOrBuilder
    public boolean getAlreadyPaired() {
        return this.alreadyPaired_;
    }

    @Override // fr.sd.taada.proto.BluetoothPairingResponseOrBuilder
    public MessageStatus getStatus() {
        MessageStatus messageStatusForNumber = MessageStatus.forNumber(this.status_);
        return messageStatusForNumber == null ? MessageStatus.STATUS_UNSOLICITED_MESSAGE : messageStatusForNumber;
    }

    @Override // fr.sd.taada.proto.BluetoothPairingResponseOrBuilder
    public boolean hasAlreadyPaired() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.BluetoothPairingResponseOrBuilder
    public boolean hasStatus() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(BluetoothPairingResponse bluetoothPairingResponse) {
        return DEFAULT_INSTANCE.createBuilder(bluetoothPairingResponse);
    }

    public static BluetoothPairingResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothPairingResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BluetoothPairingResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothPairingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static BluetoothPairingResponse parseFrom(ByteString byteString) {
        return (BluetoothPairingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static BluetoothPairingResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothPairingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static BluetoothPairingResponse parseFrom(byte[] bArr) {
        return (BluetoothPairingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BluetoothPairingResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothPairingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static BluetoothPairingResponse parseFrom(InputStream inputStream) {
        return (BluetoothPairingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BluetoothPairingResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothPairingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BluetoothPairingResponse parseFrom(CodedInputStream codedInputStream) {
        return (BluetoothPairingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static BluetoothPairingResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothPairingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
