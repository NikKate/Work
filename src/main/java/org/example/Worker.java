package org.example;

public class Worker {

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String result);
    }
    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    private OnTaskErrorListener errorCallback;
    private OnTaskDoneListener callback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 33) {
                errorCallback.onError("Task " + i + " is error");
            } else {
                errorCallback.onError("Task " + i + " is done");
            }
        }
    }
}
