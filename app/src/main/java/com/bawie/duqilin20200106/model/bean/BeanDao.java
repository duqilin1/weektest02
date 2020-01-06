package com.bawie.duqilin20200106.model.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/*
 *@auther:杜其林
 *@Date: 2020/1/6
 *@Time:10:22
 *@Description:${DESCRIPTION}
 * */
@Entity
public class BeanDao {
     private String bena;

     @Generated(hash = 1113811972)
     public BeanDao(String bena) {
         this.bena = bena;
     }

     @Generated(hash = 1438189893)
     public BeanDao() {
     }

     public String getBena() {
         return this.bena;
     }

     public void setBena(String bena) {
         this.bena = bena;
     }

}
