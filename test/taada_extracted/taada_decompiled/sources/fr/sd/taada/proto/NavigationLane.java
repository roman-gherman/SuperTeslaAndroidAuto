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
public final class NavigationLane extends GeneratedMessageLite<NavigationLane, Builder> implements NavigationLaneOrBuilder {
    private static final NavigationLane DEFAULT_INSTANCE;
    public static final int LANE_DIRECTIONS_FIELD_NUMBER = 1;
    private static volatile Parser<NavigationLane> PARSER;
    private Internal.ProtobufList<LaneDirection> laneDirections_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.NavigationLane$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<NavigationLane, Builder> implements NavigationLaneOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllLaneDirections(Iterable<? extends LaneDirection> iterable) {
            copyOnWrite();
            ((NavigationLane) this.instance).addAllLaneDirections(iterable);
            return this;
        }

        public Builder addLaneDirections(LaneDirection laneDirection) {
            copyOnWrite();
            ((NavigationLane) this.instance).addLaneDirections(laneDirection);
            return this;
        }

        public Builder clearLaneDirections() {
            copyOnWrite();
            ((NavigationLane) this.instance).clearLaneDirections();
            return this;
        }

        @Override // fr.sd.taada.proto.NavigationLaneOrBuilder
        public LaneDirection getLaneDirections(int i) {
            return ((NavigationLane) this.instance).getLaneDirections(i);
        }

        @Override // fr.sd.taada.proto.NavigationLaneOrBuilder
        public int getLaneDirectionsCount() {
            return ((NavigationLane) this.instance).getLaneDirectionsCount();
        }

        @Override // fr.sd.taada.proto.NavigationLaneOrBuilder
        public List<LaneDirection> getLaneDirectionsList() {
            return Collections.unmodifiableList(((NavigationLane) this.instance).getLaneDirectionsList());
        }

        public Builder removeLaneDirections(int i) {
            copyOnWrite();
            ((NavigationLane) this.instance).removeLaneDirections(i);
            return this;
        }

        public Builder setLaneDirections(int i, LaneDirection laneDirection) {
            copyOnWrite();
            ((NavigationLane) this.instance).setLaneDirections(i, laneDirection);
            return this;
        }

        private Builder() {
            super(NavigationLane.DEFAULT_INSTANCE);
        }

        public Builder addLaneDirections(int i, LaneDirection laneDirection) {
            copyOnWrite();
            ((NavigationLane) this.instance).addLaneDirections(i, laneDirection);
            return this;
        }

        public Builder setLaneDirections(int i, LaneDirection.Builder builder) {
            copyOnWrite();
            ((NavigationLane) this.instance).setLaneDirections(i, builder);
            return this;
        }

        public Builder addLaneDirections(LaneDirection.Builder builder) {
            copyOnWrite();
            ((NavigationLane) this.instance).addLaneDirections(builder);
            return this;
        }

        public Builder addLaneDirections(int i, LaneDirection.Builder builder) {
            copyOnWrite();
            ((NavigationLane) this.instance).addLaneDirections(i, builder);
            return this;
        }
    }

    public static final class LaneDirection extends GeneratedMessageLite<LaneDirection, Builder> implements LaneDirectionOrBuilder {
        private static final LaneDirection DEFAULT_INSTANCE;
        public static final int IS_HIGHLIGHTED_FIELD_NUMBER = 2;
        private static volatile Parser<LaneDirection> PARSER = null;
        public static final int SHAPE_FIELD_NUMBER = 1;
        private int bitField0_;
        private boolean isHighlighted_;
        private int shape_;

        public static final class Builder extends GeneratedMessageLite.Builder<LaneDirection, Builder> implements LaneDirectionOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearIsHighlighted() {
                copyOnWrite();
                ((LaneDirection) this.instance).clearIsHighlighted();
                return this;
            }

            public Builder clearShape() {
                copyOnWrite();
                ((LaneDirection) this.instance).clearShape();
                return this;
            }

            @Override // fr.sd.taada.proto.NavigationLane.LaneDirectionOrBuilder
            public boolean getIsHighlighted() {
                return ((LaneDirection) this.instance).getIsHighlighted();
            }

            @Override // fr.sd.taada.proto.NavigationLane.LaneDirectionOrBuilder
            public Shape getShape() {
                return ((LaneDirection) this.instance).getShape();
            }

            @Override // fr.sd.taada.proto.NavigationLane.LaneDirectionOrBuilder
            public boolean hasIsHighlighted() {
                return ((LaneDirection) this.instance).hasIsHighlighted();
            }

            @Override // fr.sd.taada.proto.NavigationLane.LaneDirectionOrBuilder
            public boolean hasShape() {
                return ((LaneDirection) this.instance).hasShape();
            }

            public Builder setIsHighlighted(boolean z6) {
                copyOnWrite();
                ((LaneDirection) this.instance).setIsHighlighted(z6);
                return this;
            }

            public Builder setShape(Shape shape) {
                copyOnWrite();
                ((LaneDirection) this.instance).setShape(shape);
                return this;
            }

            private Builder() {
                super(LaneDirection.DEFAULT_INSTANCE);
            }
        }

        public enum Shape implements Internal.EnumLite {
            UNKNOWN(0),
            STRAIGHT(1),
            SLIGHT_LEFT(2),
            SLIGHT_RIGHT(3),
            NORMAL_LEFT(4),
            NORMAL_RIGHT(5),
            SHARP_LEFT(6),
            SHARP_RIGHT(7),
            U_TURN_LEFT(8),
            U_TURN_RIGHT(9);

            public static final int NORMAL_LEFT_VALUE = 4;
            public static final int NORMAL_RIGHT_VALUE = 5;
            public static final int SHARP_LEFT_VALUE = 6;
            public static final int SHARP_RIGHT_VALUE = 7;
            public static final int SLIGHT_LEFT_VALUE = 2;
            public static final int SLIGHT_RIGHT_VALUE = 3;
            public static final int STRAIGHT_VALUE = 1;
            public static final int UNKNOWN_VALUE = 0;
            public static final int U_TURN_LEFT_VALUE = 8;
            public static final int U_TURN_RIGHT_VALUE = 9;
            private static final Internal.EnumLiteMap<Shape> internalValueMap = new Internal.EnumLiteMap<Shape>() { // from class: fr.sd.taada.proto.NavigationLane.LaneDirection.Shape.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Shape findValueByNumber(int i) {
                    return Shape.forNumber(i);
                }
            };
            private final int value;

            public static final class ShapeVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new ShapeVerifier();

                private ShapeVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return Shape.forNumber(i) != null;
                }
            }

            Shape(int i) {
                this.value = i;
            }

            public static Shape forNumber(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return STRAIGHT;
                    case 2:
                        return SLIGHT_LEFT;
                    case 3:
                        return SLIGHT_RIGHT;
                    case 4:
                        return NORMAL_LEFT;
                    case 5:
                        return NORMAL_RIGHT;
                    case 6:
                        return SHARP_LEFT;
                    case 7:
                        return SHARP_RIGHT;
                    case 8:
                        return U_TURN_LEFT;
                    case 9:
                        return U_TURN_RIGHT;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<Shape> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return ShapeVerifier.INSTANCE;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static Shape valueOf(int i) {
                return forNumber(i);
            }
        }

        static {
            LaneDirection laneDirection = new LaneDirection();
            DEFAULT_INSTANCE = laneDirection;
            GeneratedMessageLite.registerDefaultInstance(LaneDirection.class, laneDirection);
        }

        private LaneDirection() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsHighlighted() {
            this.bitField0_ &= -3;
            this.isHighlighted_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearShape() {
            this.bitField0_ &= -2;
            this.shape_ = 0;
        }

        public static LaneDirection getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static LaneDirection parseDelimitedFrom(InputStream inputStream) {
            return (LaneDirection) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static LaneDirection parseFrom(ByteBuffer byteBuffer) {
            return (LaneDirection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<LaneDirection> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsHighlighted(boolean z6) {
            this.bitField0_ |= 2;
            this.isHighlighted_ = z6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setShape(Shape shape) {
            shape.getClass();
            this.bitField0_ |= 1;
            this.shape_ = shape.getNumber();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new LaneDirection();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\u0007\u0001", new Object[]{"bitField0_", "shape_", Shape.internalGetVerifier(), "isHighlighted_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<LaneDirection> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (LaneDirection.class) {
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

        @Override // fr.sd.taada.proto.NavigationLane.LaneDirectionOrBuilder
        public boolean getIsHighlighted() {
            return this.isHighlighted_;
        }

        @Override // fr.sd.taada.proto.NavigationLane.LaneDirectionOrBuilder
        public Shape getShape() {
            Shape shapeForNumber = Shape.forNumber(this.shape_);
            return shapeForNumber == null ? Shape.UNKNOWN : shapeForNumber;
        }

        @Override // fr.sd.taada.proto.NavigationLane.LaneDirectionOrBuilder
        public boolean hasIsHighlighted() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // fr.sd.taada.proto.NavigationLane.LaneDirectionOrBuilder
        public boolean hasShape() {
            return (this.bitField0_ & 1) != 0;
        }

        public static Builder newBuilder(LaneDirection laneDirection) {
            return DEFAULT_INSTANCE.createBuilder(laneDirection);
        }

        public static LaneDirection parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (LaneDirection) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LaneDirection parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (LaneDirection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static LaneDirection parseFrom(ByteString byteString) {
            return (LaneDirection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static LaneDirection parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (LaneDirection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static LaneDirection parseFrom(byte[] bArr) {
            return (LaneDirection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static LaneDirection parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (LaneDirection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static LaneDirection parseFrom(InputStream inputStream) {
            return (LaneDirection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static LaneDirection parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (LaneDirection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LaneDirection parseFrom(CodedInputStream codedInputStream) {
            return (LaneDirection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static LaneDirection parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (LaneDirection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface LaneDirectionOrBuilder extends MessageLiteOrBuilder {
        boolean getIsHighlighted();

        LaneDirection.Shape getShape();

        boolean hasIsHighlighted();

        boolean hasShape();
    }

    static {
        NavigationLane navigationLane = new NavigationLane();
        DEFAULT_INSTANCE = navigationLane;
        GeneratedMessageLite.registerDefaultInstance(NavigationLane.class, navigationLane);
    }

    private NavigationLane() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllLaneDirections(Iterable<? extends LaneDirection> iterable) {
        ensureLaneDirectionsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.laneDirections_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLaneDirections(LaneDirection laneDirection) {
        laneDirection.getClass();
        ensureLaneDirectionsIsMutable();
        this.laneDirections_.add(laneDirection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLaneDirections() {
        this.laneDirections_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureLaneDirectionsIsMutable() {
        if (this.laneDirections_.isModifiable()) {
            return;
        }
        this.laneDirections_ = GeneratedMessageLite.mutableCopy(this.laneDirections_);
    }

    public static NavigationLane getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static NavigationLane parseDelimitedFrom(InputStream inputStream) {
        return (NavigationLane) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationLane parseFrom(ByteBuffer byteBuffer) {
        return (NavigationLane) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<NavigationLane> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLaneDirections(int i) {
        ensureLaneDirectionsIsMutable();
        this.laneDirections_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLaneDirections(int i, LaneDirection laneDirection) {
        laneDirection.getClass();
        ensureLaneDirectionsIsMutable();
        this.laneDirections_.set(i, laneDirection);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new NavigationLane();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"laneDirections_", LaneDirection.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<NavigationLane> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (NavigationLane.class) {
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

    @Override // fr.sd.taada.proto.NavigationLaneOrBuilder
    public LaneDirection getLaneDirections(int i) {
        return this.laneDirections_.get(i);
    }

    @Override // fr.sd.taada.proto.NavigationLaneOrBuilder
    public int getLaneDirectionsCount() {
        return this.laneDirections_.size();
    }

    @Override // fr.sd.taada.proto.NavigationLaneOrBuilder
    public List<LaneDirection> getLaneDirectionsList() {
        return this.laneDirections_;
    }

    public LaneDirectionOrBuilder getLaneDirectionsOrBuilder(int i) {
        return this.laneDirections_.get(i);
    }

    public List<? extends LaneDirectionOrBuilder> getLaneDirectionsOrBuilderList() {
        return this.laneDirections_;
    }

    public static Builder newBuilder(NavigationLane navigationLane) {
        return DEFAULT_INSTANCE.createBuilder(navigationLane);
    }

    public static NavigationLane parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationLane) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavigationLane parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationLane) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static NavigationLane parseFrom(ByteString byteString) {
        return (NavigationLane) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLaneDirections(int i, LaneDirection laneDirection) {
        laneDirection.getClass();
        ensureLaneDirectionsIsMutable();
        this.laneDirections_.add(i, laneDirection);
    }

    public static NavigationLane parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationLane) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLaneDirections(int i, LaneDirection.Builder builder) {
        ensureLaneDirectionsIsMutable();
        this.laneDirections_.set(i, builder.build());
    }

    public static NavigationLane parseFrom(byte[] bArr) {
        return (NavigationLane) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NavigationLane parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationLane) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLaneDirections(LaneDirection.Builder builder) {
        ensureLaneDirectionsIsMutable();
        this.laneDirections_.add(builder.build());
    }

    public static NavigationLane parseFrom(InputStream inputStream) {
        return (NavigationLane) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationLane parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationLane) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLaneDirections(int i, LaneDirection.Builder builder) {
        ensureLaneDirectionsIsMutable();
        this.laneDirections_.add(i, builder.build());
    }

    public static NavigationLane parseFrom(CodedInputStream codedInputStream) {
        return (NavigationLane) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static NavigationLane parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationLane) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
