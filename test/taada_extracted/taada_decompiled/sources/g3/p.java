package g3;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements ModuleVisibilityHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f3317a = new p();

    @Override // kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper
    public final boolean isInFriendModule(DeclarationDescriptor what, DeclarationDescriptor from) {
        kotlin.jvm.internal.h.f(what, "what");
        kotlin.jvm.internal.h.f(from, "from");
        return true;
    }
}
