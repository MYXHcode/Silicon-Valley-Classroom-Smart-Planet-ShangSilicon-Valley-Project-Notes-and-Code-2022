import request from '@/utils/request'

export function login(data)
{
  return request({
    // url: '/vue-admin-template/user/login',
    url: '/admin/vod/user/login',
    method: 'post',
    data
  })
}

export function getInfo(token)
{
  return request({
    // url: '/vue-admin-template/user/info',
    url: '/admin/vod/user/info',
    method: 'get',
    params: { token }
  })
}

export function logout()
{
  return request({
    // url: '/vue-admin-template/user/logout',
    url: '/admin/vod/user/logout',
    method: 'post'
  })
}
