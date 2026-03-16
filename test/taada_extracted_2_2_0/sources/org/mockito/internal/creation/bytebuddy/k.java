package org.mockito.internal.creation.bytebuddy;

import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((Class) obj).getName();
    }
}
