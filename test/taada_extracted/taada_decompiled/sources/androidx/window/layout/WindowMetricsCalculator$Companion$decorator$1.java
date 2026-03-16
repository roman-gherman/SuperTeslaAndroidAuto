package androidx.window.layout;

import fr.sd.taada.helpers.LocaleHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.i;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/window/layout/WindowMetricsCalculator;", LocaleHelper.LANGUAGE_ITALIAN, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class WindowMetricsCalculator$Companion$decorator$1 extends i implements Function1<WindowMetricsCalculator, WindowMetricsCalculator> {
    public static final WindowMetricsCalculator$Companion$decorator$1 INSTANCE = new WindowMetricsCalculator$Companion$decorator$1();

    public WindowMetricsCalculator$Companion$decorator$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WindowMetricsCalculator invoke(WindowMetricsCalculator it) {
        h.f(it, "it");
        return it;
    }
}
