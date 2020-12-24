'use strict';

const db = uniCloud.database()

exports.main = async (event, context) => {
	//event为客户端上传的参数
	
	const product_list = await db.collection('product_list').get()
	const banner = await db.collection('banner').get()
	const subject = await db.collection('subject').get()
	const product_label = await db.collection('product_label').get()
	
	let home = {product_list,banner,subject,product_label}
	
	//返回数据给客户端
	return {
		"status":200,
		"msg":"成功",
		"data":home
	}
};
