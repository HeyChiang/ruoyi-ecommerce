<template>
	<view class="loading-layout" v-if="showLoading">
		<u-loading mode="flower" size="60"></u-loading>
		<text class="loading-text">正在加载...</text>
	</view>
</template>

<script>
	export default {
		name:"page-loading",
		data() {
			return {

			};
		},
		props: {
			showLoading: {
				type: Boolean,
				default: true
			}
		}
	}
</script>

<style lang="scss">
	.loading-layout {
		position: fixed;
		display: flex;
		width: 100%;
		height: 100%;
		top: 0;
		justify-content: center;
		align-items: center;
		background-color: #FFFFFF;
		z-index: 100;
		.loading-text {
			margin-left: 10rpx;
			font-size: $uni-font-size-lg;
			color: $uni-text-color;
		}
	}
</style>
