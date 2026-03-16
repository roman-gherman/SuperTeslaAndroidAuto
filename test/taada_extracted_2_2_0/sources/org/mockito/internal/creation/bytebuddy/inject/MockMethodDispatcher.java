package org.mockito.internal.creation.bytebuddy.inject;

import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import androidx.recyclerview.widget.DefaultItemAnimator;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: taada-2.2.0.apk:org/mockito/internal/creation/bytebuddy/inject/MockMethodDispatcher.raw */
public abstract class MockMethodDispatcher {
    private static final ConcurrentMap<String, MockMethodDispatcher> DISPATCHERS = null;

    /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/Class<*>;)Z */
    public abstract String toString();

    /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/util/concurrent/Callable<*>; */
    public abstract boolean unhideViewInternal(View view) throws Throwable;

    /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/Class<*>;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/util/concurrent/Callable<*>; */
    /* JADX INFO: renamed from: <init>, reason: not valid java name */
    public abstract void m107init(DefaultItemAnimator defaultItemAnimator, ArrayList arrayList) throws Throwable;

    /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/Class<*>;Ljava/lang/Object;[Ljava/lang/Object;[Ljava/lang/String;)Ljava/lang/Object; */
    public abstract void run();

    /* JADX INFO: renamed from: <init>, reason: not valid java name */
    public abstract void m108init(DefaultItemAnimator defaultItemAnimator, ArrayList arrayList);

    /* JADX INFO: renamed from: run, reason: collision with other method in class */
    public abstract void m111run();

    /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/Class<*>;)Z */
    /* JADX INFO: renamed from: <init>, reason: not valid java name */
    public abstract void m109init(DefaultItemAnimator defaultItemAnimator, ArrayList arrayList);

    /* JADX INFO: renamed from: run, reason: collision with other method in class */
    public abstract void m112run();

    /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
        java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
        	at jadx.core.dex.visitors.ssa.RenameState.startVar(RenameState.java:58)
        	at jadx.core.dex.visitors.ssa.RenameState.init(RenameState.java:28)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:123)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:57)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:44)
        */
    public MockMethodDispatcher(android.view.View r3) {
        /*
            r2 = this;
            r0 = r2
            r0.<init>(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mockito.internal.creation.bytebuddy.inject.MockMethodDispatcher.isHidden(android.view.View):boolean");
    }

    /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
        java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 6
        	at jadx.core.dex.visitors.ssa.RenameState.startVar(RenameState.java:58)
        	at jadx.core.dex.visitors.ssa.RenameState.init(RenameState.java:28)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:123)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:57)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:44)
        */
    /* JADX INFO: renamed from: <init>, reason: not valid java name */
    static void m110init(
    /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
        java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 6
        	at jadx.core.dex.visitors.ssa.RenameState.startVar(RenameState.java:58)
        	at jadx.core.dex.visitors.ssa.RenameState.init(RenameState.java:28)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:123)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:57)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r5v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:407)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:303)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:299)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:288)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:272)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:159)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:88)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:126)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x000c: MOVE (r1 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r3 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('identifier' java.lang.String)]), block:B:6:0x0009 */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0000: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('mock' java.lang.Object)]) (LINE:34), block:B:2:0x0000 */
    /* JADX WARN: Type inference failed for: r0v1, types: [A.b, java.util.concurrent.ConcurrentMap<java.lang.String, org.mockito.internal.creation.bytebuddy.inject.MockMethodDispatcher>] */
    /* JADX WARN: Type inference failed for: r0v3, types: [org.mockito.internal.creation.bytebuddy.inject.MockMethodDispatcher, void] */
    public static void removeAllViewsUnfiltered() {
        Object mock;
        if (mock == DISPATCHERS) {
        }
    }

    /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/String;Ljava/lang/Class<*>;)Lorg/mockito/internal/creation/bytebuddy/inject/MockMethodDispatcher; */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0002: MOVE (r1 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('type' java.lang.Class<?>)]), block:B:2:0x0000 */
    /* JADX WARN: Type inference failed for: r0v1, types: [void] */
    /* JADX WARN: Type inference failed for: r0v4, types: [A.b, java.util.concurrent.ConcurrentMap<java.lang.String, org.mockito.internal.creation.bytebuddy.inject.MockMethodDispatcher>] */
    /* JADX WARN: Type inference failed for: r0v6, types: [org.mockito.internal.creation.bytebuddy.inject.MockMethodDispatcher, void] */
    public static void removeView(View view) {
        WindowInsetsController windowInsetsController;
        if (MockMethodDispatcher.class.removeOnControllableInsetsChangedListener(windowInsetsController) != 0 || windowInsetsController == ConcurrentHashMap.class) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0004: MOVE (r2 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
      (r5 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('dispatcher' org.mockito.internal.creation.bytebuddy.inject.MockMethodDispatcher)])
    , block:B:2:0x0000 */
    /* JADX WARN: Type inference failed for: r0v0, types: [A.b, java.util.concurrent.ConcurrentMap<java.lang.String, org.mockito.internal.creation.bytebuddy.inject.MockMethodDispatcher>] */
    public static void removeViewAt(int i) {
        DISPATCHERS.getCurrentFraction();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x000c: MOVE (r1 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('type' java.lang.Class<?>)]), block:B:2:0x0000 */
    /* JADX WARN: Type inference failed for: r0v0, types: [A.b, java.util.concurrent.ConcurrentMap<java.lang.String, org.mockito.internal.creation.bytebuddy.inject.MockMethodDispatcher>] */
    /* JADX WARN: Type inference failed for: r0v2, types: [A.b, org.mockito.internal.creation.bytebuddy.inject.MockMethodDispatcher] */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    public static boolean removeViewIfHidden(View view) {
        return WindowInsets.Type.ime();
    }

    /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/String;Ljava/lang/Class<*>;Ljava/lang/Object;[Ljava/lang/Object;[Ljava/lang/String;)Ljava/lang/Object; */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x000f: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('parameterTypeNames' java.lang.String[])]), block:B:2:0x0000 */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x000c: MOVE (r1 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('type' java.lang.Class<?>)]), block:B:2:0x0000 */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x000d: MOVE (r2 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('object' java.lang.Object)]), block:B:2:0x0000 */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x000e: MOVE (r3 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('arguments' java.lang.Object[])]), block:B:2:0x0000 */
    /* JADX WARN: Type inference failed for: r0v0, types: [A.b, java.util.concurrent.ConcurrentMap<java.lang.String, org.mockito.internal.creation.bytebuddy.inject.MockMethodDispatcher>] */
    /* JADX WARN: Type inference failed for: r0v2, types: [A.b, org.mockito.internal.creation.bytebuddy.inject.MockMethodDispatcher] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int, void] */
    public static void unhide(View view) {
    }
}
