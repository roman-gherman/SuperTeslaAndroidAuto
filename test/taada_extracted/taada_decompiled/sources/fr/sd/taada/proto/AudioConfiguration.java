package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class AudioConfiguration extends GeneratedMessageLite<AudioConfiguration, Builder> implements AudioConfigurationOrBuilder {
    private static final AudioConfiguration DEFAULT_INSTANCE;
    public static final int NUMBER_OF_BITS_FIELD_NUMBER = 2;
    public static final int NUMBER_OF_CHANNELS_FIELD_NUMBER = 3;
    private static volatile Parser<AudioConfiguration> PARSER = null;
    public static final int SAMPLING_RATE_FIELD_NUMBER = 1;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int numberOfBits_;
    private int numberOfChannels_;
    private int samplingRate_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.AudioConfiguration$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<AudioConfiguration, Builder> implements AudioConfigurationOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearNumberOfBits() {
            copyOnWrite();
            ((AudioConfiguration) this.instance).clearNumberOfBits();
            return this;
        }

        public Builder clearNumberOfChannels() {
            copyOnWrite();
            ((AudioConfiguration) this.instance).clearNumberOfChannels();
            return this;
        }

        public Builder clearSamplingRate() {
            copyOnWrite();
            ((AudioConfiguration) this.instance).clearSamplingRate();
            return this;
        }

        @Override // fr.sd.taada.proto.AudioConfigurationOrBuilder
        public int getNumberOfBits() {
            return ((AudioConfiguration) this.instance).getNumberOfBits();
        }

        @Override // fr.sd.taada.proto.AudioConfigurationOrBuilder
        public int getNumberOfChannels() {
            return ((AudioConfiguration) this.instance).getNumberOfChannels();
        }

        @Override // fr.sd.taada.proto.AudioConfigurationOrBuilder
        public int getSamplingRate() {
            return ((AudioConfiguration) this.instance).getSamplingRate();
        }

        @Override // fr.sd.taada.proto.AudioConfigurationOrBuilder
        public boolean hasNumberOfBits() {
            return ((AudioConfiguration) this.instance).hasNumberOfBits();
        }

        @Override // fr.sd.taada.proto.AudioConfigurationOrBuilder
        public boolean hasNumberOfChannels() {
            return ((AudioConfiguration) this.instance).hasNumberOfChannels();
        }

        @Override // fr.sd.taada.proto.AudioConfigurationOrBuilder
        public boolean hasSamplingRate() {
            return ((AudioConfiguration) this.instance).hasSamplingRate();
        }

        public Builder setNumberOfBits(int i) {
            copyOnWrite();
            ((AudioConfiguration) this.instance).setNumberOfBits(i);
            return this;
        }

        public Builder setNumberOfChannels(int i) {
            copyOnWrite();
            ((AudioConfiguration) this.instance).setNumberOfChannels(i);
            return this;
        }

        public Builder setSamplingRate(int i) {
            copyOnWrite();
            ((AudioConfiguration) this.instance).setSamplingRate(i);
            return this;
        }

        private Builder() {
            super(AudioConfiguration.DEFAULT_INSTANCE);
        }
    }

    static {
        AudioConfiguration audioConfiguration = new AudioConfiguration();
        DEFAULT_INSTANCE = audioConfiguration;
        GeneratedMessageLite.registerDefaultInstance(AudioConfiguration.class, audioConfiguration);
    }

    private AudioConfiguration() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumberOfBits() {
        this.bitField0_ &= -3;
        this.numberOfBits_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumberOfChannels() {
        this.bitField0_ &= -5;
        this.numberOfChannels_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSamplingRate() {
        this.bitField0_ &= -2;
        this.samplingRate_ = 0;
    }

    public static AudioConfiguration getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static AudioConfiguration parseDelimitedFrom(InputStream inputStream) {
        return (AudioConfiguration) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AudioConfiguration parseFrom(ByteBuffer byteBuffer) {
        return (AudioConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<AudioConfiguration> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumberOfBits(int i) {
        this.bitField0_ |= 2;
        this.numberOfBits_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumberOfChannels(int i) {
        this.bitField0_ |= 4;
        this.numberOfChannels_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSamplingRate(int i) {
        this.bitField0_ |= 1;
        this.samplingRate_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new AudioConfiguration();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001ԋ\u0000\u0002ԋ\u0001\u0003ԋ\u0002", new Object[]{"bitField0_", "samplingRate_", "numberOfBits_", "numberOfChannels_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AudioConfiguration> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (AudioConfiguration.class) {
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

    @Override // fr.sd.taada.proto.AudioConfigurationOrBuilder
    public int getNumberOfBits() {
        return this.numberOfBits_;
    }

    @Override // fr.sd.taada.proto.AudioConfigurationOrBuilder
    public int getNumberOfChannels() {
        return this.numberOfChannels_;
    }

    @Override // fr.sd.taada.proto.AudioConfigurationOrBuilder
    public int getSamplingRate() {
        return this.samplingRate_;
    }

    @Override // fr.sd.taada.proto.AudioConfigurationOrBuilder
    public boolean hasNumberOfBits() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.AudioConfigurationOrBuilder
    public boolean hasNumberOfChannels() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.AudioConfigurationOrBuilder
    public boolean hasSamplingRate() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(AudioConfiguration audioConfiguration) {
        return DEFAULT_INSTANCE.createBuilder(audioConfiguration);
    }

    public static AudioConfiguration parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AudioConfiguration) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AudioConfiguration parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (AudioConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AudioConfiguration parseFrom(ByteString byteString) {
        return (AudioConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AudioConfiguration parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (AudioConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AudioConfiguration parseFrom(byte[] bArr) {
        return (AudioConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AudioConfiguration parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (AudioConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AudioConfiguration parseFrom(InputStream inputStream) {
        return (AudioConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AudioConfiguration parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AudioConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AudioConfiguration parseFrom(CodedInputStream codedInputStream) {
        return (AudioConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AudioConfiguration parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AudioConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
