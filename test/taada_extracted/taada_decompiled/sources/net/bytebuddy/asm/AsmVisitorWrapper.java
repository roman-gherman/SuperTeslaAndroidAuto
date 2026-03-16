package net.bytebuddy.asm;

import com.google.protobuf.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
public interface AsmVisitorWrapper {
    public static final int NO_FLAGS = 0;

    public static abstract class AbstractBase implements AsmVisitorWrapper {
        @Override // net.bytebuddy.asm.AsmVisitorWrapper
        public int mergeReader(int i) {
            return i;
        }

        @Override // net.bytebuddy.asm.AsmVisitorWrapper
        public int mergeWriter(int i) {
            return i;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Compound implements AsmVisitorWrapper {
        private final List<AsmVisitorWrapper> asmVisitorWrappers;

        public Compound(AsmVisitorWrapper... asmVisitorWrapperArr) {
            this((List<? extends AsmVisitorWrapper>) Arrays.asList(asmVisitorWrapperArr));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.asmVisitorWrappers.equals(((Compound) obj).asmVisitorWrappers);
        }

        public int hashCode() {
            return this.asmVisitorWrappers.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.asm.AsmVisitorWrapper
        public int mergeReader(int i) {
            Iterator<AsmVisitorWrapper> it = this.asmVisitorWrappers.iterator();
            while (it.hasNext()) {
                i = it.next().mergeReader(i);
            }
            return i;
        }

        @Override // net.bytebuddy.asm.AsmVisitorWrapper
        public int mergeWriter(int i) {
            Iterator<AsmVisitorWrapper> it = this.asmVisitorWrappers.iterator();
            while (it.hasNext()) {
                i = it.next().mergeWriter(i);
            }
            return i;
        }

        @Override // net.bytebuddy.asm.AsmVisitorWrapper
        public ClassVisitor wrap(TypeDescription typeDescription, ClassVisitor classVisitor, Implementation.Context context, TypePool typePool, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, int i, int i3) {
            Iterator<AsmVisitorWrapper> it = this.asmVisitorWrappers.iterator();
            ClassVisitor classVisitorWrap = classVisitor;
            while (it.hasNext()) {
                classVisitorWrap = it.next().wrap(typeDescription, classVisitorWrap, context, typePool, fieldList, methodList, i, i3);
            }
            return classVisitorWrap;
        }

        public Compound(List<? extends AsmVisitorWrapper> list) {
            this.asmVisitorWrappers = new ArrayList();
            for (AsmVisitorWrapper asmVisitorWrapper : list) {
                if (asmVisitorWrapper instanceof Compound) {
                    this.asmVisitorWrappers.addAll(((Compound) asmVisitorWrapper).asmVisitorWrappers);
                } else if (!(asmVisitorWrapper instanceof NoOp)) {
                    this.asmVisitorWrappers.add(asmVisitorWrapper);
                }
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForDeclaredFields extends AbstractBase {
        private final List<Entry> entries;

        public class DispatchingVisitor extends ClassVisitor {
            private final Map<String, FieldDescription.InDefinedShape> fields;
            private final TypeDescription instrumentedType;

            public DispatchingVisitor(ClassVisitor classVisitor, TypeDescription typeDescription, Map<String, FieldDescription.InDefinedShape> map) {
                super(OpenedClassReader.ASM_API, classVisitor);
                this.instrumentedType = typeDescription;
                this.fields = map;
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            @MaybeNull
            public FieldVisitor visitField(int i, String str, String str2, @MaybeNull String str3, @MaybeNull Object obj) {
                FieldVisitor fieldVisitorVisitField = super.visitField(i, str, str2, str3, obj);
                FieldDescription.InDefinedShape inDefinedShape = this.fields.get(str + str2);
                if (fieldVisitorVisitField != null && inDefinedShape != null) {
                    for (Entry entry : ForDeclaredFields.this.entries) {
                        if (entry.matches(inDefinedShape)) {
                            fieldVisitorVisitField = entry.wrap(this.instrumentedType, inDefinedShape, fieldVisitorVisitField);
                        }
                    }
                }
                return fieldVisitorVisitField;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Entry implements ElementMatcher<FieldDescription.InDefinedShape>, FieldVisitorWrapper {
            private final List<? extends FieldVisitorWrapper> fieldVisitorWrappers;
            private final ElementMatcher<? super FieldDescription.InDefinedShape> matcher;

            public Entry(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher, List<? extends FieldVisitorWrapper> list) {
                this.matcher = elementMatcher;
                this.fieldVisitorWrappers = list;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Entry entry = (Entry) obj;
                return this.matcher.equals(entry.matcher) && this.fieldVisitorWrappers.equals(entry.fieldVisitorWrappers);
            }

            public int hashCode() {
                return this.fieldVisitorWrappers.hashCode() + a.j(this.matcher, getClass().hashCode() * 31, 31);
            }

            @Override // net.bytebuddy.asm.AsmVisitorWrapper.ForDeclaredFields.FieldVisitorWrapper
            public FieldVisitor wrap(TypeDescription typeDescription, FieldDescription.InDefinedShape inDefinedShape, FieldVisitor fieldVisitor) {
                Iterator<? extends FieldVisitorWrapper> it = this.fieldVisitorWrappers.iterator();
                while (it.hasNext()) {
                    fieldVisitor = it.next().wrap(typeDescription, inDefinedShape, fieldVisitor);
                }
                return fieldVisitor;
            }

            @Override // net.bytebuddy.matcher.ElementMatcher
            public boolean matches(@MaybeNull FieldDescription.InDefinedShape inDefinedShape) {
                return this.matcher.matches(inDefinedShape);
            }
        }

        public interface FieldVisitorWrapper {
            FieldVisitor wrap(TypeDescription typeDescription, FieldDescription.InDefinedShape inDefinedShape, FieldVisitor fieldVisitor);
        }

        public ForDeclaredFields() {
            this(Collections.EMPTY_LIST);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.entries.equals(((ForDeclaredFields) obj).entries);
        }

        public ForDeclaredFields field(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher, FieldVisitorWrapper... fieldVisitorWrapperArr) {
            return field(elementMatcher, Arrays.asList(fieldVisitorWrapperArr));
        }

        public int hashCode() {
            return this.entries.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.asm.AsmVisitorWrapper
        public ClassVisitor wrap(TypeDescription typeDescription, ClassVisitor classVisitor, Implementation.Context context, TypePool typePool, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, int i, int i3) {
            HashMap map = new HashMap();
            for (FieldDescription.InDefinedShape inDefinedShape : fieldList) {
                map.put(inDefinedShape.getInternalName() + inDefinedShape.getDescriptor(), inDefinedShape);
            }
            return new DispatchingVisitor(classVisitor, typeDescription, map);
        }

        public ForDeclaredFields(List<Entry> list) {
            this.entries = list;
        }

        public ForDeclaredFields field(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher, List<? extends FieldVisitorWrapper> list) {
            return new ForDeclaredFields(CompoundList.of(this.entries, new Entry(elementMatcher, list)));
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForDeclaredMethods implements AsmVisitorWrapper {
        private final List<Entry> entries;
        private final int readerFlags;
        private final int writerFlags;

        public class DispatchingVisitor extends ClassVisitor {
            private final Implementation.Context implementationContext;
            private final TypeDescription instrumentedType;
            private final Map<String, MethodDescription> methods;
            private final int readerFlags;
            private final TypePool typePool;
            private final int writerFlags;

            public DispatchingVisitor(ClassVisitor classVisitor, TypeDescription typeDescription, Implementation.Context context, TypePool typePool, Map<String, MethodDescription> map, int i, int i3) {
                super(OpenedClassReader.ASM_API, classVisitor);
                this.instrumentedType = typeDescription;
                this.implementationContext = context;
                this.typePool = typePool;
                this.methods = map;
                this.writerFlags = i;
                this.readerFlags = i3;
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            @MaybeNull
            public MethodVisitor visitMethod(int i, String str, String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
                MethodVisitor methodVisitorVisitMethod = super.visitMethod(i, str, str2, str3, strArr);
                MethodDescription methodDescription = this.methods.get(str + str2);
                if (methodVisitorVisitMethod == null || methodDescription == null) {
                    return methodVisitorVisitMethod;
                }
                while (true) {
                    MethodVisitor methodVisitor = methodVisitorVisitMethod;
                    for (Entry entry : ForDeclaredMethods.this.entries) {
                        if (entry.matches(methodDescription)) {
                            break;
                        }
                    }
                    return methodVisitor;
                    methodVisitorVisitMethod = entry.wrap(this.instrumentedType, methodDescription, methodVisitor, this.implementationContext, this.typePool, this.writerFlags, this.readerFlags);
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Entry implements ElementMatcher<MethodDescription>, MethodVisitorWrapper {
            private final ElementMatcher<? super MethodDescription> matcher;
            private final List<? extends MethodVisitorWrapper> methodVisitorWrappers;

            public Entry(ElementMatcher<? super MethodDescription> elementMatcher, List<? extends MethodVisitorWrapper> list) {
                this.matcher = elementMatcher;
                this.methodVisitorWrappers = list;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Entry entry = (Entry) obj;
                return this.matcher.equals(entry.matcher) && this.methodVisitorWrappers.equals(entry.methodVisitorWrappers);
            }

            public int hashCode() {
                return this.methodVisitorWrappers.hashCode() + a.j(this.matcher, getClass().hashCode() * 31, 31);
            }

            @Override // net.bytebuddy.asm.AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper
            public MethodVisitor wrap(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, TypePool typePool, int i, int i3) {
                Iterator<? extends MethodVisitorWrapper> it = this.methodVisitorWrappers.iterator();
                MethodVisitor methodVisitorWrap = methodVisitor;
                while (it.hasNext()) {
                    methodVisitorWrap = it.next().wrap(typeDescription, methodDescription, methodVisitorWrap, context, typePool, i, i3);
                }
                return methodVisitorWrap;
            }

            @Override // net.bytebuddy.matcher.ElementMatcher
            public boolean matches(@MaybeNull MethodDescription methodDescription) {
                return this.matcher.matches(methodDescription);
            }
        }

        public interface MethodVisitorWrapper {
            MethodVisitor wrap(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, TypePool typePool, int i, int i3);
        }

        public ForDeclaredMethods() {
            this(Collections.EMPTY_LIST, 0, 0);
        }

        public ForDeclaredMethods constructor(ElementMatcher<? super MethodDescription> elementMatcher, MethodVisitorWrapper... methodVisitorWrapperArr) {
            return constructor(elementMatcher, Arrays.asList(methodVisitorWrapperArr));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ForDeclaredMethods forDeclaredMethods = (ForDeclaredMethods) obj;
            return this.writerFlags == forDeclaredMethods.writerFlags && this.readerFlags == forDeclaredMethods.readerFlags && this.entries.equals(forDeclaredMethods.entries);
        }

        public int hashCode() {
            return ((androidx.constraintlayout.core.motion.a.d(this.entries, getClass().hashCode() * 31, 31) + this.writerFlags) * 31) + this.readerFlags;
        }

        public ForDeclaredMethods invokable(ElementMatcher<? super MethodDescription> elementMatcher, MethodVisitorWrapper... methodVisitorWrapperArr) {
            return invokable(elementMatcher, Arrays.asList(methodVisitorWrapperArr));
        }

        @Override // net.bytebuddy.asm.AsmVisitorWrapper
        public int mergeReader(int i) {
            return i | this.readerFlags;
        }

        @Override // net.bytebuddy.asm.AsmVisitorWrapper
        public int mergeWriter(int i) {
            return i | this.writerFlags;
        }

        public ForDeclaredMethods method(ElementMatcher<? super MethodDescription> elementMatcher, MethodVisitorWrapper... methodVisitorWrapperArr) {
            return method(elementMatcher, Arrays.asList(methodVisitorWrapperArr));
        }

        public ForDeclaredMethods readerFlags(int i) {
            return new ForDeclaredMethods(this.entries, this.writerFlags, i | this.readerFlags);
        }

        @Override // net.bytebuddy.asm.AsmVisitorWrapper
        public ClassVisitor wrap(TypeDescription typeDescription, ClassVisitor classVisitor, Implementation.Context context, TypePool typePool, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, int i, int i3) {
            HashMap map = new HashMap();
            for (MethodDescription methodDescription : CompoundList.of(methodList, new MethodDescription.Latent.TypeInitializer(typeDescription))) {
                map.put(methodDescription.getInternalName() + methodDescription.getDescriptor(), methodDescription);
            }
            return new DispatchingVisitor(classVisitor, typeDescription, context, typePool, map, i, i3);
        }

        public ForDeclaredMethods writerFlags(int i) {
            return new ForDeclaredMethods(this.entries, i | this.writerFlags, this.readerFlags);
        }

        public ForDeclaredMethods(List<Entry> list, int i, int i3) {
            this.entries = list;
            this.writerFlags = i;
            this.readerFlags = i3;
        }

        public ForDeclaredMethods constructor(ElementMatcher<? super MethodDescription> elementMatcher, List<? extends MethodVisitorWrapper> list) {
            return invokable(ElementMatchers.isConstructor().and(elementMatcher), list);
        }

        public ForDeclaredMethods invokable(ElementMatcher<? super MethodDescription> elementMatcher, List<? extends MethodVisitorWrapper> list) {
            return new ForDeclaredMethods(CompoundList.of(this.entries, new Entry(elementMatcher, list)), this.writerFlags, this.readerFlags);
        }

        public ForDeclaredMethods method(ElementMatcher<? super MethodDescription> elementMatcher, List<? extends MethodVisitorWrapper> list) {
            return invokable(ElementMatchers.isMethod().and(elementMatcher), list);
        }
    }

    public enum NoOp implements AsmVisitorWrapper {
        INSTANCE;

        @Override // net.bytebuddy.asm.AsmVisitorWrapper
        public int mergeReader(int i) {
            return i;
        }

        @Override // net.bytebuddy.asm.AsmVisitorWrapper
        public int mergeWriter(int i) {
            return i;
        }

        @Override // net.bytebuddy.asm.AsmVisitorWrapper
        public ClassVisitor wrap(TypeDescription typeDescription, ClassVisitor classVisitor, Implementation.Context context, TypePool typePool, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, int i, int i3) {
            return classVisitor;
        }
    }

    int mergeReader(int i);

    int mergeWriter(int i);

    ClassVisitor wrap(TypeDescription typeDescription, ClassVisitor classVisitor, Implementation.Context context, TypePool typePool, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, int i, int i3);
}
