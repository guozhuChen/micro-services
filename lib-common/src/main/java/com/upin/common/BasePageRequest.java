package com.upin.common;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * @Created by Leslie on 2018/7/27.
 */
public class BasePageRequest implements Pageable, Serializable {
    private Integer offset;
    private Integer limit;
    private Sort sort;

    public BasePageRequest(Integer offset, Integer limit, Sort sort) {
        if (offset == null) {
            offset = 0;
        }
        if (limit == null) {
            // 默认 查询一百条记录
            limit = 100;
        }
        if (offset < 0) {
            throw new IllegalArgumentException("Offset index must not be less than zero!");
        }
        if (limit < 1) {
            throw new IllegalArgumentException("Limit must not be less than one!");
        }
        this.offset = offset;
        this.limit = limit;
        this.sort = sort;
    }

    @Override
    public int getPageNumber() {
        return offset / limit;
    }

    @Override
    public int getPageSize() {
        return limit;
    }

    @Override
    public long getOffset() {
        return offset;
    }

    @Override
    public Sort getSort() {
        return sort;
    }

    @Override
    public Pageable next() {
        return new BasePageRequest(new Long(getOffset()).intValue() + getPageSize(), getPageSize(), getSort());
    }

    public BasePageRequest previous() {
        return hasPrevious() ? new BasePageRequest(new Long(getOffset()).intValue() - getPageSize(), getPageSize(), getSort()) : this;
    }

    @Override
    public Pageable previousOrFirst() {
        return hasPrevious() ? previous() : first();
    }

    @Override
    public Pageable first() {
        return new BasePageRequest(0, getPageSize(), getSort());
    }

    @Override
    public boolean hasPrevious() {
        return offset > limit;
    }
}
