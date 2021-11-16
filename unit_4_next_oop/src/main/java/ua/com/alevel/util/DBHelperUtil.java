package ua.com.alevel.util;

import java.util.Collection;
import java.util.UUID;

public final class DBHelperUtil {
    private DBHelperUtil(){}

    public static String generateId(Collection<?> items) {
        final String id = UUID.randomUUID().toString();
        if (items.stream().anyMatch(item -> item.getId().equals(id))) {
            return generateId(items);
        }
        return id;
    }

}
