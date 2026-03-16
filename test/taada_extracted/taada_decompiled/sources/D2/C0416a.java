package d2;

import c2.AbstractC0241a;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.h;

/* JADX INFO: renamed from: d2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0416a extends AbstractC0241a {
    @Override // c2.AbstractC0241a
    public final Random b() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        h.e(threadLocalRandomCurrent, "current()");
        return threadLocalRandomCurrent;
    }
}
