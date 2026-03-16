package org.mockito.internal.configuration;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.mockito.Mock;
import org.mockito.MockSettings;
import org.mockito.MockedConstruction;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.util.StringUtil;
import org.mockito.internal.util.Supplier;
import org.mockito.quality.Strictness;

/* JADX INFO: loaded from: classes.dex */
public class MockAnnotationProcessor implements FieldAnnotationProcessor<Mock> {
    public static Class<?> inferParameterizedType(Type type, String str, String str2) {
        if (type instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            if (actualTypeArguments.length == 1) {
                Type type2 = actualTypeArguments[0];
                if (type2 instanceof Class) {
                    return (Class) type2;
                }
            }
        }
        throw new MockitoException(StringUtil.join(androidx.constraintlayout.core.motion.a.p("Mockito cannot infer a static mock from a raw type for ", str), "", androidx.constraintlayout.core.motion.a.q("Instead of @Mock ", str2, " you need to specify a parameterized type"), "For example, if you would like to mock Sample.class, specify", "", androidx.constraintlayout.core.motion.a.q("@Mock ", str2, "<Sample>"), "", "as the type parameter. If the type is itself parameterized, it should be specified as raw type."));
    }

    public static Object processAnnotationForMock(Mock mock, Class<?> cls, Supplier<Type> supplier, String str) {
        MockSettings mockSettingsWithSettings = Mockito.withSettings();
        if (mock.extraInterfaces().length > 0) {
            mockSettingsWithSettings.extraInterfaces(mock.extraInterfaces());
        }
        if ("".equals(mock.name())) {
            mockSettingsWithSettings.name(str);
        } else {
            mockSettingsWithSettings.name(mock.name());
        }
        if (mock.serializable()) {
            mockSettingsWithSettings.serializable();
        }
        if (mock.stubOnly()) {
            mockSettingsWithSettings.stubOnly();
        }
        if (mock.lenient()) {
            mockSettingsWithSettings.lenient();
        }
        if (mock.strictness() != Mock.Strictness.TEST_LEVEL_DEFAULT) {
            mockSettingsWithSettings.strictness(Strictness.valueOf(mock.strictness().toString()));
        }
        if (!mock.mockMaker().isEmpty()) {
            mockSettingsWithSettings.mockMaker(mock.mockMaker());
        }
        mockSettingsWithSettings.defaultAnswer(mock.answer());
        return cls == MockedStatic.class ? Mockito.mockStatic(inferParameterizedType(supplier.get(), str, "MockedStatic"), mockSettingsWithSettings) : cls == MockedConstruction.class ? Mockito.mockConstruction(inferParameterizedType(supplier.get(), str, "MockedConstruction"), mockSettingsWithSettings) : Mockito.mock(cls, mockSettingsWithSettings);
    }

    @Override // org.mockito.internal.configuration.FieldAnnotationProcessor
    public Object process(Mock mock, Field field) {
        return processAnnotationForMock(mock, field.getType(), new R0.a(field, 11), field.getName());
    }
}
