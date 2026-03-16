package fr.sd.taada.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class SensorSourceService extends GeneratedMessageLite<SensorSourceService, Builder> implements SensorSourceServiceOrBuilder {
    private static final SensorSourceService DEFAULT_INSTANCE;
    public static final int LOCATION_CHARACTERIZATION_FIELD_NUMBER = 2;
    private static volatile Parser<SensorSourceService> PARSER = null;
    public static final int SENSORS_FIELD_NUMBER = 1;
    public static final int SUPPORTED_EV_CONNECTOR_TYPES_FIELD_NUMBER = 4;
    public static final int SUPPORTED_FUEL_TYPES_FIELD_NUMBER = 3;
    private int bitField0_;
    private int locationCharacterization_;
    private static final Internal.ListAdapter.Converter<Integer, FuelType> supportedFuelTypes_converter_ = new Internal.ListAdapter.Converter<Integer, FuelType>() { // from class: fr.sd.taada.proto.SensorSourceService.1
        @Override // com.google.protobuf.Internal.ListAdapter.Converter
        public FuelType convert(Integer num) {
            FuelType fuelTypeForNumber = FuelType.forNumber(num.intValue());
            return fuelTypeForNumber == null ? FuelType.FUEL_TYPE_UNKNOWN : fuelTypeForNumber;
        }
    };
    private static final Internal.ListAdapter.Converter<Integer, EvConnectorType> supportedEvConnectorTypes_converter_ = new Internal.ListAdapter.Converter<Integer, EvConnectorType>() { // from class: fr.sd.taada.proto.SensorSourceService.2
        @Override // com.google.protobuf.Internal.ListAdapter.Converter
        public EvConnectorType convert(Integer num) {
            EvConnectorType evConnectorTypeForNumber = EvConnectorType.forNumber(num.intValue());
            return evConnectorTypeForNumber == null ? EvConnectorType.EV_CONNECTOR_TYPE_UNKNOWN : evConnectorTypeForNumber;
        }
    };
    private byte memoizedIsInitialized = 2;
    private Internal.ProtobufList<Sensor> sensors_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.IntList supportedFuelTypes_ = GeneratedMessageLite.emptyIntList();
    private Internal.IntList supportedEvConnectorTypes_ = GeneratedMessageLite.emptyIntList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.SensorSourceService$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
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

    public static final class Builder extends GeneratedMessageLite.Builder<SensorSourceService, Builder> implements SensorSourceServiceOrBuilder {
        public Builder addAllSensors(Iterable<? extends Sensor> iterable) {
            copyOnWrite();
            ((SensorSourceService) this.instance).addAllSensors(iterable);
            return this;
        }

        public Builder addAllSupportedEvConnectorTypes(Iterable<? extends EvConnectorType> iterable) {
            copyOnWrite();
            ((SensorSourceService) this.instance).addAllSupportedEvConnectorTypes(iterable);
            return this;
        }

        public Builder addAllSupportedFuelTypes(Iterable<? extends FuelType> iterable) {
            copyOnWrite();
            ((SensorSourceService) this.instance).addAllSupportedFuelTypes(iterable);
            return this;
        }

        public Builder addSensors(Sensor sensor) {
            copyOnWrite();
            ((SensorSourceService) this.instance).addSensors(sensor);
            return this;
        }

        public Builder addSupportedEvConnectorTypes(EvConnectorType evConnectorType) {
            copyOnWrite();
            ((SensorSourceService) this.instance).addSupportedEvConnectorTypes(evConnectorType);
            return this;
        }

        public Builder addSupportedFuelTypes(FuelType fuelType) {
            copyOnWrite();
            ((SensorSourceService) this.instance).addSupportedFuelTypes(fuelType);
            return this;
        }

        public Builder clearLocationCharacterization() {
            copyOnWrite();
            ((SensorSourceService) this.instance).clearLocationCharacterization();
            return this;
        }

        public Builder clearSensors() {
            copyOnWrite();
            ((SensorSourceService) this.instance).clearSensors();
            return this;
        }

        public Builder clearSupportedEvConnectorTypes() {
            copyOnWrite();
            ((SensorSourceService) this.instance).clearSupportedEvConnectorTypes();
            return this;
        }

        public Builder clearSupportedFuelTypes() {
            copyOnWrite();
            ((SensorSourceService) this.instance).clearSupportedFuelTypes();
            return this;
        }

        @Override // fr.sd.taada.proto.SensorSourceServiceOrBuilder
        public int getLocationCharacterization() {
            return ((SensorSourceService) this.instance).getLocationCharacterization();
        }

        @Override // fr.sd.taada.proto.SensorSourceServiceOrBuilder
        public Sensor getSensors(int i) {
            return ((SensorSourceService) this.instance).getSensors(i);
        }

        @Override // fr.sd.taada.proto.SensorSourceServiceOrBuilder
        public int getSensorsCount() {
            return ((SensorSourceService) this.instance).getSensorsCount();
        }

        @Override // fr.sd.taada.proto.SensorSourceServiceOrBuilder
        public List<Sensor> getSensorsList() {
            return Collections.unmodifiableList(((SensorSourceService) this.instance).getSensorsList());
        }

        @Override // fr.sd.taada.proto.SensorSourceServiceOrBuilder
        public EvConnectorType getSupportedEvConnectorTypes(int i) {
            return ((SensorSourceService) this.instance).getSupportedEvConnectorTypes(i);
        }

        @Override // fr.sd.taada.proto.SensorSourceServiceOrBuilder
        public int getSupportedEvConnectorTypesCount() {
            return ((SensorSourceService) this.instance).getSupportedEvConnectorTypesCount();
        }

        @Override // fr.sd.taada.proto.SensorSourceServiceOrBuilder
        public List<EvConnectorType> getSupportedEvConnectorTypesList() {
            return ((SensorSourceService) this.instance).getSupportedEvConnectorTypesList();
        }

        @Override // fr.sd.taada.proto.SensorSourceServiceOrBuilder
        public FuelType getSupportedFuelTypes(int i) {
            return ((SensorSourceService) this.instance).getSupportedFuelTypes(i);
        }

        @Override // fr.sd.taada.proto.SensorSourceServiceOrBuilder
        public int getSupportedFuelTypesCount() {
            return ((SensorSourceService) this.instance).getSupportedFuelTypesCount();
        }

        @Override // fr.sd.taada.proto.SensorSourceServiceOrBuilder
        public List<FuelType> getSupportedFuelTypesList() {
            return ((SensorSourceService) this.instance).getSupportedFuelTypesList();
        }

        @Override // fr.sd.taada.proto.SensorSourceServiceOrBuilder
        public boolean hasLocationCharacterization() {
            return ((SensorSourceService) this.instance).hasLocationCharacterization();
        }

        public Builder removeSensors(int i) {
            copyOnWrite();
            ((SensorSourceService) this.instance).removeSensors(i);
            return this;
        }

        public Builder setLocationCharacterization(int i) {
            copyOnWrite();
            ((SensorSourceService) this.instance).setLocationCharacterization(i);
            return this;
        }

        public Builder setSensors(int i, Sensor sensor) {
            copyOnWrite();
            ((SensorSourceService) this.instance).setSensors(i, sensor);
            return this;
        }

        public Builder setSupportedEvConnectorTypes(int i, EvConnectorType evConnectorType) {
            copyOnWrite();
            ((SensorSourceService) this.instance).setSupportedEvConnectorTypes(i, evConnectorType);
            return this;
        }

        public Builder setSupportedFuelTypes(int i, FuelType fuelType) {
            copyOnWrite();
            ((SensorSourceService) this.instance).setSupportedFuelTypes(i, fuelType);
            return this;
        }

        private Builder() {
            super(SensorSourceService.DEFAULT_INSTANCE);
        }

        public Builder addSensors(int i, Sensor sensor) {
            copyOnWrite();
            ((SensorSourceService) this.instance).addSensors(i, sensor);
            return this;
        }

        public Builder setSensors(int i, Sensor.Builder builder) {
            copyOnWrite();
            ((SensorSourceService) this.instance).setSensors(i, builder);
            return this;
        }

        public Builder addSensors(Sensor.Builder builder) {
            copyOnWrite();
            ((SensorSourceService) this.instance).addSensors(builder);
            return this;
        }

        public Builder addSensors(int i, Sensor.Builder builder) {
            copyOnWrite();
            ((SensorSourceService) this.instance).addSensors(i, builder);
            return this;
        }
    }

    public static final class Sensor extends GeneratedMessageLite<Sensor, Builder> implements SensorOrBuilder {
        private static final Sensor DEFAULT_INSTANCE;
        private static volatile Parser<Sensor> PARSER = null;
        public static final int SENSOR_TYPE_FIELD_NUMBER = 1;
        private int bitField0_;
        private byte memoizedIsInitialized = 2;
        private int sensorType_ = 1;

        public static final class Builder extends GeneratedMessageLite.Builder<Sensor, Builder> implements SensorOrBuilder {
            public Builder clearSensorType() {
                copyOnWrite();
                ((Sensor) this.instance).clearSensorType();
                return this;
            }

            @Override // fr.sd.taada.proto.SensorSourceService.SensorOrBuilder
            public SensorType getSensorType() {
                return ((Sensor) this.instance).getSensorType();
            }

            @Override // fr.sd.taada.proto.SensorSourceService.SensorOrBuilder
            public boolean hasSensorType() {
                return ((Sensor) this.instance).hasSensorType();
            }

            public Builder setSensorType(SensorType sensorType) {
                copyOnWrite();
                ((Sensor) this.instance).setSensorType(sensorType);
                return this;
            }

            private Builder() {
                super(Sensor.DEFAULT_INSTANCE);
            }
        }

        static {
            Sensor sensor = new Sensor();
            DEFAULT_INSTANCE = sensor;
            GeneratedMessageLite.registerDefaultInstance(Sensor.class, sensor);
        }

        private Sensor() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSensorType() {
            this.bitField0_ &= -2;
            this.sensorType_ = 1;
        }

        public static Sensor getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Sensor parseDelimitedFrom(InputStream inputStream) {
            return (Sensor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Sensor parseFrom(ByteBuffer byteBuffer) {
            return (Sensor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<Sensor> parser() {
            return DEFAULT_INSTANCE.getParserForType();
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
            switch (AnonymousClass3.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Sensor();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001Ԍ\u0000", new Object[]{"bitField0_", "sensorType_", SensorType.internalGetVerifier()});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Sensor> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Sensor.class) {
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

        @Override // fr.sd.taada.proto.SensorSourceService.SensorOrBuilder
        public SensorType getSensorType() {
            SensorType sensorTypeForNumber = SensorType.forNumber(this.sensorType_);
            return sensorTypeForNumber == null ? SensorType.SENSOR_LOCATION : sensorTypeForNumber;
        }

        @Override // fr.sd.taada.proto.SensorSourceService.SensorOrBuilder
        public boolean hasSensorType() {
            return (this.bitField0_ & 1) != 0;
        }

        public static Builder newBuilder(Sensor sensor) {
            return DEFAULT_INSTANCE.createBuilder(sensor);
        }

        public static Sensor parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Sensor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Sensor parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (Sensor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Sensor parseFrom(ByteString byteString) {
            return (Sensor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Sensor parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Sensor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Sensor parseFrom(byte[] bArr) {
            return (Sensor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Sensor parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Sensor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Sensor parseFrom(InputStream inputStream) {
            return (Sensor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Sensor parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Sensor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Sensor parseFrom(CodedInputStream codedInputStream) {
            return (Sensor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Sensor parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Sensor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface SensorOrBuilder extends MessageLiteOrBuilder {
        SensorType getSensorType();

        boolean hasSensorType();
    }

    static {
        SensorSourceService sensorSourceService = new SensorSourceService();
        DEFAULT_INSTANCE = sensorSourceService;
        GeneratedMessageLite.registerDefaultInstance(SensorSourceService.class, sensorSourceService);
    }

    private SensorSourceService() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSensors(Iterable<? extends Sensor> iterable) {
        ensureSensorsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.sensors_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSupportedEvConnectorTypes(Iterable<? extends EvConnectorType> iterable) {
        ensureSupportedEvConnectorTypesIsMutable();
        Iterator<? extends EvConnectorType> it = iterable.iterator();
        while (it.hasNext()) {
            this.supportedEvConnectorTypes_.addInt(it.next().getNumber());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSupportedFuelTypes(Iterable<? extends FuelType> iterable) {
        ensureSupportedFuelTypesIsMutable();
        Iterator<? extends FuelType> it = iterable.iterator();
        while (it.hasNext()) {
            this.supportedFuelTypes_.addInt(it.next().getNumber());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSensors(Sensor sensor) {
        sensor.getClass();
        ensureSensorsIsMutable();
        this.sensors_.add(sensor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSupportedEvConnectorTypes(EvConnectorType evConnectorType) {
        evConnectorType.getClass();
        ensureSupportedEvConnectorTypesIsMutable();
        this.supportedEvConnectorTypes_.addInt(evConnectorType.getNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSupportedFuelTypes(FuelType fuelType) {
        fuelType.getClass();
        ensureSupportedFuelTypesIsMutable();
        this.supportedFuelTypes_.addInt(fuelType.getNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLocationCharacterization() {
        this.bitField0_ &= -2;
        this.locationCharacterization_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSensors() {
        this.sensors_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSupportedEvConnectorTypes() {
        this.supportedEvConnectorTypes_ = GeneratedMessageLite.emptyIntList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSupportedFuelTypes() {
        this.supportedFuelTypes_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureSensorsIsMutable() {
        if (this.sensors_.isModifiable()) {
            return;
        }
        this.sensors_ = GeneratedMessageLite.mutableCopy(this.sensors_);
    }

    private void ensureSupportedEvConnectorTypesIsMutable() {
        if (this.supportedEvConnectorTypes_.isModifiable()) {
            return;
        }
        this.supportedEvConnectorTypes_ = GeneratedMessageLite.mutableCopy(this.supportedEvConnectorTypes_);
    }

    private void ensureSupportedFuelTypesIsMutable() {
        if (this.supportedFuelTypes_.isModifiable()) {
            return;
        }
        this.supportedFuelTypes_ = GeneratedMessageLite.mutableCopy(this.supportedFuelTypes_);
    }

    public static SensorSourceService getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static SensorSourceService parseDelimitedFrom(InputStream inputStream) {
        return (SensorSourceService) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SensorSourceService parseFrom(ByteBuffer byteBuffer) {
        return (SensorSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<SensorSourceService> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSensors(int i) {
        ensureSensorsIsMutable();
        this.sensors_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocationCharacterization(int i) {
        this.bitField0_ |= 1;
        this.locationCharacterization_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSensors(int i, Sensor sensor) {
        sensor.getClass();
        ensureSensorsIsMutable();
        this.sensors_.set(i, sensor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSupportedEvConnectorTypes(int i, EvConnectorType evConnectorType) {
        evConnectorType.getClass();
        ensureSupportedEvConnectorTypesIsMutable();
        this.supportedEvConnectorTypes_.setInt(i, evConnectorType.getNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSupportedFuelTypes(int i, FuelType fuelType) {
        fuelType.getClass();
        ensureSupportedFuelTypesIsMutable();
        this.supportedFuelTypes_.setInt(i, fuelType.getNumber());
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (AnonymousClass3.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new SensorSourceService();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0003\u0001\u0001Л\u0002\u000b\u0000\u0003\u001e\u0004\u001e", new Object[]{"bitField0_", "sensors_", Sensor.class, "locationCharacterization_", "supportedFuelTypes_", FuelType.internalGetVerifier(), "supportedEvConnectorTypes_", EvConnectorType.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<SensorSourceService> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (SensorSourceService.class) {
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

    @Override // fr.sd.taada.proto.SensorSourceServiceOrBuilder
    public int getLocationCharacterization() {
        return this.locationCharacterization_;
    }

    @Override // fr.sd.taada.proto.SensorSourceServiceOrBuilder
    public Sensor getSensors(int i) {
        return this.sensors_.get(i);
    }

    @Override // fr.sd.taada.proto.SensorSourceServiceOrBuilder
    public int getSensorsCount() {
        return this.sensors_.size();
    }

    @Override // fr.sd.taada.proto.SensorSourceServiceOrBuilder
    public List<Sensor> getSensorsList() {
        return this.sensors_;
    }

    public SensorOrBuilder getSensorsOrBuilder(int i) {
        return this.sensors_.get(i);
    }

    public List<? extends SensorOrBuilder> getSensorsOrBuilderList() {
        return this.sensors_;
    }

    @Override // fr.sd.taada.proto.SensorSourceServiceOrBuilder
    public EvConnectorType getSupportedEvConnectorTypes(int i) {
        return supportedEvConnectorTypes_converter_.convert(Integer.valueOf(this.supportedEvConnectorTypes_.getInt(i)));
    }

    @Override // fr.sd.taada.proto.SensorSourceServiceOrBuilder
    public int getSupportedEvConnectorTypesCount() {
        return this.supportedEvConnectorTypes_.size();
    }

    @Override // fr.sd.taada.proto.SensorSourceServiceOrBuilder
    public List<EvConnectorType> getSupportedEvConnectorTypesList() {
        return new Internal.ListAdapter(this.supportedEvConnectorTypes_, supportedEvConnectorTypes_converter_);
    }

    @Override // fr.sd.taada.proto.SensorSourceServiceOrBuilder
    public FuelType getSupportedFuelTypes(int i) {
        return supportedFuelTypes_converter_.convert(Integer.valueOf(this.supportedFuelTypes_.getInt(i)));
    }

    @Override // fr.sd.taada.proto.SensorSourceServiceOrBuilder
    public int getSupportedFuelTypesCount() {
        return this.supportedFuelTypes_.size();
    }

    @Override // fr.sd.taada.proto.SensorSourceServiceOrBuilder
    public List<FuelType> getSupportedFuelTypesList() {
        return new Internal.ListAdapter(this.supportedFuelTypes_, supportedFuelTypes_converter_);
    }

    @Override // fr.sd.taada.proto.SensorSourceServiceOrBuilder
    public boolean hasLocationCharacterization() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(SensorSourceService sensorSourceService) {
        return DEFAULT_INSTANCE.createBuilder(sensorSourceService);
    }

    public static SensorSourceService parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorSourceService) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SensorSourceService parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static SensorSourceService parseFrom(ByteString byteString) {
        return (SensorSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSensors(int i, Sensor sensor) {
        sensor.getClass();
        ensureSensorsIsMutable();
        this.sensors_.add(i, sensor);
    }

    public static SensorSourceService parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSensors(int i, Sensor.Builder builder) {
        ensureSensorsIsMutable();
        this.sensors_.set(i, builder.build());
    }

    public static SensorSourceService parseFrom(byte[] bArr) {
        return (SensorSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SensorSourceService parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSensors(Sensor.Builder builder) {
        ensureSensorsIsMutable();
        this.sensors_.add(builder.build());
    }

    public static SensorSourceService parseFrom(InputStream inputStream) {
        return (SensorSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SensorSourceService parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSensors(int i, Sensor.Builder builder) {
        ensureSensorsIsMutable();
        this.sensors_.add(i, builder.build());
    }

    public static SensorSourceService parseFrom(CodedInputStream codedInputStream) {
        return (SensorSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SensorSourceService parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SensorSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
