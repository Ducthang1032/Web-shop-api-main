package main.java.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tdt.cqsta.common.constants.NumberConstants;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class ObjectUtil {
    public static <T> List<T> getPage(List<T> sourceList, int page, int pageSize) {
        if (pageSize <= 0 || page <= 0) {
            return Collections.emptyList();
        }

        int fromIndex = (page - 1) * pageSize;
        if (Objects.isNull(sourceList) || sourceList.size() <= fromIndex) {
            return Collections.emptyList();
        }

        return sourceList.subList(fromIndex, Math.min(fromIndex + pageSize, sourceList.size()));
    }

    public static int getNumberPage(int listSize, int pageSize) {
        if (pageSize <= 0) return Integer.MAX_VALUE - 1;
        return Math.max((listSize + pageSize - 1) / pageSize, NumberConstants.DEFAULT_TOTAL_PAGE);
    }

    public static int getPageNoByIndex(int indexInArray, int pageSize) {
        return (indexInArray < NumberUtils.INTEGER_ZERO)
                ? NumberUtils.INTEGER_ONE
                : (indexInArray / pageSize + NumberUtils.INTEGER_ONE);
    }

    public static String convertObjectToJson(Object object) throws JsonProcessingException {
        return Objects.isNull(object) ? StringUtils.EMPTY : new ObjectMapper().writeValueAsString(object);
    }

    public static <T> int getListSize(List<T> sourceList) {
        if (Objects.isNull(sourceList)) return 0;
        return sourceList.size();
    }

    public static boolean allListIsEmpty(Collection<?>... collection) {
        if (ArrayUtils.isEmpty(collection))
            return true;
        return Arrays.stream(collection).allMatch(CollectionUtils::isEmpty);
    }

    //If there are elements with the same key, the FIRST ELEMENT that appears in the list will be taken
    public static <T, K> List<T> distinctByKey(List<T> sourceList, Function<? super T, ? extends K> keyExtractor) {
        return new ArrayList<>(sourceList.stream()
                .collect(Collectors.toMap(keyExtractor, p -> p, (p, q) -> p)).values());
    }

    //f there are elements with the same key, the LAST ELEMENT appearing in the list will be taken
    public static <T, K> List<T> distinctByLastKey(List<T> sourceList, Function<? super T, ? extends K> keyExtractor) {
        return new ArrayList<>(sourceList.stream()
                .collect(Collectors.toMap(keyExtractor, p -> p, (p, q) -> q)).values());
    }

    public static <T> T getLastItemOrDefault(List<T> sourceList, T other) {
        if (CollectionUtils.isEmpty(sourceList)) return other;
        int lastIndex = sourceList.size() - 1;
        T lastItem = sourceList.get(lastIndex);
        return Objects.isNull(lastItem) ? other : lastItem;
    }

    public static <T> T getFirstItemOrDefault(List<T> sourceList, T other) {
        if (CollectionUtils.isEmpty(sourceList)) return other;
        T firstItem = sourceList.get(0);
        return Objects.isNull(firstItem) ? other : firstItem;
    }

    public static <T> boolean notContains(List<T> sourceList, T objectCheck) {
        return CollectionUtils.isEmpty(sourceList)
                || !sourceList.contains(objectCheck);
    }

    public static <T> boolean noneContains(List<T> sourceList, T... objectCheck) {
        return !CollectionUtils.containsAny(sourceList, Arrays.asList(objectCheck));
    }

    public static Map<String, Object> convertObjectToMap(Object input) {
        Map<String, Object> result = new HashMap<>();
        if (Objects.isNull(input)) return result;
        for (Field field : input.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                result.put(field.getName(), field.get(input));
            } catch (Exception ignored) {
            }
        }
        return result;
    }
}
