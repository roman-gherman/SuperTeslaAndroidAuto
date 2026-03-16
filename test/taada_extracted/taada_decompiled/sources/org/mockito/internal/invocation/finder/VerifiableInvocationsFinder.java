package org.mockito.internal.invocation.finder;

import java.util.List;
import java.util.stream.Collectors;
import n5.a;
import org.mockito.invocation.Invocation;

/* JADX INFO: loaded from: classes.dex */
public class VerifiableInvocationsFinder {
    private VerifiableInvocationsFinder() {
    }

    public static List<Invocation> find(List<?> list) {
        return (List) AllInvocationsFinder.find(list).stream().filter(new a(0)).collect(Collectors.toList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$find$0(Invocation invocation) {
        return !invocation.isIgnoredForVerification();
    }
}
