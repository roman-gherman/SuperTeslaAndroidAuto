package org.mockito.internal.debugging;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.mockito.internal.invocation.InvocationMatcher;
import org.mockito.internal.util.StringUtil;
import org.mockito.invocation.Invocation;

/* JADX INFO: loaded from: classes.dex */
public class LoggingListener implements FindingsListener {
    private final boolean warnAboutUnstubbed;
    private final List<String> argMismatchStubs = new LinkedList();
    private final List<String> unusedStubs = new LinkedList();
    private final List<String> unstubbedCalls = new LinkedList();

    public LoggingListener(boolean z6) {
        this.warnAboutUnstubbed = z6;
    }

    private void addOrderedList(List<String> list, List<String> list2) {
        Iterator<String> it = list2.iterator();
        while (it.hasNext()) {
            list.add("[Mockito] " + it.next());
        }
    }

    public static int indexOfNextPair(int i) {
        return (i / 2) + 1;
    }

    @Override // org.mockito.internal.debugging.FindingsListener
    public void foundStubCalledWithDifferentArgs(Invocation invocation, InvocationMatcher invocationMatcher) {
        String string = Integer.toString(indexOfNextPair(this.argMismatchStubs.size()));
        String strReplaceAll = string.replaceAll("\\d", " ");
        List<String> list = this.argMismatchStubs;
        StringBuilder sbL = B2.b.l(string, ". Stubbed ");
        sbL.append(invocation.getLocation());
        list.add(sbL.toString());
        List<String> list2 = this.argMismatchStubs;
        StringBuilder sbL2 = B2.b.l(strReplaceAll, "  Invoked ");
        sbL2.append(invocationMatcher.getInvocation().getLocation());
        list2.add(sbL2.toString());
    }

    @Override // org.mockito.internal.debugging.FindingsListener
    public void foundUnstubbed(InvocationMatcher invocationMatcher) {
        if (this.warnAboutUnstubbed) {
            this.unstubbedCalls.add((this.unstubbedCalls.size() + 1) + ". " + invocationMatcher.getInvocation().getLocation());
        }
    }

    @Override // org.mockito.internal.debugging.FindingsListener
    public void foundUnusedStub(Invocation invocation) {
        this.unusedStubs.add((this.unusedStubs.size() + 1) + ". " + invocation.getLocation());
    }

    public String getStubbingInfo() {
        if (this.argMismatchStubs.isEmpty() && this.unusedStubs.isEmpty() && this.unstubbedCalls.isEmpty()) {
            return "";
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add("[Mockito] Additional stubbing information (see javadoc for StubbingInfo class):");
        if (!this.argMismatchStubs.isEmpty()) {
            linkedList.add("[Mockito]");
            linkedList.add("[Mockito] Argument mismatch between stubbing and actual invocation (is stubbing correct in the test?):");
            linkedList.add("[Mockito]");
            addOrderedList(linkedList, this.argMismatchStubs);
        }
        if (!this.unusedStubs.isEmpty()) {
            linkedList.add("[Mockito]");
            linkedList.add("[Mockito] Unused stubbing (perhaps can be removed from the test?):");
            linkedList.add("[Mockito]");
            addOrderedList(linkedList, this.unusedStubs);
        }
        if (!this.unstubbedCalls.isEmpty()) {
            linkedList.add("[Mockito]");
            linkedList.add("[Mockito] Unstubbed method invocations (perhaps missing stubbing in the test?):");
            linkedList.add("[Mockito]");
            addOrderedList(linkedList, this.unstubbedCalls);
        }
        return StringUtil.join("", linkedList);
    }
}
