package org.mockito.internal.util.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.util.MockUtil;
import org.mockito.plugins.MemberAccessor;

/* JADX INFO: loaded from: classes.dex */
public class FieldInitializer {
    private final Field field;
    private final Object fieldOwner;
    private final ConstructorInstantiator instantiator;

    public interface ConstructorArgumentResolver {
        Object[] resolveTypeInstances(Class<?>... clsArr);
    }

    public interface ConstructorInstantiator {
        FieldInitializationReport instantiate();
    }

    public static class NoArgConstructorInstantiator implements ConstructorInstantiator {
        private final Field field;
        private final Object testClass;

        public NoArgConstructorInstantiator(Object obj, Field field) {
            this.testClass = obj;
            this.field = field;
        }

        @Override // org.mockito.internal.util.reflection.FieldInitializer.ConstructorInstantiator
        public FieldInitializationReport instantiate() {
            MemberAccessor memberAccessor = Plugins.getMemberAccessor();
            try {
                memberAccessor.set(this.field, this.testClass, memberAccessor.lambda$newInstance$0(this.field.getType().getDeclaredConstructor(new Class[0]), new Object[0]));
                return new FieldInitializationReport(memberAccessor.get(this.field, this.testClass), true, false);
            } catch (IllegalAccessException e) {
                throw new MockitoException("IllegalAccessException (see the stack trace for cause): " + e, e);
            } catch (InstantiationException e6) {
                throw new MockitoException("InstantiationException (see the stack trace for cause): " + e6, e6);
            } catch (NoSuchMethodException e7) {
                throw new MockitoException("the type '" + this.field.getType().getSimpleName() + "' has no default constructor", e7);
            } catch (InvocationTargetException e8) {
                throw new MockitoException("the default constructor of type '" + this.field.getType().getSimpleName() + "' has raised an exception (see the stack trace for cause): " + e8.getTargetException(), e8);
            }
        }
    }

    public static class ParameterizedConstructorInstantiator implements ConstructorInstantiator {
        private final ConstructorArgumentResolver argResolver;
        private final Comparator<Constructor<?>> byParameterNumber = new Comparator<Constructor<?>>() { // from class: org.mockito.internal.util.reflection.FieldInitializer.ParameterizedConstructorInstantiator.1
            private int countMockableParams(Constructor<?> constructor) {
                int i = 0;
                for (Class<?> cls : constructor.getParameterTypes()) {
                    if (MockUtil.typeMockabilityOf(cls, null).mockable()) {
                        i++;
                    }
                }
                return i;
            }

            @Override // java.util.Comparator
            public int compare(Constructor<?> constructor, Constructor<?> constructor2) {
                int length = constructor2.getParameterTypes().length - constructor.getParameterTypes().length;
                if (length != 0) {
                    return length;
                }
                return countMockableParams(constructor2) - countMockableParams(constructor);
            }
        };
        private final Field field;
        private final Object testClass;

        public ParameterizedConstructorInstantiator(Object obj, Field field, ConstructorArgumentResolver constructorArgumentResolver) {
            this.testClass = obj;
            this.field = field;
            this.argResolver = constructorArgumentResolver;
        }

        private Constructor<?> biggestConstructor(Class<?> cls) {
            List listAsList = Arrays.asList(cls.getDeclaredConstructors());
            Collections.sort(listAsList, this.byParameterNumber);
            Constructor<?> constructor = (Constructor) listAsList.get(0);
            checkParameterized(constructor, this.field);
            return constructor;
        }

        private void checkParameterized(Constructor<?> constructor, Field field) {
            if (constructor.getParameterTypes().length != 0) {
                return;
            }
            throw new MockitoException("the field " + field.getName() + " of type " + field.getType() + " has no parameterized constructor");
        }

        @Override // org.mockito.internal.util.reflection.FieldInitializer.ConstructorInstantiator
        public FieldInitializationReport instantiate() {
            MemberAccessor memberAccessor = Plugins.getMemberAccessor();
            Constructor<?> constructorBiggestConstructor = biggestConstructor(this.field.getType());
            try {
                memberAccessor.set(this.field, this.testClass, memberAccessor.lambda$newInstance$0(constructorBiggestConstructor, this.argResolver.resolveTypeInstances(constructorBiggestConstructor.getParameterTypes())));
                return new FieldInitializationReport(memberAccessor.get(this.field, this.testClass), false, true);
            } catch (IllegalAccessException e) {
                throw new MockitoException("IllegalAccessException (see the stack trace for cause): " + e, e);
            } catch (IllegalArgumentException e6) {
                throw new MockitoException("internal error : argResolver provided incorrect types for constructor " + constructorBiggestConstructor + " of type " + this.field.getType().getSimpleName(), e6);
            } catch (InstantiationException e7) {
                throw new MockitoException("InstantiationException (see the stack trace for cause): " + e7, e7);
            } catch (InvocationTargetException e8) {
                throw new MockitoException("the constructor of type '" + this.field.getType().getSimpleName() + "' has raised an exception (see the stack trace for cause): " + e8.getTargetException(), e8);
            }
        }
    }

    public FieldInitializer(Object obj, Field field) {
        this(obj, field, new NoArgConstructorInstantiator(obj, field));
    }

    private FieldInitializationReport acquireFieldInstance() {
        Object obj = Plugins.getMemberAccessor().get(this.field, this.fieldOwner);
        return obj != null ? new FieldInitializationReport(obj, false, false) : this.instantiator.instantiate();
    }

    private void checkNotAbstract(Field field) {
        if (Modifier.isAbstract(field.getType().getModifiers())) {
            throw new MockitoException("the type '" + field.getType().getSimpleName() + "' is an abstract class.");
        }
    }

    private void checkNotEnum(Field field) {
        if (field.getType().isEnum()) {
            throw new MockitoException("the type '" + field.getType().getSimpleName() + "' is an enum.");
        }
    }

    private void checkNotInner(Field field) {
        Class<?> type = field.getType();
        if (!type.isMemberClass() || Modifier.isStatic(type.getModifiers())) {
            return;
        }
        throw new MockitoException("the type '" + type.getSimpleName() + "' is an inner non static class.");
    }

    private void checkNotInterface(Field field) {
        if (field.getType().isInterface()) {
            throw new MockitoException("the type '" + field.getType().getSimpleName() + "' is an interface.");
        }
    }

    private void checkNotLocal(Field field) {
        if (field.getType().isLocalClass()) {
            throw new MockitoException("the type '" + field.getType().getSimpleName() + "' is a local class.");
        }
    }

    public FieldInitializationReport initialize() {
        try {
            return acquireFieldInstance();
        } catch (IllegalAccessException e) {
            throw new MockitoException("Problems initializing field '" + this.field.getName() + "' of type '" + this.field.getType().getSimpleName() + "'", e);
        }
    }

    public FieldInitializer(Object obj, Field field, ConstructorArgumentResolver constructorArgumentResolver) {
        this(obj, field, new ParameterizedConstructorInstantiator(obj, field, constructorArgumentResolver));
    }

    private FieldInitializer(Object obj, Field field, ConstructorInstantiator constructorInstantiator) {
        if (new FieldReader(obj, field).isNull()) {
            checkNotLocal(field);
            checkNotInner(field);
            checkNotInterface(field);
            checkNotEnum(field);
            checkNotAbstract(field);
        }
        this.fieldOwner = obj;
        this.field = field;
        this.instantiator = constructorInstantiator;
    }
}
