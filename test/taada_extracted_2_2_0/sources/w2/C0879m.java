package w2;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;

/* JADX INFO: renamed from: w2.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0879m extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0879m f5017a = new C0879m(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((ValueParameterDescriptor) obj).getType();
    }
}
