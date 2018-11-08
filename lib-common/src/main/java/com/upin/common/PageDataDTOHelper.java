package com.upin.common;

/**
 * @Created by Leslie on 2018/7/27.
 */
public class PageDataDTOHelper {

    public static PageDataDTO fillPage(PageDataDTO data, long totalElements, int totalPages, Integer offset, Integer limit) {
        return data.offset(offset).limit(limit).totalElements(new Long(totalElements).intValue()).totalPages(totalPages);
    }
}
