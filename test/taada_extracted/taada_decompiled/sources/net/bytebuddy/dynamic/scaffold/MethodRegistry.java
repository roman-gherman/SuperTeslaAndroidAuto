package net.bytebuddy.dynamic.scaffold;

import com.google.protobuf.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.Transformer;
import net.bytebuddy.dynamic.VisibilityBridgeStrategy;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.matcher.LatentMatcher;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
public interface MethodRegistry {

    public interface Compiled extends TypeWriter.MethodPool {
        MethodList<?> getInstrumentedMethods();

        TypeDescription getInstrumentedType();

        LoadedTypeInitializer getLoadedTypeInitializer();

        MethodList<?> getMethods();

        TypeInitializer getTypeInitializer();
    }

    public interface Handler extends InstrumentedType.Prepareable {

        public interface Compiled {
            TypeWriter.MethodPool.Record assemble(MethodDescription methodDescription, MethodAttributeAppender methodAttributeAppender, Visibility visibility);
        }

        public enum ForAbstractMethod implements Handler, Compiled {
            INSTANCE;

            @Override // net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.Compiled
            public TypeWriter.MethodPool.Record assemble(MethodDescription methodDescription, MethodAttributeAppender methodAttributeAppender, Visibility visibility) {
                return new TypeWriter.MethodPool.Record.ForDefinedMethod.WithoutBody(methodDescription, methodAttributeAppender, visibility);
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler
            public Compiled compile(Implementation.Target target) {
                return this;
            }

            @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForAnnotationValue implements Handler, Compiled {
            private final AnnotationValue<?, ?> annotationValue;

            public ForAnnotationValue(AnnotationValue<?, ?> annotationValue) {
                this.annotationValue = annotationValue;
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.Compiled
            public TypeWriter.MethodPool.Record assemble(MethodDescription methodDescription, MethodAttributeAppender methodAttributeAppender, Visibility visibility) {
                return new TypeWriter.MethodPool.Record.ForDefinedMethod.WithAnnotationDefaultValue(methodDescription, this.annotationValue, methodAttributeAppender);
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler
            public Compiled compile(Implementation.Target target) {
                return this;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.annotationValue.equals(((ForAnnotationValue) obj).annotationValue);
            }

            public int hashCode() {
                return this.annotationValue.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForImplementation implements Handler {
            private final Implementation implementation;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Compiled implements Compiled {
                private final ByteCodeAppender byteCodeAppender;

                public Compiled(ByteCodeAppender byteCodeAppender) {
                    this.byteCodeAppender = byteCodeAppender;
                }

                @Override // net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.Compiled
                public TypeWriter.MethodPool.Record assemble(MethodDescription methodDescription, MethodAttributeAppender methodAttributeAppender, Visibility visibility) {
                    return new TypeWriter.MethodPool.Record.ForDefinedMethod.WithBody(methodDescription, this.byteCodeAppender, methodAttributeAppender, visibility);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.byteCodeAppender.equals(((Compiled) obj).byteCodeAppender);
                }

                public int hashCode() {
                    return this.byteCodeAppender.hashCode() + (getClass().hashCode() * 31);
                }
            }

            public ForImplementation(Implementation implementation) {
                this.implementation = implementation;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.implementation.equals(((ForImplementation) obj).implementation);
            }

            public int hashCode() {
                return this.implementation.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return this.implementation.prepare(instrumentedType);
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler
            public Compiled compile(Implementation.Target target) {
                return new Compiled(this.implementation.appender(target));
            }
        }

        public enum ForVisibilityBridge implements Handler {
            INSTANCE;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Compiled implements Compiled {
                private final TypeDescription instrumentedType;

                public Compiled(TypeDescription typeDescription) {
                    this.instrumentedType = typeDescription;
                }

                @Override // net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.Compiled
                public TypeWriter.MethodPool.Record assemble(MethodDescription methodDescription, MethodAttributeAppender methodAttributeAppender, Visibility visibility) {
                    return TypeWriter.MethodPool.Record.ForDefinedMethod.OfVisibilityBridge.of(this.instrumentedType, methodDescription, methodAttributeAppender);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.instrumentedType.equals(((Compiled) obj).instrumentedType);
                }

                public int hashCode() {
                    return this.instrumentedType.hashCode() + (getClass().hashCode() * 31);
                }
            }

            @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                throw new IllegalStateException("A visibility bridge handler must not apply any preparations");
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler
            public Compiled compile(Implementation.Target target) {
                return new Compiled(target.getInstrumentedType());
            }
        }

        Compiled compile(Implementation.Target target);
    }

    public interface Prepared {
        Compiled compile(Implementation.Target.Factory factory, ClassFileVersion classFileVersion);

        MethodList<?> getInstrumentedMethods();

        TypeDescription getInstrumentedType();

        LoadedTypeInitializer getLoadedTypeInitializer();

        MethodList<?> getMethods();

        TypeInitializer getTypeInitializer();
    }

    MethodRegistry append(LatentMatcher<? super MethodDescription> latentMatcher, Handler handler, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer);

    Prepared prepare(InstrumentedType instrumentedType, MethodGraph.Compiler compiler, TypeValidation typeValidation, VisibilityBridgeStrategy visibilityBridgeStrategy, LatentMatcher<? super MethodDescription> latentMatcher);

    MethodRegistry prepend(LatentMatcher<? super MethodDescription> latentMatcher, Handler handler, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer);

    @HashCodeAndEqualsPlugin.Enhance
    public static class Default implements MethodRegistry {
        private final List<Entry> entries;

        @HashCodeAndEqualsPlugin.Enhance
        public static class Compiled implements Compiled {
            private final LinkedHashMap<MethodDescription, Entry> implementations;
            private final TypeDescription instrumentedType;
            private final LoadedTypeInitializer loadedTypeInitializer;
            private final MethodList<?> methods;
            private final boolean supportsBridges;
            private final TypeInitializer typeInitializer;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Entry {
                private final MethodAttributeAppender attributeAppender;
                private final boolean bridgeMethod;
                private final Set<MethodDescription.TypeToken> bridgeTypes;
                private final Handler.Compiled handler;
                private final MethodDescription methodDescription;
                private final Visibility visibility;

                public Entry(Handler.Compiled compiled, MethodAttributeAppender methodAttributeAppender, MethodDescription methodDescription, Set<MethodDescription.TypeToken> set, Visibility visibility, boolean z6) {
                    this.handler = compiled;
                    this.attributeAppender = methodAttributeAppender;
                    this.methodDescription = methodDescription;
                    this.bridgeTypes = set;
                    this.visibility = visibility;
                    this.bridgeMethod = z6;
                }

                public TypeWriter.MethodPool.Record bind(TypeDescription typeDescription, boolean z6) {
                    if (this.bridgeMethod && !z6) {
                        return new TypeWriter.MethodPool.Record.ForNonImplementedMethod(this.methodDescription);
                    }
                    TypeWriter.MethodPool.Record recordAssemble = this.handler.assemble(this.methodDescription, this.attributeAppender, this.visibility);
                    return z6 ? TypeWriter.MethodPool.Record.AccessBridgeWrapper.of(recordAssemble, typeDescription, this.methodDescription, this.bridgeTypes, this.attributeAppender) : recordAssemble;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Entry entry = (Entry) obj;
                    return this.bridgeMethod == entry.bridgeMethod && this.visibility.equals(entry.visibility) && this.handler.equals(entry.handler) && this.attributeAppender.equals(entry.attributeAppender) && this.methodDescription.equals(entry.methodDescription) && this.bridgeTypes.equals(entry.bridgeTypes);
                }

                public int hashCode() {
                    return ((this.visibility.hashCode() + ((this.bridgeTypes.hashCode() + a.f(this.methodDescription, (this.attributeAppender.hashCode() + ((this.handler.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31, 31)) * 31)) * 31) + (this.bridgeMethod ? 1 : 0);
                }
            }

            public Compiled(TypeDescription typeDescription, LoadedTypeInitializer loadedTypeInitializer, TypeInitializer typeInitializer, MethodList<?> methodList, LinkedHashMap<MethodDescription, Entry> linkedHashMap, boolean z6) {
                this.instrumentedType = typeDescription;
                this.loadedTypeInitializer = loadedTypeInitializer;
                this.typeInitializer = typeInitializer;
                this.methods = methodList;
                this.implementations = linkedHashMap;
                this.supportsBridges = z6;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Compiled compiled = (Compiled) obj;
                return this.supportsBridges == compiled.supportsBridges && this.instrumentedType.equals(compiled.instrumentedType) && this.loadedTypeInitializer.equals(compiled.loadedTypeInitializer) && this.typeInitializer.equals(compiled.typeInitializer) && this.methods.equals(compiled.methods) && this.implementations.equals(compiled.implementations);
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodRegistry.Compiled
            public MethodList<?> getInstrumentedMethods() {
                return (MethodList) new MethodList.Explicit(new ArrayList(this.implementations.keySet())).filter(ElementMatchers.not(ElementMatchers.isTypeInitializer()));
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodRegistry.Compiled
            public TypeDescription getInstrumentedType() {
                return this.instrumentedType;
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodRegistry.Compiled
            public LoadedTypeInitializer getLoadedTypeInitializer() {
                return this.loadedTypeInitializer;
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodRegistry.Compiled
            public MethodList<?> getMethods() {
                return this.methods;
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodRegistry.Compiled
            public TypeInitializer getTypeInitializer() {
                return this.typeInitializer;
            }

            public int hashCode() {
                return ((this.implementations.hashCode() + ((this.methods.hashCode() + ((this.typeInitializer.hashCode() + ((this.loadedTypeInitializer.hashCode() + a.i(this.instrumentedType, getClass().hashCode() * 31, 31)) * 31)) * 31)) * 31)) * 31) + (this.supportsBridges ? 1 : 0);
            }

            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool
            public TypeWriter.MethodPool.Record target(MethodDescription methodDescription) {
                Entry entry = this.implementations.get(methodDescription);
                return entry == null ? new TypeWriter.MethodPool.Record.ForNonImplementedMethod(methodDescription) : entry.bind(this.instrumentedType, this.supportsBridges);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Entry implements LatentMatcher<MethodDescription> {
            private final MethodAttributeAppender.Factory attributeAppenderFactory;
            private final Handler handler;
            private final LatentMatcher<? super MethodDescription> matcher;
            private final Transformer<MethodDescription> transformer;

            public Entry(LatentMatcher<? super MethodDescription> latentMatcher, Handler handler, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer) {
                this.matcher = latentMatcher;
                this.handler = handler;
                this.attributeAppenderFactory = factory;
                this.transformer = transformer;
            }

            public Prepared.Entry asPreparedEntry(TypeDescription typeDescription, MethodDescription methodDescription, Visibility visibility) {
                return asPreparedEntry(typeDescription, methodDescription, Collections.EMPTY_SET, visibility);
            }

            public Prepared.Entry asSupplementaryEntry(MethodDescription methodDescription) {
                return new Prepared.Entry(this.handler, MethodAttributeAppender.Explicit.of(methodDescription), methodDescription, Collections.EMPTY_SET, methodDescription.getVisibility(), false);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Entry entry = (Entry) obj;
                return this.matcher.equals(entry.matcher) && this.handler.equals(entry.handler) && this.attributeAppenderFactory.equals(entry.attributeAppenderFactory) && this.transformer.equals(entry.transformer);
            }

            public Handler getHandler() {
                return this.handler;
            }

            public int hashCode() {
                return this.transformer.hashCode() + ((this.attributeAppenderFactory.hashCode() + ((this.handler.hashCode() + ((this.matcher.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31)) * 31);
            }

            @Override // net.bytebuddy.matcher.LatentMatcher
            public ElementMatcher<? super MethodDescription> resolve(TypeDescription typeDescription) {
                return this.matcher.resolve(typeDescription);
            }

            public Prepared.Entry asPreparedEntry(TypeDescription typeDescription, MethodDescription methodDescription, Set<MethodDescription.TypeToken> set, Visibility visibility) {
                return new Prepared.Entry(this.handler, this.attributeAppenderFactory, this.transformer.transform(typeDescription, methodDescription), set, visibility, false);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Prepared implements Prepared {
            private final LinkedHashMap<MethodDescription, Entry> implementations;
            private final TypeDescription instrumentedType;
            private final LoadedTypeInitializer loadedTypeInitializer;
            private final MethodGraph.Linked methodGraph;
            private final MethodList<?> methods;
            private final TypeInitializer typeInitializer;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Entry {
                private final MethodAttributeAppender.Factory attributeAppenderFactory;
                private final boolean bridgeMethod;
                private final Handler handler;
                private final MethodDescription methodDescription;
                private final Set<MethodDescription.TypeToken> typeTokens;
                private final Visibility visibility;

                public Entry(Handler handler, MethodAttributeAppender.Factory factory, MethodDescription methodDescription, Set<MethodDescription.TypeToken> set, Visibility visibility, boolean z6) {
                    this.handler = handler;
                    this.attributeAppenderFactory = factory;
                    this.methodDescription = methodDescription;
                    this.typeTokens = set;
                    this.visibility = visibility;
                    this.bridgeMethod = z6;
                }

                public static Entry forVisibilityBridge(MethodDescription methodDescription, Visibility visibility) {
                    return new Entry(Handler.ForVisibilityBridge.INSTANCE, MethodAttributeAppender.Explicit.of(methodDescription), methodDescription, Collections.EMPTY_SET, visibility, true);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Entry entry = (Entry) obj;
                    return this.bridgeMethod == entry.bridgeMethod && this.visibility.equals(entry.visibility) && this.handler.equals(entry.handler) && this.attributeAppenderFactory.equals(entry.attributeAppenderFactory) && this.methodDescription.equals(entry.methodDescription) && this.typeTokens.equals(entry.typeTokens);
                }

                public MethodAttributeAppender.Factory getAppenderFactory() {
                    return this.attributeAppenderFactory;
                }

                public Handler getHandler() {
                    return this.handler;
                }

                public MethodDescription getMethodDescription() {
                    return this.methodDescription;
                }

                public Visibility getVisibility() {
                    return this.visibility;
                }

                public int hashCode() {
                    return ((this.visibility.hashCode() + ((this.typeTokens.hashCode() + a.f(this.methodDescription, (this.attributeAppenderFactory.hashCode() + ((this.handler.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31, 31)) * 31)) * 31) + (this.bridgeMethod ? 1 : 0);
                }

                public boolean isBridgeMethod() {
                    return this.bridgeMethod;
                }

                public Set<MethodDescription.TypeToken> resolveBridgeTypes() {
                    HashSet hashSet = new HashSet(this.typeTokens);
                    hashSet.remove(this.methodDescription.asTypeToken());
                    return hashSet;
                }
            }

            public Prepared(LinkedHashMap<MethodDescription, Entry> linkedHashMap, LoadedTypeInitializer loadedTypeInitializer, TypeInitializer typeInitializer, TypeDescription typeDescription, MethodGraph.Linked linked, MethodList<?> methodList) {
                this.implementations = linkedHashMap;
                this.loadedTypeInitializer = loadedTypeInitializer;
                this.typeInitializer = typeInitializer;
                this.instrumentedType = typeDescription;
                this.methodGraph = linked;
                this.methods = methodList;
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodRegistry.Prepared
            public Compiled compile(Implementation.Target.Factory factory, ClassFileVersion classFileVersion) {
                HashMap map = new HashMap();
                HashMap map2 = new HashMap();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Implementation.Target targetMake = factory.make(this.instrumentedType, this.methodGraph, classFileVersion);
                for (Map.Entry<MethodDescription, Entry> entry : this.implementations.entrySet()) {
                    Handler.Compiled compiledCompile = (Handler.Compiled) map.get(entry.getValue().getHandler());
                    if (compiledCompile == null) {
                        compiledCompile = entry.getValue().getHandler().compile(targetMake);
                        map.put(entry.getValue().getHandler(), compiledCompile);
                    }
                    Handler.Compiled compiled = compiledCompile;
                    MethodAttributeAppender methodAttributeAppenderMake = (MethodAttributeAppender) map2.get(entry.getValue().getAppenderFactory());
                    if (methodAttributeAppenderMake == null) {
                        methodAttributeAppenderMake = entry.getValue().getAppenderFactory().make(this.instrumentedType);
                        map2.put(entry.getValue().getAppenderFactory(), methodAttributeAppenderMake);
                    }
                    linkedHashMap.put(entry.getKey(), new Compiled.Entry(compiled, methodAttributeAppenderMake, entry.getValue().getMethodDescription(), entry.getValue().resolveBridgeTypes(), entry.getValue().getVisibility(), entry.getValue().isBridgeMethod()));
                }
                return new Compiled(this.instrumentedType, this.loadedTypeInitializer, this.typeInitializer, this.methods, linkedHashMap, classFileVersion.isAtLeast(ClassFileVersion.JAVA_V5));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Prepared prepared = (Prepared) obj;
                return this.implementations.equals(prepared.implementations) && this.loadedTypeInitializer.equals(prepared.loadedTypeInitializer) && this.typeInitializer.equals(prepared.typeInitializer) && this.instrumentedType.equals(prepared.instrumentedType) && this.methodGraph.equals(prepared.methodGraph) && this.methods.equals(prepared.methods);
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodRegistry.Prepared
            public MethodList<?> getInstrumentedMethods() {
                return (MethodList) new MethodList.Explicit(new ArrayList(this.implementations.keySet())).filter(ElementMatchers.not(ElementMatchers.isTypeInitializer()));
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodRegistry.Prepared
            public TypeDescription getInstrumentedType() {
                return this.instrumentedType;
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodRegistry.Prepared
            public LoadedTypeInitializer getLoadedTypeInitializer() {
                return this.loadedTypeInitializer;
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodRegistry.Prepared
            public MethodList<?> getMethods() {
                return this.methods;
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodRegistry.Prepared
            public TypeInitializer getTypeInitializer() {
                return this.typeInitializer;
            }

            public int hashCode() {
                return this.methods.hashCode() + ((this.methodGraph.hashCode() + a.i(this.instrumentedType, (this.typeInitializer.hashCode() + ((this.loadedTypeInitializer.hashCode() + ((this.implementations.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31)) * 31, 31)) * 31);
            }
        }

        public Default() {
            this.entries = Collections.EMPTY_LIST;
        }

        @Override // net.bytebuddy.dynamic.scaffold.MethodRegistry
        public MethodRegistry append(LatentMatcher<? super MethodDescription> latentMatcher, Handler handler, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer) {
            return new Default(CompoundList.of(this.entries, new Entry(latentMatcher, handler, factory, transformer)));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.entries.equals(((Default) obj).entries);
        }

        public int hashCode() {
            return this.entries.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.dynamic.scaffold.MethodRegistry
        public Prepared prepare(InstrumentedType instrumentedType, MethodGraph.Compiler compiler, TypeValidation typeValidation, VisibilityBridgeStrategy visibilityBridgeStrategy, LatentMatcher<? super MethodDescription> latentMatcher) {
            InstrumentedType instrumentedTypePrepare;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet(instrumentedType.getDeclaredMethods());
            for (Entry entry : this.entries) {
                if (hashSet.add(entry.getHandler()) && instrumentedType != (instrumentedTypePrepare = entry.getHandler().prepare(instrumentedType))) {
                    for (MethodDescription.InDefinedShape inDefinedShape : instrumentedTypePrepare.getDeclaredMethods()) {
                        if (!hashSet2.contains(inDefinedShape)) {
                            linkedHashMap.put(inDefinedShape, entry.asSupplementaryEntry(inDefinedShape));
                            hashSet2.add(inDefinedShape);
                        }
                    }
                    instrumentedType = instrumentedTypePrepare;
                }
            }
            MethodGraph.Linked linkedCompile = compiler.compile((TypeDefinition) instrumentedType);
            ElementMatcher.Junction junctionAnd = ElementMatchers.not(ElementMatchers.anyOf(linkedHashMap.keySet())).and(ElementMatchers.returns(ElementMatchers.isVisibleTo(instrumentedType))).and(ElementMatchers.hasParameters(ElementMatchers.whereNone(ElementMatchers.hasType(ElementMatchers.not(ElementMatchers.isVisibleTo(instrumentedType)))))).and(latentMatcher.resolve(instrumentedType));
            ArrayList arrayList = new ArrayList();
            for (MethodGraph.Node node : linkedCompile.listNodes()) {
                MethodDescription representative = node.getRepresentative();
                boolean z6 = false;
                boolean z7 = instrumentedType.isPublic() && !instrumentedType.isInterface();
                if (junctionAnd.matches(representative)) {
                    for (Entry entry2 : this.entries) {
                        if (entry2.resolve(instrumentedType).matches(representative)) {
                            linkedHashMap.put(representative, entry2.asPreparedEntry(instrumentedType, representative, node.getMethodTypes(), node.getVisibility()));
                            break;
                        }
                    }
                    z6 = z7;
                } else {
                    z6 = z7;
                }
                if (z6 && !node.getSort().isMadeVisible() && representative.isPublic() && !representative.isAbstract() && !representative.isFinal() && representative.getDeclaringType().isPackagePrivate() && visibilityBridgeStrategy.generateVisibilityBridge(representative)) {
                    linkedHashMap.put(representative, Prepared.Entry.forVisibilityBridge(representative, node.getVisibility()));
                }
                arrayList.add(representative);
            }
            for (MethodDescription methodDescription : CompoundList.of((List<? extends MethodDescription.Latent.TypeInitializer>) instrumentedType.getDeclaredMethods().filter(ElementMatchers.not(ElementMatchers.isVirtual()).and(junctionAnd)), new MethodDescription.Latent.TypeInitializer(instrumentedType))) {
                Iterator<Entry> it = this.entries.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Entry next = it.next();
                        if (next.resolve(instrumentedType).matches(methodDescription)) {
                            linkedHashMap.put(methodDescription, next.asPreparedEntry(instrumentedType, methodDescription, methodDescription.getVisibility()));
                            break;
                        }
                    }
                }
                arrayList.add(methodDescription);
            }
            LoadedTypeInitializer loadedTypeInitializer = instrumentedType.getLoadedTypeInitializer();
            TypeInitializer typeInitializer = instrumentedType.getTypeInitializer();
            InstrumentedType instrumentedTypeValidated = instrumentedType;
            if (typeValidation.isEnabled()) {
                instrumentedTypeValidated = instrumentedType.validated();
            }
            return new Prepared(linkedHashMap, loadedTypeInitializer, typeInitializer, instrumentedTypeValidated, linkedCompile, new MethodList.Explicit(arrayList));
        }

        @Override // net.bytebuddy.dynamic.scaffold.MethodRegistry
        public MethodRegistry prepend(LatentMatcher<? super MethodDescription> latentMatcher, Handler handler, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer) {
            return new Default(CompoundList.of(new Entry(latentMatcher, handler, factory, transformer), this.entries));
        }

        private Default(List<Entry> list) {
            this.entries = list;
        }
    }
}
