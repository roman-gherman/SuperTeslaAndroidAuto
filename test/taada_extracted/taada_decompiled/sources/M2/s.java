package M2;

import A2.C0022d;
import a.AbstractC0132a;
import a3.AbstractC0155s;
import a3.AbstractC0162z;
import a3.C0138a;
import a3.C0152o;
import a3.C0161y;
import a3.c0;
import io.ktor.utils.io.Z;
import io.ktor.utils.io.b0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$ValueParametersHandler;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import n2.AbstractC0713e;
import n2.AbstractC0714f;
import n2.C0712d;
import n2.C0723o;
import n2.EnumC0709a;
import n2.EnumC0719k;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.pool.TypePool;
import o2.EnumC0739c;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends n implements DescriptorRendererOptions {
    public final x d;
    public final N1.j e = AbstractC0132a.M(new C0022d(this, 1));

    public s(x xVar) {
        this.d = xVar;
    }

    public static void L(StringBuilder sb) {
        int length = sb.length();
        if (length == 0 || sb.charAt(length - 1) != ' ') {
            sb.append(' ');
        }
    }

    public static boolean X(AbstractC0162z abstractC0162z) {
        if (!b0.u(abstractC0162z)) {
            return false;
        }
        List listA = abstractC0162z.a();
        if (listA != null && listA.isEmpty()) {
            return true;
        }
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            if (((TypeProjection) it.next()).isStarProjection()) {
                return false;
            }
        }
        return true;
    }

    public static final void b(s sVar, PropertyDescriptor propertyDescriptor, StringBuilder sb) {
        if (!sVar.f()) {
            x xVar = sVar.d;
            KProperty[] kPropertyArr = x.f1080W;
            if (!((Boolean) xVar.f1097g.getValue(xVar, kPropertyArr[5])).booleanValue()) {
                if (sVar.e().contains(t.ANNOTATIONS)) {
                    sVar.m(sb, propertyDescriptor, null);
                    FieldDescriptor backingField = propertyDescriptor.getBackingField();
                    if (backingField != null) {
                        sVar.m(sb, backingField, EnumC0739c.FIELD);
                    }
                    FieldDescriptor delegateField = propertyDescriptor.getDelegateField();
                    if (delegateField != null) {
                        sVar.m(sb, delegateField, EnumC0739c.PROPERTY_DELEGATE_FIELD);
                    }
                    if (((C) xVar.f1085G.getValue(xVar, kPropertyArr[31])) == C.b) {
                        PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
                        if (getter != null) {
                            sVar.m(sb, getter, EnumC0739c.PROPERTY_GETTER);
                        }
                        PropertySetterDescriptor setter = propertyDescriptor.getSetter();
                        if (setter != null) {
                            sVar.m(sb, setter, EnumC0739c.PROPERTY_SETTER);
                            List<ValueParameterDescriptor> valueParameters = setter.getValueParameters();
                            kotlin.jvm.internal.h.e(valueParameters, "setter.valueParameters");
                            ValueParameterDescriptor it = (ValueParameterDescriptor) kotlin.collections.m.g0(valueParameters);
                            kotlin.jvm.internal.h.e(it, "it");
                            sVar.m(sb, it, EnumC0739c.SETTER_PARAMETER);
                        }
                    }
                }
                List<ReceiverParameterDescriptor> contextReceiverParameters = propertyDescriptor.getContextReceiverParameters();
                kotlin.jvm.internal.h.e(contextReceiverParameters, "property.contextReceiverParameters");
                sVar.q(sb, contextReceiverParameters);
                AbstractC0714f visibility = propertyDescriptor.getVisibility();
                kotlin.jvm.internal.h.e(visibility, "property.visibility");
                sVar.V(visibility, sb);
                sVar.C(sb, sVar.e().contains(t.CONST) && propertyDescriptor.isConst(), "const");
                sVar.y(propertyDescriptor, sb);
                sVar.B(sb, propertyDescriptor);
                sVar.G(sb, propertyDescriptor);
                sVar.C(sb, sVar.e().contains(t.LATEINIT) && propertyDescriptor.isLateInit(), "lateinit");
                sVar.x(sb, propertyDescriptor);
            }
            sVar.S(propertyDescriptor, sb, false);
            List<TypeParameterDescriptor> typeParameters = propertyDescriptor.getTypeParameters();
            kotlin.jvm.internal.h.e(typeParameters, "property.typeParameters");
            sVar.R(sb, typeParameters, true);
            sVar.J(sb, propertyDescriptor);
        }
        sVar.D(propertyDescriptor, sb, true);
        sb.append(": ");
        AbstractC0162z type = propertyDescriptor.getType();
        kotlin.jvm.internal.h.e(type, "property.type");
        sb.append(sVar.M(type));
        sVar.K(sb, propertyDescriptor);
        sVar.v(propertyDescriptor, sb);
        List<TypeParameterDescriptor> typeParameters2 = propertyDescriptor.getTypeParameters();
        kotlin.jvm.internal.h.e(typeParameters2, "property.typeParameters");
        sVar.W(sb, typeParameters2);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0059 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static n2.EnumC0719k j(kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor r6) {
        /*
            boolean r0 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            n2.k r1 = n2.EnumC0719k.d
            n2.c r2 = n2.EnumC0711c.b
            n2.k r3 = n2.EnumC0719k.f4247a
            if (r0 == 0) goto L13
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r6
            n2.c r6 = r6.getKind()
            if (r6 != r2) goto L5b
            goto L59
        L13:
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = r6.getContainingDeclaration()
            boolean r4 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r4 == 0) goto L1e
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
            goto L1f
        L1e:
            r0 = 0
        L1f:
            if (r0 != 0) goto L22
            goto L5b
        L22:
            boolean r4 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
            if (r4 != 0) goto L27
            goto L5b
        L27:
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r6
            java.util.Collection r4 = r6.getOverriddenDescriptors()
            java.lang.String r5 = "this.overriddenDescriptors"
            kotlin.jvm.internal.h.e(r4, r5)
            boolean r4 = r4.isEmpty()
            n2.k r5 = n2.EnumC0719k.c
            if (r4 != 0) goto L41
            n2.k r4 = r0.getModality()
            if (r4 == r3) goto L41
            goto L5a
        L41:
            n2.c r0 = r0.getKind()
            if (r0 != r2) goto L5b
            n2.f r0 = r6.getVisibility()
            n2.d r2 = n2.AbstractC0713e.f4232a
            boolean r0 = kotlin.jvm.internal.h.a(r0, r2)
            if (r0 != 0) goto L5b
            n2.k r6 = r6.getModality()
            if (r6 != r1) goto L5a
        L59:
            return r1
        L5a:
            return r5
        L5b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: M2.s.j(kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor):n2.k");
    }

    public final void A(EnumC0719k enumC0719k, StringBuilder sb, EnumC0719k enumC0719k2) {
        x xVar = this.d;
        if (((Boolean) xVar.f1105p.getValue(xVar, x.f1080W[14])).booleanValue() || enumC0719k != enumC0719k2) {
            C(sb, e().contains(t.MODALITY), C5.f.l0(enumC0719k.name()));
        }
    }

    public final void B(StringBuilder sb, CallableMemberDescriptor callableMemberDescriptor) {
        if (N2.f.s(callableMemberDescriptor) && callableMemberDescriptor.getModality() == EnumC0719k.f4247a) {
            return;
        }
        x xVar = this.d;
        if (((A) xVar.f1081A.getValue(xVar, x.f1080W[25])) == A.f1043a && callableMemberDescriptor.getModality() == EnumC0719k.c && !callableMemberDescriptor.getOverriddenDescriptors().isEmpty()) {
            return;
        }
        EnumC0719k modality = callableMemberDescriptor.getModality();
        kotlin.jvm.internal.h.e(modality, "callable.modality");
        A(modality, sb, j(callableMemberDescriptor));
    }

    public final void C(StringBuilder sb, boolean z6, String str) {
        if (z6) {
            sb.append(w(str));
            sb.append(" ");
        }
    }

    public final void D(DeclarationDescriptor declarationDescriptor, StringBuilder sb, boolean z6) {
        L2.f name = declarationDescriptor.getName();
        kotlin.jvm.internal.h.e(name, "descriptor.name");
        sb.append(a(name, z6));
    }

    public final void E(StringBuilder sb, AbstractC0162z abstractC0162z) {
        c0 c0VarF = abstractC0162z.f();
        C0138a c0138a = c0VarF instanceof C0138a ? (C0138a) c0VarF : null;
        if (c0138a == null) {
            F(sb, abstractC0162z);
            return;
        }
        x xVar = this.d;
        KProperty[] kPropertyArr = x.f1080W;
        boolean zBooleanValue = ((Boolean) xVar.f1092Q.getValue(xVar, kPropertyArr[41])).booleanValue();
        a3.F f6 = c0138a.b;
        if (zBooleanValue) {
            F(sb, f6);
            return;
        }
        F(sb, c0138a.c);
        if (((Boolean) xVar.f1091P.getValue(xVar, kPropertyArr[40])).booleanValue()) {
            F fG = g();
            D d = F.b;
            if (fG == d) {
                sb.append("<font color=\"808080\"><i>");
            }
            sb.append(" /* = ");
            F(sb, f6);
            sb.append(" */");
            if (g() == d) {
                sb.append("</i></font>");
            }
        }
    }

    public final void F(StringBuilder sb, AbstractC0162z abstractC0162z) {
        L2.f fVarL;
        String strC;
        boolean z6 = abstractC0162z instanceof a3.D;
        x xVar = this.d;
        if (z6 && xVar.getDebugMode() && !((a3.D) abstractC0162z).d.isComputed()) {
            sb.append("<Not computed yet>");
            return;
        }
        c0 c0VarF = abstractC0162z.f();
        if (c0VarF instanceof AbstractC0155s) {
            sb.append(((AbstractC0155s) c0VarF).k(this, this));
            return;
        }
        if (c0VarF instanceof a3.F) {
            a3.F f6 = (a3.F) c0VarF;
            if (f6.equals(a3.b0.b) || f6.c() == a3.b0.f1543a.b) {
                sb.append("???");
                return;
            }
            TypeConstructor typeConstructorC = f6.c();
            if ((typeConstructorC instanceof c3.h) && ((c3.h) typeConstructorC).f1753a == c3.i.UNINFERRED_TYPE_VARIABLE) {
                if (!((Boolean) xVar.f1108t.getValue(xVar, x.f1080W[18])).booleanValue()) {
                    sb.append("???");
                    return;
                }
                TypeConstructor typeConstructorC2 = f6.c();
                kotlin.jvm.internal.h.d(typeConstructorC2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
                sb.append(s(((c3.h) typeConstructorC2).b[0]));
                return;
            }
            if (kotlin.reflect.l.O(f6)) {
                r(sb, f6);
                return;
            }
            if (!X(f6)) {
                r(sb, f6);
                return;
            }
            int length = sb.length();
            ((s) this.e.getValue()).m(sb, f6, null);
            boolean z7 = sb.length() != length;
            AbstractC0162z abstractC0162zR = b0.r(f6);
            List listM = b0.m(f6);
            if (!listM.isEmpty()) {
                sb.append("context(");
                Iterator it = listM.subList(0, kotlin.collections.n.x(listM)).iterator();
                while (it.hasNext()) {
                    E(sb, (AbstractC0162z) it.next());
                    sb.append(", ");
                }
                E(sb, (AbstractC0162z) kotlin.collections.m.X(listM));
                sb.append(") ");
            }
            boolean zV = b0.v(f6);
            boolean zD = f6.d();
            boolean z8 = zD || (z7 && abstractC0162zR != null);
            if (z8) {
                if (zV) {
                    sb.insert(length, '(');
                } else {
                    if (z7) {
                        io.ktor.utils.io.jvm.javaio.q.m(kotlin.text.i.K(sb));
                        if (sb.charAt(kotlin.text.i.F(sb) - 1) != ')') {
                            sb.insert(kotlin.text.i.F(sb), "()");
                        }
                    }
                    sb.append("(");
                }
            }
            C(sb, zV, "suspend");
            if (abstractC0162zR != null) {
                boolean z9 = (X(abstractC0162zR) && !abstractC0162zR.d()) || b0.v(abstractC0162zR) || !abstractC0162zR.getAnnotations().isEmpty() || (abstractC0162zR instanceof C0152o);
                if (z9) {
                    sb.append("(");
                }
                E(sb, abstractC0162zR);
                if (z9) {
                    sb.append(")");
                }
                sb.append(".");
            }
            sb.append("(");
            if (!b0.u(f6) || f6.getAnnotations().findAnnotation(k2.o.f3755p) == null || f6.a().size() > 1) {
                int i = 0;
                for (TypeProjection typeProjection : b0.s(f6)) {
                    int i3 = i + 1;
                    if (i > 0) {
                        sb.append(", ");
                    }
                    if (((Boolean) xVar.S.getValue(xVar, x.f1080W[43])).booleanValue()) {
                        AbstractC0162z type = typeProjection.getType();
                        kotlin.jvm.internal.h.e(type, "typeProjection.type");
                        fVarL = b0.l(type);
                    } else {
                        fVarL = null;
                    }
                    if (fVarL != null) {
                        sb.append(a(fVarL, false));
                        sb.append(": ");
                    }
                    kotlin.jvm.internal.h.f(typeProjection, "typeProjection");
                    StringBuilder sb2 = new StringBuilder();
                    kotlin.collections.m.U(Z.p(typeProjection), sb2, ", ", null, null, new o(this, 0), 60);
                    String string = sb2.toString();
                    kotlin.jvm.internal.h.e(string, "StringBuilder().apply(builderAction).toString()");
                    sb.append(string);
                    i = i3;
                }
            } else {
                sb.append("???");
            }
            sb.append(") ");
            int iOrdinal = g().ordinal();
            if (iOrdinal == 0) {
                strC = c("->");
            } else {
                if (iOrdinal != 1) {
                    throw new C0.x();
                }
                strC = "&rarr;";
            }
            sb.append(strC);
            sb.append(" ");
            b0.u(f6);
            AbstractC0162z type2 = ((TypeProjection) kotlin.collections.m.X(f6.a())).getType();
            kotlin.jvm.internal.h.e(type2, "arguments.last().type");
            E(sb, type2);
            if (z8) {
                sb.append(")");
            }
            if (zD) {
                sb.append(TypeDescription.Generic.OfWildcardType.SYMBOL);
            }
        }
    }

    public final void G(StringBuilder sb, CallableMemberDescriptor callableMemberDescriptor) {
        if (e().contains(t.OVERRIDE) && !callableMemberDescriptor.getOverriddenDescriptors().isEmpty()) {
            x xVar = this.d;
            if (((A) xVar.f1081A.getValue(xVar, x.f1080W[25])) != A.b) {
                C(sb, true, "override");
                if (i()) {
                    sb.append("/*");
                    sb.append(callableMemberDescriptor.getOverriddenDescriptors().size());
                    sb.append("*/ ");
                }
            }
        }
    }

    public final void H(L2.c cVar, String str, StringBuilder sb) {
        sb.append(w(str));
        L2.e eVarI = cVar.i();
        kotlin.jvm.internal.h.e(eVarI, "fqName.toUnsafe()");
        String strC = c(E1.k.f0(eVarI.e()));
        if (strC.length() > 0) {
            sb.append(" ");
            sb.append(strC);
        }
    }

    public final void I(StringBuilder sb, B2.d dVar) {
        B2.d dVar2 = (B2.d) dVar.d;
        ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters = (ClassifierDescriptorWithTypeParameters) dVar.b;
        if (dVar2 != null) {
            I(sb, dVar2);
            sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
            L2.f name = classifierDescriptorWithTypeParameters.getName();
            kotlin.jvm.internal.h.e(name, "possiblyInnerType.classifierDescriptor.name");
            sb.append(a(name, false));
        } else {
            TypeConstructor typeConstructor = classifierDescriptorWithTypeParameters.getTypeConstructor();
            kotlin.jvm.internal.h.e(typeConstructor, "possiblyInnerType.classi…escriptor.typeConstructor");
            sb.append(O(typeConstructor));
        }
        sb.append(N((List) dVar.c));
    }

    public final void J(StringBuilder sb, CallableMemberDescriptor callableMemberDescriptor) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableMemberDescriptor.getExtensionReceiverParameter();
        if (extensionReceiverParameter != null) {
            m(sb, extensionReceiverParameter, EnumC0739c.RECEIVER);
            AbstractC0162z type = extensionReceiverParameter.getType();
            kotlin.jvm.internal.h.e(type, "receiver.type");
            sb.append(u(type));
            sb.append(".");
        }
    }

    public final void K(StringBuilder sb, CallableMemberDescriptor callableMemberDescriptor) {
        ReceiverParameterDescriptor extensionReceiverParameter;
        x xVar = this.d;
        if (((Boolean) xVar.E.getValue(xVar, x.f1080W[29])).booleanValue() && (extensionReceiverParameter = callableMemberDescriptor.getExtensionReceiverParameter()) != null) {
            sb.append(" on ");
            AbstractC0162z type = extensionReceiverParameter.getType();
            kotlin.jvm.internal.h.e(type, "receiver.type");
            sb.append(M(type));
        }
    }

    public final String M(AbstractC0162z type) {
        kotlin.jvm.internal.h.f(type, "type");
        StringBuilder sb = new StringBuilder();
        x xVar = this.d;
        E(sb, (AbstractC0162z) ((Function1) xVar.x.getValue(xVar, x.f1080W[22])).invoke(type));
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String N(List typeArguments) {
        kotlin.jvm.internal.h.f(typeArguments, "typeArguments");
        if (typeArguments.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(c("<"));
        kotlin.collections.m.U(typeArguments, sb, ", ", null, null, new o(this, 0), 60);
        sb.append(c(">"));
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String O(TypeConstructor typeConstructor) {
        kotlin.jvm.internal.h.f(typeConstructor, "typeConstructor");
        ClassifierDescriptor klass = typeConstructor.getDeclarationDescriptor();
        if (klass instanceof TypeParameterDescriptor ? true : klass instanceof ClassDescriptor ? true : klass instanceof TypeAliasDescriptor) {
            kotlin.jvm.internal.h.f(klass, "klass");
            return c3.j.f(klass) ? klass.getTypeConstructor().toString() : d().renderClassifier(klass, this);
        }
        if (klass == null) {
            return typeConstructor instanceof C0161y ? ((C0161y) typeConstructor).b(r.f1064a) : typeConstructor.toString();
        }
        throw new IllegalStateException(("Unexpected classifier: " + klass.getClass()).toString());
    }

    public final void P(TypeParameterDescriptor typeParameterDescriptor, StringBuilder sb, boolean z6) {
        if (z6) {
            sb.append(c("<"));
        }
        if (i()) {
            sb.append("/*");
            sb.append(typeParameterDescriptor.getIndex());
            sb.append("*/ ");
        }
        C(sb, typeParameterDescriptor.isReified(), "reified");
        String str = typeParameterDescriptor.getVariance().f1547a;
        boolean z7 = true;
        C(sb, str.length() > 0, str);
        m(sb, typeParameterDescriptor, null);
        D(typeParameterDescriptor, sb, z6);
        int size = typeParameterDescriptor.getUpperBounds().size();
        if ((size > 1 && !z6) || size == 1) {
            AbstractC0162z next = typeParameterDescriptor.getUpperBounds().iterator().next();
            if (next == null) {
                k2.i.a(141);
                throw null;
            }
            if (!k2.i.w(next) || !next.d()) {
                sb.append(" : ");
                sb.append(M(next));
            }
        } else if (z6) {
            for (AbstractC0162z abstractC0162z : typeParameterDescriptor.getUpperBounds()) {
                if (abstractC0162z == null) {
                    k2.i.a(141);
                    throw null;
                }
                if (!k2.i.w(abstractC0162z) || !abstractC0162z.d()) {
                    if (z7) {
                        sb.append(" : ");
                    } else {
                        sb.append(" & ");
                    }
                    sb.append(M(abstractC0162z));
                    z7 = false;
                }
            }
        }
        if (z6) {
            sb.append(c(">"));
        }
    }

    public final void Q(StringBuilder sb, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            P((TypeParameterDescriptor) it.next(), sb, false);
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
    }

    public final void R(StringBuilder sb, List list, boolean z6) {
        x xVar = this.d;
        if (((Boolean) xVar.f1109v.getValue(xVar, x.f1080W[20])).booleanValue() || list.isEmpty()) {
            return;
        }
        sb.append(c("<"));
        Q(sb, list);
        sb.append(c(">"));
        if (z6) {
            sb.append(" ");
        }
    }

    public final void S(VariableDescriptor variableDescriptor, StringBuilder sb, boolean z6) {
        if (z6 || !(variableDescriptor instanceof ValueParameterDescriptor)) {
            sb.append(w(variableDescriptor.isVar() ? "var" : "val"));
            sb.append(" ");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r11, boolean r12, java.lang.StringBuilder r13, boolean r14) {
        /*
            Method dump skipped, instruction units count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: M2.s.T(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor, boolean, java.lang.StringBuilder, boolean):void");
    }

    public final void U(StringBuilder sb, List list, boolean z6) {
        x xVar = this.d;
        int iOrdinal = ((B) xVar.f1083D.getValue(xVar, x.f1080W[28])).ordinal();
        boolean z7 = true;
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    throw new C0.x();
                }
            } else if (z6) {
            }
            z7 = false;
        }
        int size = list.size();
        h().appendBeforeValueParameters(size, sb);
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) it.next();
            h().appendBeforeValueParameter(valueParameterDescriptor, i, size, sb);
            T(valueParameterDescriptor, z7, sb, false);
            h().appendAfterValueParameter(valueParameterDescriptor, i, size, sb);
            i++;
        }
        h().appendAfterValueParameters(size, sb);
    }

    public final boolean V(AbstractC0714f abstractC0714f, StringBuilder sb) {
        if (!e().contains(t.VISIBILITY)) {
            return false;
        }
        x xVar = this.d;
        KProperty[] kPropertyArr = x.f1080W;
        if (((Boolean) xVar.f1103n.getValue(xVar, kPropertyArr[12])).booleanValue()) {
            abstractC0714f = AbstractC0713e.g(((C0712d) abstractC0714f).f4231a.c());
        }
        if (!((Boolean) xVar.f1104o.getValue(xVar, kPropertyArr[13])).booleanValue() && abstractC0714f.equals(AbstractC0713e.f4237k)) {
            return false;
        }
        sb.append(w(((C0712d) abstractC0714f).f4231a.b()));
        sb.append(" ");
        return true;
    }

    public final void W(StringBuilder sb, List list) {
        x xVar = this.d;
        if (((Boolean) xVar.f1109v.getValue(xVar, x.f1080W[20])).booleanValue()) {
            return;
        }
        ArrayList arrayList = new ArrayList(0);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) it.next();
            List<AbstractC0162z> upperBounds = typeParameterDescriptor.getUpperBounds();
            kotlin.jvm.internal.h.e(upperBounds, "typeParameter.upperBounds");
            for (AbstractC0162z it2 : kotlin.collections.m.M(upperBounds)) {
                StringBuilder sb2 = new StringBuilder();
                L2.f name = typeParameterDescriptor.getName();
                kotlin.jvm.internal.h.e(name, "typeParameter.name");
                sb2.append(a(name, false));
                sb2.append(" : ");
                kotlin.jvm.internal.h.e(it2, "it");
                sb2.append(M(it2));
                arrayList.add(sb2.toString());
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        sb.append(" ");
        sb.append(w("where"));
        sb.append(" ");
        kotlin.collections.m.U(arrayList, sb, ", ", null, null, null, 124);
    }

    @Override // M2.n
    public final String a(L2.f fVar, boolean z6) {
        String strC = c(E1.k.e0(fVar));
        x xVar = this.d;
        return (((Boolean) xVar.U.getValue(xVar, x.f1080W[46])).booleanValue() && g() == F.b && z6) ? androidx.constraintlayout.core.motion.a.q("<b>", strC, "</b>") : strC;
    }

    public final String c(String str) {
        return g().a(str);
    }

    public final ClassifierNamePolicy d() {
        x xVar = this.d;
        return (ClassifierNamePolicy) xVar.b.getValue(xVar, x.f1080W[0]);
    }

    public final Set e() {
        x xVar = this.d;
        return (Set) xVar.e.getValue(xVar, x.f1080W[3]);
    }

    public final boolean f() {
        x xVar = this.d;
        return ((Boolean) xVar.f1096f.getValue(xVar, x.f1080W[4])).booleanValue();
    }

    public final F g() {
        x xVar = this.d;
        return (F) xVar.C.getValue(xVar, x.f1080W[27]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public final EnumC0126a getAnnotationArgumentsRenderingPolicy() {
        return this.d.getAnnotationArgumentsRenderingPolicy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public final boolean getDebugMode() {
        return this.d.getDebugMode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public final boolean getEnhancedTypes() {
        return this.d.getEnhancedTypes();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public final Set getExcludedTypeAnnotationClasses() {
        return this.d.getExcludedTypeAnnotationClasses();
    }

    public final DescriptorRenderer$ValueParametersHandler h() {
        x xVar = this.d;
        return (DescriptorRenderer$ValueParametersHandler) xVar.f1082B.getValue(xVar, x.f1080W[26]);
    }

    public final boolean i() {
        x xVar = this.d;
        return ((Boolean) xVar.f1099j.getValue(xVar, x.f1080W[8])).booleanValue();
    }

    public final String k(DeclarationDescriptor declarationDescriptor) {
        DeclarationDescriptor containingDeclaration;
        String name;
        kotlin.jvm.internal.h.f(declarationDescriptor, "declarationDescriptor");
        StringBuilder sb = new StringBuilder();
        declarationDescriptor.accept(new B.g(this, 11), sb);
        x xVar = this.d;
        v vVar = xVar.c;
        KProperty[] kPropertyArr = x.f1080W;
        if (((Boolean) vVar.getValue(xVar, kPropertyArr[1])).booleanValue() && !(declarationDescriptor instanceof PackageFragmentDescriptor) && !(declarationDescriptor instanceof PackageViewDescriptor) && (containingDeclaration = declarationDescriptor.getContainingDeclaration()) != null && !(containingDeclaration instanceof ModuleDescriptor)) {
            sb.append(" ");
            sb.append(z("defined in"));
            sb.append(" ");
            L2.e eVarG = N2.f.g(containingDeclaration);
            kotlin.jvm.internal.h.e(eVarG, "getFqName(containingDeclaration)");
            sb.append(eVarG.f961a.isEmpty() ? "root package" : c(E1.k.f0(eVarG.e())));
            if (((Boolean) xVar.d.getValue(xVar, kPropertyArr[2])).booleanValue() && (containingDeclaration instanceof PackageFragmentDescriptor) && (declarationDescriptor instanceof DeclarationDescriptorWithSource) && (name = ((DeclarationDescriptorWithSource) declarationDescriptor).getSource().getContainingFile().getName()) != null) {
                sb.append(" ");
                sb.append(z("in file"));
                sb.append(" ");
                sb.append(name);
            }
        }
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Iterable, java.util.List] */
    /* JADX WARN: Type inference failed for: r4v6, types: [kotlin.collections.u] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.util.ArrayList] */
    public final String l(AnnotationDescriptor annotation, EnumC0739c enumC0739c) {
        ClassConstructorDescriptor unsubstitutedPrimaryConstructor;
        List<ValueParameterDescriptor> valueParameters;
        kotlin.jvm.internal.h.f(annotation, "annotation");
        StringBuilder sb = new StringBuilder();
        sb.append('@');
        if (enumC0739c != null) {
            sb.append(enumC0739c.f4286a + ':');
        }
        AbstractC0162z type = annotation.getType();
        sb.append(M(type));
        x xVar = this.d;
        if (xVar.getAnnotationArgumentsRenderingPolicy().f1047a) {
            Map<L2.f, P2.g> allValueArguments = annotation.getAllValueArguments();
            ?? arrayList = 0;
            arrayList = 0;
            arrayList = 0;
            ClassDescriptor classDescriptorD = ((Boolean) xVar.H.getValue(xVar, x.f1080W[32])).booleanValue() ? R2.e.d(annotation) : null;
            if (classDescriptorD != null && (unsubstitutedPrimaryConstructor = classDescriptorD.getUnsubstitutedPrimaryConstructor()) != null && (valueParameters = unsubstitutedPrimaryConstructor.getValueParameters()) != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : valueParameters) {
                    if (((ValueParameterDescriptor) obj).declaresDefaultValue()) {
                        arrayList2.add(obj);
                    }
                }
                arrayList = new ArrayList(kotlin.collections.o.D(arrayList2));
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((ValueParameterDescriptor) it.next()).getName());
                }
            }
            if (arrayList == 0) {
                arrayList = kotlin.collections.u.f3804a;
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : arrayList) {
                L2.f it2 = (L2.f) obj2;
                kotlin.jvm.internal.h.e(it2, "it");
                if (!allValueArguments.containsKey(it2)) {
                    arrayList3.add(obj2);
                }
            }
            ArrayList arrayList4 = new ArrayList(kotlin.collections.o.D(arrayList3));
            Iterator it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                arrayList4.add(((L2.f) it3.next()).b() + " = ...");
            }
            Set<Map.Entry<L2.f, P2.g>> setEntrySet = allValueArguments.entrySet();
            ArrayList arrayList5 = new ArrayList(kotlin.collections.o.D(setEntrySet));
            Iterator it4 = setEntrySet.iterator();
            while (it4.hasNext()) {
                Map.Entry entry = (Map.Entry) it4.next();
                L2.f fVar = (L2.f) entry.getKey();
                P2.g gVar = (P2.g) entry.getValue();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(fVar.b());
                sb2.append(" = ");
                sb2.append(!arrayList.contains(fVar) ? p(gVar) : "...");
                arrayList5.add(sb2.toString());
            }
            List listJ0 = kotlin.collections.m.j0(kotlin.collections.m.b0(arrayList5, arrayList4));
            if (xVar.getAnnotationArgumentsRenderingPolicy().b || !listJ0.isEmpty()) {
                kotlin.collections.m.U(listJ0, sb, ", ", "(", ")", null, 112);
            }
        }
        if (i() && (kotlin.reflect.l.O(type) || (type.c().getDeclarationDescriptor() instanceof C0723o))) {
            sb.append(" /* annotation class not found */");
        }
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final void m(StringBuilder sb, Annotated annotated, EnumC0739c enumC0739c) {
        if (e().contains(t.ANNOTATIONS)) {
            boolean z6 = annotated instanceof AbstractC0162z;
            x xVar = this.d;
            Set excludedTypeAnnotationClasses = z6 ? xVar.getExcludedTypeAnnotationClasses() : (Set) xVar.J.getValue(xVar, x.f1080W[34]);
            Function1 function1 = (Function1) xVar.f1087L.getValue(xVar, x.f1080W[36]);
            for (AnnotationDescriptor annotationDescriptor : annotated.getAnnotations()) {
                if (!kotlin.collections.m.L(annotationDescriptor.getFqName(), excludedTypeAnnotationClasses) && !kotlin.jvm.internal.h.a(annotationDescriptor.getFqName(), k2.o.f3756r) && (function1 == null || ((Boolean) function1.invoke(annotationDescriptor)).booleanValue())) {
                    sb.append(l(annotationDescriptor, enumC0739c));
                    if (((Boolean) xVar.I.getValue(xVar, x.f1080W[33])).booleanValue()) {
                        sb.append('\n');
                    } else {
                        sb.append(" ");
                    }
                }
            }
        }
    }

    public final void o(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, StringBuilder sb) {
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        kotlin.jvm.internal.h.e(declaredTypeParameters, "classifier.declaredTypeParameters");
        List<TypeParameterDescriptor> parameters = classifierDescriptorWithTypeParameters.getTypeConstructor().getParameters();
        kotlin.jvm.internal.h.e(parameters, "classifier.typeConstructor.parameters");
        if (i() && classifierDescriptorWithTypeParameters.isInner() && parameters.size() > declaredTypeParameters.size()) {
            sb.append(" /*captured type parameters: ");
            Q(sb, parameters.subList(declaredTypeParameters.size(), parameters.size()));
            sb.append("*/");
        }
    }

    public final String p(P2.g gVar) {
        if (gVar instanceof P2.b) {
            return kotlin.collections.m.V((Iterable) ((P2.b) gVar).f1217a, ", ", "{", "}", new o(this, 1), 24);
        }
        if (gVar instanceof P2.a) {
            return kotlin.text.i.P(l((AnnotationDescriptor) ((P2.a) gVar).f1217a, null), "@");
        }
        if (!(gVar instanceof P2.r)) {
            return gVar.toString();
        }
        P2.q qVar = (P2.q) ((P2.r) gVar).f1217a;
        if (qVar instanceof P2.o) {
            return ((P2.o) qVar).f1221a + "::class";
        }
        if (!(qVar instanceof P2.p)) {
            throw new C0.x();
        }
        P2.p pVar = (P2.p) qVar;
        String strB = pVar.f1222a.f1216a.b().b();
        for (int i = 0; i < pVar.f1222a.b; i++) {
            strB = "kotlin.Array<" + strB + '>';
        }
        return B2.b.e(strB, "::class");
    }

    public final void q(StringBuilder sb, List list) {
        if (list.isEmpty()) {
            return;
        }
        sb.append("context(");
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i3 = i + 1;
            ReceiverParameterDescriptor receiverParameterDescriptor = (ReceiverParameterDescriptor) it.next();
            m(sb, receiverParameterDescriptor, EnumC0739c.RECEIVER);
            AbstractC0162z type = receiverParameterDescriptor.getType();
            kotlin.jvm.internal.h.e(type, "contextReceiver.type");
            sb.append(u(type));
            if (i == kotlin.collections.n.x(list)) {
                sb.append(") ");
            } else {
                sb.append(", ");
            }
            i = i3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(java.lang.StringBuilder r6, a3.F r7) {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: M2.s.r(java.lang.StringBuilder, a3.F):void");
    }

    public final String s(String str) {
        int iOrdinal = g().ordinal();
        if (iOrdinal == 0) {
            return str;
        }
        if (iOrdinal == 1) {
            return androidx.constraintlayout.core.motion.a.q("<font color=red><b>", str, "</b></font>");
        }
        throw new C0.x();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public final void setAnnotationArgumentsRenderingPolicy(EnumC0126a enumC0126a) {
        kotlin.jvm.internal.h.f(enumC0126a, "<set-?>");
        this.d.setAnnotationArgumentsRenderingPolicy(enumC0126a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public final void setClassifierNamePolicy(ClassifierNamePolicy classifierNamePolicy) {
        kotlin.jvm.internal.h.f(classifierNamePolicy, "<set-?>");
        this.d.setClassifierNamePolicy(classifierNamePolicy);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public final void setDebugMode(boolean z6) {
        this.d.setDebugMode(z6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public final void setExcludedTypeAnnotationClasses(Set set) {
        kotlin.jvm.internal.h.f(set, "<set-?>");
        this.d.setExcludedTypeAnnotationClasses(set);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public final void setModifiers(Set set) {
        kotlin.jvm.internal.h.f(set, "<set-?>");
        this.d.setModifiers(set);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public final void setParameterNameRenderingPolicy(B b) {
        kotlin.jvm.internal.h.f(b, "<set-?>");
        this.d.setParameterNameRenderingPolicy(b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public final void setReceiverAfterName(boolean z6) {
        this.d.setReceiverAfterName(z6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public final void setRenderCompanionObjectName(boolean z6) {
        this.d.setRenderCompanionObjectName(z6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public final void setStartFromName(boolean z6) {
        this.d.setStartFromName(z6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public final void setTextFormat(F f6) {
        kotlin.jvm.internal.h.f(f6, "<set-?>");
        this.d.setTextFormat(f6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public final void setVerbose(boolean z6) {
        this.d.setVerbose(z6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public final void setWithDefinedIn(boolean z6) {
        this.d.setWithDefinedIn(z6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public final void setWithoutSuperTypes(boolean z6) {
        this.d.setWithoutSuperTypes(z6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public final void setWithoutTypeParameters(boolean z6) {
        this.d.setWithoutTypeParameters(z6);
    }

    public final String t(String lowerRendered, String upperRendered, k2.i iVar) {
        kotlin.jvm.internal.h.f(lowerRendered, "lowerRendered");
        kotlin.jvm.internal.h.f(upperRendered, "upperRendered");
        if (E1.k.r0(lowerRendered, upperRendered)) {
            return kotlin.text.r.C(upperRendered, "(") ? androidx.constraintlayout.core.motion.a.q("(", lowerRendered, ")!") : lowerRendered.concat("!");
        }
        String strV = kotlin.text.i.V(d().renderClassifier(iVar.i(k2.o.f3725B), this), "Collection");
        String strG0 = E1.k.g0(lowerRendered, strV.concat("Mutable"), upperRendered, strV, strV.concat("(Mutable)"));
        if (strG0 != null) {
            return strG0;
        }
        String strG02 = E1.k.g0(lowerRendered, strV.concat("MutableMap.MutableEntry"), upperRendered, strV.concat("Map.Entry"), strV.concat("(Mutable)Map.(Mutable)Entry"));
        if (strG02 != null) {
            return strG02;
        }
        ClassifierNamePolicy classifierNamePolicyD = d();
        ClassDescriptor classDescriptorJ = iVar.j("Array");
        kotlin.jvm.internal.h.e(classDescriptorJ, "builtIns.array");
        String strV2 = kotlin.text.i.V(classifierNamePolicyD.renderClassifier(classDescriptorJ, this), "Array");
        String strG03 = E1.k.g0(lowerRendered, strV2.concat(c("Array<")), upperRendered, strV2.concat(c("Array<out ")), strV2.concat(c("Array<(out) ")));
        if (strG03 != null) {
            return strG03;
        }
        return "(" + lowerRendered + ".." + upperRendered + ')';
    }

    public final String u(AbstractC0162z abstractC0162z) {
        String strM = M(abstractC0162z);
        if ((!X(abstractC0162z) || a3.b0.f(abstractC0162z)) && !(abstractC0162z instanceof C0152o)) {
            return strM;
        }
        return "(" + strM + ')';
    }

    public final void v(VariableDescriptor variableDescriptor, StringBuilder sb) {
        P2.g compileTimeInitializer;
        x xVar = this.d;
        if (!((Boolean) xVar.u.getValue(xVar, x.f1080W[19])).booleanValue() || (compileTimeInitializer = variableDescriptor.getCompileTimeInitializer()) == null) {
            return;
        }
        sb.append(" = ");
        sb.append(c(p(compileTimeInitializer)));
    }

    public final String w(String str) {
        int iOrdinal = g().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                throw new C0.x();
            }
            x xVar = this.d;
            if (!((Boolean) xVar.U.getValue(xVar, x.f1080W[46])).booleanValue()) {
                return androidx.constraintlayout.core.motion.a.q("<b>", str, "</b>");
            }
        }
        return str;
    }

    public final void x(StringBuilder sb, CallableMemberDescriptor callableMemberDescriptor) {
        if (e().contains(t.MEMBER_KIND) && i() && callableMemberDescriptor.getKind() != EnumC0709a.f4226a) {
            sb.append("/*");
            sb.append(C5.f.l0(callableMemberDescriptor.getKind().name()));
            sb.append("*/ ");
        }
    }

    public final void y(MemberDescriptor memberDescriptor, StringBuilder sb) {
        C(sb, memberDescriptor.isExternal(), "external");
        boolean z6 = false;
        C(sb, e().contains(t.EXPECT) && memberDescriptor.isExpect(), "expect");
        if (e().contains(t.ACTUAL) && memberDescriptor.isActual()) {
            z6 = true;
        }
        C(sb, z6, "actual");
    }

    public final String z(String str) {
        int iOrdinal = g().ordinal();
        if (iOrdinal == 0) {
            return str;
        }
        if (iOrdinal == 1) {
            return androidx.constraintlayout.core.motion.a.q("<i>", str, "</i>");
        }
        throw new C0.x();
    }
}
