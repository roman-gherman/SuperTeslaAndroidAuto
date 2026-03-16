package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class OdometerData extends GeneratedMessageLite<OdometerData, Builder> implements OdometerDataOrBuilder {
    private static final OdometerData DEFAULT_INSTANCE;
    public static final int KMS_E1_FIELD_NUMBER = 1;
    private static volatile Parser<OdometerData> PARSER = null;
    public static final int TRIP_KMS_E1_FIELD_NUMBER = 2;
    private int bitField0_;
    private int kmsE1_;
    private byte memoizedIsInitialized = 2;
    private int tripKmsE1_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.OdometerData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<OdometerData, Builder> implements OdometerDataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearKmsE1() {
            copyOnWrite();
            ((OdometerData) this.instance).clearKmsE1();
            return this;
        }

        public Builder clearTripKmsE1() {
            copyOnWrite();
            ((OdometerData) this.instance).clearTripKmsE1();
            return this;
        }

        @Override // fr.sd.taada.proto.OdometerDataOrBuilder
        public int getKmsE1() {
            return ((OdometerData) this.instance).getKmsE1();
        }

        @Override // fr.sd.taada.proto.OdometerDataOrBuilder
        public int getTripKmsE1() {
            return ((OdometerData) this.instance).getTripKmsE1();
        }

        @Override // fr.sd.taada.proto.OdometerDataOrBuilder
        public boolean hasKmsE1() {
            return ((OdometerData) this.instance).hasKmsE1();
        }

        @Override // fr.sd.taada.proto.OdometerDataOrBuilder
        public boolean hasTripKmsE1() {
            return ((OdometerData) this.instance).hasTripKmsE1();
        }

        public Builder setKmsE1(int i) {
            copyOnWrite();
            ((OdometerData) this.instance).setKmsE1(i);
            return this;
        }

        public Builder setTripKmsE1(int i) {
            copyOnWrite();
            ((OdometerData) this.instance).setTripKmsE1(i);
            return this;
        }

        private Builder() {
            super(OdometerData.DEFAULT_INSTANCE);
        }
    }

    static {
        OdometerData odometerData = new OdometerData();
        DEFAULT_INSTANCE = odometerData;
        GeneratedMessageLite.registerDefaultInstance(OdometerData.class, odometerData);
    }

    private OdometerData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKmsE1() {
        this.bitField0_ &= -2;
        this.kmsE1_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTripKmsE1() {
        this.bitField0_ &= -3;
        this.tripKmsE1_ = 0;
    }

    public static OdometerData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static OdometerData parseDelimitedFrom(InputStream inputStream) {
        return (OdometerData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OdometerData parseFrom(ByteBuffer byteBuffer) {
        return (OdometerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<OdometerData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKmsE1(int i) {
        this.bitField0_ |= 1;
        this.kmsE1_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTripKmsE1(int i) {
        this.bitField0_ |= 2;
        this.tripKmsE1_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new OdometerData();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001Ԅ\u0000\u0002\u0004\u0001", new Object[]{"bitField0_", "kmsE1_", "tripKmsE1_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<OdometerData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (OdometerData.class) {
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

    @Override // fr.sd.taada.proto.OdometerDataOrBuilder
    public int getKmsE1() {
        return this.kmsE1_;
    }

    @Override // fr.sd.taada.proto.OdometerDataOrBuilder
    public int getTripKmsE1() {
        return this.tripKmsE1_;
    }

    @Override // fr.sd.taada.proto.OdometerDataOrBuilder
    public boolean hasKmsE1() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.OdometerDataOrBuilder
    public boolean hasTripKmsE1() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(OdometerData odometerData) {
        return DEFAULT_INSTANCE.createBuilder(odometerData);
    }

    public static OdometerData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (OdometerData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static OdometerData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (OdometerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static OdometerData parseFrom(ByteString byteString) {
        return (OdometerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static OdometerData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (OdometerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static OdometerData parseFrom(byte[] bArr) {
        return (OdometerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static OdometerData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (OdometerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static OdometerData parseFrom(InputStream inputStream) {
        return (OdometerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OdometerData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (OdometerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static OdometerData parseFrom(CodedInputStream codedInputStream) {
        return (OdometerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static OdometerData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (OdometerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
