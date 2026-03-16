package kotlin.reflect.jvm.internal.impl.descriptors;

import N1.m;
import a3.AbstractC0162z;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface SupertypeLoopChecker {
    @NotNull
    Collection<AbstractC0162z> findLoopsInSupertypesAndDisconnect(@NotNull TypeConstructor typeConstructor, @NotNull Collection<? extends AbstractC0162z> collection, @NotNull Function1<? super TypeConstructor, ? extends Iterable<? extends AbstractC0162z>> function1, @NotNull Function1<? super AbstractC0162z, m> function12);
}
