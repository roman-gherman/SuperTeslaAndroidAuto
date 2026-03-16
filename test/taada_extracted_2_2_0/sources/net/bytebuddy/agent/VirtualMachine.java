package net.bytebuddy.agent;

import B2.b;
import androidx.constraintlayout.core.motion.a;
import com.sun.jna.LastErrorException;
import com.sun.jna.Library;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.platform.win32.Advapi32;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Win32Exception;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import net.bytebuddy.agent.utility.nullability.MaybeNull;
import net.bytebuddy.agent.utility.nullability.UnknownNull;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: loaded from: classes2.dex */
public interface VirtualMachine {

    public static abstract class AbstractBase implements VirtualMachine {
        @Override // net.bytebuddy.agent.VirtualMachine
        public void loadAgent(String str) {
            loadAgent(str, null);
        }

        @Override // net.bytebuddy.agent.VirtualMachine
        public void loadAgentLibrary(String str) {
            loadAgentLibrary(str, null);
        }

        @Override // net.bytebuddy.agent.VirtualMachine
        public void loadAgentPath(String str) {
            loadAgentPath(str, null);
        }
    }

    public static class ForOpenJ9 extends AbstractBase {
        private static final String IBM_TEMPORARY_FOLDER = "com.ibm.tools.attach.directory";
        private static final SecureRandom SECURE_RANDOM = new SecureRandom();
        private final Socket socket;

        public interface Dispatcher {

            public static class ForJnaPosixEnvironment implements Dispatcher {
                private final int attempts;
                private final PosixLibrary library = (PosixLibrary) Native.loadLibrary("c", PosixLibrary.class);
                private final long pause;
                private final TimeUnit timeUnit;

                public interface PosixLibrary extends Library {
                    public static final int EAGAIN = 11;
                    public static final int EDEADLK = 35;
                    public static final int ESRCH = 3;
                    public static final short IPC_NOWAIT = 2048;
                    public static final int NULL_SIGNAL = 0;
                    public static final short SEM_UNDO = 4096;

                    public static class SemaphoreOperation extends Structure {
                        public short flags;
                        public short number;
                        public short operation;

                        public List<String> getFieldOrder() {
                            return Arrays.asList("number", "operation", "flags");
                        }
                    }

                    int chmod(String str, int i);

                    int ftok(String str, int i);

                    int getpid();

                    int getuid();

                    int kill(int i, int i3);

                    int semget(int i, int i3, int i4);

                    int semop(int i, SemaphoreOperation semaphoreOperation, int i3);
                }

                public ForJnaPosixEnvironment(int i, long j6, TimeUnit timeUnit) {
                    this.attempts = i;
                    this.pause = j6;
                    this.timeUnit = timeUnit;
                }

                /* JADX INFO: Thrown type has an unknown type hierarchy: com.sun.jna.LastErrorException */
                @SuppressFBWarnings(justification = "Modifier is required by JNA.", value = {"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD", "UUF_UNUSED_PUBLIC_OR_PROTECTED_FIELD"})
                private void notifySemaphore(File file, String str, int i, short s3, short s6, boolean z6) throws LastErrorException {
                    PosixLibrary posixLibrary = this.library;
                    int iSemget = posixLibrary.semget(posixLibrary.ftok(new File(file, str).getAbsolutePath(), 161), 2, 438);
                    PosixLibrary.SemaphoreOperation semaphoreOperation = new PosixLibrary.SemaphoreOperation();
                    semaphoreOperation.operation = s3;
                    semaphoreOperation.flags = s6;
                    while (true) {
                        int i3 = i - 1;
                        if (i <= 0) {
                            return;
                        }
                        try {
                            this.library.semop(iSemget, semaphoreOperation, 1);
                            i = i3;
                        } catch (LastErrorException e) {
                            if (!z6 || (Native.getLastError() != 11 && Native.getLastError() != 35)) {
                                throw e;
                            }
                            return;
                        }
                    }
                }

                /* JADX INFO: Thrown type has an unknown type hierarchy: com.sun.jna.LastErrorException */
                @Override // net.bytebuddy.agent.VirtualMachine.ForOpenJ9.Dispatcher
                public void decrementSemaphore(File file, String str, boolean z6, int i) throws LastErrorException {
                    notifySemaphore(file, str, i, (short) -1, (short) 6144, true);
                }

                @Override // net.bytebuddy.agent.VirtualMachine.ForOpenJ9.Dispatcher
                @SuppressFBWarnings(justification = "The stream life-cycle is bound to its process.", value = {"OS_OPEN_STREAM"})
                public int getOwnerIdOf(File file) {
                    try {
                        Process processExec = Runtime.getRuntime().exec(new String[]{"stat", Platform.isMac() ? "-f" : "-c", "%u", file.getAbsolutePath()});
                        int i = this.attempts;
                        String line = new BufferedReader(new InputStreamReader(processExec.getInputStream(), "UTF-8")).readLine();
                        do {
                            try {
                                try {
                                    if (processExec.exitValue() == 0) {
                                        return Integer.parseInt(line);
                                    }
                                    throw new IllegalStateException("Error while executing stat");
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                    throw new IllegalStateException(e);
                                }
                                Thread.currentThread().interrupt();
                                throw new IllegalStateException(e);
                            } catch (IllegalThreadStateException unused) {
                                Thread.sleep(this.timeUnit.toMillis(this.pause));
                                i--;
                            }
                        } while (i > 0);
                        processExec.destroy();
                        throw new IllegalStateException("Command for stat did not exit in time");
                    } catch (IOException e6) {
                        throw new IllegalStateException("Unable to execute stat command", e6);
                    }
                }

                @Override // net.bytebuddy.agent.VirtualMachine.ForOpenJ9.Dispatcher
                public String getTemporaryFolder(String str) {
                    if (Platform.isLinux()) {
                        File file = new File(a.q("/proc/", str, "/root/tmp"));
                        if (file.isDirectory() && file.canRead()) {
                            return file.getAbsolutePath();
                        }
                    }
                    String str2 = System.getenv("TMPDIR");
                    return str2 == null ? "/tmp" : str2;
                }

                /* JADX INFO: Thrown type has an unknown type hierarchy: com.sun.jna.LastErrorException */
                @Override // net.bytebuddy.agent.VirtualMachine.ForOpenJ9.Dispatcher
                public void incrementSemaphore(File file, String str, boolean z6, int i) throws LastErrorException {
                    notifySemaphore(file, str, i, (short) 1, (short) 0, false);
                }

                @Override // net.bytebuddy.agent.VirtualMachine.ForOpenJ9.Dispatcher
                public boolean isExistingProcess(int i) {
                    return this.library.kill(i, 0) != 3;
                }

                @Override // net.bytebuddy.agent.VirtualMachine.ForOpenJ9.Dispatcher
                public int pid() {
                    return this.library.getpid();
                }

                @Override // net.bytebuddy.agent.VirtualMachine.ForOpenJ9.Dispatcher
                public void setPermissions(File file, int i) {
                    this.library.chmod(file.getAbsolutePath(), i);
                }

                @Override // net.bytebuddy.agent.VirtualMachine.ForOpenJ9.Dispatcher
                public int userId() {
                    return this.library.getuid();
                }
            }

            public static class ForJnaWindowsEnvironment implements Dispatcher {
                private static final String CREATION_MUTEX_NAME = "j9shsemcreationMutex";
                private static final int NO_USER_ID = 0;
                private final WindowsLibrary library = (WindowsLibrary) Native.loadLibrary("kernel32", WindowsLibrary.class, W32APIOptions.DEFAULT_OPTIONS);

                public static class AttachmentHandle implements Closeable {
                    private final WinNT.HANDLE child;
                    private final WinNT.HANDLE parent;

                    public AttachmentHandle(WinNT.HANDLE handle, WinNT.HANDLE handle2) {
                        this.parent = handle;
                        this.child = handle2;
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: com.sun.jna.platform.win32.Win32Exception */
                    @Override // java.io.Closeable, java.lang.AutoCloseable
                    public void close() throws Win32Exception {
                        Kernel32 kernel32;
                        WinNT.HANDLE handle;
                        try {
                            if (!Kernel32.INSTANCE.CloseHandle(this.child)) {
                                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                            }
                            if (!kernel32.CloseHandle(handle)) {
                                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                            }
                        } finally {
                            Kernel32.INSTANCE.CloseHandle(this.parent);
                        }
                    }

                    public WinNT.HANDLE getHandle() {
                        return this.child;
                    }
                }

                public interface WindowsLibrary extends StdCallLibrary {
                    public static final int SEMAPHORE_ALL_ACCESS = 2031619;

                    @SuppressFBWarnings(justification = "Field required by native implementation.", value = {"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD", "UUF_UNUSED_PUBLIC_OR_PROTECTED_FIELD"})
                    public static class SecurityAttributes extends Structure {
                        public boolean inherit;

                        @MaybeNull
                        public WinDef.DWORD length;

                        @MaybeNull
                        public Pointer securityDescriptor;

                        public List<String> getFieldOrder() {
                            return Arrays.asList("length", "securityDescriptor", "inherit");
                        }
                    }

                    @MaybeNull
                    WinNT.HANDLE CreateMutex(SecurityAttributes securityAttributes, boolean z6, String str);

                    @MaybeNull
                    WinNT.HANDLE CreateSemaphoreW(@MaybeNull WinBase.SECURITY_ATTRIBUTES security_attributes, long j6, long j7, String str);

                    WinNT.HANDLE OpenMutex(int i, boolean z6, String str);

                    @MaybeNull
                    WinNT.HANDLE OpenSemaphoreW(int i, boolean z6, String str);

                    boolean ReleaseMutex(WinNT.HANDLE handle);

                    boolean ReleaseSemaphore(WinNT.HANDLE handle, long j6, @MaybeNull Long l6);
                }

                /* JADX INFO: Thrown type has an unknown type hierarchy: com.sun.jna.platform.win32.Win32Exception */
                private AttachmentHandle openSemaphore(File file, String str, boolean z6) throws Win32Exception {
                    WinNT.SECURITY_DESCRIPTOR security_descriptor = new WinNT.SECURITY_DESCRIPTOR(65536);
                    if (!Advapi32.INSTANCE.InitializeSecurityDescriptor(security_descriptor, 1)) {
                        throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                    }
                    if (!Advapi32.INSTANCE.SetSecurityDescriptorDacl(security_descriptor, true, (WinNT.ACL) null, true)) {
                        throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                    }
                    WindowsLibrary.SecurityAttributes securityAttributes = new WindowsLibrary.SecurityAttributes();
                    securityAttributes.length = new WinDef.DWORD(securityAttributes.size());
                    securityAttributes.securityDescriptor = security_descriptor.getPointer();
                    WinNT.HANDLE handleCreateMutex = this.library.CreateMutex(securityAttributes, false, CREATION_MUTEX_NAME);
                    if (handleCreateMutex == null) {
                        int iGetLastError = Kernel32.INSTANCE.GetLastError();
                        if (iGetLastError != 183) {
                            throw new Win32Exception(iGetLastError);
                        }
                        handleCreateMutex = this.library.OpenMutex(2031617, false, CREATION_MUTEX_NAME);
                        if (handleCreateMutex == null) {
                            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                        }
                    }
                    int iWaitForSingleObject = Kernel32.INSTANCE.WaitForSingleObject(handleCreateMutex, 2000);
                    if (iWaitForSingleObject == -1 || iWaitForSingleObject == 258) {
                        throw new Win32Exception(iWaitForSingleObject);
                    }
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append(z6 ? "Global\\" : "");
                        sb.append((file.getAbsolutePath() + '_' + str).replaceAll("[^a-zA-Z0-9_]", ""));
                        sb.append("_semaphore");
                        String string = sb.toString();
                        WinNT.HANDLE handleOpenSemaphoreW = this.library.OpenSemaphoreW(WindowsLibrary.SEMAPHORE_ALL_ACCESS, false, string);
                        if (handleOpenSemaphoreW != null) {
                            WinNT.HANDLE handleOpenSemaphoreW2 = this.library.OpenSemaphoreW(WindowsLibrary.SEMAPHORE_ALL_ACCESS, false, string + "_set0");
                            if (handleOpenSemaphoreW2 == null) {
                                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                            }
                            AttachmentHandle attachmentHandle = new AttachmentHandle(handleOpenSemaphoreW, handleOpenSemaphoreW2);
                            if (this.library.ReleaseMutex(handleCreateMutex)) {
                                return attachmentHandle;
                            }
                            throw new Win32Exception(Native.getLastError());
                        }
                        WinNT.HANDLE handleCreateSemaphoreW = this.library.CreateSemaphoreW(null, 0L, 2147483647L, string);
                        if (handleCreateSemaphoreW == null) {
                            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                        }
                        WinNT.HANDLE handleCreateSemaphoreW2 = this.library.CreateSemaphoreW(null, 0L, 2147483647L, string + "_set0");
                        if (handleCreateSemaphoreW2 == null) {
                            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                        }
                        AttachmentHandle attachmentHandle2 = new AttachmentHandle(handleCreateSemaphoreW, handleCreateSemaphoreW2);
                        if (this.library.ReleaseMutex(handleCreateMutex)) {
                            return attachmentHandle2;
                        }
                        throw new Win32Exception(Native.getLastError());
                    } catch (Throwable th) {
                        if (this.library.ReleaseMutex(handleCreateMutex)) {
                            throw th;
                        }
                        throw new Win32Exception(Native.getLastError());
                    }
                }

                /* JADX INFO: Thrown type has an unknown type hierarchy: com.sun.jna.platform.win32.Win32Exception */
                /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
                
                    if (r4 != 258) goto L13;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
                
                    throw new com.sun.jna.platform.win32.Win32Exception(r4);
                 */
                @Override // net.bytebuddy.agent.VirtualMachine.ForOpenJ9.Dispatcher
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void decrementSemaphore(java.io.File r2, java.lang.String r3, boolean r4, int r5) throws com.sun.jna.platform.win32.Win32Exception {
                    /*
                        r1 = this;
                        net.bytebuddy.agent.VirtualMachine$ForOpenJ9$Dispatcher$ForJnaWindowsEnvironment$AttachmentHandle r2 = r1.openSemaphore(r2, r3, r4)
                    L4:
                        int r3 = r5 + (-1)
                        if (r5 <= 0) goto L2f
                        com.sun.jna.platform.win32.Kernel32 r4 = com.sun.jna.platform.win32.Kernel32.INSTANCE     // Catch: java.lang.Throwable -> L27
                        com.sun.jna.platform.win32.WinNT$HANDLE r5 = r2.getHandle()     // Catch: java.lang.Throwable -> L27
                        r0 = 0
                        int r4 = r4.WaitForSingleObject(r5, r0)     // Catch: java.lang.Throwable -> L27
                        if (r4 == 0) goto L29
                        r5 = 128(0x80, float:1.8E-43)
                        if (r4 == r5) goto L29
                        r3 = 258(0x102, float:3.62E-43)
                        if (r4 != r3) goto L21
                        r2.close()
                        return
                    L21:
                        com.sun.jna.platform.win32.Win32Exception r3 = new com.sun.jna.platform.win32.Win32Exception     // Catch: java.lang.Throwable -> L27
                        r3.<init>(r4)     // Catch: java.lang.Throwable -> L27
                        throw r3     // Catch: java.lang.Throwable -> L27
                    L27:
                        r3 = move-exception
                        goto L2b
                    L29:
                        r5 = r3
                        goto L4
                    L2b:
                        r2.close()
                        throw r3
                    L2f:
                        r2.close()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.VirtualMachine.ForOpenJ9.Dispatcher.ForJnaWindowsEnvironment.decrementSemaphore(java.io.File, java.lang.String, boolean, int):void");
                }

                @Override // net.bytebuddy.agent.VirtualMachine.ForOpenJ9.Dispatcher
                public int getOwnerIdOf(File file) {
                    return 0;
                }

                /* JADX INFO: Thrown type has an unknown type hierarchy: com.sun.jna.platform.win32.Win32Exception */
                @Override // net.bytebuddy.agent.VirtualMachine.ForOpenJ9.Dispatcher
                public String getTemporaryFolder(String str) throws Win32Exception {
                    WinDef.DWORD dword = new WinDef.DWORD(260L);
                    char[] cArr = new char[dword.intValue()];
                    if (Kernel32.INSTANCE.GetTempPath(dword, cArr).intValue() != 0) {
                        return Native.toString(cArr);
                    }
                    throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                }

                /* JADX INFO: Thrown type has an unknown type hierarchy: com.sun.jna.platform.win32.Win32Exception */
                @Override // net.bytebuddy.agent.VirtualMachine.ForOpenJ9.Dispatcher
                public void incrementSemaphore(File file, String str, boolean z6, int i) throws Win32Exception {
                    AttachmentHandle attachmentHandleOpenSemaphore = openSemaphore(file, str, z6);
                    while (true) {
                        int i3 = i - 1;
                        if (i <= 0) {
                            return;
                        }
                        try {
                            if (!this.library.ReleaseSemaphore(attachmentHandleOpenSemaphore.getHandle(), 1L, null)) {
                                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                            }
                            i = i3;
                        } finally {
                            attachmentHandleOpenSemaphore.close();
                        }
                    }
                }

                /* JADX INFO: Thrown type has an unknown type hierarchy: com.sun.jna.platform.win32.Win32Exception */
                @Override // net.bytebuddy.agent.VirtualMachine.ForOpenJ9.Dispatcher
                public boolean isExistingProcess(int i) throws Win32Exception {
                    WinNT.HANDLE handleOpenProcess = Kernel32.INSTANCE.OpenProcess(1024, false, i);
                    if (handleOpenProcess == null) {
                        throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                    }
                    IntByReference intByReference = new IntByReference();
                    if (Kernel32.INSTANCE.GetExitCodeProcess(handleOpenProcess, intByReference)) {
                        return intByReference.getValue() == 259;
                    }
                    throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                }

                @Override // net.bytebuddy.agent.VirtualMachine.ForOpenJ9.Dispatcher
                public int pid() {
                    return Kernel32.INSTANCE.GetCurrentProcessId();
                }

                @Override // net.bytebuddy.agent.VirtualMachine.ForOpenJ9.Dispatcher
                public void setPermissions(File file, int i) {
                }

                @Override // net.bytebuddy.agent.VirtualMachine.ForOpenJ9.Dispatcher
                public int userId() {
                    return 0;
                }
            }

            void decrementSemaphore(File file, String str, boolean z6, int i);

            int getOwnerIdOf(File file);

            String getTemporaryFolder(String str);

            void incrementSemaphore(File file, String str, boolean z6, int i);

            boolean isExistingProcess(int i);

            int pid();

            void setPermissions(File file, int i);

            int userId();
        }

        public ForOpenJ9(Socket socket) {
            this.socket = socket;
        }

        public static VirtualMachine attach(String str) {
            return attach(str, 5000, Platform.isWindows() ? new Dispatcher.ForJnaWindowsEnvironment() : new Dispatcher.ForJnaPosixEnvironment(15, 100L, TimeUnit.MILLISECONDS));
        }

        private static byte[] read(Socket socket) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = socket.getInputStream().read(bArr);
                if (i == -1) {
                    break;
                }
                if (i > 0) {
                    int i3 = i - 1;
                    if (bArr[i3] == 0) {
                        byteArrayOutputStream.write(bArr, 0, i3);
                        break;
                    }
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
            return byteArrayOutputStream.toByteArray();
        }

        private static void write(Socket socket, byte[] bArr) throws IOException {
            socket.getOutputStream().write(bArr);
            socket.getOutputStream().write(0);
            socket.getOutputStream().flush();
        }

        @Override // net.bytebuddy.agent.VirtualMachine
        public void detach() throws IOException {
            try {
                write(this.socket, "ATTACH_DETACH".getBytes("UTF-8"));
                read(this.socket);
            } finally {
                this.socket.close();
            }
        }

        @Override // net.bytebuddy.agent.VirtualMachine
        public Properties getAgentProperties() throws IOException {
            write(this.socket, "ATTACH_GETAGENTPROPERTIES".getBytes("UTF-8"));
            Properties properties = new Properties();
            properties.load(new ByteArrayInputStream(read(this.socket)));
            return properties;
        }

        @Override // net.bytebuddy.agent.VirtualMachine
        public Properties getSystemProperties() throws IOException {
            write(this.socket, "ATTACH_GETSYSTEMPROPERTIES".getBytes("UTF-8"));
            Properties properties = new Properties();
            properties.load(new ByteArrayInputStream(read(this.socket)));
            return properties;
        }

        @Override // net.bytebuddy.agent.VirtualMachine
        public void loadAgent(String str, @MaybeNull String str2) throws IOException {
            Socket socket = this.socket;
            StringBuilder sb = new StringBuilder("ATTACH_LOADAGENT(instrument,");
            sb.append(str);
            sb.append(SignatureVisitor.INSTANCEOF);
            if (str2 == null) {
                str2 = "";
            }
            sb.append(str2);
            sb.append(')');
            write(socket, sb.toString().getBytes("UTF-8"));
            String str3 = new String(read(this.socket), "UTF-8");
            if (str3.startsWith("ATTACH_ERR")) {
                throw new IllegalStateException("Target VM failed loading agent: ".concat(str3));
            }
            if (!str3.startsWith("ATTACH_ACK") && !str3.startsWith("ATTACH_RESULT=")) {
                throw new IllegalStateException("Unexpected response: ".concat(str3));
            }
        }

        @Override // net.bytebuddy.agent.VirtualMachine
        public void loadAgentLibrary(String str, @MaybeNull String str2) throws IOException {
            Socket socket = this.socket;
            StringBuilder sb = new StringBuilder("ATTACH_LOADAGENTLIBRARY(");
            sb.append(str);
            sb.append(str2 == null ? "" : ",".concat(str2));
            sb.append(')');
            write(socket, sb.toString().getBytes("UTF-8"));
            String str3 = new String(read(this.socket), "UTF-8");
            if (str3.startsWith("ATTACH_ERR")) {
                throw new IllegalStateException("Target VM failed loading native library: ".concat(str3));
            }
            if (!str3.startsWith("ATTACH_ACK") && !str3.startsWith("ATTACH_RESULT=")) {
                throw new IllegalStateException("Unexpected response: ".concat(str3));
            }
        }

        @Override // net.bytebuddy.agent.VirtualMachine
        public void loadAgentPath(String str, @MaybeNull String str2) throws IOException {
            Socket socket = this.socket;
            StringBuilder sb = new StringBuilder("ATTACH_LOADAGENTPATH(");
            sb.append(str);
            sb.append(str2 == null ? "" : ",".concat(str2));
            sb.append(')');
            write(socket, sb.toString().getBytes("UTF-8"));
            String str3 = new String(read(this.socket), "UTF-8");
            if (str3.startsWith("ATTACH_ERR")) {
                throw new IllegalStateException("Target VM failed loading native agent: ".concat(str3));
            }
            if (!str3.startsWith("ATTACH_ACK") && !str3.startsWith("ATTACH_RESULT=")) {
                throw new IllegalStateException("Unexpected response: ".concat(str3));
            }
        }

        @Override // net.bytebuddy.agent.VirtualMachine
        public String startLocalManagementAgent() throws IOException {
            write(this.socket, "ATTACH_START_LOCAL_MANAGEMENT_AGENT".getBytes("UTF-8"));
            String str = new String(read(this.socket), "UTF-8");
            if (str.startsWith("ATTACH_ERR")) {
                throw new IllegalStateException("Target VM could not start management agent: ".concat(str));
            }
            if (str.startsWith("ATTACH_ACK")) {
                return str.substring(10);
            }
            if (str.startsWith("ATTACH_RESULT=")) {
                return str.substring(14);
            }
            throw new IllegalStateException("Unexpected response: ".concat(str));
        }

        @Override // net.bytebuddy.agent.VirtualMachine
        public void startManagementAgent(Properties properties) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            properties.store(byteArrayOutputStream, (String) null);
            write(this.socket, "ATTACH_START_MANAGEMENT_AGENT".getBytes("UTF-8"));
            write(this.socket, byteArrayOutputStream.toByteArray());
            String str = new String(read(this.socket), "UTF-8");
            if (str.startsWith("ATTACH_ERR")) {
                throw new IllegalStateException("Target VM could not start management agent: ".concat(str));
            }
            if (!str.startsWith("ATTACH_ACK") && !str.startsWith("ATTACH_RESULT=")) {
                throw new IllegalStateException("Unexpected response: ".concat(str));
            }
        }

        /* JADX WARN: Finally extract failed */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0108  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static net.bytebuddy.agent.VirtualMachine attach(java.lang.String r24, int r25, net.bytebuddy.agent.VirtualMachine.ForOpenJ9.Dispatcher r26) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 912
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.VirtualMachine.ForOpenJ9.attach(java.lang.String, int, net.bytebuddy.agent.VirtualMachine$ForOpenJ9$Dispatcher):net.bytebuddy.agent.VirtualMachine");
        }
    }

    public enum Resolver implements PrivilegedAction<Class<? extends VirtualMachine>> {
        INSTANCE;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.security.PrivilegedAction
        public Class<? extends VirtualMachine> run() {
            try {
                Class.forName("com.sun.jna.Platform");
                return System.getProperty("java.vm.name", "").toUpperCase(Locale.US).contains("J9") ? ForOpenJ9.class : ForHotSpot.class;
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Optional JNA dependency is not available", e);
            }
        }
    }

    void detach();

    Properties getAgentProperties();

    Properties getSystemProperties();

    void loadAgent(String str);

    void loadAgent(String str, @MaybeNull String str2);

    void loadAgentLibrary(String str);

    void loadAgentLibrary(String str, @MaybeNull String str2);

    void loadAgentPath(String str);

    void loadAgentPath(String str, @MaybeNull String str2);

    String startLocalManagementAgent();

    void startManagementAgent(Properties properties);

    public static class ForHotSpot extends AbstractBase {
        private static final String ARGUMENT_DELIMITER = "=";
        private static final String INSTRUMENT_COMMAND = "instrument";
        private static final String LOAD_COMMAND = "load";
        private static final String PROTOCOL_VERSION = "1";
        private final Connection connection;

        public interface Connection extends Closeable {

            public interface Factory {

                public static abstract class ForSocketFile implements Factory {
                    private static final String ATTACH_FILE_PREFIX = ".attach_pid";
                    private static final String SOCKET_FILE_PREFIX = ".java_pid";
                    private final int attempts;
                    private final long pause;
                    private final String temporaryDirectory;
                    private final TimeUnit timeUnit;

                    public ForSocketFile(String str, int i, long j6, TimeUnit timeUnit) {
                        this.temporaryDirectory = str;
                        this.attempts = i;
                        this.pause = j6;
                        this.timeUnit = timeUnit;
                    }

                    @Override // net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.Factory
                    @SuppressFBWarnings(justification = "File name convention is specified.", value = {"DMI_HARDCODED_ABSOLUTE_FILENAME"})
                    public Connection connect(String str) {
                        File file = new File(this.temporaryDirectory, a.p(SOCKET_FILE_PREFIX, str));
                        if (!file.exists()) {
                            String strP = a.p(ATTACH_FILE_PREFIX, str);
                            File file2 = new File(a.r("/proc/", str, "/cwd/", strP));
                            try {
                                if (!file2.createNewFile() && !file2.isFile()) {
                                    throw new IllegalStateException("Could not create attach file: " + file2);
                                }
                            } catch (IOException unused) {
                                file2 = new File(this.temporaryDirectory, strP);
                                if (!file2.createNewFile() && !file2.isFile()) {
                                    throw new IllegalStateException("Could not create attach file: " + file2);
                                }
                            }
                            try {
                                try {
                                    kill(str, 3);
                                    int i = this.attempts;
                                    while (!file.exists()) {
                                        int i3 = i - 1;
                                        if (i <= 0) {
                                            break;
                                        }
                                        this.timeUnit.sleep(this.pause);
                                        i = i3;
                                    }
                                    if (!file.exists()) {
                                        throw new IllegalStateException("Target VM did not respond: " + str);
                                    }
                                    if (!file2.delete()) {
                                        file2.deleteOnExit();
                                    }
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                    throw new IllegalStateException(e);
                                }
                            } catch (Throwable th) {
                                if (!file2.delete()) {
                                    file2.deleteOnExit();
                                }
                                throw th;
                            }
                        }
                        return doConnect(file);
                    }

                    public abstract Connection doConnect(File file);

                    public abstract void kill(String str, int i);
                }

                Connection connect(String str);
            }

            public static class ForJnaPosixSocket extends OnPersistentByteChannel<Integer> {
                private final PosixLibrary library;
                private final File socket;

                public static class Factory extends Factory.ForSocketFile {
                    private final PosixLibrary library;

                    public interface MacLibrary extends Library {
                        public static final int CS_DARWIN_USER_TEMP_DIR = 65537;

                        long confstr(int i, Pointer pointer, long j6);
                    }

                    public Factory(String str, int i, long j6, TimeUnit timeUnit) {
                        super(str, i, j6, timeUnit);
                        this.library = (PosixLibrary) Native.loadLibrary("c", PosixLibrary.class);
                    }

                    public static Factory withDefaultTemporaryFolder(int i, long j6, TimeUnit timeUnit) {
                        String string = "/tmp";
                        if (Platform.isMac()) {
                            MacLibrary macLibrary = (MacLibrary) Native.loadLibrary("c", MacLibrary.class);
                            Memory memory = new Memory(4096L);
                            long jConfstr = macLibrary.confstr(65537, memory, memory.size());
                            if (jConfstr != 0 && jConfstr <= 4096) {
                                string = memory.getString(0L);
                            }
                        }
                        return new Factory(string, i, j6, timeUnit);
                    }

                    @Override // net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.Factory.ForSocketFile
                    public Connection doConnect(File file) {
                        return new ForJnaPosixSocket(this.library, file);
                    }

                    @Override // net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.Factory.ForSocketFile
                    public void kill(String str, int i) {
                        this.library.kill(Integer.parseInt(str), i);
                    }
                }

                public interface PosixLibrary extends Library {

                    public static class SocketAddress extends Structure {

                        @SuppressFBWarnings(justification = "Field required by native implementation.", value = {"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
                        public short family = 1;
                        public byte[] path = new byte[100];

                        public List<String> getFieldOrder() {
                            return Arrays.asList("family", "path");
                        }

                        public void setPath(String str) {
                            try {
                                System.arraycopy(str.getBytes("UTF-8"), 0, this.path, 0, str.length());
                                System.arraycopy(new byte[]{0}, 0, this.path, str.length(), 1);
                            } catch (UnsupportedEncodingException e) {
                                throw new IllegalStateException(e);
                            }
                        }
                    }

                    int close(int i);

                    int connect(int i, SocketAddress socketAddress, int i3);

                    int kill(int i, int i3);

                    int read(int i, ByteBuffer byteBuffer, int i3);

                    int socket(int i, int i3, int i4);

                    int write(int i, ByteBuffer byteBuffer, int i3);
                }

                public ForJnaPosixSocket(PosixLibrary posixLibrary, File file) {
                    this.library = posixLibrary;
                    this.socket = file;
                }

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }

                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v1, types: [int] */
                /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Integer] */
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
                @Override // net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.OnPersistentByteChannel
                public Integer connect() {
                    int iSocket = this.library.socket(1, 1, 0);
                    try {
                        PosixLibrary.SocketAddress socketAddress = new PosixLibrary.SocketAddress();
                        socketAddress.setPath(this.socket.getAbsolutePath());
                        this.library.connect(iSocket, socketAddress, socketAddress.size());
                        iSocket = Integer.valueOf((int) iSocket);
                        return iSocket;
                    } catch (RuntimeException e) {
                        this.library.close(iSocket);
                        throw e;
                    }
                }

                @Override // net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.OnPersistentByteChannel
                public int read(Integer num, byte[] bArr) {
                    int i = this.library.read(num.intValue(), ByteBuffer.wrap(bArr), bArr.length);
                    if (i == 0) {
                        return -1;
                    }
                    return i;
                }

                @Override // net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.OnPersistentByteChannel
                public void write(Integer num, byte[] bArr) {
                    this.library.write(num.intValue(), ByteBuffer.wrap(bArr), bArr.length);
                }

                @Override // net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.OnPersistentByteChannel
                public void close(Integer num) {
                    this.library.close(num.intValue());
                }
            }

            public static class ForJnaSolarisDoor implements Connection {
                private final SolarisLibrary library;
                private final File socket;

                public static class Factory extends Factory.ForSocketFile {
                    private final SolarisLibrary library;

                    public Factory(int i, long j6, TimeUnit timeUnit) {
                        super("/tmp", i, j6, timeUnit);
                        this.library = (SolarisLibrary) Native.loadLibrary("c", SolarisLibrary.class);
                    }

                    @Override // net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.Factory.ForSocketFile
                    public Connection doConnect(File file) {
                        return new ForJnaSolarisDoor(this.library, file);
                    }

                    @Override // net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.Factory.ForSocketFile
                    public void kill(String str, int i) {
                        this.library.kill(Integer.parseInt(str), i);
                    }
                }

                public static class Response implements Response {
                    private final int handle;
                    private final SolarisLibrary library;

                    public Response(SolarisLibrary solarisLibrary, int i) {
                        this.library = solarisLibrary;
                        this.handle = i;
                    }

                    @Override // java.io.Closeable, java.lang.AutoCloseable
                    public void close() {
                        this.library.close(this.handle);
                    }

                    @Override // net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.Response
                    public int read(byte[] bArr) {
                        int i = this.library.read(this.handle, ByteBuffer.wrap(bArr), bArr.length);
                        if (i == 0) {
                            return -1;
                        }
                        return i;
                    }
                }

                public interface SolarisLibrary extends Library {

                    public static class DoorArgument extends Structure {

                        @MaybeNull
                        public Pointer dataPointer;
                        public int dataSize;
                        public int descriptorCount;

                        @MaybeNull
                        public Pointer descriptorPointer;

                        @UnknownNull
                        public Pointer resultPointer;
                        public int resultSize;

                        public List<String> getFieldOrder() {
                            return Arrays.asList("dataPointer", "dataSize", "descriptorPointer", "descriptorCount", "resultPointer", "resultSize");
                        }
                    }

                    int close(int i);

                    int door_call(int i, DoorArgument doorArgument);

                    int kill(int i, int i3);

                    int open(String str, int i);

                    int read(int i, ByteBuffer byteBuffer, int i3);
                }

                public ForJnaSolarisDoor(SolarisLibrary solarisLibrary, File file) {
                    this.library = solarisLibrary;
                    this.socket = file;
                }

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }

                @Override // net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection
                @SuppressFBWarnings(justification = "This pattern is required for use of JNA.", value = {"UWF_UNWRITTEN_PUBLIC_OR_PROTECTED_FIELD", "URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
                public Response execute(String str, String... strArr) {
                    Pointer pointer;
                    int iOpen = this.library.open(this.socket.getAbsolutePath(), 2);
                    try {
                        SolarisLibrary.DoorArgument doorArgument = new SolarisLibrary.DoorArgument();
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            byteArrayOutputStream.write(str.getBytes("UTF-8"));
                            byteArrayOutputStream.write(0);
                            for (String str2 : strArr) {
                                if (str2 != null) {
                                    byteArrayOutputStream.write(str2.getBytes("UTF-8"));
                                }
                                byteArrayOutputStream.write(0);
                            }
                            doorArgument.dataSize = byteArrayOutputStream.size();
                            Memory memory = new Memory(byteArrayOutputStream.size());
                            memory.write(0L, byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                            doorArgument.dataPointer = memory;
                            Memory memory2 = new Memory(128L);
                            doorArgument.resultPointer = memory2;
                            doorArgument.resultSize = (int) memory2.size();
                            if (this.library.door_call(iOpen, doorArgument) != 0) {
                                throw new IllegalStateException("Door call to target VM failed");
                            }
                            if (doorArgument.resultSize < 4 || doorArgument.resultPointer.getInt(0L) != 0) {
                                throw new IllegalStateException("Target VM could not execute door call");
                            }
                            if (doorArgument.descriptorCount != 1 || (pointer = doorArgument.descriptorPointer) == null) {
                                throw new IllegalStateException("Did not receive communication descriptor from target VM");
                            }
                            return new Response(this.library, pointer.getInt(4L));
                        } catch (Throwable th) {
                            throw th;
                        }
                    } finally {
                        this.library.close(iOpen);
                    }
                }
            }

            public static class ForJnaWindowsNamedPipe implements Connection {
                private static final int MEM_RELEASE = 32768;
                private final WindowsAttachLibrary attachLibrary;
                private final WinDef.LPVOID code;
                private final WindowsLibrary library;
                private final WinNT.HANDLE process;
                private final SecureRandom random = new SecureRandom();

                public static class Factory implements Factory {
                    public static final String LIBRARY_NAME = "net.bytebuddy.library.name";
                    private final WindowsLibrary library = (WindowsLibrary) Native.loadLibrary("kernel32", WindowsLibrary.class, W32APIOptions.DEFAULT_OPTIONS);
                    private final WindowsAttachLibrary attachLibrary = (WindowsAttachLibrary) Native.loadLibrary(System.getProperty(LIBRARY_NAME, "attach_hotspot_windows"), WindowsAttachLibrary.class);

                    /* JADX INFO: Thrown type has an unknown type hierarchy: com.sun.jna.platform.win32.Win32Exception */
                    @Override // net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.Factory
                    public Connection connect(String str) throws Win32Exception {
                        WinNT.HANDLE handleOpenProcess = Kernel32.INSTANCE.OpenProcess(2039803, false, Integer.parseInt(str));
                        if (handleOpenProcess == null) {
                            throw new Win32Exception(Native.getLastError());
                        }
                        try {
                            WinDef.LPVOID lpvoidAllocate_remote_code = this.attachLibrary.allocate_remote_code(handleOpenProcess);
                            if (lpvoidAllocate_remote_code != null) {
                                return new ForJnaWindowsNamedPipe(this.library, this.attachLibrary, handleOpenProcess, lpvoidAllocate_remote_code);
                            }
                            throw new Win32Exception(Native.getLastError());
                        } catch (Throwable th) {
                            if (!Kernel32.INSTANCE.CloseHandle(handleOpenProcess)) {
                                throw new Win32Exception(Native.getLastError());
                            }
                            if (th instanceof RuntimeException) {
                                throw th;
                            }
                            throw new IllegalStateException(th);
                        }
                    }
                }

                public static class NamedPipeResponse implements Response {
                    private final WinNT.HANDLE pipe;

                    public NamedPipeResponse(WinNT.HANDLE handle) {
                        this.pipe = handle;
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: com.sun.jna.platform.win32.Win32Exception */
                    @Override // java.io.Closeable, java.lang.AutoCloseable
                    public void close() throws Win32Exception {
                        try {
                            if (!Kernel32.INSTANCE.DisconnectNamedPipe(this.pipe)) {
                                throw new Win32Exception(Native.getLastError());
                            }
                            if (!Kernel32.INSTANCE.CloseHandle(this.pipe)) {
                                throw new Win32Exception(Native.getLastError());
                            }
                        } catch (Throwable th) {
                            if (!Kernel32.INSTANCE.CloseHandle(this.pipe)) {
                                throw new Win32Exception(Native.getLastError());
                            }
                            throw th;
                        }
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: com.sun.jna.platform.win32.Win32Exception */
                    @Override // net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.Response
                    public int read(byte[] bArr) throws Win32Exception {
                        IntByReference intByReference = new IntByReference();
                        if (Kernel32.INSTANCE.ReadFile(this.pipe, bArr, bArr.length, intByReference, (WinBase.OVERLAPPED) null)) {
                            return intByReference.getValue();
                        }
                        int lastError = Native.getLastError();
                        if (lastError == 109) {
                            return -1;
                        }
                        throw new Win32Exception(lastError);
                    }
                }

                public interface WindowsAttachLibrary extends StdCallLibrary {
                    @MaybeNull
                    WinDef.LPVOID allocate_remote_argument(WinNT.HANDLE handle, String str, @MaybeNull String str2, @MaybeNull String str3, @MaybeNull String str4, @MaybeNull String str5);

                    @MaybeNull
                    WinDef.LPVOID allocate_remote_code(WinNT.HANDLE handle);
                }

                public interface WindowsLibrary extends StdCallLibrary {
                    @MaybeNull
                    WinNT.HANDLE CreateRemoteThread(WinNT.HANDLE handle, @MaybeNull WinBase.SECURITY_ATTRIBUTES security_attributes, int i, Pointer pointer, Pointer pointer2, @MaybeNull WinDef.DWORD dword, @MaybeNull Pointer pointer3);

                    boolean GetExitCodeThread(WinNT.HANDLE handle, IntByReference intByReference);

                    Pointer VirtualAllocEx(WinNT.HANDLE handle, Pointer pointer, int i, int i3, int i4);

                    boolean VirtualFreeEx(WinNT.HANDLE handle, Pointer pointer, int i, int i3);
                }

                public ForJnaWindowsNamedPipe(WindowsLibrary windowsLibrary, WindowsAttachLibrary windowsAttachLibrary, WinNT.HANDLE handle, WinDef.LPVOID lpvoid) {
                    this.library = windowsLibrary;
                    this.attachLibrary = windowsAttachLibrary;
                    this.process = handle;
                    this.code = lpvoid;
                }

                /* JADX INFO: Thrown type has an unknown type hierarchy: com.sun.jna.platform.win32.Win32Exception */
                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() throws Win32Exception {
                    try {
                        if (!this.library.VirtualFreeEx(this.process, this.code.getPointer(), 0, 32768)) {
                            throw new Win32Exception(Native.getLastError());
                        }
                        if (!Kernel32.INSTANCE.CloseHandle(this.process)) {
                            throw new Win32Exception(Native.getLastError());
                        }
                    } catch (Throwable th) {
                        if (!Kernel32.INSTANCE.CloseHandle(this.process)) {
                            throw new Win32Exception(Native.getLastError());
                        }
                        throw th;
                    }
                }

                /* JADX INFO: Thrown type has an unknown type hierarchy: com.sun.jna.platform.win32.Win32Exception */
                @Override // net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection
                public Response execute(String str, String... strArr) throws Win32Exception {
                    int lastError;
                    if (!ForHotSpot.PROTOCOL_VERSION.equals(str)) {
                        throw new IllegalArgumentException(a.p("Unknown protocol version: ", str));
                    }
                    if (strArr.length > 4) {
                        throw new IllegalArgumentException("Cannot supply more then four arguments to Windows attach mechanism: " + Arrays.asList(strArr));
                    }
                    String str2 = "\\\\.\\pipe\\javatool" + Math.abs(this.random.nextInt() + 1);
                    WinNT.HANDLE handleCreateNamedPipe = Kernel32.INSTANCE.CreateNamedPipe(str2, 1, 0, 1, 4096, 8192, 0, (WinBase.SECURITY_ATTRIBUTES) null);
                    if (handleCreateNamedPipe == null) {
                        throw new Win32Exception(Native.getLastError());
                    }
                    try {
                        WinDef.LPVOID lpvoidAllocate_remote_argument = this.attachLibrary.allocate_remote_argument(this.process, str2, strArr.length < 1 ? null : strArr[0], strArr.length < 2 ? null : strArr[1], strArr.length < 3 ? null : strArr[2], strArr.length < 4 ? null : strArr[3]);
                        if (lpvoidAllocate_remote_argument == null) {
                            throw new Win32Exception(Native.getLastError());
                        }
                        try {
                            WinNT.HANDLE handleCreateRemoteThread = this.library.CreateRemoteThread(this.process, null, 0, this.code.getPointer(), lpvoidAllocate_remote_argument.getPointer(), null, null);
                            if (handleCreateRemoteThread == null) {
                                throw new Win32Exception(Native.getLastError());
                            }
                            try {
                                int iWaitForSingleObject = Kernel32.INSTANCE.WaitForSingleObject(handleCreateRemoteThread, -1);
                                if (iWaitForSingleObject != 0) {
                                    throw new Win32Exception(iWaitForSingleObject);
                                }
                                IntByReference intByReference = new IntByReference();
                                if (!this.library.GetExitCodeThread(handleCreateRemoteThread, intByReference)) {
                                    throw new Win32Exception(Native.getLastError());
                                }
                                if (intByReference.getValue() != 0) {
                                    throw new IllegalStateException("Target VM could not dispatch command successfully: " + intByReference.getValue());
                                }
                                if (!Kernel32.INSTANCE.ConnectNamedPipe(handleCreateNamedPipe, (WinBase.OVERLAPPED) null) && (lastError = Native.getLastError()) != 535) {
                                    throw new Win32Exception(lastError);
                                }
                                NamedPipeResponse namedPipeResponse = new NamedPipeResponse(handleCreateNamedPipe);
                                if (!Kernel32.INSTANCE.CloseHandle(handleCreateRemoteThread)) {
                                    throw new Win32Exception(Native.getLastError());
                                }
                                if (this.library.VirtualFreeEx(this.process, lpvoidAllocate_remote_argument.getPointer(), 0, 32768)) {
                                    return namedPipeResponse;
                                }
                                throw new Win32Exception(Native.getLastError());
                            } catch (Throwable th) {
                                if (Kernel32.INSTANCE.CloseHandle(handleCreateRemoteThread)) {
                                    throw th;
                                }
                                throw new Win32Exception(Native.getLastError());
                            }
                        } catch (Throwable th2) {
                            if (this.library.VirtualFreeEx(this.process, lpvoidAllocate_remote_argument.getPointer(), 0, 32768)) {
                                throw th2;
                            }
                            throw new Win32Exception(Native.getLastError());
                        }
                    } catch (Throwable th3) {
                        if (!Kernel32.INSTANCE.CloseHandle(handleCreateNamedPipe)) {
                            throw new Win32Exception(Native.getLastError());
                        }
                        if (th3 instanceof RuntimeException) {
                            throw th3;
                        }
                        throw new IllegalStateException(th3);
                    }
                }
            }

            public static abstract class OnPersistentByteChannel<T> implements Connection {
                private static final byte[] BLANK = {0};

                public class Response implements Response {
                    private final T connection;

                    @Override // java.io.Closeable, java.lang.AutoCloseable
                    public void close() {
                        OnPersistentByteChannel.this.close(this.connection);
                    }

                    @Override // net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.Response
                    public int read(byte[] bArr) {
                        return OnPersistentByteChannel.this.read(this.connection, bArr);
                    }

                    private Response(T t6) {
                        this.connection = t6;
                    }
                }

                public abstract void close(T t6);

                public abstract T connect();

                @Override // net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection
                public Response execute(String str, String... strArr) throws IOException {
                    T tConnect = connect();
                    try {
                        write(tConnect, str.getBytes("UTF-8"));
                        write(tConnect, BLANK);
                        for (String str2 : strArr) {
                            if (str2 != null) {
                                write(tConnect, str2.getBytes("UTF-8"));
                            }
                            write(tConnect, BLANK);
                        }
                        return new Response(tConnect);
                    } catch (Throwable th) {
                        close(tConnect);
                        if (th instanceof RuntimeException) {
                            throw ((RuntimeException) th);
                        }
                        if (th instanceof IOException) {
                            throw ((IOException) th);
                        }
                        throw new IllegalStateException(th);
                    }
                }

                public abstract int read(T t6, byte[] bArr);

                public abstract void write(T t6, byte[] bArr);
            }

            public interface Response extends Closeable {
                int read(byte[] bArr);
            }

            Response execute(String str, String... strArr);
        }

        public ForHotSpot(Connection connection) {
            this.connection = connection;
        }

        public static VirtualMachine attach(String str) {
            return Platform.isWindows() ? attach(str, new Connection.ForJnaWindowsNamedPipe.Factory()) : Platform.isSolaris() ? attach(str, new Connection.ForJnaSolarisDoor.Factory(15, 100L, TimeUnit.MILLISECONDS)) : attach(str, Connection.ForJnaPosixSocket.Factory.withDefaultTemporaryFolder(15, 100L, TimeUnit.MILLISECONDS));
        }

        private static void checkHeader(Connection.Response response) throws IOException {
            byte[] bArr = new byte[1];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int i = response.read(bArr);
                if (i == -1) {
                    break;
                }
                if (i > 0) {
                    byte b = bArr[0];
                    if (b == 10) {
                        break;
                    } else {
                        byteArrayOutputStream.write(b);
                    }
                }
            }
            int i3 = Integer.parseInt(byteArrayOutputStream.toString("UTF-8"));
            if (i3 == 0) {
                return;
            }
            if (i3 == 101) {
                throw new IOException("Protocol mismatch with target VM");
            }
            byte[] bArr2 = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            while (true) {
                int i4 = response.read(bArr2);
                if (i4 == -1) {
                    throw new IllegalStateException(byteArrayOutputStream2.toString("UTF-8"));
                }
                byteArrayOutputStream2.write(bArr2, 0, i4);
            }
        }

        private Properties getProperties(String str) throws IOException {
            Connection.Response responseExecute = this.connection.execute(PROTOCOL_VERSION, str, null, null, null);
            try {
                checkHeader(responseExecute);
                byte[] bArr = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int i = responseExecute.read(bArr);
                    if (i == -1) {
                        Properties properties = new Properties();
                        properties.load(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                        responseExecute.close();
                        return properties;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                }
            } catch (Throwable th) {
                responseExecute.close();
                throw th;
            }
        }

        @Override // net.bytebuddy.agent.VirtualMachine
        public void detach() throws IOException {
            this.connection.close();
        }

        @Override // net.bytebuddy.agent.VirtualMachine
        public Properties getAgentProperties() {
            return getProperties("agentProperties");
        }

        @Override // net.bytebuddy.agent.VirtualMachine
        public Properties getSystemProperties() {
            return getProperties("properties");
        }

        public void load(String str, boolean z6, @MaybeNull String str2) throws IOException {
            Connection connection = this.connection;
            String string = Boolean.toString(z6);
            if (str2 != null) {
                str = b.f(str, ARGUMENT_DELIMITER, str2);
            }
            Connection.Response responseExecute = connection.execute(PROTOCOL_VERSION, LOAD_COMMAND, INSTRUMENT_COMMAND, string, str);
            try {
                checkHeader(responseExecute);
            } finally {
                responseExecute.close();
            }
        }

        @Override // net.bytebuddy.agent.VirtualMachine
        public void loadAgent(String str, @MaybeNull String str2) throws IOException {
            load(str, false, str2);
        }

        @Override // net.bytebuddy.agent.VirtualMachine
        public void loadAgentLibrary(String str, @MaybeNull String str2) throws IOException {
            load(str, false, str2);
        }

        @Override // net.bytebuddy.agent.VirtualMachine
        public void loadAgentPath(String str, @MaybeNull String str2) throws IOException {
            load(str, true, str2);
        }

        @Override // net.bytebuddy.agent.VirtualMachine
        public String startLocalManagementAgent() throws IOException {
            Connection.Response responseExecute = this.connection.execute(PROTOCOL_VERSION, "jcmd", "ManagementAgent.start_local", null, null);
            try {
                checkHeader(responseExecute);
                return getAgentProperties().getProperty("com.sun.management.jmxremote.localConnectorAddress");
            } finally {
                responseExecute.close();
            }
        }

        @Override // net.bytebuddy.agent.VirtualMachine
        public void startManagementAgent(Properties properties) throws IOException {
            StringBuilder sb = new StringBuilder("ManagementAgent.start ");
            boolean z6 = true;
            for (Map.Entry entry : properties.entrySet()) {
                if (!(entry.getKey() instanceof String) || !((String) entry.getKey()).startsWith("com.sun.management.")) {
                    throw new IllegalArgumentException("Illegal property name: " + entry.getKey());
                }
                if (z6) {
                    z6 = false;
                } else {
                    sb.append(' ');
                }
                sb.append(((String) entry.getKey()).substring(19));
                sb.append(SignatureVisitor.INSTANCEOF);
                String string = entry.getValue().toString();
                if (string.contains(" ")) {
                    sb.append('\'');
                    sb.append(string);
                    sb.append('\'');
                } else {
                    sb.append(string);
                }
            }
            Connection.Response responseExecute = this.connection.execute(PROTOCOL_VERSION, "jcmd", sb.toString(), null, null);
            try {
                checkHeader(responseExecute);
            } finally {
                responseExecute.close();
            }
        }

        public static VirtualMachine attach(String str, Connection.Factory factory) {
            return new ForHotSpot(factory.connect(str));
        }
    }
}
