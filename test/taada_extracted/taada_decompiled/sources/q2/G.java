package q2;

import a3.Z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import n2.AbstractC0714f;
import n2.EnumC0709a;
import n2.EnumC0719k;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes2.dex */
public abstract class G extends AbstractC0778o implements PropertyAccessorDescriptor {
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f4545f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final EnumC0719k f4546g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PropertyDescriptor f4547h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final EnumC0709a f4548j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AbstractC0714f f4549k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FunctionDescriptor f4550l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G(EnumC0719k enumC0719k, AbstractC0714f abstractC0714f, PropertyDescriptor propertyDescriptor, Annotations annotations, L2.f fVar, boolean z6, boolean z7, boolean z8, EnumC0709a enumC0709a, SourceElement sourceElement) {
        super(propertyDescriptor.getContainingDeclaration(), annotations, fVar, sourceElement);
        if (enumC0719k == null) {
            a(0);
            throw null;
        }
        if (abstractC0714f == null) {
            a(1);
            throw null;
        }
        if (annotations == null) {
            a(3);
            throw null;
        }
        if (sourceElement == null) {
            a(5);
            throw null;
        }
        this.f4550l = null;
        this.f4546g = enumC0719k;
        this.f4549k = abstractC0714f;
        this.f4547h = propertyDescriptor;
        this.e = z6;
        this.f4545f = z7;
        this.i = z8;
        this.f4548j = enumC0709a;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i3;
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 7:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                i3 = 2;
                break;
            case 7:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i) {
            case 1:
                objArr[0] = "visibility";
                break;
            case 2:
                objArr[0] = "correspondingProperty";
                break;
            case 3:
                objArr[0] = "annotations";
                break;
            case 4:
                objArr[0] = "name";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 7:
                objArr[0] = "substitutor";
                break;
            case 16:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "modality";
                break;
        }
        switch (i) {
            case 6:
                objArr[1] = "getKind";
                break;
            case 7:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 8:
                objArr[1] = "substitute";
                break;
            case 9:
                objArr[1] = "getTypeParameters";
                break;
            case 10:
                objArr[1] = "getModality";
                break;
            case 11:
                objArr[1] = "getVisibility";
                break;
            case 12:
                objArr[1] = "getCorrespondingVariable";
                break;
            case 13:
                objArr[1] = "getCorrespondingProperty";
                break;
            case 14:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 15:
                objArr[1] = "getOverriddenDescriptors";
                break;
        }
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                break;
            case 7:
                objArr[2] = "substitute";
                break;
            case 16:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                throw new IllegalStateException(str2);
            case 7:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public final CallableMemberDescriptor copy(DeclarationDescriptor declarationDescriptor, EnumC0719k enumC0719k, AbstractC0714f abstractC0714f, EnumC0709a enumC0709a, boolean z6) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    public final ArrayList g(boolean z6) {
        ArrayList arrayList = new ArrayList(0);
        for (PropertyDescriptor propertyDescriptor : getCorrespondingProperty().getOverriddenDescriptors()) {
            CallableDescriptor getter = z6 ? propertyDescriptor.getGetter() : propertyDescriptor.getSetter();
            if (getter != null) {
                arrayList.add(getter);
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final List getContextReceiverParameters() {
        List<ReceiverParameterDescriptor> contextReceiverParameters = getCorrespondingProperty().getContextReceiverParameters();
        if (contextReceiverParameters != null) {
            return contextReceiverParameters;
        }
        a(14);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor
    public final PropertyDescriptor getCorrespondingProperty() {
        PropertyDescriptor propertyDescriptor = this.f4547h;
        if (propertyDescriptor != null) {
            return propertyDescriptor;
        }
        a(13);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return getCorrespondingProperty().getDispatchReceiverParameter();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return getCorrespondingProperty().getExtensionReceiverParameter();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public final FunctionDescriptor getInitialSignatureDescriptor() {
        return this.f4550l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public final EnumC0709a getKind() {
        EnumC0709a enumC0709a = this.f4548j;
        if (enumC0709a != null) {
            return enumC0709a;
        }
        a(6);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final EnumC0719k getModality() {
        EnumC0719k enumC0719k = this.f4546g;
        if (enumC0719k != null) {
            return enumC0719k;
        }
        a(10);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final List getTypeParameters() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        a(9);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final Object getUserData(CallableDescriptor.UserDataKey userDataKey) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final AbstractC0714f getVisibility() {
        AbstractC0714f abstractC0714f = this.f4549k;
        if (abstractC0714f != null) {
            return abstractC0714f;
        }
        a(11);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final boolean hasSynthesizedParameterNames() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor
    public final boolean isDefault() {
        return this.e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final boolean isExpect() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final boolean isExternal() {
        return this.f4545f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public final boolean isHiddenForResolutionEverywhereBesideSupercalls() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public final boolean isHiddenToOvercomeSignatureClash() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public final boolean isInfix() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public final boolean isInline() {
        return this.i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public final boolean isOperator() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public final boolean isSuspend() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public final boolean isTailrec() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor
    public final FunctionDescriptor.CopyBuilder newCopyBuilder() {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public final void setOverriddenDescriptors(Collection collection) {
        if (collection != null) {
            return;
        }
        a(16);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public final FunctionDescriptor substitute(Z z6) {
        if (z6 != null) {
            return this;
        }
        a(7);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public final /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(Z z6) {
        substitute(z6);
        return this;
    }
}
