const path = require('path');

function resolve(dir) {
    return path.join(__dirname, dir);
}

module.exports = {
    lintOnSave: true,
    productionSourceMap: false,
    devServer: {
        proxy: 'http://127.0.0.1:8080',
    },
    publicPath:"/admin",
    chainWebpack: config => {
        config.resolve.alias
            .set('@', resolve('src'))
            .set('@assets', resolve('src/assets'))
    }
};