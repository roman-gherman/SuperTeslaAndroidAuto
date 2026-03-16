package net.bytebuddy.description.modifier;

import java.util.Arrays;
import java.util.Collection;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
public interface ModifierContributor {
    public static final int EMPTY_MASK = 0;

    public interface ForField extends ModifierContributor {
        public static final int MASK = 151775;
    }

    public interface ForMethod extends ModifierContributor {
        public static final int MASK = 7679;
    }

    public interface ForParameter extends ModifierContributor {
        public static final int MASK = 36880;
    }

    public interface ForType extends ModifierContributor {
        public static final int MASK = 161311;
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Resolver<T extends ModifierContributor> {
        private final Collection<? extends T> modifierContributors;

        public Resolver(Collection<? extends T> collection) {
            this.modifierContributors = collection;
        }

        public static Resolver<ForType> of(ForType... forTypeArr) {
            return of(Arrays.asList(forTypeArr));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.modifierContributors.equals(((Resolver) obj).modifierContributors);
        }

        public int hashCode() {
            return this.modifierContributors.hashCode() + (getClass().hashCode() * 31);
        }

        public int resolve() {
            return resolve(0);
        }

        public static Resolver<ForField> of(ForField... forFieldArr) {
            return of(Arrays.asList(forFieldArr));
        }

        public int resolve(int i) {
            for (T t6 : this.modifierContributors) {
                i = (i & (~t6.getRange())) | t6.getMask();
            }
            return i;
        }

        public static Resolver<ForMethod> of(ForMethod... forMethodArr) {
            return of(Arrays.asList(forMethodArr));
        }

        public static Resolver<ForParameter> of(ForParameter... forParameterArr) {
            return of(Arrays.asList(forParameterArr));
        }

        public static <S extends ModifierContributor> Resolver<S> of(Collection<? extends S> collection) {
            return new Resolver<>(collection);
        }
    }

    int getMask();

    int getRange();

    boolean isDefault();
}
