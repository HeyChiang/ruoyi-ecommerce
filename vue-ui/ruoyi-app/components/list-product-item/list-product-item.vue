<template>
	<view class="productContainer"  style="height: 100%;" @click="onClick">
		<u-image border-radius="6" width="230rpx" height="230rpx" :src="item.slideshow" class="img"></u-image>
		<view class="productRightLayout">
			<text class="productName">{{item.title}}</text>
			<u-line-progress active-color="#F61639" :percent="70" :show-percent="false" height="20"></u-line-progress>
			<view class="soldTextLayout">
				已售：<text class="soldText">{{item.salesreal}}</text>份/还剩{{item.total}}件
			</view>
			<view class="bottomLayout">
				<view>
					<text class="priceText">￥{{item.marketprice}}</text>
					<text class="delPriceText">￥{{item.productprice}}</text>
				</view>
				<view class="buyBtn">立即抢购</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		props:{
			item:{
				type:Object
			}
		},
		data() {
			return {
				
			};
		},
		methods:{
			onClick(){
				uni.navigateTo({
					url:'/pages/shop/product-detail/product-detail?id='+this.item.id+"&shopId=1"
				})
			}
		}
	}
</script>

<style lang="scss">
.productContainer{
	display: flex;
	padding: 15rpx 30rpx 15rpx 30rpx;
	.img{
		flex-shrink: 0;
	}
	.productRightLayout{
		margin-left: 30rpx;
		display: inline-flex;
		flex-direction: column;
		height: 100%;
		width: 100%;
		.productName{
			color: $uni-text-color;
			font-size: $uni-font-size-base;
			margin-bottom: 15rpx;
		}
		.soldTextLayout{
			margin-top: 15rpx;
			font-size: $uni-font-size-sm;
			.soldText{
				color: $uni-color-primary;
			}
		}
		.bottomLayout{
			margin-top: 15rpx;
			display: flex;
			flex-direction: row;
			justify-content: space-between;
			justify-items: center;
			.priceText{
				height: 60rpx;
				line-height: 60rpx;
				color: $uni-color-primary;
				font-size: $uni-font-size-lg;
			}
			.delPriceText{
				height: 60rpx;
				margin-left: 15rpx;
				margin-top: 6rpx;
				line-height: 60rpx;
				font-size: $uni-font-size-sm;
				color: $uni-text-color-grey;
				text-decoration: line-through;
			}
			.buyBtn{
				width: 150rpx;
				height: 60rpx;
				color: $uni-color-primary;
				border-radius: 8rpx;
				border: 3rpx solid $uni-color-primary;
				background-color: $uni-bg-color;
				text-align: center;
				line-height: 60rpx;
				font-size: $uni-font-size-base;
			}
		}
	}
}
</style>
