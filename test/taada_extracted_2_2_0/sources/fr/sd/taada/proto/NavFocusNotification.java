package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class NavFocusNotification extends GeneratedMessageLite<NavFocusNotification, Builder> implements NavFocusNotificationOrBuilder {
    private static final NavFocusNotification DEFAULT_INSTANCE;
    public static final int FOCUS_TYPE_FIELD_NUMBER = 1;
    private static volatile Parser<NavFocusNotification> PARSER;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int focusType_ = 1;

    /* JADX INFO: renamed from: fr.sd.taada.proto.NavFocusNotification$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<NavFocusNotification, Builder> implements NavFocusNotificationOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearFocusType() {
            copyOnWrite();
            ((NavFocusNotification) this.instance).clearFocusType();
            return this;
        }

        @Override // fr.sd.taada.proto.NavFocusNotificationOrBuilder
        public NavFocusType getFocusType() {
            return ((NavFocusNotification) this.instance).getFocusType();
        }

        @Override // fr.sd.taada.proto.NavFocusNotificationOrBuilder
        public boolean hasFocusType() {
            return ((NavFocusNotification) this.instance).hasFocusType();
        }

        public Builder setFocusType(NavFocusType navFocusType) {
            copyOnWrite();
            ((NavFocusNotification) this.instance).setFocusType(navFocusType);
            return this;
        }

        private Builder() {
            super(NavFocusNotification.DEFAULT_INSTANCE);
        }
    }

    static {
        NavFocusNotification navFocusNotification = new NavFocusNotification();
        DEFAULT_INSTANCE = navFocusNotification;
        GeneratedMessageLite.registerDefaultInstance(NavFocusNotification.class, navFocusNotification);
    }

    private NavFocusNotification() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFocusType() {
        this.bitField0_ &= -2;
        this.focusType_ = 1;
    }

    public static NavFocusNotification getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static NavFocusNotification parseDelimitedFrom(InputStream inputStream) {
        return (NavFocusNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavFocusNotification parseFrom(ByteBuffer byteBuffer) {
        return (NavFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<NavFocusNotification> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFocusType(NavFocusType navFocusType) {
        navFocusType.getClass();
        this.bitField0_ |= 1;
        this.focusType_ = navFocusType.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new NavFocusNotification();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001Ԍ\u0000", new Object[]{"bitField0_", "focusType_", NavFocusType.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<NavFocusNotification> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (NavFocusNotification.class) {
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

    @Override // fr.sd.taada.proto.NavFocusNotificationOrBuilder
    public NavFocusType getFocusType() {
        NavFocusType navFocusTypeForNumber = NavFocusType.forNumber(this.focusType_);
        return navFocusTypeForNumber == null ? NavFocusType.NAV_FOCUS_NATIVE : navFocusTypeForNumber;
    }

    @Override // fr.sd.taada.proto.NavFocusNotificationOrBuilder
    public boolean hasFocusType() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(NavFocusNotification navFocusNotification) {
        return DEFAULT_INSTANCE.createBuilder(navFocusNotification);
    }

    public static NavFocusNotification parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavFocusNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavFocusNotification parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (NavFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static NavFocusNotification parseFrom(ByteString byteString) {
        return (NavFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static NavFocusNotification parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (NavFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static NavFocusNotification parseFrom(byte[] bArr) {
        return (NavFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NavFocusNotification parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (NavFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static NavFocusNotification parseFrom(InputStream inputStream) {
        return (NavFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavFocusNotification parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavFocusNotification parseFrom(CodedInputStream codedInputStream) {
        return (NavFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static NavFocusNotification parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavFocusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
