package org.mockito.internal.listeners;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.mockito.internal.creation.settings.CreationSettings;
import org.mockito.invocation.Invocation;
import org.mockito.listeners.StubbingLookupEvent;
import org.mockito.listeners.StubbingLookupListener;
import org.mockito.mock.MockCreationSettings;
import org.mockito.stubbing.Stubbing;

/* JADX INFO: loaded from: classes.dex */
public final class StubbingLookupNotifier {

    public static class Event implements StubbingLookupEvent {
        private final Collection<Stubbing> allStubbings;
        private final Invocation invocation;
        private final MockCreationSettings mockSettings;
        private final Stubbing stubbing;

        public Event(Invocation invocation, Stubbing stubbing, Collection<Stubbing> collection, MockCreationSettings mockCreationSettings) {
            this.invocation = invocation;
            this.stubbing = stubbing;
            this.allStubbings = collection;
            this.mockSettings = mockCreationSettings;
        }

        @Override // org.mockito.listeners.StubbingLookupEvent
        public Collection<Stubbing> getAllStubbings() {
            return this.allStubbings;
        }

        @Override // org.mockito.listeners.StubbingLookupEvent
        public Invocation getInvocation() {
            return this.invocation;
        }

        @Override // org.mockito.listeners.StubbingLookupEvent
        public MockCreationSettings getMockSettings() {
            return this.mockSettings;
        }

        @Override // org.mockito.listeners.StubbingLookupEvent
        public Stubbing getStubbingFound() {
            return this.stubbing;
        }
    }

    private StubbingLookupNotifier() {
    }

    public static void notifyStubbedAnswerLookup(Invocation invocation, Stubbing stubbing, Collection<Stubbing> collection, CreationSettings creationSettings) {
        List<StubbingLookupListener> stubbingLookupListeners = creationSettings.getStubbingLookupListeners();
        if (stubbingLookupListeners.isEmpty()) {
            return;
        }
        Event event = new Event(invocation, stubbing, collection, creationSettings);
        Iterator<StubbingLookupListener> it = stubbingLookupListeners.iterator();
        while (it.hasNext()) {
            it.next().onStubbingLookup(event);
        }
    }
}
