package org.mockito.internal.debugging;

import java.io.PrintStream;
import org.mockito.invocation.DescribedInvocation;
import org.mockito.listeners.InvocationListener;
import org.mockito.listeners.MethodInvocationReport;

/* JADX INFO: loaded from: classes.dex */
public class VerboseMockInvocationLogger implements InvocationListener {
    private int mockInvocationsCounter;
    final PrintStream printStream;

    public VerboseMockInvocationLogger() {
        this(System.out);
    }

    private void printFooter() {
        this.printStream.println();
    }

    private void printHeader() {
        this.mockInvocationsCounter++;
        this.printStream.println("############ Logging method invocation #" + this.mockInvocationsCounter + " on mock/spy ########");
    }

    private void printInvocation(DescribedInvocation describedInvocation) {
        this.printStream.println(describedInvocation);
        printlnIndented("invoked: " + describedInvocation.getLocation());
    }

    private void printReturnedValueOrThrowable(MethodInvocationReport methodInvocationReport) {
        String str = "";
        if (methodInvocationReport.threwException()) {
            if (methodInvocationReport.getThrowable().getMessage() != null) {
                str = " with message " + methodInvocationReport.getThrowable().getMessage();
            }
            printlnIndented("has thrown: " + methodInvocationReport.getThrowable().getClass() + str);
            return;
        }
        if (methodInvocationReport.getReturnedValue() != null) {
            str = " (" + methodInvocationReport.getReturnedValue().getClass().getName() + ")";
        }
        printlnIndented("has returned: \"" + methodInvocationReport.getReturnedValue() + "\"" + str);
    }

    private void printStubInfo(MethodInvocationReport methodInvocationReport) {
        if (methodInvocationReport.getLocationOfStubbing() != null) {
            printlnIndented("stubbed: " + methodInvocationReport.getLocationOfStubbing());
        }
    }

    private void printlnIndented(String str) {
        this.printStream.println("   " + str);
    }

    @Override // org.mockito.listeners.InvocationListener
    public void reportInvocation(MethodInvocationReport methodInvocationReport) {
        printHeader();
        printStubInfo(methodInvocationReport);
        printInvocation(methodInvocationReport.getInvocation());
        printReturnedValueOrThrowable(methodInvocationReport);
        printFooter();
    }

    public VerboseMockInvocationLogger(PrintStream printStream) {
        this.mockInvocationsCounter = 0;
        this.printStream = printStream;
    }
}
