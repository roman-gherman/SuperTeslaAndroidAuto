package z1;

import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends kotlin.jvm.internal.i implements Function1 {
    public static final c b = new c(1, 0);
    public static final c c = new c(1, 1);
    public static final c d = new c(1, 2);
    public static final c e = new c(1, 3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5173a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(int i, int i3) {
        super(i);
        this.f5173a = i3;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f5173a) {
            case 0:
                Map.Entry $receiver = (Map.Entry) obj;
                kotlin.jvm.internal.h.f($receiver, "$this$$receiver");
                return new j(((e) $receiver.getKey()).f5175a, $receiver.getValue());
            case 1:
                Map.Entry $receiver2 = (Map.Entry) obj;
                kotlin.jvm.internal.h.f($receiver2, "$this$$receiver");
                return new j(k1.j.d((String) $receiver2.getKey()), $receiver2.getValue());
            case 2:
                e $receiver3 = (e) obj;
                kotlin.jvm.internal.h.f($receiver3, "$this$$receiver");
                return $receiver3.f5175a;
            default:
                String $receiver4 = (String) obj;
                kotlin.jvm.internal.h.f($receiver4, "$this$$receiver");
                return k1.j.d($receiver4);
        }
    }
}
