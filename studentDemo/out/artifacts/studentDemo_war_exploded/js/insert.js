function insert() {
    var sno = $('#sno').val();
    var sname = $('#sname').val();
    var chinese = $('#chinese').val();
    var math = $('#math').val();
    var english = $('#english').val();
    alert(sno);
    alert(sname);
    alert(chinese);
    alert(math);
    alert(english);
//	  低层实现 支持错误处理
    $.ajax({
        url:"http://localhost:8080/studentDemo/StudentIns",
        async:true,// false
        type:"POST",//GET
        //default text(文本传输) 服务器传回来的就是文本传输，json传回来的就是json对象
        dataType:"json",// xml
        // parameter
        data:{sno:sno, sname:sname, chinese:chinese, math:math, english:english},
        success:function(result){
            console.log(JSON.stringify(result));
            if (result.isSuccess == true)
                window.location.href = 'insertSuc.jsp?sno='+result.sno+'&sname='+sname+'&chinese='+chinese+'&math='+math+'&english='+english;
            else
                window.location.href = 'insert.html';
        }});
}
$(function(){
    $("#btn").click(function(){
        alert("click");
        insert();
    });
});