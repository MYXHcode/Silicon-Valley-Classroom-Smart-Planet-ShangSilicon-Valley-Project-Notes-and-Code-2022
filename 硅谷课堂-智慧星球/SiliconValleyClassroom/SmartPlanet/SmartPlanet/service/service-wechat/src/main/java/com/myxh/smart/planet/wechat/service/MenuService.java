package com.myxh.smart.planet.wechat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.wechat.Menu;
import com.myxh.smart.planet.vo.wechat.MenuVo;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/16
 *
 * <p>
 * 菜单 服务类
 * </p>
 */
public interface MenuService extends IService<Menu>
{
    /**
     * 获取所有菜单，按照一级和二级菜单封装
     *
     * @return menuList 菜单列表
     */
    List<MenuVo> findMenuInfo();

    /**
     * 获取所有一级菜单
     *
     * @return oneMenuList 一级菜单列表
     */
    List<Menu> findMenuOneInfo();

    /**
     * 同步微信公众号菜单
     */
    void syncMenu();

    /**
     * 删除微信公众号菜单
     */
    void removeMenu();
}
