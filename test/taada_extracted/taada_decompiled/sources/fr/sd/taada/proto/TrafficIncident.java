package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.Location;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class TrafficIncident extends GeneratedMessageLite<TrafficIncident, Builder> implements TrafficIncidentOrBuilder {
    private static final TrafficIncident DEFAULT_INSTANCE;
    public static final int EVENT_CODE_FIELD_NUMBER = 1;
    public static final int EXPECTED_INCIDENT_DURATION_FIELD_NUMBER = 3;
    public static final int LOCATION_FIELD_NUMBER = 2;
    private static volatile Parser<TrafficIncident> PARSER;
    private int bitField0_;
    private int eventCode_;
    private int expectedIncidentDuration_;
    private Location location_;
    private byte memoizedIsInitialized = 2;

    /* JADX INFO: renamed from: fr.sd.taada.proto.TrafficIncident$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<TrafficIncident, Builder> implements TrafficIncidentOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearEventCode() {
            copyOnWrite();
            ((TrafficIncident) this.instance).clearEventCode();
            return this;
        }

        public Builder clearExpectedIncidentDuration() {
            copyOnWrite();
            ((TrafficIncident) this.instance).clearExpectedIncidentDuration();
            return this;
        }

        public Builder clearLocation() {
            copyOnWrite();
            ((TrafficIncident) this.instance).clearLocation();
            return this;
        }

        @Override // fr.sd.taada.proto.TrafficIncidentOrBuilder
        public int getEventCode() {
            return ((TrafficIncident) this.instance).getEventCode();
        }

        @Override // fr.sd.taada.proto.TrafficIncidentOrBuilder
        public int getExpectedIncidentDuration() {
            return ((TrafficIncident) this.instance).getExpectedIncidentDuration();
        }

        @Override // fr.sd.taada.proto.TrafficIncidentOrBuilder
        public Location getLocation() {
            return ((TrafficIncident) this.instance).getLocation();
        }

        @Override // fr.sd.taada.proto.TrafficIncidentOrBuilder
        public boolean hasEventCode() {
            return ((TrafficIncident) this.instance).hasEventCode();
        }

        @Override // fr.sd.taada.proto.TrafficIncidentOrBuilder
        public boolean hasExpectedIncidentDuration() {
            return ((TrafficIncident) this.instance).hasExpectedIncidentDuration();
        }

        @Override // fr.sd.taada.proto.TrafficIncidentOrBuilder
        public boolean hasLocation() {
            return ((TrafficIncident) this.instance).hasLocation();
        }

        public Builder mergeLocation(Location location) {
            copyOnWrite();
            ((TrafficIncident) this.instance).mergeLocation(location);
            return this;
        }

        public Builder setEventCode(int i) {
            copyOnWrite();
            ((TrafficIncident) this.instance).setEventCode(i);
            return this;
        }

        public Builder setExpectedIncidentDuration(int i) {
            copyOnWrite();
            ((TrafficIncident) this.instance).setExpectedIncidentDuration(i);
            return this;
        }

        public Builder setLocation(Location location) {
            copyOnWrite();
            ((TrafficIncident) this.instance).setLocation(location);
            return this;
        }

        private Builder() {
            super(TrafficIncident.DEFAULT_INSTANCE);
        }

        public Builder setLocation(Location.Builder builder) {
            copyOnWrite();
            ((TrafficIncident) this.instance).setLocation(builder);
            return this;
        }
    }

    static {
        TrafficIncident trafficIncident = new TrafficIncident();
        DEFAULT_INSTANCE = trafficIncident;
        GeneratedMessageLite.registerDefaultInstance(TrafficIncident.class, trafficIncident);
    }

    private TrafficIncident() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEventCode() {
        this.bitField0_ &= -2;
        this.eventCode_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearExpectedIncidentDuration() {
        this.bitField0_ &= -5;
        this.expectedIncidentDuration_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLocation() {
        this.location_ = null;
        this.bitField0_ &= -3;
    }

    public static TrafficIncident getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeLocation(Location location) {
        location.getClass();
        Location location2 = this.location_;
        if (location2 == null || location2 == Location.getDefaultInstance()) {
            this.location_ = location;
        } else {
            this.location_ = Location.newBuilder(this.location_).mergeFrom(location).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static TrafficIncident parseDelimitedFrom(InputStream inputStream) {
        return (TrafficIncident) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TrafficIncident parseFrom(ByteBuffer byteBuffer) {
        return (TrafficIncident) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<TrafficIncident> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEventCode(int i) {
        this.bitField0_ |= 1;
        this.eventCode_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExpectedIncidentDuration(int i) {
        this.bitField0_ |= 4;
        this.expectedIncidentDuration_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocation(Location location) {
        location.getClass();
        this.location_ = location;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new TrafficIncident();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001Ԅ\u0000\u0002ԉ\u0001\u0003Ԅ\u0002", new Object[]{"bitField0_", "eventCode_", "location_", "expectedIncidentDuration_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<TrafficIncident> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (TrafficIncident.class) {
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

    @Override // fr.sd.taada.proto.TrafficIncidentOrBuilder
    public int getEventCode() {
        return this.eventCode_;
    }

    @Override // fr.sd.taada.proto.TrafficIncidentOrBuilder
    public int getExpectedIncidentDuration() {
        return this.expectedIncidentDuration_;
    }

    @Override // fr.sd.taada.proto.TrafficIncidentOrBuilder
    public Location getLocation() {
        Location location = this.location_;
        return location == null ? Location.getDefaultInstance() : location;
    }

    @Override // fr.sd.taada.proto.TrafficIncidentOrBuilder
    public boolean hasEventCode() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.TrafficIncidentOrBuilder
    public boolean hasExpectedIncidentDuration() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.TrafficIncidentOrBuilder
    public boolean hasLocation() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(TrafficIncident trafficIncident) {
        return DEFAULT_INSTANCE.createBuilder(trafficIncident);
    }

    public static TrafficIncident parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TrafficIncident) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TrafficIncident parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (TrafficIncident) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static TrafficIncident parseFrom(ByteString byteString) {
        return (TrafficIncident) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static TrafficIncident parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (TrafficIncident) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocation(Location.Builder builder) {
        this.location_ = builder.build();
        this.bitField0_ |= 2;
    }

    public static TrafficIncident parseFrom(byte[] bArr) {
        return (TrafficIncident) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TrafficIncident parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (TrafficIncident) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static TrafficIncident parseFrom(InputStream inputStream) {
        return (TrafficIncident) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TrafficIncident parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TrafficIncident) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TrafficIncident parseFrom(CodedInputStream codedInputStream) {
        return (TrafficIncident) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static TrafficIncident parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TrafficIncident) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
