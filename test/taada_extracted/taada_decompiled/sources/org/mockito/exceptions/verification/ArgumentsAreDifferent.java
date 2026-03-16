package org.mockito.exceptions.verification;

import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.internal.util.StringUtil;

/* JADX INFO: loaded from: classes.dex */
public class ArgumentsAreDifferent extends MockitoAssertionError {
    private static final long serialVersionUID = 1;

    public ArgumentsAreDifferent(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return StringUtil.removeFirstLine(super.getMessage());
    }

    public ArgumentsAreDifferent(String str, String str2, String str3) {
        this(str);
    }
}
