package o1;

import java.io.InputStream;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.B;
import kotlin.jvm.internal.w;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f4277a;

    static {
        KClass[] kClassArr = {w.f3817a.b(InputStream.class)};
        LinkedHashSet linkedHashSet = new LinkedHashSet(B.F(1));
        kotlin.collections.j.K(kClassArr, linkedHashSet);
        f4277a = linkedHashSet;
    }
}
