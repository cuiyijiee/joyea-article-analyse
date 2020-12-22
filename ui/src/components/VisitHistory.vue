<template>
    <div class="container">
        <a-button type="primary" @click="handleExportAllVisitorRecord">
            导出EXCEL
        </a-button>
        <a-table :columns="columns" :data-source="productList" bordered
                 :pagination="pagination" :loading="loading" @change="handleTableChange">
            <template #headImage="{ text: headImage }">
              <span>
                  <a-avatar :src="headImage" size="large"/>
              </span>
            </template>
            <template #aHref="{ text: webUrl }">
              <span>
                  <a :href="webUrl" target="_blank">{{ webUrl }}</a>
              </span>
            </template>
        </a-table>
    </div>
</template>

<script>
import {dateFormat} from "@/utils"
import {pageFindReadRecord, findAllReadRecord} from "@/api"
import XLSX from 'xlsx'

const columns = [
    {
        title: '微信头像',
        dataIndex: 'wxHeadImage',
        key: 'wxHeadImage',
        slots: {customRender: 'headImage'},
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
        slots: {customRender: 'aHref'},
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
                        key: record.id,
                        createdAt: dateFormat(record.createdAt),
                        wxHeadImage: record.visitor.wxHeadImage,
                        wxNickName: record.visitor.wxNickName,
                        companyName: record.visitor.companyName,
                        userName: record.visitor.userName,
                        companyPosition: record.visitor.companyPosition,
                        mobileNumber: record.visitor.mobileNumber,
                        webTitle: record.productWeb.webTitle,
                        webUrl: record.productWeb.webUrl,
                        productName: record.productWeb.productName,
                    })
                })
            }).finally(() => {
                this.loading = false;
            })
        },
        handleExportAllVisitorRecord() {
            findAllReadRecord().then(resp => {
                let allVisitRecord = [];
                resp.forEach(record => {
                    allVisitRecord.push({
                        "微信头像": record.visitor.wxHeadImage,
                        "微信昵称": record.visitor.wxNickName,
                        "公司名称": record.visitor.companyName,
                        "姓名": record.visitor.userName,
                        "职位": record.visitor.companyPosition,
                        "联系方式": record.visitor.mobileNumber,
                        "链接标题": record.productWeb.webTitle,
                        "链接地址": record.productWeb.webUrl,
                        "产品名称": record.productWeb.productName,
                        "扫码时间": dateFormat(record.createdAt),
                    })
                });
                const worksheet = XLSX.utils.json_to_sheet(allVisitRecord);
                const wb = XLSX.utils.book_new();
                XLSX.utils.book_append_sheet(wb, worksheet, "Sheet");
                XLSX.writeFile(wb, "访问记录.xlsx");
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