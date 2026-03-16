package f;

import java.nio.ByteBuffer;
import java.util.AbstractList;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class k extends AbstractList implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3155a;
    public final /* synthetic */ m b;

    public /* synthetic */ k(m mVar, int i) {
        this.f3155a = i;
        this.b = mVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        switch (this.f3155a) {
            case 0:
                m mVar = this.b;
                m.b(i, mVar.b.e.b);
                l lVarD = mVar.d((i * 8) + mVar.b.e.c);
                return new r(lVarD.d, lVarD.e(), lVarD.e(), lVarD.b.getInt());
            case 1:
                m mVar2 = this.b;
                m.b(i, mVar2.b.f3173f.b);
                l lVarD2 = mVar2.d((i * 8) + mVar2.b.f3173f.c);
                return new u(lVarD2.d, lVarD2.e(), lVarD2.e(), lVarD2.b.getInt());
            case 2:
                m mVar3 = this.b;
                m.b(i, mVar3.b.d.b);
                l lVarD3 = mVar3.d((i * 12) + mVar3.b.d.c);
                ByteBuffer byteBuffer = lVarD3.b;
                return new v(lVarD3.d, byteBuffer.getInt(), byteBuffer.getInt(), byteBuffer.getInt());
            case 3:
                return get(i);
            case 4:
                m mVar4 = this.b;
                x xVar = mVar4.b;
                m.b(i, xVar.c.b);
                return Integer.valueOf(mVar4.f3158a.getInt((i * 4) + xVar.c.c));
            default:
                m mVar5 = this.b;
                k kVar = mVar5.d;
                x xVar2 = mVar5.b;
                m.b(i, xVar2.c.b);
                return kVar.get(mVar5.f3158a.getInt((i * 4) + xVar2.c.c));
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        switch (this.f3155a) {
        }
        return this.b.b.c.b;
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int i) {
        m mVar = this.b;
        m.b(i, mVar.b.b.b);
        return mVar.d((i * 4) + mVar.b.b.c).c();
    }
}
