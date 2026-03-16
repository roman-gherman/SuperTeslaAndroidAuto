package org.mockito;

import java.util.function.Function;
import org.mockito.MockedConstruction;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4436a;
    public final /* synthetic */ MockSettings b;

    public /* synthetic */ a(MockSettings mockSettings, int i) {
        this.f4436a = i;
        this.b = mockSettings;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f4436a) {
            case 0:
                return Mockito.lambda$mockConstruction$6(this.b, (MockedConstruction.Context) obj);
            default:
                return Mockito.lambda$mockConstruction$4(this.b, (MockedConstruction.Context) obj);
        }
    }
}
