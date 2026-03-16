package a3;

import java.util.ArrayDeque;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* JADX INFO: loaded from: classes2.dex */
public class Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1536a;
    public final boolean b;
    public final ClassicTypeSystemContext c;
    public final b3.b d;
    public final b3.d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1537f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayDeque f1538g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public j3.m f1539h;

    public Q(boolean z6, boolean z7, ClassicTypeSystemContext typeSystemContext, b3.b kotlinTypePreparator, b3.d kotlinTypeRefiner) {
        kotlin.jvm.internal.h.f(typeSystemContext, "typeSystemContext");
        kotlin.jvm.internal.h.f(kotlinTypePreparator, "kotlinTypePreparator");
        kotlin.jvm.internal.h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        this.f1536a = z6;
        this.b = z7;
        this.c = typeSystemContext;
        this.d = kotlinTypePreparator;
        this.e = kotlinTypeRefiner;
    }

    public final void a() {
        ArrayDeque arrayDeque = this.f1538g;
        kotlin.jvm.internal.h.c(arrayDeque);
        arrayDeque.clear();
        j3.m mVar = this.f1539h;
        kotlin.jvm.internal.h.c(mVar);
        mVar.clear();
    }

    public final void b() {
        if (this.f1538g == null) {
            this.f1538g = new ArrayDeque(4);
        }
        if (this.f1539h == null) {
            this.f1539h = new j3.m();
        }
    }

    public final c0 c(KotlinTypeMarker type) {
        kotlin.jvm.internal.h.f(type, "type");
        return this.d.a(type);
    }

    public final AbstractC0162z d(KotlinTypeMarker type) {
        kotlin.jvm.internal.h.f(type, "type");
        ((b3.c) this.e).getClass();
        return (AbstractC0162z) type;
    }
}
