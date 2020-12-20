<template>
    <a-layout id="components-layout-demo-fixed">
        <a-layout-header :style="{ position: 'fixed', zIndex: 1, width: '100%' }">
            <div class="logo"/>
            <a-menu theme="dark"
                    mode="horizontal"
                    v-model:selectedKeys="selectedKeys"
                    :style="{ lineHeight: '64px' }">
                <a-menu-item key="1">
                    链接管理
                </a-menu-item>
                <a-menu-item key="2">
                    访问记录
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
            ©{{ new Date().getFullYear() }} Created by Joyea Company
        </a-layout-footer>
    </a-layout>
</template>
<script>
export default {
    data() {
        return {
            selectedKeys: ['2'],
        };
    },
};
</script>
<style>
#components-layout-demo-fixed .logo {
    width: 120px;
    height: 31px;
    background: rgba(255, 255, 255, 0.2);
    margin: 16px 24px 16px 0;
    float: left;
}
</style>
