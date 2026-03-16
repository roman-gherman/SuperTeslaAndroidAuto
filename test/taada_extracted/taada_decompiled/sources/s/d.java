package s;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f4742a;
    public static final d b;
    public static final d c;
    public static final /* synthetic */ d[] d;

    static {
        d dVar = new d("NETWORK_UNMETERED", 0);
        f4742a = dVar;
        d dVar2 = new d("DEVICE_IDLE", 1);
        b = dVar2;
        d dVar3 = new d("DEVICE_CHARGING", 2);
        c = dVar3;
        d = new d[]{dVar, dVar2, dVar3};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) d.clone();
    }
}
