package net.bytebuddy.asm;

import B2.b;
import com.google.protobuf.a;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.IOException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.build.RepeatedAnnotationPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.TargetType;
import net.bytebuddy.dynamic.scaffold.FieldLocator;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.implementation.FieldAccessor;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.SuperMethodCall;
import net.bytebuddy.implementation.bytecode.Addition;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.Removal;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.implementation.bytecode.Throw;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.collection.ArrayAccess;
import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
import net.bytebuddy.implementation.bytecode.constant.DoubleConstant;
import net.bytebuddy.implementation.bytecode.constant.FloatConstant;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.constant.JavaConstantValue;
import net.bytebuddy.implementation.bytecode.constant.LongConstant;
import net.bytebuddy.implementation.bytecode.constant.MethodConstant;
import net.bytebuddy.implementation.bytecode.constant.NullConstant;
import net.bytebuddy.implementation.bytecode.constant.SerializedConstant;
import net.bytebuddy.implementation.bytecode.constant.TextConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.Attribute;
import net.bytebuddy.jar.asm.ClassReader;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.jar.asm.TypePath;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.visitor.ExceptionTableSensitiveMethodVisitor;
import net.bytebuddy.utility.visitor.LineNumberPrependingMethodVisitor;
import net.bytebuddy.utility.visitor.StackAwareMethodVisitor;

/* JADX INFO: loaded from: classes2.dex */
@HashCodeAndEqualsPlugin.Enhance
public class Advice implements AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper, Implementation {
    private static final MethodDescription.InDefinedShape BACKUP_ARGUMENTS;
    private static final MethodDescription.InDefinedShape INLINE_ENTER;
    private static final MethodDescription.InDefinedShape INLINE_EXIT;
    private static final MethodDescription.InDefinedShape ON_THROWABLE;
    private static final MethodDescription.InDefinedShape PREPEND_LINE_NUMBER;
    private static final MethodDescription.InDefinedShape REPEAT_ON;
    private static final MethodDescription.InDefinedShape SKIP_ON;
    private static final MethodDescription.InDefinedShape SUPPRESS_ENTER;
    private static final MethodDescription.InDefinedShape SUPPRESS_EXIT;

    @AlwaysNull
    private static final ClassReader UNDEFINED = null;
    private final Assigner assigner;
    private final Implementation delegate;
    private final ExceptionHandler exceptionHandler;
    private final Dispatcher.Resolved.ForMethodEnter methodEnter;
    private final Dispatcher.Resolved.ForMethodExit methodExit;

    public static abstract class AdviceVisitor extends ExceptionTableSensitiveMethodVisitor implements Dispatcher.RelocationHandler.Relocation {
        private static final int THIS_VARIABLE_INDEX = 0;
        private static final String THIS_VARIABLE_NAME = "this";
        protected final ArgumentHandler.ForInstrumentedMethod argumentHandler;
        protected final MethodDescription instrumentedMethod;
        private final Dispatcher.Bound methodEnter;
        protected final Dispatcher.Bound methodExit;
        protected final MethodSizeHandler.ForInstrumentedMethod methodSizeHandler;
        private final Label preparationStart;
        protected final StackMapFrameHandler.ForInstrumentedMethod stackMapFrameHandler;

        public static abstract class WithExitAdvice extends AdviceVisitor {
            protected final Label returnHandler;

            public static class WithExceptionHandling extends WithExitAdvice {
                private final Label exceptionHandler;
                private final TypeDescription throwable;
                protected final Label userStart;

                public WithExceptionHandling(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, StackManipulation stackManipulation, TypeDescription typeDescription, MethodDescription methodDescription, Dispatcher.Resolved.ForMethodEnter forMethodEnter, Dispatcher.Resolved.ForMethodExit forMethodExit, int i, int i3, TypeDescription typeDescription2) {
                    super(methodVisitor, context, assigner, stackManipulation, typeDescription, methodDescription, forMethodEnter, forMethodExit, methodDescription.getReturnType().represents(Void.TYPE) ? Collections.singletonList(TypeDescription.ForLoadedType.of(Throwable.class)) : Arrays.asList(methodDescription.getReturnType().asErasure(), TypeDescription.ForLoadedType.of(Throwable.class)), i, i3);
                    this.throwable = typeDescription2;
                    this.exceptionHandler = new Label();
                    this.userStart = new Label();
                }

                @Override // net.bytebuddy.asm.Advice.AdviceVisitor.WithExitAdvice
                public void onExitAdviceReturn() {
                    this.mv.visitVarInsn(25, this.argumentHandler.thrown());
                    Label label = new Label();
                    this.mv.visitJumpInsn(198, label);
                    this.mv.visitVarInsn(25, this.argumentHandler.thrown());
                    this.mv.visitInsn(191);
                    this.mv.visitLabel(label);
                    this.stackMapFrameHandler.injectPostCompletionFrame(this.mv);
                }

                @Override // net.bytebuddy.asm.Advice.AdviceVisitor
                public void onUserPrepare() {
                    this.mv.visitTryCatchBlock(this.userStart, this.returnHandler, this.exceptionHandler, this.throwable.getInternalName());
                }

                @Override // net.bytebuddy.asm.Advice.AdviceVisitor.WithExitAdvice
                public void onUserReturn() {
                    this.stackMapFrameHandler.injectReturnFrame(this.mv);
                    TypeDescription.Generic returnType = this.instrumentedMethod.getReturnType();
                    Class cls = Boolean.TYPE;
                    boolean zRepresents = returnType.represents(cls);
                    Class cls2 = Void.TYPE;
                    Class cls3 = Double.TYPE;
                    Class cls4 = Float.TYPE;
                    Class cls5 = Long.TYPE;
                    Class cls6 = Integer.TYPE;
                    Class cls7 = Character.TYPE;
                    Class cls8 = Short.TYPE;
                    Class cls9 = Byte.TYPE;
                    if (zRepresents || this.instrumentedMethod.getReturnType().represents(cls9) || this.instrumentedMethod.getReturnType().represents(cls8) || this.instrumentedMethod.getReturnType().represents(cls7) || this.instrumentedMethod.getReturnType().represents(cls6)) {
                        this.mv.visitVarInsn(54, this.argumentHandler.returned());
                    } else if (this.instrumentedMethod.getReturnType().represents(cls5)) {
                        this.mv.visitVarInsn(55, this.argumentHandler.returned());
                    } else if (this.instrumentedMethod.getReturnType().represents(cls4)) {
                        this.mv.visitVarInsn(56, this.argumentHandler.returned());
                    } else if (this.instrumentedMethod.getReturnType().represents(cls3)) {
                        this.mv.visitVarInsn(57, this.argumentHandler.returned());
                    } else if (!this.instrumentedMethod.getReturnType().represents(cls2)) {
                        this.mv.visitVarInsn(58, this.argumentHandler.returned());
                    }
                    this.mv.visitInsn(1);
                    this.mv.visitVarInsn(58, this.argumentHandler.thrown());
                    Label label = new Label();
                    this.mv.visitJumpInsn(167, label);
                    this.mv.visitLabel(this.exceptionHandler);
                    this.stackMapFrameHandler.injectExceptionFrame(this.mv);
                    this.mv.visitVarInsn(58, this.argumentHandler.thrown());
                    if (this.instrumentedMethod.getReturnType().represents(cls) || this.instrumentedMethod.getReturnType().represents(cls9) || this.instrumentedMethod.getReturnType().represents(cls8) || this.instrumentedMethod.getReturnType().represents(cls7) || this.instrumentedMethod.getReturnType().represents(cls6)) {
                        this.mv.visitInsn(3);
                        this.mv.visitVarInsn(54, this.argumentHandler.returned());
                    } else if (this.instrumentedMethod.getReturnType().represents(cls5)) {
                        this.mv.visitInsn(9);
                        this.mv.visitVarInsn(55, this.argumentHandler.returned());
                    } else if (this.instrumentedMethod.getReturnType().represents(cls4)) {
                        this.mv.visitInsn(11);
                        this.mv.visitVarInsn(56, this.argumentHandler.returned());
                    } else if (this.instrumentedMethod.getReturnType().represents(cls3)) {
                        this.mv.visitInsn(14);
                        this.mv.visitVarInsn(57, this.argumentHandler.returned());
                    } else if (!this.instrumentedMethod.getReturnType().represents(cls2)) {
                        this.mv.visitInsn(1);
                        this.mv.visitVarInsn(58, this.argumentHandler.returned());
                    }
                    this.mv.visitLabel(label);
                    this.methodSizeHandler.requireStackSize(StackSize.SINGLE.getSize());
                }

                @Override // net.bytebuddy.asm.Advice.AdviceVisitor
                public void onUserStart() {
                    this.mv.visitLabel(this.userStart);
                }
            }

            public static class WithoutExceptionHandling extends WithExitAdvice {
                public WithoutExceptionHandling(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, StackManipulation stackManipulation, TypeDescription typeDescription, MethodDescription methodDescription, Dispatcher.Resolved.ForMethodEnter forMethodEnter, Dispatcher.Resolved.ForMethodExit forMethodExit, int i, int i3) {
                    super(methodVisitor, context, assigner, stackManipulation, typeDescription, methodDescription, forMethodEnter, forMethodExit, methodDescription.getReturnType().represents(Void.TYPE) ? Collections.EMPTY_LIST : Collections.singletonList(methodDescription.getReturnType().asErasure()), i, i3);
                }

                @Override // net.bytebuddy.asm.Advice.AdviceVisitor.WithExitAdvice
                public void onExitAdviceReturn() {
                }

                @Override // net.bytebuddy.asm.Advice.AdviceVisitor
                public void onUserPrepare() {
                }

                @Override // net.bytebuddy.asm.Advice.AdviceVisitor.WithExitAdvice
                public void onUserReturn() {
                    if (this.instrumentedMethod.getReturnType().represents(Boolean.TYPE) || this.instrumentedMethod.getReturnType().represents(Byte.TYPE) || this.instrumentedMethod.getReturnType().represents(Short.TYPE) || this.instrumentedMethod.getReturnType().represents(Character.TYPE) || this.instrumentedMethod.getReturnType().represents(Integer.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.mv);
                        this.mv.visitVarInsn(54, this.argumentHandler.returned());
                        return;
                    }
                    if (this.instrumentedMethod.getReturnType().represents(Long.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.mv);
                        this.mv.visitVarInsn(55, this.argumentHandler.returned());
                        return;
                    }
                    if (this.instrumentedMethod.getReturnType().represents(Float.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.mv);
                        this.mv.visitVarInsn(56, this.argumentHandler.returned());
                    } else if (this.instrumentedMethod.getReturnType().represents(Double.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.mv);
                        this.mv.visitVarInsn(57, this.argumentHandler.returned());
                    } else {
                        if (this.instrumentedMethod.getReturnType().represents(Void.TYPE)) {
                            return;
                        }
                        this.stackMapFrameHandler.injectReturnFrame(this.mv);
                        this.mv.visitVarInsn(58, this.argumentHandler.returned());
                    }
                }

                @Override // net.bytebuddy.asm.Advice.AdviceVisitor
                public void onUserStart() {
                }
            }

            public WithExitAdvice(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, StackManipulation stackManipulation, TypeDescription typeDescription, MethodDescription methodDescription, Dispatcher.Resolved.ForMethodEnter forMethodEnter, Dispatcher.Resolved.ForMethodExit forMethodExit, List<? extends TypeDescription> list, int i, int i3) {
                super(StackAwareMethodVisitor.of(methodVisitor, methodDescription), context, assigner, stackManipulation, typeDescription, methodDescription, forMethodEnter, forMethodExit, list, i, i3);
                this.returnHandler = new Label();
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.Relocation
            public void apply(MethodVisitor methodVisitor) {
                if (this.instrumentedMethod.getReturnType().represents(Boolean.TYPE) || this.instrumentedMethod.getReturnType().represents(Byte.TYPE) || this.instrumentedMethod.getReturnType().represents(Short.TYPE) || this.instrumentedMethod.getReturnType().represents(Character.TYPE) || this.instrumentedMethod.getReturnType().represents(Integer.TYPE)) {
                    methodVisitor.visitInsn(3);
                } else if (this.instrumentedMethod.getReturnType().represents(Long.TYPE)) {
                    methodVisitor.visitInsn(9);
                } else if (this.instrumentedMethod.getReturnType().represents(Float.TYPE)) {
                    methodVisitor.visitInsn(11);
                } else if (this.instrumentedMethod.getReturnType().represents(Double.TYPE)) {
                    methodVisitor.visitInsn(14);
                } else if (!this.instrumentedMethod.getReturnType().represents(Void.TYPE)) {
                    methodVisitor.visitInsn(1);
                }
                methodVisitor.visitJumpInsn(167, this.returnHandler);
            }

            public abstract void onExitAdviceReturn();

            @Override // net.bytebuddy.asm.Advice.AdviceVisitor
            public void onUserEnd() {
                this.mv.visitLabel(this.returnHandler);
                onUserReturn();
                this.stackMapFrameHandler.injectCompletionFrame(this.mv);
                this.methodExit.apply();
                onExitAdviceReturn();
                if (this.instrumentedMethod.getReturnType().represents(Boolean.TYPE) || this.instrumentedMethod.getReturnType().represents(Byte.TYPE) || this.instrumentedMethod.getReturnType().represents(Short.TYPE) || this.instrumentedMethod.getReturnType().represents(Character.TYPE) || this.instrumentedMethod.getReturnType().represents(Integer.TYPE)) {
                    this.mv.visitVarInsn(21, this.argumentHandler.returned());
                    this.mv.visitInsn(172);
                } else if (this.instrumentedMethod.getReturnType().represents(Long.TYPE)) {
                    this.mv.visitVarInsn(22, this.argumentHandler.returned());
                    this.mv.visitInsn(173);
                } else if (this.instrumentedMethod.getReturnType().represents(Float.TYPE)) {
                    this.mv.visitVarInsn(23, this.argumentHandler.returned());
                    this.mv.visitInsn(174);
                } else if (this.instrumentedMethod.getReturnType().represents(Double.TYPE)) {
                    this.mv.visitVarInsn(24, this.argumentHandler.returned());
                    this.mv.visitInsn(175);
                } else if (this.instrumentedMethod.getReturnType().represents(Void.TYPE)) {
                    this.mv.visitInsn(177);
                } else {
                    this.mv.visitVarInsn(25, this.argumentHandler.returned());
                    this.mv.visitInsn(176);
                }
                this.methodSizeHandler.requireStackSize(this.instrumentedMethod.getReturnType().getStackSize().getSize());
            }

            public abstract void onUserReturn();

            @Override // net.bytebuddy.utility.visitor.ExceptionTableSensitiveMethodVisitor
            public void onVisitInsn(int i) {
                switch (i) {
                    case 172:
                        this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor) this.mv).drainStack(54, 21, StackSize.SINGLE));
                        break;
                    case 173:
                        this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor) this.mv).drainStack(55, 22, StackSize.DOUBLE));
                        break;
                    case 174:
                        this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor) this.mv).drainStack(56, 23, StackSize.SINGLE));
                        break;
                    case 175:
                        this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor) this.mv).drainStack(57, 24, StackSize.DOUBLE));
                        break;
                    case 176:
                        this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor) this.mv).drainStack(58, 25, StackSize.SINGLE));
                        break;
                    case 177:
                        ((StackAwareMethodVisitor) this.mv).drainStack();
                        break;
                    default:
                        this.mv.visitInsn(i);
                        return;
                }
                this.mv.visitJumpInsn(167, this.returnHandler);
            }
        }

        public static class WithoutExitAdvice extends AdviceVisitor {
            public WithoutExitAdvice(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, StackManipulation stackManipulation, TypeDescription typeDescription, MethodDescription methodDescription, Dispatcher.Resolved.ForMethodEnter forMethodEnter, int i, int i3) {
                super(methodVisitor, context, assigner, stackManipulation, typeDescription, methodDescription, forMethodEnter, Dispatcher.Inactive.INSTANCE, Collections.EMPTY_LIST, i, i3);
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.Relocation
            public void apply(MethodVisitor methodVisitor) {
                if (this.instrumentedMethod.getReturnType().represents(Boolean.TYPE) || this.instrumentedMethod.getReturnType().represents(Byte.TYPE) || this.instrumentedMethod.getReturnType().represents(Short.TYPE) || this.instrumentedMethod.getReturnType().represents(Character.TYPE) || this.instrumentedMethod.getReturnType().represents(Integer.TYPE)) {
                    methodVisitor.visitInsn(3);
                    methodVisitor.visitInsn(172);
                    return;
                }
                if (this.instrumentedMethod.getReturnType().represents(Long.TYPE)) {
                    methodVisitor.visitInsn(9);
                    methodVisitor.visitInsn(173);
                    return;
                }
                if (this.instrumentedMethod.getReturnType().represents(Float.TYPE)) {
                    methodVisitor.visitInsn(11);
                    methodVisitor.visitInsn(174);
                } else if (this.instrumentedMethod.getReturnType().represents(Double.TYPE)) {
                    methodVisitor.visitInsn(14);
                    methodVisitor.visitInsn(175);
                } else if (this.instrumentedMethod.getReturnType().represents(Void.TYPE)) {
                    methodVisitor.visitInsn(177);
                } else {
                    methodVisitor.visitInsn(1);
                    methodVisitor.visitInsn(176);
                }
            }

            @Override // net.bytebuddy.asm.Advice.AdviceVisitor
            public void onUserEnd() {
            }

            @Override // net.bytebuddy.asm.Advice.AdviceVisitor
            public void onUserPrepare() {
            }

            @Override // net.bytebuddy.asm.Advice.AdviceVisitor
            public void onUserStart() {
            }
        }

        public AdviceVisitor(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, StackManipulation stackManipulation, TypeDescription typeDescription, MethodDescription methodDescription, Dispatcher.Resolved.ForMethodEnter forMethodEnter, Dispatcher.Resolved.ForMethodExit forMethodExit, List<? extends TypeDescription> list, int i, int i3) {
            super(OpenedClassReader.ASM_API, methodVisitor);
            this.instrumentedMethod = methodDescription;
            Label label = new Label();
            this.preparationStart = label;
            TreeMap treeMap = new TreeMap();
            treeMap.putAll(forMethodEnter.getNamedTypes());
            treeMap.putAll(forMethodExit.getNamedTypes());
            ArgumentHandler.ForInstrumentedMethod forInstrumentedMethodResolve = forMethodExit.getArgumentHandlerFactory().resolve(methodDescription, forMethodEnter.getAdviceType(), forMethodExit.getAdviceType(), treeMap);
            this.argumentHandler = forInstrumentedMethodResolve;
            TypeDefinition adviceType = forMethodExit.getAdviceType();
            Class cls = Void.TYPE;
            List listOf = CompoundList.of(adviceType.represents(cls) ? Collections.EMPTY_LIST : Collections.singletonList(forMethodExit.getAdviceType().asErasure()), (List) forInstrumentedMethodResolve.getNamedTypes());
            List listSingletonList = forMethodEnter.getActualAdviceType().represents(cls) ? Collections.EMPTY_LIST : Collections.singletonList(forMethodEnter.getActualAdviceType().asErasure());
            List listSingletonList2 = forMethodEnter.getAdviceType().represents(cls) ? Collections.EMPTY_LIST : Collections.singletonList(forMethodEnter.getAdviceType().asErasure());
            MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethodOf = MethodSizeHandler.Default.of(methodDescription, listOf, listSingletonList2, list, forInstrumentedMethodResolve.isCopyingArguments(), i);
            this.methodSizeHandler = forInstrumentedMethodOf;
            StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethodOf2 = StackMapFrameHandler.Default.of(typeDescription, methodDescription, listOf, listSingletonList, listSingletonList2, list, forMethodExit.isAlive(), forInstrumentedMethodResolve.isCopyingArguments(), context.getClassFileVersion(), i, i3);
            this.stackMapFrameHandler = forInstrumentedMethodOf2;
            this.methodEnter = forMethodEnter.bind(typeDescription, methodDescription, methodVisitor, context, assigner, forInstrumentedMethodResolve, forInstrumentedMethodOf, forInstrumentedMethodOf2, stackManipulation, this);
            this.methodExit = forMethodExit.bind(typeDescription, methodDescription, methodVisitor, context, assigner, forInstrumentedMethodResolve, forInstrumentedMethodOf, forInstrumentedMethodOf2, stackManipulation, new Dispatcher.RelocationHandler.Relocation.ForLabel(label));
        }

        @Override // net.bytebuddy.utility.visitor.ExceptionTableSensitiveMethodVisitor
        public void onAfterExceptionTable() {
            this.methodEnter.prepare();
            onUserPrepare();
            this.methodExit.prepare();
            this.methodEnter.initialize();
            this.methodExit.initialize();
            this.stackMapFrameHandler.injectInitializationFrame(this.mv);
            this.methodEnter.apply();
            this.mv.visitLabel(this.preparationStart);
            this.methodSizeHandler.requireStackSize(this.argumentHandler.prepare(this.mv));
            this.stackMapFrameHandler.injectStartFrame(this.mv);
            this.mv.visitInsn(0);
            onUserStart();
        }

        public abstract void onUserEnd();

        public abstract void onUserPrepare();

        public abstract void onUserStart();

        @Override // net.bytebuddy.utility.visitor.ExceptionTableSensitiveMethodVisitor
        public void onVisitFrame(int i, int i3, @MaybeNull Object[] objArr, int i4, @MaybeNull Object[] objArr2) {
            this.stackMapFrameHandler.translateFrame(this.mv, i, i3, objArr, i4, objArr2);
        }

        @Override // net.bytebuddy.utility.visitor.ExceptionTableSensitiveMethodVisitor
        public void onVisitIincInsn(int i, int i3) {
            this.mv.visitIincInsn(this.argumentHandler.argument(i), i3);
        }

        @Override // net.bytebuddy.utility.visitor.ExceptionTableSensitiveMethodVisitor
        public void onVisitVarInsn(int i, int i3) {
            this.mv.visitVarInsn(i, this.argumentHandler.argument(i3));
        }

        @Override // net.bytebuddy.jar.asm.MethodVisitor
        public void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i) {
            MethodVisitor methodVisitor = this.mv;
            if (i != 0 || !"this".equals(str)) {
                i = this.argumentHandler.variable(i);
            }
            methodVisitor.visitLocalVariable(str, str2, str3, label, label2, i);
        }

        @Override // net.bytebuddy.jar.asm.MethodVisitor
        public AnnotationVisitor visitLocalVariableAnnotation(int i, TypePath typePath, Label[] labelArr, Label[] labelArr2, int[] iArr, String str, boolean z6) {
            int[] iArr2 = new int[iArr.length];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr2[i3] = this.argumentHandler.variable(iArr[i3]);
            }
            return this.mv.visitLocalVariableAnnotation(i, typePath, labelArr, labelArr2, iArr2, str, z6);
        }

        @Override // net.bytebuddy.jar.asm.MethodVisitor
        public void visitMaxs(int i, int i3) {
            onUserEnd();
            this.mv.visitMaxs(this.methodSizeHandler.compoundStackSize(i), this.methodSizeHandler.compoundLocalVariableLength(i3));
        }
    }

    @Target({ElementType.PARAMETER})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AllArguments {
        boolean nullIfEmpty() default false;

        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Appender implements ByteCodeAppender {
        private final Advice advice;
        private final ByteCodeAppender delegate;
        private final Implementation.Target implementationTarget;

        public static class EmulatingMethodVisitor extends MethodVisitor {
            private final ByteCodeAppender delegate;
            private int localVariableLength;
            private int stackSize;

            public EmulatingMethodVisitor(MethodVisitor methodVisitor, ByteCodeAppender byteCodeAppender) {
                super(OpenedClassReader.ASM_API, methodVisitor);
                this.delegate = byteCodeAppender;
            }

            public ByteCodeAppender.Size resolve(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                methodVisitor.visitCode();
                ByteCodeAppender.Size sizeApply = this.delegate.apply(methodVisitor, context, methodDescription);
                methodVisitor.visitMaxs(sizeApply.getOperandStackSize(), sizeApply.getLocalVariableSize());
                methodVisitor.visitEnd();
                return new ByteCodeAppender.Size(this.stackSize, this.localVariableLength);
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            public void visitCode() {
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            public void visitEnd() {
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            public void visitMaxs(int i, int i3) {
                this.stackSize = i;
                this.localVariableLength = i3;
            }
        }

        public Appender(Advice advice, Implementation.Target target, ByteCodeAppender byteCodeAppender) {
            this.advice = advice;
            this.implementationTarget = target;
            this.delegate = byteCodeAppender;
        }

        @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            EmulatingMethodVisitor emulatingMethodVisitor = new EmulatingMethodVisitor(methodVisitor, this.delegate);
            return emulatingMethodVisitor.resolve(this.advice.doWrap(this.implementationTarget.getInstrumentedType(), methodDescription, emulatingMethodVisitor, context, 0, 0), context, methodDescription);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Appender appender = (Appender) obj;
            return this.advice.equals(appender.advice) && this.implementationTarget.equals(appender.implementationTarget) && this.delegate.equals(appender.delegate);
        }

        public int hashCode() {
            return this.delegate.hashCode() + ((this.implementationTarget.hashCode() + ((this.advice.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31);
        }
    }

    @Target({ElementType.PARAMETER})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Argument {
        boolean optional() default false;

        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;

        int value();
    }

    public interface ArgumentHandler {
        public static final int THIS_REFERENCE = 0;

        public enum Factory {
            SIMPLE { // from class: net.bytebuddy.asm.Advice.ArgumentHandler.Factory.1
                @Override // net.bytebuddy.asm.Advice.ArgumentHandler.Factory
                public ForInstrumentedMethod resolve(MethodDescription methodDescription, TypeDefinition typeDefinition, TypeDefinition typeDefinition2, SortedMap<String, TypeDefinition> sortedMap) {
                    return new ForInstrumentedMethod.Default.Simple(methodDescription, typeDefinition2, sortedMap, typeDefinition);
                }
            },
            COPYING { // from class: net.bytebuddy.asm.Advice.ArgumentHandler.Factory.2
                @Override // net.bytebuddy.asm.Advice.ArgumentHandler.Factory
                public ForInstrumentedMethod resolve(MethodDescription methodDescription, TypeDefinition typeDefinition, TypeDefinition typeDefinition2, SortedMap<String, TypeDefinition> sortedMap) {
                    return new ForInstrumentedMethod.Default.Copying(methodDescription, typeDefinition2, sortedMap, typeDefinition);
                }
            };

            public abstract ForInstrumentedMethod resolve(MethodDescription methodDescription, TypeDefinition typeDefinition, TypeDefinition typeDefinition2, SortedMap<String, TypeDefinition> sortedMap);
        }

        public interface ForAdvice extends ArgumentHandler {

            public static abstract class Default implements ForAdvice {
                protected final MethodDescription adviceMethod;
                protected final TypeDefinition exitType;
                protected final MethodDescription instrumentedMethod;
                protected final SortedMap<String, TypeDefinition> namedTypes;

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForMethodEnter extends Default {
                    public ForMethodEnter(MethodDescription methodDescription, MethodDescription methodDescription2, TypeDefinition typeDefinition, SortedMap<String, TypeDefinition> sortedMap) {
                        super(methodDescription, methodDescription2, typeDefinition, sortedMap);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass();
                    }

                    public int hashCode() {
                        return getClass().hashCode();
                    }

                    @Override // net.bytebuddy.asm.Advice.ArgumentHandler.ForAdvice
                    public int mapped(int i) {
                        return ((StackSize.of(this.namedTypes.values()) + a.g(this.exitType, this.instrumentedMethod.getStackSize())) - this.adviceMethod.getStackSize()) + i;
                    }

                    @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                    public int returned() {
                        throw new IllegalStateException("Cannot resolve the return value offset during enter advice");
                    }

                    @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                    public int thrown() {
                        throw new IllegalStateException("Cannot resolve the thrown value offset during enter advice");
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForMethodExit extends Default {
                    private final TypeDefinition enterType;
                    private final StackSize throwableSize;

                    public ForMethodExit(MethodDescription methodDescription, MethodDescription methodDescription2, TypeDefinition typeDefinition, SortedMap<String, TypeDefinition> sortedMap, TypeDefinition typeDefinition2, StackSize stackSize) {
                        super(methodDescription, methodDescription2, typeDefinition, sortedMap);
                        this.enterType = typeDefinition2;
                        this.throwableSize = stackSize;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForMethodExit forMethodExit = (ForMethodExit) obj;
                        return this.throwableSize.equals(forMethodExit.throwableSize) && this.enterType.equals(forMethodExit.enterType);
                    }

                    public int hashCode() {
                        return this.throwableSize.hashCode() + ((this.enterType.hashCode() + (getClass().hashCode() * 31)) * 31);
                    }

                    @Override // net.bytebuddy.asm.Advice.ArgumentHandler.ForAdvice
                    public int mapped(int i) {
                        return ((this.throwableSize.getSize() + (this.instrumentedMethod.getReturnType().getStackSize().getSize() + a.g(this.enterType, StackSize.of(this.namedTypes.values()) + a.g(this.exitType, this.instrumentedMethod.getStackSize())))) - this.adviceMethod.getStackSize()) + i;
                    }

                    @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                    public int returned() {
                        return a.g(this.enterType, StackSize.of(this.namedTypes.values()) + a.g(this.exitType, this.instrumentedMethod.getStackSize()));
                    }

                    @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                    public int thrown() {
                        return this.instrumentedMethod.getReturnType().getStackSize().getSize() + a.g(this.enterType, StackSize.of(this.namedTypes.values()) + a.g(this.exitType, this.instrumentedMethod.getStackSize()));
                    }
                }

                public Default(MethodDescription methodDescription, MethodDescription methodDescription2, TypeDefinition typeDefinition, SortedMap<String, TypeDefinition> sortedMap) {
                    this.instrumentedMethod = methodDescription;
                    this.adviceMethod = methodDescription2;
                    this.exitType = typeDefinition;
                    this.namedTypes = sortedMap;
                }

                @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                public int argument(int i) {
                    return i;
                }

                @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                public int enter() {
                    return StackSize.of(this.namedTypes.values()) + a.g(this.exitType, this.instrumentedMethod.getStackSize());
                }

                @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                public int exit() {
                    return this.instrumentedMethod.getStackSize();
                }

                @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                public int named(String str) {
                    return StackSize.of(this.namedTypes.headMap(str).values()) + a.g(this.exitType, this.instrumentedMethod.getStackSize());
                }
            }

            int mapped(int i);
        }

        public interface ForInstrumentedMethod extends ArgumentHandler {

            public static abstract class Default implements ForInstrumentedMethod {
                protected final TypeDefinition enterType;
                protected final TypeDefinition exitType;
                protected final MethodDescription instrumentedMethod;
                protected final SortedMap<String, TypeDefinition> namedTypes;

                @HashCodeAndEqualsPlugin.Enhance
                public static class Copying extends Default {
                    public Copying(MethodDescription methodDescription, TypeDefinition typeDefinition, SortedMap<String, TypeDefinition> sortedMap, TypeDefinition typeDefinition2) {
                        super(methodDescription, typeDefinition, sortedMap, typeDefinition2);
                    }

                    @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                    public int argument(int i) {
                        return this.enterType.getStackSize().getSize() + StackSize.of(this.namedTypes.values()) + a.g(this.exitType, this.instrumentedMethod.getStackSize()) + i;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass();
                    }

                    public int hashCode() {
                        return getClass().hashCode();
                    }

                    @Override // net.bytebuddy.asm.Advice.ArgumentHandler.ForInstrumentedMethod
                    public boolean isCopyingArguments() {
                        return true;
                    }

                    @Override // net.bytebuddy.asm.Advice.ArgumentHandler.ForInstrumentedMethod
                    public int prepare(MethodVisitor methodVisitor) {
                        StackSize stackSizeMaximum;
                        if (this.instrumentedMethod.isStatic()) {
                            stackSizeMaximum = StackSize.ZERO;
                        } else {
                            methodVisitor.visitVarInsn(25, 0);
                            methodVisitor.visitVarInsn(58, this.enterType.getStackSize().getSize() + StackSize.of(this.namedTypes.values()) + a.g(this.exitType, this.instrumentedMethod.getStackSize()));
                            stackSizeMaximum = StackSize.SINGLE;
                        }
                        Iterator<?> it = this.instrumentedMethod.getParameters().iterator();
                        while (it.hasNext()) {
                            ParameterDescription parameterDescription = (ParameterDescription) it.next();
                            Type type = Type.getType(parameterDescription.getType().asErasure().getDescriptor());
                            methodVisitor.visitVarInsn(type.getOpcode(21), parameterDescription.getOffset());
                            methodVisitor.visitVarInsn(type.getOpcode(54), parameterDescription.getOffset() + a.g(this.enterType, StackSize.of(this.namedTypes.values()) + a.g(this.exitType, this.instrumentedMethod.getStackSize())));
                            stackSizeMaximum = stackSizeMaximum.maximum(parameterDescription.getType().getStackSize());
                        }
                        return stackSizeMaximum.getSize();
                    }

                    @Override // net.bytebuddy.asm.Advice.ArgumentHandler.ForInstrumentedMethod
                    public int variable(int i) {
                        int size = this.instrumentedMethod.getParameters().size() + (!this.instrumentedMethod.isStatic() ? 1 : 0);
                        TypeDefinition typeDefinition = this.exitType;
                        Class cls = Void.TYPE;
                        return this.namedTypes.size() + size + (!typeDefinition.represents(cls) ? 1 : 0) + (!this.enterType.represents(cls) ? 1 : 0) + i;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class Simple extends Default {
                    public Simple(MethodDescription methodDescription, TypeDefinition typeDefinition, SortedMap<String, TypeDefinition> sortedMap, TypeDefinition typeDefinition2) {
                        super(methodDescription, typeDefinition, sortedMap, typeDefinition2);
                    }

                    @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                    public int argument(int i) {
                        if (i < this.instrumentedMethod.getStackSize()) {
                            return i;
                        }
                        return a.g(this.enterType, StackSize.of(this.namedTypes.values()) + a.g(this.exitType, i));
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass();
                    }

                    public int hashCode() {
                        return getClass().hashCode();
                    }

                    @Override // net.bytebuddy.asm.Advice.ArgumentHandler.ForInstrumentedMethod
                    public boolean isCopyingArguments() {
                        return false;
                    }

                    @Override // net.bytebuddy.asm.Advice.ArgumentHandler.ForInstrumentedMethod
                    public int prepare(MethodVisitor methodVisitor) {
                        return 0;
                    }

                    @Override // net.bytebuddy.asm.Advice.ArgumentHandler.ForInstrumentedMethod
                    public int variable(int i) {
                        if (i < this.instrumentedMethod.getParameters().size() + (!this.instrumentedMethod.isStatic() ? 1 : 0)) {
                            return i;
                        }
                        TypeDefinition typeDefinition = this.exitType;
                        Class cls = Void.TYPE;
                        return this.namedTypes.size() + i + (!typeDefinition.represents(cls) ? 1 : 0) + (!this.enterType.represents(cls) ? 1 : 0);
                    }
                }

                public Default(MethodDescription methodDescription, TypeDefinition typeDefinition, SortedMap<String, TypeDefinition> sortedMap, TypeDefinition typeDefinition2) {
                    this.instrumentedMethod = methodDescription;
                    this.namedTypes = sortedMap;
                    this.exitType = typeDefinition;
                    this.enterType = typeDefinition2;
                }

                @Override // net.bytebuddy.asm.Advice.ArgumentHandler.ForInstrumentedMethod
                public ForAdvice bindEnter(MethodDescription methodDescription) {
                    return new ForAdvice.Default.ForMethodEnter(this.instrumentedMethod, methodDescription, this.exitType, this.namedTypes);
                }

                @Override // net.bytebuddy.asm.Advice.ArgumentHandler.ForInstrumentedMethod
                public ForAdvice bindExit(MethodDescription methodDescription, boolean z6) {
                    return new ForAdvice.Default.ForMethodExit(this.instrumentedMethod, methodDescription, this.exitType, this.namedTypes, this.enterType, z6 ? StackSize.ZERO : StackSize.SINGLE);
                }

                @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                public int enter() {
                    return StackSize.of(this.namedTypes.values()) + a.g(this.exitType, this.instrumentedMethod.getStackSize());
                }

                @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                public int exit() {
                    return this.instrumentedMethod.getStackSize();
                }

                @Override // net.bytebuddy.asm.Advice.ArgumentHandler.ForInstrumentedMethod
                public List<TypeDescription> getNamedTypes() {
                    ArrayList arrayList = new ArrayList(this.namedTypes.size());
                    Iterator<TypeDefinition> it = this.namedTypes.values().iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().asErasure());
                    }
                    return arrayList;
                }

                @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                public int named(String str) {
                    return StackSize.of(this.namedTypes.headMap(str).values()) + a.g(this.exitType, this.instrumentedMethod.getStackSize());
                }

                @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                public int returned() {
                    return a.g(this.enterType, StackSize.of(this.namedTypes.values()) + a.g(this.exitType, this.instrumentedMethod.getStackSize()));
                }

                @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                public int thrown() {
                    return this.instrumentedMethod.getReturnType().getStackSize().getSize() + a.g(this.enterType, StackSize.of(this.namedTypes.values()) + a.g(this.exitType, this.instrumentedMethod.getStackSize()));
                }
            }

            ForAdvice bindEnter(MethodDescription methodDescription);

            ForAdvice bindExit(MethodDescription methodDescription, boolean z6);

            List<TypeDescription> getNamedTypes();

            boolean isCopyingArguments();

            int prepare(MethodVisitor methodVisitor);

            int variable(int i);
        }

        int argument(int i);

        int enter();

        int exit();

        int named(String str);

        int returned();

        int thrown();
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static abstract class AssignReturned implements PostProcessor {
        public static final int NO_INDEX = -1;
        protected final ExceptionHandler.Factory exceptionHandlerFactory;
        protected final boolean exit;
        protected final boolean skipOnDefaultValue;
        protected final TypeDescription.Generic type;

        @Target({ElementType.METHOD})
        @Documented
        @Retention(RetentionPolicy.RUNTIME)
        public @interface AsScalar {
            boolean skipOnDefaultValue() default true;
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class DefaultValueSkip implements StackManipulation {
            private final Dispatcher dispatcher;
            private final int offset;
            private final StackManipulation stackManipulation;
            private final StackMapFrameHandler.ForPostProcessor stackMapFrameHandler;

            public enum Dispatcher {
                INTEGER { // from class: net.bytebuddy.asm.Advice.AssignReturned.DefaultValueSkip.Dispatcher.1
                    @Override // net.bytebuddy.asm.Advice.AssignReturned.DefaultValueSkip.Dispatcher
                    public StackManipulation.Size apply(MethodVisitor methodVisitor, int i, Label label) {
                        methodVisitor.visitVarInsn(21, i);
                        methodVisitor.visitJumpInsn(153, label);
                        return new StackManipulation.Size(0, 1);
                    }
                },
                LONG { // from class: net.bytebuddy.asm.Advice.AssignReturned.DefaultValueSkip.Dispatcher.2
                    @Override // net.bytebuddy.asm.Advice.AssignReturned.DefaultValueSkip.Dispatcher
                    public StackManipulation.Size apply(MethodVisitor methodVisitor, int i, Label label) {
                        methodVisitor.visitVarInsn(22, i);
                        methodVisitor.visitInsn(9);
                        methodVisitor.visitInsn(148);
                        methodVisitor.visitJumpInsn(153, label);
                        return new StackManipulation.Size(0, 4);
                    }
                },
                FLOAT { // from class: net.bytebuddy.asm.Advice.AssignReturned.DefaultValueSkip.Dispatcher.3
                    @Override // net.bytebuddy.asm.Advice.AssignReturned.DefaultValueSkip.Dispatcher
                    public StackManipulation.Size apply(MethodVisitor methodVisitor, int i, Label label) {
                        methodVisitor.visitVarInsn(23, i);
                        methodVisitor.visitInsn(11);
                        methodVisitor.visitInsn(149);
                        methodVisitor.visitJumpInsn(153, label);
                        return new StackManipulation.Size(0, 2);
                    }
                },
                DOUBLE { // from class: net.bytebuddy.asm.Advice.AssignReturned.DefaultValueSkip.Dispatcher.4
                    @Override // net.bytebuddy.asm.Advice.AssignReturned.DefaultValueSkip.Dispatcher
                    public StackManipulation.Size apply(MethodVisitor methodVisitor, int i, Label label) {
                        methodVisitor.visitVarInsn(24, i);
                        methodVisitor.visitInsn(14);
                        methodVisitor.visitInsn(151);
                        methodVisitor.visitJumpInsn(153, label);
                        return new StackManipulation.Size(0, 4);
                    }
                },
                REFERENCE { // from class: net.bytebuddy.asm.Advice.AssignReturned.DefaultValueSkip.Dispatcher.5
                    @Override // net.bytebuddy.asm.Advice.AssignReturned.DefaultValueSkip.Dispatcher
                    public StackManipulation.Size apply(MethodVisitor methodVisitor, int i, Label label) {
                        methodVisitor.visitVarInsn(25, i);
                        methodVisitor.visitJumpInsn(198, label);
                        return new StackManipulation.Size(0, 2);
                    }
                };

                public abstract StackManipulation.Size apply(MethodVisitor methodVisitor, int i, Label label);
            }

            public DefaultValueSkip(StackManipulation stackManipulation, StackMapFrameHandler.ForPostProcessor forPostProcessor, int i, Dispatcher dispatcher) {
                this.stackManipulation = stackManipulation;
                this.stackMapFrameHandler = forPostProcessor;
                this.offset = i;
                this.dispatcher = dispatcher;
            }

            public static StackManipulation of(StackManipulation stackManipulation, StackMapFrameHandler.ForPostProcessor forPostProcessor, int i, TypeDefinition typeDefinition) {
                Dispatcher dispatcher;
                if (!typeDefinition.isPrimitive()) {
                    dispatcher = Dispatcher.REFERENCE;
                } else if (typeDefinition.represents(Boolean.TYPE) || typeDefinition.represents(Byte.TYPE) || typeDefinition.represents(Short.TYPE) || typeDefinition.represents(Character.TYPE) || typeDefinition.represents(Integer.TYPE)) {
                    dispatcher = Dispatcher.INTEGER;
                } else if (typeDefinition.represents(Long.TYPE)) {
                    dispatcher = Dispatcher.LONG;
                } else if (typeDefinition.represents(Float.TYPE)) {
                    dispatcher = Dispatcher.FLOAT;
                } else {
                    if (!typeDefinition.represents(Double.TYPE)) {
                        throw new IllegalArgumentException("Cannot apply skip for " + typeDefinition);
                    }
                    dispatcher = Dispatcher.DOUBLE;
                }
                return new DefaultValueSkip(stackManipulation, forPostProcessor, i, dispatcher);
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                Label label = new Label();
                StackManipulation.Size sizeAggregate = this.dispatcher.apply(methodVisitor, this.offset, label).aggregate(this.stackManipulation.apply(methodVisitor, context));
                methodVisitor.visitLabel(label);
                this.stackMapFrameHandler.injectIntermediateFrame(methodVisitor, Collections.EMPTY_LIST);
                methodVisitor.visitInsn(0);
                return sizeAggregate;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                DefaultValueSkip defaultValueSkip = (DefaultValueSkip) obj;
                return this.offset == defaultValueSkip.offset && this.dispatcher.equals(defaultValueSkip.dispatcher) && this.stackManipulation.equals(defaultValueSkip.stackManipulation) && this.stackMapFrameHandler.equals(defaultValueSkip.stackMapFrameHandler);
            }

            public int hashCode() {
                return this.dispatcher.hashCode() + ((((this.stackMapFrameHandler.hashCode() + ((this.stackManipulation.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31) + this.offset) * 31);
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public boolean isValid() {
                return this.stackManipulation.isValid();
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ExceptionHandler implements StackManipulation {
            private final StackManipulation exceptionHandler;
            private final TypeDescription exceptionType;
            private final StackManipulation stackManipulation;
            private final StackMapFrameHandler.ForPostProcessor stackMapFrameHandler;

            public interface Factory {

                @HashCodeAndEqualsPlugin.Enhance
                public static class Enabled implements Factory {
                    private final TypeDescription exceptionType;

                    public Enabled(TypeDescription typeDescription) {
                        this.exceptionType = typeDescription;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.exceptionType.equals(((Enabled) obj).exceptionType);
                    }

                    public int hashCode() {
                        return this.exceptionType.hashCode() + (getClass().hashCode() * 31);
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.ExceptionHandler.Factory
                    public StackManipulation wrap(StackManipulation stackManipulation, StackManipulation stackManipulation2, StackMapFrameHandler.ForPostProcessor forPostProcessor) {
                        return new ExceptionHandler(stackManipulation, stackManipulation2, this.exceptionType, forPostProcessor);
                    }
                }

                public enum NoOp implements Factory {
                    INSTANCE;

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.ExceptionHandler.Factory
                    public StackManipulation wrap(StackManipulation stackManipulation, StackManipulation stackManipulation2, StackMapFrameHandler.ForPostProcessor forPostProcessor) {
                        return stackManipulation;
                    }
                }

                StackManipulation wrap(StackManipulation stackManipulation, StackManipulation stackManipulation2, StackMapFrameHandler.ForPostProcessor forPostProcessor);
            }

            public ExceptionHandler(StackManipulation stackManipulation, StackManipulation stackManipulation2, TypeDescription typeDescription, StackMapFrameHandler.ForPostProcessor forPostProcessor) {
                this.stackManipulation = stackManipulation;
                this.exceptionHandler = stackManipulation2;
                this.exceptionType = typeDescription;
                this.stackMapFrameHandler = forPostProcessor;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                Label label = new Label();
                Label label2 = new Label();
                Label label3 = new Label();
                methodVisitor.visitTryCatchBlock(label, label2, label2, this.exceptionType.getInternalName());
                methodVisitor.visitLabel(label);
                StackManipulation.Size sizeApply = this.stackManipulation.apply(methodVisitor, context);
                methodVisitor.visitJumpInsn(167, label3);
                methodVisitor.visitLabel(label2);
                this.stackMapFrameHandler.injectIntermediateFrame(methodVisitor, Collections.singletonList(this.exceptionType));
                StackManipulation.Size sizeAggregate = this.exceptionHandler.apply(methodVisitor, context).aggregate(sizeApply);
                methodVisitor.visitLabel(label3);
                this.stackMapFrameHandler.injectIntermediateFrame(methodVisitor, Collections.EMPTY_LIST);
                return sizeAggregate;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ExceptionHandler exceptionHandler = (ExceptionHandler) obj;
                return this.stackManipulation.equals(exceptionHandler.stackManipulation) && this.exceptionHandler.equals(exceptionHandler.exceptionHandler) && this.exceptionType.equals(exceptionHandler.exceptionType) && this.stackMapFrameHandler.equals(exceptionHandler.stackMapFrameHandler);
            }

            public int hashCode() {
                return this.stackMapFrameHandler.hashCode() + a.i(this.exceptionType, (this.exceptionHandler.hashCode() + ((this.stackManipulation.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31, 31);
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public boolean isValid() {
                return this.stackManipulation.isValid() && this.exceptionHandler.isValid();
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Factory implements PostProcessor.Factory {
            private static final MethodDescription.InDefinedShape SKIP_ON_DEFAULT_VALUE = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType.of(AsScalar.class).getDeclaredMethods().filter(ElementMatchers.named("skipOnDefaultValue")).getOnly();
            private final ExceptionHandler.Factory exceptionHandlerFactory;
            private final List<? extends Handler.Factory<?>> factories;

            public Factory() {
                this(Arrays.asList(ToArguments.Handler.Factory.INSTANCE, ToAllArguments.Handler.Factory.INSTANCE, ToThis.Handler.Factory.INSTANCE, ToFields.Handler.Factory.INSTANCE, ToReturned.Handler.Factory.INSTANCE, ToThrown.Handler.Factory.INSTANCE), ExceptionHandler.Factory.NoOp.INSTANCE);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Factory factory = (Factory) obj;
                return this.factories.equals(factory.factories) && this.exceptionHandlerFactory.equals(factory.exceptionHandlerFactory);
            }

            public int hashCode() {
                return this.exceptionHandlerFactory.hashCode() + androidx.constraintlayout.core.motion.a.d(this.factories, getClass().hashCode() * 31, 31);
            }

            @Override // net.bytebuddy.asm.Advice.PostProcessor.Factory
            public PostProcessor make(MethodDescription.InDefinedShape inDefinedShape, boolean z6) {
                if (inDefinedShape.getReturnType().represents(Void.TYPE)) {
                    return PostProcessor.NoOp.INSTANCE;
                }
                HashMap map = new HashMap();
                for (Handler.Factory<?> factory : this.factories) {
                    if (map.put(factory.getAnnotationType().getName(), factory) != null) {
                        throw new IllegalStateException("Duplicate registration of handler for " + factory.getAnnotationType());
                    }
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                boolean z7 = false;
                boolean zBooleanValue = true;
                for (AnnotationDescription annotationDescription : inDefinedShape.getDeclaredAnnotations()) {
                    if (annotationDescription.getAnnotationType().represents(AsScalar.class)) {
                        zBooleanValue = ((Boolean) annotationDescription.getValue(SKIP_ON_DEFAULT_VALUE).resolve(Boolean.class)).booleanValue();
                        z7 = true;
                    } else {
                        Handler.Factory factory2 = (Handler.Factory) map.get(annotationDescription.getAnnotationType().getName());
                        if (factory2 != null && linkedHashMap.put(factory2.getAnnotationType(), factory2.make(inDefinedShape, z6, annotationDescription.prepare(factory2.getAnnotationType()))) != null) {
                            throw new IllegalStateException("Duplicate handler registration for " + annotationDescription.getAnnotationType());
                        }
                    }
                }
                return linkedHashMap.isEmpty() ? PostProcessor.NoOp.INSTANCE : (z7 || !inDefinedShape.getReturnType().isArray()) ? new ForScalar(inDefinedShape.getReturnType(), this.exceptionHandlerFactory, z6, zBooleanValue, linkedHashMap.values()) : new ForArray(inDefinedShape.getReturnType(), this.exceptionHandlerFactory, z6, linkedHashMap.values());
            }

            public Factory with(Class<? extends Annotation> cls, Handler... handlerArr) {
                return with(cls, Arrays.asList(handlerArr));
            }

            public PostProcessor.Factory withSuppressed(Class<? extends Throwable> cls) {
                return withSuppressed(TypeDescription.ForLoadedType.of(cls));
            }

            public Factory(List<? extends Handler.Factory<?>> list, ExceptionHandler.Factory factory) {
                this.factories = list;
                this.exceptionHandlerFactory = factory;
            }

            public Factory with(Class<? extends Annotation> cls, List<Handler> list) {
                return with(new Handler.Factory.Simple(cls, list));
            }

            public PostProcessor.Factory withSuppressed(TypeDescription typeDescription) {
                if (typeDescription.isAssignableTo(Throwable.class)) {
                    return new Factory(this.factories, new ExceptionHandler.Factory.Enabled(typeDescription));
                }
                throw new IllegalArgumentException(a.o(typeDescription, " is not a throwable type"));
            }

            public Factory with(Handler.Factory<?> factory) {
                return new Factory(CompoundList.of(this.factories, factory), this.exceptionHandlerFactory);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForArray extends AssignReturned {
            private final Map<Handler, Integer> handlers;

            public ForArray(TypeDescription.Generic generic, ExceptionHandler.Factory factory, boolean z6, Collection<List<Handler>> collection) {
                super(generic, factory, z6, true);
                this.handlers = new LinkedHashMap();
                Iterator<List<Handler>> it = collection.iterator();
                while (it.hasNext()) {
                    for (Handler handler : it.next()) {
                        int index = handler.getIndex();
                        if (index <= -1) {
                            throw new IllegalStateException("Handler on array requires positive index for " + handler);
                        }
                        this.handlers.put(handler, Integer.valueOf(index));
                    }
                }
            }

            @Override // net.bytebuddy.asm.Advice.AssignReturned
            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.handlers.equals(((ForArray) obj).handlers);
            }

            @Override // net.bytebuddy.asm.Advice.AssignReturned
            public Collection<Handler> getHandlers() {
                return this.handlers.keySet();
            }

            @Override // net.bytebuddy.asm.Advice.AssignReturned
            @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
            public TypeDescription.Generic getType() {
                return this.type.getComponentType();
            }

            @Override // net.bytebuddy.asm.Advice.AssignReturned
            public int hashCode() {
                return this.handlers.hashCode() + (super.hashCode() * 31);
            }

            @Override // net.bytebuddy.asm.Advice.AssignReturned
            @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
            public StackManipulation toLoadInstruction(Handler handler, int i) {
                return new StackManipulation.Compound(MethodVariableAccess.REFERENCE.loadFrom(i), IntegerConstant.forValue(this.handlers.get(handler).intValue()), ArrayAccess.of(this.type.getComponentType()).load());
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForScalar extends AssignReturned {
            private final List<Handler> handlers;

            public ForScalar(TypeDescription.Generic generic, ExceptionHandler.Factory factory, boolean z6, boolean z7, Collection<List<Handler>> collection) {
                super(generic, factory, z6, z7);
                this.handlers = new ArrayList();
                Iterator<List<Handler>> it = collection.iterator();
                while (it.hasNext()) {
                    for (Handler handler : it.next()) {
                        if (handler.getIndex() > -1) {
                            throw new IllegalStateException("Handler on array requires negative index for " + handler);
                        }
                        this.handlers.add(handler);
                    }
                }
            }

            @Override // net.bytebuddy.asm.Advice.AssignReturned
            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.handlers.equals(((ForScalar) obj).handlers);
            }

            @Override // net.bytebuddy.asm.Advice.AssignReturned
            public Collection<Handler> getHandlers() {
                return this.handlers;
            }

            @Override // net.bytebuddy.asm.Advice.AssignReturned
            public TypeDescription.Generic getType() {
                return this.type;
            }

            @Override // net.bytebuddy.asm.Advice.AssignReturned
            public int hashCode() {
                return this.handlers.hashCode() + (super.hashCode() * 31);
            }

            @Override // net.bytebuddy.asm.Advice.AssignReturned
            public StackManipulation toLoadInstruction(Handler handler, int i) {
                return MethodVariableAccess.of(this.type).loadFrom(i);
            }
        }

        public interface Handler {

            public interface Factory<T extends Annotation> {

                @HashCodeAndEqualsPlugin.Enhance
                public static class Simple<S extends Annotation> implements Factory<S> {
                    private final List<Handler> handlers;
                    private final Class<S> type;

                    public Simple(Class<S> cls, List<Handler> list) {
                        this.type = cls;
                        this.handlers = list;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Simple simple = (Simple) obj;
                        return this.type.equals(simple.type) && this.handlers.equals(simple.handlers);
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    public Class<S> getAnnotationType() {
                        return this.type;
                    }

                    public int hashCode() {
                        return this.handlers.hashCode() + a.e(getClass().hashCode() * 31, 31, this.type);
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    public List<Handler> make(MethodDescription.InDefinedShape inDefinedShape, boolean z6, AnnotationDescription.Loadable<? extends S> loadable) {
                        return this.handlers;
                    }
                }

                Class<T> getAnnotationType();

                List<Handler> make(MethodDescription.InDefinedShape inDefinedShape, boolean z6, AnnotationDescription.Loadable<? extends T> loadable);
            }

            int getIndex();

            StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, TypeDescription.Generic generic, StackManipulation stackManipulation);
        }

        @Target({ElementType.METHOD})
        @Documented
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ToAllArguments {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Handler implements Handler {
                private final int index;
                private final Assigner.Typing typing;

                public enum Factory implements Handler.Factory<ToAllArguments> {
                    INSTANCE;

                    private static final MethodDescription.InDefinedShape TO_ALL_ARGUMENTS_INDEX;
                    private static final MethodDescription.InDefinedShape TO_ALL_ARGUMENTS_TYPING;

                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(ToAllArguments.class).getDeclaredMethods();
                        TO_ALL_ARGUMENTS_INDEX = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("index")).getOnly();
                        TO_ALL_ARGUMENTS_TYPING = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("typing")).getOnly();
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    public Class<ToAllArguments> getAnnotationType() {
                        return ToAllArguments.class;
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    public List<Handler> make(MethodDescription.InDefinedShape inDefinedShape, boolean z6, AnnotationDescription.Loadable<? extends ToAllArguments> loadable) {
                        return Collections.singletonList(new Handler(((Integer) loadable.getValue(TO_ALL_ARGUMENTS_INDEX).resolve(Integer.class)).intValue(), (Assigner.Typing) a.k(ToAllArguments.class, loadable.getValue(TO_ALL_ARGUMENTS_TYPING), Assigner.Typing.class)));
                    }
                }

                public Handler(int i, Assigner.Typing typing) {
                    this.index = i;
                    this.typing = typing;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Handler handler = (Handler) obj;
                    return this.index == handler.index && this.typing.equals(handler.typing);
                }

                @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler
                public int getIndex() {
                    return this.index;
                }

                public int hashCode() {
                    return this.typing.hashCode() + (((getClass().hashCode() * 31) + this.index) * 31);
                }

                @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler
                @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, TypeDescription.Generic generic, StackManipulation stackManipulation) {
                    ArrayList arrayList = new ArrayList(methodDescription.getParameters().size());
                    if (!generic.isArray()) {
                        StackManipulation stackManipulationAssign = assigner.assign(generic, TypeDefinition.Sort.describe(Object[].class), this.typing);
                        if (!stackManipulationAssign.isValid()) {
                            throw new IllegalStateException("Cannot assign " + generic + " to " + Object[].class);
                        }
                        generic = TypeDefinition.Sort.describe(Object[].class);
                        stackManipulation = new StackManipulation.Compound(stackManipulation, stackManipulationAssign);
                    }
                    Iterator<?> it = methodDescription.getParameters().iterator();
                    while (it.hasNext()) {
                        ParameterDescription parameterDescription = (ParameterDescription) it.next();
                        StackManipulation stackManipulationAssign2 = assigner.assign(generic.getComponentType(), parameterDescription.getType(), this.typing);
                        if (!stackManipulationAssign2.isValid()) {
                            throw new IllegalStateException("Cannot assign " + generic.getComponentType() + " to " + parameterDescription);
                        }
                        arrayList.add(new StackManipulation.Compound(stackManipulationAssign2, MethodVariableAccess.of(parameterDescription.getType()).storeAt(argumentHandler.argument(parameterDescription.getOffset()))));
                    }
                    return new StackManipulation.Compound(stackManipulation, ArrayAccess.of(generic.getComponentType()).forEach(arrayList), Removal.SINGLE);
                }
            }

            int index() default -1;

            Assigner.Typing typing() default Assigner.Typing.STATIC;
        }

        @Target({ElementType.METHOD})
        @Documented
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ToArguments {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Handler implements Handler {
                private final int index;
                private final Assigner.Typing typing;
                private final int value;

                public enum Factory implements Handler.Factory<ToArguments> {
                    INSTANCE;

                    private static final MethodDescription.InDefinedShape TO_ARGUMENTS_VALUE = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType.of(ToArguments.class).getDeclaredMethods().filter(ElementMatchers.named("value")).getOnly();
                    private static final MethodDescription.InDefinedShape TO_ARGUMENT_INDEX;
                    private static final MethodDescription.InDefinedShape TO_ARGUMENT_TYPING;
                    private static final MethodDescription.InDefinedShape TO_ARGUMENT_VALUE;

                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(ToArgument.class).getDeclaredMethods();
                        TO_ARGUMENT_VALUE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("value")).getOnly();
                        TO_ARGUMENT_INDEX = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("index")).getOnly();
                        TO_ARGUMENT_TYPING = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("typing")).getOnly();
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    public Class<ToArguments> getAnnotationType() {
                        return ToArguments.class;
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    public List<Handler> make(MethodDescription.InDefinedShape inDefinedShape, boolean z6, AnnotationDescription.Loadable<? extends ToArguments> loadable) {
                        ArrayList arrayList = new ArrayList();
                        for (AnnotationDescription annotationDescription : (AnnotationDescription[]) loadable.getValue(TO_ARGUMENTS_VALUE).resolve(AnnotationDescription[].class)) {
                            int iIntValue = ((Integer) annotationDescription.getValue(TO_ARGUMENT_VALUE).resolve(Integer.class)).intValue();
                            if (iIntValue < 0) {
                                throw new IllegalStateException("An argument cannot have a negative index for " + inDefinedShape);
                            }
                            arrayList.add(new Handler(iIntValue, ((Integer) annotationDescription.getValue(TO_ARGUMENT_INDEX).resolve(Integer.class)).intValue(), (Assigner.Typing) a.k(ToArguments.class, annotationDescription.getValue(TO_ARGUMENT_TYPING), Assigner.Typing.class)));
                        }
                        return arrayList;
                    }
                }

                public Handler(int i, int i3, Assigner.Typing typing) {
                    this.value = i;
                    this.index = i3;
                    this.typing = typing;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Handler handler = (Handler) obj;
                    return this.value == handler.value && this.index == handler.index && this.typing.equals(handler.typing);
                }

                @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler
                public int getIndex() {
                    return this.index;
                }

                public int hashCode() {
                    return this.typing.hashCode() + (((((getClass().hashCode() * 31) + this.value) * 31) + this.index) * 31);
                }

                @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler
                public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, TypeDescription.Generic generic, StackManipulation stackManipulation) {
                    if (methodDescription.getParameters().size() < this.value) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(methodDescription);
                        sb.append(" declares less then ");
                        throw new IllegalStateException(b.g(sb, " parameters", this.value));
                    }
                    StackManipulation stackManipulationAssign = assigner.assign(generic, ((ParameterDescription) methodDescription.getParameters().get(this.value)).getType(), this.typing);
                    if (stackManipulationAssign.isValid()) {
                        return new StackManipulation.Compound(stackManipulation, stackManipulationAssign, MethodVariableAccess.of(((ParameterDescription) methodDescription.getParameters().get(this.value)).getType()).storeAt(argumentHandler.argument(((ParameterDescription) methodDescription.getParameters().get(this.value)).getOffset())));
                    }
                    throw new IllegalStateException("Cannot assign " + generic + " to " + ((ParameterDescription) methodDescription.getParameters().get(this.value)).getType());
                }
            }

            @Target({})
            @RepeatedAnnotationPlugin.Enhance(ToArguments.class)
            @Repeatable(ToArguments.class)
            public @interface ToArgument {
                int index() default -1;

                Assigner.Typing typing() default Assigner.Typing.STATIC;

                int value();
            }

            ToArgument[] value();
        }

        @Target({ElementType.METHOD})
        @Documented
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ToFields {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Handler implements Handler {
                private final TypeDescription declaringType;
                private final int index;
                private final String name;
                private final Assigner.Typing typing;

                public enum Factory implements Handler.Factory<ToFields> {
                    INSTANCE;

                    private static final MethodDescription.InDefinedShape TO_FIELDS_VALUE = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType.of(ToFields.class).getDeclaredMethods().filter(ElementMatchers.named("value")).getOnly();
                    private static final MethodDescription.InDefinedShape TO_FIELD_DECLARING_TYPE;
                    private static final MethodDescription.InDefinedShape TO_FIELD_INDEX;
                    private static final MethodDescription.InDefinedShape TO_FIELD_TYPING;
                    private static final MethodDescription.InDefinedShape TO_FIELD_VALUE;

                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(ToField.class).getDeclaredMethods();
                        TO_FIELD_VALUE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("value")).getOnly();
                        TO_FIELD_INDEX = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("index")).getOnly();
                        TO_FIELD_DECLARING_TYPE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("declaringType")).getOnly();
                        TO_FIELD_TYPING = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("typing")).getOnly();
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    public Class<ToFields> getAnnotationType() {
                        return ToFields.class;
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    public List<Handler> make(MethodDescription.InDefinedShape inDefinedShape, boolean z6, AnnotationDescription.Loadable<? extends ToFields> loadable) {
                        ArrayList arrayList = new ArrayList();
                        for (AnnotationDescription annotationDescription : (AnnotationDescription[]) loadable.getValue(TO_FIELDS_VALUE).resolve(AnnotationDescription[].class)) {
                            arrayList.add(new Handler(((Integer) annotationDescription.getValue(TO_FIELD_INDEX).resolve(Integer.class)).intValue(), (String) annotationDescription.getValue(TO_FIELD_VALUE).resolve(String.class), (TypeDescription) annotationDescription.getValue(TO_FIELD_DECLARING_TYPE).resolve(TypeDescription.class), (Assigner.Typing) a.k(ToFields.class, annotationDescription.getValue(TO_FIELD_TYPING), Assigner.Typing.class)));
                        }
                        return arrayList;
                    }
                }

                public Handler(int i, String str, TypeDescription typeDescription, Assigner.Typing typing) {
                    this.index = i;
                    this.name = str;
                    this.declaringType = typeDescription;
                    this.typing = typing;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Handler handler = (Handler) obj;
                    return this.index == handler.index && this.typing.equals(handler.typing) && this.name.equals(handler.name) && this.declaringType.equals(handler.declaringType);
                }

                @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler
                public int getIndex() {
                    return this.index;
                }

                public int hashCode() {
                    return this.typing.hashCode() + a.i(this.declaringType, androidx.constraintlayout.core.motion.a.c(((getClass().hashCode() * 31) + this.index) * 31, 31, this.name), 31);
                }

                @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler
                @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, TypeDescription.Generic generic, StackManipulation stackManipulation) {
                    StackManipulation stackManipulationLoadThis;
                    FieldLocator forClassHierarchy = this.declaringType.represents(Void.TYPE) ? new FieldLocator.ForClassHierarchy(typeDescription) : new FieldLocator.ForExactType(this.declaringType);
                    FieldLocator.Resolution resolutionResolveAccessor = this.name.equals("") ? OffsetMapping.ForField.Unresolved.resolveAccessor(forClassHierarchy, methodDescription) : forClassHierarchy.locate(this.name);
                    if (!resolutionResolveAccessor.isResolved()) {
                        throw new IllegalStateException("Cannot resolve field " + this.name + " for " + typeDescription);
                    }
                    if (!resolutionResolveAccessor.getField().isVisibleTo(typeDescription)) {
                        throw new IllegalStateException(resolutionResolveAccessor.getField() + " is not visible to " + typeDescription);
                    }
                    if (resolutionResolveAccessor.getField().isStatic()) {
                        stackManipulationLoadThis = StackManipulation.Trivial.INSTANCE;
                    } else {
                        if (methodDescription.isStatic()) {
                            throw new IllegalStateException("Cannot access member field " + resolutionResolveAccessor.getField() + " from static " + methodDescription);
                        }
                        if (!typeDescription.isAssignableTo(resolutionResolveAccessor.getField().getDeclaringType().asErasure())) {
                            throw new IllegalStateException(typeDescription + " does not define " + resolutionResolveAccessor.getField());
                        }
                        stackManipulationLoadThis = MethodVariableAccess.loadThis();
                    }
                    StackManipulation stackManipulationAssign = assigner.assign(generic, resolutionResolveAccessor.getField().getType(), this.typing);
                    if (stackManipulationAssign.isValid()) {
                        return new StackManipulation.Compound(stackManipulationLoadThis, stackManipulation, stackManipulationAssign, FieldAccess.forField(resolutionResolveAccessor.getField()).write());
                    }
                    throw new IllegalStateException("Cannot assign " + generic + " to " + resolutionResolveAccessor.getField());
                }
            }

            @Target({})
            @RepeatedAnnotationPlugin.Enhance(ToFields.class)
            @Repeatable(ToFields.class)
            public @interface ToField {
                Class<?> declaringType() default void.class;

                int index() default -1;

                Assigner.Typing typing() default Assigner.Typing.STATIC;

                String value() default "";
            }

            ToField[] value();
        }

        @Target({ElementType.METHOD})
        @Documented
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ToReturned {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Handler implements Handler {
                private final int index;
                private final Assigner.Typing typing;

                public enum Factory implements Handler.Factory<ToReturned> {
                    INSTANCE;

                    private static final MethodDescription.InDefinedShape TO_RETURNED_INDEX;
                    private static final MethodDescription.InDefinedShape TO_RETURNED_TYPING;

                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(ToReturned.class).getDeclaredMethods();
                        TO_RETURNED_INDEX = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("index")).getOnly();
                        TO_RETURNED_TYPING = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("typing")).getOnly();
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    public Class<ToReturned> getAnnotationType() {
                        return ToReturned.class;
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    public List<Handler> make(MethodDescription.InDefinedShape inDefinedShape, boolean z6, AnnotationDescription.Loadable<? extends ToReturned> loadable) {
                        if (z6) {
                            return Collections.singletonList(new Handler(((Integer) loadable.getValue(TO_RETURNED_INDEX).resolve(Integer.class)).intValue(), (Assigner.Typing) a.k(ToReturned.class, loadable.getValue(TO_RETURNED_TYPING), Assigner.Typing.class)));
                        }
                        throw new IllegalStateException("Cannot write returned value from enter advice " + inDefinedShape);
                    }
                }

                public Handler(int i, Assigner.Typing typing) {
                    this.index = i;
                    this.typing = typing;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Handler handler = (Handler) obj;
                    return this.index == handler.index && this.typing.equals(handler.typing);
                }

                @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler
                public int getIndex() {
                    return this.index;
                }

                public int hashCode() {
                    return this.typing.hashCode() + (((getClass().hashCode() * 31) + this.index) * 31);
                }

                @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler
                public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, TypeDescription.Generic generic, StackManipulation stackManipulation) {
                    if (methodDescription.getReturnType().represents(Void.TYPE)) {
                        return StackManipulation.Trivial.INSTANCE;
                    }
                    StackManipulation stackManipulationAssign = assigner.assign(generic, methodDescription.getReturnType(), this.typing);
                    if (stackManipulationAssign.isValid()) {
                        return new StackManipulation.Compound(stackManipulation, stackManipulationAssign, MethodVariableAccess.of(methodDescription.getReturnType()).storeAt(argumentHandler.returned()));
                    }
                    throw new IllegalStateException("Cannot assign " + generic + " to " + methodDescription.getReturnType());
                }
            }

            int index() default -1;

            Assigner.Typing typing() default Assigner.Typing.STATIC;
        }

        @Target({ElementType.METHOD})
        @Documented
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ToThis {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Handler implements Handler {
                private final boolean exit;
                private final int index;
                private final Assigner.Typing typing;

                public enum Factory implements Handler.Factory<ToThis> {
                    INSTANCE;

                    private static final MethodDescription.InDefinedShape TO_THIS_INDEX;
                    private static final MethodDescription.InDefinedShape TO_THIS_TYPING;

                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(ToThis.class).getDeclaredMethods();
                        TO_THIS_INDEX = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("index")).getOnly();
                        TO_THIS_TYPING = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("typing")).getOnly();
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    public Class<ToThis> getAnnotationType() {
                        return ToThis.class;
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    public List<Handler> make(MethodDescription.InDefinedShape inDefinedShape, boolean z6, AnnotationDescription.Loadable<? extends ToThis> loadable) {
                        return Collections.singletonList(new Handler(((Integer) loadable.getValue(TO_THIS_INDEX).resolve(Integer.class)).intValue(), (Assigner.Typing) a.k(ToThis.class, loadable.getValue(TO_THIS_TYPING), Assigner.Typing.class), z6));
                    }
                }

                public Handler(int i, Assigner.Typing typing, boolean z6) {
                    this.index = i;
                    this.typing = typing;
                    this.exit = z6;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Handler handler = (Handler) obj;
                    return this.index == handler.index && this.exit == handler.exit && this.typing.equals(handler.typing);
                }

                @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler
                public int getIndex() {
                    return this.index;
                }

                public int hashCode() {
                    return ((this.typing.hashCode() + (((getClass().hashCode() * 31) + this.index) * 31)) * 31) + (this.exit ? 1 : 0);
                }

                @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler
                public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, TypeDescription.Generic generic, StackManipulation stackManipulation) {
                    if (methodDescription.isStatic()) {
                        throw new IllegalStateException(a.l("Cannot assign this reference for static method ", methodDescription));
                    }
                    if (!this.exit && methodDescription.isConstructor()) {
                        throw new IllegalStateException(a.l("Cannot assign this reference in constructor prior to initialization for ", methodDescription));
                    }
                    StackManipulation stackManipulationAssign = assigner.assign(generic, typeDescription.asGenericType(), this.typing);
                    if (stackManipulationAssign.isValid()) {
                        return new StackManipulation.Compound(stackManipulation, stackManipulationAssign, MethodVariableAccess.REFERENCE.storeAt(argumentHandler.argument(0)));
                    }
                    throw new IllegalStateException("Cannot assign " + generic + " to " + typeDescription);
                }
            }

            int index() default -1;

            Assigner.Typing typing() default Assigner.Typing.STATIC;
        }

        @Target({ElementType.METHOD})
        @Documented
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ToThrown {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Handler implements Handler {
                private final int index;
                private final Assigner.Typing typing;

                public enum Factory implements Handler.Factory<ToThrown> {
                    INSTANCE;

                    private static final MethodDescription.InDefinedShape TO_THROWN_INDEX;
                    private static final MethodDescription.InDefinedShape TO_THROWN_TYPING;

                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(ToThrown.class).getDeclaredMethods();
                        TO_THROWN_INDEX = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("index")).getOnly();
                        TO_THROWN_TYPING = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("typing")).getOnly();
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    public Class<ToThrown> getAnnotationType() {
                        return ToThrown.class;
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    @SuppressFBWarnings(justification = "Assuming annotation for exit advice.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    public List<Handler> make(MethodDescription.InDefinedShape inDefinedShape, boolean z6, AnnotationDescription.Loadable<? extends ToThrown> loadable) {
                        if (!z6) {
                            throw new IllegalStateException("Cannot assign thrown value from enter advice " + inDefinedShape);
                        }
                        if (!((TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodExit.class).getValue(Advice.ON_THROWABLE).resolve(TypeDescription.class)).represents(NoExceptionHandler.class)) {
                            return Collections.singletonList(new Handler(((Integer) loadable.getValue(TO_THROWN_INDEX).resolve(Integer.class)).intValue(), (Assigner.Typing) a.k(ToThrown.class, loadable.getValue(TO_THROWN_TYPING), Assigner.Typing.class)));
                        }
                        throw new IllegalStateException("Cannot assign thrown value for non-catching exit advice " + inDefinedShape);
                    }
                }

                public Handler(int i, Assigner.Typing typing) {
                    this.index = i;
                    this.typing = typing;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Handler handler = (Handler) obj;
                    return this.index == handler.index && this.typing.equals(handler.typing);
                }

                @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler
                public int getIndex() {
                    return this.index;
                }

                public int hashCode() {
                    return this.typing.hashCode() + (((getClass().hashCode() * 31) + this.index) * 31);
                }

                @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler
                public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, TypeDescription.Generic generic, StackManipulation stackManipulation) {
                    if (methodDescription.getReturnType().represents(Void.TYPE)) {
                        return StackManipulation.Trivial.INSTANCE;
                    }
                    StackManipulation stackManipulationAssign = assigner.assign(generic, TypeDefinition.Sort.describe(Throwable.class), this.typing);
                    if (stackManipulationAssign.isValid()) {
                        return new StackManipulation.Compound(stackManipulation, stackManipulationAssign, MethodVariableAccess.REFERENCE.storeAt(argumentHandler.thrown()));
                    }
                    throw new IllegalStateException("Cannot assign " + generic + " to " + Throwable.class.getName());
                }
            }

            int index() default -1;

            Assigner.Typing typing() default Assigner.Typing.STATIC;
        }

        public AssignReturned(TypeDescription.Generic generic, ExceptionHandler.Factory factory, boolean z6, boolean z7) {
            this.type = generic;
            this.exceptionHandlerFactory = factory;
            this.exit = z6;
            this.skipOnDefaultValue = z7;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            AssignReturned assignReturned = (AssignReturned) obj;
            return this.exit == assignReturned.exit && this.skipOnDefaultValue == assignReturned.skipOnDefaultValue && this.type.equals(assignReturned.type) && this.exceptionHandlerFactory.equals(assignReturned.exceptionHandlerFactory);
        }

        public abstract Collection<Handler> getHandlers();

        public abstract TypeDescription.Generic getType();

        public int hashCode() {
            return ((((this.exceptionHandlerFactory.hashCode() + a.h(this.type, getClass().hashCode() * 31, 31)) * 31) + (this.exit ? 1 : 0)) * 31) + (this.skipOnDefaultValue ? 1 : 0);
        }

        @Override // net.bytebuddy.asm.Advice.PostProcessor
        public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, StackMapFrameHandler.ForPostProcessor forPostProcessor, StackManipulation stackManipulation) {
            ArrayList arrayList = new ArrayList(getHandlers().size());
            for (Handler handler : getHandlers()) {
                arrayList.add(handler.resolve(typeDescription, methodDescription, assigner, argumentHandler, getType(), toLoadInstruction(handler, this.exit ? argumentHandler.exit() : argumentHandler.enter())));
            }
            StackManipulation stackManipulationWrap = this.exceptionHandlerFactory.wrap(new StackManipulation.Compound(arrayList), stackManipulation, forPostProcessor);
            if (this.skipOnDefaultValue) {
                return DefaultValueSkip.of(stackManipulationWrap, forPostProcessor, this.exit ? argumentHandler.exit() : argumentHandler.enter(), this.type);
            }
            return stackManipulationWrap;
        }

        public abstract StackManipulation toLoadInstruction(Handler handler, int i);
    }

    public interface Delegator {

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForDynamicInvocation implements Delegator {
            private final MethodDescription.InDefinedShape bootstrapMethod;

            public ForDynamicInvocation(MethodDescription.InDefinedShape inDefinedShape) {
                this.bootstrapMethod = inDefinedShape;
            }

            public static Delegator of(MethodDescription.InDefinedShape inDefinedShape) {
                if (inDefinedShape.isInvokeBootstrap()) {
                    return new ForDynamicInvocation(inDefinedShape);
                }
                throw new IllegalArgumentException("Not a suitable bootstrap target: " + inDefinedShape);
            }

            @Override // net.bytebuddy.asm.Advice.Delegator
            public void apply(MethodVisitor methodVisitor, MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription, MethodDescription methodDescription, boolean z6) {
                Object[] objArr;
                boolean zIsTypeInitializer = methodDescription.isTypeInitializer();
                Class cls = Integer.TYPE;
                if (zIsTypeInitializer) {
                    if (!this.bootstrapMethod.isInvokeBootstrap(Arrays.asList(TypeDescription.ForLoadedType.of(String.class), TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(Class.class), TypeDescription.ForLoadedType.of(String.class)))) {
                        throw new IllegalArgumentException(this.bootstrapMethod + " is not accepting advice bootstrap arguments");
                    }
                    objArr = new Object[]{inDefinedShape.getDeclaringType().getName(), Integer.valueOf(z6 ? 1 : 0), Type.getType(typeDescription.getDescriptor()), methodDescription.getInternalName()};
                } else {
                    if (!this.bootstrapMethod.isInvokeBootstrap(Arrays.asList(TypeDescription.ForLoadedType.of(String.class), TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(Class.class), TypeDescription.ForLoadedType.of(String.class), JavaType.METHOD_HANDLE.getTypeStub()))) {
                        throw new IllegalArgumentException(this.bootstrapMethod + " is not accepting advice bootstrap arguments");
                    }
                    objArr = new Object[]{inDefinedShape.getDeclaringType().getName(), Integer.valueOf(z6 ? 1 : 0), Type.getType(typeDescription.getDescriptor()), methodDescription.getInternalName(), JavaConstant.MethodHandle.of(methodDescription.asDefined()).accept(JavaConstantValue.Visitor.INSTANCE)};
                }
                methodVisitor.visitInvokeDynamicInsn(inDefinedShape.getInternalName(), inDefinedShape.getDescriptor(), new Handle(this.bootstrapMethod.isConstructor() ? 8 : 6, this.bootstrapMethod.getDeclaringType().getInternalName(), this.bootstrapMethod.getInternalName(), this.bootstrapMethod.getDescriptor(), false), objArr);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.bootstrapMethod.equals(((ForDynamicInvocation) obj).bootstrapMethod);
            }

            public int hashCode() {
                return this.bootstrapMethod.hashCode() + (getClass().hashCode() * 31);
            }
        }

        public enum ForStaticInvocation implements Delegator {
            INSTANCE;

            @Override // net.bytebuddy.asm.Advice.Delegator
            public void apply(MethodVisitor methodVisitor, MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription, MethodDescription methodDescription, boolean z6) {
                methodVisitor.visitMethodInsn(184, inDefinedShape.getDeclaringType().getInternalName(), inDefinedShape.getInternalName(), inDefinedShape.getDescriptor(), false);
            }
        }

        void apply(MethodVisitor methodVisitor, MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription, MethodDescription methodDescription, boolean z6);
    }

    public interface Dispatcher {

        @AlwaysNull
        public static final AnnotationVisitor IGNORE_ANNOTATION = null;

        @AlwaysNull
        public static final MethodVisitor IGNORE_METHOD = null;

        public interface Bound {
            void apply();

            void initialize();

            void prepare();
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Delegating implements Unresolved {
            protected final MethodDescription.InDefinedShape adviceMethod;
            protected final Delegator delegator;

            public static abstract class Resolved extends Resolved.AbstractBase {
                protected final Delegator delegator;

                public static abstract class AdviceMethodWriter implements Bound {
                    protected final MethodDescription.InDefinedShape adviceMethod;
                    protected final ArgumentHandler.ForAdvice argumentHandler;
                    private final Assigner assigner;
                    private final Delegator delegator;
                    private final StackManipulation exceptionHandler;
                    protected final Implementation.Context implementationContext;
                    private final MethodDescription instrumentedMethod;
                    private final TypeDescription instrumentedType;
                    protected final MethodSizeHandler.ForAdvice methodSizeHandler;
                    protected final MethodVisitor methodVisitor;
                    private final List<OffsetMapping.Target> offsetMappings;
                    private final PostProcessor postProcessor;
                    private final RelocationHandler.Bound relocationHandler;
                    protected final StackMapFrameHandler.ForAdvice stackMapFrameHandler;
                    private final SuppressionHandler.Bound suppressionHandler;

                    public static class ForMethodEnter extends AdviceMethodWriter {
                        public ForMethodEnter(MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, PostProcessor postProcessor, List<OffsetMapping.Target> list, MethodVisitor methodVisitor, Implementation.Context context, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation, Delegator delegator) {
                            super(inDefinedShape, typeDescription, methodDescription, assigner, postProcessor, list, methodVisitor, context, forAdvice, forAdvice2, forAdvice3, bound, bound2, stackManipulation, delegator);
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Bound
                        public void initialize() {
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Delegating.Resolved.AdviceMethodWriter
                        public boolean isExitAdvice() {
                            return false;
                        }
                    }

                    public static class ForMethodExit extends AdviceMethodWriter {
                        public ForMethodExit(MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, PostProcessor postProcessor, List<OffsetMapping.Target> list, MethodVisitor methodVisitor, Implementation.Context context, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation, Delegator delegator) {
                            super(inDefinedShape, typeDescription, methodDescription, assigner, postProcessor, list, methodVisitor, context, forAdvice, forAdvice2, forAdvice3, bound, bound2, stackManipulation, delegator);
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Bound
                        public void initialize() {
                            if (this.adviceMethod.getReturnType().represents(Boolean.TYPE) || this.adviceMethod.getReturnType().represents(Byte.TYPE) || this.adviceMethod.getReturnType().represents(Short.TYPE) || this.adviceMethod.getReturnType().represents(Character.TYPE) || this.adviceMethod.getReturnType().represents(Integer.TYPE)) {
                                this.methodVisitor.visitInsn(3);
                                this.methodVisitor.visitVarInsn(54, this.argumentHandler.exit());
                            } else if (this.adviceMethod.getReturnType().represents(Long.TYPE)) {
                                this.methodVisitor.visitInsn(9);
                                this.methodVisitor.visitVarInsn(55, this.argumentHandler.exit());
                            } else if (this.adviceMethod.getReturnType().represents(Float.TYPE)) {
                                this.methodVisitor.visitInsn(11);
                                this.methodVisitor.visitVarInsn(56, this.argumentHandler.exit());
                            } else if (this.adviceMethod.getReturnType().represents(Double.TYPE)) {
                                this.methodVisitor.visitInsn(14);
                                this.methodVisitor.visitVarInsn(57, this.argumentHandler.exit());
                            } else if (!this.adviceMethod.getReturnType().represents(Void.TYPE)) {
                                this.methodVisitor.visitInsn(1);
                                this.methodVisitor.visitVarInsn(58, this.argumentHandler.exit());
                            }
                            this.methodSizeHandler.requireStackSize(this.adviceMethod.getReturnType().getStackSize().getSize());
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Delegating.Resolved.AdviceMethodWriter
                        public boolean isExitAdvice() {
                            return true;
                        }
                    }

                    public AdviceMethodWriter(MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, PostProcessor postProcessor, List<OffsetMapping.Target> list, MethodVisitor methodVisitor, Implementation.Context context, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation, Delegator delegator) {
                        this.adviceMethod = inDefinedShape;
                        this.instrumentedType = typeDescription;
                        this.instrumentedMethod = methodDescription;
                        this.assigner = assigner;
                        this.postProcessor = postProcessor;
                        this.offsetMappings = list;
                        this.methodVisitor = methodVisitor;
                        this.implementationContext = context;
                        this.argumentHandler = forAdvice;
                        this.methodSizeHandler = forAdvice2;
                        this.stackMapFrameHandler = forAdvice3;
                        this.suppressionHandler = bound;
                        this.relocationHandler = bound2;
                        this.exceptionHandler = stackManipulation;
                        this.delegator = delegator;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Bound
                    public void apply() {
                        this.suppressionHandler.onStart(this.methodVisitor);
                        int size = 0;
                        int i = 0;
                        int iMax = 0;
                        for (OffsetMapping.Target target : this.offsetMappings) {
                            size += this.adviceMethod.getParameters().get(i).getType().getStackSize().getSize();
                            iMax = Math.max(iMax, target.resolveRead().apply(this.methodVisitor, this.implementationContext).getMaximalSize() + size);
                            i++;
                        }
                        this.delegator.apply(this.methodVisitor, this.adviceMethod, this.instrumentedType, this.instrumentedMethod, isExitAdvice());
                        this.suppressionHandler.onEndWithSkip(this.methodVisitor, this.implementationContext, this.methodSizeHandler, this.stackMapFrameHandler, this.adviceMethod.getReturnType());
                        if (this.adviceMethod.getReturnType().represents(Boolean.TYPE) || this.adviceMethod.getReturnType().represents(Byte.TYPE) || this.adviceMethod.getReturnType().represents(Short.TYPE) || this.adviceMethod.getReturnType().represents(Character.TYPE) || this.adviceMethod.getReturnType().represents(Integer.TYPE)) {
                            this.methodVisitor.visitVarInsn(54, isExitAdvice() ? this.argumentHandler.exit() : this.argumentHandler.enter());
                        } else if (this.adviceMethod.getReturnType().represents(Long.TYPE)) {
                            this.methodVisitor.visitVarInsn(55, isExitAdvice() ? this.argumentHandler.exit() : this.argumentHandler.enter());
                        } else if (this.adviceMethod.getReturnType().represents(Float.TYPE)) {
                            this.methodVisitor.visitVarInsn(56, isExitAdvice() ? this.argumentHandler.exit() : this.argumentHandler.enter());
                        } else if (this.adviceMethod.getReturnType().represents(Double.TYPE)) {
                            this.methodVisitor.visitVarInsn(57, isExitAdvice() ? this.argumentHandler.exit() : this.argumentHandler.enter());
                        } else if (!this.adviceMethod.getReturnType().represents(Void.TYPE)) {
                            this.methodVisitor.visitVarInsn(58, isExitAdvice() ? this.argumentHandler.exit() : this.argumentHandler.enter());
                        }
                        this.methodSizeHandler.requireStackSize(this.postProcessor.resolve(this.instrumentedType, this.instrumentedMethod, this.assigner, this.argumentHandler, this.stackMapFrameHandler, this.exceptionHandler).apply(this.methodVisitor, this.implementationContext).getMaximalSize());
                        this.methodSizeHandler.requireStackSize(this.relocationHandler.apply(this.methodVisitor, isExitAdvice() ? this.argumentHandler.exit() : this.argumentHandler.enter()));
                        this.stackMapFrameHandler.injectCompletionFrame(this.methodVisitor);
                        this.methodSizeHandler.requireStackSize(Math.max(iMax, this.adviceMethod.getReturnType().getStackSize().getSize()));
                        this.methodSizeHandler.requireLocalVariableLength(this.adviceMethod.getReturnType().getStackSize().getSize() + this.instrumentedMethod.getStackSize());
                    }

                    public abstract boolean isExitAdvice();

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Bound
                    public void prepare() {
                        this.suppressionHandler.onPrepare(this.methodVisitor);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static abstract class ForMethodEnter extends Resolved implements Resolved.ForMethodEnter {
                    private final boolean prependLineNumber;

                    public static class WithDiscardedEnterType extends ForMethodEnter {
                        public WithDiscardedEnterType(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, Delegator delegator) {
                            super(inDefinedShape, postProcessor, list, typeDefinition, delegator);
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Delegating.Resolved.ForMethodEnter
                        public Bound doResolve(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation) {
                            forAdvice2.requireLocalVariableLengthPadding(this.adviceMethod.getReturnType().getStackSize().getSize());
                            return super.doResolve(typeDescription, methodDescription, methodVisitor, context, assigner, forAdvice, forAdvice2, forAdvice3, bound, bound2, stackManipulation);
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher
                        public TypeDefinition getAdviceType() {
                            return TypeDescription.ForLoadedType.of(Void.TYPE);
                        }
                    }

                    public static class WithRetainedEnterType extends ForMethodEnter {
                        public WithRetainedEnterType(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, Delegator delegator) {
                            super(inDefinedShape, postProcessor, list, typeDefinition, delegator);
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher
                        public TypeDefinition getAdviceType() {
                            return this.adviceMethod.getReturnType();
                        }
                    }

                    @SuppressFBWarnings(justification = "Assuming annotation for exit advice.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    public ForMethodEnter(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, Delegator delegator) {
                        super(inDefinedShape, postProcessor, CompoundList.of(Arrays.asList(OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE, OffsetMapping.ForAllArguments.Factory.INSTANCE, OffsetMapping.ForThisReference.Factory.INSTANCE, OffsetMapping.ForField.Unresolved.Factory.INSTANCE, OffsetMapping.ForOrigin.Factory.INSTANCE, OffsetMapping.ForUnusedValue.Factory.INSTANCE, OffsetMapping.ForStubValue.INSTANCE, OffsetMapping.ForExitValue.Factory.of(typeDefinition), new OffsetMapping.Factory.Illegal(Thrown.class), new OffsetMapping.Factory.Illegal(Enter.class), new OffsetMapping.Factory.Illegal(Local.class), new OffsetMapping.Factory.Illegal(Return.class)), (List) list), (TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodEnter.class).getValue(Advice.SUPPRESS_ENTER).resolve(TypeDescription.class), (TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodEnter.class).getValue(Advice.SKIP_ON).resolve(TypeDescription.class), delegator);
                        this.prependLineNumber = ((Boolean) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodEnter.class).getValue(Advice.PREPEND_LINE_NUMBER).resolve(Boolean.class)).booleanValue();
                    }

                    public static Resolved.ForMethodEnter of(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Delegator delegator, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, boolean z6) {
                        return z6 ? new WithRetainedEnterType(inDefinedShape, postProcessor, list, typeDefinition, delegator) : new WithDiscardedEnterType(inDefinedShape, postProcessor, list, typeDefinition, delegator);
                    }

                    public Bound doResolve(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation) {
                        ArrayList arrayList = new ArrayList(this.offsetMappings.size());
                        Iterator<OffsetMapping> it = this.offsetMappings.values().iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next().resolve(typeDescription, methodDescription, assigner, forAdvice, OffsetMapping.Sort.ENTER));
                        }
                        return new AdviceMethodWriter.ForMethodEnter(this.adviceMethod, typeDescription, methodDescription, assigner, this.postProcessor, arrayList, methodVisitor, context, forAdvice, forAdvice2, forAdvice3, bound, bound2, stackManipulation, this.delegator);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.AbstractBase
                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.prependLineNumber == ((ForMethodEnter) obj).prependLineNumber;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodEnter
                    public TypeDefinition getActualAdviceType() {
                        return this.adviceMethod.getReturnType();
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.AbstractBase
                    public int hashCode() {
                        return (super.hashCode() * 31) + (this.prependLineNumber ? 1 : 0);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodEnter
                    public boolean isPrependLineNumber() {
                        return this.prependLineNumber;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Delegating.Resolved
                    public Bound resolve(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, StackManipulation stackManipulation, RelocationHandler.Relocation relocation) {
                        return doResolve(typeDescription, methodDescription, methodVisitor, context, assigner, forInstrumentedMethod.bindEnter(this.adviceMethod), forInstrumentedMethod2.bindEnter(this.adviceMethod), forInstrumentedMethod3.bindEnter(this.adviceMethod), this.suppressionHandler.bind(stackManipulation), this.relocationHandler.bind(methodDescription, relocation), stackManipulation);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static abstract class ForMethodExit extends Resolved implements Resolved.ForMethodExit {
                    private final boolean backupArguments;

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class WithExceptionHandler extends ForMethodExit {
                        private final TypeDescription throwable;

                        public WithExceptionHandler(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Map<String, TypeDefinition> map, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, TypeDescription typeDescription, Delegator delegator) {
                            super(inDefinedShape, postProcessor, map, list, typeDefinition, delegator);
                            this.throwable = typeDescription;
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Delegating.Resolved.ForMethodExit, net.bytebuddy.asm.Advice.Dispatcher.Resolved.AbstractBase
                        public boolean equals(@MaybeNull Object obj) {
                            if (!super.equals(obj)) {
                                return false;
                            }
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.throwable.equals(((WithExceptionHandler) obj).throwable);
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodExit
                        public TypeDescription getThrowable() {
                            return this.throwable;
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Delegating.Resolved.ForMethodExit, net.bytebuddy.asm.Advice.Dispatcher.Resolved.AbstractBase
                        public int hashCode() {
                            return this.throwable.hashCode() + (super.hashCode() * 31);
                        }
                    }

                    public static class WithoutExceptionHandler extends ForMethodExit {
                        public WithoutExceptionHandler(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Map<String, TypeDefinition> map, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, Delegator delegator) {
                            super(inDefinedShape, postProcessor, map, list, typeDefinition, delegator);
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodExit
                        public TypeDescription getThrowable() {
                            return NoExceptionHandler.DESCRIPTION;
                        }
                    }

                    @SuppressFBWarnings(justification = "Assuming annotation for exit advice.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    public ForMethodExit(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Map<String, TypeDefinition> map, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, Delegator delegator) {
                        super(inDefinedShape, postProcessor, CompoundList.of(Arrays.asList(OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE, OffsetMapping.ForAllArguments.Factory.INSTANCE, OffsetMapping.ForThisReference.Factory.INSTANCE, OffsetMapping.ForField.Unresolved.Factory.INSTANCE, OffsetMapping.ForOrigin.Factory.INSTANCE, OffsetMapping.ForUnusedValue.Factory.INSTANCE, OffsetMapping.ForStubValue.INSTANCE, OffsetMapping.ForEnterValue.Factory.of(typeDefinition), OffsetMapping.ForExitValue.Factory.of(inDefinedShape.getReturnType()), new OffsetMapping.ForLocalValue.Factory(map), OffsetMapping.ForReturnValue.Factory.INSTANCE, OffsetMapping.ForThrowable.Factory.of(inDefinedShape)), (List) list), (TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodExit.class).getValue(Advice.SUPPRESS_EXIT).resolve(TypeDescription.class), (TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodExit.class).getValue(Advice.REPEAT_ON).resolve(TypeDescription.class), delegator);
                        this.backupArguments = ((Boolean) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodExit.class).getValue(Advice.BACKUP_ARGUMENTS).resolve(Boolean.class)).booleanValue();
                    }

                    private Bound doResolve(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation) {
                        ArrayList arrayList = new ArrayList(this.offsetMappings.size());
                        Iterator<OffsetMapping> it = this.offsetMappings.values().iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next().resolve(typeDescription, methodDescription, assigner, forAdvice, OffsetMapping.Sort.EXIT));
                        }
                        return new AdviceMethodWriter.ForMethodExit(this.adviceMethod, typeDescription, methodDescription, assigner, this.postProcessor, arrayList, methodVisitor, context, forAdvice, forAdvice2, forAdvice3, bound, bound2, stackManipulation, this.delegator);
                    }

                    @SuppressFBWarnings(justification = "Assuming annotation for exit advice.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    public static Resolved.ForMethodExit of(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Delegator delegator, Map<String, TypeDefinition> map, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition) {
                        TypeDescription typeDescription = (TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodExit.class).getValue(Advice.ON_THROWABLE).resolve(TypeDescription.class);
                        return typeDescription.represents(NoExceptionHandler.class) ? new WithoutExceptionHandler(inDefinedShape, postProcessor, map, list, typeDefinition, delegator) : new WithExceptionHandler(inDefinedShape, postProcessor, map, list, typeDefinition, typeDescription, delegator);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.AbstractBase
                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.backupArguments == ((ForMethodExit) obj).backupArguments;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher
                    public TypeDefinition getAdviceType() {
                        return this.adviceMethod.getReturnType();
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodExit
                    public ArgumentHandler.Factory getArgumentHandlerFactory() {
                        return this.backupArguments ? ArgumentHandler.Factory.COPYING : ArgumentHandler.Factory.SIMPLE;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.AbstractBase
                    public int hashCode() {
                        return (super.hashCode() * 31) + (this.backupArguments ? 1 : 0);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Delegating.Resolved
                    public Bound resolve(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, StackManipulation stackManipulation, RelocationHandler.Relocation relocation) {
                        return doResolve(typeDescription, methodDescription, methodVisitor, context, assigner, forInstrumentedMethod.bindExit(this.adviceMethod, getThrowable().represents(NoExceptionHandler.class)), forInstrumentedMethod2.bindExit(this.adviceMethod), forInstrumentedMethod3.bindExit(this.adviceMethod), this.suppressionHandler.bind(stackManipulation), this.relocationHandler.bind(methodDescription, relocation), stackManipulation);
                    }
                }

                public Resolved(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, List<? extends OffsetMapping.Factory<?>> list, TypeDescription typeDescription, TypeDescription typeDescription2, Delegator delegator) {
                    super(inDefinedShape, postProcessor, list, typeDescription, typeDescription2, OffsetMapping.Factory.AdviceType.DELEGATION);
                    this.delegator = delegator;
                }

                @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved
                public Bound bind(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, StackManipulation stackManipulation, RelocationHandler.Relocation relocation) {
                    if (this.adviceMethod.isVisibleTo(typeDescription)) {
                        return resolve(typeDescription, methodDescription, methodVisitor, context, assigner, forInstrumentedMethod, forInstrumentedMethod2, forInstrumentedMethod3, stackManipulation, relocation);
                    }
                    throw new IllegalStateException(this.adviceMethod + " is not visible to " + methodDescription.getDeclaringType());
                }

                @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved
                public Map<String, TypeDefinition> getNamedTypes() {
                    return Collections.EMPTY_MAP;
                }

                public abstract Bound resolve(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, StackManipulation stackManipulation, RelocationHandler.Relocation relocation);
            }

            public Delegating(MethodDescription.InDefinedShape inDefinedShape, Delegator delegator) {
                this.adviceMethod = inDefinedShape;
                this.delegator = delegator;
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Unresolved
            public Resolved.ForMethodEnter asMethodEnter(List<? extends OffsetMapping.Factory<?>> list, @MaybeNull ClassReader classReader, Unresolved unresolved, PostProcessor.Factory factory) {
                MethodDescription.InDefinedShape inDefinedShape = this.adviceMethod;
                return Resolved.ForMethodEnter.of(inDefinedShape, factory.make(inDefinedShape, false), this.delegator, list, unresolved.getAdviceType(), unresolved.isAlive());
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Unresolved
            public Resolved.ForMethodExit asMethodExit(List<? extends OffsetMapping.Factory<?>> list, @MaybeNull ClassReader classReader, Unresolved unresolved, PostProcessor.Factory factory) {
                Map<String, TypeDefinition> namedTypes = unresolved.getNamedTypes();
                for (ParameterDescription.InDefinedShape inDefinedShape : this.adviceMethod.getParameters()) {
                    AnnotationDescription.Loadable loadableOfType = inDefinedShape.getDeclaredAnnotations().ofType(Local.class);
                    if (loadableOfType != null) {
                        String str = (String) loadableOfType.getValue(OffsetMapping.ForLocalValue.Factory.LOCAL_VALUE).resolve(String.class);
                        TypeDefinition typeDefinition = namedTypes.get(str);
                        if (typeDefinition == null) {
                            throw new IllegalStateException(this.adviceMethod + " attempts use of undeclared local variable " + str);
                        }
                        if (!typeDefinition.equals(inDefinedShape.getType())) {
                            throw new IllegalStateException(this.adviceMethod + " does not read variable " + str + " as " + typeDefinition);
                        }
                    }
                }
                MethodDescription.InDefinedShape inDefinedShape2 = this.adviceMethod;
                return Resolved.ForMethodExit.of(inDefinedShape2, factory.make(inDefinedShape2, true), this.delegator, namedTypes, list, unresolved.getAdviceType());
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Delegating delegating = (Delegating) obj;
                return this.adviceMethod.equals(delegating.adviceMethod) && this.delegator.equals(delegating.delegator);
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Unresolved
            public Map<String, TypeDefinition> getNamedTypes() {
                return Collections.EMPTY_MAP;
            }

            public int hashCode() {
                return this.delegator.hashCode() + ((this.adviceMethod.hashCode() + (getClass().hashCode() * 31)) * 31);
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher
            public boolean isAlive() {
                return true;
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Unresolved
            public boolean isBinary() {
                return false;
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher
            public TypeDescription getAdviceType() {
                return this.adviceMethod.getReturnType().asErasure();
            }
        }

        public enum Inactive implements Unresolved, Resolved.ForMethodEnter, Resolved.ForMethodExit, Bound {
            INSTANCE;

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Bound
            public void apply() {
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Unresolved
            public Resolved.ForMethodEnter asMethodEnter(List<? extends OffsetMapping.Factory<?>> list, @MaybeNull ClassReader classReader, Unresolved unresolved, PostProcessor.Factory factory) {
                return this;
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Unresolved
            public Resolved.ForMethodExit asMethodExit(List<? extends OffsetMapping.Factory<?>> list, @MaybeNull ClassReader classReader, Unresolved unresolved, PostProcessor.Factory factory) {
                return this;
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved
            public Bound bind(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, StackManipulation stackManipulation, RelocationHandler.Relocation relocation) {
                return this;
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodEnter
            public TypeDefinition getActualAdviceType() {
                return TypeDescription.ForLoadedType.of(Void.TYPE);
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodExit
            public ArgumentHandler.Factory getArgumentHandlerFactory() {
                return ArgumentHandler.Factory.SIMPLE;
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Unresolved
            public Map<String, TypeDefinition> getNamedTypes() {
                return Collections.EMPTY_MAP;
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodExit
            public TypeDescription getThrowable() {
                return NoExceptionHandler.DESCRIPTION;
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Bound
            public void initialize() {
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher
            public boolean isAlive() {
                return false;
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Unresolved
            public boolean isBinary() {
                return false;
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodEnter
            public boolean isPrependLineNumber() {
                return false;
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Bound
            public void prepare() {
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher
            public TypeDescription getAdviceType() {
                return TypeDescription.ForLoadedType.of(Void.TYPE);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Inlining implements Unresolved {
            protected final MethodDescription.InDefinedShape adviceMethod;
            private final Map<String, TypeDefinition> namedTypes = new HashMap();

            public static class CodeTranslationVisitor extends MethodVisitor {
                protected final MethodDescription.InDefinedShape adviceMethod;
                protected final ArgumentHandler.ForAdvice argumentHandler;
                private final Assigner assigner;
                protected final Label endOfMethod;
                private final StackManipulation exceptionHandler;
                private final boolean exit;
                protected final Implementation.Context implementationContext;
                private final MethodDescription instrumentedMethod;
                private final TypeDescription instrumentedType;
                protected final MethodSizeHandler.ForAdvice methodSizeHandler;
                protected final MethodVisitor methodVisitor;
                private final Map<Integer, OffsetMapping.Target> offsetMappings;
                private final PostProcessor postProcessor;
                private final RelocationHandler.Bound relocationHandler;
                protected final StackMapFrameHandler.ForAdvice stackMapFrameHandler;
                private final SuppressionHandler.Bound suppressionHandler;

                public CodeTranslationVisitor(MethodVisitor methodVisitor, Implementation.Context context, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, MethodDescription.InDefinedShape inDefinedShape, Map<Integer, OffsetMapping.Target> map, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation, PostProcessor postProcessor, boolean z6) {
                    super(OpenedClassReader.ASM_API, StackAwareMethodVisitor.of(methodVisitor, methodDescription));
                    this.methodVisitor = methodVisitor;
                    this.implementationContext = context;
                    this.argumentHandler = forAdvice;
                    this.methodSizeHandler = forAdvice2;
                    this.stackMapFrameHandler = forAdvice3;
                    this.instrumentedType = typeDescription;
                    this.instrumentedMethod = methodDescription;
                    this.assigner = assigner;
                    this.adviceMethod = inDefinedShape;
                    this.offsetMappings = map;
                    this.suppressionHandler = bound;
                    this.relocationHandler = bound2;
                    this.exceptionHandler = stackManipulation;
                    this.postProcessor = postProcessor;
                    this.exit = z6;
                    this.endOfMethod = new Label();
                }

                public void propagateHandler(Label label) {
                    ((StackAwareMethodVisitor) this.mv).register(label, Collections.singletonList(StackSize.SINGLE));
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitAnnotableParameterCount(int i, boolean z6) {
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                @MaybeNull
                public AnnotationVisitor visitAnnotation(String str, boolean z6) {
                    return Dispatcher.IGNORE_ANNOTATION;
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                @MaybeNull
                public AnnotationVisitor visitAnnotationDefault() {
                    return Dispatcher.IGNORE_ANNOTATION;
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitAttribute(Attribute attribute) {
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitCode() {
                    this.suppressionHandler.onStart(this.methodVisitor);
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitEnd() {
                    this.suppressionHandler.onEnd(this.methodVisitor, this.implementationContext, this.methodSizeHandler, this.stackMapFrameHandler, this.adviceMethod.getReturnType());
                    this.methodVisitor.visitLabel(this.endOfMethod);
                    if (this.adviceMethod.getReturnType().represents(Boolean.TYPE) || this.adviceMethod.getReturnType().represents(Byte.TYPE) || this.adviceMethod.getReturnType().represents(Short.TYPE) || this.adviceMethod.getReturnType().represents(Character.TYPE) || this.adviceMethod.getReturnType().represents(Integer.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.methodVisitor);
                        this.methodVisitor.visitVarInsn(54, this.exit ? this.argumentHandler.exit() : this.argumentHandler.enter());
                    } else if (this.adviceMethod.getReturnType().represents(Long.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.methodVisitor);
                        this.methodVisitor.visitVarInsn(55, this.exit ? this.argumentHandler.exit() : this.argumentHandler.enter());
                    } else if (this.adviceMethod.getReturnType().represents(Float.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.methodVisitor);
                        this.methodVisitor.visitVarInsn(56, this.exit ? this.argumentHandler.exit() : this.argumentHandler.enter());
                    } else if (this.adviceMethod.getReturnType().represents(Double.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.methodVisitor);
                        this.methodVisitor.visitVarInsn(57, this.exit ? this.argumentHandler.exit() : this.argumentHandler.enter());
                    } else if (!this.adviceMethod.getReturnType().represents(Void.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.methodVisitor);
                        this.methodVisitor.visitVarInsn(58, this.exit ? this.argumentHandler.exit() : this.argumentHandler.enter());
                    }
                    this.methodSizeHandler.requireStackSize(this.postProcessor.resolve(this.instrumentedType, this.instrumentedMethod, this.assigner, this.argumentHandler, this.stackMapFrameHandler, this.exceptionHandler).apply(this.methodVisitor, this.implementationContext).getMaximalSize());
                    this.methodSizeHandler.requireStackSize(this.relocationHandler.apply(this.methodVisitor, this.exit ? this.argumentHandler.exit() : this.argumentHandler.enter()));
                    this.stackMapFrameHandler.injectCompletionFrame(this.methodVisitor);
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitFrame(int i, int i3, @MaybeNull Object[] objArr, int i4, @MaybeNull Object[] objArr2) {
                    this.stackMapFrameHandler.translateFrame(this.methodVisitor, i, i3, objArr, i4, objArr2);
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitIincInsn(int i, int i3) {
                    OffsetMapping.Target target = this.offsetMappings.get(Integer.valueOf(i));
                    if (target != null) {
                        this.methodSizeHandler.requireStackSizePadding(target.resolveIncrement(i3).apply(this.mv, this.implementationContext).getMaximalSize());
                    } else {
                        this.mv.visitIincInsn(this.argumentHandler.mapped(i), i3);
                    }
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitInsn(int i) {
                    switch (i) {
                        case 172:
                            this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor) this.mv).drainStack(54, 21, StackSize.SINGLE));
                            break;
                        case 173:
                            this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor) this.mv).drainStack(55, 22, StackSize.DOUBLE));
                            break;
                        case 174:
                            this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor) this.mv).drainStack(56, 23, StackSize.SINGLE));
                            break;
                        case 175:
                            this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor) this.mv).drainStack(57, 24, StackSize.DOUBLE));
                            break;
                        case 176:
                            this.methodSizeHandler.requireLocalVariableLength(((StackAwareMethodVisitor) this.mv).drainStack(58, 25, StackSize.SINGLE));
                            break;
                        case 177:
                            ((StackAwareMethodVisitor) this.mv).drainStack();
                            break;
                        default:
                            this.mv.visitInsn(i);
                            return;
                    }
                    this.mv.visitJumpInsn(167, this.endOfMethod);
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitMaxs(int i, int i3) {
                    this.methodSizeHandler.recordMaxima(i, i3);
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitParameter(String str, int i) {
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                @MaybeNull
                public AnnotationVisitor visitParameterAnnotation(int i, String str, boolean z6) {
                    return Dispatcher.IGNORE_ANNOTATION;
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                @MaybeNull
                public AnnotationVisitor visitTypeAnnotation(int i, @MaybeNull TypePath typePath, String str, boolean z6) {
                    return Dispatcher.IGNORE_ANNOTATION;
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitVarInsn(int i, int i3) {
                    StackManipulation stackManipulationResolveRead;
                    StackSize stackSize;
                    OffsetMapping.Target target = this.offsetMappings.get(Integer.valueOf(i3));
                    if (target == null) {
                        this.mv.visitVarInsn(i, this.argumentHandler.mapped(i3));
                        return;
                    }
                    switch (i) {
                        case 21:
                        case 23:
                        case 25:
                            stackManipulationResolveRead = target.resolveRead();
                            stackSize = StackSize.SINGLE;
                            break;
                        case 22:
                        case 24:
                            stackManipulationResolveRead = target.resolveRead();
                            stackSize = StackSize.DOUBLE;
                            break;
                        default:
                            switch (i) {
                                case 54:
                                case 55:
                                case 56:
                                case 57:
                                case 58:
                                    stackManipulationResolveRead = target.resolveWrite();
                                    stackSize = StackSize.ZERO;
                                    break;
                                default:
                                    throw new IllegalStateException(b.c(i, "Unexpected opcode: "));
                            }
                            break;
                    }
                    this.methodSizeHandler.requireStackSizePadding(stackManipulationResolveRead.apply(this.mv, this.implementationContext).getMaximalSize() - stackSize.getSize());
                }
            }

            public static abstract class Resolved extends Resolved.AbstractBase {
                protected final ClassReader classReader;

                @HashCodeAndEqualsPlugin.Enhance
                public static abstract class ForMethodEnter extends Resolved implements Resolved.ForMethodEnter {
                    private final Map<String, TypeDefinition> namedTypes;
                    private final boolean prependLineNumber;

                    public static class WithDiscardedEnterType extends ForMethodEnter {
                        public WithDiscardedEnterType(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Map<String, TypeDefinition> map, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, ClassReader classReader) {
                            super(inDefinedShape, postProcessor, map, list, typeDefinition, classReader);
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Inlining.Resolved.ForMethodEnter
                        public MethodVisitor doApply(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, TypeDescription typeDescription, MethodDescription methodDescription, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation) {
                            forAdvice2.requireLocalVariableLengthPadding(this.adviceMethod.getReturnType().getStackSize().getSize());
                            return super.doApply(methodVisitor, context, assigner, forAdvice, forAdvice2, forAdvice3, typeDescription, methodDescription, bound, bound2, stackManipulation);
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher
                        public TypeDefinition getAdviceType() {
                            return TypeDescription.ForLoadedType.of(Void.TYPE);
                        }
                    }

                    public static class WithRetainedEnterType extends ForMethodEnter {
                        public WithRetainedEnterType(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Map<String, TypeDefinition> map, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, ClassReader classReader) {
                            super(inDefinedShape, postProcessor, map, list, typeDefinition, classReader);
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher
                        public TypeDefinition getAdviceType() {
                            return this.adviceMethod.getReturnType();
                        }
                    }

                    @SuppressFBWarnings(justification = "Assuming annotation for exit advice.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    public ForMethodEnter(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Map<String, TypeDefinition> map, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, ClassReader classReader) {
                        super(inDefinedShape, postProcessor, CompoundList.of(Arrays.asList(OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE, OffsetMapping.ForAllArguments.Factory.INSTANCE, OffsetMapping.ForThisReference.Factory.INSTANCE, OffsetMapping.ForField.Unresolved.Factory.INSTANCE, OffsetMapping.ForOrigin.Factory.INSTANCE, OffsetMapping.ForUnusedValue.Factory.INSTANCE, OffsetMapping.ForStubValue.INSTANCE, OffsetMapping.ForThrowable.Factory.INSTANCE, OffsetMapping.ForExitValue.Factory.of(typeDefinition), new OffsetMapping.ForLocalValue.Factory(map), new OffsetMapping.Factory.Illegal(Thrown.class), new OffsetMapping.Factory.Illegal(Enter.class), new OffsetMapping.Factory.Illegal(Return.class)), (List) list), (TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodEnter.class).getValue(Advice.SUPPRESS_ENTER).resolve(TypeDescription.class), (TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodEnter.class).getValue(Advice.SKIP_ON).resolve(TypeDescription.class), classReader);
                        this.namedTypes = map;
                        this.prependLineNumber = ((Boolean) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodEnter.class).getValue(Advice.PREPEND_LINE_NUMBER).resolve(Boolean.class)).booleanValue();
                    }

                    public static Resolved.ForMethodEnter of(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Map<String, TypeDefinition> map, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, ClassReader classReader, boolean z6) {
                        return z6 ? new WithRetainedEnterType(inDefinedShape, postProcessor, map, list, typeDefinition, classReader) : new WithDiscardedEnterType(inDefinedShape, postProcessor, map, list, typeDefinition, classReader);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Inlining.Resolved
                    public MethodVisitor apply(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, TypeDescription typeDescription, MethodDescription methodDescription, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation) {
                        return doApply(methodVisitor, context, assigner, forInstrumentedMethod.bindEnter(this.adviceMethod), forInstrumentedMethod2.bindEnter(this.adviceMethod), forInstrumentedMethod3.bindEnter(this.adviceMethod), typeDescription, methodDescription, bound, bound2, stackManipulation);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved
                    public Bound bind(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, StackManipulation stackManipulation, RelocationHandler.Relocation relocation) {
                        return new AdviceMethodInliner(typeDescription, methodDescription, methodVisitor, context, assigner, forInstrumentedMethod, forInstrumentedMethod2, forInstrumentedMethod3, this.suppressionHandler.bind(stackManipulation), this.relocationHandler.bind(methodDescription, relocation), stackManipulation, this.classReader);
                    }

                    public MethodVisitor doApply(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, TypeDescription typeDescription, MethodDescription methodDescription, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation) {
                        HashMap map = new HashMap();
                        for (Map.Entry<Integer, OffsetMapping> entry : this.offsetMappings.entrySet()) {
                            map.put(entry.getKey(), entry.getValue().resolve(typeDescription, methodDescription, assigner, forAdvice, OffsetMapping.Sort.ENTER));
                        }
                        return new CodeTranslationVisitor(methodVisitor, context, forAdvice, forAdvice2, forAdvice3, typeDescription, methodDescription, assigner, this.adviceMethod, map, bound, bound2, stackManipulation, this.postProcessor, false);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.AbstractBase
                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForMethodEnter forMethodEnter = (ForMethodEnter) obj;
                        return this.prependLineNumber == forMethodEnter.prependLineNumber && this.namedTypes.equals(forMethodEnter.namedTypes);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodEnter
                    public TypeDefinition getActualAdviceType() {
                        return this.adviceMethod.getReturnType();
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved
                    public Map<String, TypeDefinition> getNamedTypes() {
                        return this.namedTypes;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.AbstractBase
                    public int hashCode() {
                        return ((this.namedTypes.hashCode() + (super.hashCode() * 31)) * 31) + (this.prependLineNumber ? 1 : 0);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodEnter
                    public boolean isPrependLineNumber() {
                        return this.prependLineNumber;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Inlining.Resolved
                    public Map<Integer, TypeDefinition> resolveInitializationTypes(ArgumentHandler argumentHandler) {
                        TreeMap treeMap = new TreeMap();
                        for (Map.Entry<String, TypeDefinition> entry : this.namedTypes.entrySet()) {
                            treeMap.put(Integer.valueOf(argumentHandler.named(entry.getKey())), entry.getValue());
                        }
                        return treeMap;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static abstract class ForMethodExit extends Resolved implements Resolved.ForMethodExit {
                    private final boolean backupArguments;
                    private final Map<String, TypeDefinition> uninitializedNamedTypes;

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class WithExceptionHandler extends ForMethodExit {
                        private final TypeDescription throwable;

                        public WithExceptionHandler(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Map<String, TypeDefinition> map, Map<String, TypeDefinition> map2, List<? extends OffsetMapping.Factory<?>> list, ClassReader classReader, TypeDefinition typeDefinition, TypeDescription typeDescription) {
                            super(inDefinedShape, postProcessor, map, map2, list, classReader, typeDefinition);
                            this.throwable = typeDescription;
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Inlining.Resolved.ForMethodExit, net.bytebuddy.asm.Advice.Dispatcher.Resolved.AbstractBase
                        public boolean equals(@MaybeNull Object obj) {
                            if (!super.equals(obj)) {
                                return false;
                            }
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.throwable.equals(((WithExceptionHandler) obj).throwable);
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodExit
                        public TypeDescription getThrowable() {
                            return this.throwable;
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Inlining.Resolved.ForMethodExit, net.bytebuddy.asm.Advice.Dispatcher.Resolved.AbstractBase
                        public int hashCode() {
                            return this.throwable.hashCode() + (super.hashCode() * 31);
                        }
                    }

                    public static class WithoutExceptionHandler extends ForMethodExit {
                        public WithoutExceptionHandler(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Map<String, TypeDefinition> map, Map<String, TypeDefinition> map2, List<? extends OffsetMapping.Factory<?>> list, ClassReader classReader, TypeDefinition typeDefinition) {
                            super(inDefinedShape, postProcessor, map, map2, list, classReader, typeDefinition);
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodExit
                        public TypeDescription getThrowable() {
                            return NoExceptionHandler.DESCRIPTION;
                        }
                    }

                    @SuppressFBWarnings(justification = "Assuming annotation for exit advice.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    public ForMethodExit(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Map<String, TypeDefinition> map, Map<String, TypeDefinition> map2, List<? extends OffsetMapping.Factory<?>> list, ClassReader classReader, TypeDefinition typeDefinition) {
                        super(inDefinedShape, postProcessor, CompoundList.of(Arrays.asList(OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE, OffsetMapping.ForAllArguments.Factory.INSTANCE, OffsetMapping.ForThisReference.Factory.INSTANCE, OffsetMapping.ForField.Unresolved.Factory.INSTANCE, OffsetMapping.ForOrigin.Factory.INSTANCE, OffsetMapping.ForUnusedValue.Factory.INSTANCE, OffsetMapping.ForStubValue.INSTANCE, OffsetMapping.ForEnterValue.Factory.of(typeDefinition), OffsetMapping.ForExitValue.Factory.of(inDefinedShape.getReturnType()), new OffsetMapping.ForLocalValue.Factory(map), OffsetMapping.ForReturnValue.Factory.INSTANCE, OffsetMapping.ForThrowable.Factory.of(inDefinedShape)), (List) list), (TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodExit.class).getValue(Advice.SUPPRESS_EXIT).resolve(TypeDescription.class), (TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodExit.class).getValue(Advice.REPEAT_ON).resolve(TypeDescription.class), classReader);
                        this.uninitializedNamedTypes = map2;
                        this.backupArguments = ((Boolean) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodExit.class).getValue(Advice.BACKUP_ARGUMENTS).resolve(Boolean.class)).booleanValue();
                    }

                    private MethodVisitor doApply(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, TypeDescription typeDescription, MethodDescription methodDescription, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation) {
                        HashMap map = new HashMap();
                        for (Map.Entry<Integer, OffsetMapping> entry : this.offsetMappings.entrySet()) {
                            map.put(entry.getKey(), entry.getValue().resolve(typeDescription, methodDescription, assigner, forAdvice, OffsetMapping.Sort.EXIT));
                        }
                        return new CodeTranslationVisitor(methodVisitor, context, forAdvice, forAdvice2, forAdvice3, typeDescription, methodDescription, assigner, this.adviceMethod, map, bound, bound2, stackManipulation, this.postProcessor, true);
                    }

                    @SuppressFBWarnings(justification = "Assuming annotation for exit advice.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    public static Resolved.ForMethodExit of(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Map<String, TypeDefinition> map, Map<String, TypeDefinition> map2, List<? extends OffsetMapping.Factory<?>> list, ClassReader classReader, TypeDefinition typeDefinition) {
                        TypeDescription typeDescription = (TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodExit.class).getValue(Advice.ON_THROWABLE).resolve(TypeDescription.class);
                        return typeDescription.represents(NoExceptionHandler.class) ? new WithoutExceptionHandler(inDefinedShape, postProcessor, map, map2, list, classReader, typeDefinition) : new WithExceptionHandler(inDefinedShape, postProcessor, map, map2, list, classReader, typeDefinition, typeDescription);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Inlining.Resolved
                    public MethodVisitor apply(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, TypeDescription typeDescription, MethodDescription methodDescription, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation) {
                        return doApply(methodVisitor, context, assigner, forInstrumentedMethod.bindExit(this.adviceMethod, getThrowable().represents(NoExceptionHandler.class)), forInstrumentedMethod2.bindExit(this.adviceMethod), forInstrumentedMethod3.bindExit(this.adviceMethod), typeDescription, methodDescription, bound, bound2, stackManipulation);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved
                    public Bound bind(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, StackManipulation stackManipulation, RelocationHandler.Relocation relocation) {
                        return new AdviceMethodInliner(typeDescription, methodDescription, methodVisitor, context, assigner, forInstrumentedMethod, forInstrumentedMethod2, forInstrumentedMethod3, this.suppressionHandler.bind(stackManipulation), this.relocationHandler.bind(methodDescription, relocation), stackManipulation, this.classReader);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.AbstractBase
                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForMethodExit forMethodExit = (ForMethodExit) obj;
                        return this.backupArguments == forMethodExit.backupArguments && this.uninitializedNamedTypes.equals(forMethodExit.uninitializedNamedTypes);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher
                    public TypeDefinition getAdviceType() {
                        return this.adviceMethod.getReturnType();
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodExit
                    public ArgumentHandler.Factory getArgumentHandlerFactory() {
                        return this.backupArguments ? ArgumentHandler.Factory.COPYING : ArgumentHandler.Factory.SIMPLE;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved
                    public Map<String, TypeDefinition> getNamedTypes() {
                        return this.uninitializedNamedTypes;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.AbstractBase
                    public int hashCode() {
                        return ((this.uninitializedNamedTypes.hashCode() + (super.hashCode() * 31)) * 31) + (this.backupArguments ? 1 : 0);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Inlining.Resolved
                    public Map<Integer, TypeDefinition> resolveInitializationTypes(ArgumentHandler argumentHandler) {
                        TreeMap treeMap = new TreeMap();
                        for (Map.Entry<String, TypeDefinition> entry : this.uninitializedNamedTypes.entrySet()) {
                            treeMap.put(Integer.valueOf(argumentHandler.named(entry.getKey())), entry.getValue());
                        }
                        if (!this.adviceMethod.getReturnType().represents(Void.TYPE)) {
                            treeMap.put(Integer.valueOf(argumentHandler.exit()), this.adviceMethod.getReturnType());
                        }
                        return treeMap;
                    }
                }

                public Resolved(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, List<? extends OffsetMapping.Factory<?>> list, TypeDescription typeDescription, TypeDescription typeDescription2, ClassReader classReader) {
                    super(inDefinedShape, postProcessor, list, typeDescription, typeDescription2, OffsetMapping.Factory.AdviceType.INLINING);
                    this.classReader = classReader;
                }

                public abstract MethodVisitor apply(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, TypeDescription typeDescription, MethodDescription methodDescription, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation);

                public abstract Map<Integer, TypeDefinition> resolveInitializationTypes(ArgumentHandler argumentHandler);

                public class AdviceMethodInliner extends ClassVisitor implements Bound {
                    protected final ArgumentHandler.ForInstrumentedMethod argumentHandler;
                    protected final Assigner assigner;
                    protected final ClassReader classReader;
                    protected final StackManipulation exceptionHandler;
                    protected final Implementation.Context implementationContext;
                    protected final MethodDescription instrumentedMethod;
                    protected final TypeDescription instrumentedType;
                    protected final List<Label> labels;
                    protected final MethodSizeHandler.ForInstrumentedMethod methodSizeHandler;
                    protected final MethodVisitor methodVisitor;
                    protected final RelocationHandler.Bound relocationHandler;
                    protected final StackMapFrameHandler.ForInstrumentedMethod stackMapFrameHandler;
                    protected final SuppressionHandler.Bound suppressionHandler;

                    public class ExceptionTableCollector extends MethodVisitor {
                        private final MethodVisitor methodVisitor;

                        public ExceptionTableCollector(MethodVisitor methodVisitor) {
                            super(OpenedClassReader.ASM_API);
                            this.methodVisitor = methodVisitor;
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        @MaybeNull
                        public AnnotationVisitor visitTryCatchAnnotation(int i, @MaybeNull TypePath typePath, String str, boolean z6) {
                            return this.methodVisitor.visitTryCatchAnnotation(i, typePath, str, z6);
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitTryCatchBlock(Label label, Label label2, Label label3, @MaybeNull String str) {
                            this.methodVisitor.visitTryCatchBlock(label, label2, label3, str);
                            AdviceMethodInliner.this.labels.addAll(Arrays.asList(label, label2, label3));
                        }
                    }

                    public class ExceptionTableExtractor extends ClassVisitor {
                        public ExceptionTableExtractor() {
                            super(OpenedClassReader.ASM_API);
                        }

                        @Override // net.bytebuddy.jar.asm.ClassVisitor
                        @MaybeNull
                        public MethodVisitor visitMethod(int i, String str, String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
                            if (!Resolved.this.adviceMethod.getInternalName().equals(str) || !Resolved.this.adviceMethod.getDescriptor().equals(str2)) {
                                return Dispatcher.IGNORE_METHOD;
                            }
                            AdviceMethodInliner adviceMethodInliner = AdviceMethodInliner.this;
                            return adviceMethodInliner.new ExceptionTableCollector(adviceMethodInliner.methodVisitor);
                        }
                    }

                    public AdviceMethodInliner(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, StackManipulation stackManipulation, ClassReader classReader) {
                        super(OpenedClassReader.ASM_API);
                        this.instrumentedType = typeDescription;
                        this.instrumentedMethod = methodDescription;
                        this.methodVisitor = methodVisitor;
                        this.implementationContext = context;
                        this.assigner = assigner;
                        this.argumentHandler = forInstrumentedMethod;
                        this.methodSizeHandler = forInstrumentedMethod2;
                        this.stackMapFrameHandler = forInstrumentedMethod3;
                        this.suppressionHandler = bound;
                        this.relocationHandler = bound2;
                        this.exceptionHandler = stackManipulation;
                        this.classReader = classReader;
                        this.labels = new ArrayList();
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Bound
                    public void apply() {
                        this.classReader.accept(this, this.stackMapFrameHandler.getReaderHint() | 2);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Bound
                    public void initialize() {
                        for (Map.Entry<Integer, TypeDefinition> entry : Resolved.this.resolveInitializationTypes(this.argumentHandler).entrySet()) {
                            if (entry.getValue().represents(Boolean.TYPE) || entry.getValue().represents(Byte.TYPE) || entry.getValue().represents(Short.TYPE) || entry.getValue().represents(Character.TYPE) || entry.getValue().represents(Integer.TYPE)) {
                                this.methodVisitor.visitInsn(3);
                                this.methodVisitor.visitVarInsn(54, entry.getKey().intValue());
                            } else if (entry.getValue().represents(Long.TYPE)) {
                                this.methodVisitor.visitInsn(9);
                                this.methodVisitor.visitVarInsn(55, entry.getKey().intValue());
                            } else if (entry.getValue().represents(Float.TYPE)) {
                                this.methodVisitor.visitInsn(11);
                                this.methodVisitor.visitVarInsn(56, entry.getKey().intValue());
                            } else if (entry.getValue().represents(Double.TYPE)) {
                                this.methodVisitor.visitInsn(14);
                                this.methodVisitor.visitVarInsn(57, entry.getKey().intValue());
                            } else {
                                this.methodVisitor.visitInsn(1);
                                this.methodVisitor.visitVarInsn(58, entry.getKey().intValue());
                            }
                            this.methodSizeHandler.requireStackSize(entry.getValue().getStackSize().getSize());
                        }
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Bound
                    public void prepare() {
                        this.classReader.accept(new ExceptionTableExtractor(), 6);
                        this.suppressionHandler.onPrepare(this.methodVisitor);
                    }

                    @Override // net.bytebuddy.jar.asm.ClassVisitor
                    @MaybeNull
                    public MethodVisitor visitMethod(int i, String str, String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
                        return (Resolved.this.adviceMethod.getInternalName().equals(str) && Resolved.this.adviceMethod.getDescriptor().equals(str2)) ? new ExceptionTableSubstitutor(Resolved.this.apply(this.methodVisitor, this.implementationContext, this.assigner, this.argumentHandler, this.methodSizeHandler, this.stackMapFrameHandler, this.instrumentedType, this.instrumentedMethod, this.suppressionHandler, this.relocationHandler, this.exceptionHandler)) : Dispatcher.IGNORE_METHOD;
                    }

                    public class ExceptionTableSubstitutor extends MethodVisitor {
                        private int index;
                        private final Map<Label, Label> substitutions;

                        public ExceptionTableSubstitutor(MethodVisitor methodVisitor) {
                            super(OpenedClassReader.ASM_API, methodVisitor);
                            this.substitutions = new IdentityHashMap();
                        }

                        private Label[] resolve(Label[] labelArr) {
                            Label[] labelArr2 = new Label[labelArr.length];
                            int length = labelArr.length;
                            int i = 0;
                            int i3 = 0;
                            while (i < length) {
                                labelArr2[i3] = resolve(labelArr[i]);
                                i++;
                                i3++;
                            }
                            return labelArr2;
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitJumpInsn(int i, Label label) {
                            super.visitJumpInsn(i, resolve(label));
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitLabel(Label label) {
                            super.visitLabel(resolve(label));
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
                            super.visitLookupSwitchInsn(resolve(label), iArr, resolve(labelArr));
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitTableSwitchInsn(int i, int i3, Label label, Label... labelArr) {
                            super.visitTableSwitchInsn(i, i3, label, resolve(labelArr));
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        @MaybeNull
                        public AnnotationVisitor visitTryCatchAnnotation(int i, @MaybeNull TypePath typePath, String str, boolean z6) {
                            return Dispatcher.IGNORE_ANNOTATION;
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
                            Map<Label, Label> map = this.substitutions;
                            List<Label> list = AdviceMethodInliner.this.labels;
                            int i = this.index;
                            this.index = i + 1;
                            map.put(label, list.get(i));
                            Map<Label, Label> map2 = this.substitutions;
                            List<Label> list2 = AdviceMethodInliner.this.labels;
                            int i3 = this.index;
                            this.index = i3 + 1;
                            map2.put(label2, list2.get(i3));
                            List<Label> list3 = AdviceMethodInliner.this.labels;
                            int i4 = this.index;
                            this.index = i4 + 1;
                            Label label4 = list3.get(i4);
                            this.substitutions.put(label3, label4);
                            ((CodeTranslationVisitor) this.mv).propagateHandler(label4);
                        }

                        private Label resolve(Label label) {
                            Label label2 = this.substitutions.get(label);
                            return label2 == null ? label : label2;
                        }
                    }
                }
            }

            public Inlining(MethodDescription.InDefinedShape inDefinedShape) {
                String str;
                TypeDefinition typeDefinitionPut;
                this.adviceMethod = inDefinedShape;
                for (ParameterDescription.InDefinedShape inDefinedShape2 : inDefinedShape.getParameters()) {
                    AnnotationDescription.Loadable loadableOfType = inDefinedShape2.getDeclaredAnnotations().ofType(Local.class);
                    if (loadableOfType != null && (typeDefinitionPut = this.namedTypes.put((str = (String) loadableOfType.getValue(OffsetMapping.ForLocalValue.Factory.LOCAL_VALUE).resolve(String.class)), inDefinedShape2.getType())) != null && !typeDefinitionPut.equals(inDefinedShape2.getType())) {
                        throw new IllegalStateException(androidx.constraintlayout.core.motion.a.q("Local variable for ", str, " is defined with inconsistent types"));
                    }
                }
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Unresolved
            public Resolved.ForMethodEnter asMethodEnter(List<? extends OffsetMapping.Factory<?>> list, @MaybeNull ClassReader classReader, Unresolved unresolved, PostProcessor.Factory factory) {
                if (classReader == null) {
                    throw new IllegalStateException("Class reader not expected null");
                }
                MethodDescription.InDefinedShape inDefinedShape = this.adviceMethod;
                return Resolved.ForMethodEnter.of(inDefinedShape, factory.make(inDefinedShape, false), this.namedTypes, list, unresolved.getAdviceType(), classReader, unresolved.isAlive());
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Unresolved
            public Resolved.ForMethodExit asMethodExit(List<? extends OffsetMapping.Factory<?>> list, @MaybeNull ClassReader classReader, Unresolved unresolved, PostProcessor.Factory factory) {
                HashMap map = new HashMap(unresolved.getNamedTypes());
                HashMap map2 = new HashMap();
                for (Map.Entry<String, TypeDefinition> entry : this.namedTypes.entrySet()) {
                    TypeDefinition typeDefinition = (TypeDefinition) map.get(entry.getKey());
                    TypeDefinition typeDefinition2 = (TypeDefinition) map2.get(entry.getKey());
                    if (typeDefinition == null && typeDefinition2 == null) {
                        map.put(entry.getKey(), entry.getValue());
                        map2.put(entry.getKey(), entry.getValue());
                    } else {
                        if (typeDefinition == null) {
                            typeDefinition = typeDefinition2;
                        }
                        if (!typeDefinition.equals(entry.getValue())) {
                            throw new IllegalStateException(b.h(new StringBuilder("Local variable for "), entry.getKey(), " is defined with inconsistent types"));
                        }
                    }
                }
                MethodDescription.InDefinedShape inDefinedShape = this.adviceMethod;
                return Resolved.ForMethodExit.of(inDefinedShape, factory.make(inDefinedShape, true), map, map2, list, classReader, unresolved.getAdviceType());
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Inlining inlining = (Inlining) obj;
                return this.adviceMethod.equals(inlining.adviceMethod) && this.namedTypes.equals(inlining.namedTypes);
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Unresolved
            public Map<String, TypeDefinition> getNamedTypes() {
                return this.namedTypes;
            }

            public int hashCode() {
                return this.namedTypes.hashCode() + ((this.adviceMethod.hashCode() + (getClass().hashCode() * 31)) * 31);
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher
            public boolean isAlive() {
                return true;
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Unresolved
            public boolean isBinary() {
                return true;
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher
            public TypeDescription getAdviceType() {
                return this.adviceMethod.getReturnType().asErasure();
            }
        }

        public interface RelocationHandler {

            public interface Bound {
                public static final int NO_REQUIRED_SIZE = 0;

                int apply(MethodVisitor methodVisitor, int i);
            }

            public enum Disabled implements RelocationHandler, Bound {
                INSTANCE;

                @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.Bound
                public int apply(MethodVisitor methodVisitor, int i) {
                    return 0;
                }

                @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler
                public Bound bind(MethodDescription methodDescription, Relocation relocation) {
                    return this;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForType implements RelocationHandler {
                private final TypeDescription typeDescription;

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class Bound implements Bound {
                    private final MethodDescription instrumentedMethod;
                    private final Relocation relocation;

                    public Bound(MethodDescription methodDescription, Relocation relocation) {
                        this.instrumentedMethod = methodDescription;
                        this.relocation = relocation;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.Bound
                    public int apply(MethodVisitor methodVisitor, int i) {
                        if (this.instrumentedMethod.isConstructor()) {
                            throw new IllegalStateException("Cannot skip code execution from constructor: " + this.instrumentedMethod);
                        }
                        methodVisitor.visitVarInsn(25, i);
                        methodVisitor.visitTypeInsn(193, ForType.this.typeDescription.getInternalName());
                        Label label = new Label();
                        methodVisitor.visitJumpInsn(153, label);
                        this.relocation.apply(methodVisitor);
                        methodVisitor.visitLabel(label);
                        return 0;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Bound bound = (Bound) obj;
                        return this.instrumentedMethod.equals(bound.instrumentedMethod) && this.relocation.equals(bound.relocation) && ForType.this.equals(ForType.this);
                    }

                    public int hashCode() {
                        return ForType.this.hashCode() + ((this.relocation.hashCode() + a.f(this.instrumentedMethod, getClass().hashCode() * 31, 31)) * 31);
                    }
                }

                public ForType(TypeDescription typeDescription) {
                    this.typeDescription = typeDescription;
                }

                public static RelocationHandler of(TypeDescription typeDescription, TypeDefinition typeDefinition) {
                    if (typeDescription.represents(Void.TYPE)) {
                        return Disabled.INSTANCE;
                    }
                    if (typeDescription.represents(OnDefaultValue.class)) {
                        return ForValue.of(typeDefinition, false);
                    }
                    if (typeDescription.represents(OnNonDefaultValue.class)) {
                        return ForValue.of(typeDefinition, true);
                    }
                    if (!typeDescription.isPrimitive() && !typeDefinition.isPrimitive()) {
                        return new ForType(typeDescription);
                    }
                    throw new IllegalStateException("Cannot skip method by instance type for primitive return type " + typeDefinition);
                }

                @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler
                public Bound bind(MethodDescription methodDescription, Relocation relocation) {
                    return new Bound(methodDescription, relocation);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((ForType) obj).typeDescription);
                }

                public int hashCode() {
                    return this.typeDescription.hashCode() + (getClass().hashCode() * 31);
                }
            }

            public enum ForValue implements RelocationHandler {
                INTEGER(21, 154, 153, 0) { // from class: net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue.1
                    @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue
                    public void convertValue(MethodVisitor methodVisitor) {
                    }
                },
                LONG(22, 154, 153, 0) { // from class: net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue.2
                    @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue
                    public void convertValue(MethodVisitor methodVisitor) {
                        methodVisitor.visitInsn(136);
                    }
                },
                FLOAT(23, 154, 153, 2) { // from class: net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue.3
                    @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue
                    public void convertValue(MethodVisitor methodVisitor) {
                        methodVisitor.visitInsn(11);
                        methodVisitor.visitInsn(149);
                    }
                },
                DOUBLE(24, 154, 153, 4) { // from class: net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue.4
                    @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue
                    public void convertValue(MethodVisitor methodVisitor) {
                        methodVisitor.visitInsn(14);
                        methodVisitor.visitInsn(151);
                    }
                },
                REFERENCE(25, 199, 198, 0) { // from class: net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue.5
                    @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue
                    public void convertValue(MethodVisitor methodVisitor) {
                    }
                };

                private final int defaultJump;
                private final int load;
                private final int nonDefaultJump;
                private final int requiredSize;

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class Bound implements Bound {
                    private final MethodDescription instrumentedMethod;
                    private final boolean inverted;
                    private final Relocation relocation;

                    public Bound(MethodDescription methodDescription, Relocation relocation, boolean z6) {
                        this.instrumentedMethod = methodDescription;
                        this.relocation = relocation;
                        this.inverted = z6;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.Bound
                    public int apply(MethodVisitor methodVisitor, int i) {
                        if (this.instrumentedMethod.isConstructor()) {
                            throw new IllegalStateException("Cannot skip code execution from constructor: " + this.instrumentedMethod);
                        }
                        methodVisitor.visitVarInsn(ForValue.this.load, i);
                        ForValue.this.convertValue(methodVisitor);
                        Label label = new Label();
                        methodVisitor.visitJumpInsn(this.inverted ? ForValue.this.nonDefaultJump : ForValue.this.defaultJump, label);
                        this.relocation.apply(methodVisitor);
                        methodVisitor.visitLabel(label);
                        return ForValue.this.requiredSize;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Bound bound = (Bound) obj;
                        return this.inverted == bound.inverted && ForValue.this.equals(ForValue.this) && this.instrumentedMethod.equals(bound.instrumentedMethod) && this.relocation.equals(bound.relocation);
                    }

                    public int hashCode() {
                        return ForValue.this.hashCode() + ((((this.relocation.hashCode() + a.f(this.instrumentedMethod, getClass().hashCode() * 31, 31)) * 31) + (this.inverted ? 1 : 0)) * 31);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class Inverted implements RelocationHandler {
                    public Inverted() {
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler
                    public Bound bind(MethodDescription methodDescription, Relocation relocation) {
                        return ForValue.this.new Bound(methodDescription, relocation, true);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && ForValue.this.equals(ForValue.this);
                    }

                    public int hashCode() {
                        return ForValue.this.hashCode() + (getClass().hashCode() * 31);
                    }
                }

                public static RelocationHandler of(TypeDefinition typeDefinition, boolean z6) {
                    ForValue forValue;
                    if (typeDefinition.represents(Long.TYPE)) {
                        forValue = LONG;
                    } else if (typeDefinition.represents(Float.TYPE)) {
                        forValue = FLOAT;
                    } else if (typeDefinition.represents(Double.TYPE)) {
                        forValue = DOUBLE;
                    } else {
                        if (typeDefinition.represents(Void.TYPE)) {
                            throw new IllegalStateException("Cannot skip on default value for void return type");
                        }
                        forValue = typeDefinition.isPrimitive() ? INTEGER : REFERENCE;
                    }
                    if (!z6) {
                        return forValue;
                    }
                    forValue.getClass();
                    return forValue.new Inverted();
                }

                @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler
                public Bound bind(MethodDescription methodDescription, Relocation relocation) {
                    return new Bound(methodDescription, relocation, false);
                }

                public abstract void convertValue(MethodVisitor methodVisitor);

                ForValue(int i, int i3, int i4, int i5) {
                    this.load = i;
                    this.defaultJump = i3;
                    this.nonDefaultJump = i4;
                    this.requiredSize = i5;
                }
            }

            public interface Relocation {

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForLabel implements Relocation {
                    private final Label label;

                    public ForLabel(Label label) {
                        this.label = label;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.Relocation
                    public void apply(MethodVisitor methodVisitor) {
                        methodVisitor.visitJumpInsn(167, this.label);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.label.equals(((ForLabel) obj).label);
                    }

                    public int hashCode() {
                        return this.label.hashCode() + (getClass().hashCode() * 31);
                    }
                }

                void apply(MethodVisitor methodVisitor);
            }

            Bound bind(MethodDescription methodDescription, Relocation relocation);
        }

        public interface Resolved extends Dispatcher {

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class AbstractBase implements Resolved {
                protected final MethodDescription.InDefinedShape adviceMethod;
                protected final Map<Integer, OffsetMapping> offsetMappings;
                protected final PostProcessor postProcessor;
                protected final RelocationHandler relocationHandler;
                protected final SuppressionHandler suppressionHandler;

                public AbstractBase(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, List<? extends OffsetMapping.Factory<?>> list, TypeDescription typeDescription, TypeDescription typeDescription2, OffsetMapping.Factory.AdviceType adviceType) {
                    this.adviceMethod = inDefinedShape;
                    this.postProcessor = postProcessor;
                    HashMap map = new HashMap();
                    for (OffsetMapping.Factory<?> factory : list) {
                        map.put(TypeDescription.ForLoadedType.of(factory.getAnnotationType()), factory);
                    }
                    this.offsetMappings = new LinkedHashMap();
                    for (ParameterDescription.InDefinedShape inDefinedShape2 : inDefinedShape.getParameters()) {
                        OffsetMapping unresolved = null;
                        for (AnnotationDescription annotationDescription : inDefinedShape2.getDeclaredAnnotations()) {
                            OffsetMapping.Factory factory2 = (OffsetMapping.Factory) map.get(annotationDescription.getAnnotationType());
                            if (factory2 != null) {
                                OffsetMapping offsetMappingMake = factory2.make(inDefinedShape2, annotationDescription.prepare(factory2.getAnnotationType()), adviceType);
                                if (unresolved != null) {
                                    throw new IllegalStateException(inDefinedShape2 + " is bound to both " + offsetMappingMake + " and " + unresolved);
                                }
                                unresolved = offsetMappingMake;
                            }
                        }
                        Map<Integer, OffsetMapping> map2 = this.offsetMappings;
                        Integer numValueOf = Integer.valueOf(inDefinedShape2.getOffset());
                        if (unresolved == null) {
                            unresolved = new OffsetMapping.ForArgument.Unresolved(inDefinedShape2);
                        }
                        map2.put(numValueOf, unresolved);
                    }
                    this.suppressionHandler = SuppressionHandler.Suppressing.of(typeDescription);
                    this.relocationHandler = RelocationHandler.ForType.of(typeDescription2, inDefinedShape.getReturnType());
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    AbstractBase abstractBase = (AbstractBase) obj;
                    return this.adviceMethod.equals(abstractBase.adviceMethod) && this.postProcessor.equals(abstractBase.postProcessor) && this.offsetMappings.equals(abstractBase.offsetMappings) && this.suppressionHandler.equals(abstractBase.suppressionHandler) && this.relocationHandler.equals(abstractBase.relocationHandler);
                }

                public int hashCode() {
                    return this.relocationHandler.hashCode() + ((this.suppressionHandler.hashCode() + ((this.offsetMappings.hashCode() + ((this.postProcessor.hashCode() + ((this.adviceMethod.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31)) * 31)) * 31);
                }

                @Override // net.bytebuddy.asm.Advice.Dispatcher
                public boolean isAlive() {
                    return true;
                }
            }

            public interface ForMethodEnter extends Resolved {
                TypeDefinition getActualAdviceType();

                boolean isPrependLineNumber();
            }

            public interface ForMethodExit extends Resolved {
                ArgumentHandler.Factory getArgumentHandlerFactory();

                TypeDescription getThrowable();
            }

            Bound bind(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, StackManipulation stackManipulation, RelocationHandler.Relocation relocation);

            Map<String, TypeDefinition> getNamedTypes();
        }

        public interface SuppressionHandler {

            public interface Bound {
                void onEnd(MethodVisitor methodVisitor, Implementation.Context context, MethodSizeHandler.ForAdvice forAdvice, StackMapFrameHandler.ForAdvice forAdvice2, TypeDefinition typeDefinition);

                void onEndWithSkip(MethodVisitor methodVisitor, Implementation.Context context, MethodSizeHandler.ForAdvice forAdvice, StackMapFrameHandler.ForAdvice forAdvice2, TypeDefinition typeDefinition);

                void onPrepare(MethodVisitor methodVisitor);

                void onStart(MethodVisitor methodVisitor);
            }

            public enum NoOp implements SuppressionHandler, Bound {
                INSTANCE;

                @Override // net.bytebuddy.asm.Advice.Dispatcher.SuppressionHandler
                public Bound bind(StackManipulation stackManipulation) {
                    return this;
                }

                @Override // net.bytebuddy.asm.Advice.Dispatcher.SuppressionHandler.Bound
                public void onEnd(MethodVisitor methodVisitor, Implementation.Context context, MethodSizeHandler.ForAdvice forAdvice, StackMapFrameHandler.ForAdvice forAdvice2, TypeDefinition typeDefinition) {
                }

                @Override // net.bytebuddy.asm.Advice.Dispatcher.SuppressionHandler.Bound
                public void onEndWithSkip(MethodVisitor methodVisitor, Implementation.Context context, MethodSizeHandler.ForAdvice forAdvice, StackMapFrameHandler.ForAdvice forAdvice2, TypeDefinition typeDefinition) {
                }

                @Override // net.bytebuddy.asm.Advice.Dispatcher.SuppressionHandler.Bound
                public void onPrepare(MethodVisitor methodVisitor) {
                }

                @Override // net.bytebuddy.asm.Advice.Dispatcher.SuppressionHandler.Bound
                public void onStart(MethodVisitor methodVisitor) {
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Suppressing implements SuppressionHandler {
                private final TypeDescription suppressedType;

                public static class Bound implements Bound {
                    private final StackManipulation exceptionHandler;
                    private final TypeDescription suppressedType;
                    private final Label startOfMethod = new Label();
                    private final Label endOfMethod = new Label();

                    public Bound(TypeDescription typeDescription, StackManipulation stackManipulation) {
                        this.suppressedType = typeDescription;
                        this.exceptionHandler = stackManipulation;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.SuppressionHandler.Bound
                    public void onEnd(MethodVisitor methodVisitor, Implementation.Context context, MethodSizeHandler.ForAdvice forAdvice, StackMapFrameHandler.ForAdvice forAdvice2, TypeDefinition typeDefinition) {
                        methodVisitor.visitLabel(this.endOfMethod);
                        forAdvice2.injectExceptionFrame(methodVisitor);
                        forAdvice.requireStackSize(this.exceptionHandler.apply(methodVisitor, context).getMaximalSize() + 1);
                        if (typeDefinition.represents(Boolean.TYPE) || typeDefinition.represents(Byte.TYPE) || typeDefinition.represents(Short.TYPE) || typeDefinition.represents(Character.TYPE) || typeDefinition.represents(Integer.TYPE)) {
                            methodVisitor.visitInsn(3);
                            return;
                        }
                        if (typeDefinition.represents(Long.TYPE)) {
                            methodVisitor.visitInsn(9);
                            return;
                        }
                        if (typeDefinition.represents(Float.TYPE)) {
                            methodVisitor.visitInsn(11);
                        } else if (typeDefinition.represents(Double.TYPE)) {
                            methodVisitor.visitInsn(14);
                        } else {
                            if (typeDefinition.represents(Void.TYPE)) {
                                return;
                            }
                            methodVisitor.visitInsn(1);
                        }
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.SuppressionHandler.Bound
                    public void onEndWithSkip(MethodVisitor methodVisitor, Implementation.Context context, MethodSizeHandler.ForAdvice forAdvice, StackMapFrameHandler.ForAdvice forAdvice2, TypeDefinition typeDefinition) {
                        Label label = new Label();
                        methodVisitor.visitJumpInsn(167, label);
                        onEnd(methodVisitor, context, forAdvice, forAdvice2, typeDefinition);
                        methodVisitor.visitLabel(label);
                        forAdvice2.injectReturnFrame(methodVisitor);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.SuppressionHandler.Bound
                    public void onPrepare(MethodVisitor methodVisitor) {
                        Label label = this.startOfMethod;
                        Label label2 = this.endOfMethod;
                        methodVisitor.visitTryCatchBlock(label, label2, label2, this.suppressedType.getInternalName());
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.SuppressionHandler.Bound
                    public void onStart(MethodVisitor methodVisitor) {
                        methodVisitor.visitLabel(this.startOfMethod);
                    }
                }

                public Suppressing(TypeDescription typeDescription) {
                    this.suppressedType = typeDescription;
                }

                public static SuppressionHandler of(TypeDescription typeDescription) {
                    return typeDescription.represents(NoExceptionHandler.class) ? NoOp.INSTANCE : new Suppressing(typeDescription);
                }

                @Override // net.bytebuddy.asm.Advice.Dispatcher.SuppressionHandler
                public Bound bind(StackManipulation stackManipulation) {
                    return new Bound(this.suppressedType, stackManipulation);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.suppressedType.equals(((Suppressing) obj).suppressedType);
                }

                public int hashCode() {
                    return this.suppressedType.hashCode() + (getClass().hashCode() * 31);
                }
            }

            Bound bind(StackManipulation stackManipulation);
        }

        public interface Unresolved extends Dispatcher {
            Resolved.ForMethodEnter asMethodEnter(List<? extends OffsetMapping.Factory<?>> list, @MaybeNull ClassReader classReader, Unresolved unresolved, PostProcessor.Factory factory);

            Resolved.ForMethodExit asMethodExit(List<? extends OffsetMapping.Factory<?>> list, @MaybeNull ClassReader classReader, Unresolved unresolved, PostProcessor.Factory factory);

            Map<String, TypeDefinition> getNamedTypes();

            boolean isBinary();
        }

        TypeDefinition getAdviceType();

        boolean isAlive();
    }

    @Target({ElementType.PARAMETER})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Enter {
        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;
    }

    public interface ExceptionHandler {

        public enum Default implements ExceptionHandler {
            SUPPRESSING { // from class: net.bytebuddy.asm.Advice.ExceptionHandler.Default.1
                @Override // net.bytebuddy.asm.Advice.ExceptionHandler
                public StackManipulation resolve(MethodDescription methodDescription, TypeDescription typeDescription) {
                    return Removal.SINGLE;
                }
            },
            PRINTING { // from class: net.bytebuddy.asm.Advice.ExceptionHandler.Default.2
                @Override // net.bytebuddy.asm.Advice.ExceptionHandler
                public StackManipulation resolve(MethodDescription methodDescription, TypeDescription typeDescription) {
                    try {
                        return MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(Throwable.class.getMethod("printStackTrace", new Class[0])));
                    } catch (NoSuchMethodException unused) {
                        throw new IllegalStateException("Cannot locate Throwable::printStackTrace");
                    }
                }
            },
            RETHROWING { // from class: net.bytebuddy.asm.Advice.ExceptionHandler.Default.3
                @Override // net.bytebuddy.asm.Advice.ExceptionHandler
                public StackManipulation resolve(MethodDescription methodDescription, TypeDescription typeDescription) {
                    return Throw.INSTANCE;
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Simple implements ExceptionHandler {
            private final StackManipulation stackManipulation;

            public Simple(StackManipulation stackManipulation) {
                this.stackManipulation = stackManipulation;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.stackManipulation.equals(((Simple) obj).stackManipulation);
            }

            public int hashCode() {
                return this.stackManipulation.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.asm.Advice.ExceptionHandler
            public StackManipulation resolve(MethodDescription methodDescription, TypeDescription typeDescription) {
                return this.stackManipulation;
            }
        }

        StackManipulation resolve(MethodDescription methodDescription, TypeDescription typeDescription);
    }

    @Target({ElementType.PARAMETER})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Exit {
        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;
    }

    @Target({ElementType.PARAMETER})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FieldValue {
        Class<?> declaringType() default void.class;

        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;

        String value() default "";
    }

    @Target({ElementType.PARAMETER})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Local {
        String value();
    }

    public interface MethodSizeHandler {
        public static final int UNDEFINED_SIZE = 32767;

        public static abstract class Default implements ForInstrumentedMethod {
            protected final List<? extends TypeDescription> initialTypes;
            protected final MethodDescription instrumentedMethod;
            protected int localVariableLength;
            protected final List<? extends TypeDescription> postMethodTypes;
            protected final List<? extends TypeDescription> preMethodTypes;
            protected int stackSize;

            public class ForAdvice implements ForAdvice {
                private final MethodDescription.InDefinedShape adviceMethod;
                private final int baseLocalVariableLength;
                private int localVariableLengthPadding;
                private int stackSizePadding;

                public ForAdvice(MethodDescription.InDefinedShape inDefinedShape, int i) {
                    this.adviceMethod = inDefinedShape;
                    this.baseLocalVariableLength = i;
                }

                @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForAdvice
                public void recordMaxima(int i, int i3) {
                    Default.this.requireStackSize(i + this.stackSizePadding);
                    Default.this.requireLocalVariableLength((i3 - this.adviceMethod.getStackSize()) + this.baseLocalVariableLength + this.localVariableLengthPadding);
                }

                @Override // net.bytebuddy.asm.Advice.MethodSizeHandler
                public void requireLocalVariableLength(int i) {
                    Default.this.requireLocalVariableLength(i);
                }

                @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForAdvice
                public void requireLocalVariableLengthPadding(int i) {
                    this.localVariableLengthPadding = Math.max(this.localVariableLengthPadding, i);
                }

                @Override // net.bytebuddy.asm.Advice.MethodSizeHandler
                public void requireStackSize(int i) {
                    Default.this.requireStackSize(i);
                }

                @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForAdvice
                public void requireStackSizePadding(int i) {
                    this.stackSizePadding = Math.max(this.stackSizePadding, i);
                }
            }

            public static class WithCopiedArguments extends Default {
                public WithCopiedArguments(MethodDescription methodDescription, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3) {
                    super(methodDescription, list, list2, list3);
                }

                @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForInstrumentedMethod
                public ForAdvice bindExit(MethodDescription.InDefinedShape inDefinedShape) {
                    return new ForAdvice(inDefinedShape, StackSize.of(this.postMethodTypes) + StackSize.of(this.preMethodTypes) + StackSize.of(this.initialTypes) + (this.instrumentedMethod.getStackSize() * 2));
                }

                @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.Default, net.bytebuddy.asm.Advice.MethodSizeHandler.ForInstrumentedMethod
                public int compoundLocalVariableLength(int i) {
                    return Math.max(this.localVariableLength, StackSize.of(this.preMethodTypes) + StackSize.of(this.initialTypes) + StackSize.of(this.postMethodTypes) + this.instrumentedMethod.getStackSize() + i);
                }
            }

            public static class WithRetainedArguments extends Default {
                public WithRetainedArguments(MethodDescription methodDescription, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3) {
                    super(methodDescription, list, list2, list3);
                }

                @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForInstrumentedMethod
                public ForAdvice bindExit(MethodDescription.InDefinedShape inDefinedShape) {
                    return new ForAdvice(inDefinedShape, StackSize.of(this.preMethodTypes) + StackSize.of(this.initialTypes) + StackSize.of(this.postMethodTypes) + this.instrumentedMethod.getStackSize());
                }

                @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.Default, net.bytebuddy.asm.Advice.MethodSizeHandler.ForInstrumentedMethod
                public int compoundLocalVariableLength(int i) {
                    return Math.max(this.localVariableLength, StackSize.of(this.preMethodTypes) + StackSize.of(this.initialTypes) + StackSize.of(this.postMethodTypes) + i);
                }
            }

            public Default(MethodDescription methodDescription, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3) {
                this.instrumentedMethod = methodDescription;
                this.initialTypes = list;
                this.preMethodTypes = list2;
                this.postMethodTypes = list3;
            }

            public static ForInstrumentedMethod of(MethodDescription methodDescription, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3, boolean z6, int i) {
                return (i & 3) != 0 ? NoOp.INSTANCE : z6 ? new WithCopiedArguments(methodDescription, list, list2, list3) : new WithRetainedArguments(methodDescription, list, list2, list3);
            }

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForInstrumentedMethod
            public ForAdvice bindEnter(MethodDescription.InDefinedShape inDefinedShape) {
                return new ForAdvice(inDefinedShape, StackSize.of(this.initialTypes) + this.instrumentedMethod.getStackSize());
            }

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForInstrumentedMethod
            public int compoundLocalVariableLength(int i) {
                return Math.max(this.localVariableLength, StackSize.of(this.preMethodTypes) + StackSize.of(this.initialTypes) + StackSize.of(this.postMethodTypes) + i);
            }

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForInstrumentedMethod
            public int compoundStackSize(int i) {
                return Math.max(this.stackSize, i);
            }

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler
            public void requireLocalVariableLength(int i) {
                this.localVariableLength = Math.max(this.localVariableLength, i);
            }

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler
            public void requireStackSize(int i) {
                this.stackSize = Math.max(this.stackSize, i);
            }
        }

        public interface ForAdvice extends MethodSizeHandler {
            void recordMaxima(int i, int i3);

            void requireLocalVariableLengthPadding(int i);

            void requireStackSizePadding(int i);
        }

        public interface ForInstrumentedMethod extends MethodSizeHandler {
            ForAdvice bindEnter(MethodDescription.InDefinedShape inDefinedShape);

            ForAdvice bindExit(MethodDescription.InDefinedShape inDefinedShape);

            int compoundLocalVariableLength(int i);

            int compoundStackSize(int i);
        }

        public enum NoOp implements ForInstrumentedMethod, ForAdvice {
            INSTANCE;

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForInstrumentedMethod
            public ForAdvice bindEnter(MethodDescription.InDefinedShape inDefinedShape) {
                return this;
            }

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForInstrumentedMethod
            public ForAdvice bindExit(MethodDescription.InDefinedShape inDefinedShape) {
                return this;
            }

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForInstrumentedMethod
            public int compoundLocalVariableLength(int i) {
                return MethodSizeHandler.UNDEFINED_SIZE;
            }

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForInstrumentedMethod
            public int compoundStackSize(int i) {
                return MethodSizeHandler.UNDEFINED_SIZE;
            }

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForAdvice
            public void recordMaxima(int i, int i3) {
            }

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler
            public void requireLocalVariableLength(int i) {
            }

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForAdvice
            public void requireLocalVariableLengthPadding(int i) {
            }

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler
            public void requireStackSize(int i) {
            }

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForAdvice
            public void requireStackSizePadding(int i) {
            }
        }

        void requireLocalVariableLength(int i);

        void requireStackSize(int i);
    }

    public static class NoExceptionHandler extends Throwable {
        private static final TypeDescription DESCRIPTION = TypeDescription.ForLoadedType.of(NoExceptionHandler.class);
        private static final long serialVersionUID = 1;

        private NoExceptionHandler() {
            throw new UnsupportedOperationException("This class only serves as a marker type and should not be instantiated");
        }
    }

    public static final class OnDefaultValue {
        private OnDefaultValue() {
            throw new UnsupportedOperationException("This class only serves as a marker type and should not be instantiated");
        }
    }

    @Target({ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface OnMethodEnter {
        boolean inline() default true;

        boolean prependLineNumber() default true;

        Class<?> skipOn() default void.class;

        Class<? extends Throwable> suppress() default NoExceptionHandler.class;
    }

    @Target({ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface OnMethodExit {
        boolean backupArguments() default true;

        boolean inline() default true;

        Class<? extends Throwable> onThrowable() default NoExceptionHandler.class;

        Class<?> repeatOn() default void.class;

        Class<? extends Throwable> suppress() default NoExceptionHandler.class;
    }

    public static final class OnNonDefaultValue {
        private OnNonDefaultValue() {
            throw new UnsupportedOperationException("This class only serves as a marker type and should not be instantiated");
        }
    }

    @Target({ElementType.PARAMETER})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Origin {
        public static final String DEFAULT = "";

        String value() default "";
    }

    public interface PostProcessor {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Compound implements PostProcessor {
            private final List<PostProcessor> postProcessors;

            public Compound(List<PostProcessor> list) {
                this.postProcessors = list;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.postProcessors.equals(((Compound) obj).postProcessors);
            }

            public int hashCode() {
                return this.postProcessors.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.asm.Advice.PostProcessor
            public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, StackMapFrameHandler.ForPostProcessor forPostProcessor, StackManipulation stackManipulation) {
                ArrayList arrayList = new ArrayList(this.postProcessors.size());
                Iterator<PostProcessor> it = this.postProcessors.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().resolve(typeDescription, methodDescription, assigner, argumentHandler, forPostProcessor, stackManipulation));
                }
                return new StackManipulation.Compound(arrayList);
            }
        }

        public interface Factory {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Compound implements Factory {
                private final List<Factory> factories;

                public Compound(Factory... factoryArr) {
                    this((List<? extends Factory>) Arrays.asList(factoryArr));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.factories.equals(((Compound) obj).factories);
                }

                public int hashCode() {
                    return this.factories.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.asm.Advice.PostProcessor.Factory
                public PostProcessor make(MethodDescription.InDefinedShape inDefinedShape, boolean z6) {
                    ArrayList arrayList = new ArrayList(this.factories.size());
                    Iterator<Factory> it = this.factories.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().make(inDefinedShape, z6));
                    }
                    return new Compound(arrayList);
                }

                public Compound(List<? extends Factory> list) {
                    this.factories = new ArrayList();
                    for (Factory factory : list) {
                        if (factory instanceof Compound) {
                            this.factories.addAll(((Compound) factory).factories);
                        } else if (!(factory instanceof NoOp)) {
                            this.factories.add(factory);
                        }
                    }
                }
            }

            PostProcessor make(MethodDescription.InDefinedShape inDefinedShape, boolean z6);
        }

        public enum NoOp implements PostProcessor, Factory {
            INSTANCE;

            @Override // net.bytebuddy.asm.Advice.PostProcessor.Factory
            public PostProcessor make(MethodDescription.InDefinedShape inDefinedShape, boolean z6) {
                return this;
            }

            @Override // net.bytebuddy.asm.Advice.PostProcessor
            public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, StackMapFrameHandler.ForPostProcessor forPostProcessor, StackManipulation stackManipulation) {
                return StackManipulation.Trivial.INSTANCE;
            }
        }

        StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, StackMapFrameHandler.ForPostProcessor forPostProcessor, StackManipulation stackManipulation);
    }

    @Target({ElementType.PARAMETER})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Return {
        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;
    }

    public interface StackMapFrameHandler {

        public static abstract class Default implements ForInstrumentedMethod {
            protected static final Object[] EMPTY = new Object[0];
            protected int currentFrameDivergence;
            protected final boolean expandFrames;
            protected final List<? extends TypeDescription> initialTypes;
            protected final MethodDescription instrumentedMethod;
            protected final TypeDescription instrumentedType;
            protected final List<? extends TypeDescription> latentTypes;
            protected final List<? extends TypeDescription> postMethodTypes;
            protected final List<? extends TypeDescription> preMethodTypes;

            public class ForAdvice implements ForAdvice {
                protected final MethodDescription.InDefinedShape adviceMethod;
                protected final List<? extends TypeDescription> endTypes;
                private final Initialization initialization;
                private boolean intermedate = false;
                private final List<? extends TypeDescription> intermediateTypes;
                protected final List<? extends TypeDescription> startTypes;
                protected final TranslationMode translationMode;

                public ForAdvice(MethodDescription.InDefinedShape inDefinedShape, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3, TranslationMode translationMode, Initialization initialization) {
                    this.adviceMethod = inDefinedShape;
                    this.startTypes = list;
                    this.intermediateTypes = list2;
                    this.endTypes = list3;
                    this.translationMode = translationMode;
                    this.initialization = initialization;
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
                public void injectCompletionFrame(MethodVisitor methodVisitor) {
                    Default r02 = Default.this;
                    if (r02.expandFrames) {
                        r02.injectFullFrame(methodVisitor, this.initialization, CompoundList.of((List) this.startTypes, (List) this.endTypes), Collections.EMPTY_LIST);
                        return;
                    }
                    int i = 0;
                    if (r02.currentFrameDivergence != 0 || (!this.intermedate && this.endTypes.size() >= 4)) {
                        if (Default.this.currentFrameDivergence >= 3 || !this.endTypes.isEmpty()) {
                            Default.this.injectFullFrame(methodVisitor, this.initialization, CompoundList.of((List) this.startTypes, (List) this.endTypes), Collections.EMPTY_LIST);
                            return;
                        }
                        int i3 = Default.this.currentFrameDivergence;
                        Object[] objArr = Default.EMPTY;
                        methodVisitor.visitFrame(2, i3, objArr, objArr.length, objArr);
                        Default.this.currentFrameDivergence = 0;
                        return;
                    }
                    if (this.intermedate || this.endTypes.isEmpty()) {
                        Object[] objArr2 = Default.EMPTY;
                        methodVisitor.visitFrame(3, objArr2.length, objArr2, objArr2.length, objArr2);
                        return;
                    }
                    int size = this.endTypes.size();
                    Object[] objArr3 = new Object[size];
                    Iterator<? extends TypeDescription> it = this.endTypes.iterator();
                    while (it.hasNext()) {
                        objArr3[i] = Initialization.INITIALIZED.toFrame(it.next());
                        i++;
                    }
                    Object[] objArr4 = Default.EMPTY;
                    methodVisitor.visitFrame(1, size, objArr3, objArr4.length, objArr4);
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
                public void injectExceptionFrame(MethodVisitor methodVisitor) {
                    Default r02 = Default.this;
                    if (r02.expandFrames || r02.currentFrameDivergence != 0) {
                        r02.injectFullFrame(methodVisitor, this.initialization, this.startTypes, Collections.singletonList(TypeDescription.ForLoadedType.of(Throwable.class)));
                    } else {
                        Object[] objArr = Default.EMPTY;
                        methodVisitor.visitFrame(4, objArr.length, objArr, 1, new Object[]{Type.getInternalName(Throwable.class)});
                    }
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForPostProcessor
                public void injectIntermediateFrame(MethodVisitor methodVisitor, List<? extends TypeDescription> list) {
                    Default r22 = Default.this;
                    if (r22.expandFrames) {
                        r22.injectFullFrame(methodVisitor, this.initialization, CompoundList.of((List) this.startTypes, (List) this.intermediateTypes), list);
                    } else {
                        int i = 0;
                        if (!this.intermedate || list.size() >= 2) {
                            if (Default.this.currentFrameDivergence != 0 || this.intermediateTypes.size() >= 4 || (!list.isEmpty() && (list.size() >= 2 || !this.intermediateTypes.isEmpty()))) {
                                if (Default.this.currentFrameDivergence < 3 && this.intermediateTypes.isEmpty() && list.isEmpty()) {
                                    int i3 = Default.this.currentFrameDivergence;
                                    Object[] objArr = Default.EMPTY;
                                    methodVisitor.visitFrame(2, i3, objArr, objArr.length, objArr);
                                } else {
                                    Default.this.injectFullFrame(methodVisitor, this.initialization, CompoundList.of((List) this.startTypes, (List) this.intermediateTypes), list);
                                }
                            } else if (!this.intermediateTypes.isEmpty()) {
                                int size = this.intermediateTypes.size();
                                Object[] objArr2 = new Object[size];
                                Iterator<? extends TypeDescription> it = this.intermediateTypes.iterator();
                                while (it.hasNext()) {
                                    objArr2[i] = Initialization.INITIALIZED.toFrame(it.next());
                                    i++;
                                }
                                Object[] objArr3 = Default.EMPTY;
                                methodVisitor.visitFrame(1, size, objArr2, objArr3.length, objArr3);
                            } else if (list.isEmpty()) {
                                Object[] objArr4 = Default.EMPTY;
                                methodVisitor.visitFrame(3, objArr4.length, objArr4, objArr4.length, objArr4);
                            } else {
                                Object[] objArr5 = Default.EMPTY;
                                methodVisitor.visitFrame(4, objArr5.length, objArr5, 1, new Object[]{Initialization.INITIALIZED.toFrame(list.get(0))});
                            }
                        } else if (list.isEmpty()) {
                            Object[] objArr6 = Default.EMPTY;
                            methodVisitor.visitFrame(3, objArr6.length, objArr6, objArr6.length, objArr6);
                        } else {
                            Object[] objArr7 = Default.EMPTY;
                            methodVisitor.visitFrame(4, objArr7.length, objArr7, 1, new Object[]{Initialization.INITIALIZED.toFrame(list.get(0))});
                        }
                    }
                    Default.this.currentFrameDivergence = this.intermediateTypes.size() - this.endTypes.size();
                    this.intermedate = true;
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
                public void injectReturnFrame(MethodVisitor methodVisitor) {
                    Default r02 = Default.this;
                    boolean z6 = r02.expandFrames;
                    Class cls = Void.TYPE;
                    if (z6 || r02.currentFrameDivergence != 0) {
                        r02.injectFullFrame(methodVisitor, this.initialization, this.startTypes, this.adviceMethod.getReturnType().represents(cls) ? Collections.EMPTY_LIST : Collections.singletonList(this.adviceMethod.getReturnType().asErasure()));
                    } else if (this.adviceMethod.getReturnType().represents(cls)) {
                        Object[] objArr = Default.EMPTY;
                        methodVisitor.visitFrame(3, objArr.length, objArr, objArr.length, objArr);
                    } else {
                        Object[] objArr2 = Default.EMPTY;
                        methodVisitor.visitFrame(4, objArr2.length, objArr2, 1, new Object[]{Initialization.INITIALIZED.toFrame(this.adviceMethod.getReturnType().asErasure())});
                    }
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
                public void translateFrame(MethodVisitor methodVisitor, int i, int i3, @MaybeNull Object[] objArr, int i4, @MaybeNull Object[] objArr2) {
                    Default.this.translateFrame(methodVisitor, this.translationMode, this.adviceMethod, this.startTypes, i, i3, objArr, i4, objArr2);
                }
            }

            public enum Initialization {
                UNITIALIZED { // from class: net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.Initialization.1
                    @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.Initialization
                    public Object toFrame(TypeDescription typeDescription) {
                        if (typeDescription.isPrimitive()) {
                            throw new IllegalArgumentException(a.m("Cannot assume primitive uninitialized value: ", typeDescription));
                        }
                        return Opcodes.UNINITIALIZED_THIS;
                    }
                },
                INITIALIZED { // from class: net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.Initialization.2
                    @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.Initialization
                    public Object toFrame(TypeDescription typeDescription) {
                        return (typeDescription.represents(Boolean.TYPE) || typeDescription.represents(Byte.TYPE) || typeDescription.represents(Short.TYPE) || typeDescription.represents(Character.TYPE) || typeDescription.represents(Integer.TYPE)) ? Opcodes.INTEGER : typeDescription.represents(Long.TYPE) ? Opcodes.LONG : typeDescription.represents(Float.TYPE) ? Opcodes.FLOAT : typeDescription.represents(Double.TYPE) ? Opcodes.DOUBLE : typeDescription.getInternalName();
                    }
                };

                public abstract Object toFrame(TypeDescription typeDescription);
            }

            public enum TranslationMode {
                COPY { // from class: net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.TranslationMode.1
                    @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.TranslationMode
                    public int copy(TypeDescription typeDescription, MethodDescription methodDescription, MethodDescription methodDescription2, Object[] objArr, Object[] objArr2) {
                        int size = methodDescription.getParameters().size() + (!methodDescription.isStatic() ? 1 : 0);
                        System.arraycopy(objArr, 0, objArr2, 0, size);
                        return size;
                    }

                    @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.TranslationMode
                    public boolean isPossibleThisFrameValue(TypeDescription typeDescription, MethodDescription methodDescription, Object obj) {
                        return (methodDescription.isConstructor() && Opcodes.UNINITIALIZED_THIS.equals(obj)) || Initialization.INITIALIZED.toFrame(typeDescription).equals(obj);
                    }
                },
                ENTER { // from class: net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.TranslationMode.2
                    @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.TranslationMode
                    public int copy(TypeDescription typeDescription, MethodDescription methodDescription, MethodDescription methodDescription2, Object[] objArr, Object[] objArr2) {
                        int i = 0;
                        if (!methodDescription.isStatic()) {
                            objArr2[0] = methodDescription.isConstructor() ? Opcodes.UNINITIALIZED_THIS : Initialization.INITIALIZED.toFrame(typeDescription);
                            i = 1;
                        }
                        Iterator<TypeDescription> it = methodDescription.getParameters().asTypeList().asErasures().iterator();
                        while (it.hasNext()) {
                            objArr2[i] = Initialization.INITIALIZED.toFrame(it.next());
                            i++;
                        }
                        return i;
                    }

                    @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.TranslationMode
                    public boolean isPossibleThisFrameValue(TypeDescription typeDescription, MethodDescription methodDescription, Object obj) {
                        return methodDescription.isConstructor() ? Opcodes.UNINITIALIZED_THIS.equals(obj) : Initialization.INITIALIZED.toFrame(typeDescription).equals(obj);
                    }
                },
                EXIT { // from class: net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.TranslationMode.3
                    @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.TranslationMode
                    public int copy(TypeDescription typeDescription, MethodDescription methodDescription, MethodDescription methodDescription2, Object[] objArr, Object[] objArr2) {
                        int i = 0;
                        if (!methodDescription.isStatic()) {
                            objArr2[0] = Initialization.INITIALIZED.toFrame(typeDescription);
                            i = 1;
                        }
                        Iterator<TypeDescription> it = methodDescription.getParameters().asTypeList().asErasures().iterator();
                        while (it.hasNext()) {
                            objArr2[i] = Initialization.INITIALIZED.toFrame(it.next());
                            i++;
                        }
                        return i;
                    }

                    @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.TranslationMode
                    public boolean isPossibleThisFrameValue(TypeDescription typeDescription, MethodDescription methodDescription, Object obj) {
                        return Initialization.INITIALIZED.toFrame(typeDescription).equals(obj);
                    }
                };

                public abstract int copy(TypeDescription typeDescription, MethodDescription methodDescription, MethodDescription methodDescription2, Object[] objArr, Object[] objArr2);

                public abstract boolean isPossibleThisFrameValue(TypeDescription typeDescription, MethodDescription methodDescription, Object obj);
            }

            public static class Trivial extends Default {
                /* JADX WARN: Illegal instructions before constructor call */
                public Trivial(TypeDescription typeDescription, MethodDescription methodDescription, List<? extends TypeDescription> list, boolean z6) {
                    List list2 = Collections.EMPTY_LIST;
                    super(typeDescription, methodDescription, list2, list, list2, list2, z6);
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
                public ForAdvice bindExit(MethodDescription.InDefinedShape inDefinedShape) {
                    throw new IllegalStateException("Did not expect exit advice " + inDefinedShape + " for " + this.instrumentedMethod);
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
                public void injectCompletionFrame(MethodVisitor methodVisitor) {
                    throw new IllegalStateException("Did not expect completion frame for " + this.instrumentedMethod);
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
                public void injectExceptionFrame(MethodVisitor methodVisitor) {
                    throw new IllegalStateException("Did not expect exception frame for " + this.instrumentedMethod);
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
                public void injectInitializationFrame(MethodVisitor methodVisitor) {
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
                public void injectPostCompletionFrame(MethodVisitor methodVisitor) {
                    throw new IllegalStateException("Did not expect post completion frame for " + this.instrumentedMethod);
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
                public void injectReturnFrame(MethodVisitor methodVisitor) {
                    throw new IllegalStateException("Did not expect return frame for " + this.instrumentedMethod);
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
                public void injectStartFrame(MethodVisitor methodVisitor) {
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
                public void translateFrame(MethodVisitor methodVisitor, int i, int i3, @MaybeNull Object[] objArr, int i4, @MaybeNull Object[] objArr2) {
                    methodVisitor.visitFrame(i, i3, objArr, i4, objArr2);
                }
            }

            public static abstract class WithPreservedArguments extends Default {
                protected boolean allowCompactCompletionFrame;

                public static class WithArgumentCopy extends WithPreservedArguments {
                    public WithArgumentCopy(TypeDescription typeDescription, MethodDescription methodDescription, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3, List<? extends TypeDescription> list4, boolean z6) {
                        super(typeDescription, methodDescription, list, list2, list3, list4, z6, true);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:20:0x007f A[LOOP:0: B:18:0x0079->B:20:0x007f, LOOP_END] */
                    /* JADX WARN: Removed duplicated region for block: B:22:0x009c  */
                    /* JADX WARN: Removed duplicated region for block: B:37:0x00ff A[LOOP:1: B:35:0x00f9->B:37:0x00ff, LOOP_END] */
                    /* JADX WARN: Removed duplicated region for block: B:41:0x011d A[LOOP:2: B:39:0x0117->B:41:0x011d, LOOP_END] */
                    /* JADX WARN: Removed duplicated region for block: B:45:0x013b A[LOOP:3: B:43:0x0135->B:45:0x013b, LOOP_END] */
                    /* JADX WARN: Removed duplicated region for block: B:48:0x0155  */
                    /* JADX WARN: Removed duplicated region for block: B:50:0x015d  */
                    /* JADX WARN: Removed duplicated region for block: B:56:0x018a A[LOOP:4: B:54:0x0184->B:56:0x018a, LOOP_END] */
                    /* JADX WARN: Removed duplicated region for block: B:59:0x01a0  */
                    @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public void injectStartFrame(net.bytebuddy.jar.asm.MethodVisitor r18) {
                        /*
                            Method dump skipped, instruction units count: 449
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.WithPreservedArguments.WithArgumentCopy.injectStartFrame(net.bytebuddy.jar.asm.MethodVisitor):void");
                    }

                    @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
                    @SuppressFBWarnings(justification = "ASM models frames by reference identity.", value = {"RC_REF_COMPARISON_BAD_PRACTICE"})
                    public void translateFrame(MethodVisitor methodVisitor, int i, int i3, @MaybeNull Object[] objArr, int i4, @MaybeNull Object[] objArr2) {
                        int i5 = 1;
                        if (i == -1 || i == 0) {
                            int size = this.preMethodTypes.size() + this.initialTypes.size() + this.instrumentedMethod.getParameters().size() + (!this.instrumentedMethod.isStatic() ? 1 : 0) + i3;
                            Object[] objArr3 = new Object[size];
                            if (this.instrumentedMethod.isConstructor()) {
                                Initialization initialization = Initialization.INITIALIZED;
                                int i6 = 0;
                                while (true) {
                                    if (i6 >= i3) {
                                        break;
                                    }
                                    if (objArr[i6] == Opcodes.UNINITIALIZED_THIS) {
                                        initialization = Initialization.UNITIALIZED;
                                        break;
                                    }
                                    i6++;
                                }
                                objArr3[0] = initialization.toFrame(this.instrumentedType);
                            } else if (this.instrumentedMethod.isStatic()) {
                                i5 = 0;
                            } else {
                                objArr3[0] = Initialization.INITIALIZED.toFrame(this.instrumentedType);
                            }
                            Iterator<TypeDescription> it = this.instrumentedMethod.getParameters().asTypeList().asErasures().iterator();
                            while (it.hasNext()) {
                                objArr3[i5] = Initialization.INITIALIZED.toFrame(it.next());
                                i5++;
                            }
                            Iterator<? extends TypeDescription> it2 = this.initialTypes.iterator();
                            while (it2.hasNext()) {
                                objArr3[i5] = Initialization.INITIALIZED.toFrame(it2.next());
                                i5++;
                            }
                            Iterator<? extends TypeDescription> it3 = this.preMethodTypes.iterator();
                            while (it3.hasNext()) {
                                objArr3[i5] = Initialization.INITIALIZED.toFrame(it3.next());
                                i5++;
                            }
                            if (i3 > 0) {
                                System.arraycopy(objArr, 0, objArr3, i5, i3);
                            }
                            this.currentFrameDivergence = size;
                            objArr = objArr3;
                            i3 = size;
                        } else if (i == 1) {
                            this.currentFrameDivergence += i3;
                        } else if (i == 2) {
                            this.currentFrameDivergence -= i3;
                        } else if (i != 3 && i != 4) {
                            throw new IllegalArgumentException(b.c(i, "Unexpected frame type: "));
                        }
                        methodVisitor.visitFrame(i, i3, objArr, i4, objArr2);
                    }
                }

                public static class WithoutArgumentCopy extends WithPreservedArguments {
                    public WithoutArgumentCopy(TypeDescription typeDescription, MethodDescription methodDescription, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3, List<? extends TypeDescription> list4, boolean z6, boolean z7) {
                        super(typeDescription, methodDescription, list, list2, list3, list4, z6, z7);
                    }

                    @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
                    public void injectStartFrame(MethodVisitor methodVisitor) {
                    }

                    @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
                    public void translateFrame(MethodVisitor methodVisitor, int i, int i3, @MaybeNull Object[] objArr, int i4, @MaybeNull Object[] objArr2) {
                        translateFrame(methodVisitor, TranslationMode.COPY, this.instrumentedMethod, CompoundList.of((List) this.initialTypes, (List) this.preMethodTypes), i, i3, objArr, i4, objArr2);
                    }
                }

                public WithPreservedArguments(TypeDescription typeDescription, MethodDescription methodDescription, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3, List<? extends TypeDescription> list4, boolean z6, boolean z7) {
                    super(typeDescription, methodDescription, list, list2, list3, list4, z6);
                    this.allowCompactCompletionFrame = z7;
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
                public ForAdvice bindExit(MethodDescription.InDefinedShape inDefinedShape) {
                    List listOf = CompoundList.of(this.initialTypes, this.preMethodTypes, this.postMethodTypes);
                    List list = Collections.EMPTY_LIST;
                    return new ForAdvice(inDefinedShape, listOf, list, list, TranslationMode.EXIT, Initialization.INITIALIZED);
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
                public void injectCompletionFrame(MethodVisitor methodVisitor) {
                    if (!this.allowCompactCompletionFrame || this.expandFrames || this.currentFrameDivergence != 0 || this.postMethodTypes.size() >= 4) {
                        injectFullFrame(methodVisitor, Initialization.INITIALIZED, CompoundList.of(this.initialTypes, this.preMethodTypes, this.postMethodTypes), Collections.EMPTY_LIST);
                        return;
                    }
                    if (this.postMethodTypes.isEmpty()) {
                        Object[] objArr = Default.EMPTY;
                        methodVisitor.visitFrame(3, objArr.length, objArr, objArr.length, objArr);
                        return;
                    }
                    int size = this.postMethodTypes.size();
                    Object[] objArr2 = new Object[size];
                    Iterator<? extends TypeDescription> it = this.postMethodTypes.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        objArr2[i] = Initialization.INITIALIZED.toFrame(it.next());
                        i++;
                    }
                    Object[] objArr3 = Default.EMPTY;
                    methodVisitor.visitFrame(1, size, objArr2, objArr3.length, objArr3);
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
                public void injectExceptionFrame(MethodVisitor methodVisitor) {
                    if (this.expandFrames || this.currentFrameDivergence != 0) {
                        injectFullFrame(methodVisitor, Initialization.INITIALIZED, CompoundList.of((List) this.initialTypes, (List) this.preMethodTypes), Collections.singletonList(TypeDescription.ForLoadedType.of(Throwable.class)));
                    } else {
                        Object[] objArr = Default.EMPTY;
                        methodVisitor.visitFrame(4, objArr.length, objArr, 1, new Object[]{Type.getInternalName(Throwable.class)});
                    }
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
                public void injectInitializationFrame(MethodVisitor methodVisitor) {
                    if (this.initialTypes.isEmpty()) {
                        return;
                    }
                    if (!this.expandFrames && this.initialTypes.size() < 4) {
                        int size = this.initialTypes.size();
                        Object[] objArr = new Object[size];
                        Iterator<? extends TypeDescription> it = this.initialTypes.iterator();
                        while (it.hasNext()) {
                            objArr[i] = Initialization.INITIALIZED.toFrame(it.next());
                            i++;
                        }
                        Object[] objArr2 = Default.EMPTY;
                        methodVisitor.visitFrame(1, size, objArr, objArr2.length, objArr2);
                        return;
                    }
                    int i = 1;
                    int size2 = this.initialTypes.size() + this.instrumentedMethod.getParameters().size() + (!this.instrumentedMethod.isStatic() ? 1 : 0);
                    Object[] objArr3 = new Object[size2];
                    if (this.instrumentedMethod.isConstructor()) {
                        objArr3[0] = Opcodes.UNINITIALIZED_THIS;
                    } else if (this.instrumentedMethod.isStatic()) {
                        i = 0;
                    } else {
                        objArr3[0] = Initialization.INITIALIZED.toFrame(this.instrumentedType);
                    }
                    Iterator<TypeDescription> it2 = this.instrumentedMethod.getParameters().asTypeList().asErasures().iterator();
                    while (it2.hasNext()) {
                        objArr3[i] = Initialization.INITIALIZED.toFrame(it2.next());
                        i++;
                    }
                    Iterator<? extends TypeDescription> it3 = this.initialTypes.iterator();
                    while (it3.hasNext()) {
                        objArr3[i] = Initialization.INITIALIZED.toFrame(it3.next());
                        i++;
                    }
                    i = this.expandFrames ? -1 : 0;
                    Object[] objArr4 = Default.EMPTY;
                    methodVisitor.visitFrame(i, size2, objArr3, objArr4.length, objArr4);
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
                public void injectPostCompletionFrame(MethodVisitor methodVisitor) {
                    if (this.expandFrames || this.currentFrameDivergence != 0) {
                        injectFullFrame(methodVisitor, Initialization.INITIALIZED, CompoundList.of(this.initialTypes, this.preMethodTypes, this.postMethodTypes), Collections.EMPTY_LIST);
                    } else {
                        Object[] objArr = Default.EMPTY;
                        methodVisitor.visitFrame(3, objArr.length, objArr, objArr.length, objArr);
                    }
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
                public void injectReturnFrame(MethodVisitor methodVisitor) {
                    boolean z6 = this.expandFrames;
                    Class cls = Void.TYPE;
                    if (z6 || this.currentFrameDivergence != 0) {
                        injectFullFrame(methodVisitor, Initialization.INITIALIZED, CompoundList.of((List) this.initialTypes, (List) this.preMethodTypes), this.instrumentedMethod.getReturnType().represents(cls) ? Collections.EMPTY_LIST : Collections.singletonList(this.instrumentedMethod.getReturnType().asErasure()));
                    } else if (this.instrumentedMethod.getReturnType().represents(cls)) {
                        Object[] objArr = Default.EMPTY;
                        methodVisitor.visitFrame(3, objArr.length, objArr, objArr.length, objArr);
                    } else {
                        Object[] objArr2 = Default.EMPTY;
                        methodVisitor.visitFrame(4, objArr2.length, objArr2, 1, new Object[]{Initialization.INITIALIZED.toFrame(this.instrumentedMethod.getReturnType().asErasure())});
                    }
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.Default
                @SuppressFBWarnings(justification = "ASM models frames by reference identity.", value = {"RC_REF_COMPARISON_BAD_PRACTICE"})
                public void translateFrame(MethodVisitor methodVisitor, TranslationMode translationMode, MethodDescription methodDescription, List<? extends TypeDescription> list, int i, int i3, @MaybeNull Object[] objArr, int i4, @MaybeNull Object[] objArr2) {
                    if (i == 0 && i3 > 0 && objArr[0] != Opcodes.UNINITIALIZED_THIS) {
                        this.allowCompactCompletionFrame = true;
                    }
                    super.translateFrame(methodVisitor, translationMode, methodDescription, list, i, i3, objArr, i4, objArr2);
                }
            }

            public Default(TypeDescription typeDescription, MethodDescription methodDescription, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3, List<? extends TypeDescription> list4, boolean z6) {
                this.instrumentedType = typeDescription;
                this.instrumentedMethod = methodDescription;
                this.initialTypes = list;
                this.latentTypes = list2;
                this.preMethodTypes = list3;
                this.postMethodTypes = list4;
                this.expandFrames = z6;
            }

            public static ForInstrumentedMethod of(TypeDescription typeDescription, MethodDescription methodDescription, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3, List<? extends TypeDescription> list4, boolean z6, boolean z7, ClassFileVersion classFileVersion, int i, int i3) {
                boolean z8;
                TypeDescription typeDescription2;
                MethodDescription methodDescription2;
                List<? extends TypeDescription> list5;
                List<? extends TypeDescription> list6;
                List<? extends TypeDescription> list7;
                List<? extends TypeDescription> list8;
                if ((i & 2) != 0 || classFileVersion.isLessThan(ClassFileVersion.JAVA_V6)) {
                    return NoOp.INSTANCE;
                }
                if (!z6 && list.isEmpty()) {
                    return new Trivial(typeDescription, methodDescription, list2, (i3 & 8) != 0);
                }
                if (!z7) {
                    return new WithPreservedArguments.WithoutArgumentCopy(typeDescription, methodDescription, list, list2, list3, list4, (i3 & 8) != 0, !methodDescription.isConstructor());
                }
                if ((i3 & 8) != 0) {
                    z8 = true;
                    methodDescription2 = methodDescription;
                    list5 = list;
                    list6 = list2;
                    list7 = list3;
                    list8 = list4;
                    typeDescription2 = typeDescription;
                } else {
                    z8 = false;
                    typeDescription2 = typeDescription;
                    methodDescription2 = methodDescription;
                    list5 = list;
                    list6 = list2;
                    list7 = list3;
                    list8 = list4;
                }
                return new WithPreservedArguments.WithArgumentCopy(typeDescription2, methodDescription2, list5, list6, list7, list8, z8);
            }

            @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
            public ForAdvice bindEnter(MethodDescription.InDefinedShape inDefinedShape) {
                return new ForAdvice(inDefinedShape, this.initialTypes, this.latentTypes, this.preMethodTypes, TranslationMode.ENTER, this.instrumentedMethod.isConstructor() ? Initialization.UNITIALIZED : Initialization.INITIALIZED);
            }

            @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
            public int getReaderHint() {
                return this.expandFrames ? 8 : 0;
            }

            public void injectFullFrame(MethodVisitor methodVisitor, Initialization initialization, List<? extends TypeDescription> list, List<? extends TypeDescription> list2) {
                int i = 1;
                int size = list.size() + this.instrumentedMethod.getParameters().size() + (!this.instrumentedMethod.isStatic() ? 1 : 0);
                Object[] objArr = new Object[size];
                if (this.instrumentedMethod.isStatic()) {
                    i = 0;
                } else {
                    objArr[0] = initialization.toFrame(this.instrumentedType);
                }
                Iterator<TypeDescription> it = this.instrumentedMethod.getParameters().asTypeList().asErasures().iterator();
                while (it.hasNext()) {
                    objArr[i] = Initialization.INITIALIZED.toFrame(it.next());
                    i++;
                }
                Iterator<? extends TypeDescription> it2 = list.iterator();
                while (it2.hasNext()) {
                    objArr[i] = Initialization.INITIALIZED.toFrame(it2.next());
                    i++;
                }
                int size2 = list2.size();
                Object[] objArr2 = new Object[size2];
                Iterator<? extends TypeDescription> it3 = list2.iterator();
                int i3 = 0;
                while (it3.hasNext()) {
                    objArr2[i3] = Initialization.INITIALIZED.toFrame(it3.next());
                    i3++;
                }
                methodVisitor.visitFrame(this.expandFrames ? -1 : 0, size, objArr, size2, objArr2);
                this.currentFrameDivergence = 0;
            }

            public void translateFrame(MethodVisitor methodVisitor, TranslationMode translationMode, MethodDescription methodDescription, List<? extends TypeDescription> list, int i, int i3, @MaybeNull Object[] objArr, int i4, @MaybeNull Object[] objArr2) {
                int i5;
                int i6;
                Object[] objArr3;
                int i7;
                int i8;
                Object[] objArr4;
                MethodVisitor methodVisitor2;
                if (i == -1 || i == 0) {
                    if (methodDescription.getParameters().size() + (!methodDescription.isStatic() ? 1 : 0) > i3) {
                        throw new IllegalStateException("Inconsistent frame length for " + methodDescription + ": " + i3);
                    }
                    if (methodDescription.isStatic()) {
                        i5 = 0;
                    } else {
                        if (!translationMode.isPossibleThisFrameValue(this.instrumentedType, this.instrumentedMethod, objArr[0])) {
                            throw new IllegalStateException(methodDescription + " is inconsistent for 'this' reference: " + objArr[0]);
                        }
                        i5 = 1;
                    }
                    for (int i9 = 0; i9 < methodDescription.getParameters().size(); i9++) {
                        int i10 = i9 + i5;
                        if (!Initialization.INITIALIZED.toFrame(((ParameterDescription) methodDescription.getParameters().get(i9)).getType().asErasure()).equals(objArr[i10])) {
                            throw new IllegalStateException(methodDescription + " is inconsistent at " + i9 + ": " + objArr[i10]);
                        }
                    }
                    int size = list.size() + this.instrumentedMethod.getParameters().size() + ((i3 - (!methodDescription.isStatic() ? 1 : 0)) - methodDescription.getParameters().size()) + (!this.instrumentedMethod.isStatic() ? 1 : 0);
                    Object[] objArr5 = new Object[size];
                    int iCopy = translationMode.copy(this.instrumentedType, this.instrumentedMethod, methodDescription, objArr, objArr5);
                    Iterator<? extends TypeDescription> it = list.iterator();
                    while (it.hasNext()) {
                        objArr5[iCopy] = Initialization.INITIALIZED.toFrame(it.next());
                        iCopy++;
                    }
                    int size2 = methodDescription.getParameters().size() + (!methodDescription.isStatic() ? 1 : 0);
                    int i11 = size - iCopy;
                    System.arraycopy(objArr, size2, objArr5, iCopy, i11);
                    this.currentFrameDivergence = i11;
                    i6 = size;
                    objArr3 = objArr5;
                    i7 = i;
                    i8 = i4;
                    objArr4 = objArr2;
                    methodVisitor2 = methodVisitor;
                } else {
                    if (i == 1) {
                        this.currentFrameDivergence += i3;
                    } else if (i == 2) {
                        int i12 = this.currentFrameDivergence - i3;
                        this.currentFrameDivergence = i12;
                        if (i12 < 0) {
                            throw new IllegalStateException(methodDescription + " dropped " + Math.abs(this.currentFrameDivergence) + " implicit frames");
                        }
                    } else if (i != 3 && i != 4) {
                        throw new IllegalArgumentException(b.c(i, "Unexpected frame type: "));
                    }
                    i6 = i3;
                    objArr3 = objArr;
                    methodVisitor2 = methodVisitor;
                    i7 = i;
                    i8 = i4;
                    objArr4 = objArr2;
                }
                methodVisitor2.visitFrame(i7, i6, objArr3, i8, objArr4);
            }
        }

        public interface ForAdvice extends StackMapFrameHandler, ForPostProcessor {
        }

        public interface ForInstrumentedMethod extends StackMapFrameHandler {
            ForAdvice bindEnter(MethodDescription.InDefinedShape inDefinedShape);

            ForAdvice bindExit(MethodDescription.InDefinedShape inDefinedShape);

            int getReaderHint();

            void injectInitializationFrame(MethodVisitor methodVisitor);

            void injectPostCompletionFrame(MethodVisitor methodVisitor);

            void injectStartFrame(MethodVisitor methodVisitor);
        }

        public interface ForPostProcessor {
            void injectIntermediateFrame(MethodVisitor methodVisitor, List<? extends TypeDescription> list);
        }

        public enum NoOp implements ForInstrumentedMethod, ForAdvice {
            INSTANCE;

            @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
            public ForAdvice bindEnter(MethodDescription.InDefinedShape inDefinedShape) {
                return this;
            }

            @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
            public ForAdvice bindExit(MethodDescription.InDefinedShape inDefinedShape) {
                return this;
            }

            @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
            public int getReaderHint() {
                return 4;
            }

            @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
            public void injectCompletionFrame(MethodVisitor methodVisitor) {
            }

            @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
            public void injectExceptionFrame(MethodVisitor methodVisitor) {
            }

            @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
            public void injectInitializationFrame(MethodVisitor methodVisitor) {
            }

            @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForPostProcessor
            public void injectIntermediateFrame(MethodVisitor methodVisitor, List<? extends TypeDescription> list) {
            }

            @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
            public void injectPostCompletionFrame(MethodVisitor methodVisitor) {
            }

            @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
            public void injectReturnFrame(MethodVisitor methodVisitor) {
            }

            @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
            public void injectStartFrame(MethodVisitor methodVisitor) {
            }

            @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
            public void translateFrame(MethodVisitor methodVisitor, int i, int i3, @MaybeNull Object[] objArr, int i4, @MaybeNull Object[] objArr2) {
            }
        }

        void injectCompletionFrame(MethodVisitor methodVisitor);

        void injectExceptionFrame(MethodVisitor methodVisitor);

        void injectReturnFrame(MethodVisitor methodVisitor);

        void translateFrame(MethodVisitor methodVisitor, int i, int i3, @MaybeNull Object[] objArr, int i4, @MaybeNull Object[] objArr2);
    }

    @Target({ElementType.PARAMETER})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface StubValue {
    }

    @Target({ElementType.PARAMETER})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface This {
        boolean optional() default false;

        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;
    }

    @Target({ElementType.PARAMETER})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Thrown {
        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.DYNAMIC;
    }

    @Target({ElementType.PARAMETER})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Unused {
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class WithCustomMapping {
        private final Delegator delegator;
        private final Map<Class<? extends Annotation>, OffsetMapping.Factory<?>> offsetMappings;
        private final PostProcessor.Factory postProcessorFactory;

        public WithCustomMapping() {
            this(PostProcessor.NoOp.INSTANCE, Collections.EMPTY_MAP, Delegator.ForStaticInvocation.INSTANCE);
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, @MaybeNull Object obj) {
            return bind(OffsetMapping.ForStackManipulation.Factory.of(cls, obj));
        }

        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, Method method, Object... objArr) {
            return bindDynamic(cls, method, Arrays.asList(objArr));
        }

        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, Constructor<?> constructor, Class<?> cls2) {
            return bindLambda(cls, new MethodDescription.ForLoadedConstructor(constructor), TypeDescription.ForLoadedType.of(cls2));
        }

        public <T extends Annotation> WithCustomMapping bindProperty(Class<T> cls, String str) {
            return bind(OffsetMapping.ForStackManipulation.OfAnnotationProperty.of(cls, str));
        }

        public <T extends Annotation> WithCustomMapping bindSerialized(Class<T> cls, Serializable serializable) {
            return bindSerialized(cls, serializable, serializable.getClass());
        }

        public WithCustomMapping bootstrap(Constructor<?> constructor) {
            return bootstrap(new MethodDescription.ForLoadedConstructor(constructor));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            WithCustomMapping withCustomMapping = (WithCustomMapping) obj;
            return this.postProcessorFactory.equals(withCustomMapping.postProcessorFactory) && this.delegator.equals(withCustomMapping.delegator) && this.offsetMappings.equals(withCustomMapping.offsetMappings);
        }

        public int hashCode() {
            return this.offsetMappings.hashCode() + ((this.delegator.hashCode() + ((this.postProcessorFactory.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31);
        }

        public Advice to(Class<?> cls) {
            return to(cls, ClassFileLocator.ForClassLoader.of(cls.getClassLoader()));
        }

        public WithCustomMapping with(PostProcessor.Factory factory) {
            return new WithCustomMapping(new PostProcessor.Factory.Compound(this.postProcessorFactory, factory), this.offsetMappings, this.delegator);
        }

        public WithCustomMapping(PostProcessor.Factory factory, Map<Class<? extends Annotation>, OffsetMapping.Factory<?>> map, Delegator delegator) {
            this.postProcessorFactory = factory;
            this.offsetMappings = map;
            this.delegator = delegator;
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, Field field) {
            return bind((Class) cls, (FieldDescription) new FieldDescription.ForLoadedField(field));
        }

        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, Method method, List<?> list) {
            return bindDynamic(cls, new MethodDescription.ForLoadedMethod(method), list);
        }

        public <T extends Annotation, S extends Serializable> WithCustomMapping bindSerialized(Class<T> cls, S s3, Class<? super S> cls2) {
            return bind(OffsetMapping.ForSerializedValue.Factory.of(cls, s3, cls2));
        }

        public WithCustomMapping bootstrap(Method method) {
            return bootstrap(new MethodDescription.ForLoadedMethod(method));
        }

        public Advice to(Class<?> cls, ClassFileLocator classFileLocator) {
            return to(TypeDescription.ForLoadedType.of(cls), classFileLocator);
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, FieldDescription fieldDescription) {
            return bind(new OffsetMapping.ForField.Resolved.Factory(cls, fieldDescription));
        }

        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, Constructor<?> constructor, Object... objArr) {
            return bindDynamic(cls, constructor, Arrays.asList(objArr));
        }

        public WithCustomMapping bootstrap(MethodDescription.InDefinedShape inDefinedShape) {
            return new WithCustomMapping(this.postProcessorFactory, this.offsetMappings, Delegator.ForDynamicInvocation.of(inDefinedShape));
        }

        public Advice to(TypeDescription typeDescription, ClassFileLocator classFileLocator) {
            return Advice.to(typeDescription, this.postProcessorFactory, classFileLocator, new ArrayList(this.offsetMappings.values()), this.delegator);
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, Method method, int i) {
            if (i >= 0) {
                if (method.getParameterTypes().length > i) {
                    return bind((Class) cls, (ParameterDescription) new MethodDescription.ForLoadedMethod(method).getParameters().get(i));
                }
                throw new IllegalArgumentException(method + " does not declare a parameter with index " + i);
            }
            throw new IllegalArgumentException(b.c(i, "A parameter cannot be negative: "));
        }

        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, Constructor<?> constructor, List<?> list) {
            return bindDynamic(cls, new MethodDescription.ForLoadedConstructor(constructor), list);
        }

        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, Constructor<?> constructor, Class<?> cls2, MethodGraph.Compiler compiler) {
            return bindLambda(cls, new MethodDescription.ForLoadedConstructor(constructor), TypeDescription.ForLoadedType.of(cls2), compiler);
        }

        public Advice to(Class<?> cls, Class<?> cls2) {
            ClassFileLocator compound;
            ClassLoader classLoader = cls.getClassLoader();
            ClassLoader classLoader2 = cls2.getClassLoader();
            if (classLoader == classLoader2) {
                compound = ClassFileLocator.ForClassLoader.of(classLoader);
            } else {
                compound = new ClassFileLocator.Compound(ClassFileLocator.ForClassLoader.of(classLoader), ClassFileLocator.ForClassLoader.of(classLoader2));
            }
            return to(cls, cls2, compound);
        }

        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape, Object... objArr) {
            return bindDynamic(cls, inDefinedShape, Arrays.asList(objArr));
        }

        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape, List<?> list) {
            List<JavaConstant> listWrap = JavaConstant.Simple.wrap(list);
            if (inDefinedShape.isInvokeBootstrap(TypeList.Explicit.of((List<? extends JavaConstant>) listWrap))) {
                return bind(new OffsetMapping.ForStackManipulation.OfDynamicInvocation(cls, inDefinedShape, listWrap));
            }
            throw new IllegalArgumentException("Not a valid bootstrap method " + inDefinedShape + " for " + listWrap);
        }

        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, Method method, Class<?> cls2) {
            return bindLambda(cls, new MethodDescription.ForLoadedMethod(method), TypeDescription.ForLoadedType.of(cls2));
        }

        public Advice to(Class<?> cls, Class<?> cls2, ClassFileLocator classFileLocator) {
            return to(TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(cls2), classFileLocator);
        }

        public Advice to(TypeDescription typeDescription, TypeDescription typeDescription2) {
            return to(typeDescription, typeDescription2, ClassFileLocator.NoOp.INSTANCE);
        }

        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, Method method, Class<?> cls2, MethodGraph.Compiler compiler) {
            return bindLambda(cls, new MethodDescription.ForLoadedMethod(method), TypeDescription.ForLoadedType.of(cls2), compiler);
        }

        public Advice to(TypeDescription typeDescription, TypeDescription typeDescription2, ClassFileLocator classFileLocator) {
            return Advice.to(typeDescription, typeDescription2, this.postProcessorFactory, classFileLocator, new ArrayList(this.offsetMappings.values()), this.delegator);
        }

        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription) {
            return bindLambda(cls, inDefinedShape, typeDescription, MethodGraph.Compiler.DEFAULT);
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, Constructor<?> constructor, int i) {
            if (i >= 0) {
                if (constructor.getParameterTypes().length > i) {
                    return bind((Class) cls, (ParameterDescription) new MethodDescription.ForLoadedConstructor(constructor).getParameters().get(i));
                }
                throw new IllegalArgumentException(constructor + " does not declare a parameter with index " + i);
            }
            throw new IllegalArgumentException(b.c(i, "A parameter cannot be negative: "));
        }

        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription, MethodGraph.Compiler compiler) {
            if (typeDescription.isInterface()) {
                MethodList methodListFilter = compiler.compile((TypeDefinition) typeDescription).listNodes().asMethodList().filter(ElementMatchers.isAbstract());
                if (methodListFilter.size() == 1) {
                    TypeDescription.Latent latent = new TypeDescription.Latent("java.lang.invoke.LambdaMetafactory", 1, TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class), new TypeDescription.Generic[0]);
                    List list = Collections.EMPTY_LIST;
                    TypeDescription.Generic genericAsGenericType = JavaType.CALL_SITE.getTypeStub().asGenericType();
                    ParameterDescription.Token token = new ParameterDescription.Token(JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().asGenericType());
                    ParameterDescription.Token token2 = new ParameterDescription.Token(TypeDescription.ForLoadedType.of(String.class).asGenericType());
                    JavaType javaType = JavaType.METHOD_TYPE;
                    return bindDynamic(cls, new MethodDescription.Latent(latent, "metafactory", 9, list, genericAsGenericType, Arrays.asList(token, token2, new ParameterDescription.Token(javaType.getTypeStub().asGenericType()), new ParameterDescription.Token(javaType.getTypeStub().asGenericType()), new ParameterDescription.Token(JavaType.METHOD_HANDLE.getTypeStub().asGenericType()), new ParameterDescription.Token(javaType.getTypeStub().asGenericType())), list, list, AnnotationValue.UNDEFINED, TypeDescription.Generic.UNDEFINED), JavaConstant.MethodType.of(methodListFilter.asDefined().getOnly()), JavaConstant.MethodHandle.of(inDefinedShape), JavaConstant.MethodType.of(methodListFilter.asDefined().getOnly()));
                }
                throw new IllegalArgumentException(typeDescription + " does not define exactly one abstract method: " + methodListFilter);
            }
            throw new IllegalArgumentException(a.o(typeDescription, " is not an interface type"));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, ParameterDescription parameterDescription) {
            return bind(new OffsetMapping.ForArgument.Resolved.Factory(cls, parameterDescription));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, Class<?> cls2) {
            return bind((Class) cls, TypeDescription.ForLoadedType.of(cls2));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, TypeDescription typeDescription) {
            return bind(new OffsetMapping.ForStackManipulation.Factory(cls, typeDescription));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, Enum<?> r32) {
            return bind((Class) cls, (EnumerationDescription) new EnumerationDescription.ForLoadedEnumeration(r32));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, EnumerationDescription enumerationDescription) {
            return bind(new OffsetMapping.ForStackManipulation.Factory(cls, enumerationDescription));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, JavaConstant javaConstant) {
            return bind(new OffsetMapping.ForStackManipulation.Factory(cls, new JavaConstantValue(javaConstant), javaConstant.getTypeDescription().asGenericType()));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, StackManipulation stackManipulation, java.lang.reflect.Type type) {
            return bind(cls, stackManipulation, TypeDefinition.Sort.describe(type));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, StackManipulation stackManipulation, TypeDescription.Generic generic) {
            return bind(new OffsetMapping.ForStackManipulation.Factory(cls, stackManipulation, generic));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, OffsetMapping offsetMapping) {
            return bind(new OffsetMapping.Factory.Simple(cls, offsetMapping));
        }

        public WithCustomMapping bind(OffsetMapping.Factory<?> factory) {
            HashMap map = new HashMap(this.offsetMappings);
            if (factory.getAnnotationType().isAnnotation()) {
                if (map.put(factory.getAnnotationType(), factory) == null) {
                    return new WithCustomMapping(this.postProcessorFactory, map, this.delegator);
                }
                throw new IllegalArgumentException("Annotation type already mapped: " + factory.getAnnotationType());
            }
            throw new IllegalArgumentException("Not an annotation type: " + factory.getAnnotationType());
        }
    }

    static {
        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(OnMethodEnter.class).getDeclaredMethods();
        SKIP_ON = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("skipOn")).getOnly();
        PREPEND_LINE_NUMBER = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("prependLineNumber")).getOnly();
        INLINE_ENTER = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("inline")).getOnly();
        SUPPRESS_ENTER = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("suppress")).getOnly();
        MethodList<MethodDescription.InDefinedShape> declaredMethods2 = TypeDescription.ForLoadedType.of(OnMethodExit.class).getDeclaredMethods();
        REPEAT_ON = (MethodDescription.InDefinedShape) declaredMethods2.filter(ElementMatchers.named("repeatOn")).getOnly();
        ON_THROWABLE = (MethodDescription.InDefinedShape) declaredMethods2.filter(ElementMatchers.named("onThrowable")).getOnly();
        BACKUP_ARGUMENTS = (MethodDescription.InDefinedShape) declaredMethods2.filter(ElementMatchers.named("backupArguments")).getOnly();
        INLINE_EXIT = (MethodDescription.InDefinedShape) declaredMethods2.filter(ElementMatchers.named("inline")).getOnly();
        SUPPRESS_EXIT = (MethodDescription.InDefinedShape) declaredMethods2.filter(ElementMatchers.named("suppress")).getOnly();
    }

    public Advice(Dispatcher.Resolved.ForMethodEnter forMethodEnter, Dispatcher.Resolved.ForMethodExit forMethodExit) {
        this(forMethodEnter, forMethodExit, Assigner.DEFAULT, ExceptionHandler.Default.SUPPRESSING, SuperMethodCall.INSTANCE);
    }

    private static Dispatcher.Unresolved locate(Class<? extends Annotation> cls, MethodDescription.InDefinedShape inDefinedShape, Dispatcher.Unresolved unresolved, MethodDescription.InDefinedShape inDefinedShape2, Delegator delegator) {
        AnnotationDescription.Loadable loadableOfType = inDefinedShape2.getDeclaredAnnotations().ofType(cls);
        if (loadableOfType == null) {
            return unresolved;
        }
        if (unresolved.isAlive()) {
            throw new IllegalStateException("Duplicate advice for " + unresolved + " and " + inDefinedShape2);
        }
        if (inDefinedShape2.isStatic()) {
            return ((Boolean) loadableOfType.getValue(inDefinedShape).resolve(Boolean.class)).booleanValue() ? new Dispatcher.Inlining(inDefinedShape2) : new Dispatcher.Delegating(inDefinedShape2, delegator);
        }
        throw new IllegalStateException("Advice for " + inDefinedShape2 + " is not static");
    }

    public static Advice to(Class<?> cls) {
        return to(cls, ClassFileLocator.ForClassLoader.of(cls.getClassLoader()));
    }

    public static WithCustomMapping withCustomMapping() {
        return new WithCustomMapping();
    }

    @Override // net.bytebuddy.implementation.Implementation
    public ByteCodeAppender appender(Implementation.Target target) {
        return new Appender(this, target, this.delegate.appender(target));
    }

    public MethodVisitor doWrap(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, int i, int i3) {
        MethodVisitor lineNumberPrependingMethodVisitor = this.methodEnter.isPrependLineNumber() ? new LineNumberPrependingMethodVisitor(methodVisitor) : methodVisitor;
        if (!this.methodExit.isAlive()) {
            return new AdviceVisitor.WithoutExitAdvice(lineNumberPrependingMethodVisitor, context, this.assigner, this.exceptionHandler.resolve(methodDescription, typeDescription), typeDescription, methodDescription, this.methodEnter, i, i3);
        }
        if (this.methodExit.getThrowable().represents(NoExceptionHandler.class)) {
            return new AdviceVisitor.WithExitAdvice.WithoutExceptionHandling(lineNumberPrependingMethodVisitor, context, this.assigner, this.exceptionHandler.resolve(methodDescription, typeDescription), typeDescription, methodDescription, this.methodEnter, this.methodExit, i, i3);
        }
        if (methodDescription.isConstructor()) {
            throw new IllegalStateException(a.l("Cannot catch exception during constructor call for ", methodDescription));
        }
        Assigner assigner = this.assigner;
        StackManipulation stackManipulationResolve = this.exceptionHandler.resolve(methodDescription, typeDescription);
        Dispatcher.Resolved.ForMethodEnter forMethodEnter = this.methodEnter;
        Dispatcher.Resolved.ForMethodExit forMethodExit = this.methodExit;
        return new AdviceVisitor.WithExitAdvice.WithExceptionHandling(lineNumberPrependingMethodVisitor, context, assigner, stackManipulationResolve, typeDescription, methodDescription, forMethodEnter, forMethodExit, i, i3, forMethodExit.getThrowable());
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Advice advice = (Advice) obj;
        return this.methodEnter.equals(advice.methodEnter) && this.methodExit.equals(advice.methodExit) && this.assigner.equals(advice.assigner) && this.exceptionHandler.equals(advice.exceptionHandler) && this.delegate.equals(advice.delegate);
    }

    public int hashCode() {
        return this.delegate.hashCode() + ((this.exceptionHandler.hashCode() + ((this.assigner.hashCode() + ((this.methodExit.hashCode() + ((this.methodEnter.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public AsmVisitorWrapper.ForDeclaredMethods on(ElementMatcher<? super MethodDescription> elementMatcher) {
        return new AsmVisitorWrapper.ForDeclaredMethods().invokable(elementMatcher, this);
    }

    @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
    public InstrumentedType prepare(InstrumentedType instrumentedType) {
        return this.delegate.prepare(instrumentedType);
    }

    public Advice withAssigner(Assigner assigner) {
        return new Advice(this.methodEnter, this.methodExit, assigner, this.exceptionHandler, this.delegate);
    }

    public Advice withExceptionHandler(StackManipulation stackManipulation) {
        return withExceptionHandler(new ExceptionHandler.Simple(stackManipulation));
    }

    public Advice withExceptionPrinting() {
        return withExceptionHandler(ExceptionHandler.Default.PRINTING);
    }

    @Override // net.bytebuddy.asm.AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper
    public MethodVisitor wrap(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, TypePool typePool, int i, int i3) {
        return (methodDescription.isAbstract() || methodDescription.isNative()) ? methodVisitor : doWrap(typeDescription, methodDescription, methodVisitor, context, i, i3);
    }

    public interface OffsetMapping {

        public interface Factory<T extends Annotation> {

            public enum AdviceType {
                DELEGATION(true),
                INLINING(false);

                private final boolean delegation;

                AdviceType(boolean z6) {
                    this.delegation = z6;
                }

                public boolean isDelegation() {
                    return this.delegation;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Illegal<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;

                public Illegal(Class<T> cls) {
                    this.annotationType = cls;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.annotationType.equals(((Illegal) obj).annotationType);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return this.annotationType.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, AdviceType adviceType) {
                    throw new IllegalStateException("Usage of " + this.annotationType + " is not allowed on " + inDefinedShape);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Simple<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;
                private final OffsetMapping offsetMapping;

                public Simple(Class<T> cls, OffsetMapping offsetMapping) {
                    this.annotationType = cls;
                    this.offsetMapping = offsetMapping;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Simple simple = (Simple) obj;
                    return this.annotationType.equals(simple.annotationType) && this.offsetMapping.equals(simple.offsetMapping);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return this.offsetMapping.hashCode() + a.e(getClass().hashCode() * 31, 31, this.annotationType);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, AdviceType adviceType) {
                    return this.offsetMapping;
                }
            }

            Class<T> getAnnotationType();

            OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, AdviceType adviceType);
        }

        public enum ForInstrumentedMethod implements OffsetMapping {
            METHOD { // from class: net.bytebuddy.asm.Advice.OffsetMapping.ForInstrumentedMethod.1
                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForInstrumentedMethod
                public boolean isRepresentable(MethodDescription methodDescription) {
                    return methodDescription.isMethod();
                }
            },
            CONSTRUCTOR { // from class: net.bytebuddy.asm.Advice.OffsetMapping.ForInstrumentedMethod.2
                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForInstrumentedMethod
                public boolean isRepresentable(MethodDescription methodDescription) {
                    return methodDescription.isConstructor();
                }
            },
            EXECUTABLE { // from class: net.bytebuddy.asm.Advice.OffsetMapping.ForInstrumentedMethod.3
                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForInstrumentedMethod
                public boolean isRepresentable(MethodDescription methodDescription) {
                    return true;
                }
            };

            public abstract boolean isRepresentable(MethodDescription methodDescription);

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                if (isRepresentable(methodDescription)) {
                    return Target.ForStackManipulation.of(methodDescription.asDefined());
                }
                throw new IllegalStateException("Cannot represent " + methodDescription + " as given method constant");
            }
        }

        public enum ForInstrumentedType implements OffsetMapping {
            INSTANCE;

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                return Target.ForStackManipulation.of(typeDescription);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForLocalValue implements OffsetMapping {
            private final TypeDescription.Generic localType;
            private final String name;
            private final TypeDescription.Generic target;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory implements Factory<Local> {
                protected static final MethodDescription.InDefinedShape LOCAL_VALUE = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType.of(Local.class).getDeclaredMethods().filter(ElementMatchers.named("value")).getOnly();
                private final Map<String, TypeDefinition> namedTypes;

                public Factory(Map<String, TypeDefinition> map) {
                    this.namedTypes = map;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.namedTypes.equals(((Factory) obj).namedTypes);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<Local> getAnnotationType() {
                    return Local.class;
                }

                public int hashCode() {
                    return this.namedTypes.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Local> loadable, Factory.AdviceType adviceType) {
                    String str = (String) loadable.getValue(LOCAL_VALUE).resolve(String.class);
                    TypeDefinition typeDefinition = this.namedTypes.get(str);
                    if (typeDefinition != null) {
                        return new ForLocalValue(inDefinedShape.getType(), typeDefinition.asGenericType(), str);
                    }
                    throw new IllegalStateException(androidx.constraintlayout.core.motion.a.p("Named local variable is unknown: ", str));
                }
            }

            public ForLocalValue(TypeDescription.Generic generic, TypeDescription.Generic generic2, String str) {
                this.target = generic;
                this.localType = generic2;
                this.name = str;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForLocalValue forLocalValue = (ForLocalValue) obj;
                return this.name.equals(forLocalValue.name) && this.target.equals(forLocalValue.target) && this.localType.equals(forLocalValue.localType);
            }

            public int hashCode() {
                return this.name.hashCode() + a.h(this.localType, a.h(this.target, getClass().hashCode() * 31, 31), 31);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                TypeDescription.Generic generic = this.localType;
                TypeDescription.Generic generic2 = this.target;
                Assigner.Typing typing = Assigner.Typing.STATIC;
                StackManipulation stackManipulationAssign = assigner.assign(generic, generic2, typing);
                StackManipulation stackManipulationAssign2 = assigner.assign(this.target, this.localType, typing);
                if (stackManipulationAssign.isValid() && stackManipulationAssign2.isValid()) {
                    return new Target.ForVariable.ReadWrite(this.target, argumentHandler.named(this.name), stackManipulationAssign, stackManipulationAssign2);
                }
                throw new IllegalStateException("Cannot assign " + this.localType + " to " + this.target);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForOrigin implements OffsetMapping {
            private static final char DELIMITER = '#';
            private static final char ESCAPE = '\\';
            private final List<Renderer> renderers;

            public enum Factory implements Factory<Origin> {
                INSTANCE;

                private static final MethodDescription.InDefinedShape ORIGIN_VALUE = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType.of(Origin.class).getDeclaredMethods().filter(ElementMatchers.named("value")).getOnly();

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<Origin> getAnnotationType() {
                    return Origin.class;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Origin> loadable, Factory.AdviceType adviceType) {
                    if (inDefinedShape.getType().asErasure().represents(Class.class)) {
                        return ForInstrumentedType.INSTANCE;
                    }
                    if (inDefinedShape.getType().asErasure().represents(Method.class)) {
                        return ForInstrumentedMethod.METHOD;
                    }
                    if (inDefinedShape.getType().asErasure().represents(Constructor.class)) {
                        return ForInstrumentedMethod.CONSTRUCTOR;
                    }
                    if (JavaType.EXECUTABLE.getTypeStub().equals(inDefinedShape.getType().asErasure())) {
                        return ForInstrumentedMethod.EXECUTABLE;
                    }
                    if (inDefinedShape.getType().asErasure().isAssignableFrom(String.class)) {
                        return ForOrigin.parse((String) loadable.getValue(ORIGIN_VALUE).resolve(String.class));
                    }
                    throw new IllegalStateException("Non-supported type " + inDefinedShape.getType() + " for @Origin annotation");
                }
            }

            public interface Renderer {

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForConstantValue implements Renderer {
                    private final String value;

                    public ForConstantValue(String str) {
                        this.value = str;
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer
                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return this.value;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.value.equals(((ForConstantValue) obj).value);
                    }

                    public int hashCode() {
                        return this.value.hashCode() + (getClass().hashCode() * 31);
                    }
                }

                public enum ForDescriptor implements Renderer {
                    INSTANCE;

                    public static final char SYMBOL = 'd';

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer
                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return methodDescription.getDescriptor();
                    }
                }

                public enum ForJavaSignature implements Renderer {
                    INSTANCE;

                    public static final char SYMBOL = 's';

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer
                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        StringBuilder sb = new StringBuilder("(");
                        boolean z6 = false;
                        for (TypeDescription typeDescription2 : methodDescription.getParameters().asTypeList().asErasures()) {
                            if (z6) {
                                sb.append(',');
                            } else {
                                z6 = true;
                            }
                            sb.append(typeDescription2.getName());
                        }
                        sb.append(')');
                        return sb.toString();
                    }
                }

                public enum ForMethodName implements Renderer {
                    INSTANCE;

                    public static final char SYMBOL = 'm';

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer
                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return methodDescription.getInternalName();
                    }
                }

                public enum ForPropertyName implements Renderer {
                    INSTANCE;

                    public static final char SYMBOL = 'p';

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer
                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return FieldAccessor.FieldNameExtractor.ForBeanProperty.INSTANCE.resolve(methodDescription);
                    }
                }

                public enum ForReturnTypeName implements Renderer {
                    INSTANCE;

                    public static final char SYMBOL = 'r';

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer
                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return methodDescription.getReturnType().asErasure().getName();
                    }
                }

                public enum ForStringRepresentation implements Renderer {
                    INSTANCE;

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer
                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return methodDescription.toString();
                    }
                }

                public enum ForTypeName implements Renderer {
                    INSTANCE;

                    public static final char SYMBOL = 't';

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer
                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return typeDescription.getName();
                    }
                }

                String apply(TypeDescription typeDescription, MethodDescription methodDescription);
            }

            public ForOrigin(List<Renderer> list) {
                this.renderers = list;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0063  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public static net.bytebuddy.asm.Advice.OffsetMapping parse(java.lang.String r9) {
                /*
                    Method dump skipped, instruction units count: 278
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.parse(java.lang.String):net.bytebuddy.asm.Advice$OffsetMapping");
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.renderers.equals(((ForOrigin) obj).renderers);
            }

            public int hashCode() {
                return this.renderers.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                StringBuilder sb = new StringBuilder();
                Iterator<Renderer> it = this.renderers.iterator();
                while (it.hasNext()) {
                    sb.append(it.next().apply(typeDescription, methodDescription));
                }
                return Target.ForStackManipulation.of(sb.toString());
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForSerializedValue implements OffsetMapping {
            private final StackManipulation deserialization;
            private final TypeDescription.Generic target;
            private final TypeDescription typeDescription;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;
                private final StackManipulation deserialization;
                private final TypeDescription typeDescription;

                public Factory(Class<T> cls, TypeDescription typeDescription, StackManipulation stackManipulation) {
                    this.annotationType = cls;
                    this.typeDescription = typeDescription;
                    this.deserialization = stackManipulation;
                }

                public static <S extends Annotation> Factory<S> of(Class<S> cls, Serializable serializable, Class<?> cls2) {
                    if (cls2.isInstance(serializable)) {
                        return new Factory(cls, TypeDescription.ForLoadedType.of(cls2), SerializedConstant.of(serializable));
                    }
                    throw new IllegalArgumentException(serializable + " is no instance of " + cls2);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Factory factory = (Factory) obj;
                    return this.annotationType.equals(factory.annotationType) && this.typeDescription.equals(factory.typeDescription) && this.deserialization.equals(factory.deserialization);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return this.deserialization.hashCode() + a.i(this.typeDescription, a.e(getClass().hashCode() * 31, 31, this.annotationType), 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                    return new ForSerializedValue(inDefinedShape.getType(), this.typeDescription, this.deserialization);
                }
            }

            public ForSerializedValue(TypeDescription.Generic generic, TypeDescription typeDescription, StackManipulation stackManipulation) {
                this.target = generic;
                this.typeDescription = typeDescription;
                this.deserialization = stackManipulation;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForSerializedValue forSerializedValue = (ForSerializedValue) obj;
                return this.target.equals(forSerializedValue.target) && this.typeDescription.equals(forSerializedValue.typeDescription) && this.deserialization.equals(forSerializedValue.deserialization);
            }

            public int hashCode() {
                return this.deserialization.hashCode() + a.i(this.typeDescription, a.h(this.target, getClass().hashCode() * 31, 31), 31);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                StackManipulation stackManipulationAssign = assigner.assign(this.typeDescription.asGenericType(), this.target, Assigner.Typing.DYNAMIC);
                if (stackManipulationAssign.isValid()) {
                    return new Target.ForStackManipulation(new StackManipulation.Compound(this.deserialization, stackManipulationAssign));
                }
                throw new IllegalStateException("Cannot assign " + this.typeDescription + " to " + this.target);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForStackManipulation implements OffsetMapping {
            private final StackManipulation stackManipulation;
            private final TypeDescription.Generic targetType;
            private final TypeDescription.Generic typeDescription;
            private final Assigner.Typing typing;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;
                private final StackManipulation stackManipulation;
                private final TypeDescription.Generic typeDescription;

                public Factory(Class<T> cls, TypeDescription typeDescription) {
                    this(cls, ClassConstant.of(typeDescription), TypeDescription.ForLoadedType.of(Class.class).asGenericType());
                }

                public static <S extends Annotation> Factory<S> of(Class<S> cls, @MaybeNull Object obj) {
                    StackManipulation javaConstantValue;
                    TypeDescription typeDescription;
                    StackManipulation stackManipulationOf;
                    TypeDescription typeDescriptionOf;
                    if (obj == null) {
                        return new OfDefaultValue(cls);
                    }
                    if (obj instanceof Boolean) {
                        stackManipulationOf = IntegerConstant.forValue(((Boolean) obj).booleanValue());
                        typeDescriptionOf = TypeDescription.ForLoadedType.of(Boolean.TYPE);
                    } else if (obj instanceof Byte) {
                        stackManipulationOf = IntegerConstant.forValue(((Byte) obj).byteValue());
                        typeDescriptionOf = TypeDescription.ForLoadedType.of(Byte.TYPE);
                    } else if (obj instanceof Short) {
                        stackManipulationOf = IntegerConstant.forValue(((Short) obj).shortValue());
                        typeDescriptionOf = TypeDescription.ForLoadedType.of(Short.TYPE);
                    } else if (obj instanceof Character) {
                        stackManipulationOf = IntegerConstant.forValue(((Character) obj).charValue());
                        typeDescriptionOf = TypeDescription.ForLoadedType.of(Character.TYPE);
                    } else if (obj instanceof Integer) {
                        stackManipulationOf = IntegerConstant.forValue(((Integer) obj).intValue());
                        typeDescriptionOf = TypeDescription.ForLoadedType.of(Integer.TYPE);
                    } else if (obj instanceof Long) {
                        stackManipulationOf = LongConstant.forValue(((Long) obj).longValue());
                        typeDescriptionOf = TypeDescription.ForLoadedType.of(Long.TYPE);
                    } else if (obj instanceof Float) {
                        stackManipulationOf = FloatConstant.forValue(((Float) obj).floatValue());
                        typeDescriptionOf = TypeDescription.ForLoadedType.of(Float.TYPE);
                    } else if (obj instanceof Double) {
                        stackManipulationOf = DoubleConstant.forValue(((Double) obj).doubleValue());
                        typeDescriptionOf = TypeDescription.ForLoadedType.of(Double.TYPE);
                    } else {
                        if (obj instanceof String) {
                            javaConstantValue = new TextConstant((String) obj);
                            typeDescription = TypeDescription.ForLoadedType.of(String.class);
                        } else if (obj instanceof Class) {
                            stackManipulationOf = ClassConstant.of(TypeDescription.ForLoadedType.of((Class) obj));
                            typeDescriptionOf = TypeDescription.ForLoadedType.of(Class.class);
                        } else if (obj instanceof TypeDescription) {
                            stackManipulationOf = ClassConstant.of((TypeDescription) obj);
                            typeDescriptionOf = TypeDescription.ForLoadedType.of(Class.class);
                        } else if (obj instanceof Enum) {
                            Enum r42 = (Enum) obj;
                            javaConstantValue = FieldAccess.forEnumeration(new EnumerationDescription.ForLoadedEnumeration(r42));
                            typeDescription = TypeDescription.ForLoadedType.of(r42.getDeclaringClass());
                        } else if (obj instanceof EnumerationDescription) {
                            EnumerationDescription enumerationDescription = (EnumerationDescription) obj;
                            javaConstantValue = FieldAccess.forEnumeration(enumerationDescription);
                            typeDescription = enumerationDescription.getEnumerationType();
                        } else if (JavaType.METHOD_HANDLE.isInstance(obj)) {
                            JavaConstant.MethodHandle methodHandleOfLoaded = JavaConstant.MethodHandle.ofLoaded(obj);
                            javaConstantValue = new JavaConstantValue(methodHandleOfLoaded);
                            typeDescription = methodHandleOfLoaded.getTypeDescription();
                        } else if (JavaType.METHOD_TYPE.isInstance(obj)) {
                            JavaConstant.MethodType methodTypeOfLoaded = JavaConstant.MethodType.ofLoaded(obj);
                            javaConstantValue = new JavaConstantValue(methodTypeOfLoaded);
                            typeDescription = methodTypeOfLoaded.getTypeDescription();
                        } else {
                            if (!(obj instanceof JavaConstant)) {
                                throw new IllegalStateException(androidx.constraintlayout.core.motion.a.m(obj, "Not a constant value: "));
                            }
                            JavaConstant javaConstant = (JavaConstant) obj;
                            javaConstantValue = new JavaConstantValue(javaConstant);
                            typeDescription = javaConstant.getTypeDescription();
                        }
                        StackManipulation stackManipulation = javaConstantValue;
                        typeDescriptionOf = typeDescription;
                        stackManipulationOf = stackManipulation;
                    }
                    return new Factory(cls, stackManipulationOf, typeDescriptionOf.asGenericType());
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Factory factory = (Factory) obj;
                    return this.annotationType.equals(factory.annotationType) && this.stackManipulation.equals(factory.stackManipulation) && this.typeDescription.equals(factory.typeDescription);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return this.typeDescription.hashCode() + ((this.stackManipulation.hashCode() + a.e(getClass().hashCode() * 31, 31, this.annotationType)) * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                    return new ForStackManipulation(this.stackManipulation, this.typeDescription, inDefinedShape.getType(), Assigner.Typing.STATIC);
                }

                public Factory(Class<T> cls, EnumerationDescription enumerationDescription) {
                    this(cls, FieldAccess.forEnumeration(enumerationDescription), enumerationDescription.getEnumerationType().asGenericType());
                }

                public Factory(Class<T> cls, StackManipulation stackManipulation, TypeDescription.Generic generic) {
                    this.annotationType = cls;
                    this.stackManipulation = stackManipulation;
                    this.typeDescription = generic;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfAnnotationProperty<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;
                private final MethodDescription.InDefinedShape property;

                public OfAnnotationProperty(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape) {
                    this.annotationType = cls;
                    this.property = inDefinedShape;
                }

                public static <S extends Annotation> Factory<S> of(Class<S> cls, String str) {
                    if (!cls.isAnnotation()) {
                        throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.j(cls, "Not an annotation type: "));
                    }
                    try {
                        return new OfAnnotationProperty(cls, new MethodDescription.ForLoadedMethod(cls.getMethod(str, new Class[0])));
                    } catch (NoSuchMethodException e) {
                        throw new IllegalArgumentException("Cannot find a property " + str + " on " + cls, e);
                    }
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    OfAnnotationProperty ofAnnotationProperty = (OfAnnotationProperty) obj;
                    return this.annotationType.equals(ofAnnotationProperty.annotationType) && this.property.equals(ofAnnotationProperty.property);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return this.property.hashCode() + a.e(getClass().hashCode() * 31, 31, this.annotationType);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                    Factory factoryOf;
                    Object objResolve = loadable.getValue(this.property).resolve();
                    if (objResolve instanceof TypeDescription) {
                        factoryOf = new Factory(this.annotationType, (TypeDescription) objResolve);
                    } else if (objResolve instanceof EnumerationDescription) {
                        factoryOf = new Factory(this.annotationType, (EnumerationDescription) objResolve);
                    } else {
                        if (objResolve instanceof AnnotationDescription) {
                            throw new IllegalStateException("Cannot bind annotation as fixed value for " + this.property);
                        }
                        factoryOf = Factory.of(this.annotationType, objResolve);
                    }
                    return factoryOf.make(inDefinedShape, loadable, adviceType);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfDefaultValue<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;

                public OfDefaultValue(Class<T> cls) {
                    this.annotationType = cls;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.annotationType.equals(((OfDefaultValue) obj).annotationType);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return this.annotationType.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                    return new ForStackManipulation(DefaultValue.of(inDefinedShape.getType()), inDefinedShape.getType(), inDefinedShape.getType(), Assigner.Typing.STATIC);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfDynamicInvocation<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;
                private final List<? extends JavaConstant> arguments;
                private final MethodDescription.InDefinedShape bootstrapMethod;

                public OfDynamicInvocation(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape, List<? extends JavaConstant> list) {
                    this.annotationType = cls;
                    this.bootstrapMethod = inDefinedShape;
                    this.arguments = list;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    OfDynamicInvocation ofDynamicInvocation = (OfDynamicInvocation) obj;
                    return this.annotationType.equals(ofDynamicInvocation.annotationType) && this.bootstrapMethod.equals(ofDynamicInvocation.bootstrapMethod) && this.arguments.equals(ofDynamicInvocation.arguments);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return this.arguments.hashCode() + ((this.bootstrapMethod.hashCode() + a.e(getClass().hashCode() * 31, 31, this.annotationType)) * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                    if (!inDefinedShape.getType().isInterface()) {
                        throw new IllegalArgumentException(inDefinedShape.getType() + " is not an interface");
                    }
                    if (!inDefinedShape.getType().getInterfaces().isEmpty()) {
                        throw new IllegalArgumentException(inDefinedShape.getType() + " must not extend other interfaces");
                    }
                    if (!inDefinedShape.getType().isPublic()) {
                        throw new IllegalArgumentException(inDefinedShape.getType() + " is mot public");
                    }
                    MethodList methodListFilter = inDefinedShape.getType().getDeclaredMethods().filter(ElementMatchers.isAbstract());
                    if (methodListFilter.size() == 1) {
                        return new ForStackManipulation(MethodInvocation.invoke(this.bootstrapMethod).dynamic(((MethodDescription) methodListFilter.getOnly()).getInternalName(), inDefinedShape.getType().asErasure(), Collections.EMPTY_LIST, this.arguments), inDefinedShape.getType(), inDefinedShape.getType(), Assigner.Typing.STATIC);
                    }
                    throw new IllegalArgumentException(inDefinedShape.getType() + " must declare exactly one abstract method");
                }
            }

            public ForStackManipulation(StackManipulation stackManipulation, TypeDescription.Generic generic, TypeDescription.Generic generic2, Assigner.Typing typing) {
                this.stackManipulation = stackManipulation;
                this.typeDescription = generic;
                this.targetType = generic2;
                this.typing = typing;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForStackManipulation forStackManipulation = (ForStackManipulation) obj;
                return this.typing.equals(forStackManipulation.typing) && this.stackManipulation.equals(forStackManipulation.stackManipulation) && this.typeDescription.equals(forStackManipulation.typeDescription) && this.targetType.equals(forStackManipulation.targetType);
            }

            public int hashCode() {
                return this.typing.hashCode() + a.h(this.targetType, a.h(this.typeDescription, (this.stackManipulation.hashCode() + (getClass().hashCode() * 31)) * 31, 31), 31);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                StackManipulation stackManipulationAssign = assigner.assign(this.typeDescription, this.targetType, this.typing);
                if (stackManipulationAssign.isValid()) {
                    return new Target.ForStackManipulation(new StackManipulation.Compound(this.stackManipulation, stackManipulationAssign));
                }
                throw new IllegalStateException("Cannot assign " + this.typeDescription + " to " + this.targetType);
            }
        }

        public enum ForStubValue implements OffsetMapping, Factory<StubValue> {
            INSTANCE;

            @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
            public Class<StubValue> getAnnotationType() {
                return StubValue.class;
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
            public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<StubValue> loadable, Factory.AdviceType adviceType) {
                if (inDefinedShape.getType().represents(Object.class)) {
                    return this;
                }
                throw new IllegalStateException("Cannot use StubValue on non-Object parameter type " + inDefinedShape);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                return new Target.ForDefaultValue.ReadOnly(methodDescription.getReturnType(), assigner.assign(methodDescription.getReturnType(), TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class), Assigner.Typing.DYNAMIC));
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForUnusedValue implements OffsetMapping {
            private final TypeDefinition target;

            public enum Factory implements Factory<Unused> {
                INSTANCE;

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<Unused> getAnnotationType() {
                    return Unused.class;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Unused> loadable, Factory.AdviceType adviceType) {
                    return new ForUnusedValue(inDefinedShape.getType());
                }
            }

            public ForUnusedValue(TypeDefinition typeDefinition) {
                this.target = typeDefinition;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.target.equals(((ForUnusedValue) obj).target);
            }

            public int hashCode() {
                return this.target.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                return new Target.ForDefaultValue.ReadWrite(this.target);
            }
        }

        public enum Sort {
            ENTER { // from class: net.bytebuddy.asm.Advice.OffsetMapping.Sort.1
                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Sort
                public boolean isPremature(MethodDescription methodDescription) {
                    return methodDescription.isConstructor();
                }
            },
            EXIT { // from class: net.bytebuddy.asm.Advice.OffsetMapping.Sort.2
                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Sort
                public boolean isPremature(MethodDescription methodDescription) {
                    return false;
                }
            };

            public abstract boolean isPremature(MethodDescription methodDescription);
        }

        public interface Target {

            public static abstract class AbstractReadOnlyAdapter implements Target {
                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                public StackManipulation resolveIncrement(int i) {
                    throw new IllegalStateException("Cannot write to read-only value");
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                public StackManipulation resolveWrite() {
                    throw new IllegalStateException("Cannot write to read-only value");
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class ForArray implements Target {
                protected final TypeDescription.Generic target;
                protected final List<? extends StackManipulation> valueReads;

                public static class ReadOnly extends ForArray {
                    public ReadOnly(TypeDescription.Generic generic, List<? extends StackManipulation> list) {
                        super(generic, list);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveWrite() {
                        throw new IllegalStateException("Cannot write to read-only array value");
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ReadWrite extends ForArray {
                    private final List<? extends StackManipulation> valueWrites;

                    public ReadWrite(TypeDescription.Generic generic, List<? extends StackManipulation> list, List<? extends StackManipulation> list2) {
                        super(generic, list);
                        this.valueWrites = list2;
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target.ForArray
                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.valueWrites.equals(((ReadWrite) obj).valueWrites);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target.ForArray
                    public int hashCode() {
                        return this.valueWrites.hashCode() + (super.hashCode() * 31);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveWrite() {
                        return new StackManipulation.Compound(ArrayAccess.of(this.target).forEach(this.valueWrites), Removal.SINGLE);
                    }
                }

                public ForArray(TypeDescription.Generic generic, List<? extends StackManipulation> list) {
                    this.target = generic;
                    this.valueReads = list;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForArray forArray = (ForArray) obj;
                    return this.target.equals(forArray.target) && this.valueReads.equals(forArray.valueReads);
                }

                public int hashCode() {
                    return this.valueReads.hashCode() + a.h(this.target, getClass().hashCode() * 31, 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                public StackManipulation resolveIncrement(int i) {
                    throw new IllegalStateException("Cannot increment read-only array value");
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                public StackManipulation resolveRead() {
                    return ArrayFactory.forType(this.target).withValues(this.valueReads);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class ForDefaultValue implements Target {
                protected final StackManipulation readAssignment;
                protected final TypeDefinition typeDefinition;

                public static class ReadOnly extends ForDefaultValue {
                    public ReadOnly(TypeDefinition typeDefinition) {
                        this(typeDefinition, StackManipulation.Trivial.INSTANCE);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveIncrement(int i) {
                        throw new IllegalStateException("Cannot write to read-only default value");
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveWrite() {
                        throw new IllegalStateException("Cannot write to read-only default value");
                    }

                    public ReadOnly(TypeDefinition typeDefinition, StackManipulation stackManipulation) {
                        super(typeDefinition, stackManipulation);
                    }
                }

                public static class ReadWrite extends ForDefaultValue {
                    public ReadWrite(TypeDefinition typeDefinition) {
                        this(typeDefinition, StackManipulation.Trivial.INSTANCE);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveIncrement(int i) {
                        return StackManipulation.Trivial.INSTANCE;
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveWrite() {
                        return Removal.of(this.typeDefinition);
                    }

                    public ReadWrite(TypeDefinition typeDefinition, StackManipulation stackManipulation) {
                        super(typeDefinition, stackManipulation);
                    }
                }

                public ForDefaultValue(TypeDefinition typeDefinition, StackManipulation stackManipulation) {
                    this.typeDefinition = typeDefinition;
                    this.readAssignment = stackManipulation;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForDefaultValue forDefaultValue = (ForDefaultValue) obj;
                    return this.typeDefinition.equals(forDefaultValue.typeDefinition) && this.readAssignment.equals(forDefaultValue.readAssignment);
                }

                public int hashCode() {
                    return this.readAssignment.hashCode() + ((this.typeDefinition.hashCode() + (getClass().hashCode() * 31)) * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                public StackManipulation resolveRead() {
                    return new StackManipulation.Compound(DefaultValue.of(this.typeDefinition), this.readAssignment);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class ForField implements Target {
                protected final FieldDescription fieldDescription;
                protected final StackManipulation readAssignment;

                public static class ReadOnly extends ForField {
                    public ReadOnly(FieldDescription fieldDescription) {
                        this(fieldDescription, StackManipulation.Trivial.INSTANCE);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveIncrement(int i) {
                        throw new IllegalStateException("Cannot write to read-only field value");
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveWrite() {
                        throw new IllegalStateException("Cannot write to read-only field value");
                    }

                    public ReadOnly(FieldDescription fieldDescription, StackManipulation stackManipulation) {
                        super(fieldDescription, stackManipulation);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ReadWrite extends ForField {
                    private final StackManipulation writeAssignment;

                    /* JADX WARN: Illegal instructions before constructor call */
                    public ReadWrite(FieldDescription fieldDescription) {
                        StackManipulation.Trivial trivial = StackManipulation.Trivial.INSTANCE;
                        this(fieldDescription, trivial, trivial);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target.ForField
                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.writeAssignment.equals(((ReadWrite) obj).writeAssignment);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target.ForField
                    public int hashCode() {
                        return this.writeAssignment.hashCode() + (super.hashCode() * 31);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveIncrement(int i) {
                        return new StackManipulation.Compound(resolveRead(), IntegerConstant.forValue(i), Addition.INTEGER, resolveWrite());
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveWrite() {
                        return new StackManipulation.Compound(this.writeAssignment, this.fieldDescription.isStatic() ? StackManipulation.Trivial.INSTANCE : new StackManipulation.Compound(MethodVariableAccess.loadThis(), Duplication.SINGLE.flipOver(this.fieldDescription.getType()), Removal.SINGLE), FieldAccess.forField(this.fieldDescription).write());
                    }

                    public ReadWrite(FieldDescription fieldDescription, StackManipulation stackManipulation, StackManipulation stackManipulation2) {
                        super(fieldDescription, stackManipulation);
                        this.writeAssignment = stackManipulation2;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class WriteOnly implements Target {
                    private final FieldDescription fieldDescription;
                    private final StackManipulation writeAssignment;

                    public WriteOnly(FieldDescription fieldDescription, StackManipulation stackManipulation) {
                        this.fieldDescription = fieldDescription;
                        this.writeAssignment = stackManipulation;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        WriteOnly writeOnly = (WriteOnly) obj;
                        return this.fieldDescription.equals(writeOnly.fieldDescription) && this.writeAssignment.equals(writeOnly.writeAssignment);
                    }

                    public int hashCode() {
                        return this.writeAssignment.hashCode() + ((this.fieldDescription.hashCode() + (getClass().hashCode() * 31)) * 31);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveIncrement(int i) {
                        throw new IllegalStateException("Cannot increment write-only field value");
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveRead() {
                        throw new IllegalStateException("Cannot read write-only field value");
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveWrite() {
                        return new StackManipulation.Compound(this.writeAssignment, this.fieldDescription.isStatic() ? StackManipulation.Trivial.INSTANCE : new StackManipulation.Compound(MethodVariableAccess.loadThis(), Duplication.SINGLE.flipOver(this.fieldDescription.getType()), Removal.SINGLE), FieldAccess.forField(this.fieldDescription).write());
                    }
                }

                public ForField(FieldDescription fieldDescription, StackManipulation stackManipulation) {
                    this.fieldDescription = fieldDescription;
                    this.readAssignment = stackManipulation;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForField forField = (ForField) obj;
                    return this.fieldDescription.equals(forField.fieldDescription) && this.readAssignment.equals(forField.readAssignment);
                }

                public int hashCode() {
                    return this.readAssignment.hashCode() + ((this.fieldDescription.hashCode() + (getClass().hashCode() * 31)) * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                public StackManipulation resolveRead() {
                    return new StackManipulation.Compound(this.fieldDescription.isStatic() ? StackManipulation.Trivial.INSTANCE : MethodVariableAccess.loadThis(), FieldAccess.forField(this.fieldDescription).read(), this.readAssignment);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForStackManipulation implements Target {
                private final StackManipulation stackManipulation;

                @HashCodeAndEqualsPlugin.Enhance
                public static class Writable implements Target {
                    private final StackManipulation read;
                    private final StackManipulation write;

                    public Writable(StackManipulation stackManipulation, StackManipulation stackManipulation2) {
                        this.read = stackManipulation;
                        this.write = stackManipulation2;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Writable writable = (Writable) obj;
                        return this.read.equals(writable.read) && this.write.equals(writable.write);
                    }

                    public int hashCode() {
                        return this.write.hashCode() + ((this.read.hashCode() + (getClass().hashCode() * 31)) * 31);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveIncrement(int i) {
                        throw new IllegalStateException("Cannot increment mutable constant value: " + this.write);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveRead() {
                        return this.read;
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveWrite() {
                        return this.write;
                    }
                }

                public ForStackManipulation(StackManipulation stackManipulation) {
                    this.stackManipulation = stackManipulation;
                }

                public static Target of(MethodDescription.InDefinedShape inDefinedShape) {
                    return new ForStackManipulation(MethodConstant.of(inDefinedShape));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.stackManipulation.equals(((ForStackManipulation) obj).stackManipulation);
                }

                public int hashCode() {
                    return this.stackManipulation.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                public StackManipulation resolveIncrement(int i) {
                    throw new IllegalStateException("Cannot write to constant value: " + this.stackManipulation);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                public StackManipulation resolveRead() {
                    return this.stackManipulation;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                public StackManipulation resolveWrite() {
                    throw new IllegalStateException("Cannot write to constant value: " + this.stackManipulation);
                }

                public static Target of(TypeDescription typeDescription) {
                    return new ForStackManipulation(ClassConstant.of(typeDescription));
                }

                public static Target of(Object obj) {
                    if (obj == null) {
                        return new ForStackManipulation(NullConstant.INSTANCE);
                    }
                    if (obj instanceof Boolean) {
                        return new ForStackManipulation(IntegerConstant.forValue(((Boolean) obj).booleanValue()));
                    }
                    if (obj instanceof Byte) {
                        return new ForStackManipulation(IntegerConstant.forValue(((Byte) obj).byteValue()));
                    }
                    if (obj instanceof Short) {
                        return new ForStackManipulation(IntegerConstant.forValue(((Short) obj).shortValue()));
                    }
                    if (obj instanceof Character) {
                        return new ForStackManipulation(IntegerConstant.forValue(((Character) obj).charValue()));
                    }
                    if (obj instanceof Integer) {
                        return new ForStackManipulation(IntegerConstant.forValue(((Integer) obj).intValue()));
                    }
                    if (obj instanceof Long) {
                        return new ForStackManipulation(LongConstant.forValue(((Long) obj).longValue()));
                    }
                    if (obj instanceof Float) {
                        return new ForStackManipulation(FloatConstant.forValue(((Float) obj).floatValue()));
                    }
                    if (obj instanceof Double) {
                        return new ForStackManipulation(DoubleConstant.forValue(((Double) obj).doubleValue()));
                    }
                    if (obj instanceof String) {
                        return new ForStackManipulation(new TextConstant((String) obj));
                    }
                    if (obj instanceof Enum) {
                        return new ForStackManipulation(FieldAccess.forEnumeration(new EnumerationDescription.ForLoadedEnumeration((Enum) obj)));
                    }
                    if (obj instanceof EnumerationDescription) {
                        return new ForStackManipulation(FieldAccess.forEnumeration((EnumerationDescription) obj));
                    }
                    if (obj instanceof Class) {
                        return new ForStackManipulation(ClassConstant.of(TypeDescription.ForLoadedType.of((Class) obj)));
                    }
                    if (obj instanceof TypeDescription) {
                        return new ForStackManipulation(ClassConstant.of((TypeDescription) obj));
                    }
                    if (JavaType.METHOD_HANDLE.isInstance(obj)) {
                        return new ForStackManipulation(new JavaConstantValue(JavaConstant.MethodHandle.ofLoaded(obj)));
                    }
                    if (JavaType.METHOD_TYPE.isInstance(obj)) {
                        return new ForStackManipulation(new JavaConstantValue(JavaConstant.MethodType.ofLoaded(obj)));
                    }
                    if (obj instanceof JavaConstant) {
                        return new ForStackManipulation(new JavaConstantValue((JavaConstant) obj));
                    }
                    throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.m(obj, "Not a constant value: "));
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class ForVariable implements Target {
                protected final int offset;
                protected final StackManipulation readAssignment;
                protected final TypeDefinition typeDefinition;

                public static class ReadOnly extends ForVariable {
                    public ReadOnly(TypeDefinition typeDefinition, int i) {
                        this(typeDefinition, i, StackManipulation.Trivial.INSTANCE);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveIncrement(int i) {
                        throw new IllegalStateException("Cannot write to read-only variable " + this.typeDefinition + " at " + this.offset);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveWrite() {
                        throw new IllegalStateException("Cannot write to read-only parameter " + this.typeDefinition + " at " + this.offset);
                    }

                    public ReadOnly(TypeDefinition typeDefinition, int i, StackManipulation stackManipulation) {
                        super(typeDefinition, i, stackManipulation);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ReadWrite extends ForVariable {
                    private final StackManipulation writeAssignment;

                    /* JADX WARN: Illegal instructions before constructor call */
                    public ReadWrite(TypeDefinition typeDefinition, int i) {
                        StackManipulation.Trivial trivial = StackManipulation.Trivial.INSTANCE;
                        this(typeDefinition, i, trivial, trivial);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target.ForVariable
                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.writeAssignment.equals(((ReadWrite) obj).writeAssignment);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target.ForVariable
                    public int hashCode() {
                        return this.writeAssignment.hashCode() + (super.hashCode() * 31);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveIncrement(int i) {
                        return this.typeDefinition.represents(Integer.TYPE) ? MethodVariableAccess.of(this.typeDefinition).increment(this.offset, i) : new StackManipulation.Compound(resolveRead(), IntegerConstant.forValue(1), Addition.INTEGER, resolveWrite());
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveWrite() {
                        return new StackManipulation.Compound(this.writeAssignment, MethodVariableAccess.of(this.typeDefinition).storeAt(this.offset));
                    }

                    public ReadWrite(TypeDefinition typeDefinition, int i, StackManipulation stackManipulation, StackManipulation stackManipulation2) {
                        super(typeDefinition, i, stackManipulation);
                        this.writeAssignment = stackManipulation2;
                    }
                }

                public ForVariable(TypeDefinition typeDefinition, int i, StackManipulation stackManipulation) {
                    this.typeDefinition = typeDefinition;
                    this.offset = i;
                    this.readAssignment = stackManipulation;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForVariable forVariable = (ForVariable) obj;
                    return this.offset == forVariable.offset && this.typeDefinition.equals(forVariable.typeDefinition) && this.readAssignment.equals(forVariable.readAssignment);
                }

                public int hashCode() {
                    return this.readAssignment.hashCode() + ((((this.typeDefinition.hashCode() + (getClass().hashCode() * 31)) * 31) + this.offset) * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                public StackManipulation resolveRead() {
                    return new StackManipulation.Compound(MethodVariableAccess.of(this.typeDefinition).loadFrom(this.offset), this.readAssignment);
                }
            }

            StackManipulation resolveIncrement(int i);

            StackManipulation resolveRead();

            StackManipulation resolveWrite();
        }

        Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort);

        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class ForArgument implements OffsetMapping {
            protected final boolean readOnly;
            protected final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Resolved extends ForArgument {
                private final ParameterDescription parameterDescription;

                @HashCodeAndEqualsPlugin.Enhance
                public static class Factory<T extends Annotation> implements Factory<T> {
                    private final Class<T> annotationType;
                    private final ParameterDescription parameterDescription;
                    private final boolean readOnly;
                    private final Assigner.Typing typing;

                    public Factory(Class<T> cls, ParameterDescription parameterDescription) {
                        this(cls, parameterDescription, true, Assigner.Typing.STATIC);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Factory factory = (Factory) obj;
                        return this.readOnly == factory.readOnly && this.typing.equals(factory.typing) && this.annotationType.equals(factory.annotationType) && this.parameterDescription.equals(factory.parameterDescription);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                    public Class<T> getAnnotationType() {
                        return this.annotationType;
                    }

                    public int hashCode() {
                        return this.typing.hashCode() + ((((this.parameterDescription.hashCode() + a.e(getClass().hashCode() * 31, 31, this.annotationType)) * 31) + (this.readOnly ? 1 : 0)) * 31);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                        return new Resolved(inDefinedShape.getType(), this.readOnly, this.typing, this.parameterDescription);
                    }

                    public Factory(Class<T> cls, ParameterDescription parameterDescription, boolean z6, Assigner.Typing typing) {
                        this.annotationType = cls;
                        this.parameterDescription = parameterDescription;
                        this.readOnly = z6;
                        this.typing = typing;
                    }
                }

                public Resolved(TypeDescription.Generic generic, boolean z6, Assigner.Typing typing, ParameterDescription parameterDescription) {
                    super(generic, z6, typing);
                    this.parameterDescription = parameterDescription;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForArgument
                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.parameterDescription.equals(((Resolved) obj).parameterDescription);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForArgument
                public int hashCode() {
                    return this.parameterDescription.hashCode() + (super.hashCode() * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForArgument
                public ParameterDescription resolve(MethodDescription methodDescription) {
                    if (this.parameterDescription.getDeclaringMethod().equals(methodDescription)) {
                        return this.parameterDescription;
                    }
                    throw new IllegalStateException(this.parameterDescription + " is not a parameter of " + methodDescription);
                }
            }

            public ForArgument(TypeDescription.Generic generic, boolean z6, Assigner.Typing typing) {
                this.target = generic;
                this.readOnly = z6;
                this.typing = typing;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForArgument forArgument = (ForArgument) obj;
                return this.readOnly == forArgument.readOnly && this.typing.equals(forArgument.typing) && this.target.equals(forArgument.target);
            }

            public int hashCode() {
                return this.typing.hashCode() + ((a.h(this.target, getClass().hashCode() * 31, 31) + (this.readOnly ? 1 : 0)) * 31);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                ParameterDescription parameterDescriptionResolve = resolve(methodDescription);
                StackManipulation stackManipulationAssign = assigner.assign(parameterDescriptionResolve.getType(), this.target, this.typing);
                if (!stackManipulationAssign.isValid()) {
                    throw new IllegalStateException("Cannot assign " + parameterDescriptionResolve + " to " + this.target);
                }
                if (this.readOnly) {
                    return new Target.ForVariable.ReadOnly(parameterDescriptionResolve.getType(), argumentHandler.argument(parameterDescriptionResolve.getOffset()), stackManipulationAssign);
                }
                StackManipulation stackManipulationAssign2 = assigner.assign(this.target, parameterDescriptionResolve.getType(), this.typing);
                if (stackManipulationAssign2.isValid()) {
                    return new Target.ForVariable.ReadWrite(parameterDescriptionResolve.getType(), argumentHandler.argument(parameterDescriptionResolve.getOffset()), stackManipulationAssign, stackManipulationAssign2);
                }
                throw new IllegalStateException("Cannot assign " + parameterDescriptionResolve + " to " + this.target);
            }

            public abstract ParameterDescription resolve(MethodDescription methodDescription);

            @HashCodeAndEqualsPlugin.Enhance
            public static class Unresolved extends ForArgument {
                private final int index;
                private final boolean optional;

                public enum Factory implements Factory<Argument> {
                    INSTANCE;

                    private static final MethodDescription.InDefinedShape ARGUMENT_OPTIONAL;
                    private static final MethodDescription.InDefinedShape ARGUMENT_READ_ONLY;
                    private static final MethodDescription.InDefinedShape ARGUMENT_TYPING;
                    private static final MethodDescription.InDefinedShape ARGUMENT_VALUE;

                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(Argument.class).getDeclaredMethods();
                        ARGUMENT_VALUE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("value")).getOnly();
                        ARGUMENT_READ_ONLY = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("readOnly")).getOnly();
                        ARGUMENT_TYPING = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("typing")).getOnly();
                        ARGUMENT_OPTIONAL = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("optional")).getOnly();
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                    public Class<Argument> getAnnotationType() {
                        return Argument.class;
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Argument> loadable, Factory.AdviceType adviceType) {
                        if (!adviceType.isDelegation() || ((Boolean) loadable.getValue(ARGUMENT_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                            return new Unresolved(inDefinedShape.getType(), loadable);
                        }
                        throw new IllegalStateException("Cannot define writable field access for " + inDefinedShape + " when using delegation");
                    }
                }

                public Unresolved(TypeDescription.Generic generic, AnnotationDescription.Loadable<Argument> loadable) {
                    this(generic, ((Boolean) loadable.getValue(Factory.ARGUMENT_READ_ONLY).resolve(Boolean.class)).booleanValue(), (Assigner.Typing) a.k(Argument.class, loadable.getValue(Factory.ARGUMENT_TYPING), Assigner.Typing.class), ((Integer) loadable.getValue(Factory.ARGUMENT_VALUE).resolve(Integer.class)).intValue(), ((Boolean) loadable.getValue(Factory.ARGUMENT_OPTIONAL).resolve(Boolean.class)).booleanValue());
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForArgument
                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Unresolved unresolved = (Unresolved) obj;
                    return this.index == unresolved.index && this.optional == unresolved.optional;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForArgument
                public int hashCode() {
                    return (((super.hashCode() * 31) + this.index) * 31) + (this.optional ? 1 : 0);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForArgument
                public ParameterDescription resolve(MethodDescription methodDescription) {
                    ParameterList<?> parameters = methodDescription.getParameters();
                    int size = parameters.size();
                    int i = this.index;
                    if (size > i) {
                        return (ParameterDescription) parameters.get(i);
                    }
                    throw new IllegalStateException(methodDescription + " does not define an index " + this.index);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForArgument, net.bytebuddy.asm.Advice.OffsetMapping
                public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                    if (!this.optional || methodDescription.getParameters().size() > this.index) {
                        return super.resolve(typeDescription, methodDescription, assigner, argumentHandler, sort);
                    }
                    return this.readOnly ? new Target.ForDefaultValue.ReadOnly(this.target) : new Target.ForDefaultValue.ReadWrite(this.target);
                }

                public Unresolved(ParameterDescription parameterDescription) {
                    this(parameterDescription.getType(), true, Assigner.Typing.STATIC, parameterDescription.getIndex());
                }

                public Unresolved(TypeDescription.Generic generic, boolean z6, Assigner.Typing typing, int i) {
                    this(generic, z6, typing, i, false);
                }

                public Unresolved(TypeDescription.Generic generic, boolean z6, Assigner.Typing typing, int i, boolean z7) {
                    super(generic, z6, typing);
                    this.index = i;
                    this.optional = z7;
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class ForField implements OffsetMapping {
            private static final MethodDescription.InDefinedShape DECLARING_TYPE;
            private static final MethodDescription.InDefinedShape READ_ONLY;
            private static final MethodDescription.InDefinedShape TYPING;
            private static final MethodDescription.InDefinedShape VALUE;
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Resolved extends ForField {
                private final FieldDescription fieldDescription;

                @HashCodeAndEqualsPlugin.Enhance
                public static class Factory<T extends Annotation> implements Factory<T> {
                    private final Class<T> annotationType;
                    private final FieldDescription fieldDescription;
                    private final boolean readOnly;
                    private final Assigner.Typing typing;

                    public Factory(Class<T> cls, FieldDescription fieldDescription) {
                        this(cls, fieldDescription, true, Assigner.Typing.STATIC);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Factory factory = (Factory) obj;
                        return this.readOnly == factory.readOnly && this.typing.equals(factory.typing) && this.annotationType.equals(factory.annotationType) && this.fieldDescription.equals(factory.fieldDescription);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                    public Class<T> getAnnotationType() {
                        return this.annotationType;
                    }

                    public int hashCode() {
                        return this.typing.hashCode() + ((((this.fieldDescription.hashCode() + a.e(getClass().hashCode() * 31, 31, this.annotationType)) * 31) + (this.readOnly ? 1 : 0)) * 31);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                        return new Resolved(inDefinedShape.getType(), this.readOnly, this.typing, this.fieldDescription);
                    }

                    public Factory(Class<T> cls, FieldDescription fieldDescription, boolean z6, Assigner.Typing typing) {
                        this.annotationType = cls;
                        this.fieldDescription = fieldDescription;
                        this.readOnly = z6;
                        this.typing = typing;
                    }
                }

                public Resolved(TypeDescription.Generic generic, boolean z6, Assigner.Typing typing, FieldDescription fieldDescription) {
                    super(generic, z6, typing);
                    this.fieldDescription = fieldDescription;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForField
                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((Resolved) obj).fieldDescription);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForField
                public int hashCode() {
                    return this.fieldDescription.hashCode() + (super.hashCode() * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForField
                @SuppressFBWarnings(justification = "Assuming declaring type for type member.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                public FieldDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                    if (!this.fieldDescription.isStatic() && !this.fieldDescription.getDeclaringType().asErasure().isAssignableFrom(typeDescription)) {
                        throw new IllegalStateException(this.fieldDescription + " is no member of " + typeDescription);
                    }
                    if (this.fieldDescription.isVisibleTo(typeDescription)) {
                        return this.fieldDescription;
                    }
                    throw new IllegalStateException("Cannot access " + this.fieldDescription + " from " + typeDescription);
                }
            }

            static {
                MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(FieldValue.class).getDeclaredMethods();
                VALUE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("value")).getOnly();
                DECLARING_TYPE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("declaringType")).getOnly();
                READ_ONLY = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("readOnly")).getOnly();
                TYPING = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("typing")).getOnly();
            }

            public ForField(TypeDescription.Generic generic, boolean z6, Assigner.Typing typing) {
                this.target = generic;
                this.readOnly = z6;
                this.typing = typing;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForField forField = (ForField) obj;
                return this.readOnly == forField.readOnly && this.typing.equals(forField.typing) && this.target.equals(forField.target);
            }

            public int hashCode() {
                return this.typing.hashCode() + ((a.h(this.target, getClass().hashCode() * 31, 31) + (this.readOnly ? 1 : 0)) * 31);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                FieldDescription fieldDescriptionResolve = resolve(typeDescription, methodDescription);
                if (!fieldDescriptionResolve.isStatic() && methodDescription.isStatic()) {
                    throw new IllegalStateException("Cannot read non-static field " + fieldDescriptionResolve + " from static method " + methodDescription);
                }
                if (sort.isPremature(methodDescription) && !fieldDescriptionResolve.isStatic()) {
                    if (this.readOnly) {
                        throw new IllegalStateException("Cannot assign " + fieldDescriptionResolve + " to " + this.target);
                    }
                    StackManipulation stackManipulationAssign = assigner.assign(this.target, fieldDescriptionResolve.getType(), this.typing);
                    if (stackManipulationAssign.isValid()) {
                        return new Target.ForField.WriteOnly(fieldDescriptionResolve.asDefined(), stackManipulationAssign);
                    }
                    throw new IllegalStateException("Cannot assign " + this.target + " to " + fieldDescriptionResolve);
                }
                StackManipulation stackManipulationAssign2 = assigner.assign(fieldDescriptionResolve.getType(), this.target, this.typing);
                if (!stackManipulationAssign2.isValid()) {
                    throw new IllegalStateException("Cannot assign " + fieldDescriptionResolve + " to " + this.target);
                }
                if (this.readOnly) {
                    return new Target.ForField.ReadOnly(fieldDescriptionResolve, stackManipulationAssign2);
                }
                StackManipulation stackManipulationAssign3 = assigner.assign(this.target, fieldDescriptionResolve.getType(), this.typing);
                if (stackManipulationAssign3.isValid()) {
                    return new Target.ForField.ReadWrite(fieldDescriptionResolve.asDefined(), stackManipulationAssign2, stackManipulationAssign3);
                }
                throw new IllegalStateException("Cannot assign " + this.target + " to " + fieldDescriptionResolve);
            }

            public abstract FieldDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription);

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class Unresolved extends ForField {
                protected static final String BEAN_PROPERTY = "";
                private final String name;

                public enum Factory implements Factory<FieldValue> {
                    INSTANCE;

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                    public Class<FieldValue> getAnnotationType() {
                        return FieldValue.class;
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<FieldValue> loadable, Factory.AdviceType adviceType) {
                        if (!adviceType.isDelegation() || ((Boolean) loadable.getValue(ForField.READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                            TypeDescription typeDescription = (TypeDescription) loadable.getValue(ForField.DECLARING_TYPE).resolve(TypeDescription.class);
                            return typeDescription.represents(Void.TYPE) ? new WithImplicitType(inDefinedShape.getType(), loadable) : new WithExplicitType(inDefinedShape.getType(), loadable, typeDescription);
                        }
                        throw new IllegalStateException("Cannot write to field for " + inDefinedShape + " in read-only context");
                    }
                }

                public Unresolved(TypeDescription.Generic generic, boolean z6, Assigner.Typing typing, String str) {
                    super(generic, z6, typing);
                    this.name = str;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static FieldLocator.Resolution resolveAccessor(FieldLocator fieldLocator, MethodDescription methodDescription) {
                    String strSubstring;
                    if (ElementMatchers.isSetter().matches(methodDescription)) {
                        strSubstring = methodDescription.getInternalName().substring(3);
                    } else {
                        if (!ElementMatchers.isGetter().matches(methodDescription)) {
                            return FieldLocator.Resolution.Illegal.INSTANCE;
                        }
                        strSubstring = methodDescription.getInternalName().substring(methodDescription.getInternalName().startsWith("is") ? 2 : 3);
                    }
                    return fieldLocator.locate(Character.toLowerCase(strSubstring.charAt(0)) + strSubstring.substring(1));
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForField
                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.name.equals(((Unresolved) obj).name);
                }

                public abstract FieldLocator fieldLocator(TypeDescription typeDescription);

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForField
                public int hashCode() {
                    return this.name.hashCode() + (super.hashCode() * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForField
                public FieldDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                    FieldLocator fieldLocator = fieldLocator(typeDescription);
                    FieldLocator.Resolution resolutionResolveAccessor = this.name.equals("") ? resolveAccessor(fieldLocator, methodDescription) : fieldLocator.locate(this.name);
                    if (resolutionResolveAccessor.isResolved()) {
                        return resolutionResolveAccessor.getField();
                    }
                    throw new IllegalStateException("Cannot locate field named " + this.name + " for " + typeDescription);
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class WithExplicitType extends Unresolved {
                    private final TypeDescription declaringType;

                    public WithExplicitType(TypeDescription.Generic generic, AnnotationDescription.Loadable<FieldValue> loadable, TypeDescription typeDescription) {
                        this(generic, ((Boolean) loadable.getValue(ForField.READ_ONLY).resolve(Boolean.class)).booleanValue(), (Assigner.Typing) a.k(Assigner.Typing.class, loadable.getValue(ForField.TYPING), Assigner.Typing.class), (String) loadable.getValue(ForField.VALUE).resolve(String.class), typeDescription);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForField.Unresolved, net.bytebuddy.asm.Advice.OffsetMapping.ForField
                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.declaringType.equals(((WithExplicitType) obj).declaringType);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForField.Unresolved
                    public FieldLocator fieldLocator(TypeDescription typeDescription) {
                        if (this.declaringType.represents(TargetType.class) || typeDescription.isAssignableTo(this.declaringType)) {
                            return new FieldLocator.ForExactType(TargetType.resolve(this.declaringType, typeDescription));
                        }
                        throw new IllegalStateException(this.declaringType + " is no super type of " + typeDescription);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForField.Unresolved, net.bytebuddy.asm.Advice.OffsetMapping.ForField
                    public int hashCode() {
                        return this.declaringType.hashCode() + (super.hashCode() * 31);
                    }

                    public WithExplicitType(TypeDescription.Generic generic, boolean z6, Assigner.Typing typing, String str, TypeDescription typeDescription) {
                        super(generic, z6, typing, str);
                        this.declaringType = typeDescription;
                    }
                }

                public static class WithImplicitType extends Unresolved {
                    public WithImplicitType(TypeDescription.Generic generic, AnnotationDescription.Loadable<FieldValue> loadable) {
                        this(generic, ((Boolean) loadable.getValue(ForField.READ_ONLY).resolve(Boolean.class)).booleanValue(), (Assigner.Typing) a.k(Assigner.Typing.class, loadable.getValue(ForField.TYPING), Assigner.Typing.class), (String) loadable.getValue(ForField.VALUE).resolve(String.class));
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForField.Unresolved
                    public FieldLocator fieldLocator(TypeDescription typeDescription) {
                        return new FieldLocator.ForClassHierarchy(typeDescription);
                    }

                    public WithImplicitType(TypeDescription.Generic generic, boolean z6, Assigner.Typing typing, String str) {
                        super(generic, z6, typing, str);
                    }
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForEnterValue implements OffsetMapping {
            private final TypeDescription.Generic enterType;
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory implements Factory<Enter> {
                private static final MethodDescription.InDefinedShape ENTER_READ_ONLY;
                private static final MethodDescription.InDefinedShape ENTER_TYPING;
                private final TypeDefinition enterType;

                static {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(Enter.class).getDeclaredMethods();
                    ENTER_READ_ONLY = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("readOnly")).getOnly();
                    ENTER_TYPING = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("typing")).getOnly();
                }

                public Factory(TypeDefinition typeDefinition) {
                    this.enterType = typeDefinition;
                }

                public static Factory<Enter> of(TypeDefinition typeDefinition) {
                    return typeDefinition.represents(Void.TYPE) ? new Factory.Illegal(Enter.class) : new Factory(typeDefinition);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.enterType.equals(((Factory) obj).enterType);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<Enter> getAnnotationType() {
                    return Enter.class;
                }

                public int hashCode() {
                    return this.enterType.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Enter> loadable, Factory.AdviceType adviceType) {
                    if (!adviceType.isDelegation() || ((Boolean) loadable.getValue(ENTER_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                        return new ForEnterValue(inDefinedShape.getType(), this.enterType.asGenericType(), loadable);
                    }
                    throw new IllegalStateException("Cannot use writable " + inDefinedShape + " on read-only parameter");
                }
            }

            public ForEnterValue(TypeDescription.Generic generic, TypeDescription.Generic generic2, AnnotationDescription.Loadable<Enter> loadable) {
                this(generic, generic2, ((Boolean) loadable.getValue(Factory.ENTER_READ_ONLY).resolve(Boolean.class)).booleanValue(), (Assigner.Typing) a.k(Enter.class, loadable.getValue(Factory.ENTER_TYPING), Assigner.Typing.class));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForEnterValue forEnterValue = (ForEnterValue) obj;
                return this.readOnly == forEnterValue.readOnly && this.typing.equals(forEnterValue.typing) && this.target.equals(forEnterValue.target) && this.enterType.equals(forEnterValue.enterType);
            }

            public int hashCode() {
                return this.typing.hashCode() + ((a.h(this.enterType, a.h(this.target, getClass().hashCode() * 31, 31), 31) + (this.readOnly ? 1 : 0)) * 31);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                StackManipulation stackManipulationAssign = assigner.assign(this.enterType, this.target, this.typing);
                if (!stackManipulationAssign.isValid()) {
                    throw new IllegalStateException("Cannot assign " + this.enterType + " to " + this.target);
                }
                if (this.readOnly) {
                    return new Target.ForVariable.ReadOnly(this.target, argumentHandler.enter(), stackManipulationAssign);
                }
                StackManipulation stackManipulationAssign2 = assigner.assign(this.target, this.enterType, this.typing);
                if (stackManipulationAssign2.isValid()) {
                    return new Target.ForVariable.ReadWrite(this.target, argumentHandler.enter(), stackManipulationAssign, stackManipulationAssign2);
                }
                throw new IllegalStateException("Cannot assign " + this.target + " to " + this.enterType);
            }

            public ForEnterValue(TypeDescription.Generic generic, TypeDescription.Generic generic2, boolean z6, Assigner.Typing typing) {
                this.target = generic;
                this.enterType = generic2;
                this.readOnly = z6;
                this.typing = typing;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForExitValue implements OffsetMapping {
            private final TypeDescription.Generic exitType;
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory implements Factory<Exit> {
                private static final MethodDescription.InDefinedShape EXIT_READ_ONLY;
                private static final MethodDescription.InDefinedShape EXIT_TYPING;
                private final TypeDefinition exitType;

                static {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(Exit.class).getDeclaredMethods();
                    EXIT_READ_ONLY = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("readOnly")).getOnly();
                    EXIT_TYPING = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("typing")).getOnly();
                }

                public Factory(TypeDefinition typeDefinition) {
                    this.exitType = typeDefinition;
                }

                public static Factory<Exit> of(TypeDefinition typeDefinition) {
                    return typeDefinition.represents(Void.TYPE) ? new Factory.Illegal(Exit.class) : new Factory(typeDefinition);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.exitType.equals(((Factory) obj).exitType);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<Exit> getAnnotationType() {
                    return Exit.class;
                }

                public int hashCode() {
                    return this.exitType.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Exit> loadable, Factory.AdviceType adviceType) {
                    if (!adviceType.isDelegation() || ((Boolean) loadable.getValue(EXIT_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                        return new ForExitValue(inDefinedShape.getType(), this.exitType.asGenericType(), loadable);
                    }
                    throw new IllegalStateException("Cannot use writable " + inDefinedShape + " on read-only parameter");
                }
            }

            public ForExitValue(TypeDescription.Generic generic, TypeDescription.Generic generic2, AnnotationDescription.Loadable<Exit> loadable) {
                this(generic, generic2, ((Boolean) loadable.getValue(Factory.EXIT_READ_ONLY).resolve(Boolean.class)).booleanValue(), (Assigner.Typing) a.k(Exit.class, loadable.getValue(Factory.EXIT_TYPING), Assigner.Typing.class));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForExitValue forExitValue = (ForExitValue) obj;
                return this.readOnly == forExitValue.readOnly && this.typing.equals(forExitValue.typing) && this.target.equals(forExitValue.target) && this.exitType.equals(forExitValue.exitType);
            }

            public int hashCode() {
                return this.typing.hashCode() + ((a.h(this.exitType, a.h(this.target, getClass().hashCode() * 31, 31), 31) + (this.readOnly ? 1 : 0)) * 31);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                StackManipulation stackManipulationAssign = assigner.assign(this.exitType, this.target, this.typing);
                if (!stackManipulationAssign.isValid()) {
                    throw new IllegalStateException("Cannot assign " + this.exitType + " to " + this.target);
                }
                if (this.readOnly) {
                    return new Target.ForVariable.ReadOnly(this.target, argumentHandler.exit(), stackManipulationAssign);
                }
                StackManipulation stackManipulationAssign2 = assigner.assign(this.target, this.exitType, this.typing);
                if (stackManipulationAssign2.isValid()) {
                    return new Target.ForVariable.ReadWrite(this.target, argumentHandler.exit(), stackManipulationAssign, stackManipulationAssign2);
                }
                throw new IllegalStateException("Cannot assign " + this.target + " to " + this.exitType);
            }

            public ForExitValue(TypeDescription.Generic generic, TypeDescription.Generic generic2, boolean z6, Assigner.Typing typing) {
                this.target = generic;
                this.exitType = generic2;
                this.readOnly = z6;
                this.typing = typing;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForReturnValue implements OffsetMapping {
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            public enum Factory implements Factory<Return> {
                INSTANCE;

                private static final MethodDescription.InDefinedShape RETURN_READ_ONLY;
                private static final MethodDescription.InDefinedShape RETURN_TYPING;

                static {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(Return.class).getDeclaredMethods();
                    RETURN_READ_ONLY = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("readOnly")).getOnly();
                    RETURN_TYPING = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("typing")).getOnly();
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<Return> getAnnotationType() {
                    return Return.class;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Return> loadable, Factory.AdviceType adviceType) {
                    if (!adviceType.isDelegation() || ((Boolean) loadable.getValue(RETURN_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                        return new ForReturnValue(inDefinedShape.getType(), loadable);
                    }
                    throw new IllegalStateException("Cannot write return value for " + inDefinedShape + " in read-only context");
                }
            }

            public ForReturnValue(TypeDescription.Generic generic, AnnotationDescription.Loadable<Return> loadable) {
                this(generic, ((Boolean) loadable.getValue(Factory.RETURN_READ_ONLY).resolve(Boolean.class)).booleanValue(), (Assigner.Typing) a.k(Return.class, loadable.getValue(Factory.RETURN_TYPING), Assigner.Typing.class));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForReturnValue forReturnValue = (ForReturnValue) obj;
                return this.readOnly == forReturnValue.readOnly && this.typing.equals(forReturnValue.typing) && this.target.equals(forReturnValue.target);
            }

            public int hashCode() {
                return this.typing.hashCode() + ((a.h(this.target, getClass().hashCode() * 31, 31) + (this.readOnly ? 1 : 0)) * 31);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                StackManipulation stackManipulationAssign = assigner.assign(methodDescription.getReturnType(), this.target, this.typing);
                if (!stackManipulationAssign.isValid()) {
                    throw new IllegalStateException("Cannot assign " + methodDescription.getReturnType() + " to " + this.target);
                }
                boolean z6 = this.readOnly;
                Class cls = Void.TYPE;
                if (z6) {
                    return methodDescription.getReturnType().represents(cls) ? new Target.ForDefaultValue.ReadOnly(this.target) : new Target.ForVariable.ReadOnly(methodDescription.getReturnType(), argumentHandler.returned(), stackManipulationAssign);
                }
                StackManipulation stackManipulationAssign2 = assigner.assign(this.target, methodDescription.getReturnType(), this.typing);
                if (stackManipulationAssign2.isValid()) {
                    return methodDescription.getReturnType().represents(cls) ? new Target.ForDefaultValue.ReadWrite(this.target) : new Target.ForVariable.ReadWrite(methodDescription.getReturnType(), argumentHandler.returned(), stackManipulationAssign, stackManipulationAssign2);
                }
                throw new IllegalStateException("Cannot assign " + this.target + " to " + methodDescription.getReturnType());
            }

            public ForReturnValue(TypeDescription.Generic generic, boolean z6, Assigner.Typing typing) {
                this.target = generic;
                this.readOnly = z6;
                this.typing = typing;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForThrowable implements OffsetMapping {
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            public enum Factory implements Factory<Thrown> {
                INSTANCE;

                private static final MethodDescription.InDefinedShape THROWN_READ_ONLY;
                private static final MethodDescription.InDefinedShape THROWN_TYPING;

                static {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(Thrown.class).getDeclaredMethods();
                    THROWN_READ_ONLY = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("readOnly")).getOnly();
                    THROWN_TYPING = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("typing")).getOnly();
                }

                @SuppressFBWarnings(justification = "Assuming annotation for exit advice.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                public static Factory<?> of(MethodDescription.InDefinedShape inDefinedShape) {
                    return ((TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodExit.class).getValue(Advice.ON_THROWABLE).resolve(TypeDescription.class)).represents(NoExceptionHandler.class) ? new Factory.Illegal(Thrown.class) : INSTANCE;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<Thrown> getAnnotationType() {
                    return Thrown.class;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Thrown> loadable, Factory.AdviceType adviceType) {
                    if (!adviceType.isDelegation() || ((Boolean) loadable.getValue(THROWN_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                        return new ForThrowable(inDefinedShape.getType(), loadable);
                    }
                    throw new IllegalStateException("Cannot use writable " + inDefinedShape + " on read-only parameter");
                }
            }

            public ForThrowable(TypeDescription.Generic generic, AnnotationDescription.Loadable<Thrown> loadable) {
                this(generic, ((Boolean) loadable.getValue(Factory.THROWN_READ_ONLY).resolve(Boolean.class)).booleanValue(), (Assigner.Typing) a.k(Thrown.class, loadable.getValue(Factory.THROWN_TYPING), Assigner.Typing.class));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForThrowable forThrowable = (ForThrowable) obj;
                return this.readOnly == forThrowable.readOnly && this.typing.equals(forThrowable.typing) && this.target.equals(forThrowable.target);
            }

            public int hashCode() {
                return this.typing.hashCode() + ((a.h(this.target, getClass().hashCode() * 31, 31) + (this.readOnly ? 1 : 0)) * 31);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                StackManipulation stackManipulationAssign = assigner.assign(TypeDescription.ForLoadedType.of(Throwable.class).asGenericType(), this.target, this.typing);
                if (!stackManipulationAssign.isValid()) {
                    throw new IllegalStateException("Cannot assign Throwable to " + this.target);
                }
                if (this.readOnly) {
                    return new Target.ForVariable.ReadOnly(TypeDescription.ForLoadedType.of(Throwable.class), argumentHandler.thrown(), stackManipulationAssign);
                }
                StackManipulation stackManipulationAssign2 = assigner.assign(this.target, TypeDescription.ForLoadedType.of(Throwable.class).asGenericType(), this.typing);
                if (stackManipulationAssign2.isValid()) {
                    return new Target.ForVariable.ReadWrite(TypeDescription.ForLoadedType.of(Throwable.class), argumentHandler.thrown(), stackManipulationAssign, stackManipulationAssign2);
                }
                throw new IllegalStateException("Cannot assign " + this.target + " to Throwable");
            }

            public ForThrowable(TypeDescription.Generic generic, boolean z6, Assigner.Typing typing) {
                this.target = generic;
                this.readOnly = z6;
                this.typing = typing;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForAllArguments implements OffsetMapping {
            private final boolean nullIfEmpty;
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            public enum Factory implements Factory<AllArguments> {
                INSTANCE;

                private static final MethodDescription.InDefinedShape ALL_ARGUMENTS_NULL_IF_EMPTY;
                private static final MethodDescription.InDefinedShape ALL_ARGUMENTS_READ_ONLY;
                private static final MethodDescription.InDefinedShape ALL_ARGUMENTS_TYPING;

                static {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(AllArguments.class).getDeclaredMethods();
                    ALL_ARGUMENTS_READ_ONLY = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("readOnly")).getOnly();
                    ALL_ARGUMENTS_TYPING = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("typing")).getOnly();
                    ALL_ARGUMENTS_NULL_IF_EMPTY = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("nullIfEmpty")).getOnly();
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<AllArguments> getAnnotationType() {
                    return AllArguments.class;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<AllArguments> loadable, Factory.AdviceType adviceType) {
                    if (!inDefinedShape.getType().represents(Object.class) && !inDefinedShape.getType().isArray()) {
                        throw new IllegalStateException("Cannot use AllArguments annotation on a non-array type");
                    }
                    if (!adviceType.isDelegation() || ((Boolean) loadable.getValue(ALL_ARGUMENTS_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                        return new ForAllArguments(inDefinedShape.getType().represents(Object.class) ? TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class) : inDefinedShape.getType().getComponentType(), loadable);
                    }
                    throw new IllegalStateException("Cannot define writable field access for " + inDefinedShape);
                }
            }

            public ForAllArguments(TypeDescription.Generic generic, AnnotationDescription.Loadable<AllArguments> loadable) {
                this(generic, ((Boolean) loadable.getValue(Factory.ALL_ARGUMENTS_READ_ONLY).resolve(Boolean.class)).booleanValue(), (Assigner.Typing) a.k(AllArguments.class, loadable.getValue(Factory.ALL_ARGUMENTS_TYPING), Assigner.Typing.class), ((Boolean) loadable.getValue(Factory.ALL_ARGUMENTS_NULL_IF_EMPTY).resolve(Boolean.class)).booleanValue());
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForAllArguments forAllArguments = (ForAllArguments) obj;
                return this.readOnly == forAllArguments.readOnly && this.nullIfEmpty == forAllArguments.nullIfEmpty && this.typing.equals(forAllArguments.typing) && this.target.equals(forAllArguments.target);
            }

            public int hashCode() {
                return ((this.typing.hashCode() + ((a.h(this.target, getClass().hashCode() * 31, 31) + (this.readOnly ? 1 : 0)) * 31)) * 31) + (this.nullIfEmpty ? 1 : 0);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                if (this.nullIfEmpty && methodDescription.getParameters().isEmpty()) {
                    return this.readOnly ? new Target.ForStackManipulation(NullConstant.INSTANCE) : new Target.ForStackManipulation.Writable(NullConstant.INSTANCE, Removal.SINGLE);
                }
                ArrayList arrayList = new ArrayList(methodDescription.getParameters().size());
                Iterator<?> it = methodDescription.getParameters().iterator();
                while (it.hasNext()) {
                    ParameterDescription parameterDescription = (ParameterDescription) it.next();
                    StackManipulation stackManipulationAssign = assigner.assign(parameterDescription.getType(), this.target, this.typing);
                    if (!stackManipulationAssign.isValid()) {
                        throw new IllegalStateException("Cannot assign " + parameterDescription + " to " + this.target);
                    }
                    arrayList.add(new StackManipulation.Compound(MethodVariableAccess.of(parameterDescription.getType()).loadFrom(argumentHandler.argument(parameterDescription.getOffset())), stackManipulationAssign));
                }
                if (this.readOnly) {
                    return new Target.ForArray.ReadOnly(this.target, arrayList);
                }
                ArrayList arrayList2 = new ArrayList(methodDescription.getParameters().size());
                Iterator<?> it2 = methodDescription.getParameters().iterator();
                while (it2.hasNext()) {
                    ParameterDescription parameterDescription2 = (ParameterDescription) it2.next();
                    StackManipulation stackManipulationAssign2 = assigner.assign(this.target, parameterDescription2.getType(), this.typing);
                    if (!stackManipulationAssign2.isValid()) {
                        throw new IllegalStateException("Cannot assign " + this.target + " to " + parameterDescription2);
                    }
                    arrayList2.add(new StackManipulation.Compound(stackManipulationAssign2, MethodVariableAccess.of(parameterDescription2.getType()).storeAt(argumentHandler.argument(parameterDescription2.getOffset()))));
                }
                return new Target.ForArray.ReadWrite(this.target, arrayList, arrayList2);
            }

            public ForAllArguments(TypeDescription.Generic generic, boolean z6, Assigner.Typing typing, boolean z7) {
                this.target = generic;
                this.readOnly = z6;
                this.typing = typing;
                this.nullIfEmpty = z7;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForThisReference implements OffsetMapping {
            private final boolean optional;
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            public enum Factory implements Factory<This> {
                INSTANCE;

                private static final MethodDescription.InDefinedShape THIS_OPTIONAL;
                private static final MethodDescription.InDefinedShape THIS_READ_ONLY;
                private static final MethodDescription.InDefinedShape THIS_TYPING;

                static {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(This.class).getDeclaredMethods();
                    THIS_READ_ONLY = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("readOnly")).getOnly();
                    THIS_TYPING = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("typing")).getOnly();
                    THIS_OPTIONAL = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("optional")).getOnly();
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<This> getAnnotationType() {
                    return This.class;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<This> loadable, Factory.AdviceType adviceType) {
                    if (!adviceType.isDelegation() || ((Boolean) loadable.getValue(THIS_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                        return new ForThisReference(inDefinedShape.getType(), loadable);
                    }
                    throw new IllegalStateException("Cannot write to this reference for " + inDefinedShape + " in read-only context");
                }
            }

            public ForThisReference(TypeDescription.Generic generic, AnnotationDescription.Loadable<This> loadable) {
                this(generic, ((Boolean) loadable.getValue(Factory.THIS_READ_ONLY).resolve(Boolean.class)).booleanValue(), (Assigner.Typing) a.k(This.class, loadable.getValue(Factory.THIS_TYPING), Assigner.Typing.class), ((Boolean) loadable.getValue(Factory.THIS_OPTIONAL).resolve(Boolean.class)).booleanValue());
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForThisReference forThisReference = (ForThisReference) obj;
                return this.readOnly == forThisReference.readOnly && this.optional == forThisReference.optional && this.typing.equals(forThisReference.typing) && this.target.equals(forThisReference.target);
            }

            public int hashCode() {
                return ((this.typing.hashCode() + ((a.h(this.target, getClass().hashCode() * 31, 31) + (this.readOnly ? 1 : 0)) * 31)) * 31) + (this.optional ? 1 : 0);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                if (methodDescription.isStatic() || sort.isPremature(methodDescription)) {
                    if (this.optional) {
                        return this.readOnly ? new Target.ForDefaultValue.ReadOnly(typeDescription) : new Target.ForDefaultValue.ReadWrite(typeDescription);
                    }
                    throw new IllegalStateException(a.l("Cannot map this reference for static method or constructor start: ", methodDescription));
                }
                StackManipulation stackManipulationAssign = assigner.assign(typeDescription.asGenericType(), this.target, this.typing);
                if (!stackManipulationAssign.isValid()) {
                    throw new IllegalStateException("Cannot assign " + typeDescription + " to " + this.target);
                }
                if (this.readOnly) {
                    return new Target.ForVariable.ReadOnly(typeDescription.asGenericType(), argumentHandler.argument(0), stackManipulationAssign);
                }
                StackManipulation stackManipulationAssign2 = assigner.assign(this.target, typeDescription.asGenericType(), this.typing);
                if (stackManipulationAssign2.isValid()) {
                    return new Target.ForVariable.ReadWrite(typeDescription.asGenericType(), argumentHandler.argument(0), stackManipulationAssign, stackManipulationAssign2);
                }
                throw new IllegalStateException("Cannot assign " + this.target + " to " + typeDescription);
            }

            public ForThisReference(TypeDescription.Generic generic, boolean z6, Assigner.Typing typing, boolean z7) {
                this.target = generic;
                this.readOnly = z6;
                this.typing = typing;
                this.optional = z7;
            }
        }
    }

    private Advice(Dispatcher.Resolved.ForMethodEnter forMethodEnter, Dispatcher.Resolved.ForMethodExit forMethodExit, Assigner assigner, ExceptionHandler exceptionHandler, Implementation implementation) {
        this.methodEnter = forMethodEnter;
        this.methodExit = forMethodExit;
        this.assigner = assigner;
        this.exceptionHandler = exceptionHandler;
        this.delegate = implementation;
    }

    public static Advice to(Class<?> cls, ClassFileLocator classFileLocator) {
        return to(TypeDescription.ForLoadedType.of(cls), classFileLocator);
    }

    public Advice withExceptionHandler(ExceptionHandler exceptionHandler) {
        return new Advice(this.methodEnter, this.methodExit, this.assigner, exceptionHandler, this.delegate);
    }

    public static Advice to(TypeDescription typeDescription) {
        return to(typeDescription, ClassFileLocator.NoOp.INSTANCE);
    }

    public Implementation wrap(Implementation implementation) {
        return new Advice(this.methodEnter, this.methodExit, this.assigner, this.exceptionHandler, implementation);
    }

    public static Advice to(TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        return to(typeDescription, PostProcessor.NoOp.INSTANCE, classFileLocator, Collections.EMPTY_LIST, Delegator.ForStaticInvocation.INSTANCE);
    }

    public static Advice to(TypeDescription typeDescription, PostProcessor.Factory factory, ClassFileLocator classFileLocator, List<? extends OffsetMapping.Factory<?>> list, Delegator delegator) {
        Dispatcher.Unresolved unresolvedLocate = Dispatcher.Inactive.INSTANCE;
        Dispatcher.Unresolved unresolvedLocate2 = unresolvedLocate;
        for (MethodDescription.InDefinedShape inDefinedShape : typeDescription.getDeclaredMethods()) {
            unresolvedLocate = locate(OnMethodEnter.class, INLINE_ENTER, unresolvedLocate, inDefinedShape, delegator);
            unresolvedLocate2 = locate(OnMethodExit.class, INLINE_EXIT, unresolvedLocate2, inDefinedShape, delegator);
        }
        if (!unresolvedLocate.isAlive() && !unresolvedLocate2.isAlive()) {
            throw new IllegalArgumentException(a.m("No advice defined by ", typeDescription));
        }
        try {
            ClassReader classReaderOf = (unresolvedLocate.isBinary() || unresolvedLocate2.isBinary()) ? OpenedClassReader.of(classFileLocator.locate(typeDescription.getName()).resolve()) : UNDEFINED;
            return new Advice(unresolvedLocate.asMethodEnter(list, classReaderOf, unresolvedLocate2, factory), unresolvedLocate2.asMethodExit(list, classReaderOf, unresolvedLocate, factory));
        } catch (IOException e) {
            throw new IllegalStateException(a.m("Error reading class file of ", typeDescription), e);
        }
    }

    public static Advice to(Class<?> cls, Class<?> cls2) {
        ClassFileLocator compound;
        ClassLoader classLoader = cls.getClassLoader();
        ClassLoader classLoader2 = cls2.getClassLoader();
        if (classLoader == classLoader2) {
            compound = ClassFileLocator.ForClassLoader.of(classLoader);
        } else {
            compound = new ClassFileLocator.Compound(ClassFileLocator.ForClassLoader.of(classLoader), ClassFileLocator.ForClassLoader.of(classLoader2));
        }
        return to(cls, cls2, compound);
    }

    public static Advice to(Class<?> cls, Class<?> cls2, ClassFileLocator classFileLocator) {
        return to(TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(cls2), classFileLocator);
    }

    public static Advice to(TypeDescription typeDescription, TypeDescription typeDescription2) {
        return to(typeDescription, typeDescription2, ClassFileLocator.NoOp.INSTANCE);
    }

    public static Advice to(TypeDescription typeDescription, TypeDescription typeDescription2, ClassFileLocator classFileLocator) {
        return to(typeDescription, typeDescription2, PostProcessor.NoOp.INSTANCE, classFileLocator, Collections.EMPTY_LIST, Delegator.ForStaticInvocation.INSTANCE);
    }

    public static Advice to(TypeDescription typeDescription, TypeDescription typeDescription2, PostProcessor.Factory factory, ClassFileLocator classFileLocator, List<? extends OffsetMapping.Factory<?>> list, Delegator delegator) {
        Dispatcher.Unresolved unresolvedLocate = Dispatcher.Inactive.INSTANCE;
        Iterator<MethodDescription.InDefinedShape> it = typeDescription.getDeclaredMethods().iterator();
        Dispatcher.Unresolved unresolvedLocate2 = unresolvedLocate;
        while (it.hasNext()) {
            unresolvedLocate2 = locate(OnMethodEnter.class, INLINE_ENTER, unresolvedLocate2, it.next(), delegator);
        }
        if (unresolvedLocate2.isAlive()) {
            Iterator<MethodDescription.InDefinedShape> it2 = typeDescription2.getDeclaredMethods().iterator();
            while (it2.hasNext()) {
                unresolvedLocate = locate(OnMethodExit.class, INLINE_EXIT, unresolvedLocate, it2.next(), delegator);
            }
            if (unresolvedLocate.isAlive()) {
                try {
                    return new Advice(unresolvedLocate2.asMethodEnter(list, unresolvedLocate2.isBinary() ? OpenedClassReader.of(classFileLocator.locate(typeDescription.getName()).resolve()) : UNDEFINED, unresolvedLocate, factory), unresolvedLocate.asMethodExit(list, unresolvedLocate.isBinary() ? OpenedClassReader.of(classFileLocator.locate(typeDescription2.getName()).resolve()) : UNDEFINED, unresolvedLocate2, factory));
                } catch (IOException e) {
                    throw new IllegalStateException("Error reading class file of " + typeDescription + " or " + typeDescription2, e);
                }
            }
            throw new IllegalArgumentException(a.m("No exit advice defined by ", typeDescription2));
        }
        throw new IllegalArgumentException(a.m("No enter advice defined by ", typeDescription));
    }
}
