package com.android.dx.command.findusages;

import B2.b;
import com.android.dx.io.CodeReader;
import com.android.dx.io.OpcodeInfo;
import com.android.dx.io.instructions.DecodedInstruction;
import f.C0437c;
import f.C0438d;
import f.e;
import f.f;
import f.j;
import f.k;
import f.m;
import f.r;
import f.u;
import f.y;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class FindUsages {
    private final CodeReader codeReader = new CodeReader();
    private f currentClass;
    private C0438d currentMethod;
    private final m dex;
    private final Set<Integer> fieldIds;
    private final Set<Integer> methodIds;
    private final PrintWriter out;

    public FindUsages(final m mVar, String str, String str2, final PrintWriter printWriter) {
        this.dex = mVar;
        this.out = printWriter;
        HashSet<Integer> hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        Pattern patternCompile = Pattern.compile(str);
        Pattern patternCompile2 = Pattern.compile(str2);
        k kVar = mVar.d;
        for (int i = 0; i < kVar.size(); i++) {
            String str3 = (String) kVar.get(i);
            if (patternCompile.matcher(str3).matches()) {
                hashSet.add(Integer.valueOf(i));
            }
            if (patternCompile2.matcher(str3).matches()) {
                hashSet2.add(Integer.valueOf(i));
            }
        }
        if (hashSet.isEmpty() || hashSet2.isEmpty()) {
            this.fieldIds = null;
            this.methodIds = null;
            return;
        }
        this.methodIds = new HashSet();
        this.fieldIds = new HashSet();
        for (Integer num : hashSet) {
            num.intValue();
            int iBinarySearch = Collections.binarySearch(mVar.e, num);
            if (iBinarySearch >= 0) {
                this.methodIds.addAll(getMethodIds(mVar, hashSet2, iBinarySearch));
                this.fieldIds.addAll(getFieldIds(mVar, hashSet2, iBinarySearch));
            }
        }
        this.codeReader.setFieldVisitor(new CodeReader.Visitor() { // from class: com.android.dx.command.findusages.FindUsages.1
            @Override // com.android.dx.io.CodeReader.Visitor
            public void visit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction) {
                int index = decodedInstruction.getIndex();
                if (FindUsages.this.fieldIds.contains(Integer.valueOf(index))) {
                    printWriter.println(FindUsages.this.location() + ": field reference " + mVar.f3161h.get(index) + " (" + OpcodeInfo.getName(decodedInstruction.getOpcode()) + ")");
                }
            }
        });
        this.codeReader.setMethodVisitor(new CodeReader.Visitor() { // from class: com.android.dx.command.findusages.FindUsages.2
            @Override // com.android.dx.io.CodeReader.Visitor
            public void visit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction) {
                int index = decodedInstruction.getIndex();
                if (FindUsages.this.methodIds.contains(Integer.valueOf(index))) {
                    printWriter.println(FindUsages.this.location() + ": method reference " + mVar.i.get(index) + " (" + OpcodeInfo.getName(decodedInstruction.getOpcode()) + ")");
                }
            }
        });
    }

    private Set<Integer> findAssignableTypes(m mVar, int i) {
        y yVarD;
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(i));
        mVar.getClass();
        Iterator it = !mVar.b.f3174g.a() ? Collections.EMPTY_SET.iterator() : new j(mVar);
        while (it.hasNext()) {
            f fVar = (f) it.next();
            boolean zContains = hashSet.contains(Integer.valueOf(fVar.e));
            int i3 = fVar.c;
            if (zContains) {
                hashSet.add(Integer.valueOf(i3));
            } else {
                m mVar2 = fVar.f3144a;
                int i4 = fVar.f3145f;
                if (i4 == 0) {
                    mVar2.getClass();
                    yVarD = y.c;
                } else {
                    yVarD = mVar2.d(i4).d();
                }
                short[] sArr = yVarD.b;
                int length = sArr.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    }
                    if (hashSet.contains(Integer.valueOf(sArr[i5]))) {
                        hashSet.add(Integer.valueOf(i3));
                        break;
                    }
                    i5++;
                }
            }
        }
        return hashSet;
    }

    private Set<Integer> getFieldIds(m mVar, Set<Integer> set, int i) {
        HashSet hashSet = new HashSet();
        int i3 = 0;
        for (r rVar : mVar.f3161h) {
            if (set.contains(Integer.valueOf(rVar.d)) && i == rVar.b) {
                hashSet.add(Integer.valueOf(i3));
            }
            i3++;
        }
        return hashSet;
    }

    private Set<Integer> getMethodIds(m mVar, Set<Integer> set, int i) {
        Set<Integer> setFindAssignableTypes = findAssignableTypes(mVar, i);
        HashSet hashSet = new HashSet();
        int i3 = 0;
        for (u uVar : mVar.i) {
            if (set.contains(Integer.valueOf(uVar.d)) && setFindAssignableTypes.contains(Integer.valueOf(uVar.b))) {
                hashSet.add(Integer.valueOf(i3));
            }
            i3++;
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String location() {
        String str = (String) this.dex.f3159f.get(this.currentClass.c);
        C0438d c0438d = this.currentMethod;
        if (c0438d == null) {
            return str;
        }
        u uVar = (u) this.dex.i.get(c0438d.f3142a);
        StringBuilder sbL = b.l(str, ".");
        sbL.append((String) this.dex.d.get(uVar.d));
        return sbL.toString();
    }

    public void findUsages() {
        if (this.fieldIds == null || this.methodIds == null) {
            return;
        }
        m mVar = this.dex;
        mVar.getClass();
        Iterator it = !mVar.b.f3174g.a() ? Collections.EMPTY_SET.iterator() : new j(mVar);
        while (it.hasNext()) {
            f fVar = (f) it.next();
            this.currentClass = fVar;
            this.currentMethod = null;
            if (fVar.i != 0) {
                e eVarE = this.dex.e(fVar);
                C0437c[] c0437cArr = eVarE.f3143a;
                int length = c0437cArr.length;
                C0437c[] c0437cArr2 = eVarE.b;
                int length2 = length + c0437cArr2.length;
                C0437c[] c0437cArr3 = new C0437c[length2];
                System.arraycopy(c0437cArr, 0, c0437cArr3, 0, c0437cArr.length);
                System.arraycopy(c0437cArr2, 0, c0437cArr3, c0437cArr.length, c0437cArr2.length);
                for (int i = 0; i < length2; i++) {
                    int i3 = c0437cArr3[i].f3141a;
                    if (this.fieldIds.contains(Integer.valueOf(i3))) {
                        this.out.println(location() + " field declared " + this.dex.f3161h.get(i3));
                    }
                }
                C0438d[] c0438dArr = eVarE.c;
                int length3 = c0438dArr.length;
                C0438d[] c0438dArr2 = eVarE.d;
                int length4 = length3 + c0438dArr2.length;
                C0438d[] c0438dArr3 = new C0438d[length4];
                System.arraycopy(c0438dArr, 0, c0438dArr3, 0, c0438dArr.length);
                System.arraycopy(c0438dArr2, 0, c0438dArr3, c0438dArr.length, c0438dArr2.length);
                for (int i4 = 0; i4 < length4; i4++) {
                    C0438d c0438d = c0438dArr3[i4];
                    this.currentMethod = c0438d;
                    int i5 = c0438d.f3142a;
                    if (this.methodIds.contains(Integer.valueOf(i5))) {
                        this.out.println(location() + " method declared " + this.dex.i.get(i5));
                    }
                    if (c0438d.c != 0) {
                        this.codeReader.visitAll(this.dex.f(c0438d).e);
                    }
                }
            }
        }
        this.currentClass = null;
        this.currentMethod = null;
    }
}
