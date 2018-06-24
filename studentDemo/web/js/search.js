function search() {
	var sno = $('#sno').val();
	var sname = $('#name').val();
	console.log(sno);
	console.log(sname);
//	  低层实现 支持错误处理
	  $.ajax({
	    	url:"http://localhost:8080/studentdemo/StudentSearch",
	    	async:true,// false
	    	type:"POST",//GET
	    	//default text(文本传输) 服务器传回来的就是文本传输，json传回来的就是json对象
	    	dataType:"json",// xml
	    	// parameter
	    	data:{sno:sno, sname:sname},
	    	success:function(result){
	        console.log(JSON.stringify(result));
                $("#table1  tr:not(:first)").html("");
                for(var i=0,l=result.length;i<l;i++){
                	console.log(result[i]);
                    var newObj = $("<tr bgcolor='EEF2FD'><td width='8%'><div align='center'>"+(i + 1)+"</div></td><td width='8%'><div align='center'>"+result[i].stuNum+"</div></td><td width='8%'><div align='center'>"+result[i].stuName+"</div></td><td width='8%'><div align='center'>"+result[i].stuChinese+"</div></td><td width='8%'><div align='center'>"+result[i].stuMath+"</div></td><td width='8%'><div align='center'>"+result[i].stuEnglish+"</div></td><td width='8%'><div align='center'><a href="+"delete.jsp?sno="+result[i].stuNum+">delete</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="+"update.jsp?sno="+result[i].stuNum+"&sname="+result[i].stuName+"&chinese="+result[i].stuChinese+"&math="+result[i].stuMath+"&english="+result[i].stuEnglish+">update</a></div></td></tr>");
                	$('#table1').append(newObj);
                }

	    }});
}
$(function(){
	$("#sub").click(function(){
		console.log("click");
		search();
	  });
});