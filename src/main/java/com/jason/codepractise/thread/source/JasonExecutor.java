package com.jason.codepractise.thread.source;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;


public interface JasonExecutor {
    void excute(@NotNull Runnable runnable);
}
