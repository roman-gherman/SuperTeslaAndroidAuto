package androidx.navigation;

import N1.m;
import a.AbstractC0132a;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Lifecycle;
import android.view.LifecycleObserver;
import android.view.LifecycleOwner;
import android.view.OnBackPressedCallback;
import android.view.OnBackPressedDispatcher;
import android.view.ViewModelStore;
import android.view.ViewModelStoreOwner;
import androidx.core.app.TaskStackBuilder;
import androidx.core.os.BundleKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs$CastExtraArgs;
import fr.sd.taada.helpers.LocaleHelper;
import io.ktor.utils.io.Z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import k3.C0590a;
import k3.e;
import k3.j;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.C0595b;
import kotlin.collections.D;
import kotlin.collections.i;
import kotlin.collections.n;
import kotlin.collections.u;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.t;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.pool.TypePool;
import o3.EnumC0743a;
import p3.p;
import p3.q;
import p3.v;
import p3.z;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000ü\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0016\u0018\u0000 \u0097\u00022\u00020\u0001:\u0006\u0097\u0002\u0098\u0002\u0099\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0011H\u0017¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0011H\u0017¢\u0006\u0004\b\u0012\u0010\u0017J)\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0017¢\u0006\u0004\b\u0012\u0010\u0019J)\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u001cJ%\u0010\"\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0\u001eH\u0000¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b#\u0010$J\u0019\u0010#\u001a\u00020\u00112\b\b\u0001\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b#\u0010%J\u000f\u0010&\u001a\u00020\u0011H\u0017¢\u0006\u0004\b&\u0010\u0013J\u000f\u0010)\u001a\u00020\rH\u0000¢\u0006\u0004\b'\u0010(J\u0015\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060*H\u0000¢\u0006\u0004\b+\u0010,J\u0019\u0010/\u001a\u00020\r2\b\b\u0001\u0010.\u001a\u00020\u0014H\u0017¢\u0006\u0004\b/\u00100J#\u0010/\u001a\u00020\r2\b\b\u0001\u0010.\u001a\u00020\u00142\b\u00102\u001a\u0004\u0018\u000101H\u0017¢\u0006\u0004\b/\u00103J!\u0010/\u001a\u00020\r2\u0006\u00105\u001a\u0002042\b\u00102\u001a\u0004\u0018\u000101H\u0017¢\u0006\u0004\b/\u00106J\u0019\u00109\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u000107H\u0017¢\u0006\u0004\b9\u0010:J\u001b\u0010<\u001a\u0004\u0018\u00010;2\b\b\u0001\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b<\u0010=J\u0019\u0010<\u001a\u0004\u0018\u00010;2\u0006\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b<\u0010>J\u0019\u0010@\u001a\u00020\r2\b\b\u0001\u0010?\u001a\u00020\u0014H\u0017¢\u0006\u0004\b@\u00100J#\u0010@\u001a\u00020\r2\b\b\u0001\u0010?\u001a\u00020\u00142\b\u0010A\u001a\u0004\u0018\u000101H\u0017¢\u0006\u0004\b@\u00103J-\u0010@\u001a\u00020\r2\b\b\u0001\u0010?\u001a\u00020\u00142\b\u0010A\u001a\u0004\u0018\u0001012\b\u0010C\u001a\u0004\u0018\u00010BH\u0017¢\u0006\u0004\b@\u0010DJ7\u0010@\u001a\u00020\r2\b\b\u0001\u0010?\u001a\u00020\u00142\b\u0010A\u001a\u0004\u0018\u0001012\b\u0010C\u001a\u0004\u0018\u00010B2\b\u0010F\u001a\u0004\u0018\u00010EH\u0017¢\u0006\u0004\b@\u0010GJ\u0017\u0010@\u001a\u00020\r2\u0006\u0010I\u001a\u00020HH\u0017¢\u0006\u0004\b@\u0010JJ!\u0010@\u001a\u00020\r2\u0006\u0010I\u001a\u00020H2\b\u0010C\u001a\u0004\u0018\u00010BH\u0017¢\u0006\u0004\b@\u0010KJ+\u0010@\u001a\u00020\r2\u0006\u0010I\u001a\u00020H2\b\u0010C\u001a\u0004\u0018\u00010B2\b\u0010F\u001a\u0004\u0018\u00010EH\u0017¢\u0006\u0004\b@\u0010LJ\u0017\u0010@\u001a\u00020\r2\u0006\u0010N\u001a\u00020MH\u0017¢\u0006\u0004\b@\u0010OJ!\u0010@\u001a\u00020\r2\u0006\u0010N\u001a\u00020M2\b\u0010C\u001a\u0004\u0018\u00010BH\u0017¢\u0006\u0004\b@\u0010PJ+\u0010@\u001a\u00020\r2\u0006\u0010N\u001a\u00020M2\b\u0010C\u001a\u0004\u0018\u00010B2\b\u0010F\u001a\u0004\u0018\u00010EH\u0017¢\u0006\u0004\b@\u0010QJ\u0017\u0010@\u001a\u00020\r2\u0006\u0010S\u001a\u00020RH\u0017¢\u0006\u0004\b@\u0010TJ!\u0010@\u001a\u00020\r2\u0006\u0010S\u001a\u00020R2\b\u0010C\u001a\u0004\u0018\u00010BH\u0017¢\u0006\u0004\b@\u0010UJ\u001f\u0010@\u001a\u00020\r2\u0006\u0010S\u001a\u00020R2\u0006\u0010F\u001a\u00020EH\u0017¢\u0006\u0004\b@\u0010VJ0\u0010@\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001a2\u0017\u0010Z\u001a\u0013\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020\r0W¢\u0006\u0002\bYH\u0007¢\u0006\u0004\b@\u0010[J/\u0010@\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001a2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010B2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010EH\u0007¢\u0006\u0004\b@\u0010\\J\u000f\u0010^\u001a\u00020]H\u0016¢\u0006\u0004\b^\u0010_J\u0011\u0010\u0018\u001a\u0004\u0018\u000101H\u0017¢\u0006\u0004\b\u0018\u0010`J\u0019\u0010b\u001a\u00020\r2\b\u0010a\u001a\u0004\u0018\u000101H\u0017¢\u0006\u0004\bb\u0010cJ\u0017\u0010f\u001a\u00020\r2\u0006\u0010e\u001a\u00020dH\u0017¢\u0006\u0004\bf\u0010gJ\u0017\u0010j\u001a\u00020\r2\u0006\u0010i\u001a\u00020hH\u0017¢\u0006\u0004\bj\u0010kJ\u0017\u0010m\u001a\u00020\r2\u0006\u0010l\u001a\u00020\u0011H\u0017¢\u0006\u0004\bm\u0010nJ\u0017\u0010q\u001a\u00020\r2\u0006\u0010p\u001a\u00020oH\u0017¢\u0006\u0004\bq\u0010rJ\u0019\u0010u\u001a\u00020t2\b\b\u0001\u0010s\u001a\u00020\u0014H\u0016¢\u0006\u0004\bu\u0010vJ\u0019\u0010w\u001a\u00020\u00062\b\b\u0001\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\bw\u0010xJ\u0015\u0010w\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\bw\u0010yJ\u001f\u0010{\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010z\u001a\u00020\u0006H\u0002¢\u0006\u0004\b{\u0010|Jh\u0010\u0083\u0001\u001a\u00020\r*\n\u0012\u0006\b\u0001\u0012\u00020;0}2\f\u0010~\u001a\b\u0012\u0004\u0012\u00020\u00060*2\b\u0010C\u001a\u0004\u0018\u00010B2\b\u0010F\u001a\u0004\u0018\u00010E2&\b\u0002\u0010\u0082\u0001\u001a\u001f\u0012\u0015\u0012\u00130\u0006¢\u0006\u000e\b\u007f\u0012\n\b\u0080\u0001\u0012\u0005\b\b(\u0081\u0001\u0012\u0004\u0012\u00020\r0WH\u0002¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001JU\u0010\u0085\u0001\u001a\u00020\r*\n\u0012\u0006\b\u0001\u0012\u00020;0}2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00112%\b\u0002\u0010\u0082\u0001\u001a\u001e\u0012\u0014\u0012\u00120\u0006¢\u0006\r\b\u007f\u0012\t\b\u0080\u0001\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\r0WH\u0002¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J-\u0010\u0085\u0001\u001a\u00020\u00112\b\b\u0001\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u0011H\u0003¢\u0006\u0005\b\u0085\u0001\u0010\u0019J)\u0010\u0085\u0001\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0002¢\u0006\u0005\b\u0085\u0001\u0010\u001cJ>\u0010\u0089\u0001\u001a\u00020\u00112\u0011\u0010\u0087\u0001\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030}0*2\u0007\u0010\u0088\u0001\u001a\u00020;2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0002¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J7\u0010\u008e\u0001\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00112\u0011\b\u0002\u0010\u008d\u0001\u001a\n\u0012\u0005\u0012\u00030\u008c\u00010\u008b\u0001H\u0002¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u001b\u0010\u0090\u0001\u001a\u00020\u00112\b\b\u0001\u0010\u0015\u001a\u00020\u0014H\u0003¢\u0006\u0005\b\u0090\u0001\u0010%J\u0019\u0010\u0090\u0001\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001aH\u0003¢\u0006\u0005\b\u0090\u0001\u0010$J\u0011\u0010\u0091\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\b\u0091\u0001\u0010\u0013J\u0011\u0010\u0092\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\b\u0092\u0001\u0010\u0013J\u0011\u0010\u0093\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\b\u0093\u0001\u0010\u0013J\u001b\u0010\u0094\u0001\u001a\u00020\r2\b\u00102\u001a\u0004\u0018\u000101H\u0003¢\u0006\u0005\b\u0094\u0001\u0010cJ\u001d\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u001a2\u0007\u0010I\u001a\u00030\u0095\u0001H\u0002¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J \u0010<\u001a\u0004\u0018\u00010;*\u00020;2\b\b\u0001\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0005\b<\u0010\u0098\u0001J7\u0010@\u001a\u00020\r2\u0007\u0010\u0099\u0001\u001a\u00020;2\b\u0010A\u001a\u0004\u0018\u0001012\b\u0010C\u001a\u0004\u0018\u00010B2\b\u0010F\u001a\u0004\u0018\u00010EH\u0003¢\u0006\u0005\b@\u0010\u009a\u0001J%\u0010\u009b\u0001\u001a\u00020\u00112\u0007\u0010\u0099\u0001\u001a\u00020;2\b\u0010A\u001a\u0004\u0018\u000101H\u0002¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J9\u0010\u009e\u0001\u001a\u00020\u00112\u0007\u0010\u009d\u0001\u001a\u00020\u00142\b\u0010A\u001a\u0004\u0018\u0001012\b\u0010C\u001a\u0004\u0018\u00010B2\b\u0010F\u001a\u0004\u0018\u00010EH\u0002¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J\u0019\u0010\u009e\u0001\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0005\b\u009e\u0001\u0010$J>\u0010 \u0001\u001a\u00020\u00112\f\u0010~\u001a\b\u0012\u0004\u0012\u00020\u00060*2\b\u0010A\u001a\u0004\u0018\u0001012\b\u0010C\u001a\u0004\u0018\u00010B2\b\u0010F\u001a\u0004\u0018\u00010EH\u0002¢\u0006\u0006\b \u0001\u0010¡\u0001J+\u0010£\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060*2\u0011\u0010¢\u0001\u001a\f\u0012\u0005\u0012\u00030\u008c\u0001\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0006\b£\u0001\u0010¤\u0001J@\u0010§\u0001\u001a\u00020\r2\u0007\u0010\u0099\u0001\u001a\u00020;2\t\u0010¥\u0001\u001a\u0004\u0018\u0001012\u0007\u0010\u0081\u0001\u001a\u00020\u00062\u000f\b\u0002\u0010¦\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060*H\u0002¢\u0006\u0006\b§\u0001\u0010¨\u0001J\u0011\u0010©\u0001\u001a\u00020\rH\u0002¢\u0006\u0005\b©\u0001\u0010(R\u001a\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\u000f\n\u0005\b\u0003\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001R\u001c\u0010®\u0001\u001a\u0005\u0018\u00010\u00ad\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R\u001c\u0010±\u0001\u001a\u0005\u0018\u00010°\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R\u001b\u0010³\u0001\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0001\u0010´\u0001R\u001b\u0010µ\u0001\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010¶\u0001R#\u0010¹\u0001\u001a\f\u0012\u0005\u0012\u00030¸\u0001\u0018\u00010·\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u0019\u0010»\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R\u001e\u0010½\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u008b\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001R$\u0010À\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060*0¿\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R,\u0010Ã\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060*0Â\u00018GX\u0087\u0004¢\u0006\u0010\n\u0006\bÃ\u0001\u0010Ä\u0001\u001a\u0006\bÅ\u0001\u0010Æ\u0001R$\u0010Ç\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060*0¿\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÇ\u0001\u0010Á\u0001R)\u0010È\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060*0Â\u00018\u0006¢\u0006\u0010\n\u0006\bÈ\u0001\u0010Ä\u0001\u001a\u0006\bÉ\u0001\u0010Æ\u0001R$\u0010Ë\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060Ê\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bË\u0001\u0010Ì\u0001R%\u0010Î\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0005\u0012\u00030Í\u00010Ê\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÎ\u0001\u0010Ì\u0001R&\u0010Ï\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001a0Ê\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÏ\u0001\u0010Ì\u0001R,\u0010Ð\u0001\u001a\u0017\u0012\u0004\u0012\u00020\u001a\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u008c\u00010\u008b\u00010Ê\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÐ\u0001\u0010Ì\u0001R\u001b\u0010Ñ\u0001\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R\u001b\u0010Ó\u0001\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÓ\u0001\u0010Ô\u0001R\u001c\u0010Ö\u0001\u001a\u0005\u0018\u00010Õ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÖ\u0001\u0010×\u0001R\u001e\u0010Ù\u0001\u001a\t\u0012\u0004\u0012\u00020\u000b0Ø\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÙ\u0001\u0010Ú\u0001R*\u0010Ü\u0001\u001a\u00030Û\u00018@@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÜ\u0001\u0010Ý\u0001\u001a\u0006\bÞ\u0001\u0010ß\u0001\"\u0006\bà\u0001\u0010á\u0001R\u0018\u0010ã\u0001\u001a\u00030â\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bã\u0001\u0010ä\u0001R\u0018\u0010æ\u0001\u001a\u00030å\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bæ\u0001\u0010ç\u0001R\u0019\u0010è\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bè\u0001\u0010¼\u0001R\u001a\u0010ê\u0001\u001a\u00030é\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bê\u0001\u0010ë\u0001R1\u0010í\u0001\u001a\u001c\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020;0}\u0012\t\u0012\u00070ì\u0001R\u00020\u00000Ê\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bí\u0001\u0010Ì\u0001R8\u0010î\u0001\u001a!\u0012\u0015\u0012\u00130\u0006¢\u0006\u000e\b\u007f\u0012\n\b\u0080\u0001\u0012\u0005\b\b(\u0081\u0001\u0012\u0004\u0012\u00020\r\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bî\u0001\u0010ï\u0001R7\u0010ð\u0001\u001a \u0012\u0014\u0012\u00120\u0006¢\u0006\r\b\u007f\u0012\t\b\u0080\u0001\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\r\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bð\u0001\u0010ï\u0001R$\u0010ñ\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110Ê\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bñ\u0001\u0010Ì\u0001R\u0019\u0010ò\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bò\u0001\u0010ó\u0001R\u001e\u0010õ\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060ô\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bõ\u0001\u0010ö\u0001R!\u0010û\u0001\u001a\u00030°\u00018VX\u0096\u0084\u0002¢\u0006\u0010\n\u0006\b÷\u0001\u0010ø\u0001\u001a\u0006\bù\u0001\u0010ú\u0001R\u001e\u0010ý\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060ü\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bý\u0001\u0010þ\u0001R#\u0010\u0080\u0002\u001a\t\u0012\u0004\u0012\u00020\u00060ÿ\u00018\u0006¢\u0006\u0010\n\u0006\b\u0080\u0002\u0010\u0081\u0002\u001a\u0006\b\u0082\u0002\u0010\u0083\u0002R'\u00105\u001a\u0002042\u0006\u00105\u001a\u0002048W@WX\u0096\u000e¢\u0006\u000f\u001a\u0006\b\u0084\u0002\u0010\u0085\u0002\"\u0005\b/\u0010\u0086\u0002R,\u0010\u0087\u0002\u001a\u00030é\u00012\b\u0010\u0087\u0002\u001a\u00030é\u00018V@WX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u0088\u0002\u0010\u0089\u0002\"\u0006\b\u008a\u0002\u0010\u008b\u0002R\u0019\u0010\u008e\u0002\u001a\u0004\u0018\u00010;8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008c\u0002\u0010\u008d\u0002R\u0019\u0010\u0091\u0002\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008f\u0002\u0010\u0090\u0002R\u0019\u0010\u0093\u0002\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0092\u0002\u0010\u0090\u0002R\u0017\u0010\u0096\u0002\u001a\u00020\u00148BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0094\u0002\u0010\u0095\u0002¨\u0006\u009a\u0002"}, d2 = {"Landroidx/navigation/NavController;", "", "Landroid/content/Context;", "context", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroid/content/Context;)V", "Landroidx/navigation/NavBackStackEntry;", "child", "unlinkChildFromParent$navigation_runtime_release", "(Landroidx/navigation/NavBackStackEntry;)Landroidx/navigation/NavBackStackEntry;", "unlinkChildFromParent", "Landroidx/navigation/NavController$OnDestinationChangedListener;", ServiceSpecificExtraArgs$CastExtraArgs.LISTENER, "LN1/m;", "addOnDestinationChangedListener", "(Landroidx/navigation/NavController$OnDestinationChangedListener;)V", "removeOnDestinationChangedListener", "", "popBackStack", "()Z", "", "destinationId", "inclusive", "(IZ)Z", "saveState", "(IZZ)Z", "", "route", "(Ljava/lang/String;ZZ)Z", "popUpTo", "Lkotlin/Function0;", "onComplete", "popBackStackFromNavigator$navigation_runtime_release", "(Landroidx/navigation/NavBackStackEntry;Lkotlin/jvm/functions/Function0;)V", "popBackStackFromNavigator", "clearBackStack", "(Ljava/lang/String;)Z", "(I)Z", "navigateUp", "updateBackStackLifecycle$navigation_runtime_release", "()V", "updateBackStackLifecycle", "", "populateVisibleEntries$navigation_runtime_release", "()Ljava/util/List;", "populateVisibleEntries", "graphResId", "setGraph", "(I)V", "Landroid/os/Bundle;", "startDestinationArgs", "(ILandroid/os/Bundle;)V", "Landroidx/navigation/NavGraph;", "graph", "(Landroidx/navigation/NavGraph;Landroid/os/Bundle;)V", "Landroid/content/Intent;", "intent", "handleDeepLink", "(Landroid/content/Intent;)Z", "Landroidx/navigation/NavDestination;", "findDestination", "(I)Landroidx/navigation/NavDestination;", "(Ljava/lang/String;)Landroidx/navigation/NavDestination;", "resId", "navigate", "args", "Landroidx/navigation/NavOptions;", "navOptions", "(ILandroid/os/Bundle;Landroidx/navigation/NavOptions;)V", "Landroidx/navigation/Navigator$Extras;", "navigatorExtras", "(ILandroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "Landroid/net/Uri;", "deepLink", "(Landroid/net/Uri;)V", "(Landroid/net/Uri;Landroidx/navigation/NavOptions;)V", "(Landroid/net/Uri;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "Landroidx/navigation/NavDeepLinkRequest;", "request", "(Landroidx/navigation/NavDeepLinkRequest;)V", "(Landroidx/navigation/NavDeepLinkRequest;Landroidx/navigation/NavOptions;)V", "(Landroidx/navigation/NavDeepLinkRequest;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "Landroidx/navigation/NavDirections;", "directions", "(Landroidx/navigation/NavDirections;)V", "(Landroidx/navigation/NavDirections;Landroidx/navigation/NavOptions;)V", "(Landroidx/navigation/NavDirections;Landroidx/navigation/Navigator$Extras;)V", "Lkotlin/Function1;", "Landroidx/navigation/NavOptionsBuilder;", "Lkotlin/ExtensionFunctionType;", "builder", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/String;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "Landroidx/navigation/NavDeepLinkBuilder;", "createDeepLink", "()Landroidx/navigation/NavDeepLinkBuilder;", "()Landroid/os/Bundle;", "navState", "restoreState", "(Landroid/os/Bundle;)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "Landroidx/activity/OnBackPressedDispatcher;", "dispatcher", "setOnBackPressedDispatcher", "(Landroidx/activity/OnBackPressedDispatcher;)V", "enabled", "enableOnBackPressed", "(Z)V", "Landroidx/lifecycle/ViewModelStore;", "viewModelStore", "setViewModelStore", "(Landroidx/lifecycle/ViewModelStore;)V", "navGraphId", "Landroidx/lifecycle/ViewModelStoreOwner;", "getViewModelStoreOwner", "(I)Landroidx/lifecycle/ViewModelStoreOwner;", "getBackStackEntry", "(I)Landroidx/navigation/NavBackStackEntry;", "(Ljava/lang/String;)Landroidx/navigation/NavBackStackEntry;", "parent", "linkChildToParent", "(Landroidx/navigation/NavBackStackEntry;Landroidx/navigation/NavBackStackEntry;)V", "Landroidx/navigation/Navigator;", "entries", "Lkotlin/ParameterName;", "name", "backStackEntry", "handler", "navigateInternal", "(Landroidx/navigation/Navigator;Ljava/util/List;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;Lkotlin/jvm/functions/Function1;)V", "popBackStackInternal", "(Landroidx/navigation/Navigator;Landroidx/navigation/NavBackStackEntry;ZLkotlin/jvm/functions/Function1;)V", "popOperations", "foundDestination", "executePopOperations", "(Ljava/util/List;Landroidx/navigation/NavDestination;ZZ)Z", "Lkotlin/collections/i;", "Landroidx/navigation/NavBackStackEntryState;", "savedState", "popEntryFromBackStack", "(Landroidx/navigation/NavBackStackEntry;ZLkotlin/collections/i;)V", "clearBackStackInternal", "tryRelaunchUpToExplicitStack", "tryRelaunchUpToGeneratedStack", "dispatchOnDestinationChanged", "onGraphCreated", "", "findInvalidDestinationDisplayNameInDeepLink", "([I)Ljava/lang/String;", "(Landroidx/navigation/NavDestination;I)Landroidx/navigation/NavDestination;", "node", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "launchSingleTopInternal", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;)Z", "id", "restoreStateInternal", "(ILandroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)Z", "executeRestoreState", "(Ljava/util/List;Landroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)Z", "backStackState", "instantiateBackStack", "(Lkotlin/collections/i;)Ljava/util/List;", "finalArgs", "restoredEntries", "addEntryToBackStack", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;Landroidx/navigation/NavBackStackEntry;Ljava/util/List;)V", "updateOnBackPressedCallbackEnabled", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/app/Activity;", "activity", "Landroid/app/Activity;", "Landroidx/navigation/NavInflater;", "inflater", "Landroidx/navigation/NavInflater;", "_graph", "Landroidx/navigation/NavGraph;", "navigatorStateToRestore", "Landroid/os/Bundle;", "", "Landroid/os/Parcelable;", "backStackToRestore", "[Landroid/os/Parcelable;", "deepLinkHandled", "Z", "backQueue", "Lkotlin/collections/i;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_currentBackStack", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "currentBackStack", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentBackStack", "()Lkotlinx/coroutines/flow/StateFlow;", "_visibleEntries", "visibleEntries", "getVisibleEntries", "", "childToParentEntries", "Ljava/util/Map;", "Ljava/util/concurrent/atomic/AtomicInteger;", "parentToChildCount", "backStackMap", "backStackStates", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "Landroidx/navigation/NavControllerViewModel;", "viewModel", "Landroidx/navigation/NavControllerViewModel;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "onDestinationChangedListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/lifecycle/Lifecycle$State;", "hostLifecycleState", "Landroidx/lifecycle/Lifecycle$State;", "getHostLifecycleState$navigation_runtime_release", "()Landroidx/lifecycle/Lifecycle$State;", "setHostLifecycleState$navigation_runtime_release", "(Landroidx/lifecycle/Lifecycle$State;)V", "Landroidx/lifecycle/LifecycleObserver;", "lifecycleObserver", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/activity/OnBackPressedCallback;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "enableOnBackPressedCallback", "Landroidx/navigation/NavigatorProvider;", "_navigatorProvider", "Landroidx/navigation/NavigatorProvider;", "Landroidx/navigation/NavController$NavControllerNavigatorState;", "navigatorState", "addToBackStackHandler", "Lkotlin/jvm/functions/Function1;", "popFromBackStackHandler", "entrySavedState", "dispatchReentrantCount", "I", "", "backStackEntriesToDispatch", "Ljava/util/List;", "navInflater$delegate", "Lkotlin/Lazy;", "getNavInflater", "()Landroidx/navigation/NavInflater;", "navInflater", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_currentBackStackEntryFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/Flow;", "currentBackStackEntryFlow", "Lkotlinx/coroutines/flow/Flow;", "getCurrentBackStackEntryFlow", "()Lkotlinx/coroutines/flow/Flow;", "getGraph", "()Landroidx/navigation/NavGraph;", "(Landroidx/navigation/NavGraph;)V", "navigatorProvider", "getNavigatorProvider", "()Landroidx/navigation/NavigatorProvider;", "setNavigatorProvider", "(Landroidx/navigation/NavigatorProvider;)V", "getCurrentDestination", "()Landroidx/navigation/NavDestination;", "currentDestination", "getCurrentBackStackEntry", "()Landroidx/navigation/NavBackStackEntry;", "currentBackStackEntry", "getPreviousBackStackEntry", "previousBackStackEntry", "getDestinationCountOnBackStack", "()I", "destinationCountOnBackStack", "Companion", "NavControllerNavigatorState", "OnDestinationChangedListener", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class NavController {
    private static final String KEY_BACK_STACK = "android-support-nav:controller:backStack";
    private static final String KEY_BACK_STACK_DEST_IDS = "android-support-nav:controller:backStackDestIds";
    private static final String KEY_BACK_STACK_IDS = "android-support-nav:controller:backStackIds";
    private static final String KEY_BACK_STACK_STATES_IDS = "android-support-nav:controller:backStackStates";
    private static final String KEY_BACK_STACK_STATES_PREFIX = "android-support-nav:controller:backStackStates:";
    public static final String KEY_DEEP_LINK_ARGS = "android-support-nav:controller:deepLinkArgs";
    public static final String KEY_DEEP_LINK_EXTRAS = "android-support-nav:controller:deepLinkExtras";
    public static final String KEY_DEEP_LINK_HANDLED = "android-support-nav:controller:deepLinkHandled";
    public static final String KEY_DEEP_LINK_IDS = "android-support-nav:controller:deepLinkIds";
    public static final String KEY_DEEP_LINK_INTENT = "android-support-nav:controller:deepLinkIntent";
    private static final String KEY_NAVIGATOR_STATE = "android-support-nav:controller:navigatorState";
    private static final String KEY_NAVIGATOR_STATE_NAMES = "android-support-nav:controller:navigatorState:names";
    private static final String TAG = "NavController";
    private final MutableStateFlow<List<NavBackStackEntry>> _currentBackStack;
    private final MutableSharedFlow<NavBackStackEntry> _currentBackStackEntryFlow;
    private NavGraph _graph;
    private NavigatorProvider _navigatorProvider;
    private final MutableStateFlow<List<NavBackStackEntry>> _visibleEntries;
    private Activity activity;
    private Function1<? super NavBackStackEntry, m> addToBackStackHandler;
    private final i backQueue;
    private final List<NavBackStackEntry> backStackEntriesToDispatch;
    private final Map<Integer, String> backStackMap;
    private final Map<String, i> backStackStates;
    private Parcelable[] backStackToRestore;
    private final Map<NavBackStackEntry, NavBackStackEntry> childToParentEntries;
    private final Context context;
    private final StateFlow<List<NavBackStackEntry>> currentBackStack;
    private final Flow<NavBackStackEntry> currentBackStackEntryFlow;
    private boolean deepLinkHandled;
    private int dispatchReentrantCount;
    private boolean enableOnBackPressedCallback;
    private final Map<NavBackStackEntry, Boolean> entrySavedState;
    private Lifecycle.State hostLifecycleState;
    private NavInflater inflater;
    private final LifecycleObserver lifecycleObserver;
    private LifecycleOwner lifecycleOwner;

    /* JADX INFO: renamed from: navInflater$delegate, reason: from kotlin metadata */
    private final Lazy navInflater;
    private final Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> navigatorState;
    private Bundle navigatorStateToRestore;
    private final OnBackPressedCallback onBackPressedCallback;
    private OnBackPressedDispatcher onBackPressedDispatcher;
    private final CopyOnWriteArrayList<OnDestinationChangedListener> onDestinationChangedListeners;
    private final Map<NavBackStackEntry, AtomicInteger> parentToChildCount;
    private Function1<? super NavBackStackEntry, m> popFromBackStackHandler;
    private NavControllerViewModel viewModel;
    private final StateFlow<List<NavBackStackEntry>> visibleEntries;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean deepLinkSaveState = true;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087T¢\u0006\f\n\u0004\b\n\u0010\u000b\u0012\u0004\b\f\u0010\u0003R\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\t8\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\t8\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\t8\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0015\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u000bR\u0014\u0010\u0017\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u000bR\u0014\u0010\u0018\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u000bR\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroidx/navigation/NavController$Companion;", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "", "saveState", "LN1/m;", "enableDeepLinkSaveState", "(Z)V", "", "KEY_DEEP_LINK_EXTRAS", "Ljava/lang/String;", "getKEY_DEEP_LINK_EXTRAS$annotations", "KEY_BACK_STACK", "KEY_BACK_STACK_DEST_IDS", "KEY_BACK_STACK_IDS", "KEY_BACK_STACK_STATES_IDS", "KEY_BACK_STACK_STATES_PREFIX", "KEY_DEEP_LINK_ARGS", "KEY_DEEP_LINK_HANDLED", "KEY_DEEP_LINK_IDS", "KEY_DEEP_LINK_INTENT", "KEY_NAVIGATOR_STATE", "KEY_NAVIGATOR_STATE_NAMES", "TAG", "deepLinkSaveState", "Z", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(d dVar) {
            this();
        }

        public static /* synthetic */ void getKEY_DEEP_LINK_EXTRAS$annotations() {
        }

        @JvmStatic
        @NavDeepLinkSaveStateControl
        public final void enableDeepLinkSaveState(boolean saveState) {
            NavController.deepLinkSaveState = saveState;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u000bJ!\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u000bJ\u0017\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u000bR\u001f\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Landroidx/navigation/NavController$NavControllerNavigatorState;", "Landroidx/navigation/NavigatorState;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "navigator", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroidx/navigation/NavController;Landroidx/navigation/Navigator;)V", "Landroidx/navigation/NavBackStackEntry;", "backStackEntry", "LN1/m;", "push", "(Landroidx/navigation/NavBackStackEntry;)V", "addInternal", "destination", "Landroid/os/Bundle;", "arguments", "createBackStackEntry", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;)Landroidx/navigation/NavBackStackEntry;", "popUpTo", "", "saveState", "pop", "(Landroidx/navigation/NavBackStackEntry;Z)V", "popWithTransition", "entry", "markTransitionComplete", "prepareForTransition", "Landroidx/navigation/Navigator;", "getNavigator", "()Landroidx/navigation/Navigator;", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class NavControllerNavigatorState extends NavigatorState {
        private final Navigator<? extends NavDestination> navigator;
        final /* synthetic */ NavController this$0;

        public NavControllerNavigatorState(NavController navController, Navigator<? extends NavDestination> navigator) {
            h.f(navigator, "navigator");
            this.this$0 = navController;
            this.navigator = navigator;
        }

        public final void addInternal(NavBackStackEntry backStackEntry) {
            h.f(backStackEntry, "backStackEntry");
            super.push(backStackEntry);
        }

        @Override // androidx.navigation.NavigatorState
        public NavBackStackEntry createBackStackEntry(NavDestination destination, Bundle arguments) {
            h.f(destination, "destination");
            return NavBackStackEntry.Companion.create$default(NavBackStackEntry.INSTANCE, this.this$0.getContext(), destination, arguments, this.this$0.getHostLifecycleState$navigation_runtime_release(), this.this$0.viewModel, null, null, 96, null);
        }

        public final Navigator<? extends NavDestination> getNavigator() {
            return this.navigator;
        }

        @Override // androidx.navigation.NavigatorState
        public void markTransitionComplete(NavBackStackEntry entry) {
            NavControllerViewModel navControllerViewModel;
            h.f(entry, "entry");
            boolean zA = h.a(this.this$0.entrySavedState.get(entry), Boolean.TRUE);
            super.markTransitionComplete(entry);
            this.this$0.entrySavedState.remove(entry);
            if (this.this$0.backQueue.contains(entry)) {
                if (getIsNavigating()) {
                    return;
                }
                this.this$0.updateBackStackLifecycle$navigation_runtime_release();
                this.this$0._currentBackStack.tryEmit(kotlin.collections.m.p0(this.this$0.backQueue));
                this.this$0._visibleEntries.tryEmit(this.this$0.populateVisibleEntries$navigation_runtime_release());
                return;
            }
            this.this$0.unlinkChildFromParent$navigation_runtime_release(entry);
            if (entry.getLifecycle().getState().isAtLeast(Lifecycle.State.CREATED)) {
                entry.setMaxLifecycle(Lifecycle.State.DESTROYED);
            }
            i iVar = this.this$0.backQueue;
            if (iVar == null || !iVar.isEmpty()) {
                Iterator it = iVar.iterator();
                while (it.hasNext()) {
                    if (h.a(((NavBackStackEntry) it.next()).getId(), entry.getId())) {
                        break;
                    }
                }
                if (!zA && (navControllerViewModel = this.this$0.viewModel) != null) {
                    navControllerViewModel.clear(entry.getId());
                }
            } else if (!zA) {
                navControllerViewModel.clear(entry.getId());
            }
            this.this$0.updateBackStackLifecycle$navigation_runtime_release();
            this.this$0._visibleEntries.tryEmit(this.this$0.populateVisibleEntries$navigation_runtime_release());
        }

        @Override // androidx.navigation.NavigatorState
        public void pop(NavBackStackEntry popUpTo, boolean saveState) {
            h.f(popUpTo, "popUpTo");
            Navigator navigator = this.this$0._navigatorProvider.getNavigator(popUpTo.getDestination().getNavigatorName());
            if (!h.a(navigator, this.navigator)) {
                Object obj = this.this$0.navigatorState.get(navigator);
                h.c(obj);
                ((NavControllerNavigatorState) obj).pop(popUpTo, saveState);
            } else {
                Function1 function1 = this.this$0.popFromBackStackHandler;
                if (function1 == null) {
                    this.this$0.popBackStackFromNavigator$navigation_runtime_release(popUpTo, new NavController$NavControllerNavigatorState$pop$1(this, popUpTo, saveState));
                } else {
                    function1.invoke(popUpTo);
                    super.pop(popUpTo, saveState);
                }
            }
        }

        @Override // androidx.navigation.NavigatorState
        public void popWithTransition(NavBackStackEntry popUpTo, boolean saveState) {
            h.f(popUpTo, "popUpTo");
            super.popWithTransition(popUpTo, saveState);
            this.this$0.entrySavedState.put(popUpTo, Boolean.valueOf(saveState));
        }

        @Override // androidx.navigation.NavigatorState
        public void prepareForTransition(NavBackStackEntry entry) {
            h.f(entry, "entry");
            super.prepareForTransition(entry);
            if (!this.this$0.backQueue.contains(entry)) {
                throw new IllegalStateException("Cannot transition entry that is not in the back stack");
            }
            entry.setMaxLifecycle(Lifecycle.State.STARTED);
        }

        @Override // androidx.navigation.NavigatorState
        public void push(NavBackStackEntry backStackEntry) {
            h.f(backStackEntry, "backStackEntry");
            Navigator navigator = this.this$0._navigatorProvider.getNavigator(backStackEntry.getDestination().getNavigatorName());
            if (h.a(navigator, this.navigator)) {
                Function1 function1 = this.this$0.addToBackStackHandler;
                if (function1 == null) {
                    Objects.toString(backStackEntry.getDestination());
                    return;
                } else {
                    function1.invoke(backStackEntry);
                    addInternal(backStackEntry);
                    return;
                }
            }
            Object obj = this.this$0.navigatorState.get(navigator);
            if (obj != null) {
                ((NavControllerNavigatorState) obj).push(backStackEntry);
                return;
            }
            throw new IllegalStateException(("NavigatorBackStack for " + backStackEntry.getDestination().getNavigatorName() + " should already be created").toString());
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/navigation/NavController$OnDestinationChangedListener;", "", "Landroidx/navigation/NavController;", "controller", "Landroidx/navigation/NavDestination;", "destination", "Landroid/os/Bundle;", "arguments", "LN1/m;", "onDestinationChanged", "(Landroidx/navigation/NavController;Landroidx/navigation/NavDestination;Landroid/os/Bundle;)V", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnDestinationChangedListener {
        void onDestinationChanged(NavController controller, NavDestination destination, Bundle arguments);
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$executePopOperations$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/navigation/NavBackStackEntry;", "entry", "LN1/m;", "invoke", "(Landroidx/navigation/NavBackStackEntry;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class AnonymousClass1 extends kotlin.jvm.internal.i implements Function1<NavBackStackEntry, m> {
        final /* synthetic */ s $popped;
        final /* synthetic */ s $receivedPop;
        final /* synthetic */ boolean $saveState;
        final /* synthetic */ i $savedState;
        final /* synthetic */ NavController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(s sVar, s sVar2, NavController navController, boolean z6, i iVar) {
            super(1);
            this.$receivedPop = sVar;
            this.$popped = sVar2;
            this.this$0 = navController;
            this.$saveState = z6;
            this.$savedState = iVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ m invoke(NavBackStackEntry navBackStackEntry) {
            invoke2(navBackStackEntry);
            return m.f1129a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NavBackStackEntry entry) {
            h.f(entry, "entry");
            this.$receivedPop.f3813a = true;
            this.$popped.f3813a = true;
            this.this$0.popEntryFromBackStack(entry, this.$saveState, this.$savedState);
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$executePopOperations$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/navigation/NavDestination;", "destination", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass2 extends kotlin.jvm.internal.i implements Function1<NavDestination, NavDestination> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final NavDestination invoke(NavDestination destination) {
            h.f(destination, "destination");
            NavGraph parent = destination.getParent();
            if (parent == null || parent.getStartDestId() != destination.getId()) {
                return null;
            }
            return destination.getParent();
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$executePopOperations$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "destination", "Landroidx/navigation/NavDestination;", "invoke", "(Landroidx/navigation/NavDestination;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass3 extends kotlin.jvm.internal.i implements Function1<NavDestination, Boolean> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(NavDestination destination) {
            h.f(destination, "destination");
            return Boolean.valueOf(!NavController.this.backStackMap.containsKey(Integer.valueOf(destination.getId())));
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$executePopOperations$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/navigation/NavDestination;", "destination", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass5 extends kotlin.jvm.internal.i implements Function1<NavDestination, NavDestination> {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final NavDestination invoke(NavDestination destination) {
            h.f(destination, "destination");
            NavGraph parent = destination.getParent();
            if (parent == null || parent.getStartDestId() != destination.getId()) {
                return null;
            }
            return destination.getParent();
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$executePopOperations$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "destination", "Landroidx/navigation/NavDestination;", "invoke", "(Landroidx/navigation/NavDestination;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass6 extends kotlin.jvm.internal.i implements Function1<NavDestination, Boolean> {
        public AnonymousClass6() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(NavDestination destination) {
            h.f(destination, "destination");
            return Boolean.valueOf(!NavController.this.backStackMap.containsKey(Integer.valueOf(destination.getId())));
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$executeRestoreState$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/navigation/NavBackStackEntry;", "entry", "LN1/m;", "invoke", "(Landroidx/navigation/NavBackStackEntry;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class C02063 extends kotlin.jvm.internal.i implements Function1<NavBackStackEntry, m> {
        final /* synthetic */ Bundle $args;
        final /* synthetic */ List<NavBackStackEntry> $entries;
        final /* synthetic */ t $lastNavigatedIndex;
        final /* synthetic */ s $navigated;
        final /* synthetic */ NavController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02063(s sVar, List<NavBackStackEntry> list, t tVar, NavController navController, Bundle bundle) {
            super(1);
            this.$navigated = sVar;
            this.$entries = list;
            this.$lastNavigatedIndex = tVar;
            this.this$0 = navController;
            this.$args = bundle;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ m invoke(NavBackStackEntry navBackStackEntry) {
            invoke2(navBackStackEntry);
            return m.f1129a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NavBackStackEntry entry) {
            List<NavBackStackEntry> listSubList;
            h.f(entry, "entry");
            this.$navigated.f3813a = true;
            int iIndexOf = this.$entries.indexOf(entry);
            if (iIndexOf != -1) {
                int i = iIndexOf + 1;
                listSubList = this.$entries.subList(this.$lastNavigatedIndex.f3814a, i);
                this.$lastNavigatedIndex.f3814a = i;
            } else {
                listSubList = u.f3804a;
            }
            this.this$0.addEntryToBackStack(entry.getDestination(), this.$args, entry, listSubList);
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$handleDeepLink$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/navigation/NavOptionsBuilder;", "LN1/m;", "invoke", "(Landroidx/navigation/NavOptionsBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class C02072 extends kotlin.jvm.internal.i implements Function1<NavOptionsBuilder, m> {
        final /* synthetic */ NavDestination $node;
        final /* synthetic */ NavController this$0;

        /* JADX INFO: renamed from: androidx.navigation.NavController$handleDeepLink$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/navigation/AnimBuilder;", "LN1/m;", "invoke", "(Landroidx/navigation/AnimBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        public static final class AnonymousClass1 extends kotlin.jvm.internal.i implements Function1<AnimBuilder, m> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ m invoke(AnimBuilder animBuilder) {
                invoke2(animBuilder);
                return m.f1129a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AnimBuilder anim) {
                h.f(anim, "$this$anim");
                anim.setEnter(0);
                anim.setExit(0);
            }
        }

        /* JADX INFO: renamed from: androidx.navigation.NavController$handleDeepLink$2$2, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/navigation/PopUpToBuilder;", "LN1/m;", "invoke", "(Landroidx/navigation/PopUpToBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        public static final class C00082 extends kotlin.jvm.internal.i implements Function1<PopUpToBuilder, m> {
            public static final C00082 INSTANCE = new C00082();

            public C00082() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ m invoke(PopUpToBuilder popUpToBuilder) {
                invoke2(popUpToBuilder);
                return m.f1129a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PopUpToBuilder popUpTo) {
                h.f(popUpTo, "$this$popUpTo");
                popUpTo.setSaveState(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02072(NavDestination navDestination, NavController navController) {
            super(1);
            this.$node = navDestination;
            this.this$0 = navController;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ m invoke(NavOptionsBuilder navOptionsBuilder) {
            invoke2(navOptionsBuilder);
            return m.f1129a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NavOptionsBuilder navOptions) {
            h.f(navOptions, "$this$navOptions");
            navOptions.anim(AnonymousClass1.INSTANCE);
            NavDestination navDestination = this.$node;
            if (navDestination instanceof NavGraph) {
                Sequence<NavDestination> hierarchy = NavDestination.INSTANCE.getHierarchy(navDestination);
                NavController navController = this.this$0;
                for (NavDestination navDestination2 : hierarchy) {
                    NavDestination currentDestination = navController.getCurrentDestination();
                    if (h.a(navDestination2, currentDestination != null ? currentDestination.getParent() : null)) {
                        return;
                    }
                }
                if (NavController.deepLinkSaveState) {
                    navOptions.popUpTo(NavGraph.INSTANCE.findStartDestination(this.this$0.getGraph()).getId(), C00082.INSTANCE);
                }
            }
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$navigate$5, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/navigation/NavBackStackEntry;", LocaleHelper.LANGUAGE_ITALIAN, "LN1/m;", "invoke", "(Landroidx/navigation/NavBackStackEntry;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class C02085 extends kotlin.jvm.internal.i implements Function1<NavBackStackEntry, m> {
        final /* synthetic */ Bundle $finalArgs;
        final /* synthetic */ s $navigated;
        final /* synthetic */ NavDestination $node;
        final /* synthetic */ NavController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02085(s sVar, NavController navController, NavDestination navDestination, Bundle bundle) {
            super(1);
            this.$navigated = sVar;
            this.this$0 = navController;
            this.$node = navDestination;
            this.$finalArgs = bundle;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ m invoke(NavBackStackEntry navBackStackEntry) {
            invoke2(navBackStackEntry);
            return m.f1129a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NavBackStackEntry it) {
            h.f(it, "it");
            this.$navigated.f3813a = true;
            NavController.addEntryToBackStack$default(this.this$0, this.$node, this.$finalArgs, it, null, 8, null);
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$navigateInternal$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/navigation/NavBackStackEntry;", LocaleHelper.LANGUAGE_ITALIAN, "LN1/m;", "invoke", "(Landroidx/navigation/NavBackStackEntry;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class C02091 extends kotlin.jvm.internal.i implements Function1<NavBackStackEntry, m> {
        public static final C02091 INSTANCE = new C02091();

        public C02091() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NavBackStackEntry it) {
            h.f(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ m invoke(NavBackStackEntry navBackStackEntry) {
            invoke2(navBackStackEntry);
            return m.f1129a;
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$popBackStackInternal$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/navigation/NavBackStackEntry;", LocaleHelper.LANGUAGE_ITALIAN, "LN1/m;", "invoke", "(Landroidx/navigation/NavBackStackEntry;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class C02101 extends kotlin.jvm.internal.i implements Function1<NavBackStackEntry, m> {
        public static final C02101 INSTANCE = new C02101();

        public C02101() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NavBackStackEntry it) {
            h.f(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ m invoke(NavBackStackEntry navBackStackEntry) {
            invoke2(navBackStackEntry);
            return m.f1129a;
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$restoreStateInternal$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", LocaleHelper.LANGUAGE_ITALIAN, "", "invoke", "(Ljava/lang/String;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class C02111 extends kotlin.jvm.internal.i implements Function1<String, Boolean> {
        final /* synthetic */ String $backStackId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02111(String str) {
            super(1);
            this.$backStackId = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(String str) {
            return Boolean.valueOf(h.a(str, this.$backStackId));
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$restoreStateInternal$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", LocaleHelper.LANGUAGE_ITALIAN, "", "invoke", "(Ljava/lang/String;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class C02123 extends kotlin.jvm.internal.i implements Function1<String, Boolean> {
        final /* synthetic */ String $backStackId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02123(String str) {
            super(1);
            this.$backStackId = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(String str) {
            return Boolean.valueOf(h.a(str, this.$backStackId));
        }
    }

    public NavController(Context context) {
        Object next;
        h.f(context, "context");
        this.context = context;
        Iterator it = k3.m.B(context, NavController$activity$1.INSTANCE).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((Context) next) instanceof Activity) {
                    break;
                }
            }
        }
        this.activity = (Activity) next;
        this.backQueue = new i();
        u uVar = u.f3804a;
        z zVarA = v.a(uVar);
        this._currentBackStack = zVarA;
        this.currentBackStack = new q(zVarA);
        z zVarA2 = v.a(uVar);
        this._visibleEntries = zVarA2;
        this.visibleEntries = new q(zVarA2);
        this.childToParentEntries = new LinkedHashMap();
        this.parentToChildCount = new LinkedHashMap();
        this.backStackMap = new LinkedHashMap();
        this.backStackStates = new LinkedHashMap();
        this.onDestinationChangedListeners = new CopyOnWriteArrayList<>();
        this.hostLifecycleState = Lifecycle.State.INITIALIZED;
        this.lifecycleObserver = new a(this, 0);
        this.onBackPressedCallback = new OnBackPressedCallback() { // from class: androidx.navigation.NavController$onBackPressedCallback$1
            {
                super(false);
            }

            @Override // android.view.OnBackPressedCallback
            public void handleOnBackPressed() {
                this.this$0.popBackStack();
            }
        };
        this.enableOnBackPressedCallback = true;
        this._navigatorProvider = new NavigatorProvider();
        this.navigatorState = new LinkedHashMap();
        this.entrySavedState = new LinkedHashMap();
        NavigatorProvider navigatorProvider = this._navigatorProvider;
        navigatorProvider.addNavigator(new NavGraphNavigator(navigatorProvider));
        this._navigatorProvider.addNavigator(new ActivityNavigator(this.context));
        this.backStackEntriesToDispatch = new ArrayList();
        this.navInflater = AbstractC0132a.M(new NavController$navInflater$2(this));
        p3.u uVar2 = new p3.u(1, EnumC0743a.b);
        this._currentBackStackEntryFlow = uVar2;
        this.currentBackStackEntryFlow = new p(uVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addEntryToBackStack(NavDestination node, Bundle finalArgs, NavBackStackEntry backStackEntry, List<NavBackStackEntry> restoredEntries) {
        Bundle bundle;
        i<NavBackStackEntry> iVar;
        NavDestination destination;
        List<NavBackStackEntry> list;
        NavBackStackEntry navBackStackEntry;
        NavGraph navGraph;
        NavBackStackEntry navBackStackEntryPrevious;
        NavBackStackEntry navBackStackEntryPrevious2;
        List<NavBackStackEntry> list2 = restoredEntries;
        NavDestination destination2 = backStackEntry.getDestination();
        if (!(destination2 instanceof FloatingWindow)) {
            while (!this.backQueue.isEmpty() && (((NavBackStackEntry) this.backQueue.last()).getDestination() instanceof FloatingWindow) && popBackStackInternal$default(this, ((NavBackStackEntry) this.backQueue.last()).getDestination().getId(), true, false, 4, null)) {
            }
        }
        i iVar2 = new i();
        NavBackStackEntry navBackStackEntry2 = null;
        if (node instanceof NavGraph) {
            NavDestination navDestination = destination2;
            while (true) {
                h.c(navDestination);
                NavGraph parent = navDestination.getParent();
                if (parent != null) {
                    ListIterator<NavBackStackEntry> listIterator = list2.listIterator(list2.size());
                    while (true) {
                        if (listIterator.hasPrevious()) {
                            navBackStackEntryPrevious2 = listIterator.previous();
                            if (h.a(navBackStackEntryPrevious2.getDestination(), parent)) {
                                break;
                            }
                        } else {
                            navBackStackEntryPrevious2 = null;
                            break;
                        }
                    }
                    NavBackStackEntry navBackStackEntryCreate$default = navBackStackEntryPrevious2;
                    if (navBackStackEntryCreate$default == null) {
                        bundle = finalArgs;
                        destination = destination2;
                        navBackStackEntryCreate$default = NavBackStackEntry.Companion.create$default(NavBackStackEntry.INSTANCE, this.context, parent, bundle, getHostLifecycleState$navigation_runtime_release(), this.viewModel, null, null, 96, null);
                    } else {
                        bundle = finalArgs;
                        destination = destination2;
                    }
                    iVar2.addFirst(navBackStackEntryCreate$default);
                    if (this.backQueue.isEmpty() || ((NavBackStackEntry) this.backQueue.last()).getDestination() != parent) {
                        navBackStackEntry = backStackEntry;
                        list = restoredEntries;
                        iVar = iVar2;
                    } else {
                        list = restoredEntries;
                        iVar = iVar2;
                        navBackStackEntry = backStackEntry;
                        popEntryFromBackStack$default(this, (NavBackStackEntry) this.backQueue.last(), false, null, 6, null);
                    }
                } else {
                    bundle = finalArgs;
                    iVar = iVar2;
                    destination = destination2;
                    list = list2;
                    navBackStackEntry = backStackEntry;
                }
                if (parent == null || parent == node) {
                    break;
                }
                list2 = list;
                navDestination = parent;
                iVar2 = iVar;
                destination2 = destination;
            }
        } else {
            bundle = finalArgs;
            iVar = iVar2;
            destination = destination2;
            list = list2;
            navBackStackEntry = backStackEntry;
        }
        NavDestination destination3 = iVar.isEmpty() ? destination : ((NavBackStackEntry) iVar.first()).getDestination();
        while (destination3 != null && findDestination(destination3.getId()) != destination3) {
            NavGraph parent2 = destination3.getParent();
            if (parent2 != null) {
                Bundle bundle2 = (bundle == null || !bundle.isEmpty()) ? bundle : null;
                ListIterator<NavBackStackEntry> listIterator2 = list.listIterator(list.size());
                while (true) {
                    if (listIterator2.hasPrevious()) {
                        navBackStackEntryPrevious = listIterator2.previous();
                        if (h.a(navBackStackEntryPrevious.getDestination(), parent2)) {
                            break;
                        }
                    } else {
                        navBackStackEntryPrevious = null;
                        break;
                    }
                }
                NavBackStackEntry navBackStackEntryCreate$default2 = navBackStackEntryPrevious;
                if (navBackStackEntryCreate$default2 == null) {
                    navGraph = parent2;
                    navBackStackEntryCreate$default2 = NavBackStackEntry.Companion.create$default(NavBackStackEntry.INSTANCE, this.context, navGraph, parent2.addInDefaultArgs(bundle2), getHostLifecycleState$navigation_runtime_release(), this.viewModel, null, null, 96, null);
                } else {
                    navGraph = parent2;
                }
                iVar.addFirst(navBackStackEntryCreate$default2);
            } else {
                navGraph = parent2;
            }
            destination3 = navGraph;
        }
        if (!iVar.isEmpty()) {
            destination = ((NavBackStackEntry) iVar.first()).getDestination();
        }
        while (!this.backQueue.isEmpty() && (((NavBackStackEntry) this.backQueue.last()).getDestination() instanceof NavGraph)) {
            NavDestination destination4 = ((NavBackStackEntry) this.backQueue.last()).getDestination();
            h.d(destination4, "null cannot be cast to non-null type androidx.navigation.NavGraph");
            if (((NavGraph) destination4).findNode(destination.getId(), false) != null) {
                break;
            } else {
                popEntryFromBackStack$default(this, (NavBackStackEntry) this.backQueue.last(), false, null, 6, null);
            }
        }
        NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) this.backQueue.e();
        if (navBackStackEntry3 == null) {
            navBackStackEntry3 = (NavBackStackEntry) iVar.e();
        }
        if (!h.a(navBackStackEntry3 != null ? navBackStackEntry3.getDestination() : null, this._graph)) {
            ListIterator<NavBackStackEntry> listIterator3 = list.listIterator(list.size());
            while (true) {
                if (!listIterator3.hasPrevious()) {
                    break;
                }
                NavBackStackEntry navBackStackEntryPrevious3 = listIterator3.previous();
                NavDestination destination5 = navBackStackEntryPrevious3.getDestination();
                NavGraph navGraph2 = this._graph;
                h.c(navGraph2);
                if (h.a(destination5, navGraph2)) {
                    navBackStackEntry2 = navBackStackEntryPrevious3;
                    break;
                }
            }
            NavBackStackEntry navBackStackEntryCreate$default3 = navBackStackEntry2;
            if (navBackStackEntryCreate$default3 == null) {
                NavBackStackEntry.Companion companion = NavBackStackEntry.INSTANCE;
                Context context = this.context;
                NavGraph navGraph3 = this._graph;
                h.c(navGraph3);
                NavGraph navGraph4 = this._graph;
                h.c(navGraph4);
                navBackStackEntryCreate$default3 = NavBackStackEntry.Companion.create$default(companion, context, navGraph3, navGraph4.addInDefaultArgs(bundle), getHostLifecycleState$navigation_runtime_release(), this.viewModel, null, null, 96, null);
            }
            iVar.addFirst(navBackStackEntryCreate$default3);
        }
        for (NavBackStackEntry navBackStackEntry4 : iVar) {
            NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(this._navigatorProvider.getNavigator(navBackStackEntry4.getDestination().getNavigatorName()));
            if (navControllerNavigatorState == null) {
                throw new IllegalStateException(("NavigatorBackStack for " + node.getNavigatorName() + " should already be created").toString());
            }
            navControllerNavigatorState.addInternal(navBackStackEntry4);
        }
        this.backQueue.addAll(iVar);
        this.backQueue.addLast(navBackStackEntry);
        for (NavBackStackEntry navBackStackEntry5 : kotlin.collections.m.d0(navBackStackEntry, iVar)) {
            NavGraph parent3 = navBackStackEntry5.getDestination().getParent();
            if (parent3 != null) {
                linkChildToParent(navBackStackEntry5, getBackStackEntry(parent3.getId()));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void addEntryToBackStack$default(NavController navController, NavDestination navDestination, Bundle bundle, NavBackStackEntry navBackStackEntry, List list, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addEntryToBackStack");
        }
        if ((i & 8) != 0) {
            list = u.f3804a;
        }
        navController.addEntryToBackStack(navDestination, bundle, navBackStackEntry, list);
    }

    private final boolean clearBackStackInternal(int destinationId) {
        Iterator<T> it = this.navigatorState.values().iterator();
        while (it.hasNext()) {
            ((NavControllerNavigatorState) it.next()).setNavigating(true);
        }
        boolean zRestoreStateInternal = restoreStateInternal(destinationId, null, NavOptionsBuilderKt.navOptions(NavController$clearBackStackInternal$restored$1.INSTANCE), null);
        Iterator<T> it2 = this.navigatorState.values().iterator();
        while (it2.hasNext()) {
            ((NavControllerNavigatorState) it2.next()).setNavigating(false);
        }
        return zRestoreStateInternal && popBackStackInternal(destinationId, true, false);
    }

    private final boolean dispatchOnDestinationChanged() {
        while (!this.backQueue.isEmpty() && (((NavBackStackEntry) this.backQueue.last()).getDestination() instanceof NavGraph)) {
            popEntryFromBackStack$default(this, (NavBackStackEntry) this.backQueue.last(), false, null, 6, null);
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.backQueue.g();
        if (navBackStackEntry != null) {
            this.backStackEntriesToDispatch.add(navBackStackEntry);
        }
        this.dispatchReentrantCount++;
        updateBackStackLifecycle$navigation_runtime_release();
        int i = this.dispatchReentrantCount - 1;
        this.dispatchReentrantCount = i;
        if (i == 0) {
            ArrayList<NavBackStackEntry> arrayListP0 = kotlin.collections.m.p0(this.backStackEntriesToDispatch);
            this.backStackEntriesToDispatch.clear();
            for (NavBackStackEntry navBackStackEntry2 : arrayListP0) {
                Iterator<OnDestinationChangedListener> it = this.onDestinationChangedListeners.iterator();
                while (it.hasNext()) {
                    it.next().onDestinationChanged(this, navBackStackEntry2.getDestination(), navBackStackEntry2.getArguments());
                }
                this._currentBackStackEntryFlow.tryEmit(navBackStackEntry2);
            }
            this._currentBackStack.tryEmit(kotlin.collections.m.p0(this.backQueue));
            this._visibleEntries.tryEmit(populateVisibleEntries$navigation_runtime_release());
        }
        return navBackStackEntry != null;
    }

    @JvmStatic
    @NavDeepLinkSaveStateControl
    public static final void enableDeepLinkSaveState(boolean z6) {
        INSTANCE.enableDeepLinkSaveState(z6);
    }

    private final boolean executePopOperations(List<? extends Navigator<?>> popOperations, NavDestination foundDestination, boolean inclusive, boolean saveState) {
        NavController navController;
        boolean z6;
        s sVar = new s();
        i iVar = new i();
        Iterator<? extends Navigator<?>> it = popOperations.iterator();
        while (true) {
            if (!it.hasNext()) {
                navController = this;
                z6 = saveState;
                break;
            }
            Navigator<? extends NavDestination> navigator = (Navigator) it.next();
            s sVar2 = new s();
            navController = this;
            z6 = saveState;
            popBackStackInternal(navigator, (NavBackStackEntry) this.backQueue.last(), z6, new AnonymousClass1(sVar2, sVar, navController, z6, iVar));
            if (!sVar2.f3813a) {
                break;
            }
            saveState = z6;
        }
        if (z6) {
            if (!inclusive) {
                e eVar = new e(new j(k3.m.B(foundDestination, AnonymousClass2.INSTANCE), new AnonymousClass3()));
                while (eVar.hasNext()) {
                    NavDestination navDestination = (NavDestination) eVar.next();
                    Map<Integer, String> map = navController.backStackMap;
                    Integer numValueOf = Integer.valueOf(navDestination.getId());
                    NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) iVar.e();
                    map.put(numValueOf, navBackStackEntryState != null ? navBackStackEntryState.getId() : null);
                }
            }
            if (!iVar.isEmpty()) {
                NavBackStackEntryState navBackStackEntryState2 = (NavBackStackEntryState) iVar.first();
                e eVar2 = new e(new j(k3.m.B(findDestination(navBackStackEntryState2.getDestinationId()), AnonymousClass5.INSTANCE), new AnonymousClass6()));
                while (eVar2.hasNext()) {
                    navController.backStackMap.put(Integer.valueOf(((NavDestination) eVar2.next()).getId()), navBackStackEntryState2.getId());
                }
                navController.backStackStates.put(navBackStackEntryState2.getId(), iVar);
            }
        }
        updateOnBackPressedCallbackEnabled();
        return sVar.f3813a;
    }

    private final boolean executeRestoreState(List<NavBackStackEntry> entries, Bundle args, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        NavBackStackEntry navBackStackEntry;
        NavDestination destination;
        ArrayList<List<NavBackStackEntry>> arrayList = new ArrayList();
        ArrayList<NavBackStackEntry> arrayList2 = new ArrayList();
        for (Object obj : entries) {
            if (!(((NavBackStackEntry) obj).getDestination() instanceof NavGraph)) {
                arrayList2.add(obj);
            }
        }
        for (NavBackStackEntry navBackStackEntry2 : arrayList2) {
            List list = (List) kotlin.collections.m.Y(arrayList);
            if (h.a((list == null || (navBackStackEntry = (NavBackStackEntry) kotlin.collections.m.X(list)) == null || (destination = navBackStackEntry.getDestination()) == null) ? null : destination.getNavigatorName(), navBackStackEntry2.getDestination().getNavigatorName())) {
                list.add(navBackStackEntry2);
            } else {
                arrayList.add(n.A(navBackStackEntry2));
            }
        }
        s sVar = new s();
        for (List<NavBackStackEntry> list2 : arrayList) {
            navigateInternal(this._navigatorProvider.getNavigator(((NavBackStackEntry) kotlin.collections.m.P(list2)).getDestination().getNavigatorName()), list2, navOptions, navigatorExtras, new C02063(sVar, entries, new t(), this, args));
        }
        return sVar.f3813a;
    }

    private final String findInvalidDestinationDisplayNameInDeepLink(int[] deepLink) {
        NavGraph navGraph;
        NavGraph navGraph2 = this._graph;
        int length = deepLink.length;
        int i = 0;
        while (true) {
            NavDestination navDestinationFindNode = null;
            if (i >= length) {
                return null;
            }
            int i3 = deepLink[i];
            if (i == 0) {
                NavGraph navGraph3 = this._graph;
                h.c(navGraph3);
                if (navGraph3.getId() == i3) {
                    navDestinationFindNode = this._graph;
                }
            } else {
                h.c(navGraph2);
                navDestinationFindNode = navGraph2.findNode(i3);
            }
            if (navDestinationFindNode == null) {
                return NavDestination.INSTANCE.getDisplayName(this.context, i3);
            }
            if (i != deepLink.length - 1 && (navDestinationFindNode instanceof NavGraph)) {
                while (true) {
                    navGraph = (NavGraph) navDestinationFindNode;
                    h.c(navGraph);
                    if (!(navGraph.findNode(navGraph.getStartDestId()) instanceof NavGraph)) {
                        break;
                    }
                    navDestinationFindNode = navGraph.findNode(navGraph.getStartDestId());
                }
                navGraph2 = navGraph;
            }
            i++;
        }
    }

    private final int getDestinationCountOnBackStack() {
        i iVar = this.backQueue;
        int i = 0;
        if (iVar != null && iVar.isEmpty()) {
            return 0;
        }
        Iterator it = iVar.iterator();
        while (it.hasNext()) {
            if (!(((NavBackStackEntry) it.next()).getDestination() instanceof NavGraph) && (i = i + 1) < 0) {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
        return i;
    }

    private final List<NavBackStackEntry> instantiateBackStack(i backStackState) {
        NavDestination graph;
        ArrayList arrayList = new ArrayList();
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.backQueue.g();
        if (navBackStackEntry == null || (graph = navBackStackEntry.getDestination()) == null) {
            graph = getGraph();
        }
        if (backStackState != null) {
            Iterator<E> it = backStackState.iterator();
            while (it.hasNext()) {
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) it.next();
                NavDestination navDestinationFindDestination = findDestination(graph, navBackStackEntryState.getDestinationId());
                if (navDestinationFindDestination == null) {
                    throw new IllegalStateException(("Restore State failed: destination " + NavDestination.INSTANCE.getDisplayName(this.context, navBackStackEntryState.getDestinationId()) + " cannot be found from the current destination " + graph).toString());
                }
                arrayList.add(navBackStackEntryState.instantiate(this.context, navDestinationFindDestination, getHostLifecycleState$navigation_runtime_release(), this.viewModel));
                graph = navDestinationFindDestination;
            }
        }
        return arrayList;
    }

    private final boolean launchSingleTopInternal(NavDestination node, Bundle args) {
        NavDestination destination;
        int iNextIndex;
        NavBackStackEntry currentBackStackEntry = getCurrentBackStackEntry();
        int id = node instanceof NavGraph ? NavGraph.INSTANCE.findStartDestination((NavGraph) node).getId() : node.getId();
        if (currentBackStackEntry == null || (destination = currentBackStackEntry.getDestination()) == null || id != destination.getId()) {
            return false;
        }
        i<NavBackStackEntry> iVar = new i();
        i iVar2 = this.backQueue;
        ListIterator listIterator = iVar2.listIterator(iVar2.a());
        while (true) {
            if (!listIterator.hasPrevious()) {
                iNextIndex = -1;
                break;
            }
            if (((NavBackStackEntry) listIterator.previous()).getDestination() == node) {
                iNextIndex = listIterator.nextIndex();
                break;
            }
        }
        while (n.x(this.backQueue) >= iNextIndex) {
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.backQueue.removeLast();
            unlinkChildFromParent$navigation_runtime_release(navBackStackEntry);
            iVar.addFirst(new NavBackStackEntry(navBackStackEntry, navBackStackEntry.getDestination().addInDefaultArgs(args)));
        }
        for (NavBackStackEntry navBackStackEntry2 : iVar) {
            NavGraph parent = navBackStackEntry2.getDestination().getParent();
            if (parent != null) {
                linkChildToParent(navBackStackEntry2, getBackStackEntry(parent.getId()));
            }
            this.backQueue.addLast(navBackStackEntry2);
        }
        for (NavBackStackEntry navBackStackEntry3 : iVar) {
            this._navigatorProvider.getNavigator(navBackStackEntry3.getDestination().getNavigatorName()).onLaunchSingleTop(navBackStackEntry3);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lifecycleObserver$lambda$2(NavController this$0, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        h.f(this$0, "this$0");
        h.f(lifecycleOwner, "<anonymous parameter 0>");
        h.f(event, "event");
        this$0.hostLifecycleState = event.getTargetState();
        if (this$0._graph != null) {
            Iterator<E> it = this$0.backQueue.iterator();
            while (it.hasNext()) {
                ((NavBackStackEntry) it.next()).handleLifecycleEvent(event);
            }
        }
    }

    private final void linkChildToParent(NavBackStackEntry child, NavBackStackEntry parent) {
        this.childToParentEntries.put(child, parent);
        if (this.parentToChildCount.get(parent) == null) {
            this.parentToChildCount.put(parent, new AtomicInteger(0));
        }
        AtomicInteger atomicInteger = this.parentToChildCount.get(parent);
        h.c(atomicInteger);
        atomicInteger.incrementAndGet();
    }

    public static /* synthetic */ void navigate$default(NavController navController, String str, NavOptions navOptions, Navigator.Extras extras, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigate");
        }
        if ((i & 2) != 0) {
            navOptions = null;
        }
        if ((i & 4) != 0) {
            extras = null;
        }
        navController.navigate(str, navOptions, extras);
    }

    private final void navigateInternal(Navigator<? extends NavDestination> navigator, List<NavBackStackEntry> list, NavOptions navOptions, Navigator.Extras extras, Function1<? super NavBackStackEntry, m> function1) {
        this.addToBackStackHandler = function1;
        navigator.navigate(list, navOptions, extras);
        this.addToBackStackHandler = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void navigateInternal$default(NavController navController, Navigator navigator, List list, NavOptions navOptions, Navigator.Extras extras, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigateInternal");
        }
        if ((i & 8) != 0) {
            function1 = C02091.INSTANCE;
        }
        navController.navigateInternal(navigator, list, navOptions, extras, function1);
    }

    private final void onGraphCreated(Bundle startDestinationArgs) {
        Activity activity;
        ArrayList<String> stringArrayList;
        Bundle bundle = this.navigatorStateToRestore;
        if (bundle != null && (stringArrayList = bundle.getStringArrayList(KEY_NAVIGATOR_STATE_NAMES)) != null) {
            for (String name : stringArrayList) {
                NavigatorProvider navigatorProvider = this._navigatorProvider;
                h.e(name, "name");
                Navigator navigator = navigatorProvider.getNavigator(name);
                Bundle bundle2 = bundle.getBundle(name);
                if (bundle2 != null) {
                    navigator.onRestoreState(bundle2);
                }
            }
        }
        Parcelable[] parcelableArr = this.backStackToRestore;
        if (parcelableArr != null) {
            for (Parcelable parcelable : parcelableArr) {
                h.d(parcelable, "null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState");
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) parcelable;
                NavDestination navDestinationFindDestination = findDestination(navBackStackEntryState.getDestinationId());
                if (navDestinationFindDestination == null) {
                    StringBuilder sbM = B2.b.m("Restoring the Navigation back stack failed: destination ", NavDestination.INSTANCE.getDisplayName(this.context, navBackStackEntryState.getDestinationId()), " cannot be found from the current destination ");
                    sbM.append(getCurrentDestination());
                    throw new IllegalStateException(sbM.toString());
                }
                NavBackStackEntry navBackStackEntryInstantiate = navBackStackEntryState.instantiate(this.context, navDestinationFindDestination, getHostLifecycleState$navigation_runtime_release(), this.viewModel);
                Navigator<? extends NavDestination> navigator2 = this._navigatorProvider.getNavigator(navDestinationFindDestination.getNavigatorName());
                Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> map = this.navigatorState;
                NavControllerNavigatorState navControllerNavigatorState = map.get(navigator2);
                if (navControllerNavigatorState == null) {
                    navControllerNavigatorState = new NavControllerNavigatorState(this, navigator2);
                    map.put(navigator2, navControllerNavigatorState);
                }
                this.backQueue.addLast(navBackStackEntryInstantiate);
                navControllerNavigatorState.addInternal(navBackStackEntryInstantiate);
                NavGraph parent = navBackStackEntryInstantiate.getDestination().getParent();
                if (parent != null) {
                    linkChildToParent(navBackStackEntryInstantiate, getBackStackEntry(parent.getId()));
                }
            }
            updateOnBackPressedCallbackEnabled();
            this.backStackToRestore = null;
        }
        Collection<Navigator<? extends NavDestination>> collectionValues = this._navigatorProvider.getNavigators().values();
        ArrayList<Navigator<? extends NavDestination>> arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (!((Navigator) obj).getIsAttached()) {
                arrayList.add(obj);
            }
        }
        for (Navigator<? extends NavDestination> navigator3 : arrayList) {
            Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> map2 = this.navigatorState;
            NavControllerNavigatorState navControllerNavigatorState2 = map2.get(navigator3);
            if (navControllerNavigatorState2 == null) {
                navControllerNavigatorState2 = new NavControllerNavigatorState(this, navigator3);
                map2.put(navigator3, navControllerNavigatorState2);
            }
            navigator3.onAttach(navControllerNavigatorState2);
        }
        if (this._graph == null || !this.backQueue.isEmpty()) {
            dispatchOnDestinationChanged();
            return;
        }
        if (!this.deepLinkHandled && (activity = this.activity) != null) {
            h.c(activity);
            if (handleDeepLink(activity.getIntent())) {
                return;
            }
        }
        NavGraph navGraph = this._graph;
        h.c(navGraph);
        navigate(navGraph, startDestinationArgs, (NavOptions) null, (Navigator.Extras) null);
    }

    public static /* synthetic */ boolean popBackStack$default(NavController navController, String str, boolean z6, boolean z7, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStack");
        }
        if ((i & 4) != 0) {
            z7 = false;
        }
        return navController.popBackStack(str, z6, z7);
    }

    private final void popBackStackInternal(Navigator<? extends NavDestination> navigator, NavBackStackEntry navBackStackEntry, boolean z6, Function1<? super NavBackStackEntry, m> function1) {
        this.popFromBackStackHandler = function1;
        navigator.popBackStack(navBackStackEntry, z6);
        this.popFromBackStackHandler = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void popBackStackInternal$default(NavController navController, Navigator navigator, NavBackStackEntry navBackStackEntry, boolean z6, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
        }
        if ((i & 4) != 0) {
            function1 = C02101.INSTANCE;
        }
        navController.popBackStackInternal(navigator, navBackStackEntry, z6, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void popEntryFromBackStack(NavBackStackEntry popUpTo, boolean saveState, i savedState) {
        NavControllerViewModel navControllerViewModel;
        StateFlow<Set<NavBackStackEntry>> transitionsInProgress;
        Set<NavBackStackEntry> value;
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.backQueue.last();
        if (!h.a(navBackStackEntry, popUpTo)) {
            throw new IllegalStateException(("Attempted to pop " + popUpTo.getDestination() + ", which is not the top of the back stack (" + navBackStackEntry.getDestination() + ')').toString());
        }
        this.backQueue.removeLast();
        NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(get_navigatorProvider().getNavigator(navBackStackEntry.getDestination().getNavigatorName()));
        boolean z6 = true;
        if ((navControllerNavigatorState == null || (transitionsInProgress = navControllerNavigatorState.getTransitionsInProgress()) == null || (value = transitionsInProgress.getValue()) == null || !value.contains(navBackStackEntry)) && !this.parentToChildCount.containsKey(navBackStackEntry)) {
            z6 = false;
        }
        Lifecycle.State currentState = navBackStackEntry.getLifecycle().getState();
        Lifecycle.State state = Lifecycle.State.CREATED;
        if (currentState.isAtLeast(state)) {
            if (saveState) {
                navBackStackEntry.setMaxLifecycle(state);
                savedState.addFirst(new NavBackStackEntryState(navBackStackEntry));
            }
            if (z6) {
                navBackStackEntry.setMaxLifecycle(state);
            } else {
                navBackStackEntry.setMaxLifecycle(Lifecycle.State.DESTROYED);
                unlinkChildFromParent$navigation_runtime_release(navBackStackEntry);
            }
        }
        if (saveState || z6 || (navControllerViewModel = this.viewModel) == null) {
            return;
        }
        navControllerViewModel.clear(navBackStackEntry.getId());
    }

    public static /* synthetic */ void popEntryFromBackStack$default(NavController navController, NavBackStackEntry navBackStackEntry, boolean z6, i iVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popEntryFromBackStack");
        }
        if ((i & 2) != 0) {
            z6 = false;
        }
        if ((i & 4) != 0) {
            iVar = new i();
        }
        navController.popEntryFromBackStack(navBackStackEntry, z6, iVar);
    }

    private final boolean restoreStateInternal(int id, Bundle args, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        if (!this.backStackMap.containsKey(Integer.valueOf(id))) {
            return false;
        }
        String str = this.backStackMap.get(Integer.valueOf(id));
        Collection<String> collectionValues = this.backStackMap.values();
        C02111 c02111 = new C02111(str);
        h.f(collectionValues, "<this>");
        kotlin.collections.s.H(collectionValues, c02111, true);
        return executeRestoreState(instantiateBackStack((i) kotlin.jvm.internal.z.b(this.backStackStates).remove(str)), args, navOptions, navigatorExtras);
    }

    private final boolean tryRelaunchUpToExplicitStack() {
        int i = 0;
        if (this.deepLinkHandled) {
            Activity activity = this.activity;
            h.c(activity);
            Intent intent = activity.getIntent();
            Bundle extras = intent.getExtras();
            h.c(extras);
            int[] intArray = extras.getIntArray(KEY_DEEP_LINK_IDS);
            h.c(intArray);
            ArrayList arrayListM = kotlin.collections.j.M(intArray);
            ArrayList parcelableArrayList = extras.getParcelableArrayList(KEY_DEEP_LINK_ARGS);
            int iIntValue = ((Number) kotlin.collections.s.I(arrayListM)).intValue();
            if (parcelableArrayList != null) {
            }
            if (!arrayListM.isEmpty()) {
                NavDestination navDestinationFindDestination = findDestination(getGraph(), iIntValue);
                if (navDestinationFindDestination instanceof NavGraph) {
                    iIntValue = NavGraph.INSTANCE.findStartDestination((NavGraph) navDestinationFindDestination).getId();
                }
                NavDestination currentDestination = getCurrentDestination();
                if (currentDestination != null && iIntValue == currentDestination.getId()) {
                    NavDeepLinkBuilder navDeepLinkBuilderCreateDeepLink = createDeepLink();
                    Bundle bundleBundleOf = BundleKt.bundleOf(new N1.e(KEY_DEEP_LINK_INTENT, intent));
                    Bundle bundle = extras.getBundle(KEY_DEEP_LINK_EXTRAS);
                    if (bundle != null) {
                        bundleBundleOf.putAll(bundle);
                    }
                    navDeepLinkBuilderCreateDeepLink.setArguments(bundleBundleOf);
                    for (Object obj : arrayListM) {
                        int i3 = i + 1;
                        Bundle bundle2 = null;
                        if (i < 0) {
                            n.C();
                            throw null;
                        }
                        int iIntValue2 = ((Number) obj).intValue();
                        if (parcelableArrayList != null) {
                            bundle2 = (Bundle) parcelableArrayList.get(i);
                        }
                        navDeepLinkBuilderCreateDeepLink.addDestination(iIntValue2, bundle2);
                        i = i3;
                    }
                    navDeepLinkBuilderCreateDeepLink.createTaskStackBuilder().startActivities();
                    Activity activity2 = this.activity;
                    if (activity2 == null) {
                        return true;
                    }
                    activity2.finish();
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean tryRelaunchUpToGeneratedStack() {
        NavDestination currentDestination = getCurrentDestination();
        h.c(currentDestination);
        int id = currentDestination.getId();
        for (NavGraph parent = currentDestination.getParent(); parent != null; parent = parent.getParent()) {
            if (parent.getStartDestId() != id) {
                Bundle bundle = new Bundle();
                Activity activity = this.activity;
                if (activity != null) {
                    h.c(activity);
                    if (activity.getIntent() != null) {
                        Activity activity2 = this.activity;
                        h.c(activity2);
                        if (activity2.getIntent().getData() != null) {
                            Activity activity3 = this.activity;
                            h.c(activity3);
                            bundle.putParcelable(KEY_DEEP_LINK_INTENT, activity3.getIntent());
                            NavGraph navGraph = this._graph;
                            h.c(navGraph);
                            Activity activity4 = this.activity;
                            h.c(activity4);
                            Intent intent = activity4.getIntent();
                            h.e(intent, "activity!!.intent");
                            NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLink = navGraph.matchDeepLink(new NavDeepLinkRequest(intent));
                            if ((deepLinkMatchMatchDeepLink != null ? deepLinkMatchMatchDeepLink.getMatchingArgs() : null) != null) {
                                bundle.putAll(deepLinkMatchMatchDeepLink.getDestination().addInDefaultArgs(deepLinkMatchMatchDeepLink.getMatchingArgs()));
                            }
                        }
                    }
                }
                NavDeepLinkBuilder.setDestination$default(new NavDeepLinkBuilder(this), parent.getId(), (Bundle) null, 2, (Object) null).setArguments(bundle).createTaskStackBuilder().startActivities();
                Activity activity5 = this.activity;
                if (activity5 == null) {
                    return true;
                }
                activity5.finish();
                return true;
            }
            id = parent.getId();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void updateOnBackPressedCallbackEnabled() {
        /*
            r3 = this;
            androidx.activity.OnBackPressedCallback r0 = r3.onBackPressedCallback
            boolean r1 = r3.enableOnBackPressedCallback
            if (r1 == 0) goto Le
            int r1 = r3.getDestinationCountOnBackStack()
            r2 = 1
            if (r1 <= r2) goto Le
            goto Lf
        Le:
            r2 = 0
        Lf:
            r0.setEnabled(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.updateOnBackPressedCallbackEnabled():void");
    }

    public void addOnDestinationChangedListener(OnDestinationChangedListener listener) {
        h.f(listener, "listener");
        this.onDestinationChangedListeners.add(listener);
        if (this.backQueue.isEmpty()) {
            return;
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.backQueue.last();
        listener.onDestinationChanged(this, navBackStackEntry.getDestination(), navBackStackEntry.getArguments());
    }

    public final boolean clearBackStack(String route) {
        h.f(route, "route");
        return clearBackStackInternal(route) && dispatchOnDestinationChanged();
    }

    public NavDeepLinkBuilder createDeepLink() {
        return new NavDeepLinkBuilder(this);
    }

    public void enableOnBackPressed(boolean enabled) {
        this.enableOnBackPressedCallback = enabled;
        updateOnBackPressedCallbackEnabled();
    }

    public final NavDestination findDestination(int destinationId) {
        NavDestination destination;
        NavGraph navGraph = this._graph;
        if (navGraph == null) {
            return null;
        }
        h.c(navGraph);
        if (navGraph.getId() == destinationId) {
            return this._graph;
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.backQueue.g();
        if (navBackStackEntry == null || (destination = navBackStackEntry.getDestination()) == null) {
            destination = this._graph;
            h.c(destination);
        }
        return findDestination(destination, destinationId);
    }

    public NavBackStackEntry getBackStackEntry(int destinationId) {
        Object objPrevious;
        i iVar = this.backQueue;
        ListIterator<E> listIterator = iVar.listIterator(iVar.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
            if (((NavBackStackEntry) objPrevious).getDestination().getId() == destinationId) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) objPrevious;
        if (navBackStackEntry != null) {
            return navBackStackEntry;
        }
        StringBuilder sbJ = B2.b.j(destinationId, "No destination with ID ", " is on the NavController's back stack. The current destination is ");
        sbJ.append(getCurrentDestination());
        throw new IllegalArgumentException(sbJ.toString().toString());
    }

    public final Context getContext() {
        return this.context;
    }

    public final StateFlow<List<NavBackStackEntry>> getCurrentBackStack() {
        return this.currentBackStack;
    }

    public NavBackStackEntry getCurrentBackStackEntry() {
        return (NavBackStackEntry) this.backQueue.g();
    }

    public final Flow<NavBackStackEntry> getCurrentBackStackEntryFlow() {
        return this.currentBackStackEntryFlow;
    }

    public NavDestination getCurrentDestination() {
        NavBackStackEntry currentBackStackEntry = getCurrentBackStackEntry();
        if (currentBackStackEntry != null) {
            return currentBackStackEntry.getDestination();
        }
        return null;
    }

    public NavGraph getGraph() {
        NavGraph navGraph = this._graph;
        if (navGraph == null) {
            throw new IllegalStateException("You must call setGraph() before calling getGraph()");
        }
        h.d(navGraph, "null cannot be cast to non-null type androidx.navigation.NavGraph");
        return navGraph;
    }

    public final Lifecycle.State getHostLifecycleState$navigation_runtime_release() {
        return this.lifecycleOwner == null ? Lifecycle.State.CREATED : this.hostLifecycleState;
    }

    public NavInflater getNavInflater() {
        return (NavInflater) this.navInflater.getValue();
    }

    /* JADX INFO: renamed from: getNavigatorProvider, reason: from getter */
    public NavigatorProvider get_navigatorProvider() {
        return this._navigatorProvider;
    }

    public NavBackStackEntry getPreviousBackStackEntry() {
        Object next;
        Iterator it = kotlin.collections.m.e0(this.backQueue).iterator();
        if (it.hasNext()) {
            it.next();
        }
        Iterator it2 = ((C0590a) k3.m.u(it)).iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (!(((NavBackStackEntry) next).getDestination() instanceof NavGraph)) {
                break;
            }
        }
        return (NavBackStackEntry) next;
    }

    public ViewModelStoreOwner getViewModelStoreOwner(int navGraphId) {
        if (this.viewModel == null) {
            throw new IllegalStateException("You must call setViewModelStore() before calling getViewModelStoreOwner().");
        }
        NavBackStackEntry backStackEntry = getBackStackEntry(navGraphId);
        if (backStackEntry.getDestination() instanceof NavGraph) {
            return backStackEntry;
        }
        throw new IllegalArgumentException(B2.b.d(navGraphId, "No NavGraph with ID ", " is on the NavController's back stack").toString());
    }

    public final StateFlow<List<NavBackStackEntry>> getVisibleEntries() {
        return this.visibleEntries;
    }

    public boolean handleDeepLink(Intent intent) {
        int[] intArray;
        NavDestination navDestinationFindNode;
        NavGraph navGraph;
        Bundle bundle;
        int i = 0;
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            try {
                intArray = extras.getIntArray(KEY_DEEP_LINK_IDS);
            } catch (Exception e) {
                Log.e(TAG, "handleDeepLink() could not extract deepLink from " + intent, e);
                intArray = null;
            }
        } else {
            intArray = null;
        }
        ArrayList parcelableArrayList = extras != null ? extras.getParcelableArrayList(KEY_DEEP_LINK_ARGS) : null;
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = extras != null ? extras.getBundle(KEY_DEEP_LINK_EXTRAS) : null;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        if (intArray == null || intArray.length == 0) {
            NavGraph navGraph2 = this._graph;
            h.c(navGraph2);
            NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLink = navGraph2.matchDeepLink(new NavDeepLinkRequest(intent));
            if (deepLinkMatchMatchDeepLink != null) {
                NavDestination destination = deepLinkMatchMatchDeepLink.getDestination();
                int[] iArrBuildDeepLinkIds$default = NavDestination.buildDeepLinkIds$default(destination, null, 1, null);
                Bundle bundleAddInDefaultArgs = destination.addInDefaultArgs(deepLinkMatchMatchDeepLink.getMatchingArgs());
                if (bundleAddInDefaultArgs != null) {
                    bundle2.putAll(bundleAddInDefaultArgs);
                }
                intArray = iArrBuildDeepLinkIds$default;
                parcelableArrayList = null;
            }
        }
        if (intArray == null || intArray.length == 0) {
            return false;
        }
        if (findInvalidDestinationDisplayNameInDeepLink(intArray) != null) {
            intent.toString();
            return false;
        }
        bundle2.putParcelable(KEY_DEEP_LINK_INTENT, intent);
        int length = intArray.length;
        Bundle[] bundleArr = new Bundle[length];
        for (int i3 = 0; i3 < length; i3++) {
            Bundle bundle4 = new Bundle();
            bundle4.putAll(bundle2);
            if (parcelableArrayList != null && (bundle = (Bundle) parcelableArrayList.get(i3)) != null) {
                bundle4.putAll(bundle);
            }
            bundleArr[i3] = bundle4;
        }
        int flags = intent.getFlags();
        int i4 = 268435456 & flags;
        if (i4 != 0 && (flags & 32768) == 0) {
            intent.addFlags(32768);
            TaskStackBuilder taskStackBuilderAddNextIntentWithParentStack = TaskStackBuilder.create(this.context).addNextIntentWithParentStack(intent);
            h.e(taskStackBuilderAddNextIntentWithParentStack, "create(context)\n        …ntWithParentStack(intent)");
            taskStackBuilderAddNextIntentWithParentStack.startActivities();
            Activity activity = this.activity;
            if (activity != null) {
                activity.finish();
                activity.overridePendingTransition(0, 0);
            }
            return true;
        }
        if (i4 != 0) {
            if (!this.backQueue.isEmpty()) {
                NavGraph navGraph3 = this._graph;
                h.c(navGraph3);
                popBackStackInternal$default(this, navGraph3.getId(), true, false, 4, null);
            }
            while (i < intArray.length) {
                int i5 = intArray[i];
                int i6 = i + 1;
                Bundle bundle5 = bundleArr[i];
                NavDestination navDestinationFindDestination = findDestination(i5);
                if (navDestinationFindDestination == null) {
                    StringBuilder sbM = B2.b.m("Deep Linking failed: destination ", NavDestination.INSTANCE.getDisplayName(this.context, i5), " cannot be found from the current destination ");
                    sbM.append(getCurrentDestination());
                    throw new IllegalStateException(sbM.toString());
                }
                navigate(navDestinationFindDestination, bundle5, NavOptionsBuilderKt.navOptions(new C02072(navDestinationFindDestination, this)), (Navigator.Extras) null);
                i = i6;
            }
            this.deepLinkHandled = true;
            return true;
        }
        NavGraph navGraph4 = this._graph;
        int length2 = intArray.length;
        for (int i7 = 0; i7 < length2; i7++) {
            int i8 = intArray[i7];
            Bundle bundle6 = bundleArr[i7];
            if (i7 == 0) {
                navDestinationFindNode = this._graph;
            } else {
                h.c(navGraph4);
                navDestinationFindNode = navGraph4.findNode(i8);
            }
            if (navDestinationFindNode == null) {
                throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.INSTANCE.getDisplayName(this.context, i8) + " cannot be found in graph " + navGraph4);
            }
            if (i7 == intArray.length - 1) {
                NavOptions.Builder builder = new NavOptions.Builder();
                NavGraph navGraph5 = this._graph;
                h.c(navGraph5);
                navigate(navDestinationFindNode, bundle6, NavOptions.Builder.setPopUpTo$default(builder, navGraph5.getId(), true, false, 4, (Object) null).setEnterAnim(0).setExitAnim(0).build(), (Navigator.Extras) null);
            } else if (navDestinationFindNode instanceof NavGraph) {
                while (true) {
                    navGraph = (NavGraph) navDestinationFindNode;
                    h.c(navGraph);
                    if (!(navGraph.findNode(navGraph.getStartDestId()) instanceof NavGraph)) {
                        break;
                    }
                    navDestinationFindNode = navGraph.findNode(navGraph.getStartDestId());
                }
                navGraph4 = navGraph;
            }
        }
        this.deepLinkHandled = true;
        return true;
    }

    public final void navigate(String route) {
        h.f(route, "route");
        navigate$default(this, route, null, null, 6, null);
    }

    public boolean navigateUp() {
        Intent intent;
        if (getDestinationCountOnBackStack() != 1) {
            return popBackStack();
        }
        Activity activity = this.activity;
        Bundle extras = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getExtras();
        return (extras != null ? extras.getIntArray(KEY_DEEP_LINK_IDS) : null) != null ? tryRelaunchUpToExplicitStack() : tryRelaunchUpToGeneratedStack();
    }

    public final boolean popBackStack(String route, boolean z6) {
        h.f(route, "route");
        return popBackStack$default(this, route, z6, false, 4, null);
    }

    public final void popBackStackFromNavigator$navigation_runtime_release(NavBackStackEntry popUpTo, Function0<m> onComplete) {
        h.f(popUpTo, "popUpTo");
        h.f(onComplete, "onComplete");
        int iIndexOf = this.backQueue.indexOf(popUpTo);
        if (iIndexOf < 0) {
            popUpTo.toString();
            return;
        }
        int i = iIndexOf + 1;
        if (i != this.backQueue.a()) {
            popBackStackInternal(((NavBackStackEntry) this.backQueue.get(i)).getDestination().getId(), true, false);
        }
        popEntryFromBackStack$default(this, popUpTo, false, null, 6, null);
        onComplete.invoke();
        updateOnBackPressedCallbackEnabled();
        dispatchOnDestinationChanged();
    }

    public final List<NavBackStackEntry> populateVisibleEntries$navigation_runtime_release() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.navigatorState.values().iterator();
        while (it.hasNext()) {
            Set<NavBackStackEntry> value = ((NavControllerNavigatorState) it.next()).getTransitionsInProgress().getValue();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : value) {
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                if (!arrayList.contains(navBackStackEntry) && !navBackStackEntry.getMaxLifecycle().isAtLeast(Lifecycle.State.STARTED)) {
                    arrayList2.add(obj);
                }
            }
            kotlin.collections.s.F(arrayList2, arrayList);
        }
        i iVar = this.backQueue;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : iVar) {
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) obj2;
            if (!arrayList.contains(navBackStackEntry2) && navBackStackEntry2.getMaxLifecycle().isAtLeast(Lifecycle.State.STARTED)) {
                arrayList3.add(obj2);
            }
        }
        kotlin.collections.s.F(arrayList3, arrayList);
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : arrayList) {
            if (!(((NavBackStackEntry) obj3).getDestination() instanceof NavGraph)) {
                arrayList4.add(obj3);
            }
        }
        return arrayList4;
    }

    public void removeOnDestinationChangedListener(OnDestinationChangedListener listener) {
        h.f(listener, "listener");
        this.onDestinationChangedListeners.remove(listener);
    }

    public void restoreState(Bundle navState) {
        if (navState == null) {
            return;
        }
        navState.setClassLoader(this.context.getClassLoader());
        this.navigatorStateToRestore = navState.getBundle(KEY_NAVIGATOR_STATE);
        this.backStackToRestore = navState.getParcelableArray(KEY_BACK_STACK);
        this.backStackStates.clear();
        int[] intArray = navState.getIntArray(KEY_BACK_STACK_DEST_IDS);
        ArrayList<String> stringArrayList = navState.getStringArrayList(KEY_BACK_STACK_IDS);
        if (intArray != null && stringArrayList != null) {
            int length = intArray.length;
            int i = 0;
            int i3 = 0;
            while (i < length) {
                this.backStackMap.put(Integer.valueOf(intArray[i]), stringArrayList.get(i3));
                i++;
                i3++;
            }
        }
        ArrayList<String> stringArrayList2 = navState.getStringArrayList(KEY_BACK_STACK_STATES_IDS);
        if (stringArrayList2 != null) {
            for (String id : stringArrayList2) {
                Parcelable[] parcelableArray = navState.getParcelableArray(KEY_BACK_STACK_STATES_PREFIX + id);
                if (parcelableArray != null) {
                    Map<String, i> map = this.backStackStates;
                    h.e(id, "id");
                    i iVar = new i(parcelableArray.length);
                    C0595b c0595bJ = h.j(parcelableArray);
                    while (c0595bJ.hasNext()) {
                        Parcelable parcelable = (Parcelable) c0595bJ.next();
                        h.d(parcelable, "null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState");
                        iVar.addLast((NavBackStackEntryState) parcelable);
                    }
                    map.put(id, iVar);
                }
            }
        }
        this.deepLinkHandled = navState.getBoolean(KEY_DEEP_LINK_HANDLED);
    }

    public Bundle saveState() {
        Bundle bundle;
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle2 = new Bundle();
        for (Map.Entry<String, Navigator<? extends NavDestination>> entry : this._navigatorProvider.getNavigators().entrySet()) {
            String key = entry.getKey();
            Bundle bundleOnSaveState = entry.getValue().onSaveState();
            if (bundleOnSaveState != null) {
                arrayList.add(key);
                bundle2.putBundle(key, bundleOnSaveState);
            }
        }
        if (arrayList.isEmpty()) {
            bundle = null;
        } else {
            bundle = new Bundle();
            bundle2.putStringArrayList(KEY_NAVIGATOR_STATE_NAMES, arrayList);
            bundle.putBundle(KEY_NAVIGATOR_STATE, bundle2);
        }
        if (!this.backQueue.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[this.backQueue.a()];
            Iterator<E> it = this.backQueue.iterator();
            int i = 0;
            while (it.hasNext()) {
                parcelableArr[i] = new NavBackStackEntryState((NavBackStackEntry) it.next());
                i++;
            }
            bundle.putParcelableArray(KEY_BACK_STACK, parcelableArr);
        }
        if (!this.backStackMap.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            int[] iArr = new int[this.backStackMap.size()];
            ArrayList<String> arrayList2 = new ArrayList<>();
            int i3 = 0;
            for (Map.Entry<Integer, String> entry2 : this.backStackMap.entrySet()) {
                int iIntValue = entry2.getKey().intValue();
                String value = entry2.getValue();
                iArr[i3] = iIntValue;
                arrayList2.add(value);
                i3++;
            }
            bundle.putIntArray(KEY_BACK_STACK_DEST_IDS, iArr);
            bundle.putStringArrayList(KEY_BACK_STACK_IDS, arrayList2);
        }
        if (!this.backStackStates.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            ArrayList<String> arrayList3 = new ArrayList<>();
            for (Map.Entry<String, i> entry3 : this.backStackStates.entrySet()) {
                String key2 = entry3.getKey();
                i value2 = entry3.getValue();
                arrayList3.add(key2);
                Parcelable[] parcelableArr2 = new Parcelable[value2.a()];
                int i4 = 0;
                for (Object obj : value2) {
                    int i5 = i4 + 1;
                    if (i4 < 0) {
                        n.C();
                        throw null;
                    }
                    parcelableArr2[i4] = (NavBackStackEntryState) obj;
                    i4 = i5;
                }
                bundle.putParcelableArray(androidx.constraintlayout.core.motion.a.p(KEY_BACK_STACK_STATES_PREFIX, key2), parcelableArr2);
            }
            bundle.putStringArrayList(KEY_BACK_STACK_STATES_IDS, arrayList3);
        }
        if (this.deepLinkHandled) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(KEY_DEEP_LINK_HANDLED, this.deepLinkHandled);
        }
        return bundle;
    }

    public void setGraph(NavGraph graph) {
        h.f(graph, "graph");
        setGraph(graph, (Bundle) null);
    }

    public final void setHostLifecycleState$navigation_runtime_release(Lifecycle.State state) {
        h.f(state, "<set-?>");
        this.hostLifecycleState = state;
    }

    public void setLifecycleOwner(LifecycleOwner owner) {
        Lifecycle lifecycle;
        h.f(owner, "owner");
        if (owner.equals(this.lifecycleOwner)) {
            return;
        }
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this.lifecycleObserver);
        }
        this.lifecycleOwner = owner;
        owner.getLifecycle().addObserver(this.lifecycleObserver);
    }

    public void setNavigatorProvider(NavigatorProvider navigatorProvider) {
        h.f(navigatorProvider, "navigatorProvider");
        if (!this.backQueue.isEmpty()) {
            throw new IllegalStateException("NavigatorProvider must be set before setGraph call");
        }
        this._navigatorProvider = navigatorProvider;
    }

    public void setOnBackPressedDispatcher(OnBackPressedDispatcher dispatcher) {
        h.f(dispatcher, "dispatcher");
        if (dispatcher.equals(this.onBackPressedDispatcher)) {
            return;
        }
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner == null) {
            throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
        }
        this.onBackPressedCallback.remove();
        this.onBackPressedDispatcher = dispatcher;
        dispatcher.addCallback(lifecycleOwner, this.onBackPressedCallback);
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        lifecycle.removeObserver(this.lifecycleObserver);
        lifecycle.addObserver(this.lifecycleObserver);
    }

    public void setViewModelStore(ViewModelStore viewModelStore) {
        h.f(viewModelStore, "viewModelStore");
        NavControllerViewModel navControllerViewModel = this.viewModel;
        NavControllerViewModel.Companion companion = NavControllerViewModel.INSTANCE;
        if (h.a(navControllerViewModel, companion.getInstance(viewModelStore))) {
            return;
        }
        if (!this.backQueue.isEmpty()) {
            throw new IllegalStateException("ViewModelStore should be set before setGraph call");
        }
        this.viewModel = companion.getInstance(viewModelStore);
    }

    public final NavBackStackEntry unlinkChildFromParent$navigation_runtime_release(NavBackStackEntry child) {
        h.f(child, "child");
        NavBackStackEntry navBackStackEntryRemove = this.childToParentEntries.remove(child);
        if (navBackStackEntryRemove == null) {
            return null;
        }
        AtomicInteger atomicInteger = this.parentToChildCount.get(navBackStackEntryRemove);
        Integer numValueOf = atomicInteger != null ? Integer.valueOf(atomicInteger.decrementAndGet()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(this._navigatorProvider.getNavigator(navBackStackEntryRemove.getDestination().getNavigatorName()));
            if (navControllerNavigatorState != null) {
                navControllerNavigatorState.markTransitionComplete(navBackStackEntryRemove);
            }
            this.parentToChildCount.remove(navBackStackEntryRemove);
        }
        return navBackStackEntryRemove;
    }

    public final void updateBackStackLifecycle$navigation_runtime_release() {
        AtomicInteger atomicInteger;
        StateFlow<Set<NavBackStackEntry>> transitionsInProgress;
        Set<NavBackStackEntry> value;
        ArrayList<NavBackStackEntry> arrayListP0 = kotlin.collections.m.p0(this.backQueue);
        if (arrayListP0.isEmpty()) {
            return;
        }
        NavDestination destination = ((NavBackStackEntry) kotlin.collections.m.X(arrayListP0)).getDestination();
        ArrayList arrayList = new ArrayList();
        if (destination instanceof FloatingWindow) {
            Iterator it = kotlin.collections.m.e0(arrayListP0).iterator();
            while (it.hasNext()) {
                NavDestination destination2 = ((NavBackStackEntry) it.next()).getDestination();
                arrayList.add(destination2);
                if (!(destination2 instanceof FloatingWindow) && !(destination2 instanceof NavGraph)) {
                    break;
                }
            }
        }
        HashMap map = new HashMap();
        for (NavBackStackEntry navBackStackEntry : kotlin.collections.m.e0(arrayListP0)) {
            Lifecycle.State maxLifecycle = navBackStackEntry.getMaxLifecycle();
            NavDestination destination3 = navBackStackEntry.getDestination();
            if (destination != null && destination3.getId() == destination.getId()) {
                Lifecycle.State state = Lifecycle.State.RESUMED;
                if (maxLifecycle != state) {
                    NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(get_navigatorProvider().getNavigator(navBackStackEntry.getDestination().getNavigatorName()));
                    if (h.a((navControllerNavigatorState == null || (transitionsInProgress = navControllerNavigatorState.getTransitionsInProgress()) == null || (value = transitionsInProgress.getValue()) == null) ? null : Boolean.valueOf(value.contains(navBackStackEntry)), Boolean.TRUE) || ((atomicInteger = this.parentToChildCount.get(navBackStackEntry)) != null && atomicInteger.get() == 0)) {
                        map.put(navBackStackEntry, Lifecycle.State.STARTED);
                    } else {
                        map.put(navBackStackEntry, state);
                    }
                }
                NavDestination navDestination = (NavDestination) kotlin.collections.m.R(arrayList);
                if (navDestination != null && navDestination.getId() == destination3.getId()) {
                    if (arrayList.isEmpty()) {
                        throw new NoSuchElementException("List is empty.");
                    }
                    arrayList.remove(0);
                }
                destination = destination.getParent();
            } else if (arrayList.isEmpty() || destination3.getId() != ((NavDestination) kotlin.collections.m.P(arrayList)).getId()) {
                navBackStackEntry.setMaxLifecycle(Lifecycle.State.CREATED);
            } else {
                if (arrayList.isEmpty()) {
                    throw new NoSuchElementException("List is empty.");
                }
                NavDestination navDestination2 = (NavDestination) arrayList.remove(0);
                if (maxLifecycle == Lifecycle.State.RESUMED) {
                    navBackStackEntry.setMaxLifecycle(Lifecycle.State.STARTED);
                } else {
                    Lifecycle.State state2 = Lifecycle.State.STARTED;
                    if (maxLifecycle != state2) {
                        map.put(navBackStackEntry, state2);
                    }
                }
                NavGraph parent = navDestination2.getParent();
                if (parent != null && !arrayList.contains(parent)) {
                    arrayList.add(parent);
                }
            }
        }
        for (NavBackStackEntry navBackStackEntry2 : arrayListP0) {
            Lifecycle.State state3 = (Lifecycle.State) map.get(navBackStackEntry2);
            if (state3 != null) {
                navBackStackEntry2.setMaxLifecycle(state3);
            } else {
                navBackStackEntry2.updateState();
            }
        }
    }

    public final void navigate(String route, NavOptions navOptions) {
        h.f(route, "route");
        navigate$default(this, route, navOptions, null, 4, null);
    }

    public boolean popBackStack() {
        if (this.backQueue.isEmpty()) {
            return false;
        }
        NavDestination currentDestination = getCurrentDestination();
        h.c(currentDestination);
        return popBackStack(currentDestination.getId(), true);
    }

    public void setGraph(int graphResId) {
        setGraph(getNavInflater().inflate(graphResId), (Bundle) null);
    }

    public static /* synthetic */ boolean popBackStackInternal$default(NavController navController, int i, boolean z6, boolean z7, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
        }
        if ((i3 & 4) != 0) {
            z7 = false;
        }
        return navController.popBackStackInternal(i, z6, z7);
    }

    public final boolean clearBackStack(int destinationId) {
        return clearBackStackInternal(destinationId) && dispatchOnDestinationChanged();
    }

    public void navigate(int resId) {
        navigate(resId, (Bundle) null);
    }

    public void setGraph(int graphResId, Bundle startDestinationArgs) {
        setGraph(getNavInflater().inflate(graphResId), startDestinationArgs);
    }

    private final boolean popBackStackInternal(int destinationId, boolean inclusive, boolean saveState) {
        NavDestination destination;
        if (this.backQueue.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = kotlin.collections.m.e0(this.backQueue).iterator();
        while (true) {
            if (!it.hasNext()) {
                destination = null;
                break;
            }
            destination = ((NavBackStackEntry) it.next()).getDestination();
            Navigator navigator = this._navigatorProvider.getNavigator(destination.getNavigatorName());
            if (inclusive || destination.getId() != destinationId) {
                arrayList.add(navigator);
            }
            if (destination.getId() == destinationId) {
                break;
            }
        }
        if (destination == null) {
            NavDestination.INSTANCE.getDisplayName(this.context, destinationId);
            return false;
        }
        return executePopOperations(arrayList, destination, inclusive, saveState);
    }

    public void navigate(int resId, Bundle args) {
        navigate(resId, args, (NavOptions) null);
    }

    public boolean popBackStack(int destinationId, boolean inclusive) {
        return popBackStack(destinationId, inclusive, false);
    }

    public void setGraph(NavGraph graph, Bundle startDestinationArgs) {
        NavController navController;
        h.f(graph, "graph");
        if (!h.a(this._graph, graph)) {
            NavGraph navGraph = this._graph;
            if (navGraph != null) {
                for (Integer id : new ArrayList(this.backStackMap.keySet())) {
                    h.e(id, "id");
                    clearBackStackInternal(id.intValue());
                }
                navController = this;
                popBackStackInternal$default(navController, navGraph.getId(), true, false, 4, null);
            } else {
                navController = this;
            }
            navController._graph = graph;
            onGraphCreated(startDestinationArgs);
            return;
        }
        int size = graph.getNodes().size();
        for (int i = 0; i < size; i++) {
            NavDestination navDestinationValueAt = graph.getNodes().valueAt(i);
            NavGraph navGraph2 = this._graph;
            h.c(navGraph2);
            int iKeyAt = navGraph2.getNodes().keyAt(i);
            NavGraph navGraph3 = this._graph;
            h.c(navGraph3);
            navGraph3.getNodes().replace(iKeyAt, navDestinationValueAt);
        }
        for (NavBackStackEntry navBackStackEntry : this.backQueue) {
            D d = new D(k3.m.F(NavDestination.INSTANCE.getHierarchy(navBackStackEntry.getDestination())), 0);
            NavDestination navDestinationFindNode = this._graph;
            h.c(navDestinationFindNode);
            C0595b c0595b = new C0595b(d);
            while (c0595b.hasNext()) {
                NavDestination navDestination = (NavDestination) c0595b.next();
                if (!h.a(navDestination, this._graph) || !h.a(navDestinationFindNode, graph)) {
                    if (navDestinationFindNode instanceof NavGraph) {
                        navDestinationFindNode = ((NavGraph) navDestinationFindNode).findNode(navDestination.getId());
                        h.c(navDestinationFindNode);
                    }
                }
            }
            navBackStackEntry.setDestination(navDestinationFindNode);
        }
    }

    public void navigate(int resId, Bundle args, NavOptions navOptions) {
        navigate(resId, args, navOptions, (Navigator.Extras) null);
    }

    public boolean popBackStack(int destinationId, boolean inclusive, boolean saveState) {
        return popBackStackInternal(destinationId, inclusive, saveState) && dispatchOnDestinationChanged();
    }

    private final NavDestination findDestination(NavDestination navDestination, int i) {
        NavGraph parent;
        if (navDestination.getId() == i) {
            return navDestination;
        }
        if (navDestination instanceof NavGraph) {
            parent = (NavGraph) navDestination;
        } else {
            parent = navDestination.getParent();
            h.c(parent);
        }
        return parent.findNode(i);
    }

    public void navigate(int resId, Bundle args, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        NavDestination destination;
        int destinationId;
        if (this.backQueue.isEmpty()) {
            destination = this._graph;
        } else {
            destination = ((NavBackStackEntry) this.backQueue.last()).getDestination();
        }
        if (destination != null) {
            NavAction action = destination.getAction(resId);
            Bundle bundle = null;
            if (action != null) {
                if (navOptions == null) {
                    navOptions = action.getNavOptions();
                }
                destinationId = action.getDestinationId();
                Bundle defaultArguments = action.getDefaultArguments();
                if (defaultArguments != null) {
                    bundle = new Bundle();
                    bundle.putAll(defaultArguments);
                }
            } else {
                destinationId = resId;
            }
            if (args != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putAll(args);
            }
            if (destinationId == 0 && navOptions != null && (navOptions.getPopUpToId() != -1 || navOptions.getPopUpToRoute() != null)) {
                if (navOptions.getPopUpToRoute() != null) {
                    String popUpToRoute = navOptions.getPopUpToRoute();
                    h.c(popUpToRoute);
                    popBackStack$default(this, popUpToRoute, navOptions.getPopUpToInclusive(), false, 4, null);
                    return;
                } else {
                    if (navOptions.getPopUpToId() != -1) {
                        popBackStack(navOptions.getPopUpToId(), navOptions.getPopUpToInclusive());
                        return;
                    }
                    return;
                }
            }
            if (destinationId != 0) {
                NavDestination navDestinationFindDestination = findDestination(destinationId);
                if (navDestinationFindDestination == null) {
                    NavDestination.Companion companion = NavDestination.INSTANCE;
                    String displayName = companion.getDisplayName(this.context, destinationId);
                    if (action == null) {
                        throw new IllegalArgumentException("Navigation action/destination " + displayName + " cannot be found from the current destination " + destination);
                    }
                    StringBuilder sbM = B2.b.m("Navigation destination ", displayName, " referenced from action ");
                    sbM.append(companion.getDisplayName(this.context, resId));
                    sbM.append(" cannot be found from the current destination ");
                    sbM.append(destination);
                    throw new IllegalArgumentException(sbM.toString().toString());
                }
                navigate(navDestinationFindDestination, bundle, navOptions, navigatorExtras);
                return;
            }
            throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo");
        }
        throw new IllegalStateException("No current destination found. Ensure a navigation graph has been set for NavController " + this + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
    }

    public final boolean popBackStack(String route, boolean inclusive, boolean saveState) {
        h.f(route, "route");
        return popBackStackInternal(route, inclusive, saveState) && dispatchOnDestinationChanged();
    }

    private final boolean restoreStateInternal(String route) {
        NavBackStackEntryState navBackStackEntryState;
        int iHashCode = NavDestination.INSTANCE.createRoute(route).hashCode();
        if (this.backStackMap.containsKey(Integer.valueOf(iHashCode))) {
            return restoreStateInternal(iHashCode, null, null, null);
        }
        NavDestination navDestinationFindDestination = findDestination(route);
        if (navDestinationFindDestination != null) {
            String str = this.backStackMap.get(Integer.valueOf(navDestinationFindDestination.getId()));
            Collection<String> collectionValues = this.backStackMap.values();
            C02123 c02123 = new C02123(str);
            h.f(collectionValues, "<this>");
            kotlin.collections.s.H(collectionValues, c02123, true);
            i iVar = (i) kotlin.jvm.internal.z.b(this.backStackStates).remove(str);
            NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLink = navDestinationFindDestination.matchDeepLink(route);
            h.c(deepLinkMatchMatchDeepLink);
            if (deepLinkMatchMatchDeepLink.hasMatchingArgs((iVar == null || (navBackStackEntryState = (NavBackStackEntryState) iVar.e()) == null) ? null : navBackStackEntryState.getArgs())) {
                return executeRestoreState(instantiateBackStack(iVar), null, null, null);
            }
            return false;
        }
        StringBuilder sbM = B2.b.m("Restore State failed: route ", route, " cannot be found from the current destination ");
        sbM.append(getCurrentDestination());
        throw new IllegalStateException(sbM.toString().toString());
    }

    public final NavDestination findDestination(String route) {
        NavGraph destination;
        NavGraph parent;
        h.f(route, "route");
        NavGraph navGraph = this._graph;
        if (navGraph == null) {
            return null;
        }
        h.c(navGraph);
        if (!h.a(navGraph.getRoute(), route)) {
            NavGraph navGraph2 = this._graph;
            h.c(navGraph2);
            if (navGraph2.matchDeepLink(route) == null) {
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.backQueue.g();
                if (navBackStackEntry == null || (destination = navBackStackEntry.getDestination()) == null) {
                    destination = this._graph;
                    h.c(destination);
                }
                if (destination instanceof NavGraph) {
                    parent = destination;
                } else {
                    parent = destination.getParent();
                    h.c(parent);
                }
                return parent.findNode(route);
            }
        }
        return this._graph;
    }

    private final boolean clearBackStackInternal(String route) {
        Iterator<T> it = this.navigatorState.values().iterator();
        while (it.hasNext()) {
            ((NavControllerNavigatorState) it.next()).setNavigating(true);
        }
        boolean zRestoreStateInternal = restoreStateInternal(route);
        Iterator<T> it2 = this.navigatorState.values().iterator();
        while (it2.hasNext()) {
            ((NavControllerNavigatorState) it2.next()).setNavigating(false);
        }
        return zRestoreStateInternal && popBackStackInternal(route, true, false);
    }

    public final NavBackStackEntry getBackStackEntry(String route) {
        Object objPrevious;
        h.f(route, "route");
        i iVar = this.backQueue;
        ListIterator<E> listIterator = iVar.listIterator(iVar.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) objPrevious;
            if (navBackStackEntry.getDestination().hasRoute(route, navBackStackEntry.getArguments())) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) objPrevious;
        if (navBackStackEntry2 != null) {
            return navBackStackEntry2;
        }
        StringBuilder sbM = B2.b.m("No destination with route ", route, " is on the NavController's back stack. The current destination is ");
        sbM.append(getCurrentDestination());
        throw new IllegalArgumentException(sbM.toString().toString());
    }

    private final boolean popBackStackInternal(String route, boolean inclusive, boolean saveState) {
        Object objPrevious;
        if (this.backQueue.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        i iVar = this.backQueue;
        ListIterator<E> listIterator = iVar.listIterator(iVar.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) objPrevious;
            boolean zHasRoute = navBackStackEntry.getDestination().hasRoute(route, navBackStackEntry.getArguments());
            if (inclusive || !zHasRoute) {
                arrayList.add(this._navigatorProvider.getNavigator(navBackStackEntry.getDestination().getNavigatorName()));
            }
            if (zHasRoute) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) objPrevious;
        NavDestination destination = navBackStackEntry2 != null ? navBackStackEntry2.getDestination() : null;
        if (destination == null) {
            return false;
        }
        return executePopOperations(arrayList, destination, inclusive, saveState);
    }

    public void navigate(Uri deepLink) {
        h.f(deepLink, "deepLink");
        navigate(new NavDeepLinkRequest(deepLink, null, null));
    }

    public void navigate(Uri deepLink, NavOptions navOptions) {
        h.f(deepLink, "deepLink");
        navigate(new NavDeepLinkRequest(deepLink, null, null), navOptions, (Navigator.Extras) null);
    }

    public void navigate(Uri deepLink, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        h.f(deepLink, "deepLink");
        navigate(new NavDeepLinkRequest(deepLink, null, null), navOptions, navigatorExtras);
    }

    public void navigate(NavDeepLinkRequest request) {
        h.f(request, "request");
        navigate(request, (NavOptions) null);
    }

    public void navigate(NavDeepLinkRequest request, NavOptions navOptions) {
        h.f(request, "request");
        navigate(request, navOptions, (Navigator.Extras) null);
    }

    public void navigate(NavDeepLinkRequest request, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        h.f(request, "request");
        NavGraph navGraph = this._graph;
        if (navGraph != null) {
            h.c(navGraph);
            NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLink = navGraph.matchDeepLink(request);
            if (deepLinkMatchMatchDeepLink != null) {
                Bundle bundleAddInDefaultArgs = deepLinkMatchMatchDeepLink.getDestination().addInDefaultArgs(deepLinkMatchMatchDeepLink.getMatchingArgs());
                if (bundleAddInDefaultArgs == null) {
                    bundleAddInDefaultArgs = new Bundle();
                }
                NavDestination destination = deepLinkMatchMatchDeepLink.getDestination();
                Intent intent = new Intent();
                intent.setDataAndType(request.getUri(), request.getMimeType());
                intent.setAction(request.getAction());
                bundleAddInDefaultArgs.putParcelable(KEY_DEEP_LINK_INTENT, intent);
                navigate(destination, bundleAddInDefaultArgs, navOptions, navigatorExtras);
                return;
            }
            throw new IllegalArgumentException("Navigation destination that matches request " + request + " cannot be found in the navigation graph " + this._graph);
        }
        throw new IllegalArgumentException(("Cannot navigate to " + request + ". Navigation graph has not been set for NavController " + this + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH).toString());
    }

    private final void navigate(NavDestination node, Bundle args, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        boolean z6;
        boolean z7;
        boolean zPopBackStackInternal;
        Iterator<T> it = this.navigatorState.values().iterator();
        while (it.hasNext()) {
            ((NavControllerNavigatorState) it.next()).setNavigating(true);
        }
        s sVar = new s();
        if (navOptions == null) {
            z6 = false;
        } else {
            if (navOptions.getPopUpToRoute() != null) {
                String popUpToRoute = navOptions.getPopUpToRoute();
                h.c(popUpToRoute);
                zPopBackStackInternal = popBackStackInternal(popUpToRoute, navOptions.getPopUpToInclusive(), navOptions.getPopUpToSaveState());
            } else {
                if (navOptions.getPopUpToId() != -1) {
                    zPopBackStackInternal = popBackStackInternal(navOptions.getPopUpToId(), navOptions.getPopUpToInclusive(), navOptions.getPopUpToSaveState());
                }
                z6 = false;
            }
            z6 = zPopBackStackInternal;
        }
        Bundle bundleAddInDefaultArgs = node.addInDefaultArgs(args);
        if (navOptions != null && navOptions.getRestoreState() && this.backStackMap.containsKey(Integer.valueOf(node.getId()))) {
            sVar.f3813a = restoreStateInternal(node.getId(), bundleAddInDefaultArgs, navOptions, navigatorExtras);
            z7 = false;
        } else {
            z7 = navOptions != null && navOptions.getSingleTop() && launchSingleTopInternal(node, args);
            if (!z7) {
                navigateInternal(this._navigatorProvider.getNavigator(node.getNavigatorName()), Z.p(NavBackStackEntry.Companion.create$default(NavBackStackEntry.INSTANCE, this.context, node, bundleAddInDefaultArgs, getHostLifecycleState$navigation_runtime_release(), this.viewModel, null, null, 96, null)), navOptions, navigatorExtras, new C02085(sVar, this, node, bundleAddInDefaultArgs));
            }
        }
        updateOnBackPressedCallbackEnabled();
        Iterator<T> it2 = this.navigatorState.values().iterator();
        while (it2.hasNext()) {
            ((NavControllerNavigatorState) it2.next()).setNavigating(false);
        }
        if (!z6 && !sVar.f3813a && !z7) {
            updateBackStackLifecycle$navigation_runtime_release();
        } else {
            dispatchOnDestinationChanged();
        }
    }

    public void navigate(NavDirections directions) {
        h.f(directions, "directions");
        navigate(directions.getActionId(), directions.getArguments(), (NavOptions) null);
    }

    public void navigate(NavDirections directions, NavOptions navOptions) {
        h.f(directions, "directions");
        navigate(directions.getActionId(), directions.getArguments(), navOptions);
    }

    public void navigate(NavDirections directions, Navigator.Extras navigatorExtras) {
        h.f(directions, "directions");
        h.f(navigatorExtras, "navigatorExtras");
        navigate(directions.getActionId(), directions.getArguments(), (NavOptions) null, navigatorExtras);
    }

    public final void navigate(String route, Function1<? super NavOptionsBuilder, m> builder) {
        h.f(route, "route");
        h.f(builder, "builder");
        navigate$default(this, route, NavOptionsBuilderKt.navOptions(builder), null, 4, null);
    }

    public final void navigate(String route, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        h.f(route, "route");
        NavDeepLinkRequest.Builder.Companion companion = NavDeepLinkRequest.Builder.INSTANCE;
        Uri uri = Uri.parse(NavDestination.INSTANCE.createRoute(route));
        h.b(uri, "Uri.parse(this)");
        navigate(companion.fromUri(uri).build(), navOptions, navigatorExtras);
    }
}
