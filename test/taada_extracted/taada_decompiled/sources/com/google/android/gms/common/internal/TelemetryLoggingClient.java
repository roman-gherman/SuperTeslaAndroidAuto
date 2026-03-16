package com.google.android.gms.common.internal;

import D.e;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.b;
import com.google.errorprone.annotations.DoNotMock;
import com.google.errorprone.annotations.RestrictedInheritance;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* JADX INFO: loaded from: classes.dex */
@DoNotMock("Use canonical fakes instead. go/cheezhead-testing-methodology")
@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms.*", explanation = "Use canonical fakes instead.", link = "go/gmscore-restrictedinheritance")
public interface TelemetryLoggingClient extends HasApiKey<e> {
    @ResultIgnorabilityUnspecified
    b log(TelemetryData telemetryData);
}
