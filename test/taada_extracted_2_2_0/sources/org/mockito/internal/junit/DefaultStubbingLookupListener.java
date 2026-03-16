package org.mockito.internal.junit;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.stubbing.StrictnessSelector;
import org.mockito.internal.stubbing.UnusedStubbingReporting;
import org.mockito.invocation.Invocation;
import org.mockito.listeners.StubbingLookupEvent;
import org.mockito.listeners.StubbingLookupListener;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.Stubbing;

/* JADX INFO: loaded from: classes.dex */
class DefaultStubbingLookupListener implements StubbingLookupListener, Serializable {
    private static final long serialVersionUID = -6789800638070123629L;
    private Strictness currentStrictness;
    private boolean mismatchesReported;

    public DefaultStubbingLookupListener(Strictness strictness) {
        this.currentStrictness = strictness;
    }

    private static List<Invocation> potentialArgMismatches(Invocation invocation, Collection<Stubbing> collection) {
        LinkedList linkedList = new LinkedList();
        for (Stubbing stubbing : collection) {
            if (UnusedStubbingReporting.shouldBeReported(stubbing) && stubbing.getInvocation().getMethod().getName().equals(invocation.getMethod().getName()) && !stubbing.getInvocation().getLocation().getSourceFile().equals(invocation.getLocation().getSourceFile())) {
                linkedList.add(stubbing.getInvocation());
            }
        }
        return linkedList;
    }

    public boolean isMismatchesReported() {
        return this.mismatchesReported;
    }

    @Override // org.mockito.listeners.StubbingLookupListener
    public void onStubbingLookup(StubbingLookupEvent stubbingLookupEvent) {
        if (StrictnessSelector.determineStrictness(stubbingLookupEvent.getStubbingFound(), stubbingLookupEvent.getMockSettings(), this.currentStrictness) != Strictness.STRICT_STUBS) {
            return;
        }
        if (stubbingLookupEvent.getStubbingFound() != null) {
            stubbingLookupEvent.getInvocation().markVerified();
            return;
        }
        List<Invocation> listPotentialArgMismatches = potentialArgMismatches(stubbingLookupEvent.getInvocation(), stubbingLookupEvent.getAllStubbings());
        if (listPotentialArgMismatches.isEmpty()) {
            return;
        }
        this.mismatchesReported = true;
        Reporter.potentialStubbingProblem(stubbingLookupEvent.getInvocation(), listPotentialArgMismatches);
    }

    public void setCurrentStrictness(Strictness strictness) {
        this.currentStrictness = strictness;
    }
}
