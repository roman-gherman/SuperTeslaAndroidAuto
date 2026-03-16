package net.bytebuddy.build;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.build.Plugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.modifier.FieldPersistence;
import net.bytebuddy.description.modifier.Ownership;
import net.bytebuddy.description.modifier.SyntheticState;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.RandomString;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
@HashCodeAndEqualsPlugin.Enhance
public class CachedReturnPlugin extends Plugin.ForElementMatcher implements Plugin.Factory {
    private static final String ADVICE_INFIX = "$Advice$";
    private static final MethodDescription.InDefinedShape ENHANCE_VALUE = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType.of(Enhance.class).getDeclaredMethods().filter(ElementMatchers.named("value")).getOnly();
    private static final String NAME_INFIX = "_";

    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
    private final Map<TypeDescription, TypeDescription> adviceByType;
    private final ClassFileLocator classFileLocator;
    private final boolean ignoreExistingFields;

    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
    private final RandomString randomString;

    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CacheField {
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class CacheFieldOffsetMapping implements Advice.OffsetMapping {
        private final String name;

        public CacheFieldOffsetMapping(String str) {
            this.name = str;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.name.equals(((CacheFieldOffsetMapping) obj).name);
        }

        public int hashCode() {
            return this.name.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.asm.Advice.OffsetMapping
        public Advice.OffsetMapping.Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, Advice.ArgumentHandler argumentHandler, Advice.OffsetMapping.Sort sort) {
            return new Advice.OffsetMapping.Target.ForField.ReadWrite((FieldDescription) typeDescription.getDeclaredFields().filter(ElementMatchers.named(this.name)).getOnly());
        }
    }

    @Target({ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Enhance {
        String value() default "";
    }

    public CachedReturnPlugin() {
        this(false);
    }

    @Override // net.bytebuddy.build.Plugin
    @SuppressFBWarnings(justification = "Annotation presence is required by matcher.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
    public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        for (MethodDescription.InDefinedShape inDefinedShape : typeDescription.getDeclaredMethods().filter(ElementMatchers.not(ElementMatchers.isBridge()).and(ElementMatchers.isAnnotatedWith((Class<? extends Annotation>) Enhance.class)))) {
            if (inDefinedShape.isAbstract()) {
                throw new IllegalStateException("Cannot cache the value of an abstract method: " + inDefinedShape);
            }
            if (!inDefinedShape.getParameters().isEmpty()) {
                throw new IllegalStateException("Cannot cache the value of a method with parameters: " + inDefinedShape);
            }
            if (inDefinedShape.getReturnType().represents(Void.TYPE)) {
                throw new IllegalStateException("Cannot cache void result for " + inDefinedShape);
            }
            String str = (String) inDefinedShape.getDeclaredAnnotations().ofType(Enhance.class).getValue(ENHANCE_VALUE).resolve(String.class);
            if (str.length() == 0) {
                str = inDefinedShape.getName() + "_" + this.randomString.nextString();
            } else if (this.ignoreExistingFields && !typeDescription.getDeclaredFields().filter(ElementMatchers.named(str)).isEmpty()) {
                break;
            }
            builder = builder.defineField(str, inDefinedShape.getReturnType().asErasure(), inDefinedShape.isStatic() ? Ownership.STATIC : Ownership.MEMBER, inDefinedShape.isStatic() ? FieldPersistence.PLAIN : FieldPersistence.TRANSIENT, Visibility.PRIVATE, SyntheticState.SYNTHETIC).visit(Advice.withCustomMapping().bind(CacheField.class, (Advice.OffsetMapping) new CacheFieldOffsetMapping(str)).to(this.adviceByType.get(inDefinedShape.getReturnType().isPrimitive() ? inDefinedShape.getReturnType().asErasure() : TypeDescription.ForLoadedType.of(Object.class)), this.classFileLocator).on(ElementMatchers.is(inDefinedShape)));
        }
        return builder;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // net.bytebuddy.build.Plugin.ForElementMatcher
    public boolean equals(@MaybeNull Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CachedReturnPlugin cachedReturnPlugin = (CachedReturnPlugin) obj;
        return this.ignoreExistingFields == cachedReturnPlugin.ignoreExistingFields && this.classFileLocator.equals(cachedReturnPlugin.classFileLocator);
    }

    @Override // net.bytebuddy.build.Plugin.ForElementMatcher
    public int hashCode() {
        return this.classFileLocator.hashCode() + (((super.hashCode() * 31) + (this.ignoreExistingFields ? 1 : 0)) * 31);
    }

    @Override // net.bytebuddy.build.Plugin.Factory
    public Plugin make() {
        return this;
    }

    public CachedReturnPlugin(boolean z6) {
        super(ElementMatchers.declaresMethod(ElementMatchers.isAnnotatedWith((Class<? extends Annotation>) Enhance.class)));
        this.ignoreExistingFields = z6;
        this.randomString = new RandomString();
        ClassFileLocator classFileLocatorOf = ClassFileLocator.ForClassLoader.of(CachedReturnPlugin.class.getClassLoader());
        this.classFileLocator = classFileLocatorOf;
        TypePool typePoolOf = TypePool.Default.of(classFileLocatorOf);
        this.adviceByType = new HashMap();
        Class[] clsArr = {Boolean.TYPE, Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Object.class};
        for (int i = 0; i < 9; i++) {
            Class cls = clsArr[i];
            this.adviceByType.put(TypeDescription.ForLoadedType.of(cls), typePoolOf.describe(CachedReturnPlugin.class.getName() + ADVICE_INFIX + cls.getSimpleName()).resolve());
        }
    }
}
