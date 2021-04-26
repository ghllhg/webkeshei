// $('button').on('click',function() {
//     console.log('开始了');
//     $.ajax({
//         type: 'post',
//         url: 'http://ql.laenix.site/api/register',
//         data:{
//             'name':'wangenze',
//             'password':123456
//         },
//         datatype: JSON,
//         success: function(data) {
//             console.log(data);
//             console.log(data.msg);
//         },
//         error: function(err){
//             console.log(err);
//         }
//     })
//     console.log('结束了');
// })
// // $('.button').click(function(){
// //     console.log(111);
// // })
$(".btn").on("click",function(){
    var inputPhone = $("#inputPhone").val();
    var inputUser = $("#inputUser").val();
    var inputPassword = $("#inputPassword").val();
    var inputMail = $("#inputMail").val();
    console.log("年龄"+inputPhone);
    console.log("用户名"+inputUser);
    console.log("密码"+inputPassword);
    console.log("邮箱"+inputMail);
    $.ajax({
        type:'post',
        url:'http://localhost:8080/shop/regist',
        data:{
            "username":inputUser,
            "password":inputPassword,
            "phone":inputPhone,
            "email":inputMail
        },
        success:function(data){
            alert(data);
        },
        dataType:'json'

    });
})