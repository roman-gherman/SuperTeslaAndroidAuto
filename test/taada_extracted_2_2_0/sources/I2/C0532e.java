package i2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.y;

/* JADX INFO: renamed from: i2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0532e extends r {
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0532e(Member member, Type type, Class cls, Type[] typeArr, int i) {
        super(member, type, cls, typeArr);
        this.e = i;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final Object call(Object[] args) {
        switch (this.e) {
            case 0:
                kotlin.jvm.internal.h.f(args, "args");
                kotlin.reflect.l.f(this, args);
                Constructor constructor = (Constructor) this.f3477a;
                y yVar = new y(2);
                yVar.b(args);
                yVar.a(null);
                ArrayList arrayList = yVar.f3819a;
                return constructor.newInstance(arrayList.toArray(new Object[arrayList.size()]));
            default:
                kotlin.jvm.internal.h.f(args, "args");
                kotlin.reflect.l.f(this, args);
                return ((Constructor) this.f3477a).newInstance(Arrays.copyOf(args, args.length));
        }
    }
}
