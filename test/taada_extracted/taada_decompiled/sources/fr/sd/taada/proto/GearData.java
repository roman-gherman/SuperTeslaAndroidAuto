package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class GearData extends GeneratedMessageLite<GearData, Builder> implements GearDataOrBuilder {
    private static final GearData DEFAULT_INSTANCE;
    public static final int GEAR_FIELD_NUMBER = 1;
    private static volatile Parser<GearData> PARSER;
    private int bitField0_;
    private int gear_;
    private byte memoizedIsInitialized = 2;

    /* JADX INFO: renamed from: fr.sd.taada.proto.GearData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<GearData, Builder> implements GearDataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearGear() {
            copyOnWrite();
            ((GearData) this.instance).clearGear();
            return this;
        }

        @Override // fr.sd.taada.proto.GearDataOrBuilder
        public Gear getGear() {
            return ((GearData) this.instance).getGear();
        }

        @Override // fr.sd.taada.proto.GearDataOrBuilder
        public boolean hasGear() {
            return ((GearData) this.instance).hasGear();
        }

        public Builder setGear(Gear gear) {
            copyOnWrite();
            ((GearData) this.instance).setGear(gear);
            return this;
        }

        private Builder() {
            super(GearData.DEFAULT_INSTANCE);
        }
    }

    static {
        GearData gearData = new GearData();
        DEFAULT_INSTANCE = gearData;
        GeneratedMessageLite.registerDefaultInstance(GearData.class, gearData);
    }

    private GearData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGear() {
        this.bitField0_ &= -2;
        this.gear_ = 0;
    }

    public static GearData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GearData parseDelimitedFrom(InputStream inputStream) {
        return (GearData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GearData parseFrom(ByteBuffer byteBuffer) {
        return (GearData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GearData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGear(Gear gear) {
        gear.getClass();
        this.bitField0_ |= 1;
        this.gear_ = gear.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GearData();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001Ԍ\u0000", new Object[]{"bitField0_", "gear_", Gear.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GearData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GearData.class) {
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

    @Override // fr.sd.taada.proto.GearDataOrBuilder
    public Gear getGear() {
        Gear gearForNumber = Gear.forNumber(this.gear_);
        return gearForNumber == null ? Gear.GEAR_NEUTRAL : gearForNumber;
    }

    @Override // fr.sd.taada.proto.GearDataOrBuilder
    public boolean hasGear() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(GearData gearData) {
        return DEFAULT_INSTANCE.createBuilder(gearData);
    }

    public static GearData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GearData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GearData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GearData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GearData parseFrom(ByteString byteString) {
        return (GearData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GearData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GearData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GearData parseFrom(byte[] bArr) {
        return (GearData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GearData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GearData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GearData parseFrom(InputStream inputStream) {
        return (GearData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GearData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GearData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GearData parseFrom(CodedInputStream codedInputStream) {
        return (GearData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GearData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GearData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
