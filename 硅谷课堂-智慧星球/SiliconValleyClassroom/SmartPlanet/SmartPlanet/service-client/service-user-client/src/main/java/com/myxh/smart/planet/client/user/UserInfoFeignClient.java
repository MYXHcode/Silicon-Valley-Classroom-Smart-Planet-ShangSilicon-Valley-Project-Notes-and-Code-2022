package com.myxh.smart.planet.client.user;

import com.myxh.smart.planet.model.user.UserInfo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author MYXH
 * @date 2023/10/15
 */
@FeignClient("service-user")
public interface UserInfoFeignClient
{
    @Operation(summary = "查询", description = "根据 id 查询用户信息")
    @GetMapping("/admin/user/user/info/inner/get/{id}")
    UserInfo getUserInfoById(@PathVariable("id") Long id);
}
