<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/23
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<script src="../js/jquery-1.12.0.min.js">

</script>
<script src="../js/jquery.json.js">

</script>
<script type="text/javascript">
    var array=[{userName: 'winzip'},{password: 'password'}];
    (function () {
//        $.ajax({
//            type: 'GET',
//            data: JSON.stringify({userName:"shit"}),
//            dataType: 'json',
//            url:"/user/fuck_you",
//            contentType: 'application/json;charset=UTF-8',
//            success: function (result) {
//                console.log(result.one)
//            }
//        });
        function test(){
            var saveDataAry=[];
            var data1={"name":"test"};
            var data2={"name":"张三"};
            saveDataAry.push(data1);
            saveDataAry.push(data2);
            $.ajax({
                type:"POST",
                url:"/user/student",
                dataType:"text",
                contentType:"application/json",
                data:jQuery.toJSON(data1),
                success:function(data){
                    console.log(data)
                },
                error:function (data) {
                    console.log(data)
                }
            });
        }
        test()
    })(window)
</script>
</body>
</html>
