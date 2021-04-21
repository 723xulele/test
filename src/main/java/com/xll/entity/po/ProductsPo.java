package com.xll.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("products")
public class ProductsPo implements Serializable {

    private static final long serialVersionUID=1L;

    private String pid;

    private String pname;

    private String pimage;

    private Double price;

    private String tid;


}
