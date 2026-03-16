package fr.sd.taada.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class NavigationCue extends GeneratedMessageLite<NavigationCue, Builder> implements NavigationCueOrBuilder {
    public static final int ALTERNATE_TEXT_FIELD_NUMBER = 1;
    private static final NavigationCue DEFAULT_INSTANCE;
    private static volatile Parser<NavigationCue> PARSER;
    private Internal.ProtobufList<String> alternateText_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.NavigationCue$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<NavigationCue, Builder> implements NavigationCueOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllAlternateText(Iterable<String> iterable) {
            copyOnWrite();
            ((NavigationCue) this.instance).addAllAlternateText(iterable);
            return this;
        }

        public Builder addAlternateText(String str) {
            copyOnWrite();
            ((NavigationCue) this.instance).addAlternateText(str);
            return this;
        }

        public Builder addAlternateTextBytes(ByteString byteString) {
            copyOnWrite();
            ((NavigationCue) this.instance).addAlternateTextBytes(byteString);
            return this;
        }

        public Builder clearAlternateText() {
            copyOnWrite();
            ((NavigationCue) this.instance).clearAlternateText();
            return this;
        }

        @Override // fr.sd.taada.proto.NavigationCueOrBuilder
        public String getAlternateText(int i) {
            return ((NavigationCue) this.instance).getAlternateText(i);
        }

        @Override // fr.sd.taada.proto.NavigationCueOrBuilder
        public ByteString getAlternateTextBytes(int i) {
            return ((NavigationCue) this.instance).getAlternateTextBytes(i);
        }

        @Override // fr.sd.taada.proto.NavigationCueOrBuilder
        public int getAlternateTextCount() {
            return ((NavigationCue) this.instance).getAlternateTextCount();
        }

        @Override // fr.sd.taada.proto.NavigationCueOrBuilder
        public List<String> getAlternateTextList() {
            return Collections.unmodifiableList(((NavigationCue) this.instance).getAlternateTextList());
        }

        public Builder setAlternateText(int i, String str) {
            copyOnWrite();
            ((NavigationCue) this.instance).setAlternateText(i, str);
            return this;
        }

        private Builder() {
            super(NavigationCue.DEFAULT_INSTANCE);
        }
    }

    static {
        NavigationCue navigationCue = new NavigationCue();
        DEFAULT_INSTANCE = navigationCue;
        GeneratedMessageLite.registerDefaultInstance(NavigationCue.class, navigationCue);
    }

    private NavigationCue() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAlternateText(Iterable<String> iterable) {
        ensureAlternateTextIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.alternateText_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAlternateText(String str) {
        str.getClass();
        ensureAlternateTextIsMutable();
        this.alternateText_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAlternateTextBytes(ByteString byteString) {
        byteString.getClass();
        ensureAlternateTextIsMutable();
        this.alternateText_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAlternateText() {
        this.alternateText_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureAlternateTextIsMutable() {
        if (this.alternateText_.isModifiable()) {
            return;
        }
        this.alternateText_ = GeneratedMessageLite.mutableCopy(this.alternateText_);
    }

    public static NavigationCue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static NavigationCue parseDelimitedFrom(InputStream inputStream) {
        return (NavigationCue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationCue parseFrom(ByteBuffer byteBuffer) {
        return (NavigationCue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<NavigationCue> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlternateText(int i, String str) {
        str.getClass();
        ensureAlternateTextIsMutable();
        this.alternateText_.set(i, str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new NavigationCue();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"alternateText_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<NavigationCue> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (NavigationCue.class) {
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

    @Override // fr.sd.taada.proto.NavigationCueOrBuilder
    public String getAlternateText(int i) {
        return this.alternateText_.get(i);
    }

    @Override // fr.sd.taada.proto.NavigationCueOrBuilder
    public ByteString getAlternateTextBytes(int i) {
        return ByteString.copyFromUtf8(this.alternateText_.get(i));
    }

    @Override // fr.sd.taada.proto.NavigationCueOrBuilder
    public int getAlternateTextCount() {
        return this.alternateText_.size();
    }

    @Override // fr.sd.taada.proto.NavigationCueOrBuilder
    public List<String> getAlternateTextList() {
        return this.alternateText_;
    }

    public static Builder newBuilder(NavigationCue navigationCue) {
        return DEFAULT_INSTANCE.createBuilder(navigationCue);
    }

    public static NavigationCue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationCue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavigationCue parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationCue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static NavigationCue parseFrom(ByteString byteString) {
        return (NavigationCue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static NavigationCue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationCue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static NavigationCue parseFrom(byte[] bArr) {
        return (NavigationCue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NavigationCue parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationCue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static NavigationCue parseFrom(InputStream inputStream) {
        return (NavigationCue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationCue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationCue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavigationCue parseFrom(CodedInputStream codedInputStream) {
        return (NavigationCue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static NavigationCue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationCue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
