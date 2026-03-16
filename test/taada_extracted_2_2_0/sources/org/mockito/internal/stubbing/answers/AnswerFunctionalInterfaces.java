package org.mockito.internal.stubbing.answers;

import java.lang.reflect.Method;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.Answer1;
import org.mockito.stubbing.Answer2;
import org.mockito.stubbing.Answer3;
import org.mockito.stubbing.Answer4;
import org.mockito.stubbing.Answer5;
import org.mockito.stubbing.Answer6;
import org.mockito.stubbing.VoidAnswer1;
import org.mockito.stubbing.VoidAnswer2;
import org.mockito.stubbing.VoidAnswer3;
import org.mockito.stubbing.VoidAnswer4;
import org.mockito.stubbing.VoidAnswer5;
import org.mockito.stubbing.VoidAnswer6;

/* JADX INFO: loaded from: classes.dex */
public class AnswerFunctionalInterfaces {
    private AnswerFunctionalInterfaces() {
    }

    private static Method findAnswerMethod(Class<?> cls, int i) {
        for (Method method : cls.getDeclaredMethods()) {
            if (!method.isBridge() && method.getName().equals("answer") && method.getParameterTypes().length == i) {
                return method;
            }
        }
        throw new IllegalStateException("Failed to find answer() method on the supplied class: " + cls.getName() + ", with the supplied number of parameters: " + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <A> A lastParameter(InvocationOnMock invocationOnMock, Method method, int i) {
        Method method2 = invocationOnMock.getMethod();
        if (method2.isVarArgs() && method2.getParameterTypes().length == i + 1) {
            if (method.getParameterTypes()[i].isAssignableFrom(method2.getParameterTypes()[i])) {
                return (A) invocationOnMock.getRawArguments()[i];
            }
        }
        return (A) invocationOnMock.getArgument(i);
    }

    public static <T, A> Answer<T> toAnswer(final Answer1<T, A> answer1) {
        final Method methodFindAnswerMethod = findAnswerMethod(answer1.getClass(), 1);
        return new Answer<T>() { // from class: org.mockito.internal.stubbing.answers.AnswerFunctionalInterfaces.1
            @Override // org.mockito.stubbing.Answer
            public T answer(InvocationOnMock invocationOnMock) {
                return (T) answer1.answer(AnswerFunctionalInterfaces.lastParameter(invocationOnMock, methodFindAnswerMethod, 0));
            }
        };
    }

    public static <A> Answer<Void> toAnswer(final VoidAnswer1<A> voidAnswer1) {
        final Method methodFindAnswerMethod = findAnswerMethod(voidAnswer1.getClass(), 1);
        return new Answer<Void>() { // from class: org.mockito.internal.stubbing.answers.AnswerFunctionalInterfaces.2
            @Override // org.mockito.stubbing.Answer
            public Void answer(InvocationOnMock invocationOnMock) {
                voidAnswer1.answer(AnswerFunctionalInterfaces.lastParameter(invocationOnMock, methodFindAnswerMethod, 0));
                return null;
            }
        };
    }

    public static <T, A, B> Answer<T> toAnswer(final Answer2<T, A, B> answer2) {
        final Method methodFindAnswerMethod = findAnswerMethod(answer2.getClass(), 2);
        return new Answer<T>() { // from class: org.mockito.internal.stubbing.answers.AnswerFunctionalInterfaces.3
            @Override // org.mockito.stubbing.Answer
            public T answer(InvocationOnMock invocationOnMock) {
                return (T) answer2.answer(invocationOnMock.getArgument(0), AnswerFunctionalInterfaces.lastParameter(invocationOnMock, methodFindAnswerMethod, 1));
            }
        };
    }

    public static <A, B> Answer<Void> toAnswer(final VoidAnswer2<A, B> voidAnswer2) {
        final Method methodFindAnswerMethod = findAnswerMethod(voidAnswer2.getClass(), 2);
        return new Answer<Void>() { // from class: org.mockito.internal.stubbing.answers.AnswerFunctionalInterfaces.4
            @Override // org.mockito.stubbing.Answer
            public Void answer(InvocationOnMock invocationOnMock) {
                voidAnswer2.answer(invocationOnMock.getArgument(0), AnswerFunctionalInterfaces.lastParameter(invocationOnMock, methodFindAnswerMethod, 1));
                return null;
            }
        };
    }

    public static <T, A, B, C> Answer<T> toAnswer(final Answer3<T, A, B, C> answer3) {
        final Method methodFindAnswerMethod = findAnswerMethod(answer3.getClass(), 3);
        return new Answer<T>() { // from class: org.mockito.internal.stubbing.answers.AnswerFunctionalInterfaces.5
            @Override // org.mockito.stubbing.Answer
            public T answer(InvocationOnMock invocationOnMock) {
                return (T) answer3.answer(invocationOnMock.getArgument(0), invocationOnMock.getArgument(1), AnswerFunctionalInterfaces.lastParameter(invocationOnMock, methodFindAnswerMethod, 2));
            }
        };
    }

    public static <A, B, C> Answer<Void> toAnswer(final VoidAnswer3<A, B, C> voidAnswer3) {
        final Method methodFindAnswerMethod = findAnswerMethod(voidAnswer3.getClass(), 3);
        return new Answer<Void>() { // from class: org.mockito.internal.stubbing.answers.AnswerFunctionalInterfaces.6
            @Override // org.mockito.stubbing.Answer
            public Void answer(InvocationOnMock invocationOnMock) {
                voidAnswer3.answer(invocationOnMock.getArgument(0), invocationOnMock.getArgument(1), AnswerFunctionalInterfaces.lastParameter(invocationOnMock, methodFindAnswerMethod, 2));
                return null;
            }
        };
    }

    public static <T, A, B, C, D> Answer<T> toAnswer(final Answer4<T, A, B, C, D> answer4) {
        final Method methodFindAnswerMethod = findAnswerMethod(answer4.getClass(), 4);
        return new Answer<T>() { // from class: org.mockito.internal.stubbing.answers.AnswerFunctionalInterfaces.7
            @Override // org.mockito.stubbing.Answer
            public T answer(InvocationOnMock invocationOnMock) {
                return (T) answer4.answer(invocationOnMock.getArgument(0), invocationOnMock.getArgument(1), invocationOnMock.getArgument(2), AnswerFunctionalInterfaces.lastParameter(invocationOnMock, methodFindAnswerMethod, 3));
            }
        };
    }

    public static <A, B, C, D> Answer<Void> toAnswer(final VoidAnswer4<A, B, C, D> voidAnswer4) {
        final Method methodFindAnswerMethod = findAnswerMethod(voidAnswer4.getClass(), 4);
        return new Answer<Void>() { // from class: org.mockito.internal.stubbing.answers.AnswerFunctionalInterfaces.8
            @Override // org.mockito.stubbing.Answer
            public Void answer(InvocationOnMock invocationOnMock) {
                voidAnswer4.answer(invocationOnMock.getArgument(0), invocationOnMock.getArgument(1), invocationOnMock.getArgument(2), AnswerFunctionalInterfaces.lastParameter(invocationOnMock, methodFindAnswerMethod, 3));
                return null;
            }
        };
    }

    public static <T, A, B, C, D, E> Answer<T> toAnswer(final Answer5<T, A, B, C, D, E> answer5) {
        final Method methodFindAnswerMethod = findAnswerMethod(answer5.getClass(), 5);
        return new Answer<T>() { // from class: org.mockito.internal.stubbing.answers.AnswerFunctionalInterfaces.9
            @Override // org.mockito.stubbing.Answer
            public T answer(InvocationOnMock invocationOnMock) {
                return (T) answer5.answer(invocationOnMock.getArgument(0), invocationOnMock.getArgument(1), invocationOnMock.getArgument(2), invocationOnMock.getArgument(3), AnswerFunctionalInterfaces.lastParameter(invocationOnMock, methodFindAnswerMethod, 4));
            }
        };
    }

    public static <A, B, C, D, E> Answer<Void> toAnswer(final VoidAnswer5<A, B, C, D, E> voidAnswer5) {
        final Method methodFindAnswerMethod = findAnswerMethod(voidAnswer5.getClass(), 5);
        return new Answer<Void>() { // from class: org.mockito.internal.stubbing.answers.AnswerFunctionalInterfaces.10
            @Override // org.mockito.stubbing.Answer
            public Void answer(InvocationOnMock invocationOnMock) {
                voidAnswer5.answer(invocationOnMock.getArgument(0), invocationOnMock.getArgument(1), invocationOnMock.getArgument(2), invocationOnMock.getArgument(3), AnswerFunctionalInterfaces.lastParameter(invocationOnMock, methodFindAnswerMethod, 4));
                return null;
            }
        };
    }

    public static <T, A, B, C, D, E, F> Answer<T> toAnswer(final Answer6<T, A, B, C, D, E, F> answer6) {
        final Method methodFindAnswerMethod = findAnswerMethod(answer6.getClass(), 6);
        return new Answer<T>() { // from class: org.mockito.internal.stubbing.answers.AnswerFunctionalInterfaces.11
            @Override // org.mockito.stubbing.Answer
            public T answer(InvocationOnMock invocationOnMock) {
                return (T) answer6.answer(invocationOnMock.getArgument(0), invocationOnMock.getArgument(1), invocationOnMock.getArgument(2), invocationOnMock.getArgument(3), invocationOnMock.getArgument(4), AnswerFunctionalInterfaces.lastParameter(invocationOnMock, methodFindAnswerMethod, 5));
            }
        };
    }

    public static <A, B, C, D, E, F> Answer<Void> toAnswer(final VoidAnswer6<A, B, C, D, E, F> voidAnswer6) {
        final Method methodFindAnswerMethod = findAnswerMethod(voidAnswer6.getClass(), 6);
        return new Answer<Void>() { // from class: org.mockito.internal.stubbing.answers.AnswerFunctionalInterfaces.12
            @Override // org.mockito.stubbing.Answer
            public Void answer(InvocationOnMock invocationOnMock) {
                voidAnswer6.answer(invocationOnMock.getArgument(0), invocationOnMock.getArgument(1), invocationOnMock.getArgument(2), invocationOnMock.getArgument(3), invocationOnMock.getArgument(4), AnswerFunctionalInterfaces.lastParameter(invocationOnMock, methodFindAnswerMethod, 5));
                return null;
            }
        };
    }
}
