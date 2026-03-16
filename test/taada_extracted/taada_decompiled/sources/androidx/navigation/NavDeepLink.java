package androidx.navigation;

import N1.e;
import a.AbstractC0132a;
import android.net.Uri;
import android.os.Bundle;
import io.ktor.utils.io.Z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.o;
import kotlin.collections.s;
import kotlin.collections.u;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.i;
import kotlin.text.r;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b)\u0018\u0000 \u007f2\u00020\u0001:\u0007\u0080\u0001\u007f\u0081\u0001\u0082\u0001B'\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\tJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\nH\u0000¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\f\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0015\u001a\u00020\n2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\u001d\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016H\u0000¢\u0006\u0004\b\u001c\u0010\u001bJ\u0019\u0010!\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0012H\u0016¢\u0006\u0004\b%\u0010&J1\u0010-\u001a\u00020,2\u0006\u0010\b\u001a\u00020\u00022\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020'2\n\u0010+\u001a\u00060)j\u0002`*H\u0002¢\u0006\u0004\b-\u0010.J\u0019\u0010/\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b/\u0010\rJ\u0019\u00100\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b0\u00101J\u0019\u00102\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b2\u00101J7\u00105\u001a\u00020,2\b\u00103\u001a\u0004\u0018\u00010\u00022\u0006\u00104\u001a\u00020\u00192\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016H\u0002¢\u0006\u0004\b5\u00106J5\u00109\u001a\u00020\u000b2\u0006\u00108\u001a\u0002072\u0006\u00104\u001a\u00020\u00192\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016H\u0002¢\u0006\u0004\b9\u0010:J5\u0010;\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u00104\u001a\u00020\u00192\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016H\u0002¢\u0006\u0004\b;\u0010<JE\u0010A\u001a\u00020\u000b2\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010=2\u0006\u0010@\u001a\u00020?2\u0006\u00104\u001a\u00020\u00192\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016H\u0002¢\u0006\u0004\bA\u0010BJ1\u0010F\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u00192\u0006\u0010C\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\b\u0010E\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\bF\u0010GJ3\u0010H\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u00192\u0006\u0010C\u001a\u00020\u00022\b\u0010D\u001a\u0004\u0018\u00010\u00022\b\u0010E\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\bH\u0010GJ\u000f\u0010I\u001a\u00020,H\u0002¢\u0006\u0004\bI\u0010JJ\u001b\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020?0KH\u0002¢\u0006\u0004\bL\u0010MJ#\u0010O\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020'\u0012\u0004\u0012\u00020\u0002\u0018\u00010NH\u0002¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020,H\u0002¢\u0006\u0004\bQ\u0010JR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010R\u001a\u0004\bS\u0010TR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010R\u001a\u0004\bU\u0010TR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010R\u001a\u0004\bV\u0010TR\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010Y\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010RR\u001d\u0010_\u001a\u0004\u0018\u00010Z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u001b\u0010a\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010\\\u001a\u0004\ba\u0010bR'\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020?0K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bc\u0010\\\u001a\u0004\bd\u0010MR\u0016\u0010f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR/\u0010j\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020'\u0012\u0004\u0012\u00020\u0002\u0018\u00010N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bh\u0010\\\u001a\u0004\bi\u0010PR!\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bk\u0010\\\u001a\u0004\bl\u0010mR\u001d\u0010q\u001a\u0004\u0018\u00010\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bo\u0010\\\u001a\u0004\bp\u0010TR\u001d\u0010t\u001a\u0004\u0018\u00010Z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\br\u0010\\\u001a\u0004\bs\u0010^R\u0018\u0010u\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010RR\u001d\u0010x\u001a\u0004\u0018\u00010Z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bv\u0010\\\u001a\u0004\bw\u0010^R*\u0010z\u001a\u00020\u000b2\u0006\u0010y\u001a\u00020\u000b8G@@X\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010g\u001a\u0004\bz\u0010b\"\u0004\b{\u0010|R\u001a\u0010~\u001a\b\u0012\u0004\u0012\u00020\u00020=8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b}\u0010m¨\u0006\u0083\u0001"}, d2 = {"Landroidx/navigation/NavDeepLink;", "", "", "uriPattern", "action", "mimeType", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "uri", "(Ljava/lang/String;)V", "Landroid/net/Uri;", "", "matches$navigation_common_release", "(Landroid/net/Uri;)Z", "matches", "Landroidx/navigation/NavDeepLinkRequest;", "deepLinkRequest", "(Landroidx/navigation/NavDeepLinkRequest;)Z", "", "getMimeTypeMatchRating", "(Ljava/lang/String;)I", "deepLink", "", "Landroidx/navigation/NavArgument;", "arguments", "Landroid/os/Bundle;", "getMatchingArguments", "(Landroid/net/Uri;Ljava/util/Map;)Landroid/os/Bundle;", "getMatchingPathAndQueryArgs$navigation_common_release", "getMatchingPathAndQueryArgs", "requestedLink", "calculateMatchingPathSegments$navigation_common_release", "(Landroid/net/Uri;)I", "calculateMatchingPathSegments", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "args", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "uriRegex", "LN1/m;", "buildRegex", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/StringBuilder;)V", "matchUri", "matchAction", "(Ljava/lang/String;)Z", "matchMimeType", "fragment", "bundle", "getMatchingUriFragment", "(Ljava/lang/String;Landroid/os/Bundle;Ljava/util/Map;)V", "Ljava/util/regex/Matcher;", "matcher", "getMatchingPathArguments", "(Ljava/util/regex/Matcher;Landroid/os/Bundle;Ljava/util/Map;)Z", "getMatchingQueryArguments", "(Landroid/net/Uri;Landroid/os/Bundle;Ljava/util/Map;)Z", "", "inputParams", "Landroidx/navigation/NavDeepLink$ParamQuery;", "storedParam", "parseInputParams", "(Ljava/util/List;Landroidx/navigation/NavDeepLink$ParamQuery;Landroid/os/Bundle;Ljava/util/Map;)Z", "name", "value", "argument", "parseArgument", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Landroidx/navigation/NavArgument;)Z", "parseArgumentForRepeatedParam", "parsePath", "()V", "", "parseQuery", "()Ljava/util/Map;", "LN1/e;", "parseFragment", "()LN1/e;", "parseMime", "Ljava/lang/String;", "getUriPattern", "()Ljava/lang/String;", "getAction", "getMimeType", "pathArgs", "Ljava/util/List;", "pathRegex", "Ljava/util/regex/Pattern;", "pathPattern$delegate", "Lkotlin/Lazy;", "getPathPattern", "()Ljava/util/regex/Pattern;", "pathPattern", "isParameterizedQuery$delegate", "isParameterizedQuery", "()Z", "queryArgsMap$delegate", "getQueryArgsMap", "queryArgsMap", "isSingleQueryParamValueOnly", "Z", "fragArgsAndRegex$delegate", "getFragArgsAndRegex", "fragArgsAndRegex", "fragArgs$delegate", "getFragArgs", "()Ljava/util/List;", "fragArgs", "fragRegex$delegate", "getFragRegex", "fragRegex", "fragPattern$delegate", "getFragPattern", "fragPattern", "mimeTypeRegex", "mimeTypePattern$delegate", "getMimeTypePattern", "mimeTypePattern", "<set-?>", "isExactDeepLink", "setExactDeepLink$navigation_common_release", "(Z)V", "getArgumentsNames$navigation_common_release", "argumentsNames", "Companion", "Builder", "MimeType", "ParamQuery", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NavDeepLink {
    private final String action;

    /* JADX INFO: renamed from: fragArgs$delegate, reason: from kotlin metadata */
    private final Lazy fragArgs;

    /* JADX INFO: renamed from: fragArgsAndRegex$delegate, reason: from kotlin metadata */
    private final Lazy fragArgsAndRegex;

    /* JADX INFO: renamed from: fragPattern$delegate, reason: from kotlin metadata */
    private final Lazy fragPattern;

    /* JADX INFO: renamed from: fragRegex$delegate, reason: from kotlin metadata */
    private final Lazy fragRegex;
    private boolean isExactDeepLink;

    /* JADX INFO: renamed from: isParameterizedQuery$delegate, reason: from kotlin metadata */
    private final Lazy isParameterizedQuery;
    private boolean isSingleQueryParamValueOnly;
    private final String mimeType;

    /* JADX INFO: renamed from: mimeTypePattern$delegate, reason: from kotlin metadata */
    private final Lazy mimeTypePattern;
    private String mimeTypeRegex;
    private final List<String> pathArgs;

    /* JADX INFO: renamed from: pathPattern$delegate, reason: from kotlin metadata */
    private final Lazy pathPattern;
    private String pathRegex;

    /* JADX INFO: renamed from: queryArgsMap$delegate, reason: from kotlin metadata */
    private final Lazy queryArgsMap;
    private final String uriPattern;
    private static final Companion Companion = new Companion(null);
    private static final Pattern SCHEME_PATTERN = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");
    private static final Pattern FILL_IN_PATTERN = Pattern.compile("\\{(.+?)\\}");

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\b\u0017¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/navigation/NavDeepLink$Builder;", "", "()V", "action", "", "mimeType", "uriPattern", "build", "Landroidx/navigation/NavDeepLink;", "setAction", "setMimeType", "setUriPattern", "Companion", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private String action;
        private String mimeType;
        private String uriPattern;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Landroidx/navigation/NavDeepLink$Builder$Companion;", "", "()V", "fromAction", "Landroidx/navigation/NavDeepLink$Builder;", "action", "", "fromMimeType", "mimeType", "fromUriPattern", "uriPattern", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(d dVar) {
                this();
            }

            @JvmStatic
            public final Builder fromAction(String action) {
                h.f(action, "action");
                if (action.length() <= 0) {
                    throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
                }
                Builder builder = new Builder();
                builder.setAction(action);
                return builder;
            }

            @JvmStatic
            public final Builder fromMimeType(String mimeType) {
                h.f(mimeType, "mimeType");
                Builder builder = new Builder();
                builder.setMimeType(mimeType);
                return builder;
            }

            @JvmStatic
            public final Builder fromUriPattern(String uriPattern) {
                h.f(uriPattern, "uriPattern");
                Builder builder = new Builder();
                builder.setUriPattern(uriPattern);
                return builder;
            }

            private Companion() {
            }
        }

        @JvmStatic
        public static final Builder fromAction(String str) {
            return INSTANCE.fromAction(str);
        }

        @JvmStatic
        public static final Builder fromMimeType(String str) {
            return INSTANCE.fromMimeType(str);
        }

        @JvmStatic
        public static final Builder fromUriPattern(String str) {
            return INSTANCE.fromUriPattern(str);
        }

        public final NavDeepLink build() {
            return new NavDeepLink(this.uriPattern, this.action, this.mimeType);
        }

        public final Builder setAction(String action) {
            h.f(action, "action");
            if (action.length() <= 0) {
                throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
            }
            this.action = action;
            return this;
        }

        public final Builder setMimeType(String mimeType) {
            h.f(mimeType, "mimeType");
            this.mimeType = mimeType;
            return this;
        }

        public final Builder setUriPattern(String uriPattern) {
            h.f(uriPattern, "uriPattern");
            this.uriPattern = uriPattern;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/navigation/NavDeepLink$Companion;", "", "()V", "FILL_IN_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "SCHEME_PATTERN", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(d dVar) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\u0004¨\u0006\u000f"}, d2 = {"Landroidx/navigation/NavDeepLink$MimeType;", "", "mimeType", "", "(Ljava/lang/String;)V", "subType", "getSubType", "()Ljava/lang/String;", "setSubType", "type", "getType", "setType", "compareTo", "", "other", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class MimeType implements Comparable<MimeType> {
        private String subType;
        private String type;

        public MimeType(String mimeType) {
            List listP;
            List listL0;
            h.f(mimeType, "mimeType");
            Pattern patternCompile = Pattern.compile("/");
            h.e(patternCompile, "compile(pattern)");
            Matcher matcher = patternCompile.matcher(mimeType);
            if (matcher.find()) {
                ArrayList arrayList = new ArrayList(10);
                int iEnd = 0;
                do {
                    arrayList.add(mimeType.subSequence(iEnd, matcher.start()).toString());
                    iEnd = matcher.end();
                } while (matcher.find());
                arrayList.add(mimeType.subSequence(iEnd, mimeType.length()).toString());
                listP = arrayList;
            } else {
                listP = Z.p(mimeType.toString());
            }
            if (listP.isEmpty()) {
                listL0 = u.f3804a;
            } else {
                ListIterator listIterator = listP.listIterator(listP.size());
                while (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() != 0) {
                        listL0 = m.l0(listIterator.nextIndex() + 1, listP);
                        break;
                    }
                }
                listL0 = u.f3804a;
            }
            this.type = (String) listL0.get(0);
            this.subType = (String) listL0.get(1);
        }

        public final String getSubType() {
            return this.subType;
        }

        public final String getType() {
            return this.type;
        }

        public final void setSubType(String str) {
            h.f(str, "<set-?>");
            this.subType = str;
        }

        public final void setType(String str) {
            h.f(str, "<set-?>");
            this.type = str;
        }

        @Override // java.lang.Comparable
        public int compareTo(MimeType other) {
            h.f(other, "other");
            int i = h.a(this.type, other.type) ? 2 : 0;
            return h.a(this.subType, other.subType) ? i + 1 : i;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\bR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/navigation/NavDeepLink$ParamQuery;", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "", "name", "LN1/m;", "addArgumentName", "(Ljava/lang/String;)V", "", "index", "getArgumentName", "(I)Ljava/lang/String;", "size", "()I", "paramRegex", "Ljava/lang/String;", "getParamRegex", "()Ljava/lang/String;", "setParamRegex", "", "arguments", "Ljava/util/List;", "getArguments", "()Ljava/util/List;", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ParamQuery {
        private final List<String> arguments = new ArrayList();
        private String paramRegex;

        public final void addArgumentName(String name) {
            h.f(name, "name");
            this.arguments.add(name);
        }

        public final String getArgumentName(int index) {
            return this.arguments.get(index);
        }

        public final List<String> getArguments() {
            return this.arguments;
        }

        public final String getParamRegex() {
            return this.paramRegex;
        }

        public final void setParamRegex(String str) {
            this.paramRegex = str;
        }

        public final int size() {
            return this.arguments.size();
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavDeepLink$isParameterizedQuery$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass2 extends i implements Function0<Boolean> {
        public AnonymousClass2() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf((NavDeepLink.this.getUriPattern() == null || Uri.parse(NavDeepLink.this.getUriPattern()).getQuery() == null) ? false : true);
        }
    }

    public NavDeepLink(String str, String str2, String str3) {
        this.uriPattern = str;
        this.action = str2;
        this.mimeType = str3;
        this.pathArgs = new ArrayList();
        this.pathPattern = AbstractC0132a.M(new NavDeepLink$pathPattern$2(this));
        this.isParameterizedQuery = AbstractC0132a.M(new AnonymousClass2());
        this.queryArgsMap = AbstractC0132a.N(3, new NavDeepLink$queryArgsMap$2(this));
        this.fragArgsAndRegex = AbstractC0132a.N(3, new NavDeepLink$fragArgsAndRegex$2(this));
        this.fragArgs = AbstractC0132a.N(3, new NavDeepLink$fragArgs$2(this));
        this.fragRegex = AbstractC0132a.N(3, new NavDeepLink$fragRegex$2(this));
        this.fragPattern = AbstractC0132a.M(new NavDeepLink$fragPattern$2(this));
        this.mimeTypePattern = AbstractC0132a.M(new NavDeepLink$mimeTypePattern$2(this));
        parsePath();
        parseMime();
    }

    private final void buildRegex(String uri, List<String> args, StringBuilder uriRegex) {
        Matcher matcher = FILL_IN_PATTERN.matcher(uri);
        int iEnd = 0;
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            h.d(strGroup, "null cannot be cast to non-null type kotlin.String");
            args.add(strGroup);
            if (matcher.start() > iEnd) {
                String strSubstring = uri.substring(iEnd, matcher.start());
                h.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                uriRegex.append(Pattern.quote(strSubstring));
            }
            uriRegex.append("([^/]+?)");
            iEnd = matcher.end();
        }
        if (iEnd < uri.length()) {
            String strSubstring2 = uri.substring(iEnd);
            h.e(strSubstring2, "this as java.lang.String).substring(startIndex)");
            uriRegex.append(Pattern.quote(strSubstring2));
        }
    }

    private final List<String> getFragArgs() {
        return (List) this.fragArgs.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e getFragArgsAndRegex() {
        return (e) this.fragArgsAndRegex.getValue();
    }

    private final Pattern getFragPattern() {
        return (Pattern) this.fragPattern.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getFragRegex() {
        return (String) this.fragRegex.getValue();
    }

    private final boolean getMatchingPathArguments(Matcher matcher, Bundle bundle, Map<String, NavArgument> arguments) {
        List<String> list = this.pathArgs;
        ArrayList arrayList = new ArrayList(o.D(list));
        int i = 0;
        for (Object obj : list) {
            int i3 = i + 1;
            if (i < 0) {
                n.C();
                throw null;
            }
            String str = (String) obj;
            String value = Uri.decode(matcher.group(i3));
            NavArgument navArgument = arguments.get(str);
            try {
                h.e(value, "value");
            } catch (IllegalArgumentException unused) {
            }
            if (parseArgument(bundle, str, value, navArgument)) {
                return false;
            }
            arrayList.add(N1.m.f1129a);
            i = i3;
        }
        return true;
    }

    private final boolean getMatchingQueryArguments(Uri deepLink, Bundle bundle, Map<String, NavArgument> arguments) {
        String query;
        for (Map.Entry<String, ParamQuery> entry : getQueryArgsMap().entrySet()) {
            String key = entry.getKey();
            ParamQuery value = entry.getValue();
            List<String> queryParameters = deepLink.getQueryParameters(key);
            if (this.isSingleQueryParamValueOnly && (query = deepLink.getQuery()) != null && !query.equals(deepLink.toString())) {
                queryParameters = Z.p(query);
            }
            if (!parseInputParams(queryParameters, value, bundle, arguments)) {
                return false;
            }
        }
        return true;
    }

    private final void getMatchingUriFragment(String fragment, Bundle bundle, Map<String, NavArgument> arguments) {
        Pattern fragPattern = getFragPattern();
        Matcher matcher = fragPattern != null ? fragPattern.matcher(String.valueOf(fragment)) : null;
        if (matcher != null && matcher.matches()) {
            List<String> fragArgs = getFragArgs();
            ArrayList arrayList = new ArrayList(o.D(fragArgs));
            int i = 0;
            for (Object obj : fragArgs) {
                int i3 = i + 1;
                if (i < 0) {
                    n.C();
                    throw null;
                }
                String str = (String) obj;
                String value = Uri.decode(matcher.group(i3));
                NavArgument navArgument = arguments.get(str);
                try {
                    h.e(value, "value");
                    if (parseArgument(bundle, str, value, navArgument)) {
                        return;
                    }
                    arrayList.add(N1.m.f1129a);
                    i = i3;
                } catch (IllegalArgumentException unused) {
                    return;
                }
            }
        }
    }

    private final Pattern getMimeTypePattern() {
        return (Pattern) this.mimeTypePattern.getValue();
    }

    private final Pattern getPathPattern() {
        return (Pattern) this.pathPattern.getValue();
    }

    private final Map<String, ParamQuery> getQueryArgsMap() {
        return (Map) this.queryArgsMap.getValue();
    }

    private final boolean isParameterizedQuery() {
        return ((Boolean) this.isParameterizedQuery.getValue()).booleanValue();
    }

    private final boolean matchAction(String action) {
        boolean z6 = action == null;
        String str = this.action;
        if (z6 == (str != null)) {
            return false;
        }
        return action == null || h.a(str, action);
    }

    private final boolean matchMimeType(String mimeType) {
        if ((mimeType == null) == (this.mimeType != null)) {
            return false;
        }
        if (mimeType != null) {
            Pattern mimeTypePattern = getMimeTypePattern();
            h.c(mimeTypePattern);
            if (!mimeTypePattern.matcher(mimeType).matches()) {
                return false;
            }
        }
        return true;
    }

    private final boolean matchUri(Uri uri) {
        if ((uri == null) == (getPathPattern() != null)) {
            return false;
        }
        if (uri != null) {
            Pattern pathPattern = getPathPattern();
            h.c(pathPattern);
            if (!pathPattern.matcher(uri.toString()).matches()) {
                return false;
            }
        }
        return true;
    }

    private final boolean parseArgument(Bundle bundle, String name, String value, NavArgument argument) {
        if (argument != null) {
            argument.getType().parseAndPut(bundle, name, value);
            return false;
        }
        bundle.putString(name, value);
        return false;
    }

    private final boolean parseArgumentForRepeatedParam(Bundle bundle, String name, String value, NavArgument argument) {
        if (!bundle.containsKey(name)) {
            return true;
        }
        if (argument == null) {
            return false;
        }
        NavType<Object> type = argument.getType();
        type.parseAndPut(bundle, name, value, type.get(bundle, name));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e parseFragment() {
        String str = this.uriPattern;
        if (str == null || Uri.parse(str).getFragment() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String fragment = Uri.parse(this.uriPattern).getFragment();
        StringBuilder sb = new StringBuilder();
        h.c(fragment);
        buildRegex(fragment, arrayList, sb);
        String string = sb.toString();
        h.e(string, "fragRegex.toString()");
        return new e(arrayList, string);
    }

    private final boolean parseInputParams(List<String> inputParams, ParamQuery storedParam, Bundle bundle, Map<String, NavArgument> arguments) {
        ArrayList arrayList;
        int i;
        if (inputParams == null) {
            return true;
        }
        for (String str : inputParams) {
            String paramRegex = storedParam.getParamRegex();
            Matcher matcher = paramRegex != null ? Pattern.compile(paramRegex, 32).matcher(str) : null;
            if (matcher != null && matcher.matches()) {
                Bundle bundle2 = new Bundle();
                try {
                    List<String> arguments2 = storedParam.getArguments();
                    arrayList = new ArrayList(o.D(arguments2));
                    i = 0;
                } catch (IllegalArgumentException unused) {
                }
                for (Object obj : arguments2) {
                    int i3 = i + 1;
                    if (i < 0) {
                        n.C();
                        throw null;
                    }
                    String str2 = (String) obj;
                    String strGroup = matcher.group(i3);
                    if (strGroup == null) {
                        strGroup = "";
                    }
                    try {
                        NavArgument navArgument = arguments.get(str2);
                        if (parseArgumentForRepeatedParam(bundle, str2, strGroup, navArgument)) {
                            if (strGroup.equals('{' + str2 + '}') || !parseArgument(bundle2, str2, strGroup, navArgument)) {
                            }
                        }
                        arrayList.add(N1.m.f1129a);
                        i = i3;
                    } catch (IllegalArgumentException unused2) {
                        continue;
                    }
                    continue;
                }
                bundle.putAll(bundle2);
            }
            return false;
        }
        return true;
    }

    private final void parseMime() {
        if (this.mimeType == null) {
            return;
        }
        if (!Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(this.mimeType).matches()) {
            throw new IllegalArgumentException(B2.b.h(new StringBuilder("The given mimeType "), this.mimeType, " does not match to required \"type/subtype\" format").toString());
        }
        MimeType mimeType = new MimeType(this.mimeType);
        this.mimeTypeRegex = r.B("^(" + mimeType.getType() + "|[*]+)/(" + mimeType.getSubType() + "|[*]+)$", "*|[*]", "[\\s\\S]");
    }

    private final void parsePath() {
        if (this.uriPattern == null) {
            return;
        }
        StringBuilder sb = new StringBuilder("^");
        if (!SCHEME_PATTERN.matcher(this.uriPattern).find()) {
            sb.append("http[s]?://");
        }
        Matcher matcher = Pattern.compile("(\\?|\\#|$)").matcher(this.uriPattern);
        matcher.find();
        boolean z6 = false;
        String strSubstring = this.uriPattern.substring(0, matcher.start());
        h.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        buildRegex(strSubstring, this.pathArgs, sb);
        if (!kotlin.text.i.D(sb, ".*", false) && !kotlin.text.i.D(sb, "([^/]+?)", false)) {
            z6 = true;
        }
        this.isExactDeepLink = z6;
        sb.append("($|(\\?(.)*)|(\\#(.)*))");
        String string = sb.toString();
        h.e(string, "uriRegex.toString()");
        this.pathRegex = r.B(string, ".*", "\\E.*\\Q");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, ParamQuery> parseQuery() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (isParameterizedQuery()) {
            Uri uri = Uri.parse(this.uriPattern);
            for (String paramName : uri.getQueryParameterNames()) {
                StringBuilder sb = new StringBuilder();
                List<String> queryParameters = uri.getQueryParameters(paramName);
                if (queryParameters.size() > 1) {
                    throw new IllegalArgumentException(B2.b.h(B2.b.m("Query parameter ", paramName, " must only be present once in "), this.uriPattern, ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.").toString());
                }
                String queryParam = (String) m.R(queryParameters);
                if (queryParam == null) {
                    this.isSingleQueryParamValueOnly = true;
                    queryParam = paramName;
                }
                Matcher matcher = FILL_IN_PATTERN.matcher(queryParam);
                ParamQuery paramQuery = new ParamQuery();
                int iEnd = 0;
                while (matcher.find()) {
                    String strGroup = matcher.group(1);
                    h.d(strGroup, "null cannot be cast to non-null type kotlin.String");
                    paramQuery.addArgumentName(strGroup);
                    h.e(queryParam, "queryParam");
                    String strSubstring = queryParam.substring(iEnd, matcher.start());
                    h.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    sb.append(Pattern.quote(strSubstring));
                    sb.append("(.+?)?");
                    iEnd = matcher.end();
                }
                if (iEnd < queryParam.length()) {
                    String strSubstring2 = queryParam.substring(iEnd);
                    h.e(strSubstring2, "this as java.lang.String).substring(startIndex)");
                    sb.append(Pattern.quote(strSubstring2));
                }
                String string = sb.toString();
                h.e(string, "argRegex.toString()");
                paramQuery.setParamRegex(r.B(string, ".*", "\\E.*\\Q"));
                h.e(paramName, "paramName");
                linkedHashMap.put(paramName, paramQuery);
            }
        }
        return linkedHashMap;
    }

    public final int calculateMatchingPathSegments$navigation_common_release(Uri requestedLink) {
        if (requestedLink == null || this.uriPattern == null) {
            return 0;
        }
        List<String> requestedPathSegments = requestedLink.getPathSegments();
        List<String> uriPathSegments = Uri.parse(this.uriPattern).getPathSegments();
        h.e(requestedPathSegments, "requestedPathSegments");
        h.e(uriPathSegments, "uriPathSegments");
        Set setR0 = m.r0(requestedPathSegments);
        setR0.retainAll(uriPathSegments);
        return setR0.size();
    }

    public boolean equals(Object other) {
        if (other != null && (other instanceof NavDeepLink)) {
            NavDeepLink navDeepLink = (NavDeepLink) other;
            if (h.a(this.uriPattern, navDeepLink.uriPattern) && h.a(this.action, navDeepLink.action) && h.a(this.mimeType, navDeepLink.mimeType)) {
                return true;
            }
        }
        return false;
    }

    public final String getAction() {
        return this.action;
    }

    public final List<String> getArgumentsNames$navigation_common_release() {
        List<String> list = this.pathArgs;
        Collection<ParamQuery> collectionValues = getQueryArgsMap().values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            s.F(((ParamQuery) it.next()).getArguments(), arrayList);
        }
        return m.b0(getFragArgs(), m.b0(arrayList, list));
    }

    public final Bundle getMatchingArguments(Uri deepLink, Map<String, NavArgument> arguments) {
        h.f(deepLink, "deepLink");
        h.f(arguments, "arguments");
        Pattern pathPattern = getPathPattern();
        Matcher matcher = pathPattern != null ? pathPattern.matcher(deepLink.toString()) : null;
        if (matcher == null || !matcher.matches()) {
            return null;
        }
        Bundle bundle = new Bundle();
        if (!getMatchingPathArguments(matcher, bundle, arguments)) {
            return null;
        }
        if (isParameterizedQuery() && !getMatchingQueryArguments(deepLink, bundle, arguments)) {
            return null;
        }
        getMatchingUriFragment(deepLink.getFragment(), bundle, arguments);
        if (NavArgumentKt.missingRequiredArguments(arguments, new NavDeepLink$getMatchingArguments$missingRequiredArguments$1(bundle)).isEmpty()) {
            return bundle;
        }
        return null;
    }

    public final Bundle getMatchingPathAndQueryArgs$navigation_common_release(Uri deepLink, Map<String, NavArgument> arguments) {
        h.f(arguments, "arguments");
        Bundle bundle = new Bundle();
        if (deepLink != null) {
            Pattern pathPattern = getPathPattern();
            Matcher matcher = pathPattern != null ? pathPattern.matcher(deepLink.toString()) : null;
            if (matcher != null && matcher.matches()) {
                getMatchingPathArguments(matcher, bundle, arguments);
                if (isParameterizedQuery()) {
                    getMatchingQueryArguments(deepLink, bundle, arguments);
                }
            }
        }
        return bundle;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final int getMimeTypeMatchRating(String mimeType) {
        h.f(mimeType, "mimeType");
        if (this.mimeType == null) {
            return -1;
        }
        Pattern mimeTypePattern = getMimeTypePattern();
        h.c(mimeTypePattern);
        if (mimeTypePattern.matcher(mimeType).matches()) {
            return new MimeType(this.mimeType).compareTo(new MimeType(mimeType));
        }
        return -1;
    }

    public final String getUriPattern() {
        return this.uriPattern;
    }

    public int hashCode() {
        String str = this.uriPattern;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.action;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.mimeType;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    /* JADX INFO: renamed from: isExactDeepLink, reason: from getter */
    public final boolean getIsExactDeepLink() {
        return this.isExactDeepLink;
    }

    public final boolean matches$navigation_common_release(Uri uri) {
        h.f(uri, "uri");
        return matches$navigation_common_release(new NavDeepLinkRequest(uri, null, null));
    }

    public final void setExactDeepLink$navigation_common_release(boolean z6) {
        this.isExactDeepLink = z6;
    }

    public final boolean matches$navigation_common_release(NavDeepLinkRequest deepLinkRequest) {
        h.f(deepLinkRequest, "deepLinkRequest");
        if (matchUri(deepLinkRequest.getUri()) && matchAction(deepLinkRequest.getAction())) {
            return matchMimeType(deepLinkRequest.getMimeType());
        }
        return false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavDeepLink(String uri) {
        this(uri, null, null);
        h.f(uri, "uri");
    }
}
