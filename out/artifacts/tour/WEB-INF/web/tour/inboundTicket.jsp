<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>景点门票</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta content="Metronic Shop UI description" name="description">
  <meta content="Metronic Shop UI keywords" name="keywords">
  <meta content="keenthemes" name="author">
  <meta property="og:site_name" content="-CUSTOMER VALUE-">
  <meta property="og:title" content="-CUSTOMER VALUE-">
  <meta property="og:description" content="-CUSTOMER VALUE-">
  <meta property="og:type" content="website">
  <meta property="og:image" content="-CUSTOMER VALUE-"><!-- link to image for socio -->
  <meta property="og:url" content="-CUSTOMER VALUE-">
  <link rel="shortcut icon" href="favicon.ico">
  <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700|PT+Sans+Narrow|Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all" rel="stylesheet" type="text/css">
  <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all" rel="stylesheet" type="text/css"><!--- fonts for slider on the index page -->  
  <link href="resource/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="resource/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="resource/assets/global/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet">
  <link href="resource/assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.css" rel="stylesheet">
  <link href="resource/assets/global/plugins/slider-layer-slider/css/layerslider.css" rel="stylesheet">
  <link href="resource/assets/global/css/components.css" rel="stylesheet">
  <link href="resource/assets/frontend/layout/css/style.css" rel="stylesheet">
  <link href="resource/assets/frontend/pages/css/style-shop.css" rel="stylesheet" type="text/css">
  <link href="resource/assets/frontend/pages/css/style-layer-slider.css" rel="stylesheet">
  <link href="resource/assets/frontend/layout/css/style-responsive.css" rel="stylesheet">
  <link href="resource/assets/frontend/layout/css/themes/red.css" rel="stylesheet" id="style-color">
  <link href="resource/assets/frontend/layout/css/custom.css" rel="stylesheet">
  <link rel="shortcut icon" href="favicon.ico"/>
<link rel="stylesheet" href="resource/artDialog/css/ui-dialog.css">
<script type="text/javascript" src="resource/js/jquery.js"></script>
<script src="resource/artDialog/dist/dialog-plus.js"></script>
<script type="text/javascript">
function toSub(){
	var member_id = ${sessionScope.session_member.member_id};
	if(member_id.length==0){
		alert("请先登录再进行购买");
		return false;
	}
	$("#myForm").submit();
}
function toSub1(){
	var member_id = ${sessionScope.session_member.member_id};
	if(member_id.length==0){
		alert("请先登录再进行购买");
		return false;
	}
	$("#myForm1").submit();
}
function toSub2(){
	var member_id = ${sessionScope.session_member.member_id};
	if(member_id.length==0){
		alert("请先登录再进行购买");
		return false;
	}
	$("#myForm2").submit();
}
function toSub3(){
	var member_id = ${sessionScope.session_member.member_id};
	if(member_id.length==0){
		alert("请先登录再进行购买");
		return false;
	}
	$("#myForm3").submit();
}
function toSub4(){
	var member_id = ${sessionScope.session_member.member_id};
	if(member_id.length==0){
		alert("请先登录再进行购买");
		return false;
	}
	$("#myForm4").submit();
}
function toSub5(){
	var member_id = ${sessionScope.session_member.member_id};
	if(member_id.length==0){
		alert("请先登录再进行购买");
		return false;
	}
	$("#myForm5").submit();
}
function toSub6(){
	var member_id = ${sessionScope.session_member.member_id};
	if(member_id.length==0){
		alert("请先登录再进行购买");
		return false;
	}
	$("#myForm6").submit();
}
function toSub7(){
	var member_id = ${sessionScope.session_member.member_id};
	if(member_id.length==0){
		alert("请先登录再进行购买");
		return false;
	}
	$("#myForm7").submit();
}
function toSub8(){
	var member_id = ${sessionScope.session_member.member_id};
	if(member_id.length==0){
		alert("请先登录再进行购买");
		return false;
	}
	$("#myForm8").submit();
}
function toSub9(){
	var member_id = ${sessionScope.session_member.member_id};
	if(member_id.length==0){
		alert("请先登录再进行购买");
		return false;
	}
	$("#myForm9").submit();
}
function toSub10(){
	var member_id = ${sessionScope.session_member.member_id};
	if(member_id.length==0){
		alert("请先登录再进行购买");
		return false;
	}
	$("#myForm10").submit();
}
function toSub11(){
	var member_id = ${sessionScope.session_member.member_id};
	if(member_id.length==0){
		alert("请先登录再进行购买");
		return false;
	}
	$("#myForm11").submit();
}
</script>
</head>
<body class="ecommerce">
    <div class="color-panel hidden-sm">
      <div class="color-mode-icons icon-color"></div>
      <div class="color-mode-icons icon-color-close"></div>
      <div class="color-mode">
        <p>主题颜色</p>
        <ul class="inline">
          <li class="color-red current color-default" data-style="red"></li>
          <li class="color-blue" data-style="blue"></li>
          <li class="color-green" data-style="green"></li>
          <li class="color-orange" data-style="orange"></li>
          <li class="color-gray" data-style="gray"></li>
          <li class="color-turquoise" data-style="turquoise"></li>
        </ul>
      </div>
    </div>
    <div class="pre-header">
        <div class="container">
           <div class="row">
                <div class="col-md-6 col-sm-6 additional-shop-info">
                    <ul class="list-unstyled list-inline">
                        <li><i class="fa fa-phone"></i><span>+88888888</span></li>
                        <li><i class="fa fa-envelope-o"></i><span>gaosheng@qq.com</span></li>
                    </ul>
                </div>
                <div class="col-md-6 col-sm-6 additional-nav">
                    <ul class="list-unstyled list-inline pull-right">
                        <li><a href="WebLoginServlet.html">会员登录</a></li>
                        <li><a href="WebRegisterServlet.html">会员注册</a></li>
                    </ul>
                </div>
            </div>
        </div>        
    </div>
     <div class="header">
      <div class="container">
        <a href="javascript:void(0);" class="mobi-toggler"><i class="fa fa-bars"></i></a>
        <div class="header-navigation">
          <ul>
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="#">
               		 主页
              </a>
              <ul class="dropdown-menu">
                <li><a href="WebIndexServlet.html">回到主页</a></li>
              </ul>
            </li>
            <li class="dropdown dropdown-megamenu">
              <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="#">
               	热门景点推荐
              </a>
              <ul class="dropdown-menu">
                <li><a href="InboundHotTourism.html">周边热门景点</a></li>
              </ul>
            </li>
            <li class="dropdown dropdown-megamenu">
              <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="#">
               	景点门票
              </a>
              <ul class="dropdown-menu">
                <li><a href="InboundTouristTicket.html">周边景点门票</a></li>
              </ul>
            </li>
          </ul>
        </div>
        
        
        
        
      </div>
    </div>


    <div class="main">
      <div class="container">
        <div class="row margin-bottom-40 ">
        
        
          <div class="col-md-9 col-sm-8">
            <h2>景点门票</h2>
            <div class="owl-carousel owl-carousel3">
            
            
            
              <form action="InboundTicketBought.html" method="post" id="myForm">
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${inboundTicket[0].inboundTicket_url }" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${inboundTicket[0].inboundTicket_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <div class="pi-price">${inboundTicket[0].inboundTicket_price }元</div><br>
                  <center><p>${inboundTicket[0].inboundTicket_desc}</p></center>
                  <div class="sticker sticker-new"></div>
                  <input type="hidden" name="inboundTicket_url" id="inboundTicket_url" value="${inboundTicket[0].inboundTicket_url }">
                  <input type="hidden" name="inboundTicket_price" id="inboundTicket_price" value="${inboundTicket[0].inboundTicket_price }">
                  <input type="hidden" name="inboundTicket_desc" id="inboundTicket_desc" value="${inboundTicket[0].inboundTicket_desc}">
                  <input type="button" value="购买" class="btn btn-circle " onclick="toSub()">
                </div>
              </div>
              </form>
              
              
              <form action="InboundTicketBought.html" method="post" id="myForm1">
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${inboundTicket[1].inboundTicket_url }" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${inboundTicket[1].inboundTicket_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <div class="pi-price">${inboundTicket[1].inboundTicket_price }元</div><br>
                   <center><p>${inboundTicket[1].inboundTicket_desc}</p></center>
					<input type="hidden" name="inboundTicket_url" id="inboundTicket_url" value="${inboundTicket[1].inboundTicket_url }">
                  <input type="hidden" name="inboundTicket_price" id="inboundTicket_price" value="${inboundTicket[1].inboundTicket_price }">
                  <input type="hidden" name="inboundTicket_desc" id="inboundTicket_desc" value="${inboundTicket[1].inboundTicket_desc}">
                  <input type="button" value="购买" class="btn btn-circle " onclick="toSub1()">
                </div>
              </div>
              </form>
              
              <form action="InboundTicketBought.html" method="post" id="myForm2">
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${inboundTicket[2].inboundTicket_url }" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${inboundTicket[2].inboundTicket_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <div class="pi-price">${inboundTicket[2].inboundTicket_price }元</div><br>
                   <center><p>${inboundTicket[2].inboundTicket_desc}</p></center>
					<input type="hidden" name="inboundTicket_url" id="inboundTicket_url" value="${inboundTicket[2].inboundTicket_url }">
                  <input type="hidden" name="inboundTicket_price" id="inboundTicket_price" value="${inboundTicket[2].inboundTicket_price }">
                  <input type="hidden" name="inboundTicket_desc" id="inboundTicket_desc" value="${inboundTicket[2].inboundTicket_desc}">
                  <input type="button" value="购买" class="btn btn-circle " onclick="toSub2()">
                </div>
              </div>
              </form>
              
              <form action="InboundTicketBought.html" method="post" id="myForm3">
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${inboundTicket[3].inboundTicket_url }" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${inboundTicket[3].inboundTicket_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <div class="pi-price">${inboundTicket[3].inboundTicket_price }元</div><br>
                   <center><p>${inboundTicket[3].inboundTicket_desc}</p></center>
					<input type="hidden" name="inboundTicket_url" id="inboundTicket_url" value="${inboundTicket[3].inboundTicket_url }">
                  <input type="hidden" name="inboundTicket_price" id="inboundTicket_price" value="${inboundTicket[3].inboundTicket_price }">
                  <input type="hidden" name="inboundTicket_desc" id="inboundTicket_desc" value="${inboundTicket[3].inboundTicket_desc}">
                  <input type="button" value="购买" class="btn btn-circle " onclick="toSub3()">
                  <div class="sticker sticker-sale"></div>
                </div>
              </div>
              </form>
              
              
              <form action="InboundTicketBought.html" method="post" id="myForm4">
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${inboundTicket[4].inboundTicket_url }" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${inboundTicket[4].inboundTicket_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <div class="pi-price">${inboundTicket[4].inboundTicket_price }元</div><br>
                   <center><p>${inboundTicket[4].inboundTicket_desc}</p></center>
					<input type="hidden" name="inboundTicket_url" id="inboundTicket_url" value="${inboundTicket[4].inboundTicket_url }">
                  <input type="hidden" name="inboundTicket_price" id="inboundTicket_price" value="${inboundTicket[4].inboundTicket_price }">
                  <input type="hidden" name="inboundTicket_desc" id="inboundTicket_desc" value="${inboundTicket[4].inboundTicket_desc}">
                  <input type="button" value="购买" class="btn btn-circle " onclick="toSub4()">
                </div>
              </div>
              </form>
              
              <form action="InboundTicketBought.html" method="post" id="myForm5">
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${inboundTicket[5].inboundTicket_url }" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${inboundTicket[5].inboundTicket_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <div class="pi-price">${inboundTicket[5].inboundTicket_price }元</div><br>
                   <center><p>${inboundTicket[5].inboundTicket_desc}</p></center>
					<input type="hidden" name="inboundTicket_url" id="inboundTicket_url" value="${inboundTicket[5].inboundTicket_url }">
                  <input type="hidden" name="inboundTicket_price" id="inboundTicket_price" value="${inboundTicket[5].inboundTicket_price }">
                  <input type="hidden" name="inboundTicket_desc" id="inboundTicket_desc" value="${inboundTicket[5].inboundTicket_desc}">
                  <input type="button" value="购买" class="btn btn-circle " onclick="toSub5()">
                </div>
              </div>
              </form>
            </div>
          </div>
        </div>


		
        <div class="row margin-bottom-35 ">
          <div class="col-md-6 two-items-bottom-items">
            <h2>景点门票</h2>
            <div class="owl-carousel owl-carousel2">
            
            <form action="InboundTicketBought.html" method="post" id="myForm6">
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${inboundTicket[6].inboundTicket_url }" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${inboundTicket[6].inboundTicket_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <div class="pi-price">${inboundTicket[6].inboundTicket_price }元</div><br>
                   <center><p>${inboundTicket[6].inboundTicket_desc}</p></center>
					<input type="hidden" name="inboundTicket_url" id="inboundTicket_url" value="${inboundTicket[6].inboundTicket_url }">
                  <input type="hidden" name="inboundTicket_price" id="inboundTicket_price" value="${inboundTicket[6].inboundTicket_price }">
                  <input type="hidden" name="inboundTicket_desc" id="inboundTicket_desc" value="${inboundTicket[6].inboundTicket_desc}">
                  <input type="button" value="购买" class="btn btn-circle " onclick="toSub6()">
                </div>
              </div>
              </form>
              
              <form action="InboundTicketBought.html" method="post" id="myForm7">
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${inboundTicket[7].inboundTicket_url }" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${inboundTicket[7].inboundTicket_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <div class="pi-price">${inboundTicket[7].inboundTicket_price }元</div><br>
                   <center><p>${inboundTicket[7].inboundTicket_desc}</p></center>
					<input type="hidden" name="inboundTicket_url" id="inboundTicket_url" value="${inboundTicket[7].inboundTicket_url }">
                  <input type="hidden" name="inboundTicket_price" id="inboundTicket_price" value="${inboundTicket[7].inboundTicket_price }">
                  <input type="hidden" name="inboundTicket_desc" id="inboundTicket_desc" value="${inboundTicket[7].inboundTicket_desc}">
                  <input type="button" value="购买" class="btn btn-circle " onclick="toSub7()">
                </div>
              </div>
              </form>
              
              <form action="InboundTicketBought.html" method="post" id="myForm8">
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${inboundTicket[8].inboundTicket_url }" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${inboundTicket[8].inboundTicket_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <div class="pi-price">${inboundTicket[8].inboundTicket_price }元</div><br>
                   <center><p>${inboundTicket[8].inboundTicket_desc}</p></center>
					<input type="hidden" name="inboundTicket_url" id="inboundTicket_url" value="${inboundTicket[8].inboundTicket_url }">
                  <input type="hidden" name="inboundTicket_price" id="inboundTicket_price" value="${inboundTicket[8].inboundTicket_price }">
                  <input type="hidden" name="inboundTicket_desc" id="inboundTicket_desc" value="${inboundTicket[8].inboundTicket_desc}">
                  <input type="button" value="购买" class="btn btn-circle " onclick="toSub8()">
                </div>
              </div>
              </form>
              
              
              <form action="InboundTicketBought.html" method="post" id="myForm9">
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${inboundTicket[9].inboundTicket_url }" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${inboundTicket[9].inboundTicket_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <div class="pi-price">${inboundTicket[9].inboundTicket_price }元</div><br>
                   <center><p>${inboundTicket[9].inboundTicket_desc}</p></center>
					<input type="hidden" name="inboundTicket_url" id="inboundTicket_url" value="${inboundTicket[9].inboundTicket_url }">
                  <input type="hidden" name="inboundTicket_price" id="inboundTicket_price" value="${inboundTicket[9].inboundTicket_price }">
                  <input type="hidden" name="inboundTicket_desc" id="inboundTicket_desc" value="${inboundTicket[9].inboundTicket_desc}">
                  <input type="button" value="购买" class="btn btn-circle " onclick="toSub9()">
                </div>
              </div>
              </form>
              
              <form action="InboundTicketBought.html" method="post" id="myForm10">
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${inboundTicket[10].inboundTicket_url }" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${inboundTicket[10].inboundTicket_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <div class="pi-price">${inboundTicket[10].inboundTicket_price }元</div><br>
                   <center><p>${inboundTicket[10].inboundTicket_desc}</p></center>
					<input type="hidden" name="inboundTicket_url" id="inboundTicket_url" value="${inboundTicket[10].inboundTicket_url }">
                  <input type="hidden" name="inboundTicket_price" id="inboundTicket_price" value="${inboundTicket[10].inboundTicket_price }">
                  <input type="hidden" name="inboundTicket_desc" id="inboundTicket_desc" value="${inboundTicket[10].inboundTicket_desc}">
                  <input type="button" value="购买" class="btn btn-circle " onclick="toSub10()">
                </div>
              </div>
              </form>
              
              <form action="InboundTicketBought.html" method="post" id="myForm11">
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${inboundTicket[11].inboundTicket_url }" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${inboundTicket[11].inboundTicket_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <div class="pi-price">${inboundTicket[11].inboundTicket_price }元</div><br>
                   <center><p>${inboundTicket[11].inboundTicket_desc}</p></center>
					<input type="hidden" name="inboundTicket_url" id="inboundTicket_url" value="${inboundTicket[11].inboundTicket_url }">
                  <input type="hidden" name="inboundTicket_price" id="inboundTicket_price" value="${inboundTicket[11].inboundTicket_price }">
                  <input type="hidden" name="inboundTicket_desc" id="inboundTicket_desc" value="${inboundTicket[11].inboundTicket_desc}">
                  <input type="button" value="购买" class="btn btn-circle " onclick="toSub11()">
                </div>
              </div>
              </form>
            </div>
          </div>
          <div class="col-md-6 shop-index-carousel">
            <div class="content-slider">
              <div id="myCarousel" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                  <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                  <li data-target="#myCarousel" data-slide-to="1"></li>
                  <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                  <div class="item active">
                    <img src="${inboundTicket[12].inboundTicket_url }" class="img-responsive" alt="Berry Lace Dress">
                  </div>
                  <div class="item">
                    <img src="${inboundTicket[13].inboundTicket_url }" class="img-responsive" alt="Berry Lace Dress">
                  </div>
                  <div class="item">
                    <img src="${inboundTicket[14].inboundTicket_url }" class="img-responsive" alt="Berry Lace Dress">
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>        
      </div>
    </div>


    <div class="steps-block steps-block-red">
      <div class="container">
        <div class="row">
          <div class="col-md-4 steps-block-col">
            <i class="fa fa-truck"></i>
            <div>
              <h2>爱情</h2>
              <em>与爱人享受浪漫的爱情之旅，品味薰衣草的芬芳，享受爱情的甜蜜。</em>
            </div>
            <span>&nbsp;</span>
          </div>
          <div class="col-md-4 steps-block-col">
            <i class="fa fa-gift"></i>
            <div>
              <h2>亲情</h2>
              <em>与家人一起享受温馨的亲情之旅，品味郁金香的美妙，享受亲情的美好。</em>
            </div>
            <span>&nbsp;</span>
          </div>
          <div class="col-md-4 steps-block-col">
            <i class="fa fa-phone"></i>
            <div>
              <h2>友情</h2>
              <em>与朋友一起享受愉悦的基情之旅，品味百合的甜美，享受友情的纯真。</em>
            </div>
          </div>
        </div>
      </div>
    </div>

      <div class="pre-footer">
      <div class="container">
        <div class="row">
          <div class="col-md-4 col-sm-6 pre-footer-col">
            <h2>暮春，三月</h2>
            <p>阳光从树枝的空隙里倾泻下来，反射出太阳的剪影。枝头的花朵，羞答答的露出个肩头。抱着本书，坐在树荫下，凝望着广场上奔跑的人群，开始自己的遨游。</p>
            <div class="photo-stream">
              <h2>旅游纪念册</h2>
              <ul class="list-unstyled">
                <li><a><img alt="" src="resource/assets/frontend/pages/img/me/people1s.jpg"></a></li>
                <li><a><img alt="" src="resource/assets/frontend/pages/img/me/people2s.jpg"></a></li>
                <li><a><img alt="" src="resource/assets/frontend/pages/img/me/people3s.jpg"></a></li>
                <li><a><img alt="" src="resource/assets/frontend/pages/img/me/spot1.jpg"></a></li>
                <li><a><img alt="" src="resource/assets/frontend/pages/img/me/spot2 (2).jpg"></a></li>
                <li><a><img alt="" src="resource/assets/frontend/pages/img/me/spot2 (2).jpg"></a></li>
                <li><a><img alt="" src="resource/assets/frontend/pages/img/me/spot1.jpg"></a></li>
                <li><a><img alt="" src="resource/assets/frontend/pages/img/me/people3s.jpg"></a></li>
                <li><a><img alt="" src="resource/assets/frontend/pages/img/me/people2s.jpg"></a></li>
                <li><a><img alt="" src="resource/assets/frontend/pages/img/me/people1s.jpg"></a></li>
              </ul>                    
            </div>
          </div>
          <div class="col-md-4 col-sm-6 pre-footer-col">
            <h2>联系我们</h2>
            <address class="margin-bottom-40">
              	山东省，济南市<br>
              	二环南路七贤街道办事处，大学士花园<br>
              	电话:88888888<br>
            </address>
            <div class="pre-footer-subscribe-box pre-footer-subscribe-box-vertical">
            </div>
          </div>
          <div class="col-md-4 col-sm-6 pre-footer-col">
            <h2 class="margin-bottom-0">品味晨曦的美好</h2>
          </div>
        </div>
      </div>
    </div>

     <div class="footer">
      <div class="container">
        <div class="row">
          <div class="col-md-6 col-sm-6 padding-top-10">
          </div>
        </div>
      </div>
    </div>

    <script src="resource/assets/global/plugins/jquery-1.11.0.min.js" type="text/javascript"></script>
    <script src="resource/assets/global/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
    <script src="resource/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>      
    <script src="resource/assets/frontend/layout/scripts/back-to-top.js" type="text/javascript"></script>
    <script src="resource/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <script src="resource/assets/global/plugins/fancybox/source/jquery.fancybox.pack.js" type="text/javascript"></script><!-- pop up -->
    <script src="resource/assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.min.js" type="text/javascript"></script><!-- slider for products -->
    <script src='resource/assets/global/plugins/zoom/jquery.zoom.min.js' type="text/javascript"></script><!-- product zoom -->
    <script src="resource/assets/global/plugins/bootstrap-touchspin/bootstrap.touchspin.js" type="text/javascript"></script><!-- Quantity -->
    <script src="resource/assets/global/plugins/slider-layer-slider/js/greensock.js" type="text/javascript"></script><!-- External libraries: GreenSock -->
    <script src="resource/assets/global/plugins/slider-layer-slider/js/layerslider.transitions.js" type="text/javascript"></script><!-- LayerSlider script files -->
    <script src="resource/assets/global/plugins/slider-layer-slider/js/layerslider.kreaturamedia.jquery.js" type="text/javascript"></script><!-- LayerSlider script files -->
    <script src="resource/assets/frontend/pages/scripts/layerslider-init.js" type="text/javascript"></script>
    <script src="resource/assets/frontend/layout/scripts/layout.js" type="text/javascript"></script>
    <script type="text/javascript">
        jQuery(document).ready(function() {
            Layout.init();    
            Layout.initOWL();
            LayersliderInit.initLayerSlider();
            Layout.initImageZoom();
            Layout.initTouchspin();
            Layout.initTwitter();
        });
    </script>
</body>
</html>