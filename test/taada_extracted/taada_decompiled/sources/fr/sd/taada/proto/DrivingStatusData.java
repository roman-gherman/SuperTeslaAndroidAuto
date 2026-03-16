package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class DrivingStatusData extends GeneratedMessageLite<DrivingStatusData, Builder> implements DrivingStatusDataOrBuilder {
    private static final DrivingStatusData DEFAULT_INSTANCE;
    private static volatile Parser<DrivingStatusData> PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 1;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int status_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.DrivingStatusData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<DrivingStatusData, Builder> implements DrivingStatusDataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearStatus() {
            copyOnWrite();
            ((DrivingStatusData) this.instance).clearStatus();
            return this;
        }

        @Override // fr.sd.taada.proto.DrivingStatusDataOrBuilder
        public int getStatus() {
            return ((DrivingStatusData) this.instance).getStatus();
        }

        @Override // fr.sd.taada.proto.DrivingStatusDataOrBuilder
        public boolean hasStatus() {
            return ((DrivingStatusData) this.instance).hasStatus();
        }

        public Builder setStatus(int i) {
            copyOnWrite();
            ((DrivingStatusData) this.instance).setStatus(i);
            return this;
        }

        private Builder() {
            super(DrivingStatusData.DEFAULT_INSTANCE);
        }
    }

    static {
        DrivingStatusData drivingStatusData = new DrivingStatusData();
        DEFAULT_INSTANCE = drivingStatusData;
        GeneratedMessageLite.registerDefaultInstance(DrivingStatusData.class, drivingStatusData);
    }

    private DrivingStatusData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.bitField0_ &= -2;
        this.status_ = 0;
    }

    public static DrivingStatusData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static DrivingStatusData parseDelimitedFrom(InputStream inputStream) {
        return (DrivingStatusData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DrivingStatusData parseFrom(ByteBuffer byteBuffer) {
        return (DrivingStatusData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<DrivingStatusData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(int i) {
        this.bitField0_ |= 1;
        this.status_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new DrivingStatusData();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001Ԅ\u0000", new Object[]{"bitField0_", "status_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<DrivingStatusData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (DrivingStatusData.class) {
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

    @Override // fr.sd.taada.proto.DrivingStatusDataOrBuilder
    public int getStatus() {
        return this.status_;
    }

    @Override // fr.sd.taada.proto.DrivingStatusDataOrBuilder
    public boolean hasStatus() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(DrivingStatusData drivingStatusData) {
        return DEFAULT_INSTANCE.createBuilder(drivingStatusData);
    }

    public static DrivingStatusData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DrivingStatusData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DrivingStatusData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DrivingStatusData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static DrivingStatusData parseFrom(ByteString byteString) {
        return (DrivingStatusData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static DrivingStatusData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DrivingStatusData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DrivingStatusData parseFrom(byte[] bArr) {
        return (DrivingStatusData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DrivingStatusData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (DrivingStatusData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static DrivingStatusData parseFrom(InputStream inputStream) {
        return (DrivingStatusData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DrivingStatusData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DrivingStatusData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DrivingStatusData parseFrom(CodedInputStream codedInputStream) {
        return (DrivingStatusData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DrivingStatusData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DrivingStatusData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
