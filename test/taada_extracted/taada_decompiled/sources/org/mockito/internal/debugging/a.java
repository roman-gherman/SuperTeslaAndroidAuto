package org.mockito.internal.debugging;

import java.util.function.Predicate;
import org.mockito.stubbing.Stubbing;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Predicate {
    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return InvocationsPrinter.lambda$printInvocations$0((Stubbing) obj);
    }
}
