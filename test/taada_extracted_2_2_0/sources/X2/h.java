package X2;

import G2.B;
import G2.C0125z;
import G2.U;
import a3.AbstractC0162z;
import a3.F;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import n2.EnumC0719k;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements DeserializationConfiguration, FlexibleTypeDeserializer, LocalClassifierTypeSettings, ContractDeserializer, ErrorReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f1432a = new h();
    public static final h b = new h();
    public static final h c = new h();

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i != 1) {
            objArr[0] = "descriptor";
        } else {
            objArr[0] = "unresolvedSuperClasses";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter$1";
        if (i != 2) {
            objArr[2] = "reportIncompleteHierarchy";
        } else {
            objArr[2] = "reportCannotInferVisibility";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static EnumC0719k b(B b2) {
        int i = b2 == null ? -1 : s.f1449a[b2.ordinal()];
        EnumC0719k enumC0719k = EnumC0719k.f4248a;
        if (i != 1) {
            if (i == 2) {
                return EnumC0719k.c;
            }
            if (i == 3) {
                return EnumC0719k.d;
            }
            if (i == 4) {
                return EnumC0719k.b;
            }
        }
        return enumC0719k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer
    public AbstractC0162z create(U proto, String flexibleId, F lowerBound, F upperBound) {
        kotlin.jvm.internal.h.f(proto, "proto");
        kotlin.jvm.internal.h.f(flexibleId, "flexibleId");
        kotlin.jvm.internal.h.f(lowerBound, "lowerBound");
        kotlin.jvm.internal.h.f(upperBound, "upperBound");
        throw new IllegalArgumentException("This method should not be used.");
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer
    public N1.e deserializeContractFromFunction(C0125z proto, FunctionDescriptor ownerFunction, I2.f typeTable, y typeDeserializer) {
        kotlin.jvm.internal.h.f(proto, "proto");
        kotlin.jvm.internal.h.f(ownerFunction, "ownerFunction");
        kotlin.jvm.internal.h.f(typeTable, "typeTable");
        kotlin.jvm.internal.h.f(typeDeserializer, "typeDeserializer");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
    public boolean getAllowUnstableDependencies() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
    public I2.a getBinaryVersion() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
    public boolean getPreserveDeclarationsOrdering() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings
    public F getReplacementTypeForLocalClassifiers() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
    public boolean getReportErrorsOnPreReleaseDependencies() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
    public boolean getSkipMetadataVersionCheck() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
    public boolean getSkipPrereleaseCheck() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
    public boolean getTypeAliasesAllowed() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter
    public void reportCannotInferVisibility(CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor != null) {
            return;
        }
        a(2);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter
    public void reportIncompleteHierarchy(ClassDescriptor classDescriptor, List list) {
        if (classDescriptor == null) {
            a(0);
            throw null;
        }
        if (list != null) {
            return;
        }
        a(1);
        throw null;
    }
}
