package com.myxh.smart.planet.activity.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myxh.smart.planet.activity.service.CouponInfoService;
import com.myxh.smart.planet.model.activity.CouponInfo;
import com.myxh.smart.planet.model.activity.CouponUse;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.activity.CouponUseQueryVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/15
 *
 * <p>
 * 优惠券信息 前端控制器
 * </p>
 */
@Tag(name = "优惠券信息管理", description = "优惠券信息管理接口")
@RestController
@RequestMapping("/admin/activity/coupon/info")
public class CouponInfoController
{
    @Autowired
    private CouponInfoService couponInfoService;

    /**
     * 条件查询优惠券分页
     *
     * @param current 当前页码
     * @param limit   每页记录数
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "条件查询优惠券分页", description = "条件查询优惠券分页")
    @GetMapping("find/query/page/{current}/{limit}")
    public Result<IPage<CouponInfo>> couponInfoList(
            @Parameter(name = "current", description = "当前页码", required = true) @PathVariable("current") Long current,
            @Parameter(name = "limit", description = "每页记录数", required = true) @PathVariable("limit") Long limit)
    {
        Page<CouponInfo> couponInfoPageParam = new Page<>(current, limit);
        IPage<CouponInfo> couponInfoPageModel = couponInfoService.page(couponInfoPageParam);

        return Result.ok(couponInfoPageModel);
    }

    /**
     * 根据 id 查询优惠券
     *
     * @param id id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "查询", description = "根据 id 查询优惠券")
    @GetMapping("get/{id}")
    public Result<CouponInfo> get(@PathVariable("id") String id)
    {
        CouponInfo couponInfo = couponInfoService.getById(id);

        return Result.ok(couponInfo);
    }

    /**
     * 添加优惠券
     *
     * @param couponInfo 优惠券数据
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "添加", description = "添加优惠券")
    @PostMapping("save")
    public Result<Void> save(@RequestBody CouponInfo couponInfo)
    {
        couponInfoService.save(couponInfo);

        return Result.ok(null);
    }

    /**
     * 修改优惠券
     *
     * @param couponInfo 优惠券数据
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "修改", description = "修改优惠券")
    @PutMapping("update")
    public Result<Void> updateById(@RequestBody CouponInfo couponInfo)
    {
        couponInfoService.updateById(couponInfo);

        return Result.ok(null);
    }

    /**
     * 逻辑删除优惠券
     *
     * @param id id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "删除", description = "逻辑删除优惠券")
    @DeleteMapping("remove/{id}")
    public Result<Void> remove(@PathVariable("id") String id)
    {
        couponInfoService.removeById(id);

        return Result.ok(null);
    }

    /**
     * 批量删除优惠券
     *
     * @param idList id 数组，Json 数组 [1,2,3,...]
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "批量删除", description = "批量删除优惠券")
    @DeleteMapping("remove/batch")
    public Result<Void> batchRemove(@RequestBody List<String> idList)
    {
        couponInfoService.removeByIds(idList);

        return Result.ok(null);
    }

    /**
     * 条件查询已经使用的优惠券分页
     *
     * @param current 当前页码
     * @param limit   每页记录数
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "条件查已经使用的优惠券分页", description = "条件查已经使用的优惠券分页")
    @GetMapping("coupon/use/{current}/{limit}")
    public Result<IPage<CouponUse>> couponUseList(
            @Parameter(name = "current", description = "当前页码", required = true)
            @PathVariable("current") Long current,
            @Parameter(name = "limit", description = "每页记录数", required = true)
            @PathVariable("limit") Long limit,
            @Parameter(name = "couponUseVo", description = "查询对象")
           CouponUseQueryVo couponUseQueryVo)
    {
        Page<CouponUse> couponUsePageParam = new Page<>(current, limit);
        IPage<CouponUse> couponUsePageModel = couponInfoService.selectCouponUsePage(couponUsePageParam, couponUseQueryVo);

        return Result.ok(couponUsePageModel);
    }
}
