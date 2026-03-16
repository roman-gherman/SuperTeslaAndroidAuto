package net.bytebuddy.description.method;

import com.google.protobuf.a;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.DeclaredByType;
import net.bytebuddy.description.ModifierReviewable;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.TypeVariableSource;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.description.type.TypeVariableToken;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.jar.asm.signature.SignatureWriter;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
public interface MethodDescription extends TypeVariableSource, DeclaredByType.WithMandatoryDeclaration, ModifierReviewable.ForMethodDescription, NamedElement.WithGenericName, ByteCodeElement, ByteCodeElement.TypeDependant<InDefinedShape, Token> {
    public static final String CONSTRUCTOR_INTERNAL_NAME = "<init>";
    public static final String TYPE_INITIALIZER_INTERNAL_NAME = "<clinit>";
    public static final int TYPE_INITIALIZER_MODIFIER = 8;

    @AlwaysNull
    public static final InDefinedShape UNDEFINED = null;

    public static abstract class AbstractBase extends TypeVariableSource.AbstractBase implements MethodDescription {
        private static final int SOURCE_MODIFIERS = 1343;
        private transient /* synthetic */ int hashCode;

        private static boolean isAnnotationType(TypeDescription typeDescription, AnnotationDescription... annotationDescriptionArr) {
            for (AnnotationDescription annotationDescription : annotationDescriptionArr) {
                if (!annotationDescription.getAnnotationType().equals(typeDescription)) {
                    return false;
                }
            }
            return true;
        }

        @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
        private boolean isBootstrap(TypeDescription typeDescription) {
            TypeList typeListAsErasures = getParameters().asTypeList().asErasures();
            int size = typeListAsErasures.size();
            if (size != 0) {
                return size != 1 ? size != 2 ? size != 3 ? JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().isAssignableTo(typeListAsErasures.get(0)) && (typeListAsErasures.get(1).represents(Object.class) || typeListAsErasures.get(1).represents(String.class)) && typeListAsErasures.get(2).isAssignableFrom(typeDescription) : JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().isAssignableTo(typeListAsErasures.get(0)) && (typeListAsErasures.get(1).represents(Object.class) || typeListAsErasures.get(1).represents(String.class)) && ((typeListAsErasures.get(2).isArray() && typeListAsErasures.get(2).getComponentType().isAssignableFrom(typeDescription)) || typeListAsErasures.get(2).isAssignableFrom(typeDescription)) : JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().isAssignableTo(typeListAsErasures.get(0)) && typeListAsErasures.get(1).represents(Object[].class) : typeListAsErasures.getOnly().represents(Object[].class);
            }
            return false;
        }

        @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
        private boolean isBootstrapping(List<? extends TypeDefinition> list) {
            TypeList typeListAsErasures = getParameters().asTypeList().asErasures();
            if (typeListAsErasures.size() < 4) {
                if (list.isEmpty()) {
                    return true;
                }
                if (!typeListAsErasures.get(typeListAsErasures.size() - 1).isArray()) {
                    return false;
                }
                Iterator<? extends TypeDefinition> it = list.iterator();
                while (it.hasNext()) {
                    if (!it.next().asErasure().isAssignableTo(typeListAsErasures.get(typeListAsErasures.size() - 1).getComponentType())) {
                        return false;
                    }
                }
                return true;
            }
            Iterator<TypeDescription> it2 = typeListAsErasures.subList(3, typeListAsErasures.size()).iterator();
            for (TypeDefinition typeDefinition : list) {
                if (!it2.hasNext()) {
                    return false;
                }
                TypeDescription next = it2.next();
                if (!it2.hasNext() && next.isArray()) {
                    return true;
                }
                if (!typeDefinition.asErasure().isAssignableTo(next)) {
                    return false;
                }
            }
            if (it2.hasNext()) {
                return it2.next().isArray() && !it2.hasNext();
            }
            return true;
        }

        private static boolean isEnumerationType(TypeDescription typeDescription, EnumerationDescription... enumerationDescriptionArr) {
            for (EnumerationDescription enumerationDescription : enumerationDescriptionArr) {
                if (!enumerationDescription.getEnumerationType().equals(typeDescription)) {
                    return false;
                }
            }
            return true;
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        public <T> T accept(TypeVariableSource.Visitor<T> visitor) {
            return visitor.onMethod(asDefined());
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public SignatureToken asSignatureToken() {
            return new SignatureToken(getInternalName(), getReturnType().asErasure(), getParameters().asTypeList().asErasures());
        }

        @Override // net.bytebuddy.description.ByteCodeElement.TypeDependant
        public /* bridge */ /* synthetic */ ByteCodeElement.Token asToken(ElementMatcher elementMatcher) {
            return asToken((ElementMatcher<? super TypeDescription>) elementMatcher);
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public TypeToken asTypeToken() {
            return new TypeToken(getReturnType().asErasure(), getParameters().asTypeList().asErasures());
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MethodDescription)) {
                return false;
            }
            MethodDescription methodDescription = (MethodDescription) obj;
            return getInternalName().equals(methodDescription.getInternalName()) && getDeclaringType().equals(methodDescription.getDeclaringType()) && getReturnType().asErasure().equals(methodDescription.getReturnType().asErasure()) && getParameters().asTypeList().asErasures().equals(methodDescription.getParameters().asTypeList().asErasures());
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public int getActualModifiers() {
            return getModifiers() | (getDeclaredAnnotations().isAnnotationPresent(Deprecated.class) ? 131072 : 0);
        }

        @Override // net.bytebuddy.description.NamedElement
        public String getActualName() {
            return isMethod() ? getName() : "";
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        @MaybeNull
        public <T> T getDefaultValue(Class<T> cls) {
            return cls.cast(getDefaultValue());
        }

        @Override // net.bytebuddy.description.NamedElement.WithDescriptor
        public String getDescriptor() {
            StringBuilder sb = new StringBuilder("(");
            Iterator<TypeDescription> it = getParameters().asTypeList().asErasures().iterator();
            while (it.hasNext()) {
                sb.append(it.next().getDescriptor());
            }
            sb.append(')');
            sb.append(getReturnType().asErasure().getDescriptor());
            return sb.toString();
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        @MaybeNull
        public TypeVariableSource getEnclosingSource() {
            return isStatic() ? TypeVariableSource.UNDEFINED : getDeclaringType().asErasure();
        }

        @Override // net.bytebuddy.description.NamedElement.WithDescriptor
        @MaybeNull
        public String getGenericSignature() {
            try {
                SignatureWriter signatureWriter = new SignatureWriter();
                boolean z6 = false;
                for (TypeDescription.Generic generic : getTypeVariables()) {
                    signatureWriter.visitFormalTypeParameter(generic.getSymbol());
                    Iterator<TypeDescription.Generic> it = generic.getUpperBounds().iterator();
                    boolean z7 = true;
                    while (it.hasNext()) {
                        it.next().accept(new TypeDescription.Generic.Visitor.ForSignatureVisitor(z7 ? signatureWriter.visitClassBound() : signatureWriter.visitInterfaceBound()));
                        z7 = false;
                    }
                    z6 = true;
                }
                for (TypeDescription.Generic generic2 : getParameters().asTypeList()) {
                    generic2.accept(new TypeDescription.Generic.Visitor.ForSignatureVisitor(signatureWriter.visitParameterType()));
                    z6 = z6 || !generic2.getSort().isNonGeneric();
                }
                TypeDescription.Generic returnType = getReturnType();
                returnType.accept(new TypeDescription.Generic.Visitor.ForSignatureVisitor(signatureWriter.visitReturnType()));
                boolean z8 = z6 || !returnType.getSort().isNonGeneric();
                TypeList.Generic exceptionTypes = getExceptionTypes();
                if (!exceptionTypes.filter(ElementMatchers.not(ElementMatchers.ofSort(TypeDefinition.Sort.NON_GENERIC))).isEmpty()) {
                    for (TypeDescription.Generic generic3 : exceptionTypes) {
                        generic3.accept(new TypeDescription.Generic.Visitor.ForSignatureVisitor(signatureWriter.visitExceptionType()));
                        z8 = z8 || !generic3.getSort().isNonGeneric();
                    }
                }
                return z8 ? signatureWriter.toString() : NamedElement.WithDescriptor.NON_GENERIC_SIGNATURE;
            } catch (GenericSignatureFormatError unused) {
                return NamedElement.WithDescriptor.NON_GENERIC_SIGNATURE;
            }
        }

        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getName() {
            return isMethod() ? getInternalName() : getDeclaringType().asErasure().getName();
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public int getStackSize() {
            return getParameters().asTypeList().getStackSize() + (!isStatic() ? 1 : 0);
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int iHashCode;
            if (this.hashCode != 0) {
                iHashCode = 0;
            } else {
                iHashCode = ((getReturnType().asErasure().hashCode() + ((getInternalName().hashCode() + ((getDeclaringType().hashCode() + 17) * 31)) * 31)) * 31) + getParameters().asTypeList().asErasures().hashCode();
            }
            if (iHashCode == 0) {
                return this.hashCode;
            }
            this.hashCode = iHashCode;
            return iHashCode;
        }

        @Override // net.bytebuddy.description.ByteCodeElement
        public boolean isAccessibleTo(TypeDescription typeDescription) {
            if (isVirtual() || getDeclaringType().asErasure().isVisibleTo(typeDescription)) {
                if (isPublic() || typeDescription.equals(getDeclaringType().asErasure())) {
                    return true;
                }
                if (!isPrivate() && typeDescription.isSamePackage(getDeclaringType().asErasure())) {
                    return true;
                }
            }
            return isPrivate() && typeDescription.isNestMateOf(getDeclaringType().asErasure());
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean isBridgeCompatible(TypeToken typeToken) {
            TypeList typeListAsErasures = getParameters().asTypeList().asErasures();
            List<TypeDescription> parameterTypes = typeToken.getParameterTypes();
            if (typeListAsErasures.size() != parameterTypes.size()) {
                return false;
            }
            for (int i = 0; i < typeListAsErasures.size(); i++) {
                if (!typeListAsErasures.get(i).equals(parameterTypes.get(i)) && (typeListAsErasures.get(i).isPrimitive() || parameterTypes.get(i).isPrimitive())) {
                    return false;
                }
            }
            TypeDescription typeDescriptionAsErasure = getReturnType().asErasure();
            TypeDescription returnType = typeToken.getReturnType();
            if (typeDescriptionAsErasure.equals(returnType)) {
                return true;
            }
            return (typeDescriptionAsErasure.isPrimitive() || returnType.isPrimitive()) ? false : true;
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean isConstantBootstrap() {
            return isBootstrap(TypeDescription.ForLoadedType.of(Class.class));
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean isConstructor() {
            return MethodDescription.CONSTRUCTOR_INTERNAL_NAME.equals(getInternalName());
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean isDefaultMethod() {
            return (isAbstract() || isBridge() || !getDeclaringType().isInterface()) ? false : true;
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean isDefaultValue() {
            return !isConstructor() && !isStatic() && getReturnType().asErasure().isAnnotationReturnType() && getParameters().isEmpty();
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        public boolean isGenerified() {
            return !getTypeVariables().isEmpty();
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        public boolean isInferrable() {
            return true;
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean isInvokableOn(TypeDescription typeDescription) {
            if (isStatic() || isTypeInitializer() || !isVisibleTo(typeDescription)) {
                return false;
            }
            return isVirtual() ? getDeclaringType().asErasure().isAssignableFrom(typeDescription) : getDeclaringType().asErasure().equals(typeDescription);
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean isInvokeBootstrap() {
            TypeDescription typeDescriptionAsErasure = getReturnType().asErasure();
            if (isMethod()) {
                if (!isStatic()) {
                    return false;
                }
                JavaType javaType = JavaType.CALL_SITE;
                if (!javaType.getTypeStub().isAssignableFrom(typeDescriptionAsErasure) && !javaType.getTypeStub().isAssignableTo(typeDescriptionAsErasure)) {
                    return false;
                }
            }
            if (!isConstructor() || JavaType.CALL_SITE.getTypeStub().isAssignableFrom(getDeclaringType().asErasure())) {
                return isBootstrap(JavaType.METHOD_TYPE.getTypeStub());
            }
            return false;
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean isMethod() {
            return (isConstructor() || isTypeInitializer()) ? false : true;
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean isSpecializableFor(TypeDescription typeDescription) {
            if (isStatic()) {
                return false;
            }
            return (isPrivate() || isConstructor()) ? getDeclaringType().equals(typeDescription) : !isAbstract() && getDeclaringType().asErasure().isAssignableFrom(typeDescription);
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean isTypeInitializer() {
            return MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME.equals(getInternalName());
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean isVirtual() {
            return (isConstructor() || isPrivate() || isStatic() || isTypeInitializer()) ? false : true;
        }

        @Override // net.bytebuddy.description.ByteCodeElement
        public boolean isVisibleTo(TypeDescription typeDescription) {
            if (!isVirtual() && !getDeclaringType().asErasure().isVisibleTo(typeDescription)) {
                return false;
            }
            if (isPublic() || typeDescription.equals(getDeclaringType().asErasure())) {
                return true;
            }
            if (isProtected() && getDeclaringType().asErasure().isAssignableFrom(typeDescription)) {
                return true;
            }
            if (isPrivate() || !typeDescription.isSamePackage(getDeclaringType().asErasure())) {
                return isPrivate() && typeDescription.isNestMateOf(getDeclaringType().asErasure());
            }
            return true;
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean represents(Method method) {
            return equals(new ForLoadedMethod(method));
        }

        @Override // net.bytebuddy.description.NamedElement.WithGenericName
        public String toGenericString() {
            StringBuilder sb = new StringBuilder();
            int modifiers = getModifiers() & SOURCE_MODIFIERS;
            if (modifiers != 0) {
                sb.append(Modifier.toString(modifiers));
                sb.append(' ');
            }
            if (isMethod()) {
                sb.append(getReturnType().getActualName());
                sb.append(' ');
                sb.append(getDeclaringType().asErasure().getActualName());
                sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
            }
            sb.append(getName());
            sb.append('(');
            boolean z6 = true;
            boolean z7 = true;
            for (TypeDescription.Generic generic : getParameters().asTypeList()) {
                if (z7) {
                    z7 = false;
                } else {
                    sb.append(',');
                }
                sb.append(generic.getActualName());
            }
            sb.append(')');
            TypeList.Generic exceptionTypes = getExceptionTypes();
            if (!exceptionTypes.isEmpty()) {
                sb.append(" throws ");
                for (TypeDescription.Generic generic2 : exceptionTypes) {
                    if (z6) {
                        z6 = false;
                    } else {
                        sb.append(',');
                    }
                    sb.append(generic2.getActualName());
                }
            }
            return sb.toString();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            int modifiers = getModifiers() & SOURCE_MODIFIERS;
            if (modifiers != 0) {
                sb.append(Modifier.toString(modifiers));
                sb.append(' ');
            }
            if (isMethod()) {
                sb.append(getReturnType().asErasure().getActualName());
                sb.append(' ');
                sb.append(getDeclaringType().asErasure().getActualName());
                sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
            }
            sb.append(getName());
            sb.append('(');
            boolean z6 = true;
            boolean z7 = true;
            for (TypeDescription typeDescription : getParameters().asTypeList().asErasures()) {
                if (z7) {
                    z7 = false;
                } else {
                    sb.append(',');
                }
                sb.append(typeDescription.getActualName());
            }
            sb.append(')');
            TypeList typeListAsErasures = getExceptionTypes().asErasures();
            if (!typeListAsErasures.isEmpty()) {
                sb.append(" throws ");
                for (TypeDescription typeDescription2 : typeListAsErasures) {
                    if (z6) {
                        z6 = false;
                    } else {
                        sb.append(',');
                    }
                    sb.append(typeDescription2.getActualName());
                }
            }
            return sb.toString();
        }

        @Override // net.bytebuddy.description.ByteCodeElement.TypeDependant
        public Token asToken(ElementMatcher<? super TypeDescription> elementMatcher) {
            TypeDescription.Generic receiverType = getReceiverType();
            return new Token(getInternalName(), getModifiers(), getTypeVariables().asTokenList(elementMatcher), (TypeDescription.Generic) getReturnType().accept(new TypeDescription.Generic.Visitor.Substitutor.ForDetachment(elementMatcher)), getParameters().asTokenList(elementMatcher), getExceptionTypes().accept(new TypeDescription.Generic.Visitor.Substitutor.ForDetachment(elementMatcher)), getDeclaredAnnotations(), getDefaultValue(), receiverType == null ? TypeDescription.Generic.UNDEFINED : (TypeDescription.Generic) receiverType.accept(new TypeDescription.Generic.Visitor.Substitutor.ForDetachment(elementMatcher)));
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public int getActualModifiers(boolean z6) {
            return z6 ? getActualModifiers() & (-1281) : (getActualModifiers() & (-257)) | 1024;
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean isConstantBootstrap(List<? extends TypeDefinition> list) {
            return isConstantBootstrap() && isBootstrapping(list);
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean represents(Constructor<?> constructor) {
            return equals(new ForLoadedConstructor(constructor));
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public int getActualModifiers(boolean z6, Visibility visibility) {
            return ModifierContributor.Resolver.of(Collections.singleton(getVisibility().expandTo(visibility))).resolve(getActualModifiers(z6));
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
        public boolean isDefaultValue(AnnotationValue<?, ?> annotationValue) {
            if (!isDefaultValue()) {
                return false;
            }
            TypeDescription typeDescriptionAsErasure = getReturnType().asErasure();
            Object objResolve = annotationValue.resolve();
            return (typeDescriptionAsErasure.represents(Boolean.TYPE) && (objResolve instanceof Boolean)) || (typeDescriptionAsErasure.represents(Byte.TYPE) && (objResolve instanceof Byte)) || ((typeDescriptionAsErasure.represents(Character.TYPE) && (objResolve instanceof Character)) || ((typeDescriptionAsErasure.represents(Short.TYPE) && (objResolve instanceof Short)) || ((typeDescriptionAsErasure.represents(Integer.TYPE) && (objResolve instanceof Integer)) || ((typeDescriptionAsErasure.represents(Long.TYPE) && (objResolve instanceof Long)) || ((typeDescriptionAsErasure.represents(Float.TYPE) && (objResolve instanceof Float)) || ((typeDescriptionAsErasure.represents(Double.TYPE) && (objResolve instanceof Double)) || ((typeDescriptionAsErasure.represents(String.class) && (objResolve instanceof String)) || ((typeDescriptionAsErasure.isAssignableTo(Enum.class) && (objResolve instanceof EnumerationDescription) && isEnumerationType(typeDescriptionAsErasure, (EnumerationDescription) objResolve)) || ((typeDescriptionAsErasure.isAssignableTo(Annotation.class) && (objResolve instanceof AnnotationDescription) && isAnnotationType(typeDescriptionAsErasure, (AnnotationDescription) objResolve)) || ((typeDescriptionAsErasure.represents(Class.class) && (objResolve instanceof TypeDescription)) || ((typeDescriptionAsErasure.represents(boolean[].class) && (objResolve instanceof boolean[])) || ((typeDescriptionAsErasure.represents(byte[].class) && (objResolve instanceof byte[])) || ((typeDescriptionAsErasure.represents(char[].class) && (objResolve instanceof char[])) || ((typeDescriptionAsErasure.represents(short[].class) && (objResolve instanceof short[])) || ((typeDescriptionAsErasure.represents(int[].class) && (objResolve instanceof int[])) || ((typeDescriptionAsErasure.represents(long[].class) && (objResolve instanceof long[])) || ((typeDescriptionAsErasure.represents(float[].class) && (objResolve instanceof float[])) || ((typeDescriptionAsErasure.represents(double[].class) && (objResolve instanceof double[])) || ((typeDescriptionAsErasure.represents(String[].class) && (objResolve instanceof String[])) || ((typeDescriptionAsErasure.isAssignableTo(Enum[].class) && (objResolve instanceof EnumerationDescription[]) && isEnumerationType(typeDescriptionAsErasure.getComponentType(), (EnumerationDescription[]) objResolve)) || ((typeDescriptionAsErasure.isAssignableTo(Annotation[].class) && (objResolve instanceof AnnotationDescription[]) && isAnnotationType(typeDescriptionAsErasure.getComponentType(), (AnnotationDescription[]) objResolve)) || (typeDescriptionAsErasure.represents(Class[].class) && (objResolve instanceof TypeDescription[])))))))))))))))))))))));
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean isInvokeBootstrap(List<? extends TypeDefinition> list) {
            return isInvokeBootstrap() && isBootstrapping(list);
        }
    }

    public static class ForLoadedConstructor extends InDefinedShape.AbstractBase.ForLoadedExecutable<Constructor<?>> implements ParameterDescription.ForLoadedParameter.ParameterAnnotationSource {
        private transient /* synthetic */ AnnotationList declaredAnnotations;
        private transient /* synthetic */ Annotation[][] parameterAnnotations;
        private transient /* synthetic */ ParameterList parameters;

        public ForLoadedConstructor(Constructor<?> constructor) {
            super(constructor);
        }

        @Override // net.bytebuddy.description.annotation.AnnotationSource
        @CachedReturnPlugin.Enhance("declaredAnnotations")
        public AnnotationList getDeclaredAnnotations() {
            AnnotationList.ForLoadedAnnotations forLoadedAnnotations = this.declaredAnnotations != null ? null : new AnnotationList.ForLoadedAnnotations(((Constructor) this.executable).getDeclaredAnnotations());
            if (forLoadedAnnotations == null) {
                return this.declaredAnnotations;
            }
            this.declaredAnnotations = forLoadedAnnotations;
            return forLoadedAnnotations;
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        @AlwaysNull
        public AnnotationValue<?, ?> getDefaultValue() {
            return AnnotationValue.UNDEFINED;
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.NamedElement.WithDescriptor
        public String getDescriptor() {
            return Type.getConstructorDescriptor((Constructor) this.executable);
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public TypeList.Generic getExceptionTypes() {
            return new TypeList.Generic.OfConstructorExceptionTypes((Constructor) this.executable);
        }

        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getInternalName() {
            return MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
        }

        @Override // net.bytebuddy.description.ModifierReviewable
        public int getModifiers() {
            return ((Constructor) this.executable).getModifiers();
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getName() {
            return ((Constructor) this.executable).getName();
        }

        @Override // net.bytebuddy.description.method.ParameterDescription.ForLoadedParameter.ParameterAnnotationSource
        @CachedReturnPlugin.Enhance("parameterAnnotations")
        public Annotation[][] getParameterAnnotations() {
            Annotation[][] parameterAnnotations = this.parameterAnnotations != null ? null : ((Constructor) this.executable).getParameterAnnotations();
            if (parameterAnnotations == null) {
                return this.parameterAnnotations;
            }
            this.parameterAnnotations = parameterAnnotations;
            return parameterAnnotations;
        }

        @Override // net.bytebuddy.description.method.MethodDescription, net.bytebuddy.description.method.MethodDescription.InDefinedShape
        @CachedReturnPlugin.Enhance("parameters")
        public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
            ParameterList<ParameterDescription.InDefinedShape> parameterListOf = this.parameters != null ? null : ParameterList.ForLoadedExecutable.of((Constructor<?>) this.executable, (ParameterDescription.ForLoadedParameter.ParameterAnnotationSource) this);
            if (parameterListOf == null) {
                return this.parameters;
            }
            this.parameters = parameterListOf;
            return parameterListOf;
        }

        @Override // net.bytebuddy.description.method.MethodDescription.InDefinedShape.AbstractBase.ForLoadedExecutable, net.bytebuddy.description.method.MethodDescription.InDefinedShape.AbstractBase, net.bytebuddy.description.method.MethodDescription
        public /* bridge */ /* synthetic */ TypeDescription.Generic getReceiverType() {
            return super.getReceiverType();
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public TypeDescription.Generic getReturnType() {
            return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Void.TYPE);
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        public TypeList.Generic getTypeVariables() {
            return TypeList.Generic.ForLoadedTypes.OfTypeVariables.of((GenericDeclaration) this.executable);
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.method.MethodDescription
        public boolean isConstructor() {
            return true;
        }

        @Override // net.bytebuddy.description.ModifierReviewable.AbstractBase, net.bytebuddy.description.ModifierReviewable
        public boolean isSynthetic() {
            return ((Constructor) this.executable).isSynthetic();
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.method.MethodDescription
        public boolean isTypeInitializer() {
            return false;
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.method.MethodDescription
        public boolean represents(Method method) {
            return false;
        }

        @Override // net.bytebuddy.description.DeclaredByType.WithMandatoryDeclaration, net.bytebuddy.description.DeclaredByType
        @Nonnull
        public TypeDescription getDeclaringType() {
            return TypeDescription.ForLoadedType.of(((Constructor) this.executable).getDeclaringClass());
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.method.MethodDescription
        public boolean represents(Constructor<?> constructor) {
            return ((Constructor) this.executable).equals(constructor) || equals(new ForLoadedConstructor(constructor));
        }
    }

    public static class ForLoadedMethod extends InDefinedShape.AbstractBase.ForLoadedExecutable<Method> implements ParameterDescription.ForLoadedParameter.ParameterAnnotationSource {
        private transient /* synthetic */ AnnotationList declaredAnnotations;
        private transient /* synthetic */ Annotation[][] parameterAnnotations;
        private transient /* synthetic */ ParameterList parameters;

        public ForLoadedMethod(Method method) {
            super(method);
        }

        @Override // net.bytebuddy.description.annotation.AnnotationSource
        @CachedReturnPlugin.Enhance("declaredAnnotations")
        public AnnotationList getDeclaredAnnotations() {
            AnnotationList.ForLoadedAnnotations forLoadedAnnotations = this.declaredAnnotations != null ? null : new AnnotationList.ForLoadedAnnotations(((Method) this.executable).getDeclaredAnnotations());
            if (forLoadedAnnotations == null) {
                return this.declaredAnnotations;
            }
            this.declaredAnnotations = forLoadedAnnotations;
            return forLoadedAnnotations;
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        @MaybeNull
        public AnnotationValue<?, ?> getDefaultValue() {
            Object defaultValue = ((Method) this.executable).getDefaultValue();
            return defaultValue == null ? AnnotationValue.UNDEFINED : AnnotationDescription.ForLoadedAnnotation.asValue(defaultValue, ((Method) this.executable).getReturnType());
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.NamedElement.WithDescriptor
        public String getDescriptor() {
            return Type.getMethodDescriptor((Method) this.executable);
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public TypeList.Generic getExceptionTypes() {
            return TypeDescription.AbstractBase.RAW_TYPES ? new TypeList.Generic.ForLoadedTypes(((Method) this.executable).getExceptionTypes()) : new TypeList.Generic.OfMethodExceptionTypes((Method) this.executable);
        }

        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getInternalName() {
            return ((Method) this.executable).getName();
        }

        public Method getLoadedMethod() {
            return (Method) this.executable;
        }

        @Override // net.bytebuddy.description.ModifierReviewable
        public int getModifiers() {
            return ((Method) this.executable).getModifiers();
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getName() {
            return ((Method) this.executable).getName();
        }

        @Override // net.bytebuddy.description.method.ParameterDescription.ForLoadedParameter.ParameterAnnotationSource
        @CachedReturnPlugin.Enhance("parameterAnnotations")
        public Annotation[][] getParameterAnnotations() {
            Annotation[][] parameterAnnotations = this.parameterAnnotations != null ? null : ((Method) this.executable).getParameterAnnotations();
            if (parameterAnnotations == null) {
                return this.parameterAnnotations;
            }
            this.parameterAnnotations = parameterAnnotations;
            return parameterAnnotations;
        }

        @Override // net.bytebuddy.description.method.MethodDescription, net.bytebuddy.description.method.MethodDescription.InDefinedShape
        @CachedReturnPlugin.Enhance("parameters")
        public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
            ParameterList<ParameterDescription.InDefinedShape> parameterListOf = this.parameters != null ? null : ParameterList.ForLoadedExecutable.of((Method) this.executable, (ParameterDescription.ForLoadedParameter.ParameterAnnotationSource) this);
            if (parameterListOf == null) {
                return this.parameters;
            }
            this.parameters = parameterListOf;
            return parameterListOf;
        }

        @Override // net.bytebuddy.description.method.MethodDescription.InDefinedShape.AbstractBase.ForLoadedExecutable, net.bytebuddy.description.method.MethodDescription.InDefinedShape.AbstractBase, net.bytebuddy.description.method.MethodDescription
        public /* bridge */ /* synthetic */ TypeDescription.Generic getReceiverType() {
            return super.getReceiverType();
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public TypeDescription.Generic getReturnType() {
            return TypeDescription.AbstractBase.RAW_TYPES ? TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(((Method) this.executable).getReturnType()) : new TypeDescription.Generic.LazyProjection.ForLoadedReturnType((Method) this.executable);
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        public TypeList.Generic getTypeVariables() {
            return TypeDescription.AbstractBase.RAW_TYPES ? new TypeList.Generic.Empty() : TypeList.Generic.ForLoadedTypes.OfTypeVariables.of((GenericDeclaration) this.executable);
        }

        @Override // net.bytebuddy.description.ModifierReviewable.AbstractBase, net.bytebuddy.description.ModifierReviewable.ForMethodDescription
        public boolean isBridge() {
            return ((Method) this.executable).isBridge();
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.method.MethodDescription
        public boolean isConstructor() {
            return false;
        }

        @Override // net.bytebuddy.description.ModifierReviewable.AbstractBase, net.bytebuddy.description.ModifierReviewable
        public boolean isSynthetic() {
            return ((Method) this.executable).isSynthetic();
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.method.MethodDescription
        public boolean isTypeInitializer() {
            return false;
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.method.MethodDescription
        public boolean represents(Constructor<?> constructor) {
            return false;
        }

        @Override // net.bytebuddy.description.DeclaredByType.WithMandatoryDeclaration, net.bytebuddy.description.DeclaredByType
        @Nonnull
        public TypeDescription getDeclaringType() {
            return TypeDescription.ForLoadedType.of(((Method) this.executable).getDeclaringClass());
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.method.MethodDescription
        public boolean represents(Method method) {
            return ((Method) this.executable).equals(method) || equals(new ForLoadedMethod(method));
        }
    }

    public interface InDefinedShape extends MethodDescription {

        public static abstract class AbstractBase extends AbstractBase implements InDefinedShape {

            @JavaDispatcher.Proxied("java.lang.reflect.Executable")
            public interface Executable {
                @JavaDispatcher.Defaults
                @MaybeNull
                @JavaDispatcher.Proxied("getAnnotatedReceiverType")
                AnnotatedElement getAnnotatedReceiverType(Object obj);
            }

            public static abstract class ForLoadedExecutable<T extends AnnotatedElement> extends AbstractBase {
                private static final boolean ACCESS_CONTROLLER;
                protected static final Executable EXECUTABLE;
                protected final T executable;

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
                    EXECUTABLE = (Executable) doPrivileged(JavaDispatcher.of(Executable.class));
                }

                public ForLoadedExecutable(T t6) {
                    this.executable = t6;
                }

                @AccessControllerPlugin.Enhance
                private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
                    return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
                }

                @Override // net.bytebuddy.description.method.MethodDescription.InDefinedShape.AbstractBase, net.bytebuddy.description.ByteCodeElement.TypeDependant
                public /* bridge */ /* synthetic */ ByteCodeElement.TypeDependant asDefined() {
                    return super.asDefined();
                }

                @Override // net.bytebuddy.description.method.MethodDescription.InDefinedShape.AbstractBase, net.bytebuddy.description.method.MethodDescription
                public TypeDescription.Generic getReceiverType() {
                    AnnotatedElement annotatedReceiverType = EXECUTABLE.getAnnotatedReceiverType(this.executable);
                    return annotatedReceiverType == null ? super.getReceiverType() : TypeDefinition.Sort.describeAnnotated(annotatedReceiverType);
                }
            }

            @Override // net.bytebuddy.description.ByteCodeElement.TypeDependant
            public InDefinedShape asDefined() {
                return this;
            }

            @MaybeNull
            public TypeDescription.Generic getReceiverType() {
                if (isStatic()) {
                    return TypeDescription.Generic.UNDEFINED;
                }
                if (!isConstructor()) {
                    return TypeDescription.Generic.OfParameterizedType.ForGenerifiedErasure.of(getDeclaringType());
                }
                TypeDescription declaringType = getDeclaringType();
                TypeDescription enclosingType = getDeclaringType().getEnclosingType();
                return enclosingType == null ? TypeDescription.Generic.OfParameterizedType.ForGenerifiedErasure.of(declaringType) : declaringType.isStatic() ? enclosingType.asGenericType() : TypeDescription.Generic.OfParameterizedType.ForGenerifiedErasure.of(enclosingType);
            }
        }

        @Override // net.bytebuddy.description.DeclaredByType.WithMandatoryDeclaration, net.bytebuddy.description.DeclaredByType
        @Nonnull
        TypeDescription getDeclaringType();

        ParameterList<ParameterDescription.InDefinedShape> getParameters();
    }

    public interface InGenericShape extends MethodDescription {
        @Override // net.bytebuddy.description.DeclaredByType.WithMandatoryDeclaration, net.bytebuddy.description.DeclaredByType
        @Nonnull
        TypeDescription.Generic getDeclaringType();

        @Override // net.bytebuddy.description.method.MethodDescription, net.bytebuddy.description.method.MethodDescription.InDefinedShape
        ParameterList<ParameterDescription.InGenericShape> getParameters();
    }

    public static class Latent extends InDefinedShape.AbstractBase {
        private final List<? extends AnnotationDescription> declaredAnnotations;
        private final TypeDescription declaringType;

        @MaybeNull
        private final AnnotationValue<?, ?> defaultValue;
        private final List<? extends TypeDescription.Generic> exceptionTypes;
        private final String internalName;
        private final int modifiers;
        private final List<? extends ParameterDescription.Token> parameterTokens;

        @MaybeNull
        private final TypeDescription.Generic receiverType;
        private final TypeDescription.Generic returnType;
        private final List<? extends TypeVariableToken> typeVariables;

        public static class TypeInitializer extends InDefinedShape.AbstractBase {
            private final TypeDescription typeDescription;

            public TypeInitializer(TypeDescription typeDescription) {
                this.typeDescription = typeDescription;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationSource
            public AnnotationList getDeclaredAnnotations() {
                return new AnnotationList.Empty();
            }

            @Override // net.bytebuddy.description.method.MethodDescription
            @AlwaysNull
            public AnnotationValue<?, ?> getDefaultValue() {
                return AnnotationValue.UNDEFINED;
            }

            @Override // net.bytebuddy.description.method.MethodDescription
            public TypeList.Generic getExceptionTypes() {
                return new TypeList.Generic.Empty();
            }

            @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
            public String getInternalName() {
                return MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME;
            }

            @Override // net.bytebuddy.description.ModifierReviewable
            public int getModifiers() {
                return 8;
            }

            @Override // net.bytebuddy.description.method.MethodDescription, net.bytebuddy.description.method.MethodDescription.InDefinedShape
            public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                return new ParameterList.Empty();
            }

            @Override // net.bytebuddy.description.method.MethodDescription
            public TypeDescription.Generic getReturnType() {
                return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Void.TYPE);
            }

            @Override // net.bytebuddy.description.TypeVariableSource
            public TypeList.Generic getTypeVariables() {
                return new TypeList.Generic.Empty();
            }

            @Override // net.bytebuddy.description.DeclaredByType.WithMandatoryDeclaration, net.bytebuddy.description.DeclaredByType
            @Nonnull
            public TypeDescription getDeclaringType() {
                return this.typeDescription;
            }
        }

        public Latent(TypeDescription typeDescription, Token token) {
            this(typeDescription, token.getName(), token.getModifiers(), token.getTypeVariableTokens(), token.getReturnType(), token.getParameterTokens(), token.getExceptionTypes(), token.getAnnotations(), token.getDefaultValue(), token.getReceiverType());
        }

        @Override // net.bytebuddy.description.annotation.AnnotationSource
        public AnnotationList getDeclaredAnnotations() {
            return new AnnotationList.Explicit(this.declaredAnnotations);
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        @MaybeNull
        public AnnotationValue<?, ?> getDefaultValue() {
            return this.defaultValue;
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public TypeList.Generic getExceptionTypes() {
            return TypeList.Generic.ForDetachedTypes.attach(this, this.exceptionTypes);
        }

        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getInternalName() {
            return this.internalName;
        }

        @Override // net.bytebuddy.description.ModifierReviewable
        public int getModifiers() {
            return this.modifiers;
        }

        @Override // net.bytebuddy.description.method.MethodDescription, net.bytebuddy.description.method.MethodDescription.InDefinedShape
        public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
            return new ParameterList.ForTokens(this, this.parameterTokens);
        }

        @Override // net.bytebuddy.description.method.MethodDescription.InDefinedShape.AbstractBase, net.bytebuddy.description.method.MethodDescription
        @MaybeNull
        public TypeDescription.Generic getReceiverType() {
            TypeDescription.Generic generic = this.receiverType;
            return generic == null ? super.getReceiverType() : (TypeDescription.Generic) generic.accept(TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of(this));
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public TypeDescription.Generic getReturnType() {
            return (TypeDescription.Generic) this.returnType.accept(TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of(this));
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        public TypeList.Generic getTypeVariables() {
            return TypeList.Generic.ForDetachedTypes.attachVariables(this, this.typeVariables);
        }

        @Override // net.bytebuddy.description.DeclaredByType.WithMandatoryDeclaration, net.bytebuddy.description.DeclaredByType
        @Nonnull
        public TypeDescription getDeclaringType() {
            return this.declaringType;
        }

        public Latent(TypeDescription typeDescription, String str, int i, List<? extends TypeVariableToken> list, TypeDescription.Generic generic, List<? extends ParameterDescription.Token> list2, List<? extends TypeDescription.Generic> list3, List<? extends AnnotationDescription> list4, @MaybeNull AnnotationValue<?, ?> annotationValue, @MaybeNull TypeDescription.Generic generic2) {
            this.declaringType = typeDescription;
            this.internalName = str;
            this.modifiers = i;
            this.typeVariables = list;
            this.returnType = generic;
            this.parameterTokens = list2;
            this.exceptionTypes = list3;
            this.declaredAnnotations = list4;
            this.defaultValue = annotationValue;
            this.receiverType = generic2;
        }
    }

    public static class SignatureToken {
        private transient /* synthetic */ int hashCode;
        private final String name;
        private final List<? extends TypeDescription> parameterTypes;
        private final TypeDescription returnType;

        public SignatureToken(String str, TypeDescription typeDescription, TypeDescription... typeDescriptionArr) {
            this(str, typeDescription, (List<? extends TypeDescription>) Arrays.asList(typeDescriptionArr));
        }

        public TypeToken asTypeToken() {
            return new TypeToken(this.returnType, this.parameterTypes);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SignatureToken)) {
                return false;
            }
            SignatureToken signatureToken = (SignatureToken) obj;
            return this.name.equals(signatureToken.name) && this.returnType.equals(signatureToken.returnType) && this.parameterTypes.equals(signatureToken.parameterTypes);
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

        public String getName() {
            return this.name;
        }

        public List<TypeDescription> getParameterTypes() {
            return this.parameterTypes;
        }

        public TypeDescription getReturnType() {
            return this.returnType;
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int i;
            if (this.hashCode != 0) {
                i = 0;
            } else {
                i = a.i(this.returnType, this.name.hashCode() * 31, 31) + this.parameterTypes.hashCode();
            }
            if (i == 0) {
                return this.hashCode;
            }
            this.hashCode = i;
            return i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.returnType);
            sb.append(' ');
            sb.append(this.name);
            sb.append('(');
            boolean z6 = true;
            for (TypeDescription typeDescription : this.parameterTypes) {
                if (z6) {
                    z6 = false;
                } else {
                    sb.append(',');
                }
                sb.append(typeDescription);
            }
            sb.append(')');
            return sb.toString();
        }

        public SignatureToken(String str, TypeDescription typeDescription, List<? extends TypeDescription> list) {
            this.name = str;
            this.returnType = typeDescription;
            this.parameterTypes = list;
        }
    }

    public static class Token implements ByteCodeElement.Token<Token> {
        private final List<? extends AnnotationDescription> annotations;

        @MaybeNull
        private final AnnotationValue<?, ?> defaultValue;
        private final List<? extends TypeDescription.Generic> exceptionTypes;
        private transient /* synthetic */ int hashCode;
        private final int modifiers;
        private final String name;
        private final List<? extends ParameterDescription.Token> parameterTokens;

        @MaybeNull
        private final TypeDescription.Generic receiverType;
        private final TypeDescription.Generic returnType;
        private final List<? extends TypeVariableToken> typeVariableTokens;

        public Token(int i) {
            this(MethodDescription.CONSTRUCTOR_INTERNAL_NAME, i, TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Void.TYPE));
        }

        @Override // net.bytebuddy.description.ByteCodeElement.Token
        public /* bridge */ /* synthetic */ ByteCodeElement.Token accept(TypeDescription.Generic.Visitor visitor) {
            return accept((TypeDescription.Generic.Visitor<? extends TypeDescription.Generic>) visitor);
        }

        public SignatureToken asSignatureToken(TypeDescription typeDescription) {
            TypeDescription.Generic.Visitor.Reducing reducing = new TypeDescription.Generic.Visitor.Reducing(typeDescription, this.typeVariableTokens);
            ArrayList arrayList = new ArrayList(this.parameterTokens.size());
            Iterator<? extends ParameterDescription.Token> it = this.parameterTokens.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getType().accept(reducing));
            }
            return new SignatureToken(this.name, (TypeDescription) this.returnType.accept(reducing), arrayList);
        }

        public boolean equals(@MaybeNull Object obj) {
            AnnotationValue<?, ?> annotationValue;
            TypeDescription.Generic generic;
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                Token token = (Token) obj;
                if (this.modifiers == token.modifiers && this.name.equals(token.name) && this.typeVariableTokens.equals(token.typeVariableTokens) && this.returnType.equals(token.returnType) && this.parameterTokens.equals(token.parameterTokens) && this.exceptionTypes.equals(token.exceptionTypes) && this.annotations.equals(token.annotations) && ((annotationValue = this.defaultValue) == null ? token.defaultValue == null : annotationValue.equals(token.defaultValue)) && ((generic = this.receiverType) == null ? token.receiverType == null : generic.equals(token.receiverType))) {
                    return true;
                }
            }
            return false;
        }

        public AnnotationList getAnnotations() {
            return new AnnotationList.Explicit(this.annotations);
        }

        @MaybeNull
        public AnnotationValue<?, ?> getDefaultValue() {
            return this.defaultValue;
        }

        public TypeList.Generic getExceptionTypes() {
            return new TypeList.Generic.Explicit(this.exceptionTypes);
        }

        public int getModifiers() {
            return this.modifiers;
        }

        public String getName() {
            return this.name;
        }

        public ByteCodeElement.Token.TokenList<ParameterDescription.Token> getParameterTokens() {
            return new ByteCodeElement.Token.TokenList<>(this.parameterTokens);
        }

        @MaybeNull
        public TypeDescription.Generic getReceiverType() {
            return this.receiverType;
        }

        public TypeDescription.Generic getReturnType() {
            return this.returnType;
        }

        public ByteCodeElement.Token.TokenList<TypeVariableToken> getTypeVariableTokens() {
            return new ByteCodeElement.Token.TokenList<>(this.typeVariableTokens);
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            if (this.hashCode == 0) {
                int iHashCode = (this.annotations.hashCode() + ((this.exceptionTypes.hashCode() + ((this.parameterTokens.hashCode() + a.h(this.returnType, (this.typeVariableTokens.hashCode() + (((this.name.hashCode() * 31) + this.modifiers) * 31)) * 31, 31)) * 31)) * 31)) * 31;
                AnnotationValue<?, ?> annotationValue = this.defaultValue;
                int iHashCode2 = (iHashCode + (annotationValue != null ? annotationValue.hashCode() : 0)) * 31;
                TypeDescription.Generic generic = this.receiverType;
                iHashCode = (generic != null ? generic.hashCode() : 0) + iHashCode2;
            }
            if (iHashCode == 0) {
                return this.hashCode;
            }
            this.hashCode = iHashCode;
            return iHashCode;
        }

        public String toString() {
            return "MethodDescription.Token{name='" + this.name + "', modifiers=" + this.modifiers + ", typeVariableTokens=" + this.typeVariableTokens + ", returnType=" + this.returnType + ", parameterTokens=" + this.parameterTokens + ", exceptionTypes=" + this.exceptionTypes + ", annotations=" + this.annotations + ", defaultValue=" + this.defaultValue + ", receiverType=" + this.receiverType + '}';
        }

        public Token(String str, int i, TypeDescription.Generic generic) {
            this(str, i, generic, Collections.EMPTY_LIST);
        }

        @Override // net.bytebuddy.description.ByteCodeElement.Token
        public Token accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
            String str = this.name;
            int i = this.modifiers;
            List listAccept = getTypeVariableTokens().accept(visitor);
            TypeDescription.Generic generic = (TypeDescription.Generic) this.returnType.accept(visitor);
            List listAccept2 = getParameterTokens().accept(visitor);
            TypeList.Generic genericAccept = getExceptionTypes().accept(visitor);
            List<? extends AnnotationDescription> list = this.annotations;
            AnnotationValue<?, ?> annotationValue = this.defaultValue;
            TypeDescription.Generic generic2 = this.receiverType;
            return new Token(str, i, listAccept, generic, listAccept2, genericAccept, list, annotationValue, generic2 == null ? TypeDescription.Generic.UNDEFINED : (TypeDescription.Generic) generic2.accept(visitor));
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Token(String str, int i, TypeDescription.Generic generic, List<? extends TypeDescription.Generic> list) {
            List list2 = Collections.EMPTY_LIST;
            this(str, i, list2, generic, new ParameterDescription.Token.TypeList(list), list2, list2, AnnotationValue.UNDEFINED, TypeDescription.Generic.UNDEFINED);
        }

        public Token(String str, int i, List<? extends TypeVariableToken> list, TypeDescription.Generic generic, List<? extends ParameterDescription.Token> list2, List<? extends TypeDescription.Generic> list3, List<? extends AnnotationDescription> list4, @MaybeNull AnnotationValue<?, ?> annotationValue, @MaybeNull TypeDescription.Generic generic2) {
            this.name = str;
            this.modifiers = i;
            this.typeVariableTokens = list;
            this.returnType = generic;
            this.parameterTokens = list2;
            this.exceptionTypes = list3;
            this.annotations = list4;
            this.defaultValue = annotationValue;
            this.receiverType = generic2;
        }
    }

    public static class TypeSubstituting extends AbstractBase implements InGenericShape {
        private final TypeDescription.Generic declaringType;
        private final MethodDescription methodDescription;
        private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;

        public TypeSubstituting(TypeDescription.Generic generic, MethodDescription methodDescription, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
            this.declaringType = generic;
            this.methodDescription = methodDescription;
            this.visitor = visitor;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationSource
        public AnnotationList getDeclaredAnnotations() {
            return this.methodDescription.getDeclaredAnnotations();
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        @MaybeNull
        public AnnotationValue<?, ?> getDefaultValue() {
            return this.methodDescription.getDefaultValue();
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public TypeList.Generic getExceptionTypes() {
            return new TypeList.Generic.ForDetachedTypes(this.methodDescription.getExceptionTypes(), this.visitor);
        }

        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getInternalName() {
            return this.methodDescription.getInternalName();
        }

        @Override // net.bytebuddy.description.ModifierReviewable
        public int getModifiers() {
            return this.methodDescription.getModifiers();
        }

        @Override // net.bytebuddy.description.method.MethodDescription, net.bytebuddy.description.method.MethodDescription.InDefinedShape
        public ParameterList<ParameterDescription.InGenericShape> getParameters() {
            return new ParameterList.TypeSubstituting(this, this.methodDescription.getParameters(), this.visitor);
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public TypeDescription.Generic getReceiverType() {
            TypeDescription.Generic receiverType = this.methodDescription.getReceiverType();
            return receiverType == null ? TypeDescription.Generic.UNDEFINED : (TypeDescription.Generic) receiverType.accept(this.visitor);
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public TypeDescription.Generic getReturnType() {
            return (TypeDescription.Generic) this.methodDescription.getReturnType().accept(this.visitor);
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        public TypeList.Generic getTypeVariables() {
            return this.methodDescription.getTypeVariables().accept(this.visitor).filter(ElementMatchers.ofSort(TypeDefinition.Sort.VARIABLE));
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.method.MethodDescription
        public boolean isConstructor() {
            return this.methodDescription.isConstructor();
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.method.MethodDescription
        public boolean isMethod() {
            return this.methodDescription.isMethod();
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.method.MethodDescription
        public boolean isTypeInitializer() {
            return this.methodDescription.isTypeInitializer();
        }

        @Override // net.bytebuddy.description.ByteCodeElement.TypeDependant
        public InDefinedShape asDefined() {
            return this.methodDescription.asDefined();
        }

        @Override // net.bytebuddy.description.DeclaredByType.WithMandatoryDeclaration, net.bytebuddy.description.DeclaredByType
        @Nonnull
        public TypeDescription.Generic getDeclaringType() {
            return this.declaringType;
        }
    }

    public static class TypeToken {
        private transient /* synthetic */ int hashCode;
        private final List<? extends TypeDescription> parameterTypes;
        private final TypeDescription returnType;

        public TypeToken(TypeDescription typeDescription, List<? extends TypeDescription> list) {
            this.returnType = typeDescription;
            this.parameterTypes = list;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TypeToken)) {
                return false;
            }
            TypeToken typeToken = (TypeToken) obj;
            return this.returnType.equals(typeToken.returnType) && this.parameterTypes.equals(typeToken.parameterTypes);
        }

        public List<TypeDescription> getParameterTypes() {
            return this.parameterTypes;
        }

        public TypeDescription getReturnType() {
            return this.returnType;
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int iHashCode = this.hashCode != 0 ? 0 : (this.returnType.hashCode() * 31) + this.parameterTypes.hashCode();
            if (iHashCode == 0) {
                return this.hashCode;
            }
            this.hashCode = iHashCode;
            return iHashCode;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("(");
            Iterator<? extends TypeDescription> it = this.parameterTypes.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getDescriptor());
            }
            sb.append(')');
            sb.append(this.returnType.getDescriptor());
            return sb.toString();
        }
    }

    SignatureToken asSignatureToken();

    TypeToken asTypeToken();

    int getActualModifiers();

    int getActualModifiers(boolean z6);

    int getActualModifiers(boolean z6, Visibility visibility);

    @MaybeNull
    <T> T getDefaultValue(Class<T> cls);

    @MaybeNull
    AnnotationValue<?, ?> getDefaultValue();

    TypeList.Generic getExceptionTypes();

    ParameterList<?> getParameters();

    @MaybeNull
    TypeDescription.Generic getReceiverType();

    TypeDescription.Generic getReturnType();

    int getStackSize();

    boolean isBridgeCompatible(TypeToken typeToken);

    boolean isConstantBootstrap();

    boolean isConstantBootstrap(List<? extends TypeDefinition> list);

    boolean isConstructor();

    boolean isDefaultMethod();

    boolean isDefaultValue();

    boolean isDefaultValue(AnnotationValue<?, ?> annotationValue);

    boolean isInvokableOn(TypeDescription typeDescription);

    boolean isInvokeBootstrap();

    boolean isInvokeBootstrap(List<? extends TypeDefinition> list);

    boolean isMethod();

    boolean isSpecializableFor(TypeDescription typeDescription);

    boolean isTypeInitializer();

    boolean isVirtual();

    boolean represents(Constructor<?> constructor);

    boolean represents(Method method);
}
