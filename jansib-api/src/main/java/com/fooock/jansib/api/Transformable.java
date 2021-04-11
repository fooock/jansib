package com.fooock.jansib.api;

import java.util.function.Function;

public interface Transformable<F> {
    <T> T transform(Function<F, T> function);
}
