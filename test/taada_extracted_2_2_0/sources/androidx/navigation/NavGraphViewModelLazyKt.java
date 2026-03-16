package androidx.navigation;

import a.AbstractC0132a;
import android.view.ViewModel;
import android.view.ViewModelProvider;
import android.view.viewmodel.CreationExtras;
import androidx.fragment.app.Fragment;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.i;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\u001a>\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0087\bø\u0001\u0000\u001aP\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0010\b\n\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b2\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0087\bø\u0001\u0000\u001a<\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0087\bø\u0001\u0000\u001aN\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0010\b\n\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b2\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e²\u0006\u0016\u0010\u000f\u001a\u00020\u0010\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003X\u008a\u0084\u0002²\u0006\u0016\u0010\u000f\u001a\u00020\u0010\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003X\u008a\u0084\u0002²\u0006\u0016\u0010\u000f\u001a\u00020\u0010\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003X\u008a\u0084\u0002²\u0006\u0016\u0010\u000f\u001a\u00020\u0010\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003X\u008a\u0084\u0002"}, d2 = {"navGraphViewModels", "Lkotlin/Lazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/Fragment;", "navGraphId", "", "factoryProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "extrasProducer", "Landroidx/lifecycle/viewmodel/CreationExtras;", "navGraphRoute", "", "navigation-fragment_release", "backStackEntry", "Landroidx/navigation/NavBackStackEntry;"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NavGraphViewModelLazyKt {

    /* JADX INFO: renamed from: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass1 extends i implements Function0<CreationExtras> {
        final /* synthetic */ Lazy<NavBackStackEntry> $backStackEntry$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Lazy<NavBackStackEntry> lazy) {
            super(0);
            this.$backStackEntry$delegate = lazy;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CreationExtras invoke() {
            return NavGraphViewModelLazyKt.m22navGraphViewModels$lambda0(this.$backStackEntry$delegate).getDefaultViewModelCreationExtras();
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass2 extends i implements Function0<ViewModelProvider.Factory> {
        final /* synthetic */ Lazy<NavBackStackEntry> $backStackEntry$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Lazy<NavBackStackEntry> lazy) {
            super(0);
            this.$backStackEntry$delegate = lazy;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return NavGraphViewModelLazyKt.m22navGraphViewModels$lambda0(this.$backStackEntry$delegate).getDefaultViewModelProviderFactory();
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass3 extends i implements Function0<CreationExtras> {
        final /* synthetic */ Lazy<NavBackStackEntry> $backStackEntry$delegate;
        final /* synthetic */ Function0<CreationExtras> $extrasProducer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Function0<? extends CreationExtras> function0, Lazy<NavBackStackEntry> lazy) {
            super(0);
            this.$extrasProducer = function0;
            this.$backStackEntry$delegate = lazy;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CreationExtras invoke() {
            CreationExtras creationExtrasInvoke;
            Function0<CreationExtras> function0 = this.$extrasProducer;
            return (function0 == null || (creationExtrasInvoke = function0.invoke()) == null) ? NavGraphViewModelLazyKt.m23navGraphViewModels$lambda1(this.$backStackEntry$delegate).getDefaultViewModelCreationExtras() : creationExtrasInvoke;
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass4 extends i implements Function0<ViewModelProvider.Factory> {
        final /* synthetic */ Lazy<NavBackStackEntry> $backStackEntry$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Lazy<NavBackStackEntry> lazy) {
            super(0);
            this.$backStackEntry$delegate = lazy;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return NavGraphViewModelLazyKt.m23navGraphViewModels$lambda1(this.$backStackEntry$delegate).getDefaultViewModelProviderFactory();
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass5 extends i implements Function0<CreationExtras> {
        final /* synthetic */ Lazy<NavBackStackEntry> $backStackEntry$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(Lazy<NavBackStackEntry> lazy) {
            super(0);
            this.$backStackEntry$delegate = lazy;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CreationExtras invoke() {
            return NavGraphViewModelLazyKt.m24navGraphViewModels$lambda2(this.$backStackEntry$delegate).getDefaultViewModelCreationExtras();
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass6 extends i implements Function0<ViewModelProvider.Factory> {
        final /* synthetic */ Lazy<NavBackStackEntry> $backStackEntry$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(Lazy<NavBackStackEntry> lazy) {
            super(0);
            this.$backStackEntry$delegate = lazy;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return NavGraphViewModelLazyKt.m24navGraphViewModels$lambda2(this.$backStackEntry$delegate).getDefaultViewModelProviderFactory();
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$7, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass7 extends i implements Function0<CreationExtras> {
        final /* synthetic */ Lazy<NavBackStackEntry> $backStackEntry$delegate;
        final /* synthetic */ Function0<CreationExtras> $extrasProducer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass7(Function0<? extends CreationExtras> function0, Lazy<NavBackStackEntry> lazy) {
            super(0);
            this.$extrasProducer = function0;
            this.$backStackEntry$delegate = lazy;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CreationExtras invoke() {
            CreationExtras creationExtrasInvoke;
            Function0<CreationExtras> function0 = this.$extrasProducer;
            return (function0 == null || (creationExtrasInvoke = function0.invoke()) == null) ? NavGraphViewModelLazyKt.m25navGraphViewModels$lambda3(this.$backStackEntry$delegate).getDefaultViewModelCreationExtras() : creationExtrasInvoke;
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$8, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass8 extends i implements Function0<ViewModelProvider.Factory> {
        final /* synthetic */ Lazy<NavBackStackEntry> $backStackEntry$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass8(Lazy<NavBackStackEntry> lazy) {
            super(0);
            this.$backStackEntry$delegate = lazy;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return NavGraphViewModelLazyKt.m25navGraphViewModels$lambda3(this.$backStackEntry$delegate).getDefaultViewModelProviderFactory();
        }
    }

    @Deprecated(level = N1.a.c, message = "Superseded by navGraphViewModels that takes a CreationExtras producer")
    public static final <VM extends ViewModel> Lazy<VM> navGraphViewModels(Fragment fragment, int i, Function0<? extends ViewModelProvider.Factory> function0) {
        h.f(fragment, "<this>");
        new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1(AbstractC0132a.M(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$2(fragment, i)));
        h.k();
        throw null;
    }

    public static Lazy navGraphViewModels$default(Fragment fragment, int i, Function0 function0, int i3, Object obj) {
        h.f(fragment, "<this>");
        new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1(AbstractC0132a.M(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$2(fragment, i)));
        h.k();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: navGraphViewModels$lambda-0, reason: not valid java name */
    public static final NavBackStackEntry m22navGraphViewModels$lambda0(Lazy<NavBackStackEntry> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: navGraphViewModels$lambda-1, reason: not valid java name */
    public static final NavBackStackEntry m23navGraphViewModels$lambda1(Lazy<NavBackStackEntry> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: navGraphViewModels$lambda-2, reason: not valid java name */
    public static final NavBackStackEntry m24navGraphViewModels$lambda2(Lazy<NavBackStackEntry> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: navGraphViewModels$lambda-3, reason: not valid java name */
    public static final NavBackStackEntry m25navGraphViewModels$lambda3(Lazy<NavBackStackEntry> lazy) {
        return lazy.getValue();
    }

    public static final <VM extends ViewModel> Lazy<VM> navGraphViewModels(Fragment fragment, int i, Function0<? extends CreationExtras> function0, Function0<? extends ViewModelProvider.Factory> function02) {
        h.f(fragment, "<this>");
        new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$2(AbstractC0132a.M(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$4(fragment, i)));
        h.k();
        throw null;
    }

    public static Lazy navGraphViewModels$default(Fragment fragment, int i, Function0 function0, Function0 function02, int i3, Object obj) {
        h.f(fragment, "<this>");
        new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$2(AbstractC0132a.M(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$4(fragment, i)));
        h.k();
        throw null;
    }

    @Deprecated(level = N1.a.c, message = "Superseded by navGraphViewModels that takes a CreationExtras producer")
    public static final <VM extends ViewModel> Lazy<VM> navGraphViewModels(Fragment fragment, String navGraphRoute, Function0<? extends ViewModelProvider.Factory> function0) {
        h.f(fragment, "<this>");
        h.f(navGraphRoute, "navGraphRoute");
        new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$3(AbstractC0132a.M(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$6(fragment, navGraphRoute)));
        h.k();
        throw null;
    }

    public static Lazy navGraphViewModels$default(Fragment fragment, String navGraphRoute, Function0 function0, int i, Object obj) {
        h.f(fragment, "<this>");
        h.f(navGraphRoute, "navGraphRoute");
        new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$3(AbstractC0132a.M(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$6(fragment, navGraphRoute)));
        h.k();
        throw null;
    }

    public static final <VM extends ViewModel> Lazy<VM> navGraphViewModels(Fragment fragment, String navGraphRoute, Function0<? extends CreationExtras> function0, Function0<? extends ViewModelProvider.Factory> function02) {
        h.f(fragment, "<this>");
        h.f(navGraphRoute, "navGraphRoute");
        new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$4(AbstractC0132a.M(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$8(fragment, navGraphRoute)));
        h.k();
        throw null;
    }

    public static Lazy navGraphViewModels$default(Fragment fragment, String navGraphRoute, Function0 function0, Function0 function02, int i, Object obj) {
        h.f(fragment, "<this>");
        h.f(navGraphRoute, "navGraphRoute");
        new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$4(AbstractC0132a.M(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$8(fragment, navGraphRoute)));
        h.k();
        throw null;
    }
}
