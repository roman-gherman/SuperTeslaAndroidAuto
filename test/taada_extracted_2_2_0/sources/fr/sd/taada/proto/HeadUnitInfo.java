package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class HeadUnitInfo extends GeneratedMessageLite<HeadUnitInfo, Builder> implements HeadUnitInfoOrBuilder {
    private static final HeadUnitInfo DEFAULT_INSTANCE;
    public static final int HEAD_UNIT_MAKE_FIELD_NUMBER = 5;
    public static final int HEAD_UNIT_MODEL_FIELD_NUMBER = 6;
    public static final int HEAD_UNIT_SOFTWARE_BUILD_FIELD_NUMBER = 7;
    public static final int HEAD_UNIT_SOFTWARE_VERSION_FIELD_NUMBER = 8;
    public static final int MAKE_FIELD_NUMBER = 1;
    public static final int MODEL_FIELD_NUMBER = 2;
    private static volatile Parser<HeadUnitInfo> PARSER = null;
    public static final int VEHICLE_ID_FIELD_NUMBER = 4;
    public static final int YEAR_FIELD_NUMBER = 3;
    private int bitField0_;
    private String make_ = "";
    private String model_ = "";
    private String year_ = "";
    private String vehicleId_ = "";
    private String headUnitMake_ = "";
    private String headUnitModel_ = "";
    private String headUnitSoftwareBuild_ = "";
    private String headUnitSoftwareVersion_ = "";

    /* JADX INFO: renamed from: fr.sd.taada.proto.HeadUnitInfo$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<HeadUnitInfo, Builder> implements HeadUnitInfoOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearHeadUnitMake() {
            copyOnWrite();
            ((HeadUnitInfo) this.instance).clearHeadUnitMake();
            return this;
        }

        public Builder clearHeadUnitModel() {
            copyOnWrite();
            ((HeadUnitInfo) this.instance).clearHeadUnitModel();
            return this;
        }

        public Builder clearHeadUnitSoftwareBuild() {
            copyOnWrite();
            ((HeadUnitInfo) this.instance).clearHeadUnitSoftwareBuild();
            return this;
        }

        public Builder clearHeadUnitSoftwareVersion() {
            copyOnWrite();
            ((HeadUnitInfo) this.instance).clearHeadUnitSoftwareVersion();
            return this;
        }

        public Builder clearMake() {
            copyOnWrite();
            ((HeadUnitInfo) this.instance).clearMake();
            return this;
        }

        public Builder clearModel() {
            copyOnWrite();
            ((HeadUnitInfo) this.instance).clearModel();
            return this;
        }

        public Builder clearVehicleId() {
            copyOnWrite();
            ((HeadUnitInfo) this.instance).clearVehicleId();
            return this;
        }

        public Builder clearYear() {
            copyOnWrite();
            ((HeadUnitInfo) this.instance).clearYear();
            return this;
        }

        @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
        public String getHeadUnitMake() {
            return ((HeadUnitInfo) this.instance).getHeadUnitMake();
        }

        @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
        public ByteString getHeadUnitMakeBytes() {
            return ((HeadUnitInfo) this.instance).getHeadUnitMakeBytes();
        }

        @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
        public String getHeadUnitModel() {
            return ((HeadUnitInfo) this.instance).getHeadUnitModel();
        }

        @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
        public ByteString getHeadUnitModelBytes() {
            return ((HeadUnitInfo) this.instance).getHeadUnitModelBytes();
        }

        @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
        public String getHeadUnitSoftwareBuild() {
            return ((HeadUnitInfo) this.instance).getHeadUnitSoftwareBuild();
        }

        @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
        public ByteString getHeadUnitSoftwareBuildBytes() {
            return ((HeadUnitInfo) this.instance).getHeadUnitSoftwareBuildBytes();
        }

        @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
        public String getHeadUnitSoftwareVersion() {
            return ((HeadUnitInfo) this.instance).getHeadUnitSoftwareVersion();
        }

        @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
        public ByteString getHeadUnitSoftwareVersionBytes() {
            return ((HeadUnitInfo) this.instance).getHeadUnitSoftwareVersionBytes();
        }

        @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
        public String getMake() {
            return ((HeadUnitInfo) this.instance).getMake();
        }

        @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
        public ByteString getMakeBytes() {
            return ((HeadUnitInfo) this.instance).getMakeBytes();
        }

        @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
        public String getModel() {
            return ((HeadUnitInfo) this.instance).getModel();
        }

        @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
        public ByteString getModelBytes() {
            return ((HeadUnitInfo) this.instance).getModelBytes();
        }

        @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
        public String getVehicleId() {
            return ((HeadUnitInfo) this.instance).getVehicleId();
        }

        @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
        public ByteString getVehicleIdBytes() {
            return ((HeadUnitInfo) this.instance).getVehicleIdBytes();
        }

        @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
        public String getYear() {
            return ((HeadUnitInfo) this.instance).getYear();
        }

        @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
        public ByteString getYearBytes() {
            return ((HeadUnitInfo) this.instance).getYearBytes();
        }

        @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
        public boolean hasHeadUnitMake() {
            return ((HeadUnitInfo) this.instance).hasHeadUnitMake();
        }

        @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
        public boolean hasHeadUnitModel() {
            return ((HeadUnitInfo) this.instance).hasHeadUnitModel();
        }

        @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
        public boolean hasHeadUnitSoftwareBuild() {
            return ((HeadUnitInfo) this.instance).hasHeadUnitSoftwareBuild();
        }

        @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
        public boolean hasHeadUnitSoftwareVersion() {
            return ((HeadUnitInfo) this.instance).hasHeadUnitSoftwareVersion();
        }

        @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
        public boolean hasMake() {
            return ((HeadUnitInfo) this.instance).hasMake();
        }

        @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
        public boolean hasModel() {
            return ((HeadUnitInfo) this.instance).hasModel();
        }

        @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
        public boolean hasVehicleId() {
            return ((HeadUnitInfo) this.instance).hasVehicleId();
        }

        @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
        public boolean hasYear() {
            return ((HeadUnitInfo) this.instance).hasYear();
        }

        public Builder setHeadUnitMake(String str) {
            copyOnWrite();
            ((HeadUnitInfo) this.instance).setHeadUnitMake(str);
            return this;
        }

        public Builder setHeadUnitMakeBytes(ByteString byteString) {
            copyOnWrite();
            ((HeadUnitInfo) this.instance).setHeadUnitMakeBytes(byteString);
            return this;
        }

        public Builder setHeadUnitModel(String str) {
            copyOnWrite();
            ((HeadUnitInfo) this.instance).setHeadUnitModel(str);
            return this;
        }

        public Builder setHeadUnitModelBytes(ByteString byteString) {
            copyOnWrite();
            ((HeadUnitInfo) this.instance).setHeadUnitModelBytes(byteString);
            return this;
        }

        public Builder setHeadUnitSoftwareBuild(String str) {
            copyOnWrite();
            ((HeadUnitInfo) this.instance).setHeadUnitSoftwareBuild(str);
            return this;
        }

        public Builder setHeadUnitSoftwareBuildBytes(ByteString byteString) {
            copyOnWrite();
            ((HeadUnitInfo) this.instance).setHeadUnitSoftwareBuildBytes(byteString);
            return this;
        }

        public Builder setHeadUnitSoftwareVersion(String str) {
            copyOnWrite();
            ((HeadUnitInfo) this.instance).setHeadUnitSoftwareVersion(str);
            return this;
        }

        public Builder setHeadUnitSoftwareVersionBytes(ByteString byteString) {
            copyOnWrite();
            ((HeadUnitInfo) this.instance).setHeadUnitSoftwareVersionBytes(byteString);
            return this;
        }

        public Builder setMake(String str) {
            copyOnWrite();
            ((HeadUnitInfo) this.instance).setMake(str);
            return this;
        }

        public Builder setMakeBytes(ByteString byteString) {
            copyOnWrite();
            ((HeadUnitInfo) this.instance).setMakeBytes(byteString);
            return this;
        }

        public Builder setModel(String str) {
            copyOnWrite();
            ((HeadUnitInfo) this.instance).setModel(str);
            return this;
        }

        public Builder setModelBytes(ByteString byteString) {
            copyOnWrite();
            ((HeadUnitInfo) this.instance).setModelBytes(byteString);
            return this;
        }

        public Builder setVehicleId(String str) {
            copyOnWrite();
            ((HeadUnitInfo) this.instance).setVehicleId(str);
            return this;
        }

        public Builder setVehicleIdBytes(ByteString byteString) {
            copyOnWrite();
            ((HeadUnitInfo) this.instance).setVehicleIdBytes(byteString);
            return this;
        }

        public Builder setYear(String str) {
            copyOnWrite();
            ((HeadUnitInfo) this.instance).setYear(str);
            return this;
        }

        public Builder setYearBytes(ByteString byteString) {
            copyOnWrite();
            ((HeadUnitInfo) this.instance).setYearBytes(byteString);
            return this;
        }

        private Builder() {
            super(HeadUnitInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        HeadUnitInfo headUnitInfo = new HeadUnitInfo();
        DEFAULT_INSTANCE = headUnitInfo;
        GeneratedMessageLite.registerDefaultInstance(HeadUnitInfo.class, headUnitInfo);
    }

    private HeadUnitInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHeadUnitMake() {
        this.bitField0_ &= -17;
        this.headUnitMake_ = getDefaultInstance().getHeadUnitMake();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHeadUnitModel() {
        this.bitField0_ &= -33;
        this.headUnitModel_ = getDefaultInstance().getHeadUnitModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHeadUnitSoftwareBuild() {
        this.bitField0_ &= -65;
        this.headUnitSoftwareBuild_ = getDefaultInstance().getHeadUnitSoftwareBuild();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHeadUnitSoftwareVersion() {
        this.bitField0_ &= -129;
        this.headUnitSoftwareVersion_ = getDefaultInstance().getHeadUnitSoftwareVersion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMake() {
        this.bitField0_ &= -2;
        this.make_ = getDefaultInstance().getMake();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearModel() {
        this.bitField0_ &= -3;
        this.model_ = getDefaultInstance().getModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVehicleId() {
        this.bitField0_ &= -9;
        this.vehicleId_ = getDefaultInstance().getVehicleId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearYear() {
        this.bitField0_ &= -5;
        this.year_ = getDefaultInstance().getYear();
    }

    public static HeadUnitInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static HeadUnitInfo parseDelimitedFrom(InputStream inputStream) {
        return (HeadUnitInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HeadUnitInfo parseFrom(ByteBuffer byteBuffer) {
        return (HeadUnitInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<HeadUnitInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeadUnitMake(String str) {
        str.getClass();
        this.bitField0_ |= 16;
        this.headUnitMake_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeadUnitMakeBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 16;
        this.headUnitMake_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeadUnitModel(String str) {
        str.getClass();
        this.bitField0_ |= 32;
        this.headUnitModel_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeadUnitModelBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 32;
        this.headUnitModel_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeadUnitSoftwareBuild(String str) {
        str.getClass();
        this.bitField0_ |= 64;
        this.headUnitSoftwareBuild_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeadUnitSoftwareBuildBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 64;
        this.headUnitSoftwareBuild_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeadUnitSoftwareVersion(String str) {
        str.getClass();
        this.bitField0_ |= 128;
        this.headUnitSoftwareVersion_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeadUnitSoftwareVersionBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 128;
        this.headUnitSoftwareVersion_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMake(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.make_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMakeBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.make_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModel(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.model_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModelBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 2;
        this.model_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVehicleId(String str) {
        str.getClass();
        this.bitField0_ |= 8;
        this.vehicleId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVehicleIdBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 8;
        this.vehicleId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setYear(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.year_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setYearBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 4;
        this.year_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new HeadUnitInfo();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\b\u0007", new Object[]{"bitField0_", "make_", "model_", "year_", "vehicleId_", "headUnitMake_", "headUnitModel_", "headUnitSoftwareBuild_", "headUnitSoftwareVersion_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HeadUnitInfo> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (HeadUnitInfo.class) {
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
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
    public String getHeadUnitMake() {
        return this.headUnitMake_;
    }

    @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
    public ByteString getHeadUnitMakeBytes() {
        return ByteString.copyFromUtf8(this.headUnitMake_);
    }

    @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
    public String getHeadUnitModel() {
        return this.headUnitModel_;
    }

    @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
    public ByteString getHeadUnitModelBytes() {
        return ByteString.copyFromUtf8(this.headUnitModel_);
    }

    @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
    public String getHeadUnitSoftwareBuild() {
        return this.headUnitSoftwareBuild_;
    }

    @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
    public ByteString getHeadUnitSoftwareBuildBytes() {
        return ByteString.copyFromUtf8(this.headUnitSoftwareBuild_);
    }

    @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
    public String getHeadUnitSoftwareVersion() {
        return this.headUnitSoftwareVersion_;
    }

    @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
    public ByteString getHeadUnitSoftwareVersionBytes() {
        return ByteString.copyFromUtf8(this.headUnitSoftwareVersion_);
    }

    @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
    public String getMake() {
        return this.make_;
    }

    @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
    public ByteString getMakeBytes() {
        return ByteString.copyFromUtf8(this.make_);
    }

    @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
    public String getModel() {
        return this.model_;
    }

    @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
    public ByteString getModelBytes() {
        return ByteString.copyFromUtf8(this.model_);
    }

    @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
    public String getVehicleId() {
        return this.vehicleId_;
    }

    @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
    public ByteString getVehicleIdBytes() {
        return ByteString.copyFromUtf8(this.vehicleId_);
    }

    @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
    public String getYear() {
        return this.year_;
    }

    @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
    public ByteString getYearBytes() {
        return ByteString.copyFromUtf8(this.year_);
    }

    @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
    public boolean hasHeadUnitMake() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
    public boolean hasHeadUnitModel() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
    public boolean hasHeadUnitSoftwareBuild() {
        return (this.bitField0_ & 64) != 0;
    }

    @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
    public boolean hasHeadUnitSoftwareVersion() {
        return (this.bitField0_ & 128) != 0;
    }

    @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
    public boolean hasMake() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
    public boolean hasModel() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
    public boolean hasVehicleId() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // fr.sd.taada.proto.HeadUnitInfoOrBuilder
    public boolean hasYear() {
        return (this.bitField0_ & 4) != 0;
    }

    public static Builder newBuilder(HeadUnitInfo headUnitInfo) {
        return DEFAULT_INSTANCE.createBuilder(headUnitInfo);
    }

    public static HeadUnitInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HeadUnitInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HeadUnitInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (HeadUnitInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static HeadUnitInfo parseFrom(ByteString byteString) {
        return (HeadUnitInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static HeadUnitInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (HeadUnitInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static HeadUnitInfo parseFrom(byte[] bArr) {
        return (HeadUnitInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static HeadUnitInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (HeadUnitInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static HeadUnitInfo parseFrom(InputStream inputStream) {
        return (HeadUnitInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HeadUnitInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HeadUnitInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HeadUnitInfo parseFrom(CodedInputStream codedInputStream) {
        return (HeadUnitInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HeadUnitInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HeadUnitInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
