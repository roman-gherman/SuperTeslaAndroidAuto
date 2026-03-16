package net.bytebuddy.utility;

import B2.b;
import com.android.multidex.ClassPathElement;
import com.google.protobuf.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
public interface JavaConstant {

    /* JADX INFO: renamed from: net.bytebuddy.utility.JavaConstant$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$bytebuddy$utility$JavaConstant$MethodHandle$HandleType;

        static {
            int[] iArr = new int[MethodHandle.HandleType.values().length];
            $SwitchMap$net$bytebuddy$utility$JavaConstant$MethodHandle$HandleType = iArr;
            try {
                iArr[MethodHandle.HandleType.GET_FIELD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$bytebuddy$utility$JavaConstant$MethodHandle$HandleType[MethodHandle.HandleType.GET_STATIC_FIELD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$bytebuddy$utility$JavaConstant$MethodHandle$HandleType[MethodHandle.HandleType.PUT_FIELD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$net$bytebuddy$utility$JavaConstant$MethodHandle$HandleType[MethodHandle.HandleType.PUT_STATIC_FIELD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class Dynamic implements JavaConstant {
        public static final String DEFAULT_NAME = "_";
        private final List<JavaConstant> arguments;
        private final MethodHandle bootstrap;
        private final String name;
        private final TypeDescription typeDescription;

        public Dynamic(String str, TypeDescription typeDescription, MethodHandle methodHandle, List<JavaConstant> list) {
            this.name = str;
            this.typeDescription = typeDescription;
            this.bootstrap = methodHandle;
            this.arguments = list;
        }

        public static Dynamic bootstrap(String str, Method method, Object... objArr) {
            return bootstrap(str, method, (List<?>) Arrays.asList(objArr));
        }

        public static JavaConstant ofArrayVarHandle(Class<?> cls) {
            return ofArrayVarHandle(TypeDescription.ForLoadedType.of(cls));
        }

        public static JavaConstant ofEnumeration(Enum<?> r12) {
            return ofEnumeration(new EnumerationDescription.ForLoadedEnumeration(r12));
        }

        public static Dynamic ofField(Field field) {
            return ofField(new FieldDescription.ForLoadedField(field));
        }

        public static Dynamic ofInvocation(Method method, Object... objArr) {
            return ofInvocation(method, (List<?>) Arrays.asList(objArr));
        }

        public static Dynamic ofNullConstant() {
            return new Dynamic(DEFAULT_NAME, TypeDescription.ForLoadedType.of(Object.class), new MethodHandle(MethodHandle.HandleType.INVOKE_STATIC, JavaType.CONSTANT_BOOTSTRAPS.getTypeStub(), "nullConstant", TypeDescription.ForLoadedType.of(Object.class), Arrays.asList(JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.ForLoadedType.of(String.class), TypeDescription.ForLoadedType.of(Class.class))), Collections.EMPTY_LIST);
        }

        public static JavaConstant ofPrimitiveType(Class<?> cls) {
            return ofPrimitiveType(TypeDescription.ForLoadedType.of(cls));
        }

        public static JavaConstant ofVarHandle(Field field) {
            return ofVarHandle(new FieldDescription.ForLoadedField(field));
        }

        @Override // net.bytebuddy.utility.JavaConstant
        public <T> T accept(Visitor<T> visitor) {
            return visitor.onDynamic(this);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Dynamic dynamic = (Dynamic) obj;
            if (this.name.equals(dynamic.name) && this.typeDescription.equals(dynamic.typeDescription) && this.bootstrap.equals(dynamic.bootstrap)) {
                return this.arguments.equals(dynamic.arguments);
            }
            return false;
        }

        public List<JavaConstant> getArguments() {
            return this.arguments;
        }

        public MethodHandle getBootstrap() {
            return this.bootstrap;
        }

        public String getName() {
            return this.name;
        }

        @Override // net.bytebuddy.utility.JavaConstant
        public TypeDescription getTypeDescription() {
            return this.typeDescription;
        }

        public int hashCode() {
            return this.arguments.hashCode() + ((this.bootstrap.hashCode() + a.i(this.typeDescription, this.name.hashCode() * 31, 31)) * 31);
        }

        @Override // net.bytebuddy.utility.JavaConstant
        public Object toDescription() {
            Object[] array = Simple.CONSTANT_DESC.toArray(this.arguments.size());
            for (int i = 0; i < array.length; i++) {
                array[i] = this.arguments.get(i).toDescription();
            }
            Simple.Dispatcher.OfDynamicConstantDesc ofDynamicConstantDesc = Simple.DYNAMIC_CONSTANT_DESC;
            Simple.Dispatcher.OfMethodHandleDesc ofMethodHandleDesc = Simple.METHOD_HANDLE_DESC;
            Object objValueOf = Simple.DIRECT_METHOD_HANDLE_DESC_KIND.valueOf(this.bootstrap.getHandleType().getIdentifier(), this.bootstrap.getOwnerType().isInterface());
            Simple.Dispatcher.OfClassDesc ofClassDesc = Simple.CLASS_DESC;
            return ofDynamicConstantDesc.ofCanonical(ofMethodHandleDesc.of(objValueOf, ofClassDesc.ofDescriptor(this.bootstrap.getOwnerType().getDescriptor()), this.bootstrap.getName(), this.bootstrap.getDescriptor()), getName(), ofClassDesc.ofDescriptor(this.typeDescription.getDescriptor()), array);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.bootstrap.getOwnerType().getSimpleName());
            sb.append("::");
            sb.append(this.bootstrap.getName());
            sb.append('(');
            sb.append(this.name.equals(DEFAULT_NAME) ? "" : this.name);
            sb.append(ClassPathElement.SEPARATOR_CHAR);
            boolean z6 = true;
            for (JavaConstant javaConstant : this.arguments) {
                if (z6) {
                    z6 = false;
                } else {
                    sb.append(',');
                }
                sb.append(javaConstant.toString());
            }
            sb.append(')');
            sb.append(this.typeDescription.getSimpleName());
            return sb.toString();
        }

        public JavaConstant withType(Class<?> cls) {
            return withType(TypeDescription.ForLoadedType.of(cls));
        }

        public static Dynamic bootstrap(String str, Method method, List<?> list) {
            return bootstrap(str, new MethodDescription.ForLoadedMethod(method), list);
        }

        public static JavaConstant ofArrayVarHandle(TypeDescription typeDescription) {
            if (!typeDescription.isArray()) {
                throw new IllegalArgumentException(a.m("Not an array type: ", typeDescription));
            }
            JavaType javaType = JavaType.VAR_HANDLE;
            return new Dynamic(DEFAULT_NAME, javaType.getTypeStub(), new MethodHandle(MethodHandle.HandleType.INVOKE_STATIC, JavaType.CONSTANT_BOOTSTRAPS.getTypeStub(), "arrayVarHandle", javaType.getTypeStub(), Arrays.asList(JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.ForLoadedType.of(String.class), TypeDescription.ForLoadedType.of(Class.class), TypeDescription.ForLoadedType.of(Class.class))), Collections.singletonList(Simple.of(typeDescription)));
        }

        public static JavaConstant ofEnumeration(EnumerationDescription enumerationDescription) {
            return new Dynamic(enumerationDescription.getValue(), enumerationDescription.getEnumerationType(), new MethodHandle(MethodHandle.HandleType.INVOKE_STATIC, JavaType.CONSTANT_BOOTSTRAPS.getTypeStub(), "enumConstant", TypeDescription.ForLoadedType.of(Enum.class), Arrays.asList(JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.ForLoadedType.of(String.class), TypeDescription.ForLoadedType.of(Class.class))), Collections.EMPTY_LIST);
        }

        public static Dynamic ofField(FieldDescription.InDefinedShape inDefinedShape) {
            if (inDefinedShape.isStatic() && inDefinedShape.isFinal()) {
                boolean zEquals = inDefinedShape.getType().isPrimitive() ? inDefinedShape.getType().asErasure().asBoxed().equals(inDefinedShape.getType().asErasure()) : inDefinedShape.getDeclaringType().equals(inDefinedShape.getType().asErasure());
                return new Dynamic(inDefinedShape.getInternalName(), inDefinedShape.getType().asErasure(), new MethodHandle(MethodHandle.HandleType.INVOKE_STATIC, JavaType.CONSTANT_BOOTSTRAPS.getTypeStub(), "getStaticFinal", TypeDescription.ForLoadedType.of(Object.class), zEquals ? Arrays.asList(JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.ForLoadedType.of(String.class), TypeDescription.ForLoadedType.of(Class.class)) : Arrays.asList(JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.ForLoadedType.of(String.class), TypeDescription.ForLoadedType.of(Class.class), TypeDescription.ForLoadedType.of(Class.class))), zEquals ? Collections.EMPTY_LIST : Collections.singletonList(Simple.of(inDefinedShape.getDeclaringType())));
            }
            throw new IllegalArgumentException("Field must be static and final: " + inDefinedShape);
        }

        public static Dynamic ofInvocation(Method method, List<?> list) {
            return ofInvocation(new MethodDescription.ForLoadedMethod(method), list);
        }

        public static JavaConstant ofPrimitiveType(TypeDescription typeDescription) {
            if (typeDescription.isPrimitive()) {
                return new Dynamic(typeDescription.getDescriptor(), TypeDescription.ForLoadedType.of(Class.class), new MethodHandle(MethodHandle.HandleType.INVOKE_STATIC, JavaType.CONSTANT_BOOTSTRAPS.getTypeStub(), "primitiveClass", TypeDescription.ForLoadedType.of(Class.class), Arrays.asList(JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.ForLoadedType.of(String.class), TypeDescription.ForLoadedType.of(Class.class))), Collections.EMPTY_LIST);
            }
            throw new IllegalArgumentException(a.m("Not a primitive type: ", typeDescription));
        }

        public static JavaConstant ofVarHandle(FieldDescription.InDefinedShape inDefinedShape) {
            String internalName = inDefinedShape.getInternalName();
            JavaType javaType = JavaType.VAR_HANDLE;
            return new Dynamic(internalName, javaType.getTypeStub(), new MethodHandle(MethodHandle.HandleType.INVOKE_STATIC, JavaType.CONSTANT_BOOTSTRAPS.getTypeStub(), inDefinedShape.isStatic() ? "staticFieldVarHandle" : "fieldVarHandle", javaType.getTypeStub(), Arrays.asList(JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.ForLoadedType.of(String.class), TypeDescription.ForLoadedType.of(Class.class), TypeDescription.ForLoadedType.of(Class.class), TypeDescription.ForLoadedType.of(Class.class))), Arrays.asList(Simple.of(inDefinedShape.getDeclaringType()), Simple.of(inDefinedShape.getType().asErasure())));
        }

        public JavaConstant withType(TypeDescription typeDescription) {
            if (typeDescription.represents(Void.TYPE)) {
                throw new IllegalArgumentException("Constant value cannot represent void");
            }
            if (!getBootstrap().getName().equals(MethodDescription.CONSTRUCTOR_INTERNAL_NAME) ? !typeDescription.asBoxed().isInHierarchyWith(getTypeDescription().asBoxed()) : !getTypeDescription().isAssignableTo(typeDescription)) {
                return new Dynamic(getName(), typeDescription, getBootstrap(), getArguments());
            }
            throw new IllegalArgumentException(typeDescription + " is not compatible with bootstrapped type " + getTypeDescription());
        }

        public static Dynamic bootstrap(String str, Constructor<?> constructor, Object... objArr) {
            return bootstrap(str, constructor, (List<?>) Arrays.asList(objArr));
        }

        public static Dynamic ofInvocation(Constructor<?> constructor, Object... objArr) {
            return ofInvocation(constructor, (List<?>) Arrays.asList(objArr));
        }

        public static Dynamic bootstrap(String str, Constructor<?> constructor, List<?> list) {
            return bootstrap(str, new MethodDescription.ForLoadedConstructor(constructor), list);
        }

        public static Dynamic ofInvocation(Constructor<?> constructor, List<?> list) {
            return ofInvocation(new MethodDescription.ForLoadedConstructor(constructor), list);
        }

        public static Dynamic bootstrap(String str, MethodDescription.InDefinedShape inDefinedShape, Object... objArr) {
            return bootstrap(str, inDefinedShape, (List<?>) Arrays.asList(objArr));
        }

        public static Dynamic ofInvocation(MethodDescription.InDefinedShape inDefinedShape, Object... objArr) {
            return ofInvocation(inDefinedShape, (List<?>) Arrays.asList(objArr));
        }

        public static Dynamic bootstrap(String str, MethodDescription.InDefinedShape inDefinedShape, List<?> list) {
            TypeDescription typeDescriptionAsErasure;
            if (str.length() != 0 && !str.contains(".")) {
                ArrayList arrayList = new ArrayList(list.size());
                ArrayList arrayList2 = new ArrayList(list.size());
                Iterator<?> it = list.iterator();
                while (it.hasNext()) {
                    JavaConstant javaConstantWrap = Simple.wrap(it.next());
                    arrayList.add(javaConstantWrap);
                    arrayList2.add(javaConstantWrap.getTypeDescription());
                }
                if (inDefinedShape.isConstantBootstrap(arrayList2)) {
                    if (inDefinedShape.isConstructor()) {
                        typeDescriptionAsErasure = inDefinedShape.getDeclaringType();
                    } else {
                        typeDescriptionAsErasure = inDefinedShape.getReturnType().asErasure();
                    }
                    return new Dynamic(str, typeDescriptionAsErasure, new MethodHandle(inDefinedShape.isConstructor() ? MethodHandle.HandleType.INVOKE_SPECIAL_CONSTRUCTOR : MethodHandle.HandleType.INVOKE_STATIC, inDefinedShape.getDeclaringType(), inDefinedShape.getInternalName(), inDefinedShape.getReturnType().asErasure(), inDefinedShape.getParameters().asTypeList().asErasures()), arrayList);
                }
                throw new IllegalArgumentException("Not a valid bootstrap method " + inDefinedShape + " for " + arrayList);
            }
            throw new IllegalArgumentException("Not a valid field name: ".concat(str));
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
        
            if ((r13.getParameters().size() + ((r13.isStatic() || r13.isConstructor()) ? 0 : 1)) <= (r14.size() + 1)) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0071, code lost:
        
            if ((r13.getParameters().size() + ((r13.isStatic() || r13.isConstructor()) ? 0 : 1)) == r14.size()) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0077, code lost:
        
            if (r13.isStatic() != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x007d, code lost:
        
            if (r13.isConstructor() == false) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0080, code lost:
        
            r2 = net.bytebuddy.utility.CompoundList.of(r13.getDeclaringType(), r13.getParameters().asTypeList().asErasures());
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0095, code lost:
        
            r2 = r13.getParameters().asTypeList().asErasures();
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00a5, code lost:
        
            if (r13.isVarArgs() == false) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00a7, code lost:
        
            r2 = net.bytebuddy.utility.CompoundList.of(r2.subList(0, r2.size() - 1), java.util.Collections.nCopies((r14.size() - r2.size()) + 1, ((net.bytebuddy.description.type.TypeDescription) B2.b.b(1, r2)).getComponentType())).iterator();
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00d1, code lost:
        
            r2 = r2.iterator();
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00d5, code lost:
        
            r5 = new java.util.ArrayList(r14.size() + 1);
            r5.add(net.bytebuddy.utility.JavaConstant.MethodHandle.of(r13));
            r6 = r14.iterator();
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00ee, code lost:
        
            if (r6.hasNext() == false) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00f0, code lost:
        
            r7 = net.bytebuddy.utility.JavaConstant.Simple.wrap(r6.next());
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0106, code lost:
        
            if (r7.getTypeDescription().isAssignableTo((net.bytebuddy.description.type.TypeDescription) r2.next()) == false) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0108, code lost:
        
            r5.add(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0123, code lost:
        
            throw new java.lang.IllegalArgumentException("Cannot assign " + r14 + " to " + r13);
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x012a, code lost:
        
            if (r13.isConstructor() == false) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x012c, code lost:
        
            r13 = r13.getDeclaringType();
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0131, code lost:
        
            r13 = r13.getReturnType().asErasure();
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0187, code lost:
        
            return new net.bytebuddy.utility.JavaConstant.Dynamic(net.bytebuddy.utility.JavaConstant.Dynamic.DEFAULT_NAME, r13, new net.bytebuddy.utility.JavaConstant.MethodHandle(net.bytebuddy.utility.JavaConstant.MethodHandle.HandleType.INVOKE_STATIC, net.bytebuddy.utility.JavaType.CONSTANT_BOOTSTRAPS.getTypeStub(), "invoke", net.bytebuddy.description.type.TypeDescription.ForLoadedType.of(java.lang.Object.class), java.util.Arrays.asList(net.bytebuddy.utility.JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), net.bytebuddy.description.type.TypeDescription.ForLoadedType.of(java.lang.String.class), net.bytebuddy.description.type.TypeDescription.ForLoadedType.of(java.lang.Class.class), net.bytebuddy.utility.JavaType.METHOD_HANDLE.getTypeStub(), net.bytebuddy.description.type.TypeDescription.ArrayProjection.of(net.bytebuddy.description.type.TypeDescription.ForLoadedType.of(java.lang.Object.class)))), r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x019f, code lost:
        
            throw new java.lang.IllegalArgumentException("Cannot assign " + r14 + " to " + r13);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static net.bytebuddy.utility.JavaConstant.Dynamic ofInvocation(net.bytebuddy.description.method.MethodDescription.InDefinedShape r13, java.util.List<?> r14) {
            /*
                Method dump skipped, instruction units count: 416
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.utility.JavaConstant.Dynamic.ofInvocation(net.bytebuddy.description.method.MethodDescription$InDefinedShape, java.util.List):net.bytebuddy.utility.JavaConstant$Dynamic");
        }
    }

    public static class MethodHandle implements JavaConstant {
        private static final boolean ACCESS_CONTROLLER;
        protected static final MethodHandles METHOD_HANDLES;
        protected static final MethodHandles.Lookup METHOD_HANDLES_LOOKUP;
        protected static final MethodHandleInfo METHOD_HANDLE_INFO;
        protected static final MethodType METHOD_TYPE;
        private final HandleType handleType;
        private final String name;
        private final TypeDescription ownerType;
        private final List<? extends TypeDescription> parameterTypes;
        private final TypeDescription returnType;

        @JavaDispatcher.Proxied("java.lang.invoke.MethodHandleInfo")
        public interface MethodHandleInfo {
            @JavaDispatcher.Proxied("getDeclaringClass")
            Class<?> getDeclaringClass(Object obj);

            @JavaDispatcher.Proxied("getMethodType")
            Object getMethodType(Object obj);

            @JavaDispatcher.Proxied("getName")
            String getName(Object obj);

            @JavaDispatcher.Proxied("getReferenceKind")
            int getReferenceKind(Object obj);

            @JavaDispatcher.IsConstructor
            @JavaDispatcher.Proxied("revealDirect")
            Object revealDirect(@JavaDispatcher.Proxied("java.lang.invoke.MethodHandle") Object obj);
        }

        @JavaDispatcher.Proxied("java.lang.invoke.MethodHandles")
        public interface MethodHandles {

            @JavaDispatcher.Proxied("java.lang.invoke.MethodHandles$Lookup")
            public interface Lookup {
                @JavaDispatcher.Proxied("lookupClass")
                Class<?> lookupClass(Object obj);

                @JavaDispatcher.Proxied("revealDirect")
                Object revealDirect(Object obj, @JavaDispatcher.Proxied("java.lang.invoke.MethodHandle") Object obj2);
            }

            @JavaDispatcher.IsStatic
            @JavaDispatcher.Proxied("publicLookup")
            Object publicLookup();
        }

        @JavaDispatcher.Proxied("java.lang.invoke.MethodType")
        public interface MethodType {
            @JavaDispatcher.Proxied("parameterArray")
            Class<?>[] parameterArray(Object obj);

            @JavaDispatcher.Proxied("returnType")
            Class<?> returnType(Object obj);
        }

        static {
            boolean z6 = false;
            try {
                Class.forName("java.security.AccessController", false, null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
            } catch (ClassNotFoundException unused) {
                ACCESS_CONTROLLER = z6;
            } catch (SecurityException unused2) {
                z6 = true;
                ACCESS_CONTROLLER = z6;
            }
            METHOD_HANDLE_INFO = (MethodHandleInfo) doPrivileged(JavaDispatcher.of(MethodHandleInfo.class));
            METHOD_TYPE = (MethodType) doPrivileged(JavaDispatcher.of(MethodType.class));
            METHOD_HANDLES = (MethodHandles) doPrivileged(JavaDispatcher.of(MethodHandles.class));
            METHOD_HANDLES_LOOKUP = (MethodHandles.Lookup) doPrivileged(JavaDispatcher.of(MethodHandles.Lookup.class));
        }

        public MethodHandle(HandleType handleType, TypeDescription typeDescription, String str, TypeDescription typeDescription2, List<? extends TypeDescription> list) {
            this.handleType = handleType;
            this.ownerType = typeDescription;
            this.name = str;
            this.returnType = typeDescription2;
            this.parameterTypes = list;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static Class<?> lookupType(Object obj) {
            return METHOD_HANDLES_LOOKUP.lookupClass(obj);
        }

        public static MethodHandle of(Method method) {
            return of(new MethodDescription.ForLoadedMethod(method));
        }

        public static MethodHandle ofGetter(Field field) {
            return ofGetter(new FieldDescription.ForLoadedField(field));
        }

        public static MethodHandle ofLoaded(Object obj) {
            return ofLoaded(obj, METHOD_HANDLES.publicLookup());
        }

        public static MethodHandle ofSetter(Field field) {
            return ofSetter(new FieldDescription.ForLoadedField(field));
        }

        public static MethodHandle ofSpecial(Method method, Class<?> cls) {
            return ofSpecial(new MethodDescription.ForLoadedMethod(method), TypeDescription.ForLoadedType.of(cls));
        }

        @Override // net.bytebuddy.utility.JavaConstant
        public <T> T accept(Visitor<T> visitor) {
            return visitor.onMethodHandle(this);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MethodHandle)) {
                return false;
            }
            MethodHandle methodHandle = (MethodHandle) obj;
            return this.handleType == methodHandle.handleType && this.name.equals(methodHandle.name) && this.ownerType.equals(methodHandle.ownerType) && this.parameterTypes.equals(methodHandle.parameterTypes) && this.returnType.equals(methodHandle.returnType);
        }

        public String getDescriptor() {
            int i = AnonymousClass1.$SwitchMap$net$bytebuddy$utility$JavaConstant$MethodHandle$HandleType[this.handleType.ordinal()];
            if (i == 1 || i == 2) {
                return this.returnType.getDescriptor();
            }
            if (i == 3 || i == 4) {
                return this.parameterTypes.get(0).getDescriptor();
            }
            StringBuilder sb = new StringBuilder("(");
            Iterator<? extends TypeDescription> it = this.parameterTypes.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getDescriptor());
            }
            sb.append(')');
            sb.append(this.returnType.getDescriptor());
            return sb.toString();
        }

        public HandleType getHandleType() {
            return this.handleType;
        }

        public String getName() {
            return this.name;
        }

        public TypeDescription getOwnerType() {
            return this.ownerType;
        }

        public TypeList getParameterTypes() {
            return new TypeList.Explicit(this.parameterTypes);
        }

        public TypeDescription getReturnType() {
            return this.returnType;
        }

        @Override // net.bytebuddy.utility.JavaConstant
        public TypeDescription getTypeDescription() {
            return JavaType.METHOD_HANDLE.getTypeStub();
        }

        public int hashCode() {
            return this.parameterTypes.hashCode() + a.i(this.returnType, androidx.constraintlayout.core.motion.a.c(a.i(this.ownerType, this.handleType.hashCode() * 31, 31), 31, this.name), 31);
        }

        @Override // net.bytebuddy.utility.JavaConstant
        public Object toDescription() {
            return Simple.METHOD_HANDLE_DESC.of(Simple.DIRECT_METHOD_HANDLE_DESC_KIND.valueOf(this.handleType.getIdentifier(), this.ownerType.isInterface()), Simple.CLASS_DESC.ofDescriptor(this.ownerType.getDescriptor()), this.name, getDescriptor());
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.handleType.name());
            sb.append((!this.ownerType.isInterface() || this.handleType.isField() || this.handleType == HandleType.INVOKE_INTERFACE) ? "" : "@interface");
            sb.append(ClassPathElement.SEPARATOR_CHAR);
            sb.append(this.ownerType.getSimpleName());
            sb.append("::");
            sb.append(this.name);
            sb.append('(');
            boolean z6 = true;
            for (TypeDescription typeDescription : this.parameterTypes) {
                if (z6) {
                    z6 = false;
                } else {
                    sb.append(',');
                }
                sb.append(typeDescription.getSimpleName());
            }
            sb.append(')');
            sb.append(this.returnType.getSimpleName());
            return sb.toString();
        }

        public static MethodHandle of(Constructor<?> constructor) {
            return of(new MethodDescription.ForLoadedConstructor(constructor));
        }

        public static MethodHandle ofGetter(FieldDescription.InDefinedShape inDefinedShape) {
            return new MethodHandle(HandleType.ofGetter(inDefinedShape), inDefinedShape.getDeclaringType().asErasure(), inDefinedShape.getInternalName(), inDefinedShape.getType().asErasure(), Collections.EMPTY_LIST);
        }

        public static MethodHandle ofLoaded(Object obj, Object obj2) {
            if (!JavaType.METHOD_HANDLE.isInstance(obj)) {
                throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.m(obj, "Expected method handle object: "));
            }
            if (!JavaType.METHOD_HANDLES_LOOKUP.isInstance(obj2)) {
                throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.m(obj2, "Expected method handle lookup object: "));
            }
            Object objRevealDirect = ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V8).isAtMost(ClassFileVersion.JAVA_V7) ? METHOD_HANDLE_INFO.revealDirect(obj) : METHOD_HANDLES_LOOKUP.revealDirect(obj2, obj);
            MethodHandleInfo methodHandleInfo = METHOD_HANDLE_INFO;
            Object methodType = methodHandleInfo.getMethodType(objRevealDirect);
            HandleType handleTypeOf = HandleType.of(methodHandleInfo.getReferenceKind(objRevealDirect));
            TypeDescription typeDescriptionOf = TypeDescription.ForLoadedType.of(methodHandleInfo.getDeclaringClass(objRevealDirect));
            String name = methodHandleInfo.getName(objRevealDirect);
            MethodType methodType2 = METHOD_TYPE;
            return new MethodHandle(handleTypeOf, typeDescriptionOf, name, TypeDescription.ForLoadedType.of(methodType2.returnType(methodType)), new TypeList.ForLoadedTypes(methodType2.parameterArray(methodType)));
        }

        public static MethodHandle ofSetter(FieldDescription.InDefinedShape inDefinedShape) {
            return new MethodHandle(HandleType.ofSetter(inDefinedShape), inDefinedShape.getDeclaringType().asErasure(), inDefinedShape.getInternalName(), TypeDescription.ForLoadedType.of(Void.TYPE), Collections.singletonList(inDefinedShape.getType().asErasure()));
        }

        public static MethodHandle ofSpecial(MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription) {
            if (inDefinedShape.isSpecializableFor(typeDescription)) {
                return new MethodHandle(HandleType.ofSpecial(inDefinedShape), typeDescription, inDefinedShape.getInternalName(), inDefinedShape.getReturnType().asErasure(), inDefinedShape.getParameters().asTypeList().asErasures());
            }
            throw new IllegalArgumentException("Cannot specialize " + inDefinedShape + " for " + typeDescription);
        }

        public static MethodHandle of(MethodDescription.InDefinedShape inDefinedShape) {
            return new MethodHandle(HandleType.of(inDefinedShape), inDefinedShape.getDeclaringType().asErasure(), inDefinedShape.getInternalName(), inDefinedShape.getReturnType().asErasure(), inDefinedShape.getParameters().asTypeList().asErasures());
        }

        public enum HandleType {
            INVOKE_VIRTUAL(5, false),
            INVOKE_STATIC(6, false),
            INVOKE_SPECIAL(7, false),
            INVOKE_INTERFACE(9, false),
            INVOKE_SPECIAL_CONSTRUCTOR(8, false),
            PUT_FIELD(3, true),
            GET_FIELD(1, true),
            PUT_STATIC_FIELD(4, true),
            GET_STATIC_FIELD(2, true);

            private final boolean field;
            private final int identifier;

            HandleType(int i, boolean z6) {
                this.identifier = i;
                this.field = z6;
            }

            public static HandleType of(MethodDescription.InDefinedShape inDefinedShape) {
                if (!inDefinedShape.isTypeInitializer()) {
                    return inDefinedShape.isStatic() ? INVOKE_STATIC : inDefinedShape.isConstructor() ? INVOKE_SPECIAL_CONSTRUCTOR : inDefinedShape.isPrivate() ? INVOKE_SPECIAL : inDefinedShape.getDeclaringType().isInterface() ? INVOKE_INTERFACE : INVOKE_VIRTUAL;
                }
                throw new IllegalArgumentException("Cannot create handle of type initializer " + inDefinedShape);
            }

            public static HandleType ofGetter(FieldDescription.InDefinedShape inDefinedShape) {
                return inDefinedShape.isStatic() ? GET_STATIC_FIELD : GET_FIELD;
            }

            public static HandleType ofSetter(FieldDescription.InDefinedShape inDefinedShape) {
                return inDefinedShape.isStatic() ? PUT_STATIC_FIELD : PUT_FIELD;
            }

            public static HandleType ofSpecial(MethodDescription.InDefinedShape inDefinedShape) {
                if (!inDefinedShape.isStatic() && !inDefinedShape.isAbstract()) {
                    return inDefinedShape.isConstructor() ? INVOKE_SPECIAL_CONSTRUCTOR : INVOKE_SPECIAL;
                }
                throw new IllegalArgumentException("Cannot invoke " + inDefinedShape + " via invokespecial");
            }

            public int getIdentifier() {
                return this.identifier;
            }

            public boolean isField() {
                return this.field;
            }

            public static HandleType of(int i) {
                for (HandleType handleType : values()) {
                    if (handleType.getIdentifier() == i) {
                        return handleType;
                    }
                }
                throw new IllegalArgumentException(b.c(i, "Unknown handle type: "));
            }
        }
    }

    public static class MethodType implements JavaConstant {
        private static final boolean ACCESS_CONTROLLER;
        private static final Dispatcher DISPATCHER;
        private final List<? extends TypeDescription> parameterTypes;
        private final TypeDescription returnType;

        @JavaDispatcher.Proxied("java.lang.invoke.MethodType")
        public interface Dispatcher {
            @JavaDispatcher.Proxied("parameterArray")
            Class<?>[] parameterArray(Object obj);

            @JavaDispatcher.Proxied("returnType")
            Class<?> returnType(Object obj);
        }

        static {
            boolean z6 = false;
            try {
                Class.forName("java.security.AccessController", false, null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
            } catch (ClassNotFoundException unused) {
                ACCESS_CONTROLLER = z6;
            } catch (SecurityException unused2) {
                z6 = true;
                ACCESS_CONTROLLER = z6;
            }
            DISPATCHER = (Dispatcher) doPrivileged(JavaDispatcher.of(Dispatcher.class));
        }

        public MethodType(TypeDescription typeDescription, List<? extends TypeDescription> list) {
            this.returnType = typeDescription;
            this.parameterTypes = list;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static MethodType of(Class<?> cls, Class<?>... clsArr) {
            return of(TypeDescription.ForLoadedType.of(cls), new TypeList.ForLoadedTypes(clsArr));
        }

        public static MethodType ofConstant(Object obj) {
            return ofConstant(obj.getClass());
        }

        public static MethodType ofGetter(Field field) {
            return ofGetter(new FieldDescription.ForLoadedField(field));
        }

        public static MethodType ofLoaded(Object obj) {
            if (!JavaType.METHOD_TYPE.isInstance(obj)) {
                throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.m(obj, "Expected method type object: "));
            }
            Dispatcher dispatcher = DISPATCHER;
            return of(dispatcher.returnType(obj), dispatcher.parameterArray(obj));
        }

        public static MethodType ofSetter(Field field) {
            return ofSetter(new FieldDescription.ForLoadedField(field));
        }

        @Override // net.bytebuddy.utility.JavaConstant
        public <T> T accept(Visitor<T> visitor) {
            return visitor.onMethodType(this);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MethodType)) {
                return false;
            }
            MethodType methodType = (MethodType) obj;
            return this.parameterTypes.equals(methodType.parameterTypes) && this.returnType.equals(methodType.returnType);
        }

        public String getDescriptor() {
            StringBuilder sb = new StringBuilder("(");
            Iterator<? extends TypeDescription> it = this.parameterTypes.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getDescriptor());
            }
            sb.append(')');
            sb.append(this.returnType.getDescriptor());
            return sb.toString();
        }

        public TypeList getParameterTypes() {
            return new TypeList.Explicit(this.parameterTypes);
        }

        public TypeDescription getReturnType() {
            return this.returnType;
        }

        @Override // net.bytebuddy.utility.JavaConstant
        public TypeDescription getTypeDescription() {
            return JavaType.METHOD_TYPE.getTypeStub();
        }

        public int hashCode() {
            return this.parameterTypes.hashCode() + (this.returnType.hashCode() * 31);
        }

        @Override // net.bytebuddy.utility.JavaConstant
        public Object toDescription() {
            Object[] array = Simple.CLASS_DESC.toArray(this.parameterTypes.size());
            for (int i = 0; i < this.parameterTypes.size(); i++) {
                array[i] = Simple.CLASS_DESC.ofDescriptor(this.parameterTypes.get(i).getDescriptor());
            }
            return Simple.METHOD_TYPE_DESC.of(Simple.CLASS_DESC.ofDescriptor(this.returnType.getDescriptor()), array);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("(");
            boolean z6 = true;
            for (TypeDescription typeDescription : this.parameterTypes) {
                if (z6) {
                    z6 = false;
                } else {
                    sb.append(',');
                }
                sb.append(typeDescription.getSimpleName());
            }
            sb.append(')');
            sb.append(this.returnType.getSimpleName());
            return sb.toString();
        }

        public static MethodType of(TypeDescription typeDescription, TypeDescription... typeDescriptionArr) {
            return new MethodType(typeDescription, Arrays.asList(typeDescriptionArr));
        }

        public static MethodType ofConstant(Class<?> cls) {
            return ofConstant(TypeDescription.ForLoadedType.of(cls));
        }

        public static MethodType ofGetter(FieldDescription fieldDescription) {
            return new MethodType(fieldDescription.getType().asErasure(), Collections.EMPTY_LIST);
        }

        public static MethodType ofSetter(FieldDescription fieldDescription) {
            return new MethodType(TypeDescription.ForLoadedType.of(Void.TYPE), Collections.singletonList(fieldDescription.getType().asErasure()));
        }

        public static MethodType of(TypeDescription typeDescription, List<? extends TypeDescription> list) {
            return new MethodType(typeDescription, list);
        }

        public static MethodType ofConstant(TypeDescription typeDescription) {
            return new MethodType(typeDescription, Collections.EMPTY_LIST);
        }

        public static MethodType of(Method method) {
            return of(new MethodDescription.ForLoadedMethod(method));
        }

        public static MethodType of(Constructor<?> constructor) {
            return of(new MethodDescription.ForLoadedConstructor(constructor));
        }

        public static MethodType of(MethodDescription methodDescription) {
            return new MethodType(methodDescription.getReturnType().asErasure(), methodDescription.getParameters().asTypeList().asErasures());
        }
    }

    public static abstract class Simple<T> implements JavaConstant {
        private static final boolean ACCESS_CONTROLLER;
        protected static final Dispatcher.OfClassDesc CLASS_DESC;
        protected static final Dispatcher CONSTANT_DESC;
        protected static final Dispatcher.OfDirectMethodHandleDesc DIRECT_METHOD_HANDLE_DESC;
        protected static final Dispatcher.OfDirectMethodHandleDesc.ForKind DIRECT_METHOD_HANDLE_DESC_KIND;
        protected static final Dispatcher.OfDynamicConstantDesc DYNAMIC_CONSTANT_DESC;
        protected static final Dispatcher.OfMethodHandleDesc METHOD_HANDLE_DESC;
        protected static final Dispatcher.OfMethodTypeDesc METHOD_TYPE_DESC;
        private final TypeDescription typeDescription;
        protected final T value;

        @JavaDispatcher.Proxied("java.lang.constant.ConstantDesc")
        public interface Dispatcher {

            @JavaDispatcher.Proxied("java.lang.constant.ClassDesc")
            public interface OfClassDesc extends Dispatcher {
                @JavaDispatcher.Proxied("descriptorString")
                String descriptorString(Object obj);

                @JavaDispatcher.IsStatic
                @JavaDispatcher.Proxied("ofDescriptor")
                Object ofDescriptor(String str);
            }

            @JavaDispatcher.Proxied("java.lang.constant.DirectMethodHandleDesc")
            public interface OfDirectMethodHandleDesc extends Dispatcher {

                @JavaDispatcher.Proxied("java.lang.constant.DirectMethodHandleDesc$Kind")
                public interface ForKind {
                    @JavaDispatcher.IsStatic
                    @JavaDispatcher.Proxied("valueOf")
                    Object valueOf(int i, boolean z6);
                }

                @JavaDispatcher.Proxied("lookupDescriptor")
                String lookupDescriptor(Object obj);

                @JavaDispatcher.Proxied("methodName")
                String methodName(Object obj);

                @JavaDispatcher.Proxied("owner")
                Object owner(Object obj);

                @JavaDispatcher.Proxied("refKind")
                int refKind(Object obj);
            }

            @JavaDispatcher.Proxied("java.lang.constant.DynamicConstantDesc")
            public interface OfDynamicConstantDesc extends Dispatcher {
                @JavaDispatcher.Proxied("bootstrapArgs")
                Object[] bootstrapArgs(Object obj);

                @JavaDispatcher.Proxied("bootstrapMethod")
                Object bootstrapMethod(Object obj);

                @JavaDispatcher.Proxied("constantName")
                String constantName(Object obj);

                @JavaDispatcher.Proxied("constantType")
                Object constantType(Object obj);

                @JavaDispatcher.IsStatic
                @JavaDispatcher.Proxied("ofCanonical")
                Object ofCanonical(@JavaDispatcher.Proxied("java.lang.constant.DirectMethodHandleDesc") Object obj, String str, @JavaDispatcher.Proxied("java.lang.constant.ClassDesc") Object obj2, @JavaDispatcher.Proxied("java.lang.constant.ConstantDesc") Object[] objArr);
            }

            @JavaDispatcher.Proxied("java.lang.constant.MethodHandleDesc")
            public interface OfMethodHandleDesc extends Dispatcher {
                @JavaDispatcher.Proxied("invocationType")
                Object invocationType(Object obj);

                @JavaDispatcher.IsStatic
                @JavaDispatcher.Proxied("of")
                Object of(@JavaDispatcher.Proxied("java.lang.constant.DirectMethodHandleDesc$Kind") Object obj, @JavaDispatcher.Proxied("java.lang.constant.ClassDesc") Object obj2, String str, String str2);
            }

            @JavaDispatcher.Proxied("java.lang.constant.MethodTypeDesc")
            public interface OfMethodTypeDesc extends Dispatcher {
                @JavaDispatcher.IsStatic
                @JavaDispatcher.Proxied("of")
                Object of(@JavaDispatcher.Proxied("java.lang.constant.ClassDesc") Object obj, @JavaDispatcher.Proxied("java.lang.constant.ClassDesc") Object[] objArr);

                @JavaDispatcher.IsStatic
                @JavaDispatcher.Proxied("ofDescriptor")
                Object ofDescriptor(String str);

                @JavaDispatcher.Proxied("parameterArray")
                Object[] parameterArray(Object obj);

                @JavaDispatcher.Proxied("returnType")
                Object returnType(Object obj);
            }

            @JavaDispatcher.Instance
            @JavaDispatcher.Proxied("isInstance")
            boolean isInstance(Object obj);

            @JavaDispatcher.Container
            @JavaDispatcher.Proxied("toArray")
            Object[] toArray(int i);
        }

        public static class OfTrivialValue<S> extends Simple<S> {
            public OfTrivialValue(S s3, TypeDescription typeDescription) {
                super(s3, typeDescription);
            }

            @Override // net.bytebuddy.utility.JavaConstant
            public <T> T accept(Visitor<T> visitor) {
                return visitor.onValue(this);
            }

            @Override // net.bytebuddy.utility.JavaConstant
            public Object toDescription() {
                return this.value;
            }
        }

        public static class OfTypeDescription extends Simple<TypeDescription> {
            public OfTypeDescription(TypeDescription typeDescription) {
                super(typeDescription, TypeDescription.ForLoadedType.of(Class.class));
            }

            @Override // net.bytebuddy.utility.JavaConstant
            public <T> T accept(Visitor<T> visitor) {
                return visitor.onType(this);
            }

            @Override // net.bytebuddy.utility.JavaConstant
            public Object toDescription() {
                return Simple.CLASS_DESC.ofDescriptor(((TypeDescription) this.value).getDescriptor());
            }
        }

        static {
            boolean z6 = false;
            try {
                Class.forName("java.security.AccessController", false, null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
            } catch (ClassNotFoundException unused) {
                ACCESS_CONTROLLER = z6;
            } catch (SecurityException unused2) {
                z6 = true;
                ACCESS_CONTROLLER = z6;
            }
            CONSTANT_DESC = (Dispatcher) doPrivileged(JavaDispatcher.of(Dispatcher.class));
            CLASS_DESC = (Dispatcher.OfClassDesc) doPrivileged(JavaDispatcher.of(Dispatcher.OfClassDesc.class));
            METHOD_TYPE_DESC = (Dispatcher.OfMethodTypeDesc) doPrivileged(JavaDispatcher.of(Dispatcher.OfMethodTypeDesc.class));
            METHOD_HANDLE_DESC = (Dispatcher.OfMethodHandleDesc) doPrivileged(JavaDispatcher.of(Dispatcher.OfMethodHandleDesc.class));
            DIRECT_METHOD_HANDLE_DESC = (Dispatcher.OfDirectMethodHandleDesc) doPrivileged(JavaDispatcher.of(Dispatcher.OfDirectMethodHandleDesc.class));
            DIRECT_METHOD_HANDLE_DESC_KIND = (Dispatcher.OfDirectMethodHandleDesc.ForKind) doPrivileged(JavaDispatcher.of(Dispatcher.OfDirectMethodHandleDesc.ForKind.class));
            DYNAMIC_CONSTANT_DESC = (Dispatcher.OfDynamicConstantDesc) doPrivileged(JavaDispatcher.of(Dispatcher.OfDynamicConstantDesc.class));
        }

        public Simple(T t6, TypeDescription typeDescription) {
            this.value = t6;
            this.typeDescription = typeDescription;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static JavaConstant of(TypeDescription typeDescription) {
            if (typeDescription.isPrimitive()) {
                throw new IllegalArgumentException(a.m("A primitive type cannot be represented as a type constant: ", typeDescription));
            }
            return new OfTypeDescription(typeDescription);
        }

        public static JavaConstant ofDescription(Object obj, @MaybeNull ClassLoader classLoader) {
            return ofDescription(obj, ClassFileLocator.ForClassLoader.of(classLoader));
        }

        public static JavaConstant ofLoaded(Object obj) {
            if (obj instanceof Integer) {
                return new OfTrivialValue((Integer) obj, TypeDescription.ForLoadedType.of(Integer.TYPE));
            }
            if (obj instanceof Long) {
                return new OfTrivialValue((Long) obj, TypeDescription.ForLoadedType.of(Long.TYPE));
            }
            if (obj instanceof Float) {
                return new OfTrivialValue((Float) obj, TypeDescription.ForLoadedType.of(Float.TYPE));
            }
            if (obj instanceof Double) {
                return new OfTrivialValue((Double) obj, TypeDescription.ForLoadedType.of(Double.TYPE));
            }
            if (obj instanceof String) {
                return new OfTrivialValue((String) obj, TypeDescription.ForLoadedType.of(String.class));
            }
            if (obj instanceof Class) {
                return of(TypeDescription.ForLoadedType.of((Class) obj));
            }
            if (JavaType.METHOD_HANDLE.isInstance(obj)) {
                return MethodHandle.ofLoaded(obj);
            }
            if (JavaType.METHOD_TYPE.isInstance(obj)) {
                return MethodType.ofLoaded(obj);
            }
            throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.m(obj, "Not a loaded Java constant value: "));
        }

        public static JavaConstant wrap(Object obj) {
            return obj instanceof JavaConstant ? (JavaConstant) obj : obj instanceof TypeDescription ? of((TypeDescription) obj) : ofLoaded(obj);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.value.equals(((Simple) obj).value);
        }

        @Override // net.bytebuddy.utility.JavaConstant
        public TypeDescription getTypeDescription() {
            return this.typeDescription;
        }

        public T getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return this.value.toString();
        }

        public static JavaConstant ofDescription(Object obj, ClassFileLocator classFileLocator) {
            return ofDescription(obj, TypePool.Default.WithLazyResolution.of(classFileLocator));
        }

        public static JavaConstant ofDescription(Object obj, TypePool typePool) {
            String className;
            String className2;
            String className3;
            TypeDescription typeDescriptionResolve;
            String className4;
            String className5;
            String className6;
            String className7;
            if (obj instanceof Integer) {
                return new OfTrivialValue((Integer) obj, TypeDescription.ForLoadedType.of(Integer.TYPE));
            }
            if (obj instanceof Long) {
                return new OfTrivialValue((Long) obj, TypeDescription.ForLoadedType.of(Long.TYPE));
            }
            if (obj instanceof Float) {
                return new OfTrivialValue((Float) obj, TypeDescription.ForLoadedType.of(Float.TYPE));
            }
            if (obj instanceof Double) {
                return new OfTrivialValue((Double) obj, TypeDescription.ForLoadedType.of(Double.TYPE));
            }
            if (obj instanceof String) {
                return new OfTrivialValue((String) obj, TypeDescription.ForLoadedType.of(String.class));
            }
            Dispatcher.OfClassDesc ofClassDesc = CLASS_DESC;
            if (ofClassDesc.isInstance(obj)) {
                Type type = Type.getType(ofClassDesc.descriptorString(obj));
                if (type.getSort() == 9) {
                    className7 = type.getInternalName().replace(ClassPathElement.SEPARATOR_CHAR, TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                } else {
                    className7 = type.getClassName();
                }
                return of(typePool.describe(className7).resolve());
            }
            Dispatcher.OfMethodTypeDesc ofMethodTypeDesc = METHOD_TYPE_DESC;
            int i = 0;
            if (ofMethodTypeDesc.isInstance(obj)) {
                Object[] objArrParameterArray = ofMethodTypeDesc.parameterArray(obj);
                ArrayList arrayList = new ArrayList(objArrParameterArray.length);
                int length = objArrParameterArray.length;
                while (i < length) {
                    Type type2 = Type.getType(CLASS_DESC.descriptorString(objArrParameterArray[i]));
                    if (type2.getSort() == 9) {
                        className6 = type2.getInternalName().replace(ClassPathElement.SEPARATOR_CHAR, TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                    } else {
                        className6 = type2.getClassName();
                    }
                    arrayList.add(typePool.describe(className6).resolve());
                    i++;
                }
                Type type3 = Type.getType(CLASS_DESC.descriptorString(METHOD_TYPE_DESC.returnType(obj)));
                if (type3.getSort() == 9) {
                    className5 = type3.getInternalName().replace(ClassPathElement.SEPARATOR_CHAR, TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                } else {
                    className5 = type3.getClassName();
                }
                return MethodType.of(typePool.describe(className5).resolve(), arrayList);
            }
            Dispatcher.OfDirectMethodHandleDesc ofDirectMethodHandleDesc = DIRECT_METHOD_HANDLE_DESC;
            if (ofDirectMethodHandleDesc.isInstance(obj)) {
                Object[] objArrParameterArray2 = ofMethodTypeDesc.parameterArray(METHOD_HANDLE_DESC.invocationType(obj));
                ArrayList arrayList2 = new ArrayList(objArrParameterArray2.length);
                int length2 = objArrParameterArray2.length;
                while (i < length2) {
                    Type type4 = Type.getType(CLASS_DESC.descriptorString(objArrParameterArray2[i]));
                    if (type4.getSort() == 9) {
                        className4 = type4.getInternalName().replace(ClassPathElement.SEPARATOR_CHAR, TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                    } else {
                        className4 = type4.getClassName();
                    }
                    arrayList2.add(typePool.describe(className4).resolve());
                    i++;
                }
                Dispatcher.OfClassDesc ofClassDesc2 = CLASS_DESC;
                Type type5 = Type.getType(ofClassDesc2.descriptorString(METHOD_TYPE_DESC.returnType(METHOD_HANDLE_DESC.invocationType(obj))));
                Dispatcher.OfDirectMethodHandleDesc ofDirectMethodHandleDesc2 = DIRECT_METHOD_HANDLE_DESC;
                MethodHandle.HandleType handleTypeOf = MethodHandle.HandleType.of(ofDirectMethodHandleDesc2.refKind(obj));
                TypeDescription typeDescriptionResolve2 = typePool.describe(Type.getType(ofClassDesc2.descriptorString(ofDirectMethodHandleDesc2.owner(obj))).getClassName()).resolve();
                String strMethodName = ofDirectMethodHandleDesc2.methodName(obj);
                if (ofDirectMethodHandleDesc2.refKind(obj) == 8) {
                    typeDescriptionResolve = TypeDescription.ForLoadedType.of(Void.TYPE);
                } else {
                    typeDescriptionResolve = typePool.describe(type5.getSort() == 9 ? type5.getInternalName().replace(ClassPathElement.SEPARATOR_CHAR, TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH) : type5.getClassName()).resolve();
                }
                return new MethodHandle(handleTypeOf, typeDescriptionResolve2, strMethodName, typeDescriptionResolve, arrayList2);
            }
            Dispatcher.OfDynamicConstantDesc ofDynamicConstantDesc = DYNAMIC_CONSTANT_DESC;
            if (ofDynamicConstantDesc.isInstance(obj)) {
                Type methodType = Type.getMethodType(ofDirectMethodHandleDesc.lookupDescriptor(ofDynamicConstantDesc.bootstrapMethod(obj)));
                ArrayList arrayList3 = new ArrayList(methodType.getArgumentTypes().length);
                for (Type type6 : methodType.getArgumentTypes()) {
                    if (type6.getSort() == 9) {
                        className3 = type6.getInternalName().replace(ClassPathElement.SEPARATOR_CHAR, TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                    } else {
                        className3 = type6.getClassName();
                    }
                    arrayList3.add(typePool.describe(className3).resolve());
                }
                Object[] objArrBootstrapArgs = DYNAMIC_CONSTANT_DESC.bootstrapArgs(obj);
                ArrayList arrayList4 = new ArrayList(objArrBootstrapArgs.length);
                int length3 = objArrBootstrapArgs.length;
                while (i < length3) {
                    arrayList4.add(ofDescription(objArrBootstrapArgs[i], typePool));
                    i++;
                }
                Dispatcher.OfClassDesc ofClassDesc3 = CLASS_DESC;
                Dispatcher.OfDynamicConstantDesc ofDynamicConstantDesc2 = DYNAMIC_CONSTANT_DESC;
                Type type7 = Type.getType(ofClassDesc3.descriptorString(ofDynamicConstantDesc2.constantType(obj)));
                String strConstantName = ofDynamicConstantDesc2.constantName(obj);
                if (type7.getSort() == 9) {
                    className = type7.getInternalName().replace(ClassPathElement.SEPARATOR_CHAR, TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                } else {
                    className = type7.getClassName();
                }
                TypeDescription typeDescriptionResolve3 = typePool.describe(className).resolve();
                Dispatcher.OfDirectMethodHandleDesc ofDirectMethodHandleDesc3 = DIRECT_METHOD_HANDLE_DESC;
                MethodHandle.HandleType handleTypeOf2 = MethodHandle.HandleType.of(ofDirectMethodHandleDesc3.refKind(ofDynamicConstantDesc2.bootstrapMethod(obj)));
                TypeDescription typeDescriptionResolve4 = typePool.describe(Type.getType(ofClassDesc3.descriptorString(ofDirectMethodHandleDesc3.owner(ofDynamicConstantDesc2.bootstrapMethod(obj)))).getClassName()).resolve();
                String strMethodName2 = ofDirectMethodHandleDesc3.methodName(ofDynamicConstantDesc2.bootstrapMethod(obj));
                if (methodType.getReturnType().getSort() == 9) {
                    className2 = methodType.getReturnType().getInternalName().replace(ClassPathElement.SEPARATOR_CHAR, TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                } else {
                    className2 = methodType.getReturnType().getClassName();
                }
                return new Dynamic(strConstantName, typeDescriptionResolve3, new MethodHandle(handleTypeOf2, typeDescriptionResolve4, strMethodName2, typePool.describe(className2).resolve(), arrayList3), arrayList4);
            }
            throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.m(obj, "Not a resolvable constant description or not expressible as a constant pool value: "));
        }

        public static List<JavaConstant> wrap(List<?> list) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(wrap(it.next()));
            }
            return arrayList;
        }
    }

    public interface Visitor<T> {

        public enum NoOp implements Visitor<JavaConstant> {
            INSTANCE;

            @Override // net.bytebuddy.utility.JavaConstant.Visitor
            public JavaConstant onDynamic(Dynamic dynamic) {
                return dynamic;
            }

            @Override // net.bytebuddy.utility.JavaConstant.Visitor
            public JavaConstant onMethodHandle(MethodHandle methodHandle) {
                return methodHandle;
            }

            @Override // net.bytebuddy.utility.JavaConstant.Visitor
            public JavaConstant onMethodType(MethodType methodType) {
                return methodType;
            }

            @Override // net.bytebuddy.utility.JavaConstant.Visitor
            /* JADX INFO: renamed from: onType, reason: avoid collision after fix types in other method */
            public JavaConstant onType2(Simple<TypeDescription> simple) {
                return simple;
            }

            @Override // net.bytebuddy.utility.JavaConstant.Visitor
            /* JADX INFO: renamed from: onValue, reason: avoid collision after fix types in other method */
            public JavaConstant onValue2(Simple<?> simple) {
                return simple;
            }

            @Override // net.bytebuddy.utility.JavaConstant.Visitor
            public /* bridge */ /* synthetic */ JavaConstant onType(Simple simple) {
                return onType2((Simple<TypeDescription>) simple);
            }

            @Override // net.bytebuddy.utility.JavaConstant.Visitor
            public /* bridge */ /* synthetic */ JavaConstant onValue(Simple simple) {
                return onValue2((Simple<?>) simple);
            }
        }

        T onDynamic(Dynamic dynamic);

        T onMethodHandle(MethodHandle methodHandle);

        T onMethodType(MethodType methodType);

        T onType(Simple<TypeDescription> simple);

        T onValue(Simple<?> simple);
    }

    <T> T accept(Visitor<T> visitor);

    TypeDescription getTypeDescription();

    Object toDescription();
}
