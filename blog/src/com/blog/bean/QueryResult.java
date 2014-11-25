package com.blog.bean;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Project_NAME: blog
 * User: niweiwei
 * Date: 14-2-18
 * Time: 下午9:45
 * To change this template use File | Settings | File Templates.
 */
public class QueryResult<T> {
    private List<T> resultlist;
    private long totalrecord;

    public List<T> getResultlist() {
        return resultlist;
    }
    public void setResultlist(List<T> resultlist) {
        this.resultlist = resultlist;
    }
    public long getTotalrecord() {
        return totalrecord;
    }
    public void setTotalrecord(long totalrecord) {
        this.totalrecord = totalrecord;
    }
}
