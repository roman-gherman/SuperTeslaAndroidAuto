package J4;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f880a;
    public final int b;
    public int c;
    public int d;
    public boolean e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f881f = false;

    public c(int i) {
        this.b = i;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final c clone() {
        c cVar = new c(this.b);
        cVar.f880a = this.f880a;
        cVar.c = this.c;
        cVar.d = this.d;
        cVar.e = this.e;
        cVar.f881f = this.f881f;
        return cVar;
    }

    public final int b() {
        if (!this.e || this.f881f) {
            return Integer.MAX_VALUE;
        }
        return this.c;
    }
}
