package org.mockito.internal.creation;

import androidx.constraintlayout.core.motion.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.mockito.MockSettings;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.creation.settings.CreationSettings;
import org.mockito.internal.debugging.VerboseMockInvocationLogger;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.util.Checks;
import org.mockito.internal.util.MockCreationValidator;
import org.mockito.internal.util.MockNameImpl;
import org.mockito.internal.util.collections.Sets;
import org.mockito.listeners.InvocationListener;
import org.mockito.listeners.StubbingLookupListener;
import org.mockito.listeners.VerificationStartedListener;
import org.mockito.mock.MockCreationSettings;
import org.mockito.mock.MockName;
import org.mockito.mock.SerializableMode;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.Answer;

/* JADX INFO: loaded from: classes.dex */
public class MockSettingsImpl<T> extends CreationSettings<T> implements MockSettings, MockCreationSettings<T> {
    private static final long serialVersionUID = 4475297236197939569L;
    private Object[] constructorArgs;
    private Object outerClassInstance;
    private boolean useConstructor;

    public static <T> void addListeners(T[] tArr, List<T> list, String str) {
        if (tArr == null) {
            throw Reporter.methodDoesNotAcceptParameter(str, "null vararg array.");
        }
        if (tArr.length == 0) {
            throw Reporter.requiresAtLeastOneListener(str);
        }
        for (T t6 : tArr) {
            if (t6 == null) {
                throw Reporter.methodDoesNotAcceptParameter(str, "null listeners.");
            }
            list.add(t6);
        }
    }

    private boolean invocationListenersContainsType(Class<?> cls) {
        Iterator<InvocationListener> it = this.invocationListeners.iterator();
        while (it.hasNext()) {
            if (it.next().getClass().equals(cls)) {
                return true;
            }
        }
        return false;
    }

    private static Set<Class<?>> prepareExtraInterfaces(CreationSettings creationSettings) {
        HashSet hashSet = new HashSet(creationSettings.getExtraInterfaces());
        if (creationSettings.isSerializable()) {
            hashSet.add(Serializable.class);
        }
        return hashSet;
    }

    private static <T> CreationSettings<T> validatedSettings(Class<T> cls, CreationSettings<T> creationSettings) {
        MockCreationValidator mockCreationValidator = new MockCreationValidator();
        mockCreationValidator.validateType(cls, creationSettings.getMockMaker());
        mockCreationValidator.validateExtraInterfaces(cls, creationSettings.getExtraInterfaces());
        mockCreationValidator.validateMockedType(cls, creationSettings.getSpiedInstance());
        mockCreationValidator.validateConstructorUse(creationSettings.isUsingConstructor(), creationSettings.getSerializableMode());
        CreationSettings<T> creationSettings2 = new CreationSettings<>(creationSettings);
        creationSettings2.setMockName(new MockNameImpl(creationSettings.getName(), cls, false));
        creationSettings2.setTypeToMock(cls);
        creationSettings2.setExtraInterfaces(prepareExtraInterfaces(creationSettings));
        return creationSettings2;
    }

    private static <T> CreationSettings<T> validatedStaticSettings(Class<T> cls, CreationSettings<T> creationSettings) {
        if (cls.isPrimitive()) {
            throw new MockitoException(a.j(cls, "Cannot create static mock of primitive type "));
        }
        if (!creationSettings.getExtraInterfaces().isEmpty()) {
            throw new MockitoException(a.j(cls, "Cannot specify additional interfaces for static mock of "));
        }
        if (creationSettings.getSpiedInstance() != null) {
            throw new MockitoException(a.j(cls, "Cannot specify spied instance for static mock of "));
        }
        CreationSettings<T> creationSettings2 = new CreationSettings<>(creationSettings);
        creationSettings2.setMockName(new MockNameImpl(creationSettings.getName(), cls, true));
        creationSettings2.setTypeToMock(cls);
        return creationSettings2;
    }

    @Override // org.mockito.MockSettings
    public <T2> MockCreationSettings<T2> build(Class<T2> cls) {
        return validatedSettings(cls, this);
    }

    @Override // org.mockito.MockSettings
    public <T2> MockCreationSettings<T2> buildStatic(Class<T2> cls) {
        return validatedStaticSettings(cls, this);
    }

    @Override // org.mockito.MockSettings
    public MockSettings defaultAnswer(Answer answer) {
        this.defaultAnswer = answer;
        if (answer != null) {
            return this;
        }
        throw Reporter.defaultAnswerDoesNotAcceptNullParameter();
    }

    @Override // org.mockito.MockSettings
    public MockSettings extraInterfaces(Class<?>... clsArr) {
        if (clsArr == null || clsArr.length == 0) {
            throw Reporter.extraInterfacesRequiresAtLeastOneInterface();
        }
        for (Class<?> cls : clsArr) {
            if (cls == null) {
                throw Reporter.extraInterfacesDoesNotAcceptNullParameters();
            }
            if (!cls.isInterface()) {
                throw Reporter.extraInterfacesAcceptsOnlyInterfaces(cls);
            }
        }
        this.extraInterfaces = Sets.newSet(clsArr);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.mockito.internal.creation.settings.CreationSettings, org.mockito.mock.MockCreationSettings
    public Object[] getConstructorArgs() {
        if (this.outerClassInstance == null) {
            return this.constructorArgs;
        }
        ArrayList arrayList = new ArrayList(this.constructorArgs.length + 1);
        arrayList.add(this.outerClassInstance);
        arrayList.addAll(Arrays.asList(this.constructorArgs));
        return arrayList.toArray(new Object[this.constructorArgs.length + 1]);
    }

    @Override // org.mockito.internal.creation.settings.CreationSettings, org.mockito.mock.MockCreationSettings
    public Answer<Object> getDefaultAnswer() {
        return this.defaultAnswer;
    }

    @Override // org.mockito.internal.creation.settings.CreationSettings, org.mockito.mock.MockCreationSettings
    public Set<Class<?>> getExtraInterfaces() {
        return this.extraInterfaces;
    }

    @Override // org.mockito.internal.creation.settings.CreationSettings, org.mockito.mock.MockCreationSettings
    public MockName getMockName() {
        return this.mockName;
    }

    @Override // org.mockito.internal.creation.settings.CreationSettings, org.mockito.mock.MockCreationSettings
    public Object getOuterClassInstance() {
        return this.outerClassInstance;
    }

    @Override // org.mockito.internal.creation.settings.CreationSettings, org.mockito.mock.MockCreationSettings
    public Object getSpiedInstance() {
        return this.spiedInstance;
    }

    @Override // org.mockito.internal.creation.settings.CreationSettings, org.mockito.mock.MockCreationSettings
    public Class<T> getTypeToMock() {
        return this.typeToMock;
    }

    public boolean hasInvocationListeners() {
        return !getInvocationListeners().isEmpty();
    }

    @Override // org.mockito.MockSettings
    public MockSettings invocationListeners(InvocationListener... invocationListenerArr) {
        addListeners(invocationListenerArr, this.invocationListeners, "invocationListeners");
        return this;
    }

    @Override // org.mockito.internal.creation.settings.CreationSettings, org.mockito.mock.MockCreationSettings
    public boolean isStubOnly() {
        return this.stubOnly;
    }

    @Override // org.mockito.internal.creation.settings.CreationSettings, org.mockito.mock.MockCreationSettings
    public boolean isUsingConstructor() {
        return this.useConstructor;
    }

    @Override // org.mockito.MockSettings
    public MockSettings lenient() {
        this.strictness = Strictness.LENIENT;
        return this;
    }

    @Override // org.mockito.MockSettings
    public MockSettings mockMaker(String str) {
        this.mockMaker = str;
        return this;
    }

    @Override // org.mockito.MockSettings
    public MockSettings name(String str) {
        this.name = str;
        return this;
    }

    @Override // org.mockito.MockSettings
    public MockSettings outerInstance(Object obj) {
        this.outerClassInstance = obj;
        return this;
    }

    @Override // org.mockito.MockSettings
    public MockSettings serializable() {
        return serializable(SerializableMode.BASIC);
    }

    @Override // org.mockito.MockSettings
    public MockSettings spiedInstance(Object obj) {
        this.spiedInstance = obj;
        return this;
    }

    @Override // org.mockito.MockSettings
    public MockSettings strictness(Strictness strictness) {
        if (strictness == null) {
            throw Reporter.strictnessDoesNotAcceptNullParameter();
        }
        this.strictness = strictness;
        return this;
    }

    @Override // org.mockito.MockSettings
    public MockSettings stubbingLookupListeners(StubbingLookupListener... stubbingLookupListenerArr) {
        addListeners(stubbingLookupListenerArr, this.stubbingLookupListeners, "stubbingLookupListeners");
        return this;
    }

    @Override // org.mockito.MockSettings
    public MockSettings useConstructor(Object... objArr) {
        Checks.checkNotNull(objArr, "constructorArgs", "If you need to pass null, please cast it to the right type, e.g.: useConstructor((String) null)");
        this.useConstructor = true;
        this.constructorArgs = objArr;
        return this;
    }

    @Override // org.mockito.MockSettings
    public MockSettings verboseLogging() {
        if (!invocationListenersContainsType(VerboseMockInvocationLogger.class)) {
            invocationListeners(new VerboseMockInvocationLogger());
        }
        return this;
    }

    @Override // org.mockito.MockSettings
    public MockSettings verificationStartedListeners(VerificationStartedListener... verificationStartedListenerArr) {
        addListeners(verificationStartedListenerArr, this.verificationStartedListeners, "verificationStartedListeners");
        return this;
    }

    @Override // org.mockito.MockSettings
    public MockSettings withoutAnnotations() {
        this.stripAnnotations = true;
        return this;
    }

    @Override // org.mockito.MockSettings
    public MockSettings serializable(SerializableMode serializableMode) {
        this.serializableMode = serializableMode;
        return this;
    }

    @Override // org.mockito.MockSettings
    public MockSettingsImpl<T> stubOnly() {
        this.stubOnly = true;
        return this;
    }
}
