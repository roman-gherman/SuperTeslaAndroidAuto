package com.android.dx.dex.file;

import B2.b;
import com.android.dx.dex.code.CatchHandlerList;
import com.android.dx.dex.code.CatchTable;
import com.android.dx.dex.code.DalvCode;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.ByteArrayAnnotatedOutput;
import com.android.dx.util.Hex;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class CatchStructs {
    private static final int TRY_ITEM_WRITE_SIZE = 8;
    private final DalvCode code;
    private CatchTable table = null;
    private byte[] encodedHandlers = null;
    private int encodedHandlerHeaderSize = 0;
    private TreeMap<CatchHandlerList, Integer> handlerOffsets = null;

    public CatchStructs(DalvCode dalvCode) {
        this.code = dalvCode;
    }

    private static void annotateAndConsumeHandlers(CatchHandlerList catchHandlerList, int i, int i3, String str, PrintWriter printWriter, AnnotatedOutput annotatedOutput) {
        String human = catchHandlerList.toHuman(str, Hex.u2(i) + ": ");
        if (printWriter != null) {
            printWriter.println(human);
        }
        annotatedOutput.annotate(i3, human);
    }

    private void annotateEntries(String str, PrintWriter printWriter, AnnotatedOutput annotatedOutput) {
        PrintWriter printWriter2;
        AnnotatedOutput annotatedOutput2;
        finishProcessingIfNecessary();
        int iIntValue = 0;
        boolean z6 = annotatedOutput != null;
        int i = z6 ? 6 : 0;
        int i3 = z6 ? 2 : 0;
        int size = this.table.size();
        String strE = b.e(str, "  ");
        if (z6) {
            annotatedOutput.annotate(0, str + "tries:");
        } else {
            printWriter.println(str + "tries:");
        }
        for (int i4 = 0; i4 < size; i4++) {
            CatchTable.Entry entry = this.table.get(i4);
            CatchHandlerList handlers = entry.getHandlers();
            StringBuilder sbL = b.l(strE, "try ");
            sbL.append(Hex.u2or4(entry.getStart()));
            sbL.append("..");
            sbL.append(Hex.u2or4(entry.getEnd()));
            String string = sbL.toString();
            String human = handlers.toHuman(strE, "");
            if (z6) {
                annotatedOutput.annotate(i, string);
                annotatedOutput.annotate(i3, human);
            } else {
                printWriter.println(string);
                printWriter.println(human);
            }
        }
        if (!z6) {
            return;
        }
        annotatedOutput.annotate(0, str + "handlers:");
        int i5 = this.encodedHandlerHeaderSize;
        StringBuilder sbL2 = b.l(strE, "size: ");
        sbL2.append(Hex.u2(this.handlerOffsets.size()));
        annotatedOutput.annotate(i5, sbL2.toString());
        Iterator<Map.Entry<CatchHandlerList, Integer>> it = this.handlerOffsets.entrySet().iterator();
        CatchHandlerList key = null;
        while (true) {
            int i6 = iIntValue;
            CatchHandlerList catchHandlerList = key;
            if (!it.hasNext()) {
                annotateAndConsumeHandlers(catchHandlerList, i6, this.encodedHandlers.length - i6, strE, printWriter, annotatedOutput);
                return;
            }
            Map.Entry<CatchHandlerList, Integer> next = it.next();
            key = next.getKey();
            iIntValue = next.getValue().intValue();
            if (catchHandlerList != null) {
                printWriter2 = printWriter;
                annotatedOutput2 = annotatedOutput;
                annotateAndConsumeHandlers(catchHandlerList, i6, iIntValue - i6, strE, printWriter2, annotatedOutput2);
            } else {
                printWriter2 = printWriter;
                annotatedOutput2 = annotatedOutput;
            }
            printWriter = printWriter2;
            annotatedOutput = annotatedOutput2;
        }
    }

    private void finishProcessingIfNecessary() {
        if (this.table == null) {
            this.table = this.code.getCatches();
        }
    }

    public void debugPrint(PrintWriter printWriter, String str) {
        annotateEntries(str, printWriter, null);
    }

    public void encode(DexFile dexFile) {
        finishProcessingIfNecessary();
        TypeIdsSection typeIds = dexFile.getTypeIds();
        int size = this.table.size();
        this.handlerOffsets = new TreeMap<>();
        for (int i = 0; i < size; i++) {
            this.handlerOffsets.put(this.table.get(i).getHandlers(), null);
        }
        if (this.handlerOffsets.size() > 65535) {
            throw new UnsupportedOperationException("too many catch handlers");
        }
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput = new ByteArrayAnnotatedOutput();
        this.encodedHandlerHeaderSize = byteArrayAnnotatedOutput.writeUleb128(this.handlerOffsets.size());
        for (Map.Entry<CatchHandlerList, Integer> entry : this.handlerOffsets.entrySet()) {
            CatchHandlerList key = entry.getKey();
            int size2 = key.size();
            boolean zCatchesAll = key.catchesAll();
            entry.setValue(Integer.valueOf(byteArrayAnnotatedOutput.getCursor()));
            if (zCatchesAll) {
                byteArrayAnnotatedOutput.writeSleb128(-(size2 - 1));
                size2--;
            } else {
                byteArrayAnnotatedOutput.writeSleb128(size2);
            }
            for (int i3 = 0; i3 < size2; i3++) {
                CatchHandlerList.Entry entry2 = key.get(i3);
                byteArrayAnnotatedOutput.writeUleb128(typeIds.indexOf(entry2.getExceptionType()));
                byteArrayAnnotatedOutput.writeUleb128(entry2.getHandler());
            }
            if (zCatchesAll) {
                byteArrayAnnotatedOutput.writeUleb128(key.get(size2).getHandler());
            }
        }
        this.encodedHandlers = byteArrayAnnotatedOutput.toByteArray();
    }

    public int triesSize() {
        finishProcessingIfNecessary();
        return this.table.size();
    }

    public int writeSize() {
        return (triesSize() * 8) + this.encodedHandlers.length;
    }

    public void writeTo(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        finishProcessingIfNecessary();
        if (annotatedOutput.annotates()) {
            annotateEntries("  ", null, annotatedOutput);
        }
        int size = this.table.size();
        for (int i = 0; i < size; i++) {
            CatchTable.Entry entry = this.table.get(i);
            int start = entry.getStart();
            int end = entry.getEnd();
            int i3 = end - start;
            if (i3 >= 65536) {
                throw new UnsupportedOperationException("bogus exception range: " + Hex.u4(start) + ".." + Hex.u4(end));
            }
            annotatedOutput.writeInt(start);
            annotatedOutput.writeShort(i3);
            annotatedOutput.writeShort(this.handlerOffsets.get(entry.getHandlers()).intValue());
        }
        annotatedOutput.write(this.encodedHandlers);
    }
}
