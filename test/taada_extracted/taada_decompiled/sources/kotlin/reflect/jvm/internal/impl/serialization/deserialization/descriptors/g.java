package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import A2.C0027i;
import A2.C0031m;
import G2.B;
import G2.C0111k;
import G2.EnumC0110j;
import G2.U;
import G2.b0;
import G2.j0;
import G2.k0;
import X2.s;
import a3.AbstractC0162z;
import a3.F;
import c4.AbstractC0246d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeserializedDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import n2.AbstractC0714f;
import n2.C0712d;
import n2.EnumC0711c;
import n2.EnumC0719k;
import n2.t;
import n2.v;
import n2.z;
import q2.AbstractC0765b;
import q2.w;
import v2.EnumC0851b;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends AbstractC0765b implements DeserializedDescriptor {
    public final C0111k e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final I2.a f3894f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SourceElement f3895g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final L2.b f3896h;
    public final EnumC0719k i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final C0712d f3897j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final EnumC0711c f3898k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final X2.i f3899l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final U2.n f3900m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final C0027i f3901n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final t f3902o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final C0.t f3903p;
    public final DeclarationDescriptor q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final NullableLazyValue f3904r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final NotNullLazyValue f3905s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final NullableLazyValue f3906t;
    public final NotNullLazyValue u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final NullableLazyValue f3907v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final X2.p f3908w;
    public final Annotations x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public g(X2.i outerContext, C0111k classProto, NameResolver nameResolver, I2.a aVar, SourceElement sourceElement) {
        EnumC0711c enumC0711c;
        Annotations rVar;
        super(outerContext.f1433a.f1418a, kotlin.reflect.l.w(nameResolver, classProto.e).i());
        int i = 6;
        int i3 = 1;
        kotlin.jvm.internal.h.f(outerContext, "outerContext");
        kotlin.jvm.internal.h.f(classProto, "classProto");
        kotlin.jvm.internal.h.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.h.f(sourceElement, "sourceElement");
        this.e = classProto;
        this.f3894f = aVar;
        this.f3895g = sourceElement;
        this.f3896h = kotlin.reflect.l.w(nameResolver, classProto.e);
        this.i = X2.h.b((B) I2.e.e.c(classProto.d));
        this.f3897j = C5.f.s((k0) I2.e.d.c(classProto.d));
        EnumC0110j enumC0110j = (EnumC0110j) I2.e.f774f.c(classProto.d);
        int i4 = enumC0110j == null ? -1 : s.b[enumC0110j.ordinal()];
        EnumC0711c enumC0711c2 = EnumC0711c.f4228a;
        EnumC0711c enumC0711c3 = EnumC0711c.c;
        switch (i4) {
            case 2:
                enumC0711c2 = EnumC0711c.b;
                enumC0711c = enumC0711c2;
                break;
            case 3:
                enumC0711c = enumC0711c3;
                break;
            case 4:
                enumC0711c2 = EnumC0711c.d;
                enumC0711c = enumC0711c2;
                break;
            case 5:
                enumC0711c2 = EnumC0711c.e;
                enumC0711c = enumC0711c2;
                break;
            case 6:
            case 7:
                enumC0711c2 = EnumC0711c.f4229f;
                enumC0711c = enumC0711c2;
                break;
            default:
                enumC0711c = enumC0711c2;
                break;
        }
        this.f3898k = enumC0711c;
        List list = classProto.f629g;
        kotlin.jvm.internal.h.e(list, "classProto.typeParameterList");
        b0 b0Var = classProto.E;
        kotlin.jvm.internal.h.e(b0Var, "classProto.typeTable");
        I2.f fVar = new I2.f(b0Var);
        I2.g gVar = I2.g.b;
        j0 j0Var = classProto.f627G;
        kotlin.jvm.internal.h.e(j0Var, "classProto.versionRequirementTable");
        X2.i iVarA = outerContext.a(this, list, nameResolver, fVar, C5.f.q(j0Var), aVar);
        this.f3899l = iVarA;
        X2.g gVar2 = iVarA.f1433a;
        this.f3900m = enumC0711c == enumC0711c3 ? new U2.p(gVar2.f1418a, this) : U2.m.f1338a;
        this.f3901n = new C0027i(this);
        v vVar = t.e;
        StorageManager storageManager = gVar2.f1418a;
        b3.d kotlinTypeRefinerForOwnerModule = gVar2.q.getKotlinTypeRefiner();
        C0031m c0031m = new C0031m(i3, i, this);
        vVar.getClass();
        kotlin.jvm.internal.h.f(storageManager, "storageManager");
        kotlin.jvm.internal.h.f(kotlinTypeRefinerForOwnerModule, "kotlinTypeRefinerForOwnerModule");
        this.f3902o = new t(this, storageManager, c0031m, kotlinTypeRefinerForOwnerModule);
        this.f3903p = enumC0711c == enumC0711c3 ? new C0.t(this) : null;
        DeclarationDescriptor declarationDescriptor = outerContext.c;
        this.q = declarationDescriptor;
        f fVar2 = new f(this, 4);
        StorageManager storageManager2 = gVar2.f1418a;
        this.f3904r = storageManager2.createNullableLazyValue(fVar2);
        this.f3905s = storageManager2.createLazyValue(new f(this, 3));
        this.f3906t = storageManager2.createNullableLazyValue(new f(this, 2));
        this.u = storageManager2.createLazyValue(new f(this, 5));
        this.f3907v = storageManager2.createNullableLazyValue(new f(this, i));
        g gVar3 = declarationDescriptor instanceof g ? (g) declarationDescriptor : null;
        this.f3908w = new X2.p(classProto, iVarA.b, iVarA.d, sourceElement, gVar3 != null ? gVar3.f3908w : null);
        if (I2.e.c.c(classProto.d).booleanValue()) {
            rVar = new r(storageManager2, new f(this, i3));
        } else {
            Annotations.Companion.getClass();
            rVar = o2.f.b;
        }
        this.x = rVar;
    }

    @Override // q2.AbstractC0762A
    public final MemberScope b(b3.d dVar) {
        t tVar = this.f3902o;
        tVar.getClass();
        R2.e.j(tVar.f4258a);
        return (MemberScope) AbstractC0246d.T(tVar.d, t.f4257f[0]);
    }

    public final e e() {
        b3.d kotlinTypeRefiner = this.f3899l.f1433a.q.getKotlinTypeRefiner();
        t tVar = this.f3902o;
        tVar.getClass();
        kotlin.jvm.internal.h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        R2.e.j(tVar.f4258a);
        return (e) ((MemberScope) AbstractC0246d.T(tVar.d, t.f4257f[0]));
    }

    public final F f(L2.f fVar) {
        Iterator it = e().getContributedVariables(fVar, EnumC0851b.f4935g).iterator();
        boolean z6 = false;
        Object obj = null;
        while (true) {
            if (!it.hasNext()) {
                if (!z6) {
                    break;
                }
            } else {
                Object next = it.next();
                if (((PropertyDescriptor) next).getExtensionReceiverParameter() == null) {
                    if (z6) {
                        break;
                    }
                    z6 = true;
                    obj = next;
                }
            }
        }
        obj = null;
        PropertyDescriptor propertyDescriptor = (PropertyDescriptor) obj;
        return (F) (propertyDescriptor != null ? propertyDescriptor.getType() : null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public final Annotations getAnnotations() {
        return this.x;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final ClassDescriptor getCompanionObjectDescriptor() {
        return (ClassDescriptor) this.f3906t.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final Collection getConstructors() {
        return (Collection) this.f3905s.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final DeclarationDescriptor getContainingDeclaration() {
        return this.q;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Iterable] */
    @Override // q2.AbstractC0765b, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final List getContextReceivers() {
        X2.i iVar = this.f3899l;
        I2.f fVar = iVar.d;
        C0111k c0111k = this.e;
        kotlin.jvm.internal.h.f(c0111k, "<this>");
        List list = c0111k.f634m;
        boolean zIsEmpty = list.isEmpty();
        ?? arrayList = list;
        if (zIsEmpty) {
            arrayList = 0;
        }
        if (arrayList == 0) {
            List<Integer> contextReceiverTypeIdList = c0111k.f635n;
            kotlin.jvm.internal.h.e(contextReceiverTypeIdList, "contextReceiverTypeIdList");
            arrayList = new ArrayList(kotlin.collections.o.D(contextReceiverTypeIdList));
            for (Integer it : contextReceiverTypeIdList) {
                kotlin.jvm.internal.h.e(it, "it");
                arrayList.add(fVar.a(it.intValue()));
            }
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.o.D(arrayList));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            AbstractC0162z abstractC0162zF = iVar.f1436h.f((U) it2.next());
            ReceiverParameterDescriptor thisAsReceiverParameter = getThisAsReceiverParameter();
            V2.b bVar = new V2.b(this, abstractC0162zF, null);
            Annotations.Companion.getClass();
            arrayList2.add(new w(thisAsReceiverParameter, bVar, o2.f.b));
        }
        return arrayList2;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.Map] */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public final List getDeclaredTypeParameters() {
        return kotlin.collections.m.o0(this.f3899l.f1436h.f1457g.values());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final EnumC0711c getKind() {
        return this.f3898k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final EnumC0719k getModality() {
        return this.i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final Collection getSealedSubclasses() {
        return (Collection) this.u.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public final SourceElement getSource() {
        return this.f3895g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final MemberScope getStaticScope() {
        return this.f3900m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public final TypeConstructor getTypeConstructor() {
        return this.f3901n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return (ClassConstructorDescriptor) this.f3904r.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final z getValueClassRepresentation() {
        return (z) this.f3907v.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final AbstractC0714f getVisibility() {
        return this.f3897j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final boolean isCompanionObject() {
        return I2.e.f774f.c(this.e.d) == EnumC0110j.COMPANION_OBJECT;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final boolean isData() {
        return I2.e.f776h.c(this.e.d).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final boolean isExpect() {
        return I2.e.f777j.c(this.e.d).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final boolean isExternal() {
        return I2.e.i.c(this.e.d).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final boolean isFun() {
        return I2.e.f779l.c(this.e.d).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final boolean isInline() {
        if (!I2.e.f778k.c(this.e.d).booleanValue()) {
            return false;
        }
        I2.a aVar = this.f3894f;
        int i = aVar.b;
        if (i >= 1) {
            if (i > 1) {
                return false;
            }
            int i3 = aVar.c;
            if (i3 >= 4 && (i3 > 4 || aVar.d > 1)) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public final boolean isInner() {
        return I2.e.f775g.c(this.e.d).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final boolean isValue() {
        return I2.e.f778k.c(this.e.d).booleanValue() && this.f3894f.a(1, 4, 2);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("deserialized ");
        sb.append(isExpect() ? "expect " : "");
        sb.append("class ");
        sb.append(getName());
        return sb.toString();
    }
}
