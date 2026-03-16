package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.HdRadioStationInfo;
import fr.sd.taada.proto.RdsData;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class RadioStationMetaData extends GeneratedMessageLite<RadioStationMetaData, Builder> implements RadioStationMetaDataOrBuilder {
    public static final int AUDIO_CHANNELS_FIELD_NUMBER = 1;
    private static final RadioStationMetaData DEFAULT_INSTANCE;
    public static final int HD_STATION_INFO_FIELD_NUMBER = 4;
    private static volatile Parser<RadioStationMetaData> PARSER = null;
    public static final int RDS_FIELD_NUMBER = 3;
    public static final int SIGNAL_QUALITY_FIELD_NUMBER = 2;
    private int audioChannels_;
    private int bitField0_;
    private HdRadioStationInfo hdStationInfo_;
    private byte memoizedIsInitialized = 2;
    private RdsData rds_;
    private int signalQuality_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.RadioStationMetaData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<RadioStationMetaData, Builder> implements RadioStationMetaDataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAudioChannels() {
            copyOnWrite();
            ((RadioStationMetaData) this.instance).clearAudioChannels();
            return this;
        }

        public Builder clearHdStationInfo() {
            copyOnWrite();
            ((RadioStationMetaData) this.instance).clearHdStationInfo();
            return this;
        }

        public Builder clearRds() {
            copyOnWrite();
            ((RadioStationMetaData) this.instance).clearRds();
            return this;
        }

        public Builder clearSignalQuality() {
            copyOnWrite();
            ((RadioStationMetaData) this.instance).clearSignalQuality();
            return this;
        }

        @Override // fr.sd.taada.proto.RadioStationMetaDataOrBuilder
        public int getAudioChannels() {
            return ((RadioStationMetaData) this.instance).getAudioChannels();
        }

        @Override // fr.sd.taada.proto.RadioStationMetaDataOrBuilder
        public HdRadioStationInfo getHdStationInfo() {
            return ((RadioStationMetaData) this.instance).getHdStationInfo();
        }

        @Override // fr.sd.taada.proto.RadioStationMetaDataOrBuilder
        public RdsData getRds() {
            return ((RadioStationMetaData) this.instance).getRds();
        }

        @Override // fr.sd.taada.proto.RadioStationMetaDataOrBuilder
        public int getSignalQuality() {
            return ((RadioStationMetaData) this.instance).getSignalQuality();
        }

        @Override // fr.sd.taada.proto.RadioStationMetaDataOrBuilder
        public boolean hasAudioChannels() {
            return ((RadioStationMetaData) this.instance).hasAudioChannels();
        }

        @Override // fr.sd.taada.proto.RadioStationMetaDataOrBuilder
        public boolean hasHdStationInfo() {
            return ((RadioStationMetaData) this.instance).hasHdStationInfo();
        }

        @Override // fr.sd.taada.proto.RadioStationMetaDataOrBuilder
        public boolean hasRds() {
            return ((RadioStationMetaData) this.instance).hasRds();
        }

        @Override // fr.sd.taada.proto.RadioStationMetaDataOrBuilder
        public boolean hasSignalQuality() {
            return ((RadioStationMetaData) this.instance).hasSignalQuality();
        }

        public Builder mergeHdStationInfo(HdRadioStationInfo hdRadioStationInfo) {
            copyOnWrite();
            ((RadioStationMetaData) this.instance).mergeHdStationInfo(hdRadioStationInfo);
            return this;
        }

        public Builder mergeRds(RdsData rdsData) {
            copyOnWrite();
            ((RadioStationMetaData) this.instance).mergeRds(rdsData);
            return this;
        }

        public Builder setAudioChannels(int i) {
            copyOnWrite();
            ((RadioStationMetaData) this.instance).setAudioChannels(i);
            return this;
        }

        public Builder setHdStationInfo(HdRadioStationInfo hdRadioStationInfo) {
            copyOnWrite();
            ((RadioStationMetaData) this.instance).setHdStationInfo(hdRadioStationInfo);
            return this;
        }

        public Builder setRds(RdsData rdsData) {
            copyOnWrite();
            ((RadioStationMetaData) this.instance).setRds(rdsData);
            return this;
        }

        public Builder setSignalQuality(int i) {
            copyOnWrite();
            ((RadioStationMetaData) this.instance).setSignalQuality(i);
            return this;
        }

        private Builder() {
            super(RadioStationMetaData.DEFAULT_INSTANCE);
        }

        public Builder setHdStationInfo(HdRadioStationInfo.Builder builder) {
            copyOnWrite();
            ((RadioStationMetaData) this.instance).setHdStationInfo(builder);
            return this;
        }

        public Builder setRds(RdsData.Builder builder) {
            copyOnWrite();
            ((RadioStationMetaData) this.instance).setRds(builder);
            return this;
        }
    }

    static {
        RadioStationMetaData radioStationMetaData = new RadioStationMetaData();
        DEFAULT_INSTANCE = radioStationMetaData;
        GeneratedMessageLite.registerDefaultInstance(RadioStationMetaData.class, radioStationMetaData);
    }

    private RadioStationMetaData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAudioChannels() {
        this.bitField0_ &= -2;
        this.audioChannels_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHdStationInfo() {
        this.hdStationInfo_ = null;
        this.bitField0_ &= -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRds() {
        this.rds_ = null;
        this.bitField0_ &= -5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSignalQuality() {
        this.bitField0_ &= -3;
        this.signalQuality_ = 0;
    }

    public static RadioStationMetaData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeHdStationInfo(HdRadioStationInfo hdRadioStationInfo) {
        hdRadioStationInfo.getClass();
        HdRadioStationInfo hdRadioStationInfo2 = this.hdStationInfo_;
        if (hdRadioStationInfo2 == null || hdRadioStationInfo2 == HdRadioStationInfo.getDefaultInstance()) {
            this.hdStationInfo_ = hdRadioStationInfo;
        } else {
            this.hdStationInfo_ = HdRadioStationInfo.newBuilder(this.hdStationInfo_).mergeFrom(hdRadioStationInfo).buildPartial();
        }
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRds(RdsData rdsData) {
        rdsData.getClass();
        RdsData rdsData2 = this.rds_;
        if (rdsData2 == null || rdsData2 == RdsData.getDefaultInstance()) {
            this.rds_ = rdsData;
        } else {
            this.rds_ = RdsData.newBuilder(this.rds_).mergeFrom(rdsData).buildPartial();
        }
        this.bitField0_ |= 4;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static RadioStationMetaData parseDelimitedFrom(InputStream inputStream) {
        return (RadioStationMetaData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RadioStationMetaData parseFrom(ByteBuffer byteBuffer) {
        return (RadioStationMetaData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<RadioStationMetaData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioChannels(int i) {
        this.bitField0_ |= 1;
        this.audioChannels_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHdStationInfo(HdRadioStationInfo hdRadioStationInfo) {
        hdRadioStationInfo.getClass();
        this.hdStationInfo_ = hdRadioStationInfo;
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRds(RdsData rdsData) {
        rdsData.getClass();
        this.rds_ = rdsData;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSignalQuality(int i) {
        this.bitField0_ |= 2;
        this.signalQuality_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RadioStationMetaData();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001\u0004\u0000\u0002\u0004\u0001\u0003\t\u0002\u0004Љ\u0003", new Object[]{"bitField0_", "audioChannels_", "signalQuality_", "rds_", "hdStationInfo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RadioStationMetaData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (RadioStationMetaData.class) {
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

    @Override // fr.sd.taada.proto.RadioStationMetaDataOrBuilder
    public int getAudioChannels() {
        return this.audioChannels_;
    }

    @Override // fr.sd.taada.proto.RadioStationMetaDataOrBuilder
    public HdRadioStationInfo getHdStationInfo() {
        HdRadioStationInfo hdRadioStationInfo = this.hdStationInfo_;
        return hdRadioStationInfo == null ? HdRadioStationInfo.getDefaultInstance() : hdRadioStationInfo;
    }

    @Override // fr.sd.taada.proto.RadioStationMetaDataOrBuilder
    public RdsData getRds() {
        RdsData rdsData = this.rds_;
        return rdsData == null ? RdsData.getDefaultInstance() : rdsData;
    }

    @Override // fr.sd.taada.proto.RadioStationMetaDataOrBuilder
    public int getSignalQuality() {
        return this.signalQuality_;
    }

    @Override // fr.sd.taada.proto.RadioStationMetaDataOrBuilder
    public boolean hasAudioChannels() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.RadioStationMetaDataOrBuilder
    public boolean hasHdStationInfo() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // fr.sd.taada.proto.RadioStationMetaDataOrBuilder
    public boolean hasRds() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.RadioStationMetaDataOrBuilder
    public boolean hasSignalQuality() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(RadioStationMetaData radioStationMetaData) {
        return DEFAULT_INSTANCE.createBuilder(radioStationMetaData);
    }

    public static RadioStationMetaData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioStationMetaData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RadioStationMetaData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioStationMetaData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static RadioStationMetaData parseFrom(ByteString byteString) {
        return (RadioStationMetaData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static RadioStationMetaData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioStationMetaData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHdStationInfo(HdRadioStationInfo.Builder builder) {
        this.hdStationInfo_ = builder.build();
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRds(RdsData.Builder builder) {
        this.rds_ = builder.build();
        this.bitField0_ |= 4;
    }

    public static RadioStationMetaData parseFrom(byte[] bArr) {
        return (RadioStationMetaData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RadioStationMetaData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioStationMetaData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static RadioStationMetaData parseFrom(InputStream inputStream) {
        return (RadioStationMetaData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RadioStationMetaData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioStationMetaData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RadioStationMetaData parseFrom(CodedInputStream codedInputStream) {
        return (RadioStationMetaData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RadioStationMetaData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioStationMetaData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
