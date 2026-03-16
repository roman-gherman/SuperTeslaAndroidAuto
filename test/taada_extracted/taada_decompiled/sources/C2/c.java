package c2;

import java.util.Random;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends AbstractC0241a {
    public final b c = new b(0);

    @Override // c2.AbstractC0241a
    public final Random b() {
        Object obj = this.c.get();
        h.e(obj, "implStorage.get()");
        return (Random) obj;
    }
}
