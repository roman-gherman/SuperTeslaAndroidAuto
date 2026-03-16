package U1;

import N1.m;
import com.android.multidex.ClassPathElement;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.h;
import kotlin.reflect.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements Continuation, CoroutineStackFrame, Serializable {

    @Nullable
    private final Continuation<Object> completion;

    public a(Continuation continuation) {
        this.completion = continuation;
    }

    @NotNull
    public Continuation<m> create(@NotNull Continuation<?> completion) {
        h.f(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<Object> continuation = this.completion;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Nullable
    public final Continuation<Object> getCompletion() {
        return this.completion;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public StackTraceElement getStackTraceElement() {
        int iIntValue;
        String strC;
        DebugMetadata debugMetadata = (DebugMetadata) getClass().getAnnotation(DebugMetadata.class);
        String str = null;
        if (debugMetadata == null) {
            return null;
        }
        int iV = debugMetadata.v();
        if (iV > 1) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + iV + ". Please update the Kotlin standard library.").toString());
        }
        try {
            Field declaredField = getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            iIntValue = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            iIntValue = -1;
        }
        int i = iIntValue >= 0 ? debugMetadata.l()[iIntValue] : -1;
        B2.d dVar = d.b;
        B2.d dVar2 = d.f1315a;
        if (dVar == null) {
            try {
                B2.d dVar3 = new B2.d(Class.class.getDeclaredMethod("getModule", new Class[0]), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]), 5);
                d.b = dVar3;
                dVar = dVar3;
            } catch (Exception unused2) {
                d.b = dVar2;
                dVar = dVar2;
            }
        }
        if (dVar != dVar2) {
            Method method = (Method) dVar.b;
            Object objInvoke = method != null ? method.invoke(getClass(), new Object[0]) : null;
            if (objInvoke != null) {
                Method method2 = (Method) dVar.c;
                Object objInvoke2 = method2 != null ? method2.invoke(objInvoke, new Object[0]) : null;
                if (objInvoke2 != null) {
                    Method method3 = (Method) dVar.d;
                    Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, new Object[0]) : null;
                    if (objInvoke3 instanceof String) {
                        str = (String) objInvoke3;
                    }
                }
            }
        }
        if (str == null) {
            strC = debugMetadata.c();
        } else {
            strC = str + ClassPathElement.SEPARATOR_CHAR + debugMetadata.c();
        }
        return new StackTraceElement(strC, debugMetadata.m(), debugMetadata.f(), i);
    }

    public abstract Object invokeSuspend(Object obj);

    public void releaseIntercepted() {
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(@NotNull Object obj) {
        Continuation<Object> continuation = this;
        while (true) {
            a aVar = (a) continuation;
            Continuation<Object> continuation2 = aVar.completion;
            h.c(continuation2);
            try {
                obj = aVar.invokeSuspend(obj);
                if (obj == T1.a.f1304a) {
                    return;
                }
            } catch (Throwable th) {
                obj = l.n(th);
            }
            aVar.releaseIntercepted();
            if (!(continuation2 instanceof a)) {
                continuation2.resumeWith(obj);
                return;
            }
            continuation = continuation2;
        }
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    @NotNull
    public Continuation<m> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        h.f(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
