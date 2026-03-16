package androidx.fragment.app;

import N1.m;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a:\u0010\b\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a:\u0010\n\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\t\u001aD\u0010\f\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, d2 = {"Landroidx/fragment/app/FragmentManager;", "", "allowStateLoss", "Lkotlin/Function1;", "Landroidx/fragment/app/FragmentTransaction;", "LN1/m;", "Lkotlin/ExtensionFunctionType;", "body", "commit", "(Landroidx/fragment/app/FragmentManager;ZLkotlin/jvm/functions/Function1;)V", "commitNow", "now", "transaction", "(Landroidx/fragment/app/FragmentManager;ZZLkotlin/jvm/functions/Function1;)V", "fragment-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FragmentManagerKt {
    public static final void commit(FragmentManager fragmentManager, boolean z6, Function1<? super FragmentTransaction, m> body) {
        kotlin.jvm.internal.h.f(fragmentManager, "<this>");
        kotlin.jvm.internal.h.f(body, "body");
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        kotlin.jvm.internal.h.e(fragmentTransactionBeginTransaction, "beginTransaction()");
        body.invoke(fragmentTransactionBeginTransaction);
        if (z6) {
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        } else {
            fragmentTransactionBeginTransaction.commit();
        }
    }

    public static /* synthetic */ void commit$default(FragmentManager fragmentManager, boolean z6, Function1 body, int i, Object obj) {
        if ((i & 1) != 0) {
            z6 = false;
        }
        kotlin.jvm.internal.h.f(fragmentManager, "<this>");
        kotlin.jvm.internal.h.f(body, "body");
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        kotlin.jvm.internal.h.e(fragmentTransactionBeginTransaction, "beginTransaction()");
        body.invoke(fragmentTransactionBeginTransaction);
        if (z6) {
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        } else {
            fragmentTransactionBeginTransaction.commit();
        }
    }

    public static final void commitNow(FragmentManager fragmentManager, boolean z6, Function1<? super FragmentTransaction, m> body) {
        kotlin.jvm.internal.h.f(fragmentManager, "<this>");
        kotlin.jvm.internal.h.f(body, "body");
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        kotlin.jvm.internal.h.e(fragmentTransactionBeginTransaction, "beginTransaction()");
        body.invoke(fragmentTransactionBeginTransaction);
        if (z6) {
            fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
        } else {
            fragmentTransactionBeginTransaction.commitNow();
        }
    }

    public static /* synthetic */ void commitNow$default(FragmentManager fragmentManager, boolean z6, Function1 body, int i, Object obj) {
        if ((i & 1) != 0) {
            z6 = false;
        }
        kotlin.jvm.internal.h.f(fragmentManager, "<this>");
        kotlin.jvm.internal.h.f(body, "body");
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        kotlin.jvm.internal.h.e(fragmentTransactionBeginTransaction, "beginTransaction()");
        body.invoke(fragmentTransactionBeginTransaction);
        if (z6) {
            fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
        } else {
            fragmentTransactionBeginTransaction.commitNow();
        }
    }

    @Deprecated(message = "Use commit { .. } or commitNow { .. } extensions")
    public static final void transaction(FragmentManager fragmentManager, boolean z6, boolean z7, Function1<? super FragmentTransaction, m> body) {
        kotlin.jvm.internal.h.f(fragmentManager, "<this>");
        kotlin.jvm.internal.h.f(body, "body");
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        kotlin.jvm.internal.h.e(fragmentTransactionBeginTransaction, "beginTransaction()");
        body.invoke(fragmentTransactionBeginTransaction);
        if (z6) {
            if (z7) {
                fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
                return;
            } else {
                fragmentTransactionBeginTransaction.commitNow();
                return;
            }
        }
        if (z7) {
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        } else {
            fragmentTransactionBeginTransaction.commit();
        }
    }

    public static /* synthetic */ void transaction$default(FragmentManager fragmentManager, boolean z6, boolean z7, Function1 body, int i, Object obj) {
        if ((i & 1) != 0) {
            z6 = false;
        }
        if ((i & 2) != 0) {
            z7 = false;
        }
        kotlin.jvm.internal.h.f(fragmentManager, "<this>");
        kotlin.jvm.internal.h.f(body, "body");
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        kotlin.jvm.internal.h.e(fragmentTransactionBeginTransaction, "beginTransaction()");
        body.invoke(fragmentTransactionBeginTransaction);
        if (z6) {
            if (z7) {
                fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
                return;
            } else {
                fragmentTransactionBeginTransaction.commitNow();
                return;
            }
        }
        if (z7) {
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        } else {
            fragmentTransactionBeginTransaction.commit();
        }
    }
}
