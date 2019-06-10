package com.liori.service.wishlist.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liori.mapper.base.BaseMapper;
import com.liori.mapper.wishlist.WishListMapper;
import com.liori.model.wishlist.WishList;
import com.liori.model.wishlist.WishListExample;
import com.liori.service.base.impl.BaseServiceImpl;
import com.liori.service.wishlist.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


/**
 * <p>愿望清单的接口实现类</p>
 * <b>created on 2019-06-10 21:13:13</b>
 *
 * @author liori
 * @since 0.1
 */
@Service
public class WishListServiceImpl extends BaseServiceImpl<WishList, WishListExample> implements WishListService {


    @Autowired
    private WishListMapper wishListMapper;

     @Override
    public BaseMapper<WishList, WishListExample> getSpecificMapper() {
        return wishListMapper;
    }

    @Override
    public PageInfo<WishList> selectWishListsByExample(WishList wishList, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        WishListExample wishListExample = new WishListExample();
        List<WishList> wishLists = wishListMapper.selectByExample(wishListExample);
        return new PageInfo<>(wishLists);
    }
}
