package org.mockito.internal.debugging;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.exceptions.stacktrace.StackTraceCleaner;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.exceptions.stacktrace.DefaultStackTraceCleaner;
import org.mockito.invocation.Location;

/* JADX INFO: loaded from: classes.dex */
class Java9PlusLocationImpl implements Location, Serializable {
    private static final int BUFFER_SIZE = 16;
    private static final StackTraceCleaner CLEANER;
    private static final int FRAMES_TO_SKIP;
    private static final String PREFIX = "-> at ";
    private static final String SHOW_REFLECT_FRAMES = "SHOW_REFLECT_FRAMES";
    private static final String UNEXPECTED_ERROR_SUFFIX = "\nThis is unexpected and is likely due to a change in either Java's StackWalker or Reflection APIs.\nIt's worth trying to upgrade to a newer version of Mockito, or otherwise to file a bug report.";
    private static final Predicate<StackTraceCleaner.StackFrameMetadata> cleanerIsIn;
    private static final long serialVersionUID = 2954388321980069195L;
    private static final Function<Object, StackTraceCleaner.StackFrameMetadata> toStackFrameMetadata;
    private final StackTraceCleaner.StackFrameMetadata sfm;
    private volatile String stackTraceLine;
    private static final String STACK_WALKER = "java.lang.StackWalker";
    private static final Class<?> stackWalkerClazz = clazz(STACK_WALKER);
    private static final String STACK_FRAME = "java.lang.StackWalker$StackFrame";
    private static final Class<?> stackFrameClazz = clazz(STACK_FRAME);
    private static final String OPTION = "java.lang.StackWalker$Option";
    private static final Class<?> optionClazz = clazz(OPTION);
    private static final Object stackWalker = stackWalker();
    private static final Method walk = walk();

    public static final class MetadataShim implements StackTraceCleaner.StackFrameMetadata, Serializable {
        private static final long serialVersionUID = 8491903719411428648L;
        private final Object stackFrame;
        private static final Method getClassName = getter("getClassName");
        private static final Method getMethodName = getter("getMethodName");
        private static final Method getFileName = getter("getFileName");
        private static final Method getLineNumber = getter("getLineNumber");
        private static final Method toString = getter(Object.class, "toString");

        private Object get(Method method) {
            try {
                return method.invoke(this.stackFrame, new Object[0]);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }

        private static Method getter(String str) {
            return getter(Java9PlusLocationImpl.stackFrameClazz, str);
        }

        private StackTraceElement toStackTraceElement() {
            try {
                return (StackTraceElement) Java9PlusLocationImpl.stackFrameClazz.getMethod("toStackTraceElement", new Class[0]).invoke(this.stackFrame, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }

        private Object writeReplace() {
            return new SerializableShim(toStackTraceElement());
        }

        @Override // org.mockito.exceptions.stacktrace.StackTraceCleaner.StackFrameMetadata
        public String getClassName() {
            return (String) get(getClassName);
        }

        @Override // org.mockito.exceptions.stacktrace.StackTraceCleaner.StackFrameMetadata
        public String getFileName() {
            return (String) get(getFileName);
        }

        @Override // org.mockito.exceptions.stacktrace.StackTraceCleaner.StackFrameMetadata
        public int getLineNumber() {
            return ((Integer) get(getLineNumber)).intValue();
        }

        @Override // org.mockito.exceptions.stacktrace.StackTraceCleaner.StackFrameMetadata
        public String getMethodName() {
            return (String) get(getMethodName);
        }

        public String toString() {
            return (String) get(toString);
        }

        private MetadataShim(Object obj) {
            this.stackFrame = obj;
        }

        private static Method getter(Class<?> cls, String str) {
            try {
                return cls.getDeclaredMethod(str, new Class[0]);
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }
    }

    public static final class SerializableShim implements StackTraceCleaner.StackFrameMetadata, Serializable {
        private static final long serialVersionUID = 7908320459080898690L;
        private final StackTraceElement ste;

        @Override // org.mockito.exceptions.stacktrace.StackTraceCleaner.StackFrameMetadata
        public String getClassName() {
            return this.ste.getClassName();
        }

        @Override // org.mockito.exceptions.stacktrace.StackTraceCleaner.StackFrameMetadata
        public String getFileName() {
            return this.ste.getFileName();
        }

        @Override // org.mockito.exceptions.stacktrace.StackTraceCleaner.StackFrameMetadata
        public int getLineNumber() {
            return this.ste.getLineNumber();
        }

        @Override // org.mockito.exceptions.stacktrace.StackTraceCleaner.StackFrameMetadata
        public String getMethodName() {
            return this.ste.getMethodName();
        }

        private SerializableShim(StackTraceElement stackTraceElement) {
            this.ste = stackTraceElement;
        }
    }

    static {
        StackTraceCleaner stackTraceCleaner = Plugins.getStackTraceCleanerProvider().getStackTraceCleaner(new DefaultStackTraceCleaner());
        CLEANER = stackTraceCleaner;
        toStackFrameMetadata = new c(0);
        Objects.requireNonNull(stackTraceCleaner);
        cleanerIsIn = new d(stackTraceCleaner, 0);
        FRAMES_TO_SKIP = framesToSkip();
    }

    public Java9PlusLocationImpl(boolean z6) {
        this.sfm = getStackFrame(z6);
    }

    private static Class<?> clazz(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static int framesToSkip() {
        return ((Integer) stackWalk(new c(1))).intValue();
    }

    private static StackTraceCleaner.StackFrameMetadata getStackFrame(final boolean z6) {
        return (StackTraceCleaner.StackFrameMetadata) stackWalk(new Function() { // from class: org.mockito.internal.debugging.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Java9PlusLocationImpl.lambda$getStackFrame$2(z6, (Stream) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$framesToSkip$3(Stream stream) {
        return Integer.valueOf(((List) stream.map(toStackFrameMetadata).map(new c(2)).collect(Collectors.toList())).indexOf(Java9PlusLocationImpl.class.getName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ MockitoException lambda$getStackFrame$1() {
        return new MockitoException(noStackTraceFailureMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ StackTraceCleaner.StackFrameMetadata lambda$getStackFrame$2(boolean z6, Stream stream) {
        return (StackTraceCleaner.StackFrameMetadata) stream.map(toStackFrameMetadata).skip(FRAMES_TO_SKIP).filter(cleanerIsIn).skip(z6 ? 1L : 0L).findFirst().orElseThrow(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ StackTraceCleaner.StackFrameMetadata lambda$static$0(Object obj) {
        return new MetadataShim(obj);
    }

    private static String noStackTraceFailureMessage() {
        return usingDefaultStackTraceCleaner() ? "Mockito could not find the first non-Mockito stack frame.\nThis is unexpected and is likely due to a change in either Java's StackWalker or Reflection APIs.\nIt's worth trying to upgrade to a newer version of Mockito, or otherwise to file a bug report." : androidx.constraintlayout.core.motion.a.q("Mockito could not find the first non-Mockito stack frame. A custom stack frame cleaner \n(type ", CLEANER.getClass().getName(), ") is in use and this has mostly likely filtered out all the relevant stack frames.");
    }

    private String stackTraceLine() {
        if (this.stackTraceLine == null) {
            synchronized (this) {
                try {
                    if (this.stackTraceLine == null) {
                        this.stackTraceLine = PREFIX + this.sfm.toString();
                    }
                } finally {
                }
            }
        }
        return this.stackTraceLine;
    }

    private static <T> T stackWalk(Function<Stream<Object>, T> function) {
        try {
            return (T) walk.invoke(stackWalker, function);
        } catch (IllegalAccessException e) {
            throw new MockitoException("Unexpected access exception while stack walking.\nThis is unexpected and is likely due to a change in either Java's StackWalker or Reflection APIs.\nIt's worth trying to upgrade to a newer version of Mockito, or otherwise to file a bug report.", e);
        } catch (InvocationTargetException unused) {
            throw new MockitoException(stackWalkFailureMessage());
        }
    }

    private static String stackWalkFailureMessage() {
        return usingDefaultStackTraceCleaner() ? "Caught an unexpected exception while stack walking.\nThis is unexpected and is likely due to a change in either Java's StackWalker or Reflection APIs.\nIt's worth trying to upgrade to a newer version of Mockito, or otherwise to file a bug report." : androidx.constraintlayout.core.motion.a.q("Caught an unexpected exception while stack walking.\nThis is likely caused by the custom stack trace cleaner in use (class ", CLEANER.getClass().getName(), ").");
    }

    private static Object stackWalker() {
        try {
            return stackWalkerClazz.getDeclaredMethod("getInstance", Set.class, Integer.TYPE).invoke(null, Collections.singleton(Enum.valueOf(optionClazz, SHOW_REFLECT_FRAMES)), 16);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            throw new MockitoException("Mockito received an exception while trying to acquire a StackWalker.\nThis is unexpected and is likely due to a change in either Java's StackWalker or Reflection APIs.\nIt's worth trying to upgrade to a newer version of Mockito, or otherwise to file a bug report.");
        }
    }

    private static boolean usingDefaultStackTraceCleaner() {
        return CLEANER instanceof DefaultStackTraceCleaner;
    }

    private static Method walk() {
        try {
            return stackWalkerClazz.getMethod("walk", Function.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.mockito.invocation.Location
    public String getSourceFile() {
        return this.sfm.getFileName();
    }

    @Override // org.mockito.invocation.Location
    public String toString() {
        return stackTraceLine();
    }
}
