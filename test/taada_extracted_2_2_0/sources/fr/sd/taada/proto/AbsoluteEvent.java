package fr.sd.taada.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class AbsoluteEvent extends GeneratedMessageLite<AbsoluteEvent, Builder> implements AbsoluteEventOrBuilder {
    public static final int DATA_FIELD_NUMBER = 1;
    private static final AbsoluteEvent DEFAULT_INSTANCE;
    private static volatile Parser<AbsoluteEvent> PARSER;
    private byte memoizedIsInitialized = 2;
    private Internal.ProtobufList<Abs> data_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.AbsoluteEvent$1, reason: invalid class name */
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

    public static final class Abs extends GeneratedMessageLite<Abs, Builder> implements AbsOrBuilder {
        private static final Abs DEFAULT_INSTANCE;
        public static final int KEYCODE_FIELD_NUMBER = 1;
        private static volatile Parser<Abs> PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 2;
        private int bitField0_;
        private int keycode_;
        private byte memoizedIsInitialized = 2;
        private int value_;

        public static final class Builder extends GeneratedMessageLite.Builder<Abs, Builder> implements AbsOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearKeycode() {
                copyOnWrite();
                ((Abs) this.instance).clearKeycode();
                return this;
            }

            public Builder clearValue() {
                copyOnWrite();
                ((Abs) this.instance).clearValue();
                return this;
            }

            @Override // fr.sd.taada.proto.AbsoluteEvent.AbsOrBuilder
            public int getKeycode() {
                return ((Abs) this.instance).getKeycode();
            }

            @Override // fr.sd.taada.proto.AbsoluteEvent.AbsOrBuilder
            public int getValue() {
                return ((Abs) this.instance).getValue();
            }

            @Override // fr.sd.taada.proto.AbsoluteEvent.AbsOrBuilder
            public boolean hasKeycode() {
                return ((Abs) this.instance).hasKeycode();
            }

            @Override // fr.sd.taada.proto.AbsoluteEvent.AbsOrBuilder
            public boolean hasValue() {
                return ((Abs) this.instance).hasValue();
            }

            public Builder setKeycode(int i) {
                copyOnWrite();
                ((Abs) this.instance).setKeycode(i);
                return this;
            }

            public Builder setValue(int i) {
                copyOnWrite();
                ((Abs) this.instance).setValue(i);
                return this;
            }

            private Builder() {
                super(Abs.DEFAULT_INSTANCE);
            }
        }

        static {
            Abs abs = new Abs();
            DEFAULT_INSTANCE = abs;
            GeneratedMessageLite.registerDefaultInstance(Abs.class, abs);
        }

        private Abs() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearKeycode() {
            this.bitField0_ &= -2;
            this.keycode_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValue() {
            this.bitField0_ &= -3;
            this.value_ = 0;
        }

        public static Abs getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Abs parseDelimitedFrom(InputStream inputStream) {
            return (Abs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Abs parseFrom(ByteBuffer byteBuffer) {
            return (Abs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<Abs> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKeycode(int i) {
            this.bitField0_ |= 1;
            this.keycode_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValue(int i) {
            this.bitField0_ |= 2;
            this.value_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Abs();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ԋ\u0000\u0002Ԅ\u0001", new Object[]{"bitField0_", "keycode_", "value_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Abs> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Abs.class) {
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

        @Override // fr.sd.taada.proto.AbsoluteEvent.AbsOrBuilder
        public int getKeycode() {
            return this.keycode_;
        }

        @Override // fr.sd.taada.proto.AbsoluteEvent.AbsOrBuilder
        public int getValue() {
            return this.value_;
        }

        @Override // fr.sd.taada.proto.AbsoluteEvent.AbsOrBuilder
        public boolean hasKeycode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // fr.sd.taada.proto.AbsoluteEvent.AbsOrBuilder
        public boolean hasValue() {
            return (this.bitField0_ & 2) != 0;
        }

        public static Builder newBuilder(Abs abs) {
            return DEFAULT_INSTANCE.createBuilder(abs);
        }

        public static Abs parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Abs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Abs parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (Abs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Abs parseFrom(ByteString byteString) {
            return (Abs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Abs parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Abs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Abs parseFrom(byte[] bArr) {
            return (Abs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Abs parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Abs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Abs parseFrom(InputStream inputStream) {
            return (Abs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Abs parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Abs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Abs parseFrom(CodedInputStream codedInputStream) {
            return (Abs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Abs parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Abs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface AbsOrBuilder extends MessageLiteOrBuilder {
        int getKeycode();

        int getValue();

        boolean hasKeycode();

        boolean hasValue();
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AbsoluteEvent, Builder> implements AbsoluteEventOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllData(Iterable<? extends Abs> iterable) {
            copyOnWrite();
            ((AbsoluteEvent) this.instance).addAllData(iterable);
            return this;
        }

        public Builder addData(Abs abs) {
            copyOnWrite();
            ((AbsoluteEvent) this.instance).addData(abs);
            return this;
        }

        public Builder clearData() {
            copyOnWrite();
            ((AbsoluteEvent) this.instance).clearData();
            return this;
        }

        @Override // fr.sd.taada.proto.AbsoluteEventOrBuilder
        public Abs getData(int i) {
            return ((AbsoluteEvent) this.instance).getData(i);
        }

        @Override // fr.sd.taada.proto.AbsoluteEventOrBuilder
        public int getDataCount() {
            return ((AbsoluteEvent) this.instance).getDataCount();
        }

        @Override // fr.sd.taada.proto.AbsoluteEventOrBuilder
        public List<Abs> getDataList() {
            return Collections.unmodifiableList(((AbsoluteEvent) this.instance).getDataList());
        }

        public Builder removeData(int i) {
            copyOnWrite();
            ((AbsoluteEvent) this.instance).removeData(i);
            return this;
        }

        public Builder setData(int i, Abs abs) {
            copyOnWrite();
            ((AbsoluteEvent) this.instance).setData(i, abs);
            return this;
        }

        private Builder() {
            super(AbsoluteEvent.DEFAULT_INSTANCE);
        }

        public Builder addData(int i, Abs abs) {
            copyOnWrite();
            ((AbsoluteEvent) this.instance).addData(i, abs);
            return this;
        }

        public Builder setData(int i, Abs.Builder builder) {
            copyOnWrite();
            ((AbsoluteEvent) this.instance).setData(i, builder);
            return this;
        }

        public Builder addData(Abs.Builder builder) {
            copyOnWrite();
            ((AbsoluteEvent) this.instance).addData(builder);
            return this;
        }

        public Builder addData(int i, Abs.Builder builder) {
            copyOnWrite();
            ((AbsoluteEvent) this.instance).addData(i, builder);
            return this;
        }
    }

    static {
        AbsoluteEvent absoluteEvent = new AbsoluteEvent();
        DEFAULT_INSTANCE = absoluteEvent;
        GeneratedMessageLite.registerDefaultInstance(AbsoluteEvent.class, absoluteEvent);
    }

    private AbsoluteEvent() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllData(Iterable<? extends Abs> iterable) {
        ensureDataIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.data_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addData(Abs abs) {
        abs.getClass();
        ensureDataIsMutable();
        this.data_.add(abs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearData() {
        this.data_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureDataIsMutable() {
        if (this.data_.isModifiable()) {
            return;
        }
        this.data_ = GeneratedMessageLite.mutableCopy(this.data_);
    }

    public static AbsoluteEvent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static AbsoluteEvent parseDelimitedFrom(InputStream inputStream) {
        return (AbsoluteEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AbsoluteEvent parseFrom(ByteBuffer byteBuffer) {
        return (AbsoluteEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<AbsoluteEvent> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeData(int i) {
        ensureDataIsMutable();
        this.data_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(int i, Abs abs) {
        abs.getClass();
        ensureDataIsMutable();
        this.data_.set(i, abs);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new AbsoluteEvent();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"data_", Abs.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AbsoluteEvent> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (AbsoluteEvent.class) {
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

    @Override // fr.sd.taada.proto.AbsoluteEventOrBuilder
    public Abs getData(int i) {
        return this.data_.get(i);
    }

    @Override // fr.sd.taada.proto.AbsoluteEventOrBuilder
    public int getDataCount() {
        return this.data_.size();
    }

    @Override // fr.sd.taada.proto.AbsoluteEventOrBuilder
    public List<Abs> getDataList() {
        return this.data_;
    }

    public AbsOrBuilder getDataOrBuilder(int i) {
        return this.data_.get(i);
    }

    public List<? extends AbsOrBuilder> getDataOrBuilderList() {
        return this.data_;
    }

    public static Builder newBuilder(AbsoluteEvent absoluteEvent) {
        return DEFAULT_INSTANCE.createBuilder(absoluteEvent);
    }

    public static AbsoluteEvent parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AbsoluteEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AbsoluteEvent parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (AbsoluteEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AbsoluteEvent parseFrom(ByteString byteString) {
        return (AbsoluteEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addData(int i, Abs abs) {
        abs.getClass();
        ensureDataIsMutable();
        this.data_.add(i, abs);
    }

    public static AbsoluteEvent parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (AbsoluteEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(int i, Abs.Builder builder) {
        ensureDataIsMutable();
        this.data_.set(i, builder.build());
    }

    public static AbsoluteEvent parseFrom(byte[] bArr) {
        return (AbsoluteEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AbsoluteEvent parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (AbsoluteEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addData(Abs.Builder builder) {
        ensureDataIsMutable();
        this.data_.add(builder.build());
    }

    public static AbsoluteEvent parseFrom(InputStream inputStream) {
        return (AbsoluteEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AbsoluteEvent parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AbsoluteEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addData(int i, Abs.Builder builder) {
        ensureDataIsMutable();
        this.data_.add(i, builder.build());
    }

    public static AbsoluteEvent parseFrom(CodedInputStream codedInputStream) {
        return (AbsoluteEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AbsoluteEvent parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AbsoluteEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
