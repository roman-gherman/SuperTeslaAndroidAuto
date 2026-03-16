package org.mockito.internal.debugging;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.mockito.Mockito;
import org.mockito.invocation.Invocation;
import org.mockito.stubbing.Stubbing;

/* JADX INFO: loaded from: classes.dex */
public class InvocationsPrinter {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$printInvocations$0(Stubbing stubbing) {
        return !stubbing.wasUsed();
    }

    public String printInvocations(Object obj) {
        Collection<Invocation> invocations = Mockito.mockingDetails(obj).getInvocations();
        Collection<Stubbing> stubbings = Mockito.mockingDetails(obj).getStubbings();
        if (invocations.isEmpty() && stubbings.isEmpty()) {
            return androidx.constraintlayout.core.motion.a.m(obj, "No interactions and stubbings found for mock: ");
        }
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int i3 = 1;
        for (Invocation invocation : invocations) {
            if (i3 == 1) {
                sb.append("[Mockito] Interactions of: ");
                sb.append(obj);
                sb.append("\n");
            }
            sb.append(" ");
            int i4 = i3 + 1;
            sb.append(i3);
            sb.append(". ");
            sb.append(invocation);
            sb.append("\n  ");
            sb.append(invocation.getLocation());
            sb.append("\n");
            if (invocation.stubInfo() != null) {
                sb.append("   - stubbed ");
                sb.append(invocation.stubInfo().stubbedAt());
                sb.append("\n");
            }
            i3 = i4;
        }
        if (((List) stubbings.stream().filter(new a()).collect(Collectors.toList())).isEmpty()) {
            return sb.toString();
        }
        sb.append("[Mockito] Unused stubbings of: ");
        sb.append(obj);
        sb.append("\n");
        for (Stubbing stubbing : stubbings) {
            sb.append(" ");
            sb.append(i);
            sb.append(". ");
            sb.append(stubbing.getInvocation());
            sb.append("\n  - stubbed ");
            sb.append(stubbing.getInvocation().getLocation());
            sb.append("\n");
            i++;
        }
        return sb.toString();
    }
}
