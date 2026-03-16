package L0;

import com.google.firebase.encoders.ValueEncoderContext;

/* JADX INFO: loaded from: classes.dex */
public final class f implements ValueEncoderContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f955a = false;
    public boolean b = false;
    public com.google.firebase.encoders.b c;
    public final d d;

    public f(d dVar) {
        this.d = dVar;
    }

    public final void a() {
        if (this.f955a) {
            throw new com.google.firebase.encoders.a("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f955a = true;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(String str) {
        a();
        this.d.a(this.c, str, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(float f6) {
        a();
        this.d.c(this.c, f6, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(double d) {
        a();
        this.d.b(this.c, d, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(int i) {
        a();
        this.d.d(this.c, i, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(long j6) {
        a();
        this.d.e(this.c, j6, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(boolean z6) {
        a();
        this.d.d(this.c, z6 ? 1 : 0, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(byte[] bArr) {
        a();
        this.d.a(this.c, bArr, this.b);
        return this;
    }
}
