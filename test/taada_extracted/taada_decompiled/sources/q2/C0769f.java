package q2;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: renamed from: q2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0769f implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StorageManager f4591a;
    public final /* synthetic */ n2.v b;
    public final /* synthetic */ AbstractC0772i c;

    public C0769f(AbstractC0772i abstractC0772i, StorageManager storageManager, n2.v vVar) {
        this.c = abstractC0772i;
        this.f4591a = storageManager;
        this.b = vVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return new C0771h(this.c, this.f4591a, this.b);
    }
}
