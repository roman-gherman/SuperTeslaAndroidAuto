package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0355b implements MessageLite.Builder {
    public final String a() {
        return "Reading " + getClass().getName() + " from a ByteString threw an IOException (should never happen).";
    }

    public abstract AbstractC0355b b(AbstractC0357c abstractC0357c);

    public abstract AbstractC0355b c(int i, byte[] bArr);

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final AbstractC0355b mergeFrom(AbstractC0388s abstractC0388s) {
        return e(abstractC0388s, D.a());
    }

    public abstract AbstractC0355b e(AbstractC0388s abstractC0388s, D d);

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final AbstractC0355b mergeFrom(MessageLite messageLite) {
        if (getDefaultInstanceForType().getClass().isInstance(messageLite)) {
            return b((AbstractC0357c) messageLite);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    public abstract AbstractC0355b g(byte[] bArr, int i, D d);

    public final void h(AbstractC0381o abstractC0381o) {
        try {
            AbstractC0388s abstractC0388sH = abstractC0381o.h();
            mergeFrom(abstractC0388sH);
            abstractC0388sH.a(0);
        } catch (V e) {
            throw e;
        } catch (IOException e6) {
            throw new RuntimeException(a(), e6);
        }
    }

    public final void i(AbstractC0381o abstractC0381o, D d) {
        try {
            AbstractC0388s abstractC0388sH = abstractC0381o.h();
            e(abstractC0388sH, d);
            abstractC0388sH.a(0);
        } catch (V e) {
            throw e;
        } catch (IOException e6) {
            throw new RuntimeException(a(), e6);
        }
    }

    public final void j(InputStream inputStream) {
        AbstractC0388s abstractC0388sG = AbstractC0388s.g(inputStream);
        mergeFrom(abstractC0388sG);
        abstractC0388sG.a(0);
    }

    public final void k(InputStream inputStream, D d) {
        AbstractC0388s abstractC0388sG = AbstractC0388s.g(inputStream);
        e(abstractC0388sG, d);
        abstractC0388sG.a(0);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    public final boolean mergeDelimitedFrom(InputStream inputStream, D d) throws IOException {
        int i = inputStream.read();
        if (i == -1) {
            return false;
        }
        k(new C0353a(inputStream, AbstractC0388s.t(i, inputStream), 0), d);
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(AbstractC0381o abstractC0381o) {
        h(abstractC0381o);
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(AbstractC0381o abstractC0381o, D d) {
        i(abstractC0381o, d);
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    public final boolean mergeDelimitedFrom(InputStream inputStream) {
        return mergeDelimitedFrom(inputStream, D.a());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream inputStream) {
        j(inputStream);
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream inputStream, D d) {
        k(inputStream, d);
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    public MessageLite.Builder mergeFrom(byte[] bArr) {
        return c(bArr.length, bArr);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    public MessageLite.Builder mergeFrom(byte[] bArr, D d) {
        return g(bArr, bArr.length, d);
    }
}
