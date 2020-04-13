<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>汽车票购买</title>
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
  <link href="resource/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="resource/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="resource/assets/global/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet">
  <link href="resource/assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.css" rel="stylesheet">
  <link href="resource/assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css">
  <link href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" rel="stylesheet" type="text/css"><!-- for slider-range -->
  <link href="resource/assets/global/plugins/rateit/src/rateit.css" rel="stylesheet" type="text/css">
  <link href="resource/assets/global/css/components.css" rel="stylesheet">
  <link href="resource/assets/frontend/layout/css/style.css" rel="stylesheet">
  <link href="resource/assets/frontend/pages/css/style-shop.css" rel="stylesheet" type="text/css">
  <link href="resource/assets/frontend/layout/css/style-responsive.css" rel="stylesheet">
  <link href="resource/assets/frontend/layout/css/themes/red.css" rel="stylesheet" id="style-color">
  <link href="resource/assets/frontend/layout/css/custom.css" rel="stylesheet">
  <script type="text/javascript">
  	function toSub(){
  		var bill_number=$("#bill_number").val();
  		var bill_memberPhone=$("#bill_memberPhone").val();
  		var member_id = ${sessionScope.session_member.member_id};
		if(member_id.length==0){
			alert("请先登录再进行购买");
			return false;
		}
  		if(bill_number.length==0){
  			alert("请输入数量再进行购买");
  			return false;
  		}
  		if(bill_memberPhone.trim().length==0){
  			alert("请输入手机号再进行购买");
  			return false;
  		}
  		alert("购买成功");
  		$("#myForm").submit();
  	}
  </script>
</head>
<body class="ecommerce">
    <div class="color-panel hidden-sm">
      <div class="color-mode-icons icon-color"></div>
      <div class="color-mode-icons icon-color-close"></div>
      <div class="color-mode">
        <p>颜色主题</p>
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

       

        <div class="header-navigation">
          <ul>
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="#">
               	返回
              </a>
              <ul class="dropdown-menu">
                <li><a href="BusTicket.html">汽车票购买</a></li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </div>
    
    <div class="main">
      <div class="container">
        <ul class="breadcrumb">
            <li><a href="WebIndexServlet.html">主页</a></li>
            <li><a href="BusTicket.html">汽车票推荐</a></li>
            <li class="active">汽车票购买</li>
        </ul>
        
        <div class="row margin-bottom-40">
          <div class="col-md-9 col-sm-7">
            <div class="product-page">
            
            
            
            <form action="WebBillListServlet19.html" method="post" id="myForm">
              <div class="row">
                <div class="col-md-6 col-sm-6">
                  <div class="product-main-image">
                    <img src="${bus.bus_url }" alt="Cool green dress with red bell" class="img-responsive" data-BigImgsrc="${bus.bus_url }">
                  </div>
                </div>
                <div class="col-md-6 col-sm-6">
                  <h1>${bus.bus_point }</h1>
                  <div class="price-availability-block clearfix">
                    <div class="price">
                      <strong>${bus.bus_price }元</strong>
                    </div>
                    <div class="availability">
                      起点  <strong>${bus.bus_from }</strong><br>
                       终点  <strong>${bus.bus_to }</strong>
                    </div>
                  </div>
                    <div class="form-group">
                      <label class="col-lg-5 control-label">请输入您的手机号</label><br>
                      <div class="col-lg-8">
                        <input type="text" class="form-control" id="bill_memberPhone" name="bill_memberPhone" >
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-lg-5 control-label">请输入您的购买数量</label><br>
                      <div class="col-lg-8">
                        <input type="number" class="form-control" id="bill_number" name="bill_number" >
                      </div>
                    </div>
                  </div>
                  <input type="hidden" name="bill_thing" id="bill_thing" value="${bus.bus_point }">
                   <input type="hidden" name="bill_price" id="bill_price" value="${bus.bus_price }">
                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                   <input type="button" value="购买" class="btn btn-primary" onclick="toSub()">
                </div>
				</form>
				 起飞时间 ${bus.bus_time }
                <div class="sticker sticker-sale"></div>
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
              	邮箱: gaosheng@qq.com<br>
            </address>
            <div class="pre-footer-subscribe-box pre-footer-subscribe-box-vertical">
              <h2>四海兴唐</h2>
              <p>桃李满天下，四海兴中华。</p>
              <p>欢迎加入我们。</p>
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
            	四海兴唐 | 祥云27 | 高升
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
    <script src="resource/assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
    <script src="resource/assets/global/plugins/rateit/src/jquery.rateit.js" type="text/javascript"></script>
    <script src="resource/assets/frontend/layout/scripts/layout.js" type="text/javascript"></script>
    <script type="text/javascript">
        jQuery(document).ready(function() {
            Layout.init();    
            Layout.initOWL();
            Layout.initTwitter();
            Layout.initImageZoom();
            Layout.initTouchspin();
            Layout.initUniform();
        });
    </script>
</body>
</html>