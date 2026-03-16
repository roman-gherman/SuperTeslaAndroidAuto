package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class LocationData extends GeneratedMessageLite<LocationData, Builder> implements LocationDataOrBuilder {
    public static final int ACCURACY_E3_FIELD_NUMBER = 4;
    public static final int ALTITUDE_E2_FIELD_NUMBER = 5;
    public static final int BEARING_E6_FIELD_NUMBER = 7;
    private static final LocationData DEFAULT_INSTANCE;
    public static final int LATITUDE_E7_FIELD_NUMBER = 2;
    public static final int LONGITUDE_E7_FIELD_NUMBER = 3;
    private static volatile Parser<LocationData> PARSER = null;
    public static final int SPEED_E3_FIELD_NUMBER = 6;
    public static final int TIMESTAMP_FIELD_NUMBER = 1;
    private int accuracyE3_;
    private int altitudeE2_;
    private int bearingE6_;
    private int bitField0_;
    private int latitudeE7_;
    private int longitudeE7_;
    private byte memoizedIsInitialized = 2;
    private int speedE3_;
    private long timestamp_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.LocationData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<LocationData, Builder> implements LocationDataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAccuracyE3() {
            copyOnWrite();
            ((LocationData) this.instance).clearAccuracyE3();
            return this;
        }

        public Builder clearAltitudeE2() {
            copyOnWrite();
            ((LocationData) this.instance).clearAltitudeE2();
            return this;
        }

        public Builder clearBearingE6() {
            copyOnWrite();
            ((LocationData) this.instance).clearBearingE6();
            return this;
        }

        public Builder clearLatitudeE7() {
            copyOnWrite();
            ((LocationData) this.instance).clearLatitudeE7();
            return this;
        }

        public Builder clearLongitudeE7() {
            copyOnWrite();
            ((LocationData) this.instance).clearLongitudeE7();
            return this;
        }

        public Builder clearSpeedE3() {
            copyOnWrite();
            ((LocationData) this.instance).clearSpeedE3();
            return this;
        }

        @Deprecated
        public Builder clearTimestamp() {
            copyOnWrite();
            ((LocationData) this.instance).clearTimestamp();
            return this;
        }

        @Override // fr.sd.taada.proto.LocationDataOrBuilder
        public int getAccuracyE3() {
            return ((LocationData) this.instance).getAccuracyE3();
        }

        @Override // fr.sd.taada.proto.LocationDataOrBuilder
        public int getAltitudeE2() {
            return ((LocationData) this.instance).getAltitudeE2();
        }

        @Override // fr.sd.taada.proto.LocationDataOrBuilder
        public int getBearingE6() {
            return ((LocationData) this.instance).getBearingE6();
        }

        @Override // fr.sd.taada.proto.LocationDataOrBuilder
        public int getLatitudeE7() {
            return ((LocationData) this.instance).getLatitudeE7();
        }

        @Override // fr.sd.taada.proto.LocationDataOrBuilder
        public int getLongitudeE7() {
            return ((LocationData) this.instance).getLongitudeE7();
        }

        @Override // fr.sd.taada.proto.LocationDataOrBuilder
        public int getSpeedE3() {
            return ((LocationData) this.instance).getSpeedE3();
        }

        @Override // fr.sd.taada.proto.LocationDataOrBuilder
        @Deprecated
        public long getTimestamp() {
            return ((LocationData) this.instance).getTimestamp();
        }

        @Override // fr.sd.taada.proto.LocationDataOrBuilder
        public boolean hasAccuracyE3() {
            return ((LocationData) this.instance).hasAccuracyE3();
        }

        @Override // fr.sd.taada.proto.LocationDataOrBuilder
        public boolean hasAltitudeE2() {
            return ((LocationData) this.instance).hasAltitudeE2();
        }

        @Override // fr.sd.taada.proto.LocationDataOrBuilder
        public boolean hasBearingE6() {
            return ((LocationData) this.instance).hasBearingE6();
        }

        @Override // fr.sd.taada.proto.LocationDataOrBuilder
        public boolean hasLatitudeE7() {
            return ((LocationData) this.instance).hasLatitudeE7();
        }

        @Override // fr.sd.taada.proto.LocationDataOrBuilder
        public boolean hasLongitudeE7() {
            return ((LocationData) this.instance).hasLongitudeE7();
        }

        @Override // fr.sd.taada.proto.LocationDataOrBuilder
        public boolean hasSpeedE3() {
            return ((LocationData) this.instance).hasSpeedE3();
        }

        @Override // fr.sd.taada.proto.LocationDataOrBuilder
        @Deprecated
        public boolean hasTimestamp() {
            return ((LocationData) this.instance).hasTimestamp();
        }

        public Builder setAccuracyE3(int i) {
            copyOnWrite();
            ((LocationData) this.instance).setAccuracyE3(i);
            return this;
        }

        public Builder setAltitudeE2(int i) {
            copyOnWrite();
            ((LocationData) this.instance).setAltitudeE2(i);
            return this;
        }

        public Builder setBearingE6(int i) {
            copyOnWrite();
            ((LocationData) this.instance).setBearingE6(i);
            return this;
        }

        public Builder setLatitudeE7(int i) {
            copyOnWrite();
            ((LocationData) this.instance).setLatitudeE7(i);
            return this;
        }

        public Builder setLongitudeE7(int i) {
            copyOnWrite();
            ((LocationData) this.instance).setLongitudeE7(i);
            return this;
        }

        public Builder setSpeedE3(int i) {
            copyOnWrite();
            ((LocationData) this.instance).setSpeedE3(i);
            return this;
        }

        @Deprecated
        public Builder setTimestamp(long j6) {
            copyOnWrite();
            ((LocationData) this.instance).setTimestamp(j6);
            return this;
        }

        private Builder() {
            super(LocationData.DEFAULT_INSTANCE);
        }
    }

    static {
        LocationData locationData = new LocationData();
        DEFAULT_INSTANCE = locationData;
        GeneratedMessageLite.registerDefaultInstance(LocationData.class, locationData);
    }

    private LocationData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAccuracyE3() {
        this.bitField0_ &= -9;
        this.accuracyE3_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAltitudeE2() {
        this.bitField0_ &= -17;
        this.altitudeE2_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBearingE6() {
        this.bitField0_ &= -65;
        this.bearingE6_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLatitudeE7() {
        this.bitField0_ &= -3;
        this.latitudeE7_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLongitudeE7() {
        this.bitField0_ &= -5;
        this.longitudeE7_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSpeedE3() {
        this.bitField0_ &= -33;
        this.speedE3_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimestamp() {
        this.bitField0_ &= -2;
        this.timestamp_ = 0L;
    }

    public static LocationData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static LocationData parseDelimitedFrom(InputStream inputStream) {
        return (LocationData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LocationData parseFrom(ByteBuffer byteBuffer) {
        return (LocationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<LocationData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAccuracyE3(int i) {
        this.bitField0_ |= 8;
        this.accuracyE3_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAltitudeE2(int i) {
        this.bitField0_ |= 16;
        this.altitudeE2_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBearingE6(int i) {
        this.bitField0_ |= 64;
        this.bearingE6_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLatitudeE7(int i) {
        this.bitField0_ |= 2;
        this.latitudeE7_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLongitudeE7(int i) {
        this.bitField0_ |= 4;
        this.longitudeE7_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSpeedE3(int i) {
        this.bitField0_ |= 32;
        this.speedE3_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimestamp(long j6) {
        this.bitField0_ |= 1;
        this.timestamp_ = j6;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new LocationData();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0002\u0001\u0003\u0000\u0002Ԅ\u0001\u0003Ԅ\u0002\u0004\u000b\u0003\u0005\u0004\u0004\u0006\u0004\u0005\u0007\u0004\u0006", new Object[]{"bitField0_", "timestamp_", "latitudeE7_", "longitudeE7_", "accuracyE3_", "altitudeE2_", "speedE3_", "bearingE6_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<LocationData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (LocationData.class) {
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

    @Override // fr.sd.taada.proto.LocationDataOrBuilder
    public int getAccuracyE3() {
        return this.accuracyE3_;
    }

    @Override // fr.sd.taada.proto.LocationDataOrBuilder
    public int getAltitudeE2() {
        return this.altitudeE2_;
    }

    @Override // fr.sd.taada.proto.LocationDataOrBuilder
    public int getBearingE6() {
        return this.bearingE6_;
    }

    @Override // fr.sd.taada.proto.LocationDataOrBuilder
    public int getLatitudeE7() {
        return this.latitudeE7_;
    }

    @Override // fr.sd.taada.proto.LocationDataOrBuilder
    public int getLongitudeE7() {
        return this.longitudeE7_;
    }

    @Override // fr.sd.taada.proto.LocationDataOrBuilder
    public int getSpeedE3() {
        return this.speedE3_;
    }

    @Override // fr.sd.taada.proto.LocationDataOrBuilder
    @Deprecated
    public long getTimestamp() {
        return this.timestamp_;
    }

    @Override // fr.sd.taada.proto.LocationDataOrBuilder
    public boolean hasAccuracyE3() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // fr.sd.taada.proto.LocationDataOrBuilder
    public boolean hasAltitudeE2() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // fr.sd.taada.proto.LocationDataOrBuilder
    public boolean hasBearingE6() {
        return (this.bitField0_ & 64) != 0;
    }

    @Override // fr.sd.taada.proto.LocationDataOrBuilder
    public boolean hasLatitudeE7() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.LocationDataOrBuilder
    public boolean hasLongitudeE7() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.LocationDataOrBuilder
    public boolean hasSpeedE3() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // fr.sd.taada.proto.LocationDataOrBuilder
    @Deprecated
    public boolean hasTimestamp() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(LocationData locationData) {
        return DEFAULT_INSTANCE.createBuilder(locationData);
    }

    public static LocationData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LocationData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static LocationData parseFrom(ByteString byteString) {
        return (LocationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static LocationData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static LocationData parseFrom(byte[] bArr) {
        return (LocationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LocationData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static LocationData parseFrom(InputStream inputStream) {
        return (LocationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LocationData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LocationData parseFrom(CodedInputStream codedInputStream) {
        return (LocationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static LocationData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LocationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
