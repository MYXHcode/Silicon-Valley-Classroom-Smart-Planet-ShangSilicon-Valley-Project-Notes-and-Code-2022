# 智慧星球——在线视频学习平台——微服务项目 部署运行说明

[TOC]

## 1、智慧星球项目介绍

智慧星球项目是我作为一名 Java 初学者的第一款微服务实战项目，希望能通过学习和开发这款项目，提高自身编码能力，积累项目开发经验，帮助我拿到校招 Offer。

> 我是一名主修计算机科学与技术的大四学生，同时也是一个编程爱好者。目前，我正在学习 Java Spring，并且经常分享我的学习经验。我对 Unity 很感兴趣，希望将来成为一名独立的游戏开发者。
>
> 在夜空所有星星熄灭的时候，所有梦想、所有溪流，都能汇入同一片大海中，那时我们终会相见。
>
> 联系方式：
>
> QQ: 1735350920
>
> WeChat 微信: MYXH1735350920
>
> Email 邮箱: denglei_myxh@qq.com
>
> Twitter 推特: https://twitter.com/MYXH1735350920
>
> Bilibili 哔哩哔哩: https://b23.tv/F3Nv0DP
>
> GitHub: https://github.com/MYXHcode
>
> CSDN: https://blog.csdn.net/qq_40734758

## 2、创建 MySQL 数据库

![创建 MySQL 数据库](https://img-blog.csdnimg.cn/614b222b7c6d49dd80fb00d820a83ff7.png)

![创建 MySQL 数据库](https://img-blog.csdnimg.cn/b072d5b0d80a4385913bd54eeb636470.png)

## 3、启动 Ngrok 内网穿透

### 3.1、隧道管理

![隧道管理](https://img-blog.csdnimg.cn/14eef8f625bf4fc2b1665b74f04536de.png)

![隧道管理](https://img-blog.csdnimg.cn/8d8b863f1789486e8a639add7eb1966d.png)

### 3.2、隧道详情

| 隧道 id      | 隧道名称          | 隧道协议 | 本地端口       | 服务器类型                                           | 到期日期   | 赠送域名                                    |
| ------------ | ----------------- | -------- | -------------- | ---------------------------------------------------- | ---------- | ------------------------------------------- |
| 194301414363 | SmartPlanet       | http     | 127.0.0.1:8333 | Ngrok [(客户端下载)](https://ngrok.cc/download.html) | 免费不过期 | http://smartplanet.free.idcfengye.com       |
| 103050414405 | SmartPlanetMobile | http     | 127.0.0.1:8080 | Ngrok [(客户端下载)](https://ngrok.cc/download.html) | 免费不过期 | http://smartplanetmobile.free.idcfengye.com |

### 3.3、启动隧道

![启动隧道](https://img-blog.csdnimg.cn/49e3b089b0cb405c9030a7985d08d7c2.png)

![启动隧道](https://img-blog.csdnimg.cn/789fedbeef1448babc50e62d3b0e7229.png)

## 4、启动 Nacos 服务注册中心

**启动命令：**

```shell
startup.cmd -m standalone
```

![启动 Nacos 服务注册中心](https://img-blog.csdnimg.cn/05fafbb6880f4968954714704f1e084e.png)

## 5、启动后端微服务

![启动后端微服务](https://img-blog.csdnimg.cn/ff6dbc58ddcd429098dc855f95a4bb1f.png)

## 6、启动前端管理员界面

**启动命令：**

```shell
npm run dev
```

![启动前端管理员界面](https://img-blog.csdnimg.cn/06997547e41d46059f071923313e6acd.png)

![启动前端管理员界面](https://img-blog.csdnimg.cn/0b3a3ea60cd24ef0b662a372011d1195.png)

## 7、启动前端公众号界面

**启动命令：**

```shell
npm run serve
```

![启动前端公众号界面](https://img-blog.csdnimg.cn/3ca892efc8234d85b8321667d2ecb9d4.png)

## 8、关注微信公众号测试号-智慧星球

（1）微信公众号测试号的支付功能无法测试，微信授权功能有些问题，微信用户账号 token 会过期，需要使用微信公众号正式号才可以测试。

![关注微信公众号测试号-智慧星球](https://img-blog.csdnimg.cn/89be41931f8247cd87f0b3792dca51f9.png)

（2）可以使用手机端微信直接测试，或者安装 PC 端微信测试。

![关注微信公众号测试号-智慧星球](https://img-blog.csdnimg.cn/3b422b2638b4492fa133776abb0faacb.png)

![关注微信公众号测试号-智慧星球](https://img-blog.csdnimg.cn/216c56e610564b028aeaeea5a6768566.png)
