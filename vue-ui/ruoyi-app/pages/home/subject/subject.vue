<template>
	<view>
		<list-product :list="productList" :loadMoreStatus="loadMoreStatus"></list-product>
		<page-loading :showLoading="showLoading"></page-loading>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				productList:[],
				loadMoreStatus:'',
				showLoading:true,
				page:0
			};
		},
		onLoad(options) {
			uni.setNavigationBarTitle({
				title:options.title
			})
			this.getData()
		},
		onReachBottom() {
			this.getData()
		},
		methods:{
			getData(){
				if(this.loadMoreStatus === 'noMore'){
					console.log('没有分页数据了')
					return
				}
				
				uniCloud.callFunction({
					name:"subject",
					data:{
						"page":this.page
					},
					success: (res) => {
						if(res.success && res.result.status === 200){
							const data = res.result.data
							this.productList.push(...data.data)
							if(data.data.length >9){
								this.loadMoreStatus = 'loading'
							}else{
								this.loadMoreStatus = 'noMore'
							}
							
							this.page++
						}
						this.showLoading = false
					},
					fail: (res) => {
						this.showLoading = false
					}
				})
			}
		}
	}
</script>

<style lang="scss">
	
</style>
