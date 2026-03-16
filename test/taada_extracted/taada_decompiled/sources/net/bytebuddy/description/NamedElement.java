package net.bytebuddy.description;

import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
public interface NamedElement {
    public static final String EMPTY_NAME = "";

    @AlwaysNull
    public static final String NO_NAME = null;

    public interface WithDescriptor extends NamedElement {

        @AlwaysNull
        public static final String NON_GENERIC_SIGNATURE = null;

        String getDescriptor();

        @MaybeNull
        String getGenericSignature();
    }

    public interface WithGenericName extends WithRuntimeName {
        String toGenericString();
    }

    public interface WithOptionalName extends NamedElement {
        boolean isNamed();
    }

    public interface WithRuntimeName extends NamedElement {
        String getInternalName();

        String getName();
    }

    String getActualName();
}
