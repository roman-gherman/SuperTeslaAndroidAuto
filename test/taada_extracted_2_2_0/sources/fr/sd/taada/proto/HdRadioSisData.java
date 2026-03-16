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
public final class HdRadioSisData extends GeneratedMessageLite<HdRadioSisData, Builder> implements HdRadioSisDataOrBuilder {
    private static final HdRadioSisData DEFAULT_INSTANCE;
    private static volatile Parser<HdRadioSisData> PARSER = null;
    public static final int SERVICE_INFO_MESSAGE_FIELD_NUMBER = 6;
    public static final int STATION_ID_FIELD_NUMBER = 1;
    public static final int STATION_LOCATION_FIELD_NUMBER = 4;
    public static final int STATION_MESSAGE_FIELD_NUMBER = 5;
    public static final int STATION_NAME_LONG_FIELD_NUMBER = 3;
    public static final int STATION_NAME_SHORT_FIELD_NUMBER = 2;
    public static final int UNIVERSAL_SHORT_STATION_NAME_SLOGAN_FIELD_NUMBER = 7;
    private int bitField0_;
    private int stationId_;
    private Location stationLocation_;
    private byte memoizedIsInitialized = 2;
    private String stationNameShort_ = "";
    private String stationNameLong_ = "";
    private String stationMessage_ = "";
    private String serviceInfoMessage_ = "";
    private String universalShortStationNameSlogan_ = "";

    /* JADX INFO: renamed from: fr.sd.taada.proto.HdRadioSisData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<HdRadioSisData, Builder> implements HdRadioSisDataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearServiceInfoMessage() {
            copyOnWrite();
            ((HdRadioSisData) this.instance).clearServiceInfoMessage();
            return this;
        }

        public Builder clearStationId() {
            copyOnWrite();
            ((HdRadioSisData) this.instance).clearStationId();
            return this;
        }

        public Builder clearStationLocation() {
            copyOnWrite();
            ((HdRadioSisData) this.instance).clearStationLocation();
            return this;
        }

        public Builder clearStationMessage() {
            copyOnWrite();
            ((HdRadioSisData) this.instance).clearStationMessage();
            return this;
        }

        public Builder clearStationNameLong() {
            copyOnWrite();
            ((HdRadioSisData) this.instance).clearStationNameLong();
            return this;
        }

        public Builder clearStationNameShort() {
            copyOnWrite();
            ((HdRadioSisData) this.instance).clearStationNameShort();
            return this;
        }

        public Builder clearUniversalShortStationNameSlogan() {
            copyOnWrite();
            ((HdRadioSisData) this.instance).clearUniversalShortStationNameSlogan();
            return this;
        }

        @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
        public String getServiceInfoMessage() {
            return ((HdRadioSisData) this.instance).getServiceInfoMessage();
        }

        @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
        public ByteString getServiceInfoMessageBytes() {
            return ((HdRadioSisData) this.instance).getServiceInfoMessageBytes();
        }

        @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
        public int getStationId() {
            return ((HdRadioSisData) this.instance).getStationId();
        }

        @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
        public Location getStationLocation() {
            return ((HdRadioSisData) this.instance).getStationLocation();
        }

        @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
        public String getStationMessage() {
            return ((HdRadioSisData) this.instance).getStationMessage();
        }

        @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
        public ByteString getStationMessageBytes() {
            return ((HdRadioSisData) this.instance).getStationMessageBytes();
        }

        @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
        public String getStationNameLong() {
            return ((HdRadioSisData) this.instance).getStationNameLong();
        }

        @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
        public ByteString getStationNameLongBytes() {
            return ((HdRadioSisData) this.instance).getStationNameLongBytes();
        }

        @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
        public String getStationNameShort() {
            return ((HdRadioSisData) this.instance).getStationNameShort();
        }

        @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
        public ByteString getStationNameShortBytes() {
            return ((HdRadioSisData) this.instance).getStationNameShortBytes();
        }

        @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
        public String getUniversalShortStationNameSlogan() {
            return ((HdRadioSisData) this.instance).getUniversalShortStationNameSlogan();
        }

        @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
        public ByteString getUniversalShortStationNameSloganBytes() {
            return ((HdRadioSisData) this.instance).getUniversalShortStationNameSloganBytes();
        }

        @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
        public boolean hasServiceInfoMessage() {
            return ((HdRadioSisData) this.instance).hasServiceInfoMessage();
        }

        @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
        public boolean hasStationId() {
            return ((HdRadioSisData) this.instance).hasStationId();
        }

        @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
        public boolean hasStationLocation() {
            return ((HdRadioSisData) this.instance).hasStationLocation();
        }

        @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
        public boolean hasStationMessage() {
            return ((HdRadioSisData) this.instance).hasStationMessage();
        }

        @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
        public boolean hasStationNameLong() {
            return ((HdRadioSisData) this.instance).hasStationNameLong();
        }

        @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
        public boolean hasStationNameShort() {
            return ((HdRadioSisData) this.instance).hasStationNameShort();
        }

        @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
        public boolean hasUniversalShortStationNameSlogan() {
            return ((HdRadioSisData) this.instance).hasUniversalShortStationNameSlogan();
        }

        public Builder mergeStationLocation(Location location) {
            copyOnWrite();
            ((HdRadioSisData) this.instance).mergeStationLocation(location);
            return this;
        }

        public Builder setServiceInfoMessage(String str) {
            copyOnWrite();
            ((HdRadioSisData) this.instance).setServiceInfoMessage(str);
            return this;
        }

        public Builder setServiceInfoMessageBytes(ByteString byteString) {
            copyOnWrite();
            ((HdRadioSisData) this.instance).setServiceInfoMessageBytes(byteString);
            return this;
        }

        public Builder setStationId(int i) {
            copyOnWrite();
            ((HdRadioSisData) this.instance).setStationId(i);
            return this;
        }

        public Builder setStationLocation(Location location) {
            copyOnWrite();
            ((HdRadioSisData) this.instance).setStationLocation(location);
            return this;
        }

        public Builder setStationMessage(String str) {
            copyOnWrite();
            ((HdRadioSisData) this.instance).setStationMessage(str);
            return this;
        }

        public Builder setStationMessageBytes(ByteString byteString) {
            copyOnWrite();
            ((HdRadioSisData) this.instance).setStationMessageBytes(byteString);
            return this;
        }

        public Builder setStationNameLong(String str) {
            copyOnWrite();
            ((HdRadioSisData) this.instance).setStationNameLong(str);
            return this;
        }

        public Builder setStationNameLongBytes(ByteString byteString) {
            copyOnWrite();
            ((HdRadioSisData) this.instance).setStationNameLongBytes(byteString);
            return this;
        }

        public Builder setStationNameShort(String str) {
            copyOnWrite();
            ((HdRadioSisData) this.instance).setStationNameShort(str);
            return this;
        }

        public Builder setStationNameShortBytes(ByteString byteString) {
            copyOnWrite();
            ((HdRadioSisData) this.instance).setStationNameShortBytes(byteString);
            return this;
        }

        public Builder setUniversalShortStationNameSlogan(String str) {
            copyOnWrite();
            ((HdRadioSisData) this.instance).setUniversalShortStationNameSlogan(str);
            return this;
        }

        public Builder setUniversalShortStationNameSloganBytes(ByteString byteString) {
            copyOnWrite();
            ((HdRadioSisData) this.instance).setUniversalShortStationNameSloganBytes(byteString);
            return this;
        }

        private Builder() {
            super(HdRadioSisData.DEFAULT_INSTANCE);
        }

        public Builder setStationLocation(Location.Builder builder) {
            copyOnWrite();
            ((HdRadioSisData) this.instance).setStationLocation(builder);
            return this;
        }
    }

    static {
        HdRadioSisData hdRadioSisData = new HdRadioSisData();
        DEFAULT_INSTANCE = hdRadioSisData;
        GeneratedMessageLite.registerDefaultInstance(HdRadioSisData.class, hdRadioSisData);
    }

    private HdRadioSisData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearServiceInfoMessage() {
        this.bitField0_ &= -33;
        this.serviceInfoMessage_ = getDefaultInstance().getServiceInfoMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStationId() {
        this.bitField0_ &= -2;
        this.stationId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStationLocation() {
        this.stationLocation_ = null;
        this.bitField0_ &= -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStationMessage() {
        this.bitField0_ &= -17;
        this.stationMessage_ = getDefaultInstance().getStationMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStationNameLong() {
        this.bitField0_ &= -5;
        this.stationNameLong_ = getDefaultInstance().getStationNameLong();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStationNameShort() {
        this.bitField0_ &= -3;
        this.stationNameShort_ = getDefaultInstance().getStationNameShort();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUniversalShortStationNameSlogan() {
        this.bitField0_ &= -65;
        this.universalShortStationNameSlogan_ = getDefaultInstance().getUniversalShortStationNameSlogan();
    }

    public static HdRadioSisData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStationLocation(Location location) {
        location.getClass();
        Location location2 = this.stationLocation_;
        if (location2 == null || location2 == Location.getDefaultInstance()) {
            this.stationLocation_ = location;
        } else {
            this.stationLocation_ = Location.newBuilder(this.stationLocation_).mergeFrom(location).buildPartial();
        }
        this.bitField0_ |= 8;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static HdRadioSisData parseDelimitedFrom(InputStream inputStream) {
        return (HdRadioSisData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HdRadioSisData parseFrom(ByteBuffer byteBuffer) {
        return (HdRadioSisData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<HdRadioSisData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServiceInfoMessage(String str) {
        str.getClass();
        this.bitField0_ |= 32;
        this.serviceInfoMessage_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServiceInfoMessageBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 32;
        this.serviceInfoMessage_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStationId(int i) {
        this.bitField0_ |= 1;
        this.stationId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStationLocation(Location location) {
        location.getClass();
        this.stationLocation_ = location;
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStationMessage(String str) {
        str.getClass();
        this.bitField0_ |= 16;
        this.stationMessage_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStationMessageBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 16;
        this.stationMessage_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStationNameLong(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.stationNameLong_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStationNameLongBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 4;
        this.stationNameLong_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStationNameShort(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.stationNameShort_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStationNameShortBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 2;
        this.stationNameShort_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUniversalShortStationNameSlogan(String str) {
        str.getClass();
        this.bitField0_ |= 64;
        this.universalShortStationNameSlogan_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUniversalShortStationNameSloganBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 64;
        this.universalShortStationNameSlogan_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new HdRadioSisData();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0001\u0001\u0004\u0000\u0002\b\u0001\u0003\b\u0002\u0004Љ\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006", new Object[]{"bitField0_", "stationId_", "stationNameShort_", "stationNameLong_", "stationLocation_", "stationMessage_", "serviceInfoMessage_", "universalShortStationNameSlogan_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HdRadioSisData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (HdRadioSisData.class) {
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

    @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
    public String getServiceInfoMessage() {
        return this.serviceInfoMessage_;
    }

    @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
    public ByteString getServiceInfoMessageBytes() {
        return ByteString.copyFromUtf8(this.serviceInfoMessage_);
    }

    @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
    public int getStationId() {
        return this.stationId_;
    }

    @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
    public Location getStationLocation() {
        Location location = this.stationLocation_;
        return location == null ? Location.getDefaultInstance() : location;
    }

    @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
    public String getStationMessage() {
        return this.stationMessage_;
    }

    @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
    public ByteString getStationMessageBytes() {
        return ByteString.copyFromUtf8(this.stationMessage_);
    }

    @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
    public String getStationNameLong() {
        return this.stationNameLong_;
    }

    @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
    public ByteString getStationNameLongBytes() {
        return ByteString.copyFromUtf8(this.stationNameLong_);
    }

    @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
    public String getStationNameShort() {
        return this.stationNameShort_;
    }

    @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
    public ByteString getStationNameShortBytes() {
        return ByteString.copyFromUtf8(this.stationNameShort_);
    }

    @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
    public String getUniversalShortStationNameSlogan() {
        return this.universalShortStationNameSlogan_;
    }

    @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
    public ByteString getUniversalShortStationNameSloganBytes() {
        return ByteString.copyFromUtf8(this.universalShortStationNameSlogan_);
    }

    @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
    public boolean hasServiceInfoMessage() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
    public boolean hasStationId() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
    public boolean hasStationLocation() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
    public boolean hasStationMessage() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
    public boolean hasStationNameLong() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
    public boolean hasStationNameShort() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.HdRadioSisDataOrBuilder
    public boolean hasUniversalShortStationNameSlogan() {
        return (this.bitField0_ & 64) != 0;
    }

    public static Builder newBuilder(HdRadioSisData hdRadioSisData) {
        return DEFAULT_INSTANCE.createBuilder(hdRadioSisData);
    }

    public static HdRadioSisData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioSisData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HdRadioSisData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioSisData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static HdRadioSisData parseFrom(ByteString byteString) {
        return (HdRadioSisData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static HdRadioSisData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioSisData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStationLocation(Location.Builder builder) {
        this.stationLocation_ = builder.build();
        this.bitField0_ |= 8;
    }

    public static HdRadioSisData parseFrom(byte[] bArr) {
        return (HdRadioSisData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static HdRadioSisData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioSisData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static HdRadioSisData parseFrom(InputStream inputStream) {
        return (HdRadioSisData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HdRadioSisData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioSisData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HdRadioSisData parseFrom(CodedInputStream codedInputStream) {
        return (HdRadioSisData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HdRadioSisData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioSisData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
