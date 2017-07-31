package com.example.demo.pojo;

import java.util.List;

/**
 * Created by lijiyang on 2017/7/31.
 */
public interface Page<T> {
    Long getPageSize();

    void setPageSize(Long var1);

    Long getPageIndex();

    void setPageIndex(Long var1);

    Long getTotalCount();

    void setTotalCount(Long var1);

    Long getPageCount();

    List<T> getData();

    void setData(List<T> var1);
}