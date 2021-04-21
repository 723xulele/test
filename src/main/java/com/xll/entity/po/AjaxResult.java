package com.xll.entity.po;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author : XuLeLe
 * @Date : 2021/01/27/16:56
 * @Description:
 */
@Data
public class AjaxResult {
    private Integer status;
    private String msg;
    private Object obj;

    public static AjaxResult markSuccess() {
       AjaxResult mrv = new AjaxResult();
       mrv.setStatus(0);
       return mrv;
   }
   public static AjaxResult markSuccess(Object obj) {
       AjaxResult mrv = new AjaxResult();
       mrv.setStatus(0);
       mrv.setObj(obj);
       return mrv;
   }
   public static AjaxResult markSuccess(Object obj,String msg) {
       AjaxResult mrv = new AjaxResult();
       mrv.setStatus(0);
       mrv.setObj(obj);
       mrv.setMsg(msg);
       return mrv;
   }

   public static AjaxResult markSuccess(String msg) {
       AjaxResult mrv = new AjaxResult();
       mrv.setStatus(1);
       mrv.setMsg(msg);
       return mrv;
   }
}
