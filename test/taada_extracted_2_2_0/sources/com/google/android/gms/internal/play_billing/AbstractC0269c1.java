package com.google.android.gms.internal.play_billing;

import java.util.List;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.c1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0269c1 implements zzil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0272d1 f2073a;
    public AbstractC0272d1 b;

    public AbstractC0269c1(AbstractC0272d1 abstractC0272d1) {
        this.f2073a = abstractC0272d1;
        if (abstractC0272d1.c()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.b = (AbstractC0272d1) abstractC0272d1.d(4);
    }

    public static void a(int i, List list) {
        String strD = B2.b.d(list.size() - i, "Element at index ", " is null.");
        int size = list.size();
        while (true) {
            size--;
            if (size < i) {
                throw new NullPointerException(strD);
            }
            list.remove(size);
        }
    }

    public final AbstractC0272d1 b() {
        AbstractC0272d1 abstractC0272d1Zzh = zzh();
        if (AbstractC0272d1.l(abstractC0272d1Zzh, true)) {
            return abstractC0272d1Zzh;
        }
        throw new C0331x1();
    }

    @Override // com.google.android.gms.internal.play_billing.zzil
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final AbstractC0272d1 zzh() {
        if (!this.b.c()) {
            return this.b;
        }
        AbstractC0272d1 abstractC0272d1 = this.b;
        abstractC0272d1.getClass();
        C0316s1.c.a(abstractC0272d1.getClass()).zzf(abstractC0272d1);
        abstractC0272d1.i();
        return this.b;
    }

    public final Object clone() {
        AbstractC0269c1 abstractC0269c1 = (AbstractC0269c1) this.f2073a.d(5);
        abstractC0269c1.b = zzh();
        return abstractC0269c1;
    }

    public final void d() {
        if (this.b.c()) {
            return;
        }
        AbstractC0272d1 abstractC0272d1 = (AbstractC0272d1) this.f2073a.d(4);
        C0316s1.c.a(abstractC0272d1.getClass()).zzg(abstractC0272d1, this.b);
        this.b = abstractC0272d1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzin
    public final /* bridge */ /* synthetic */ zzim zzi() {
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzin
    public final boolean zzl() {
        return AbstractC0272d1.l(this.b, false);
    }
}
