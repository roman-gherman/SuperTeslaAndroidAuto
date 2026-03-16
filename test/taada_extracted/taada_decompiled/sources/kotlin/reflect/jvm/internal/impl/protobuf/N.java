package kotlin.reflect.jvm.internal.impl.protobuf;

/* JADX INFO: loaded from: classes2.dex */
public enum N {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(AbstractC0604e.f3860a),
    ENUM(null),
    MESSAGE(null);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3857a;

    N(Object obj) {
        this.f3857a = obj;
    }
}
