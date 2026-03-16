package q2;

import a3.AbstractC0162z;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import n2.AbstractC0714f;
import n2.EnumC0709a;
import n2.EnumC0719k;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes2.dex */
public final class K extends G implements PropertySetterDescriptor {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ValueParameterDescriptor f4572m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final PropertySetterDescriptor f4573n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(PropertyDescriptor propertyDescriptor, Annotations annotations, EnumC0719k enumC0719k, AbstractC0714f abstractC0714f, boolean z6, boolean z7, boolean z8, EnumC0709a enumC0709a, PropertySetterDescriptor propertySetterDescriptor, SourceElement sourceElement) {
        super(enumC0719k, abstractC0714f, propertyDescriptor, annotations, L2.f.g("<set-" + propertyDescriptor.getName() + ">"), z6, z7, z8, enumC0709a, sourceElement);
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
        if (enumC0709a == null) {
            a(4);
            throw null;
        }
        if (sourceElement == null) {
            a(5);
            throw null;
        }
        this.f4573n = propertySetterDescriptor != null ? propertySetterDescriptor : this;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i3;
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i) {
            case 1:
            case 9:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "visibility";
                break;
            case 4:
                objArr[0] = "kind";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "parameter";
                break;
            case 7:
                objArr[0] = "setterDescriptor";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        switch (i) {
            case 10:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 11:
                objArr[1] = "getValueParameters";
                break;
            case 12:
                objArr[1] = "getReturnType";
                break;
            case 13:
                objArr[1] = "getOriginal";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
        }
        switch (i) {
            case 6:
                objArr[2] = "initialize";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSetterParameter";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            default:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static S h(K k6, AbstractC0162z abstractC0162z, Annotations annotations) {
        if (abstractC0162z == null) {
            a(8);
            throw null;
        }
        if (annotations != null) {
            return new S(k6, null, 0, annotations, L2.h.f966g, abstractC0162z, false, false, false, null, SourceElement.NO_SOURCE);
        }
        a(9);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final Object accept(DeclarationDescriptorVisitor declarationDescriptorVisitor, Object obj) {
        return declarationDescriptorVisitor.visitPropertySetterDescriptor(this, obj);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final Collection getOverriddenDescriptors() {
        return g(false);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final AbstractC0162z getReturnType() {
        a3.F fV = R2.e.e(this).v();
        if (fV != null) {
            return fV;
        }
        a(12);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final List getValueParameters() {
        ValueParameterDescriptor valueParameterDescriptor = this.f4572m;
        if (valueParameterDescriptor == null) {
            throw new IllegalStateException();
        }
        List listSingletonList = Collections.singletonList(valueParameterDescriptor);
        if (listSingletonList != null) {
            return listSingletonList;
        }
        a(11);
        throw null;
    }

    @Override // q2.AbstractC0778o, q2.AbstractC0777n, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final PropertySetterDescriptor getOriginal() {
        PropertySetterDescriptor propertySetterDescriptor = this.f4573n;
        if (propertySetterDescriptor != null) {
            return propertySetterDescriptor;
        }
        a(13);
        throw null;
    }
}
