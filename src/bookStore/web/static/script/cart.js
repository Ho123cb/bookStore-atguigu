window.onload = function () {
    var vue = new Vue({
        el: "#bookList",
        data: {
            cart: {}
        },
        methods: {
            getCart: function () {
                axios({
                    method: "post",
                    url: "cart.do",
                    params: {
                        operate: 'cartInfo'
                    }
                }).then(function (value) {
                    vue.cart = value.data;
                }).catch(function (reason) {
                    console.error("获取购物车失败", reason);
                });
            },
            editCart: function (oop, id) {
                axios({
                    method: "post",
                    url: "cart.do",
                    params: {
                        operate: 'editCart',
                        oop: oop,
                        id: id
                    }
                }).then(function () {
                    vue.getCart();
                    // alert('successful!!!');
                }).catch(function (reason) {
                    console.error("修改购物车失败", reason);
                });
            }
        },
        mounted: function () {
            this.getCart();
        }
    });
};
