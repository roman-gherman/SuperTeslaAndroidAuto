package com.android.dx.command.grep;

import B2.b;
import com.android.dx.io.CodeReader;
import com.android.dx.io.instructions.DecodedInstruction;
import f.C0438d;
import f.e;
import f.f;
import f.j;
import f.m;
import f.q;
import f.u;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class Grep {
    private final CodeReader codeReader;
    private int count;
    private f currentClass;
    private C0438d currentMethod;
    private final m dex;
    private final PrintWriter out;
    private final Set<Integer> stringIds;

    public Grep(m mVar, Pattern pattern, PrintWriter printWriter) {
        CodeReader codeReader = new CodeReader();
        this.codeReader = codeReader;
        this.count = 0;
        this.dex = mVar;
        this.out = printWriter;
        this.stringIds = getStringIds(mVar, pattern);
        codeReader.setStringVisitor(new CodeReader.Visitor() { // from class: com.android.dx.command.grep.Grep.1
            @Override // com.android.dx.io.CodeReader.Visitor
            public void visit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction) {
                Grep.this.encounterString(decodedInstruction.getIndex());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void encounterString(int i) {
        if (this.stringIds.contains(Integer.valueOf(i))) {
            this.out.println(location() + " " + ((String) this.dex.d.get(i)));
            this.count = this.count + 1;
        }
    }

    private Set<Integer> getStringIds(m mVar, Pattern pattern) {
        HashSet hashSet = new HashSet();
        Iterator it = mVar.d.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (pattern.matcher((String) it.next()).find()) {
                hashSet.add(Integer.valueOf(i));
            }
            i++;
        }
        return hashSet;
    }

    private String location() {
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

    private void readArray(q qVar) {
        qVar.a(28);
        qVar.b = -1;
        int iZ = C5.f.Z(qVar.f3163a);
        for (int i = 0; i < iZ; i++) {
            int iB = qVar.b();
            if (iB == 23) {
                encounterString(qVar.f());
            } else if (iB == 28) {
                readArray(qVar);
            }
        }
    }

    public int grep() {
        m mVar = this.dex;
        mVar.getClass();
        Iterator it = !mVar.b.f3174g.a() ? Collections.EMPTY_SET.iterator() : new j(mVar);
        while (it.hasNext()) {
            f fVar = (f) it.next();
            this.currentClass = fVar;
            this.currentMethod = null;
            if (fVar.i != 0) {
                e eVarE = this.dex.e(fVar);
                int i = fVar.f3148j;
                if (i != 0) {
                    readArray(new q(this.dex.d(i)));
                }
                C0438d[] c0438dArr = eVarE.c;
                int length = c0438dArr.length;
                C0438d[] c0438dArr2 = eVarE.d;
                int length2 = length + c0438dArr2.length;
                C0438d[] c0438dArr3 = new C0438d[length2];
                System.arraycopy(c0438dArr, 0, c0438dArr3, 0, c0438dArr.length);
                System.arraycopy(c0438dArr2, 0, c0438dArr3, c0438dArr.length, c0438dArr2.length);
                for (int i3 = 0; i3 < length2; i3++) {
                    C0438d c0438d = c0438dArr3[i3];
                    this.currentMethod = c0438d;
                    if (c0438d.c != 0) {
                        this.codeReader.visitAll(this.dex.f(c0438d).e);
                    }
                }
            }
        }
        this.currentClass = null;
        this.currentMethod = null;
        return this.count;
    }
}
