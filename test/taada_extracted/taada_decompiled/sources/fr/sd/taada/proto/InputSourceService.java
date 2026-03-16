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
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class InputSourceService extends GeneratedMessageLite<InputSourceService, Builder> implements InputSourceServiceOrBuilder {
    private static final InputSourceService DEFAULT_INSTANCE;
    public static final int DISPLAY_ID_FIELD_NUMBER = 5;
    public static final int FEEDBACK_EVENTS_SUPPORTED_FIELD_NUMBER = 4;
    public static final int KEYCODES_SUPPORTED_FIELD_NUMBER = 1;
    private static volatile Parser<InputSourceService> PARSER = null;
    public static final int TOUCHPAD_FIELD_NUMBER = 3;
    public static final int TOUCHSCREEN_FIELD_NUMBER = 2;
    private static final Internal.ListAdapter.Converter<Integer, FeedbackEvent> feedbackEventsSupported_converter_ = new Internal.ListAdapter.Converter<Integer, FeedbackEvent>() { // from class: fr.sd.taada.proto.InputSourceService.1
        @Override // com.google.protobuf.Internal.ListAdapter.Converter
        public FeedbackEvent convert(Integer num) {
            FeedbackEvent feedbackEventForNumber = FeedbackEvent.forNumber(num.intValue());
            return feedbackEventForNumber == null ? FeedbackEvent.FEEDBACK_SELECT : feedbackEventForNumber;
        }
    };
    private int bitField0_;
    private int displayId_;
    private int keycodesSupportedMemoizedSerializedSize = -1;
    private byte memoizedIsInitialized = 2;
    private Internal.IntList keycodesSupported_ = GeneratedMessageLite.emptyIntList();
    private Internal.ProtobufList<TouchScreen> touchscreen_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<TouchPad> touchpad_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.IntList feedbackEventsSupported_ = GeneratedMessageLite.emptyIntList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.InputSourceService$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
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

    public static final class Builder extends GeneratedMessageLite.Builder<InputSourceService, Builder> implements InputSourceServiceOrBuilder {
        public Builder addAllFeedbackEventsSupported(Iterable<? extends FeedbackEvent> iterable) {
            copyOnWrite();
            ((InputSourceService) this.instance).addAllFeedbackEventsSupported(iterable);
            return this;
        }

        public Builder addAllKeycodesSupported(Iterable<? extends Integer> iterable) {
            copyOnWrite();
            ((InputSourceService) this.instance).addAllKeycodesSupported(iterable);
            return this;
        }

        public Builder addAllTouchpad(Iterable<? extends TouchPad> iterable) {
            copyOnWrite();
            ((InputSourceService) this.instance).addAllTouchpad(iterable);
            return this;
        }

        public Builder addAllTouchscreen(Iterable<? extends TouchScreen> iterable) {
            copyOnWrite();
            ((InputSourceService) this.instance).addAllTouchscreen(iterable);
            return this;
        }

        public Builder addFeedbackEventsSupported(FeedbackEvent feedbackEvent) {
            copyOnWrite();
            ((InputSourceService) this.instance).addFeedbackEventsSupported(feedbackEvent);
            return this;
        }

        public Builder addKeycodesSupported(int i) {
            copyOnWrite();
            ((InputSourceService) this.instance).addKeycodesSupported(i);
            return this;
        }

        public Builder addTouchpad(TouchPad touchPad) {
            copyOnWrite();
            ((InputSourceService) this.instance).addTouchpad(touchPad);
            return this;
        }

        public Builder addTouchscreen(TouchScreen touchScreen) {
            copyOnWrite();
            ((InputSourceService) this.instance).addTouchscreen(touchScreen);
            return this;
        }

        public Builder clearDisplayId() {
            copyOnWrite();
            ((InputSourceService) this.instance).clearDisplayId();
            return this;
        }

        public Builder clearFeedbackEventsSupported() {
            copyOnWrite();
            ((InputSourceService) this.instance).clearFeedbackEventsSupported();
            return this;
        }

        public Builder clearKeycodesSupported() {
            copyOnWrite();
            ((InputSourceService) this.instance).clearKeycodesSupported();
            return this;
        }

        public Builder clearTouchpad() {
            copyOnWrite();
            ((InputSourceService) this.instance).clearTouchpad();
            return this;
        }

        public Builder clearTouchscreen() {
            copyOnWrite();
            ((InputSourceService) this.instance).clearTouchscreen();
            return this;
        }

        @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
        public int getDisplayId() {
            return ((InputSourceService) this.instance).getDisplayId();
        }

        @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
        public FeedbackEvent getFeedbackEventsSupported(int i) {
            return ((InputSourceService) this.instance).getFeedbackEventsSupported(i);
        }

        @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
        public int getFeedbackEventsSupportedCount() {
            return ((InputSourceService) this.instance).getFeedbackEventsSupportedCount();
        }

        @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
        public List<FeedbackEvent> getFeedbackEventsSupportedList() {
            return ((InputSourceService) this.instance).getFeedbackEventsSupportedList();
        }

        @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
        public int getKeycodesSupported(int i) {
            return ((InputSourceService) this.instance).getKeycodesSupported(i);
        }

        @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
        public int getKeycodesSupportedCount() {
            return ((InputSourceService) this.instance).getKeycodesSupportedCount();
        }

        @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
        public List<Integer> getKeycodesSupportedList() {
            return Collections.unmodifiableList(((InputSourceService) this.instance).getKeycodesSupportedList());
        }

        @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
        public TouchPad getTouchpad(int i) {
            return ((InputSourceService) this.instance).getTouchpad(i);
        }

        @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
        public int getTouchpadCount() {
            return ((InputSourceService) this.instance).getTouchpadCount();
        }

        @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
        public List<TouchPad> getTouchpadList() {
            return Collections.unmodifiableList(((InputSourceService) this.instance).getTouchpadList());
        }

        @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
        public TouchScreen getTouchscreen(int i) {
            return ((InputSourceService) this.instance).getTouchscreen(i);
        }

        @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
        public int getTouchscreenCount() {
            return ((InputSourceService) this.instance).getTouchscreenCount();
        }

        @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
        public List<TouchScreen> getTouchscreenList() {
            return Collections.unmodifiableList(((InputSourceService) this.instance).getTouchscreenList());
        }

        @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
        public boolean hasDisplayId() {
            return ((InputSourceService) this.instance).hasDisplayId();
        }

        public Builder removeTouchpad(int i) {
            copyOnWrite();
            ((InputSourceService) this.instance).removeTouchpad(i);
            return this;
        }

        public Builder removeTouchscreen(int i) {
            copyOnWrite();
            ((InputSourceService) this.instance).removeTouchscreen(i);
            return this;
        }

        public Builder setDisplayId(int i) {
            copyOnWrite();
            ((InputSourceService) this.instance).setDisplayId(i);
            return this;
        }

        public Builder setFeedbackEventsSupported(int i, FeedbackEvent feedbackEvent) {
            copyOnWrite();
            ((InputSourceService) this.instance).setFeedbackEventsSupported(i, feedbackEvent);
            return this;
        }

        public Builder setKeycodesSupported(int i, int i3) {
            copyOnWrite();
            ((InputSourceService) this.instance).setKeycodesSupported(i, i3);
            return this;
        }

        public Builder setTouchpad(int i, TouchPad touchPad) {
            copyOnWrite();
            ((InputSourceService) this.instance).setTouchpad(i, touchPad);
            return this;
        }

        public Builder setTouchscreen(int i, TouchScreen touchScreen) {
            copyOnWrite();
            ((InputSourceService) this.instance).setTouchscreen(i, touchScreen);
            return this;
        }

        private Builder() {
            super(InputSourceService.DEFAULT_INSTANCE);
        }

        public Builder addTouchpad(int i, TouchPad touchPad) {
            copyOnWrite();
            ((InputSourceService) this.instance).addTouchpad(i, touchPad);
            return this;
        }

        public Builder addTouchscreen(int i, TouchScreen touchScreen) {
            copyOnWrite();
            ((InputSourceService) this.instance).addTouchscreen(i, touchScreen);
            return this;
        }

        public Builder setTouchpad(int i, TouchPad.Builder builder) {
            copyOnWrite();
            ((InputSourceService) this.instance).setTouchpad(i, builder);
            return this;
        }

        public Builder setTouchscreen(int i, TouchScreen.Builder builder) {
            copyOnWrite();
            ((InputSourceService) this.instance).setTouchscreen(i, builder);
            return this;
        }

        public Builder addTouchpad(TouchPad.Builder builder) {
            copyOnWrite();
            ((InputSourceService) this.instance).addTouchpad(builder);
            return this;
        }

        public Builder addTouchscreen(TouchScreen.Builder builder) {
            copyOnWrite();
            ((InputSourceService) this.instance).addTouchscreen(builder);
            return this;
        }

        public Builder addTouchpad(int i, TouchPad.Builder builder) {
            copyOnWrite();
            ((InputSourceService) this.instance).addTouchpad(i, builder);
            return this;
        }

        public Builder addTouchscreen(int i, TouchScreen.Builder builder) {
            copyOnWrite();
            ((InputSourceService) this.instance).addTouchscreen(i, builder);
            return this;
        }
    }

    public static final class TouchPad extends GeneratedMessageLite<TouchPad, Builder> implements TouchPadOrBuilder {
        private static final TouchPad DEFAULT_INSTANCE;
        public static final int HEIGHT_FIELD_NUMBER = 2;
        private static volatile Parser<TouchPad> PARSER = null;
        public static final int PHYSICAL_HEIGHT_FIELD_NUMBER = 5;
        public static final int PHYSICAL_WIDTH_FIELD_NUMBER = 4;
        public static final int SENSITIVITY_FIELD_NUMBER = 8;
        public static final int TAP_AS_SELECT_FIELD_NUMBER = 7;
        public static final int UI_ABSOLUTE_FIELD_NUMBER = 6;
        public static final int UI_NAVIGATION_FIELD_NUMBER = 3;
        public static final int WIDTH_FIELD_NUMBER = 1;
        private int bitField0_;
        private int height_;
        private byte memoizedIsInitialized = 2;
        private int physicalHeight_;
        private int physicalWidth_;
        private int sensitivity_;
        private boolean tapAsSelect_;
        private boolean uiAbsolute_;
        private boolean uiNavigation_;
        private int width_;

        public static final class Builder extends GeneratedMessageLite.Builder<TouchPad, Builder> implements TouchPadOrBuilder {
            public Builder clearHeight() {
                copyOnWrite();
                ((TouchPad) this.instance).clearHeight();
                return this;
            }

            public Builder clearPhysicalHeight() {
                copyOnWrite();
                ((TouchPad) this.instance).clearPhysicalHeight();
                return this;
            }

            public Builder clearPhysicalWidth() {
                copyOnWrite();
                ((TouchPad) this.instance).clearPhysicalWidth();
                return this;
            }

            public Builder clearSensitivity() {
                copyOnWrite();
                ((TouchPad) this.instance).clearSensitivity();
                return this;
            }

            public Builder clearTapAsSelect() {
                copyOnWrite();
                ((TouchPad) this.instance).clearTapAsSelect();
                return this;
            }

            public Builder clearUiAbsolute() {
                copyOnWrite();
                ((TouchPad) this.instance).clearUiAbsolute();
                return this;
            }

            public Builder clearUiNavigation() {
                copyOnWrite();
                ((TouchPad) this.instance).clearUiNavigation();
                return this;
            }

            public Builder clearWidth() {
                copyOnWrite();
                ((TouchPad) this.instance).clearWidth();
                return this;
            }

            @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
            public int getHeight() {
                return ((TouchPad) this.instance).getHeight();
            }

            @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
            public int getPhysicalHeight() {
                return ((TouchPad) this.instance).getPhysicalHeight();
            }

            @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
            public int getPhysicalWidth() {
                return ((TouchPad) this.instance).getPhysicalWidth();
            }

            @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
            public int getSensitivity() {
                return ((TouchPad) this.instance).getSensitivity();
            }

            @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
            public boolean getTapAsSelect() {
                return ((TouchPad) this.instance).getTapAsSelect();
            }

            @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
            public boolean getUiAbsolute() {
                return ((TouchPad) this.instance).getUiAbsolute();
            }

            @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
            public boolean getUiNavigation() {
                return ((TouchPad) this.instance).getUiNavigation();
            }

            @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
            public int getWidth() {
                return ((TouchPad) this.instance).getWidth();
            }

            @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
            public boolean hasHeight() {
                return ((TouchPad) this.instance).hasHeight();
            }

            @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
            public boolean hasPhysicalHeight() {
                return ((TouchPad) this.instance).hasPhysicalHeight();
            }

            @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
            public boolean hasPhysicalWidth() {
                return ((TouchPad) this.instance).hasPhysicalWidth();
            }

            @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
            public boolean hasSensitivity() {
                return ((TouchPad) this.instance).hasSensitivity();
            }

            @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
            public boolean hasTapAsSelect() {
                return ((TouchPad) this.instance).hasTapAsSelect();
            }

            @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
            public boolean hasUiAbsolute() {
                return ((TouchPad) this.instance).hasUiAbsolute();
            }

            @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
            public boolean hasUiNavigation() {
                return ((TouchPad) this.instance).hasUiNavigation();
            }

            @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
            public boolean hasWidth() {
                return ((TouchPad) this.instance).hasWidth();
            }

            public Builder setHeight(int i) {
                copyOnWrite();
                ((TouchPad) this.instance).setHeight(i);
                return this;
            }

            public Builder setPhysicalHeight(int i) {
                copyOnWrite();
                ((TouchPad) this.instance).setPhysicalHeight(i);
                return this;
            }

            public Builder setPhysicalWidth(int i) {
                copyOnWrite();
                ((TouchPad) this.instance).setPhysicalWidth(i);
                return this;
            }

            public Builder setSensitivity(int i) {
                copyOnWrite();
                ((TouchPad) this.instance).setSensitivity(i);
                return this;
            }

            public Builder setTapAsSelect(boolean z6) {
                copyOnWrite();
                ((TouchPad) this.instance).setTapAsSelect(z6);
                return this;
            }

            public Builder setUiAbsolute(boolean z6) {
                copyOnWrite();
                ((TouchPad) this.instance).setUiAbsolute(z6);
                return this;
            }

            public Builder setUiNavigation(boolean z6) {
                copyOnWrite();
                ((TouchPad) this.instance).setUiNavigation(z6);
                return this;
            }

            public Builder setWidth(int i) {
                copyOnWrite();
                ((TouchPad) this.instance).setWidth(i);
                return this;
            }

            private Builder() {
                super(TouchPad.DEFAULT_INSTANCE);
            }
        }

        static {
            TouchPad touchPad = new TouchPad();
            DEFAULT_INSTANCE = touchPad;
            GeneratedMessageLite.registerDefaultInstance(TouchPad.class, touchPad);
        }

        private TouchPad() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHeight() {
            this.bitField0_ &= -3;
            this.height_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPhysicalHeight() {
            this.bitField0_ &= -17;
            this.physicalHeight_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPhysicalWidth() {
            this.bitField0_ &= -9;
            this.physicalWidth_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSensitivity() {
            this.bitField0_ &= -129;
            this.sensitivity_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTapAsSelect() {
            this.bitField0_ &= -65;
            this.tapAsSelect_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUiAbsolute() {
            this.bitField0_ &= -33;
            this.uiAbsolute_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUiNavigation() {
            this.bitField0_ &= -5;
            this.uiNavigation_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWidth() {
            this.bitField0_ &= -2;
            this.width_ = 0;
        }

        public static TouchPad getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TouchPad parseDelimitedFrom(InputStream inputStream) {
            return (TouchPad) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TouchPad parseFrom(ByteBuffer byteBuffer) {
            return (TouchPad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<TouchPad> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHeight(int i) {
            this.bitField0_ |= 2;
            this.height_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPhysicalHeight(int i) {
            this.bitField0_ |= 16;
            this.physicalHeight_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPhysicalWidth(int i) {
            this.bitField0_ |= 8;
            this.physicalWidth_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSensitivity(int i) {
            this.bitField0_ |= 128;
            this.sensitivity_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTapAsSelect(boolean z6) {
            this.bitField0_ |= 64;
            this.tapAsSelect_ = z6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUiAbsolute(boolean z6) {
            this.bitField0_ |= 32;
            this.uiAbsolute_ = z6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUiNavigation(boolean z6) {
            this.bitField0_ |= 4;
            this.uiNavigation_ = z6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWidth(int i) {
            this.bitField0_ |= 1;
            this.width_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass2.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TouchPad();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0002\u0001Ԅ\u0000\u0002Ԅ\u0001\u0003\u0007\u0002\u0004\u0004\u0003\u0005\u0004\u0004\u0006\u0007\u0005\u0007\u0007\u0006\b\u0004\u0007", new Object[]{"bitField0_", "width_", "height_", "uiNavigation_", "physicalWidth_", "physicalHeight_", "uiAbsolute_", "tapAsSelect_", "sensitivity_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<TouchPad> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (TouchPad.class) {
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

        @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
        public int getHeight() {
            return this.height_;
        }

        @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
        public int getPhysicalHeight() {
            return this.physicalHeight_;
        }

        @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
        public int getPhysicalWidth() {
            return this.physicalWidth_;
        }

        @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
        public int getSensitivity() {
            return this.sensitivity_;
        }

        @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
        public boolean getTapAsSelect() {
            return this.tapAsSelect_;
        }

        @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
        public boolean getUiAbsolute() {
            return this.uiAbsolute_;
        }

        @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
        public boolean getUiNavigation() {
            return this.uiNavigation_;
        }

        @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
        public int getWidth() {
            return this.width_;
        }

        @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
        public boolean hasHeight() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
        public boolean hasPhysicalHeight() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
        public boolean hasPhysicalWidth() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
        public boolean hasSensitivity() {
            return (this.bitField0_ & 128) != 0;
        }

        @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
        public boolean hasTapAsSelect() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
        public boolean hasUiAbsolute() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
        public boolean hasUiNavigation() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // fr.sd.taada.proto.InputSourceService.TouchPadOrBuilder
        public boolean hasWidth() {
            return (this.bitField0_ & 1) != 0;
        }

        public static Builder newBuilder(TouchPad touchPad) {
            return DEFAULT_INSTANCE.createBuilder(touchPad);
        }

        public static TouchPad parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (TouchPad) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TouchPad parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (TouchPad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static TouchPad parseFrom(ByteString byteString) {
            return (TouchPad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TouchPad parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (TouchPad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static TouchPad parseFrom(byte[] bArr) {
            return (TouchPad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TouchPad parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (TouchPad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static TouchPad parseFrom(InputStream inputStream) {
            return (TouchPad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TouchPad parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (TouchPad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TouchPad parseFrom(CodedInputStream codedInputStream) {
            return (TouchPad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static TouchPad parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (TouchPad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface TouchPadOrBuilder extends MessageLiteOrBuilder {
        int getHeight();

        int getPhysicalHeight();

        int getPhysicalWidth();

        int getSensitivity();

        boolean getTapAsSelect();

        boolean getUiAbsolute();

        boolean getUiNavigation();

        int getWidth();

        boolean hasHeight();

        boolean hasPhysicalHeight();

        boolean hasPhysicalWidth();

        boolean hasSensitivity();

        boolean hasTapAsSelect();

        boolean hasUiAbsolute();

        boolean hasUiNavigation();

        boolean hasWidth();
    }

    public static final class TouchScreen extends GeneratedMessageLite<TouchScreen, Builder> implements TouchScreenOrBuilder {
        private static final TouchScreen DEFAULT_INSTANCE;
        public static final int HEIGHT_FIELD_NUMBER = 2;
        public static final int IS_SECONDARY_FIELD_NUMBER = 4;
        private static volatile Parser<TouchScreen> PARSER = null;
        public static final int TYPE_FIELD_NUMBER = 3;
        public static final int WIDTH_FIELD_NUMBER = 1;
        private int bitField0_;
        private int height_;
        private boolean isSecondary_;
        private byte memoizedIsInitialized = 2;
        private int type_ = 1;
        private int width_;

        public static final class Builder extends GeneratedMessageLite.Builder<TouchScreen, Builder> implements TouchScreenOrBuilder {
            public Builder clearHeight() {
                copyOnWrite();
                ((TouchScreen) this.instance).clearHeight();
                return this;
            }

            public Builder clearIsSecondary() {
                copyOnWrite();
                ((TouchScreen) this.instance).clearIsSecondary();
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((TouchScreen) this.instance).clearType();
                return this;
            }

            public Builder clearWidth() {
                copyOnWrite();
                ((TouchScreen) this.instance).clearWidth();
                return this;
            }

            @Override // fr.sd.taada.proto.InputSourceService.TouchScreenOrBuilder
            public int getHeight() {
                return ((TouchScreen) this.instance).getHeight();
            }

            @Override // fr.sd.taada.proto.InputSourceService.TouchScreenOrBuilder
            public boolean getIsSecondary() {
                return ((TouchScreen) this.instance).getIsSecondary();
            }

            @Override // fr.sd.taada.proto.InputSourceService.TouchScreenOrBuilder
            public TouchScreenType getType() {
                return ((TouchScreen) this.instance).getType();
            }

            @Override // fr.sd.taada.proto.InputSourceService.TouchScreenOrBuilder
            public int getWidth() {
                return ((TouchScreen) this.instance).getWidth();
            }

            @Override // fr.sd.taada.proto.InputSourceService.TouchScreenOrBuilder
            public boolean hasHeight() {
                return ((TouchScreen) this.instance).hasHeight();
            }

            @Override // fr.sd.taada.proto.InputSourceService.TouchScreenOrBuilder
            public boolean hasIsSecondary() {
                return ((TouchScreen) this.instance).hasIsSecondary();
            }

            @Override // fr.sd.taada.proto.InputSourceService.TouchScreenOrBuilder
            public boolean hasType() {
                return ((TouchScreen) this.instance).hasType();
            }

            @Override // fr.sd.taada.proto.InputSourceService.TouchScreenOrBuilder
            public boolean hasWidth() {
                return ((TouchScreen) this.instance).hasWidth();
            }

            public Builder setHeight(int i) {
                copyOnWrite();
                ((TouchScreen) this.instance).setHeight(i);
                return this;
            }

            public Builder setIsSecondary(boolean z6) {
                copyOnWrite();
                ((TouchScreen) this.instance).setIsSecondary(z6);
                return this;
            }

            public Builder setType(TouchScreenType touchScreenType) {
                copyOnWrite();
                ((TouchScreen) this.instance).setType(touchScreenType);
                return this;
            }

            public Builder setWidth(int i) {
                copyOnWrite();
                ((TouchScreen) this.instance).setWidth(i);
                return this;
            }

            private Builder() {
                super(TouchScreen.DEFAULT_INSTANCE);
            }
        }

        static {
            TouchScreen touchScreen = new TouchScreen();
            DEFAULT_INSTANCE = touchScreen;
            GeneratedMessageLite.registerDefaultInstance(TouchScreen.class, touchScreen);
        }

        private TouchScreen() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHeight() {
            this.bitField0_ &= -3;
            this.height_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsSecondary() {
            this.bitField0_ &= -9;
            this.isSecondary_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearType() {
            this.bitField0_ &= -5;
            this.type_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWidth() {
            this.bitField0_ &= -2;
            this.width_ = 0;
        }

        public static TouchScreen getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TouchScreen parseDelimitedFrom(InputStream inputStream) {
            return (TouchScreen) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TouchScreen parseFrom(ByteBuffer byteBuffer) {
            return (TouchScreen) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<TouchScreen> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHeight(int i) {
            this.bitField0_ |= 2;
            this.height_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsSecondary(boolean z6) {
            this.bitField0_ |= 8;
            this.isSecondary_ = z6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setType(TouchScreenType touchScreenType) {
            touchScreenType.getClass();
            this.bitField0_ |= 4;
            this.type_ = touchScreenType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWidth(int i) {
            this.bitField0_ |= 1;
            this.width_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (AnonymousClass2.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TouchScreen();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0002\u0001Ԅ\u0000\u0002Ԅ\u0001\u0003\f\u0002\u0004\u0007\u0003", new Object[]{"bitField0_", "width_", "height_", "type_", TouchScreenType.internalGetVerifier(), "isSecondary_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<TouchScreen> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (TouchScreen.class) {
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

        @Override // fr.sd.taada.proto.InputSourceService.TouchScreenOrBuilder
        public int getHeight() {
            return this.height_;
        }

        @Override // fr.sd.taada.proto.InputSourceService.TouchScreenOrBuilder
        public boolean getIsSecondary() {
            return this.isSecondary_;
        }

        @Override // fr.sd.taada.proto.InputSourceService.TouchScreenOrBuilder
        public TouchScreenType getType() {
            TouchScreenType touchScreenTypeForNumber = TouchScreenType.forNumber(this.type_);
            return touchScreenTypeForNumber == null ? TouchScreenType.CAPACITIVE : touchScreenTypeForNumber;
        }

        @Override // fr.sd.taada.proto.InputSourceService.TouchScreenOrBuilder
        public int getWidth() {
            return this.width_;
        }

        @Override // fr.sd.taada.proto.InputSourceService.TouchScreenOrBuilder
        public boolean hasHeight() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // fr.sd.taada.proto.InputSourceService.TouchScreenOrBuilder
        public boolean hasIsSecondary() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // fr.sd.taada.proto.InputSourceService.TouchScreenOrBuilder
        public boolean hasType() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // fr.sd.taada.proto.InputSourceService.TouchScreenOrBuilder
        public boolean hasWidth() {
            return (this.bitField0_ & 1) != 0;
        }

        public static Builder newBuilder(TouchScreen touchScreen) {
            return DEFAULT_INSTANCE.createBuilder(touchScreen);
        }

        public static TouchScreen parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (TouchScreen) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TouchScreen parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (TouchScreen) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static TouchScreen parseFrom(ByteString byteString) {
            return (TouchScreen) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TouchScreen parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (TouchScreen) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static TouchScreen parseFrom(byte[] bArr) {
            return (TouchScreen) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TouchScreen parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (TouchScreen) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static TouchScreen parseFrom(InputStream inputStream) {
            return (TouchScreen) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TouchScreen parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (TouchScreen) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TouchScreen parseFrom(CodedInputStream codedInputStream) {
            return (TouchScreen) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static TouchScreen parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (TouchScreen) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface TouchScreenOrBuilder extends MessageLiteOrBuilder {
        int getHeight();

        boolean getIsSecondary();

        TouchScreenType getType();

        int getWidth();

        boolean hasHeight();

        boolean hasIsSecondary();

        boolean hasType();

        boolean hasWidth();
    }

    static {
        InputSourceService inputSourceService = new InputSourceService();
        DEFAULT_INSTANCE = inputSourceService;
        GeneratedMessageLite.registerDefaultInstance(InputSourceService.class, inputSourceService);
    }

    private InputSourceService() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllFeedbackEventsSupported(Iterable<? extends FeedbackEvent> iterable) {
        ensureFeedbackEventsSupportedIsMutable();
        Iterator<? extends FeedbackEvent> it = iterable.iterator();
        while (it.hasNext()) {
            this.feedbackEventsSupported_.addInt(it.next().getNumber());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllKeycodesSupported(Iterable<? extends Integer> iterable) {
        ensureKeycodesSupportedIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.keycodesSupported_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTouchpad(Iterable<? extends TouchPad> iterable) {
        ensureTouchpadIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.touchpad_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTouchscreen(Iterable<? extends TouchScreen> iterable) {
        ensureTouchscreenIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.touchscreen_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFeedbackEventsSupported(FeedbackEvent feedbackEvent) {
        feedbackEvent.getClass();
        ensureFeedbackEventsSupportedIsMutable();
        this.feedbackEventsSupported_.addInt(feedbackEvent.getNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addKeycodesSupported(int i) {
        ensureKeycodesSupportedIsMutable();
        this.keycodesSupported_.addInt(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTouchpad(TouchPad touchPad) {
        touchPad.getClass();
        ensureTouchpadIsMutable();
        this.touchpad_.add(touchPad);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTouchscreen(TouchScreen touchScreen) {
        touchScreen.getClass();
        ensureTouchscreenIsMutable();
        this.touchscreen_.add(touchScreen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisplayId() {
        this.bitField0_ &= -2;
        this.displayId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFeedbackEventsSupported() {
        this.feedbackEventsSupported_ = GeneratedMessageLite.emptyIntList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeycodesSupported() {
        this.keycodesSupported_ = GeneratedMessageLite.emptyIntList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTouchpad() {
        this.touchpad_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTouchscreen() {
        this.touchscreen_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureFeedbackEventsSupportedIsMutable() {
        if (this.feedbackEventsSupported_.isModifiable()) {
            return;
        }
        this.feedbackEventsSupported_ = GeneratedMessageLite.mutableCopy(this.feedbackEventsSupported_);
    }

    private void ensureKeycodesSupportedIsMutable() {
        if (this.keycodesSupported_.isModifiable()) {
            return;
        }
        this.keycodesSupported_ = GeneratedMessageLite.mutableCopy(this.keycodesSupported_);
    }

    private void ensureTouchpadIsMutable() {
        if (this.touchpad_.isModifiable()) {
            return;
        }
        this.touchpad_ = GeneratedMessageLite.mutableCopy(this.touchpad_);
    }

    private void ensureTouchscreenIsMutable() {
        if (this.touchscreen_.isModifiable()) {
            return;
        }
        this.touchscreen_ = GeneratedMessageLite.mutableCopy(this.touchscreen_);
    }

    public static InputSourceService getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static InputSourceService parseDelimitedFrom(InputStream inputStream) {
        return (InputSourceService) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static InputSourceService parseFrom(ByteBuffer byteBuffer) {
        return (InputSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<InputSourceService> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTouchpad(int i) {
        ensureTouchpadIsMutable();
        this.touchpad_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTouchscreen(int i) {
        ensureTouchscreenIsMutable();
        this.touchscreen_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayId(int i) {
        this.bitField0_ |= 1;
        this.displayId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFeedbackEventsSupported(int i, FeedbackEvent feedbackEvent) {
        feedbackEvent.getClass();
        ensureFeedbackEventsSupportedIsMutable();
        this.feedbackEventsSupported_.setInt(i, feedbackEvent.getNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeycodesSupported(int i, int i3) {
        ensureKeycodesSupportedIsMutable();
        this.keycodesSupported_.setInt(i, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTouchpad(int i, TouchPad touchPad) {
        touchPad.getClass();
        ensureTouchpadIsMutable();
        this.touchpad_.set(i, touchPad);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTouchscreen(int i, TouchScreen touchScreen) {
        touchScreen.getClass();
        ensureTouchscreenIsMutable();
        this.touchscreen_.set(i, touchScreen);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (AnonymousClass2.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new InputSourceService();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0004\u0002\u0001'\u0002Л\u0003Л\u0004\u001e\u0005\u000b\u0000", new Object[]{"bitField0_", "keycodesSupported_", "touchscreen_", TouchScreen.class, "touchpad_", TouchPad.class, "feedbackEventsSupported_", FeedbackEvent.internalGetVerifier(), "displayId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<InputSourceService> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (InputSourceService.class) {
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

    @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
    public int getDisplayId() {
        return this.displayId_;
    }

    @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
    public FeedbackEvent getFeedbackEventsSupported(int i) {
        return feedbackEventsSupported_converter_.convert(Integer.valueOf(this.feedbackEventsSupported_.getInt(i)));
    }

    @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
    public int getFeedbackEventsSupportedCount() {
        return this.feedbackEventsSupported_.size();
    }

    @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
    public List<FeedbackEvent> getFeedbackEventsSupportedList() {
        return new Internal.ListAdapter(this.feedbackEventsSupported_, feedbackEventsSupported_converter_);
    }

    @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
    public int getKeycodesSupported(int i) {
        return this.keycodesSupported_.getInt(i);
    }

    @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
    public int getKeycodesSupportedCount() {
        return this.keycodesSupported_.size();
    }

    @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
    public List<Integer> getKeycodesSupportedList() {
        return this.keycodesSupported_;
    }

    @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
    public TouchPad getTouchpad(int i) {
        return this.touchpad_.get(i);
    }

    @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
    public int getTouchpadCount() {
        return this.touchpad_.size();
    }

    @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
    public List<TouchPad> getTouchpadList() {
        return this.touchpad_;
    }

    public TouchPadOrBuilder getTouchpadOrBuilder(int i) {
        return this.touchpad_.get(i);
    }

    public List<? extends TouchPadOrBuilder> getTouchpadOrBuilderList() {
        return this.touchpad_;
    }

    @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
    public TouchScreen getTouchscreen(int i) {
        return this.touchscreen_.get(i);
    }

    @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
    public int getTouchscreenCount() {
        return this.touchscreen_.size();
    }

    @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
    public List<TouchScreen> getTouchscreenList() {
        return this.touchscreen_;
    }

    public TouchScreenOrBuilder getTouchscreenOrBuilder(int i) {
        return this.touchscreen_.get(i);
    }

    public List<? extends TouchScreenOrBuilder> getTouchscreenOrBuilderList() {
        return this.touchscreen_;
    }

    @Override // fr.sd.taada.proto.InputSourceServiceOrBuilder
    public boolean hasDisplayId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(InputSourceService inputSourceService) {
        return DEFAULT_INSTANCE.createBuilder(inputSourceService);
    }

    public static InputSourceService parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (InputSourceService) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static InputSourceService parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (InputSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static InputSourceService parseFrom(ByteString byteString) {
        return (InputSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTouchpad(int i, TouchPad touchPad) {
        touchPad.getClass();
        ensureTouchpadIsMutable();
        this.touchpad_.add(i, touchPad);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTouchscreen(int i, TouchScreen touchScreen) {
        touchScreen.getClass();
        ensureTouchscreenIsMutable();
        this.touchscreen_.add(i, touchScreen);
    }

    public static InputSourceService parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (InputSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTouchpad(int i, TouchPad.Builder builder) {
        ensureTouchpadIsMutable();
        this.touchpad_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTouchscreen(int i, TouchScreen.Builder builder) {
        ensureTouchscreenIsMutable();
        this.touchscreen_.set(i, builder.build());
    }

    public static InputSourceService parseFrom(byte[] bArr) {
        return (InputSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static InputSourceService parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (InputSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTouchpad(TouchPad.Builder builder) {
        ensureTouchpadIsMutable();
        this.touchpad_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTouchscreen(TouchScreen.Builder builder) {
        ensureTouchscreenIsMutable();
        this.touchscreen_.add(builder.build());
    }

    public static InputSourceService parseFrom(InputStream inputStream) {
        return (InputSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static InputSourceService parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (InputSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTouchpad(int i, TouchPad.Builder builder) {
        ensureTouchpadIsMutable();
        this.touchpad_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTouchscreen(int i, TouchScreen.Builder builder) {
        ensureTouchscreenIsMutable();
        this.touchscreen_.add(i, builder.build());
    }

    public static InputSourceService parseFrom(CodedInputStream codedInputStream) {
        return (InputSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static InputSourceService parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (InputSourceService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
