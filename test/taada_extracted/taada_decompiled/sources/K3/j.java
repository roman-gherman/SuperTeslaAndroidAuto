package k3;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements Sequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3787a = 2;
    public final kotlin.jvm.internal.i b;
    public final Object c;

    /* JADX WARN: Multi-variable type inference failed */
    public j(Sequence sequence, Function1 predicate) {
        kotlin.jvm.internal.h.f(sequence, "sequence");
        kotlin.jvm.internal.h.f(predicate, "predicate");
        this.c = sequence;
        this.b = (kotlin.jvm.internal.i) predicate;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        switch (this.f3787a) {
            case 0:
                return new i(this);
            case 1:
                return new e(this);
            default:
                return new kotlin.text.b(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(Function0 function0, Function1 getNextValue) {
        kotlin.jvm.internal.h.f(getNextValue, "getNextValue");
        this.b = (kotlin.jvm.internal.i) function0;
        this.c = getNextValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(String input, Function2 function2) {
        kotlin.jvm.internal.h.f(input, "input");
        this.c = input;
        this.b = (kotlin.jvm.internal.i) function2;
    }
}
