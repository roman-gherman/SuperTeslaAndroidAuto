package h1;

import io.ktor.client.request.HttpRequest;
import kotlin.reflect.l;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends C0494b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f3355f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f3356g;

    public d(g1.f fVar, HttpRequest httpRequest, r1.b bVar, byte[] bArr) {
        super(fVar);
        this.f3355f = bArr;
        this.b = new e(this, httpRequest);
        this.c = new f(this, bArr, bVar);
        this.f3356g = true;
    }

    @Override // h1.C0494b
    public final boolean b() {
        return this.f3356g;
    }

    @Override // h1.C0494b
    public final Object e() {
        return l.a(this.f3355f);
    }
}
