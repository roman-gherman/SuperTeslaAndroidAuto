package n0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import java.util.ArrayList;
import java.util.Iterator;
import m0.C0630a;

/* JADX INFO: loaded from: classes.dex */
public final class m extends s {
    public final /* synthetic */ ArrayList c;
    public final /* synthetic */ Matrix d;

    public m(ArrayList arrayList, Matrix matrix) {
        this.c = arrayList;
        this.d = matrix;
    }

    @Override // n0.s
    public final void a(Matrix matrix, C0630a c0630a, int i, Canvas canvas) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((s) it.next()).a(this.d, c0630a, i, canvas);
        }
    }
}
