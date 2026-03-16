package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.InputReport;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class GalVerificationInjectInput extends GeneratedMessageLite<GalVerificationInjectInput, Builder> implements GalVerificationInjectInputOrBuilder {
    private static final GalVerificationInjectInput DEFAULT_INSTANCE;
    public static final int INPUT_FIELD_NUMBER = 1;
    private static volatile Parser<GalVerificationInjectInput> PARSER;
    private int bitField0_;
    private InputReport input_;
    private byte memoizedIsInitialized = 2;

    /* JADX INFO: renamed from: fr.sd.taada.proto.GalVerificationInjectInput$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<GalVerificationInjectInput, Builder> implements GalVerificationInjectInputOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearInput() {
            copyOnWrite();
            ((GalVerificationInjectInput) this.instance).clearInput();
            return this;
        }

        @Override // fr.sd.taada.proto.GalVerificationInjectInputOrBuilder
        public InputReport getInput() {
            return ((GalVerificationInjectInput) this.instance).getInput();
        }

        @Override // fr.sd.taada.proto.GalVerificationInjectInputOrBuilder
        public boolean hasInput() {
            return ((GalVerificationInjectInput) this.instance).hasInput();
        }

        public Builder mergeInput(InputReport inputReport) {
            copyOnWrite();
            ((GalVerificationInjectInput) this.instance).mergeInput(inputReport);
            return this;
        }

        public Builder setInput(InputReport inputReport) {
            copyOnWrite();
            ((GalVerificationInjectInput) this.instance).setInput(inputReport);
            return this;
        }

        private Builder() {
            super(GalVerificationInjectInput.DEFAULT_INSTANCE);
        }

        public Builder setInput(InputReport.Builder builder) {
            copyOnWrite();
            ((GalVerificationInjectInput) this.instance).setInput(builder);
            return this;
        }
    }

    static {
        GalVerificationInjectInput galVerificationInjectInput = new GalVerificationInjectInput();
        DEFAULT_INSTANCE = galVerificationInjectInput;
        GeneratedMessageLite.registerDefaultInstance(GalVerificationInjectInput.class, galVerificationInjectInput);
    }

    private GalVerificationInjectInput() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInput() {
        this.input_ = null;
        this.bitField0_ &= -2;
    }

    public static GalVerificationInjectInput getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeInput(InputReport inputReport) {
        inputReport.getClass();
        InputReport inputReport2 = this.input_;
        if (inputReport2 == null || inputReport2 == InputReport.getDefaultInstance()) {
            this.input_ = inputReport;
        } else {
            this.input_ = InputReport.newBuilder(this.input_).mergeFrom(inputReport).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GalVerificationInjectInput parseDelimitedFrom(InputStream inputStream) {
        return (GalVerificationInjectInput) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GalVerificationInjectInput parseFrom(ByteBuffer byteBuffer) {
        return (GalVerificationInjectInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GalVerificationInjectInput> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInput(InputReport inputReport) {
        inputReport.getClass();
        this.input_ = inputReport;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GalVerificationInjectInput();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001ԉ\u0000", new Object[]{"bitField0_", "input_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GalVerificationInjectInput> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GalVerificationInjectInput.class) {
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

    @Override // fr.sd.taada.proto.GalVerificationInjectInputOrBuilder
    public InputReport getInput() {
        InputReport inputReport = this.input_;
        return inputReport == null ? InputReport.getDefaultInstance() : inputReport;
    }

    @Override // fr.sd.taada.proto.GalVerificationInjectInputOrBuilder
    public boolean hasInput() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(GalVerificationInjectInput galVerificationInjectInput) {
        return DEFAULT_INSTANCE.createBuilder(galVerificationInjectInput);
    }

    public static GalVerificationInjectInput parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationInjectInput) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GalVerificationInjectInput parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationInjectInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GalVerificationInjectInput parseFrom(ByteString byteString) {
        return (GalVerificationInjectInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GalVerificationInjectInput parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationInjectInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInput(InputReport.Builder builder) {
        this.input_ = builder.build();
        this.bitField0_ |= 1;
    }

    public static GalVerificationInjectInput parseFrom(byte[] bArr) {
        return (GalVerificationInjectInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GalVerificationInjectInput parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationInjectInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GalVerificationInjectInput parseFrom(InputStream inputStream) {
        return (GalVerificationInjectInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GalVerificationInjectInput parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationInjectInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GalVerificationInjectInput parseFrom(CodedInputStream codedInputStream) {
        return (GalVerificationInjectInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GalVerificationInjectInput parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationInjectInput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
