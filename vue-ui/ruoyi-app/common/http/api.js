import {request} from './request.js'

// 仅作为示例用于请求java、php类的服务器数据
// import { getGoodDetail } from '@/common/http/api.js'
// getGoodDetail({
// 	"id":options.id,
// 	"shopId":options.shopId
// },({data})=>{
// 	 // 处理返回的数据
// })


// 首页Banner和商品数据
export function getIndex(data,onSuccess,onFaild){
	request('/appindex/index',data,onSuccess,onFaild)
}

// 首页的tab数据
export function getAgent(data,onSuccess,onFaild){
	request('/agent/shopInfo',data,onSuccess,onFaild)
}

// 商品详情
export function getGoodDetail(data,onSuccess,onFaild){
	request('/appindex/goods_detail',data,onSuccess,onFaild)
}