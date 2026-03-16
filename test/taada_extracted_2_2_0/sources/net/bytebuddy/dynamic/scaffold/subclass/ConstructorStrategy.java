package net.bytebuddy.dynamic.scaffold.subclass;

import com.google.protobuf.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.Transformer;
import net.bytebuddy.dynamic.scaffold.MethodRegistry;
import net.bytebuddy.implementation.MethodCall;
import net.bytebuddy.implementation.SuperMethodCall;
import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.matcher.LatentMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
public interface ConstructorStrategy {

    public enum Default implements ConstructorStrategy {
        NO_CONSTRUCTORS { // from class: net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy.Default.1
            @Override // net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy.Default
            public List<MethodDescription.Token> doExtractConstructors(TypeDescription typeDescription) {
                return Collections.EMPTY_LIST;
            }

            @Override // net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy.Default
            public MethodRegistry doInject(MethodRegistry methodRegistry, MethodAttributeAppender.Factory factory) {
                return methodRegistry;
            }
        },
        DEFAULT_CONSTRUCTOR { // from class: net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy.Default.2
            @Override // net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy.Default
            public List<MethodDescription.Token> doExtractConstructors(TypeDescription typeDescription) {
                TypeDescription.Generic superClass = typeDescription.getSuperClass();
                if ((superClass == null ? new MethodList.Empty() : (MethodList) superClass.getDeclaredMethods().filter(ElementMatchers.isConstructor().and(ElementMatchers.takesArguments(0)).and(ElementMatchers.isVisibleTo(typeDescription)))).size() == 1) {
                    return Collections.singletonList(new MethodDescription.Token(1));
                }
                throw new IllegalArgumentException(typeDescription.getSuperClass() + " declares no constructor that is visible to " + typeDescription);
            }

            @Override // net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy.Default
            public MethodRegistry doInject(MethodRegistry methodRegistry, MethodAttributeAppender.Factory factory) {
                return methodRegistry.append(new LatentMatcher.Resolved(ElementMatchers.isConstructor()), new MethodRegistry.Handler.ForImplementation(SuperMethodCall.INSTANCE), factory, Transformer.NoOp.make());
            }
        },
        IMITATE_SUPER_CLASS { // from class: net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy.Default.3
            @Override // net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy.Default
            public List<MethodDescription.Token> doExtractConstructors(TypeDescription typeDescription) {
                TypeDescription.Generic superClass = typeDescription.getSuperClass();
                return (superClass == null ? new MethodList.Empty() : superClass.getDeclaredMethods().filter(ElementMatchers.isConstructor().and(ElementMatchers.isVisibleTo(typeDescription)))).asTokenList(ElementMatchers.is(typeDescription));
            }

            @Override // net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy.Default
            public MethodRegistry doInject(MethodRegistry methodRegistry, MethodAttributeAppender.Factory factory) {
                return methodRegistry.append(new LatentMatcher.Resolved(ElementMatchers.isConstructor()), new MethodRegistry.Handler.ForImplementation(SuperMethodCall.INSTANCE), factory, Transformer.NoOp.make());
            }
        },
        IMITATE_SUPER_CLASS_PUBLIC { // from class: net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy.Default.4
            @Override // net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy.Default
            public List<MethodDescription.Token> doExtractConstructors(TypeDescription typeDescription) {
                TypeDescription.Generic superClass = typeDescription.getSuperClass();
                return (superClass == null ? new MethodList.Empty() : superClass.getDeclaredMethods().filter(ElementMatchers.isPublic().and(ElementMatchers.isConstructor()))).asTokenList(ElementMatchers.is(typeDescription));
            }

            @Override // net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy.Default
            public MethodRegistry doInject(MethodRegistry methodRegistry, MethodAttributeAppender.Factory factory) {
                return methodRegistry.append(new LatentMatcher.Resolved(ElementMatchers.isConstructor()), new MethodRegistry.Handler.ForImplementation(SuperMethodCall.INSTANCE), factory, Transformer.NoOp.make());
            }
        },
        IMITATE_SUPER_CLASS_OPENING { // from class: net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy.Default.5
            @Override // net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy.Default
            public List<MethodDescription.Token> doExtractConstructors(TypeDescription typeDescription) {
                TypeDescription.Generic superClass = typeDescription.getSuperClass();
                return (superClass == null ? new MethodList.Empty() : superClass.getDeclaredMethods().filter(ElementMatchers.isConstructor().and(ElementMatchers.isVisibleTo(typeDescription)))).asTokenList(ElementMatchers.is(typeDescription));
            }

            @Override // net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy.Default
            public MethodRegistry doInject(MethodRegistry methodRegistry, MethodAttributeAppender.Factory factory) {
                return methodRegistry.append(new LatentMatcher.Resolved(ElementMatchers.isConstructor()), new MethodRegistry.Handler.ForImplementation(SuperMethodCall.INSTANCE), factory, Transformer.NoOp.make());
            }

            @Override // net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy.Default
            public int resolveModifier(int i) {
                return 1;
            }
        };

        @HashCodeAndEqualsPlugin.Enhance
        public static class WithMethodAttributeAppenderFactory implements ConstructorStrategy {
            private final Default delegate;
            private final MethodAttributeAppender.Factory methodAttributeAppenderFactory;

            public WithMethodAttributeAppenderFactory(Default r12, MethodAttributeAppender.Factory factory) {
                this.delegate = r12;
                this.methodAttributeAppenderFactory = factory;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                WithMethodAttributeAppenderFactory withMethodAttributeAppenderFactory = (WithMethodAttributeAppenderFactory) obj;
                return this.delegate.equals(withMethodAttributeAppenderFactory.delegate) && this.methodAttributeAppenderFactory.equals(withMethodAttributeAppenderFactory.methodAttributeAppenderFactory);
            }

            @Override // net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy
            public List<MethodDescription.Token> extractConstructors(TypeDescription typeDescription) {
                return this.delegate.extractConstructors(typeDescription);
            }

            public int hashCode() {
                return this.methodAttributeAppenderFactory.hashCode() + ((this.delegate.hashCode() + (getClass().hashCode() * 31)) * 31);
            }

            @Override // net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy
            public MethodRegistry inject(TypeDescription typeDescription, MethodRegistry methodRegistry) {
                return this.delegate.doInject(methodRegistry, this.methodAttributeAppenderFactory);
            }
        }

        public abstract List<MethodDescription.Token> doExtractConstructors(TypeDescription typeDescription);

        public abstract MethodRegistry doInject(MethodRegistry methodRegistry, MethodAttributeAppender.Factory factory);

        @Override // net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy
        public List<MethodDescription.Token> extractConstructors(TypeDescription typeDescription) {
            List<MethodDescription.Token> listDoExtractConstructors = doExtractConstructors(typeDescription);
            ArrayList arrayList = new ArrayList(listDoExtractConstructors.size());
            for (MethodDescription.Token token : listDoExtractConstructors) {
                arrayList.add(new MethodDescription.Token(token.getName(), resolveModifier(token.getModifiers()), token.getTypeVariableTokens(), token.getReturnType(), token.getParameterTokens(), token.getExceptionTypes(), token.getAnnotations(), token.getDefaultValue(), TypeDescription.Generic.UNDEFINED));
            }
            return arrayList;
        }

        @Override // net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy
        public MethodRegistry inject(TypeDescription typeDescription, MethodRegistry methodRegistry) {
            return doInject(methodRegistry, MethodAttributeAppender.NoOp.INSTANCE);
        }

        public int resolveModifier(int i) {
            return i;
        }

        public ConstructorStrategy with(MethodAttributeAppender.Factory factory) {
            return new WithMethodAttributeAppenderFactory(this, factory);
        }

        public ConstructorStrategy withInheritedAnnotations() {
            return new WithMethodAttributeAppenderFactory(this, MethodAttributeAppender.ForInstrumentedMethod.EXCLUDING_RECEIVER);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForDefaultConstructor implements ConstructorStrategy {
        private final ElementMatcher<? super MethodDescription> elementMatcher;
        private final MethodAttributeAppender.Factory methodAttributeAppenderFactory;

        public ForDefaultConstructor() {
            this(ElementMatchers.any());
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ForDefaultConstructor forDefaultConstructor = (ForDefaultConstructor) obj;
            return this.elementMatcher.equals(forDefaultConstructor.elementMatcher) && this.methodAttributeAppenderFactory.equals(forDefaultConstructor.methodAttributeAppenderFactory);
        }

        @Override // net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy
        public List<MethodDescription.Token> extractConstructors(TypeDescription typeDescription) {
            TypeDescription.Generic superClass = typeDescription.getSuperClass();
            if (superClass == null) {
                throw new IllegalArgumentException(a.m("Cannot extract constructors for ", typeDescription));
            }
            if (superClass.getDeclaredMethods().filter(ElementMatchers.isConstructor()).isEmpty()) {
                throw new IllegalStateException("Cannot define default constructor for class without super class constructor");
            }
            return Collections.singletonList(new MethodDescription.Token(1));
        }

        public int hashCode() {
            return this.methodAttributeAppenderFactory.hashCode() + a.j(this.elementMatcher, getClass().hashCode() * 31, 31);
        }

        @Override // net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy
        public MethodRegistry inject(TypeDescription typeDescription, MethodRegistry methodRegistry) {
            TypeDescription.Generic superClass = typeDescription.getSuperClass();
            if (superClass == null) {
                throw new IllegalArgumentException(a.m("Cannot inject constructors for ", typeDescription));
            }
            MethodList methodListFilter = superClass.getDeclaredMethods().filter(ElementMatchers.isConstructor().and(this.elementMatcher));
            if (methodListFilter.isEmpty()) {
                throw new IllegalStateException("No possible candidate for super constructor invocation in " + superClass);
            }
            if (!methodListFilter.filter(ElementMatchers.takesArguments(0)).isEmpty()) {
                methodListFilter = (MethodList) methodListFilter.filter(ElementMatchers.takesArguments(0));
            } else if (methodListFilter.size() > 1) {
                throw new IllegalStateException("More than one possible super constructor for constructor delegation: " + methodListFilter);
            }
            MethodCall methodCallInvoke = MethodCall.invoke((MethodDescription) methodListFilter.getOnly());
            Iterator<TypeDescription> it = ((MethodDescription) methodListFilter.getOnly()).getParameters().asTypeList().asErasures().iterator();
            while (it.hasNext()) {
                methodCallInvoke = methodCallInvoke.with(it.next().getDefaultValue());
            }
            return methodRegistry.append(new LatentMatcher.Resolved(ElementMatchers.isConstructor().and(ElementMatchers.takesArguments(0))), new MethodRegistry.Handler.ForImplementation(methodCallInvoke), this.methodAttributeAppenderFactory, Transformer.NoOp.make());
        }

        public ForDefaultConstructor(ElementMatcher<? super MethodDescription> elementMatcher) {
            this(elementMatcher, MethodAttributeAppender.NoOp.INSTANCE);
        }

        public ForDefaultConstructor(MethodAttributeAppender.Factory factory) {
            this(ElementMatchers.any(), factory);
        }

        public ForDefaultConstructor(ElementMatcher<? super MethodDescription> elementMatcher, MethodAttributeAppender.Factory factory) {
            this.elementMatcher = elementMatcher;
            this.methodAttributeAppenderFactory = factory;
        }
    }

    List<MethodDescription.Token> extractConstructors(TypeDescription typeDescription);

    MethodRegistry inject(TypeDescription typeDescription, MethodRegistry methodRegistry);
}
