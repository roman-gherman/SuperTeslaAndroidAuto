package org.mockito.internal.creation.bytebuddy;

import java.lang.reflect.Method;
import java.util.function.Function;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
class StackWalkerChecker implements Predicate<Class<?>> {
    private final Method stackWalkerGetInstance;
    private final Enum<?> stackWalkerOptionRetainClassReference;
    private final Method stackWalkerStackFrameGetDeclaringClass;
    private final Method stackWalkerWalk;

    public StackWalkerChecker() throws ClassNotFoundException {
        Class<?> cls = Class.forName("java.lang.StackWalker");
        Class<?> cls2 = Class.forName("java.lang.StackWalker$Option");
        this.stackWalkerGetInstance = cls.getMethod("getInstance", cls2);
        this.stackWalkerWalk = cls.getMethod("walk", Function.class);
        this.stackWalkerStackFrameGetDeclaringClass = Class.forName("java.lang.StackWalker$StackFrame").getMethod("getDeclaringClass", new Class[0]);
        this.stackWalkerOptionRetainClassReference = Enum.valueOf(cls2, "RETAIN_CLASS_REFERENCE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x002e, code lost:
    
        r6 = (java.lang.Class) r4.stackWalkerStackFrameGetDeclaringClass.invoke(r6.next(), new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003c, code lost:
    
        if (r5 == r6) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
    
        if (r5.isAssignableFrom(r6) == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0046, code lost:
    
        return java.lang.Boolean.TRUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002c, code lost:
    
        if (r6.hasNext() == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ java.lang.Object lambda$test$0(java.lang.Class r5, java.lang.Object r6) {
        /*
            r4 = this;
            java.util.stream.Stream r6 = (java.util.stream.Stream) r6
            java.util.Iterator r6 = r6.iterator()
        L6:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L4a
            java.lang.Object r0 = r6.next()     // Catch: java.lang.Exception -> L47
            java.lang.reflect.Method r1 = r4.stackWalkerStackFrameGetDeclaringClass     // Catch: java.lang.Exception -> L47
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L47
            java.lang.Object r0 = r1.invoke(r0, r3)     // Catch: java.lang.Exception -> L47
            java.lang.Class r0 = (java.lang.Class) r0     // Catch: java.lang.Exception -> L47
            java.lang.String r0 = r0.getName()     // Catch: java.lang.Exception -> L47
            java.lang.String r1 = "org.mockito.internal."
            boolean r0 = r0.startsWith(r1)     // Catch: java.lang.Exception -> L47
            if (r0 == 0) goto L28
            goto L6
        L28:
            boolean r0 = r6.hasNext()     // Catch: java.lang.Exception -> L47
            if (r0 == 0) goto L4a
            java.lang.Object r6 = r6.next()     // Catch: java.lang.Exception -> L47
            java.lang.reflect.Method r0 = r4.stackWalkerStackFrameGetDeclaringClass     // Catch: java.lang.Exception -> L47
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L47
            java.lang.Object r6 = r0.invoke(r6, r1)     // Catch: java.lang.Exception -> L47
            java.lang.Class r6 = (java.lang.Class) r6     // Catch: java.lang.Exception -> L47
            if (r5 == r6) goto L4a
            boolean r5 = r5.isAssignableFrom(r6)     // Catch: java.lang.Exception -> L47
            if (r5 == 0) goto L4a
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch: java.lang.Exception -> L47
            return r5
        L47:
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            return r5
        L4a:
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mockito.internal.creation.bytebuddy.StackWalkerChecker.lambda$test$0(java.lang.Class, java.lang.Object):java.lang.Object");
    }

    public static Predicate<Class<?>> orFallback() {
        try {
            return new StackWalkerChecker();
        } catch (Exception unused) {
            return new StackTraceChecker();
        }
    }

    @Override // java.util.function.Predicate
    public boolean test(final Class<?> cls) {
        try {
            return ((Boolean) this.stackWalkerWalk.invoke(this.stackWalkerGetInstance.invoke(null, this.stackWalkerOptionRetainClassReference), new Function() { // from class: org.mockito.internal.creation.bytebuddy.j
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f4447a.lambda$test$0(cls, obj);
                }
            })).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }
}
