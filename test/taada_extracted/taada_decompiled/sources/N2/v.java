package n2;

import a3.AbstractC0162z;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* JADX INFO: loaded from: classes2.dex */
public final class v implements SupertypeLoopChecker, ReceiverValue, SourceFile {
    public static final v b = new v(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4259a;

    public /* synthetic */ v(int i) {
        this.f4259a = i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker
    public Collection findLoopsInSupertypesAndDisconnect(TypeConstructor currentTypeConstructor, Collection superTypes, Function1 neighbors, Function1 reportLoop) {
        kotlin.jvm.internal.h.f(currentTypeConstructor, "currentTypeConstructor");
        kotlin.jvm.internal.h.f(superTypes, "superTypes");
        kotlin.jvm.internal.h.f(neighbors, "neighbors");
        kotlin.jvm.internal.h.f(reportLoop, "reportLoop");
        return superTypes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceFile
    public String getName() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
    public AbstractC0162z getType() {
        switch (this.f4259a) {
            case 1:
                throw new IllegalStateException("This method should not be called");
            case 2:
                throw new IllegalStateException("This method should not be called");
            default:
                throw new IllegalStateException("This method should not be called");
        }
    }
}
