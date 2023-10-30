package com.myxh.smart.planet.vo.live;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Data
@Schema(description = "直播课程商品")
public class LiveCourseGoodsView
{
    @Schema(description = "商品名称")
    private String name;

    @Schema(description = "图片")
    private String img;

    @Schema(description = "商品现价")
    private String price;

    @Schema(description = "商品原价")
    private String originalPrice;

    @Schema(description = "商品标签")
    private String tab;

    @Schema(description = "商品链接")
    private String url;

    @Schema(description = "商品状态：0 -> 下架，1 -> 上架，2 -> 推荐")
    private String putAway;

    @Schema(description = "购买模式：1 -> 链接购买，2 -> 二维码购买")
    private String pay;

    @Schema(description = "商品二维码")
    private String qrcode = "";
}
