package i2;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends i {
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(Field field, boolean z6, int i) {
        super(field, z6);
        this.e = i;
    }

    @Override // i2.r
    public void a(Object[] objArr) {
        switch (this.e) {
            case 1:
                kotlin.reflect.l.f(this, objArr);
                b(objArr.length == 0 ? null : objArr[0]);
                break;
            default:
                super.a(objArr);
                break;
        }
    }
}
