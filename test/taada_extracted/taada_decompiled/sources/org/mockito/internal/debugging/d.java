package org.mockito.internal.debugging;

import java.util.function.Predicate;
import org.mockito.exceptions.stacktrace.StackTraceCleaner;
import org.mockito.internal.verification.api.InOrderContext;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.MatchableInvocation;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4450a;
    public final /* synthetic */ Object b;

    public /* synthetic */ d(Object obj, int i) {
        this.f4450a = i;
        this.b = obj;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f4450a) {
            case 0:
                return ((StackTraceCleaner) this.b).isIn((StackTraceCleaner.StackFrameMetadata) obj);
            case 1:
                return ((InOrderContext) this.b).isVerified((Invocation) obj);
            default:
                return ((MatchableInvocation) this.b).matches((Invocation) obj);
        }
    }
}
