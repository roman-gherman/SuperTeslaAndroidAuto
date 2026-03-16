package g3;

import c4.AbstractC0246d;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.util.Check;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o implements Check {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3316a;
    public final String b;

    public /* synthetic */ o(String str, int i) {
        this.f3316a = i;
        this.b = str;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public final String getDescription() {
        switch (this.f3316a) {
        }
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public final String invoke(FunctionDescriptor functionDescriptor) {
        switch (this.f3316a) {
        }
        return AbstractC0246d.X(this, functionDescriptor);
    }
}
