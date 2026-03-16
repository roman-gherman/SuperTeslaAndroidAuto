package org.mockito.internal.verification;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import n5.a;
import org.mockito.internal.util.ObjectMethodsGuru;
import org.mockito.invocation.Invocation;

/* JADX INFO: loaded from: classes.dex */
public class DefaultRegisteredInvocations implements RegisteredInvocations, Serializable {
    private static final long serialVersionUID = -2674402327380736290L;
    private final LinkedList<Invocation> invocations = new LinkedList<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getAll$0(Invocation invocation) {
        return !ObjectMethodsGuru.isToStringMethod(invocation.getMethod());
    }

    @Override // org.mockito.internal.verification.RegisteredInvocations
    public void add(Invocation invocation) {
        synchronized (this.invocations) {
            this.invocations.add(invocation);
        }
    }

    @Override // org.mockito.internal.verification.RegisteredInvocations
    public void clear() {
        synchronized (this.invocations) {
            this.invocations.clear();
        }
    }

    @Override // org.mockito.internal.verification.RegisteredInvocations
    public List<Invocation> getAll() {
        LinkedList linkedList;
        synchronized (this.invocations) {
            linkedList = new LinkedList(this.invocations);
        }
        return (List) linkedList.stream().filter(new a(3)).collect(Collectors.toList());
    }

    @Override // org.mockito.internal.verification.RegisteredInvocations
    public boolean isEmpty() {
        boolean zIsEmpty;
        synchronized (this.invocations) {
            zIsEmpty = this.invocations.isEmpty();
        }
        return zIsEmpty;
    }

    @Override // org.mockito.internal.verification.RegisteredInvocations
    public void removeLast() {
        synchronized (this.invocations) {
            try {
                if (!this.invocations.isEmpty()) {
                    this.invocations.removeLast();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
