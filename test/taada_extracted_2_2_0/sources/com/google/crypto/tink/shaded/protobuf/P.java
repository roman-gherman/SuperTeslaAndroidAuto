package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class P implements Parser {
    public static final D b = D.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Q f2843a;

    public P(Q q) {
        this.f2843a = q;
    }

    public static void a(Q q) throws V {
        if (q != null && !Q.i(q, true)) {
            throw new V(new I0().getMessage());
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Q parsePartialDelimitedFrom(InputStream inputStream, D d) throws V {
        try {
            int i = inputStream.read();
            if (i == -1) {
                return null;
            }
            return parsePartialFrom(new C0353a(inputStream, AbstractC0388s.t(i, inputStream), 0), d);
        } catch (IOException e) {
            throw new V(e.getMessage(), e);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final Q parsePartialFrom(AbstractC0381o abstractC0381o, D d) throws V {
        AbstractC0388s abstractC0388sH = abstractC0381o.h();
        Q qO = Q.o(this.f2843a, abstractC0388sH, d);
        try {
            abstractC0388sH.a(0);
            return qO;
        } catch (V e) {
            throw e;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final Q parsePartialFrom(InputStream inputStream, D d) throws V {
        AbstractC0388s abstractC0388sG = AbstractC0388s.g(inputStream);
        Q qO = Q.o(this.f2843a, abstractC0388sG, d);
        try {
            abstractC0388sG.a(0);
            return qO;
        } catch (V e) {
            throw e;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public final Object parseDelimitedFrom(InputStream inputStream) throws V {
        Q partialDelimitedFrom = parsePartialDelimitedFrom(inputStream, b);
        a(partialDelimitedFrom);
        return partialDelimitedFrom;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public final Object parseFrom(byte[] bArr, int i, int i3) throws V {
        Q qP = Q.p(this.f2843a, bArr, i, i3, b);
        a(qP);
        return qP;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public final Object parseDelimitedFrom(InputStream inputStream, D d) throws V {
        Q partialDelimitedFrom = parsePartialDelimitedFrom(inputStream, d);
        a(partialDelimitedFrom);
        return partialDelimitedFrom;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public final Object parsePartialDelimitedFrom(InputStream inputStream) {
        return parsePartialDelimitedFrom(inputStream, b);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public final Object parseFrom(byte[] bArr, int i, int i3, D d) throws V {
        Q qP = Q.p(this.f2843a, bArr, i, i3, d);
        a(qP);
        return qP;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public final Object parsePartialFrom(byte[] bArr, int i, int i3) {
        return Q.p(this.f2843a, bArr, i, i3, b);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public final Object parsePartialFrom(byte[] bArr, int i, int i3, D d) {
        return Q.p(this.f2843a, bArr, i, i3, d);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public final Object parseFrom(AbstractC0381o abstractC0381o) throws V {
        Q partialFrom = parsePartialFrom(abstractC0381o, b);
        a(partialFrom);
        return partialFrom;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public final Object parsePartialFrom(AbstractC0381o abstractC0381o) {
        return parsePartialFrom(abstractC0381o, b);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public final Object parseFrom(AbstractC0381o abstractC0381o, D d) throws V {
        Q partialFrom = parsePartialFrom(abstractC0381o, d);
        a(partialFrom);
        return partialFrom;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public final Object parsePartialFrom(byte[] bArr, D d) {
        return Q.p(this.f2843a, bArr, 0, bArr.length, d);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public final Object parseFrom(ByteBuffer byteBuffer) throws V {
        AbstractC0388s abstractC0388sH = AbstractC0388s.h(byteBuffer, false);
        Q qO = Q.o(this.f2843a, abstractC0388sH, b);
        try {
            abstractC0388sH.a(0);
            a(qO);
            return qO;
        } catch (V e) {
            throw e;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public final Object parsePartialFrom(byte[] bArr) {
        return Q.p(this.f2843a, bArr, 0, bArr.length, b);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public final Object parsePartialFrom(InputStream inputStream) {
        return parsePartialFrom(inputStream, b);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public final Object parsePartialFrom(AbstractC0388s abstractC0388s) {
        return Q.o(this.f2843a, abstractC0388s, b);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public final Object parseFrom(ByteBuffer byteBuffer, D d) throws V {
        AbstractC0388s abstractC0388sH = AbstractC0388s.h(byteBuffer, false);
        Q qO = Q.o(this.f2843a, abstractC0388sH, d);
        try {
            abstractC0388sH.a(0);
            a(qO);
            return qO;
        } catch (V e) {
            throw e;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public final Object parsePartialFrom(AbstractC0388s abstractC0388s, D d) {
        return Q.o(this.f2843a, abstractC0388s, d);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public final Object parseFrom(byte[] bArr) throws V {
        Q qP = Q.p(this.f2843a, bArr, 0, bArr.length, b);
        a(qP);
        return qP;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public final Object parseFrom(byte[] bArr, D d) throws V {
        Q qP = Q.p(this.f2843a, bArr, 0, bArr.length, d);
        a(qP);
        return qP;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public final Object parseFrom(InputStream inputStream) throws V {
        Q partialFrom = parsePartialFrom(inputStream, b);
        a(partialFrom);
        return partialFrom;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public final Object parseFrom(InputStream inputStream, D d) throws V {
        Q partialFrom = parsePartialFrom(inputStream, d);
        a(partialFrom);
        return partialFrom;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public final Object parseFrom(AbstractC0388s abstractC0388s) throws V {
        Q qO = Q.o(this.f2843a, abstractC0388s, b);
        a(qO);
        return qO;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public final Object parseFrom(AbstractC0388s abstractC0388s, D d) throws V {
        Q qO = Q.o(this.f2843a, abstractC0388s, d);
        a(qO);
        return qO;
    }
}
