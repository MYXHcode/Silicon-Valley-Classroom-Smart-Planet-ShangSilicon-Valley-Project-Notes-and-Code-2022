package com.myxh.smart.planet.wechat.service.impl;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.exception.SmartPlanetException;
import com.myxh.smart.planet.model.wechat.Menu;
import com.myxh.smart.planet.vo.wechat.MenuVo;
import com.myxh.smart.planet.wechat.mapper.MenuMapper;
import com.myxh.smart.planet.wechat.service.MenuService;
import lombok.SneakyThrows;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/16
 *
 * <p>
 * 菜单 服务实现类
 * </p>
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService
{
    @Autowired
    private WxMpService wxMpService;

    /**
     * 获取所有菜单，按照一级和二级菜单封装
     *
     * @return menuList 菜单列表
     */
    @Override
    public List<MenuVo> findMenuInfo()
    {
        // 1、创建 List 集合，用于最终数据封装
        List<MenuVo> finalMenuList = new ArrayList<>();

        // 2、查询所有菜单数据（包含一级和二级）
        List<Menu> menuList = baseMapper.selectList(null);

        // 3、从所有菜单数据获取所有一级菜单数据（parentId = 0）
        List<Menu> oneMenuList = menuList.stream().filter(menu -> menu.getParentId() == 0).toList();

        // 4、封装一级菜单数据，封装到最终数据 List 集台
        // 遍历一级菜单 List 集合
        for (Menu oneMenu : oneMenuList)
        {
            MenuVo oneMenuVo = new MenuVo();
            BeanUtils.copyProperties(oneMenu, oneMenuVo);

            // 5、封装二级菜单数据（判断一级菜单和二级菜单 parentId是否相同）
            // 如果相同，把二级菜单数据放到一级菜单里面
            List<Menu> twoMenuList = menuList.stream().filter(menu -> menu.getParentId().longValue() == oneMenu.getId()).sorted(Comparator.comparing(Menu::getSort)).toList();

            List<MenuVo> children = new ArrayList<>();

            for (Menu twoMenu : twoMenuList)
            {
                MenuVo twoMenuVo = new MenuVo();
                BeanUtils.copyProperties(twoMenu, twoMenuVo);
                children.add(twoMenuVo);
            }

            // 把二级菜单数据放到一级菜单里面
            oneMenuVo.setChildren(children);

            // 把 oneMenuVo 放到最终 List 集合
            finalMenuList.add(oneMenuVo);
        }

        // 返回最终数据
        return finalMenuList;
    }

    /**
     * 获取所有一级菜单
     *
     * @return oneMenuList 一级菜单列表
     */
    @Override
    public List<Menu> findMenuOneInfo()
    {
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", 0);
        List<Menu> oneMenuList = baseMapper.selectList(wrapper);

        return oneMenuList;
    }

    /**
     * 同步微信公众号菜单
     */
    @SneakyThrows
    @Override
    public void syncMenu()
    {
        // 获取所有菜单数据
        List<MenuVo> menuVoList = this.findMenuInfo();

        // 封装 button 里面结构，数组格式
        JSONArray buttonList = new JSONArray();

        for (MenuVo oneMenuVo : menuVoList)
        {
            // json 对象，一级菜单
            JSONObject one = new JSONObject();
            one.put("name", oneMenuVo.getName());

            // json 数组，二级菜单
            JSONArray subButton = new JSONArray();

            for (MenuVo twoMenuVo : oneMenuVo.getChildren())
            {
                JSONObject view = new JSONObject();
                view.put("type", twoMenuVo.getType());
                view.put("name", twoMenuVo.getName());

                if (twoMenuVo.getType().equals("view"))
                {
                    view.put("url", "http://smartplanetmobile.free.idcfengye.com/#" + twoMenuVo.getUrl());
                }
                else
                {
                    view.put("key", twoMenuVo.getMenuKey());
                }

                subButton.add(view);
            }

            one.put("sub_button", subButton);
            buttonList.add(one);
        }

        // 封装最外层 button 部分
        JSONObject button = new JSONObject();
        button.put("button", buttonList);

        try
        {
            String menuId = this.wxMpService.getMenuService().menuCreate(button.toJSONString());
            System.out.println("menuId = " + menuId);

        }
        catch (Exception e)
        {
            throw new SmartPlanetException(20001,"微信公众号菜单同步失败");
        }
    }

    /**
     * 删除微信公众号菜单
     */
    @Override
    public void removeMenu()
    {
        try
        {
            wxMpService.getMenuService().menuDelete();
        }
        catch (WxErrorException e)
        {
            throw new SmartPlanetException(20001, "微信公众号菜单删除失败");
        }
    }
}
