package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class RpmData extends GeneratedMessageLite<RpmData, Builder> implements RpmDataOrBuilder {
    private static final RpmData DEFAULT_INSTANCE;
    private static volatile Parser<RpmData> PARSER = null;
    public static final int RPM_E3_FIELD_NUMBER = 1;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int rpmE3_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.RpmData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<RpmData, Builder> implements RpmDataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearRpmE3() {
            copyOnWrite();
            ((RpmData) this.instance).clearRpmE3();
            return this;
        }

        @Override // fr.sd.taada.proto.RpmDataOrBuilder
        public int getRpmE3() {
            return ((RpmData) this.instance).getRpmE3();
        }

        @Override // fr.sd.taada.proto.RpmDataOrBuilder
        public boolean hasRpmE3() {
            return ((RpmData) this.instance).hasRpmE3();
        }

        public Builder setRpmE3(int i) {
            copyOnWrite();
            ((RpmData) this.instance).setRpmE3(i);
            return this;
        }

        private Builder() {
            super(RpmData.DEFAULT_INSTANCE);
        }
    }

    static {
        RpmData rpmData = new RpmData();
        DEFAULT_INSTANCE = rpmData;
        GeneratedMessageLite.registerDefaultInstance(RpmData.class, rpmData);
    }

    private RpmData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRpmE3() {
        this.bitField0_ &= -2;
        this.rpmE3_ = 0;
    }

    public static RpmData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static RpmData parseDelimitedFrom(InputStream inputStream) {
        return (RpmData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RpmData parseFrom(ByteBuffer byteBuffer) {
        return (RpmData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<RpmData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRpmE3(int i) {
        this.bitField0_ |= 1;
        this.rpmE3_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RpmData();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001Ԅ\u0000", new Object[]{"bitField0_", "rpmE3_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RpmData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (RpmData.class) {
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

    @Override // fr.sd.taada.proto.RpmDataOrBuilder
    public int getRpmE3() {
        return this.rpmE3_;
    }

    @Override // fr.sd.taada.proto.RpmDataOrBuilder
    public boolean hasRpmE3() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(RpmData rpmData) {
        return DEFAULT_INSTANCE.createBuilder(rpmData);
    }

    public static RpmData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RpmData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RpmData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (RpmData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static RpmData parseFrom(ByteString byteString) {
        return (RpmData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static RpmData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (RpmData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static RpmData parseFrom(byte[] bArr) {
        return (RpmData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RpmData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (RpmData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static RpmData parseFrom(InputStream inputStream) {
        return (RpmData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RpmData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RpmData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RpmData parseFrom(CodedInputStream codedInputStream) {
        return (RpmData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RpmData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RpmData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
