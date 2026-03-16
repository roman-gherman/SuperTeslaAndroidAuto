package net.bytebuddy.description;

import net.bytebuddy.description.ModifierReviewable;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
public interface TypeVariableSource extends ModifierReviewable.OfAbstraction {

    @AlwaysNull
    public static final TypeVariableSource UNDEFINED = null;

    public static abstract class AbstractBase extends ModifierReviewable.AbstractBase implements TypeVariableSource {
        @Override // net.bytebuddy.description.TypeVariableSource
        public TypeDescription.Generic findExpectedVariable(String str) {
            TypeDescription.Generic genericFindVariable = findVariable(str);
            if (genericFindVariable != null) {
                return genericFindVariable;
            }
            throw new IllegalArgumentException("Cannot resolve " + str + " from " + this);
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        @MaybeNull
        public TypeDescription.Generic findVariable(String str) {
            TypeList.Generic genericFilter = getTypeVariables().filter(ElementMatchers.named(str));
            if (!genericFilter.isEmpty()) {
                return genericFilter.getOnly();
            }
            TypeVariableSource enclosingSource = getEnclosingSource();
            return enclosingSource == null ? TypeDescription.Generic.UNDEFINED : enclosingSource.findVariable(str);
        }
    }

    public interface Visitor<T> {

        public enum NoOp implements Visitor<TypeVariableSource> {
            INSTANCE;

            @Override // net.bytebuddy.description.TypeVariableSource.Visitor
            public TypeVariableSource onMethod(MethodDescription.InDefinedShape inDefinedShape) {
                return inDefinedShape;
            }

            @Override // net.bytebuddy.description.TypeVariableSource.Visitor
            public TypeVariableSource onType(TypeDescription typeDescription) {
                return typeDescription;
            }
        }

        T onMethod(MethodDescription.InDefinedShape inDefinedShape);

        T onType(TypeDescription typeDescription);
    }

    <T> T accept(Visitor<T> visitor);

    TypeDescription.Generic findExpectedVariable(String str);

    @MaybeNull
    TypeDescription.Generic findVariable(String str);

    @MaybeNull
    TypeVariableSource getEnclosingSource();

    TypeList.Generic getTypeVariables();

    boolean isGenerified();

    boolean isInferrable();
}
