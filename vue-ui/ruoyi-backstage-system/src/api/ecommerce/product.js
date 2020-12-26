import request from '@/utils/request'

// 查询商品列表
export function listProduct(query) {
  return request({
    url: '/ecommerce/product/list',
    method: 'get',
    params: query
  })
}

// 查询商品详细
export function getProduct(pkId) {
  return request({
    url: '/ecommerce/product/' + pkId,
    method: 'get'
  })
}

// 新增商品
export function addProduct(data) {
  return request({
    url: '/ecommerce/product',
    method: 'post',
    data: data
  })
}

// 修改商品
export function updateProduct(data) {
  return request({
    url: '/ecommerce/product',
    method: 'put',
    data: data
  })
}

// 删除商品
export function delProduct(pkId) {
  return request({
    url: '/ecommerce/product/' + pkId,
    method: 'delete'
  })
}

// 导出商品
export function exportProduct(query) {
  return request({
    url: '/ecommerce/product/export',
    method: 'get',
    params: query
  })
}