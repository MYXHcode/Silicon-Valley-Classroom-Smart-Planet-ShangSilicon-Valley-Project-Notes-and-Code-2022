package com.myxh.smart.planet;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;

/**
 * @author MYXH
 * @date 2023/10/15
 */
public class CodeGet
{
    public static void main(String[] args)
    {
        // 1、使用 FastAutoGenerator 的 create 方法创建代码生成器
        // 2、设置数据源配置
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/smart_planet_activity", "MYXH", "520.ILY!")
                // 3、设置全局配置
                .globalConfig(builder ->
                {
                    // 设置作者
                    builder.author("MYXH")
                            // 设置注释日期
                            .commentDate("yyyy/MM/dd")
                            // 设置禁止打开输出目录
                            .disableOpenDir()
                            // 设置输出目录
                            .outputDir("service\\service-activity\\src\\main\\java");

                })
                // 设置数据源配置
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) ->
                {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;

                    if (typeCode == Types.SMALLINT)
                    {
                        // 设置自定义类型转换
                        return DbColumnType.INTEGER;
                    }

                    return typeRegistry.getColumnType(metaInfo);
                }))
                // 4、设置包配置
                .packageConfig(builder ->
                {
                    // 设置父包名
                    builder.parent("com.myxh.smart.planet")
                            // 设置父包模块名
                            .moduleName("activity");
                })
                // 5、设置策略配置
                .strategyConfig(builder ->
                {
                    // 设置需要生成的表名
                    builder.
                            addInclude("coupon_info", "coupon_use")
                            // 设置过滤表前缀
                            .addTablePrefix("t_", "c_")
                            .entityBuilder()
                            // 设置 Lombok 模型 @Accessors(chain = true)，setter 链式操作
                            .enableLombok()
                            // 设置数据库表映射到实体的命名策略
                            .naming(NamingStrategy.underline_to_camel)
                            // 设置数据库表字段映射到实体的命名策略
                            .columnNaming(NamingStrategy.underline_to_camel)
                            .serviceBuilder()
                            // 设置格式化 service 接口文件名称，去掉 Service 接口的首字母 I
                            .formatServiceFileName("%sService")
                            .controllerBuilder()
                            // 设置 URL中驼峰转连字符
                            .enableHyphenStyle()
                            // 设置 RESTful API风格控制器
                            .enableRestStyle();
                })
                // 设置 Freemarker 引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                // 6、执行
                .execute();
    }
}
