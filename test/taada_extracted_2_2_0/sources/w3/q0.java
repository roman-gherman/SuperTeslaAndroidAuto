package w3;

import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q0 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f5070a;
    public final int b;

    public q0(InputStream inputStream, int i) {
        this.f5070a = inputStream;
        this.b = i;
    }

    public final void a() {
        InputStream inputStream = this.f5070a;
        if (inputStream instanceof n0) {
            n0 n0Var = (n0) inputStream;
            n0Var.f5066f = true;
            n0Var.b();
        }
    }
}
