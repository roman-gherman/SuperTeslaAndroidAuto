package o2;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ f f4288a = new f();
    public static final e b = new e();

    public static Annotations a(List list) {
        return list.isEmpty() ? b : new g(list, 0);
    }
}
