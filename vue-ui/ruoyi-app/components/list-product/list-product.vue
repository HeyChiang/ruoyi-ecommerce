<template>
	<view>
		<list-product-item class="productItemLayout" :item="item" v-for="(item,index) in list" :key="item.id"></list-product-item>
		<uni-load-more :status="loadMoreStatus" v-if="loadMoreStatus"></uni-load-more>
	</view>
</template>

<script>
	export default {
		data(){
			return{
				showMore:false
			}
		},
		props:{
			loadMoreStatus:{
				type:String,
				default:''
			},
			list:{
				type:Array
			}
		}
	}
</script>

<style lang="scss">

</style>
