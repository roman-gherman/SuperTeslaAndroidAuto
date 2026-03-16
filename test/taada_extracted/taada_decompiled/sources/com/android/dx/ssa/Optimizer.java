package com.android.dx.ssa;

import com.android.dx.rop.code.RopMethod;
import com.android.dx.rop.code.TranslationAdvice;
import com.android.dx.ssa.back.LivenessAnalyzer;
import com.android.dx.ssa.back.SsaToRop;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes.dex */
public class Optimizer {
    private static TranslationAdvice advice = null;
    private static boolean preserveLocals = true;

    public enum OptionalStep {
        MOVE_PARAM_COMBINER,
        SCCP,
        LITERAL_UPGRADE,
        CONST_COLLECTOR,
        ESCAPE_ANALYSIS
    }

    public static SsaMethod debugDeadCodeRemover(RopMethod ropMethod, int i, boolean z6, boolean z7, TranslationAdvice translationAdvice) {
        preserveLocals = z7;
        advice = translationAdvice;
        SsaMethod ssaMethodConvertToSsaMethod = SsaConverter.convertToSsaMethod(ropMethod, i, z6);
        DeadCodeRemover.process(ssaMethodConvertToSsaMethod);
        return ssaMethodConvertToSsaMethod;
    }

    public static SsaMethod debugEdgeSplit(RopMethod ropMethod, int i, boolean z6, boolean z7, TranslationAdvice translationAdvice) {
        preserveLocals = z7;
        advice = translationAdvice;
        return SsaConverter.testEdgeSplit(ropMethod, i, z6);
    }

    public static SsaMethod debugNoRegisterAllocation(RopMethod ropMethod, int i, boolean z6, boolean z7, TranslationAdvice translationAdvice, EnumSet<OptionalStep> enumSet) {
        preserveLocals = z7;
        advice = translationAdvice;
        SsaMethod ssaMethodConvertToSsaMethod = SsaConverter.convertToSsaMethod(ropMethod, i, z6);
        runSsaFormSteps(ssaMethodConvertToSsaMethod, enumSet);
        LivenessAnalyzer.constructInterferenceGraph(ssaMethodConvertToSsaMethod);
        return ssaMethodConvertToSsaMethod;
    }

    public static SsaMethod debugPhiPlacement(RopMethod ropMethod, int i, boolean z6, boolean z7, TranslationAdvice translationAdvice) {
        preserveLocals = z7;
        advice = translationAdvice;
        return SsaConverter.testPhiPlacement(ropMethod, i, z6);
    }

    public static SsaMethod debugRenaming(RopMethod ropMethod, int i, boolean z6, boolean z7, TranslationAdvice translationAdvice) {
        preserveLocals = z7;
        advice = translationAdvice;
        return SsaConverter.convertToSsaMethod(ropMethod, i, z6);
    }

    public static TranslationAdvice getAdvice() {
        return advice;
    }

    public static boolean getPreserveLocals() {
        return preserveLocals;
    }

    public static RopMethod optimize(RopMethod ropMethod, int i, boolean z6, boolean z7, TranslationAdvice translationAdvice) {
        return optimize(ropMethod, i, z6, z7, translationAdvice, EnumSet.allOf(OptionalStep.class));
    }

    private static RopMethod optimizeMinimizeRegisters(RopMethod ropMethod, int i, boolean z6, EnumSet<OptionalStep> enumSet) {
        SsaMethod ssaMethodConvertToSsaMethod = SsaConverter.convertToSsaMethod(ropMethod, i, z6);
        EnumSet<E> enumSetClone = enumSet.clone();
        enumSetClone.remove(OptionalStep.CONST_COLLECTOR);
        runSsaFormSteps(ssaMethodConvertToSsaMethod, enumSetClone);
        return SsaToRop.convertToRopMethod(ssaMethodConvertToSsaMethod, true);
    }

    private static void runSsaFormSteps(SsaMethod ssaMethod, EnumSet<OptionalStep> enumSet) {
        boolean z6;
        if (enumSet.contains(OptionalStep.MOVE_PARAM_COMBINER)) {
            MoveParamCombiner.process(ssaMethod);
        }
        boolean z7 = false;
        if (enumSet.contains(OptionalStep.SCCP)) {
            SCCP.process(ssaMethod);
            DeadCodeRemover.process(ssaMethod);
            z6 = false;
        } else {
            z6 = true;
        }
        if (enumSet.contains(OptionalStep.LITERAL_UPGRADE)) {
            LiteralOpUpgrader.process(ssaMethod);
            DeadCodeRemover.process(ssaMethod);
            z6 = false;
        }
        OptionalStep optionalStep = OptionalStep.ESCAPE_ANALYSIS;
        enumSet.remove(optionalStep);
        if (enumSet.contains(optionalStep)) {
            EscapeAnalysis.process(ssaMethod);
            DeadCodeRemover.process(ssaMethod);
            z6 = false;
        }
        if (enumSet.contains(OptionalStep.CONST_COLLECTOR)) {
            ConstCollector.process(ssaMethod);
            DeadCodeRemover.process(ssaMethod);
        } else {
            z7 = z6;
        }
        if (z7) {
            DeadCodeRemover.process(ssaMethod);
        }
        PhiTypeResolver.process(ssaMethod);
    }

    public static RopMethod optimize(RopMethod ropMethod, int i, boolean z6, boolean z7, TranslationAdvice translationAdvice, EnumSet<OptionalStep> enumSet) {
        preserveLocals = z7;
        advice = translationAdvice;
        SsaMethod ssaMethodConvertToSsaMethod = SsaConverter.convertToSsaMethod(ropMethod, i, z6);
        runSsaFormSteps(ssaMethodConvertToSsaMethod, enumSet);
        RopMethod ropMethodConvertToRopMethod = SsaToRop.convertToRopMethod(ssaMethodConvertToSsaMethod, false);
        return ropMethodConvertToRopMethod.getBlocks().getRegCount() > advice.getMaxOptimalRegisterCount() ? optimizeMinimizeRegisters(ropMethod, i, z6, enumSet) : ropMethodConvertToRopMethod;
    }
}
