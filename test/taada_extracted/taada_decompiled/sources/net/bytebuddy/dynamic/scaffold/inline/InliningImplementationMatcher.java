package net.bytebuddy.dynamic.scaffold.inline;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.matcher.LatentMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
@HashCodeAndEqualsPlugin.Enhance
public class InliningImplementationMatcher implements LatentMatcher<MethodDescription> {
    private final LatentMatcher<? super MethodDescription> ignoredMethods;
    private final ElementMatcher<? super MethodDescription> predefinedMethodSignatures;

    public InliningImplementationMatcher(LatentMatcher<? super MethodDescription> latentMatcher, ElementMatcher<? super MethodDescription> elementMatcher) {
        this.ignoredMethods = latentMatcher;
        this.predefinedMethodSignatures = elementMatcher;
    }

    public static LatentMatcher<MethodDescription> of(LatentMatcher<? super MethodDescription> latentMatcher, TypeDescription typeDescription) {
        ElementMatcher.Junction junctionNone = ElementMatchers.none();
        for (MethodDescription.InDefinedShape inDefinedShape : typeDescription.getDeclaredMethods()) {
            junctionNone = junctionNone.or((inDefinedShape.isConstructor() ? ElementMatchers.isConstructor() : ElementMatchers.named(inDefinedShape.getName())).and(ElementMatchers.returns(inDefinedShape.getReturnType().asErasure())).and(ElementMatchers.takesArguments(inDefinedShape.getParameters().asTypeList().asErasures())));
        }
        return new InliningImplementationMatcher(latentMatcher, junctionNone);
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InliningImplementationMatcher inliningImplementationMatcher = (InliningImplementationMatcher) obj;
        return this.ignoredMethods.equals(inliningImplementationMatcher.ignoredMethods) && this.predefinedMethodSignatures.equals(inliningImplementationMatcher.predefinedMethodSignatures);
    }

    public int hashCode() {
        return this.predefinedMethodSignatures.hashCode() + ((this.ignoredMethods.hashCode() + (getClass().hashCode() * 31)) * 31);
    }

    @Override // net.bytebuddy.matcher.LatentMatcher
    public ElementMatcher<? super MethodDescription> resolve(TypeDescription typeDescription) {
        return ElementMatchers.not(this.ignoredMethods.resolve(typeDescription)).and(ElementMatchers.isVirtual().and(ElementMatchers.not(ElementMatchers.isFinal())).or(ElementMatchers.isDeclaredBy(typeDescription))).or(ElementMatchers.isDeclaredBy(typeDescription).and(ElementMatchers.not(this.predefinedMethodSignatures)));
    }
}
