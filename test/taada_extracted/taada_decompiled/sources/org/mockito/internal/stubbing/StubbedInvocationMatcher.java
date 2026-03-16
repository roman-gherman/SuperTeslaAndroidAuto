package org.mockito.internal.stubbing;

import java.io.Serializable;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.mockito.internal.invocation.InvocationMatcher;
import org.mockito.invocation.DescribedInvocation;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.invocation.MatchableInvocation;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.Stubbing;

/* JADX INFO: loaded from: classes.dex */
public class StubbedInvocationMatcher extends InvocationMatcher implements Serializable, Stubbing {
    private static final long serialVersionUID = 4919105134123672727L;
    private final Queue<Answer> answers;
    private final Strictness strictness;
    private DescribedInvocation usedAt;
    private final Object usedAtLock;

    public StubbedInvocationMatcher(Answer answer, MatchableInvocation matchableInvocation, Strictness strictness) {
        super(matchableInvocation.getInvocation(), matchableInvocation.getMatchers());
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.answers = concurrentLinkedQueue;
        this.usedAtLock = new Object[0];
        this.strictness = strictness;
        concurrentLinkedQueue.add(answer);
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }

    @Override // org.mockito.stubbing.Answer
    public Object answer(InvocationOnMock invocationOnMock) {
        Answer answerPeek;
        synchronized (this.answers) {
            try {
                answerPeek = this.answers.size() == 1 ? this.answers.peek() : this.answers.poll();
            } catch (Throwable th) {
                throw th;
            }
        }
        return answerPeek.answer(invocationOnMock);
    }

    @Override // org.mockito.stubbing.Stubbing
    public Strictness getStrictness() {
        return this.strictness;
    }

    public void markStubUsed(DescribedInvocation describedInvocation) {
        synchronized (this.usedAtLock) {
            this.usedAt = describedInvocation;
        }
    }

    @Override // org.mockito.internal.invocation.InvocationMatcher, org.mockito.invocation.DescribedInvocation
    public String toString() {
        return super.toString() + " stubbed with: " + this.answers;
    }

    @Override // org.mockito.stubbing.Stubbing
    public boolean wasUsed() {
        boolean z6;
        synchronized (this.usedAtLock) {
            z6 = this.usedAt != null;
        }
        return z6;
    }
}
