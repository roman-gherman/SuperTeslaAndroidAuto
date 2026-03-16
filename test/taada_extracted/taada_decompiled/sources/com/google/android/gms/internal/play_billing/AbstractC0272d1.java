package com.google.android.gms.internal.play_billing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.d1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0272d1 extends K0 {
    private static final Map zzb = new ConcurrentHashMap();
    protected C0334y1 zzc;
    private int zzd;

    public AbstractC0272d1() {
        this.zza = 0;
        this.zzd = -1;
        this.zzc = C0334y1.f2135f;
    }

    public static AbstractC0272d1 g(Class cls) {
        Map map = zzb;
        AbstractC0272d1 abstractC0272d1 = (AbstractC0272d1) map.get(cls);
        if (abstractC0272d1 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                abstractC0272d1 = (AbstractC0272d1) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (abstractC0272d1 != null) {
            return abstractC0272d1;
        }
        AbstractC0272d1 abstractC0272d12 = (AbstractC0272d1) ((AbstractC0272d1) D1.f(cls)).d(6);
        if (abstractC0272d12 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, abstractC0272d12);
        return abstractC0272d12;
    }

    public static Object h(Method method, zzim zzimVar, Object... objArr) {
        try {
            return method.invoke(zzimVar, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e6) {
            Throwable cause = e6.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static void j(Class cls, AbstractC0272d1 abstractC0272d1) {
        abstractC0272d1.i();
        zzb.put(cls, abstractC0272d1);
    }

    public static final boolean l(AbstractC0272d1 abstractC0272d1, boolean z6) {
        byte bByteValue = ((Byte) abstractC0272d1.d(1)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzk = C0316s1.c.a(abstractC0272d1.getClass()).zzk(abstractC0272d1);
        if (z6) {
            abstractC0272d1.d(2);
        }
        return zZzk;
    }

    @Override // com.google.android.gms.internal.play_billing.K0
    public final int a(zzix zzixVar) {
        if (c()) {
            int iZza = zzixVar.zza(this);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException(B2.b.c(iZza, "serialized size must be non-negative, was "));
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZza2 = zzixVar.zza(this);
        if (iZza2 < 0) {
            throw new IllegalStateException(B2.b.c(iZza2, "serialized size must be non-negative, was "));
        }
        this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza2;
        return iZza2;
    }

    public final boolean c() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public abstract Object d(int i);

    public final AbstractC0269c1 e() {
        return (AbstractC0269c1) d(5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return C0316s1.c.a(getClass()).zzj(this, (AbstractC0272d1) obj);
    }

    public final AbstractC0269c1 f() {
        AbstractC0269c1 abstractC0269c1 = (AbstractC0269c1) d(5);
        if (!abstractC0269c1.f2073a.equals(this)) {
            if (!abstractC0269c1.b.c()) {
                AbstractC0272d1 abstractC0272d1 = (AbstractC0272d1) abstractC0269c1.f2073a.d(4);
                C0316s1.c.a(abstractC0272d1.getClass()).zzg(abstractC0272d1, abstractC0269c1.b);
                abstractC0269c1.b = abstractC0272d1;
            }
            AbstractC0272d1 abstractC0272d12 = abstractC0269c1.b;
            C0316s1.c.a(abstractC0272d12.getClass()).zzg(abstractC0272d12, this);
        }
        return abstractC0269c1;
    }

    public final int hashCode() {
        if (c()) {
            return C0316s1.c.a(getClass()).zzb(this);
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iZzb = C0316s1.c.a(getClass()).zzb(this);
        this.zza = iZzb;
        return iZzb;
    }

    public final void i() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final void k() {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final String toString() {
        String string = super.toString();
        char[] cArr = AbstractC0305o1.f2110a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        AbstractC0305o1.c(this, sb, 0);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.play_billing.zzim
    public final /* synthetic */ zzil zzI() {
        return (AbstractC0269c1) d(5);
    }

    @Override // com.google.android.gms.internal.play_billing.zzim
    public final void zzJ(V0 v02) {
        zzix zzixVarA = C0316s1.c.a(getClass());
        W0 w02 = v02.b;
        if (w02 == null) {
            w02 = new W0(v02);
        }
        zzixVarA.zzi(this, w02);
    }

    @Override // com.google.android.gms.internal.play_billing.zzin
    public final /* synthetic */ zzim zzi() {
        return (AbstractC0272d1) d(6);
    }

    @Override // com.google.android.gms.internal.play_billing.zzim
    public final int zzk() {
        if (c()) {
            int iZza = C0316s1.c.a(getClass()).zza(this);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException(B2.b.c(iZza, "serialized size must be non-negative, was "));
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZza2 = C0316s1.c.a(getClass()).zza(this);
        if (iZza2 < 0) {
            throw new IllegalStateException(B2.b.c(iZza2, "serialized size must be non-negative, was "));
        }
        this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza2;
        return iZza2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzin
    public final boolean zzl() {
        return l(this, true);
    }
}
