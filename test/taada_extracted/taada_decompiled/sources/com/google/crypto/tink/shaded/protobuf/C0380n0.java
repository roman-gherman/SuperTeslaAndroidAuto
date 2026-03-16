package com.google.crypto.tink.shaded.protobuf;

import java.util.List;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.n0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0380n0 extends Q implements MethodOrBuilder {
    private static final C0380n0 DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 6;
    private static volatile Parser<C0380n0> PARSER = null;
    public static final int REQUEST_STREAMING_FIELD_NUMBER = 3;
    public static final int REQUEST_TYPE_URL_FIELD_NUMBER = 2;
    public static final int RESPONSE_STREAMING_FIELD_NUMBER = 5;
    public static final int RESPONSE_TYPE_URL_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    private boolean requestStreaming_;
    private boolean responseStreaming_;
    private int syntax_;
    private String name_ = "";
    private String requestTypeUrl_ = "";
    private String responseTypeUrl_ = "";
    private Internal$ProtobufList<C0389s0> options_ = C0395v0.d;

    static {
        C0380n0 c0380n0 = new C0380n0();
        DEFAULT_INSTANCE = c0380n0;
        Q.q(C0380n0.class, c0380n0);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Q
    public final Object e(int i) {
        Parser p5;
        switch (f.s.b(i)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007\u0004Ȉ\u0005\u0007\u0006\u001b\u0007\f", new Object[]{"name_", "requestTypeUrl_", "requestStreaming_", "responseTypeUrl_", "responseStreaming_", "options_", C0389s0.class, "syntax_"});
            case 3:
                return new C0380n0();
            case 4:
                return new C0363f(DEFAULT_INSTANCE, 4);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0380n0> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0380n0.class) {
                    try {
                        p5 = PARSER;
                        if (p5 == null) {
                            p5 = new P(DEFAULT_INSTANCE);
                            PARSER = p5;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return p5;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MethodOrBuilder
    public final String getName() {
        return this.name_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MethodOrBuilder
    public final AbstractC0381o getNameBytes() {
        return AbstractC0381o.d(this.name_);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MethodOrBuilder
    public final C0389s0 getOptions(int i) {
        return this.options_.get(i);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MethodOrBuilder
    public final int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MethodOrBuilder
    public final List getOptionsList() {
        return this.options_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MethodOrBuilder
    public final boolean getRequestStreaming() {
        return this.requestStreaming_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MethodOrBuilder
    public final String getRequestTypeUrl() {
        return this.requestTypeUrl_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MethodOrBuilder
    public final AbstractC0381o getRequestTypeUrlBytes() {
        return AbstractC0381o.d(this.requestTypeUrl_);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MethodOrBuilder
    public final boolean getResponseStreaming() {
        return this.responseStreaming_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MethodOrBuilder
    public final String getResponseTypeUrl() {
        return this.responseTypeUrl_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MethodOrBuilder
    public final AbstractC0381o getResponseTypeUrlBytes() {
        return AbstractC0381o.d(this.responseTypeUrl_);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MethodOrBuilder
    public final H0 getSyntax() {
        int i = this.syntax_;
        H0 h02 = i != 0 ? i != 1 ? null : H0.SYNTAX_PROTO3 : H0.SYNTAX_PROTO2;
        return h02 == null ? H0.UNRECOGNIZED : h02;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MethodOrBuilder
    public final int getSyntaxValue() {
        return this.syntax_;
    }
}
