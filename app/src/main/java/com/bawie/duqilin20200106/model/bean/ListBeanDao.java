package com.bawie.duqilin20200106.model.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/*
 *@auther:杜其林
 *@Date: 2020/1/6
 *@Time:10:23
 *@Description:${DESCRIPTION}
 * */
@Entity
public class ListBeanDao {
     private String listBean;

     @Generated(hash = 523617796)
     public ListBeanDao(String listBean) {
         this.listBean = listBean;
     }

     @Generated(hash = 1234878516)
     public ListBeanDao() {
     }

     public String getListBean() {
         return this.listBean;
     }

     public void setListBean(String listBean) {
         this.listBean = listBean;
     }
}
