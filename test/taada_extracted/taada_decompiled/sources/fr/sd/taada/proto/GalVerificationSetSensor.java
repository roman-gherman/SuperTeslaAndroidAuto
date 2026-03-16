package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.SensorBatch;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class GalVerificationSetSensor extends GeneratedMessageLite<GalVerificationSetSensor, Builder> implements GalVerificationSetSensorOrBuilder {
    private static final GalVerificationSetSensor DEFAULT_INSTANCE;
    private static volatile Parser<GalVerificationSetSensor> PARSER = null;
    public static final int SENSORS_FIELD_NUMBER = 1;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private SensorBatch sensors_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.GalVerificationSetSensor$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<GalVerificationSetSensor, Builder> implements GalVerificationSetSensorOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearSensors() {
            copyOnWrite();
            ((GalVerificationSetSensor) this.instance).clearSensors();
            return this;
        }

        @Override // fr.sd.taada.proto.GalVerificationSetSensorOrBuilder
        public SensorBatch getSensors() {
            return ((GalVerificationSetSensor) this.instance).getSensors();
        }

        @Override // fr.sd.taada.proto.GalVerificationSetSensorOrBuilder
        public boolean hasSensors() {
            return ((GalVerificationSetSensor) this.instance).hasSensors();
        }

        public Builder mergeSensors(SensorBatch sensorBatch) {
            copyOnWrite();
            ((GalVerificationSetSensor) this.instance).mergeSensors(sensorBatch);
            return this;
        }

        public Builder setSensors(SensorBatch sensorBatch) {
            copyOnWrite();
            ((GalVerificationSetSensor) this.instance).setSensors(sensorBatch);
            return this;
        }

        private Builder() {
            super(GalVerificationSetSensor.DEFAULT_INSTANCE);
        }

        public Builder setSensors(SensorBatch.Builder builder) {
            copyOnWrite();
            ((GalVerificationSetSensor) this.instance).setSensors(builder);
            return this;
        }
    }

    static {
        GalVerificationSetSensor galVerificationSetSensor = new GalVerificationSetSensor();
        DEFAULT_INSTANCE = galVerificationSetSensor;
        GeneratedMessageLite.registerDefaultInstance(GalVerificationSetSensor.class, galVerificationSetSensor);
    }

    private GalVerificationSetSensor() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSensors() {
        this.sensors_ = null;
        this.bitField0_ &= -2;
    }

    public static GalVerificationSetSensor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSensors(SensorBatch sensorBatch) {
        sensorBatch.getClass();
        SensorBatch sensorBatch2 = this.sensors_;
        if (sensorBatch2 == null || sensorBatch2 == SensorBatch.getDefaultInstance()) {
            this.sensors_ = sensorBatch;
        } else {
            this.sensors_ = SensorBatch.newBuilder(this.sensors_).mergeFrom(sensorBatch).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GalVerificationSetSensor parseDelimitedFrom(InputStream inputStream) {
        return (GalVerificationSetSensor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GalVerificationSetSensor parseFrom(ByteBuffer byteBuffer) {
        return (GalVerificationSetSensor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GalVerificationSetSensor> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSensors(SensorBatch sensorBatch) {
        sensorBatch.getClass();
        this.sensors_ = sensorBatch;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GalVerificationSetSensor();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001Љ\u0000", new Object[]{"bitField0_", "sensors_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GalVerificationSetSensor> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GalVerificationSetSensor.class) {
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

    @Override // fr.sd.taada.proto.GalVerificationSetSensorOrBuilder
    public SensorBatch getSensors() {
        SensorBatch sensorBatch = this.sensors_;
        return sensorBatch == null ? SensorBatch.getDefaultInstance() : sensorBatch;
    }

    @Override // fr.sd.taada.proto.GalVerificationSetSensorOrBuilder
    public boolean hasSensors() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(GalVerificationSetSensor galVerificationSetSensor) {
        return DEFAULT_INSTANCE.createBuilder(galVerificationSetSensor);
    }

    public static GalVerificationSetSensor parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationSetSensor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GalVerificationSetSensor parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationSetSensor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GalVerificationSetSensor parseFrom(ByteString byteString) {
        return (GalVerificationSetSensor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GalVerificationSetSensor parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationSetSensor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSensors(SensorBatch.Builder builder) {
        this.sensors_ = builder.build();
        this.bitField0_ |= 1;
    }

    public static GalVerificationSetSensor parseFrom(byte[] bArr) {
        return (GalVerificationSetSensor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GalVerificationSetSensor parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationSetSensor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GalVerificationSetSensor parseFrom(InputStream inputStream) {
        return (GalVerificationSetSensor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GalVerificationSetSensor parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationSetSensor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GalVerificationSetSensor parseFrom(CodedInputStream codedInputStream) {
        return (GalVerificationSetSensor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GalVerificationSetSensor parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationSetSensor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
