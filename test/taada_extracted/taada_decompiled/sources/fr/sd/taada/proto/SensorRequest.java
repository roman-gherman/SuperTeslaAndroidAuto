package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class SensorRequest extends GeneratedMessageLite<SensorRequest, Builder> implements SensorRequestOrBuilder {
    private static final SensorRequest DEFAULT_INSTANCE;
    public static final int MIN_UPDATE_PERIOD_FIELD_NUMBER = 2;
    private static volatile Parser<SensorRequest> PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private long minUpdatePeriod_;
    private byte memoizedIsInitialized = 2;
    private int type_ = 1;

    /* JADX INFO: renamed from: fr.sd.taada.proto.SensorRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<SensorRequest, Builder> implements SensorRequestOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearMinUpdatePeriod() {
            copyOnWrite();
            ((SensorRequest) this.instance).clearMinUpdatePeriod();
            return this;
        }

        public Builder clearType() {
            copyOnWrite();
            ((SensorRequest) this.instance).clearType();
            return this;
        }

        @Override // fr.sd.taada.proto.SensorRequestOrBuilder
        public long getMinUpdatePeriod() {
            return ((SensorRequest) this.instance).getMinUpdatePeriod();
        }

        @Override // fr.sd.taada.proto.SensorRequestOrBuilder
        public SensorType getType() {
            return ((SensorRequest) this.instance).getType();
        }

        @Override // fr.sd.taada.proto.SensorRequestOrBuilder
        public boolean hasMinUpdatePeriod() {
            return ((SensorRequest) this.instance).hasMinUpdatePeriod();
        }

        @Override // fr.sd.taada.proto.SensorRequestOrBuilder
        public boolean hasType() {
            return ((SensorRequest) this.instance).hasType();
        }

        public Builder setMinUpdatePeriod(long j6) {
            copyOnWrite();
            ((SensorRequest) this.instance).setMinUpdatePeriod(j6);
            return this;
        }

        public Builder setType(SensorType sensorType) {
            copyOnWrite();
            ((SensorRequest) this.instance).setType(sensorType);
            return this;
        }

        private Builder() {
            super(SensorRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        SensorRequest sensorRequest = new SensorRequest();
        DEFAULT_INSTANCE = sensorRequest;
        GeneratedMessageLite.registerDefaultInstance(SensorRequest.class, sensorRequest);
    }

    private SensorRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMinUpdatePeriod() {
        this.bitField0_ &= -3;
        this.minUpdatePeriod_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.bitField0_ &= -2;
        this.type_ = 1;
    }

    public static SensorRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static SensorRequest parseDelimitedFrom(InputStream inputStream) {
        return (SensorRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SensorRequest parseFrom(ByteBuffer byteBuffer) {
        return (SensorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<SensorRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMinUpdatePeriod(long j6) {
        this.bitField0_ |= 2;
        this.minUpdatePeriod_ = j6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(SensorType sensorType) {
        sensorType.getClass();
        this.bitField0_ |= 1;
        this.type_ = sensorType.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new SensorRequest();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001Ԍ\u0000\u0002Ԃ\u0001", new Object[]{"bitField0_", "type_", SensorType.internalGetVerifier(), "minUpdatePeriod_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<SensorRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (SensorRequest.class) {
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

    @Override // fr.sd.taada.proto.SensorRequestOrBuilder
    public long getMinUpdatePeriod() {
        return this.minUpdatePeriod_;
    }

    @Override // fr.sd.taada.proto.SensorRequestOrBuilder
    public SensorType getType() {
        SensorType sensorTypeForNumber = SensorType.forNumber(this.type_);
        return sensorTypeForNumber == null ? SensorType.SENSOR_LOCATION : sensorTypeForNumber;
    }

    @Override // fr.sd.taada.proto.SensorRequestOrBuilder
    public boolean hasMinUpdatePeriod() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.SensorRequestOrBuilder
    public boolean hasType() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(SensorRequest sensorRequest) {
        return DEFAULT_INSTANCE.createBuilder(sensorRequest);
    }

    public static SensorRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SensorRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static SensorRequest parseFrom(ByteString byteString) {
        return (SensorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static SensorRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static SensorRequest parseFrom(byte[] bArr) {
        return (SensorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SensorRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static SensorRequest parseFrom(InputStream inputStream) {
        return (SensorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SensorRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SensorRequest parseFrom(CodedInputStream codedInputStream) {
        return (SensorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SensorRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
