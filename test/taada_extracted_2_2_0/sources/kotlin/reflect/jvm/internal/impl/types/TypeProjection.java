package kotlin.reflect.jvm.internal.impl.types;

import a3.AbstractC0162z;
import a3.d0;
import b3.d;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface TypeProjection extends TypeArgumentMarker {
    @NotNull
    d0 getProjectionKind();

    @NotNull
    AbstractC0162z getType();

    boolean isStarProjection();

    @NotNull
    TypeProjection refine(@NotNull d dVar);
}
