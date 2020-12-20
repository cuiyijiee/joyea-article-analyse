import axios from 'axios'

// 创建axios实例
export const service = axios.create({
    //baseURL: process.env.BASE_API, // api 的 base_url
    //baseURL: process.env.NODE_ENV === 'production' ? 'http://sck.joyea.cn:8000/' : '/',
    baseURL: "/",
    timeout: 60 * 60 * 1000 // 请求超时时间
});

service.interceptors.response.use(
    response => {
        if (response.status === 200) {
            if (response.data.code === 2000) {
                return Promise.resolve(response.data.data);
            } else {
                return Promise.reject(response);
            }
        } else {
            return Promise.reject(response);
        }
    },
    error => {
        console.error("服务器请求失败: " + JSON.stringify(error));
        return Promise.reject(error.response);
    }
)