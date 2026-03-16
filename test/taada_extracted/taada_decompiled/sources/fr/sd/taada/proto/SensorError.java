package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class SensorError extends GeneratedMessageLite<SensorError, Builder> implements SensorErrorOrBuilder {
    private static final SensorError DEFAULT_INSTANCE;
    private static volatile Parser<SensorError> PARSER = null;
    public static final int SENSOR_ERROR_TYPE_FIELD_NUMBER = 2;
    public static final int SENSOR_TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int sensorType_ = 1;
    private int sensorErrorType_ = 1;

    /* JADX INFO: renamed from: fr.sd.taada.proto.SensorError$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<SensorError, Builder> implements SensorErrorOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearSensorErrorType() {
            copyOnWrite();
            ((SensorError) this.instance).clearSensorErrorType();
            return this;
        }

        public Builder clearSensorType() {
            copyOnWrite();
            ((SensorError) this.instance).clearSensorType();
            return this;
        }

        @Override // fr.sd.taada.proto.SensorErrorOrBuilder
        public SensorErrorType getSensorErrorType() {
            return ((SensorError) this.instance).getSensorErrorType();
        }

        @Override // fr.sd.taada.proto.SensorErrorOrBuilder
        public SensorType getSensorType() {
            return ((SensorError) this.instance).getSensorType();
        }

        @Override // fr.sd.taada.proto.SensorErrorOrBuilder
        public boolean hasSensorErrorType() {
            return ((SensorError) this.instance).hasSensorErrorType();
        }

        @Override // fr.sd.taada.proto.SensorErrorOrBuilder
        public boolean hasSensorType() {
            return ((SensorError) this.instance).hasSensorType();
        }

        public Builder setSensorErrorType(SensorErrorType sensorErrorType) {
            copyOnWrite();
            ((SensorError) this.instance).setSensorErrorType(sensorErrorType);
            return this;
        }

        public Builder setSensorType(SensorType sensorType) {
            copyOnWrite();
            ((SensorError) this.instance).setSensorType(sensorType);
            return this;
        }

        private Builder() {
            super(SensorError.DEFAULT_INSTANCE);
        }
    }

    static {
        SensorError sensorError = new SensorError();
        DEFAULT_INSTANCE = sensorError;
        GeneratedMessageLite.registerDefaultInstance(SensorError.class, sensorError);
    }

    private SensorError() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSensorErrorType() {
        this.bitField0_ &= -3;
        this.sensorErrorType_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSensorType() {
        this.bitField0_ &= -2;
        this.sensorType_ = 1;
    }

    public static SensorError getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static SensorError parseDelimitedFrom(InputStream inputStream) {
        return (SensorError) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SensorError parseFrom(ByteBuffer byteBuffer) {
        return (SensorError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<SensorError> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSensorErrorType(SensorErrorType sensorErrorType) {
        sensorErrorType.getClass();
        this.bitField0_ |= 2;
        this.sensorErrorType_ = sensorErrorType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSensorType(SensorType sensorType) {
        sensorType.getClass();
        this.bitField0_ |= 1;
        this.sensorType_ = sensorType.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new SensorError();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001Ԍ\u0000\u0002Ԍ\u0001", new Object[]{"bitField0_", "sensorType_", SensorType.internalGetVerifier(), "sensorErrorType_", SensorErrorType.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<SensorError> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (SensorError.class) {
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

    @Override // fr.sd.taada.proto.SensorErrorOrBuilder
    public SensorErrorType getSensorErrorType() {
        SensorErrorType sensorErrorTypeForNumber = SensorErrorType.forNumber(this.sensorErrorType_);
        return sensorErrorTypeForNumber == null ? SensorErrorType.SENSOR_OK : sensorErrorTypeForNumber;
    }

    @Override // fr.sd.taada.proto.SensorErrorOrBuilder
    public SensorType getSensorType() {
        SensorType sensorTypeForNumber = SensorType.forNumber(this.sensorType_);
        return sensorTypeForNumber == null ? SensorType.SENSOR_LOCATION : sensorTypeForNumber;
    }

    @Override // fr.sd.taada.proto.SensorErrorOrBuilder
    public boolean hasSensorErrorType() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.SensorErrorOrBuilder
    public boolean hasSensorType() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(SensorError sensorError) {
        return DEFAULT_INSTANCE.createBuilder(sensorError);
    }

    public static SensorError parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorError) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SensorError parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static SensorError parseFrom(ByteString byteString) {
        return (SensorError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static SensorError parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static SensorError parseFrom(byte[] bArr) {
        return (SensorError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SensorError parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static SensorError parseFrom(InputStream inputStream) {
        return (SensorError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SensorError parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SensorError parseFrom(CodedInputStream codedInputStream) {
        return (SensorError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SensorError parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
