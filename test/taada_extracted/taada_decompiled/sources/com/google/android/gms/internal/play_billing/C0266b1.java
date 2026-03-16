package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.b1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0266b1 implements zzik {
    public static final C0266b1 b = new C0266b1(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2071a;

    public /* synthetic */ C0266b1(int i) {
        this.f2071a = i;
    }

    public static final C0299m1 a(Object obj, Object obj2) {
        C0299m1 c0299m1 = (C0299m1) obj;
        C0299m1 c0299m12 = (C0299m1) obj2;
        if (!c0299m12.isEmpty()) {
            if (!c0299m1.f2105a) {
                if (c0299m1.isEmpty()) {
                    c0299m1 = new C0299m1();
                } else {
                    C0299m1 c0299m13 = new C0299m1(c0299m1);
                    c0299m13.f2105a = true;
                    c0299m1 = c0299m13;
                }
            }
            c0299m1.b();
            if (!c0299m12.isEmpty()) {
                c0299m1.putAll(c0299m12);
            }
        }
        return c0299m1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzik
    public zzij zzb(Class cls) {
        switch (this.f2071a) {
            case 0:
                if (!AbstractC0272d1.class.isAssignableFrom(cls)) {
                    throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
                }
                try {
                    return (zzij) AbstractC0272d1.g(cls.asSubclass(AbstractC0272d1.class)).d(3);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
                }
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzik
    public boolean zzc(Class cls) {
        switch (this.f2071a) {
            case 0:
                return AbstractC0272d1.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }
}
