package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavDeepLinkRequest;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k3.m;
import kotlin.Metadata;
import kotlin.collections.A;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.z;
import kotlin.sequences.Sequence;
import kotlin.text.r;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u000f\b\u0016\u0018\u0000 u2\u00020\u0001:\u0003vuwB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0013\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u0005J\u0015\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u0019\u0010\u001cJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001d\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010!\u001a\u00020\u0015H\u0017¢\u0006\u0004\b\u001f\u0010\"J\u001b\u0010%\u001a\u00020$2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b%\u0010&J!\u0010)\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010'H\u0007¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0012H\u0017¢\u0006\u0004\b+\u0010,J\u0019\u00100\u001a\u0004\u0018\u00010/2\b\b\u0001\u0010.\u001a\u00020-¢\u0006\u0004\b0\u00101J!\u00104\u001a\u00020\r2\b\b\u0001\u00102\u001a\u00020-2\b\b\u0001\u00103\u001a\u00020-¢\u0006\u0004\b4\u00105J\u001f\u00104\u001a\u00020\r2\b\b\u0001\u00102\u001a\u00020-2\u0006\u00106\u001a\u00020/¢\u0006\u0004\b4\u00107J\u0017\u00108\u001a\u00020\r2\b\b\u0001\u00102\u001a\u00020-¢\u0006\u0004\b8\u00109J\u001d\u0010=\u001a\u00020\r2\u0006\u0010:\u001a\u00020\u00022\u0006\u0010<\u001a\u00020;¢\u0006\u0004\b=\u0010>J\u0015\u0010?\u001a\u00020\r2\u0006\u0010:\u001a\u00020\u0002¢\u0006\u0004\b?\u0010\u0005J\u001b\u0010A\u001a\u0004\u0018\u00010'2\b\u0010@\u001a\u0004\u0018\u00010'H\u0007¢\u0006\u0004\bA\u0010BJ!\u0010D\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010C\u001a\u0004\u0018\u00010'¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\u0002H\u0016¢\u0006\u0004\bF\u0010GJ\u001a\u0010I\u001a\u00020\u00122\b\u0010H\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020-H\u0016¢\u0006\u0004\bK\u0010LJ5\u0010O\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u001a2\b\u0010M\u001a\u0004\u0018\u00010\u00102\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020;0NH\u0002¢\u0006\u0004\bO\u0010PR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010Q\u001a\u0004\bR\u0010GR.\u0010U\u001a\u0004\u0018\u00010S2\b\u0010T\u001a\u0004\u0018\u00010S8\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0018\u0010[\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010QR$\u0010]\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001a\u0010d\u001a\b\u0012\u0004\u0012\u00020\u001a0c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u001a\u0010g\u001a\b\u0012\u0004\u0012\u00020/0f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\"\u0010j\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020;0i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR,\u0010.\u001a\u00020-2\b\b\u0001\u0010.\u001a\u00020-8G@FX\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010l\u001a\u0004\bm\u0010L\"\u0004\bn\u00109R.\u0010\u001d\u001a\u0004\u0018\u00010\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010Q\u001a\u0004\bo\u0010G\"\u0004\bp\u0010\u0005R\u001d\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020;0N8F¢\u0006\u0006\u001a\u0004\bq\u0010rR\u0014\u0010t\u001a\u00020\u00028WX\u0096\u0004¢\u0006\u0006\u001a\u0004\bs\u0010G¨\u0006x"}, d2 = {"Landroidx/navigation/NavDestination;", "", "", "navigatorName", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;)V", "Landroidx/navigation/Navigator;", "navigator", "(Landroidx/navigation/Navigator;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "LN1/m;", "onInflate", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/net/Uri;", "deepLink", "", "hasDeepLink", "(Landroid/net/Uri;)Z", "Landroidx/navigation/NavDeepLinkRequest;", "deepLinkRequest", "(Landroidx/navigation/NavDeepLinkRequest;)Z", "uriPattern", "addDeepLink", "Landroidx/navigation/NavDeepLink;", "navDeepLink", "(Landroidx/navigation/NavDeepLink;)V", "route", "Landroidx/navigation/NavDestination$DeepLinkMatch;", "matchDeepLink", "(Ljava/lang/String;)Landroidx/navigation/NavDestination$DeepLinkMatch;", "navDeepLinkRequest", "(Landroidx/navigation/NavDeepLinkRequest;)Landroidx/navigation/NavDestination$DeepLinkMatch;", "previousDestination", "", "buildDeepLinkIds", "(Landroidx/navigation/NavDestination;)[I", "Landroid/os/Bundle;", "arguments", "hasRoute", "(Ljava/lang/String;Landroid/os/Bundle;)Z", "supportsActions", "()Z", "", "id", "Landroidx/navigation/NavAction;", "getAction", "(I)Landroidx/navigation/NavAction;", "actionId", "destId", "putAction", "(II)V", "action", "(ILandroidx/navigation/NavAction;)V", "removeAction", "(I)V", "argumentName", "Landroidx/navigation/NavArgument;", "argument", "addArgument", "(Ljava/lang/String;Landroidx/navigation/NavArgument;)V", "removeArgument", "args", "addInDefaultArgs", "(Landroid/os/Bundle;)Landroid/os/Bundle;", "bundle", "fillInLabel", "(Landroid/content/Context;Landroid/os/Bundle;)Ljava/lang/String;", "toString", "()Ljava/lang/String;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "uri", "", "hasRequiredArguments", "(Landroidx/navigation/NavDeepLink;Landroid/net/Uri;Ljava/util/Map;)Z", "Ljava/lang/String;", "getNavigatorName", "Landroidx/navigation/NavGraph;", "<set-?>", "parent", "Landroidx/navigation/NavGraph;", "getParent", "()Landroidx/navigation/NavGraph;", "setParent", "(Landroidx/navigation/NavGraph;)V", "idName", "", "label", "Ljava/lang/CharSequence;", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "", "deepLinks", "Ljava/util/List;", "Landroidx/collection/SparseArrayCompat;", "actions", "Landroidx/collection/SparseArrayCompat;", "", "_arguments", "Ljava/util/Map;", "I", "getId", "setId", "getRoute", "setRoute", "getArguments", "()Ljava/util/Map;", "getDisplayName", "displayName", "Companion", "ClassType", "DeepLinkMatch", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class NavDestination {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<String, Class<?>> classes = new LinkedHashMap();
    private Map<String, NavArgument> _arguments;
    private final SparseArrayCompat<NavAction> actions;
    private final List<NavDeepLink> deepLinks;
    private int id;
    private String idName;
    private CharSequence label;
    private final String navigatorName;
    private NavGraph parent;
    private String route;

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\f\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003R\u0013\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/navigation/NavDestination$ClassType;", "", "value", "Lkotlin/reflect/KClass;", "()Ljava/lang/Class;", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {O1.b.b, O1.b.f1179a})
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention(O1.a.b)
    public @interface ClassType {
        Class<?> value();
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J:\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00160\u0006\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00052\u0010\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00160\u0006H\u0005J:\u0010\u0019\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00160\u0006\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00052\u0010\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00160\u0006H\u0007R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Landroidx/navigation/NavDestination$Companion;", "", "()V", "classes", "", "", "Ljava/lang/Class;", "hierarchy", "Lkotlin/sequences/Sequence;", "Landroidx/navigation/NavDestination;", "getHierarchy$annotations", "(Landroidx/navigation/NavDestination;)V", "getHierarchy", "(Landroidx/navigation/NavDestination;)Lkotlin/sequences/Sequence;", "createRoute", "route", "getDisplayName", "context", "Landroid/content/Context;", "id", "", "parseClassFromName", "C", "name", "expectedClassType", "parseClassFromNameInternal", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(d dVar) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getHierarchy$annotations(NavDestination navDestination) {
        }

        public final String createRoute(String route) {
            return route != null ? "android-app://androidx.navigation/".concat(route) : "";
        }

        @JvmStatic
        public final String getDisplayName(Context context, int id) {
            String strValueOf;
            h.f(context, "context");
            if (id <= 16777215) {
                return String.valueOf(id);
            }
            try {
                strValueOf = context.getResources().getResourceName(id);
            } catch (Resources.NotFoundException unused) {
                strValueOf = String.valueOf(id);
            }
            h.e(strValueOf, "try {\n                co….toString()\n            }");
            return strValueOf;
        }

        public final Sequence<NavDestination> getHierarchy(NavDestination navDestination) {
            h.f(navDestination, "<this>");
            return m.B(navDestination, NavDestination$Companion$hierarchy$1.INSTANCE);
        }

        @JvmStatic
        public final <C> Class<? extends C> parseClassFromName(Context context, String name, Class<? extends C> expectedClassType) {
            String str;
            h.f(context, "context");
            h.f(name, "name");
            h.f(expectedClassType, "expectedClassType");
            if (name.charAt(0) == '.') {
                str = context.getPackageName() + name;
            } else {
                str = name;
            }
            Class<? extends C> cls = (Class) NavDestination.classes.get(str);
            if (cls == null) {
                try {
                    cls = (Class<? extends C>) Class.forName(str, true, context.getClassLoader());
                    NavDestination.classes.put(name, cls);
                } catch (ClassNotFoundException e) {
                    throw new IllegalArgumentException(e);
                }
            }
            h.c(cls);
            if (expectedClassType.isAssignableFrom(cls)) {
                return cls;
            }
            throw new IllegalArgumentException((str + " must be a subclass of " + expectedClassType).toString());
        }

        @JvmStatic
        public final <C> Class<? extends C> parseClassFromNameInternal(Context context, String name, Class<? extends C> expectedClassType) {
            h.f(context, "context");
            h.f(name, "name");
            h.f(expectedClassType, "expectedClassType");
            return NavDestination.parseClassFromName(context, name, expectedClassType);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u0011\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0000H\u0096\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/navigation/NavDestination$DeepLinkMatch;", "", "destination", "Landroidx/navigation/NavDestination;", "matchingArgs", "Landroid/os/Bundle;", "isExactDeepLink", "", "matchingPathSegments", "", "hasMatchingAction", "mimeTypeMatchLevel", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;ZIZI)V", "getDestination", "()Landroidx/navigation/NavDestination;", "getMatchingArgs", "()Landroid/os/Bundle;", "compareTo", "other", "hasMatchingArgs", "arguments", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DeepLinkMatch implements Comparable<DeepLinkMatch> {
        private final NavDestination destination;
        private final boolean hasMatchingAction;
        private final boolean isExactDeepLink;
        private final Bundle matchingArgs;
        private final int matchingPathSegments;
        private final int mimeTypeMatchLevel;

        public DeepLinkMatch(NavDestination destination, Bundle bundle, boolean z6, int i, boolean z7, int i3) {
            h.f(destination, "destination");
            this.destination = destination;
            this.matchingArgs = bundle;
            this.isExactDeepLink = z6;
            this.matchingPathSegments = i;
            this.hasMatchingAction = z7;
            this.mimeTypeMatchLevel = i3;
        }

        public final NavDestination getDestination() {
            return this.destination;
        }

        public final Bundle getMatchingArgs() {
            return this.matchingArgs;
        }

        public final boolean hasMatchingArgs(Bundle arguments) {
            Bundle bundle;
            Object obj;
            if (arguments == null || (bundle = this.matchingArgs) == null) {
                return false;
            }
            Set<String> setKeySet = bundle.keySet();
            h.e(setKeySet, "matchingArgs.keySet()");
            for (String key : setKeySet) {
                if (!arguments.containsKey(key)) {
                    return false;
                }
                NavArgument navArgument = (NavArgument) this.destination._arguments.get(key);
                Object obj2 = null;
                NavType<Object> type = navArgument != null ? navArgument.getType() : null;
                if (type != null) {
                    Bundle bundle2 = this.matchingArgs;
                    h.e(key, "key");
                    obj = type.get(bundle2, key);
                } else {
                    obj = null;
                }
                if (type != null) {
                    h.e(key, "key");
                    obj2 = type.get(arguments, key);
                }
                if (!h.a(obj, obj2)) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.lang.Comparable
        public int compareTo(DeepLinkMatch other) {
            h.f(other, "other");
            boolean z6 = this.isExactDeepLink;
            if (z6 && !other.isExactDeepLink) {
                return 1;
            }
            if (!z6 && other.isExactDeepLink) {
                return -1;
            }
            int i = this.matchingPathSegments - other.matchingPathSegments;
            if (i > 0) {
                return 1;
            }
            if (i < 0) {
                return -1;
            }
            Bundle bundle = this.matchingArgs;
            if (bundle != null && other.matchingArgs == null) {
                return 1;
            }
            if (bundle == null && other.matchingArgs != null) {
                return -1;
            }
            if (bundle != null) {
                int size = bundle.size();
                Bundle bundle2 = other.matchingArgs;
                h.c(bundle2);
                int size2 = size - bundle2.size();
                if (size2 > 0) {
                    return 1;
                }
                if (size2 < 0) {
                    return -1;
                }
            }
            boolean z7 = this.hasMatchingAction;
            if (z7 && !other.hasMatchingAction) {
                return 1;
            }
            if (z7 || !other.hasMatchingAction) {
                return this.mimeTypeMatchLevel - other.mimeTypeMatchLevel;
            }
            return -1;
        }
    }

    public NavDestination(String navigatorName) {
        h.f(navigatorName, "navigatorName");
        this.navigatorName = navigatorName;
        this.deepLinks = new ArrayList();
        this.actions = new SparseArrayCompat<>();
        this._arguments = new LinkedHashMap();
    }

    public static /* synthetic */ int[] buildDeepLinkIds$default(NavDestination navDestination, NavDestination navDestination2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildDeepLinkIds");
        }
        if ((i & 1) != 0) {
            navDestination2 = null;
        }
        return navDestination.buildDeepLinkIds(navDestination2);
    }

    @JvmStatic
    public static final String getDisplayName(Context context, int i) {
        return INSTANCE.getDisplayName(context, i);
    }

    public static final Sequence<NavDestination> getHierarchy(NavDestination navDestination) {
        return INSTANCE.getHierarchy(navDestination);
    }

    private final boolean hasRequiredArguments(NavDeepLink deepLink, Uri uri, Map<String, NavArgument> arguments) {
        return NavArgumentKt.missingRequiredArguments(arguments, new NavDestination$hasRequiredArguments$missingRequiredArguments$1(deepLink.getMatchingPathAndQueryArgs$navigation_common_release(uri, arguments))).isEmpty();
    }

    @JvmStatic
    public static final <C> Class<? extends C> parseClassFromName(Context context, String str, Class<? extends C> cls) {
        return INSTANCE.parseClassFromName(context, str, cls);
    }

    @JvmStatic
    public static final <C> Class<? extends C> parseClassFromNameInternal(Context context, String str, Class<? extends C> cls) {
        return INSTANCE.parseClassFromNameInternal(context, str, cls);
    }

    public final void addArgument(String argumentName, NavArgument argument) {
        h.f(argumentName, "argumentName");
        h.f(argument, "argument");
        this._arguments.put(argumentName, argument);
    }

    public final void addDeepLink(String uriPattern) {
        h.f(uriPattern, "uriPattern");
        addDeepLink(new NavDeepLink.Builder().setUriPattern(uriPattern).build());
    }

    public final Bundle addInDefaultArgs(Bundle args) {
        Map<String, NavArgument> map;
        if (args == null && ((map = this._arguments) == null || map.isEmpty())) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (Map.Entry<String, NavArgument> entry : this._arguments.entrySet()) {
            entry.getValue().putDefaultValue(entry.getKey(), bundle);
        }
        if (args != null) {
            bundle.putAll(args);
            for (Map.Entry<String, NavArgument> entry2 : this._arguments.entrySet()) {
                String key = entry2.getKey();
                NavArgument value = entry2.getValue();
                if (!value.verify(key, bundle)) {
                    StringBuilder sbM = B2.b.m("Wrong argument type for '", key, "' in argument bundle. ");
                    sbM.append(value.getType().getName());
                    sbM.append(" expected.");
                    throw new IllegalArgumentException(sbM.toString().toString());
                }
            }
        }
        return bundle;
    }

    public final int[] buildDeepLinkIds() {
        return buildDeepLinkIds$default(this, null, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r9) {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavDestination.equals(java.lang.Object):boolean");
    }

    public final String fillInLabel(Context context, Bundle bundle) {
        NavArgument navArgument;
        h.f(context, "context");
        CharSequence charSequence = this.label;
        if (charSequence == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(charSequence);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            if (bundle == null || !bundle.containsKey(strGroup)) {
                throw new IllegalArgumentException("Could not find \"" + strGroup + "\" in " + bundle + " to fill label \"" + ((Object) charSequence) + '\"');
            }
            matcher.appendReplacement(stringBuffer, "");
            if (h.a((strGroup == null || (navArgument = this._arguments.get(strGroup)) == null) ? null : navArgument.getType(), NavType.ReferenceType)) {
                String string = context.getString(bundle.getInt(strGroup));
                h.e(string, "context.getString(bundle.getInt(argName))");
                stringBuffer.append(string);
            } else {
                stringBuffer.append(bundle.getString(strGroup));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public final NavAction getAction(int id) {
        NavAction navAction = this.actions.isEmpty() ? null : this.actions.get(id);
        if (navAction != null) {
            return navAction;
        }
        NavGraph navGraph = this.parent;
        if (navGraph != null) {
            return navGraph.getAction(id);
        }
        return null;
    }

    public final Map<String, NavArgument> getArguments() {
        return A.M(this._arguments);
    }

    public final int getId() {
        return this.id;
    }

    public final CharSequence getLabel() {
        return this.label;
    }

    public final String getNavigatorName() {
        return this.navigatorName;
    }

    public final NavGraph getParent() {
        return this.parent;
    }

    public final String getRoute() {
        return this.route;
    }

    public boolean hasDeepLink(Uri deepLink) {
        h.f(deepLink, "deepLink");
        return hasDeepLink(new NavDeepLinkRequest(deepLink, null, null));
    }

    public final boolean hasRoute(String route, Bundle arguments) {
        h.f(route, "route");
        if (h.a(this.route, route)) {
            return true;
        }
        DeepLinkMatch deepLinkMatchMatchDeepLink = matchDeepLink(route);
        if (equals(deepLinkMatchMatchDeepLink != null ? deepLinkMatchMatchDeepLink.getDestination() : null)) {
            return deepLinkMatchMatchDeepLink.hasMatchingArgs(arguments);
        }
        return false;
    }

    public int hashCode() {
        Set<String> setKeySet;
        int i = this.id * 31;
        String str = this.route;
        int iHashCode = i + (str != null ? str.hashCode() : 0);
        for (NavDeepLink navDeepLink : this.deepLinks) {
            int i3 = iHashCode * 31;
            String uriPattern = navDeepLink.getUriPattern();
            int iHashCode2 = (i3 + (uriPattern != null ? uriPattern.hashCode() : 0)) * 31;
            String action = navDeepLink.getAction();
            int iHashCode3 = (iHashCode2 + (action != null ? action.hashCode() : 0)) * 31;
            String mimeType = navDeepLink.getMimeType();
            iHashCode = iHashCode3 + (mimeType != null ? mimeType.hashCode() : 0);
        }
        Iterator itValueIterator = SparseArrayKt.valueIterator(this.actions);
        while (itValueIterator.hasNext()) {
            NavAction navAction = (NavAction) itValueIterator.next();
            int destinationId = (navAction.getDestinationId() + (iHashCode * 31)) * 31;
            NavOptions navOptions = navAction.getNavOptions();
            int iHashCode4 = destinationId + (navOptions != null ? navOptions.hashCode() : 0);
            Bundle defaultArguments = navAction.getDefaultArguments();
            if (defaultArguments != null && (setKeySet = defaultArguments.keySet()) != null) {
                for (String str2 : setKeySet) {
                    int i4 = iHashCode4 * 31;
                    Bundle defaultArguments2 = navAction.getDefaultArguments();
                    h.c(defaultArguments2);
                    Object obj = defaultArguments2.get(str2);
                    iHashCode4 = i4 + (obj != null ? obj.hashCode() : 0);
                }
            }
            iHashCode = iHashCode4;
        }
        for (String str3 : this._arguments.keySet()) {
            int iC = androidx.constraintlayout.core.motion.a.c(iHashCode * 31, 31, str3);
            NavArgument navArgument = this._arguments.get(str3);
            iHashCode = iC + (navArgument != null ? navArgument.hashCode() : 0);
        }
        return iHashCode;
    }

    public final DeepLinkMatch matchDeepLink(String route) {
        h.f(route, "route");
        NavDeepLinkRequest.Builder.Companion companion = NavDeepLinkRequest.Builder.INSTANCE;
        Uri uri = Uri.parse(INSTANCE.createRoute(route));
        h.b(uri, "Uri.parse(this)");
        NavDeepLinkRequest navDeepLinkRequestBuild = companion.fromUri(uri).build();
        return this instanceof NavGraph ? ((NavGraph) this).matchDeepLinkExcludingChildren(navDeepLinkRequestBuild) : matchDeepLink(navDeepLinkRequestBuild);
    }

    public void onInflate(Context context, AttributeSet attrs) {
        h.f(context, "context");
        h.f(attrs, "attrs");
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attrs, androidx.navigation.common.R.styleable.Navigator);
        h.e(typedArrayObtainAttributes, "context.resources.obtain…s, R.styleable.Navigator)");
        setRoute(typedArrayObtainAttributes.getString(androidx.navigation.common.R.styleable.Navigator_route));
        if (typedArrayObtainAttributes.hasValue(androidx.navigation.common.R.styleable.Navigator_android_id)) {
            setId(typedArrayObtainAttributes.getResourceId(androidx.navigation.common.R.styleable.Navigator_android_id, 0));
            this.idName = INSTANCE.getDisplayName(context, this.id);
        }
        this.label = typedArrayObtainAttributes.getText(androidx.navigation.common.R.styleable.Navigator_android_label);
        typedArrayObtainAttributes.recycle();
    }

    public final void putAction(int actionId, int destId) {
        putAction(actionId, new NavAction(destId, null, null, 6, null));
    }

    public final void removeAction(int actionId) {
        this.actions.remove(actionId);
    }

    public final void removeArgument(String argumentName) {
        h.f(argumentName, "argumentName");
        this._arguments.remove(argumentName);
    }

    public final void setId(int i) {
        this.id = i;
        this.idName = null;
    }

    public final void setLabel(CharSequence charSequence) {
        this.label = charSequence;
    }

    public final void setParent(NavGraph navGraph) {
        this.parent = navGraph;
    }

    public final void setRoute(String str) {
        Object next;
        if (str == null) {
            setId(0);
        } else {
            if (r.y(str)) {
                throw new IllegalArgumentException("Cannot have an empty route");
            }
            String strCreateRoute = INSTANCE.createRoute(str);
            setId(strCreateRoute.hashCode());
            addDeepLink(strCreateRoute);
        }
        List<NavDeepLink> list = this.deepLinks;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (h.a(((NavDeepLink) next).getUriPattern(), INSTANCE.createRoute(this.route))) {
                    break;
                }
            }
        }
        z.a(list).remove(next);
        this.route = str;
    }

    public boolean supportsActions() {
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        String str = this.idName;
        if (str == null) {
            sb.append("0x");
            sb.append(Integer.toHexString(this.id));
        } else {
            sb.append(str);
        }
        sb.append(")");
        String str2 = this.route;
        if (str2 != null && !r.y(str2)) {
            sb.append(" route=");
            sb.append(this.route);
        }
        if (this.label != null) {
            sb.append(" label=");
            sb.append(this.label);
        }
        String string = sb.toString();
        h.e(string, "sb.toString()");
        return string;
    }

    public final void addDeepLink(NavDeepLink navDeepLink) {
        h.f(navDeepLink, "navDeepLink");
        List<String> listMissingRequiredArguments = NavArgumentKt.missingRequiredArguments(this._arguments, new NavDestination$addDeepLink$missingRequiredArguments$1(navDeepLink));
        if (listMissingRequiredArguments.isEmpty()) {
            this.deepLinks.add(navDeepLink);
            return;
        }
        throw new IllegalArgumentException(("Deep link " + navDeepLink.getUriPattern() + " can't be used to open destination " + this + ".\nFollowing required arguments are missing: " + listMissingRequiredArguments).toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int[] buildDeepLinkIds(androidx.navigation.NavDestination r6) {
        /*
            r5 = this;
            kotlin.collections.i r0 = new kotlin.collections.i
            r0.<init>()
            r1 = r5
        L6:
            androidx.navigation.NavGraph r2 = r1.parent
            if (r6 == 0) goto Ld
            androidx.navigation.NavGraph r3 = r6.parent
            goto Le
        Ld:
            r3 = 0
        Le:
            if (r3 == 0) goto L21
            androidx.navigation.NavGraph r3 = r6.parent
            kotlin.jvm.internal.h.c(r3)
            int r4 = r1.id
            androidx.navigation.NavDestination r3 = r3.findNode(r4)
            if (r3 != r1) goto L21
            r0.addFirst(r1)
            goto L37
        L21:
            if (r2 == 0) goto L2b
            int r3 = r2.getStartDestId()
            int r4 = r1.id
            if (r3 == r4) goto L2e
        L2b:
            r0.addFirst(r1)
        L2e:
            boolean r1 = kotlin.jvm.internal.h.a(r2, r6)
            if (r1 == 0) goto L35
            goto L37
        L35:
            if (r2 != 0) goto L63
        L37:
            java.util.List r6 = kotlin.collections.m.o0(r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = kotlin.collections.o.D(r6)
            r0.<init>(r1)
            java.util.Iterator r6 = r6.iterator()
        L48:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L5e
            java.lang.Object r1 = r6.next()
            androidx.navigation.NavDestination r1 = (androidx.navigation.NavDestination) r1
            int r1 = r1.id
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L48
        L5e:
            int[] r6 = kotlin.collections.m.n0(r0)
            return r6
        L63:
            r1 = r2
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavDestination.buildDeepLinkIds(androidx.navigation.NavDestination):int[]");
    }

    public String getDisplayName() {
        String str = this.idName;
        return str == null ? String.valueOf(this.id) : str;
    }

    public boolean hasDeepLink(NavDeepLinkRequest deepLinkRequest) {
        h.f(deepLinkRequest, "deepLinkRequest");
        return matchDeepLink(deepLinkRequest) != null;
    }

    public final void putAction(int actionId, NavAction action) {
        h.f(action, "action");
        if (supportsActions()) {
            if (actionId == 0) {
                throw new IllegalArgumentException("Cannot have an action with actionId 0");
            }
            this.actions.put(actionId, action);
        } else {
            throw new UnsupportedOperationException("Cannot add action " + actionId + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NavDestination(Navigator<? extends NavDestination> navigator) {
        this(NavigatorProvider.INSTANCE.getNameForNavigator$navigation_common_release(navigator.getClass()));
        h.f(navigator, "navigator");
    }

    public DeepLinkMatch matchDeepLink(NavDeepLinkRequest navDeepLinkRequest) {
        h.f(navDeepLinkRequest, "navDeepLinkRequest");
        if (this.deepLinks.isEmpty()) {
            return null;
        }
        DeepLinkMatch deepLinkMatch = null;
        for (NavDeepLink navDeepLink : this.deepLinks) {
            Uri uri = navDeepLinkRequest.getUri();
            Bundle matchingArguments = uri != null ? navDeepLink.getMatchingArguments(uri, this._arguments) : null;
            int iCalculateMatchingPathSegments$navigation_common_release = navDeepLink.calculateMatchingPathSegments$navigation_common_release(uri);
            String action = navDeepLinkRequest.getAction();
            boolean z6 = action != null && action.equals(navDeepLink.getAction());
            String mimeType = navDeepLinkRequest.getMimeType();
            int mimeTypeMatchRating = mimeType != null ? navDeepLink.getMimeTypeMatchRating(mimeType) : -1;
            if (matchingArguments == null) {
                if (z6 || mimeTypeMatchRating > -1) {
                    if (hasRequiredArguments(navDeepLink, uri, this._arguments)) {
                    }
                }
            }
            DeepLinkMatch deepLinkMatch2 = new DeepLinkMatch(this, matchingArguments, navDeepLink.getIsExactDeepLink(), iCalculateMatchingPathSegments$navigation_common_release, z6, mimeTypeMatchRating);
            if (deepLinkMatch == null || deepLinkMatch2.compareTo(deepLinkMatch) > 0) {
                deepLinkMatch = deepLinkMatch2;
            }
        }
        return deepLinkMatch;
    }
}
