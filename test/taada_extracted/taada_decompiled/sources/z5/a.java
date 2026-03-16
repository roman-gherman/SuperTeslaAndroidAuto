package z5;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5216a = System.getProperty("java.specification.version");
    public static final String b;
    public static final int c;
    public static final boolean d;
    public static final String e;

    static {
        String property;
        System.getProperty("java.runtime.version");
        System.getProperty("java.vm.info");
        System.getProperty("java.vm.version");
        System.getProperty("java.vm.vendor");
        b = System.getProperty("java.vm.name");
        c = a();
        boolean z6 = false;
        if (a() != 0 && (property = System.getProperty("java.boot.class.path")) != null && property.toLowerCase().contains("core-oj.jar")) {
            z6 = true;
        }
        d = z6;
        e = System.getProperty("com.google.appengine.runtime.version");
    }

    public static int a() {
        if (!b.startsWith("Dalvik")) {
            return 0;
        }
        try {
            Class<?> cls = Class.forName("android.os.Build$VERSION");
            try {
                try {
                    try {
                        return ((Integer) cls.getField("SDK_INT").get(null)).intValue();
                    } catch (IllegalAccessException e6) {
                        throw new RuntimeException(e6);
                    }
                } catch (NoSuchFieldException unused) {
                    try {
                        return Integer.parseInt((String) cls.getField("SDK").get(null));
                    } catch (IllegalAccessException e7) {
                        throw new RuntimeException(e7);
                    }
                }
            } catch (NoSuchFieldException e8) {
                throw new r5.a(e8);
            }
        } catch (ClassNotFoundException e9) {
            throw new r5.a(e9);
        }
    }
}
