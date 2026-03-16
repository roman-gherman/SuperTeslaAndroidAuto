package org.mockito.internal.junit;

import java.util.function.Predicate;
import org.mockito.internal.stubbing.UnusedStubbingReporting;
import org.mockito.stubbing.Stubbing;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Predicate {
    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return UnusedStubbingReporting.shouldBeReported((Stubbing) obj);
    }
}
