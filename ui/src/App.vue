<template>
    <a-layout id="components-layout-demo-fixed">
        <a-layout-header :style="{ position: 'fixed', zIndex: 1, width: '100%' }">
            <div class="logo">
                <h3 style="">江苏仅一联合智造有限公司</h3>
            </div>
            <a-menu theme="dark"
                    mode="horizontal"
                    v-model:selectedKeys="selectedKeys"
                    @click="handleGo"
                    :style="{ lineHeight: '64px' }">
                <a-menu-item key="/">
                    访问记录
                </a-menu-item>
                <a-menu-item key="/manage">
                    链接管理
                </a-menu-item>
            </a-menu>
        </a-layout-header>
        <a-layout-content :style="{ padding: '0 50px', marginTop: '64px' }">
            <a-breadcrumb :style="{ margin: '16px 0' }">
                <!--                <a-breadcrumb-item>Home</a-breadcrumb-item>-->
            </a-breadcrumb>
            <div :style="{ background: '#fff', padding: '24px', minHeight: '380px' }">
                <router-view></router-view>
            </div>
        </a-layout-content>
        <a-layout-footer :style="{ textAlign: 'center' }">
            <!--            ©{{ new Date().getFullYear() }} Created by Joyea Company-->
        </a-layout-footer>
    </a-layout>
</template>
<script>
export default {
    data() {
        return {};
    },
    computed: {
        selectedKeys() {
            let selectedKey = [];
            selectedKey.push(this.$route.fullPath);
            return selectedKey;
        }
    },
    methods: {
        handleGo(path) {
            this.$router.replace(path.key);
        }
    }
};
</script>
<style>
#components-layout-demo-fixed .logo {
    width: 240px;
    height: 30px;
    background: azure;
    margin: 16px 24px 16px 0;
    float: left;
    line-height: 30px;
    text-align: center;
}

#components-layout-demo-fixed .logo h3 {
    color: #1890FF;
}
</style>
