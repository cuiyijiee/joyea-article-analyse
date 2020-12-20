import {createWebHashHistory, createRouter} from "vue-router";

import ProductManage from "@/components/ProductManage";

const routes = [
    {
        path: "/manage",
        name: "ProductManage",
        component: ProductManage,
    },
];

const router = createRouter({
    history: createWebHashHistory(),
    routes,
});

export default router;