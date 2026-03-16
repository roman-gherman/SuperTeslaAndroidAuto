package b3;

import a3.AbstractC0162z;
import a3.P;
import a3.Q;
import a3.Z;
import a3.d0;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* JADX INFO: renamed from: b3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0232a extends P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClassicTypeSystemContext f1697a;
    public final /* synthetic */ Z b;

    public C0232a(ClassicTypeSystemContext classicTypeSystemContext, Z z6) {
        this.f1697a = classicTypeSystemContext;
        this.b = z6;
    }

    @Override // a3.P
    public final SimpleTypeMarker a(Q state, KotlinTypeMarker type) {
        kotlin.jvm.internal.h.f(state, "state");
        kotlin.jvm.internal.h.f(type, "type");
        ClassicTypeSystemContext classicTypeSystemContext = this.f1697a;
        Object objLowerBoundIfFlexible = classicTypeSystemContext.lowerBoundIfFlexible(type);
        kotlin.jvm.internal.h.d(objLowerBoundIfFlexible, "null cannot be cast to non-null type org.jetbrains.kotlin.types.KotlinType");
        d0 d0Var = d0.INVARIANT;
        SimpleTypeMarker simpleTypeMarkerAsSimpleType = classicTypeSystemContext.asSimpleType(this.b.h((AbstractC0162z) objLowerBoundIfFlexible, d0Var));
        kotlin.jvm.internal.h.c(simpleTypeMarkerAsSimpleType);
        return simpleTypeMarkerAsSimpleType;
    }
}
