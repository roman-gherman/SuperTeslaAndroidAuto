package a3;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* JADX INFO: loaded from: classes2.dex */
public abstract class W {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final V f1541a = new V();

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public Annotations c(Annotations annotations) {
        kotlin.jvm.internal.h.f(annotations, "annotations");
        return annotations;
    }

    public abstract TypeProjection d(AbstractC0162z abstractC0162z);

    public boolean e() {
        return this instanceof V;
    }

    public AbstractC0162z f(AbstractC0162z topLevelType, d0 position) {
        kotlin.jvm.internal.h.f(topLevelType, "topLevelType");
        kotlin.jvm.internal.h.f(position, "position");
        return topLevelType;
    }
}
