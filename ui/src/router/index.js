import {createWebHashHistory, createRouter} from "vue-router";

import ProductManage from "@/components/ProductManage";
import VisitHistory from "@/components/VisitHistory";

const routes = [
    {
        path: "/manage",
        name: "ProductManage",
        component: ProductManage,
    },
    {
        path: "/",
        name: "VisitHistory",
        component: VisitHistory,
    },
];

const router = createRouter({
    history: createWebHashHistory(),
    routes,
});

export default router;