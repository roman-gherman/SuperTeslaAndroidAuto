package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.AbsoluteEvent;
import fr.sd.taada.proto.KeyEvent;
import fr.sd.taada.proto.RelativeEvent;
import fr.sd.taada.proto.TouchEvent;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class InputReport extends GeneratedMessageLite<InputReport, Builder> implements InputReportOrBuilder {
    public static final int ABSOLUTE_EVENT_FIELD_NUMBER = 5;
    private static final InputReport DEFAULT_INSTANCE;
    public static final int DISP_CHANNEL_ID_FIELD_NUMBER = 2;
    public static final int KEY_EVENT_FIELD_NUMBER = 4;
    private static volatile Parser<InputReport> PARSER = null;
    public static final int RELATIVE_EVENT_FIELD_NUMBER = 6;
    public static final int TIMESTAMP_FIELD_NUMBER = 1;
    public static final int TOUCHPAD_EVENT_FIELD_NUMBER = 7;
    public static final int TOUCH_EVENT_FIELD_NUMBER = 3;
    private AbsoluteEvent absoluteEvent_;
    private int bitField0_;
    private int dispChannelId_;
    private KeyEvent keyEvent_;
    private byte memoizedIsInitialized = 2;
    private RelativeEvent relativeEvent_;
    private long timestamp_;
    private TouchEvent touchEvent_;
    private TouchEvent touchpadEvent_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.InputReport$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<InputReport, Builder> implements InputReportOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAbsoluteEvent() {
            copyOnWrite();
            ((InputReport) this.instance).clearAbsoluteEvent();
            return this;
        }

        @Deprecated
        public Builder clearDispChannelId() {
            copyOnWrite();
            ((InputReport) this.instance).clearDispChannelId();
            return this;
        }

        public Builder clearKeyEvent() {
            copyOnWrite();
            ((InputReport) this.instance).clearKeyEvent();
            return this;
        }

        public Builder clearRelativeEvent() {
            copyOnWrite();
            ((InputReport) this.instance).clearRelativeEvent();
            return this;
        }

        public Builder clearTimestamp() {
            copyOnWrite();
            ((InputReport) this.instance).clearTimestamp();
            return this;
        }

        public Builder clearTouchEvent() {
            copyOnWrite();
            ((InputReport) this.instance).clearTouchEvent();
            return this;
        }

        public Builder clearTouchpadEvent() {
            copyOnWrite();
            ((InputReport) this.instance).clearTouchpadEvent();
            return this;
        }

        @Override // fr.sd.taada.proto.InputReportOrBuilder
        public AbsoluteEvent getAbsoluteEvent() {
            return ((InputReport) this.instance).getAbsoluteEvent();
        }

        @Override // fr.sd.taada.proto.InputReportOrBuilder
        @Deprecated
        public int getDispChannelId() {
            return ((InputReport) this.instance).getDispChannelId();
        }

        @Override // fr.sd.taada.proto.InputReportOrBuilder
        public KeyEvent getKeyEvent() {
            return ((InputReport) this.instance).getKeyEvent();
        }

        @Override // fr.sd.taada.proto.InputReportOrBuilder
        public RelativeEvent getRelativeEvent() {
            return ((InputReport) this.instance).getRelativeEvent();
        }

        @Override // fr.sd.taada.proto.InputReportOrBuilder
        public long getTimestamp() {
            return ((InputReport) this.instance).getTimestamp();
        }

        @Override // fr.sd.taada.proto.InputReportOrBuilder
        public TouchEvent getTouchEvent() {
            return ((InputReport) this.instance).getTouchEvent();
        }

        @Override // fr.sd.taada.proto.InputReportOrBuilder
        public TouchEvent getTouchpadEvent() {
            return ((InputReport) this.instance).getTouchpadEvent();
        }

        @Override // fr.sd.taada.proto.InputReportOrBuilder
        public boolean hasAbsoluteEvent() {
            return ((InputReport) this.instance).hasAbsoluteEvent();
        }

        @Override // fr.sd.taada.proto.InputReportOrBuilder
        @Deprecated
        public boolean hasDispChannelId() {
            return ((InputReport) this.instance).hasDispChannelId();
        }

        @Override // fr.sd.taada.proto.InputReportOrBuilder
        public boolean hasKeyEvent() {
            return ((InputReport) this.instance).hasKeyEvent();
        }

        @Override // fr.sd.taada.proto.InputReportOrBuilder
        public boolean hasRelativeEvent() {
            return ((InputReport) this.instance).hasRelativeEvent();
        }

        @Override // fr.sd.taada.proto.InputReportOrBuilder
        public boolean hasTimestamp() {
            return ((InputReport) this.instance).hasTimestamp();
        }

        @Override // fr.sd.taada.proto.InputReportOrBuilder
        public boolean hasTouchEvent() {
            return ((InputReport) this.instance).hasTouchEvent();
        }

        @Override // fr.sd.taada.proto.InputReportOrBuilder
        public boolean hasTouchpadEvent() {
            return ((InputReport) this.instance).hasTouchpadEvent();
        }

        public Builder mergeAbsoluteEvent(AbsoluteEvent absoluteEvent) {
            copyOnWrite();
            ((InputReport) this.instance).mergeAbsoluteEvent(absoluteEvent);
            return this;
        }

        public Builder mergeKeyEvent(KeyEvent keyEvent) {
            copyOnWrite();
            ((InputReport) this.instance).mergeKeyEvent(keyEvent);
            return this;
        }

        public Builder mergeRelativeEvent(RelativeEvent relativeEvent) {
            copyOnWrite();
            ((InputReport) this.instance).mergeRelativeEvent(relativeEvent);
            return this;
        }

        public Builder mergeTouchEvent(TouchEvent touchEvent) {
            copyOnWrite();
            ((InputReport) this.instance).mergeTouchEvent(touchEvent);
            return this;
        }

        public Builder mergeTouchpadEvent(TouchEvent touchEvent) {
            copyOnWrite();
            ((InputReport) this.instance).mergeTouchpadEvent(touchEvent);
            return this;
        }

        public Builder setAbsoluteEvent(AbsoluteEvent absoluteEvent) {
            copyOnWrite();
            ((InputReport) this.instance).setAbsoluteEvent(absoluteEvent);
            return this;
        }

        @Deprecated
        public Builder setDispChannelId(int i) {
            copyOnWrite();
            ((InputReport) this.instance).setDispChannelId(i);
            return this;
        }

        public Builder setKeyEvent(KeyEvent keyEvent) {
            copyOnWrite();
            ((InputReport) this.instance).setKeyEvent(keyEvent);
            return this;
        }

        public Builder setRelativeEvent(RelativeEvent relativeEvent) {
            copyOnWrite();
            ((InputReport) this.instance).setRelativeEvent(relativeEvent);
            return this;
        }

        public Builder setTimestamp(long j6) {
            copyOnWrite();
            ((InputReport) this.instance).setTimestamp(j6);
            return this;
        }

        public Builder setTouchEvent(TouchEvent touchEvent) {
            copyOnWrite();
            ((InputReport) this.instance).setTouchEvent(touchEvent);
            return this;
        }

        public Builder setTouchpadEvent(TouchEvent touchEvent) {
            copyOnWrite();
            ((InputReport) this.instance).setTouchpadEvent(touchEvent);
            return this;
        }

        private Builder() {
            super(InputReport.DEFAULT_INSTANCE);
        }

        public Builder setAbsoluteEvent(AbsoluteEvent.Builder builder) {
            copyOnWrite();
            ((InputReport) this.instance).setAbsoluteEvent(builder);
            return this;
        }

        public Builder setKeyEvent(KeyEvent.Builder builder) {
            copyOnWrite();
            ((InputReport) this.instance).setKeyEvent(builder);
            return this;
        }

        public Builder setRelativeEvent(RelativeEvent.Builder builder) {
            copyOnWrite();
            ((InputReport) this.instance).setRelativeEvent(builder);
            return this;
        }

        public Builder setTouchEvent(TouchEvent.Builder builder) {
            copyOnWrite();
            ((InputReport) this.instance).setTouchEvent(builder);
            return this;
        }

        public Builder setTouchpadEvent(TouchEvent.Builder builder) {
            copyOnWrite();
            ((InputReport) this.instance).setTouchpadEvent(builder);
            return this;
        }
    }

    static {
        InputReport inputReport = new InputReport();
        DEFAULT_INSTANCE = inputReport;
        GeneratedMessageLite.registerDefaultInstance(InputReport.class, inputReport);
    }

    private InputReport() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAbsoluteEvent() {
        this.absoluteEvent_ = null;
        this.bitField0_ &= -17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDispChannelId() {
        this.bitField0_ &= -3;
        this.dispChannelId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyEvent() {
        this.keyEvent_ = null;
        this.bitField0_ &= -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRelativeEvent() {
        this.relativeEvent_ = null;
        this.bitField0_ &= -33;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimestamp() {
        this.bitField0_ &= -2;
        this.timestamp_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTouchEvent() {
        this.touchEvent_ = null;
        this.bitField0_ &= -5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTouchpadEvent() {
        this.touchpadEvent_ = null;
        this.bitField0_ &= -65;
    }

    public static InputReport getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAbsoluteEvent(AbsoluteEvent absoluteEvent) {
        absoluteEvent.getClass();
        AbsoluteEvent absoluteEvent2 = this.absoluteEvent_;
        if (absoluteEvent2 == null || absoluteEvent2 == AbsoluteEvent.getDefaultInstance()) {
            this.absoluteEvent_ = absoluteEvent;
        } else {
            this.absoluteEvent_ = AbsoluteEvent.newBuilder(this.absoluteEvent_).mergeFrom(absoluteEvent).buildPartial();
        }
        this.bitField0_ |= 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeKeyEvent(KeyEvent keyEvent) {
        keyEvent.getClass();
        KeyEvent keyEvent2 = this.keyEvent_;
        if (keyEvent2 == null || keyEvent2 == KeyEvent.getDefaultInstance()) {
            this.keyEvent_ = keyEvent;
        } else {
            this.keyEvent_ = KeyEvent.newBuilder(this.keyEvent_).mergeFrom(keyEvent).buildPartial();
        }
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRelativeEvent(RelativeEvent relativeEvent) {
        relativeEvent.getClass();
        RelativeEvent relativeEvent2 = this.relativeEvent_;
        if (relativeEvent2 == null || relativeEvent2 == RelativeEvent.getDefaultInstance()) {
            this.relativeEvent_ = relativeEvent;
        } else {
            this.relativeEvent_ = RelativeEvent.newBuilder(this.relativeEvent_).mergeFrom(relativeEvent).buildPartial();
        }
        this.bitField0_ |= 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTouchEvent(TouchEvent touchEvent) {
        touchEvent.getClass();
        TouchEvent touchEvent2 = this.touchEvent_;
        if (touchEvent2 == null || touchEvent2 == TouchEvent.getDefaultInstance()) {
            this.touchEvent_ = touchEvent;
        } else {
            this.touchEvent_ = TouchEvent.newBuilder(this.touchEvent_).mergeFrom(touchEvent).buildPartial();
        }
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTouchpadEvent(TouchEvent touchEvent) {
        touchEvent.getClass();
        TouchEvent touchEvent2 = this.touchpadEvent_;
        if (touchEvent2 == null || touchEvent2 == TouchEvent.getDefaultInstance()) {
            this.touchpadEvent_ = touchEvent;
        } else {
            this.touchpadEvent_ = TouchEvent.newBuilder(this.touchpadEvent_).mergeFrom(touchEvent).buildPartial();
        }
        this.bitField0_ |= 64;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static InputReport parseDelimitedFrom(InputStream inputStream) {
        return (InputReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static InputReport parseFrom(ByteBuffer byteBuffer) {
        return (InputReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<InputReport> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAbsoluteEvent(AbsoluteEvent absoluteEvent) {
        absoluteEvent.getClass();
        this.absoluteEvent_ = absoluteEvent;
        this.bitField0_ |= 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDispChannelId(int i) {
        this.bitField0_ |= 2;
        this.dispChannelId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyEvent(KeyEvent keyEvent) {
        keyEvent.getClass();
        this.keyEvent_ = keyEvent;
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRelativeEvent(RelativeEvent relativeEvent) {
        relativeEvent.getClass();
        this.relativeEvent_ = relativeEvent;
        this.bitField0_ |= 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimestamp(long j6) {
        this.bitField0_ |= 1;
        this.timestamp_ = j6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTouchEvent(TouchEvent touchEvent) {
        touchEvent.getClass();
        this.touchEvent_ = touchEvent;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTouchpadEvent(TouchEvent touchEvent) {
        touchEvent.getClass();
        this.touchpadEvent_ = touchEvent;
        this.bitField0_ |= 64;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new InputReport();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0006\u0001ԃ\u0000\u0002\u0004\u0001\u0003Љ\u0002\u0004Љ\u0003\u0005Љ\u0004\u0006Љ\u0005\u0007Љ\u0006", new Object[]{"bitField0_", "timestamp_", "dispChannelId_", "touchEvent_", "keyEvent_", "absoluteEvent_", "relativeEvent_", "touchpadEvent_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<InputReport> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (InputReport.class) {
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

    @Override // fr.sd.taada.proto.InputReportOrBuilder
    public AbsoluteEvent getAbsoluteEvent() {
        AbsoluteEvent absoluteEvent = this.absoluteEvent_;
        return absoluteEvent == null ? AbsoluteEvent.getDefaultInstance() : absoluteEvent;
    }

    @Override // fr.sd.taada.proto.InputReportOrBuilder
    @Deprecated
    public int getDispChannelId() {
        return this.dispChannelId_;
    }

    @Override // fr.sd.taada.proto.InputReportOrBuilder
    public KeyEvent getKeyEvent() {
        KeyEvent keyEvent = this.keyEvent_;
        return keyEvent == null ? KeyEvent.getDefaultInstance() : keyEvent;
    }

    @Override // fr.sd.taada.proto.InputReportOrBuilder
    public RelativeEvent getRelativeEvent() {
        RelativeEvent relativeEvent = this.relativeEvent_;
        return relativeEvent == null ? RelativeEvent.getDefaultInstance() : relativeEvent;
    }

    @Override // fr.sd.taada.proto.InputReportOrBuilder
    public long getTimestamp() {
        return this.timestamp_;
    }

    @Override // fr.sd.taada.proto.InputReportOrBuilder
    public TouchEvent getTouchEvent() {
        TouchEvent touchEvent = this.touchEvent_;
        return touchEvent == null ? TouchEvent.getDefaultInstance() : touchEvent;
    }

    @Override // fr.sd.taada.proto.InputReportOrBuilder
    public TouchEvent getTouchpadEvent() {
        TouchEvent touchEvent = this.touchpadEvent_;
        return touchEvent == null ? TouchEvent.getDefaultInstance() : touchEvent;
    }

    @Override // fr.sd.taada.proto.InputReportOrBuilder
    public boolean hasAbsoluteEvent() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // fr.sd.taada.proto.InputReportOrBuilder
    @Deprecated
    public boolean hasDispChannelId() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.InputReportOrBuilder
    public boolean hasKeyEvent() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // fr.sd.taada.proto.InputReportOrBuilder
    public boolean hasRelativeEvent() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // fr.sd.taada.proto.InputReportOrBuilder
    public boolean hasTimestamp() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.InputReportOrBuilder
    public boolean hasTouchEvent() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.InputReportOrBuilder
    public boolean hasTouchpadEvent() {
        return (this.bitField0_ & 64) != 0;
    }

    public static Builder newBuilder(InputReport inputReport) {
        return DEFAULT_INSTANCE.createBuilder(inputReport);
    }

    public static InputReport parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (InputReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static InputReport parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (InputReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static InputReport parseFrom(ByteString byteString) {
        return (InputReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static InputReport parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (InputReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAbsoluteEvent(AbsoluteEvent.Builder builder) {
        this.absoluteEvent_ = builder.build();
        this.bitField0_ |= 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyEvent(KeyEvent.Builder builder) {
        this.keyEvent_ = builder.build();
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRelativeEvent(RelativeEvent.Builder builder) {
        this.relativeEvent_ = builder.build();
        this.bitField0_ |= 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTouchEvent(TouchEvent.Builder builder) {
        this.touchEvent_ = builder.build();
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTouchpadEvent(TouchEvent.Builder builder) {
        this.touchpadEvent_ = builder.build();
        this.bitField0_ |= 64;
    }

    public static InputReport parseFrom(byte[] bArr) {
        return (InputReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static InputReport parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (InputReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static InputReport parseFrom(InputStream inputStream) {
        return (InputReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static InputReport parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (InputReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static InputReport parseFrom(CodedInputStream codedInputStream) {
        return (InputReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static InputReport parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (InputReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
