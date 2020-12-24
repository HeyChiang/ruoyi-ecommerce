'use strict';

const db = uniCloud.database()
const pageSie = 10

exports.main = async (event, context) => {
	const page = event.page;
	
	const subject = await db.collection('product_list').aggregate().skip(page*pageSie).limit(pageSie).end()
	
	//返回数据给客户端
	return {
		"status":200,
		"msg":"成功",
		"data":subject
	}
};
