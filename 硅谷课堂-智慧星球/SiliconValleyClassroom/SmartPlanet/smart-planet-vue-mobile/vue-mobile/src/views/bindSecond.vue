<template>
  <div>
    <head>
      <!-- 设置 referrer 为 no-referrer，用于绕过防盗链限制，从而正常显示图片 -->
      <meta name="referrer" content="no-referrer" />
    </head>

    <van-image
      width="100%"
      height="200"
      src="https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png"
    />
    <div>
      <div style="text-align: center">
        <h2>最后一步，关注“智慧星球”微信公众号</h2>
      </div>
      <div style="text-align: center">
        <van-image
          width="80%"
          src="http://47.93.148.192:8080/../assets/SmartPlanet.png"
        />
      </div>
      <div style="margin: 16px">
        <van-button round block type="danger">长按二维码，添加关注</van-button>
      </div>
    </div>
    <div style="padding: 10px 25px; line-height: 30px; text-align: center">
      <p>目前已有<font color="red">3902</font>人关注“智慧星球”微信公众号</p>
    </div>
  </div>
</template>
