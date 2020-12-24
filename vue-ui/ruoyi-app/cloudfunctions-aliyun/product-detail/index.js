'use strict';
const db = uniCloud.database()

exports.main = async (event, context) => {
	if(isNaN(event.id)){
		return {
			"status":201,
			"msg":"上传的ID错误,参数：" + event
		}
	}
	
	const result = await db.collection('product').where({
		"id":event.id
	}).get()
	
	//返回数据给客户端
	return {
		"status":200,
		"msg":"成功",
		"data": result
	}
};
