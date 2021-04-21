package com.xll.services.impl;

import com.xll.entity.po.UsersPo;
import com.xll.mapper.UsersMapper;
import com.xll.service.UsersService;
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
public class UsersServiceImpl extends ServiceImpl<UsersMapper, UsersPo> implements UsersService {

}
