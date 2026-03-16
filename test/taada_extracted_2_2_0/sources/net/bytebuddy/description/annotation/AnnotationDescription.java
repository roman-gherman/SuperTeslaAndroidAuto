package net.bytebuddy.description.annotation;

import androidx.constraintlayout.core.motion.a;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.annotation.Annotation;
import java.lang.annotation.AnnotationTypeMismatchException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.IncompleteAnnotationException;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.privilege.SetAccessibleAction;

/* JADX INFO: loaded from: classes2.dex */
public interface AnnotationDescription {

    @AlwaysNull
    public static final Loadable<?> UNDEFINED = null;

    public static abstract class AbstractBase implements AnnotationDescription {
        private static final Set<ElementType> DEFAULT_TARGET = new HashSet();
        private static final MethodDescription.InDefinedShape RETENTION_VALUE;
        private static final MethodDescription.InDefinedShape TARGET_VALUE;
        private transient /* synthetic */ int hashCode;

        static {
            for (ElementType elementType : ElementType.values()) {
                if (!elementType.name().equals("TYPE_PARAMETER")) {
                    DEFAULT_TARGET.add(elementType);
                }
            }
            RETENTION_VALUE = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType.of(Retention.class).getDeclaredMethods().filter(ElementMatchers.named("value")).getOnly();
            TARGET_VALUE = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType.of(Target.class).getDeclaredMethods().filter(ElementMatchers.named("value")).getOnly();
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AnnotationDescription)) {
                return false;
            }
            AnnotationDescription annotationDescription = (AnnotationDescription) obj;
            TypeDescription annotationType = getAnnotationType();
            if (!annotationDescription.getAnnotationType().equals(annotationType)) {
                return false;
            }
            for (MethodDescription.InDefinedShape inDefinedShape : annotationType.getDeclaredMethods()) {
                if (!getValue(inDefinedShape).equals(annotationDescription.getValue(inDefinedShape))) {
                    return false;
                }
            }
            return true;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationDescription
        public Set<ElementType> getElementTypes() {
            Loadable loadableOfType = getAnnotationType().getDeclaredAnnotations().ofType(Target.class);
            return loadableOfType == null ? Collections.unmodifiableSet(DEFAULT_TARGET) : new HashSet(Arrays.asList((Object[]) loadableOfType.getValue(TARGET_VALUE).load(ClassLoadingStrategy.BOOTSTRAP_LOADER).resolve(ElementType[].class)));
        }

        @Override // net.bytebuddy.description.annotation.AnnotationDescription
        public RetentionPolicy getRetention() {
            Loadable loadableOfType = getAnnotationType().getDeclaredAnnotations().ofType(Retention.class);
            return loadableOfType == null ? RetentionPolicy.CLASS : (RetentionPolicy) loadableOfType.getValue(RETENTION_VALUE).load(ClassLoadingStrategy.BOOTSTRAP_LOADER).resolve(RetentionPolicy.class);
        }

        @Override // net.bytebuddy.description.annotation.AnnotationDescription
        public AnnotationValue<?, ?> getValue(String str) {
            MethodList methodListFilter = getAnnotationType().getDeclaredMethods().filter(ElementMatchers.named(str).and(ElementMatchers.takesArguments(0)).and(ElementMatchers.isPublic()).and(ElementMatchers.not(ElementMatchers.isStatic())));
            if (methodListFilter.size() == 1) {
                return getValue((MethodDescription.InDefinedShape) methodListFilter.getOnly());
            }
            throw new IllegalArgumentException("Unknown property of " + getAnnotationType() + ": " + str);
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int iHashCode = 0;
            if (this.hashCode == 0) {
                Iterator<MethodDescription.InDefinedShape> it = getAnnotationType().getDeclaredMethods().iterator();
                while (it.hasNext()) {
                    iHashCode += getValue(it.next()).hashCode() * 31;
                }
            }
            if (iHashCode == 0) {
                return this.hashCode;
            }
            this.hashCode = iHashCode;
            return iHashCode;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationDescription
        public boolean isDocumented() {
            return getAnnotationType().getDeclaredAnnotations().isAnnotationPresent(Documented.class);
        }

        @Override // net.bytebuddy.description.annotation.AnnotationDescription
        public boolean isInherited() {
            return getAnnotationType().getDeclaredAnnotations().isAnnotationPresent(Inherited.class);
        }

        @Override // net.bytebuddy.description.annotation.AnnotationDescription
        public boolean isSupportedOn(ElementType elementType) {
            return isSupportedOn(elementType.name());
        }

        public String toString() {
            TypeDescription annotationType = getAnnotationType();
            StringBuilder sb = new StringBuilder();
            sb.append('@');
            RenderingDispatcher.CURRENT.appendType(sb, annotationType);
            sb.append('(');
            boolean z6 = true;
            for (MethodDescription.InDefinedShape inDefinedShape : annotationType.getDeclaredMethods()) {
                AnnotationValue<?, ?> value = getValue(inDefinedShape);
                if (value.getState() != AnnotationValue.State.UNDEFINED) {
                    if (z6) {
                        z6 = false;
                    } else {
                        sb.append(", ");
                    }
                    RenderingDispatcher.CURRENT.appendPrefix(sb, inDefinedShape.getName(), annotationType.getDeclaredMethods().size());
                    sb.append(value);
                }
            }
            sb.append(')');
            return sb.toString();
        }

        @Override // net.bytebuddy.description.annotation.AnnotationDescription
        public boolean isSupportedOn(String str) {
            Loadable loadableOfType = getAnnotationType().getDeclaredAnnotations().ofType(Target.class);
            if (loadableOfType != null) {
                for (EnumerationDescription enumerationDescription : (EnumerationDescription[]) loadableOfType.getValue(TARGET_VALUE).resolve(EnumerationDescription[].class)) {
                    if (enumerationDescription.getValue().equals(str)) {
                        return true;
                    }
                }
            } else {
                if (str.equals("TYPE_USE")) {
                    return true;
                }
                Iterator<ElementType> it = DEFAULT_TARGET.iterator();
                while (it.hasNext()) {
                    if (it.next().name().equals(str)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static class AnnotationInvocationHandler<T extends Annotation> implements InvocationHandler {
        private static final String ANNOTATION_TYPE = "annotationType";
        private static final String EQUALS = "equals";
        private static final String HASH_CODE = "hashCode";
        private static final Object[] NO_ARGUMENT = new Object[0];
        private static final String TO_STRING = "toString";
        private final Class<? extends Annotation> annotationType;
        private transient /* synthetic */ int hashCode;
        private final LinkedHashMap<Method, AnnotationValue.Loaded<?>> values;

        /* JADX WARN: Multi-variable type inference failed */
        public AnnotationInvocationHandler(Class<T> cls, LinkedHashMap<Method, AnnotationValue.Loaded<?>> linkedHashMap) {
            this.annotationType = cls;
            this.values = linkedHashMap;
        }

        private boolean equalsRepresentation(Object obj, Object obj2) {
            if (obj == obj2) {
                return true;
            }
            if (!this.annotationType.isInstance(obj2)) {
                return false;
            }
            if (Proxy.isProxyClass(obj2.getClass())) {
                InvocationHandler invocationHandler = Proxy.getInvocationHandler(obj2);
                if (invocationHandler instanceof AnnotationInvocationHandler) {
                    return invocationHandler.equals(this);
                }
            }
            try {
                for (Map.Entry<Method, AnnotationValue.Loaded<?>> entry : this.values.entrySet()) {
                    try {
                        if (!entry.getValue().represents(entry.getKey().invoke(obj2, NO_ARGUMENT))) {
                            return false;
                        }
                    } catch (RuntimeException unused) {
                        return false;
                    }
                }
                return true;
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Could not access annotation property", e);
            } catch (InvocationTargetException unused2) {
                return false;
            }
        }

        private int hashCodeRepresentation() {
            int iHashCode = 0;
            for (Map.Entry<Method, AnnotationValue.Loaded<?>> entry : this.values.entrySet()) {
                if (entry.getValue().getState().isDefined()) {
                    iHashCode += entry.getValue().hashCode() ^ (entry.getKey().getName().hashCode() * 127);
                }
            }
            return iHashCode;
        }

        public static <S extends Annotation> S of(@MaybeNull ClassLoader classLoader, Class<S> cls, Map<String, ? extends AnnotationValue<?, ?>> map) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Method method : cls.getDeclaredMethods()) {
                AnnotationValue<?, ?> annotationValue = map.get(method.getName());
                if (annotationValue == null) {
                    Object defaultValue = method.getDefaultValue();
                    linkedHashMap.put(method, (defaultValue == null ? new AnnotationValue.ForMissingValue(new TypeDescription.ForLoadedType(method.getDeclaringClass()), method.getName()) : ForLoadedAnnotation.asValue(defaultValue, method.getReturnType())).load(classLoader));
                } else {
                    linkedHashMap.put(method, annotationValue.filter(new MethodDescription.ForLoadedMethod(method)).load(classLoader));
                }
            }
            return (S) Proxy.newProxyInstance(classLoader, new Class[]{cls}, new AnnotationInvocationHandler(cls, linkedHashMap));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AnnotationInvocationHandler)) {
                return false;
            }
            AnnotationInvocationHandler annotationInvocationHandler = (AnnotationInvocationHandler) obj;
            if (!this.annotationType.equals(annotationInvocationHandler.annotationType)) {
                return false;
            }
            for (Map.Entry<Method, AnnotationValue.Loaded<?>> entry : this.values.entrySet()) {
                if (!entry.getValue().equals(annotationInvocationHandler.values.get(entry.getKey()))) {
                    return false;
                }
            }
            return true;
        }

        @CachedReturnPlugin.Enhance(HASH_CODE)
        public int hashCode() {
            int i;
            if (this.hashCode != 0) {
                i = 0;
            } else {
                int iHashCode = this.values.hashCode() + (this.annotationType.hashCode() * 31);
                Iterator<Map.Entry<Method, AnnotationValue.Loaded<?>>> it = this.values.entrySet().iterator();
                while (it.hasNext()) {
                    iHashCode = (iHashCode * 31) + it.next().getValue().hashCode();
                }
                i = iHashCode;
            }
            if (i == 0) {
                return this.hashCode;
            }
            this.hashCode = i;
            return i;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, @MaybeNull Object[] objArr) {
            if (method.getDeclaringClass() == this.annotationType) {
                return this.values.get(method).resolve();
            }
            if (method.getName().equals(HASH_CODE)) {
                return Integer.valueOf(hashCodeRepresentation());
            }
            if (method.getName().equals(EQUALS) && method.getParameterTypes().length == 1) {
                return Boolean.valueOf(equalsRepresentation(obj, objArr[0]));
            }
            if (method.getName().equals(TO_STRING)) {
                return toStringRepresentation();
            }
            if (method.getName().equals(ANNOTATION_TYPE)) {
                return this.annotationType;
            }
            throw new IllegalStateException("Unexpected method: " + method);
        }

        public String toStringRepresentation() {
            StringBuilder sb = new StringBuilder();
            sb.append('@');
            RenderingDispatcher.CURRENT.appendType(sb, TypeDescription.ForLoadedType.of(this.annotationType));
            sb.append('(');
            boolean z6 = true;
            for (Map.Entry<Method, AnnotationValue.Loaded<?>> entry : this.values.entrySet()) {
                if (entry.getValue().getState().isDefined()) {
                    if (z6) {
                        z6 = false;
                    } else {
                        sb.append(", ");
                    }
                    RenderingDispatcher.CURRENT.appendPrefix(sb, entry.getKey().getName(), this.values.entrySet().size());
                    sb.append(entry.getValue().toString());
                }
            }
            sb.append(')');
            return sb.toString();
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Builder {
        private final TypeDescription annotationType;
        private final Map<String, AnnotationValue<?, ?>> annotationValues;

        public Builder(TypeDescription typeDescription, Map<String, AnnotationValue<?, ?>> map) {
            this.annotationType = typeDescription;
            this.annotationValues = map;
        }

        public static Builder ofType(Class<? extends Annotation> cls) {
            return ofType(TypeDescription.ForLoadedType.of(cls));
        }

        public AnnotationDescription build() {
            for (MethodDescription.InDefinedShape inDefinedShape : this.annotationType.getDeclaredMethods()) {
                AnnotationValue<?, ?> annotationValue = this.annotationValues.get(inDefinedShape.getName());
                if (annotationValue == null && inDefinedShape.getDefaultValue() == null) {
                    throw new IllegalStateException("No value or default value defined for " + inDefinedShape.getName());
                }
                if (annotationValue != null && annotationValue.filter(inDefinedShape).getState() != AnnotationValue.State.RESOLVED) {
                    throw new IllegalStateException("Illegal annotation value for " + inDefinedShape + ": " + annotationValue);
                }
            }
            return new Latent(this.annotationType, this.annotationValues);
        }

        public Builder define(String str, AnnotationValue<?, ?> annotationValue) {
            MethodList methodListFilter = this.annotationType.getDeclaredMethods().filter(ElementMatchers.named(str));
            if (!methodListFilter.isEmpty()) {
                HashMap map = new HashMap(this.annotationValues);
                if (map.put(((MethodDescription.InDefinedShape) methodListFilter.getOnly()).getName(), annotationValue) == null) {
                    return new Builder(this.annotationType, map);
                }
                throw new IllegalArgumentException(a.p("Property already defined: ", str));
            }
            throw new IllegalArgumentException(this.annotationType + " does not define a property named " + str);
        }

        public <T extends Annotation> Builder defineAnnotationArray(String str, Class<T> cls, T... tArr) {
            return defineAnnotationArray(str, TypeDescription.ForLoadedType.of(cls), (AnnotationDescription[]) new AnnotationList.ForLoadedAnnotations(tArr).toArray(new AnnotationDescription[0]));
        }

        public Builder defineArray(String str, boolean... zArr) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.of(zArr));
        }

        public <T extends Enum<?>> Builder defineEnumerationArray(String str, Class<T> cls, T... tArr) {
            EnumerationDescription[] enumerationDescriptionArr = new EnumerationDescription[tArr.length];
            int length = tArr.length;
            int i = 0;
            int i3 = 0;
            while (i < length) {
                enumerationDescriptionArr[i3] = new EnumerationDescription.ForLoadedEnumeration(tArr[i]);
                i++;
                i3++;
            }
            return defineEnumerationArray(str, TypeDescription.ForLoadedType.of(cls), enumerationDescriptionArr);
        }

        public Builder defineTypeArray(String str, Class<?>... clsArr) {
            return defineTypeArray(str, (TypeDescription[]) new TypeList.ForLoadedTypes(clsArr).toArray(new TypeDescription[0]));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Builder builder = (Builder) obj;
            return this.annotationType.equals(builder.annotationType) && this.annotationValues.equals(builder.annotationValues);
        }

        public int hashCode() {
            return this.annotationValues.hashCode() + com.google.protobuf.a.i(this.annotationType, getClass().hashCode() * 31, 31);
        }

        public static Builder ofType(TypeDescription typeDescription) {
            if (typeDescription.isAnnotation()) {
                return new Builder(typeDescription, Collections.EMPTY_MAP);
            }
            throw new IllegalArgumentException(com.google.protobuf.a.m("Not an annotation type: ", typeDescription));
        }

        public Builder defineArray(String str, byte... bArr) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.of(bArr));
        }

        public Builder defineTypeArray(String str, TypeDescription... typeDescriptionArr) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForDescriptionArray.of(typeDescriptionArr));
        }

        public Builder defineArray(String str, char... cArr) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.of(cArr));
        }

        public Builder defineAnnotationArray(String str, TypeDescription typeDescription, AnnotationDescription... annotationDescriptionArr) {
            return define(str, AnnotationValue.ForDescriptionArray.of(typeDescription, annotationDescriptionArr));
        }

        public Builder defineArray(String str, short... sArr) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.of(sArr));
        }

        public Builder defineArray(String str, int... iArr) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.of(iArr));
        }

        public Builder defineEnumerationArray(String str, TypeDescription typeDescription, String... strArr) {
            if (typeDescription.isEnum()) {
                EnumerationDescription[] enumerationDescriptionArr = new EnumerationDescription[strArr.length];
                for (int i = 0; i < strArr.length; i++) {
                    enumerationDescriptionArr[i] = new EnumerationDescription.Latent(typeDescription, strArr[i]);
                }
                return defineEnumerationArray(str, typeDescription, enumerationDescriptionArr);
            }
            throw new IllegalArgumentException(com.google.protobuf.a.m("Not an enumeration type: ", typeDescription));
        }

        public Builder defineArray(String str, long... jArr) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.of(jArr));
        }

        public Builder defineArray(String str, float... fArr) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.of(fArr));
        }

        public AnnotationDescription build(boolean z6) {
            return z6 ? build() : new Latent(this.annotationType, this.annotationValues);
        }

        public Builder defineArray(String str, double... dArr) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.of(dArr));
        }

        public Builder defineArray(String str, String... strArr) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.of(strArr));
        }

        public Builder define(String str, Enum<?> r32) {
            return define(str, new EnumerationDescription.ForLoadedEnumeration(r32));
        }

        public Builder define(String str, TypeDescription typeDescription, String str2) {
            return define(str, new EnumerationDescription.Latent(typeDescription, str2));
        }

        public Builder define(String str, EnumerationDescription enumerationDescription) {
            return define(str, AnnotationValue.ForEnumerationDescription.of(enumerationDescription));
        }

        public Builder define(String str, Annotation annotation) {
            return define(str, new ForLoadedAnnotation(annotation));
        }

        public Builder defineEnumerationArray(String str, TypeDescription typeDescription, EnumerationDescription... enumerationDescriptionArr) {
            return define(str, AnnotationValue.ForDescriptionArray.of(typeDescription, enumerationDescriptionArr));
        }

        public Builder define(String str, AnnotationDescription annotationDescription) {
            return define(str, new AnnotationValue.ForAnnotationDescription(annotationDescription));
        }

        public Builder define(String str, Class<?> cls) {
            return define(str, TypeDescription.ForLoadedType.of(cls));
        }

        public Builder define(String str, TypeDescription typeDescription) {
            return define(str, AnnotationValue.ForTypeDescription.of(typeDescription));
        }

        public Builder define(String str, boolean z6) {
            return define(str, AnnotationValue.ForConstant.of(z6));
        }

        public Builder define(String str, byte b) {
            return define(str, AnnotationValue.ForConstant.of(b));
        }

        public Builder define(String str, char c) {
            return define(str, AnnotationValue.ForConstant.of(c));
        }

        public Builder define(String str, short s3) {
            return define(str, AnnotationValue.ForConstant.of(s3));
        }

        public Builder define(String str, int i) {
            return define(str, AnnotationValue.ForConstant.of(i));
        }

        public Builder define(String str, long j6) {
            return define(str, AnnotationValue.ForConstant.of(j6));
        }

        public Builder define(String str, float f6) {
            return define(str, AnnotationValue.ForConstant.of(f6));
        }

        public Builder define(String str, double d) {
            return define(str, AnnotationValue.ForConstant.of(d));
        }

        public Builder define(String str, String str2) {
            return define(str, AnnotationValue.ForConstant.of(str2));
        }
    }

    public static class ForLoadedAnnotation<S extends Annotation> extends AbstractBase implements Loadable<S> {
        private static final boolean ACCESS_CONTROLLER;
        private static final Object[] NO_ARGUMENT;
        private final S annotation;
        private final Class<S> annotationType;

        static {
            try {
                Class.forName("java.security.AccessController", false, null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
            } catch (ClassNotFoundException unused) {
                ACCESS_CONTROLLER = false;
            } catch (SecurityException unused2) {
                ACCESS_CONTROLLER = true;
            }
            NO_ARGUMENT = new Object[0];
        }

        public ForLoadedAnnotation(S s3) {
            this(s3, s3.annotationType());
        }

        private static Map<String, AnnotationValue<?, ?>> asValue(Annotation annotation) {
            HashMap map = new HashMap();
            for (Method method : annotation.annotationType().getDeclaredMethods()) {
                try {
                    map.put(method.getName(), asValue(method.invoke(annotation, NO_ARGUMENT), method.getReturnType()));
                } catch (IllegalAccessException e) {
                    throw new IllegalStateException("Cannot access " + method, e);
                } catch (InvocationTargetException e6) {
                    Throwable targetException = e6.getTargetException();
                    if (targetException instanceof TypeNotPresentException) {
                        map.put(method.getName(), new AnnotationValue.ForMissingType(((TypeNotPresentException) targetException).typeName()));
                    } else if (targetException instanceof EnumConstantNotPresentException) {
                        EnumConstantNotPresentException enumConstantNotPresentException = (EnumConstantNotPresentException) targetException;
                        map.put(method.getName(), new AnnotationValue.ForEnumerationDescription.WithUnknownConstant(new TypeDescription.ForLoadedType(enumConstantNotPresentException.enumType()), enumConstantNotPresentException.constantName()));
                    } else if (targetException instanceof AnnotationTypeMismatchException) {
                        AnnotationTypeMismatchException annotationTypeMismatchException = (AnnotationTypeMismatchException) targetException;
                        map.put(method.getName(), new AnnotationValue.ForMismatchedType(new MethodDescription.ForLoadedMethod(annotationTypeMismatchException.element()), annotationTypeMismatchException.foundType()));
                    } else if (!(targetException instanceof IncompleteAnnotationException)) {
                        throw new IllegalStateException("Cannot read " + method, targetException);
                    }
                }
            }
            return map;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static <U extends Annotation> Loadable<U> of(U u) {
            return new ForLoadedAnnotation(u);
        }

        @Override // net.bytebuddy.description.annotation.AnnotationDescription
        public TypeDescription getAnnotationType() {
            return TypeDescription.ForLoadedType.of(this.annotation.annotationType());
        }

        @Override // net.bytebuddy.description.annotation.AnnotationDescription
        @SuppressFBWarnings(justification = "Exception should always be wrapped for clarity.", value = {"REC_CATCH_EXCEPTION"})
        public AnnotationValue<?, ?> getValue(MethodDescription.InDefinedShape inDefinedShape) {
            if (!inDefinedShape.getDeclaringType().represents(this.annotation.annotationType())) {
                throw new IllegalArgumentException(inDefinedShape + " does not represent " + this.annotation.annotationType());
            }
            try {
                boolean zIsPublic = inDefinedShape.getDeclaringType().isPublic();
                Method loadedMethod = inDefinedShape instanceof MethodDescription.ForLoadedMethod ? ((MethodDescription.ForLoadedMethod) inDefinedShape).getLoadedMethod() : null;
                if (loadedMethod == null || loadedMethod.getDeclaringClass() != this.annotation.annotationType() || (!zIsPublic && !loadedMethod.isAccessible())) {
                    loadedMethod = this.annotation.annotationType().getMethod(inDefinedShape.getName(), new Class[0]);
                    if (!zIsPublic) {
                        doPrivileged(new SetAccessibleAction(loadedMethod));
                    }
                }
                return asValue(loadedMethod.invoke(this.annotation, NO_ARGUMENT), loadedMethod.getReturnType()).filter(inDefinedShape);
            } catch (InvocationTargetException e) {
                Throwable targetException = e.getTargetException();
                if (targetException instanceof TypeNotPresentException) {
                    return new AnnotationValue.ForMissingType(((TypeNotPresentException) targetException).typeName());
                }
                if (targetException instanceof EnumConstantNotPresentException) {
                    EnumConstantNotPresentException enumConstantNotPresentException = (EnumConstantNotPresentException) targetException;
                    return new AnnotationValue.ForEnumerationDescription.WithUnknownConstant(new TypeDescription.ForLoadedType(enumConstantNotPresentException.enumType()), enumConstantNotPresentException.constantName());
                }
                if (targetException instanceof AnnotationTypeMismatchException) {
                    AnnotationTypeMismatchException annotationTypeMismatchException = (AnnotationTypeMismatchException) targetException;
                    return new AnnotationValue.ForMismatchedType(new MethodDescription.ForLoadedMethod(annotationTypeMismatchException.element()), annotationTypeMismatchException.foundType());
                }
                if (targetException instanceof IncompleteAnnotationException) {
                    IncompleteAnnotationException incompleteAnnotationException = (IncompleteAnnotationException) targetException;
                    return new AnnotationValue.ForMissingValue(new TypeDescription.ForLoadedType(incompleteAnnotationException.annotationType()), incompleteAnnotationException.elementName());
                }
                throw new IllegalStateException("Error reading annotation property " + inDefinedShape, targetException);
            } catch (Exception e6) {
                throw new IllegalStateException("Cannot access annotation property " + inDefinedShape, e6);
            }
        }

        @Override // net.bytebuddy.description.annotation.AnnotationDescription.Loadable
        public S load() {
            return this.annotationType == this.annotation.annotationType() ? this.annotation : (S) AnnotationInvocationHandler.of(this.annotationType.getClassLoader(), this.annotationType, asValue(this.annotation));
        }

        @Override // net.bytebuddy.description.annotation.AnnotationDescription
        public <T extends Annotation> Loadable<T> prepare(Class<T> cls) {
            if (this.annotation.annotationType().getName().equals(cls.getName())) {
                return cls == this.annotation.annotationType() ? this : new ForLoadedAnnotation(this.annotation, cls);
            }
            throw new IllegalArgumentException(cls + " does not represent " + this.annotation.annotationType());
        }

        private ForLoadedAnnotation(S s3, Class<S> cls) {
            this.annotation = s3;
            this.annotationType = cls;
        }

        public static AnnotationValue<?, ?> asValue(Object obj, Class<?> cls) {
            if (Enum.class.isAssignableFrom(cls)) {
                return AnnotationValue.ForEnumerationDescription.of(new EnumerationDescription.ForLoadedEnumeration((Enum) obj));
            }
            int i = 0;
            if (Enum[].class.isAssignableFrom(cls)) {
                Enum[] enumArr = (Enum[]) obj;
                EnumerationDescription[] enumerationDescriptionArr = new EnumerationDescription[enumArr.length];
                int length = enumArr.length;
                int i3 = 0;
                while (i < length) {
                    enumerationDescriptionArr[i3] = new EnumerationDescription.ForLoadedEnumeration(enumArr[i]);
                    i++;
                    i3++;
                }
                return AnnotationValue.ForDescriptionArray.of(TypeDescription.ForLoadedType.of(cls.getComponentType()), enumerationDescriptionArr);
            }
            if (Annotation.class.isAssignableFrom(cls)) {
                return AnnotationValue.ForAnnotationDescription.of(TypeDescription.ForLoadedType.of(cls), asValue((Annotation) obj));
            }
            if (Annotation[].class.isAssignableFrom(cls)) {
                Annotation[] annotationArr = (Annotation[]) obj;
                AnnotationDescription[] annotationDescriptionArr = new AnnotationDescription[annotationArr.length];
                int length2 = annotationArr.length;
                int i4 = 0;
                while (i < length2) {
                    annotationDescriptionArr[i4] = new Latent(TypeDescription.ForLoadedType.of(cls.getComponentType()), asValue(annotationArr[i]));
                    i++;
                    i4++;
                }
                return AnnotationValue.ForDescriptionArray.of(TypeDescription.ForLoadedType.of(cls.getComponentType()), annotationDescriptionArr);
            }
            if (Class.class.isAssignableFrom(cls)) {
                return AnnotationValue.ForTypeDescription.of(TypeDescription.ForLoadedType.of((Class) obj));
            }
            if (Class[].class.isAssignableFrom(cls)) {
                Class[] clsArr = (Class[]) obj;
                TypeDescription[] typeDescriptionArr = new TypeDescription[clsArr.length];
                int length3 = clsArr.length;
                int i5 = 0;
                while (i < length3) {
                    typeDescriptionArr[i5] = TypeDescription.ForLoadedType.of(clsArr[i]);
                    i++;
                    i5++;
                }
                return AnnotationValue.ForDescriptionArray.of(typeDescriptionArr);
            }
            return AnnotationValue.ForConstant.of(obj);
        }
    }

    public static class Latent extends AbstractBase {
        private final TypeDescription annotationType;
        private final Map<String, ? extends AnnotationValue<?, ?>> annotationValues;

        public class Loadable<S extends Annotation> extends AbstractBase implements Loadable<S> {
            private final Class<S> annotationType;

            public Loadable(Class<S> cls) {
                this.annotationType = cls;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationDescription
            public TypeDescription getAnnotationType() {
                return TypeDescription.ForLoadedType.of(this.annotationType);
            }

            @Override // net.bytebuddy.description.annotation.AnnotationDescription
            public AnnotationValue<?, ?> getValue(MethodDescription.InDefinedShape inDefinedShape) {
                return Latent.this.getValue(inDefinedShape);
            }

            @Override // net.bytebuddy.description.annotation.AnnotationDescription.Loadable
            public S load() {
                return (S) AnnotationInvocationHandler.of(this.annotationType.getClassLoader(), this.annotationType, Latent.this.annotationValues);
            }

            @Override // net.bytebuddy.description.annotation.AnnotationDescription
            public <T extends Annotation> Loadable<T> prepare(Class<T> cls) {
                return Latent.this.prepare((Class) cls);
            }
        }

        public Latent(TypeDescription typeDescription, Map<String, ? extends AnnotationValue<?, ?>> map) {
            this.annotationType = typeDescription;
            this.annotationValues = map;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationDescription
        public TypeDescription getAnnotationType() {
            return this.annotationType;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationDescription
        public AnnotationValue<?, ?> getValue(MethodDescription.InDefinedShape inDefinedShape) {
            if (inDefinedShape.getDeclaringType().equals(this.annotationType)) {
                AnnotationValue<?, ?> annotationValue = this.annotationValues.get(inDefinedShape.getName());
                if (annotationValue != null) {
                    return annotationValue.filter(inDefinedShape);
                }
                AnnotationValue<?, ?> defaultValue = inDefinedShape.getDefaultValue();
                return defaultValue == null ? new AnnotationValue.ForMissingValue(this.annotationType, inDefinedShape.getName()) : defaultValue;
            }
            throw new IllegalArgumentException("Not a property of " + this.annotationType + ": " + inDefinedShape);
        }

        @Override // net.bytebuddy.description.annotation.AnnotationDescription
        public <T extends Annotation> Loadable<T> prepare(Class<T> cls) {
            if (this.annotationType.represents(cls)) {
                return new Loadable<>(cls);
            }
            throw new IllegalArgumentException(cls + " does not represent " + this.annotationType);
        }
    }

    public interface Loadable<S extends Annotation> extends AnnotationDescription {
        S load();
    }

    public enum RenderingDispatcher {
        LEGACY_VM,
        JAVA_14_CAPABLE_VM { // from class: net.bytebuddy.description.annotation.AnnotationDescription.RenderingDispatcher.1
            @Override // net.bytebuddy.description.annotation.AnnotationDescription.RenderingDispatcher
            public void appendPrefix(StringBuilder sb, String str, int i) {
                if (i > 1 || !str.equals("value")) {
                    super.appendPrefix(sb, str, i);
                }
            }
        },
        JAVA_19_CAPABLE_VM { // from class: net.bytebuddy.description.annotation.AnnotationDescription.RenderingDispatcher.2
            @Override // net.bytebuddy.description.annotation.AnnotationDescription.RenderingDispatcher
            public void appendPrefix(StringBuilder sb, String str, int i) {
                if (i > 1 || !str.equals("value")) {
                    super.appendPrefix(sb, str, i);
                }
            }

            @Override // net.bytebuddy.description.annotation.AnnotationDescription.RenderingDispatcher
            public void appendType(StringBuilder sb, TypeDescription typeDescription) {
                sb.append(typeDescription.getCanonicalName());
            }
        };

        public static final RenderingDispatcher CURRENT;

        static {
            RenderingDispatcher renderingDispatcher = LEGACY_VM;
            RenderingDispatcher renderingDispatcher2 = JAVA_14_CAPABLE_VM;
            RenderingDispatcher renderingDispatcher3 = JAVA_19_CAPABLE_VM;
            ClassFileVersion classFileVersionOfThisVm = ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5);
            if (classFileVersionOfThisVm.isAtLeast(ClassFileVersion.JAVA_V19)) {
                CURRENT = renderingDispatcher3;
            } else if (classFileVersionOfThisVm.isAtLeast(ClassFileVersion.JAVA_V14)) {
                CURRENT = renderingDispatcher2;
            } else {
                CURRENT = renderingDispatcher;
            }
        }

        public void appendPrefix(StringBuilder sb, String str, int i) {
            sb.append(str);
            sb.append(SignatureVisitor.INSTANCEOF);
        }

        public void appendType(StringBuilder sb, TypeDescription typeDescription) {
            sb.append(typeDescription.getName());
        }
    }

    TypeDescription getAnnotationType();

    Set<ElementType> getElementTypes();

    RetentionPolicy getRetention();

    AnnotationValue<?, ?> getValue(String str);

    AnnotationValue<?, ?> getValue(MethodDescription.InDefinedShape inDefinedShape);

    boolean isDocumented();

    boolean isInherited();

    boolean isSupportedOn(String str);

    boolean isSupportedOn(ElementType elementType);

    <T extends Annotation> Loadable<T> prepare(Class<T> cls);
}
