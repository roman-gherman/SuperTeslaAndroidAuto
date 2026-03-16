package q2;

import a3.AbstractC0162z;
import a3.W;
import a3.Z;
import a3.d0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitContextReceiver;
import n2.AbstractC0713e;
import n2.AbstractC0714f;
import n2.C0712d;
import n2.EnumC0709a;
import n2.EnumC0719k;

/* JADX INFO: loaded from: classes2.dex */
public final class H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DeclarationDescriptor f4552a;
    public EnumC0719k b;
    public AbstractC0714f c;
    public EnumC0709a e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ReceiverParameterDescriptor f4555h;
    public final L2.f i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AbstractC0162z f4556j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ I f4557k;
    public PropertyDescriptor d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public W f4553f = W.f1541a;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4554g = true;

    public H(I i) {
        this.f4557k = i;
        this.f4552a = i.getContainingDeclaration();
        this.b = i.getModality();
        this.c = i.getVisibility();
        this.e = i.getKind();
        this.f4555h = i.f4567t;
        this.i = i.getName();
        this.f4556j = i.getType();
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 1 || i == 2 || i == 3 || i == 5 || i == 7 || i == 9 || i == 11 || i == 19 || i == 13 || i == 14 || i == 16 || i == 17) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 5 || i == 7 || i == 9 || i == 11 || i == 19 || i == 13 || i == 14 || i == 16 || i == 17) ? 2 : 3];
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 7:
            case 9:
            case 11:
            case 13:
            case 14:
            case 16:
            case 17:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                break;
            case 4:
                objArr[0] = "type";
                break;
            case 6:
                objArr[0] = "modality";
                break;
            case 8:
                objArr[0] = "visibility";
                break;
            case 10:
                objArr[0] = "kind";
                break;
            case 12:
                objArr[0] = "typeParameters";
                break;
            case 15:
                objArr[0] = "substitution";
                break;
            case 18:
                objArr[0] = "name";
                break;
            default:
                objArr[0] = "owner";
                break;
        }
        if (i == 1) {
            objArr[1] = "setOwner";
        } else if (i == 2) {
            objArr[1] = "setOriginal";
        } else if (i == 3) {
            objArr[1] = "setPreserveSourceElement";
        } else if (i == 5) {
            objArr[1] = "setReturnType";
        } else if (i == 7) {
            objArr[1] = "setModality";
        } else if (i == 9) {
            objArr[1] = "setVisibility";
        } else if (i == 11) {
            objArr[1] = "setKind";
        } else if (i == 19) {
            objArr[1] = "setName";
        } else if (i == 13) {
            objArr[1] = "setTypeParameters";
        } else if (i == 14) {
            objArr[1] = "setDispatchReceiverParameter";
        } else if (i == 16) {
            objArr[1] = "setSubstitution";
        } else if (i != 17) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
        } else {
            objArr[1] = "setCopyOverrides";
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 7:
            case 9:
            case 11:
            case 13:
            case 14:
            case 16:
            case 17:
            case 19:
                break;
            case 4:
                objArr[2] = "setReturnType";
                break;
            case 6:
                objArr[2] = "setModality";
                break;
            case 8:
                objArr[2] = "setVisibility";
                break;
            case 10:
                objArr[2] = "setKind";
                break;
            case 12:
                objArr[2] = "setTypeParameters";
                break;
            case 15:
                objArr[2] = "setSubstitution";
                break;
            case 18:
                objArr[2] = "setName";
                break;
            default:
                objArr[2] = "setOwner";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2 && i != 3 && i != 5 && i != 7 && i != 9 && i != 11 && i != 19 && i != 13 && i != 14 && i != 16 && i != 17) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor, q2.I, q2.U] */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5, types: [kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, q2.G, q2.K] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1, types: [kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor] */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r19v3 */
    /* JADX WARN: Type inference failed for: r19v4, types: [kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor] */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARN: Type inference failed for: r21v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v9, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.i] */
    /* JADX WARN: Type inference failed for: r3v14, types: [q2.t] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21, types: [a3.z] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v16, types: [q2.G, q2.J] */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14, types: [kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor] */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16, types: [kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor] */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r9v3, types: [q2.t] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v7 */
    public final I b() {
        ReceiverParameterDescriptor receiverParameterDescriptor;
        w wVar;
        ?? j6;
        ?? k6;
        Z z6;
        ?? r22;
        w wVar2;
        w wVar3;
        Iterator it;
        AbstractC0162z abstractC0162z;
        I i = this.f4557k;
        i.getClass();
        DeclarationDescriptor declarationDescriptor = this.f4552a;
        EnumC0719k enumC0719k = this.b;
        AbstractC0714f abstractC0714f = this.c;
        PropertyDescriptor propertyDescriptor = this.d;
        EnumC0709a enumC0709a = this.e;
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        w wVar4 = null;
        if (sourceElement == null) {
            I.a(28);
            throw null;
        }
        ?? J = i.j(declarationDescriptor, enumC0719k, abstractC0714f, propertyDescriptor, enumC0709a, this.i, sourceElement);
        List typeParameters = i.getTypeParameters();
        ArrayList arrayList = new ArrayList(((ArrayList) typeParameters).size());
        Z zL0 = E1.k.l0(typeParameters, this.f4553f, J, arrayList);
        d0 d0Var = d0.OUT_VARIANCE;
        AbstractC0162z abstractC0162z2 = this.f4556j;
        AbstractC0162z abstractC0162zJ = zL0.j(abstractC0162z2, d0Var);
        if (abstractC0162zJ != null) {
            d0 d0Var2 = d0.IN_VARIANCE;
            AbstractC0162z abstractC0162zJ2 = zL0.j(abstractC0162z2, d0Var2);
            if (abstractC0162zJ2 != null) {
                J.l(abstractC0162zJ2);
            }
            ReceiverParameterDescriptor receiverParameterDescriptor2 = this.f4555h;
            if (receiverParameterDescriptor2 != null) {
                ReceiverParameterDescriptor receiverParameterDescriptorSubstitute = receiverParameterDescriptor2.substitute(zL0);
                if (receiverParameterDescriptorSubstitute != null) {
                    receiverParameterDescriptor = receiverParameterDescriptorSubstitute;
                }
            } else {
                receiverParameterDescriptor = null;
            }
            w wVar5 = i.u;
            if (wVar5 != null) {
                AbstractC0162z abstractC0162zJ3 = zL0.j(wVar5.getType(), d0Var2);
                wVar = abstractC0162zJ3 == null ? null : new w(J, new V2.c(J, abstractC0162zJ3, wVar5.getValue()), wVar5.getAnnotations());
            } else {
                wVar = null;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = i.f4566s.iterator();
            while (it2.hasNext()) {
                ReceiverParameterDescriptor receiverParameterDescriptor3 = (ReceiverParameterDescriptor) it2.next();
                AbstractC0162z abstractC0162zJ4 = zL0.j(receiverParameterDescriptor3.getType(), d0Var2);
                if (abstractC0162zJ4 == null) {
                    it = it2;
                    abstractC0162z = abstractC0162zJ;
                    wVar2 = wVar4;
                    wVar3 = wVar2;
                } else {
                    wVar3 = wVar4;
                    it = it2;
                    abstractC0162z = abstractC0162zJ;
                    wVar2 = new w(J, new V2.b(J, abstractC0162zJ4, ((ImplicitContextReceiver) receiverParameterDescriptor3.getValue()).getCustomLabelName(), receiverParameterDescriptor3.getValue()), receiverParameterDescriptor3.getAnnotations());
                }
                if (wVar2 != null) {
                    arrayList2.add(wVar2);
                }
                abstractC0162zJ = abstractC0162z;
                it2 = it;
                wVar4 = wVar3;
            }
            ?? r21 = wVar4;
            J.m(abstractC0162zJ, arrayList, receiverParameterDescriptor, wVar, arrayList2);
            J j7 = i.f4569w;
            EnumC0709a enumC0709a2 = EnumC0709a.b;
            if (j7 == null) {
                j6 = r21;
            } else {
                Annotations annotations = j7.getAnnotations();
                EnumC0719k enumC0719k2 = this.b;
                AbstractC0714f visibility = i.f4569w.getVisibility();
                if (this.e == enumC0709a2 && AbstractC0713e.e(AbstractC0713e.g(((C0712d) visibility).f4232a.c()))) {
                    visibility = AbstractC0713e.f4236h;
                }
                AbstractC0714f abstractC0714f2 = visibility;
                J j8 = i.f4569w;
                boolean z7 = j8.e;
                EnumC0709a enumC0709a3 = this.e;
                PropertyDescriptor propertyDescriptor2 = this.d;
                j6 = new J(J, annotations, enumC0719k2, abstractC0714f2, z7, j8.f4546f, j8.i, enumC0709a3, propertyDescriptor2 == null ? r21 : propertyDescriptor2.getGetter(), SourceElement.NO_SOURCE);
            }
            if (j6 != 0) {
                J j9 = i.f4569w;
                AbstractC0162z abstractC0162z3 = j9.f4571m;
                j6.f4551l = j9.getInitialSignatureDescriptor() != null ? j9.getInitialSignatureDescriptor().substitute(zL0) : r21;
                j6.i(abstractC0162z3 != null ? zL0.j(abstractC0162z3, d0Var) : r21);
            }
            K k7 = i.x;
            if (k7 == null) {
                k6 = r21;
            } else {
                Annotations annotations2 = k7.getAnnotations();
                EnumC0719k enumC0719k3 = this.b;
                AbstractC0714f visibility2 = i.x.getVisibility();
                if (this.e == enumC0709a2 && AbstractC0713e.e(AbstractC0713e.g(((C0712d) visibility2).f4232a.c()))) {
                    visibility2 = AbstractC0713e.f4236h;
                }
                AbstractC0714f abstractC0714f3 = visibility2;
                K k8 = i.x;
                boolean z8 = k8.e;
                boolean z9 = k8.f4546f;
                boolean z10 = k8.i;
                EnumC0709a enumC0709a4 = this.e;
                PropertyDescriptor propertyDescriptor3 = this.d;
                k6 = new K(J, annotations2, enumC0719k3, abstractC0714f3, z8, z9, z10, enumC0709a4, propertyDescriptor3 == null ? r21 : propertyDescriptor3.getSetter(), SourceElement.NO_SOURCE);
            }
            if (k6 != 0) {
                z6 = zL0;
                List listK = v.k(k6, i.x.getValueParameters(), z6, false, false, null);
                if (listK == null) {
                    listK = Collections.singletonList(K.h(k6, R2.e.e(this.f4552a).m(), ((ValueParameterDescriptor) i.x.getValueParameters().get(0)).getAnnotations()));
                }
                if (listK.size() != 1) {
                    throw new IllegalStateException();
                }
                K k9 = i.x;
                if (k9 == null) {
                    I.a(31);
                    throw r21;
                }
                k6.f4551l = k9.getInitialSignatureDescriptor() != null ? k9.getInitialSignatureDescriptor().substitute(z6) : r21;
                ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) listK.get(0);
                if (valueParameterDescriptor == null) {
                    K.a(6);
                    throw r21;
                }
                k6.f4573m = valueParameterDescriptor;
            } else {
                z6 = zL0;
            }
            C0782t c0782t = i.y;
            ?? c0782t2 = c0782t == null ? r21 : new C0782t(c0782t.getAnnotations(), J);
            C0782t c0782t3 = i.f4570z;
            J.k(j6, k6, c0782t2, c0782t3 == null ? r21 : new C0782t(c0782t3.getAnnotations(), J));
            if (this.f4554g) {
                j3.m mVar = new j3.m();
                Iterator it3 = i.getOverriddenDescriptors().iterator();
                while (it3.hasNext()) {
                    mVar.add(((PropertyDescriptor) it3.next()).substitute(z6));
                }
                J.f4559k = mVar;
            }
            if (i.isConst() && (r22 = i.f4588h) != 0) {
                J.g(i.f4587g, r22);
            }
            return J;
        }
        return null;
    }
}
