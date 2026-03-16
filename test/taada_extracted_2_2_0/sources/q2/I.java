package q2;

import a3.AbstractC0162z;
import a3.W;
import a3.Z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import n2.AbstractC0714f;
import n2.C0712d;
import n2.EnumC0709a;
import n2.EnumC0719k;

/* JADX INFO: loaded from: classes2.dex */
public class I extends U implements PropertyDescriptor {
    public final EnumC0719k i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AbstractC0714f f4558j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Collection f4559k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PropertyDescriptor f4560l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final EnumC0709a f4561m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f4562n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f4563o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f4564p;
    public final boolean q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f4565r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List f4566s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ReceiverParameterDescriptor f4567t;
    public w u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ArrayList f4568v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public J f4569w;
    public K x;
    public C0782t y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public C0782t f4570z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I(DeclarationDescriptor declarationDescriptor, PropertyDescriptor propertyDescriptor, Annotations annotations, EnumC0719k enumC0719k, AbstractC0714f abstractC0714f, boolean z6, L2.f fVar, EnumC0709a enumC0709a, SourceElement sourceElement, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11) {
        super(declarationDescriptor, annotations, fVar, z6, sourceElement);
        if (declarationDescriptor == null) {
            a(0);
            throw null;
        }
        if (annotations == null) {
            a(1);
            throw null;
        }
        if (enumC0719k == null) {
            a(2);
            throw null;
        }
        if (abstractC0714f == null) {
            a(3);
            throw null;
        }
        if (fVar == null) {
            a(4);
            throw null;
        }
        if (enumC0709a == null) {
            a(5);
            throw null;
        }
        if (sourceElement == null) {
            a(6);
            throw null;
        }
        this.f4559k = null;
        this.f4566s = Collections.EMPTY_LIST;
        this.i = enumC0719k;
        this.f4558j = abstractC0714f;
        this.f4560l = propertyDescriptor == null ? this : propertyDescriptor;
        this.f4561m = enumC0709a;
        this.f4562n = z7;
        this.f4563o = z8;
        this.f4564p = z9;
        this.q = z10;
        this.f4565r = z11;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r11) {
        /*
            Method dump skipped, instruction units count: 538
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q2.I.a(int):void");
    }

    public static I i(ClassDescriptor classDescriptor, EnumC0719k enumC0719k, C0712d c0712d, boolean z6, L2.f fVar, EnumC0709a enumC0709a, SourceElement sourceElement) {
        o2.e eVar = o2.f.b;
        if (classDescriptor == null) {
            a(7);
            throw null;
        }
        if (c0712d == null) {
            a(10);
            throw null;
        }
        if (fVar == null) {
            a(11);
            throw null;
        }
        if (sourceElement != null) {
            return new I(classDescriptor, null, eVar, enumC0719k, c0712d, z6, fVar, enumC0709a, sourceElement, false, false, false, false, false);
        }
        a(13);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final Object accept(DeclarationDescriptorVisitor declarationDescriptorVisitor, Object obj) {
        return declarationDescriptorVisitor.visitPropertyDescriptor(this, obj);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public final List getAccessors() {
        ArrayList arrayList = new ArrayList(2);
        J j6 = this.f4569w;
        if (j6 != null) {
            arrayList.add(j6);
        }
        K k6 = this.x;
        if (k6 != null) {
            arrayList.add(k6);
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public final FieldDescriptor getBackingField() {
        return this.y;
    }

    @Override // q2.T, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final List getContextReceiverParameters() {
        List list = this.f4566s;
        if (list != null) {
            return list;
        }
        a(22);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public final FieldDescriptor getDelegateField() {
        return this.f4570z;
    }

    @Override // q2.T, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.f4567t;
    }

    @Override // q2.T, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.u;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public final PropertyGetterDescriptor getGetter() {
        return this.f4569w;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public final EnumC0709a getKind() {
        EnumC0709a enumC0709a = this.f4561m;
        if (enumC0709a != null) {
            return enumC0709a;
        }
        a(39);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final EnumC0719k getModality() {
        EnumC0719k enumC0719k = this.i;
        if (enumC0719k != null) {
            return enumC0719k;
        }
        a(24);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final Collection getOverriddenDescriptors() {
        Collection collection = this.f4559k;
        if (collection == null) {
            collection = Collections.EMPTY_LIST;
        }
        if (collection != null) {
            return collection;
        }
        a(41);
        throw null;
    }

    @Override // q2.T, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final AbstractC0162z getReturnType() {
        AbstractC0162z type = getType();
        if (type != null) {
            return type;
        }
        a(23);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public final PropertySetterDescriptor getSetter() {
        return this.x;
    }

    @Override // q2.T, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final List getTypeParameters() {
        ArrayList arrayList = this.f4568v;
        if (arrayList != null) {
            return arrayList;
        }
        throw new IllegalStateException("typeParameters == null for ".concat(AbstractC0777n.e(this)));
    }

    @Override // q2.T, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public Object getUserData(CallableDescriptor.UserDataKey userDataKey) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final AbstractC0714f getVisibility() {
        AbstractC0714f abstractC0714f = this.f4558j;
        if (abstractC0714f != null) {
            return abstractC0714f;
        }
        a(25);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final I copy(DeclarationDescriptor declarationDescriptor, EnumC0719k enumC0719k, AbstractC0714f abstractC0714f, EnumC0709a enumC0709a, boolean z6) {
        H h3 = new H(this);
        if (declarationDescriptor == null) {
            H.a(0);
            throw null;
        }
        h3.f4552a = declarationDescriptor;
        h3.d = null;
        if (enumC0719k == null) {
            H.a(6);
            throw null;
        }
        h3.b = enumC0719k;
        if (abstractC0714f == null) {
            H.a(8);
            throw null;
        }
        h3.c = abstractC0714f;
        if (enumC0709a == null) {
            H.a(10);
            throw null;
        }
        h3.e = enumC0709a;
        h3.f4554g = z6;
        I iB = h3.b();
        if (iB != null) {
            return iB;
        }
        a(42);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final boolean isActual() {
        return false;
    }

    @Override // q2.T, kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isConst() {
        return this.f4563o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptorWithAccessors
    public final boolean isDelegated() {
        return this.f4565r;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final boolean isExpect() {
        return this.f4564p;
    }

    public boolean isExternal() {
        return this.q;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public final boolean isLateInit() {
        return this.f4562n;
    }

    public I j(DeclarationDescriptor declarationDescriptor, EnumC0719k enumC0719k, AbstractC0714f abstractC0714f, PropertyDescriptor propertyDescriptor, EnumC0709a enumC0709a, L2.f fVar, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            a(32);
            throw null;
        }
        if (enumC0719k == null) {
            a(33);
            throw null;
        }
        if (abstractC0714f == null) {
            a(34);
            throw null;
        }
        if (enumC0709a == null) {
            a(35);
            throw null;
        }
        if (fVar == null) {
            a(36);
            throw null;
        }
        Annotations annotations = getAnnotations();
        boolean zIsConst = isConst();
        boolean zIsExternal = isExternal();
        return new I(declarationDescriptor, propertyDescriptor, annotations, enumC0719k, abstractC0714f, this.f4586f, fVar, enumC0709a, sourceElement, this.f4562n, zIsConst, this.f4564p, zIsExternal, this.f4565r);
    }

    public final void k(J j6, K k6, C0782t c0782t, C0782t c0782t2) {
        this.f4569w = j6;
        this.x = k6;
        this.y = c0782t;
        this.f4570z = c0782t2;
    }

    public void l(AbstractC0162z abstractC0162z) {
    }

    public final void m(AbstractC0162z abstractC0162z, List list, ReceiverParameterDescriptor receiverParameterDescriptor, w wVar, List list2) {
        if (abstractC0162z == null) {
            a(17);
            throw null;
        }
        if (list == null) {
            a(18);
            throw null;
        }
        if (list2 == null) {
            a(19);
            throw null;
        }
        this.e = abstractC0162z;
        this.f4568v = new ArrayList(list);
        this.u = wVar;
        this.f4567t = receiverParameterDescriptor;
        this.f4566s = list2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public final void setOverriddenDescriptors(Collection collection) {
        if (collection != null) {
            this.f4559k = collection;
        } else {
            a(40);
            throw null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public final PropertyDescriptor substitute(Z z6) {
        if (z6 != null) {
            if (z6.f1542a.e()) {
                return this;
            }
            H h3 = new H(this);
            W wG = z6.g();
            if (wG != null) {
                h3.f4553f = wG;
                h3.d = getOriginal();
                return h3.b();
            }
            H.a(15);
            throw null;
        }
        a(27);
        throw null;
    }

    @Override // q2.AbstractC0778o, q2.AbstractC0777n, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final PropertyDescriptor getOriginal() {
        PropertyDescriptor propertyDescriptor = this.f4560l;
        PropertyDescriptor original = propertyDescriptor == this ? this : propertyDescriptor.getOriginal();
        if (original != null) {
            return original;
        }
        a(38);
        throw null;
    }
}
