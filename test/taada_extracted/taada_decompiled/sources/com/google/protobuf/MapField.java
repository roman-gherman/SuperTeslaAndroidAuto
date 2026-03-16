package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class MapField<K, V> implements MutabilityOracle {
    private final Converter<K, V> converter;
    private volatile boolean isMutable;
    private List<Message> listData;
    private MutatabilityAwareMap<K, V> mapData;
    private volatile StorageMode mode;

    public interface Converter<K, V> {
        Message convertKeyAndValueToMessage(K k6, V v6);

        void convertMessageToKeyAndValue(Message message, Map<K, V> map);

        Message getMessageDefaultInstance();
    }

    public static class ImmutableMessageConverter<K, V> implements Converter<K, V> {
        private final MapEntry<K, V> defaultEntry;

        public ImmutableMessageConverter(MapEntry<K, V> mapEntry) {
            this.defaultEntry = mapEntry;
        }

        @Override // com.google.protobuf.MapField.Converter
        public Message convertKeyAndValueToMessage(K k6, V v6) {
            return this.defaultEntry.newBuilderForType().setKey(k6).setValue(v6).buildPartial();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.MapField.Converter
        public void convertMessageToKeyAndValue(Message message, Map<K, V> map) {
            MapEntry mapEntry = (MapEntry) message;
            map.put(mapEntry.getKey(), mapEntry.getValue());
        }

        @Override // com.google.protobuf.MapField.Converter
        public Message getMessageDefaultInstance() {
            return this.defaultEntry;
        }
    }

    public static class MutatabilityAwareMap<K, V> implements Map<K, V> {
        private final Map<K, V> delegate;
        private final MutabilityOracle mutabilityOracle;

        public static class MutatabilityAwareCollection<E> implements Collection<E> {
            private final Collection<E> delegate;
            private final MutabilityOracle mutabilityOracle;

            public MutatabilityAwareCollection(MutabilityOracle mutabilityOracle, Collection<E> collection) {
                this.mutabilityOracle = mutabilityOracle;
                this.delegate = collection;
            }

            @Override // java.util.Collection
            public boolean add(E e) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Collection
            public boolean addAll(Collection<? extends E> collection) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Collection
            public void clear() {
                this.mutabilityOracle.ensureMutable();
                this.delegate.clear();
            }

            @Override // java.util.Collection
            public boolean contains(Object obj) {
                return this.delegate.contains(obj);
            }

            @Override // java.util.Collection
            public boolean containsAll(Collection<?> collection) {
                return this.delegate.containsAll(collection);
            }

            @Override // java.util.Collection
            public boolean equals(Object obj) {
                return this.delegate.equals(obj);
            }

            @Override // java.util.Collection
            public int hashCode() {
                return this.delegate.hashCode();
            }

            @Override // java.util.Collection
            public boolean isEmpty() {
                return this.delegate.isEmpty();
            }

            @Override // java.util.Collection, java.lang.Iterable
            public Iterator<E> iterator() {
                return new MutatabilityAwareIterator(this.mutabilityOracle, this.delegate.iterator());
            }

            @Override // java.util.Collection
            public boolean remove(Object obj) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.remove(obj);
            }

            @Override // java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.removeAll(collection);
            }

            @Override // java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.retainAll(collection);
            }

            @Override // java.util.Collection
            public int size() {
                return this.delegate.size();
            }

            @Override // java.util.Collection
            public Object[] toArray() {
                return this.delegate.toArray();
            }

            public String toString() {
                return this.delegate.toString();
            }

            @Override // java.util.Collection
            public <T> T[] toArray(T[] tArr) {
                return (T[]) this.delegate.toArray(tArr);
            }
        }

        public static class MutatabilityAwareIterator<E> implements Iterator<E> {
            private final Iterator<E> delegate;
            private final MutabilityOracle mutabilityOracle;

            public MutatabilityAwareIterator(MutabilityOracle mutabilityOracle, Iterator<E> it) {
                this.mutabilityOracle = mutabilityOracle;
                this.delegate = it;
            }

            public boolean equals(Object obj) {
                return this.delegate.equals(obj);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.delegate.hasNext();
            }

            public int hashCode() {
                return this.delegate.hashCode();
            }

            @Override // java.util.Iterator
            public E next() {
                return this.delegate.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.mutabilityOracle.ensureMutable();
                this.delegate.remove();
            }

            public String toString() {
                return this.delegate.toString();
            }
        }

        public static class MutatabilityAwareSet<E> implements Set<E> {
            private final Set<E> delegate;
            private final MutabilityOracle mutabilityOracle;

            public MutatabilityAwareSet(MutabilityOracle mutabilityOracle, Set<E> set) {
                this.mutabilityOracle = mutabilityOracle;
                this.delegate = set;
            }

            @Override // java.util.Set, java.util.Collection
            public boolean add(E e) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.add(e);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean addAll(Collection<? extends E> collection) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.addAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public void clear() {
                this.mutabilityOracle.ensureMutable();
                this.delegate.clear();
            }

            @Override // java.util.Set, java.util.Collection
            public boolean contains(Object obj) {
                return this.delegate.contains(obj);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean containsAll(Collection<?> collection) {
                return this.delegate.containsAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean equals(Object obj) {
                return this.delegate.equals(obj);
            }

            @Override // java.util.Set, java.util.Collection
            public int hashCode() {
                return this.delegate.hashCode();
            }

            @Override // java.util.Set, java.util.Collection
            public boolean isEmpty() {
                return this.delegate.isEmpty();
            }

            @Override // java.util.Set, java.util.Collection, java.lang.Iterable
            public Iterator<E> iterator() {
                return new MutatabilityAwareIterator(this.mutabilityOracle, this.delegate.iterator());
            }

            @Override // java.util.Set, java.util.Collection
            public boolean remove(Object obj) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.remove(obj);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.removeAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.retainAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public int size() {
                return this.delegate.size();
            }

            @Override // java.util.Set, java.util.Collection
            public Object[] toArray() {
                return this.delegate.toArray();
            }

            public String toString() {
                return this.delegate.toString();
            }

            @Override // java.util.Set, java.util.Collection
            public <T> T[] toArray(T[] tArr) {
                return (T[]) this.delegate.toArray(tArr);
            }
        }

        public MutatabilityAwareMap(MutabilityOracle mutabilityOracle, Map<K, V> map) {
            this.mutabilityOracle = mutabilityOracle;
            this.delegate = map;
        }

        @Override // java.util.Map
        public void clear() {
            this.mutabilityOracle.ensureMutable();
            this.delegate.clear();
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            return this.delegate.containsKey(obj);
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return this.delegate.containsValue(obj);
        }

        @Override // java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new MutatabilityAwareSet(this.mutabilityOracle, this.delegate.entrySet());
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            return this.delegate.equals(obj);
        }

        @Override // java.util.Map
        public V get(Object obj) {
            return this.delegate.get(obj);
        }

        @Override // java.util.Map
        public int hashCode() {
            return this.delegate.hashCode();
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.delegate.isEmpty();
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            return new MutatabilityAwareSet(this.mutabilityOracle, this.delegate.keySet());
        }

        @Override // java.util.Map
        public V put(K k6, V v6) {
            this.mutabilityOracle.ensureMutable();
            Internal.checkNotNull(k6);
            Internal.checkNotNull(v6);
            return this.delegate.put(k6, v6);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            this.mutabilityOracle.ensureMutable();
            for (K k6 : map.keySet()) {
                Internal.checkNotNull(k6);
                Internal.checkNotNull(map.get(k6));
            }
            this.delegate.putAll(map);
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            this.mutabilityOracle.ensureMutable();
            return this.delegate.remove(obj);
        }

        @Override // java.util.Map
        public int size() {
            return this.delegate.size();
        }

        public String toString() {
            return this.delegate.toString();
        }

        @Override // java.util.Map
        public Collection<V> values() {
            return new MutatabilityAwareCollection(this.mutabilityOracle, this.delegate.values());
        }
    }

    public enum StorageMode {
        MAP,
        LIST,
        BOTH
    }

    private MapField(Converter<K, V> converter, StorageMode storageMode, Map<K, V> map) {
        this.converter = converter;
        this.isMutable = true;
        this.mode = storageMode;
        this.mapData = new MutatabilityAwareMap<>(this, map);
        this.listData = null;
    }

    private Message convertKeyAndValueToMessage(K k6, V v6) {
        return this.converter.convertKeyAndValueToMessage(k6, v6);
    }

    private MutatabilityAwareMap<K, V> convertListToMap(List<Message> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Message> it = list.iterator();
        while (it.hasNext()) {
            convertMessageToKeyAndValue(it.next(), linkedHashMap);
        }
        return new MutatabilityAwareMap<>(this, linkedHashMap);
    }

    private List<Message> convertMapToList(MutatabilityAwareMap<K, V> mutatabilityAwareMap) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<K, V> entry : mutatabilityAwareMap.entrySet()) {
            arrayList.add(convertKeyAndValueToMessage(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    private void convertMessageToKeyAndValue(Message message, Map<K, V> map) {
        this.converter.convertMessageToKeyAndValue(message, map);
    }

    public static <K, V> MapField<K, V> emptyMapField(MapEntry<K, V> mapEntry) {
        return new MapField<>(mapEntry, StorageMode.MAP, Collections.EMPTY_MAP);
    }

    public static <K, V> MapField<K, V> newMapField(MapEntry<K, V> mapEntry) {
        return new MapField<>(mapEntry, StorageMode.MAP, new LinkedHashMap());
    }

    public void clear() {
        this.mapData = new MutatabilityAwareMap<>(this, new LinkedHashMap());
        this.mode = StorageMode.MAP;
    }

    public MapField<K, V> copy() {
        return new MapField<>(this.converter, StorageMode.MAP, MapFieldLite.copy((Map) getMap()));
    }

    @Override // com.google.protobuf.MutabilityOracle
    public void ensureMutable() {
        if (!isMutable()) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof MapField) {
            return MapFieldLite.equals((Map) getMap(), (Map) ((MapField) obj).getMap());
        }
        return false;
    }

    public List<Message> getList() {
        StorageMode storageMode = this.mode;
        StorageMode storageMode2 = StorageMode.MAP;
        if (storageMode == storageMode2) {
            synchronized (this) {
                try {
                    if (this.mode == storageMode2) {
                        this.listData = convertMapToList(this.mapData);
                        this.mode = StorageMode.BOTH;
                    }
                } finally {
                }
            }
        }
        return Collections.unmodifiableList(this.listData);
    }

    public Map<K, V> getMap() {
        StorageMode storageMode = this.mode;
        StorageMode storageMode2 = StorageMode.LIST;
        if (storageMode == storageMode2) {
            synchronized (this) {
                try {
                    if (this.mode == storageMode2) {
                        this.mapData = convertListToMap(this.listData);
                        this.mode = StorageMode.BOTH;
                    }
                } finally {
                }
            }
        }
        return Collections.unmodifiableMap(this.mapData);
    }

    public Message getMapEntryMessageDefaultInstance() {
        return this.converter.getMessageDefaultInstance();
    }

    public List<Message> getMutableList() {
        StorageMode storageMode = this.mode;
        StorageMode storageMode2 = StorageMode.LIST;
        if (storageMode != storageMode2) {
            if (this.mode == StorageMode.MAP) {
                this.listData = convertMapToList(this.mapData);
            }
            this.mapData = null;
            this.mode = storageMode2;
        }
        return this.listData;
    }

    public Map<K, V> getMutableMap() {
        StorageMode storageMode = this.mode;
        StorageMode storageMode2 = StorageMode.MAP;
        if (storageMode != storageMode2) {
            if (this.mode == StorageMode.LIST) {
                this.mapData = convertListToMap(this.listData);
            }
            this.listData = null;
            this.mode = storageMode2;
        }
        return this.mapData;
    }

    public int hashCode() {
        return MapFieldLite.calculateHashCodeForMap(getMap());
    }

    public boolean isMutable() {
        return this.isMutable;
    }

    public void makeImmutable() {
        this.isMutable = false;
    }

    public void mergeFrom(MapField<K, V> mapField) {
        getMutableMap().putAll(MapFieldLite.copy((Map) mapField.getMap()));
    }

    private MapField(MapEntry<K, V> mapEntry, StorageMode storageMode, Map<K, V> map) {
        this(new ImmutableMessageConverter(mapEntry), storageMode, map);
    }
}
