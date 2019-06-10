package com.liori.service.wishlist;

import com.github.pagehelper.PageInfo;
import com.liori.model.wishlist.WishList;
import com.liori.model.wishlist.WishListExample;
import com.liori.service.base.BaseService;
import org.springframework.stereotype.Service;

/**
 * <p>愿望清单的接口类</p>
 * <b>created on 2019-06-10 21:13:13</b>
 *
 * @author liori
 * @since 0.1
 */
@Service
public interface WishListService extends BaseService<WishList, WishListExample> {

    /**
     * 分页查询愿望清单
     *
     * @param wishList
     * @param pageNum 页码
     * @param pageSize 每页加载量
     * @return PageInfo<WishList>
     */
    PageInfo<WishList> selectWishListsByExample(WishList wishList, Integer pageNum, Integer pageSize);

}
