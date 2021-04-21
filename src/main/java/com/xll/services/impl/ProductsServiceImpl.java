package com.xll.services.impl;

import com.xll.entity.po.ProductsPo;
import com.xll.mapper.ProductsMapper;
import com.xll.service.ProductsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author XuLeLe
 * @since 2021-01-27
 */
@Service
public class ProductsServiceImpl extends ServiceImpl<ProductsMapper, ProductsPo> implements ProductsService {

}
