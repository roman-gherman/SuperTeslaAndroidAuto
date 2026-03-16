package m5;

import java.util.function.Function;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.internal.MockitoCore;
import org.mockito.stubbing.Answer;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4157a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a(int i, Object obj, Object obj2) {
        this.f4157a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        MockedConstruction.Context context = (MockedConstruction.Context) obj;
        switch (this.f4157a) {
            case 0:
                return MockitoCore.lambda$mockConstruction$0((Function) this.b, (Class) this.c, context);
            default:
                return Mockito.lambda$mockConstructionWithAnswer$0((Answer[]) this.b, (Answer) this.c, context);
        }
    }
}
