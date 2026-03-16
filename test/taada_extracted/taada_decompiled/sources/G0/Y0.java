package G0;

import com.google.crypto.tink.proto.JwtRsaSsaPssPublicKeyOrBuilder;
import com.google.crypto.tink.shaded.protobuf.AbstractC0355b;
import com.google.crypto.tink.shaded.protobuf.AbstractC0357c;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.AbstractC0388s;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class Y0 extends com.google.crypto.tink.shaded.protobuf.O implements JwtRsaSsaPssPublicKeyOrBuilder {
    @Override // com.google.crypto.tink.shaded.protobuf.O, com.google.crypto.tink.shaded.protobuf.AbstractC0355b
    public final AbstractC0355b b(AbstractC0357c abstractC0357c) {
        r((com.google.crypto.tink.shaded.protobuf.Q) abstractC0357c);
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.O, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    public final /* bridge */ /* synthetic */ MessageLite build() {
        return build();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.O, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    public final /* bridge */ /* synthetic */ MessageLite buildPartial() {
        return buildPartial();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.O, com.google.crypto.tink.shaded.protobuf.AbstractC0355b
    public final /* bridge */ /* synthetic */ AbstractC0355b c(int i, byte[] bArr) {
        s(bArr, 0, i);
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.O, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    public final /* bridge */ /* synthetic */ MessageLite.Builder clear() {
        n();
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.O, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    /* JADX INFO: renamed from: clone */
    public final /* bridge */ /* synthetic */ MessageLite.Builder mo0clone() {
        return clone();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.O, com.google.crypto.tink.shaded.protobuf.AbstractC0355b
    public final /* bridge */ /* synthetic */ AbstractC0355b e(AbstractC0388s abstractC0388s, com.google.crypto.tink.shaded.protobuf.D d) {
        q(abstractC0388s, d);
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.O, com.google.crypto.tink.shaded.protobuf.AbstractC0355b
    public final /* bridge */ /* synthetic */ AbstractC0355b g(byte[] bArr, int i, com.google.crypto.tink.shaded.protobuf.D d) {
        t(bArr, 0, i, d);
        return this;
    }

    @Override // com.google.crypto.tink.proto.JwtRsaSsaPssPublicKeyOrBuilder
    public final X0 getAlgorithm() {
        return ((C0040b1) this.b).getAlgorithm();
    }

    @Override // com.google.crypto.tink.proto.JwtRsaSsaPssPublicKeyOrBuilder
    public final int getAlgorithmValue() {
        return ((C0040b1) this.b).getAlgorithmValue();
    }

    @Override // com.google.crypto.tink.proto.JwtRsaSsaPssPublicKeyOrBuilder
    public final C0037a1 getCustomKid() {
        return ((C0040b1) this.b).getCustomKid();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.O, com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return this.f2842a;
    }

    @Override // com.google.crypto.tink.proto.JwtRsaSsaPssPublicKeyOrBuilder
    public final AbstractC0381o getE() {
        return ((C0040b1) this.b).getE();
    }

    @Override // com.google.crypto.tink.proto.JwtRsaSsaPssPublicKeyOrBuilder
    public final AbstractC0381o getN() {
        return ((C0040b1) this.b).getN();
    }

    @Override // com.google.crypto.tink.proto.JwtRsaSsaPssPublicKeyOrBuilder
    public final int getVersion() {
        return ((C0040b1) this.b).getVersion();
    }

    @Override // com.google.crypto.tink.proto.JwtRsaSsaPssPublicKeyOrBuilder
    public final boolean hasCustomKid() {
        return ((C0040b1) this.b).hasCustomKid();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0355b, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    public final MessageLite.Builder mergeFrom(byte[] bArr) {
        s(bArr, 0, bArr.length);
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.O
    /* JADX INFO: renamed from: clone */
    public final /* bridge */ /* synthetic */ Object mo0clone() {
        return clone();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0355b, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    public final MessageLite.Builder mergeFrom(byte[] bArr, com.google.crypto.tink.shaded.protobuf.D d) {
        t(bArr, 0, bArr.length, d);
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0355b, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    public final /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(AbstractC0381o abstractC0381o) {
        h(abstractC0381o);
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0355b, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    public final /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(AbstractC0381o abstractC0381o, com.google.crypto.tink.shaded.protobuf.D d) {
        i(abstractC0381o, d);
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0355b, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    public final /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(AbstractC0388s abstractC0388s) {
        return mergeFrom(abstractC0388s);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.O, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    public final /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(AbstractC0388s abstractC0388s, com.google.crypto.tink.shaded.protobuf.D d) {
        q(abstractC0388s, d);
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0355b, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    public final /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(MessageLite messageLite) {
        return mergeFrom(messageLite);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0355b, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    public final /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream inputStream) {
        j(inputStream);
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0355b, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    public final /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream inputStream, com.google.crypto.tink.shaded.protobuf.D d) {
        k(inputStream, d);
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.O, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    public final /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] bArr, int i, int i3) {
        s(bArr, i, i3);
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.O, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
    public final /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] bArr, int i, int i3, com.google.crypto.tink.shaded.protobuf.D d) {
        t(bArr, i, i3, d);
        return this;
    }
}
