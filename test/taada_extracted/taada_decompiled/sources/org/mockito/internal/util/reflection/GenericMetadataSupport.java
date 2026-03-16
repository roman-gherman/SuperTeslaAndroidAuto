package org.mockito.internal.util.reflection;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.util.Checks;

/* JADX INFO: loaded from: classes.dex */
public abstract class GenericMetadataSupport {
    protected Map<TypeVariable<?>, Type> contextualActualTypeParameters = new HashMap();

    public interface BoundedType extends Type {
        Type firstBound();

        Type[] interfaceBounds();
    }

    public static class FromClassGenericMetadataSupport extends GenericMetadataSupport {
        private final Class<?> clazz;

        public FromClassGenericMetadataSupport(Class<?> cls) {
            this.clazz = cls;
            registerTypeParametersOn(cls.getTypeParameters());
            registerAllTypeVariables(cls);
        }

        @Override // org.mockito.internal.util.reflection.GenericMetadataSupport
        public Class<?> rawType() {
            return this.clazz;
        }
    }

    public static class FromParameterizedTypeGenericMetadataSupport extends GenericMetadataSupport {
        private final ParameterizedType parameterizedType;

        public FromParameterizedTypeGenericMetadataSupport(ParameterizedType parameterizedType) {
            this.parameterizedType = parameterizedType;
            readActualTypeParameters();
        }

        private void readActualTypeParameters() {
            registerAllTypeVariables(this.parameterizedType);
        }

        @Override // org.mockito.internal.util.reflection.GenericMetadataSupport
        public Class<?> rawType() {
            return (Class) this.parameterizedType.getRawType();
        }
    }

    public static class GenericArrayReturnType extends GenericMetadataSupport {
        private final int arity;
        private final GenericMetadataSupport genericArrayType;

        public GenericArrayReturnType(GenericMetadataSupport genericMetadataSupport, int i) {
            this.genericArrayType = genericMetadataSupport;
            this.arity = i;
        }

        @Override // org.mockito.internal.util.reflection.GenericMetadataSupport
        public Class<?> rawType() {
            Class<?> clsRawType = this.genericArrayType.rawType();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.arity; i++) {
                sb.append("[");
            }
            try {
                sb.append("L");
                sb.append(clsRawType.getName());
                sb.append(";");
                return Class.forName(sb.toString(), false, clsRawType.getClassLoader());
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("This was not supposed to happen.", e);
            }
        }
    }

    public static class NotGenericReturnTypeSupport extends GenericMetadataSupport {
        private final Class<?> returnType;

        public NotGenericReturnTypeSupport(GenericMetadataSupport genericMetadataSupport, Type type) {
            Class<?> cls = (Class) type;
            this.returnType = cls;
            this.contextualActualTypeParameters = genericMetadataSupport.contextualActualTypeParameters;
            registerAllTypeVariables(cls);
        }

        @Override // org.mockito.internal.util.reflection.GenericMetadataSupport
        public Class<?> rawType() {
            return this.returnType;
        }
    }

    public static class ParameterizedReturnType extends GenericMetadataSupport {
        private final ParameterizedType parameterizedType;
        private final TypeVariable<?>[] typeParameters;

        public ParameterizedReturnType(GenericMetadataSupport genericMetadataSupport, TypeVariable<?>[] typeVariableArr, ParameterizedType parameterizedType) {
            this.parameterizedType = parameterizedType;
            this.typeParameters = typeVariableArr;
            this.contextualActualTypeParameters = genericMetadataSupport.contextualActualTypeParameters;
            readTypeParameters();
            readTypeVariables();
        }

        private void readTypeParameters() {
            registerTypeParametersOn(this.typeParameters);
        }

        private void readTypeVariables() {
            registerTypeVariablesOn(this.parameterizedType);
        }

        @Override // org.mockito.internal.util.reflection.GenericMetadataSupport
        public Class<?> rawType() {
            return (Class) this.parameterizedType.getRawType();
        }
    }

    public static class TypeVarBoundedType implements BoundedType {
        private final TypeVariable<?> typeVariable;

        public TypeVarBoundedType(TypeVariable<?> typeVariable) {
            this.typeVariable = typeVariable;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.typeVariable.equals(((TypeVarBoundedType) obj).typeVariable);
        }

        @Override // org.mockito.internal.util.reflection.GenericMetadataSupport.BoundedType
        public Type firstBound() {
            return this.typeVariable.getBounds()[0];
        }

        public int hashCode() {
            return this.typeVariable.hashCode();
        }

        @Override // org.mockito.internal.util.reflection.GenericMetadataSupport.BoundedType
        public Type[] interfaceBounds() {
            Type[] typeArr = new Type[this.typeVariable.getBounds().length - 1];
            System.arraycopy(this.typeVariable.getBounds(), 1, typeArr, 0, this.typeVariable.getBounds().length - 1);
            return typeArr;
        }

        public String toString() {
            return "{firstBound=" + firstBound() + ", interfaceBounds=" + Arrays.deepToString(interfaceBounds()) + '}';
        }

        public TypeVariable<?> typeVariable() {
            return this.typeVariable;
        }
    }

    public static class TypeVariableReturnType extends GenericMetadataSupport {
        private List<Type> extraInterfaces;
        private Class<?> rawType;
        private final TypeVariable<?>[] typeParameters;
        private final TypeVariable<?> typeVariable;

        public TypeVariableReturnType(GenericMetadataSupport genericMetadataSupport, TypeVariable<?>[] typeVariableArr, TypeVariable<?> typeVariable) {
            this.typeParameters = typeVariableArr;
            this.typeVariable = typeVariable;
            this.contextualActualTypeParameters = genericMetadataSupport.contextualActualTypeParameters;
            readTypeParameters();
            readTypeVariables();
        }

        private Type extractActualBoundedTypeOf(Type type) {
            if (type instanceof TypeVariable) {
                return extractActualBoundedTypeOf(this.contextualActualTypeParameters.get(type));
            }
            if (!(type instanceof BoundedType)) {
                return type;
            }
            Type typeExtractActualBoundedTypeOf = extractActualBoundedTypeOf(((BoundedType) type).firstBound());
            return !(typeExtractActualBoundedTypeOf instanceof BoundedType) ? type : typeExtractActualBoundedTypeOf;
        }

        private void readTypeParameters() {
            registerTypeParametersOn(this.typeParameters);
        }

        private void readTypeVariables() {
            for (Type type : this.typeVariable.getBounds()) {
                registerTypeVariablesOn(type);
            }
            registerTypeParametersOn(new TypeVariable[]{this.typeVariable});
            registerTypeVariablesOn(getActualTypeArgumentFor(this.typeVariable));
        }

        @Override // org.mockito.internal.util.reflection.GenericMetadataSupport
        public List<Type> extraInterfaces() {
            List<Type> list = this.extraInterfaces;
            if (list != null) {
                return list;
            }
            Type typeExtractActualBoundedTypeOf = extractActualBoundedTypeOf(this.typeVariable);
            if (typeExtractActualBoundedTypeOf instanceof BoundedType) {
                List<Type> listAsList = Arrays.asList(((BoundedType) typeExtractActualBoundedTypeOf).interfaceBounds());
                this.extraInterfaces = listAsList;
                return listAsList;
            }
            if (typeExtractActualBoundedTypeOf instanceof ParameterizedType) {
                List<Type> listSingletonList = Collections.singletonList(typeExtractActualBoundedTypeOf);
                this.extraInterfaces = listSingletonList;
                return listSingletonList;
            }
            if (typeExtractActualBoundedTypeOf instanceof Class) {
                List<Type> list2 = Collections.EMPTY_LIST;
                this.extraInterfaces = list2;
                return list2;
            }
            throw new MockitoException("Cannot extract extra-interfaces from '" + this.typeVariable + "' : '" + typeExtractActualBoundedTypeOf + "'");
        }

        @Override // org.mockito.internal.util.reflection.GenericMetadataSupport
        public Class<?>[] rawExtraInterfaces() {
            List<Type> listExtraInterfaces = extraInterfaces();
            ArrayList arrayList = new ArrayList();
            Iterator<Type> it = listExtraInterfaces.iterator();
            while (it.hasNext()) {
                Class<?> clsExtractRawTypeOf = extractRawTypeOf(it.next());
                if (!rawType().equals(clsExtractRawTypeOf)) {
                    arrayList.add(clsExtractRawTypeOf);
                }
            }
            return (Class[]) arrayList.toArray(new Class[arrayList.size()]);
        }

        @Override // org.mockito.internal.util.reflection.GenericMetadataSupport
        public Class<?> rawType() {
            if (this.rawType == null) {
                this.rawType = extractRawTypeOf(this.typeVariable);
            }
            return this.rawType;
        }
    }

    public static class WildCardBoundedType implements BoundedType {
        private final WildcardType wildcard;

        public WildCardBoundedType(WildcardType wildcardType) {
            this.wildcard = wildcardType;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.wildcard.equals(((TypeVarBoundedType) obj).typeVariable);
        }

        @Override // org.mockito.internal.util.reflection.GenericMetadataSupport.BoundedType
        public Type firstBound() {
            Type[] lowerBounds = this.wildcard.getLowerBounds();
            return lowerBounds.length != 0 ? lowerBounds[0] : this.wildcard.getUpperBounds()[0];
        }

        public int hashCode() {
            return this.wildcard.hashCode();
        }

        @Override // org.mockito.internal.util.reflection.GenericMetadataSupport.BoundedType
        public Type[] interfaceBounds() {
            return new Type[0];
        }

        public String toString() {
            return "{firstBound=" + firstBound() + ", interfaceBounds=[]}";
        }

        public WildcardType wildCard() {
            return this.wildcard;
        }
    }

    private BoundedType boundsOf(TypeVariable<?> typeVariable) {
        return typeVariable.getBounds()[0] instanceof TypeVariable ? boundsOf((TypeVariable<?>) typeVariable.getBounds()[0]) : new TypeVarBoundedType(typeVariable);
    }

    public static GenericMetadataSupport inferFrom(Type type) {
        Checks.checkNotNull(type, "type");
        if (type instanceof Class) {
            return new FromClassGenericMetadataSupport((Class) type);
        }
        if (type instanceof ParameterizedType) {
            return new FromParameterizedTypeGenericMetadataSupport((ParameterizedType) type);
        }
        throw new MockitoException("Type meta-data for this Type (" + type.getClass().getCanonicalName() + ") is not supported : " + type);
    }

    private void registerTypeVariableIfNotPresent(TypeVariable<?> typeVariable) {
        if (this.contextualActualTypeParameters.containsKey(typeVariable)) {
            return;
        }
        this.contextualActualTypeParameters.put(typeVariable, boundsOf(typeVariable));
    }

    private GenericMetadataSupport resolveGenericType(Type type, Method method) {
        if (type instanceof Class) {
            return new NotGenericReturnTypeSupport(this, type);
        }
        if (type instanceof ParameterizedType) {
            return new ParameterizedReturnType(this, method.getTypeParameters(), (ParameterizedType) type);
        }
        if (type instanceof TypeVariable) {
            return new TypeVariableReturnType(this, method.getTypeParameters(), (TypeVariable) type);
        }
        throw new MockitoException("Ouch, it shouldn't happen, type '" + type.getClass().getCanonicalName() + "' on method : '" + method.toGenericString() + "' is not supported : " + type);
    }

    public Map<TypeVariable<?>, Type> actualTypeArguments() {
        TypeVariable<Class<?>>[] typeParameters = rawType().getTypeParameters();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (TypeVariable<Class<?>> typeVariable : typeParameters) {
            linkedHashMap.put(typeVariable, getActualTypeArgumentFor(typeVariable));
        }
        return linkedHashMap;
    }

    public List<Type> extraInterfaces() {
        return Collections.EMPTY_LIST;
    }

    public Class<?> extractRawTypeOf(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) type).getRawType();
        }
        if (type instanceof BoundedType) {
            return extractRawTypeOf(((BoundedType) type).firstBound());
        }
        if (type instanceof TypeVariable) {
            return extractRawTypeOf(this.contextualActualTypeParameters.get(type));
        }
        throw new MockitoException("Raw extraction not supported for : '" + type + "'");
    }

    public Type getActualTypeArgumentFor(TypeVariable<?> typeVariable) {
        Type type = this.contextualActualTypeParameters.get(typeVariable);
        return type instanceof TypeVariable ? getActualTypeArgumentFor((TypeVariable) type) : type;
    }

    public boolean hasRawExtraInterfaces() {
        return rawExtraInterfaces().length > 0;
    }

    public Class<?>[] rawExtraInterfaces() {
        return new Class[0];
    }

    public abstract Class<?> rawType();

    public void registerAllTypeVariables(Type type) {
        LinkedList linkedList = new LinkedList();
        HashSet hashSet = new HashSet();
        linkedList.add(type);
        while (!linkedList.isEmpty()) {
            Type type2 = (Type) linkedList.poll();
            if (type2 != null && !hashSet.contains(type2)) {
                registerTypeVariablesOn(type2);
                hashSet.add(type2);
                Class<?> clsExtractRawTypeOf = extractRawTypeOf(type2);
                linkedList.add(clsExtractRawTypeOf.getGenericSuperclass());
                linkedList.addAll(Arrays.asList(clsExtractRawTypeOf.getGenericInterfaces()));
            }
        }
    }

    public void registerTypeParametersOn(TypeVariable<?>[] typeVariableArr) {
        for (TypeVariable<?> typeVariable : typeVariableArr) {
            registerTypeVariableIfNotPresent(typeVariable);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void registerTypeVariablesOn(java.lang.reflect.Type r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof java.lang.reflect.ParameterizedType
            if (r0 != 0) goto L5
            goto L4a
        L5:
            java.lang.reflect.ParameterizedType r6 = (java.lang.reflect.ParameterizedType) r6
            java.lang.reflect.Type r0 = r6.getRawType()
            java.lang.Class r0 = (java.lang.Class) r0
            java.lang.reflect.TypeVariable[] r0 = r0.getTypeParameters()
            java.lang.reflect.Type[] r6 = r6.getActualTypeArguments()
            r1 = 0
        L16:
            int r2 = r6.length
            if (r1 >= r2) goto L4a
            r2 = r0[r1]
            r3 = r6[r1]
            boolean r4 = r3 instanceof java.lang.reflect.TypeVariable
            if (r4 == 0) goto L30
            r4 = r3
            java.lang.reflect.TypeVariable r4 = (java.lang.reflect.TypeVariable) r4
            r5.registerTypeVariableIfNotPresent(r4)
            java.util.Map<java.lang.reflect.TypeVariable<?>, java.lang.reflect.Type> r4 = r5.contextualActualTypeParameters
            boolean r4 = r4.containsKey(r2)
            if (r4 == 0) goto L30
            goto L47
        L30:
            boolean r4 = r3 instanceof java.lang.reflect.WildcardType
            if (r4 == 0) goto L40
            java.util.Map<java.lang.reflect.TypeVariable<?>, java.lang.reflect.Type> r4 = r5.contextualActualTypeParameters
            java.lang.reflect.WildcardType r3 = (java.lang.reflect.WildcardType) r3
            org.mockito.internal.util.reflection.GenericMetadataSupport$BoundedType r3 = r5.boundsOf(r3)
            r4.put(r2, r3)
            goto L47
        L40:
            if (r2 == r3) goto L47
            java.util.Map<java.lang.reflect.TypeVariable<?>, java.lang.reflect.Type> r4 = r5.contextualActualTypeParameters
            r4.put(r2, r3)
        L47:
            int r1 = r1 + 1
            goto L16
        L4a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mockito.internal.util.reflection.GenericMetadataSupport.registerTypeVariablesOn(java.lang.reflect.Type):void");
    }

    public GenericMetadataSupport resolveGenericReturnType(Method method) {
        Type genericReturnType = method.getGenericReturnType();
        int i = 0;
        while (genericReturnType instanceof GenericArrayType) {
            i++;
            genericReturnType = ((GenericArrayType) genericReturnType).getGenericComponentType();
        }
        GenericMetadataSupport genericMetadataSupportResolveGenericType = resolveGenericType(genericReturnType, method);
        return i == 0 ? genericMetadataSupportResolveGenericType : new GenericArrayReturnType(genericMetadataSupportResolveGenericType, i);
    }

    private BoundedType boundsOf(WildcardType wildcardType) {
        WildCardBoundedType wildCardBoundedType = new WildCardBoundedType(wildcardType);
        return wildCardBoundedType.firstBound() instanceof TypeVariable ? boundsOf((TypeVariable<?>) wildCardBoundedType.firstBound()) : wildCardBoundedType;
    }
}
