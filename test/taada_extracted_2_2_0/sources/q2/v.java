package q2;

import a3.AbstractC0162z;
import a3.Z;
import a3.d0;
import io.ktor.utils.io.b0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k2.C0588g;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitContextReceiver;
import n2.AbstractC0713e;
import n2.AbstractC0714f;
import n2.EnumC0709a;
import n2.EnumC0719k;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v extends AbstractC0778o implements FunctionDescriptor {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final FunctionDescriptor f4626A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final EnumC0709a f4627B;
    public FunctionDescriptor C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public Map f4628D;
    public List e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f4629f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AbstractC0162z f4630g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f4631h;
    public w i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ReceiverParameterDescriptor f4632j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public EnumC0719k f4633k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AbstractC0714f f4634l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f4635m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f4636n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f4637o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f4638p;
    public boolean q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f4639r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f4640s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f4641t;
    public boolean u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f4642v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f4643w;
    public boolean x;
    public Collection y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile C0588g f4644z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(L2.f fVar, DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, SourceElement sourceElement, Annotations annotations, EnumC0709a enumC0709a) {
        super(declarationDescriptor, annotations, fVar, sourceElement);
        if (declarationDescriptor == null) {
            a(0);
            throw null;
        }
        if (annotations == null) {
            a(1);
            throw null;
        }
        if (fVar == null) {
            a(2);
            throw null;
        }
        if (enumC0709a == null) {
            a(3);
            throw null;
        }
        if (sourceElement == null) {
            a(4);
            throw null;
        }
        this.f4634l = AbstractC0713e.i;
        this.f4635m = false;
        this.f4636n = false;
        this.f4637o = false;
        this.f4638p = false;
        this.q = false;
        this.f4639r = false;
        this.f4640s = false;
        this.f4641t = false;
        this.u = false;
        this.f4642v = false;
        this.f4643w = true;
        this.x = false;
        this.y = null;
        this.f4644z = null;
        this.C = null;
        this.f4628D = null;
        this.f4626A = functionDescriptor == null ? this : functionDescriptor;
        this.f4627B = enumC0709a;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i3;
        switch (i) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                i3 = 2;
                break;
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "source";
                break;
            case 5:
                objArr[0] = "contextReceiverParameters";
                break;
            case 6:
                objArr[0] = "typeParameters";
                break;
            case 7:
            case 28:
            case 30:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 8:
            case 10:
                objArr[0] = "visibility";
                break;
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 11:
                objArr[0] = "unsubstitutedReturnType";
                break;
            case 12:
                objArr[0] = "extensionReceiverParameter";
                break;
            case 17:
                objArr[0] = "overriddenDescriptors";
                break;
            case 22:
                objArr[0] = "originalSubstitutor";
                break;
            case 24:
            case 29:
            case 31:
                objArr[0] = "substitutor";
                break;
            case 25:
                objArr[0] = "configuration";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 9:
                objArr[1] = "initialize";
                break;
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 14:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 15:
                objArr[1] = "getModality";
                break;
            case 16:
                objArr[1] = "getVisibility";
                break;
            case 18:
                objArr[1] = "getTypeParameters";
                break;
            case 19:
                objArr[1] = "getValueParameters";
                break;
            case 20:
                objArr[1] = "getOriginal";
                break;
            case 21:
                objArr[1] = "getKind";
                break;
            case 23:
                objArr[1] = "newCopyBuilder";
                break;
            case 26:
                objArr[1] = "copy";
                break;
            case 27:
                objArr[1] = "getSourceToUseForCopy";
                break;
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                break;
            case 10:
                objArr[2] = "setVisibility";
                break;
            case 11:
                objArr[2] = "setReturnType";
                break;
            case 12:
                objArr[2] = "setExtensionReceiverParameter";
                break;
            case 17:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 22:
                objArr[2] = "substitute";
                break;
            case 24:
                objArr[2] = "newCopyBuilder";
                break;
            case 25:
                objArr[2] = "doSubstitute";
                break;
            case 28:
            case 29:
            case 30:
            case 31:
                objArr[2] = "getSubstitutedValueParameters";
                break;
            default:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                throw new IllegalStateException(str2);
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static ArrayList k(FunctionDescriptor functionDescriptor, List list, Z z6, boolean z7, boolean z8, boolean[] zArr) {
        if (list == null) {
            a(30);
            throw null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) it.next();
            AbstractC0162z type = valueParameterDescriptor.getType();
            d0 d0Var = d0.IN_VARIANCE;
            AbstractC0162z abstractC0162zJ = z6.j(type, d0Var);
            AbstractC0162z varargElementType = valueParameterDescriptor.getVarargElementType();
            AbstractC0162z abstractC0162zJ2 = varargElementType == null ? null : z6.j(varargElementType, d0Var);
            if (abstractC0162zJ == null) {
                return null;
            }
            if ((abstractC0162zJ != valueParameterDescriptor.getType() || varargElementType != abstractC0162zJ2) && zArr != null) {
                zArr[0] = true;
            }
            C0770g c0770g = valueParameterDescriptor instanceof Q ? new C0770g((List) ((Q) valueParameterDescriptor).f4580l.getValue(), 2) : null;
            ValueParameterDescriptor valueParameterDescriptor2 = z7 ? null : valueParameterDescriptor;
            int index = valueParameterDescriptor.getIndex();
            Annotations annotations = valueParameterDescriptor.getAnnotations();
            L2.f name = valueParameterDescriptor.getName();
            boolean zDeclaresDefaultValue = valueParameterDescriptor.declaresDefaultValue();
            boolean zIsCrossinline = valueParameterDescriptor.isCrossinline();
            boolean zIsNoinline = valueParameterDescriptor.isNoinline();
            SourceElement source = z8 ? valueParameterDescriptor.getSource() : SourceElement.NO_SOURCE;
            kotlin.jvm.internal.h.f(annotations, "annotations");
            kotlin.jvm.internal.h.f(name, "name");
            kotlin.jvm.internal.h.f(source, "source");
            arrayList.add(c0770g == null ? new S(functionDescriptor, valueParameterDescriptor2, index, annotations, name, abstractC0162zJ, zDeclaresDefaultValue, zIsCrossinline, zIsNoinline, abstractC0162zJ2, source) : new Q(functionDescriptor, valueParameterDescriptor2, index, annotations, name, abstractC0162zJ, zDeclaresDefaultValue, zIsCrossinline, zIsNoinline, abstractC0162zJ2, source, c0770g));
        }
        return arrayList;
    }

    public Object accept(DeclarationDescriptorVisitor declarationDescriptorVisitor, Object obj) {
        return declarationDescriptorVisitor.visitFunctionDescriptor(this, obj);
    }

    public final FunctionDescriptor g(DeclarationDescriptor declarationDescriptor, EnumC0719k enumC0719k, AbstractC0714f abstractC0714f, EnumC0709a enumC0709a, boolean z6) {
        FunctionDescriptor functionDescriptorBuild = newCopyBuilder().setOwner(declarationDescriptor).setModality(enumC0719k).setVisibility(abstractC0714f).setKind(enumC0709a).setCopyOverrides(z6).build();
        if (functionDescriptorBuild != null) {
            return functionDescriptorBuild;
        }
        a(26);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final List getContextReceiverParameters() {
        List list = this.f4631h;
        if (list != null) {
            return list;
        }
        a(13);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.f4632j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public final FunctionDescriptor getInitialSignatureDescriptor() {
        return this.C;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public final EnumC0709a getKind() {
        EnumC0709a enumC0709a = this.f4627B;
        if (enumC0709a != null) {
            return enumC0709a;
        }
        a(21);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final EnumC0719k getModality() {
        EnumC0719k enumC0719k = this.f4633k;
        if (enumC0719k != null) {
            return enumC0719k;
        }
        a(15);
        throw null;
    }

    @Override // q2.AbstractC0778o, q2.AbstractC0777n, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public FunctionDescriptor getOriginal() {
        FunctionDescriptor functionDescriptor = this.f4626A;
        FunctionDescriptor original = functionDescriptor == this ? this : functionDescriptor.getOriginal();
        if (original != null) {
            return original;
        }
        a(20);
        throw null;
    }

    public Collection getOverriddenDescriptors() {
        C0588g c0588g = this.f4644z;
        if (c0588g != null) {
            this.y = (Collection) c0588g.invoke();
            this.f4644z = null;
        }
        Collection collection = this.y;
        if (collection == null) {
            collection = Collections.EMPTY_LIST;
        }
        if (collection != null) {
            return collection;
        }
        a(14);
        throw null;
    }

    public AbstractC0162z getReturnType() {
        return this.f4630g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final List getTypeParameters() {
        List list = this.e;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    public Object getUserData(CallableDescriptor.UserDataKey userDataKey) {
        Map map = this.f4628D;
        if (map == null) {
            return null;
        }
        return map.get(userDataKey);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final List getValueParameters() {
        List list = this.f4629f;
        if (list != null) {
            return list;
        }
        a(19);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final AbstractC0714f getVisibility() {
        AbstractC0714f abstractC0714f = this.f4634l;
        if (abstractC0714f != null) {
            return abstractC0714f;
        }
        a(16);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public SimpleFunctionDescriptor copy(DeclarationDescriptor declarationDescriptor, EnumC0719k enumC0719k, AbstractC0714f abstractC0714f, EnumC0709a enumC0709a, boolean z6) {
        return (SimpleFunctionDescriptor) g(declarationDescriptor, enumC0719k, abstractC0714f, enumC0709a, z6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return this.x;
    }

    public abstract v i(L2.f fVar, DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, SourceElement sourceElement, Annotations annotations, EnumC0709a enumC0709a);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final boolean isActual() {
        return this.f4640s;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final boolean isExpect() {
        return this.f4639r;
    }

    public boolean isExternal() {
        return this.f4637o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public final boolean isHiddenForResolutionEverywhereBesideSupercalls() {
        return this.u;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public final boolean isHiddenToOvercomeSignatureClash() {
        return this.f4641t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public final boolean isInfix() {
        if (this.f4636n) {
            return true;
        }
        Iterator<? extends FunctionDescriptor> it = getOriginal().getOverriddenDescriptors().iterator();
        while (it.hasNext()) {
            if (it.next().isInfix()) {
                return true;
            }
        }
        return false;
    }

    public boolean isInline() {
        return this.f4638p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public final boolean isOperator() {
        if (this.f4635m) {
            return true;
        }
        Iterator<? extends FunctionDescriptor> it = getOriginal().getOverriddenDescriptors().iterator();
        while (it.hasNext()) {
            if (it.next().isOperator()) {
                return true;
            }
        }
        return false;
    }

    public boolean isSuspend() {
        return this.f4642v;
    }

    public boolean isTailrec() {
        return this.q;
    }

    public v j(C0783u c0783u) {
        char c;
        w wVar;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        AbstractC0162z abstractC0162zJ;
        boolean[] zArr = new boolean[1];
        Annotations annotationsD = c0783u.f4622s != null ? b0.d(getAnnotations(), c0783u.f4622s) : getAnnotations();
        DeclarationDescriptor declarationDescriptor = c0783u.b;
        FunctionDescriptor functionDescriptor = c0783u.e;
        EnumC0709a enumC0709a = c0783u.f4611f;
        L2.f fVar = c0783u.f4616l;
        SourceElement source = c0783u.f4619o ? (functionDescriptor != null ? functionDescriptor : getOriginal()).getSource() : SourceElement.NO_SOURCE;
        if (source == null) {
            a(27);
            throw null;
        }
        v vVarI = i(fVar, declarationDescriptor, functionDescriptor, source, annotationsD, enumC0709a);
        List typeParameters = c0783u.f4621r;
        if (typeParameters == null) {
            typeParameters = getTypeParameters();
        }
        zArr[0] = (zArr[0] ? 1 : 0) | (!typeParameters.isEmpty() ? 1 : 0);
        ArrayList arrayList = new ArrayList(typeParameters.size());
        Z zM0 = E1.k.m0(typeParameters, c0783u.f4610a, vVarI, arrayList, zArr);
        if (zM0 != null) {
            ArrayList arrayList2 = new ArrayList();
            boolean zIsEmpty = c0783u.f4613h.isEmpty();
            d0 d0Var = d0.IN_VARIANCE;
            if (!zIsEmpty) {
                int i = 0;
                for (ReceiverParameterDescriptor receiverParameterDescriptor2 : c0783u.f4613h) {
                    AbstractC0162z abstractC0162zJ2 = zM0.j(receiverParameterDescriptor2.getType(), d0Var);
                    if (abstractC0162zJ2 != null) {
                        int i3 = i + 1;
                        arrayList2.add(N2.q.e(vVarI, abstractC0162zJ2, ((ImplicitContextReceiver) receiverParameterDescriptor2.getValue()).getCustomLabelName(), receiverParameterDescriptor2.getAnnotations(), i));
                        zArr[0] = (zArr[0] ? 1 : 0) | (abstractC0162zJ2 != receiverParameterDescriptor2.getType() ? (char) 1 : (char) 0);
                        i = i3;
                    }
                }
            }
            ReceiverParameterDescriptor receiverParameterDescriptor3 = c0783u.i;
            if (receiverParameterDescriptor3 != null) {
                AbstractC0162z abstractC0162zJ3 = zM0.j(receiverParameterDescriptor3.getType(), d0Var);
                if (abstractC0162zJ3 == null) {
                    return null;
                }
                w wVar2 = new w(vVarI, new V2.c(vVarI, abstractC0162zJ3, c0783u.i.getValue()), c0783u.i.getAnnotations());
                zArr[0] = (abstractC0162zJ3 != c0783u.i.getType() ? (char) 1 : (char) 0) | (zArr[0] ? 1 : 0);
                c = 0;
                wVar = wVar2;
            } else {
                c = 0;
                wVar = null;
            }
            ReceiverParameterDescriptor receiverParameterDescriptor4 = c0783u.f4614j;
            if (receiverParameterDescriptor4 != null) {
                ReceiverParameterDescriptor receiverParameterDescriptorSubstitute = receiverParameterDescriptor4.substitute(zM0);
                if (receiverParameterDescriptorSubstitute == null) {
                    return null;
                }
                zArr[c] = (zArr[c] ? 1 : 0) | (receiverParameterDescriptorSubstitute != c0783u.f4614j ? (char) 1 : c);
                receiverParameterDescriptor = receiverParameterDescriptorSubstitute;
            } else {
                receiverParameterDescriptor = null;
            }
            ArrayList arrayListK = k(vVarI, c0783u.f4612g, zM0, c0783u.f4620p, c0783u.f4619o, zArr);
            if (arrayListK == null || (abstractC0162zJ = zM0.j(c0783u.f4615k, d0.OUT_VARIANCE)) == null) {
                return null;
            }
            boolean z6 = (zArr[c] ? 1 : 0) | (abstractC0162zJ != c0783u.f4615k ? (char) 1 : c);
            zArr[c] = z6;
            if (z6 == 0 && c0783u.f4625w) {
                return this;
            }
            vVarI.l(wVar, receiverParameterDescriptor, arrayList2, arrayList, arrayListK, abstractC0162zJ, c0783u.c, c0783u.d);
            vVarI.f4635m = this.f4635m;
            vVarI.f4636n = this.f4636n;
            vVarI.f4637o = this.f4637o;
            vVarI.f4638p = this.f4638p;
            vVarI.q = this.q;
            vVarI.f4642v = this.f4642v;
            vVarI.f4639r = this.f4639r;
            vVarI.f4640s = this.f4640s;
            vVarI.o(this.f4643w);
            vVarI.f4641t = c0783u.q;
            vVarI.u = c0783u.f4623t;
            Boolean bool = c0783u.f4624v;
            vVarI.p(bool != null ? bool.booleanValue() : this.x);
            if (!c0783u.u.isEmpty() || this.f4628D != null) {
                LinkedHashMap linkedHashMap = c0783u.u;
                Map map = this.f4628D;
                if (map != null) {
                    for (Map.Entry entry : map.entrySet()) {
                        if (!linkedHashMap.containsKey(entry.getKey())) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (linkedHashMap.size() == 1) {
                    vVarI.f4628D = Collections.singletonMap(linkedHashMap.keySet().iterator().next(), linkedHashMap.values().iterator().next());
                } else {
                    vVarI.f4628D = linkedHashMap;
                }
            }
            if (c0783u.f4618n || this.C != null) {
                FunctionDescriptor functionDescriptor2 = this.C;
                if (functionDescriptor2 == null) {
                    functionDescriptor2 = this;
                }
                vVarI.C = functionDescriptor2.substitute(zM0);
            }
            if (c0783u.f4617m && !getOriginal().getOverriddenDescriptors().isEmpty()) {
                if (c0783u.f4610a.e()) {
                    C0588g c0588g = this.f4644z;
                    if (c0588g != null) {
                        vVarI.f4644z = c0588g;
                        return vVarI;
                    }
                    vVarI.setOverriddenDescriptors(getOverriddenDescriptors());
                    return vVarI;
                }
                vVarI.f4644z = new C0588g(2, this, zM0);
            }
            return vVarI;
        }
        return null;
    }

    public void l(w wVar, ReceiverParameterDescriptor receiverParameterDescriptor, List list, List list2, List list3, AbstractC0162z abstractC0162z, EnumC0719k enumC0719k, AbstractC0714f abstractC0714f) {
        if (list == null) {
            a(5);
            throw null;
        }
        if (list2 == null) {
            a(6);
            throw null;
        }
        if (list3 == null) {
            a(7);
            throw null;
        }
        if (abstractC0714f == null) {
            a(8);
            throw null;
        }
        this.e = kotlin.collections.m.o0(list2);
        this.f4629f = kotlin.collections.m.o0(list3);
        this.f4630g = abstractC0162z;
        this.f4633k = enumC0719k;
        this.f4634l = abstractC0714f;
        this.i = wVar;
        this.f4632j = receiverParameterDescriptor;
        this.f4631h = list;
        for (int i = 0; i < list2.size(); i++) {
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) list2.get(i);
            if (typeParameterDescriptor.getIndex() != i) {
                throw new IllegalStateException(typeParameterDescriptor + " index is " + typeParameterDescriptor.getIndex() + " but position is " + i);
            }
        }
        for (int i3 = 0; i3 < list3.size(); i3++) {
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) list3.get(i3);
            if (valueParameterDescriptor.getIndex() != i3) {
                throw new IllegalStateException(valueParameterDescriptor + "index is " + valueParameterDescriptor.getIndex() + " but position is " + i3);
            }
        }
    }

    public final C0783u m(Z z6) {
        if (z6 != null) {
            return new C0783u(this, z6.g(), getContainingDeclaration(), getModality(), getVisibility(), getKind(), getValueParameters(), getContextReceiverParameters(), this.i, getReturnType());
        }
        a(24);
        throw null;
    }

    public final void n(CallableDescriptor.UserDataKey userDataKey, Object obj) {
        if (this.f4628D == null) {
            this.f4628D = new LinkedHashMap();
        }
        this.f4628D.put(userDataKey, obj);
    }

    public FunctionDescriptor.CopyBuilder newCopyBuilder() {
        return m(Z.b);
    }

    public void o(boolean z6) {
        this.f4643w = z6;
    }

    public void p(boolean z6) {
        this.x = z6;
    }

    public final void q(a3.F f6) {
        if (f6 != null) {
            this.f4630g = f6;
        } else {
            a(11);
            throw null;
        }
    }

    public void setOverriddenDescriptors(Collection collection) {
        if (collection == null) {
            a(17);
            throw null;
        }
        this.y = collection;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((FunctionDescriptor) it.next()).isHiddenForResolutionEverywhereBesideSupercalls()) {
                this.u = true;
                return;
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public FunctionDescriptor substitute(Z z6) {
        if (z6 == null) {
            a(22);
            throw null;
        }
        if (z6.f1542a.e()) {
            return this;
        }
        C0783u c0783uM = m(z6);
        c0783uM.e = getOriginal();
        c0783uM.f4619o = true;
        c0783uM.f4625w = true;
        return c0783uM.x.j(c0783uM);
    }
}
