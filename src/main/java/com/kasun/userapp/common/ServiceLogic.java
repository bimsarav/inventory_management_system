package com.kasun.userapp.common;

import java.util.List;

public interface ServiceLogic<T, V> {
    T invoke(V var1);

    List<ServiceWarning> getWarnings();
}
