package v2;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;

/* JADX INFO: renamed from: v2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0850a implements LookupTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0850a f4933a = new C0850a();

    @Override // kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker
    public final boolean getRequiresPosition() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker
    public final void record(String filePath, C0852c position, String scopeFqName, EnumC0853d scopeKind, String name) {
        h.f(filePath, "filePath");
        h.f(position, "position");
        h.f(scopeFqName, "scopeFqName");
        h.f(scopeKind, "scopeKind");
        h.f(name, "name");
    }
}
