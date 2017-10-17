package com.glemontree.mybatis.base;

import java.io.Serializable;

public class BasePage implements Serializable {

    public static final int PAGE_SHOW_COUNT = 10;

    /**
     * 页数
     */
    private int pageNum = 1;

    /**
     * 每页可以显示的数目
     */
    private int pageSize = 0;

    /**
     * 总共显示的数据
     */
    private int totalCount = 0;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getStartIndex() {
        int pageNum = getPageNum() > 0 ? getPageNum() - 1 : 0;
        return pageNum * getPageSize();
    }

    @Override
    public String toString() {
        return "BasePage{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                '}';
    }
}
