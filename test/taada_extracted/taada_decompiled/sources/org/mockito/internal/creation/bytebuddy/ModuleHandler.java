package org.mockito.internal.creation.bytebuddy;

import java.lang.reflect.Method;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
import net.bytebuddy.utility.GraalImageCode;
import org.mockito.Mockito;
import org.mockito.codegen.InjectionBase;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.util.StringUtil;

/* JADX INFO: loaded from: classes.dex */
abstract class ModuleHandler {

    public static class ModuleSystemFound extends ModuleHandler {
        private final Method addExports;
        private final Method addReads;
        private final ByteBuddy byteBuddy;
        private final Method canRead;
        private final Method forName;
        private final Method getModule;
        private final int injectonBaseSuffix;
        private final Method isExported;
        private final Method isExportedUnqualified;
        private final Method isOpen;
        private final SubclassLoader loader;

        private static Object invoke(Method method, Object obj, Object... objArr) {
            try {
                return method.invoke(obj, objArr);
            } catch (Exception e) {
                throw new MockitoException(StringUtil.join("Could not invoke " + method + " using reflection", "", "Mockito attempted to interact with the Java module system but an unexpected method behavior was encountered"), e);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0030, code lost:
        
            if (r8 == r19.getClassLoader()) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
        
            r10 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
        
            r10 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0035, code lost:
        
            if (r10 != false) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0037, code lost:
        
            if (r8 == null) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
        
            r8 = r8.getParent();
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0041, code lost:
        
            if (r8 != r19.getClassLoader()) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x004a, code lost:
        
            if (r10 == false) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x004c, code lost:
        
            r3 = net.bytebuddy.implementation.MethodCall.invoke(r17.getModule).onMethodCall(net.bytebuddy.implementation.MethodCall.invoke(r17.forName).with(r19.getName()));
            r10 = net.bytebuddy.implementation.StubMethod.INSTANCE;
            r16 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x006e, code lost:
        
            r16 = true;
            r4 = r17.byteBuddy.subclass(java.lang.Object.class, (net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy) net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy.Default.NO_CONSTRUCTORS).name("org.mockito.codegen.MockitoTypeCarrier$" + net.bytebuddy.utility.RandomString.hashOf(r18.getName().hashCode()) + net.bytebuddy.utility.RandomString.hashOf(r19.getName().hashCode())).defineField("mockitoType", java.lang.Class.class, net.bytebuddy.description.modifier.Visibility.PUBLIC, net.bytebuddy.description.modifier.Ownership.STATIC).make().load(r18.getClassLoader(), r17.loader.resolveStrategy(r18, r18.getClassLoader(), false)).getLoaded();
            r3 = r4.getField("mockitoType");
            r3.set(null, r19);
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00de, code lost:
        
            r3 = net.bytebuddy.implementation.MethodCall.invoke(r17.getModule).onField(r3);
            r10 = net.bytebuddy.implementation.MethodCall.invoke(r17.getModule).onMethodCall(net.bytebuddy.implementation.MethodCall.invoke(r17.forName).with(r4.getName()));
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0104, code lost:
        
            r4 = net.bytebuddy.implementation.MethodCall.invoke(r17.getModule).onMethodCall(net.bytebuddy.implementation.MethodCall.invoke(r17.forName).with(r18.getName()));
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0120, code lost:
        
            if (r6 == false) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0122, code lost:
        
            r10 = r10.andThen((net.bytebuddy.implementation.Implementation.Composable) net.bytebuddy.implementation.MethodCall.invoke(r17.addExports).onMethodCall(r4).with(r19.getPackage().getName()).withMethodCall(r3));
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0144, code lost:
        
            if (r7 == false) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0146, code lost:
        
            r10 = r10.andThen((net.bytebuddy.implementation.Implementation.Composable) net.bytebuddy.implementation.MethodCall.invoke(r17.addReads).onMethodCall(r4).withMethodCall(r3));
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0158, code lost:
        
            java.lang.Class.forName(r17.byteBuddy.subclass(java.lang.Object.class).name(r18.getName() + "$MockitoModuleProbe$" + net.bytebuddy.utility.RandomString.hashOf(r18.getName().hashCode()) + net.bytebuddy.utility.RandomString.hashOf(r19.getName().hashCode())).invokable(net.bytebuddy.matcher.ElementMatchers.isTypeInitializer()).intercept(r10).make().load(r18.getClassLoader(), r17.loader.resolveStrategy(r18, r18.getClassLoader(), false)).getLoaded().getName(), r16, r18.getClassLoader());
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x01ce, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x01cf, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x01e3, code lost:
        
            throw new org.mockito.exceptions.base.MockitoException(org.mockito.internal.util.StringUtil.join(androidx.constraintlayout.core.motion.a.j(r18, "Could not force module adjustment of the module of "), "", "This is required to adjust the module graph to enable mock creation"), r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x01e4, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x01f8, code lost:
        
            throw new org.mockito.exceptions.base.MockitoException(org.mockito.internal.util.StringUtil.join(androidx.constraintlayout.core.motion.a.j(r18, "Could not create a carrier for making the Mockito type visible to "), "", "This is required to adjust the module graph to enable mock creation"), r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0035, code lost:
        
            r10 = false;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0041 -> B:20:0x0032). Please report as a decompilation issue!!! */
        @Override // org.mockito.internal.creation.bytebuddy.ModuleHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void adjustModuleGraph(java.lang.Class<?> r18, java.lang.Class<?> r19, boolean r20, boolean r21) {
            /*
                Method dump skipped, instruction units count: 580
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.mockito.internal.creation.bytebuddy.ModuleHandler.ModuleSystemFound.adjustModuleGraph(java.lang.Class, java.lang.Class, boolean, boolean):void");
        }

        @Override // org.mockito.internal.creation.bytebuddy.ModuleHandler
        public boolean canRead(Class<?> cls, Class<?> cls2) {
            return ((Boolean) invoke(this.canRead, invoke(this.getModule, cls, new Object[0]), invoke(this.getModule, cls2, new Object[0]))).booleanValue();
        }

        @Override // org.mockito.internal.creation.bytebuddy.ModuleHandler
        public Class<?> injectionBase(ClassLoader classLoader, String str) {
            Class<?> cls;
            String strSubstring = str.substring(0, str.lastIndexOf(46));
            if (classLoader == InjectionBase.class.getClassLoader() && InjectionBase.class.getPackage().getName().equals(strSubstring)) {
                return InjectionBase.class;
            }
            synchronized (this) {
                try {
                    int i = this.injectonBaseSuffix;
                    while (true) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(strSubstring);
                        sb.append(".");
                        sb.append("InjectionBase");
                        sb.append("$");
                        int i3 = i + 1;
                        sb.append(i);
                        String string = sb.toString();
                        try {
                            cls = Class.forName(string, false, classLoader);
                            if (cls.getClassLoader() != classLoader) {
                                i = i3;
                            }
                        } catch (ClassNotFoundException unused) {
                            return this.byteBuddy.subclass(Object.class, (ConstructorStrategy) ConstructorStrategy.Default.NO_CONSTRUCTORS).name(string).make().load(classLoader, this.loader.resolveStrategy(InjectionBase.class, classLoader, false)).getLoaded();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return cls;
        }

        @Override // org.mockito.internal.creation.bytebuddy.ModuleHandler
        public boolean isExported(Class<?> cls) {
            if (cls.getPackage() == null) {
                return true;
            }
            return ((Boolean) invoke(this.isExportedUnqualified, invoke(this.getModule, cls, new Object[0]), cls.getPackage().getName())).booleanValue();
        }

        @Override // org.mockito.internal.creation.bytebuddy.ModuleHandler
        public boolean isOpened(Class<?> cls, Class<?> cls2) {
            if (cls.getPackage() == null) {
                return true;
            }
            return ((Boolean) invoke(this.isOpen, invoke(this.getModule, cls, new Object[0]), cls.getPackage().getName(), invoke(this.getModule, cls2, new Object[0]))).booleanValue();
        }

        private ModuleSystemFound(ByteBuddy byteBuddy, SubclassLoader subclassLoader) throws ClassNotFoundException {
            this.byteBuddy = byteBuddy;
            this.loader = subclassLoader;
            this.injectonBaseSuffix = GraalImageCode.getCurrent().isDefined() ? 0 : Math.abs(Mockito.class.hashCode());
            Class<?> cls = Class.forName("java.lang.Module");
            this.getModule = Class.class.getMethod("getModule", new Class[0]);
            this.isOpen = cls.getMethod("isOpen", String.class, cls);
            this.isExported = cls.getMethod("isExported", String.class, cls);
            this.isExportedUnqualified = cls.getMethod("isExported", String.class);
            this.canRead = cls.getMethod("canRead", cls);
            this.addExports = cls.getMethod("addExports", String.class, cls);
            this.addReads = cls.getMethod("addReads", cls);
            this.forName = Class.class.getMethod("forName", String.class);
        }

        @Override // org.mockito.internal.creation.bytebuddy.ModuleHandler
        public boolean isExported(Class<?> cls, Class<?> cls2) {
            if (cls.getPackage() == null) {
                return true;
            }
            return ((Boolean) invoke(this.isExported, invoke(this.getModule, cls, new Object[0]), cls.getPackage().getName(), invoke(this.getModule, cls2, new Object[0]))).booleanValue();
        }
    }

    public static class NoModuleSystemFound extends ModuleHandler {
        private NoModuleSystemFound() {
        }

        @Override // org.mockito.internal.creation.bytebuddy.ModuleHandler
        public void adjustModuleGraph(Class<?> cls, Class<?> cls2, boolean z6, boolean z7) {
        }

        @Override // org.mockito.internal.creation.bytebuddy.ModuleHandler
        public boolean canRead(Class<?> cls, Class<?> cls2) {
            return true;
        }

        @Override // org.mockito.internal.creation.bytebuddy.ModuleHandler
        public Class<?> injectionBase(ClassLoader classLoader, String str) {
            return InjectionBase.class;
        }

        @Override // org.mockito.internal.creation.bytebuddy.ModuleHandler
        public boolean isExported(Class<?> cls) {
            return true;
        }

        @Override // org.mockito.internal.creation.bytebuddy.ModuleHandler
        public boolean isOpened(Class<?> cls, Class<?> cls2) {
            return true;
        }

        @Override // org.mockito.internal.creation.bytebuddy.ModuleHandler
        public boolean isExported(Class<?> cls, Class<?> cls2) {
            return true;
        }
    }

    public static ModuleHandler make(ByteBuddy byteBuddy, SubclassLoader subclassLoader) {
        try {
            return new ModuleSystemFound(byteBuddy, subclassLoader);
        } catch (Exception unused) {
            return new NoModuleSystemFound();
        }
    }

    public abstract void adjustModuleGraph(Class<?> cls, Class<?> cls2, boolean z6, boolean z7);

    public abstract boolean canRead(Class<?> cls, Class<?> cls2);

    public abstract Class<?> injectionBase(ClassLoader classLoader, String str);

    public abstract boolean isExported(Class<?> cls);

    public abstract boolean isExported(Class<?> cls, Class<?> cls2);

    public abstract boolean isOpened(Class<?> cls, Class<?> cls2);
}
