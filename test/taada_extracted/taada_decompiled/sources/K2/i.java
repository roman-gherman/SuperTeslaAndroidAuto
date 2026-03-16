package k2;

import a3.AbstractC0162z;
import a3.C;
import a3.F;
import a3.K;
import a3.b0;
import a3.c0;
import a3.d0;
import c4.AbstractC0246d;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.protobuf.v;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import l2.C0617a;
import l2.EnumC0621e;
import n2.AbstractC0718j;
import net.bytebuddy.description.method.MethodDescription;
import p2.C0756a;
import q2.C0763B;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final L2.f f3709f = L2.f.g("<built-ins module>");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0763B f3710a;
    public final NotNullLazyValue b;
    public final NotNullLazyValue c;
    public final MemoizedFunctionToNotNull d;
    public final Z2.n e;

    public i(Z2.n nVar) {
        this.e = nVar;
        this.c = nVar.createLazyValue(new C0586e(this, 0));
        this.b = nVar.createLazyValue(new C0586e(this, 1));
        this.d = nVar.createMemoizedFunction(new C0587f(this, 0));
    }

    public static boolean A(AbstractC0162z abstractC0162z, L2.e eVar) {
        if (eVar != null) {
            return z(abstractC0162z, eVar) && !abstractC0162z.d();
        }
        a(135);
        throw null;
    }

    public static boolean B(FunctionDescriptor functionDescriptor) {
        if (functionDescriptor.getOriginal().getAnnotations().hasAnnotation(o.f3752m)) {
            return true;
        }
        if (!(functionDescriptor instanceof PropertyDescriptor)) {
            return false;
        }
        PropertyDescriptor propertyDescriptor = (PropertyDescriptor) functionDescriptor;
        boolean zIsVar = propertyDescriptor.isVar();
        PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
        PropertySetterDescriptor setter = propertyDescriptor.getSetter();
        if (getter == null || !B(getter)) {
            return false;
        }
        if (zIsVar) {
            return setter != null && B(setter);
        }
        return true;
    }

    public static boolean C(AbstractC0162z abstractC0162z, L2.e eVar) {
        if (eVar != null) {
            return !abstractC0162z.d() && z(abstractC0162z, eVar);
        }
        a(106);
        throw null;
    }

    public static boolean D(AbstractC0162z abstractC0162z) {
        if (abstractC0162z == null) {
            a(136);
            throw null;
        }
        if (abstractC0162z != null) {
            return z(abstractC0162z, o.b) && !b0.f(abstractC0162z);
        }
        a(138);
        throw null;
    }

    public static boolean E(AbstractC0162z abstractC0162z) {
        if (abstractC0162z != null) {
            ClassifierDescriptor declarationDescriptor = abstractC0162z.c().getDeclarationDescriptor();
            return (declarationDescriptor == null || q(declarationDescriptor) == null) ? false : true;
        }
        a(91);
        throw null;
    }

    public static boolean F(AbstractC0162z abstractC0162z) {
        if (abstractC0162z == null) {
            a(94);
            throw null;
        }
        if (abstractC0162z.d()) {
            return false;
        }
        ClassifierDescriptor declarationDescriptor = abstractC0162z.c().getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof ClassDescriptor)) {
            return false;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
        if (classDescriptor != null) {
            return s(classDescriptor) != null;
        }
        a(96);
        throw null;
    }

    public static boolean G(AbstractC0162z abstractC0162z) {
        return C(abstractC0162z, o.f3746f);
    }

    public static boolean H(TypeConstructor typeConstructor, L2.e eVar) {
        if (typeConstructor == null) {
            a(101);
            throw null;
        }
        if (eVar != null) {
            ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
            return (declarationDescriptor instanceof ClassDescriptor) && b((ClassDescriptor) declarationDescriptor, eVar);
        }
        a(102);
        throw null;
    }

    public static boolean I(ClassifierDescriptor classifierDescriptor) {
        for (DeclarationDescriptor containingDeclaration = classifierDescriptor; containingDeclaration != null; containingDeclaration = containingDeclaration.getContainingDeclaration()) {
            if (containingDeclaration instanceof PackageFragmentDescriptor) {
                return ((PackageFragmentDescriptor) containingDeclaration).getFqName().h(p.f3766j);
            }
        }
        return false;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i3;
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                i3 = 2;
                break;
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i) {
            case 1:
            case 72:
                objArr[0] = "module";
                break;
            case 2:
                objArr[0] = "computation";
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 9:
            case 10:
            case 76:
            case 77:
            case 89:
            case 96:
            case 103:
            case 107:
            case 108:
            case 143:
            case 146:
            case 147:
            case 149:
            case 157:
            case 158:
            case 159:
            case 160:
                objArr[0] = "descriptor";
                break;
            case 12:
            case 98:
            case 100:
            case 102:
            case 104:
            case 106:
            case 135:
                objArr[0] = "fqName";
                break;
            case 14:
                objArr[0] = "simpleName";
                break;
            case 16:
            case 17:
            case 53:
            case 88:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 97:
            case 99:
            case 105:
            case 109:
            case 110:
            case 111:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 144:
            case 145:
            case 148:
            case 150:
            case 151:
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 162:
                objArr[0] = "type";
                break;
            case 46:
                objArr[0] = "classSimpleName";
                break;
            case 67:
                objArr[0] = "arrayType";
                break;
            case 71:
                objArr[0] = "notNullArrayType";
                break;
            case 73:
                objArr[0] = "primitiveType";
                break;
            case 75:
                objArr[0] = "kotlinType";
                break;
            case 78:
            case 82:
                objArr[0] = "projectionType";
                break;
            case 79:
            case 83:
            case 85:
                objArr[0] = "argument";
                break;
            case 80:
                objArr[0] = "annotations";
                break;
            case 101:
                objArr[0] = "typeConstructor";
                break;
            case 112:
                objArr[0] = "classDescriptor";
                break;
            case 161:
                objArr[0] = "declarationDescriptor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i) {
            case 3:
                objArr[1] = "getAdditionalClassPartsProvider";
                break;
            case 4:
                objArr[1] = "getPlatformDependentDeclarationFilter";
                break;
            case 5:
                objArr[1] = "getClassDescriptorFactories";
                break;
            case 6:
                objArr[1] = "getStorageManager";
                break;
            case 7:
                objArr[1] = "getBuiltInsModule";
                break;
            case 8:
                objArr[1] = "getBuiltInPackagesImportedByDefault";
                break;
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 11:
                objArr[1] = "getBuiltInsPackageScope";
                break;
            case 13:
                objArr[1] = "getBuiltInClassByFqName";
                break;
            case 15:
                objArr[1] = "getBuiltInClassByName";
                break;
            case 18:
                objArr[1] = "getSuspendFunction";
                break;
            case 19:
                objArr[1] = "getKFunction";
                break;
            case 20:
                objArr[1] = "getKSuspendFunction";
                break;
            case 21:
                objArr[1] = "getKClass";
                break;
            case 22:
                objArr[1] = "getKCallable";
                break;
            case 23:
                objArr[1] = "getKProperty";
                break;
            case 24:
                objArr[1] = "getKProperty0";
                break;
            case 25:
                objArr[1] = "getKProperty1";
                break;
            case 26:
                objArr[1] = "getKProperty2";
                break;
            case 27:
                objArr[1] = "getKMutableProperty0";
                break;
            case 28:
                objArr[1] = "getKMutableProperty1";
                break;
            case 29:
                objArr[1] = "getKMutableProperty2";
                break;
            case 30:
                objArr[1] = "getIterator";
                break;
            case 31:
                objArr[1] = "getIterable";
                break;
            case 32:
                objArr[1] = "getMutableIterable";
                break;
            case 33:
                objArr[1] = "getMutableIterator";
                break;
            case 34:
                objArr[1] = "getCollection";
                break;
            case 35:
                objArr[1] = "getMutableCollection";
                break;
            case 36:
                objArr[1] = "getList";
                break;
            case 37:
                objArr[1] = "getMutableList";
                break;
            case 38:
                objArr[1] = "getSet";
                break;
            case 39:
                objArr[1] = "getMutableSet";
                break;
            case 40:
                objArr[1] = "getMap";
                break;
            case 41:
                objArr[1] = "getMutableMap";
                break;
            case 42:
                objArr[1] = "getMapEntry";
                break;
            case 43:
                objArr[1] = "getMutableMapEntry";
                break;
            case 44:
                objArr[1] = "getListIterator";
                break;
            case 45:
                objArr[1] = "getMutableListIterator";
                break;
            case 47:
                objArr[1] = "getBuiltInTypeByClassName";
                break;
            case 48:
                objArr[1] = "getNothingType";
                break;
            case 49:
                objArr[1] = "getNullableNothingType";
                break;
            case 50:
                objArr[1] = "getAnyType";
                break;
            case 51:
                objArr[1] = "getNullableAnyType";
                break;
            case 52:
                objArr[1] = "getDefaultBound";
                break;
            case 54:
                objArr[1] = "getPrimitiveKotlinType";
                break;
            case 55:
                objArr[1] = "getNumberType";
                break;
            case 56:
                objArr[1] = "getByteType";
                break;
            case 57:
                objArr[1] = "getShortType";
                break;
            case 58:
                objArr[1] = "getIntType";
                break;
            case 59:
                objArr[1] = "getLongType";
                break;
            case 60:
                objArr[1] = "getFloatType";
                break;
            case 61:
                objArr[1] = "getDoubleType";
                break;
            case 62:
                objArr[1] = "getCharType";
                break;
            case 63:
                objArr[1] = "getBooleanType";
                break;
            case 64:
                objArr[1] = "getUnitType";
                break;
            case 65:
                objArr[1] = "getStringType";
                break;
            case 66:
                objArr[1] = "getIterableType";
                break;
            case 68:
            case 69:
            case 70:
                objArr[1] = "getArrayElementType";
                break;
            case 74:
                objArr[1] = "getPrimitiveArrayKotlinType";
                break;
            case 81:
            case 84:
                objArr[1] = "getArrayType";
                break;
            case 86:
                objArr[1] = "getEnumType";
                break;
            case 87:
                objArr[1] = "getAnnotationType";
                break;
        }
        switch (i) {
            case 1:
                objArr[2] = "setBuiltInsModule";
                break;
            case 2:
                objArr[2] = "setPostponedBuiltinsModuleComputation";
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                break;
            case 9:
                objArr[2] = "isBuiltIn";
                break;
            case 10:
                objArr[2] = "isUnderKotlinPackage";
                break;
            case 12:
                objArr[2] = "getBuiltInClassByFqName";
                break;
            case 14:
                objArr[2] = "getBuiltInClassByName";
                break;
            case 16:
                objArr[2] = "getPrimitiveClassDescriptor";
                break;
            case 17:
                objArr[2] = "getPrimitiveArrayClassDescriptor";
                break;
            case 46:
                objArr[2] = "getBuiltInTypeByClassName";
                break;
            case 53:
                objArr[2] = "getPrimitiveKotlinType";
                break;
            case 67:
                objArr[2] = "getArrayElementType";
                break;
            case 71:
            case 72:
                objArr[2] = "getElementTypeForUnsignedArray";
                break;
            case 73:
                objArr[2] = "getPrimitiveArrayKotlinType";
                break;
            case 75:
                objArr[2] = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
                break;
            case 76:
            case 93:
                objArr[2] = "getPrimitiveType";
                break;
            case 77:
                objArr[2] = "getPrimitiveArrayType";
                break;
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
                objArr[2] = "getArrayType";
                break;
            case 85:
                objArr[2] = "getEnumType";
                break;
            case 88:
                objArr[2] = "isArray";
                break;
            case 89:
            case 90:
                objArr[2] = "isArrayOrPrimitiveArray";
                break;
            case 91:
                objArr[2] = "isPrimitiveArray";
                break;
            case 92:
                objArr[2] = "getPrimitiveArrayElementType";
                break;
            case 94:
                objArr[2] = "isPrimitiveType";
                break;
            case 95:
                objArr[2] = "isPrimitiveTypeOrNullablePrimitiveType";
                break;
            case 96:
                objArr[2] = "isPrimitiveClass";
                break;
            case 97:
            case 98:
            case 99:
            case 100:
                objArr[2] = "isConstructedFromGivenClass";
                break;
            case 101:
            case 102:
                objArr[2] = "isTypeConstructorForGivenClass";
                break;
            case 103:
            case 104:
                objArr[2] = "classFqNameEquals";
                break;
            case 105:
            case 106:
                objArr[2] = "isNotNullConstructedFromGivenClass";
                break;
            case 107:
                objArr[2] = "isSpecialClassWithNoSupertypes";
                break;
            case 108:
            case 109:
                objArr[2] = "isAny";
                break;
            case 110:
            case 112:
                objArr[2] = "isBoolean";
                break;
            case 111:
                objArr[2] = "isBooleanOrNullableBoolean";
                break;
            case 113:
                objArr[2] = "isNumber";
                break;
            case 114:
                objArr[2] = "isChar";
                break;
            case 115:
                objArr[2] = "isCharOrNullableChar";
                break;
            case 116:
                objArr[2] = "isInt";
                break;
            case 117:
                objArr[2] = "isByte";
                break;
            case 118:
                objArr[2] = "isLong";
                break;
            case 119:
                objArr[2] = "isLongOrNullableLong";
                break;
            case 120:
                objArr[2] = "isShort";
                break;
            case 121:
                objArr[2] = "isFloat";
                break;
            case 122:
                objArr[2] = "isFloatOrNullableFloat";
                break;
            case 123:
                objArr[2] = "isDouble";
                break;
            case 124:
                objArr[2] = "isUByte";
                break;
            case 125:
                objArr[2] = "isUShort";
                break;
            case 126:
                objArr[2] = "isUInt";
                break;
            case 127:
                objArr[2] = "isULong";
                break;
            case 128:
                objArr[2] = "isUByteArray";
                break;
            case 129:
                objArr[2] = "isUShortArray";
                break;
            case 130:
                objArr[2] = "isUIntArray";
                break;
            case 131:
                objArr[2] = "isULongArray";
                break;
            case 132:
                objArr[2] = "isUnsignedArrayType";
                break;
            case 133:
                objArr[2] = "isDoubleOrNullableDouble";
                break;
            case 134:
            case 135:
                objArr[2] = "isConstructedFromGivenClassAndNotNullable";
                break;
            case 136:
                objArr[2] = "isNothing";
                break;
            case 137:
                objArr[2] = "isNullableNothing";
                break;
            case 138:
                objArr[2] = "isNothingOrNullableNothing";
                break;
            case 139:
                objArr[2] = "isAnyOrNullableAny";
                break;
            case 140:
                objArr[2] = "isNullableAny";
                break;
            case 141:
                objArr[2] = "isDefaultBound";
                break;
            case 142:
                objArr[2] = "isUnit";
                break;
            case 143:
                objArr[2] = "mayReturnNonUnitValue";
                break;
            case 144:
                objArr[2] = "isUnitOrNullableUnit";
                break;
            case 145:
                objArr[2] = "isBooleanOrSubtype";
                break;
            case 146:
                objArr[2] = "isMemberOfAny";
                break;
            case 147:
            case 148:
                objArr[2] = "isEnum";
                break;
            case 149:
            case 150:
                objArr[2] = "isComparable";
                break;
            case 151:
                objArr[2] = "isCollectionOrNullableCollection";
                break;
            case 152:
                objArr[2] = "isListOrNullableList";
                break;
            case 153:
                objArr[2] = "isSetOrNullableSet";
                break;
            case 154:
                objArr[2] = "isMapOrNullableMap";
                break;
            case 155:
                objArr[2] = "isIterableOrNullableIterable";
                break;
            case 156:
                objArr[2] = "isThrowableOrNullableThrowable";
                break;
            case 157:
                objArr[2] = "isThrowable";
                break;
            case 158:
                objArr[2] = "isKClass";
                break;
            case 159:
                objArr[2] = "isNonPrimitiveArray";
                break;
            case 160:
                objArr[2] = "isCloneable";
                break;
            case 161:
                objArr[2] = "isDeprecated";
                break;
            case 162:
                objArr[2] = "isNotNullOrNullableFunctionSupertype";
                break;
            default:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                throw new IllegalStateException(str2);
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static boolean b(ClassDescriptor classDescriptor, L2.e eVar) {
        if (classDescriptor == null) {
            a(103);
            throw null;
        }
        if (eVar != null) {
            return classDescriptor.getName().equals(eVar.f()) && eVar.equals(N2.f.g(classDescriptor));
        }
        a(104);
        throw null;
    }

    public static k q(ClassifierDescriptor classifierDescriptor) {
        if (classifierDescriptor == null) {
            a(77);
            throw null;
        }
        if (o.f3743a0.contains(classifierDescriptor.getName())) {
            return (k) o.f3745c0.get(N2.f.g(classifierDescriptor));
        }
        return null;
    }

    public static k s(ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            a(76);
            throw null;
        }
        if (o.f3741Z.contains(classDescriptor.getName())) {
            return (k) o.f3744b0.get(N2.f.g(classDescriptor));
        }
        return null;
    }

    public static boolean w(AbstractC0162z abstractC0162z) {
        if (abstractC0162z != null) {
            return z(abstractC0162z, o.f3742a);
        }
        a(139);
        throw null;
    }

    public static boolean x(AbstractC0162z abstractC0162z) {
        if (abstractC0162z != null) {
            return z(abstractC0162z, o.f3747g);
        }
        a(88);
        throw null;
    }

    public static boolean y(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            return N2.f.i(declarationDescriptor, BuiltInsPackageFragment.class, false) != null;
        }
        a(9);
        throw null;
    }

    public static boolean z(AbstractC0162z abstractC0162z, L2.e eVar) {
        if (abstractC0162z == null) {
            a(97);
            throw null;
        }
        if (eVar != null) {
            return H(abstractC0162z.c(), eVar);
        }
        a(98);
        throw null;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, kotlin.Lazy] */
    public final void c(boolean z6) {
        L2.f moduleName = f3709f;
        kotlin.jvm.internal.h.f(moduleName, "moduleName");
        Z2.n nVar = this.e;
        C0763B c0763b = new C0763B(moduleName, nVar, this, 48);
        this.f3710a = c0763b;
        BuiltInsLoader.Companion.getClass();
        PackageFragmentProvider providerForModuleContent = ((BuiltInsLoader) C0583b.b.getValue()).createPackageFragmentProvider(nVar, this.f3710a, l(), o(), d(), z6);
        kotlin.jvm.internal.h.f(providerForModuleContent, "providerForModuleContent");
        c0763b.f4533h = providerForModuleContent;
        C0763B c0763b2 = this.f3710a;
        c0763b2.getClass();
        c0763b2.f4532g = new v(kotlin.collections.j.L(new C0763B[]{c0763b2}));
    }

    public AdditionalClassPartsProvider d() {
        return C0756a.b;
    }

    public final F e() {
        F defaultType = j("Any").getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        a(50);
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final AbstractC0162z f(AbstractC0162z abstractC0162z) {
        L2.b bVarF;
        L2.b bVar;
        ClassDescriptor classDescriptorD;
        F defaultType = null;
        if (abstractC0162z == null) {
            a(67);
            throw null;
        }
        if (x(abstractC0162z)) {
            if (abstractC0162z.a().size() != 1) {
                throw new IllegalStateException();
            }
            AbstractC0162z type = ((TypeProjection) abstractC0162z.a().get(0)).getType();
            if (type != null) {
                return type;
            }
            a(68);
            throw null;
        }
        c0 c0VarH = b0.h(abstractC0162z, false);
        AbstractC0162z abstractC0162z2 = (AbstractC0162z) ((C0589h) this.b.invoke()).b.get(c0VarH);
        if (abstractC0162z2 != null) {
            return abstractC0162z2;
        }
        int i = N2.f.f1135a;
        ClassifierDescriptor declarationDescriptor = c0VarH.c().getDeclarationDescriptor();
        ModuleDescriptor moduleDescriptorE = declarationDescriptor == null ? null : N2.f.e(declarationDescriptor);
        if (moduleDescriptorE != null) {
            ClassifierDescriptor declarationDescriptor2 = c0VarH.c().getDeclarationDescriptor();
            if (declarationDescriptor2 != null) {
                Set set = t.f3777a;
                L2.f name = declarationDescriptor2.getName();
                kotlin.jvm.internal.h.f(name, "name");
                if (t.d.contains(name) && (bVarF = R2.e.f(declarationDescriptor2)) != null && (bVar = (L2.b) t.b.get(bVarF)) != null && (classDescriptorD = AbstractC0718j.d(moduleDescriptorE, bVar)) != null) {
                    defaultType = classDescriptorD.getDefaultType();
                }
            }
            if (defaultType != null) {
                return defaultType;
            }
        }
        throw new IllegalStateException("not array: " + abstractC0162z);
    }

    public final F g(c0 c0Var) {
        d0 d0Var = d0.INVARIANT;
        if (c0Var != null) {
            Annotations.Companion.getClass();
            return h(d0Var, c0Var, o2.f.b);
        }
        a(83);
        throw null;
    }

    public final F h(d0 d0Var, AbstractC0162z abstractC0162z, Annotations annotations) {
        if (abstractC0162z != null) {
            return C.b(AbstractC0246d.I0(annotations), j("Array"), Collections.singletonList(new K(abstractC0162z, d0Var)));
        }
        a(79);
        throw null;
    }

    public final ClassDescriptor i(L2.c cVar) {
        if (cVar == null) {
            a(12);
            throw null;
        }
        ClassDescriptor classDescriptorJ = AbstractC0718j.j(k(), cVar);
        if (classDescriptorJ != null) {
            return classDescriptorJ;
        }
        a(13);
        throw null;
    }

    public final ClassDescriptor j(String str) {
        if (str == null) {
            a(14);
            throw null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) this.d.invoke(L2.f.e(str));
        if (classDescriptor != null) {
            return classDescriptor;
        }
        a(15);
        throw null;
    }

    public final C0763B k() {
        this.f3710a.getClass();
        C0763B c0763b = this.f3710a;
        if (c0763b != null) {
            return c0763b;
        }
        a(7);
        throw null;
    }

    public Iterable l() {
        List listSingletonList = Collections.singletonList(new C0617a(this.e, k()));
        if (listSingletonList != null) {
            return listSingletonList;
        }
        a(5);
        throw null;
    }

    public final F m() {
        F defaultType = j("Nothing").getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        a(48);
        throw null;
    }

    public final F n() {
        F fJ = e().g(true);
        if (fJ != null) {
            return fJ;
        }
        a(51);
        throw null;
    }

    public PlatformDependentDeclarationFilter o() {
        return C0756a.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final F p(k kVar) {
        if (kVar == null) {
            a(73);
            throw null;
        }
        F f6 = (F) ((C0589h) this.b.invoke()).f3708a.get(kVar);
        if (f6 != null) {
            return f6;
        }
        a(74);
        throw null;
    }

    public final F r(k kVar) {
        if (kVar == null) {
            a(53);
            throw null;
        }
        if (kVar == null) {
            a(16);
            throw null;
        }
        F defaultType = j(kVar.f3720a.b()).getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        a(54);
        throw null;
    }

    public final F t() {
        F defaultType = j("String").getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        a(65);
        throw null;
    }

    public final ClassDescriptor u(int i) {
        return i(p.e.c(L2.f.e(EnumC0621e.e.b + i)));
    }

    public final F v() {
        F defaultType = j("Unit").getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        a(64);
        throw null;
    }
}
