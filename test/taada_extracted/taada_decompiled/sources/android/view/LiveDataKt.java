package android.view;

import N1.m;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aD\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004H\u0087\b¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"T", "Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lkotlin/Function1;", "LN1/m;", "onChanged", "Landroidx/lifecycle/Observer;", "observe", "(Landroidx/lifecycle/LiveData;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;)Landroidx/lifecycle/Observer;", "lifecycle-livedata-core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LiveDataKt {
    @Deprecated(message = "This extension method is not required when using Kotlin 1.4. You should remove \"import androidx.lifecycle.observe\"")
    public static final <T> Observer<T> observe(LiveData<T> liveData, LifecycleOwner lifecycleOwner, final Function1<? super T, m> function1) {
        Observer<T> observer = new Observer() { // from class: androidx.lifecycle.LiveDataKt$observe$wrappedObserver$1
            @Override // android.view.Observer
            public final void onChanged(T t6) {
                function1.invoke(t6);
            }
        };
        liveData.observe(lifecycleOwner, observer);
        return observer;
    }
}
