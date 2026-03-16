package io.ktor.util;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import org.bouncycastle.cms.CMSAttributeTableGenerator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/util/HashFunction;", "", "", "input", "", TypedValues.CycleType.S_WAVE_OFFSET, "length", "LN1/m;", "update", "([BII)V", CMSAttributeTableGenerator.DIGEST, "()[B", "ktor-utils"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface HashFunction {
    @NotNull
    byte[] digest();

    void update(@NotNull byte[] input, int offset, int length);
}
