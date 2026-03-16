package kotlin.reflect.jvm.internal.impl.load.java.structure;

import n2.AbstractC0708K;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface JavaModifierListOwner extends JavaElement {
    @NotNull
    AbstractC0708K getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isStatic();
}
