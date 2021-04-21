package com.xll.entity;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author : XuLeLe
 * @Date : 2021/03/12/9:19
 * @Description:
 */
public class DavpMailConfigPo implements Serializable {

    private String contentType;

    public DavpMailConfigPo() {
    }

    public DavpMailConfigPo(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return "DavpMailConfigPo{" +
                "contentType='" + contentType + '\'' +
                '}';
    }
}
