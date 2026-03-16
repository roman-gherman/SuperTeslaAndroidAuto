package net.bytebuddy.dynamic.scaffold;

import com.android.multidex.ClassPathElement;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.jar.asm.ClassReader;
import net.bytebuddy.jar.asm.ClassWriter;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes2.dex */
public interface ClassWriterStrategy {

    public enum Default implements ClassWriterStrategy {
        CONSTANT_POOL_RETAINING { // from class: net.bytebuddy.dynamic.scaffold.ClassWriterStrategy.Default.1
            @Override // net.bytebuddy.dynamic.scaffold.ClassWriterStrategy
            public ClassWriter resolve(int i, TypePool typePool, ClassReader classReader) {
                return new FrameComputingClassWriter(classReader, i, typePool);
            }
        },
        CONSTANT_POOL_DISCARDING { // from class: net.bytebuddy.dynamic.scaffold.ClassWriterStrategy.Default.2
            @Override // net.bytebuddy.dynamic.scaffold.ClassWriterStrategy
            public ClassWriter resolve(int i, TypePool typePool, ClassReader classReader) {
                return resolve(i, typePool);
            }
        };

        @Override // net.bytebuddy.dynamic.scaffold.ClassWriterStrategy
        public ClassWriter resolve(int i, TypePool typePool) {
            return new FrameComputingClassWriter(i, typePool);
        }
    }

    ClassWriter resolve(int i, TypePool typePool);

    ClassWriter resolve(int i, TypePool typePool, ClassReader classReader);

    public static class FrameComputingClassWriter extends ClassWriter {
        private final TypePool typePool;

        public FrameComputingClassWriter(int i, TypePool typePool) {
            super(i);
            this.typePool = typePool;
        }

        @Override // net.bytebuddy.jar.asm.ClassWriter
        public String getCommonSuperClass(String str, String str2) {
            TypeDescription typeDescriptionResolve = this.typePool.describe(str.replace(ClassPathElement.SEPARATOR_CHAR, TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH)).resolve();
            TypeDescription typeDescriptionResolve2 = this.typePool.describe(str2.replace(ClassPathElement.SEPARATOR_CHAR, TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH)).resolve();
            if (typeDescriptionResolve.isAssignableFrom(typeDescriptionResolve2)) {
                return typeDescriptionResolve.getInternalName();
            }
            if (typeDescriptionResolve.isAssignableTo(typeDescriptionResolve2)) {
                return typeDescriptionResolve2.getInternalName();
            }
            if (typeDescriptionResolve.isInterface() || typeDescriptionResolve2.isInterface()) {
                return TypeDescription.ForLoadedType.of(Object.class).getInternalName();
            }
            do {
                TypeDescription.Generic superClass = typeDescriptionResolve.getSuperClass();
                if (superClass == null) {
                    return TypeDescription.ForLoadedType.of(Object.class).getInternalName();
                }
                typeDescriptionResolve = superClass.asErasure();
            } while (!typeDescriptionResolve.isAssignableFrom(typeDescriptionResolve2));
            return typeDescriptionResolve.getInternalName();
        }

        public FrameComputingClassWriter(ClassReader classReader, int i, TypePool typePool) {
            super(classReader, i);
            this.typePool = typePool;
        }
    }
}
