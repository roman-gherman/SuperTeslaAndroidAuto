package net.bytebuddy.jar.asm;

import androidx.constraintlayout.core.motion.a;
import com.android.dx.cf.attrib.AttBootstrapMethods;

/* JADX INFO: loaded from: classes2.dex */
final class SymbolTable {
    private int bootstrapMethodCount;
    private ByteVector bootstrapMethods;
    private String className;
    final ClassWriter classWriter;
    private ByteVector constantPool;
    private int constantPoolCount;
    private Entry[] entries;
    private int entryCount;
    private int majorVersion;
    private final ClassReader sourceClassReader;
    private int typeCount;
    private Entry[] typeTable;

    public SymbolTable(ClassWriter classWriter) {
        this.classWriter = classWriter;
        this.sourceClassReader = null;
        this.entries = new Entry[256];
        this.constantPoolCount = 1;
        this.constantPool = new ByteVector();
    }

    private void add(Entry entry) {
        this.entryCount++;
        int i = entry.hashCode;
        Entry[] entryArr = this.entries;
        int length = i % entryArr.length;
        entry.next = entryArr[length];
        entryArr[length] = entry;
    }

    private Symbol addConstantDynamicOrInvokeDynamicReference(int i, String str, String str2, int i3) {
        int iHash = hash(i, str, str2, i3);
        for (Entry entry = get(iHash); entry != null; entry = entry.next) {
            if (entry.tag == i && entry.hashCode == iHash && entry.data == i3 && entry.name.equals(str) && entry.value.equals(str2)) {
                return entry;
            }
        }
        this.constantPool.put122(i, i3, addConstantNameAndType(str, str2));
        int i4 = this.constantPoolCount;
        this.constantPoolCount = i4 + 1;
        return put(new Entry(i4, i, null, str, str2, i3, iHash));
    }

    private Symbol addConstantIntegerOrFloat(int i, int i3) {
        int iHash = hash(i, i3);
        for (Entry entry = get(iHash); entry != null; entry = entry.next) {
            if (entry.tag == i && entry.hashCode == iHash && entry.data == i3) {
                return entry;
            }
        }
        this.constantPool.putByte(i).putInt(i3);
        int i4 = this.constantPoolCount;
        this.constantPoolCount = i4 + 1;
        return put(new Entry(i4, i, i3, iHash));
    }

    private Symbol addConstantLongOrDouble(int i, long j6) {
        int iHash = hash(i, j6);
        for (Entry entry = get(iHash); entry != null; entry = entry.next) {
            if (entry.tag == i && entry.hashCode == iHash && entry.data == j6) {
                return entry;
            }
        }
        int i3 = this.constantPoolCount;
        this.constantPool.putByte(i).putLong(j6);
        this.constantPoolCount += 2;
        return put(new Entry(i3, i, j6, iHash));
    }

    private Entry addConstantMemberReference(int i, String str, String str2, String str3) {
        int iHash = hash(i, str, str2, str3);
        for (Entry entry = get(iHash); entry != null; entry = entry.next) {
            if (entry.tag == i && entry.hashCode == iHash && entry.owner.equals(str) && entry.name.equals(str2) && entry.value.equals(str3)) {
                return entry;
            }
        }
        this.constantPool.put122(i, addConstantClass(str).index, addConstantNameAndType(str2, str3));
        int i3 = this.constantPoolCount;
        this.constantPoolCount = i3 + 1;
        return put(new Entry(i3, i, str, str2, str3, 0L, iHash));
    }

    private Symbol addConstantUtf8Reference(int i, String str) {
        int iHash = hash(i, str);
        for (Entry entry = get(iHash); entry != null; entry = entry.next) {
            if (entry.tag == i && entry.hashCode == iHash && entry.value.equals(str)) {
                return entry;
            }
        }
        this.constantPool.put12(i, addConstantUtf8(str));
        int i3 = this.constantPoolCount;
        this.constantPoolCount = i3 + 1;
        return put(new Entry(i3, i, str, iHash));
    }

    private int addTypeInternal(Entry entry) {
        if (this.typeTable == null) {
            this.typeTable = new Entry[16];
        }
        int i = this.typeCount;
        Entry[] entryArr = this.typeTable;
        if (i == entryArr.length) {
            Entry[] entryArr2 = new Entry[entryArr.length * 2];
            System.arraycopy(entryArr, 0, entryArr2, 0, entryArr.length);
            this.typeTable = entryArr2;
        }
        Entry[] entryArr3 = this.typeTable;
        int i3 = this.typeCount;
        this.typeCount = i3 + 1;
        entryArr3[i3] = entry;
        return put(entry).index;
    }

    private void copyBootstrapMethods(ClassReader classReader, char[] cArr) {
        byte[] bArr = classReader.classFileBuffer;
        int firstAttributeOffset = classReader.getFirstAttributeOffset();
        int unsignedShort = classReader.readUnsignedShort(firstAttributeOffset - 2);
        while (true) {
            if (unsignedShort <= 0) {
                break;
            }
            if (AttBootstrapMethods.ATTRIBUTE_NAME.equals(classReader.readUTF8(firstAttributeOffset, cArr))) {
                this.bootstrapMethodCount = classReader.readUnsignedShort(firstAttributeOffset + 6);
                break;
            } else {
                firstAttributeOffset += classReader.readInt(firstAttributeOffset + 2) + 6;
                unsignedShort--;
            }
        }
        if (this.bootstrapMethodCount > 0) {
            int i = firstAttributeOffset + 8;
            int i3 = classReader.readInt(firstAttributeOffset + 2) - 2;
            ByteVector byteVector = new ByteVector(i3);
            this.bootstrapMethods = byteVector;
            byteVector.putByteArray(bArr, i, i3);
            int i4 = i;
            for (int i5 = 0; i5 < this.bootstrapMethodCount; i5++) {
                int i6 = i4 - i;
                int unsignedShort2 = classReader.readUnsignedShort(i4);
                int unsignedShort3 = classReader.readUnsignedShort(i4 + 2);
                i4 += 4;
                int iHashCode = classReader.readConst(unsignedShort2, cArr).hashCode();
                while (true) {
                    int i7 = unsignedShort3 - 1;
                    if (unsignedShort3 > 0) {
                        int unsignedShort4 = classReader.readUnsignedShort(i4);
                        i4 += 2;
                        iHashCode ^= classReader.readConst(unsignedShort4, cArr).hashCode();
                        unsignedShort3 = i7;
                    }
                }
                add(new Entry(i5, 64, i6, iHashCode & Integer.MAX_VALUE));
            }
        }
    }

    private Entry get(int i) {
        Entry[] entryArr = this.entries;
        return entryArr[i % entryArr.length];
    }

    private static int hash(int i, int i3) {
        return (i + i3) & Integer.MAX_VALUE;
    }

    private Entry put(Entry entry) {
        int i = this.entryCount;
        Entry[] entryArr = this.entries;
        if (i > (entryArr.length * 3) / 4) {
            int length = entryArr.length;
            int i3 = (length * 2) + 1;
            Entry[] entryArr2 = new Entry[i3];
            for (int i4 = length - 1; i4 >= 0; i4--) {
                Entry entry2 = this.entries[i4];
                while (entry2 != null) {
                    int i5 = entry2.hashCode % i3;
                    Entry entry3 = entry2.next;
                    entry2.next = entryArr2[i5];
                    entryArr2[i5] = entry2;
                    entry2 = entry3;
                }
            }
            this.entries = entryArr2;
        }
        this.entryCount++;
        int i6 = entry.hashCode;
        Entry[] entryArr3 = this.entries;
        int length2 = i6 % entryArr3.length;
        entry.next = entryArr3[length2];
        entryArr3[length2] = entry;
        return entry;
    }

    public Symbol addBootstrapMethod(Handle handle, Object... objArr) {
        ByteVector byteVector = this.bootstrapMethods;
        if (byteVector == null) {
            byteVector = new ByteVector();
            this.bootstrapMethods = byteVector;
        }
        int length = objArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = addConstant(objArr[i]).index;
        }
        int i3 = byteVector.length;
        byteVector.putShort(addConstantMethodHandle(handle.getTag(), handle.getOwner(), handle.getName(), handle.getDesc(), handle.isInterface()).index);
        byteVector.putShort(length);
        for (int i4 = 0; i4 < length; i4++) {
            byteVector.putShort(iArr[i4]);
        }
        int i5 = byteVector.length - i3;
        int iHashCode = handle.hashCode();
        for (Object obj : objArr) {
            iHashCode ^= obj.hashCode();
        }
        return addBootstrapMethod(i3, i5, iHashCode & Integer.MAX_VALUE);
    }

    public Symbol addConstant(Object obj) {
        if (obj instanceof Integer) {
            return addConstantInteger(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return addConstantInteger(((Byte) obj).intValue());
        }
        if (obj instanceof Character) {
            return addConstantInteger(((Character) obj).charValue());
        }
        if (obj instanceof Short) {
            return addConstantInteger(((Short) obj).intValue());
        }
        if (obj instanceof Boolean) {
            return addConstantInteger(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Float) {
            return addConstantFloat(((Float) obj).floatValue());
        }
        if (obj instanceof Long) {
            return addConstantLong(((Long) obj).longValue());
        }
        if (obj instanceof Double) {
            return addConstantDouble(((Double) obj).doubleValue());
        }
        if (obj instanceof String) {
            return addConstantString((String) obj);
        }
        if (obj instanceof Type) {
            Type type = (Type) obj;
            int sort = type.getSort();
            return sort == 10 ? addConstantClass(type.getInternalName()) : sort == 11 ? addConstantMethodType(type.getDescriptor()) : addConstantClass(type.getDescriptor());
        }
        if (obj instanceof Handle) {
            Handle handle = (Handle) obj;
            return addConstantMethodHandle(handle.getTag(), handle.getOwner(), handle.getName(), handle.getDesc(), handle.isInterface());
        }
        if (!(obj instanceof ConstantDynamic)) {
            throw new IllegalArgumentException(a.m(obj, "value "));
        }
        ConstantDynamic constantDynamic = (ConstantDynamic) obj;
        return addConstantDynamic(constantDynamic.getName(), constantDynamic.getDescriptor(), constantDynamic.getBootstrapMethod(), constantDynamic.getBootstrapMethodArgumentsUnsafe());
    }

    public Symbol addConstantClass(String str) {
        return addConstantUtf8Reference(7, str);
    }

    public Symbol addConstantDouble(double d) {
        return addConstantLongOrDouble(6, Double.doubleToRawLongBits(d));
    }

    public Symbol addConstantDynamic(String str, String str2, Handle handle, Object... objArr) {
        return addConstantDynamicOrInvokeDynamicReference(17, str, str2, addBootstrapMethod(handle, objArr).index);
    }

    public Symbol addConstantFieldref(String str, String str2, String str3) {
        return addConstantMemberReference(9, str, str2, str3);
    }

    public Symbol addConstantFloat(float f6) {
        return addConstantIntegerOrFloat(4, Float.floatToRawIntBits(f6));
    }

    public Symbol addConstantInteger(int i) {
        return addConstantIntegerOrFloat(3, i);
    }

    public Symbol addConstantInvokeDynamic(String str, String str2, Handle handle, Object... objArr) {
        return addConstantDynamicOrInvokeDynamicReference(18, str, str2, addBootstrapMethod(handle, objArr).index);
    }

    public Symbol addConstantLong(long j6) {
        return addConstantLongOrDouble(5, j6);
    }

    public Symbol addConstantMethodHandle(int i, String str, String str2, String str3, boolean z6) {
        int iHash = hash(15, str, str2, str3, i);
        for (Entry entry = get(iHash); entry != null; entry = entry.next) {
            if (entry.tag == 15 && entry.hashCode == iHash && entry.data == i && entry.owner.equals(str) && entry.name.equals(str2) && entry.value.equals(str3)) {
                return entry;
            }
        }
        if (i <= 4) {
            this.constantPool.put112(15, i, addConstantFieldref(str, str2, str3).index);
        } else {
            this.constantPool.put112(15, i, addConstantMethodref(str, str2, str3, z6).index);
        }
        int i3 = this.constantPoolCount;
        this.constantPoolCount = i3 + 1;
        return put(new Entry(i3, 15, str, str2, str3, i, iHash));
    }

    public Symbol addConstantMethodType(String str) {
        return addConstantUtf8Reference(16, str);
    }

    public Symbol addConstantMethodref(String str, String str2, String str3, boolean z6) {
        return addConstantMemberReference(z6 ? 11 : 10, str, str2, str3);
    }

    public Symbol addConstantModule(String str) {
        return addConstantUtf8Reference(19, str);
    }

    public int addConstantNameAndType(String str, String str2) {
        int iHash = hash(12, str, str2);
        for (Entry entry = get(iHash); entry != null; entry = entry.next) {
            if (entry.tag == 12 && entry.hashCode == iHash && entry.name.equals(str) && entry.value.equals(str2)) {
                return entry.index;
            }
        }
        this.constantPool.put122(12, addConstantUtf8(str), addConstantUtf8(str2));
        int i = this.constantPoolCount;
        this.constantPoolCount = i + 1;
        return put(new Entry(i, 12, str, str2, iHash)).index;
    }

    public Symbol addConstantPackage(String str) {
        return addConstantUtf8Reference(20, str);
    }

    public Symbol addConstantString(String str) {
        return addConstantUtf8Reference(8, str);
    }

    public int addConstantUtf8(String str) {
        int iHash = hash(1, str);
        for (Entry entry = get(iHash); entry != null; entry = entry.next) {
            if (entry.tag == 1 && entry.hashCode == iHash && entry.value.equals(str)) {
                return entry.index;
            }
        }
        this.constantPool.putByte(1).putUTF8(str);
        int i = this.constantPoolCount;
        this.constantPoolCount = i + 1;
        return put(new Entry(i, 1, str, iHash)).index;
    }

    public int addMergedType(int i, int i3) {
        long j6;
        long j7;
        if (i < i3) {
            j6 = i;
            j7 = i3;
        } else {
            j6 = i3;
            j7 = i;
        }
        long j8 = j6 | (j7 << 32);
        int iHash = hash(130, i + i3);
        for (Entry entry = get(iHash); entry != null; entry = entry.next) {
            if (entry.tag == 130 && entry.hashCode == iHash && entry.data == j8) {
                return entry.info;
            }
        }
        Entry[] entryArr = this.typeTable;
        int iAddType = addType(this.classWriter.getCommonSuperClass(entryArr[i].value, entryArr[i3].value));
        put(new Entry(this.typeCount, 130, j8, iHash)).info = iAddType;
        return iAddType;
    }

    public int addType(String str) {
        int iHash = hash(128, str);
        for (Entry entry = get(iHash); entry != null; entry = entry.next) {
            if (entry.tag == 128 && entry.hashCode == iHash && entry.value.equals(str)) {
                return entry.index;
            }
        }
        return addTypeInternal(new Entry(this.typeCount, 128, str, iHash));
    }

    public int addUninitializedType(String str, int i) {
        int iHash = hash(129, str, i);
        for (Entry entry = get(iHash); entry != null; entry = entry.next) {
            if (entry.tag == 129 && entry.hashCode == iHash && entry.data == i && entry.value.equals(str)) {
                return entry.index;
            }
        }
        return addTypeInternal(new Entry(this.typeCount, 129, str, i, iHash));
    }

    public int computeBootstrapMethodsSize() {
        if (this.bootstrapMethods == null) {
            return 0;
        }
        addConstantUtf8(AttBootstrapMethods.ATTRIBUTE_NAME);
        return this.bootstrapMethods.length + 8;
    }

    public String getClassName() {
        return this.className;
    }

    public int getConstantPoolCount() {
        return this.constantPoolCount;
    }

    public int getConstantPoolLength() {
        return this.constantPool.length;
    }

    public int getMajorVersion() {
        return this.majorVersion;
    }

    public ClassReader getSource() {
        return this.sourceClassReader;
    }

    public Symbol getType(int i) {
        return this.typeTable[i];
    }

    public void putBootstrapMethods(ByteVector byteVector) {
        if (this.bootstrapMethods != null) {
            ByteVector byteVectorPutShort = byteVector.putShort(addConstantUtf8(AttBootstrapMethods.ATTRIBUTE_NAME)).putInt(this.bootstrapMethods.length + 2).putShort(this.bootstrapMethodCount);
            ByteVector byteVector2 = this.bootstrapMethods;
            byteVectorPutShort.putByteArray(byteVector2.data, 0, byteVector2.length);
        }
    }

    public void putConstantPool(ByteVector byteVector) {
        ByteVector byteVectorPutShort = byteVector.putShort(this.constantPoolCount);
        ByteVector byteVector2 = this.constantPool;
        byteVectorPutShort.putByteArray(byteVector2.data, 0, byteVector2.length);
    }

    public int setMajorVersionAndClassName(int i, String str) {
        this.majorVersion = i;
        this.className = str;
        return addConstantClass(str).index;
    }

    public static class Entry extends Symbol {
        final int hashCode;
        Entry next;

        public Entry(int i, int i3, String str, String str2, String str3, long j6, int i4) {
            super(i, i3, str, str2, str3, j6);
            this.hashCode = i4;
        }

        public Entry(int i, int i3, String str, int i4) {
            super(i, i3, null, null, str, 0L);
            this.hashCode = i4;
        }

        public Entry(int i, int i3, String str, long j6, int i4) {
            super(i, i3, null, null, str, j6);
            this.hashCode = i4;
        }

        public Entry(int i, int i3, String str, String str2, int i4) {
            super(i, i3, null, str, str2, 0L);
            this.hashCode = i4;
        }

        public Entry(int i, int i3, long j6, int i4) {
            super(i, i3, null, null, null, j6);
            this.hashCode = i4;
        }
    }

    private static int hash(int i, long j6) {
        return (i + ((int) j6) + ((int) (j6 >>> 32))) & Integer.MAX_VALUE;
    }

    private static int hash(int i, String str) {
        return Integer.MAX_VALUE & (str.hashCode() + i);
    }

    private static int hash(int i, String str, int i3) {
        return Integer.MAX_VALUE & (str.hashCode() + i + i3);
    }

    private static int hash(int i, String str, String str2) {
        return Integer.MAX_VALUE & ((str2.hashCode() * str.hashCode()) + i);
    }

    private static int hash(int i, String str, String str2, int i3) {
        return Integer.MAX_VALUE & (((i3 + 1) * str2.hashCode() * str.hashCode()) + i);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SymbolTable(net.bytebuddy.jar.asm.ClassWriter r12, net.bytebuddy.jar.asm.ClassReader r13) {
        /*
            Method dump skipped, instruction units count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.jar.asm.SymbolTable.<init>(net.bytebuddy.jar.asm.ClassWriter, net.bytebuddy.jar.asm.ClassReader):void");
    }

    private void addConstantIntegerOrFloat(int i, int i3, int i4) {
        add(new Entry(i, i3, i4, hash(i3, i4)));
    }

    private void addConstantUtf8Reference(int i, int i3, String str) {
        add(new Entry(i, i3, str, hash(i3, str)));
    }

    private static int hash(int i, String str, String str2, String str3) {
        return Integer.MAX_VALUE & ((str3.hashCode() * str2.hashCode() * str.hashCode()) + i);
    }

    private static int hash(int i, String str, String str2, String str3, int i3) {
        return Integer.MAX_VALUE & ((str3.hashCode() * str2.hashCode() * str.hashCode() * i3) + i);
    }

    private void addConstantDynamicOrInvokeDynamicReference(int i, int i3, String str, String str2, int i4) {
        add(new Entry(i3, i, null, str, str2, i4, hash(i, str, str2, i4)));
    }

    private void addConstantLongOrDouble(int i, int i3, long j6) {
        add(new Entry(i, i3, j6, hash(i3, j6)));
    }

    private void addConstantUtf8(int i, String str) {
        add(new Entry(i, 1, str, hash(1, str)));
    }

    private void addConstantNameAndType(int i, String str, String str2) {
        add(new Entry(i, 12, str, str2, hash(12, str, str2)));
    }

    private void addConstantMemberReference(int i, int i3, String str, String str2, String str3) {
        add(new Entry(i, i3, str, str2, str3, 0L, hash(i3, str, str2, str3)));
    }

    private void addConstantMethodHandle(int i, int i3, String str, String str2, String str3) {
        add(new Entry(i, 15, str, str2, str3, i3, hash(15, str, str2, str3, i3)));
    }

    private Symbol addBootstrapMethod(int i, int i3, int i4) {
        byte[] bArr = this.bootstrapMethods.data;
        for (Entry entry = get(i4); entry != null; entry = entry.next) {
            if (entry.tag == 64 && entry.hashCode == i4) {
                int i5 = (int) entry.data;
                for (int i6 = 0; i6 < i3; i6++) {
                    if (bArr[i + i6] != bArr[i5 + i6]) {
                        break;
                    }
                }
                this.bootstrapMethods.length = i;
                return entry;
            }
        }
        int i7 = this.bootstrapMethodCount;
        this.bootstrapMethodCount = i7 + 1;
        return put(new Entry(i7, 64, i, i4));
    }
}
