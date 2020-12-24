
//请求服务器的基础地址
const baseUrl = 'https://mall.base.com/api/' 

export function request(url,data,onSucces,onFaild){
	uni.request({
	       url: baseUrl + url, 
		   method:'POST',
	       data: {
			   // 自定义的参数
	           ...data,
			   "platform":3,
			   "version_no":"7_0",
			   "ticket":"LJXCX_202007171449205f1149f068265765521"
	       },
	       header: {
			   //自定义请求头信息
			   // 'Access-Control-Expose-Headers':'Authorization'
	       },
	       success: (res) => {
			   
			   if(onSucces){
				   let data = res.data
				   if(data && data.code === 200){
					   onSucces(data)
				   }else{
					   onRequestFaild(onFaild,res)
				   }
			   }
	       },
		   fail: (res) => {
				onRequestFaild(onFaild,res)
		   }
	   });
}

// 失败的数据请求处理
function onRequestFaild(onFaild,res){
	console.log(res)
	if(onFaild){
		onFaild(res.data)
	}
}