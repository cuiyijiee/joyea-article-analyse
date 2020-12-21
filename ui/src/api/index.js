import {service} from "@/api/request";

export function login(user, pwd) {
    return service.post('api/user/login', {
        user: user,
        pwd: pwd
    })
}

export function pageFindProductWeb(current, pageSize) {
    return service.get(`api/productWeb/find?current=${current}&pageSize=${pageSize}`)
}

export function createProductWeb(webUrl, webTitle, productName, productType) {
    return service.post('api/productWeb/create', {
        webUrl: webUrl,
        webTitle: webTitle,
        productName: productName,
        productType: productType,
    })
}

export function updateProductWeb(id, webUrl, webTitle, productName, productType) {
    return service.post('api/productWeb/update', {
        id: id,
        webUrl: webUrl,
        webTitle: webTitle,
        productName: productName,
        productType: productType,
    })
}

export function deleteProductWeb(id) {
    return service.delete(`api/productWeb/delete?id=${id}`)
}


export function pageFindReadRecord(current,pageSize){
    return service.get(`api/readRecord/find?current=${current}&pageSize=${pageSize}`)
}