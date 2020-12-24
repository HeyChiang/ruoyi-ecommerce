<template>
	<view class="navbar" @click="open">
		<view class="navbar-fixed">
			<view :style="{ height: barStatuHeight + 'rpx' }"></view>
			<view class="search-content" :style="{ height: navbarHeight + 'rpx', width: navbarwidth + 'px' }">
				<view class="navbar-search">
					<image src="@/static/icon_search.png" class="navbar-search-icon"></image>
					<view class="search-text">搜索商品名称</view>
				</view>
				<!-- #ifndef MP || H5 -->
				<image src="@/static/icon_share.png" class="navbar-share-icon" @click="onShareClick"></image>
				<!-- #endif -->
			</view>
		</view>
		<view :style="{ height: (barStatuHeight + navbarHeight) + 'rpx' }"></view>
	</view>
</template>

<script>
export default {
	data() {
		return {
			barStatuHeight: 20*2,
			navbarHeight: 45*2,
			navbarwidth: 375*2
		};
	},
	created() {
		let systemInfo = uni.getSystemInfoSync();
		this.barStatuHeight = systemInfo.statusBarHeight * 1.8;
		this.navbarwidth = systemInfo.windowWidth;
		

		// #ifndef H5 || APP-PLUS || MP-ALIPAY
		let meanuRect = uni.getMenuButtonBoundingClientRect();
		//利用胶囊来计算状态栏的高度
		this.navbarHeight = meanuRect.bottom - this.barStatuHeight + meanuRect.top - this.barStatuHeight;
		this.navbarwidth = meanuRect.left;
		// #endif
		
	},
	methods: {
		open() {
			uni.navigateTo({
				url:'/pages/home/search/search'
			})
		},
		onShareClick(){
			uni.getProvider({
			    service: 'oauth',
			    success: function (res) {
					//获得支持分享的排条
			        console.log(res.provider)
			        if (~res.provider.indexOf('weixin')) {
						//进行分享操作
			            uni.share({
			                provider: "weixin",
			                scene: "WXSceneSession",
			                type: 0,
			                href: "http://uniapp.dcloud.io/",
			                title: "uni-app分享",
			                summary: "我正在使用HBuilderX开发uni-app，赶紧跟我一起来体验！",
			                imageUrl: "https://img-cdn-qiniu.dcloud.net.cn/uniapp/images/uni@2x.png",
			                success: function (res) {
			                    console.log("success:" + JSON.stringify(res));
			                },
			                fail: function (err) {
			                    console.log("fail:" + JSON.stringify(err));
			                }
			            });
			        }
			    }
			});
		}
	}
};
</script>

<style lang="scss">
.navbar {
	.navbar-fixed {
		position: fixed;
		top: 0;
		left: 0;
		z-index: 99;
		width: 100%;
		background-color: $uni-color-primary;
		.search-content {
			display: flex;
			justify-content: center;
			align-items: center;
			padding: 0 30rpx;
			box-sizing: border-box;
			.navbar-search {
				display: flex;
				width: 100%;
				align-items: center;
				height: 60rpx;
				border-radius: 60rpx;
				padding: 0 20rpx;
				background-color: #ffffff;
				.search-text {
					font-size: 24rpx;
					margin-left: 12rpx;
					color: #999;
				}
				.navbar-search-icon{
					width: 32rpx;
					height: 32rpx;
				}
			}
			.navbar-share-icon{
				padding-left: 22rpx;
				width: 48rpx;
				height: 48rpx;
			}
		}
	}
}
</style>
