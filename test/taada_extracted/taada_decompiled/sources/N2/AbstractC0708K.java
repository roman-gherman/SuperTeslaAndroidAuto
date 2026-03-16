package n2;

/* JADX INFO: renamed from: n2.K, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0708K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4225a;
    public final boolean b;

    public AbstractC0708K(String str, boolean z6) {
        this.f4225a = str;
        this.b = z6;
    }

    public Integer a(AbstractC0708K visibility) {
        kotlin.jvm.internal.h.f(visibility, "visibility");
        P1.e eVar = AbstractC0707J.f4224a;
        if (this == visibility) {
            return 0;
        }
        P1.e eVar2 = AbstractC0707J.f4224a;
        Integer num = (Integer) eVar2.get(this);
        Integer num2 = (Integer) eVar2.get(visibility);
        if (num == null || num2 == null || num.equals(num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public String b() {
        return this.f4225a;
    }

    public AbstractC0708K c() {
        return this;
    }

    public final String toString() {
        return b();
    }
}
