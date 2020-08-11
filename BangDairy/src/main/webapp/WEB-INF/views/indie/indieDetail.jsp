<%@page import="com.sun.org.glassfish.external.statistics.annotations.Reset"%>
<%@page import="com.kosmo.bangdairy.vo.IndieVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
 <html class="no-js" lang=""> 
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Logic - Free Html  Business Template</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
	
     <!--필요  --><link rel="stylesheet" href="resources/css/bootstrap.min.css">
 
    <link rel="stylesheet" href="resources/css/base.css">
    <link rel="stylesheet" href="resources/css/vendor.css">
    <link rel="stylesheet" href="resources/css/main.css">
	<link rel="stylesheet" href="resources/css/independent.css">
	<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">


        <!--For Plugins external css-->
        <link rel="stylesheet" href="resources/css/plugins.css" />

        <!--Theme custom css -->
        <link rel="stylesheet" href="resources/css/style.css">



        <script src="resources/js/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script> 

<script type="text/javascript" src="resources/js/Sign_in.js"></script>

    
    
    </head>
    <body data-spy="scroll" data-target=".navbar" data-offset="200" style=background-color="red">
	<%@ include file="../../../header_menu.jsp"%>
        <div class='preloader'>
            <div class='loaded'>&nbsp;</div>
        </div>
				<%	IndieVO result=(IndieVO)request.getAttribute("result"); %>
				
        <div class="culmn">
            <section id="features" class="features">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="main_features_area sections">
                                <div class="head_title">
                                                           <div class="head_title">   
                                    <h5 style="text-align: center; "><%=result.getIndieTitle() %></h5>
                                   
                                </div>
                                   
                                </div>
                               
                                    <div class="main_features_content">

                                        <div class="col-sm-6">

                                            
                                                <div class="single_ft_s_item">
                                                    <img src="resources/upload/userProfile/<%=result.getIndiePosterAddr() %>" alt="" />
                                                </div>
                                               
                                           
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="single_features_text">
                                                <h4 style=font-size:20px>줄거리<h4>
                                                      <p><%=result.getIndiePlot() %> </p>

                                             
                                            </div>
                                        </div>
                                    </div>
                                
                            </div>
                        </div>
                    </div>
                </div>
            </section>


            <section id="video" class="video text-center wow fadeIn"  data-wow-duration="2s" data-wow-dealy="1.5s">
               <!--  <div class="video_overlay"style="margin-left: 10%;margin-right: 10%;   width: 80%;">
                    <div class="container">
                        <div class="row">
                            <div class="main_video" >
                                <div class="col-sm-12">
                                    <div class="icon"> -->

                                     <iframe width="1280" height="720" src="<%=result.getIndieAddr().replace("watch?v=","embed/") %>" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                            
                                      <!--   <h3>WATCH OUR INTRO영화감상</h3> -->
                   
                                   <!--  </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div> -->
            </section>


           <!--  <section id="about" class="about"></section> -->
                <div class="container">
                    <div class="row">

                        <div class="main_about_area sections" style=padding-bottom:100px;>
                            <div class="col-sm-12">

                                <div class="main_about_content">
                                  

                                      
                                    </div>
                                    <div class="row">
                                        <div class="about_skill_area">
                                            <div class="col-sm-6">
                                                <div class="about_tabe">
                                                    <!-- Nav tabs -->
                                                       <ul>
                                                    <li><span style=font-size:20px>배우 :</span><%=result.getIndieActor() %></li>
                                                    <li><span style=font-size:20px>업데이트날자:</span><%=result.getIndieMakedate() %></li>
                                                    <li><span style=font-size:20px>장르:</span><%=result.getGenreId() %></li>
                                                </ul>

                                                <a href="" class="btn">버튼에 무슨기능 넣을까?</a>

                                                    <!-- Tab panes -->
                               
                                                </div>
                                            </div>
                                            
                                            <button class="btnPaging" value='${likeCount}'>"좋야요"${likeCount}</button>
                                            <button class="btnPaging" value='${hateCount}'>"싫어요"${hateCount}</button>
                                            
                                          <c:choose>
  											<c:when test="${userId ne null}">
                                            <span><input type="image" src="resources/images/Dislike.jpg" width="100px" id="bad" value="<%=result.getIndieId()%>" style="float: right;"></span> 
                                            
                                             <span><input type="image" src="resources/images/like.jpg" width="100px" id="good" value="<%=result.getIndieId()%>" style="float: right; "></span>
                                              </c:when>
                                              <c:otherwise>
                    <span>  <a href='javascript:login_need();'><img  src="resources/images/Dislike.jpg" width="100px" style="float: right"></a></span>
                                         
             <span>  <a href='javascript:login_need();'><img  src="resources/images/like.jpg" width="100px" style="float: right"></a></span>
                                                 
                                      
                                               </c:otherwise>
                                               </c:choose>
                                              
                                              
                                        <td></td>
                          <%--       	<%	IndieVO good=(IndieVO)request.getAttribute("good"); %>
                                	            	<%	IndieVO  result2=(IndieVO)request.getAttribute("result2"); %>
									<script type="text/javascript">
									$("#good").click(function(){									
									if(<%=good.getIndieId()%>=<%=result2.getIndieId()%>)and{
										},<%=good.getUserId()%>
										<%=good.getIndieLike()%>


										})	 --%>									
<!-- </script>	 -->
										                                        
                                        
                                            </div>
                                            
                                            
                                            
                                            
                                            <!-- 좋아요싫어요가 바형태로 나옴  -->
                                           <!--  <div class="col-sm-6">
                                                <div class="about_skill">
                                                    <div class="skillbar" data-percent="100%">
                                                        <div class="skillbar-title"><h3 class="blue">조회수</h3><span class="sm-text">100%</span></div>
                                                        <div class="skillbar-bar blue"></div>
                                                    </div>

                                                    <div class="skillbar" data-percent="10%">
                                                        <div class="skillbar-title"><h3 class="blue">좋아요</h3><span class="sm-text">90%</span></div>
                                                        <div class="skillbar-bar blue"></div>
                                                    </div>

                                                    <div class="skillbar" data-percent="69%">
                                                        <div class="skillbar-title"><h3 class="blue">싫어요</h3><span class="sm-text">69%</span></div>
                                                        <div class="skillbar-bar blue"></div>
                                                    </div>

                                                   
                                                </div>
                                            </div> -->
                                        </div>
                                    </div>

                                </div>
                            </div>

                        </div>
                    </div>
                </div>
        

        <!-- START SCROLL TO TOP  -->



        
 


	<!-- preloader
    ================================================== -->
	
       
       

        <script src="resources/js/jquery.magnific-popup.js"></script>
        <script src="resources/js/jquery.mixitup.min.js"></script>
    


        
<!--         <script src="http://maps.google.com/maps/api/js"></script> -->

<script type="text/javascript">
/*   $(window).resize(function(){resizeYoutube();});
  $(function(){resizeYoutube();});
  function resizeYoutube(){ $("iframe").each(function(){ if( /^https?:\/\/www.youtube.com\/embed\g.test($(this).attr("src")) ){ $(this).css("width","100%"); $(this).css("height",Math.ceil( parseInt($(this).css("width")) * 480 / 854 ) + "px");} }); }
 */</script>




    <!--     <script>

                                            function showmap() {
                                                var mapOptions = {
                                                    zoom: 8,
                                                    scrollwheel: false,
                                                    center: new google.maps.LatLng(-34.397, 150.644),
                                                    mapTypeId: google.maps.MapTypeId.ROADMAP
                                                };
                                                var map = new google.maps.Map(document.getElementById('map_canvas'), mapOptions);
                                            }
        </script> -->
       
   <!--체팅기능-->
<!--Start of Tawk.to Script-->
<script type="text/javascript">
var Tawk_API=Tawk_API||{}, Tawk_LoadStart=new Date();
(function(){
var s1=document.createElement("script"),s0=document.getElementsByTagName("script")[0];
s1.async=true;
s1.src='https://embed.tawk.to/5edd9bd44a7c6258179a1dcf/default';
s1.charset='UTF-8';
s1.setAttribute('crossorigin','*');
s0.parentNode.insertBefore(s1,s0);
})();
</script>
<!--End of Tawk.to Script-->

<!--End of Tawk.to Script-->

 <script src="resources/js/plugins2.js"></script> 
    <script src="resources/js/j_ajax.js"></script>
        <script src="resources/js/indieD.js"></script>
	<%@ include file="../../../footer.jsp"%>

 

    </body>
</html>
