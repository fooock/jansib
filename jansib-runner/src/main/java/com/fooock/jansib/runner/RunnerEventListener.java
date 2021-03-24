package com.fooock.jansib.runner;

import java.util.List;

/**
 *
 */
public interface RunnerEventListener {
    void onInitialize(long pid, List<String> command);
    void onEventData(String event);
    void onError(Exception exception);
    void onCompleted(long pid);
}
