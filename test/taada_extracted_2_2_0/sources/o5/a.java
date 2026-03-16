package o5;

import java.util.Map;
import java.util.function.Function;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.internal.util.MockUtil;
import org.mockito.internal.verification.argumentmatching.ArgumentMatchingTool;
import org.mockito.invocation.Invocation;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4383a;

    public /* synthetic */ a(int i) {
        this.f4383a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f4383a) {
            case 0:
                return ArgumentMatchingTool.lambda$getNotMatchingArgsWithSameName$0((String) obj);
            case 1:
                return ArgumentMatchingTool.lambda$getNotMatchingArgsWithSameName$1((String) obj);
            case 2:
                return ArgumentMatchingTool.lambda$getNotMatchingArgsWithSameName$3((Map.Entry) obj);
            case 3:
                return Mockito.lambda$mockConstruction$2((MockedConstruction.Context) obj);
            case 4:
                return MockUtil.lambda$getMockMaker$0((Class) obj);
            default:
                return ((Invocation) obj).getLocation();
        }
    }
}
