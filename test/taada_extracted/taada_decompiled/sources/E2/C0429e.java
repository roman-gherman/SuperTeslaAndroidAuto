package e2;

import java.util.NoSuchElementException;
import kotlin.collections.y;

/* JADX INFO: renamed from: e2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0429e extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3133a;
    public final int b;
    public boolean c;
    public int d;

    public C0429e(int i, int i3, int i4) {
        this.f3133a = i4;
        this.b = i3;
        boolean z6 = false;
        if (i4 <= 0 ? i >= i3 : i <= i3) {
            z6 = true;
        }
        this.c = z6;
        this.d = z6 ? i : i3;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c;
    }

    @Override // kotlin.collections.y
    public final int nextInt() {
        int i = this.d;
        if (i != this.b) {
            this.d = this.f3133a + i;
            return i;
        }
        if (!this.c) {
            throw new NoSuchElementException();
        }
        this.c = false;
        return i;
    }
}
