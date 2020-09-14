package com.mqp.anddemo1.data;

public interface OnResultListener<T> {

    void success(T result);
    void fail(String msg);
}
