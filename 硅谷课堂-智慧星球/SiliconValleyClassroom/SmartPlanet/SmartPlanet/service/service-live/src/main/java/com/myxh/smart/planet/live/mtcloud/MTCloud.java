/**
 * Copyright www.talk-fun.com
 */

package com.myxh.smart.planet.live.mtcloud;

import com.myxh.smart.planet.live.mtcloud.utils.MD5Util;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @author MYXH
 * @date 2023/10/23
 */
public class MTCloud
{
    /**
     * 合作方 ID：合作方在欢拓平台的唯一 ID
     */
    @Value("${mtcloud.openId}")
    public String openID = "";

    /**
     * 合作方秘钥：合作方 ID 对应的参数加密秘钥
     */
    @Value("${mtcloud.openToken}")
    public String openToken = "";

    /**
     * 欢拓 API 接口地址
     */
    public String restUrl = "http://api.talk-fun.com/portal.php";
    public String restUrl2 = "http://api-1.talk-fun.com/portal.php";

    /**
     * 返回的数据格式
     */
    public String format = "json";

    /**
     * SDK 版本号(请勿修改)
     */
    public String version = "java.1.6";

    /**
     * 是否开启测试
     */
    public boolean debug = false;

    /**
     * 状态码
     */
    // 失败
    public static final int CODE_FAIL = -1;

    // 成功
    public static final int CODE_SUCCESS = 0;

    // 参数错误
    public static final int CODE_PARAM_ERROR = 10;

    // 视频已上传过
    public static final int CODE_VIDEO_UPLOADED = 1281;

    // 签名过期
    public static final int CODE_SIGN_EXPIRE = 10002;

    // 签名验证错误
    public static final int CODE_SIGN_ERROR = 10003;

    /**
     * 角色定义
     */
    // 游客
    public static final String ROLE_GUEST = "guest";

    // 普通用户
    public static final String ROLE_USER = "user";

    // 管理员
    public static final String ROLE_ADMIN = "admin";

    // 超级管理员
    public static final String ROLE_SUPER_ADMIN = "spadmin";

    /**
     * 用户定义
     */
    // 未知生物
    public static final int USER_GENDER_UNKNOW = 0;

    // 男性
    public static final int USER_GENDER_MALE = 1;

    // 女性
    public static final int USER_GENDER_FEMALE = 2;

    /**
     * 主播账号类型
     */
    // 欢拓账号类型
    public static final int ACCOUNT_TYPE_MT = 1;

    // 第三方账号类型
    public static final int ACCOUNT_TYPE_THIRD = 2;

    /**
     * 语音常量
     */
    // 语音云
    public static final int VOICE_FLOW_CLOUD = 1;

    // 只听
    public static final int VOICE_FLOW_LISTEN_ONLY = 2;

    // 自动模式
    public static final int VOICE_FLOW_AUTO = 3;

    /**
     * 直播常量
     */
    // 没有回放记录
    public static final int LIVE_NO_PLAYBACK = 0;

    // 有回放记录
    public static final int LIVE_HAS_PLAYBACK = 1;

    // 回放地址，不限制播放用户 IP
    public static final int LIVE_PLAYBACK_NOT_CHECK_USER_IP = 0;

    // 回放地址，限制播放用户 IP
    public static final int LIVE_PLAYBACK_CHECK_USER_IP = 1;

    /**
     * 外部推流分辨率类型
     */
    // 4:3 比例
    public static final int CUSTOM_RTMP_RATIO_4_3 = 1;

    // 16:9 比例
    public static final int CUSTOM_RTMP_RATIO_16_9 = 2;

    public MTCloud()
    {

    }

    public MTCloud(String openID, String openToken)
    {
        this.openID = openID.trim();
        this.openToken = openToken.trim();
    }

    /**
     * 设置欢拓数据响应的格式
     *
     * @param format 返回的数据格式
     */
    public void setFormat(String format)
    {
        this.format = format;
    }

    /**
     * 获取用户 access_token, access_key 及房间地址(替代 roomGetUrl 方法)
     *
     * @param uid      合作方系统内的用户的唯一 ID
     * @param nickname 用户的昵称
     * @param role     用户的角色
     * @param roomid   房间 ID
     * @param expire   返回的地址的有效时间
     * @return String
     * @throws Exception 异常
     */
    public String userAccess(String uid, String nickname, String role, String roomid, int expire) throws Exception
    {
        HashMap<Object, Object> options = new HashMap<>();

        return this.userAccess(uid, nickname, role, roomid, expire, options);
    }

    /**
     * 用户进入直播间
     *
     * @param uid      合作方系统内的用户的唯一 ID
     * @param nickname 用户的昵称
     * @param role     用户的角色
     * @param roomid   房间 ID
     * @param expire   返回的地址的有效时间
     * @param options  可选参数
     * @return String
     * @throws Exception 异常
     */
    public String userAccess(String uid, String nickname, String role, String roomid, int expire, HashMap<Object, Object> options) throws Exception
    {
        if (!options.containsKey("gender"))
        {
            // 用户性别
            options.put("gender", MTCloud.USER_GENDER_UNKNOW);
        }

        if (!options.containsKey("avatar"))
        {
            // 用户头像
            options.put("avatar", "");
        }

        HashMap<Object, Object> params = new HashMap<>();
        params.put("uid", uid);
        params.put("nickname", nickname);
        params.put("role", role);
        params.put("roomid", roomid);
        params.put("expire", expire);
        params.put("options", options);

        return this.call("user.access", params);
    }

    /**
     * 用户进入点播
     *
     * @param uid      合作方系统内的用户的唯一 ID
     * @param nickname 用户的昵称
     * @param role     用户的角色
     * @param liveid   直播 ID
     * @param expire   返回的地址的有效时间
     * @return String
     * @throws Exception 异常
     */
    public String userAccessPlayback(String uid, String nickname, String role, String liveid, int expire) throws Exception
    {
        HashMap<Object, Object> options = new HashMap<>();

        return this.userAccessPlayback(uid, nickname, role, liveid, expire, options);
    }

    /**
     * 用户进入点播
     *
     * @param uid      合作方系统内的用户的唯一 ID
     * @param nickname 用户的昵称
     * @param role     用户的角色
     * @param liveid   直播 ID
     * @param expire   返回的地址的有效时间
     * @param options  可选参数
     * @return String
     * @throws Exception 异常
     */
    public String userAccessPlayback(String uid, String nickname, String role, String liveid, int expire, HashMap<Object, Object> options) throws Exception
    {
        if (!options.containsKey("gender"))
        {
            // 用户性别
            options.put("gender", MTCloud.USER_GENDER_UNKNOW);
        }

        if (!options.containsKey("avatar"))
        {
            // 用户头像地址
            options.put("avatar", "");
        }

        HashMap<Object, Object> params = new HashMap<>();
        params.put("uid", uid);
        params.put("nickname", nickname);
        params.put("role", role);
        params.put("liveid", liveid);
        params.put("expire", expire);
        params.put("options", options);

        return this.call("user.access.playback", params);
    }

    /**
     * 获取直播间地址
     *
     * @param uid      合作方系统内的用户的唯一 ID
     * @param nickname 用户的昵称
     * @param role     用户的角色
     * @param roomid   房间 ID
     * @param expire   返回的地址的有效时间
     * @return String
     * @throws Exception 异常
     */
    public String userAccessUrl(String uid, String nickname, String role, String roomid, int expire) throws Exception
    {
        String accessAuth = this.userAccessKey(uid, nickname, role, roomid, expire);

        return "http://open.talk-fun.com/room.php?accessAuth=" + accessAuth;
    }

    /**
     * 获取直播间验证 key
     *
     * @param uid      合作方系统内的用户的唯一 ID
     * @param nickname 用户的昵称
     * @param role     用户的角色
     * @param roomid   房间 ID
     * @param expire   返回的地址的有效时间
     * @return String
     * @throws Exception 异常
     */
    public String userAccessKey(String uid, String nickname, String role, String roomid, int expire) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("openID", this.openID.trim());
        Date date = new Date();
        long time = date.getTime() / 1000;
        String ts = time + "";
        params.put("timestamp", ts);
        params.put("uid", uid);
        params.put("nickname", nickname);
        params.put("role", role);
        params.put("roomid", roomid);
        params.put("expire", expire);
        params.put("sign", this.generateSign(params));
        String accessAuth = this.base64UrlEncode(JSONObject.fromObject(params).toString());

        return accessAuth;
    }

    /**
     * 获取直播间地址
     *
     * @param uid      合作方系统内的用户的唯一 ID
     * @param nickname 用户的昵称
     * @param role     用户的角色
     * @param roomid   房间 ID
     * @param expire   返回的地址的有效时间
     * @param options  可选参数
     * @return String
     * @throws Exception 异常
     */
    public String userAccessUrl(String uid, String nickname, String role, String roomid, int expire, HashMap<Object, Object> options) throws Exception
    {
        String accessAuth = this.userAccessKey(uid, nickname, role, roomid, expire, options);

        return "http://open.talk-fun.com/room.php?accessAuth=" + accessAuth;
    }

    /**
     * 获取直播间验证 key
     *
     * @param uid      合作方系统内的用户的唯一 ID
     * @param nickname 用户的昵称
     * @param role     用户的角色
     * @param roomid   房间 ID
     * @param expire   返回的地址的有效时间
     * @return String
     * @throws Exception 异常
     */
    public String userAccessKey(String uid, String nickname, String role, String roomid, int expire, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("openID", this.openID.trim());
        Date date = new Date();
        long time = date.getTime() / 1000;
        String ts = time + "";
        params.put("timestamp", ts);
        params.put("uid", uid);
        params.put("nickname", nickname);
        params.put("role", role);
        params.put("roomid", roomid);
        params.put("expire", expire);
        params.put("options", JSONObject.fromObject(options).toString());
        params.put("sign", this.generateSign(params));
        String accessAuth = JSONObject.fromObject(params).toString();
        accessAuth = this.base64UrlEncode(accessAuth);

        return accessAuth;
    }

    /**
     * 获取点播地址
     *
     * @param uid      合作方系统内的用户的唯一 ID
     * @param nickname 用户的昵称
     * @param role     用户的角色
     * @param liveid   直播 ID
     * @param expire   返回的地址的有效时间
     * @return String
     * @throws Exception 异常
     */
    public String userAccessPlaybackUrl(String uid, String nickname, String role, String liveid, int expire) throws Exception
    {
        String accessAuth = this.userAccessPlaybackKey(uid, nickname, role, liveid, expire);

        return "http://open.talk-fun.com/player.php?accessAuth=" + accessAuth;
    }

    /**
     * 获取点播验证 key
     *
     * @param uid      合作方系统内的用户的唯一 ID
     * @param nickname 用户的昵称
     * @param role     用户的角色
     * @param liveid   直播 ID
     * @param expire   返回的地址的有效时间
     * @return String
     * @throws Exception 异常
     */
    public String userAccessPlaybackKey(String uid, String nickname, String role, String liveid, int expire) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("openID", this.openID.trim());
        Date date = new Date();
        long time = date.getTime() / 1000;
        String ts = time + "";
        params.put("timestamp", ts);
        params.put("uid", uid);
        params.put("nickname", nickname);
        params.put("role", role);
        params.put("liveid", liveid);
        params.put("expire", expire);
        params.put("sign", this.generateSign(params));
        String accessAuth = JSONObject.fromObject(params).toString();
        accessAuth = this.base64UrlEncode(accessAuth);

        return accessAuth;
    }

    /**
     * 获取点播地址
     *
     * @param uid      合作方系统内的用户的唯一 ID
     * @param nickname 用户的昵称
     * @param role     用户的角色
     * @param liveid   直播 ID
     * @param expire   返回的地址的有效时间
     * @param options  可选参数
     * @return String
     * @throws Exception 异常
     */
    public String userAccessPlaybackUrl(String uid, String nickname, String role, String liveid, int expire, HashMap<Object, Object> options) throws Exception
    {
        String accessAuth = this.userAccessPlaybackKey(uid, nickname, role, liveid, expire, options);

        return "http://open.talk-fun.com/player.php?accessAuth=" + accessAuth;
    }

    /**
     * 获取点播验证 key
     *
     * @param uid      合作方系统内的用户的唯一 ID
     * @param nickname 用户的昵称
     * @param role     用户的角色
     * @param liveid   主播 ID
     * @param expire   返回的地址的有效时间
     * @return String
     * @throws Exception 异常
     */
    public String userAccessPlaybackKey(String uid, String nickname, String role, String liveid, int expire, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("openID", this.openID.trim());
        Date date = new Date();
        long time = date.getTime() / 1000;
        String ts = time + "";
        params.put("timestamp", ts);
        params.put("uid", uid);
        params.put("nickname", nickname);
        params.put("role", role);
        params.put("liveid", liveid);
        params.put("expire", expire);
        params.put("options", JSONObject.fromObject(options).toString());
        params.put("sign", this.generateSign(params));
        String accessAuth = JSONObject.fromObject(params).toString();
        accessAuth = this.base64UrlEncode(accessAuth);

        return accessAuth;
    }

    /**
     * 获取专辑地址
     *
     * @param uid      合作方系统内的用户的唯一 ID
     * @param nickname 用户的昵称
     * @param role     用户的角色
     * @param album_id 专辑 ID
     * @param expire   返回的地址的有效时间
     * @param options  可选参数
     * @return String
     * @throws Exception 异常
     */
    public String userAccessPlaybackAlbum(String uid, String nickname, String role, String album_id, int expire, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("uid", uid);
        params.put("nickname", nickname);
        params.put("role", role);
        params.put("album_id", album_id);
        params.put("expire", expire);
        params.put("options", options);

        return this.call("user.access.playbackAlbum", params);
    }

    /**
     * 获取专辑地址
     *
     * @param uid      合作方系统内的用户的唯一 ID
     * @param nickname 用户的昵称
     * @param role     用户的角色
     * @param album_id 专辑 ID
     * @param expire   返回的地址的有效时间
     * @param options  可选参数
     * @return String
     * @throws Exception 异常
     */
    public String userAccessPlaybackAlbumUrl(String uid, String nickname, String role, String album_id, int expire, HashMap<Object, Object> options) throws Exception
    {
        String accessAuth = this.userAccessPlaybackAlbumKey(uid, nickname, role, album_id, expire, options);

        return "http://open.talk-fun.com/player.php?accessAuth=" + accessAuth;
    }

    /**
     * 获取专辑播放 key
     *
     * @param uid      合作方系统内的用户的唯一 ID
     * @param nickname 用户的昵称
     * @param role     用户的角色
     * @param album_id 专辑 ID
     * @param expire   返回的地址的有效时间
     * @param options  可选参数
     * @return String
     * @throws Exception 异常
     */
    public String userAccessPlaybackAlbumKey(String uid, String nickname, String role, String album_id, int expire, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("openID", this.openID.trim());
        Date date = new Date();
        long time = date.getTime() / 1000;
        String ts = time + "";
        params.put("timestamp", ts);
        params.put("uid", uid);
        params.put("nickname", nickname);
        params.put("role", role);
        params.put("album_id", album_id);
        params.put("expire", expire);
        params.put("options", JSONObject.fromObject(options).toString());
        params.put("sign", this.generateSign(params));
        String accessAuth = JSONObject.fromObject(params).toString();
        accessAuth = this.base64UrlEncode(accessAuth);

        return accessAuth;
    }

    /**
     * 获取剪辑地址
     *
     * @param uid      合作方系统内的用户的唯一 ID
     * @param nickname 用户的昵称
     * @param role     用户的角色
     * @param clipid   剪辑 ID
     * @param expire   返回的地址的有效时间
     * @param options  可选参数
     * @return String
     * @throws Exception 异常
     */
    public String userAccessPlaybackClip(String uid, String nickname, String role, int clipid, int expire, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("uid", uid);
        params.put("nickname", nickname);
        params.put("role", role);
        params.put("clipid", clipid);
        params.put("expire", expire);
        params.put("options", options);

        return this.call("user.access.playbackClip", params);
    }

    /**
     * 获取剪辑地址
     *
     * @param uid      合作方系统内的用户的唯一 ID
     * @param nickname 用户的昵称
     * @param role     用户的角色
     * @param clipid   剪辑 ID
     * @param expire   返回的地址的有效时间
     * @param options  可选参数
     * @return String
     * @throws Exception 异常
     */
    public String userAccessPlaybackClipUrl(String uid, String nickname, String role, int clipid, int expire, HashMap<Object, Object> options) throws Exception
    {
        String accessAuth = this.userAccessPlaybackClipKey(uid, nickname, role, clipid, expire, options);

        return "http://open.talk-fun.com/player.php?accessAuth=" + accessAuth;
    }

    /**
     * 获取剪辑播放key
     *
     * @param uid      合作方系统内的用户的唯一 ID
     * @param nickname 用户的昵称
     * @param role     用户的角色
     * @param clipid   剪辑 ID
     * @param expire   返回的地址的有效时间
     * @param options  可选参数
     * @return String
     * @throws Exception 异常
     */
    public String userAccessPlaybackClipKey(String uid, String nickname, String role, int clipid, int expire, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("openID", this.openID.trim());
        Date date = new Date();
        long time = date.getTime() / 1000;
        String ts = time + "";
        params.put("timestamp", ts);
        params.put("uid", uid);
        params.put("nickname", nickname);
        params.put("role", role);
        params.put("clipid", clipid);
        params.put("expire", expire);
        params.put("options", JSONObject.fromObject(options).toString());
        params.put("sign", this.generateSign(params));
        String accessAuth = JSONObject.fromObject(params).toString();
        accessAuth = this.base64UrlEncode(accessAuth);

        return accessAuth;
    }

    /**
     * 获取在线用户列表
     *
     * @param roomid     房间 ID
     * @param start_time 查询开始时间，格式: 2015-01-01 12:00:00
     * @param end_time   查询结束时间，格式: 2015-01-01 13:00:00
     * @return String
     * @throws Exception 异常
     */
    public String userOnlineList(String roomid, String start_time, String end_time) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("roomid", roomid);
        params.put("start_time", start_time);
        params.put("end_time", end_time);

        return this.call("user.online.list", params);
    }

    /**
     * 获取主播管理登录地址
     *
     * @param roomid 房间 ID
     * @param expire 返回的地址的有效时间
     * @return String
     * @throws Exception 异常
     */
    public String getManagerUrl(String roomid, int expire, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("openID", this.openID.trim());
        params.put("roomid", roomid);
        params.put("timestamp", new Date().getTime() / 1000);
        params.put("expire", expire);

        if (options.containsKey("nickname"))
        {
            params.put("nickname", options.get("nickname").toString());
        }

        if (options.containsKey("role"))
        {
            params.put("role", options.get("role").toString());
        }

        params.put("sign", this.generateSign(params));
        String code = JSONObject.fromObject(params).toString();
        code = this.base64UrlEncode(code);

        return "http://open.talk-fun.com/live/manager.php?code=" + code;
    }

    /**
     * 获取直播房间地址(使用 userAccess 方法替代)
     *
     * @param uid      合作方系统内的用户的唯一 ID
     * @param nickname 用户的昵称
     * @param role     用户的角色
     * @param roomid   房间 ID
     * @param expire   返回的地址的有效时间
     * @return String
     * @throws Exception 异常
     */
    public String roomGetUrl(String uid, String nickname, String role, String roomid, int expire) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("uid", uid);
        params.put("nickname", nickname);
        params.put("role", role);
        params.put("roomid", roomid);
        params.put("expire", expire);

        return this.call("user.register", params);
    }

    /**
     * 自动创建一个房间 / 频道和主播，并且绑定房间主播的关系
     *
     * @param roomName 房间名称
     * @param authKey  管理员密码
     * @param userKey  普通用户密码
     * @param zhuboKey 主播密码
     * @param modetype 房间模式
     * @param options  可选项，包括：barrage: 弹幕开关 开启: 1 关闭: 0，departmentID：部门 ID，user_top：最高在线用户数，streamMode：小班合流模式配置，1 多人模式，2 双人模式
     * @return String
     * @throws Exception 异常
     */
    public String roomCreatev2(String roomName, String authKey, String userKey, String zhuboKey, int modetype, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("roomName", roomName);
        params.put("authKey", authKey);
        params.put("userKey", userKey);
        params.put("zhuboKey", zhuboKey);
        params.put("modetype", modetype);
        params.put("options", options);

        return this.call("room.createv2", params);
    }

    /**
     * 查询房间信息
     *
     * @param roomid 房间 ID
     * @return String
     * @throws Exception 异常
     */
    public String roomGetInfo(String roomid) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("roomid", roomid);

        return this.call("room.getInfo", params);
    }

    /**
     * 获取房间登录地址
     *
     * @param roomid 房间 ID
     * @return String
     * @throws Exception 异常
     */
    public String roomGetUrl(String roomid) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("roomid", roomid);

        return this.call("room.getUrl", params);
    }

    /**
     * 创建房间
     *
     * @param roomName 房间名称
     * @return String
     * @throws Exception 异常
     */
    public String roomCreate(String roomName) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("roomName", roomName);

        return this.call("room.create", params);
    }

    /**
     * 创建房间，新增管理员密码设置
     *
     * @param roomName 房间名称
     * @param authKey  管理员密码
     * @return String
     * @throws Exception 异常
     */
    public String roomCreate(String roomName, String authKey) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("roomName", roomName);
        params.put("authKey", authKey);

        return this.call("room.create", params);
    }

    /**
     * 创建房间
     *
     * @param roomName  房间名称
     * @param voiceFlow 语音流
     * @param authKey   管理员密码
     * @return String
     * @throws Exception 异常
     */
    public String roomCreate(String roomName, int voiceFlow, String authKey, int modetype, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("roomName", roomName);
        params.put("voiceFlow", voiceFlow);
        params.put("authKey", authKey);
        params.put("modetype", modetype);
        params.put("options", options);

        return this.call("room.create", params);
    }

    /**
     * 更新房间信息
     *
     * @param roomid 房间 ID
     * @param params 包含字段：roomName, voiceFlow, authKey
     * @return String
     * @throws Exception 异常
     */
    public String roomUpdate(String roomid, HashMap<Object, Object> params) throws Exception
    {
        params.put("roomid", roomid);

        return this.call("room.update", params);
    }

    /**
     * 删除房间
     *
     * @param roomid 房间 ID
     * @return String
     * @throws Exception 异常
     */
    public String roomDrop(String roomid) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("roomid", roomid);

        return this.call("room.drop", params);
    }

    /**
     * 获取房间列表
     *
     * @param page 页码
     * @param size 每页个数
     * @return String
     * @throws Exception 异常
     */
    public String roomList(int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("page", page);
        params.put("size", size);

        return this.call("room.list", params);
    }

    /**
     * 房间绑定主播
     *
     * @param roomid      房间 ID
     * @param account     主播账号
     * @param accountType 主播账号类型
     * @return String
     * @throws Exception 异常
     */
    public String roomBindAccount(String roomid, String account, int accountType) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("roomid", roomid);
        params.put("account", account);
        params.put("accountType", accountType);

        return this.call("room.live.bindAccount", params);
    }

    /**
     * 房间取消绑定主播
     *
     * @param roomid      房间 ID
     * @param account     主播账号
     * @param accountType 主播账号类型
     * @return String
     * @throws Exception 异常
     */
    public String roomUnbindAccount(String roomid, String account, int accountType) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("roomid", roomid);
        params.put("account", account);
        params.put("accountType", accountType);

        return this.call("room.live.unbindAccount", params);
    }

    /**
     * 发送广播
     *
     * @param roomid  房间 ID
     * @param cmd     命令
     * @param args    参数
     * @param options 可选参数
     * @return String
     * @throws Exception 异常
     */
    public String roomBroadcastSend(String roomid, String cmd, HashMap<Object, Object> args, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("roomid", roomid);
        params.put("cmd", cmd);
        params.put("params", args);
        params.put("options", options);

        return this.call("room.broadcast.send", params);
    }

    /**
     * 根据房间 ID获取当前房间的在线人数
     *
     * @param roomid 房间 ID
     * @return String
     * @throws Exception 异常
     */
    public String roomOnlineTotal(String roomid) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("roomid", roomid);

        return this.call("room.online.total", params);
    }

    /**
     * 虚拟用户导入
     *
     * @param roomid   房间 ID
     * @param userList [['nickname' => 'xxx', 'avatar' => 'xxx'], ['nickname' => 'xxxx', 'avatar' => 'xxx'], ......]
     * @return String
     */
    public String roomAddRobot(int roomid, ArrayList userList) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("roomid", roomid);
        params.put("userList", userList);
        HashMap<Object, Object> files = new HashMap<>();

        return this.call("room.robot.add", params, "POST", files);
    }

    /**
     * 滚动公告接口
     *
     * @param roomid   房间 ID
     * @param content  滚动公告内容
     * @param link     滚动公告链接
     * @param duration 滚动公告显示时长(单位：秒)
     * @return String
     */
    public String roomNoticeRoll(String roomid, String content, String link, int duration) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("roomid", roomid);
        params.put("content", content);
        params.put("link", link);
        params.put("duration", duration);

        return this.call("room.notice.roll", params);
    }

    /**
     * 获取房间 / 频道的外部推流地址
     *
     * @param roomid 房间 / 频道 ID
     * @param title  直播标题
     * @param ratio  分辨率比例
     * @return String
     */
    public String roomPushRtmpUrl(String roomid, String title, int ratio) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("roomid", roomid);
        params.put("title", title);
        params.put("ratio", ratio);

        return this.call("room.pushRtmpUrl", params);
    }

    /**
     * 根据房间 ID获取主播登录地址
     *
     * @param roomid  房间 ID
     * @param options 其它可选项，ssl：是否使用 https(true 为使用，false 为不使用)
     */
    public String roomLogin(String roomid, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("roomid", roomid);
        params.put("options", options);

        return this.call("room.login", params);
    }

    /**
     * 获取主播信息
     *
     * @param account     主播账号
     * @param accountType 主播账号类型
     * @return String
     * @throws Exception 异常
     */
    public String zhuboGet(String account, int accountType) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("account", account);
        params.put("accountType", accountType);

        return this.call("zhubo.get", params);
    }

    /**
     * 创建主播
     *
     * @param account      主播账号         (合作方主播账号的唯一 ID)
     * @param nickname     主播昵称
     * @param accountType  账号类型     (如果是欢拓的账号类型，account 可以为空)
     * @param password     主播账号密码
     * @param introduce    用户简介
     * @param departmentID 部门 ID
     * @return String
     * @throws Exception 异常
     */
    public String zhuboCreate(String account, String nickname, int accountType, String password, String introduce, int departmentID) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("account", account);
        params.put("nickname", nickname);
        params.put("accountType", accountType);
        params.put("password", password);
        params.put("intro", introduce);
        params.put("departmentID", departmentID);

        return this.call("zhubo.create", params);
    }

    /**
     * 更新主播信息
     *
     * @param account      主播账号
     * @param accountType  账号类型
     * @param nickname     主播昵称
     * @param introduce    用户简介
     * @param departmentID 部门 ID
     * @return String
     * @throws Exception 异常
     */
    public String zhuboUpdateInfo(String account, int accountType, String nickname, String introduce, int departmentID) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("account", account);
        params.put("accountType", accountType);
        params.put("nickname", nickname);
        params.put("intro", introduce);
        params.put("departmentID", departmentID);

        return this.call("zhubo.update.info", params);
    }

    /**
     * 更新主播密码
     *
     * @param account     主播账号
     * @param accountType 账号类型
     * @param password    主播账号密码
     * @return String
     * @throws Exception 异常
     */
    public String zhuboUpdatePassword(String account, int accountType, String password) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("account", account);
        params.put("accountType", accountType);
        params.put("password", password);

        return this.call("zhubo.update.password", params);
    }

    /**
     * 更新主播头像
     *
     * @param account     主播账号
     * @param accountType 账号类型
     * @param filename    图片路径(支持 jpeg、jpg，图片大小不超过 1M)
     * @return String
     * @throws Exception 异常
     */
    public String zhuboUpdatePortrait(String account, int accountType, String filename) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("account", account);
        params.put("accountType", accountType);
        String res = this.call("zhubo.portrait.uploadurl", params);
        JSONObject resJson = JSONObject.fromObject(res);

        if (resJson.getInt("code") == MTCloud.CODE_SUCCESS)
        {
            JSONObject resData = resJson.getJSONObject("data");
            File f;
            f = new File(filename);
            Part[] parts = {new FilePart(resData.getString("field"), f)};

            return this.doPost(resData.getString("api"), parts);
        }

        return res;
    }

    /**
     * 删除主播
     *
     * @param account     主播账号
     * @param accountType 账号类型
     * @return String
     * @throws Exception 异常
     */
    public String zhuboDel(String account, int accountType) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("account", account);
        params.put("accountType", accountType);

        return this.call("zhubo.del", params);
    }

    /**
     * 主播列表
     *
     * @param page 页码
     * @param size 每页个数
     * @return String
     * @throws Exception 异常
     */
    public String zhuboList(int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("page", page);
        params.put("size", size);

        return this.call("zhubo.list", params);
    }

    /**
     * 主播获取登录页面
     *
     * @param account     主播账户名
     * @param accountType 主播账户类型
     * @param options     其它可选项，ssl：是否使用 https(true 为使用，false 为不使用)
     * @return String
     * @throws Exception 异常
     */
    public String zhuboLogin(String account, int accountType, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("account", account);
        params.put("accountType", accountType);
        params.put("options", options);

        return this.call("zhubo.login", params);
    }

    /**
     * 根据房间 ID 获取主播登录地址
     *
     * @param roomid  房间 ID
     * @param options 其它可选项，ssl：是否使用https(true 为使用，false 为不使用)
     * @return String
     * @throws Exception 异常
     */
    public String zhuboRoomLogin(String roomid, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("roomid", roomid);
        params.put("options", options);

        return this.call("zhubo.room.login", params);
    }

    /**
     * 获取主播登录记录
     *
     * @param page    分页页码
     * @param size    每页数据个数
     * @param account 发起直播课程的合作方主播唯一账号或 ID，非指定查询具体主播时不要填
     * @return String
     * @throws Exception 异常
     */
    public String zhuboLoginInfo(int page, int size, String account) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("page", page);
        params.put("size", size);
        params.put("account", account);

        return this.call("zhubo.loginInfo", params);
    }

    /**
     * 主播观看固定链接
     *
     * @param account     发起直播课程的合作方主播唯一账号或 ID，非指定查询具体主播时不要填
     * @param accountType 主播账号类型。1 欢拓账户, 2 合作方账户
     * @return String
     * @throws Exception 异常
     */
    public String zhuboGetLoginUrl(String account, int accountType) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("account", account);
        params.put("accountType", accountType);

        return this.call("zhubo.getLoginUrl", params);
    }

    /**
     * 获取主播上下课记录
     *
     * @param page    分页页码
     * @param size    每页数据个数
     * @param account 发起直播课程的合作方主播唯一账号或 ID，非指定查询具体主播时不要填
     * @return String
     * @throws Exception 异常
     */
    public String zhuboClassRecord(int page, int size, String account) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("page", page);
        params.put("size", size);
        params.put("account", account);

        return this.call("zhubo.classRecord", params);
    }

    /**
     * 获取直播回放记录(需要携带用户信息的，使用 userAccessPlayback 方法)
     *
     * @param liveid 直播 ID
     * @param expire 地址有效时间
     * @return String
     * @throws Exception 异常
     */
    public String liveGet(String liveid, int expire) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("liveid", liveid);
        params.put("expire", expire);

        return this.call("live.get", params);
    }

    /**
     * 批量获取直播回放记录
     *
     * @param expire  地址有效期
     * @param liveids 直播 ID 列表
     * @return String
     * @throws Exception 异常
     */
    public String liveGetBatch(String[] liveids, int expire) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("liveids", liveids);
        params.put("expire", expire);

        return this.call("live.getBatch", params);
    }

    /**
     * 获取最新的几个直播记录
     *
     * @param size 每页个数
     */
    public String liveGetLast(int size, int roomid) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("size", size);
        params.put("roomid", roomid);

        return this.call("live.getlast", params);
    }

    /**
     * 获取直播回放记录列表
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @param page      页码
     * @param size      每页条数
     * @param playback  是否有回放
     * @return String
     * @throws Exception 异常
     */
    public String liveList(String startDate, String endDate, int page, int size, int playback) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("startDate", startDate);
        params.put("endDate", endDate);
        params.put("page", page);
        params.put("size", size);
        params.put("playback", playback);

        return this.call("live.list", params);
    }

    /**
     * 获取全部直播记录列表
     *
     * @param page 页码(默认: 1)
     * @param size 每页个数(默认: 10)
     */
    public String liveListAll(int page, int size, String order, String roomid) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("page", page);
        params.put("size", size);
        params.put("order", order);
        params.put("roomid", roomid);

        return this.call("live.listall", params);
    }

    /**
     * 获取直播聊天列表
     *
     * @param liveid 直播 ID
     * @param page   页码
     * @return String
     * @throws Exception 异常
     */
    public String liveMessageList(String liveid, int page) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("liveid", liveid);
        params.put("page", page);

        return this.call("live.message", params);
    }

    /**
     * 获取直播鲜花记录
     *
     * @param liveid 直播 ID
     * @param page   页码(默认: 1)
     * @param size   每页个数(默认: 10)
     */
    public String liveFlowerList(String liveid, int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("liveid", liveid);
        params.put("page", page);
        params.put("size", size);

        return this.call("live.flower.list", params);
    }

    /**
     * 创建直播回放专辑
     *
     * @param album_name 专辑名称
     * @param liveids    直播 ID 列表
     * @return String
     * @throws Exception 异常
     */
    public String liveAlbumCreate(String album_name, String[] liveids) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("album_name", album_name);
        params.put("liveids", liveids);

        return this.call("live.album.create", params);
    }

    /**
     * 获取专辑信息
     *
     * @param album_id 专辑 ID
     * @param expire   专辑地址有效期
     * @return String
     * @throws Exception 异常
     */
    public String liveAlbumGet(String album_id, int expire) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("album_id", album_id);
        params.put("expire", expire);

        return this.call("live.album.get", params);
    }

    /**
     * 删除专辑
     *
     * @param album_id 专辑 ID
     * @return String
     * @throws Exception 异常
     */
    public String liveAlbumDelete(String album_id) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("album_id", album_id);

        return this.call("live.album.delete", params);
    }

    /**
     * 往专辑里面增加回放记录
     *
     * @param album_id 专辑 ID
     * @param liveids  回放记录列表
     * @return String
     * @throws Exception 异常
     */
    public String liveAlbumAdd(String album_id, String[] liveids) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("album_id", album_id);
        params.put("liveids", liveids);

        return this.call("live.album.add", params);
    }

    /**
     * 从专辑中移除回放记录
     *
     * @param album_id 专辑 ID
     * @param liveids  回放记录列表
     * @return String
     * @throws Exception 异常
     */
    public String liveAlbumRemove(String album_id, String[] liveids) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("album_id", album_id);
        params.put("liveids", liveids);

        return this.call("live.album.remove", params);
    }

    /**
     * 发起投票
     *
     * @param roomid   房间 ID
     * @param uid      投票发布者，合作方用户 ID
     * @param nickname 投票发布者，合作方用户昵称
     * @param title    投票主题
     * @param label    投票标签
     * @param op       选项，json 格式，比如 ["aaa","bbb"]，aaa 为第一个选项，bbb 为第二个选项
     * @param type     类型，0 为单选，1 为多选
     * @param optional 若为单选则传 1，多选则传的值为多少表示可以选几项
     * @param answer   答案，设置第几项为答案，传入 "0" 表示第一个选项为正确答案，传入 "0,2" 表示第一和第三项为正确答案，不设置答案则传空字符串
     * @param image    图片路径，若要上传图片作为题目，则传入图片
     * @param options  可选参数
     * @return String
     * @throws Exception 异常
     */
    public String liveVoteAdd(String roomid, String uid, String nickname, String title, String label, ArrayList op, int type, int optional, String answer, String image, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("roomid", roomid);
        params.put("uid", uid);
        params.put("nickname", nickname);
        params.put("title", title);
        params.put("label", label);
        params.put("op", op);
        params.put("type", type);
        params.put("optional", optional);
        params.put("answer", answer);
        params.put("options", options);
        HashMap<Object, Object> files = new HashMap<>();

        if (!"".equals(image))
        {
            files.put("image", "@" + image);
        }

        return this.call("live.vote.add", params, "POST", files);
    }

    /**
     * 结束投票
     *
     * @param vid        投票 ID
     * @param showResult 是否显示投票结果，0 为不显示，1 为显示
     * @param uid        投票结束者，合作方用户 ID
     * @param nickname   投票结束者，合作方用户昵称
     * @return String
     * @throws Exception 异常
     */
    public String liveVoteEnd(String vid, int showResult, String uid, String nickname) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("vid", vid);
        params.put("showResult", showResult);
        params.put("uid", uid);
        params.put("nickname", nickname);

        return this.call("live.vote.end", params);
    }

    /**
     * 发布预发布的投票
     *
     * @param vid    投票 ID
     * @param roomid 房间 ID
     * @return String
     * @throws Exception 异常
     */
    public String liveVoteEmit(String vid, String roomid) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("vid", vid);
        params.put("roomid", roomid);

        return this.call("live.vote.emit", params);
    }

    /**
     * 删除投票
     *
     * @param vid 投票 ID
     * @return String
     * @throws Exception 异常
     */
    public String liveVoteDelete(String vid) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("vid", vid);

        return this.call("live.vote.delete", params);
    }

    /**
     * 更新投票
     *
     * @param vid     投票 ID
     * @param options 要更新的信息
     * @return String
     * @throws Exception 异常
     */
    public String liveVoteUpdate(String vid, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("vid", vid);
        params.put("options", options);
        HashMap<Object, Object> files = new HashMap<>();

        if (options.containsKey("image"))
        {
            String image = options.get("image").toString();

            if (!"".equals(image))
            {
                File file = new File(image);

                if (!file.exists())
                {
                    HashMap<Object, Object> ret = new HashMap<>();
                    ret.put("code", CODE_FAIL);
                    ret.put("msg", "文件" + image + "不存在");

                    return JSONObject.fromObject(ret).toString();
                }

                files.put("image", "@" + image);
            }
        }

        return this.call("live.vote.update", params, "POST", files);
    }

    /**
     * 创建一个专辑
     *
     * @param album_name 专辑名称
     * @return String
     * @throws Exception 异常
     */
    public String albumCreate(String album_name, String[] liveids) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("album_name", album_name);
        params.put("liveids", liveids);

        return this.call("album.create", params);
    }

    /**
     * 获取一个直播专辑
     *
     * @param album_id 专辑 ID
     * @param expire   地址有效时间
     * @return String
     */
    public String albumGet(String album_id, int expire) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("album_id", album_id);
        params.put("expire", expire);

        return this.call("album.get", params);
    }

    /**
     * 删除一个专辑
     *
     * @param album_id 专辑 ID
     * @return String
     */
    public String albumDelete(String album_id) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("album_id", album_id);

        return this.call("album.delete", params);
    }

    /**
     * 往专辑增加一个回放记录
     *
     * @param album_id 专辑 ID
     * @param liveids  回放记录的课程 id
     * @return String
     */
    public String albumAdd(String album_id, String[] liveids) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("album_id", album_id);
        params.put("liveids", liveids);

        return this.call("album.add", params);
    }

    /**
     * 从专辑里面清除某个回放
     *
     * @param album_id 专辑 ID
     * @param liveids  回放记录的课程 id
     */
    public String albumRemove(String album_id, String[] liveids) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("album_id", album_id);
        params.put("liveids", liveids);

        return this.call("album.remove", params);
    }

    /**
     * 创建一个课程专辑
     *
     * @param album_name 专辑名称
     * @param course_ids 课程 id
     * @return String
     */
    public String albumCreateCourse(String album_name, String[] course_ids) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("album_name", album_name);
        params.put("course_ids", course_ids);

        return this.call("album.course.create", params);
    }

    /**
     * 往课程专辑增加一个课程回放记录
     *
     * @param album_id   专辑 ID
     * @param course_ids 课程回放记录 ID 列表
     * @return String
     */
    public String albumAddCourse(String album_id, String[] course_ids) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("album_id", album_id);
        params.put("course_ids", course_ids);

        return this.call("album.course.add", params);
    }

    /**
     * 从课程专辑里面清除某个课程回放
     *
     * @param album_id   专辑 ID
     * @param course_ids 回放记录的课程 id
     */
    public String albumRemoveCourse(String album_id, String[] course_ids) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("album_id", album_id);
        params.put("course_ids", course_ids);

        return this.call("album.course.remove", params);
    }

    /**
     * 根据房间及时间获取回放记录
     *
     * @param roomid     房间 ID
     * @param start_time 开始时间 格式: 2014-12-26 12:00:00
     * @param expire     地址有效期
     * @return String
     * @throws Exception 异常
     */
    public String liveRoomGet(String roomid, String start_time, int expire) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("roomid", roomid);
        params.put("start_time", start_time);
        params.put("expire", expire);

        return this.call("live.room.get", params);
    }

    /**
     * 根据房间及时间区间获取回放记录
     *
     * @param roomid     房间 ID
     * @param start_time 起始区间时间戳  格式: 2014-12-26 00:00:00
     * @param end_time   结束区间时间戳  格式: 2014-12-26 12:00:00
     * @param expire     有效期
     * @return String
     * @throws Exception 异常
     */
    public String liveRoomList(String roomid, String start_time, String end_time, int expire) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("roomid", roomid);
        params.put("start_time", start_time);
        params.put("end_time", end_time);
        params.put("expire", expire);

        return this.call("live.room.list", params);
    }

    /**
     * 根据直播 ID获取访客列表
     *
     * @param liveid 直播 ID
     * @param page   页码
     * @param size   每页个数
     * @return String
     */
    public String liveVisitorList(String liveid, int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("liveid", liveid);
        params.put("page", page);
        params.put("size", size);

        return this.call("live.visitor.list", params);
    }

    /**
     * 根据直播 ID，用户 ID 获取访客列表
     *
     * @param liveid 直播 ID
     * @param uid    用户 ID
     * @return String
     */
    public String liveVisitorGet(String liveid, String uid) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("liveid", liveid);
        params.put("uid", uid);

        return this.call("live.visitor.get", params);
    }

    /**
     * 根据直播 ID 获取提问列表
     *
     * @param liveid 直播 ID
     * @param page   页码
     * @param size   每页个数
     * @return String
     */
    public String liveQuestionList(String liveid, int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("liveid", liveid);
        params.put("page", page);
        params.put("size", size);

        return this.call("live.question.list", params);
    }

    /**
     * 获取音频下载地址
     *
     * @param liveid 直播 ID
     * @return String
     * @throws Exception 异常
     */
    public String liveAudioDownloadUrl(String liveid) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("liveid", liveid);

        return this.call("live.audio.download.url", params);
    }

    /**
     * 根据直播 ID 获取回放访客列表
     *
     * @param liveid 直播 ID
     * @param page   页码
     * @param size   每页个数
     * @return String
     */
    public String livePlaybackVisitorList(String liveid, int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("liveid", liveid);
        params.put("page", page);
        params.put("size", size);

        return this.call("live.playback.visitor.list", params);
    }

    /**
     * 按照时间区间获取回放访客列表    (时间区间不能大于 7 天)
     *
     * @param start_time 开始时间    格式：2016-01-01 00:00:00
     * @param end_time   结束时间    格式：2016-01-02 00:00:00
     * @param page       页码
     * @param size       每页个数
     */
    public String livePlaybackVisitorTimeList(String start_time, String end_time, int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("start_time", start_time);
        params.put("end_time", end_time);
        params.put("page", page);
        params.put("size", size);

        return this.call("live.playback.visitor.timelist", params);
    }

    /**
     * 根据直播 id 获取回放视频
     *
     * @param liveid 直播 id
     */
    public String livePlaybackVideo(int liveid) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("liveid", liveid);

        return this.call("live.playback.video", params);
    }

    /**
     * 根据直播 id 获取回放登录地址
     *
     * @param liveid 直播 id
     */
    public String livePlaybackLoginUrl(int liveid) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("liveid", liveid);

        return this.call("live.playback.loginUrl", params);
    }

    /**
     * 获取直播 PPT 章节信息
     *
     * @param liveid 直播 id
     */
    public String liveChapterList(int liveid) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("liveid", liveid);

        return this.call("live.chapter.list", params);
    }

    /**
     * 按照直播 ID 获取投票列表
     *
     * @param liveid 直播 ID
     * @param page   页码
     * @param size   每页个数
     * @return String
     */
    public String liveVoteList(String liveid, int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("liveid", liveid);
        params.put("page", page);
        params.put("size", size);

        return this.call("live.vote.list", params);
    }

    /**
     * 按照投票 ID 和直播 ID 获取投票详情
     *
     * @param vid    投票 ID
     * @param liveid 直播 ID
     * @param page   页码
     * @param size   每页个数
     * @return String
     */
    public String liveVoteDetail(int vid, int liveid, int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("vid", vid);
        params.put("liveid", liveid);
        params.put("page", page);
        params.put("size", size);

        return this.call("live.vote.detail", params);
    }

    /**
     * 按照直播 ID 获取抽奖列表
     *
     * @param liveid 直播 ID
     * @param page   页码
     * @param size   每页个数
     * @return String
     */
    public String liveLotteryList(String liveid, int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("liveid", liveid);
        params.put("page", page);
        params.put("size", size);

        return this.call("live.lottery.list", params);
    }

    /**
     * 设置最高在线
     *
     * @param options 可传的参数
     * @return String
     */
    public String liveMaxUserSet(HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("options", options);

        return this.call("live.maxUser.set", params);
    }

    /**
     * 获取最高在线
     *
     * @return String
     */
    public String liveMaxUserGet() throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();

        return this.call("live.maxUser.get", params);
    }

    /**
     * 发起提问
     *
     * @param roomid   房间 ID
     * @param content  提问内容
     * @param uid      用户 id
     * @param role     用户角色
     * @param nickname 用户昵称
     * @param options  可选参数
     */
    public String liveQaAdd(String roomid, String content, String uid, String role, String nickname, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("roomid", roomid);
        params.put("content", content);
        params.put("uid", uid);
        params.put("role", role);
        params.put("nickname", nickname);
        params.put("options", options);

        return this.call("live.qa.add", params);
    }

    /**
     * 审核通过提问
     *
     * @param qid    提问ID
     * @param roomid 房间 ID
     */
    public String liveQaAudit(int qid, String roomid) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("qid", qid);
        params.put("roomid", roomid);

        return this.call("live.qa.audit", params);
    }

    /**
     * 删除提问
     *
     * @param qid    提问 ID
     * @param roomid 房间 ID
     */
    public String liveQaDelete(int qid, String roomid) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("qid", qid);
        params.put("roomid", roomid);

        return this.call("live.qa.delete", params);
    }

    /**
     * 回复提问
     *
     * @param qid      提问 ID
     * @param roomid   房间 ID
     * @param content  回复内容
     * @param uid      用户 ID
     * @param nickname 用户昵称
     * @param options  可选参数
     */
    public String liveQaAnswer(int qid, String roomid, String content, String uid, String nickname, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("qid", qid);
        params.put("roomid", roomid);
        params.put("content", content);
        params.put("uid", uid);
        params.put("nickname", nickname);
        params.put("options", options);

        return this.call("live.qa.answer", params);
    }

    /**
     * 获取问答列表
     *
     * @param roomid  房间 ID
     * @param page    页码
     * @param size    每页数量
     * @param options 可选参数
     */
    public String liveQaList(String roomid, int page, int size, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("roomid", roomid);
        params.put("page", page);
        params.put("size", size);
        params.put("options", options);

        return this.call("live.qa.list", params);
    }

    /**
     * 按照直播 ID 获取私聊记录列表
     *
     * @param liveid 直播 ID
     * @param page   页码
     * @param size   每页个数
     * @return String
     */
    public String livePrivateChatList(String liveid, int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("liveid", liveid);
        params.put("page", page);
        params.put("size", size);

        return this.call("live.privateChat", params);
    }

    /**
     * 增加一个直播课程
     *
     * @param course_name 课程名称
     * @param account     发起直播课程的主播账号
     * @param start_time  课程开始时间,格式: 2015-01-10 12:00:00
     * @param end_time    课程结束时间,格式: 2015-01-10 13:00:00
     * @return String
     */
    public String courseAdd(String course_name, String account, String start_time, String end_time, String nickname, String accountIntro, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_name", course_name);
        params.put("account", account);
        params.put("start_time", start_time);
        params.put("end_time", end_time);
        params.put("nickname", nickname);
        params.put("accountIntro", accountIntro);
        params.put("options", options);

        return this.call("course.add", params);
    }

    /**
     * 进入一个课程
     *
     * @param course_id 课程 ID
     * @param uid       用户唯一 ID
     * @param nickname  用户昵称
     * @param role      用户角色，枚举见: ROLE 定义
     * @param expire    有效期, 默认: 3600(单位: 秒)
     * @param options   可选项, 包括: gender: 枚举见上面 GENDER 定义, avatar: 头像地址
     */
    public String courseAccess(String course_id, String uid, String nickname, String role, int expire, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("uid", uid);
        params.put("nickname", nickname);
        params.put("role", role);
        params.put("expire", expire);
        params.put("options", options);

        return this.call("course.access", params);
    }

    /**
     * 进入一个课程回放
     *
     * @param course_id 课程 ID
     * @param uid       用户唯一 ID
     * @param nickname  用户昵称
     * @param role      用户角色，枚举见:ROLE 定义
     * @param expire    有效期, 默认: 3600(单位: 秒)
     * @param options   可选项, 包括: gender: 枚举见上面 GENDER 定义, avatar: 头像地址
     */
    public String courseAccessPlayback(String course_id, String uid, String nickname, String role, int expire, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("uid", uid);
        params.put("nickname", nickname);
        params.put("role", role);
        params.put("expire", expire);
        params.put("options", options);

        return this.call("course.access.playback", params);
    }

    /**
     * 获取课程直播间地址
     *
     * @param course_id 课程 ID
     * @param uid       用户唯一 ID
     * @param nickname  用户昵称
     * @param role      用户角色，枚举见: ROLE 定义
     * @param expire    有效期, 默认: 3600(单位: 秒)
     * @param options   可选项, 包括: gender: 枚举见上面 GENDER 定义, avatar: 头像地址
     */
    public String courseAccessUrl(String course_id, String uid, String nickname, String role, int expire, HashMap<Object, Object> options) throws Exception
    {
        String accessAuth = this.courseAccessKey(course_id, uid, nickname, role, expire, options);

        return "http://open.talk-fun.com/room.php?accessAuth=" + accessAuth;
    }

    /**
     * 获取课程直播 key
     *
     * @param course_id 课程 ID
     * @param uid       用户唯一 ID
     * @param nickname  用户昵称
     * @param role      用户角色，枚举见: ROLE 定义
     * @param expire    有效期, 默认: 3600(单位: 秒)
     * @param options   可选项, 包括: gender: 枚举见上面 GENDER 定义, avatar: 头像地址
     */
    public String courseAccessKey(String course_id, String uid, String nickname, String role, int expire, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("openID", this.openID.trim());
        Date date = new Date();
        long time = date.getTime() / 1000;
        String ts = time + "";
        params.put("timestamp", ts);
        params.put("course_id", course_id);
        params.put("uid", uid);
        params.put("nickname", nickname);
        params.put("role", role);
        params.put("expire", expire);
        params.put("options", JSONObject.fromObject(options).toString());
        params.put("sign", this.generateSign(params));
        String accessAuth = JSONObject.fromObject(params).toString();
        accessAuth = this.base64UrlEncode(accessAuth);

        return accessAuth;
    }

    /**
     * 获取课程回放地址
     *
     * @param course_id 课程 ID
     * @param uid       用户唯一 ID
     * @param nickname  用户昵称
     * @param role      用户角色，枚举见: ROLE 定义
     * @param expire    有效期, 默认: 3600(单位: 秒)
     * @param options   可选项, 包括: gender: 枚举见上面 GENDER 定义, avatar: 头像地址
     */
    public String courseAccessPlaybackUrl(String course_id, String uid, String nickname, String role, int expire, HashMap<Object, Object> options) throws Exception
    {
        String accessAuth = this.courseAccessKey(course_id, uid, nickname, role, expire, options);

        return "http://open.talk-fun.com/player.php?accessAuth=" + accessAuth;
    }

    /**
     * 查询课程信息
     *
     * @param course_id 课程 ID
     */
    public String courseGet(String course_id, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("options", options);

        return this.call("course.get", params);
    }

    /**
     * 发送广播
     *
     * @param course_id 课程 ID
     * @param cmd       命令
     * @param args      参数
     * @param options   可选参数
     * @return String
     * @throws Exception 异常
     */
    public String courseBroadcastSend(String course_id, String cmd, HashMap<Object, Object> args, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("cmd", cmd);
        params.put("params", args);
        params.put("options", options);

        return this.call("course.broadcast.send", params);
    }

    /**
     * 删除课程
     *
     * @param course_id 课程 ID
     */
    public String courseDelete(String course_id) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);

        return this.call("course.delete", params);
    }

    /**
     * 课程列表(将返回开始时间在区间内的课程)
     *
     * @param start_time 开始时间区间, 格式: 2015-01-01 12:00:00
     * @param end_time   结束时间区间, 格式: 2015-01-02 12:00:00
     * @param page       页码
     * @param size       每页数量
     * @param options    其他参数，status：课程状态(0 为正常状态，-1 为已删除)
     * @return String
     */
    public String courseList(String start_time, String end_time, int page, int size, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("start_time", start_time);
        params.put("end_time", end_time);
        params.put("page", page);
        params.put("size", size);
        params.put("options", options);

        return this.call("course.list", params);
    }

    /**
     * 更新课程信息
     *
     * @param course_id    课程 ID
     * @param account      发起直播课程的主播账号
     * @param course_name  课程名称
     * @param start_time   课程开始时间, 格式: 2015-01-01 12:00:00
     * @param end_time     课程结束时间, 格式: 2015-01-01 13:00:00
     * @param nickname     主播的昵称
     * @param accountIntro 主播的简介
     * @param options      可选参数
     */
    public String courseUpdate(String course_id, String account, String course_name, String start_time, String end_time, String nickname, String accountIntro, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("course_name", course_name);
        params.put("account", account);
        params.put("start_time", start_time);
        params.put("end_time", end_time);
        params.put("nickname", nickname);
        params.put("accountIntro", accountIntro);
        params.put("options", options);

        return this.call("course.update", params);
    }

    /**
     * 按照投票 ID 和课程 ID 获取投票详情
     *
     * @param vid       投票 ID
     * @param course_id 课程 ID
     * @param page      页码
     * @param size      每页个数
     * @return String
     */
    public String courseVoteDetail(int vid, int course_id, int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("vid", vid);
        params.put("course_id", course_id);
        params.put("page", page);
        params.put("size", size);

        return this.call("course.votes.detail", params);
    }

    /**
     * 按照课程 ID 获取投票列表
     *
     * @param course_id 课程 ID
     * @param page      页码
     * @param size      每页个数
     * @return String
     */
    public String courseVoteList(String course_id, int page, int size, String status) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("page", page);
        params.put("size", size);
        params.put("status", status);

        return this.call("course.votes.list", params);
    }

    /**
     * 删除投票
     *
     * @param vid 投票 ID
     * @return String
     * @throws Exception 异常
     */
    public String courseVoteDelete(String vid) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("vid", vid);

        return this.call("course.votes.delete", params);
    }

    /**
     * 更新投票
     *
     * @param vid     投票 ID
     * @param options 要更新的信息
     * @return String
     * @throws Exception 异常
     */
    public String courseVoteUpdate(String vid, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("vid", vid);
        params.put("options", options);
        HashMap<Object, Object> files = new HashMap<>();

        if (options.containsKey("image"))
        {
            String image = options.get("image").toString();

            if (!"".equals(image))
            {
                File file = new File(image);

                if (!file.exists())
                {
                    HashMap<Object, Object> ret = new HashMap<>();
                    ret.put("code", CODE_FAIL);
                    ret.put("msg", "文件" + image + "不存在");

                    return JSONObject.fromObject(ret).toString();
                }

                files.put("image", "@" + image);
            }
        }

        return this.call("course.votes.update", params, "POST", files);
    }

    /**
     * 按照课程 ID 获取抽奖列表
     *
     * @param course_id 课程 ID
     * @param page      页码
     * @param size      每页个数
     * @return String
     */
    public String courseLotteryList(String course_id, int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("page", page);
        params.put("size", size);

        return this.call("course.lottery.list", params);
    }

    /**
     * 按照课程 ID 获取音频下载地址
     *
     * @param course_id 课程 ID
     * @return String
     */
    public String courseAudioDownloadUrl(String course_id) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);

        return this.call("course.audio.download.url", params);
    }

    /**
     * 获取在线用户列表
     *
     * @param course_id  课程 ID
     * @param start_time 查询开始时间, 格式: 2015-01-01 12:00:00
     * @param end_time   查询结束时间, 格式: 2015-01-01 13:00:00
     * @param page       页码
     * @param size       每页数量
     * @return String
     * @throws Exception 异常
     */
    public String courseOnlineList(String course_id, String start_time, String end_time, int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("start_time", start_time);
        params.put("end_time", end_time);
        params.put("page", page);
        params.put("size", size);

        return this.call("course.online.list", params);
    }

    /**
     * 获取在线管理员列表
     *
     * @param start_time 查询开始时间, 格式: 2015-01-01 12:00:00
     * @param end_time   查询结束时间, 格式: 2015-01-01 13:00:00
     * @param page       页码
     * @param size       每页数量
     * @return String
     * @throws Exception 异常
     */
    public String courseOnlineAdmin(String start_time, String end_time, int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("start_time", start_time);
        params.put("end_time", end_time);
        params.put("page", page);
        params.put("size", size);

        return this.call("course.online.admin", params);
    }

    /**
     * 根据课程 ID 获取访客列表
     *
     * @param course_id 课程 ID
     * @param page      页码
     * @param size      每页个数
     * @param options   可选参数
     * @return String
     */
    public String courseVisitorList(String course_id, int page, int size, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("page", page);
        params.put("size", size);
        params.put("options", options);

        return this.call("course.visitor.list", params);
    }

    /**
     * 根据课程 ID 获取回放访客列表
     *
     * @param course_id 课程 ID
     * @param page      页面
     * @param size      每页个数
     * @param options   可选参数
     * @return String
     */
    public String coursePlaybackVisitorList(String course_id, int page, int size, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("page", page);
        params.put("size", size);
        params.put("options", options);

        return this.call("course.visitor.playback", params);
    }

    /**
     * 根据时间获取访客列表
     *
     * @param start_time 查询起始时间, 格式: 2015-01-01 12:00:00
     * @param end_time   查询结束时间, 格式: 2015-01-01 12:00:00
     * @param page       页码
     * @param size       每页个数
     */
    public String courseVisitorListAll(String start_time, String end_time, int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("start_time", start_time);
        params.put("end_time", end_time);
        params.put("page", page);
        params.put("size", size);

        return this.call("course.visitor.listall", params);
    }

    /**
     * 根据课程 ID 获取提问列表
     *
     * @param course_id 课程 ID
     * @param page      页码
     * @param size      每页个数
     * @return String
     */
    public String courseQuestionList(String course_id, int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("page", page);
        params.put("size", size);

        return this.call("course.question.list", params);
    }

    /**
     * 获取课程鲜花记录
     *
     * @param course_id 课程 ID
     * @param page      页码(默认: 1)
     * @param size      每页个数(默认: 10)
     */
    public String courseFlowerList(String course_id, int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("page", page);
        params.put("size", size);

        return this.call("course.flower.list", params);
    }

    /**
     * 获取课程聊天列表
     *
     * @param course_id 课程 id
     * @param page      页码
     * @param size      每页个数
     * @return array
     */
    public String courseMessageList(String course_id, int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("page", page);
        params.put("size", size);

        return this.call("course.message", params);
    }

    /**
     * 获取课件列表
     *
     * @param course_id 课程 id
     * @param page      页码
     * @return array
     */
    public String courseDocumentList(String course_id, int page) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("page", page);

        return this.call("course.document", params);
    }

    /**
     * 删除课件
     *
     * @param id 课件 ID
     * @return String
     */
    public String courseDocumentDelete(String id) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("id", id);

        return this.call("document.delete", params);
    }

    /**
     * 根据课程 id 获取回放视频
     *
     * @param course_id 课程 id
     * @return String
     * @throws Exception 异常
     */
    public String courseVideo(String course_id) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);

        return this.call("course.video", params);
    }

    /**
     * 根据课程 id 获取回放视频
     *
     * @param course_id 课程 id
     * @param options   可选参数
     * @return String
     * @throws Exception 异常
     */
    public String courseVideo(String course_id, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("options", options);

        return this.call("course.video", params);
    }

    /**
     * 根据课程 id 获取课程配置
     *
     * @param course_id 课程 id
     * @return String
     * @throws Exception 异常
     */
    public String courseConfig(String course_id) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);

        return this.call("course.getConfig", params);
    }

    /**
     * 更新课程配置信息
     *
     * @param course_id 课程 ID
     * @param options   配置参数
     * @return String
     * @throws Exception 异常
     */
    public String courseUpdateConfig(String course_id, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("options", options);

        return this.call("course.updateConfig", params);
    }

    /**
     * 发起投票
     *
     * @param course_id 课程 ID
     * @param uid       投票发布者，合作方用户 ID
     * @param nickname  投票发布者，合作方用户昵称
     * @param title     投票主题
     * @param label     投票标签
     * @param op        选项
     * @param type      类型，0 为单选，1 为多选
     * @param optional  若为单选则传 1，多选则传的值为多少表示可以选几项
     * @param answer    答案
     * @param image     图片路径
     * @param options   可选参数
     */
    public String courseVoteAdd(String course_id, String uid, String nickname, String title, String label, ArrayList op, int type, int optional, String answer, String image, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("uid", uid);
        params.put("nickname", nickname);
        params.put("title", title);
        params.put("label", label);
        params.put("op", op);
        params.put("type", type);
        params.put("optional", optional);
        params.put("answer", answer);
        params.put("options", options);
        HashMap<Object, Object> files = new HashMap<>();

        if (!"".equals(image))
        {
            files.put("image", "@" + image);
        }

        return this.call("course.votes.add", params, "POST", files);
    }

    /**
     * 结束投票
     *
     * @param vid        投票 ID
     * @param showResult 是否显示投票结果，1 显示，0 不显示
     * @param uid        投票结束者，合作方用户 ID
     * @param nickname   投票结束者，合作方用户昵称
     */
    public String courseVoteEnd(int vid, int showResult, String uid, String nickname) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("vid", vid);
        params.put("showVote", showResult);
        params.put("uid", uid);
        params.put("nickname", nickname);

        return this.call("course.votes.end", params);
    }

    /**
     * 发布预发布的投票
     *
     * @param vid       投票 ID
     * @param course_id 课程 ID
     * @return String
     * @throws Exception 异常
     */
    public String courseVoteEmit(int vid, int course_id) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("vid", vid);
        params.put("course_id", course_id);

        return this.call("course.votes.emit", params);
    }

    /**
     * 取课程 PPT 章节信息
     *
     * @param course_id 课程 id
     */
    public String courseChapterList(int course_id) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);

        return this.call("course.chapter.list", params);
    }

    /**
     * 根据课程 ID 获取被禁言的用户列表
     *
     * @param course_id 课程 id
     */
    public String courseChatDisableList(int course_id) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);

        return this.call("course.chat.disable.list", params);
    }

    /**
     * 添加剪辑
     *
     * @param liveid    直播 ID
     * @param name      剪辑名称
     * @param time      剪辑时间，array(array('start' => 60,'end' => 180))
     * @param isRelated 是否关联源直播，默认不关联
     */
    public String clipAdd(int liveid, String name, HashMap<Object, Object> time, int isRelated) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("liveid", liveid);
        params.put("name", name);
        params.put("time", time);
        params.put("isRelated", isRelated);

        return this.call("clip.add", params);
    }

    /**
     * 修改剪辑
     *
     * @param clipid    剪辑 ID
     * @param name      剪辑名称
     * @param time      剪辑时间，array(array('start' => 60,'end' => 180))
     * @param isRelated 是否关联源直播，默认不关联
     */
    public String clipUpdate(int clipid, String name, HashMap<Object, Object> time, int isRelated) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("clipid", clipid);
        params.put("name", name);
        params.put("time", time);
        params.put("isRelated", isRelated);

        return this.call("clip.update", params);
    }

    /**
     * 删除剪辑
     *
     * @param clipid 剪辑 ID
     */
    public String clipDelete(int clipid) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("clipid", clipid);

        return this.call("clip.delete", params);
    }

    /**
     * 获取剪辑信息
     *
     * @param clipid 剪辑 ID
     */
    public String clipGet(int clipid) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("clipid", clipid);

        return this.call("clip.get", params);
    }

    /**
     * 获取剪辑列表
     *
     * @param page 页码
     * @param size 条数
     */
    public String clipList(int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("page", page);
        params.put("size", size);

        return this.call("clip.list", params);
    }

    /**
     * 获取剪辑列表
     *
     * @param page   页码
     * @param size   条数
     * @param liveid 直播 id
     */
    public String clipList(int page, int size, int liveid) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("page", page);
        params.put("size", size);
        params.put("liveid", liveid);

        return this.call("clip.list", params);
    }

    /**
     * 根据课程 id 获取剪辑列表
     *
     * @param course_id 课程 id
     * @param page      页码
     * @param size      条数
     */
    public String clipListByCid(int course_id, int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("page", page);
        params.put("size", size);

        return this.call("clip.course.list", params);
    }

    /**
     * 添加剪辑
     *
     * @param course_id 课程 ID
     * @param name      剪辑名称
     * @param time      剪辑时间，array(array('start' => 60,'end' => 180))
     * @param isRelated 是否关联源直播，默认不关联
     */
    public String clipAddByCid(int course_id, String name, HashMap<Object, Object> time, int isRelated) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("name", name);
        params.put("time", time);
        params.put("isRelated", isRelated);

        return this.call("clip.course.add", params);
    }

    /**
     * 获取剪辑 access_token，播放地址
     *
     * @param clipid   剪辑 ID
     * @param uid      合作方用户唯一 ID
     * @param nickname 合作方用户昵称
     * @param expire   有效期，单位：秒(默认 3600 秒)
     */
    public String clipAccess(int clipid, String uid, String nickname, int expire) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("clipid", clipid);
        params.put("uid", uid);
        params.put("nickname", nickname);
        params.put("expire", expire);

        return this.call("clip.access", params);
    }

    /**
     * 虚拟用户导入
     *
     * @param course_id 课程 ID
     * @param userList  虚拟用户列表
     * @param total     总数
     */
    public String courseRobotSet(int course_id, ArrayList userList, int total) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("userList", userList);
        params.put("total", total);
        HashMap<Object, Object> files = new HashMap<>();

        return this.call("course.robot.set", params, "POST", files);
    }

    /**
     * 滚动公告接口
     *
     * @param course_id 课程 ID
     * @param content   滚动公告内容
     * @param link      滚动公告链接
     * @param duration  滚动通知显示时长(单位：秒)
     * @return String
     * @throws Exception 异常
     */
    public String courseNoticeRoll(int course_id, String content, String link, int duration) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("content", content);
        params.put("link", link);
        params.put("duration", duration);

        return this.call("course.notice.roll", params);
    }

    /**
     * 课程上传课件
     *
     * @param course_id 课程 ID
     * @param file      文件 {"file":"文件路径", "name":"文件名"}，支持的课件格式为：ppt, pptx, doc, docx, pdf, jpg, jpeg, png, gif
     */
    public String courseDocumentUpload(String course_id, HashMap<String, String> file) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("name", file.get("name"));
        String res = this.call("course.document.uploadurl.get", params);
        JSONObject resJson = JSONObject.fromObject(res);

        if (resJson.getInt("code") == MTCloud.CODE_SUCCESS)
        {
            JSONObject resData = resJson.getJSONObject("data");
            File f;
            f = new File(file.get("file"));
            Part[] parts = {new FilePart(resData.getString("field"), f)};

            return this.doPost(resData.getString("api"), parts);
        }

        return res;
    }

    /**
     * 获取主播登录信息
     *
     * @param account     主播账户
     * @param accountType 主播账户类型
     * @param options     其它可选项，ssl：是否使用 https(true 为使用，false 为不使用)
     * @return String
     * @throws Exception 异常
     */
    public String courseLogin(String account, int accountType, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("account", account);
        params.put("accountType", accountType);
        params.put("options", options);

        return this.call("course.login", params);
    }

    /**
     * 修改主播头像
     *
     * @param account  发起直播课程的合作方主播唯一账号 ID
     * @param filename 本地图片图片路径
     * @return String
     * @throws Exception 异常
     */
    public String courseZhuboPortrait(String account, String filename) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("account", account);
        String res = this.call("course.zhubo.portrait", params);
        JSONObject resJson = JSONObject.fromObject(res);

        if (resJson.getInt("code") == MTCloud.CODE_SUCCESS)
        {
            JSONObject resData = resJson.getJSONObject("data");
            File f;
            f = new File(filename);
            Part[] parts = {new FilePart(resData.getString("field"), f)};

            return this.doPost(resData.getString("api"), parts);
        }

        return res;
    }

    /**
     * 添加主播
     *
     * @param account  发起直播课程的合作方主播唯一账号 ID
     * @param nickname 主播昵称
     * @param password 主播密码
     * @return String
     * @throws Exception 异常
     */
    public String courseZhuboAdd(String account, String nickname, String intro, String password) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("account", account);
        params.put("nickname", nickname);
        params.put("intro", intro);
        params.put("password", password);

        return this.call("course.zhubo.add", params);
    }

    /**
     * 获取主播列表
     *
     * @param page 分页页码
     * @param size 每页数据个数
     * @return String
     * @throws Exception 异常
     */
    public String courseZhuboList(int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("page", page);
        params.put("size", size);

        return this.call("course.zhubo.list", params);
    }

    /**
     * 获取主播列表
     *
     * @param page    分页页码
     * @param size    每页数据个数
     * @param account 发起直播课程的合作方主播唯一账号或 ID，非指定查询具体主播时不要填
     * @return String
     * @throws Exception 异常
     */
    public String courseZhuboList(int page, int size, String account) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("page", page);
        params.put("size", size);
        params.put("account", account);

        return this.call("course.zhubo.list", params);
    }

    /**
     * 获取主播登录记录
     *
     * @param page        分页页码
     * @param size        每页数据个数
     * @param account     发起直播课程的合作方主播唯一账号或 ID，非指定查询具体主播时不要填
     * @param accountType 主播账号类型。1 欢拓账户, 2 合作方账户
     * @return String
     * @throws Exception 异常
     */
    public String courseZhuboLoginInfo(int page, int size, String account, int accountType) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("page", page);
        params.put("size", size);
        params.put("account", account);
        params.put("accountType", accountType);

        return this.call("course.zhubo.loginInfo", params);
    }

    /**
     * 获取主播上下课记录
     *
     * @param page        分页页码
     * @param size        每页数据个数
     * @param account     发起直播课程的合作方主播唯一账号或 ID，非指定查询具体主播时不要填
     * @param accountType 主播账号类型。1 欢拓账户, 2 合作方账户
     * @return String
     * @throws Exception 异常
     */
    public String courseZhuboClassRecord(int page, int size, String account, int accountType) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("page", page);
        params.put("size", size);
        params.put("account", account);
        params.put("accountType", accountType);

        return this.call("course.zhubo.classRecord", params);
    }

    /**
     * 更新主播信息
     *
     * @param account  发起直播课程的合作方主播唯一账号 ID
     * @param nickname 主播昵称
     * @param password 主播密码
     * @return String
     * @throws Exception 异常
     */
    public String courseZhuboUpdate(String account, String nickname, String intro, String password) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("account", account);
        params.put("nickname", nickname);
        params.put("intro", intro);
        params.put("password", password);

        return this.call("course.zhubo.update", params);
    }

    /**
     * 获取直播器启动协议
     *
     * @param course_id 课程 ID
     * @return String
     * @throws Exception 异常
     */
    public String courseLaunch(int course_id) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);

        return this.call("course.launch", params);
    }

    /**
     * 发起提问
     *
     * @param course_id 课程 ID
     * @param content   提问内容
     * @param uid       用户 ID
     * @param role      用户角色
     * @param nickname  用户昵称
     * @param options   可选参数
     */
    public String courseQaAdd(int course_id, String content, String uid, String role, String nickname, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("content", content);
        params.put("uid", uid);
        params.put("role", role);
        params.put("nickname", nickname);
        params.put("options", options);

        return this.call("course.qa.add", params);
    }

    /**
     * 审核通过提问
     *
     * @param qid       提问 ID
     * @param course_id 课程 ID
     */
    public String courseQaAudit(int qid, int course_id) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("qid", qid);
        params.put("course_id", course_id);

        return this.call("course.qa.audit", params);
    }

    /**
     * 删除提问
     *
     * @param qid       提问 ID
     * @param course_id 课程 ID
     */
    public String courseQaDelete(int qid, int course_id) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("qid", qid);
        params.put("course_id", course_id);

        return this.call("course.qa.delete", params);
    }

    /**
     * 回复提问
     *
     * @param qid       提问 ID
     * @param course_id 课程 ID
     * @param content   提问内容
     * @param uid       用户 ID
     * @param nickname  用户昵称
     * @param options   可选参数
     */
    public String courseQaAnswer(int qid, int course_id, String content, String uid, String nickname, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("qid", qid);
        params.put("course_id", course_id);
        params.put("content", content);
        params.put("uid", uid);
        params.put("nickname", nickname);
        params.put("options", options);

        return this.call("course.qa.answer", params);
    }

    /**
     * 获取问答列表
     *
     * @param course_id 课程 ID
     * @param page      页码
     * @param size      每页数量
     * @param options   可选参数
     */
    public String courseQaList(int course_id, int page, int size, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("page", page);
        params.put("size", size);
        params.put("options", options);

        return this.call("course.qa.list", params);
    }

    /**
     * 上传课程封面图
     *
     * @param course_id 课程 ID
     * @param filename  图片路径(支持图片格式: jpg、jpeg，图片大小不超过 2M)
     * @return String
     * @throws Exception 异常
     */
    public String courseThumbUpload(int course_id, String filename) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        String res = this.call("course.getUploadThumbUrl", params);
        JSONObject resJson = JSONObject.fromObject(res);

        if (resJson.getInt("code") == MTCloud.CODE_SUCCESS)
        {
            JSONObject resData = resJson.getJSONObject("data");
            File f;
            f = new File(filename);
            Part[] parts = {new FilePart(resData.getString("field"), f)};

            return this.doPost(resData.getString("api"), parts);
        }

        return res;
    }

    /**
     * 按照课程 ID 获取私聊记录列表
     *
     * @param course_id 课程 ID
     * @param page      页码
     * @param size      每页个数
     * @return String
     */
    public String coursePrivateChatList(int course_id, int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("page", page);
        params.put("size", size);

        return this.call("course.privateChat", params);
    }

    /**
     * 按照课程 ID 获取推流地址
     *
     * @param course_id 课程 ID
     * @param width     视频宽度
     * @param height    视频高度
     * @return String
     */
    public String coursePushRtmpUrl(int course_id, int width, int height) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("width", width);
        params.put("height", height);

        return this.call("course.pushRtmpUrl", params);
    }

    /**
     * 按照课程 ID 获取评分列表
     *
     * @param course_id 课程 ID
     * @param page      页码
     * @param size      每页个数
     * @return String
     */
    public String courseScoreList(int course_id, int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("page", page);
        params.put("size", size);

        return this.call("course.score.list", params);
    }

    /**
     * 设置课程拉流转播
     *
     * @param course_id 课程 id
     * @param pullUrl   源站拉流地址，为空测停止拉流转推
     * @return array
     */
    public String courseSetPullLive(int course_id, String pullUrl) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("pullUrl", pullUrl);

        return this.call("course.setPullLive", params);
    }

    /**
     * 获取课程拉流转播设置
     *
     * @param course_id 课程 id
     * @return array
     */
    public String courseGetPullLive(int course_id) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);

        return this.call("course.getPullLive", params);
    }

    /**
     * 课程转播绑定
     *
     * @param course_id 课程 id
     * @param rebroCid  被转播的课程 id
     * @return array
     */
    public String courseRebroAdd(String course_id, String rebroCid) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("rebroCid", rebroCid);

        return this.call("course.rebro.add", params);
    }


    /**
     * 课程转播解绑
     *
     * @param course_id 课程 id
     * @param rebroCid  被转播的课程 id
     * @return array
     */
    public String courseRebroDelete(String course_id, String rebroCid) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("rebroCid", rebroCid);

        return this.call("course.rebro.delete", params);
    }


    /**
     * 用户踢出记录
     *
     * @param page 页码
     * @param size 每页条数
     * @param uid  用户 ID
     */
    public String memberBanLog(int page, int size, String uid) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("page", page);
        params.put("size", size);
        params.put("uid", uid);

        return this.call("member.banLog", params);
    }

    /**
     * 用户踢出封禁
     *
     * @param course_id 课程 ID
     * @param uid       用户 ID
     * @param duration  封禁时长，单位秒，默认 3 小时
     * @param ip        封禁的 IP，不封 IP 的话传空字符串
     */
    public String memberBan(int course_id, String uid, int duration, String ip) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("uid", uid);
        params.put("duration", duration);
        params.put("ip", ip);

        return this.call("member.ban", params);
    }

    /**
     * 用户解封
     *
     * @param course_id 课程 ID
     * @param uid       用户 ID
     * @param ip        解禁的 IP，不解 IP 传空字符串
     */
    public String memberFree(int course_id, String uid, String ip) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("uid", uid);
        params.put("ip", ip);

        return this.call("member.free", params);
    }


    /**
     * 获取生活直播配置
     *
     * @param course_id 直播 id
     * @param options   配置
     * @return String
     */
    public String getLifeConfig(int course_id, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("options", options);

        return this.call("course.getLifeConfig", params);
    }

    /**
     * 编辑生活直播配置
     *
     * @param course_id 直播 id
     * @param options   配置
     * @return String
     */
    public String updateLifeConfig(int course_id, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("options", options);

        return this.call("course.updateLifeConfig", params, "POST", new HashMap<>());
    }

    /**
     * 查询某月份峰值
     *
     * @param date_time 查询月份(格式：2016-10)
     * @param vtype     类型(0 为总计，1 为直播，2 为回放)
     * @return String
     * @throws Exception 异常
     */
    public String statsPeakMonth(String date_time, int vtype) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("date_time", date_time);
        params.put("vtype", vtype);

        return this.call("stats.peak.month", params);
    }

    /**
     * 查询某月份峰值
     *
     * @param date_time    查询月份(格式：2016-10)
     * @param vtype        类型(0 为总计，1 为直播，2 为回放)
     * @param departmentId 部门 id
     * @return String
     * @throws Exception 异常
     */
    public String statsPeakMonth(String date_time, int vtype, int departmentId) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("date_time", date_time);
        params.put("vtype", vtype);
        params.put("departmentId", departmentId);

        return this.call("stats.peak.month", params);
    }

    /**
     * 查询某日峰值
     *
     * @param date_time 查询日期(格式：2016-10-11)
     * @param vtype     类型(0 为总计，1 为直播，2 为回放)
     * @return String
     * @throws Exception 异常
     */
    public String statsPeakDay(String date_time, int vtype) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("date_time", date_time);
        params.put("vtype", vtype);

        return this.call("stats.peak.day", params);
    }

    /**
     * 查询某月份峰值
     *
     * @param date_time    查询日期(格式：2016-10-11)
     * @param vtype        类型(0 为总计，1 为直播，2 为回放)
     * @param departmentId 部门 id
     * @return String
     * @throws Exception 异常
     */
    public String statsPeakDay(String date_time, int vtype, int departmentId) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("date_time", date_time);
        params.put("vtype", vtype);
        params.put("departmentId", departmentId);

        return this.call("stats.peak.day", params);
    }

    /**
     * 上传文档
     *
     * @param roomid 房间 ID
     * @param file   文件 {"file":"文件路径", "name":"文件名"}, 支持的课件格式为：ppt, pptx, doc, docx, pdf, jpg, jpeg, png, gif
     * @return String
     * @throws Exception 异常
     */
    public String documentUpload(String roomid, HashMap<String, String> file) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("roomid", roomid);
        params.put("name", file.get("name"));
        String res = this.call("document.uploadurl.get", params);
        JSONObject resJson = JSONObject.fromObject(res);

        if (resJson.getInt("code") == MTCloud.CODE_SUCCESS)
        {
            JSONObject resData = resJson.getJSONObject("data");
            File f;
            f = new File(file.get("file"));
            Part[] parts = {new FilePart(resData.getString("field"), f)};

            return this.doPost(resData.getString("api"), parts);
        }

        return res;
    }

    /**
     * 课件下载地址
     *
     * @param id 开放平台的文档 ID
     */
    public String documentDownload(int id) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("id", id);

        return this.call("document.downloadurl.get", params);
    }

    /**
     * 课件列表
     *
     * @param roomid 根据房间 id 获取课件列表
     */
    public String documentList(int roomid) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("roomid", roomid);

        return this.call("document.list", params);
    }

    /**
     * 课件详细信息
     *
     * @param id 根据课件 id 获取课件详细信息
     */
    public String documentGet(int id) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("id", id);

        return this.call("document.get", params);
    }

    /**
     * 第三方素材绑定（目前仅支持音视频）
     *
     * @param bid       主播 id。素材绑定的主播，同个素材只能绑定一个主播
     * @param name      素材名称
     * @param url       素材地址
     * @param filesize  素材大小
     * @param duration  素材时长
     * @param ext       素材类型
     * @param thumbnail 素材缩略图
     * @param courseId  课程 id。素材绑定的课程，同个素材只能绑定一个课程
     * @param roomId    房间 id。素材绑定的房间，同个素材只能绑定一个房间
     */
    public String documentThirdBinding(int bid, String name, String url, int filesize, int duration, String ext, int type, String thumbnail, int courseId, int roomId) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("bid", bid);
        params.put("name", name);
        params.put("url", url);
        params.put("filesize", filesize);
        params.put("duration", duration);
        params.put("ext", ext);
        params.put("type", type);
        params.put("thumbnail", thumbnail);
        params.put("course_id", courseId);
        params.put("roomid", roomId);

        return this.call("document.thirdBinding", params);
    }

    /**
     * 创建部门
     *
     * @param departmentName 部门名称
     */
    public String departmentCreate(String departmentName) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("departmentName", departmentName);

        return this.call("department.create", params);
    }

    /**
     * 更新部门信息
     *
     * @param departmentId   部门 id
     * @param departmentName 部门名称
     */
    public String departmentUpdate(int departmentId, String departmentName) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("departmentId", departmentId);
        params.put("departmentName", departmentName);

        return this.call("department.update", params);
    }

    /**
     * 删除部门
     *
     * @param departmentId 部门 id
     */
    public String departmentDelete(int departmentId) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("departmentId", departmentId);

        return this.call("department.delete", params);
    }

    /**
     * 获取部门信息
     *
     * @param departmentId 部门 id
     */
    public String departmentGet(int departmentId) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("departmentId", departmentId);

        return this.call("department.get", params);
    }

    /**
     * 批量获取部门信息
     *
     * @param departmentIds 部门 id 数组
     */
    public String departmentGetBatch(String[] departmentIds) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("departmentIds", departmentIds);

        return this.call("department.getBatch", params);
    }


    /**
     * 批量更新部门回调地址
     *
     * @param callbackApis 部门回调地址 {"1":"<a href="http://www.talk-fun.com/">http://www.talk-fun.com/</a>","2":"<a href="https://www.talk-fun.com/">https://www.talk-fun.com/</a>"}
     */
    public String departmentUpdateCallbackApiBatch(HashMap<String, String> callbackApis) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("callbackApis", callbackApis);

        return this.call("department.updateCallbackApiBatch", params);
    }

    /**
     * 部门设置最高在线
     *
     * @param departmentId 部门 id
     * @param options      可选参数
     * @throws Exception 异常
     */
    public String departmentMaxUserSet(int departmentId, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("departmentId", departmentId);
        params.put("options", options);

        return this.call("department.maxUser.set", params);
    }

    public String departmentMaxUserGet(int departmentId) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("departmentId", departmentId);

        return this.call("department.maxUser.get", params);
    }

    /**
     * 获取视频上传地址
     *
     * @param account     主播帐号
     * @param accountType 帐号类型
     * @param title       视频标题
     * @param md5         视频文件 md5
     * @param options     可选参数
     * @return String
     * @throws Exception 异常
     */
    public String videoGetUploadUrl(String account, int accountType, String title, String md5, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("account", account);
        params.put("accountType", accountType);
        params.put("title", title);
        params.put("md5", md5);
        params.put("options", options);

        return this.call("video.getUploadUrl", params);
    }

    /**
     * 获取视频信息
     *
     * @param videoId 视频 ID
     * @param expire  视频有效期(单位：秒)
     * @return String
     * @throws Exception 异常
     */
    public String videoGet(int videoId, int expire) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("videoId", videoId);
        params.put("expire", expire);

        return this.call("video.get", params);
    }

    /**
     * 批量获取视频信息
     *
     * @param expire   视频有效期(单位：秒)
     * @param videoIds 视频 ID
     * @return String
     * @throws Exception 异常
     */
    public String videoGetBatch(int[] videoIds, int expire) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("videoIds", videoIds);
        params.put("expire", expire);

        return this.call("video.getBatch", params);
    }

    /**
     * 获取视频列表
     *
     * @param page   页码
     * @param expire 视频有效期(单位：秒)
     * @return String
     * @throws Exception 异常
     */
    public String videoList(int page, int expire) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("page", page);
        params.put("expire", expire);

        return this.call("video.list", params);
    }

    /**
     * 视频删除
     *
     * @param videoId 视频 ID
     * @return String
     * @throws Exception 异常
     */
    public String videoDelete(int videoId) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("videoId", videoId);

        return this.call("video.delete", params);
    }

    /**
     * 视频更新
     *
     * @param videoId 视频 ID
     * @param title   视频标题
     * @return String
     * @throws Exception 异常
     */
    public String videoUpdate(int videoId, String title) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("videoId", videoId);
        params.put("title", title);

        return this.call("video.update", params);
    }

    /**
     * 模块设置
     *
     * @param options 可选参数
     * @return String
     * @throws Exception 异常
     */
    public String moduleSet(HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        HashMap<Object, Object> files = new HashMap<>();

        if (options.containsKey("livePcLogo"))
        {
            String path = options.get("livePcLogo").toString();
            File file = new File(path);

            if (!file.exists())
            {
                HashMap<Object, Object> retval = new HashMap<>();
                retval.put("code", CODE_FAIL);
                retval.put("msg", "文件" + path + "不存在");

                return JSONObject.fromObject(retval).toString();
            }

            files.put("livePcLogo", "@" + path);
            options.remove("livePcLogo");
        }

        if (options.containsKey("playbackPcLogo"))
        {
            String path = options.get("playbackPcLogo").toString();
            File file = new File(path);

            if (!file.exists())
            {
                HashMap<Object, Object> retval = new HashMap<>();
                retval.put("code", CODE_FAIL);
                retval.put("msg", "文件" + path + "不存在");

                return JSONObject.fromObject(retval).toString();
            }

            files.put("playbackPcLogo", "@" + path);
            options.remove("playbackPcLogo");
        }

        if (options.containsKey("clientLogo"))
        {
            String path = options.get("clientLogo").toString();
            File file = new File(path);

            if (!file.exists())
            {
                HashMap<Object, Object> retval = new HashMap<>();
                retval.put("code", CODE_FAIL);
                retval.put("msg", "文件" + path + "不存在");

                return JSONObject.fromObject(retval).toString();
            }

            files.put("clientLogo", "@" + path);
            options.remove("clientLogo");
        }

        if (options.containsKey("watermarkFile"))
        {
            String path = options.get("watermarkFile").toString();
            File file = new File(path);

            if (!file.exists())
            {
                HashMap<Object, Object> retval = new HashMap<>();
                retval.put("code", CODE_FAIL);
                retval.put("msg", "文件" + path + "不存在");

                return JSONObject.fromObject(retval).toString();
            }

            files.put("watermarkFile", "@" + path);
            options.remove("watermarkFile");
        }

        params.put("options", options);

        return this.call("module.set", params, "POST", files);
    }

    /**
     * 上传视频
     *
     * @param fileName     要上传的本地路径文件
     * @param account      上传者 ID
     * @param accountType  帐号类型：1 为欢拓帐号，2 为第三方帐号
     * @param title        视频标题
     * @param nickname     上传者昵称
     * @param accountIntro 上传者简介
     * @param course       课程参数，若不创建课程，请留空
     * @return String
     * @throws Exception 异常
     */
    public String videoUpload(String fileName, String account, int accountType, String title, String nickname, String accountIntro, HashMap<Object, Object> course) throws Exception
    {
        String retval;
        String fileMd5;
        File file = new File(fileName);

        if (file.exists())
        {
            fileMd5 = MD5Util.getFileMD5String(file);
        }
        else
        {
            retval = "{\"code\":" + MTCloud.CODE_FAIL + ",\"msg\":\"文件不存在\"}";

            return retval;
        }

        HashMap<Object, Object> options = new HashMap<>();
        options.put("nickname", nickname);
        options.put("accountIntro", accountIntro);
        options.put("course", course);
        retval = this.videoGetUploadUrl(account, accountType, title, fileMd5, options);
        JSONObject resJson = JSONObject.fromObject(retval);

        if (resJson.getInt("code") == MTCloud.CODE_SUCCESS)
        {
            JSONObject resData = resJson.getJSONObject("data");
            String uploadUrl = resData.getString("uploadUrl");
            File f;
            f = new File(fileName);
            Part[] parts = {new FilePart(resData.getString("field"), f)};
            int tryTime = 0;

            while (tryTime < 2)
            {
                retval = this.doPost(uploadUrl, parts);
                JSONObject retvalJson = JSONObject.fromObject(retval);

                if (retvalJson.getInt("code") == MTCloud.CODE_SUCCESS)
                {
                    break;
                }

                tryTime++;
            }
        }
        else if (resJson.getInt("code") == MTCloud.CODE_VIDEO_UPLOADED)
        {
            resJson.put("code", MTCloud.CODE_SUCCESS);
            retval = resJson.toString();
        }

        return retval;
    }

    /**
     * 分段上传视频
     *
     * @param fileName     要上传的本地路径文件
     * @param account      主播帐号
     * @param accountType  帐号类型
     * @param title        视频标题
     * @param nickname     主播昵称
     * @param accountIntro 主播简介
     * @param course       课程参数，若不创建课程，请留空
     * @return String
     * @throws Exception 异常
     */
    public String videoSegmentUpload(String fileName, String account, int accountType, String title, String nickname, String accountIntro, HashMap<Object, Object> course) throws Exception
    {
        String retval;
        String fileMd5;
        File file = new File(fileName);

        if (file.exists())
        {
            fileMd5 = MD5Util.getFileMD5String(file);
        }
        else
        {
            retval = "{\"code\":" + MTCloud.CODE_FAIL + ",\"msg\":\"文件不存在\"}";

            return retval;
        }

        HashMap<Object, Object> options = new HashMap<>();
        options.put("nickname", nickname);
        options.put("accountIntro", accountIntro);
        options.put("course", course);
        retval = this.videoGetUploadUrl(account, accountType, title, fileMd5, options);
        JSONObject resJson = JSONObject.fromObject(retval);

        if (resJson.getInt("code") == MTCloud.CODE_SUCCESS)
        {
            JSONObject resData = resJson.getJSONObject("data");
            String uploadUrl = resData.getString("resumeUploadUrl");
            String chunkListUrl = resData.getString("chunkListUrl");

            // 获取上传过的分片
            JSONArray chunkList = null;
            String chunkListRes = doGet(chunkListUrl);
            JSONObject chunkListJson = JSONObject.fromObject(chunkListRes);

            if (chunkListJson.getInt("code") == MTCloud.CODE_SUCCESS)
            {
                chunkList = chunkListJson.getJSONArray("data");
            }

            String fileSeparator = (new Properties(System.getProperties())).getProperty("file.separator");

            // 分割文件存储的临时目录
            File tempDir = new File(file.getParentFile().toString() + fileSeparator + "mtcloudTemp" + fileMd5 + fileSeparator);

            if (!tempDir.exists())
            {
                tempDir.mkdirs();
            }

            // 取得文件的大小
            long fileLength = file.length();
            int size = 1048576;

            // 取得被分割后的小文件的数目
            int num = (fileLength % size != 0) ? (int) (fileLength / size + 1) : (int) (fileLength / size);

            // 输入文件流，即被分割的文件
            FileInputStream in = new FileInputStream(file);

            // 读输入文件流的开始和结束下标
            long end = 0;
            int begin = 0;

            // 根据要分割的数目输出文件
            for (int i = 0; i < num; i++)
            {
                boolean _continue = false;

                if (null != chunkList)
                {
                    for (Object o : chunkList)
                    {
                        String chunk = String.valueOf(i + 1);

                        if (chunk.equals(o.toString()))
                        {
                            _continue = true;
                        }
                    }
                }

                if (_continue)
                {
                    continue;
                }

                // 对于前 num - 1 个小文件，大小都为指定的 size
                File outFile = new File(tempDir, file.getName());

                // 构建小文件的输出流
                FileOutputStream out = new FileOutputStream(outFile);

                // 将结束下标后移 size
                end += size;
                end = Math.min(end, fileLength);

                // 从输入流中读取字节存储到输出流中
                for (; begin < end; begin++)
                {
                    out.write(in.read());
                }

                out.close();
                Part[] parts = {new FilePart("filedata", outFile), new StringPart("chunk", (i + 1) + ""), new StringPart("chunks", num + ""), new StringPart("md5", fileMd5), new StringPart("chunkMd5", MD5Util.getFileMD5String(outFile))};
                int tryTime = 0;

                while (tryTime < 2)
                {
                    retval = this.doPost(uploadUrl, parts);
                    JSONObject retvalJson = JSONObject.fromObject(retval);

                    if (retvalJson.getInt("code") == MTCloud.CODE_SUCCESS)
                    {
                        break;
                    }

                    tryTime++;
                }

                parts = null;
                System.gc();
                System.out.println(i);
                System.out.println(outFile.delete());
            }

            in.close();
            tempDir.delete();
        }
        else if (resJson.getInt("code") == MTCloud.CODE_VIDEO_UPLOADED)
        {
            resJson.put("code", MTCloud.CODE_SUCCESS);
            retval = resJson.toString();
        }

        return retval;
    }

    /**
     * 获取课程峰值
     *
     * @param course_id 课程 ID
     * @return String
     */
    public String statsPeakCourse(int course_id) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);

        return this.call("stats.peak.course", params);
    }

    /**
     * 获取直播峰值
     *
     * @param liveid 直播 ID
     * @return String
     */
    public String statsPeakLive(int liveid) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("liveid", liveid);

        return this.call("stats.peak.live", params);
    }


    /**
     * 获取流量明细
     *
     * @param date_time    开始日期，格式 Y-m-d
     * @param end_time     结束日期，格式 Y-m-d，如果传空，则默认为开始日期
     * @param vtype        直播或者点播（回放），1 直播，2 回放，其它值为获取全部
     * @param ctype        当 vtype==2 时，点播的类型, 11 云点播，其它值为回放，传 -1 则获取所有
     * @param departmentID 部门 ID，获取具体部门的统计。0 为无部门；传 -100 为流量数据合计；-1 为列出所有部门，以及合计
     * @param small        当 vtype==2 时，获取小班的回放流量，传 1
     * @return String 成功返回格式 {"code": 0, "data": [{"vtype": "2","ctype": "9", "cid": "844891", "time": "2020-05-11", "flow": 4.661, "departmentID":0}, ...]}
     */
    public String statsFlowList(String date_time, String end_time, int vtype, int ctype, int departmentID, int small) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("date_time", date_time);

        if (!end_time.isEmpty())
        {
            params.put("end_time", end_time);
        }

        params.put("vtype", vtype);

        if (ctype != -1)
        {
            params.put("ctype", ctype);
        }

        if (departmentID != -100)
        {
            params.put("departmentID", departmentID);
        }

        params.put("small", small);

        return this.call("stats.flow.list", params);
    }

    /**
     * 获取流量总计
     *
     * @param departmentID 部门 ID，获取具体部门的统计，0 为无部门，传 -1 为全部
     * @return String
     */
    public String statsPeakExpend(int departmentID) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();

        if (departmentID != -1)
        {
            params.put("departmentID", departmentID);
        }

        return this.call("stats.flow", params);
    }

    /**
     * 获取音视频互动时长统计
     *
     * @param start_time   开始日期，格式 Y-m-d，默认为 7 天前
     * @param end_time     开始日期，格式 Y-m-d，默认昨天，开时结束时间跨度不能超过 31 天
     * @param departmentID 部门 ID，获取具体部门的统计，不传或传空值，则默认返回总计
     * @return String 成功时返回格式：{"code":0, "data":{"1v1":[{"date":"05-08", "duration":31}, {"date":"05-09", "duration":89}, ...], "1v6":[{"date":"05-08", "duration":96}, ...], "1v16":[{"date":"05-08", "duration":96}, ...], "desktop":[{"date":"05-08", "duration":175}, ...]}}，duration 时长单位为分钟
     */
    public String statsRtc(String start_time, String end_time, int departmentID) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("start_time", start_time);
        params.put("end_time", end_time);
        params.put("departmentID", departmentID);

        return this.call("stats.rtc", params);
    }

    /**
     * 自动登录到欢拓 console 后台
     *
     * @param uid    欢拓后台管理员 id
     * @param expire 自动登录地址的过期时间
     * @param target 登录成功后跳转的目标，形式：类型 -ID
     *               如跳到课程 ID 为"123456"的页面：course - 123456
     * @return String string    url 生成的自动登录地址
     */
    public String consoleAutoLogin(int uid, int expire, String target) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("openID", this.openID.trim());
        Date date = new Date();
        long expire1 = date.getTime() / 1000 + expire;
        params.put("expire", expire1);
        params.put("id", uid);
        String url = "http://console.talk-fun.com/?autologin=" + uid + "-" + this.generateSign(params) + "-" + expire1;

        if (!target.isEmpty())
        {
            url = url + "&target=" + URLEncoder.encode(target, StandardCharsets.UTF_8);
        }

        return url;
    }

    /**
     * 点赞记录
     *
     * @param course_id 课程 id
     * @param page      页码
     * @param size      每页数量
     * @return String
     */
    public String courseLikeRecord(int course_id, int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("page", page);
        params.put("size", size);

        return this.call("course.likeRecord", params);
    }

    /**
     * 点播列表
     *
     * @param page    页码
     * @param size    每页数量
     * @param options 其他参数，status：课程状态(0 为正常状态，-1 为已删除)
     * @return String
     */
    public String vodList(int page, int size, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("page", page);
        params.put("size", size);
        params.put("options", options);

        return this.call("course.vodList", params);
    }

    /**
     * 机器人发言
     *
     * @param course_id 课程 id
     * @param nickname  机器人名称
     * @param msg       发言
     * @return String
     */
    public String robotChatSend(int course_id, String nickname, String msg, String avatar) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("nickname", nickname);
        params.put("msg", msg);
        params.put("avatar", avatar);

        return this.call("course.robotChatSend", params);
    }


    /**
     * 根据课程 ID 获取生活直播邀请榜单列表
     *
     * @param course_id 课程 id
     * @param page      页码
     * @param size      每页数量
     * @return String
     */
    public String courseInviteRankList(int course_id, int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("page", page);
        params.put("size", size);

        return this.call("course.inviteRankList", params);
    }

    /**
     * 根据课程 ID、邀请人 ID 获取生活直播的被邀请人列表
     *
     * @param course_id 课程 id
     * @param xid       邀请人用户 id
     * @param page      页码
     * @param size      每页数量
     * @return String
     */
    public String courseInviteRankDetailList(int course_id, int xid, int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("xid", xid);
        params.put("page", page);
        params.put("size", size);

        return this.call("course.inviteRankDetailList", params);
    }

    /**
     * 渠道标识设置
     *
     * @param course_id 课程 id
     * @param options   其他参数
     * @return String
     */
    public String courseCtagsSet(int course_id, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("options", options);

        return this.call("course.ctagsSet", params);
    }

    /**
     * 点名列表
     *
     * @param course_id 课程 id
     * @param page      页码
     * @param size      每页数量
     * @return String
     */
    public String courseSignList(int course_id, int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("page", page);
        params.put("size", size);

        return this.call("course.sign", params);
    }

    /**
     * 点名详情
     *
     * @param course_id 课程 id
     * @param signId    点名序列
     * @param page      页码
     * @param size      每页数量
     * @return String
     */
    public String courseSignDetail(int course_id, int signId, int page, int size) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("signId", signId);
        params.put("page", page);
        params.put("size", size);

        return this.call("course.sign.detail", params);
    }

    /**
     * 商品添加
     *
     * @param departmentID 部门 id
     * @param options      其他参数
     * @return String
     */
    public String goodsAdd(int departmentID, HashMap<Object, Object> options) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("departmentID", departmentID);
        params.put("options", options);

        return this.call("goods.add", params);
    }

    /**
     * 回放有效期设置
     *
     * @param course_id 课程 id
     * @param enable    是否关闭回放，0 关闭回放 ，1 开启回放
     * @param expire    回放有效期，0 无限制，不大于 30 天
     * @return String
     */
    public String coursePlaybackExpireSet(int course_id, int enable, int expire) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("course_id", course_id);
        params.put("enable", enable);
        params.put("expire", expire);

        return this.call("course.playback.setExpire", params);
    }

    /**
     * 构造欢拓云签名
     *
     * @param params 业务参数
     * @return String
     * @throws Exception 异常
     */
    public String generateSign(HashMap<Object, Object> params) throws Exception
    {
        params.remove("sign");
        Object[] array = params.keySet().toArray();
        java.util.Arrays.sort(array);
        StringBuilder keyStr = new StringBuilder();

        for (Object o : array)
        {
            String key = o.toString();
            keyStr.append(key).append(params.get(key));
        }

        keyStr.append(this.openToken.trim());

        return MD5.md5(keyStr.toString());
    }

    public String call(String cmd, HashMap<Object, Object> params) throws Exception
    {
        HashMap<Object, Object> files = new HashMap<>();

        return this.call(cmd, params, "GET", files);
    }

    /**
     * 构造请求串
     *
     * @param cmd        命令
     * @param params     参数
     * @param HttpMethod HTTP 方法
     * @param files      文件
     * @return String
     * @throws Exception 异常
     */
    public String call(String cmd, HashMap<Object, Object> params, String HttpMethod, HashMap<Object, Object> files) throws Exception
    {
        // 构造系统参数
        HashMap<Object, Object> sysParams = new HashMap<>();
        sysParams.put("openID", this.openID.trim());

        // 获取时间戳
        Date date = new Date();
        long time = date.getTime() / 1000;
        String ts = time + "";
        sysParams.put("timestamp", ts);
        sysParams.put("ver", this.version);
        sysParams.put("format", this.format);
        sysParams.put("cmd", cmd);
        sysParams.put("params", URLEncoder.encode(JSONObject.fromObject(params).toString(), StandardCharsets.UTF_8));

        // 签名
        sysParams.put("sign", generateSign(sysParams));
        sysParams.putAll(files);
        String retval;

        if (HttpMethod.equals("POST"))
        {
            Object[] array = sysParams.keySet().toArray();
            Part[] parts = new Part[array.length];

            for (int i = 0; i < array.length; i++)
            {
                String key = array[i].toString();
                String value = (String) sysParams.get(key);

                if (0 == value.indexOf("@"))
                {
                    File f;
                    f = new File(value.substring(1));
                    parts[i] = new FilePart(key, f);
                }
                else
                {
                    parts[i] = new StringPart(key, value);
                }
            }

            retval = doPost(this.restUrl, parts);
        }
        else
        {
            // 构造请求 URL
            String resurl = "";

            if (this.debug)
            {
                System.out.println(sysParams);
            }

            resurl += this.restUrl + "?" + mapToQueryString(sysParams);

            if (this.debug)
            {
                System.out.println(resurl);
            }

            retval = doGet(resurl);
        }

        if (retval == null && !this.restUrl.equals(this.restUrl2))
        {
            String tempUrl = this.restUrl;
            this.restUrl = this.restUrl2;
            retval = this.call(cmd, params, HttpMethod, files);
            this.restUrl = tempUrl;
        }

        return retval;
    }

    // GET 请求
    public String doGet(String url)
    {
        // 实例化 httpClient
        HttpClient client = new HttpClient();
        HttpMethod method = new GetMethod(url);
        method.addRequestHeader("User-Agent", "MT-JAVA-SDK");

        try
        {
            // 执行
            client.executeMethod(method);
            InputStream jsonStr;
            jsonStr = method.getResponseBodyAsStream();

            if (200 != method.getStatusCode() && !this.restUrl.equals(this.restUrl2))
            {
                return null;
            }

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int i = -1;

            while ((i = jsonStr.read()) != -1)
            {
                baos.write(i);
            }

            jsonStr.close();
            baos.close();
            method.releaseConnection();

            return baos.toString(StandardCharsets.UTF_8);

        }
        catch (IOException e)
        {
            if (!this.restUrl.equals(this.restUrl2))
            {
                return null;
            }
            else
            {
                e.printStackTrace();
            }
        }

        return null;
    }

    public String doPost(String url, Part[] parts)
    {
        PostMethod filePost = new PostMethod(url);
        filePost.addRequestHeader("User-Agent", "MT-JAVA-SDK");
        filePost.setRequestEntity(new MultipartRequestEntity(parts, filePost.getParams()));
        HttpClient client = new HttpClient();

        try
        {
            client.executeMethod(filePost);
            InputStream jsonStr;
            jsonStr = filePost.getResponseBodyAsStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int i = -1;

            while ((i = jsonStr.read()) != -1)
            {
                baos.write(i);
            }

            jsonStr.close();
            baos.close();
            filePost.releaseConnection();

            return baos.toString(StandardCharsets.UTF_8);
        }
        catch (IOException e)
        {
            if (!this.restUrl.equals(this.restUrl2))
            {
                return null;
            }
            else
            {
                e.printStackTrace();
            }
        }

        return null;
    }

    /**
     * 生成一个游客 ID
     *
     * @return String
     */
    public UUID generateGuestId()
    {
        UUID uuid = UUID.randomUUID();

        return uuid;
    }

    /**
     * 生成一個短地址
     *
     * @return String
     */
    public String generateShortUrl(String url) throws Exception
    {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("url", url);

        return this.call("utils.shorturl", params);
    }

    /**
     * 将 map 中的参数及对应值转换为查询字符串
     *
     * @param params 参数
     * @return String
     */
    private String mapToQueryString(HashMap<Object, Object> params)
    {
        Object[] array = params.keySet().toArray();
        java.util.Arrays.sort(array);
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < array.length; i++)
        {
            String key = array[i].toString();

            if (i != array.length - 1)
            {

                str.append(key).append("=").append(URLEncoder.encode((String) params.get(key), StandardCharsets.UTF_8)).append("&");

            }
            else
            {
                str.append(key).append("=").append(URLEncoder.encode((String) params.get(key), StandardCharsets.UTF_8));
            }
        }

        return str.toString();
    }

    private String base64UrlEncode(String input)
    {
        input = new String(Base64.encodeBase64(input.getBytes(StandardCharsets.UTF_8)));
        input = input.replace("=", "");
        input = input.replace("+", "-");
        input = input.replace("/", "_");

        return input;
    }

    /**
     * MD5加密类
     */
    private static class MD5
    {
        private static final char[] md5Chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        public static String md5(String str)
        {
            MessageDigest md5 = getMD5Instance();
            md5.update(str.getBytes(StandardCharsets.UTF_8));
            byte[] digest = md5.digest();
            char[] chars = toHexChars(digest);

            return new String(chars);
        }

        private static MessageDigest getMD5Instance()
        {
            try
            {
                return MessageDigest.getInstance("MD5");
            }
            catch (NoSuchAlgorithmException ignored)
            {
                throw new RuntimeException(ignored);
            }
        }

        private static char[] toHexChars(byte[] digest)
        {
            char[] chars = new char[digest.length * 2];
            int i = 0;

            for (byte b : digest)
            {
                char c0 = md5Chars[(b & 0xf0) >> 4];
                chars[i++] = c0;
                char c1 = md5Chars[b & 0xf];
                chars[i++] = c1;
            }

            return chars;
        }
    }

    public static void main(String[] args)
    {

    }
}
