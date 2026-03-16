package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.HdRadioPsdData;
import fr.sd.taada.proto.HdRadioSisData;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class HdRadioStationInfo extends GeneratedMessageLite<HdRadioStationInfo, Builder> implements HdRadioStationInfoOrBuilder {
    public static final int ACQUISITION_STATE_FIELD_NUMBER = 1;
    private static final HdRadioStationInfo DEFAULT_INSTANCE;
    public static final int DIGITAL_SIGNAL_STRENGTH_FIELD_NUMBER = 2;
    private static volatile Parser<HdRadioStationInfo> PARSER = null;
    public static final int PSD_FIELD_NUMBER = 3;
    public static final int SIS_FIELD_NUMBER = 4;
    private int acquisitionState_;
    private int bitField0_;
    private int digitalSignalStrength_;
    private byte memoizedIsInitialized = 2;
    private HdRadioPsdData psd_;
    private HdRadioSisData sis_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.HdRadioStationInfo$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<HdRadioStationInfo, Builder> implements HdRadioStationInfoOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAcquisitionState() {
            copyOnWrite();
            ((HdRadioStationInfo) this.instance).clearAcquisitionState();
            return this;
        }

        public Builder clearDigitalSignalStrength() {
            copyOnWrite();
            ((HdRadioStationInfo) this.instance).clearDigitalSignalStrength();
            return this;
        }

        public Builder clearPsd() {
            copyOnWrite();
            ((HdRadioStationInfo) this.instance).clearPsd();
            return this;
        }

        public Builder clearSis() {
            copyOnWrite();
            ((HdRadioStationInfo) this.instance).clearSis();
            return this;
        }

        @Override // fr.sd.taada.proto.HdRadioStationInfoOrBuilder
        public HdAcquisionState getAcquisitionState() {
            return ((HdRadioStationInfo) this.instance).getAcquisitionState();
        }

        @Override // fr.sd.taada.proto.HdRadioStationInfoOrBuilder
        public int getDigitalSignalStrength() {
            return ((HdRadioStationInfo) this.instance).getDigitalSignalStrength();
        }

        @Override // fr.sd.taada.proto.HdRadioStationInfoOrBuilder
        public HdRadioPsdData getPsd() {
            return ((HdRadioStationInfo) this.instance).getPsd();
        }

        @Override // fr.sd.taada.proto.HdRadioStationInfoOrBuilder
        public HdRadioSisData getSis() {
            return ((HdRadioStationInfo) this.instance).getSis();
        }

        @Override // fr.sd.taada.proto.HdRadioStationInfoOrBuilder
        public boolean hasAcquisitionState() {
            return ((HdRadioStationInfo) this.instance).hasAcquisitionState();
        }

        @Override // fr.sd.taada.proto.HdRadioStationInfoOrBuilder
        public boolean hasDigitalSignalStrength() {
            return ((HdRadioStationInfo) this.instance).hasDigitalSignalStrength();
        }

        @Override // fr.sd.taada.proto.HdRadioStationInfoOrBuilder
        public boolean hasPsd() {
            return ((HdRadioStationInfo) this.instance).hasPsd();
        }

        @Override // fr.sd.taada.proto.HdRadioStationInfoOrBuilder
        public boolean hasSis() {
            return ((HdRadioStationInfo) this.instance).hasSis();
        }

        public Builder mergePsd(HdRadioPsdData hdRadioPsdData) {
            copyOnWrite();
            ((HdRadioStationInfo) this.instance).mergePsd(hdRadioPsdData);
            return this;
        }

        public Builder mergeSis(HdRadioSisData hdRadioSisData) {
            copyOnWrite();
            ((HdRadioStationInfo) this.instance).mergeSis(hdRadioSisData);
            return this;
        }

        public Builder setAcquisitionState(HdAcquisionState hdAcquisionState) {
            copyOnWrite();
            ((HdRadioStationInfo) this.instance).setAcquisitionState(hdAcquisionState);
            return this;
        }

        public Builder setDigitalSignalStrength(int i) {
            copyOnWrite();
            ((HdRadioStationInfo) this.instance).setDigitalSignalStrength(i);
            return this;
        }

        public Builder setPsd(HdRadioPsdData hdRadioPsdData) {
            copyOnWrite();
            ((HdRadioStationInfo) this.instance).setPsd(hdRadioPsdData);
            return this;
        }

        public Builder setSis(HdRadioSisData hdRadioSisData) {
            copyOnWrite();
            ((HdRadioStationInfo) this.instance).setSis(hdRadioSisData);
            return this;
        }

        private Builder() {
            super(HdRadioStationInfo.DEFAULT_INSTANCE);
        }

        public Builder setPsd(HdRadioPsdData.Builder builder) {
            copyOnWrite();
            ((HdRadioStationInfo) this.instance).setPsd(builder);
            return this;
        }

        public Builder setSis(HdRadioSisData.Builder builder) {
            copyOnWrite();
            ((HdRadioStationInfo) this.instance).setSis(builder);
            return this;
        }
    }

    static {
        HdRadioStationInfo hdRadioStationInfo = new HdRadioStationInfo();
        DEFAULT_INSTANCE = hdRadioStationInfo;
        GeneratedMessageLite.registerDefaultInstance(HdRadioStationInfo.class, hdRadioStationInfo);
    }

    private HdRadioStationInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAcquisitionState() {
        this.bitField0_ &= -2;
        this.acquisitionState_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDigitalSignalStrength() {
        this.bitField0_ &= -3;
        this.digitalSignalStrength_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPsd() {
        this.psd_ = null;
        this.bitField0_ &= -5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSis() {
        this.sis_ = null;
        this.bitField0_ &= -9;
    }

    public static HdRadioStationInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergePsd(HdRadioPsdData hdRadioPsdData) {
        hdRadioPsdData.getClass();
        HdRadioPsdData hdRadioPsdData2 = this.psd_;
        if (hdRadioPsdData2 == null || hdRadioPsdData2 == HdRadioPsdData.getDefaultInstance()) {
            this.psd_ = hdRadioPsdData;
        } else {
            this.psd_ = HdRadioPsdData.newBuilder(this.psd_).mergeFrom(hdRadioPsdData).buildPartial();
        }
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSis(HdRadioSisData hdRadioSisData) {
        hdRadioSisData.getClass();
        HdRadioSisData hdRadioSisData2 = this.sis_;
        if (hdRadioSisData2 == null || hdRadioSisData2 == HdRadioSisData.getDefaultInstance()) {
            this.sis_ = hdRadioSisData;
        } else {
            this.sis_ = HdRadioSisData.newBuilder(this.sis_).mergeFrom(hdRadioSisData).buildPartial();
        }
        this.bitField0_ |= 8;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static HdRadioStationInfo parseDelimitedFrom(InputStream inputStream) {
        return (HdRadioStationInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HdRadioStationInfo parseFrom(ByteBuffer byteBuffer) {
        return (HdRadioStationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<HdRadioStationInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAcquisitionState(HdAcquisionState hdAcquisionState) {
        hdAcquisionState.getClass();
        this.bitField0_ |= 1;
        this.acquisitionState_ = hdAcquisionState.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDigitalSignalStrength(int i) {
        this.bitField0_ |= 2;
        this.digitalSignalStrength_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPsd(HdRadioPsdData hdRadioPsdData) {
        hdRadioPsdData.getClass();
        this.psd_ = hdRadioPsdData;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSis(HdRadioSisData hdRadioSisData) {
        hdRadioSisData.getClass();
        this.sis_ = hdRadioSisData;
        this.bitField0_ |= 8;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new HdRadioStationInfo();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001\f\u0000\u0002\u0004\u0001\u0003\t\u0002\u0004Љ\u0003", new Object[]{"bitField0_", "acquisitionState_", HdAcquisionState.internalGetVerifier(), "digitalSignalStrength_", "psd_", "sis_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HdRadioStationInfo> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (HdRadioStationInfo.class) {
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

    @Override // fr.sd.taada.proto.HdRadioStationInfoOrBuilder
    public HdAcquisionState getAcquisitionState() {
        HdAcquisionState hdAcquisionStateForNumber = HdAcquisionState.forNumber(this.acquisitionState_);
        return hdAcquisionStateForNumber == null ? HdAcquisionState.ANALOG : hdAcquisionStateForNumber;
    }

    @Override // fr.sd.taada.proto.HdRadioStationInfoOrBuilder
    public int getDigitalSignalStrength() {
        return this.digitalSignalStrength_;
    }

    @Override // fr.sd.taada.proto.HdRadioStationInfoOrBuilder
    public HdRadioPsdData getPsd() {
        HdRadioPsdData hdRadioPsdData = this.psd_;
        return hdRadioPsdData == null ? HdRadioPsdData.getDefaultInstance() : hdRadioPsdData;
    }

    @Override // fr.sd.taada.proto.HdRadioStationInfoOrBuilder
    public HdRadioSisData getSis() {
        HdRadioSisData hdRadioSisData = this.sis_;
        return hdRadioSisData == null ? HdRadioSisData.getDefaultInstance() : hdRadioSisData;
    }

    @Override // fr.sd.taada.proto.HdRadioStationInfoOrBuilder
    public boolean hasAcquisitionState() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.HdRadioStationInfoOrBuilder
    public boolean hasDigitalSignalStrength() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.HdRadioStationInfoOrBuilder
    public boolean hasPsd() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.HdRadioStationInfoOrBuilder
    public boolean hasSis() {
        return (this.bitField0_ & 8) != 0;
    }

    public static Builder newBuilder(HdRadioStationInfo hdRadioStationInfo) {
        return DEFAULT_INSTANCE.createBuilder(hdRadioStationInfo);
    }

    public static HdRadioStationInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioStationInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HdRadioStationInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioStationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static HdRadioStationInfo parseFrom(ByteString byteString) {
        return (HdRadioStationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static HdRadioStationInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioStationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPsd(HdRadioPsdData.Builder builder) {
        this.psd_ = builder.build();
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSis(HdRadioSisData.Builder builder) {
        this.sis_ = builder.build();
        this.bitField0_ |= 8;
    }

    public static HdRadioStationInfo parseFrom(byte[] bArr) {
        return (HdRadioStationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static HdRadioStationInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioStationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static HdRadioStationInfo parseFrom(InputStream inputStream) {
        return (HdRadioStationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HdRadioStationInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioStationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HdRadioStationInfo parseFrom(CodedInputStream codedInputStream) {
        return (HdRadioStationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HdRadioStationInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HdRadioStationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
