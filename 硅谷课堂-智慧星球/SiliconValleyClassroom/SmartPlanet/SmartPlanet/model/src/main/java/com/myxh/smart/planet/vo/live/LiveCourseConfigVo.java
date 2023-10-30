package com.myxh.smart.planet.vo.live;

import com.myxh.smart.planet.model.live.LiveCourseConfig;
import com.myxh.smart.planet.model.live.LiveCourseGoods;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "直播课程配置")
public class LiveCourseConfigVo extends LiveCourseConfig
{
    @Schema(description = "商品列表")
    private List<LiveCourseGoods> liveCourseGoodsList;
}
