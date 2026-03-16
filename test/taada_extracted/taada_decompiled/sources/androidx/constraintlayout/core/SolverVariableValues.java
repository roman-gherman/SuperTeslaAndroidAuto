package androidx.constraintlayout.core;

import B2.b;
import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class SolverVariableValues implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean HASH = true;
    private static float epsilon = 0.001f;
    protected final Cache mCache;
    private final ArrayRow mRow;
    private final int NONE = -1;
    private int SIZE = 16;
    private int HASH_SIZE = 16;
    int[] keys = new int[16];
    int[] nextKeys = new int[16];
    int[] variables = new int[16];
    float[] values = new float[16];
    int[] previous = new int[16];
    int[] next = new int[16];
    int mCount = 0;
    int head = -1;

    public SolverVariableValues(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
        clear();
    }

    private void addToHashMap(SolverVariable solverVariable, int i) {
        int[] iArr;
        int i3 = solverVariable.id % this.HASH_SIZE;
        int[] iArr2 = this.keys;
        int i4 = iArr2[i3];
        if (i4 == -1) {
            iArr2[i3] = i;
        } else {
            while (true) {
                iArr = this.nextKeys;
                int i5 = iArr[i4];
                if (i5 == -1) {
                    break;
                } else {
                    i4 = i5;
                }
            }
            iArr[i4] = i;
        }
        this.nextKeys[i] = -1;
    }

    private void addVariable(int i, SolverVariable solverVariable, float f6) {
        this.variables[i] = solverVariable.id;
        this.values[i] = f6;
        this.previous[i] = -1;
        this.next[i] = -1;
        solverVariable.addToRow(this.mRow);
        solverVariable.usageInRowCount++;
        this.mCount++;
    }

    private void displayHash() {
        for (int i = 0; i < this.HASH_SIZE; i++) {
            if (this.keys[i] != -1) {
                String string = hashCode() + " hash [" + i + "] => ";
                int i3 = this.keys[i];
                boolean z6 = false;
                while (!z6) {
                    StringBuilder sbL = b.l(string, " ");
                    sbL.append(this.variables[i3]);
                    string = sbL.toString();
                    int i4 = this.nextKeys[i3];
                    if (i4 != -1) {
                        i3 = i4;
                    } else {
                        z6 = true;
                    }
                }
                System.out.println(string);
            }
        }
    }

    private int findEmptySlot() {
        for (int i = 0; i < this.SIZE; i++) {
            if (this.variables[i] == -1) {
                return i;
            }
        }
        return -1;
    }

    private void increaseSize() {
        int i = this.SIZE * 2;
        this.variables = Arrays.copyOf(this.variables, i);
        this.values = Arrays.copyOf(this.values, i);
        this.previous = Arrays.copyOf(this.previous, i);
        this.next = Arrays.copyOf(this.next, i);
        this.nextKeys = Arrays.copyOf(this.nextKeys, i);
        for (int i3 = this.SIZE; i3 < i; i3++) {
            this.variables[i3] = -1;
            this.nextKeys[i3] = -1;
        }
        this.SIZE = i;
    }

    private void insertVariable(int i, SolverVariable solverVariable, float f6) {
        int iFindEmptySlot = findEmptySlot();
        addVariable(iFindEmptySlot, solverVariable, f6);
        if (i != -1) {
            this.previous[iFindEmptySlot] = i;
            int[] iArr = this.next;
            iArr[iFindEmptySlot] = iArr[i];
            iArr[i] = iFindEmptySlot;
        } else {
            this.previous[iFindEmptySlot] = -1;
            if (this.mCount > 0) {
                this.next[iFindEmptySlot] = this.head;
                this.head = iFindEmptySlot;
            } else {
                this.next[iFindEmptySlot] = -1;
            }
        }
        int i3 = this.next[iFindEmptySlot];
        if (i3 != -1) {
            this.previous[i3] = iFindEmptySlot;
        }
        addToHashMap(solverVariable, iFindEmptySlot);
    }

    private void removeFromHashMap(SolverVariable solverVariable) {
        int[] iArr;
        int i;
        int i3 = solverVariable.id;
        int i4 = i3 % this.HASH_SIZE;
        int[] iArr2 = this.keys;
        int i5 = iArr2[i4];
        if (i5 == -1) {
            return;
        }
        if (this.variables[i5] == i3) {
            int[] iArr3 = this.nextKeys;
            iArr2[i4] = iArr3[i5];
            iArr3[i5] = -1;
            return;
        }
        while (true) {
            iArr = this.nextKeys;
            i = iArr[i5];
            if (i == -1 || this.variables[i] == i3) {
                break;
            } else {
                i5 = i;
            }
        }
        if (i == -1 || this.variables[i] != i3) {
            return;
        }
        iArr[i5] = iArr[i];
        iArr[i] = -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f6, boolean z6) {
        float f7 = epsilon;
        if (f6 <= (-f7) || f6 >= f7) {
            int iIndexOf = indexOf(solverVariable);
            if (iIndexOf == -1) {
                put(solverVariable, f6);
                return;
            }
            float[] fArr = this.values;
            float f8 = fArr[iIndexOf] + f6;
            fArr[iIndexOf] = f8;
            float f9 = epsilon;
            if (f8 <= (-f9) || f8 >= f9) {
                return;
            }
            fArr[iIndexOf] = 0.0f;
            remove(solverVariable, z6);
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void clear() {
        int i = this.mCount;
        for (int i3 = 0; i3 < i; i3++) {
            SolverVariable variable = getVariable(i3);
            if (variable != null) {
                variable.removeFromRow(this.mRow);
            }
        }
        for (int i4 = 0; i4 < this.SIZE; i4++) {
            this.variables[i4] = -1;
            this.nextKeys[i4] = -1;
        }
        for (int i5 = 0; i5 < this.HASH_SIZE; i5++) {
            this.keys[i5] = -1;
        }
        this.mCount = 0;
        this.head = -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable solverVariable) {
        return indexOf(solverVariable) != -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void display() {
        int i = this.mCount;
        System.out.print("{ ");
        for (int i3 = 0; i3 < i; i3++) {
            SolverVariable variable = getVariable(i3);
            if (variable != null) {
                System.out.print(variable + " = " + getVariableValue(i3) + " ");
            }
        }
        System.out.println(" }");
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void divideByAmount(float f6) {
        int i = this.mCount;
        int i3 = this.head;
        for (int i4 = 0; i4 < i; i4++) {
            float[] fArr = this.values;
            fArr[i3] = fArr[i3] / f6;
            i3 = this.next[i3];
            if (i3 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float get(SolverVariable solverVariable) {
        int iIndexOf = indexOf(solverVariable);
        if (iIndexOf != -1) {
            return this.values[iIndexOf];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.mCount;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int i) {
        int i3 = this.mCount;
        if (i3 == 0) {
            return null;
        }
        int i4 = this.head;
        for (int i5 = 0; i5 < i3; i5++) {
            if (i5 == i && i4 != -1) {
                return this.mCache.mIndexedVariables[this.variables[i4]];
            }
            i4 = this.next[i4];
            if (i4 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i) {
        int i3 = this.mCount;
        int i4 = this.head;
        for (int i5 = 0; i5 < i3; i5++) {
            if (i5 == i) {
                return this.values[i4];
            }
            i4 = this.next[i4];
            if (i4 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        if (this.mCount != 0 && solverVariable != null) {
            int i = solverVariable.id;
            int i3 = this.keys[i % this.HASH_SIZE];
            if (i3 == -1) {
                return -1;
            }
            if (this.variables[i3] == i) {
                return i3;
            }
            do {
                i3 = this.nextKeys[i3];
                if (i3 == -1) {
                    break;
                }
            } while (this.variables[i3] != i);
            if (i3 != -1 && this.variables[i3] == i) {
                return i3;
            }
        }
        return -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void invert() {
        int i = this.mCount;
        int i3 = this.head;
        for (int i4 = 0; i4 < i; i4++) {
            float[] fArr = this.values;
            fArr[i3] = fArr[i3] * (-1.0f);
            i3 = this.next[i3];
            if (i3 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void put(SolverVariable solverVariable, float f6) {
        float f7 = epsilon;
        if (f6 > (-f7) && f6 < f7) {
            remove(solverVariable, true);
            return;
        }
        if (this.mCount == 0) {
            addVariable(0, solverVariable, f6);
            addToHashMap(solverVariable, 0);
            this.head = 0;
            return;
        }
        int iIndexOf = indexOf(solverVariable);
        if (iIndexOf != -1) {
            this.values[iIndexOf] = f6;
            return;
        }
        if (this.mCount + 1 >= this.SIZE) {
            increaseSize();
        }
        int i = this.mCount;
        int i3 = this.head;
        int i4 = -1;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = this.variables[i3];
            int i7 = solverVariable.id;
            if (i6 == i7) {
                this.values[i3] = f6;
                return;
            }
            if (i6 < i7) {
                i4 = i3;
            }
            i3 = this.next[i3];
            if (i3 == -1) {
                break;
            }
        }
        insertVariable(i4, solverVariable, f6);
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float remove(SolverVariable solverVariable, boolean z6) {
        int iIndexOf = indexOf(solverVariable);
        if (iIndexOf == -1) {
            return 0.0f;
        }
        removeFromHashMap(solverVariable);
        float f6 = this.values[iIndexOf];
        if (this.head == iIndexOf) {
            this.head = this.next[iIndexOf];
        }
        this.variables[iIndexOf] = -1;
        int[] iArr = this.previous;
        int i = iArr[iIndexOf];
        if (i != -1) {
            int[] iArr2 = this.next;
            iArr2[i] = iArr2[iIndexOf];
        }
        int i3 = this.next[iIndexOf];
        if (i3 != -1) {
            iArr[i3] = iArr[iIndexOf];
        }
        this.mCount--;
        solverVariable.usageInRowCount--;
        if (z6) {
            solverVariable.removeFromRow(this.mRow);
        }
        return f6;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return 0;
    }

    public String toString() {
        String strE;
        String strE2;
        String strE3 = hashCode() + " { ";
        int i = this.mCount;
        for (int i3 = 0; i3 < i; i3++) {
            SolverVariable variable = getVariable(i3);
            if (variable != null) {
                String str = strE3 + variable + " = " + getVariableValue(i3) + " ";
                int iIndexOf = indexOf(variable);
                String strE4 = b.e(str, "[p: ");
                if (this.previous[iIndexOf] != -1) {
                    StringBuilder sbK = b.k(strE4);
                    sbK.append(this.mCache.mIndexedVariables[this.variables[this.previous[iIndexOf]]]);
                    strE = sbK.toString();
                } else {
                    strE = b.e(strE4, "none");
                }
                String strE5 = b.e(strE, ", n: ");
                if (this.next[iIndexOf] != -1) {
                    StringBuilder sbK2 = b.k(strE5);
                    sbK2.append(this.mCache.mIndexedVariables[this.variables[this.next[iIndexOf]]]);
                    strE2 = sbK2.toString();
                } else {
                    strE2 = b.e(strE5, "none");
                }
                strE3 = b.e(strE2, "]");
            }
        }
        return b.e(strE3, " }");
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z6) {
        float f6 = get(arrayRow.variable);
        remove(arrayRow.variable, z6);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.variables;
        int currentSize = solverVariableValues.getCurrentSize();
        int i = 0;
        int i3 = 0;
        while (i < currentSize) {
            int i4 = solverVariableValues.variables[i3];
            if (i4 != -1) {
                add(this.mCache.mIndexedVariables[i4], solverVariableValues.values[i3] * f6, z6);
                i++;
            }
            i3++;
        }
        return f6;
    }
}
