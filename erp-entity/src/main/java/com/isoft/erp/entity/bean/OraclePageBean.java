package com.isoft.erp.entity.bean;

import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/4/2.
 */
@SuppressWarnings("All")
public class OraclePageBean<T> {

    private Integer total=0;//总共几条记录
    private Integer pageNumber=1;//当前是第几页
    private Integer pageSize=10;//每页显示几条数据
    private List<T> rows;//每页显示的记录的具体内容

    private Integer totalPage;//总共可以分多少页

    private Map<String,Object> conditions;//可以设置sql查询条件
    private String sortOrder="";//'asc','desc'
    private String sortName="";//'uuid'

    private String sqlPrefix="";
    private String sqlSuffix="";

    private OraclePageBean(){

    }

    public OraclePageBean(Integer pageNumber, Integer pageSize,Integer total){
        this.pageNumber=pageNumber;
        this.pageSize=pageSize;
        this.total=total;
        if((total/pageSize)%2==0){
            this.totalPage=total/pageSize;
        }else if((total/pageSize)%2!=0){
            this.totalPage=(total/pageSize)+1;
        }
    }

    public OraclePageBean(Integer pageNumber, Integer pageSize,Integer total,String sortName,String sortOrder){
        this.pageNumber=pageNumber;
        this.pageSize=pageSize;
        this.sortName=sortName;
        this.sortOrder=sortOrder;
        this.rows=rows;
        this.total=total;
        if((total/pageSize)%2==0){
            this.totalPage=total/pageSize;
        }else if((total/pageSize)%2!=0){
            this.totalPage=(total/pageSize)+1;
        }
    }

    public OraclePageBean(Integer pageNumber, Integer pageSize,Integer total,String sortName,String sortOrder,Map<String,Object> conditions){
        this.pageNumber=pageNumber;
        this.pageSize=pageSize;
        this.sortName=sortName;
        this.sortOrder=sortOrder;
        this.rows=rows;
        this.total=total;
        this.conditions=conditions;
        if((total/pageSize)%2==0){
            this.totalPage=total/pageSize;
        }else if((total/pageSize)%2!=0){
            this.totalPage=(total/pageSize)+1;
        }
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSqlPrefix(){
        return "select * from ( select row_.*, rownum rownum_ from (";
    }

    public String getSqlSuffix(){
        return ") row_ ) where  rownum_ >" + getStartRowNum() + "  and  rownum_ <=" + getEndRowNum()+" "+"order by"+" "+sortName+" "+sortOrder;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getStartRowNum(){//起始行号,告诉sql从第几条查起
        return (pageNumber-1)*pageSize;
    }

    public Integer getEndRowNum(){//结束行号,告诉sql从第几条结束查询
        return pageNumber*pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Map<String, Object> getConditions() {
        return conditions;
    }

    public void setConditions(Map<String, Object> conditions) {
        this.conditions = conditions;
    }

}
