package Z2;

import A2.B;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends j {
    public final /* synthetic */ Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(n nVar, Function0 function0, Object obj) {
        super(nVar, function0);
        this.d = obj;
    }

    @Override // Z2.i
    public final B c(boolean z6) {
        return new B(this.d, 2, false);
    }
}
