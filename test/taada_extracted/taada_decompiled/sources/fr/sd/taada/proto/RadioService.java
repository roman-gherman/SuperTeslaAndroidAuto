package fr.sd.taada.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.RadioProperties;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class RadioService extends GeneratedMessageLite<RadioService, Builder> implements RadioServiceOrBuilder {
    private static final RadioService DEFAULT_INSTANCE;
    private static volatile Parser<RadioService> PARSER = null;
    public static final int RADIO_PROPERTIES_FIELD_NUMBER = 1;
    private byte memoizedIsInitialized = 2;
    private Internal.ProtobufList<RadioProperties> radioProperties_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.RadioService$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<RadioService, Builder> implements RadioServiceOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllRadioProperties(Iterable<? extends RadioProperties> iterable) {
            copyOnWrite();
            ((RadioService) this.instance).addAllRadioProperties(iterable);
            return this;
        }

        public Builder addRadioProperties(RadioProperties radioProperties) {
            copyOnWrite();
            ((RadioService) this.instance).addRadioProperties(radioProperties);
            return this;
        }

        public Builder clearRadioProperties() {
            copyOnWrite();
            ((RadioService) this.instance).clearRadioProperties();
            return this;
        }

        @Override // fr.sd.taada.proto.RadioServiceOrBuilder
        public RadioProperties getRadioProperties(int i) {
            return ((RadioService) this.instance).getRadioProperties(i);
        }

        @Override // fr.sd.taada.proto.RadioServiceOrBuilder
        public int getRadioPropertiesCount() {
            return ((RadioService) this.instance).getRadioPropertiesCount();
        }

        @Override // fr.sd.taada.proto.RadioServiceOrBuilder
        public List<RadioProperties> getRadioPropertiesList() {
            return Collections.unmodifiableList(((RadioService) this.instance).getRadioPropertiesList());
        }

        public Builder removeRadioProperties(int i) {
            copyOnWrite();
            ((RadioService) this.instance).removeRadioProperties(i);
            return this;
        }

        public Builder setRadioProperties(int i, RadioProperties radioProperties) {
            copyOnWrite();
            ((RadioService) this.instance).setRadioProperties(i, radioProperties);
            return this;
        }

        private Builder() {
            super(RadioService.DEFAULT_INSTANCE);
        }

        public Builder addRadioProperties(int i, RadioProperties radioProperties) {
            copyOnWrite();
            ((RadioService) this.instance).addRadioProperties(i, radioProperties);
            return this;
        }

        public Builder setRadioProperties(int i, RadioProperties.Builder builder) {
            copyOnWrite();
            ((RadioService) this.instance).setRadioProperties(i, builder);
            return this;
        }

        public Builder addRadioProperties(RadioProperties.Builder builder) {
            copyOnWrite();
            ((RadioService) this.instance).addRadioProperties(builder);
            return this;
        }

        public Builder addRadioProperties(int i, RadioProperties.Builder builder) {
            copyOnWrite();
            ((RadioService) this.instance).addRadioProperties(i, builder);
            return this;
        }
    }

    static {
        RadioService radioService = new RadioService();
        DEFAULT_INSTANCE = radioService;
        GeneratedMessageLite.registerDefaultInstance(RadioService.class, radioService);
    }

    private RadioService() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRadioProperties(Iterable<? extends RadioProperties> iterable) {
        ensureRadioPropertiesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.radioProperties_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRadioProperties(RadioProperties radioProperties) {
        radioProperties.getClass();
        ensureRadioPropertiesIsMutable();
        this.radioProperties_.add(radioProperties);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRadioProperties() {
        this.radioProperties_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureRadioPropertiesIsMutable() {
        if (this.radioProperties_.isModifiable()) {
            return;
        }
        this.radioProperties_ = GeneratedMessageLite.mutableCopy(this.radioProperties_);
    }

    public static RadioService getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static RadioService parseDelimitedFrom(InputStream inputStream) {
        return (RadioService) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RadioService parseFrom(ByteBuffer byteBuffer) {
        return (RadioService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<RadioService> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeRadioProperties(int i) {
        ensureRadioPropertiesIsMutable();
        this.radioProperties_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRadioProperties(int i, RadioProperties radioProperties) {
        radioProperties.getClass();
        ensureRadioPropertiesIsMutable();
        this.radioProperties_.set(i, radioProperties);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RadioService();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"radioProperties_", RadioProperties.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RadioService> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (RadioService.class) {
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

    @Override // fr.sd.taada.proto.RadioServiceOrBuilder
    public RadioProperties getRadioProperties(int i) {
        return this.radioProperties_.get(i);
    }

    @Override // fr.sd.taada.proto.RadioServiceOrBuilder
    public int getRadioPropertiesCount() {
        return this.radioProperties_.size();
    }

    @Override // fr.sd.taada.proto.RadioServiceOrBuilder
    public List<RadioProperties> getRadioPropertiesList() {
        return this.radioProperties_;
    }

    public RadioPropertiesOrBuilder getRadioPropertiesOrBuilder(int i) {
        return this.radioProperties_.get(i);
    }

    public List<? extends RadioPropertiesOrBuilder> getRadioPropertiesOrBuilderList() {
        return this.radioProperties_;
    }

    public static Builder newBuilder(RadioService radioService) {
        return DEFAULT_INSTANCE.createBuilder(radioService);
    }

    public static RadioService parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioService) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RadioService parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static RadioService parseFrom(ByteString byteString) {
        return (RadioService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRadioProperties(int i, RadioProperties radioProperties) {
        radioProperties.getClass();
        ensureRadioPropertiesIsMutable();
        this.radioProperties_.add(i, radioProperties);
    }

    public static RadioService parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRadioProperties(int i, RadioProperties.Builder builder) {
        ensureRadioPropertiesIsMutable();
        this.radioProperties_.set(i, builder.build());
    }

    public static RadioService parseFrom(byte[] bArr) {
        return (RadioService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RadioService parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRadioProperties(RadioProperties.Builder builder) {
        ensureRadioPropertiesIsMutable();
        this.radioProperties_.add(builder.build());
    }

    public static RadioService parseFrom(InputStream inputStream) {
        return (RadioService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RadioService parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRadioProperties(int i, RadioProperties.Builder builder) {
        ensureRadioPropertiesIsMutable();
        this.radioProperties_.add(i, builder.build());
    }

    public static RadioService parseFrom(CodedInputStream codedInputStream) {
        return (RadioService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RadioService parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
