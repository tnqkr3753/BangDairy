


	$("#ov_items").children().each( function(){
		$(this).bind("click", function(){
			$("#ov_items").children().each( function() {
				$(this).attr("src", $(this).attr("_src") );
			});
			$(this).attr("src", $(this).attr("ov_src") );
			$("div.distribution").css("display", "none");
			$("div[title="+$(this).attr("alt")+"]").css("display", "block");
			$("#ov_href").attr("href", $(this).attr("href"));
		})
		.css("cursor", "pointer");
	});
	
	 $("#makebtn").click(function() {
	var dynamicTag = '<input type="text" name="indieActor"  class="type01 " style="width:60px;" msg="배우를">';
	$("#actorbutton").append(dynamicTag);
	
	
});

	 $("#makeky").click(function() {
	var dynamic =  "<input type='text' name='indieKeyword' value='123'class='type01' style='width:60px'>";
	$("#actorbu").append(dynamic);
	
	
});
	 
	
	$($("#ov_items").children().get(0)).attr("src", $($("#ov_items").children().get(0)).attr("ov_src") );


	$("#ov_items2").bind("click", function(){
		$("#ov_items").find("img").eq(1).trigger("click");
	});


function fn_Choice(){
	var str = "";

	str =	"<tr>";
	str +=		"<td><input type='text' name='music_title[]' id='music_title' class='type02' style='width:100%;' msg='곡명을' /> </td>";
	str +=		"<td><input type='text' name='music_writer[]' id='music_writer' class='type02' style='width:100%;' msg='작곡자/작사자/편곡자를' /> </td>";
	str +=		"<td><input type='text' name='music_player[]' id='music_player' class='type02' style='width:100%;' msg=연주자를'/> </td>";
	str +=		"<td><input type='text' name='music_album_title[]' id='music_album_title' class='type02' style='width:100%;' msg='음반제목/음반사를'/> </td>";
	str +=		"<td><input type='text' name='music_time[]' id='music_time' class='type02' style='width:100%;' msg='사용시간을'/> </td>";
	str +=		"<td>";
	str +=			"<select title='저작원'  style='width:100%;' name='music_copyright' id='music_copyright'>";
	str +=			"<option value='예' selected>유</option>";
	str +=			"<option value='아니오' >무</option>";
	str +=			"</select>";
	str +=		"</td>";
	str +=		"<td class='c'> <img src='resources/images/xxxx.png' alt='삭제' class='btn_remove' style='cursor:pointer'></td>";
	str +=	"</tr>";

	if($("#music_tbody").find("#empty_tr").length > 0){				
		$("#music_tbody").html(str);
	}else{
		$("#music_tbody").prepend(str);
	}

	set_btn_remove();
}//fn_Choice() ---------

function set_btn_remove(){

	$(".btn_remove").click(function (){
//		console.log($(this).parent().parent().length)
		$(this).parent().parent().remove();
	});
}//set_btn_remove() ---------------


function remove_ajax(_this){
	var $this = $(_this);
//	console.log($this.html());
	$this.parent().parent().remove();
}// remove_ajax() -----------------


function fn_submit(){

	
	if(checkForm("frm")){
	
		$("#frm").submit();
	}
}
	



function indie_list_submit(){
	
		$("#frm1212").submit();
	}

		

	

function onlyNumber(obj) { 
	e = window.event;
	if ((e.keyCode >= 48 && e.keyCode <= 57) || (e.keyCode >= 96 && e.keyCode <= 105) || e.keyCode == 8 || e.keyCode == 46 || e.keyCode == 37 || e.keyCode == 39 || e.keyCode == 35 || e.keyCode == 36 || e.keyCode == 9) {
		if (e.keyCode == 48 || e.keyCode == 96) {
			if (obj.value == "" || obj.value == "0") {
				e.returnValue = false;
			} else {
				return;
			}
		} else {
			return;
		}
	} else { 
		alert("숫자만 입력 가능 합니다.");
		obj.value="";
		e.returnValue = false;
	}
}
