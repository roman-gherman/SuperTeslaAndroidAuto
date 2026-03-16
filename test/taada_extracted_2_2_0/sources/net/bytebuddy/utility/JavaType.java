package net.bytebuddy.utility;

import androidx.core.view.InputDeviceCompat;
import java.io.Serializable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'CONSTABLE' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes2.dex */
public final class JavaType {
    private static final /* synthetic */ JavaType[] $VALUES;
    public static final JavaType ACCESS_CONTROL_CONTEXT;
    public static final JavaType CALL_SITE;
    public static final JavaType CLASS_DESCRIPTION;
    public static final JavaType CONSTABLE;
    public static final JavaType CONSTANT_BOOTSTRAPS;
    public static final JavaType CONSTANT_DESCRIPTION;
    public static final JavaType DIRECT_METHOD_HANDLE_DESCRIPTION;
    public static final JavaType DYNAMIC_CONSTANT_DESCRIPTION;
    public static final JavaType EXECUTABLE;
    public static final JavaType METHOD_HANDLE;
    public static final JavaType METHOD_HANDLES;
    public static final JavaType METHOD_HANDLES_LOOKUP;
    public static final JavaType METHOD_HANDLE_DESCRIPTION;
    public static final JavaType METHOD_TYPE;
    public static final JavaType METHOD_TYPE_DESCRIPTION;
    public static final JavaType MODULE;
    public static final JavaType OBJECT_METHODS;
    public static final JavaType PARAMETER;
    public static final JavaType RECORD;
    public static final JavaType TYPE_DESCRIPTOR;
    public static final JavaType TYPE_DESCRIPTOR_OF_FIELD;
    public static final JavaType TYPE_DESCRIPTOR_OF_METHOD;
    public static final JavaType VAR_HANDLE;
    private transient /* synthetic */ Boolean available;
    private transient /* synthetic */ Class loaded;
    private final TypeDescription typeDescription;

    public static class LatentTypeWithSimpleName extends TypeDescription.Latent {
        public LatentTypeWithSimpleName(String str, int i, @MaybeNull TypeDescription.Generic generic, List<? extends TypeDescription.Generic> list) {
            super(str, i, generic, list);
        }

        @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase.OfSimpleType, net.bytebuddy.description.type.TypeDescription
        public String getSimpleName() {
            String name = getName();
            int iMax = Math.max(name.lastIndexOf(36), name.lastIndexOf(46));
            return iMax == -1 ? name : name.substring(iMax + 1);
        }
    }

    static {
        TypeDescription typeDescription = TypeDescription.UNDEFINED;
        JavaType javaType = new JavaType("CONSTABLE", 0, "java.lang.constant.Constable", 1537, typeDescription, new TypeDefinition[0]);
        CONSTABLE = javaType;
        JavaType javaType2 = new JavaType("TYPE_DESCRIPTOR", 1, "java.lang.invoke.TypeDescriptor", 1537, typeDescription, new TypeDefinition[0]);
        TYPE_DESCRIPTOR = javaType2;
        JavaType javaType3 = new JavaType("TYPE_DESCRIPTOR_OF_FIELD", 2, "java.lang.invoke.TypeDescriptor$OfField", 1537, typeDescription, javaType2.getTypeStub());
        TYPE_DESCRIPTOR_OF_FIELD = javaType3;
        JavaType javaType4 = new JavaType("TYPE_DESCRIPTOR_OF_METHOD", 3, "java.lang.invoke.TypeDescriptor$OfMethod", 1537, typeDescription, javaType2.getTypeStub());
        TYPE_DESCRIPTOR_OF_METHOD = javaType4;
        JavaType javaType5 = new JavaType("CONSTANT_DESCRIPTION", 4, "java.lang.constant.ConstantDesc", 1537, typeDescription, new TypeDefinition[0]);
        CONSTANT_DESCRIPTION = javaType5;
        JavaType javaType6 = new JavaType("DYNAMIC_CONSTANT_DESCRIPTION", 5, "java.lang.constant.DynamicConstantDesc", InputDeviceCompat.SOURCE_GAMEPAD, TypeDescription.ForLoadedType.of(Object.class), javaType5.getTypeStub());
        DYNAMIC_CONSTANT_DESCRIPTION = javaType6;
        JavaType javaType7 = new JavaType("CLASS_DESCRIPTION", 6, "java.lang.constant.ClassDesc", 1537, typeDescription, javaType5.getTypeStub(), javaType3.getTypeStub());
        CLASS_DESCRIPTION = javaType7;
        JavaType javaType8 = new JavaType("METHOD_TYPE_DESCRIPTION", 7, "java.lang.constant.MethodTypeDesc", 1537, typeDescription, javaType5.getTypeStub(), javaType4.getTypeStub());
        METHOD_TYPE_DESCRIPTION = javaType8;
        JavaType javaType9 = new JavaType("METHOD_HANDLE_DESCRIPTION", 8, "java.lang.constant.MethodHandleDesc", 1537, typeDescription, javaType5.getTypeStub());
        METHOD_HANDLE_DESCRIPTION = javaType9;
        JavaType javaType10 = new JavaType("DIRECT_METHOD_HANDLE_DESCRIPTION", 9, "java.lang.constant.DirectMethodHandleDesc", 1537, typeDescription, javaType9.getTypeStub());
        DIRECT_METHOD_HANDLE_DESCRIPTION = javaType10;
        JavaType javaType11 = new JavaType("METHOD_HANDLE", 10, "java.lang.invoke.MethodHandle", InputDeviceCompat.SOURCE_GAMEPAD, TypeDescription.ForLoadedType.of(Object.class), javaType.getTypeStub());
        METHOD_HANDLE = javaType11;
        JavaType javaType12 = new JavaType("METHOD_HANDLES", 11, "java.lang.invoke.MethodHandles", 1, Object.class, new Type[0]);
        METHOD_HANDLES = javaType12;
        JavaType javaType13 = new JavaType("METHOD_TYPE", 12, "java.lang.invoke.MethodType", 17, TypeDescription.ForLoadedType.of(Object.class), javaType.getTypeStub(), javaType4.getTypeStub(), TypeDescription.ForLoadedType.of(Serializable.class));
        METHOD_TYPE = javaType13;
        JavaType javaType14 = new JavaType("METHOD_HANDLES_LOOKUP", 13, "java.lang.invoke.MethodHandles$Lookup", 25, Object.class, new Type[0]);
        METHOD_HANDLES_LOOKUP = javaType14;
        JavaType javaType15 = new JavaType("CALL_SITE", 14, "java.lang.invoke.CallSite", InputDeviceCompat.SOURCE_GAMEPAD, Object.class, new Type[0]);
        CALL_SITE = javaType15;
        JavaType javaType16 = new JavaType("VAR_HANDLE", 15, "java.lang.invoke.VarHandle", InputDeviceCompat.SOURCE_GAMEPAD, TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class), javaType.getTypeStub());
        VAR_HANDLE = javaType16;
        JavaType javaType17 = new JavaType("PARAMETER", 16, "java.lang.reflect.Parameter", 17, Object.class, AnnotatedElement.class);
        PARAMETER = javaType17;
        JavaType javaType18 = new JavaType("EXECUTABLE", 17, "java.lang.reflect.Executable", InputDeviceCompat.SOURCE_GAMEPAD, AccessibleObject.class, Member.class, GenericDeclaration.class);
        EXECUTABLE = javaType18;
        JavaType javaType19 = new JavaType("MODULE", 18, "java.lang.Module", 17, Object.class, AnnotatedElement.class);
        MODULE = javaType19;
        JavaType javaType20 = new JavaType("CONSTANT_BOOTSTRAPS", 19, "java.lang.invoke.ConstantBootstraps", 17, Object.class, new Type[0]);
        CONSTANT_BOOTSTRAPS = javaType20;
        JavaType javaType21 = new JavaType("RECORD", 20, "java.lang.Record", InputDeviceCompat.SOURCE_GAMEPAD, Object.class, new Type[0]);
        RECORD = javaType21;
        JavaType javaType22 = new JavaType("OBJECT_METHODS", 21, "java.lang.runtime.ObjectMethods", 1, Object.class, new Type[0]);
        OBJECT_METHODS = javaType22;
        JavaType javaType23 = new JavaType("ACCESS_CONTROL_CONTEXT", 22, "java.security.AccessControlContext", 17, typeDescription, new TypeDefinition[0]);
        ACCESS_CONTROL_CONTEXT = javaType23;
        $VALUES = new JavaType[]{javaType, javaType2, javaType3, javaType4, javaType5, javaType6, javaType7, javaType8, javaType9, javaType10, javaType11, javaType12, javaType13, javaType14, javaType15, javaType16, javaType17, javaType18, javaType19, javaType20, javaType21, javaType22, javaType23};
    }

    private JavaType(String str, int i, @MaybeNull String str2, int i3, Type type, Type... typeArr) {
        this(str, i, str2, i3, type == null ? TypeDescription.Generic.UNDEFINED : TypeDefinition.Sort.describe(type), new TypeList.Generic.ForLoadedTypes(typeArr));
    }

    @CachedReturnPlugin.Enhance("available")
    private Boolean doIsAvailable() {
        Boolean bool;
        if (this.available != null) {
            bool = null;
        } else {
            try {
                load();
                bool = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                bool = Boolean.FALSE;
            }
        }
        if (bool == null) {
            return this.available;
        }
        this.available = bool;
        return bool;
    }

    public static JavaType valueOf(String str) {
        return (JavaType) Enum.valueOf(JavaType.class, str);
    }

    public static JavaType[] values() {
        return (JavaType[]) $VALUES.clone();
    }

    public TypeDescription getTypeStub() {
        return this.typeDescription;
    }

    public boolean isAvailable() {
        return doIsAvailable().booleanValue();
    }

    public boolean isInstance(Object obj) {
        if (!isAvailable()) {
            return false;
        }
        try {
            return load().isInstance(obj);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @CachedReturnPlugin.Enhance("loaded")
    public Class<?> load() {
        Class<?> cls = this.loaded != null ? null : Class.forName(this.typeDescription.getName(), false, ClassLoadingStrategy.BOOTSTRAP_LOADER);
        if (cls == null) {
            return this.loaded;
        }
        this.loaded = cls;
        return cls;
    }

    public TypeDescription loadAsDescription() {
        return TypeDescription.ForLoadedType.of(load());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private JavaType(String str, int i, @MaybeNull String str2, int i3, TypeDefinition typeDefinition, TypeDefinition... typeDefinitionArr) {
        TypeDescription.Generic genericAsGenericType;
        if (typeDefinition == null) {
            genericAsGenericType = TypeDescription.Generic.UNDEFINED;
        } else {
            genericAsGenericType = typeDefinition.asGenericType();
        }
        this(str, i, str2, i3, genericAsGenericType, new TypeList.Generic.Explicit(typeDefinitionArr));
    }

    private JavaType(String str, int i, @MaybeNull String str2, int i3, TypeDescription.Generic generic, TypeList.Generic generic2) {
        this.typeDescription = new LatentTypeWithSimpleName(str2, i3, generic, generic2);
    }
}
