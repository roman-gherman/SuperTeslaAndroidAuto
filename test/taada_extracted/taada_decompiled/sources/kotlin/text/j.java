package kotlin.text;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f3949a = new j(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String line = (String) obj;
        kotlin.jvm.internal.h.f(line, "line");
        return line;
    }
}
