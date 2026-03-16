package n0;

/* JADX INFO: loaded from: classes.dex */
public final class c extends io.ktor.utils.io.jvm.javaio.q {
    @Override // io.ktor.utils.io.jvm.javaio.q
    public final void i(t tVar, float f6, float f7) {
        tVar.d(f7 * f6, 180.0f, 90.0f);
        double d = f7;
        double d6 = f6;
        tVar.c((float) (Math.sin(Math.toRadians(90.0f)) * d * d6), (float) (Math.sin(Math.toRadians(0.0f)) * d * d6));
    }
}
