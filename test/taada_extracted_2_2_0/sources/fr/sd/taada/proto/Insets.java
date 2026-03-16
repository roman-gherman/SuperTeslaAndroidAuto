package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class Insets extends GeneratedMessageLite<Insets, Builder> implements InsetsOrBuilder {
    public static final int BOTTOM_FIELD_NUMBER = 2;
    private static final Insets DEFAULT_INSTANCE;
    public static final int LEFT_FIELD_NUMBER = 3;
    private static volatile Parser<Insets> PARSER = null;
    public static final int RIGHT_FIELD_NUMBER = 4;
    public static final int TOP_FIELD_NUMBER = 1;
    private int bitField0_;
    private int bottom_;
    private int left_;
    private int right_;
    private int top_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.Insets$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<Insets, Builder> implements InsetsOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearBottom() {
            copyOnWrite();
            ((Insets) this.instance).clearBottom();
            return this;
        }

        public Builder clearLeft() {
            copyOnWrite();
            ((Insets) this.instance).clearLeft();
            return this;
        }

        public Builder clearRight() {
            copyOnWrite();
            ((Insets) this.instance).clearRight();
            return this;
        }

        public Builder clearTop() {
            copyOnWrite();
            ((Insets) this.instance).clearTop();
            return this;
        }

        @Override // fr.sd.taada.proto.InsetsOrBuilder
        public int getBottom() {
            return ((Insets) this.instance).getBottom();
        }

        @Override // fr.sd.taada.proto.InsetsOrBuilder
        public int getLeft() {
            return ((Insets) this.instance).getLeft();
        }

        @Override // fr.sd.taada.proto.InsetsOrBuilder
        public int getRight() {
            return ((Insets) this.instance).getRight();
        }

        @Override // fr.sd.taada.proto.InsetsOrBuilder
        public int getTop() {
            return ((Insets) this.instance).getTop();
        }

        @Override // fr.sd.taada.proto.InsetsOrBuilder
        public boolean hasBottom() {
            return ((Insets) this.instance).hasBottom();
        }

        @Override // fr.sd.taada.proto.InsetsOrBuilder
        public boolean hasLeft() {
            return ((Insets) this.instance).hasLeft();
        }

        @Override // fr.sd.taada.proto.InsetsOrBuilder
        public boolean hasRight() {
            return ((Insets) this.instance).hasRight();
        }

        @Override // fr.sd.taada.proto.InsetsOrBuilder
        public boolean hasTop() {
            return ((Insets) this.instance).hasTop();
        }

        public Builder setBottom(int i) {
            copyOnWrite();
            ((Insets) this.instance).setBottom(i);
            return this;
        }

        public Builder setLeft(int i) {
            copyOnWrite();
            ((Insets) this.instance).setLeft(i);
            return this;
        }

        public Builder setRight(int i) {
            copyOnWrite();
            ((Insets) this.instance).setRight(i);
            return this;
        }

        public Builder setTop(int i) {
            copyOnWrite();
            ((Insets) this.instance).setTop(i);
            return this;
        }

        private Builder() {
            super(Insets.DEFAULT_INSTANCE);
        }
    }

    static {
        Insets insets = new Insets();
        DEFAULT_INSTANCE = insets;
        GeneratedMessageLite.registerDefaultInstance(Insets.class, insets);
    }

    private Insets() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBottom() {
        this.bitField0_ &= -3;
        this.bottom_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLeft() {
        this.bitField0_ &= -5;
        this.left_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRight() {
        this.bitField0_ &= -9;
        this.right_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTop() {
        this.bitField0_ &= -2;
        this.top_ = 0;
    }

    public static Insets getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Insets parseDelimitedFrom(InputStream inputStream) {
        return (Insets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Insets parseFrom(ByteBuffer byteBuffer) {
        return (Insets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Insets> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBottom(int i) {
        this.bitField0_ |= 2;
        this.bottom_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLeft(int i) {
        this.bitField0_ |= 4;
        this.left_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRight(int i) {
        this.bitField0_ |= 8;
        this.right_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTop(int i) {
        this.bitField0_ |= 1;
        this.top_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Insets();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0000\u0002\u000b\u0001\u0003\u000b\u0002\u0004\u000b\u0003", new Object[]{"bitField0_", "top_", "bottom_", "left_", "right_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Insets> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Insets.class) {
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

    @Override // fr.sd.taada.proto.InsetsOrBuilder
    public int getBottom() {
        return this.bottom_;
    }

    @Override // fr.sd.taada.proto.InsetsOrBuilder
    public int getLeft() {
        return this.left_;
    }

    @Override // fr.sd.taada.proto.InsetsOrBuilder
    public int getRight() {
        return this.right_;
    }

    @Override // fr.sd.taada.proto.InsetsOrBuilder
    public int getTop() {
        return this.top_;
    }

    @Override // fr.sd.taada.proto.InsetsOrBuilder
    public boolean hasBottom() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.InsetsOrBuilder
    public boolean hasLeft() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.InsetsOrBuilder
    public boolean hasRight() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // fr.sd.taada.proto.InsetsOrBuilder
    public boolean hasTop() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(Insets insets) {
        return DEFAULT_INSTANCE.createBuilder(insets);
    }

    public static Insets parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Insets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Insets parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Insets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Insets parseFrom(ByteString byteString) {
        return (Insets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Insets parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Insets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Insets parseFrom(byte[] bArr) {
        return (Insets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Insets parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Insets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Insets parseFrom(InputStream inputStream) {
        return (Insets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Insets parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Insets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Insets parseFrom(CodedInputStream codedInputStream) {
        return (Insets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Insets parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Insets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
