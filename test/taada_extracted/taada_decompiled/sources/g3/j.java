package g3;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.util.Check;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L2.f f3313a;
    public final kotlin.text.g b;
    public final Collection c;
    public final Function1 d;
    public final Check[] e;

    public j(L2.f fVar, kotlin.text.g gVar, Collection collection, Function1 function1, Check... checkArr) {
        this.f3313a = fVar;
        this.b = gVar;
        this.c = collection;
        this.d = function1;
        this.e = checkArr;
    }

    public /* synthetic */ j(L2.f fVar, Check[] checkArr) {
        this(fVar, checkArr, C0490g.f3310a);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(L2.f name, Check[] checkArr, Function1 additionalChecks) {
        this(name, null, null, additionalChecks, (Check[]) Arrays.copyOf(checkArr, checkArr.length));
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(additionalChecks, "additionalChecks");
    }

    public /* synthetic */ j(Set set, Check[] checkArr) {
        this(set, checkArr, i.f3312a);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(Collection nameList, Check[] checkArr, Function1 additionalChecks) {
        this(null, null, nameList, additionalChecks, (Check[]) Arrays.copyOf(checkArr, checkArr.length));
        kotlin.jvm.internal.h.f(nameList, "nameList");
        kotlin.jvm.internal.h.f(additionalChecks, "additionalChecks");
    }
}
