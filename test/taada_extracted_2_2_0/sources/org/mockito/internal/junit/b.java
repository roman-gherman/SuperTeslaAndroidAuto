package org.mockito.internal.junit;

import java.util.function.Function;
import org.mockito.invocation.Invocation;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return StubbingArgMismatches.lambda$add$0((Invocation) obj);
    }
}
