package com.myxh.smart.planet.wechat.controller;

import com.alibaba.fastjson2.JSONObject;
import com.myxh.smart.planet.exception.SmartPlanetException;
import com.myxh.smart.planet.model.wechat.Menu;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.wechat.MenuVo;
import com.myxh.smart.planet.wechat.service.MenuService;
import com.myxh.smart.planet.wechat.utils.ConstantPropertiesUtil;
import com.myxh.smart.planet.wechat.utils.HttpClientUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/16
 *
 * <p>
 * 菜单 前端控制器
 * </p>
 */
@Tag(name = "微信公众号菜单管理", description = "微信公众号菜单管理接口")
@RestController
@RequestMapping("/admin/wechat/menu")
public class MenuController
{
    @Autowired
    private MenuService menuService;

    /**
     * 获取所有菜单，按照一级和二级菜单封装
     *
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "获取所有菜单", description = "获取所有菜单，按照一级和二级菜单封装")
    @GetMapping("find/menu/info")
    public Result<List<MenuVo>> findMenuInfo()
    {
        List<MenuVo> menuList = menuService.findMenuInfo();

        return Result.ok(menuList);
    }

    /**
     * 获取所有一级菜单
     *
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "获取所有一级菜单", description = "获取所有一级菜单")
    @GetMapping("find/one/menu/info")
    public Result<List<Menu>> findOneMenuInfo()
    {
        List<Menu> oneMenuList = menuService.findMenuOneInfo();

        return Result.ok(oneMenuList);
    }

    /**
     * 根据 id 查询菜单
     *
     * @param id id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "查询", description = "根据 id 查询菜单")
    @GetMapping("get/{id}")
    public Result<Menu> get(@PathVariable("id") Long id)
    {
        Menu menu = menuService.getById(id);

        return Result.ok(menu);
    }

    /**
     * 添加菜单
     *
     * @param menu 菜单
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "添加", description = "添加菜单")
    @PostMapping("save")
    public Result<Void> save(@RequestBody Menu menu)
    {
        menuService.save(menu);

        return Result.ok(null);
    }

    /**
     * 修改菜单
     *
     * @param menu 菜单
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "修改", description = "修改菜单")
    @PutMapping("update")
    public Result<Void> updateById(@RequestBody Menu menu)
    {
        menuService.updateById(menu);

        return Result.ok(null);
    }

    /**
     * 逻辑删除菜单
     *
     * @param id id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "删除", description = "逻辑删除菜单")
    @DeleteMapping("remove/{id}")
    public Result<Void> remove(@PathVariable("id") Long id)
    {
        menuService.removeById(id);

        return Result.ok(null);
    }

    /**
     * 批量删除菜单
     *
     * @param idList id 数组，Json 数组 [1,2,3,...]
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "批量删除", description = "批量删除菜单")
    @DeleteMapping("remove/batch")
    public Result<Void> batchRemove(@RequestBody List<Long> idList)
    {
        menuService.removeByIds(idList);

        return Result.ok(null);
    }

    /**
     * 获取 access_token
     *
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "获取 access_token", description = "获取 access_token")
    @GetMapping("get/access/token")
    public Result<String> getAccessToken()
    {
        try
        {
            // 拼接请求地址
            String buffer = "https://api.weixin.qq.com/cgi-bin/token" +
                    "?grant_type=client_credential" +
                    "&appid=%s" +
                    "&secret=%s";

            // 请求地址设置参数
            String url = String.format(buffer,
                    ConstantPropertiesUtil.ACCESS_KEY_ID,
                    ConstantPropertiesUtil.ACCESS_KEY_SECRET);

            // 发送 http 请求
            String tokenString = HttpClientUtils.get(url);

            // 获取 access_token
            JSONObject jsonObject = JSONObject.parseObject(tokenString);
            String access_token = jsonObject.getString("access_token");

            // 返回
            return Result.ok(access_token);
        }
        catch (Exception e)
        {
            e.printStackTrace();

            throw new SmartPlanetException(20001, "获取 access_token 失败");
        }
    }

    /**
     * 同步微信公众号菜单
     *
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "同步微信公众号菜单", description = "同步微信公众号菜单")
    @GetMapping("sync/menu")
    public Result<Void> createMenu()
    {
        menuService.syncMenu();

        return Result.ok(null);
    }

    /**
     * 删除微信公众号菜单
     *
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "删除微信公众号菜单", description = "删除微信公众号菜单")
    @DeleteMapping("remove/menu")
    public Result<Void> removeMenu()
    {
        menuService.removeMenu();

        return Result.ok(null);
    }
}
