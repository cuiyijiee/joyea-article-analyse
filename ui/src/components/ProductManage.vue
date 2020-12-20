<template>
    <div class="container">
        <a-button type="primary" @click="showCreateOrUpdateDialog">
            新增
        </a-button>
        <a-table :columns="columns" :data-source="productList" bordered
                 :pagination="pagination" :loading="loading" @change="handleTableChange">
            <template #action="{record}">
                <span>
                    <a-button @click="showCreateOrUpdateDialog($event,record)">修改</a-button>
                    <a-divider type="vertical"/>
                    <a-tooltip trigger="click">
                            <template #title>
                                <div :ref="'qrcode_' + record.id">
                                    <vue-qrcode :value="`https://scan.joyea.cn/preview?webId=${record.id}`"/>
                                </div>
                                <a-button style="width: 100%;margin-top: 20px"
                                          @click="handleDownloadQrcode(record)">下载</a-button>
                            </template>
                        <a-button>二维码</a-button>
                    </a-tooltip>
                    <a-divider type="vertical"/>
                    <a-popconfirm title="确认删除?" ok-text="确认" cancel-text="我再想想"
                                  @confirm="handleDeleteRecord(record.id)">
                        <a-button>删除</a-button>
                    </a-popconfirm>
                </span>
            </template>
        </a-table>
        <a-modal
            :title="isCreate ? '新建' : '编辑'"
            v-model:visible="createOrUpdateDialogVisible"
            :confirm-loading="createOrUpdateConfirmLoading"
            @ok="handleSubmitRecord">
            <a-form ref="createOrUpdateForm" :model="editRecord" :label-col="{span:4}" :wrapper-col="{ span: 14 }">
                <a-form-item label="文章链接" :rules="formItemEmptyRule">
                    <a-input v-model:value="editRecord.webUrl"/>
                </a-form-item>
                <a-form-item label="文章标题" :rules="formItemEmptyRule">
                    <a-input v-model:value="editRecord.webTitle"/>
                </a-form-item>
                <a-form-item label="产品剂形" :rules="formItemEmptyRule">
                    <a-input v-model:value="editRecord.productType"/>
                </a-form-item>
                <a-form-item label="产品名称" :rules="formItemEmptyRule">
                    <a-input v-model:value="editRecord.productName"/>
                </a-form-item>
            </a-form>
        </a-modal>
    </div>
</template>

<script>

import {pageFindProductWeb, createProductWeb, updateProductWeb, deleteProductWeb} from "@/api"
import {downloadBase64Png} from "@/utils";
import {message} from 'ant-design-vue';
import VueQrcode from 'vue3-qrcode'

const columns = [
    {
        title: '文章标题',
        dataIndex: 'webTitle',
        key: 'webTitle',
    },
    {
        title: '剂型',
        key: 'productType',
        dataIndex: 'productType',
    },
    {
        title: '产品名称',
        key: 'productName',
        dataIndex: 'productName',
    },
    {
        title: '文章URL',
        dataIndex: 'webUrl',
        key: 'webUrl',
    },
    {
        title: '操作',
        key: 'action',
        slots: {customRender: 'action'},
    },
];

const formItemEmptyRule = {required: true, message: 'Please input Activity name', trigger: 'blur'};

export default {
    name: 'ProductManage',
    props: {
        msg: String
    },
    components: {
        VueQrcode,
    },
    data() {
        return {
            formItemEmptyRule,
            columns,
            productList: [],
            pagination: {},
            loading: false,
            isCreate: false,
            editRecord: {},
            createOrUpdateDialogVisible: false,
            createOrUpdateConfirmLoading: false
        }
    },
    methods: {
        handleDownloadQrcode(record) {
            const targetNode = this.$refs["qrcode_" + record.id];
            if (targetNode) {
                const childNodes = targetNode.childNodes;
                if (childNodes && childNodes.length > 0) {
                    const imageNode = childNodes[0];
                    downloadBase64Png(imageNode.getAttribute('src'), `qrcode_${record.id}_${record.productName}_${record.webTitle}`);
                }
            }
        },
        showCreateOrUpdateDialog(event, record) {
            if (record) {
                this.isCreate = false;
                this.editRecord = Object.assign({}, record);
            } else {
                this.editRecord = {};
                this.isCreate = true;
            }
            this.createOrUpdateDialogVisible = true;
        },
        handleDeleteRecord(id) {
            deleteProductWeb(id).then(resp => {
                message.success("删除成功！");
                this.reloadPage();
            })
        },
        handleSubmitRecord() {
            this.$refs.createOrUpdateForm.validate().then(() => {
                if (!this.isCreate && !this.editRecord.id && this.editRecord.id.trim().length === 0) {
                    message.error("请检查参数是否填写完整！");
                } else {
                    this.createOrUpdateConfirmLoading = true;
                    if (this.isCreate) {
                        createProductWeb(
                            this.editRecord.webUrl,
                            this.editRecord.webTitle,
                            this.editRecord.productName,
                            this.editRecord.productType).then(resp => {
                            message.success("创建成功!");
                            this.reloadPage();
                            this.createOrUpdateConfirmLoading = false;
                            this.createOrUpdateDialogVisible = false;
                        })
                    } else {
                        updateProductWeb(
                            this.editRecord.id,
                            this.editRecord.webUrl,
                            this.editRecord.webTitle,
                            this.editRecord.productName,
                            this.editRecord.productType).then(resp => {
                            message.success("更新成功!");
                            this.reloadPage();
                            this.createOrUpdateConfirmLoading = false;
                            this.createOrUpdateDialogVisible = false;
                        })
                    }
                }
            }).catch(error => {
                message.error("请检查参数是否填写完整！")
            });
        },
        reloadPage() {
            this.pageFindProduct(this.pagination.current - 1, this.pagination.pageSize);
        },
        handleTableChange(pagination) {
            const pager = {...this.pagination};
            pager.current = pagination.current;
            this.pagination = pager;
            this.pageFindProduct(pagination.current - 1, pagination.pageSize);
        },
        pageFindProduct(current, pageSize) {
            this.loading = true;
            pageFindProductWeb(current, pageSize).then(resp => {
                const pagination = {...this.pagination};
                pagination.total = resp.total;
                pagination.current = current + 1;
                pagination.pageSize = pageSize;
                this.pagination = pagination;

                this.productList = [];
                resp.data.forEach(item => {
                    item.key = item.id;
                    this.productList.push(item);
                });
            }).finally(() => {
                this.loading = false;
            })
        }
    },

    created() {
        this.pageFindProduct(0, 10);
    }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
    margin: 40px 0 0;
}

ul {
    list-style-type: none;
    padding: 0;
}

li {
    display: inline-block;
    margin: 0 10px;
}

a {
    color: #42b983;
}
</style>
