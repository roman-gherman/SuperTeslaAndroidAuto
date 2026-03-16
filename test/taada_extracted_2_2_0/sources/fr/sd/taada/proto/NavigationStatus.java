package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class NavigationStatus extends GeneratedMessageLite<NavigationStatus, Builder> implements NavigationStatusOrBuilder {
    private static final NavigationStatus DEFAULT_INSTANCE;
    private static volatile Parser<NavigationStatus> PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 1;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int status_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.NavigationStatus$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<NavigationStatus, Builder> implements NavigationStatusOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearStatus() {
            copyOnWrite();
            ((NavigationStatus) this.instance).clearStatus();
            return this;
        }

        @Override // fr.sd.taada.proto.NavigationStatusOrBuilder
        public NavigationStatusEnum getStatus() {
            return ((NavigationStatus) this.instance).getStatus();
        }

        @Override // fr.sd.taada.proto.NavigationStatusOrBuilder
        public boolean hasStatus() {
            return ((NavigationStatus) this.instance).hasStatus();
        }

        public Builder setStatus(NavigationStatusEnum navigationStatusEnum) {
            copyOnWrite();
            ((NavigationStatus) this.instance).setStatus(navigationStatusEnum);
            return this;
        }

        private Builder() {
            super(NavigationStatus.DEFAULT_INSTANCE);
        }
    }

    public enum NavigationStatusEnum implements Internal.EnumLite {
        UNAVAILABLE(0),
        ACTIVE(1),
        INACTIVE(2),
        REROUTING(3);

        public static final int ACTIVE_VALUE = 1;
        public static final int INACTIVE_VALUE = 2;
        public static final int REROUTING_VALUE = 3;
        public static final int UNAVAILABLE_VALUE = 0;
        private static final Internal.EnumLiteMap<NavigationStatusEnum> internalValueMap = new Internal.EnumLiteMap<NavigationStatusEnum>() { // from class: fr.sd.taada.proto.NavigationStatus.NavigationStatusEnum.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public NavigationStatusEnum findValueByNumber(int i) {
                return NavigationStatusEnum.forNumber(i);
            }
        };
        private final int value;

        public static final class NavigationStatusEnumVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new NavigationStatusEnumVerifier();

            private NavigationStatusEnumVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return NavigationStatusEnum.forNumber(i) != null;
            }
        }

        NavigationStatusEnum(int i) {
            this.value = i;
        }

        public static NavigationStatusEnum forNumber(int i) {
            if (i == 0) {
                return UNAVAILABLE;
            }
            if (i == 1) {
                return ACTIVE;
            }
            if (i == 2) {
                return INACTIVE;
            }
            if (i != 3) {
                return null;
            }
            return REROUTING;
        }

        public static Internal.EnumLiteMap<NavigationStatusEnum> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return NavigationStatusEnumVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static NavigationStatusEnum valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        NavigationStatus navigationStatus = new NavigationStatus();
        DEFAULT_INSTANCE = navigationStatus;
        GeneratedMessageLite.registerDefaultInstance(NavigationStatus.class, navigationStatus);
    }

    private NavigationStatus() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.bitField0_ &= -2;
        this.status_ = 0;
    }

    public static NavigationStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static NavigationStatus parseDelimitedFrom(InputStream inputStream) {
        return (NavigationStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationStatus parseFrom(ByteBuffer byteBuffer) {
        return (NavigationStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<NavigationStatus> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(NavigationStatusEnum navigationStatusEnum) {
        navigationStatusEnum.getClass();
        this.bitField0_ |= 1;
        this.status_ = navigationStatusEnum.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new NavigationStatus();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001Ԍ\u0000", new Object[]{"bitField0_", "status_", NavigationStatusEnum.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<NavigationStatus> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (NavigationStatus.class) {
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

    @Override // fr.sd.taada.proto.NavigationStatusOrBuilder
    public NavigationStatusEnum getStatus() {
        NavigationStatusEnum navigationStatusEnumForNumber = NavigationStatusEnum.forNumber(this.status_);
        return navigationStatusEnumForNumber == null ? NavigationStatusEnum.UNAVAILABLE : navigationStatusEnumForNumber;
    }

    @Override // fr.sd.taada.proto.NavigationStatusOrBuilder
    public boolean hasStatus() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(NavigationStatus navigationStatus) {
        return DEFAULT_INSTANCE.createBuilder(navigationStatus);
    }

    public static NavigationStatus parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavigationStatus parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static NavigationStatus parseFrom(ByteString byteString) {
        return (NavigationStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static NavigationStatus parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static NavigationStatus parseFrom(byte[] bArr) {
        return (NavigationStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NavigationStatus parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static NavigationStatus parseFrom(InputStream inputStream) {
        return (NavigationStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationStatus parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavigationStatus parseFrom(CodedInputStream codedInputStream) {
        return (NavigationStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static NavigationStatus parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
