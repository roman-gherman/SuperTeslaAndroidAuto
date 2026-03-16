package com.google.android.material.datepicker;

import android.text.TextUtils;
import com.google.android.material.textfield.TextInputLayout;
import fr.sd.taada.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: renamed from: com.google.android.material.datepicker.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0346i extends com.google.android.material.internal.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f2420a;
    public final SimpleDateFormat b;
    public final CalendarConstraints c;
    public final String d;
    public final X0.h e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RunnableC0345h f2421f;

    public AbstractC0346i(String str, SimpleDateFormat simpleDateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.b = simpleDateFormat;
        this.f2420a = textInputLayout;
        this.c = calendarConstraints;
        this.d = textInputLayout.getContext().getString(R.string.mtrl_picker_out_of_range);
        this.e = new X0.h(15, this, str);
    }

    public abstract void a();

    public abstract void b(Long l6);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v3, types: [com.google.android.material.datepicker.h, java.lang.Runnable] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.material.internal.n, android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i3, int i4) {
        CalendarConstraints calendarConstraints = this.c;
        TextInputLayout textInputLayout = this.f2420a;
        X0.h hVar = this.e;
        textInputLayout.removeCallbacks(hVar);
        textInputLayout.removeCallbacks(this.f2421f);
        textInputLayout.setError(null);
        b(null);
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        try {
            Date date = this.b.parse(charSequence.toString());
            textInputLayout.setError(null);
            final long time = date.getTime();
            if (calendarConstraints.c.isValid(time)) {
                Calendar calendarC = L.c(calendarConstraints.f2361a.f2403a);
                calendarC.set(5, 1);
                if (calendarC.getTimeInMillis() <= time) {
                    Month month = calendarConstraints.b;
                    int i5 = month.e;
                    Calendar calendarC2 = L.c(month.f2403a);
                    calendarC2.set(5, i5);
                    if (time <= calendarC2.getTimeInMillis()) {
                        b(Long.valueOf(date.getTime()));
                        return;
                    }
                }
            }
            ?? r9 = new Runnable() { // from class: com.google.android.material.datepicker.h
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC0346i abstractC0346i = this.f2419a;
                    abstractC0346i.f2420a.setError(String.format(abstractC0346i.d, kotlin.reflect.l.y(time).replace(' ', (char) 160)));
                    abstractC0346i.a();
                }
            };
            this.f2421f = r9;
            textInputLayout.postDelayed(r9, 1000L);
        } catch (ParseException unused) {
            textInputLayout.postDelayed(hVar, 1000L);
        }
    }
}
