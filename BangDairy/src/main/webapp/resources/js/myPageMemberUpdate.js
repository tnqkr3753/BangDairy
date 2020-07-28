
$(document).ready(function(){
    function isAge(age) { 
        var number_age = Number(age); // 입력한 나이 int로 바꾸기
        if (number_age>=1 && number_age<=120){
            return true;
        }else{
            return false;
        }
        
    }
})