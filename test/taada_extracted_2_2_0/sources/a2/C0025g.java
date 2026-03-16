package A2;

import a3.AbstractC0162z;
import c4.AbstractC0246d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import z2.C0941a;
import z2.C0946f;

/* JADX INFO: renamed from: A2.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0025g implements AnnotationDescriptor, PossiblyExternalAnnotationDescriptor {
    public static final /* synthetic */ KProperty[] i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0946f f34a;
    public final JavaAnnotation b;
    public final NullableLazyValue c;
    public final NotNullLazyValue d;
    public final JavaSourceElement e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final NotNullLazyValue f35f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f36g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f37h;

    static {
        kotlin.jvm.internal.x xVar = kotlin.jvm.internal.w.f3818a;
        i = new KProperty[]{xVar.f(new kotlin.jvm.internal.q(xVar.b(C0025g.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), xVar.f(new kotlin.jvm.internal.q(xVar.b(C0025g.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), xVar.f(new kotlin.jvm.internal.q(xVar.b(C0025g.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    }

    public C0025g(JavaAnnotation javaAnnotation, C0946f c, boolean z6) {
        kotlin.jvm.internal.h.f(c, "c");
        kotlin.jvm.internal.h.f(javaAnnotation, "javaAnnotation");
        this.f34a = c;
        this.b = javaAnnotation;
        C0941a c0941a = c.f5204a;
        Z2.n nVar = c0941a.f5184a;
        this.c = nVar.createNullableLazyValue(new C0024f(this, 1));
        this.d = nVar.createLazyValue(new C0024f(this, 2));
        this.e = c0941a.f5188j.source(javaAnnotation);
        this.f35f = nVar.createLazyValue(new C0024f(this, 0));
        this.f36g = javaAnnotation.isIdeExternalAnnotation();
        this.f37h = javaAnnotation.isFreshlySupportedTypeUseAnnotation() || z6;
    }

    public final P2.g a(JavaAnnotationArgument javaAnnotationArgument) {
        AbstractC0162z abstractC0162zG;
        if (javaAnnotationArgument instanceof JavaLiteralAnnotationArgument) {
            return P2.h.f1218a.b(((JavaLiteralAnnotationArgument) javaAnnotationArgument).getValue(), null);
        }
        if (javaAnnotationArgument instanceof JavaEnumValueAnnotationArgument) {
            JavaEnumValueAnnotationArgument javaEnumValueAnnotationArgument = (JavaEnumValueAnnotationArgument) javaAnnotationArgument;
            L2.b enumClassId = javaEnumValueAnnotationArgument.getEnumClassId();
            L2.f entryName = javaEnumValueAnnotationArgument.getEntryName();
            if (enumClassId != null && entryName != null) {
                return new P2.i(enumClassId, entryName);
            }
        } else {
            boolean z6 = javaAnnotationArgument instanceof JavaArrayAnnotationArgument;
            C0946f c0946f = this.f34a;
            if (z6) {
                JavaArrayAnnotationArgument javaArrayAnnotationArgument = (JavaArrayAnnotationArgument) javaAnnotationArgument;
                L2.f name = javaArrayAnnotationArgument.getName();
                if (name == null) {
                    name = w2.D.b;
                }
                kotlin.jvm.internal.h.e(name, "argument.name ?: DEFAULT_ANNOTATION_MEMBER_NAME");
                List<JavaAnnotationArgument> elements = javaArrayAnnotationArgument.getElements();
                a3.F type = (a3.F) AbstractC0246d.T(this.d, i[1]);
                kotlin.jvm.internal.h.e(type, "type");
                if (!kotlin.reflect.l.O(type)) {
                    ClassDescriptor classDescriptorD = R2.e.d(this);
                    kotlin.jvm.internal.h.c(classDescriptorD);
                    ValueParameterDescriptor valueParameterDescriptorI = k1.j.i(name, classDescriptorD);
                    if (valueParameterDescriptorI == null || (abstractC0162zG = valueParameterDescriptorI.getType()) == null) {
                        abstractC0162zG = c0946f.f5204a.f5193o.d.g(c3.j.c(c3.i.UNKNOWN_ARRAY_ELEMENT_TYPE_OF_ANNOTATION_ARGUMENT, new String[0]));
                    }
                    ArrayList arrayList = new ArrayList(kotlin.collections.o.D(elements));
                    Iterator<T> it = elements.iterator();
                    while (it.hasNext()) {
                        P2.g gVarA = a((JavaAnnotationArgument) it.next());
                        if (gVarA == null) {
                            gVarA = new P2.t(null);
                        }
                        arrayList.add(gVarA);
                    }
                    return new P2.w(arrayList, abstractC0162zG);
                }
            } else {
                if (javaAnnotationArgument instanceof JavaAnnotationAsAnnotationArgument) {
                    return new P2.a((Object) new C0025g(((JavaAnnotationAsAnnotationArgument) javaAnnotationArgument).getAnnotation(), c0946f, false));
                }
                if (javaAnnotationArgument instanceof JavaClassObjectAnnotationArgument) {
                    AbstractC0162z abstractC0162zS = c0946f.e.s(((JavaClassObjectAnnotationArgument) javaAnnotationArgument).getReferencedType(), kotlin.reflect.l.f0(2, false, null, 7));
                    if (!kotlin.reflect.l.O(abstractC0162zS)) {
                        AbstractC0162z type2 = abstractC0162zS;
                        int i3 = 0;
                        while (k2.i.x(type2)) {
                            type2 = ((TypeProjection) kotlin.collections.m.g0(type2.a())).getType();
                            kotlin.jvm.internal.h.e(type2, "type.arguments.single().type");
                            i3++;
                        }
                        ClassifierDescriptor declarationDescriptor = type2.c().getDeclarationDescriptor();
                        if (declarationDescriptor instanceof ClassDescriptor) {
                            L2.b bVarF = R2.e.f(declarationDescriptor);
                            return bVarF == null ? new P2.r(new P2.o(abstractC0162zS)) : new P2.r(bVarF, i3);
                        }
                        if (declarationDescriptor instanceof TypeParameterDescriptor) {
                            return new P2.r(L2.b.j(k2.o.f3743a.g()), 0);
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public final Map getAllValueArguments() {
        return (Map) AbstractC0246d.T(this.f35f, i[2]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public final L2.c getFqName() {
        KProperty p5 = i[0];
        NullableLazyValue nullableLazyValue = this.c;
        kotlin.jvm.internal.h.f(nullableLazyValue, "<this>");
        kotlin.jvm.internal.h.f(p5, "p");
        return (L2.c) nullableLazyValue.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public final SourceElement getSource() {
        return this.e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public final AbstractC0162z getType() {
        return (a3.F) AbstractC0246d.T(this.d, i[1]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor
    public final boolean isIdeExternalAnnotation() {
        return this.f36g;
    }

    public final String toString() {
        return M2.n.f1060a.l(this, null);
    }
}
