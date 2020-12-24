<template>
	<view class="content">
		<navbar ref="navbar" class=".navbar"></navbar>
		<swiper class="bannerSwiper" :circular="true" indicator-active-color="#F61639" :indicator-dots="banner && banner.length > 1" autoplay="true" interval="5000" duration="200">
			<swiper-item  v-for="(item,index) in banner" :key="index">
				<u-image border-radius="10" width="690" height="316" :src="item.thumb">
				</u-image>
			</swiper-item>
		</swiper>
		<view class="subject-layout">
			<view class="subject-item" v-for="(item,index) in subjectList" @click="onSubjectClick(item)" :key="index">
			    <image class="subject-img" :src="item.thumb"></image>
			    <text class="subject-text">{{item.title}}</text>
			</view>
		</view>
		<view class="line"></view>
		<u-tabs :style="{top: navbarBottom +'px'}" class="tabStyle" :class="[{navBarFixed:floatView}]" active-color="#F61639" bar-width="85" :list="indexTabs" :current="tabIndex" @change="onTabChange"></u-tabs>

		<!-- 占位符，防止tab消失的时候发生的抖动 -->
		<view :style="{width: '100%', height: tabHeight + 'px'}" v-if="floatView"></view>
		<swiper class="swiperLayout" :style="{height: swiperHeight+'px'}" @change="onSwiperChange" :current="tabIndex">
			<swiper-item v-for="(item,index) in tabList.length" :key="index">
				<list-product class="swiperItemLayout" :list="productList"></list-product>
			</swiper-item>
		</swiper>
	</view>
</template> 

<script>
import navbar from './components/navbar.vue';
import {getIndex,getAgent} from '@/common/http/api.js'

export default {
	components: {
		navbar
	},
	data() {
		return {
			banner:[],
			floatView:false,
			navbarBottom:0,
			tabTop:0,
			tabHeight:0,
			swiperHeight:0,
			tabIndex:0,
			myRefs:[],
			productList:[],
			subjectList:[],
			tabList: []
		};
	},
	computed:{
		indexTabs:function(){
			// 将tabList的数据转换成uView框架组件能识别的数据
			return this.tabList.map((item)=>{
				return {"name":item.title}
			})
		}
	},
	onLoad() {
		uniCloud.callFunction({
			name:"home",
			success: (res) => {
				if(res.success && res.result.status === 200){
					const data = res.result.data
					this.tabList = data.product_label.data
					this.banner = data.banner.data
					this.subjectList = data.subject.data
					this.productList = data.product_list.data
					this.updateScrollHeight() 
					
				}else{
					console.log('请求失败',res)
				}
				
			}
		})
	},
	onPageScroll(e){
		// 当页面滑动的高度+搜索栏的高度 >= u-tabs的top的位置时，进入漂浮状态
		this.floatView = (e.scrollTop+this.navbarBottom) >= this.tabTop
	},
	methods: {
		onSubjectClick(item){
			uni.navigateTo({
				url:'/pages/home/subject/subject?title='+item.title
			})
		},
		onSwiperChange({detail}){
			this.tabIndex = detail.current;
		},
		onTabChange(index) {
			this.tabIndex = index;
		},
		getRectAndSize(className,onCallBack){
			const query = uni.createSelectorQuery().in(this);
			query.select(className).fields({
			  size: true,
			  rect: true
			}, onCallBack).exec();
		},
		updateScrollHeight(){
			this.$nextTick(()=>{
			
				this.getRectAndSize('.tabStyle', (data) => {
					// 获取u-tabs的高度
					this.tabHeight = data.height
					// 获取u-tabs组件顶部在容器里纵轴的位置
					this.tabTop = data.top
				})
				this.getRectAndSize('.navbar', (data) => {
				  // 获取narbar的高度，u-tabs的组件要显示在搜索栏下
				  this.navbarBottom = data.height
				})
				
				// swiper没有自动计算高度，这里获取高度然后赋值撑开页面内容的高度
				const query = uni.createSelectorQuery().in(this);
				query.selectAll('.swiperItemLayout').fields({
				  size: true,
				  rect: true
				}, (data)=>{
					this.swiperHeight = data[this.tabIndex].height
				}).exec();
				
			})
		}
	}
};
</script>

<style lang="scss">
@import 'uview-ui/index.scss';

.navBarFixed {
    position: fixed;
    z-index: 99;
    width:100%;
}

.content {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	.bannerSwiper {
		margin: 25rpx;
		width: 690rpx;
		height: 316rpx;
	}
	.line{
		width: 100%;
		height: 2rpx;
		background-color: $uni-bg-color-grey;
	}
	.subject-layout {
		margin-top: 12rpx;
		display: flex;
		flex-direction: row;
		justify-content: flex-start;
		flex-wrap: wrap;
		.subject-item {
			display: flex;
			flex-direction: column;
			font-size: 24rpx;
			padding-left: 14rpx;
			padding-right: 14rpx;
			margin-bottom: 28rpx;
			align-items: center;
			.subject-text {
				color: #333333;
				text-align: center;
			}
			image {
				width: 100rpx;
				height: 100rpx;
				margin-left: 10rpx;
				margin-right: 10rpx;
				margin-bottom: 14rpx;
				border-radius: 50%;
				box-shadow: 4rpx 4rpx 20rpx rgba(194, 194, 194, 0.3);
			}
		}
	}
	.tabStyle {
		width: 100%;
	}
	.swiperLayout{
		width: 100%;
		height: 100%;
		.productItemLayout{
			height: 100%;
		}
	}
}
</style>
