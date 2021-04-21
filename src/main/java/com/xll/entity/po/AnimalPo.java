package com.xll.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("animal")
public class AnimalPo implements Serializable {

    private static final long serialVersionUID=1L;
    // aid主键自增 IdType.AUTO
    @TableId(value = "aid", type = IdType.AUTO)
    private Integer aid;

    private String color;

    private Double weight;

    private String name;


}
