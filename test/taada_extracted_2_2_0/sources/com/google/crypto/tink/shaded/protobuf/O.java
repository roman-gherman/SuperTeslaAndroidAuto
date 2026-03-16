package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class O extends AbstractC0355b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Q f2842a;
    public Q b;

    public O(Q q) {
        this.f2842a = q;
        if (q.j()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.b = q.m();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0355b
    public AbstractC0355b b(AbstractC0357c abstractC0357c) {
        r((Q) abstractC0357c);
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0355b
    public /* bridge */ /* synthetic */ AbstractC0355b c(int i, byte[] bArr) {
        s(bArr, 0, i);
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
        n();
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0355b
    public /* bridge */ /* synthetic */ AbstractC0355b e(AbstractC0388s abstractC0388s, D d) {
        q(abstractC0388s, d);
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0355b
    public /* bridge */ /* synthetic */ AbstractC0355b g(byte[] bArr, int i, D d) {
        t(bArr, 0, i, d);
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public MessageLite getDefaultInstanceForType() {
        return this.f2842a;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return Q.i(this.b, false);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public final Q build() {
        Q qBuildPartial = buildPartial();
        qBuildPartial.getClass();
        if (Q.i(qBuildPartial, true)) {
            return qBuildPartial;
        }
        throw new I0();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public final Q buildPartial() {
        if (!this.b.j()) {
            return this.b;
        }
        Q q = this.b;
        q.getClass();
        C0393u0 c0393u0 = C0393u0.c;
        c0393u0.getClass();
        c0393u0.a(q.getClass()).makeImmutable(q);
        q.k();
        return this.b;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(AbstractC0388s abstractC0388s, D d) {
        q(abstractC0388s, d);
        return this;
    }

    public final void n() {
        Q q = this.f2842a;
        if (q.j()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.b = q.m();
    }

    @Override // 
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final O mo0clone() {
        O oNewBuilderForType = this.f2842a.newBuilderForType();
        oNewBuilderForType.b = buildPartial();
        return oNewBuilderForType;
    }

    public final void p() {
        if (this.b.j()) {
            return;
        }
        Q qM = this.f2842a.m();
        Q q = this.b;
        C0393u0 c0393u0 = C0393u0.c;
        c0393u0.getClass();
        c0393u0.a(qM.getClass()).mergeFrom(qM, q);
        this.b = qM;
    }

    public final void q(AbstractC0388s abstractC0388s, D d) {
        p();
        try {
            C0393u0 c0393u0 = C0393u0.c;
            Q q = this.b;
            c0393u0.getClass();
            Schema schemaA = c0393u0.a(q.getClass());
            Q q6 = this.b;
            C0390t c0390t = abstractC0388s.b;
            if (c0390t == null) {
                c0390t = new C0390t(abstractC0388s);
            }
            schemaA.mergeFrom(q6, c0390t, d);
        } catch (RuntimeException e) {
            if (!(e.getCause() instanceof IOException)) {
                throw e;
            }
            throw ((IOException) e.getCause());
        }
    }

    public final void r(Q q) {
        if (this.f2842a.equals(q)) {
            return;
        }
        p();
        Q q6 = this.b;
        C0393u0 c0393u0 = C0393u0.c;
        c0393u0.getClass();
        c0393u0.a(q6.getClass()).mergeFrom(q6, q);
    }

    public final void s(byte[] bArr, int i, int i3) {
        t(bArr, i, i3, D.a());
    }

    public final void t(byte[] bArr, int i, int i3, D d) {
        p();
        try {
            C0393u0 c0393u0 = C0393u0.c;
            Q q = this.b;
            c0393u0.getClass();
            c0393u0.a(q.getClass()).mergeFrom(this.b, bArr, i, i + i3, new C0367h(d));
        } catch (V e) {
            throw e;
        } catch (IOException e6) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e6);
        } catch (IndexOutOfBoundsException unused) {
            throw V.g();
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] bArr, int i, int i3) {
        s(bArr, i, i3);
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] bArr, int i, int i3, D d) {
        t(bArr, i, i3, d);
        return this;
    }
}
