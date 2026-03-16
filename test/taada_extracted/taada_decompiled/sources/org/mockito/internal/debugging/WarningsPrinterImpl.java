package org.mockito.internal.debugging;

import java.util.List;
import org.mockito.internal.invocation.InvocationMatcher;
import org.mockito.invocation.Invocation;

/* JADX INFO: loaded from: classes.dex */
public class WarningsPrinterImpl {
    private final WarningsFinder finder;
    private final boolean warnAboutUnstubbed;

    public WarningsPrinterImpl(List<Invocation> list, List<InvocationMatcher> list2, boolean z6) {
        this(z6, new WarningsFinder(list, list2));
    }

    public String print() {
        LoggingListener loggingListener = new LoggingListener(this.warnAboutUnstubbed);
        this.finder.find(loggingListener);
        return loggingListener.getStubbingInfo();
    }

    public WarningsPrinterImpl(boolean z6, WarningsFinder warningsFinder) {
        this.warnAboutUnstubbed = z6;
        this.finder = warningsFinder;
    }
}
