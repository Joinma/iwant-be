package com.liori.mapper.wishlist;

import com.liori.mapper.base.BaseMapper;
import com.liori.model.wishlist.WishList;
import com.liori.model.wishlist.WishListExample;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>愿望清单的映射器</p>
 * <b>created on 2019-06-10 21:13:13</b>
 *
 * @author liori
 * @since 0.1
 */
@Mapper
@Repository
public interface WishListMapper extends BaseMapper<WishList, WishListExample> {

}