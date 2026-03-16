package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import kotlin.text.i;
import kotlin.text.r;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fJ\u001f\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u000fJ\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/window/embedding/MatcherUtils;", "", "()V", "sDebugMatchers", "", "sMatchersTag", "", "areActivityOrIntentComponentsMatching", "activity", "Landroid/app/Activity;", "ruleComponent", "Landroid/content/ComponentName;", "areActivityOrIntentComponentsMatching$window_release", "areComponentsMatching", "activityComponent", "areComponentsMatching$window_release", "wildcardMatch", "name", "pattern", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MatcherUtils {
    public static final MatcherUtils INSTANCE = new MatcherUtils();
    public static final boolean sDebugMatchers = false;
    public static final String sMatchersTag = "SplitRuleResolution";

    private MatcherUtils() {
    }

    private final boolean wildcardMatch(String name, String pattern) {
        if (!i.D(pattern, Marker.ANY_MARKER, false)) {
            return false;
        }
        if (pattern.equals(Marker.ANY_MARKER)) {
            return true;
        }
        if (i.H(0, 6, pattern, Marker.ANY_MARKER, false) != i.L(6, pattern, Marker.ANY_MARKER) || !r.w(pattern, Marker.ANY_MARKER)) {
            throw new IllegalArgumentException("Name pattern with a wildcard must only contain a single wildcard in the end");
        }
        String strSubstring = pattern.substring(0, pattern.length() - 1);
        h.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return r.C(name, strSubstring);
    }

    public final boolean areActivityOrIntentComponentsMatching$window_release(Activity activity, ComponentName ruleComponent) {
        ComponentName component;
        h.f(activity, "activity");
        h.f(ruleComponent, "ruleComponent");
        if (areComponentsMatching$window_release(activity.getComponentName(), ruleComponent)) {
            return true;
        }
        Intent intent = activity.getIntent();
        if (intent == null || (component = intent.getComponent()) == null) {
            return false;
        }
        return INSTANCE.areComponentsMatching$window_release(component, ruleComponent);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0086 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0089 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean areComponentsMatching$window_release(android.content.ComponentName r6, android.content.ComponentName r7) {
        /*
            r5 = this;
            java.lang.String r0 = "ruleComponent"
            kotlin.jvm.internal.h.f(r7, r0)
            java.lang.String r0 = "*"
            r1 = 1
            r2 = 0
            if (r6 != 0) goto L21
            java.lang.String r6 = r7.getPackageName()
            boolean r6 = kotlin.jvm.internal.h.a(r6, r0)
            if (r6 == 0) goto L89
            java.lang.String r6 = r7.getClassName()
            boolean r6 = kotlin.jvm.internal.h.a(r6, r0)
            if (r6 == 0) goto L89
            goto L88
        L21:
            java.lang.String r3 = r6.toString()
            java.lang.String r4 = "activityComponent.toString()"
            kotlin.jvm.internal.h.e(r3, r4)
            boolean r0 = kotlin.text.i.D(r3, r0, r2)
            if (r0 != 0) goto L8a
            java.lang.String r0 = r6.getPackageName()
            java.lang.String r3 = r7.getPackageName()
            boolean r0 = kotlin.jvm.internal.h.a(r0, r3)
            if (r0 != 0) goto L59
            java.lang.String r0 = r6.getPackageName()
            java.lang.String r3 = "activityComponent.packageName"
            kotlin.jvm.internal.h.e(r0, r3)
            java.lang.String r3 = r7.getPackageName()
            java.lang.String r4 = "ruleComponent.packageName"
            kotlin.jvm.internal.h.e(r3, r4)
            boolean r0 = r5.wildcardMatch(r0, r3)
            if (r0 == 0) goto L57
            goto L59
        L57:
            r0 = r2
            goto L5a
        L59:
            r0 = r1
        L5a:
            java.lang.String r3 = r6.getClassName()
            java.lang.String r4 = r7.getClassName()
            boolean r3 = kotlin.jvm.internal.h.a(r3, r4)
            if (r3 != 0) goto L83
            java.lang.String r6 = r6.getClassName()
            java.lang.String r3 = "activityComponent.className"
            kotlin.jvm.internal.h.e(r6, r3)
            java.lang.String r7 = r7.getClassName()
            java.lang.String r3 = "ruleComponent.className"
            kotlin.jvm.internal.h.e(r7, r3)
            boolean r6 = r5.wildcardMatch(r6, r7)
            if (r6 == 0) goto L81
            goto L83
        L81:
            r6 = r2
            goto L84
        L83:
            r6 = r1
        L84:
            if (r0 == 0) goto L89
            if (r6 == 0) goto L89
        L88:
            return r1
        L89:
            return r2
        L8a:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "Wildcard can only be part of the rule."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.embedding.MatcherUtils.areComponentsMatching$window_release(android.content.ComponentName, android.content.ComponentName):boolean");
    }
}
