package androidx.core.content;

import N1.m;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a7\u0010\b\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\b¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/content/SharedPreferences;", "", "commit", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "LN1/m;", "Lkotlin/ExtensionFunctionType;", "action", "edit", "(Landroid/content/SharedPreferences;ZLkotlin/jvm/functions/Function1;)V", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SharedPreferencesKt {
    public static final void edit(SharedPreferences sharedPreferences, boolean z6, Function1<? super SharedPreferences.Editor, m> function1) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        function1.invoke(editorEdit);
        if (z6) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }

    public static /* synthetic */ void edit$default(SharedPreferences sharedPreferences, boolean z6, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z6 = false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        function1.invoke(editorEdit);
        if (z6) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }
}
