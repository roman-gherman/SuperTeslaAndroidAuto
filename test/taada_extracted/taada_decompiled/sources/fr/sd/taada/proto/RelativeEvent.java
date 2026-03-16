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
public final class RelativeEvent extends GeneratedMessageLite<RelativeEvent, Builder> implements RelativeEventOrBuilder {
    public static final int DATA_FIELD_NUMBER = 1;
    private static final RelativeEvent DEFAULT_INSTANCE;
    private static volatile Parser<RelativeEvent> PARSER;
    private byte memoizedIsInitialized = 2;
    private Internal.ProtobufList<Rel> data_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.RelativeEvent$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<RelativeEvent, Builder> implements RelativeEventOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllData(Iterable<? extends Rel> iterable) {
            copyOnWrite();
            ((RelativeEvent) this.instance).addAllData(iterable);
            return this;
        }

        public Builder addData(Rel rel) {
            copyOnWrite();
            ((RelativeEvent) this.instance).addData(rel);
            return this;
        }

        public Builder clearData() {
            copyOnWrite();
            ((RelativeEvent) this.instance).clearData();
            return this;
        }

        @Override // fr.sd.taada.proto.RelativeEventOrBuilder
        public Rel getData(int i) {
            return ((RelativeEvent) this.instance).getData(i);
        }

        @Override // fr.sd.taada.proto.RelativeEventOrBuilder
        public int getDataCount() {
            return ((RelativeEvent) this.instance).getDataCount();
        }

        @Override // fr.sd.taada.proto.RelativeEventOrBuilder
        public List<Rel> getDataList() {
            return Collections.unmodifiableList(((RelativeEvent) this.instance).getDataList());
        }

        public Builder removeData(int i) {
            copyOnWrite();
            ((RelativeEvent) this.instance).removeData(i);
            return this;
        }

        public Builder setData(int i, Rel rel) {
            copyOnWrite();
            ((RelativeEvent) this.instance).setData(i, rel);
            return this;
        }

        private Builder() {
            super(RelativeEvent.DEFAULT_INSTANCE);
        }

        public Builder addData(int i, Rel rel) {
            copyOnWrite();
            ((RelativeEvent) this.instance).addData(i, rel);
            return this;
        }

        public Builder setData(int i, Rel.Builder builder) {
            copyOnWrite();
            ((RelativeEvent) this.instance).setData(i, builder);
            return this;
        }

        public Builder addData(Rel.Builder builder) {
            copyOnWrite();
            ((RelativeEvent) this.instance).addData(builder);
            return this;
        }

        public Builder addData(int i, Rel.Builder builder) {
            copyOnWrite();
            ((RelativeEvent) this.instance).addData(i, builder);
            return this;
        }
    }

    public static final class Rel extends GeneratedMessageLite<Rel, Builder> implements RelOrBuilder {
        private static final Rel DEFAULT_INSTANCE;
        public static final int DELTA_FIELD_NUMBER = 2;
        public static final int KEYCODE_FIELD_NUMBER = 1;
        private static volatile Parser<Rel> PARSER;
        private int bitField0_;
        private int delta_;
        private int keycode_;
        private byte memoizedIsInitialized = 2;

        public static final class Builder extends GeneratedMessageLite.Builder<Rel, Builder> implements RelOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearDelta() {
                copyOnWrite();
                ((Rel) this.instance).clearDelta();
                return this;
            }

            public Builder clearKeycode() {
                copyOnWrite();
                ((Rel) this.instance).clearKeycode();
                return this;
            }

            @Override // fr.sd.taada.proto.RelativeEvent.RelOrBuilder
            public int getDelta() {
                return ((Rel) this.instance).getDelta();
            }

            @Override // fr.sd.taada.proto.RelativeEvent.RelOrBuilder
            public int getKeycode() {
                return ((Rel) this.instance).getKeycode();
            }

            @Override // fr.sd.taada.proto.RelativeEvent.RelOrBuilder
            public boolean hasDelta() {
                return ((Rel) this.instance).hasDelta();
            }

            @Override // fr.sd.taada.proto.RelativeEvent.RelOrBuilder
            public boolean hasKeycode() {
                return ((Rel) this.instance).hasKeycode();
            }

            public Builder setDelta(int i) {
                copyOnWrite();
                ((Rel) this.instance).setDelta(i);
                return this;
            }

            public Builder setKeycode(int i) {
                copyOnWrite();
                ((Rel) this.instance).setKeycode(i);
                return this;
            }

            private Builder() {
                super(Rel.DEFAULT_INSTANCE);
            }
        }

        static {
            Rel rel = new Rel();
            DEFAULT_INSTANCE = rel;
            GeneratedMessageLite.registerDefaultInstance(Rel.class, rel);
        }

        private Rel() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDelta() {
            this.bitField0_ &= -3;
            this.delta_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearKeycode() {
            this.bitField0_ &= -2;
            this.keycode_ = 0;
        }

        public static Rel getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Rel parseDelimitedFrom(InputStream inputStream) {
            return (Rel) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Rel parseFrom(ByteBuffer byteBuffer) {
            return (Rel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<Rel> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDelta(int i) {
            this.bitField0_ |= 2;
            this.delta_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKeycode(int i) {
            this.bitField0_ |= 1;
            this.keycode_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Rel();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ԋ\u0000\u0002Ԅ\u0001", new Object[]{"bitField0_", "keycode_", "delta_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Rel> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Rel.class) {
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

        @Override // fr.sd.taada.proto.RelativeEvent.RelOrBuilder
        public int getDelta() {
            return this.delta_;
        }

        @Override // fr.sd.taada.proto.RelativeEvent.RelOrBuilder
        public int getKeycode() {
            return this.keycode_;
        }

        @Override // fr.sd.taada.proto.RelativeEvent.RelOrBuilder
        public boolean hasDelta() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // fr.sd.taada.proto.RelativeEvent.RelOrBuilder
        public boolean hasKeycode() {
            return (this.bitField0_ & 1) != 0;
        }

        public static Builder newBuilder(Rel rel) {
            return DEFAULT_INSTANCE.createBuilder(rel);
        }

        public static Rel parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Rel) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Rel parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (Rel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Rel parseFrom(ByteString byteString) {
            return (Rel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Rel parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Rel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Rel parseFrom(byte[] bArr) {
            return (Rel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Rel parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Rel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Rel parseFrom(InputStream inputStream) {
            return (Rel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Rel parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Rel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Rel parseFrom(CodedInputStream codedInputStream) {
            return (Rel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Rel parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Rel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface RelOrBuilder extends MessageLiteOrBuilder {
        int getDelta();

        int getKeycode();

        boolean hasDelta();

        boolean hasKeycode();
    }

    static {
        RelativeEvent relativeEvent = new RelativeEvent();
        DEFAULT_INSTANCE = relativeEvent;
        GeneratedMessageLite.registerDefaultInstance(RelativeEvent.class, relativeEvent);
    }

    private RelativeEvent() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllData(Iterable<? extends Rel> iterable) {
        ensureDataIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.data_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addData(Rel rel) {
        rel.getClass();
        ensureDataIsMutable();
        this.data_.add(rel);
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

    public static RelativeEvent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static RelativeEvent parseDelimitedFrom(InputStream inputStream) {
        return (RelativeEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RelativeEvent parseFrom(ByteBuffer byteBuffer) {
        return (RelativeEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<RelativeEvent> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeData(int i) {
        ensureDataIsMutable();
        this.data_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(int i, Rel rel) {
        rel.getClass();
        ensureDataIsMutable();
        this.data_.set(i, rel);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RelativeEvent();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"data_", Rel.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RelativeEvent> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (RelativeEvent.class) {
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

    @Override // fr.sd.taada.proto.RelativeEventOrBuilder
    public Rel getData(int i) {
        return this.data_.get(i);
    }

    @Override // fr.sd.taada.proto.RelativeEventOrBuilder
    public int getDataCount() {
        return this.data_.size();
    }

    @Override // fr.sd.taada.proto.RelativeEventOrBuilder
    public List<Rel> getDataList() {
        return this.data_;
    }

    public RelOrBuilder getDataOrBuilder(int i) {
        return this.data_.get(i);
    }

    public List<? extends RelOrBuilder> getDataOrBuilderList() {
        return this.data_;
    }

    public static Builder newBuilder(RelativeEvent relativeEvent) {
        return DEFAULT_INSTANCE.createBuilder(relativeEvent);
    }

    public static RelativeEvent parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RelativeEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RelativeEvent parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (RelativeEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static RelativeEvent parseFrom(ByteString byteString) {
        return (RelativeEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addData(int i, Rel rel) {
        rel.getClass();
        ensureDataIsMutable();
        this.data_.add(i, rel);
    }

    public static RelativeEvent parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (RelativeEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(int i, Rel.Builder builder) {
        ensureDataIsMutable();
        this.data_.set(i, builder.build());
    }

    public static RelativeEvent parseFrom(byte[] bArr) {
        return (RelativeEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RelativeEvent parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (RelativeEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addData(Rel.Builder builder) {
        ensureDataIsMutable();
        this.data_.add(builder.build());
    }

    public static RelativeEvent parseFrom(InputStream inputStream) {
        return (RelativeEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RelativeEvent parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RelativeEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addData(int i, Rel.Builder builder) {
        ensureDataIsMutable();
        this.data_.add(i, builder.build());
    }

    public static RelativeEvent parseFrom(CodedInputStream codedInputStream) {
        return (RelativeEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RelativeEvent parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RelativeEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
