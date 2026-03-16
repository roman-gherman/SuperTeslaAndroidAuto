package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class Range extends GeneratedMessageLite<Range, Builder> implements RangeOrBuilder {
    private static final Range DEFAULT_INSTANCE;
    public static final int MAX_FIELD_NUMBER = 2;
    public static final int MIN_FIELD_NUMBER = 1;
    private static volatile Parser<Range> PARSER;
    private int bitField0_;
    private int max_;
    private byte memoizedIsInitialized = 2;
    private int min_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.Range$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<Range, Builder> implements RangeOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearMax() {
            copyOnWrite();
            ((Range) this.instance).clearMax();
            return this;
        }

        public Builder clearMin() {
            copyOnWrite();
            ((Range) this.instance).clearMin();
            return this;
        }

        @Override // fr.sd.taada.proto.RangeOrBuilder
        public int getMax() {
            return ((Range) this.instance).getMax();
        }

        @Override // fr.sd.taada.proto.RangeOrBuilder
        public int getMin() {
            return ((Range) this.instance).getMin();
        }

        @Override // fr.sd.taada.proto.RangeOrBuilder
        public boolean hasMax() {
            return ((Range) this.instance).hasMax();
        }

        @Override // fr.sd.taada.proto.RangeOrBuilder
        public boolean hasMin() {
            return ((Range) this.instance).hasMin();
        }

        public Builder setMax(int i) {
            copyOnWrite();
            ((Range) this.instance).setMax(i);
            return this;
        }

        public Builder setMin(int i) {
            copyOnWrite();
            ((Range) this.instance).setMin(i);
            return this;
        }

        private Builder() {
            super(Range.DEFAULT_INSTANCE);
        }
    }

    static {
        Range range = new Range();
        DEFAULT_INSTANCE = range;
        GeneratedMessageLite.registerDefaultInstance(Range.class, range);
    }

    private Range() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMax() {
        this.bitField0_ &= -3;
        this.max_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMin() {
        this.bitField0_ &= -2;
        this.min_ = 0;
    }

    public static Range getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Range parseDelimitedFrom(InputStream inputStream) {
        return (Range) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Range parseFrom(ByteBuffer byteBuffer) {
        return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Range> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMax(int i) {
        this.bitField0_ |= 2;
        this.max_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMin(int i) {
        this.bitField0_ |= 1;
        this.min_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Range();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001Ԅ\u0000\u0002Ԅ\u0001", new Object[]{"bitField0_", "min_", "max_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Range> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Range.class) {
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

    @Override // fr.sd.taada.proto.RangeOrBuilder
    public int getMax() {
        return this.max_;
    }

    @Override // fr.sd.taada.proto.RangeOrBuilder
    public int getMin() {
        return this.min_;
    }

    @Override // fr.sd.taada.proto.RangeOrBuilder
    public boolean hasMax() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.RangeOrBuilder
    public boolean hasMin() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(Range range) {
        return DEFAULT_INSTANCE.createBuilder(range);
    }

    public static Range parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Range) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Range parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Range parseFrom(ByteString byteString) {
        return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Range parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Range parseFrom(byte[] bArr) {
        return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Range parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Range parseFrom(InputStream inputStream) {
        return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Range parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Range parseFrom(CodedInputStream codedInputStream) {
        return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Range parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
