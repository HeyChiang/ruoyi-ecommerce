# sixty-three

#### 介绍
全端移动应用，使用uni-app编写，可在IOS、Android、小程序、H5端运行，服务器使用uniCloud的serverless。

#### Andorid端演示
![动态图演示](https://images.gitee.com/uploads/images/2020/0831/235333_31eef805_2350381.gif "adb7ea4904de5d88597e33ad561a3220[00_00_00--00_00_06].gif")

#### 软件架构
![演示图](https://images.gitee.com/uploads/images/2020/0831/234752_decb47e6_2350381.png "电商开源项目.png")


#### 安装使用

1. 安装[HBuilderX](https://www.dcloud.io/hbuilderx.html)开发工具
2. 选择[文件 - 导入 - 从Git导入]，将本仓库的https地址放入url输入框
3. 服务器uniCloud准备
    1. 选择项目文件夹下的cloudfunctions-aliyun，右键点击创建自己的云空间
    2. 选择cloudfunctions-aliyun文件夹下的db_init.json，右键初始化云空间
	3. 在static/serverless里有banner、商品列表的图片，上传到uniCloud云储存里
4. 安装HBuilderX插件
	1. [scss/sass编译](https://ext.dcloud.net.cn/plugin?name=compile-node-sass )
	2. 安装最新的uview-ui框架：npm install uview-ui
5. 选择[运行 - 运行到浏览器 - chrome]，可在h5上直接看到效果



#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request
5.  [代码规范](https://cn.vuejs.org/v2/style-guide/#%E7%BB%84%E4%BB%B6%E6%96%87%E4%BB%B6%E5%BC%BA%E7%83%88%E6%8E%A8%E8%8D%90)
