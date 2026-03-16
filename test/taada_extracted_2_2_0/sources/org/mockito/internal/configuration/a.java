package org.mockito.internal.configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4437a;
    public final /* synthetic */ Collection b;

    public /* synthetic */ a(Collection collection, int i) {
        this.f4437a = i;
        this.b = collection;
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws Exception {
        switch (this.f4437a) {
            case 0:
                IndependentAnnotationEngine.lambda$process$0((ArrayList) this.b);
                break;
            case 1:
                InjectingAnnotationEngine.lambda$process$0((ArrayList) this.b);
                break;
            default:
                InjectingAnnotationEngine.lambda$injectCloseableMocks$1((Set) this.b);
                break;
        }
    }
}
