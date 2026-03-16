package n5;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.function.Predicate;
import org.mockito.internal.configuration.injection.PropertyAndSetterInjection;
import org.mockito.internal.invocation.finder.VerifiableInvocationsFinder;
import org.mockito.internal.verification.DefaultRegisteredInvocations;
import org.mockito.internal.verification.argumentmatching.ArgumentMatchingTool;
import org.mockito.invocation.Invocation;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4265a;

    public /* synthetic */ a(int i) {
        this.f4265a = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f4265a) {
            case 0:
                return VerifiableInvocationsFinder.lambda$find$0((Invocation) obj);
            case 1:
                return ArgumentMatchingTool.lambda$getNotMatchingArgsWithSameName$2((Map.Entry) obj);
            case 2:
                return PropertyAndSetterInjection.lambda$orderedInstanceFieldsFrom$0((Field) obj);
            default:
                return DefaultRegisteredInvocations.lambda$getAll$0((Invocation) obj);
        }
    }
}
