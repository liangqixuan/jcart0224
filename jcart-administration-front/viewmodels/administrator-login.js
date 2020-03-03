var app = new Vue({
    el: '#app',
    data: {
        username: '',
        password: ''
    },
    methods:{
        handleLoginClick(){
            console.log('login click');
            this.loginAdministrator();
        },
        loginAdministrator(){
            axios.get('/administrator/login', {
                params: {
                  username: this.username,
                  password: this.password
                }
              })
              .then(function (response) {
                console.log(response);
                alert('登录成功')
              })
              .catch(function (error) {
                console.log(error);
              })
        }
    }
})