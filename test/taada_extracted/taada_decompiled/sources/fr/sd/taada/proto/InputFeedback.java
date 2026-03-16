package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class InputFeedback extends GeneratedMessageLite<InputFeedback, Builder> implements InputFeedbackOrBuilder {
    private static final InputFeedback DEFAULT_INSTANCE;
    public static final int EVENT_FIELD_NUMBER = 1;
    private static volatile Parser<InputFeedback> PARSER;
    private int bitField0_;
    private int event_ = 1;

    /* JADX INFO: renamed from: fr.sd.taada.proto.InputFeedback$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<InputFeedback, Builder> implements InputFeedbackOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearEvent() {
            copyOnWrite();
            ((InputFeedback) this.instance).clearEvent();
            return this;
        }

        @Override // fr.sd.taada.proto.InputFeedbackOrBuilder
        public FeedbackEvent getEvent() {
            return ((InputFeedback) this.instance).getEvent();
        }

        @Override // fr.sd.taada.proto.InputFeedbackOrBuilder
        public boolean hasEvent() {
            return ((InputFeedback) this.instance).hasEvent();
        }

        public Builder setEvent(FeedbackEvent feedbackEvent) {
            copyOnWrite();
            ((InputFeedback) this.instance).setEvent(feedbackEvent);
            return this;
        }

        private Builder() {
            super(InputFeedback.DEFAULT_INSTANCE);
        }
    }

    static {
        InputFeedback inputFeedback = new InputFeedback();
        DEFAULT_INSTANCE = inputFeedback;
        GeneratedMessageLite.registerDefaultInstance(InputFeedback.class, inputFeedback);
    }

    private InputFeedback() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEvent() {
        this.bitField0_ &= -2;
        this.event_ = 1;
    }

    public static InputFeedback getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static InputFeedback parseDelimitedFrom(InputStream inputStream) {
        return (InputFeedback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static InputFeedback parseFrom(ByteBuffer byteBuffer) {
        return (InputFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<InputFeedback> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEvent(FeedbackEvent feedbackEvent) {
        feedbackEvent.getClass();
        this.bitField0_ |= 1;
        this.event_ = feedbackEvent.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new InputFeedback();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f\u0000", new Object[]{"bitField0_", "event_", FeedbackEvent.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<InputFeedback> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (InputFeedback.class) {
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

    @Override // fr.sd.taada.proto.InputFeedbackOrBuilder
    public FeedbackEvent getEvent() {
        FeedbackEvent feedbackEventForNumber = FeedbackEvent.forNumber(this.event_);
        return feedbackEventForNumber == null ? FeedbackEvent.FEEDBACK_SELECT : feedbackEventForNumber;
    }

    @Override // fr.sd.taada.proto.InputFeedbackOrBuilder
    public boolean hasEvent() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(InputFeedback inputFeedback) {
        return DEFAULT_INSTANCE.createBuilder(inputFeedback);
    }

    public static InputFeedback parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (InputFeedback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static InputFeedback parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (InputFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static InputFeedback parseFrom(ByteString byteString) {
        return (InputFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static InputFeedback parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (InputFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static InputFeedback parseFrom(byte[] bArr) {
        return (InputFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static InputFeedback parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (InputFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static InputFeedback parseFrom(InputStream inputStream) {
        return (InputFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static InputFeedback parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (InputFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static InputFeedback parseFrom(CodedInputStream codedInputStream) {
        return (InputFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static InputFeedback parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (InputFeedback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
