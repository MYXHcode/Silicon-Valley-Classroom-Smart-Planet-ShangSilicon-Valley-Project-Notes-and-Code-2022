package com.myxh.smart.planet.model.live;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.myxh.smart.planet.model.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "直播课程商品")
@TableName("live_course_goods")
public class LiveCourseGoods extends BaseEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "直播课程ID")
    @TableField("live_course_id")
    private Long liveCourseId;

    @Schema(description = "推荐点播课程ID")
    @TableField("goods_id")
    private Long goodsId;

    @Schema(description = "商品名称")
    @TableField("name")
    private String name;

    @Schema(description = "图片")
    @TableField("img")
    private String img;

    @Schema(description = "商品现价")
    @TableField("price")
    private String price;

    @Schema(description = "商品原价")
    @TableField("originalPrice")
    private String originalPrice;

    @Schema(description = "商品标签")
    @TableField("tab")
    private Integer tab;

    @Schema(description = "商品链接")
    @TableField("url")
    private String url;

    @Schema(description = "商品状态：0 -> 下架，1 -> 上架，2 -> 推荐")
    @TableField("put_away")
    private String putAway;

    @Schema(description = "购买模式：1 -> 链接购买，2 -> 二维码购买")
    @TableField("pay")
    private Integer pay;

    @Schema(description = "商品二维码")
    @TableField("qrcode")
    private String qrcode;
}
