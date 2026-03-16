package com.android.dx.ssa.back;

import com.android.dx.rop.code.CstInsn;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.ssa.BasicRegisterMapper;
import com.android.dx.ssa.NormalSsaInsn;
import com.android.dx.ssa.RegisterMapper;
import com.android.dx.ssa.SsaMethod;
import com.android.dx.util.BitIntSet;
import java.util.BitSet;

/* JADX INFO: loaded from: classes.dex */
public class FirstFitAllocator extends RegisterAllocator {
    private static final boolean PRESLOT_PARAMS = true;
    private final BitSet mapped;

    public FirstFitAllocator(SsaMethod ssaMethod, InterferenceGraph interferenceGraph) {
        super(ssaMethod, interferenceGraph);
        this.mapped = new BitSet(ssaMethod.getRegCount());
    }

    private int paramNumberFromMoveParam(NormalSsaInsn normalSsaInsn) {
        return ((CstInteger) ((CstInsn) normalSsaInsn.getOriginalRopInsn()).getConstant()).getValue();
    }

    @Override // com.android.dx.ssa.back.RegisterAllocator
    public RegisterMapper allocateRegisters() {
        int iParamNumberFromMoveParam;
        boolean z6;
        int regCount = this.ssaMeth.getRegCount();
        BasicRegisterMapper basicRegisterMapper = new BasicRegisterMapper(regCount);
        int paramWidth = this.ssaMeth.getParamWidth();
        for (int i = 0; i < regCount; i++) {
            if (!this.mapped.get(i)) {
                int categoryForSsaReg = getCategoryForSsaReg(i);
                BitIntSet bitIntSet = new BitIntSet(regCount);
                this.interference.mergeInterferenceSet(i, bitIntSet);
                if (isDefinitionMoveParam(i)) {
                    iParamNumberFromMoveParam = paramNumberFromMoveParam((NormalSsaInsn) this.ssaMeth.getDefinitionForRegister(i));
                    basicRegisterMapper.addMapping(i, iParamNumberFromMoveParam, categoryForSsaReg);
                    z6 = true;
                } else {
                    basicRegisterMapper.addMapping(i, paramWidth, categoryForSsaReg);
                    iParamNumberFromMoveParam = paramWidth;
                    z6 = false;
                }
                for (int i3 = i + 1; i3 < regCount; i3++) {
                    if (!this.mapped.get(i3) && !isDefinitionMoveParam(i3) && !bitIntSet.has(i3) && (!z6 || categoryForSsaReg >= getCategoryForSsaReg(i3))) {
                        this.interference.mergeInterferenceSet(i3, bitIntSet);
                        categoryForSsaReg = Math.max(categoryForSsaReg, getCategoryForSsaReg(i3));
                        basicRegisterMapper.addMapping(i3, iParamNumberFromMoveParam, categoryForSsaReg);
                        this.mapped.set(i3);
                    }
                }
                this.mapped.set(i);
                if (!z6) {
                    paramWidth += categoryForSsaReg;
                }
            }
        }
        return basicRegisterMapper;
    }

    @Override // com.android.dx.ssa.back.RegisterAllocator
    public boolean wantsParamsMovedHigh() {
        return true;
    }
}
