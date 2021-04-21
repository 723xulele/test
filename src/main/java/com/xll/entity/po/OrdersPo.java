package com.xll.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author XuLeLe
 * @since 2021-01-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("orders")
public class OrdersPo implements Serializable {

    private static final long serialVersionUID=1L;

    private String oid;

    private Double price;

    private String addr;

    @TableField("payType")
    private String payType;

    private Integer uid;


}
