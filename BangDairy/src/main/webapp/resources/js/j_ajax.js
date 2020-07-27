$(document).ready(function(){
var a =0
var main="mainAjax"
var jsp=".jsp"
/*$('.movie_thema').click(function(){
	movieType = $(this).attr("value");
	*/
	$('#sa').click(function(){
	a=1
    $.ajax({
        type : "get", //전송방식을 지정한다 (POST,GET)
        url : main+a+jsp,//호출 URL을 설정한다. GET방식일경우 뒤에 파라티터를 붙여서 사용해도된다.
        dataType : "text",//호출한 페이지의 형식이다. xml,json,append,text등의 여러 방식을 사용할 수 있다.
        error : function(){
            alert('통신실패!!');
        },
        success : function(Parse_data){
        	
            $(".Parse_Area1").append(Parse_data); //div에 받아온 값을 넣는다.
          
        }
             })

    })
$('#sb').click(function(){
	a=2
    $.ajax({
        type : "get", //전송방식을 지정한다 (POST,GET)
        url : main+a+jsp,//호출 URL을 설정한다. GET방식일경우 뒤에 파라티터를 붙여서 사용해도된다.
        dataType : "text",//호출한 페이지의 형식이다. xml,json,append,text등의 여러 방식을 사용할 수 있다.
        error : function(){
            alert('통신실패!!');
        },
        success : function(Parse_data){
        	
        	  $(".Parse_Area2").append(Parse_data); //div에 받아온 값을 넣는다.
          
        }
             })

    })
    $('#sc').click(function(){
	a=3
    $.ajax({
        type : "get", //전송방식을 지정한다 (POST,GET)
        url : main+a+jsp,//호출 URL을 설정한다. GET방식일경우 뒤에 파라티터를 붙여서 사용해도된다.
        dataType : "text",//호출한 페이지의 형식이다. xml,json,append,text등의 여러 방식을 사용할 수 있다.
        error : function(){
            alert('통신실패!!');
        },
        success : function(Parse_data){
        	
            $(".Parse_Area3").append(Parse_data); //div에 받아온 값을 넣는다.
          
        }
             })

    })
    $('#sd').click(function(){
	a=4
    $.ajax({
        type : "get", //전송방식을 지정한다 (POST,GET)
        url : main+a+jsp,//호출 URL을 설정한다. GET방식일경우 뒤에 파라티터를 붙여서 사용해도된다.
        dataType : "text",//호출한 페이지의 형식이다. xml,json,append,text등의 여러 방식을 사용할 수 있다.
        error : function(){
            alert('통신실패!!');
        },
        success : function(Parse_data){
        	
            $(".Parse_Area4").append(Parse_data); //div에 받아온 값을 넣는다.
          
        }
             })

    })
    $('#se').click(function(){
	a=5
    $.ajax({
        type : "get", //전송방식을 지정한다 (POST,GET)
        url : main+a+jsp,//호출 URL을 설정한다. GET방식일경우 뒤에 파라티터를 붙여서 사용해도된다.
        dataType : "text",//호출한 페이지의 형식이다. xml,json,append,text등의 여러 방식을 사용할 수 있다.
        error : function(){
            alert('통신실패!!');
        },
        success : function(Parse_data){
        	
            $(".Parse_Area5").append(Parse_data); //div에 받아온 값을 넣는다.
          
        }
             })

    })
    $('#sf').click(function(){
	a=6
    $.ajax({
        type : "get", //전송방식을 지정한다 (POST,GET)
        url : main+a+jsp,//호출 URL을 설정한다. GET방식일경우 뒤에 파라티터를 붙여서 사용해도된다.
        dataType : "text",//호출한 페이지의 형식이다. xml,json,append,text등의 여러 방식을 사용할 수 있다.
        error : function(){
            alert('통신실패!!');
        },
        success : function(Parse_data){
        	
            $(".Parse_Area6").append(Parse_data); //div에 받아온 값을 넣는다.
          
        }
             })

    })
    $('#sg').click(function(){
	a=7
    $.ajax({
        type : "get", //전송방식을 지정한다 (POST,GET)
        url : main+a+jsp,//호출 URL을 설정한다. GET방식일경우 뒤에 파라티터를 붙여서 사용해도된다.
        dataType : "text",//호출한 페이지의 형식이다. xml,json,append,text등의 여러 방식을 사용할 수 있다.
        error : function(){
            alert('통신실패!!');
        },
        success : function(Parse_data){
        	
            $(".Parse_Area7").append(Parse_data); //div에 받아온 값을 넣는다.
          
        }
             })

    })
    $('#sh').click(function(){
	a=8
    $.ajax({
        type : "get", //전송방식을 지정한다 (POST,GET)
        url : main+a+jsp,//호출 URL을 설정한다. GET방식일경우 뒤에 파라티터를 붙여서 사용해도된다.
        dataType : "text",//호출한 페이지의 형식이다. xml,json,append,text등의 여러 방식을 사용할 수 있다.
        error : function(){
            alert('통신실패!!');
        },
        success : function(Parse_data){
        	
            $(".Parse_Area8").append(Parse_data); //div에 받아온 값을 넣는다.
          
        }
             })

    })
       $('#si').click(function(){
	a=9
    $.ajax({
        type : "get", //전송방식을 지정한다 (POST,GET)
        url : main+a+jsp,//호출 URL을 설정한다. GET방식일경우 뒤에 파라티터를 붙여서 사용해도된다.
        dataType : "text",//호출한 페이지의 형식이다. xml,json,append,text등의 여러 방식을 사용할 수 있다.
        error : function(){
            alert('통신실패!!');
        },
        success : function(Parse_data){
        	
            $(".Parse_Area9").append(Parse_data); //div에 받아온 값을 넣는다.
          
        }
             })

    })
    
    

    });