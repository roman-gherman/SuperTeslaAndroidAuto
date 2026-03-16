package n0;

/* JADX INFO: loaded from: classes.dex */
public final class h extends io.ktor.utils.io.jvm.javaio.q {
    @Override // io.ktor.utils.io.jvm.javaio.q
    public final void i(t tVar, float f6, float f7) {
        tVar.d(f7 * f6, 180.0f, 90.0f);
        float f8 = f7 * 2.0f * f6;
        p pVar = new p(0.0f, 0.0f, f8, f8);
        pVar.f4217f = 180.0f;
        pVar.f4218g = 90.0f;
        tVar.f4222f.add(pVar);
        n nVar = new n(pVar);
        tVar.a(180.0f);
        tVar.f4223g.add(nVar);
        tVar.d = 270.0f;
        float f9 = (0.0f + f8) * 0.5f;
        float f10 = (f8 - 0.0f) / 2.0f;
        double d = 270.0f;
        tVar.b = (((float) Math.cos(Math.toRadians(d))) * f10) + f9;
        tVar.c = (f10 * ((float) Math.sin(Math.toRadians(d)))) + f9;
    }
}
