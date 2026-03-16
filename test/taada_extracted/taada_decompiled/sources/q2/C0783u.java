package q2;

import a3.AbstractC0162z;
import a3.W;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import n2.AbstractC0714f;
import n2.EnumC0709a;
import n2.EnumC0719k;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: renamed from: q2.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0783u implements FunctionDescriptor.CopyBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public W f4609a;
    public DeclarationDescriptor b;
    public EnumC0719k c;
    public AbstractC0714f d;
    public FunctionDescriptor e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EnumC0709a f4610f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f4611g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List f4612h;
    public ReceiverParameterDescriptor i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ReceiverParameterDescriptor f4613j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AbstractC0162z f4614k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public L2.f f4615l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f4616m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f4617n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f4618o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f4619p;
    public boolean q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List f4620r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Annotations f4621s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f4622t;
    public final LinkedHashMap u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Boolean f4623v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f4624w;
    public final /* synthetic */ v x;

    public C0783u(v vVar, W w5, DeclarationDescriptor declarationDescriptor, EnumC0719k enumC0719k, AbstractC0714f abstractC0714f, EnumC0709a enumC0709a, List list, List list2, w wVar, AbstractC0162z abstractC0162z) {
        if (w5 == null) {
            a(0);
            throw null;
        }
        if (declarationDescriptor == null) {
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
        if (enumC0709a == null) {
            a(4);
            throw null;
        }
        if (list == null) {
            a(5);
            throw null;
        }
        if (list2 == null) {
            a(6);
            throw null;
        }
        if (abstractC0162z == null) {
            a(7);
            throw null;
        }
        this.x = vVar;
        this.e = null;
        this.f4613j = vVar.f4631j;
        this.f4616m = true;
        this.f4617n = false;
        this.f4618o = false;
        this.f4619p = false;
        this.q = vVar.f4640t;
        this.f4620r = null;
        this.f4621s = null;
        this.f4622t = vVar.u;
        this.u = new LinkedHashMap();
        this.f4623v = null;
        this.f4624w = false;
        this.f4609a = w5;
        this.b = declarationDescriptor;
        this.c = enumC0719k;
        this.d = abstractC0714f;
        this.f4610f = enumC0709a;
        this.f4611g = list;
        this.f4612h = list2;
        this.i = wVar;
        this.f4614k = abstractC0162z;
        this.f4615l = null;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i3;
        switch (i) {
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 20:
            case 22:
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 36:
            case 38:
            case 40:
            case 41:
            case 42:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 10:
            case 12:
            case 14:
            case 17:
            case 19:
            case 21:
            case 23:
            case 25:
            case 35:
            case 37:
            case 39:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 20:
            case 22:
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 36:
            case 38:
            case 40:
            case 41:
            case 42:
                i3 = 2;
                break;
            case 10:
            case 12:
            case 14:
            case 17:
            case 19:
            case 21:
            case 23:
            case 25:
            case 35:
            case 37:
            case 39:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i) {
            case 1:
                objArr[0] = "newOwner";
                break;
            case 2:
                objArr[0] = "newModality";
                break;
            case 3:
                objArr[0] = "newVisibility";
                break;
            case 4:
            case 14:
                objArr[0] = "kind";
                break;
            case 5:
                objArr[0] = "newValueParameterDescriptors";
                break;
            case 6:
                objArr[0] = "newContextReceiverParameters";
                break;
            case 7:
                objArr[0] = "newReturnType";
                break;
            case 8:
                objArr[0] = "owner";
                break;
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 20:
            case 22:
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 36:
            case 38:
            case 40:
            case 41:
            case 42:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                break;
            case 10:
                objArr[0] = "modality";
                break;
            case 12:
                objArr[0] = "visibility";
                break;
            case 17:
                objArr[0] = "name";
                break;
            case 19:
            case 21:
                objArr[0] = "parameters";
                break;
            case 23:
                objArr[0] = "type";
                break;
            case 25:
                objArr[0] = "contextReceiverParameters";
                break;
            case 35:
                objArr[0] = "additionalAnnotations";
                break;
            case 37:
            default:
                objArr[0] = "substitution";
                break;
            case 39:
                objArr[0] = "userDataKey";
                break;
        }
        switch (i) {
            case 9:
                objArr[1] = "setOwner";
                break;
            case 10:
            case 12:
            case 14:
            case 17:
            case 19:
            case 21:
            case 23:
            case 25:
            case 35:
            case 37:
            case 39:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                break;
            case 11:
                objArr[1] = "setModality";
                break;
            case 13:
                objArr[1] = "setVisibility";
                break;
            case 15:
                objArr[1] = "setKind";
                break;
            case 16:
                objArr[1] = "setCopyOverrides";
                break;
            case 18:
                objArr[1] = "setName";
                break;
            case 20:
                objArr[1] = "setValueParameters";
                break;
            case 22:
                objArr[1] = "setTypeParameters";
                break;
            case 24:
                objArr[1] = "setReturnType";
                break;
            case 26:
                objArr[1] = "setContextReceiverParameters";
                break;
            case 27:
                objArr[1] = "setExtensionReceiverParameter";
                break;
            case 28:
                objArr[1] = "setDispatchReceiverParameter";
                break;
            case 29:
                objArr[1] = "setOriginal";
                break;
            case 30:
                objArr[1] = "setSignatureChange";
                break;
            case 31:
                objArr[1] = "setPreserveSourceElement";
                break;
            case 32:
                objArr[1] = "setDropOriginalInContainingParts";
                break;
            case 33:
                objArr[1] = "setHiddenToOvercomeSignatureClash";
                break;
            case 34:
                objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                break;
            case 36:
                objArr[1] = "setAdditionalAnnotations";
                break;
            case 38:
                objArr[1] = "setSubstitution";
                break;
            case 40:
                objArr[1] = "putUserData";
                break;
            case 41:
                objArr[1] = "getSubstitution";
                break;
            case 42:
                objArr[1] = "setJustForTypeSubstitution";
                break;
        }
        switch (i) {
            case 8:
                objArr[2] = "setOwner";
                break;
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 20:
            case 22:
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 36:
            case 38:
            case 40:
            case 41:
            case 42:
                break;
            case 10:
                objArr[2] = "setModality";
                break;
            case 12:
                objArr[2] = "setVisibility";
                break;
            case 14:
                objArr[2] = "setKind";
                break;
            case 17:
                objArr[2] = "setName";
                break;
            case 19:
                objArr[2] = "setValueParameters";
                break;
            case 21:
                objArr[2] = "setTypeParameters";
                break;
            case 23:
                objArr[2] = "setReturnType";
                break;
            case 25:
                objArr[2] = "setContextReceiverParameters";
                break;
            case 35:
                objArr[2] = "setAdditionalAnnotations";
                break;
            case 37:
                objArr[2] = "setSubstitution";
                break;
            case 39:
                objArr[2] = "putUserData";
                break;
            default:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 20:
            case 22:
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 36:
            case 38:
            case 40:
            case 41:
            case 42:
                throw new IllegalStateException(str2);
            case 10:
            case 12:
            case 14:
            case 17:
            case 19:
            case 21:
            case 23:
            case 25:
            case 35:
            case 37:
            case 39:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor build() {
        return this.x.j(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder putUserData(CallableDescriptor.UserDataKey userDataKey, Object obj) {
        if (userDataKey != null) {
            this.u.put(userDataKey, obj);
            return this;
        }
        a(39);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setAdditionalAnnotations(Annotations annotations) {
        if (annotations != null) {
            this.f4621s = annotations;
            return this;
        }
        a(35);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setCopyOverrides(boolean z6) {
        this.f4616m = z6;
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setDispatchReceiverParameter(ReceiverParameterDescriptor receiverParameterDescriptor) {
        this.f4613j = receiverParameterDescriptor;
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setDropOriginalInContainingParts() {
        this.f4619p = true;
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setExtensionReceiverParameter(ReceiverParameterDescriptor receiverParameterDescriptor) {
        this.i = receiverParameterDescriptor;
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setHiddenForResolutionEverywhereBesideSupercalls() {
        this.f4622t = true;
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setHiddenToOvercomeSignatureClash() {
        this.q = true;
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setKind(EnumC0709a enumC0709a) {
        if (enumC0709a != null) {
            this.f4610f = enumC0709a;
            return this;
        }
        a(14);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setModality(EnumC0719k enumC0719k) {
        if (enumC0719k != null) {
            this.c = enumC0719k;
            return this;
        }
        a(10);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setName(L2.f fVar) {
        if (fVar != null) {
            this.f4615l = fVar;
            return this;
        }
        a(17);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setOriginal(CallableMemberDescriptor callableMemberDescriptor) {
        this.e = (FunctionDescriptor) callableMemberDescriptor;
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setOwner(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            this.b = declarationDescriptor;
            return this;
        }
        a(8);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setPreserveSourceElement() {
        this.f4618o = true;
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setReturnType(AbstractC0162z abstractC0162z) {
        if (abstractC0162z != null) {
            this.f4614k = abstractC0162z;
            return this;
        }
        a(23);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setSignatureChange() {
        this.f4617n = true;
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setSubstitution(W w5) {
        if (w5 != null) {
            this.f4609a = w5;
            return this;
        }
        a(37);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setTypeParameters(List list) {
        if (list != null) {
            this.f4620r = list;
            return this;
        }
        a(21);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setValueParameters(List list) {
        if (list != null) {
            this.f4611g = list;
            return this;
        }
        a(19);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setVisibility(AbstractC0714f abstractC0714f) {
        if (abstractC0714f != null) {
            this.d = abstractC0714f;
            return this;
        }
        a(12);
        throw null;
    }
}
