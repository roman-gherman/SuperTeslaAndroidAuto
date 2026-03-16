package net.bytebuddy.implementation.bytecode;

import B2.b;
import com.google.protobuf.a;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.implementation.bytecode.StackManipulation;

/* JADX INFO: loaded from: classes2.dex */
public enum StackSize {
    ZERO(0),
    SINGLE(1),
    DOUBLE(2);

    private final int size;

    /* JADX INFO: renamed from: net.bytebuddy.implementation.bytecode.StackSize$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$bytebuddy$implementation$bytecode$StackSize;

        static {
            int[] iArr = new int[StackSize.values().length];
            $SwitchMap$net$bytebuddy$implementation$bytecode$StackSize = iArr;
            try {
                iArr[StackSize.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$bytebuddy$implementation$bytecode$StackSize[StackSize.SINGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$bytebuddy$implementation$bytecode$StackSize[StackSize.ZERO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    StackSize(int i) {
        this.size = i;
    }

    public static StackSize of(Class<?> cls) {
        return cls == Void.TYPE ? ZERO : (cls == Double.TYPE || cls == Long.TYPE) ? DOUBLE : SINGLE;
    }

    public int getSize() {
        return this.size;
    }

    public StackSize maximum(StackSize stackSize) {
        int[] iArr = AnonymousClass1.$SwitchMap$net$bytebuddy$implementation$bytecode$StackSize;
        int i = iArr[ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return stackSize;
                }
                throw new AssertionError();
            }
            int i3 = iArr[stackSize.ordinal()];
            if (i3 == 1) {
                return stackSize;
            }
            if (i3 != 2 && i3 != 3) {
                throw new AssertionError();
            }
        }
        return this;
    }

    public StackManipulation.Size toDecreasingSize() {
        return new StackManipulation.Size(getSize() * (-1), 0);
    }

    public StackManipulation.Size toIncreasingSize() {
        return new StackManipulation.Size(getSize(), getSize());
    }

    public static StackSize of(int i) {
        if (i == 0) {
            return ZERO;
        }
        if (i == 1) {
            return SINGLE;
        }
        if (i == 2) {
            return DOUBLE;
        }
        throw new IllegalArgumentException(b.c(i, "Unexpected stack size value: "));
    }

    public static int of(TypeDefinition... typeDefinitionArr) {
        return of(Arrays.asList(typeDefinitionArr));
    }

    public static int of(Collection<? extends TypeDefinition> collection) {
        Iterator<? extends TypeDefinition> it = collection.iterator();
        int iG = 0;
        while (it.hasNext()) {
            iG = a.g(it.next(), iG);
        }
        return iG;
    }
}
