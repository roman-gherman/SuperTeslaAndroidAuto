package com.google.android.material.datepicker;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.CompositeDateValidator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.material.datepicker.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0342e implements CompositeDateValidator.Operator {
    @Override // com.google.android.material.datepicker.CompositeDateValidator.Operator
    public final int getId() {
        return 1;
    }

    @Override // com.google.android.material.datepicker.CompositeDateValidator.Operator
    public final boolean isValid(List list, long j6) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CalendarConstraints.DateValidator dateValidator = (CalendarConstraints.DateValidator) it.next();
            if (dateValidator != null && dateValidator.isValid(j6)) {
                return true;
            }
        }
        return false;
    }
}
