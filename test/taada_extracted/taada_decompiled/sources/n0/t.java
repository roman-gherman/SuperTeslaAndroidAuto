package n0;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f4220a;
    public float b;
    public float c;
    public float d;
    public float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f4221f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f4222g = new ArrayList();

    public t() {
        d(0.0f, 270.0f, 0.0f);
    }

    public final void a(float f6) {
        float f7 = this.d;
        if (f7 == f6) {
            return;
        }
        float f8 = ((f6 - f7) + 360.0f) % 360.0f;
        if (f8 > 180.0f) {
            return;
        }
        float f9 = this.b;
        float f10 = this.c;
        p pVar = new p(f9, f10, f9, f10);
        pVar.f4216f = this.d;
        pVar.f4217g = f8;
        this.f4222g.add(new n(pVar));
        this.d = f6;
    }

    public final void b(Matrix matrix, Path path) {
        ArrayList arrayList = this.f4221f;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((r) arrayList.get(i)).a(matrix, path);
        }
    }

    public final void c(float f6, float f7) {
        q qVar = new q();
        qVar.b = f6;
        qVar.c = f7;
        this.f4221f.add(qVar);
        o oVar = new o(qVar, this.b, this.c);
        float fB = oVar.b() + 270.0f;
        float fB2 = oVar.b() + 270.0f;
        a(fB);
        this.f4222g.add(oVar);
        this.d = fB2;
        this.b = f6;
        this.c = f7;
    }

    public final void d(float f6, float f7, float f8) {
        this.f4220a = f6;
        this.b = 0.0f;
        this.c = f6;
        this.d = f7;
        this.e = (f7 + f8) % 360.0f;
        this.f4221f.clear();
        this.f4222g.clear();
    }
}
