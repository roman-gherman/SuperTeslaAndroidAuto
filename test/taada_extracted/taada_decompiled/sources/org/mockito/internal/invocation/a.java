package org.mockito.internal.invocation;

import java.util.function.Function;
import org.mockito.ArgumentMatcher;
import org.mockito.MockedConstruction;
import org.mockito.internal.util.MockUtil;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4451a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i) {
        this.f4451a = i;
        this.b = obj;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f4451a) {
            case 0:
                return TypeSafeMatching.lambda$getArgumentType$0((ArgumentMatcher) this.b, (Class) obj);
            default:
                return MockUtil.lambda$createConstructionMock$2((Function) this.b, (MockedConstruction.Context) obj);
        }
    }
}
