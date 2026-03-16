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
public final class KeyBindingRequest extends GeneratedMessageLite<KeyBindingRequest, Builder> implements KeyBindingRequestOrBuilder {
    private static final KeyBindingRequest DEFAULT_INSTANCE;
    public static final int KEYCODES_FIELD_NUMBER = 1;
    private static volatile Parser<KeyBindingRequest> PARSER;
    private int keycodesMemoizedSerializedSize = -1;
    private Internal.IntList keycodes_ = GeneratedMessageLite.emptyIntList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.KeyBindingRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<KeyBindingRequest, Builder> implements KeyBindingRequestOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllKeycodes(Iterable<? extends Integer> iterable) {
            copyOnWrite();
            ((KeyBindingRequest) this.instance).addAllKeycodes(iterable);
            return this;
        }

        public Builder addKeycodes(int i) {
            copyOnWrite();
            ((KeyBindingRequest) this.instance).addKeycodes(i);
            return this;
        }

        public Builder clearKeycodes() {
            copyOnWrite();
            ((KeyBindingRequest) this.instance).clearKeycodes();
            return this;
        }

        @Override // fr.sd.taada.proto.KeyBindingRequestOrBuilder
        public int getKeycodes(int i) {
            return ((KeyBindingRequest) this.instance).getKeycodes(i);
        }

        @Override // fr.sd.taada.proto.KeyBindingRequestOrBuilder
        public int getKeycodesCount() {
            return ((KeyBindingRequest) this.instance).getKeycodesCount();
        }

        @Override // fr.sd.taada.proto.KeyBindingRequestOrBuilder
        public List<Integer> getKeycodesList() {
            return Collections.unmodifiableList(((KeyBindingRequest) this.instance).getKeycodesList());
        }

        public Builder setKeycodes(int i, int i3) {
            copyOnWrite();
            ((KeyBindingRequest) this.instance).setKeycodes(i, i3);
            return this;
        }

        private Builder() {
            super(KeyBindingRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        KeyBindingRequest keyBindingRequest = new KeyBindingRequest();
        DEFAULT_INSTANCE = keyBindingRequest;
        GeneratedMessageLite.registerDefaultInstance(KeyBindingRequest.class, keyBindingRequest);
    }

    private KeyBindingRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllKeycodes(Iterable<? extends Integer> iterable) {
        ensureKeycodesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.keycodes_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addKeycodes(int i) {
        ensureKeycodesIsMutable();
        this.keycodes_.addInt(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeycodes() {
        this.keycodes_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureKeycodesIsMutable() {
        if (this.keycodes_.isModifiable()) {
            return;
        }
        this.keycodes_ = GeneratedMessageLite.mutableCopy(this.keycodes_);
    }

    public static KeyBindingRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static KeyBindingRequest parseDelimitedFrom(InputStream inputStream) {
        return (KeyBindingRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KeyBindingRequest parseFrom(ByteBuffer byteBuffer) {
        return (KeyBindingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<KeyBindingRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeycodes(int i, int i3) {
        ensureKeycodesIsMutable();
        this.keycodes_.setInt(i, i3);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new KeyBindingRequest();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001'", new Object[]{"keycodes_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<KeyBindingRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (KeyBindingRequest.class) {
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

    @Override // fr.sd.taada.proto.KeyBindingRequestOrBuilder
    public int getKeycodes(int i) {
        return this.keycodes_.getInt(i);
    }

    @Override // fr.sd.taada.proto.KeyBindingRequestOrBuilder
    public int getKeycodesCount() {
        return this.keycodes_.size();
    }

    @Override // fr.sd.taada.proto.KeyBindingRequestOrBuilder
    public List<Integer> getKeycodesList() {
        return this.keycodes_;
    }

    public static Builder newBuilder(KeyBindingRequest keyBindingRequest) {
        return DEFAULT_INSTANCE.createBuilder(keyBindingRequest);
    }

    public static KeyBindingRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (KeyBindingRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static KeyBindingRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (KeyBindingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static KeyBindingRequest parseFrom(ByteString byteString) {
        return (KeyBindingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static KeyBindingRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (KeyBindingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static KeyBindingRequest parseFrom(byte[] bArr) {
        return (KeyBindingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KeyBindingRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (KeyBindingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static KeyBindingRequest parseFrom(InputStream inputStream) {
        return (KeyBindingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KeyBindingRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (KeyBindingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static KeyBindingRequest parseFrom(CodedInputStream codedInputStream) {
        return (KeyBindingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static KeyBindingRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (KeyBindingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
