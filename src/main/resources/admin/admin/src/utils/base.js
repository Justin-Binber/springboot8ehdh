const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot8ehdh/",
            name: "springboot8ehdh",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot8ehdh/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "KTV管理系统"
        } 
    }
}
export default base
