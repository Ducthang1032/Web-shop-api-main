package main.java.common.utils;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public final class AsyncUtils {

    public static <T> List<T> getResultAsyncWithComFutureAsList(List<CompletableFuture<List<T>>> futureExecutions)
            throws ExecutionException, InterruptedException {
        List<T> result = new ArrayList<>();
        for (CompletableFuture<List<T>> future : futureExecutions) {
            if (CollectionUtils.isEmpty(future.get()))
                continue;
            result.addAll(future.get());
        }
        return result;
    }

    public static <T> List<T> getResultAsync(List<CompletableFuture<T>> futureExecutions)
            throws ExecutionException, InterruptedException {
        List<T> result = new ArrayList<>();
        for (CompletableFuture<T> future : futureExecutions) {
            if (Objects.isNull(future.get()))
                continue;
            result.add(future.get());
        }
        return result;
    }
}
