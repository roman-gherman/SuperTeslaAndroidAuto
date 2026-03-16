package kotlin.reflect.jvm.internal.impl.descriptors;

import n2.AbstractC0714f;
import n2.EnumC0719k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface MemberDescriptor extends DeclarationDescriptorNonRoot, DeclarationDescriptorWithVisibility {
    @NotNull
    EnumC0719k getModality();

    @NotNull
    AbstractC0714f getVisibility();

    boolean isActual();

    boolean isExpect();

    boolean isExternal();
}
