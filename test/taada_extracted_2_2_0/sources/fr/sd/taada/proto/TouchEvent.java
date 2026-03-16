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
public final class TouchEvent extends GeneratedMessageLite<TouchEvent, Builder> implements TouchEventOrBuilder {
    public static final int ACTION_FIELD_NUMBER = 3;
    public static final int ACTION_INDEX_FIELD_NUMBER = 2;
    private static final TouchEvent DEFAULT_INSTANCE;
    private static volatile Parser<TouchEvent> PARSER = null;
    public static final int POINTER_DATA_FIELD_NUMBER = 1;
    private int actionIndex_;
    private int action_;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private Internal.ProtobufList<Pointer> pointerData_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.TouchEvent$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<TouchEvent, Builder> implements TouchEventOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllPointerData(Iterable<? extends Pointer> iterable) {
            copyOnWrite();
            ((TouchEvent) this.instance).addAllPointerData(iterable);
            return this;
        }

        public Builder addPointerData(Pointer pointer) {
            copyOnWrite();
            ((TouchEvent) this.instance).addPointerData(pointer);
            return this;
        }

        public Builder clearAction() {
            copyOnWrite();
            ((TouchEvent) this.instance).clearAction();
            return this;
        }

        public Builder clearActionIndex() {
            copyOnWrite();
            ((TouchEvent) this.instance).clearActionIndex();
            return this;
        }

        public Builder clearPointerData() {
            copyOnWrite();
            ((TouchEvent) this.instance).clearPointerData();
            return this;
        }

        @Override // fr.sd.taada.proto.TouchEventOrBuilder
        public PointerAction getAction() {
            return ((TouchEvent) this.instance).getAction();
        }

        @Override // fr.sd.taada.proto.TouchEventOrBuilder
        public int getActionIndex() {
            return ((TouchEvent) this.instance).getActionIndex();
        }

        @Override // fr.sd.taada.proto.TouchEventOrBuilder
        public Pointer getPointerData(int i) {
            return ((TouchEvent) this.instance).getPointerData(i);
        }

        @Override // fr.sd.taada.proto.TouchEventOrBuilder
        public int getPointerDataCount() {
            return ((TouchEvent) this.instance).getPointerDataCount();
        }

        @Override // fr.sd.taada.proto.TouchEventOrBuilder
        public List<Pointer> getPointerDataList() {
            return Collections.unmodifiableList(((TouchEvent) this.instance).getPointerDataList());
        }

        @Override // fr.sd.taada.proto.TouchEventOrBuilder
        public boolean hasAction() {
            return ((TouchEvent) this.instance).hasAction();
        }

        @Override // fr.sd.taada.proto.TouchEventOrBuilder
        public boolean hasActionIndex() {
            return ((TouchEvent) this.instance).hasActionIndex();
        }

        public Builder removePointerData(int i) {
            copyOnWrite();
            ((TouchEvent) this.instance).removePointerData(i);
            return this;
        }

        public Builder setAction(PointerAction pointerAction) {
            copyOnWrite();
            ((TouchEvent) this.instance).setAction(pointerAction);
            return this;
        }

        public Builder setActionIndex(int i) {
            copyOnWrite();
            ((TouchEvent) this.instance).setActionIndex(i);
            return this;
        }

        public Builder setPointerData(int i, Pointer pointer) {
            copyOnWrite();
            ((TouchEvent) this.instance).setPointerData(i, pointer);
            return this;
        }

        private Builder() {
            super(TouchEvent.DEFAULT_INSTANCE);
        }

        public Builder addPointerData(int i, Pointer pointer) {
            copyOnWrite();
            ((TouchEvent) this.instance).addPointerData(i, pointer);
            return this;
        }

        public Builder setPointerData(int i, Pointer.Builder builder) {
            copyOnWrite();
            ((TouchEvent) this.instance).setPointerData(i, builder);
            return this;
        }

        public Builder addPointerData(Pointer.Builder builder) {
            copyOnWrite();
            ((TouchEvent) this.instance).addPointerData(builder);
            return this;
        }

        public Builder addPointerData(int i, Pointer.Builder builder) {
            copyOnWrite();
            ((TouchEvent) this.instance).addPointerData(i, builder);
            return this;
        }
    }

    public static final class Pointer extends GeneratedMessageLite<Pointer, Builder> implements PointerOrBuilder {
        private static final Pointer DEFAULT_INSTANCE;
        private static volatile Parser<Pointer> PARSER = null;
        public static final int POINTER_ID_FIELD_NUMBER = 3;
        public static final int X_FIELD_NUMBER = 1;
        public static final int Y_FIELD_NUMBER = 2;
        private int bitField0_;
        private byte memoizedIsInitialized = 2;
        private int pointerId_;
        private int x_;
        private int y_;

        public static final class Builder extends GeneratedMessageLite.Builder<Pointer, Builder> implements PointerOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearPointerId() {
                copyOnWrite();
                ((Pointer) this.instance).clearPointerId();
                return this;
            }

            public Builder clearX() {
                copyOnWrite();
                ((Pointer) this.instance).clearX();
                return this;
            }

            public Builder clearY() {
                copyOnWrite();
                ((Pointer) this.instance).clearY();
                return this;
            }

            @Override // fr.sd.taada.proto.TouchEvent.PointerOrBuilder
            public int getPointerId() {
                return ((Pointer) this.instance).getPointerId();
            }

            @Override // fr.sd.taada.proto.TouchEvent.PointerOrBuilder
            public int getX() {
                return ((Pointer) this.instance).getX();
            }

            @Override // fr.sd.taada.proto.TouchEvent.PointerOrBuilder
            public int getY() {
                return ((Pointer) this.instance).getY();
            }

            @Override // fr.sd.taada.proto.TouchEvent.PointerOrBuilder
            public boolean hasPointerId() {
                return ((Pointer) this.instance).hasPointerId();
            }

            @Override // fr.sd.taada.proto.TouchEvent.PointerOrBuilder
            public boolean hasX() {
                return ((Pointer) this.instance).hasX();
            }

            @Override // fr.sd.taada.proto.TouchEvent.PointerOrBuilder
            public boolean hasY() {
                return ((Pointer) this.instance).hasY();
            }

            public Builder setPointerId(int i) {
                copyOnWrite();
                ((Pointer) this.instance).setPointerId(i);
                return this;
            }

            public Builder setX(int i) {
                copyOnWrite();
                ((Pointer) this.instance).setX(i);
                return this;
            }

            public Builder setY(int i) {
                copyOnWrite();
                ((Pointer) this.instance).setY(i);
                return this;
            }

            private Builder() {
                super(Pointer.DEFAULT_INSTANCE);
            }
        }

        static {
            Pointer pointer = new Pointer();
            DEFAULT_INSTANCE = pointer;
            GeneratedMessageLite.registerDefaultInstance(Pointer.class, pointer);
        }

        private Pointer() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPointerId() {
            this.bitField0_ &= -5;
            this.pointerId_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearX() {
            this.bitField0_ &= -2;
            this.x_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearY() {
            this.bitField0_ &= -3;
            this.y_ = 0;
        }

        public static Pointer getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Pointer parseDelimitedFrom(InputStream inputStream) {
            return (Pointer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Pointer parseFrom(ByteBuffer byteBuffer) {
            return (Pointer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<Pointer> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPointerId(int i) {
            this.bitField0_ |= 4;
            this.pointerId_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setX(int i) {
            this.bitField0_ |= 1;
            this.x_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setY(int i) {
            this.bitField0_ |= 2;
            this.y_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Pointer();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001ԋ\u0000\u0002ԋ\u0001\u0003ԋ\u0002", new Object[]{"bitField0_", "x_", "y_", "pointerId_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Pointer> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Pointer.class) {
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

        @Override // fr.sd.taada.proto.TouchEvent.PointerOrBuilder
        public int getPointerId() {
            return this.pointerId_;
        }

        @Override // fr.sd.taada.proto.TouchEvent.PointerOrBuilder
        public int getX() {
            return this.x_;
        }

        @Override // fr.sd.taada.proto.TouchEvent.PointerOrBuilder
        public int getY() {
            return this.y_;
        }

        @Override // fr.sd.taada.proto.TouchEvent.PointerOrBuilder
        public boolean hasPointerId() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // fr.sd.taada.proto.TouchEvent.PointerOrBuilder
        public boolean hasX() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // fr.sd.taada.proto.TouchEvent.PointerOrBuilder
        public boolean hasY() {
            return (this.bitField0_ & 2) != 0;
        }

        public static Builder newBuilder(Pointer pointer) {
            return DEFAULT_INSTANCE.createBuilder(pointer);
        }

        public static Pointer parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Pointer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Pointer parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (Pointer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Pointer parseFrom(ByteString byteString) {
            return (Pointer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Pointer parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Pointer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Pointer parseFrom(byte[] bArr) {
            return (Pointer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Pointer parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Pointer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Pointer parseFrom(InputStream inputStream) {
            return (Pointer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Pointer parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Pointer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Pointer parseFrom(CodedInputStream codedInputStream) {
            return (Pointer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Pointer parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Pointer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface PointerOrBuilder extends MessageLiteOrBuilder {
        int getPointerId();

        int getX();

        int getY();

        boolean hasPointerId();

        boolean hasX();

        boolean hasY();
    }

    static {
        TouchEvent touchEvent = new TouchEvent();
        DEFAULT_INSTANCE = touchEvent;
        GeneratedMessageLite.registerDefaultInstance(TouchEvent.class, touchEvent);
    }

    private TouchEvent() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPointerData(Iterable<? extends Pointer> iterable) {
        ensurePointerDataIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.pointerData_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPointerData(Pointer pointer) {
        pointer.getClass();
        ensurePointerDataIsMutable();
        this.pointerData_.add(pointer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAction() {
        this.bitField0_ &= -3;
        this.action_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearActionIndex() {
        this.bitField0_ &= -2;
        this.actionIndex_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPointerData() {
        this.pointerData_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePointerDataIsMutable() {
        if (this.pointerData_.isModifiable()) {
            return;
        }
        this.pointerData_ = GeneratedMessageLite.mutableCopy(this.pointerData_);
    }

    public static TouchEvent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static TouchEvent parseDelimitedFrom(InputStream inputStream) {
        return (TouchEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TouchEvent parseFrom(ByteBuffer byteBuffer) {
        return (TouchEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<TouchEvent> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removePointerData(int i) {
        ensurePointerDataIsMutable();
        this.pointerData_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAction(PointerAction pointerAction) {
        pointerAction.getClass();
        this.bitField0_ |= 2;
        this.action_ = pointerAction.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setActionIndex(int i) {
        this.bitField0_ |= 1;
        this.actionIndex_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPointerData(int i, Pointer pointer) {
        pointer.getClass();
        ensurePointerDataIsMutable();
        this.pointerData_.set(i, pointer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new TouchEvent();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0001\u0001Л\u0002\u000b\u0000\u0003\f\u0001", new Object[]{"bitField0_", "pointerData_", Pointer.class, "actionIndex_", "action_", PointerAction.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<TouchEvent> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (TouchEvent.class) {
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

    @Override // fr.sd.taada.proto.TouchEventOrBuilder
    public PointerAction getAction() {
        PointerAction pointerActionForNumber = PointerAction.forNumber(this.action_);
        return pointerActionForNumber == null ? PointerAction.ACTION_DOWN : pointerActionForNumber;
    }

    @Override // fr.sd.taada.proto.TouchEventOrBuilder
    public int getActionIndex() {
        return this.actionIndex_;
    }

    @Override // fr.sd.taada.proto.TouchEventOrBuilder
    public Pointer getPointerData(int i) {
        return this.pointerData_.get(i);
    }

    @Override // fr.sd.taada.proto.TouchEventOrBuilder
    public int getPointerDataCount() {
        return this.pointerData_.size();
    }

    @Override // fr.sd.taada.proto.TouchEventOrBuilder
    public List<Pointer> getPointerDataList() {
        return this.pointerData_;
    }

    public PointerOrBuilder getPointerDataOrBuilder(int i) {
        return this.pointerData_.get(i);
    }

    public List<? extends PointerOrBuilder> getPointerDataOrBuilderList() {
        return this.pointerData_;
    }

    @Override // fr.sd.taada.proto.TouchEventOrBuilder
    public boolean hasAction() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.TouchEventOrBuilder
    public boolean hasActionIndex() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(TouchEvent touchEvent) {
        return DEFAULT_INSTANCE.createBuilder(touchEvent);
    }

    public static TouchEvent parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TouchEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TouchEvent parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (TouchEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static TouchEvent parseFrom(ByteString byteString) {
        return (TouchEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPointerData(int i, Pointer pointer) {
        pointer.getClass();
        ensurePointerDataIsMutable();
        this.pointerData_.add(i, pointer);
    }

    public static TouchEvent parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (TouchEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPointerData(int i, Pointer.Builder builder) {
        ensurePointerDataIsMutable();
        this.pointerData_.set(i, builder.build());
    }

    public static TouchEvent parseFrom(byte[] bArr) {
        return (TouchEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TouchEvent parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (TouchEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPointerData(Pointer.Builder builder) {
        ensurePointerDataIsMutable();
        this.pointerData_.add(builder.build());
    }

    public static TouchEvent parseFrom(InputStream inputStream) {
        return (TouchEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TouchEvent parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TouchEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPointerData(int i, Pointer.Builder builder) {
        ensurePointerDataIsMutable();
        this.pointerData_.add(i, builder.build());
    }

    public static TouchEvent parseFrom(CodedInputStream codedInputStream) {
        return (TouchEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static TouchEvent parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TouchEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
