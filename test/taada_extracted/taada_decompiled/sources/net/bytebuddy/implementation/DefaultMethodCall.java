package net.bytebuddy.implementation;

import com.google.protobuf.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
@HashCodeAndEqualsPlugin.Enhance
public class DefaultMethodCall implements Implementation {
    private final List<TypeDescription> prioritizedInterfaces;

    @HashCodeAndEqualsPlugin.Enhance
    public static class Appender implements ByteCodeAppender {
        private final Implementation.Target implementationTarget;

        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
        private final Set<TypeDescription> nonPrioritizedInterfaces;
        private final List<TypeDescription> prioritizedInterfaces;

        public Appender(Implementation.Target target, List<TypeDescription> list) {
            this.implementationTarget = target;
            this.prioritizedInterfaces = list;
            HashSet hashSet = new HashSet(target.getInstrumentedType().getInterfaces().asErasures());
            this.nonPrioritizedInterfaces = hashSet;
            hashSet.removeAll(list);
        }

        private StackManipulation locateDefault(MethodDescription methodDescription) {
            MethodDescription.SignatureToken signatureTokenAsSignatureToken = methodDescription.asSignatureToken();
            Implementation.SpecialMethodInvocation specialMethodInvocationWithCheckedCompatibilityTo = Implementation.SpecialMethodInvocation.Illegal.INSTANCE;
            Iterator<TypeDescription> it = this.prioritizedInterfaces.iterator();
            while (it.hasNext()) {
                specialMethodInvocationWithCheckedCompatibilityTo = this.implementationTarget.invokeDefault(signatureTokenAsSignatureToken, it.next()).withCheckedCompatibilityTo(methodDescription.asTypeToken());
                if (specialMethodInvocationWithCheckedCompatibilityTo.isValid()) {
                    return specialMethodInvocationWithCheckedCompatibilityTo;
                }
            }
            Iterator<TypeDescription> it2 = this.nonPrioritizedInterfaces.iterator();
            while (it2.hasNext()) {
                Implementation.SpecialMethodInvocation specialMethodInvocationWithCheckedCompatibilityTo2 = this.implementationTarget.invokeDefault(signatureTokenAsSignatureToken, it2.next()).withCheckedCompatibilityTo(methodDescription.asTypeToken());
                if (specialMethodInvocationWithCheckedCompatibilityTo.isValid() && specialMethodInvocationWithCheckedCompatibilityTo2.isValid()) {
                    throw new IllegalStateException(methodDescription + " has an ambiguous default method with " + specialMethodInvocationWithCheckedCompatibilityTo2.getMethodDescription() + " and " + specialMethodInvocationWithCheckedCompatibilityTo.getMethodDescription());
                }
                specialMethodInvocationWithCheckedCompatibilityTo = specialMethodInvocationWithCheckedCompatibilityTo2;
            }
            return specialMethodInvocationWithCheckedCompatibilityTo;
        }

        @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            StackManipulation stackManipulationLocateDefault = locateDefault(methodDescription);
            if (stackManipulationLocateDefault.isValid()) {
                return new ByteCodeAppender.Size(new StackManipulation.Compound(MethodVariableAccess.allArgumentsOf(methodDescription).prependThisReference(), stackManipulationLocateDefault, MethodReturn.of(methodDescription.getReturnType())).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
            }
            throw new IllegalStateException(a.l("Cannot invoke default method on ", methodDescription));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Appender appender = (Appender) obj;
            return this.implementationTarget.equals(appender.implementationTarget) && this.prioritizedInterfaces.equals(appender.prioritizedInterfaces);
        }

        public int hashCode() {
            return this.prioritizedInterfaces.hashCode() + ((this.implementationTarget.hashCode() + (getClass().hashCode() * 31)) * 31);
        }
    }

    public DefaultMethodCall(List<TypeDescription> list) {
        this.prioritizedInterfaces = list;
    }

    private List<TypeDescription> filterRelevant(TypeDescription typeDescription) {
        ArrayList arrayList = new ArrayList(this.prioritizedInterfaces.size());
        HashSet hashSet = new HashSet(typeDescription.getInterfaces().asErasures());
        for (TypeDescription typeDescription2 : this.prioritizedInterfaces) {
            if (hashSet.remove(typeDescription2)) {
                arrayList.add(typeDescription2);
            }
        }
        return arrayList;
    }

    public static Implementation prioritize(Class<?>... clsArr) {
        return prioritize((Collection<? extends TypeDescription>) new TypeList.ForLoadedTypes(clsArr));
    }

    public static Implementation unambiguousOnly() {
        return new DefaultMethodCall(Collections.EMPTY_LIST);
    }

    @Override // net.bytebuddy.implementation.Implementation
    public ByteCodeAppender appender(Implementation.Target target) {
        return new Appender(target, filterRelevant(target.getInstrumentedType()));
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.prioritizedInterfaces.equals(((DefaultMethodCall) obj).prioritizedInterfaces);
    }

    public int hashCode() {
        return this.prioritizedInterfaces.hashCode() + (getClass().hashCode() * 31);
    }

    @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
    public InstrumentedType prepare(InstrumentedType instrumentedType) {
        return instrumentedType;
    }

    public static Implementation prioritize(Iterable<? extends Class<?>> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<? extends Class<?>> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return prioritize((Collection<? extends TypeDescription>) new TypeList.ForLoadedTypes(arrayList));
    }

    public static Implementation prioritize(TypeDescription... typeDescriptionArr) {
        return prioritize((Collection<? extends TypeDescription>) Arrays.asList(typeDescriptionArr));
    }

    public static Implementation prioritize(Collection<? extends TypeDescription> collection) {
        return new DefaultMethodCall(new ArrayList(collection));
    }
}
