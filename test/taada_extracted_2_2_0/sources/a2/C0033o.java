package A2;

import a3.AbstractC0162z;
import io.ktor.utils.io.b0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import n2.AbstractC0714f;
import q2.C0773j;
import q2.S;
import y2.C0931a;
import z2.C0941a;
import z2.C0944d;
import z2.C0946f;

/* JADX INFO: renamed from: A2.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0033o extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f55a = 0;
    public final /* synthetic */ C0946f b;
    public final /* synthetic */ r c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0033o(r rVar, C0946f c0946f) {
        super(0);
        this.c = rVar;
        this.b = c0946f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [A2.r] */
    /* JADX WARN: Type inference failed for: r2v15, types: [A2.r] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v5, types: [kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v9, types: [kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor, q2.j, q2.v, y2.a] */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.lang.Object, kotlin.Lazy] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        o2.e eVar;
        int i;
        boolean z6;
        C0946f c0946f;
        C0946f c0946f2;
        List listZ;
        ?? r13;
        String str;
        String str2;
        ClassDescriptor classDescriptor;
        ?? arrayList;
        JavaMethod javaMethod;
        ?? r22;
        N1.e eVar2;
        switch (this.f55a) {
            case 0:
                r rVar = this.c;
                Collection<JavaConstructor> constructors = rVar.f59n.getConstructors();
                ArrayList arrayList2 = new ArrayList(constructors.size());
                Iterator<JavaConstructor> it = constructors.iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    boolean z7 = false;
                    C0946f c0946f3 = rVar.f11a;
                    ClassDescriptor classDescriptor2 = rVar.f58m;
                    if (!zHasNext) {
                        JavaClass javaClass = rVar.f59n;
                        boolean zIsRecord = javaClass.isRecord();
                        o2.e eVar3 = o2.f.b;
                        int i3 = 2;
                        C0946f c0946f4 = this.b;
                        if (zIsRecord) {
                            Annotations.Companion.getClass();
                            C0931a c0931aV = C0931a.v(classDescriptor2, eVar3, true, c0946f3.f5204a.f5188j.source(javaClass));
                            Collection<JavaRecordComponent> recordComponents = javaClass.getRecordComponents();
                            ArrayList arrayList3 = new ArrayList(recordComponents.size());
                            B2.a aVarF0 = kotlin.reflect.l.f0(2, false, null, 6);
                            C0946f c0946f5 = c0946f4;
                            int i4 = 0;
                            for (JavaRecordComponent javaRecordComponent : recordComponents) {
                                int i5 = i4 + 1;
                                AbstractC0162z abstractC0162zS = c0946f3.e.s(javaRecordComponent.getType(), aVarF0);
                                boolean zIsVararg = javaRecordComponent.isVararg();
                                C0941a c0941a = c0946f3.f5204a;
                                AbstractC0162z abstractC0162zF = zIsVararg ? c0941a.f5193o.d.f(abstractC0162zS) : null;
                                Annotations.Companion.getClass();
                                L2.f name = javaRecordComponent.getName();
                                JavaSourceElement javaSourceElementSource = c0941a.f5188j.source(javaRecordComponent);
                                ArrayList arrayList4 = arrayList3;
                                C0931a c0931a = c0931aV;
                                C0946f c0946f6 = c0946f5;
                                o2.e eVar4 = eVar3;
                                arrayList4.add(new S(c0931a, null, i4, eVar4, name, abstractC0162zS, false, false, false, abstractC0162zF, javaSourceElementSource));
                                i3 = 2;
                                eVar3 = eVar4;
                                arrayList3 = arrayList4;
                                c0946f5 = c0946f6;
                                c0931aV = c0931a;
                                i4 = i5;
                                z7 = false;
                            }
                            int i6 = i3;
                            eVar = eVar3;
                            i = i6;
                            C0773j c0773j = c0931aV;
                            ArrayList arrayList5 = arrayList3;
                            c0946f = c0946f5;
                            boolean z8 = z7;
                            z6 = true;
                            c0773j.p(z8);
                            AbstractC0714f PROTECTED_AND_PACKAGE = classDescriptor2.getVisibility();
                            kotlin.jvm.internal.h.e(PROTECTED_AND_PACKAGE, "classDescriptor.visibility");
                            if (PROTECTED_AND_PACKAGE.equals(w2.t.b)) {
                                PROTECTED_AND_PACKAGE = w2.t.c;
                                kotlin.jvm.internal.h.e(PROTECTED_AND_PACKAGE, "PROTECTED_AND_PACKAGE");
                            }
                            c0773j.t(arrayList5, PROTECTED_AND_PACKAGE);
                            c0773j.o(false);
                            c0773j.q(classDescriptor2.getDefaultType());
                            String strO = E1.k.o(c0773j, i);
                            if (arrayList2.isEmpty()) {
                                arrayList2.add(c0773j);
                                c0946f.f5204a.f5186g.recordConstructor(javaClass, c0773j);
                            } else {
                                Iterator it2 = arrayList2.iterator();
                                while (it2.hasNext()) {
                                    if (E1.k.o((ClassConstructorDescriptor) it2.next(), i).equals(strO)) {
                                    }
                                }
                                arrayList2.add(c0773j);
                                c0946f.f5204a.f5186g.recordConstructor(javaClass, c0773j);
                            }
                        } else {
                            eVar = eVar3;
                            i = 2;
                            z6 = true;
                            c0946f = c0946f4;
                        }
                        c0946f.f5204a.x.generateConstructors(c0946f, classDescriptor2, arrayList2);
                        C0941a c0941a2 = c0946f.f5204a;
                        if (arrayList2.isEmpty()) {
                            boolean zIsAnnotationType = javaClass.isAnnotationType();
                            if ((javaClass.isInterface() || !javaClass.hasDefaultConstructor()) && !zIsAnnotationType) {
                                c0946f2 = c0946f;
                                r13 = 0;
                            } else {
                                Annotations.Companion.getClass();
                                ?? V5 = C0931a.v(classDescriptor2, eVar, z6, c0946f3.f5204a.f5188j.source(javaClass));
                                if (zIsAnnotationType) {
                                    Collection<JavaMethod> methods = javaClass.getMethods();
                                    arrayList = new ArrayList(methods.size());
                                    B2.a aVarF02 = kotlin.reflect.l.f0(i, z6, null, 6);
                                    ArrayList arrayList6 = new ArrayList();
                                    ArrayList<JavaMethod> arrayList7 = new ArrayList();
                                    for (Object obj : methods) {
                                        r rVar2 = rVar;
                                        if (kotlin.jvm.internal.h.a(((JavaMethod) obj).getName(), w2.D.b)) {
                                            arrayList6.add(obj);
                                        } else {
                                            arrayList7.add(obj);
                                        }
                                        rVar = rVar2;
                                    }
                                    r rVar3 = rVar;
                                    arrayList6.size();
                                    JavaMethod javaMethod2 = (JavaMethod) kotlin.collections.m.R(arrayList6);
                                    B2.d dVar = c0946f3.e;
                                    if (javaMethod2 != null) {
                                        JavaType returnType = javaMethod2.getReturnType();
                                        if (returnType instanceof JavaArrayType) {
                                            JavaArrayType javaArrayType = (JavaArrayType) returnType;
                                            javaMethod = javaMethod2;
                                            eVar2 = new N1.e(dVar.r(javaArrayType, aVarF02, true), dVar.s(javaArrayType.getComponentType(), aVarF02));
                                        } else {
                                            javaMethod = javaMethod2;
                                            eVar2 = new N1.e(dVar.s(returnType, aVarF02), null);
                                        }
                                        AbstractC0162z abstractC0162z = (AbstractC0162z) eVar2.f1121a;
                                        AbstractC0162z abstractC0162z2 = (AbstractC0162z) eVar2.b;
                                        str2 = "classDescriptor.visibility";
                                        ?? r23 = rVar3;
                                        classDescriptor = classDescriptor2;
                                        c0946f2 = c0946f;
                                        str = "PROTECTED_AND_PACKAGE";
                                        r23.q(arrayList, V5, 0, javaMethod, abstractC0162z, abstractC0162z2);
                                        r22 = r23;
                                    } else {
                                        javaMethod = javaMethod2;
                                        str = "PROTECTED_AND_PACKAGE";
                                        str2 = "classDescriptor.visibility";
                                        r22 = rVar3;
                                        classDescriptor = classDescriptor2;
                                        c0946f2 = c0946f;
                                    }
                                    int i7 = javaMethod != null ? 1 : 0;
                                    int i8 = 0;
                                    for (JavaMethod javaMethod3 : arrayList7) {
                                        r22.q(arrayList, V5, i8 + i7, javaMethod3, dVar.s(javaMethod3.getReturnType(), aVarF02), null);
                                        i8++;
                                    }
                                } else {
                                    str = "PROTECTED_AND_PACKAGE";
                                    str2 = "classDescriptor.visibility";
                                    classDescriptor = classDescriptor2;
                                    c0946f2 = c0946f;
                                    arrayList = Collections.EMPTY_LIST;
                                }
                                V5.p(false);
                                AbstractC0714f visibility = classDescriptor.getVisibility();
                                kotlin.jvm.internal.h.e(visibility, str2);
                                if (visibility.equals(w2.t.b)) {
                                    visibility = w2.t.c;
                                    kotlin.jvm.internal.h.e(visibility, str);
                                }
                                V5.t(arrayList, visibility);
                                V5.o(true);
                                V5.q(classDescriptor.getDefaultType());
                                c0946f3.f5204a.f5186g.recordConstructor(javaClass, V5);
                                r13 = V5;
                            }
                            listZ = kotlin.collections.n.z(r13);
                        } else {
                            c0946f2 = c0946f;
                            listZ = arrayList2;
                        }
                        return kotlin.collections.m.o0(c0941a2.f5195r.c(c0946f2, listZ));
                    }
                    JavaConstructor next = it.next();
                    C0944d c0944dZ = b0.z(c0946f3, next);
                    C0941a c0941a3 = c0946f3.f5204a;
                    C0931a c0931aV2 = C0931a.v(classDescriptor2, c0944dZ, false, c0941a3.f5188j.source(next));
                    C0946f c0946f7 = new C0946f(c0941a3, new Y0.b(c0946f3, c0931aV2, next, classDescriptor2.getDeclaredTypeParameters().size()), c0946f3.c);
                    B bN = G.n(c0946f7, c0931aV2, next.getValueParameters());
                    List<TypeParameterDescriptor> declaredTypeParameters = classDescriptor2.getDeclaredTypeParameters();
                    kotlin.jvm.internal.h.e(declaredTypeParameters, "classDescriptor.declaredTypeParameters");
                    List<JavaTypeParameter> typeParameters = next.getTypeParameters();
                    ArrayList arrayList8 = new ArrayList(kotlin.collections.o.D(typeParameters));
                    Iterator it3 = typeParameters.iterator();
                    while (it3.hasNext()) {
                        TypeParameterDescriptor typeParameterDescriptorResolveTypeParameter = c0946f7.b.resolveTypeParameter((JavaTypeParameter) it3.next());
                        kotlin.jvm.internal.h.c(typeParameterDescriptorResolveTypeParameter);
                        arrayList8.add(typeParameterDescriptorResolveTypeParameter);
                    }
                    c0931aV2.u((List) bN.c, w2.O.a(next.getVisibility()), kotlin.collections.m.b0(arrayList8, declaredTypeParameters));
                    c0931aV2.o(false);
                    c0931aV2.p(bN.b);
                    c0931aV2.q(classDescriptor2.getDefaultType());
                    c0946f7.f5204a.f5186g.recordConstructor(next, c0931aV2);
                    arrayList2.add(c0931aV2);
                }
                break;
            default:
                C0946f c0946f8 = this.b;
                return kotlin.collections.m.s0(c0946f8.f5204a.x.getNestedClassNames(c0946f8, this.c.f58m));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0033o(C0946f c0946f, r rVar) {
        super(0);
        this.b = c0946f;
        this.c = rVar;
    }
}
