package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class NavFocusRequestNotification extends GeneratedMessageLite<NavFocusRequestNotification, Builder> implements NavFocusRequestNotificationOrBuilder {
    private static final NavFocusRequestNotification DEFAULT_INSTANCE;
    public static final int FOCUS_TYPE_FIELD_NUMBER = 1;
    private static volatile Parser<NavFocusRequestNotification> PARSER;
    private int bitField0_;
    private int focusType_ = 1;

    /* JADX INFO: renamed from: fr.sd.taada.proto.NavFocusRequestNotification$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<NavFocusRequestNotification, Builder> implements NavFocusRequestNotificationOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearFocusType() {
            copyOnWrite();
            ((NavFocusRequestNotification) this.instance).clearFocusType();
            return this;
        }

        @Override // fr.sd.taada.proto.NavFocusRequestNotificationOrBuilder
        public NavFocusType getFocusType() {
            return ((NavFocusRequestNotification) this.instance).getFocusType();
        }

        @Override // fr.sd.taada.proto.NavFocusRequestNotificationOrBuilder
        public boolean hasFocusType() {
            return ((NavFocusRequestNotification) this.instance).hasFocusType();
        }

        public Builder setFocusType(NavFocusType navFocusType) {
            copyOnWrite();
            ((NavFocusRequestNotification) this.instance).setFocusType(navFocusType);
            return this;
        }

        private Builder() {
            super(NavFocusRequestNotification.DEFAULT_INSTANCE);
        }
    }

    static {
        NavFocusRequestNotification navFocusRequestNotification = new NavFocusRequestNotification();
        DEFAULT_INSTANCE = navFocusRequestNotification;
        GeneratedMessageLite.registerDefaultInstance(NavFocusRequestNotification.class, navFocusRequestNotification);
    }

    private NavFocusRequestNotification() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFocusType() {
        this.bitField0_ &= -2;
        this.focusType_ = 1;
    }

    public static NavFocusRequestNotification getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static NavFocusRequestNotification parseDelimitedFrom(InputStream inputStream) {
        return (NavFocusRequestNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavFocusRequestNotification parseFrom(ByteBuffer byteBuffer) {
        return (NavFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<NavFocusRequestNotification> parser() {
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
                return new NavFocusRequestNotification();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f\u0000", new Object[]{"bitField0_", "focusType_", NavFocusType.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<NavFocusRequestNotification> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (NavFocusRequestNotification.class) {
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

    @Override // fr.sd.taada.proto.NavFocusRequestNotificationOrBuilder
    public NavFocusType getFocusType() {
        NavFocusType navFocusTypeForNumber = NavFocusType.forNumber(this.focusType_);
        return navFocusTypeForNumber == null ? NavFocusType.NAV_FOCUS_NATIVE : navFocusTypeForNumber;
    }

    @Override // fr.sd.taada.proto.NavFocusRequestNotificationOrBuilder
    public boolean hasFocusType() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(NavFocusRequestNotification navFocusRequestNotification) {
        return DEFAULT_INSTANCE.createBuilder(navFocusRequestNotification);
    }

    public static NavFocusRequestNotification parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavFocusRequestNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavFocusRequestNotification parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (NavFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static NavFocusRequestNotification parseFrom(ByteString byteString) {
        return (NavFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static NavFocusRequestNotification parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (NavFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static NavFocusRequestNotification parseFrom(byte[] bArr) {
        return (NavFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NavFocusRequestNotification parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (NavFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static NavFocusRequestNotification parseFrom(InputStream inputStream) {
        return (NavFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavFocusRequestNotification parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavFocusRequestNotification parseFrom(CodedInputStream codedInputStream) {
        return (NavFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static NavFocusRequestNotification parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavFocusRequestNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
