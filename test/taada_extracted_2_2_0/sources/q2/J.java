package q2;

import a3.AbstractC0162z;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import n2.AbstractC0714f;
import n2.EnumC0709a;
import n2.EnumC0719k;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes2.dex */
public final class J extends G implements PropertyGetterDescriptor {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AbstractC0162z f4571m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final PropertyGetterDescriptor f4572n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(PropertyDescriptor propertyDescriptor, Annotations annotations, EnumC0719k enumC0719k, AbstractC0714f abstractC0714f, boolean z6, boolean z7, boolean z8, EnumC0709a enumC0709a, PropertyGetterDescriptor propertyGetterDescriptor, SourceElement sourceElement) {
        super(enumC0719k, abstractC0714f, propertyDescriptor, annotations, L2.f.g("<get-" + propertyDescriptor.getName() + ">"), z6, z7, z8, enumC0709a, sourceElement);
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
        this.f4572n = propertyGetterDescriptor != null ? propertyGetterDescriptor : this;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 6 || i == 7 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 6 || i == 7 || i == 8) ? 2 : 3];
        switch (i) {
            case 1:
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
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        if (i == 6) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i == 7) {
            objArr[1] = "getValueParameters";
        } else if (i != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i != 6 && i != 7 && i != 8) {
            objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
        }
        String str2 = String.format(str, objArr);
        if (i != 6 && i != 7 && i != 8) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final Object accept(DeclarationDescriptorVisitor declarationDescriptorVisitor, Object obj) {
        return declarationDescriptorVisitor.visitPropertyGetterDescriptor(this, obj);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final Collection getOverriddenDescriptors() {
        return g(true);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final AbstractC0162z getReturnType() {
        return this.f4571m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final List getValueParameters() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        a(7);
        throw null;
    }

    @Override // q2.AbstractC0778o, q2.AbstractC0777n, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final PropertyGetterDescriptor getOriginal() {
        PropertyGetterDescriptor propertyGetterDescriptor = this.f4572n;
        if (propertyGetterDescriptor != null) {
            return propertyGetterDescriptor;
        }
        a(8);
        throw null;
    }

    public final void i(AbstractC0162z abstractC0162z) {
        if (abstractC0162z == null) {
            abstractC0162z = getCorrespondingProperty().getType();
        }
        this.f4571m = abstractC0162z;
    }
}
