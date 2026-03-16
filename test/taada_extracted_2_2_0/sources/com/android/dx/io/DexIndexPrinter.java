package com.android.dx.io;

import B2.b;
import androidx.constraintlayout.core.motion.a;
import f.f;
import f.j;
import f.l;
import f.m;
import f.r;
import f.u;
import f.v;
import f.w;
import f.x;
import java.io.File;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class DexIndexPrinter {
    private final m dex;
    private final x tableOfContents;

    public DexIndexPrinter(File file) {
        m mVar = new m(file);
        this.dex = mVar;
        this.tableOfContents = mVar.b;
    }

    public static void main(String[] strArr) {
        DexIndexPrinter dexIndexPrinter = new DexIndexPrinter(new File(strArr[0]));
        dexIndexPrinter.printMap();
        dexIndexPrinter.printStrings();
        dexIndexPrinter.printTypeIds();
        dexIndexPrinter.printProtoIds();
        dexIndexPrinter.printFieldIds();
        dexIndexPrinter.printMethodIds();
        dexIndexPrinter.printTypeLists();
        dexIndexPrinter.printClassDefs();
    }

    private void printClassDefs() {
        m mVar = this.dex;
        mVar.getClass();
        Iterator it = !mVar.b.f3174g.a() ? Collections.EMPTY_SET.iterator() : new j(mVar);
        int i = 0;
        while (it.hasNext()) {
            f fVar = (f) it.next();
            System.out.println("class def " + i + ": " + fVar);
            i++;
        }
    }

    private void printFieldIds() {
        int i = 0;
        for (r rVar : this.dex.f3161h) {
            System.out.println("field " + i + ": " + rVar);
            i++;
        }
    }

    private void printMap() {
        for (w wVar : this.tableOfContents.u) {
            if (wVar.c != -1) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder("section ");
                a.w(sb, " off=", wVar.f3169a);
                a.w(sb, " size=", wVar.c);
                a.w(sb, " byteCount=", wVar.b);
                sb.append(Integer.toHexString(wVar.d));
                printStream.println(sb.toString());
            }
        }
    }

    private void printMethodIds() {
        int i = 0;
        for (u uVar : this.dex.i) {
            System.out.println("methodId " + i + ": " + uVar);
            i++;
        }
    }

    private void printProtoIds() {
        int i = 0;
        for (v vVar : this.dex.f3160g) {
            System.out.println("proto " + i + ": " + vVar);
            i++;
        }
    }

    private void printStrings() {
        int i = 0;
        for (String str : this.dex.d) {
            System.out.println("string " + i + ": " + str);
            i++;
        }
    }

    private void printTypeIds() {
        int i = 0;
        for (Integer num : this.dex.e) {
            PrintStream printStream = System.out;
            StringBuilder sbJ = b.j(i, "type ", ": ");
            sbJ.append((String) this.dex.d.get(num.intValue()));
            printStream.println(sbJ.toString());
            i++;
        }
    }

    private void printTypeLists() {
        int i = this.tableOfContents.f3177k.c;
        if (i == -1) {
            System.out.println("No type lists");
            return;
        }
        l lVarD = this.dex.d(i);
        for (int i3 = 0; i3 < this.tableOfContents.f3177k.b; i3++) {
            ByteBuffer byteBuffer = lVarD.b;
            int i4 = byteBuffer.getInt();
            System.out.print("Type list i=" + i3 + ", size=" + i4 + ", elements=");
            for (int i5 = 0; i5 < i4; i5++) {
                System.out.print(" ".concat((String) this.dex.f3159f.get((int) byteBuffer.getShort())));
            }
            if (i4 % 2 == 1) {
                byteBuffer.getShort();
            }
            System.out.println();
        }
    }
}
