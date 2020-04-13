<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>自助</title>
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
       
       
       
        <div class="header-navigation pull-right font-transform-inherit">
          <ul>
            <li class="dropdown active">
              <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="#">
                	主页 
              </a>
              <ul class="dropdown-menu">
                <li><a href="WebIndexServlet.html">回到主页</a></li>
              </ul>
            </li>
            <li class="dropdown dropdown-megamenu">
              <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="#">
              	 菜单
              </a>
              <ul class="dropdown-menu">
                <li>
                  <div class="header-navigation-content">
                    <div class="row">
                      <div class="col-md-4 header-navigation-col">
                        <h4>交通</h4>
                        <ul>
                          <li><a href="AirlineTicket.html">机票</a></li>
                          <li><a href="TrainTicket.html">火车票</a></li>
                          <li><a href="ShipTicket.html">轮船票</a></li>
                          <li><a href="BusTicket.html">汽车票</a></li>
                          <li><a href="fasterTicket.html">动车票</a></li>
                        </ul>
                      </div>
                      <div class="col-md-4 header-navigation-col">
                        <h4>住宿</h4>
                        <ul>
                          <li><a href="HolidayInn.html">假日酒店</a></li>
                          <li><a href="Apartment.html">公寓</a></li>
                          <li><a href="Villa.html">别墅</a></li>
                          <li><a href="Agricola.html">农家乐</a></li>
                          <li><a href="QuickHotel.html">快捷酒店</a></li>
                        </ul>
                      </div>
                      <div class="col-md-4 header-navigation-col">
                        <h4>美食</h4>
                        <ul>
                          <li><a href="Snack.html">小吃</a></li>
                          <li><a href="QuickMeal.html">快餐</a></li>
                          <li><a href="Buffet.html">自助</a></li>
                          <li><a href="ThemedRestaurant.html">主题</a></li>
                          <li><a href="WesternRestaurant.html">西式</a></li>
                        </ul>
                      </div>
                    </div>
                  </div>
                </li>
              </ul>
            </li>
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="#">
                	关于我们 
              </a>
              <ul class="dropdown-menu">
                <li><a href="CompanyProfile.html">公司简介</a></li>
                <li><a href="TeamIntroduction.html">团队介绍</a></li>
                <li><a href="MarketAdvantage.html">市场优势</a></li>
                <li><a href="NewMessage.html">留言</a></li>
              </ul>
            </li>
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="#">
                	景点推荐 
              </a>
              <ul class="dropdown-menu">
                <li><a href="GettingAroundTourism.html">周边游</a></li>
                <li><a href="InboundTourism.html">国内游</a></li>
                <li><a href="OutboundTourism.html">出境游</a></li>
              </ul>
            </li>
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="#">
                	签证
              </a>
              <ul class="dropdown-menu">
                <li><a href="VisaProcessing1.html">签证办理</a></li>
              </ul>
            </li>
             <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="#">
                	招聘
              </a>
              <ul class="dropdown-menu">
                <li><a href="JoinUs.html">招聘</a></li>
              </ul>
            </li>
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="#">
                	员工登录
              </a>
              <ul class="dropdown-menu">
                <li><a href="LoginServlet.shxt">员工登录</a></li>
              </ul>
            </li>
             <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="#">
                	其他
              </a>
              <ul class="dropdown-menu">
                <li><a href="Insurance.html">保险办理</a></li>
                <li><a href="Financial.html">金融</a></li>
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
            <li class="active">自助</li>
        </ul>
        <div class="row margin-bottom-40">
          <div class="col-md-12">
            <h1>自助推荐</h1>
            <div class="content-page">
              <div class="row margin-bottom-40">
              
              <c:forEach items="${buffet }" var="buffet" varStatus="vs">
                <div class="col-md-3 col-sm-4 gallery-item">
                  <a data-rel="fancybox-button" title="Project Name" href="${buffet.buffet_url }" class="fancybox-button">
                    <img alt="" src="${buffet.buffet_url }" class="img-responsive">
                    <div class="zoomix"><i class="fa fa-search"></i></div>
                  </a>
                  <div class="pi-price">${buffet.buffet_price }元</div><br><br><br>
                  <center><p>${buffet.buffet_name}</p></center> 
                  <a href="BuffetBought.html?buffet_id=${buffet.buffet_id }"><input type="button" value="购买" class="btn btn-circle " onclick="toSub()"></a>
                </div>
               </c:forEach> 
               
                
                
               
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