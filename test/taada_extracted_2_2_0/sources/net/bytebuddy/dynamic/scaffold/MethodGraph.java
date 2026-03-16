package net.bytebuddy.dynamic.scaffold;

import com.google.protobuf.a;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.matcher.FilterableList;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
public interface MethodGraph {

    @SuppressFBWarnings(justification = "Safe initialization is implied.", value = {"IC_SUPERCLASS_USES_SUBCLASS_DURING_INITIALIZATION"})
    public interface Compiler {
        public static final Compiler DEFAULT = Default.forJavaHierarchy();

        public static abstract class AbstractBase implements Compiler {
            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler
            public Linked compile(TypeDefinition typeDefinition) {
                return compile(typeDefinition, typeDefinition.asErasure());
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler
            @Deprecated
            public Linked compile(TypeDescription typeDescription) {
                return compile((TypeDefinition) typeDescription, typeDescription);
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler
            @Deprecated
            public Linked compile(TypeDescription typeDescription, TypeDescription typeDescription2) {
                return compile((TypeDefinition) typeDescription, typeDescription2);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Default<T> extends AbstractBase {
            private final Harmonizer<T> harmonizer;
            private final Merger merger;
            private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;

            public interface Harmonizer<S> {

                public enum ForJVMMethod implements Harmonizer<Token> {
                    INSTANCE;

                    public static class Token {
                        private final int hashCode;
                        private final MethodDescription.TypeToken typeToken;

                        public Token(MethodDescription.TypeToken typeToken) {
                            this.typeToken = typeToken;
                            this.hashCode = (typeToken.getParameterTypes().hashCode() * 31) + typeToken.getReturnType().hashCode();
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (!(obj instanceof Token)) {
                                return false;
                            }
                            Token token = (Token) obj;
                            return this.typeToken.getReturnType().equals(token.typeToken.getReturnType()) && this.typeToken.getParameterTypes().equals(token.typeToken.getParameterTypes());
                        }

                        public int hashCode() {
                            return this.hashCode;
                        }

                        public String toString() {
                            return this.typeToken.toString();
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.Harmonizer
                    public Token harmonize(MethodDescription.TypeToken typeToken) {
                        return new Token(typeToken);
                    }
                }

                public enum ForJavaMethod implements Harmonizer<Token> {
                    INSTANCE;

                    public static class Token {
                        private final int hashCode;
                        private final MethodDescription.TypeToken typeToken;

                        public Token(MethodDescription.TypeToken typeToken) {
                            this.typeToken = typeToken;
                            this.hashCode = typeToken.getParameterTypes().hashCode();
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this != obj) {
                                return (obj instanceof Token) && this.typeToken.getParameterTypes().equals(((Token) obj).typeToken.getParameterTypes());
                            }
                            return true;
                        }

                        public int hashCode() {
                            return this.hashCode;
                        }

                        public String toString() {
                            return this.typeToken.getParameterTypes().toString();
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.Harmonizer
                    public Token harmonize(MethodDescription.TypeToken typeToken) {
                        return new Token(typeToken);
                    }
                }

                S harmonize(MethodDescription.TypeToken typeToken);
            }

            public static abstract class Key<S> {
                protected final String internalName;
                protected final int parameterCount;

                public static class Detached extends Key<MethodDescription.TypeToken> {
                    private final Set<MethodDescription.TypeToken> identifiers;

                    public Detached(String str, int i, Set<MethodDescription.TypeToken> set) {
                        super(str, i);
                        this.identifiers = set;
                    }

                    public static Detached of(MethodDescription.SignatureToken signatureToken) {
                        return new Detached(signatureToken.getName(), signatureToken.getParameterTypes().size(), Collections.singleton(signatureToken.asTypeToken()));
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.Key
                    public Set<MethodDescription.TypeToken> getIdentifiers() {
                        return this.identifiers;
                    }
                }

                public static class Harmonized<V> extends Key<V> {
                    private final Map<V, Set<MethodDescription.TypeToken>> identifiers;

                    public Harmonized(String str, int i, Map<V, Set<MethodDescription.TypeToken>> map) {
                        super(str, i);
                        this.identifiers = map;
                    }

                    public static <Q> Harmonized<Q> of(MethodDescription methodDescription, Harmonizer<Q> harmonizer) {
                        return new Harmonized<>(methodDescription.getInternalName(), methodDescription.getParameters().size(), Collections.singletonMap(harmonizer.harmonize(methodDescription.asTypeToken()), Collections.EMPTY_SET));
                    }

                    public Harmonized<V> combineWith(Harmonized<V> harmonized) {
                        HashMap map = new HashMap(this.identifiers);
                        for (Map.Entry<V, Set<MethodDescription.TypeToken>> entry : harmonized.identifiers.entrySet()) {
                            Set set = (Set) map.get(entry.getKey());
                            if (set == null) {
                                map.put(entry.getKey(), entry.getValue());
                            } else {
                                HashSet hashSet = new HashSet(set);
                                hashSet.addAll(entry.getValue());
                                map.put(entry.getKey(), hashSet);
                            }
                        }
                        return new Harmonized<>(this.internalName, this.parameterCount, map);
                    }

                    public Detached detach(MethodDescription.TypeToken typeToken) {
                        HashSet hashSet = new HashSet();
                        Iterator<Set<MethodDescription.TypeToken>> it = this.identifiers.values().iterator();
                        while (it.hasNext()) {
                            hashSet.addAll(it.next());
                        }
                        hashSet.add(typeToken);
                        return new Detached(this.internalName, this.parameterCount, hashSet);
                    }

                    public Harmonized<V> extend(MethodDescription.InDefinedShape inDefinedShape, Harmonizer<V> harmonizer) {
                        HashMap map = new HashMap(this.identifiers);
                        MethodDescription.TypeToken typeTokenAsTypeToken = inDefinedShape.asTypeToken();
                        V vHarmonize = harmonizer.harmonize(typeTokenAsTypeToken);
                        Set set = (Set) map.get(vHarmonize);
                        if (set == null) {
                            map.put(vHarmonize, Collections.singleton(typeTokenAsTypeToken));
                        } else {
                            HashSet hashSet = new HashSet(set);
                            hashSet.add(typeTokenAsTypeToken);
                            map.put(vHarmonize, hashSet);
                        }
                        return new Harmonized<>(this.internalName, this.parameterCount, map);
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.Key
                    public Set<V> getIdentifiers() {
                        return this.identifiers.keySet();
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class Store<V> {
                    private final LinkedHashMap<Harmonized<V>, Entry<V>> entries;

                    public interface Entry<W> {

                        @HashCodeAndEqualsPlugin.Enhance
                        public static class Ambiguous<U> implements Entry<U> {
                            private final Harmonized<U> key;
                            private final LinkedHashSet<MethodDescription> methodDescriptions;
                            private final Visibility visibility;

                            @HashCodeAndEqualsPlugin.Enhance
                            public static class Node implements Node {
                                private final Detached key;
                                private final MethodDescription methodDescription;
                                private final Visibility visibility;

                                public Node(Detached detached, MethodDescription methodDescription, Visibility visibility) {
                                    this.key = detached;
                                    this.methodDescription = methodDescription;
                                    this.visibility = visibility;
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Node node = (Node) obj;
                                    return this.visibility.equals(node.visibility) && this.key.equals(node.key) && this.methodDescription.equals(node.methodDescription);
                                }

                                @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Node
                                public Set<MethodDescription.TypeToken> getMethodTypes() {
                                    return this.key.getIdentifiers();
                                }

                                @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Node
                                public MethodDescription getRepresentative() {
                                    return this.methodDescription;
                                }

                                @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Node
                                public Node.Sort getSort() {
                                    return Node.Sort.AMBIGUOUS;
                                }

                                @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Node
                                public Visibility getVisibility() {
                                    return this.visibility;
                                }

                                public int hashCode() {
                                    return this.visibility.hashCode() + a.f(this.methodDescription, (this.key.hashCode() + (getClass().hashCode() * 31)) * 31, 31);
                                }
                            }

                            public Ambiguous(Harmonized<U> harmonized, LinkedHashSet<MethodDescription> linkedHashSet, Visibility visibility) {
                                this.key = harmonized;
                                this.methodDescriptions = linkedHashSet;
                                this.visibility = visibility;
                            }

                            public static <Q> Entry<Q> of(Harmonized<Q> harmonized, MethodDescription methodDescription, MethodDescription methodDescription2, Visibility visibility) {
                                Visibility visibilityExpandTo = visibility.expandTo(methodDescription.getVisibility()).expandTo(methodDescription2.getVisibility());
                                if (!(methodDescription.isBridge() ^ methodDescription2.isBridge())) {
                                    return new Ambiguous(harmonized, new LinkedHashSet(Arrays.asList(methodDescription, methodDescription2)), visibilityExpandTo);
                                }
                                if (methodDescription.isBridge()) {
                                    methodDescription = methodDescription2;
                                }
                                return new Resolved(harmonized, methodDescription, visibilityExpandTo, false);
                            }

                            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.Key.Store.Entry
                            public Node asNode(Merger merger) {
                                Iterator<MethodDescription> it = this.methodDescriptions.iterator();
                                MethodDescription next = it.next();
                                while (it.hasNext()) {
                                    next = merger.merge(next, it.next());
                                }
                                return new Node(this.key.detach(next.asTypeToken()), next, this.visibility);
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj == null || getClass() != obj.getClass()) {
                                    return false;
                                }
                                Ambiguous ambiguous = (Ambiguous) obj;
                                return this.visibility.equals(ambiguous.visibility) && this.key.equals(ambiguous.key) && this.methodDescriptions.equals(ambiguous.methodDescriptions);
                            }

                            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.Key.Store.Entry
                            public Entry<U> extendBy(MethodDescription methodDescription, Harmonizer<U> harmonizer) {
                                Harmonized<U> harmonizedExtend = this.key.extend(methodDescription.asDefined(), harmonizer);
                                LinkedHashSet linkedHashSet = new LinkedHashSet();
                                TypeDescription typeDescriptionAsErasure = methodDescription.getDeclaringType().asErasure();
                                boolean zIsBridge = methodDescription.isBridge();
                                Visibility visibilityExpandTo = this.visibility;
                                for (MethodDescription methodDescription2 : this.methodDescriptions) {
                                    if (methodDescription2.getDeclaringType().asErasure().equals(typeDescriptionAsErasure)) {
                                        if (methodDescription2.isBridge() ^ zIsBridge) {
                                            linkedHashSet.add(zIsBridge ? methodDescription2 : methodDescription);
                                        } else {
                                            linkedHashSet.add(methodDescription);
                                            linkedHashSet.add(methodDescription2);
                                        }
                                    }
                                    visibilityExpandTo = visibilityExpandTo.expandTo(methodDescription2.getVisibility());
                                }
                                return linkedHashSet.isEmpty() ? new Resolved(harmonizedExtend, methodDescription, visibilityExpandTo, zIsBridge) : linkedHashSet.size() == 1 ? new Resolved(harmonizedExtend, (MethodDescription) linkedHashSet.iterator().next(), visibilityExpandTo, false) : new Ambiguous(harmonizedExtend, linkedHashSet, visibilityExpandTo);
                            }

                            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.Key.Store.Entry
                            public Set<MethodDescription> getCandidates() {
                                return this.methodDescriptions;
                            }

                            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.Key.Store.Entry
                            public Harmonized<U> getKey() {
                                return this.key;
                            }

                            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.Key.Store.Entry
                            public Visibility getVisibility() {
                                return this.visibility;
                            }

                            public int hashCode() {
                                return this.visibility.hashCode() + ((this.methodDescriptions.hashCode() + ((this.key.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31);
                            }

                            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.Key.Store.Entry
                            public Entry<U> inject(Entry<U> entry) {
                                LinkedHashSet linkedHashSet = new LinkedHashSet();
                                for (MethodDescription methodDescription : this.methodDescriptions) {
                                    TypeDescription typeDescriptionAsErasure = methodDescription.getDeclaringType().asErasure();
                                    Iterator<MethodDescription> it = entry.getCandidates().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            linkedHashSet.add(methodDescription);
                                            break;
                                        }
                                        TypeDescription typeDescriptionAsErasure2 = it.next().getDeclaringType().asErasure();
                                        if (typeDescriptionAsErasure2.equals(typeDescriptionAsErasure) || !typeDescriptionAsErasure2.isAssignableTo(typeDescriptionAsErasure)) {
                                        }
                                    }
                                }
                                for (MethodDescription methodDescription2 : entry.getCandidates()) {
                                    TypeDescription typeDescriptionAsErasure3 = methodDescription2.getDeclaringType().asErasure();
                                    Iterator<MethodDescription> it2 = this.methodDescriptions.iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            linkedHashSet.add(methodDescription2);
                                            break;
                                        }
                                        if (it2.next().getDeclaringType().asErasure().isAssignableTo(typeDescriptionAsErasure3)) {
                                            break;
                                        }
                                    }
                                }
                                return linkedHashSet.size() == 1 ? new Resolved(this.key.combineWith(entry.getKey()), (MethodDescription) linkedHashSet.iterator().next(), this.visibility.expandTo(entry.getVisibility())) : new Ambiguous(this.key.combineWith(entry.getKey()), linkedHashSet, this.visibility.expandTo(entry.getVisibility()));
                            }
                        }

                        public static class Initial<U> implements Entry<U> {
                            private final Harmonized<U> key;

                            public Initial(Harmonized<U> harmonized) {
                                this.key = harmonized;
                            }

                            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.Key.Store.Entry
                            public Node asNode(Merger merger) {
                                throw new IllegalStateException("Cannot transform initial entry without a registered method: " + this);
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj == null || getClass() != obj.getClass()) {
                                    return false;
                                }
                                return this.key.equals(((Initial) obj).key);
                            }

                            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.Key.Store.Entry
                            public Entry<U> extendBy(MethodDescription methodDescription, Harmonizer<U> harmonizer) {
                                return new Resolved(this.key.extend(methodDescription.asDefined(), harmonizer), methodDescription, methodDescription.getVisibility(), false);
                            }

                            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.Key.Store.Entry
                            public Set<MethodDescription> getCandidates() {
                                throw new IllegalStateException("Cannot extract method from initial entry:" + this);
                            }

                            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.Key.Store.Entry
                            public Harmonized<U> getKey() {
                                throw new IllegalStateException("Cannot extract key from initial entry:" + this);
                            }

                            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.Key.Store.Entry
                            public Visibility getVisibility() {
                                throw new IllegalStateException("Cannot extract visibility from initial entry:" + this);
                            }

                            public int hashCode() {
                                return this.key.hashCode();
                            }

                            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.Key.Store.Entry
                            public Entry<U> inject(Entry<U> entry) {
                                throw new IllegalStateException("Cannot inject into initial entry without a registered method: " + this);
                            }
                        }

                        @HashCodeAndEqualsPlugin.Enhance
                        public static class Resolved<U> implements Entry<U> {
                            private static final int MADE_VISIBLE = 5;
                            private static final boolean NOT_MADE_VISIBLE = false;
                            private final Harmonized<U> key;
                            private final boolean madeVisible;
                            private final MethodDescription methodDescription;
                            private final Visibility visibility;

                            @HashCodeAndEqualsPlugin.Enhance
                            public static class Node implements Node {
                                private final Detached key;
                                private final MethodDescription methodDescription;
                                private final Visibility visibility;
                                private final boolean visible;

                                public Node(Detached detached, MethodDescription methodDescription, Visibility visibility, boolean z6) {
                                    this.key = detached;
                                    this.methodDescription = methodDescription;
                                    this.visibility = visibility;
                                    this.visible = z6;
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Node node = (Node) obj;
                                    return this.visible == node.visible && this.visibility.equals(node.visibility) && this.key.equals(node.key) && this.methodDescription.equals(node.methodDescription);
                                }

                                @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Node
                                public Set<MethodDescription.TypeToken> getMethodTypes() {
                                    return this.key.getIdentifiers();
                                }

                                @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Node
                                public MethodDescription getRepresentative() {
                                    return this.methodDescription;
                                }

                                @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Node
                                public Node.Sort getSort() {
                                    return this.visible ? Node.Sort.VISIBLE : Node.Sort.RESOLVED;
                                }

                                @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Node
                                public Visibility getVisibility() {
                                    return this.visibility;
                                }

                                public int hashCode() {
                                    return ((this.visibility.hashCode() + a.f(this.methodDescription, (this.key.hashCode() + (getClass().hashCode() * 31)) * 31, 31)) * 31) + (this.visible ? 1 : 0);
                                }
                            }

                            public Resolved(Harmonized<U> harmonized, MethodDescription methodDescription, Visibility visibility) {
                                this(harmonized, methodDescription, visibility, false);
                            }

                            private static <V> Entry<V> of(Harmonized<V> harmonized, MethodDescription methodDescription, MethodDescription methodDescription2, Visibility visibility) {
                                Visibility visibilityExpandTo = visibility.expandTo(methodDescription2.getVisibility()).expandTo(methodDescription.getVisibility());
                                if (methodDescription.isBridge()) {
                                    return new Resolved(harmonized, methodDescription2, visibilityExpandTo, (methodDescription2.getDeclaringType().getModifiers() & 5) == 0);
                                }
                                return new Resolved(harmonized, methodDescription, visibilityExpandTo, false);
                            }

                            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.Key.Store.Entry
                            public Node asNode(Merger merger) {
                                return new Node(this.key.detach(this.methodDescription.asTypeToken()), this.methodDescription, this.visibility, this.madeVisible);
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj == null || getClass() != obj.getClass()) {
                                    return false;
                                }
                                Resolved resolved = (Resolved) obj;
                                return this.madeVisible == resolved.madeVisible && this.visibility.equals(resolved.visibility) && this.key.equals(resolved.key) && this.methodDescription.equals(resolved.methodDescription);
                            }

                            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.Key.Store.Entry
                            public Entry<U> extendBy(MethodDescription methodDescription, Harmonizer<U> harmonizer) {
                                Harmonized<U> harmonizedExtend = this.key.extend(methodDescription.asDefined(), harmonizer);
                                Visibility visibilityExpandTo = this.visibility.expandTo(methodDescription.getVisibility());
                                return methodDescription.getDeclaringType().equals(this.methodDescription.getDeclaringType()) ? Ambiguous.of(harmonizedExtend, methodDescription, this.methodDescription, visibilityExpandTo) : of(harmonizedExtend, methodDescription, this.methodDescription, visibilityExpandTo);
                            }

                            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.Key.Store.Entry
                            public Set<MethodDescription> getCandidates() {
                                return Collections.singleton(this.methodDescription);
                            }

                            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.Key.Store.Entry
                            public Harmonized<U> getKey() {
                                return this.key;
                            }

                            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.Key.Store.Entry
                            public Visibility getVisibility() {
                                return this.visibility;
                            }

                            public int hashCode() {
                                return ((this.visibility.hashCode() + a.f(this.methodDescription, (this.key.hashCode() + (getClass().hashCode() * 31)) * 31, 31)) * 31) + (this.madeVisible ? 1 : 0);
                            }

                            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.Key.Store.Entry
                            public Entry<U> inject(Entry<U> entry) {
                                if (!this.methodDescription.getDeclaringType().isInterface()) {
                                    return new Resolved(this.key.combineWith(entry.getKey()), this.methodDescription, this.visibility.expandTo(entry.getVisibility()), this.madeVisible);
                                }
                                LinkedHashSet linkedHashSet = new LinkedHashSet();
                                linkedHashSet.add(this.methodDescription);
                                TypeDescription typeDescriptionAsErasure = this.methodDescription.getDeclaringType().asErasure();
                                for (MethodDescription methodDescription : entry.getCandidates()) {
                                    if (methodDescription.getDeclaringType().asErasure().isAssignableTo(typeDescriptionAsErasure)) {
                                        linkedHashSet.remove(this.methodDescription);
                                        linkedHashSet.add(methodDescription);
                                    } else if (!methodDescription.getDeclaringType().asErasure().isAssignableFrom(typeDescriptionAsErasure)) {
                                        linkedHashSet.add(methodDescription);
                                    }
                                }
                                return linkedHashSet.size() == 1 ? new Resolved(this.key.combineWith(entry.getKey()), (MethodDescription) linkedHashSet.iterator().next(), this.visibility.expandTo(entry.getVisibility()), this.madeVisible) : new Ambiguous(this.key.combineWith(entry.getKey()), linkedHashSet, this.visibility.expandTo(entry.getVisibility()));
                            }

                            public Resolved(Harmonized<U> harmonized, MethodDescription methodDescription, Visibility visibility, boolean z6) {
                                this.key = harmonized;
                                this.methodDescription = methodDescription;
                                this.visibility = visibility;
                                this.madeVisible = z6;
                            }
                        }

                        Node asNode(Merger merger);

                        Entry<W> extendBy(MethodDescription methodDescription, Harmonizer<W> harmonizer);

                        Set<MethodDescription> getCandidates();

                        Harmonized<W> getKey();

                        Visibility getVisibility();

                        Entry<W> inject(Entry<W> entry);
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class Graph implements MethodGraph {
                        private final LinkedHashMap<Key<MethodDescription.TypeToken>, Node> entries;

                        public Graph(LinkedHashMap<Key<MethodDescription.TypeToken>, Node> linkedHashMap) {
                            this.entries = linkedHashMap;
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.entries.equals(((Graph) obj).entries);
                        }

                        public int hashCode() {
                            return this.entries.hashCode() + (getClass().hashCode() * 31);
                        }

                        @Override // net.bytebuddy.dynamic.scaffold.MethodGraph
                        public NodeList listNodes() {
                            return new NodeList(new ArrayList(this.entries.values()));
                        }

                        @Override // net.bytebuddy.dynamic.scaffold.MethodGraph
                        public Node locate(MethodDescription.SignatureToken signatureToken) {
                            Node node = this.entries.get(Detached.of(signatureToken));
                            return node == null ? Node.Unresolved.INSTANCE : node;
                        }
                    }

                    public Store() {
                        this(new LinkedHashMap());
                    }

                    private static <W> Entry<W> combine(Entry<W> entry, Entry<W> entry2) {
                        Set<MethodDescription> candidates = entry.getCandidates();
                        Set<MethodDescription> candidates2 = entry2.getCandidates();
                        LinkedHashSet linkedHashSet = new LinkedHashSet();
                        linkedHashSet.addAll(candidates);
                        linkedHashSet.addAll(candidates2);
                        for (MethodDescription methodDescription : candidates) {
                            TypeDescription typeDescriptionAsErasure = methodDescription.getDeclaringType().asErasure();
                            Iterator<MethodDescription> it = candidates2.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    MethodDescription next = it.next();
                                    TypeDescription typeDescriptionAsErasure2 = next.getDeclaringType().asErasure();
                                    if (!typeDescriptionAsErasure.equals(typeDescriptionAsErasure2)) {
                                        if (typeDescriptionAsErasure.isAssignableTo(typeDescriptionAsErasure2)) {
                                            linkedHashSet.remove(next);
                                            break;
                                        }
                                        if (typeDescriptionAsErasure.isAssignableFrom(typeDescriptionAsErasure2)) {
                                            linkedHashSet.remove(methodDescription);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        Harmonized<W> harmonizedCombineWith = entry.getKey().combineWith(entry2.getKey());
                        Visibility visibilityExpandTo = entry.getVisibility().expandTo(entry2.getVisibility());
                        return linkedHashSet.size() == 1 ? new Entry.Resolved(harmonizedCombineWith, (MethodDescription) linkedHashSet.iterator().next(), visibilityExpandTo, false) : new Entry.Ambiguous(harmonizedCombineWith, linkedHashSet, visibilityExpandTo);
                    }

                    public MethodGraph asGraph(Merger merger) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        for (Entry<V> entry : this.entries.values()) {
                            Node nodeAsNode = entry.asNode(merger);
                            linkedHashMap.put(entry.getKey().detach(nodeAsNode.getRepresentative().asTypeToken()), nodeAsNode);
                        }
                        return new Graph(linkedHashMap);
                    }

                    public Store<V> combineWith(Store<V> store) {
                        if (this.entries.isEmpty()) {
                            return store;
                        }
                        if (store.entries.isEmpty()) {
                            return this;
                        }
                        LinkedHashMap linkedHashMap = new LinkedHashMap(this.entries);
                        for (Entry<V> entryCombine : store.entries.values()) {
                            Entry entry = (Entry) linkedHashMap.remove(entryCombine.getKey());
                            if (entry != null) {
                                entryCombine = combine(entry, entryCombine);
                            }
                            linkedHashMap.put(entryCombine.getKey(), entryCombine);
                        }
                        return new Store<>(linkedHashMap);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.entries.equals(((Store) obj).entries);
                    }

                    public int hashCode() {
                        return this.entries.hashCode() + (getClass().hashCode() * 31);
                    }

                    public Store<V> inject(Store<V> store) {
                        if (this.entries.isEmpty()) {
                            return store;
                        }
                        if (store.entries.isEmpty()) {
                            return this;
                        }
                        LinkedHashMap linkedHashMap = new LinkedHashMap(this.entries);
                        for (Entry<V> entryInject : store.entries.values()) {
                            Entry entry = (Entry) linkedHashMap.remove(entryInject.getKey());
                            if (entry != null) {
                                entryInject = entry.inject(entryInject);
                            }
                            linkedHashMap.put(entryInject.getKey(), entryInject);
                        }
                        return new Store<>(linkedHashMap);
                    }

                    public Store<V> registerTopLevel(List<? extends MethodDescription> list, Harmonizer<V> harmonizer) {
                        if (list.isEmpty()) {
                            return this;
                        }
                        LinkedHashMap linkedHashMap = new LinkedHashMap(this.entries);
                        for (MethodDescription methodDescription : list) {
                            Harmonized harmonizedOf = Harmonized.of(methodDescription, harmonizer);
                            Entry initial = (Entry) linkedHashMap.remove(harmonizedOf);
                            if (initial == null) {
                                initial = new Entry.Initial(harmonizedOf);
                            }
                            Entry entryExtendBy = initial.extendBy(methodDescription, harmonizer);
                            linkedHashMap.put(entryExtendBy.getKey(), entryExtendBy);
                        }
                        return new Store<>(linkedHashMap);
                    }

                    private Store(LinkedHashMap<Harmonized<V>, Entry<V>> linkedHashMap) {
                        this.entries = linkedHashMap;
                    }
                }

                public Key(String str, int i) {
                    this.internalName = str;
                    this.parameterCount = i;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Key)) {
                        return false;
                    }
                    Key key = (Key) obj;
                    return this.internalName.equals(key.internalName) && this.parameterCount == key.parameterCount && !Collections.disjoint(getIdentifiers(), key.getIdentifiers());
                }

                public abstract Set<S> getIdentifiers();

                public int hashCode() {
                    return (this.parameterCount * 31) + this.internalName.hashCode();
                }
            }

            public interface Merger {

                public enum Directional implements Merger {
                    LEFT(true),
                    RIGHT(false);

                    private final boolean left;

                    Directional(boolean z6) {
                        this.left = z6;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.Merger
                    public MethodDescription merge(MethodDescription methodDescription, MethodDescription methodDescription2) {
                        return this.left ? methodDescription : methodDescription2;
                    }
                }

                MethodDescription merge(MethodDescription methodDescription, MethodDescription methodDescription2);
            }

            public Default(Harmonizer<T> harmonizer, Merger merger, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
                this.harmonizer = harmonizer;
                this.merger = merger;
                this.visitor = visitor;
            }

            public static Compiler forJVMHierarchy() {
                return of(Harmonizer.ForJVMMethod.INSTANCE, Merger.Directional.LEFT);
            }

            public static Compiler forJavaHierarchy() {
                return of(Harmonizer.ForJavaMethod.INSTANCE, Merger.Directional.LEFT);
            }

            public static <S> Compiler of(Harmonizer<S> harmonizer, Merger merger) {
                return new Default(harmonizer, merger, TypeDescription.Generic.Visitor.Reifying.INITIATING);
            }

            public Key.Store<T> analyze(TypeDefinition typeDefinition, TypeDefinition typeDefinition2, Map<TypeDefinition, Key.Store<T>> map, ElementMatcher<? super MethodDescription> elementMatcher) {
                Key.Store<T> store = map.get(typeDefinition2);
                if (store != null) {
                    return store;
                }
                Key.Store<T> storeDoAnalyze = doAnalyze(typeDefinition, map, elementMatcher);
                map.put(typeDefinition2, storeDoAnalyze);
                return storeDoAnalyze;
            }

            public Key.Store<T> analyzeNullable(@MaybeNull TypeDescription.Generic generic, Map<TypeDefinition, Key.Store<T>> map, ElementMatcher<? super MethodDescription> elementMatcher) {
                return generic == null ? new Key.Store<>() : analyze((TypeDefinition) generic.accept(this.visitor), generic, map, elementMatcher);
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler
            public Linked compile(TypeDefinition typeDefinition, TypeDescription typeDescription) {
                Key.Store store;
                HashMap map = new HashMap();
                Key.Store<T> storeDoAnalyze = doAnalyze(typeDefinition, map, ElementMatchers.isVirtual().and(ElementMatchers.isVisibleTo(typeDescription)));
                TypeDescription.Generic superClass = typeDefinition.getSuperClass();
                TypeList.Generic interfaces = typeDefinition.getInterfaces();
                HashMap map2 = new HashMap();
                for (TypeDescription.Generic generic : interfaces) {
                    Key.Store store2 = (Key.Store) map.get(generic);
                    if (store2 == null) {
                        throw new IllegalStateException("Failed to resolve interface type " + generic + " from " + map.keySet());
                    }
                    map2.put(generic.asErasure(), store2.asGraph(this.merger));
                }
                if (superClass == null) {
                    store = null;
                } else {
                    store = (Key.Store) map.get(superClass);
                    if (store == null) {
                        throw new IllegalStateException("Failed to resolve super class " + superClass + " from " + map.keySet());
                    }
                }
                return new Linked.Delegation(storeDoAnalyze.asGraph(this.merger), store == null ? Empty.INSTANCE : store.asGraph(this.merger), map2);
            }

            public Key.Store<T> doAnalyze(TypeDefinition typeDefinition, Map<TypeDefinition, Key.Store<T>> map, ElementMatcher<? super MethodDescription> elementMatcher) {
                Key.Store<T> storeAnalyzeNullable = analyzeNullable(typeDefinition.getSuperClass(), map, elementMatcher);
                Key.Store<T> store = new Key.Store<>();
                for (TypeDescription.Generic generic : typeDefinition.getInterfaces()) {
                    store = store.combineWith(analyze((TypeDefinition) generic.accept(this.visitor), generic, map, elementMatcher));
                }
                return storeAnalyzeNullable.inject(store).registerTopLevel(typeDefinition.getDeclaredMethods().filter(elementMatcher), this.harmonizer);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Default r52 = (Default) obj;
                return this.harmonizer.equals(r52.harmonizer) && this.merger.equals(r52.merger) && this.visitor.equals(r52.visitor);
            }

            public int hashCode() {
                return this.visitor.hashCode() + ((this.merger.hashCode() + ((this.harmonizer.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31);
            }

            public static <S> Compiler of(Harmonizer<S> harmonizer, Merger merger, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
                return new Default(harmonizer, merger, visitor);
            }
        }

        public enum ForDeclaredMethods implements Compiler {
            INSTANCE;

            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler
            public Linked compile(TypeDefinition typeDefinition) {
                return compile(typeDefinition, typeDefinition.asErasure());
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler
            @Deprecated
            public Linked compile(TypeDescription typeDescription) {
                return compile((TypeDefinition) typeDescription, typeDescription);
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler
            public Linked compile(TypeDefinition typeDefinition, TypeDescription typeDescription) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (MethodDescription methodDescription : typeDefinition.getDeclaredMethods().filter(ElementMatchers.isVirtual().and(ElementMatchers.not(ElementMatchers.isBridge())).and(ElementMatchers.isVisibleTo(typeDescription)))) {
                    linkedHashMap.put(methodDescription.asSignatureToken(), new Node.Simple(methodDescription));
                }
                return new Linked.Delegation(new Simple(linkedHashMap), Empty.INSTANCE, Collections.EMPTY_MAP);
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler
            @Deprecated
            public Linked compile(TypeDescription typeDescription, TypeDescription typeDescription2) {
                return compile((TypeDefinition) typeDescription, typeDescription2);
            }
        }

        Linked compile(TypeDefinition typeDefinition);

        Linked compile(TypeDefinition typeDefinition, TypeDescription typeDescription);

        @Deprecated
        Linked compile(TypeDescription typeDescription);

        @Deprecated
        Linked compile(TypeDescription typeDescription, TypeDescription typeDescription2);
    }

    public enum Empty implements Linked, Compiler {
        INSTANCE;

        @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler
        public Linked compile(TypeDefinition typeDefinition) {
            return this;
        }

        @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Linked
        public MethodGraph getInterfaceGraph(TypeDescription typeDescription) {
            return this;
        }

        @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Linked
        public MethodGraph getSuperClassGraph() {
            return this;
        }

        @Override // net.bytebuddy.dynamic.scaffold.MethodGraph
        public NodeList listNodes() {
            return new NodeList(Collections.EMPTY_LIST);
        }

        @Override // net.bytebuddy.dynamic.scaffold.MethodGraph
        public Node locate(MethodDescription.SignatureToken signatureToken) {
            return Node.Unresolved.INSTANCE;
        }

        @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler
        public Linked compile(TypeDefinition typeDefinition, TypeDescription typeDescription) {
            return this;
        }

        @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler
        @Deprecated
        public Linked compile(TypeDescription typeDescription) {
            return this;
        }

        @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler
        @Deprecated
        public Linked compile(TypeDescription typeDescription, TypeDescription typeDescription2) {
            return this;
        }
    }

    public interface Linked extends MethodGraph {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Delegation implements Linked {
            private final Map<TypeDescription, MethodGraph> interfaceGraphs;
            private final MethodGraph methodGraph;
            private final MethodGraph superClassGraph;

            public Delegation(MethodGraph methodGraph, MethodGraph methodGraph2, Map<TypeDescription, MethodGraph> map) {
                this.methodGraph = methodGraph;
                this.superClassGraph = methodGraph2;
                this.interfaceGraphs = map;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Delegation delegation = (Delegation) obj;
                return this.methodGraph.equals(delegation.methodGraph) && this.superClassGraph.equals(delegation.superClassGraph) && this.interfaceGraphs.equals(delegation.interfaceGraphs);
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Linked
            public MethodGraph getInterfaceGraph(TypeDescription typeDescription) {
                MethodGraph methodGraph = this.interfaceGraphs.get(typeDescription);
                return methodGraph == null ? Empty.INSTANCE : methodGraph;
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Linked
            public MethodGraph getSuperClassGraph() {
                return this.superClassGraph;
            }

            public int hashCode() {
                return this.interfaceGraphs.hashCode() + ((this.superClassGraph.hashCode() + ((this.methodGraph.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31);
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph
            public NodeList listNodes() {
                return this.methodGraph.listNodes();
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph
            public Node locate(MethodDescription.SignatureToken signatureToken) {
                return this.methodGraph.locate(signatureToken);
            }
        }

        MethodGraph getInterfaceGraph(TypeDescription typeDescription);

        MethodGraph getSuperClassGraph();
    }

    public interface Node {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Simple implements Node {
            private final MethodDescription methodDescription;

            public Simple(MethodDescription methodDescription) {
                this.methodDescription = methodDescription;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.methodDescription.equals(((Simple) obj).methodDescription);
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Node
            public Set<MethodDescription.TypeToken> getMethodTypes() {
                return Collections.EMPTY_SET;
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Node
            public MethodDescription getRepresentative() {
                return this.methodDescription;
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Node
            public Sort getSort() {
                return Sort.RESOLVED;
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Node
            public Visibility getVisibility() {
                return this.methodDescription.getVisibility();
            }

            public int hashCode() {
                return this.methodDescription.hashCode() + (getClass().hashCode() * 31);
            }
        }

        public enum Sort {
            VISIBLE(true, true, true),
            RESOLVED(true, true, false),
            AMBIGUOUS(true, false, false),
            UNRESOLVED(false, false, false);

            private final boolean madeVisible;
            private final boolean resolved;
            private final boolean unique;

            Sort(boolean z6, boolean z7, boolean z8) {
                this.resolved = z6;
                this.unique = z7;
                this.madeVisible = z8;
            }

            public boolean isMadeVisible() {
                return this.madeVisible;
            }

            public boolean isResolved() {
                return this.resolved;
            }

            public boolean isUnique() {
                return this.unique;
            }
        }

        public enum Unresolved implements Node {
            INSTANCE;

            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Node
            public Set<MethodDescription.TypeToken> getMethodTypes() {
                throw new IllegalStateException("Cannot resolve bridge method of an illegal node");
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Node
            public MethodDescription getRepresentative() {
                throw new IllegalStateException("Cannot resolve the method of an illegal node");
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Node
            public Sort getSort() {
                return Sort.UNRESOLVED;
            }

            @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Node
            public Visibility getVisibility() {
                throw new IllegalStateException("Cannot resolve visibility of an illegal node");
            }
        }

        Set<MethodDescription.TypeToken> getMethodTypes();

        MethodDescription getRepresentative();

        Sort getSort();

        Visibility getVisibility();
    }

    public static class NodeList extends FilterableList.AbstractBase<Node, NodeList> {
        private final List<? extends Node> nodes;

        public NodeList(List<? extends Node> list) {
            this.nodes = list;
        }

        public MethodList<?> asMethodList() {
            ArrayList arrayList = new ArrayList(size());
            Iterator<? extends Node> it = this.nodes.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getRepresentative());
            }
            return new MethodList.Explicit(arrayList);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.nodes.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public Node get(int i) {
            return this.nodes.get(i);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // net.bytebuddy.matcher.FilterableList.AbstractBase
        public NodeList wrap(List<Node> list) {
            return new NodeList(list);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Simple implements MethodGraph {
        private final LinkedHashMap<MethodDescription.SignatureToken, Node> nodes;

        public Simple(LinkedHashMap<MethodDescription.SignatureToken, Node> linkedHashMap) {
            this.nodes = linkedHashMap;
        }

        public static MethodGraph of(List<? extends MethodDescription> list) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (MethodDescription methodDescription : list) {
                linkedHashMap.put(methodDescription.asSignatureToken(), new Node.Simple(methodDescription));
            }
            return new Simple(linkedHashMap);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.nodes.equals(((Simple) obj).nodes);
        }

        public int hashCode() {
            return this.nodes.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.dynamic.scaffold.MethodGraph
        public NodeList listNodes() {
            return new NodeList(new ArrayList(this.nodes.values()));
        }

        @Override // net.bytebuddy.dynamic.scaffold.MethodGraph
        public Node locate(MethodDescription.SignatureToken signatureToken) {
            Node node = this.nodes.get(signatureToken);
            return node == null ? Node.Unresolved.INSTANCE : node;
        }
    }

    NodeList listNodes();

    Node locate(MethodDescription.SignatureToken signatureToken);
}
