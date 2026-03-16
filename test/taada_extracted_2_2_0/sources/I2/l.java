package i2;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends m {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f3472g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(Field field, boolean z6, boolean z7, int i) {
        super(field, z6, z7);
        this.f3472g = i;
    }

    @Override // i2.m, i2.r
    public void a(Object[] objArr) {
        switch (this.f3472g) {
            case 1:
                super.a(objArr);
                b(objArr.length == 0 ? null : objArr[0]);
                break;
            default:
                super.a(objArr);
                break;
        }
    }
}
