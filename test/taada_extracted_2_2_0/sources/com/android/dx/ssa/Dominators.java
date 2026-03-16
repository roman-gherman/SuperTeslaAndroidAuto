package com.android.dx.ssa;

import com.android.dx.ssa.DomFront;
import com.android.dx.ssa.SsaBasicBlock;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class Dominators {
    private final ArrayList<SsaBasicBlock> blocks;
    private final DomFront.DomInfo[] domInfos;
    private final DFSInfo[] info;
    private final SsaMethod meth;
    private final boolean postdom;
    private final ArrayList<SsaBasicBlock> vertex;

    public static final class DFSInfo {
        public SsaBasicBlock ancestor;
        public ArrayList<SsaBasicBlock> bucket = new ArrayList<>();
        public SsaBasicBlock parent;
        public SsaBasicBlock rep;
        public int semidom;
    }

    public class DfsWalker implements SsaBasicBlock.Visitor {
        private int dfsNum;

        private DfsWalker() {
            this.dfsNum = 0;
        }

        @Override // com.android.dx.ssa.SsaBasicBlock.Visitor
        public void visitBlock(SsaBasicBlock ssaBasicBlock, SsaBasicBlock ssaBasicBlock2) {
            DFSInfo dFSInfo = new DFSInfo();
            int i = this.dfsNum + 1;
            this.dfsNum = i;
            dFSInfo.semidom = i;
            dFSInfo.rep = ssaBasicBlock;
            dFSInfo.parent = ssaBasicBlock2;
            Dominators.this.vertex.add(ssaBasicBlock);
            Dominators.this.info[ssaBasicBlock.getIndex()] = dFSInfo;
        }
    }

    private Dominators(SsaMethod ssaMethod, DomFront.DomInfo[] domInfoArr, boolean z6) {
        this.meth = ssaMethod;
        this.domInfos = domInfoArr;
        this.postdom = z6;
        ArrayList<SsaBasicBlock> blocks = ssaMethod.getBlocks();
        this.blocks = blocks;
        this.info = new DFSInfo[blocks.size() + 2];
        this.vertex = new ArrayList<>();
    }

    private void compress(SsaBasicBlock ssaBasicBlock) {
        if (this.info[this.info[ssaBasicBlock.getIndex()].ancestor.getIndex()].ancestor != null) {
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            arrayList.add(ssaBasicBlock);
            while (!arrayList.isEmpty()) {
                int size = arrayList.size() - 1;
                DFSInfo dFSInfo = this.info[((SsaBasicBlock) arrayList.get(size)).getIndex()];
                SsaBasicBlock ssaBasicBlock2 = dFSInfo.ancestor;
                DFSInfo dFSInfo2 = this.info[ssaBasicBlock2.getIndex()];
                if (!hashSet.add(ssaBasicBlock2) || dFSInfo2.ancestor == null) {
                    arrayList.remove(size);
                    if (dFSInfo2.ancestor != null) {
                        SsaBasicBlock ssaBasicBlock3 = dFSInfo2.rep;
                        if (this.info[ssaBasicBlock3.getIndex()].semidom < this.info[dFSInfo.rep.getIndex()].semidom) {
                            dFSInfo.rep = ssaBasicBlock3;
                        }
                        dFSInfo.ancestor = dFSInfo2.ancestor;
                    }
                } else {
                    arrayList.add(ssaBasicBlock2);
                }
            }
        }
    }

    private SsaBasicBlock eval(SsaBasicBlock ssaBasicBlock) {
        DFSInfo dFSInfo = this.info[ssaBasicBlock.getIndex()];
        if (dFSInfo.ancestor == null) {
            return ssaBasicBlock;
        }
        compress(ssaBasicBlock);
        return dFSInfo.rep;
    }

    private BitSet getPreds(SsaBasicBlock ssaBasicBlock) {
        return this.postdom ? ssaBasicBlock.getSuccessors() : ssaBasicBlock.getPredecessors();
    }

    private BitSet getSuccs(SsaBasicBlock ssaBasicBlock) {
        return this.postdom ? ssaBasicBlock.getPredecessors() : ssaBasicBlock.getSuccessors();
    }

    public static Dominators make(SsaMethod ssaMethod, DomFront.DomInfo[] domInfoArr, boolean z6) {
        Dominators dominators = new Dominators(ssaMethod, domInfoArr, z6);
        dominators.run();
        return dominators;
    }

    private void run() {
        int i;
        int i3;
        SsaBasicBlock exitBlock = this.postdom ? this.meth.getExitBlock() : this.meth.getEntryBlock();
        if (exitBlock != null) {
            this.vertex.add(exitBlock);
            this.domInfos[exitBlock.getIndex()].idom = exitBlock.getIndex();
        }
        this.meth.forEachBlockDepthFirst(this.postdom, new DfsWalker());
        int size = this.vertex.size() - 1;
        int i4 = size;
        while (true) {
            if (i4 < 2) {
                break;
            }
            SsaBasicBlock ssaBasicBlock = this.vertex.get(i4);
            DFSInfo dFSInfo = this.info[ssaBasicBlock.getIndex()];
            BitSet preds = getPreds(ssaBasicBlock);
            for (int iNextSetBit = preds.nextSetBit(0); iNextSetBit >= 0; iNextSetBit = preds.nextSetBit(iNextSetBit + 1)) {
                SsaBasicBlock ssaBasicBlock2 = this.blocks.get(iNextSetBit);
                if (this.info[ssaBasicBlock2.getIndex()] != null && (i3 = this.info[eval(ssaBasicBlock2).getIndex()].semidom) < dFSInfo.semidom) {
                    dFSInfo.semidom = i3;
                }
            }
            this.info[this.vertex.get(dFSInfo.semidom).getIndex()].bucket.add(ssaBasicBlock);
            SsaBasicBlock ssaBasicBlock3 = dFSInfo.parent;
            dFSInfo.ancestor = ssaBasicBlock3;
            ArrayList<SsaBasicBlock> arrayList = this.info[ssaBasicBlock3.getIndex()].bucket;
            while (!arrayList.isEmpty()) {
                SsaBasicBlock ssaBasicBlockRemove = arrayList.remove(arrayList.size() - 1);
                SsaBasicBlock ssaBasicBlockEval = eval(ssaBasicBlockRemove);
                if (this.info[ssaBasicBlockEval.getIndex()].semidom < this.info[ssaBasicBlockRemove.getIndex()].semidom) {
                    this.domInfos[ssaBasicBlockRemove.getIndex()].idom = ssaBasicBlockEval.getIndex();
                } else {
                    this.domInfos[ssaBasicBlockRemove.getIndex()].idom = dFSInfo.parent.getIndex();
                }
            }
            i4--;
        }
        for (i = 2; i <= size; i++) {
            SsaBasicBlock ssaBasicBlock4 = this.vertex.get(i);
            if (this.domInfos[ssaBasicBlock4.getIndex()].idom != this.vertex.get(this.info[ssaBasicBlock4.getIndex()].semidom).getIndex()) {
                DomFront.DomInfo domInfo = this.domInfos[ssaBasicBlock4.getIndex()];
                DomFront.DomInfo[] domInfoArr = this.domInfos;
                domInfo.idom = domInfoArr[domInfoArr[ssaBasicBlock4.getIndex()].idom].idom;
            }
        }
    }
}
