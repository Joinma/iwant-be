package com.liori.controller.wishlist;

import com.github.pagehelper.PageInfo;
import com.liori.common.message.MessageEnum;
import com.liori.common.utils.message.MessageUtil;
import com.liori.model.wishlist.WishList;
import com.liori.service.wishlist.WishListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * <p>愿望清单的控制器</p>
 * <b>created on 2019-06-10 21:13:13</b>
 *
 * @author liori
 * @since 0.1
 */
@Api(value = "愿望清单Controller", tags = {"愿望清单接口"})
@RestController
@RequestMapping(value = "/api/wishlists")
public class WishListController {

    private final static Logger LOG = LoggerFactory.getLogger(WishListController.class);

    @Autowired
    private WishListService wishListService;

    @ApiOperation(value = "新增愿望清单", notes = "添加一个愿望清单")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> saveWishList(
            @ApiParam(name = "愿望清单信息", required = true) @RequestBody WishList wishList) {
        try {
            final WishList insertedWishList = wishListService.saveEntitySelective(wishList);
            return MessageUtil.success(insertedWishList, HttpStatus.OK);
        } catch (Throwable throwable) {
            LOG.error(MessageEnum.FAIL_TO_CREATE.getMessage(), throwable);
            return MessageUtil.error(MessageEnum.FAIL_TO_CREATE, throwable);
        }
    }

    @ApiOperation(value = "删除单个愿望清单", notes = "根据 id 删除单个愿望清单信息")
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> deleteWishList(
            @ApiParam(value = "id", required = true) @PathVariable(value = "id") String id) {
        try {
            final String deletedId = wishListService.deleteEntity(id);
            return MessageUtil.success(deletedId, HttpStatus.OK);
        } catch (Throwable throwable) {
            LOG.error(MessageEnum.FAIL_TO_UPDATE.getMessage(), throwable);
            return MessageUtil.error(MessageEnum.FAIL_TO_UPDATE, throwable);
        }
    }

    @ApiOperation(value = "获取单个愿望清单", notes = "根据 id 获取愿望清单信息")
    @GetMapping(value = "/query/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getSingleWishList(
            @ApiParam(value = "id", required = true) @PathVariable(value = "id") String id) {
        try {
            final WishList wishList = wishListService.selectSingleEntity(id);
            return MessageUtil.success(wishList, HttpStatus.OK);
        } catch (Throwable throwable) {
            LOG.error(MessageEnum.FAIL_TO_QUERY.getMessage(), throwable);
            return MessageUtil.error(MessageEnum.FAIL_TO_QUERY, throwable);
        }
    }

    @ApiOperation(value = "根据参数分页获取愿望清单", notes = "根据参数分页获取愿望清单信息")
    @GetMapping(value = "/query", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getwishLists(
            @ApiParam(value = "页码", defaultValue = "1") @RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
            @ApiParam(value = "每页加载量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
        try {
            WishList wishList = new WishList();
            final PageInfo<WishList> wishLists = wishListService.selectWishListsByExample(wishList, pageNum, pageSize);
            return MessageUtil.success(wishLists, HttpStatus.OK);
        } catch (Throwable throwable) {
            LOG.error(MessageEnum.FAIL_TO_QUERY.getMessage(), throwable);
            return MessageUtil.error(MessageEnum.FAIL_TO_QUERY, throwable);
        }
    }

    @ApiOperation(value = "更新愿望清单", notes = "更新愿望清单信息")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> updateWishList(
          @ApiParam(name = "愿望清单信息", required = true) @RequestBody WishList wishList) {
        try {
            final WishList updatedWishList = wishListService.updateEntitySelective(wishList);
            return MessageUtil.success(updatedWishList, HttpStatus.OK);
        } catch (Throwable throwable) {
            LOG.error(MessageEnum.FAIL_TO_UPDATE.getMessage(), throwable);
            return MessageUtil.error(MessageEnum.FAIL_TO_UPDATE, throwable);
        }
    }
}