<template>
    <div class="container">
        <a-table :columns="columns" :data-source="productList" bordered
                 :pagination="pagination" :loading="loading" @change="handleTableChange">
            <template #headImage="{ text: headImage }">
              <span>
                  <a-avatar :src="headImage" size="large"/>
              </span>
            </template>
            <template #aHref="{ text: webUrl }">
              <span>
                  <a :href="webUrl" target="_blank">{{webUrl}}</a>
              </span>
            </template>
        </a-table>
    </div>
</template>

<script>
import {dateFormat} from "@/utils"
import {pageFindReadRecord} from "@/api"

const columns = [
    {
        title: '微信头像',
        dataIndex: 'wxHeadImage',
        key: 'wxHeadImage',
        slots: { customRender: 'headImage' },
    },
    {
        title: '微信昵称',
        dataIndex: 'wxNickName',
        key: 'wxNickName',
    },
    {
        title: '公司名称',
        key: 'companyName',
        dataIndex: 'companyName',
    },
    {
        title: '姓名',
        key: 'userName',
        dataIndex: 'userName',
    },
    {
        title: '职务',
        dataIndex: 'companyPosition',
        key: 'companyPosition',
    },
    {
        title: '手机号码',
        dataIndex: 'mobileNumber',
        key: 'mobileNumber',
    },
    {
        title: '标题',
        dataIndex: 'webTitle',
        key: 'webTitle',
    },
    {
        title: '产品名称',
        dataIndex: 'productName',
        key: 'productName',
    },
    {
        title: '文章链接',
        dataIndex: 'webUrl',
        key: 'webUrl',
        slots: { customRender: 'aHref' },
    },
    {
        title: '扫码时间',
        dataIndex: 'createdAt',
        key: 'createdAt',
    },
];

export default {
    name: "VisitHistory",
    data() {
        return {
            columns,
            loading: false,
            pagination: {},
            productList: []
        }
    },
    methods: {
        handleTableChange(pagination) {
            const pager = {...this.pagination};
            pager.current = pagination.current;
            this.pagination = pager;
            this.handleFetchData(pagination.current - 1, pagination.pageSize);
        },
        handleFetchData(current, pageSize) {
            this.loading = true;
            pageFindReadRecord(current, pageSize).then(resp => {
                const pagination = {...this.pagination};
                pagination.total = resp.total;
                pagination.current = current + 1;
                pagination.pageSize = pageSize;
                this.pagination = pagination;

                this.productList = [];
                resp.data.forEach(record => {
                    this.productList.push({
                        key:record.id,
                        createdAt: dateFormat(record.createdAt),
                        wxHeadImage:record.visitor.wxHeadImage,
                        wxNickName:record.visitor.wxNickName,
                        companyName:record.visitor.companyName,
                        userName:record.visitor.userName,
                        companyPosition:record.visitor.companyPosition,
                        mobileNumber:record.visitor.mobileNumber,
                        webTitle:record.productWeb.webTitle,
                        webUrl:record.productWeb.webUrl,
                        productName:record.productWeb.productName,
                    })
                })
            }).finally(() => {
                this.loading = false;
            })
        }
    },
    created() {
        this.handleFetchData(0, 10)
    }
}
</script>

<style scoped>

</style>