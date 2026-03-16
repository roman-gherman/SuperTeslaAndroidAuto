package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class GpsSatellite extends GeneratedMessageLite<GpsSatellite, Builder> implements GpsSatelliteOrBuilder {
    public static final int AZIMUTH_E3_FIELD_NUMBER = 4;
    private static final GpsSatellite DEFAULT_INSTANCE;
    public static final int ELEVATION_E3_FIELD_NUMBER = 5;
    private static volatile Parser<GpsSatellite> PARSER = null;
    public static final int PRN_FIELD_NUMBER = 1;
    public static final int SNR_E3_FIELD_NUMBER = 2;
    public static final int USED_IN_FIX_FIELD_NUMBER = 3;
    private int azimuthE3_;
    private int bitField0_;
    private int elevationE3_;
    private byte memoizedIsInitialized = 2;
    private int prn_;
    private int snrE3_;
    private boolean usedInFix_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.GpsSatellite$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<GpsSatellite, Builder> implements GpsSatelliteOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAzimuthE3() {
            copyOnWrite();
            ((GpsSatellite) this.instance).clearAzimuthE3();
            return this;
        }

        public Builder clearElevationE3() {
            copyOnWrite();
            ((GpsSatellite) this.instance).clearElevationE3();
            return this;
        }

        public Builder clearPrn() {
            copyOnWrite();
            ((GpsSatellite) this.instance).clearPrn();
            return this;
        }

        public Builder clearSnrE3() {
            copyOnWrite();
            ((GpsSatellite) this.instance).clearSnrE3();
            return this;
        }

        public Builder clearUsedInFix() {
            copyOnWrite();
            ((GpsSatellite) this.instance).clearUsedInFix();
            return this;
        }

        @Override // fr.sd.taada.proto.GpsSatelliteOrBuilder
        public int getAzimuthE3() {
            return ((GpsSatellite) this.instance).getAzimuthE3();
        }

        @Override // fr.sd.taada.proto.GpsSatelliteOrBuilder
        public int getElevationE3() {
            return ((GpsSatellite) this.instance).getElevationE3();
        }

        @Override // fr.sd.taada.proto.GpsSatelliteOrBuilder
        public int getPrn() {
            return ((GpsSatellite) this.instance).getPrn();
        }

        @Override // fr.sd.taada.proto.GpsSatelliteOrBuilder
        public int getSnrE3() {
            return ((GpsSatellite) this.instance).getSnrE3();
        }

        @Override // fr.sd.taada.proto.GpsSatelliteOrBuilder
        public boolean getUsedInFix() {
            return ((GpsSatellite) this.instance).getUsedInFix();
        }

        @Override // fr.sd.taada.proto.GpsSatelliteOrBuilder
        public boolean hasAzimuthE3() {
            return ((GpsSatellite) this.instance).hasAzimuthE3();
        }

        @Override // fr.sd.taada.proto.GpsSatelliteOrBuilder
        public boolean hasElevationE3() {
            return ((GpsSatellite) this.instance).hasElevationE3();
        }

        @Override // fr.sd.taada.proto.GpsSatelliteOrBuilder
        public boolean hasPrn() {
            return ((GpsSatellite) this.instance).hasPrn();
        }

        @Override // fr.sd.taada.proto.GpsSatelliteOrBuilder
        public boolean hasSnrE3() {
            return ((GpsSatellite) this.instance).hasSnrE3();
        }

        @Override // fr.sd.taada.proto.GpsSatelliteOrBuilder
        public boolean hasUsedInFix() {
            return ((GpsSatellite) this.instance).hasUsedInFix();
        }

        public Builder setAzimuthE3(int i) {
            copyOnWrite();
            ((GpsSatellite) this.instance).setAzimuthE3(i);
            return this;
        }

        public Builder setElevationE3(int i) {
            copyOnWrite();
            ((GpsSatellite) this.instance).setElevationE3(i);
            return this;
        }

        public Builder setPrn(int i) {
            copyOnWrite();
            ((GpsSatellite) this.instance).setPrn(i);
            return this;
        }

        public Builder setSnrE3(int i) {
            copyOnWrite();
            ((GpsSatellite) this.instance).setSnrE3(i);
            return this;
        }

        public Builder setUsedInFix(boolean z6) {
            copyOnWrite();
            ((GpsSatellite) this.instance).setUsedInFix(z6);
            return this;
        }

        private Builder() {
            super(GpsSatellite.DEFAULT_INSTANCE);
        }
    }

    static {
        GpsSatellite gpsSatellite = new GpsSatellite();
        DEFAULT_INSTANCE = gpsSatellite;
        GeneratedMessageLite.registerDefaultInstance(GpsSatellite.class, gpsSatellite);
    }

    private GpsSatellite() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAzimuthE3() {
        this.bitField0_ &= -9;
        this.azimuthE3_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearElevationE3() {
        this.bitField0_ &= -17;
        this.elevationE3_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPrn() {
        this.bitField0_ &= -2;
        this.prn_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSnrE3() {
        this.bitField0_ &= -3;
        this.snrE3_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUsedInFix() {
        this.bitField0_ &= -5;
        this.usedInFix_ = false;
    }

    public static GpsSatellite getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GpsSatellite parseDelimitedFrom(InputStream inputStream) {
        return (GpsSatellite) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GpsSatellite parseFrom(ByteBuffer byteBuffer) {
        return (GpsSatellite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GpsSatellite> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAzimuthE3(int i) {
        this.bitField0_ |= 8;
        this.azimuthE3_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setElevationE3(int i) {
        this.bitField0_ |= 16;
        this.elevationE3_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPrn(int i) {
        this.bitField0_ |= 1;
        this.prn_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSnrE3(int i) {
        this.bitField0_ |= 2;
        this.snrE3_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUsedInFix(boolean z6) {
        this.bitField0_ |= 4;
        this.usedInFix_ = z6;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GpsSatellite();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0003\u0001Ԅ\u0000\u0002Ԅ\u0001\u0003ԇ\u0002\u0004\u0004\u0003\u0005\u0004\u0004", new Object[]{"bitField0_", "prn_", "snrE3_", "usedInFix_", "azimuthE3_", "elevationE3_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GpsSatellite> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GpsSatellite.class) {
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

    @Override // fr.sd.taada.proto.GpsSatelliteOrBuilder
    public int getAzimuthE3() {
        return this.azimuthE3_;
    }

    @Override // fr.sd.taada.proto.GpsSatelliteOrBuilder
    public int getElevationE3() {
        return this.elevationE3_;
    }

    @Override // fr.sd.taada.proto.GpsSatelliteOrBuilder
    public int getPrn() {
        return this.prn_;
    }

    @Override // fr.sd.taada.proto.GpsSatelliteOrBuilder
    public int getSnrE3() {
        return this.snrE3_;
    }

    @Override // fr.sd.taada.proto.GpsSatelliteOrBuilder
    public boolean getUsedInFix() {
        return this.usedInFix_;
    }

    @Override // fr.sd.taada.proto.GpsSatelliteOrBuilder
    public boolean hasAzimuthE3() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // fr.sd.taada.proto.GpsSatelliteOrBuilder
    public boolean hasElevationE3() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // fr.sd.taada.proto.GpsSatelliteOrBuilder
    public boolean hasPrn() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.GpsSatelliteOrBuilder
    public boolean hasSnrE3() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.GpsSatelliteOrBuilder
    public boolean hasUsedInFix() {
        return (this.bitField0_ & 4) != 0;
    }

    public static Builder newBuilder(GpsSatellite gpsSatellite) {
        return DEFAULT_INSTANCE.createBuilder(gpsSatellite);
    }

    public static GpsSatellite parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GpsSatellite) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GpsSatellite parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GpsSatellite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GpsSatellite parseFrom(ByteString byteString) {
        return (GpsSatellite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GpsSatellite parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GpsSatellite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GpsSatellite parseFrom(byte[] bArr) {
        return (GpsSatellite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GpsSatellite parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GpsSatellite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GpsSatellite parseFrom(InputStream inputStream) {
        return (GpsSatellite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GpsSatellite parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GpsSatellite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GpsSatellite parseFrom(CodedInputStream codedInputStream) {
        return (GpsSatellite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GpsSatellite parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GpsSatellite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
