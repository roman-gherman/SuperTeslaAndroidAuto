package E1;

import java.util.ArrayList;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.z;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final ArrayList e = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f287a;
    public final C5.f b;
    public ArrayList c;
    public boolean d;

    public d(h phase, C5.f fVar) {
        kotlin.jvm.internal.h.f(phase, "phase");
        ArrayList arrayList = e;
        kotlin.jvm.internal.h.d(arrayList, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Function3<io.ktor.util.pipeline.PipelineContext<TSubject of io.ktor.util.pipeline.PhaseContent, Call of io.ktor.util.pipeline.PhaseContent>, TSubject of io.ktor.util.pipeline.PhaseContent, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>{ io.ktor.util.pipeline.PipelineKt.PipelineInterceptorFunction<TSubject of io.ktor.util.pipeline.PhaseContent, Call of io.ktor.util.pipeline.PhaseContent> }>");
        if ((arrayList instanceof KMappedMarker) && !(arrayList instanceof KMutableList)) {
            z.f(arrayList, "kotlin.collections.MutableList");
            throw null;
        }
        this.f287a = phase;
        this.b = fVar;
        this.c = arrayList;
        this.d = true;
        if (!arrayList.isEmpty()) {
            throw new IllegalStateException("The shared empty array list has been modified");
        }
    }

    public final void a(Function3 function3) {
        if (this.d) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.c);
            this.c = arrayList;
            this.d = false;
        }
        this.c.add(function3);
    }

    public final String toString() {
        return "Phase `" + this.f287a.b + "`, " + this.c.size() + " handlers";
    }
}
