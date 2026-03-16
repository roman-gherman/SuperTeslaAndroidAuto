package org.mockito.internal.stubbing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.Answer;

/* JADX INFO: loaded from: classes.dex */
class DoAnswerStyleStubbing implements Serializable {
    private final List<Answer<?>> answers = new ArrayList();
    private Strictness stubbingStrictness;

    public void clear() {
        this.answers.clear();
        this.stubbingStrictness = null;
    }

    public List<Answer<?>> getAnswers() {
        return this.answers;
    }

    public Strictness getStubbingStrictness() {
        return this.stubbingStrictness;
    }

    public boolean isSet() {
        return this.answers.isEmpty();
    }

    public void setAnswers(List<Answer<?>> list, Strictness strictness) {
        this.stubbingStrictness = strictness;
        this.answers.addAll(list);
    }
}
