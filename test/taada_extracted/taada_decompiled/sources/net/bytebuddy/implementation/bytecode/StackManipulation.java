package net.bytebuddy.implementation.bytecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
public interface StackManipulation {

    public static abstract class AbstractBase implements StackManipulation {
        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public boolean isValid() {
            return true;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Compound implements StackManipulation {
        private final List<StackManipulation> stackManipulations;

        public Compound(StackManipulation... stackManipulationArr) {
            this((List<? extends StackManipulation>) Arrays.asList(stackManipulationArr));
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            Size sizeAggregate = Size.ZERO;
            Iterator<StackManipulation> it = this.stackManipulations.iterator();
            while (it.hasNext()) {
                sizeAggregate = sizeAggregate.aggregate(it.next().apply(methodVisitor, context));
            }
            return sizeAggregate;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.stackManipulations.equals(((Compound) obj).stackManipulations);
        }

        public int hashCode() {
            return this.stackManipulations.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public boolean isValid() {
            Iterator<StackManipulation> it = this.stackManipulations.iterator();
            while (it.hasNext()) {
                if (!it.next().isValid()) {
                    return false;
                }
            }
            return true;
        }

        public Compound(List<? extends StackManipulation> list) {
            this.stackManipulations = new ArrayList();
            for (StackManipulation stackManipulation : list) {
                if (stackManipulation instanceof Compound) {
                    this.stackManipulations.addAll(((Compound) stackManipulation).stackManipulations);
                } else if (!(stackManipulation instanceof Trivial)) {
                    this.stackManipulations.add(stackManipulation);
                }
            }
        }
    }

    public enum Illegal implements StackManipulation {
        INSTANCE;

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            throw new IllegalStateException("An illegal stack manipulation must not be applied");
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public boolean isValid() {
            return false;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Simple extends AbstractBase {
        private final Dispatcher dispatcher;

        public interface Dispatcher {
            Size apply(MethodVisitor methodVisitor, Implementation.Context context);
        }

        public Simple(Dispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            return this.dispatcher.apply(methodVisitor, context);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.dispatcher.equals(((Simple) obj).dispatcher);
        }

        public int hashCode() {
            return this.dispatcher.hashCode() + (getClass().hashCode() * 31);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Size {
        public static final Size ZERO = new Size(0, 0);
        private final int maximalSize;
        private final int sizeImpact;

        public Size(int i, int i3) {
            this.sizeImpact = i;
            this.maximalSize = i3;
        }

        public Size aggregate(Size size) {
            return aggregate(size.sizeImpact, size.maximalSize);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Size size = (Size) obj;
            return this.sizeImpact == size.sizeImpact && this.maximalSize == size.maximalSize;
        }

        public int getMaximalSize() {
            return this.maximalSize;
        }

        public int getSizeImpact() {
            return this.sizeImpact;
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.sizeImpact) * 31) + this.maximalSize;
        }

        private Size aggregate(int i, int i3) {
            int i4 = this.sizeImpact;
            return new Size(i + i4, Math.max(this.maximalSize, i4 + i3));
        }
    }

    public enum Trivial implements StackManipulation {
        INSTANCE;

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            return StackSize.ZERO.toIncreasingSize();
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public boolean isValid() {
            return true;
        }
    }

    Size apply(MethodVisitor methodVisitor, Implementation.Context context);

    boolean isValid();
}
