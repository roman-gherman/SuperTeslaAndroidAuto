package org.mockito.internal.util.reflection;

import fr.sd.taada.helpers.e;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SuperTypesLastSorter {
    private static final Comparator<Field> compareFieldsByName = new e(2);

    private SuperTypesLastSorter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$0(Field field, Field field2) {
        return field.getName().compareTo(field2.getName());
    }

    public static List<Field> sortSuperTypesLast(Collection<? extends Field> collection) {
        ArrayList arrayList = new ArrayList(collection);
        Collections.sort(arrayList, compareFieldsByName);
        int i = 0;
        while (i < arrayList.size() - 1) {
            Field field = (Field) arrayList.get(i);
            Class<?> type = field.getType();
            int i3 = i + 1;
            int i4 = i;
            for (int i5 = i3; i5 < arrayList.size(); i5++) {
                Class<?> type2 = ((Field) arrayList.get(i5)).getType();
                if (type != type2 && type.isAssignableFrom(type2)) {
                    i4 = i5;
                }
            }
            if (i4 == i) {
                i = i3;
            } else {
                arrayList.remove(i);
                arrayList.add(i4, field);
            }
        }
        return arrayList;
    }
}
