<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>晨曦旅行主页</title>
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
  <link href="resource/assets/global/plugins/slider-revolution-slider/rs-plugin/css/settings.css" rel="stylesheet">
  <link href="resource/assets/global/css/components.css" rel="stylesheet">
  <link href="resource/assets/frontend/layout/css/style.css" rel="stylesheet">
  <link href="resource/assets/frontend/pages/css/style-revolution-slider.css" rel="stylesheet"><!-- metronic revo slider styles -->
  <link href="resource/assets/frontend/layout/css/style-responsive.css" rel="stylesheet">
  <link href="resource/assets/frontend/layout/css/themes/red.css" rel="stylesheet" id="style-color">
  <link href="resource/assets/frontend/layout/css/custom.css" rel="stylesheet">
</head>
<body class="corporate">
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
    <div class="page-slider margin-bottom-40">
      <div class="fullwidthbanner-container revolution-slider">
        <div class="fullwidthabnner">
          <ul id="revolutionul">
            <li data-transition="fade" data-slotamount="8" data-masterspeed="700" data-delay="9400" data-thumb="resource/assets/frontend/pages/img/revolutionslider/thumbs/thumb2.jpg">
              <img src="resource/assets/frontend/pages/img/revolutionslider/bg9.jpg" alt="">
              <div class="caption lft slide_title_white slide_item_left"
                data-x="30"
                data-y="90"
                data-speed="400"
                data-start="1500"
                data-easing="easeOutExpo">
                	台湾<br><span class="slide_title_white_bold">日月潭</span>
              </div>
              <div class="caption lft slide_subtitle_white slide_item_left"
                data-x="87"
                data-y="245"
                data-speed="400"
                data-start="2000"
                data-easing="easeOutExpo">
                 	明珠璀璨日月潭,碧绿湖水源玉山。岛东湖面如圆日,西南湖似弯月潭。
              </div>
              <div class="caption lfb"
                data-x="640" 
                data-y="0" 
                data-speed="700" 
                data-start="1000" 
                data-easing="easeOutExpo">
                <img src="resource/assets/frontend/pages/img/revolutionslider/spot1.jpg" alt="Image 1">
              </div>
            </li>    
            <li data-transition="fade" data-slotamount="8" data-masterspeed="700" data-delay="9400" data-thumb="resource/assets/frontend/pages/img/revolutionslider/thumbs/thumb2.jpg">
              <img src="resource/assets/frontend/pages/img/revolutionslider/bg1.jpg" alt="">
              <div class="caption lft slide_title slide_item_left"
                data-x="30"
                data-y="105"
                data-speed="400"
                data-start="1500"
                data-easing="easeOutExpo">
                	湖北 
              </div>
              <div class="caption lft slide_subtitle slide_item_left"
                data-x="30"
                data-y="180"
                data-speed="400"
                data-start="2000"
                data-easing="easeOutExpo">
                	神农架
              </div>
              <div class="caption lft slide_desc slide_item_left"
                data-x="30"
                data-y="220"
                data-speed="400"
                data-start="2500"
                data-easing="easeOutExpo">
                	晨风揉醒花千朵，银雾含香吻村落。翠湖鳞波连天际，偕同霞女织绫罗。<br> 
              </div>
              <div class="caption lfb"
                data-x="640" 
                data-y="55" 
                data-speed="700" 
                data-start="1000" 
                data-easing="easeOutExpo">
                <img src="resource/assets/frontend/pages/img/revolutionslider/spot2.jpg" alt="Image 1">
              </div>
            </li>
            <li data-transition="fade" data-slotamount="7" data-masterspeed="300" data-delay="9400" data-thumb="resource/assets/frontend/pages/img/revolutionslider/thumbs/thumb2.jpg">                        
              <img src="resource/assets/frontend/pages/img/revolutionslider/bg2.jpg" alt="">
              <div class="caption lfl slide_title slide_item_left"
                data-x="30"
                data-y="125"
                data-speed="400"
                data-start="3500"
                data-easing="easeOutExpo">
                	北京
              </div>
              <div class="caption lfl slide_subtitle slide_item_left"
                data-x="30"
                data-y="200"
                data-speed="400"
                data-start="4000"
                data-easing="easeOutExpo">
                	故宫
              </div>
              <div class="caption lfl slide_desc slide_item_left"
                data-x="30"
                data-y="245"
                data-speed="400"
                data-start="4500"
                data-easing="easeOutExpo">
                	紫禁城中一线穿， 观宫看殿百千间。 皇家气派余惊叹， 文物古迹旷世鲜。
              </div>                        
              <div class="caption lfb"
                data-x="640" 
                data-y="55" 
                data-speed="700" 
                data-start="1000" 
                data-easing="easeOutExpo">
                <img src="resource/assets/frontend/pages/img/revolutionslider/spot3.jpg" alt="Image 1">
              </div>
            </li>
            <li data-transition="fade" data-slotamount="8" data-masterspeed="700" data-delay="9400" data-thumb="resource/assets/frontend/pages/img/revolutionslider/thumbs/thumb2.jpg">
              <img src="resource/assets/frontend/pages/img/revolutionslider/bg3.jpg" alt="">
             
             
              <div class="caption lfl slide_item_left" 
                data-x="30" 
                data-y="95" 
                data-speed="400" 
                data-start="1500" 
                data-easing="easeOutBack">
               <img src="resource/assets/frontend/pages/img/revolutionslider/spot4.jpg" alt="Image 1">
              </div>
              <div class="caption lfr slide_title"
                data-x="470"
                data-y="100"
                data-speed="400"
                data-start="2000"
                data-easing="easeOutExpo">
               	美国
              </div>
              <div class="caption lfr slide_subtitle"
                data-x="470"
                data-y="170"
                data-speed="400"
                data-start="2500"
                data-easing="easeOutExpo">
                	华盛顿
              </div>
              <div class="caption lfr slide_desc"
                data-x="470"
                data-y="220"
                data-speed="400"
                data-start="3000"
                data-easing="easeOutExpo">
                	体验美国之都的繁花似锦，明媚盎然。
              </div>
                        </li>               
                        <li data-transition="fade" data-slotamount="8" data-masterspeed="700" data-delay="9400" data-thumb="resource/assets/frontend/pages/img/revolutionslider/thumbs/thumb2.jpg">
                            <img src="resource/assets/frontend/pages/img/revolutionslider/bg4.jpg" alt="">                        
                             <div class="caption lft slide_title"
                                 data-x="30"
                                 data-y="105"
                                 data-speed="400"
                                 data-start="1500"
                                 data-easing="easeOutExpo">
                                 	广西
                            </div>
                            <div class="caption lft slide_subtitle"
                                 data-x="30"
                                 data-y="180"
                                 data-speed="400"
                                 data-start="2000"
                                 data-easing="easeOutExpo">
                                 	桂林
                            </div>
                            <div class="caption lft slide_desc"
                                 data-x="30"
                                 data-y="225"
                                 data-speed="400"
                                 data-start="2500"
                                 data-easing="easeOutExpo">
                                 	君家桂林住，日伐桂枝炊。何事东堂树，年年待一枝。
                            </div>
                            <div class="caption lft start"  
                                 data-x="670" 
                                 data-y="55" 
                                 data-speed="400" 
                                 data-start="2000" 
                                 data-easing="easeOutBack"  >
                                 <img src="resource/assets/frontend/pages/img/revolutionslider/spot5.jpg" alt="Image 2">
                            </div>
                        </li>
                </ul>
                <div class="tp-bannertimer tp-bottom"></div>
            </div>
        </div>
    </div>
    <div class="main">
      <div class="container">
        <div class="row service-box margin-bottom-40">
          <div class="col-md-4 col-sm-4">
            <div class="service-box-heading">
              <em><i class="fa fa-location-arrow blue"></i></em>
              <span>晨曦旅行</span>
            </div>
            <p>晨曦旅行自2008年8月8日成立至今，受到广大游客的一致好评，晨曦旅行一家专门做旅行的网站，你值得拥有</p>
          </div>
          <div class="col-md-4 col-sm-4">
            <div class="service-box-heading">
              <em><i class="fa fa-check red"></i></em>
              <span>服务理念</span>
            </div>
            <p>晨曦旅行的服务理念：最真诚的服务，最优惠的价格，最完美的规划，带给您最舒心的体验。晨曦旅行，你我同在</p>
          </div>
          <div class="col-md-4 col-sm-4">
            <div class="service-box-heading">
              <em><i class="fa fa-compress green"></i></em>
              <span>团队建设</span>
            </div>
            <p>晨曦旅行自2008年成立至今已经是一个员工万人，规模庞大的旅行体系。选择晨曦，拥抱自然</p>
          </div>
        </div>
        <div class="row quote-v1 margin-bottom-30">
          <div class="col-md-9">
            <span>沐浴晨曦的洗礼，享受自然的拥抱。你是锦瑟，我为流年。</span>
          </div>
          <div class="col-md-3 text-right">
            <a class="btn-transparent"><i class="fa fa-rocket margin-right-10"></i>晨曦旅行</a>
          </div>
        </div>
        <div class="row recent-work margin-bottom-40">
          <div class="col-md-3">
            <h2>热门酒店</h2>
            <p>热门酒店部分展示，晨曦旅行优惠多多</p>
          </div>
          <div class="col-md-9">
            <div class="owl-carousel owl-carousel3">
              <div class="recent-work-item">
                <em>
                  <img src="resource/assets/frontend/pages/img/works/hotel1.jpg" alt="Amazing Project" class="img-responsive">
                  <a href="resource/assets/frontend/pages/img/works/hotel1.jpg" class="fancybox-button" title="Project Name #1" data-rel="fancybox-button"><i class="fa fa-search"></i></a>
                </em>
                <a class="recent-work-description">
                  <strong>格林豪泰</strong>
                  <b>大床房</b>
                </a>
              </div>
              <div class="recent-work-item">
                <em>
                  <img src="resource/assets/frontend/pages/img/works/hotel2.jpg" alt="Amazing Project" class="img-responsive">
                  <a href="resource/assets/frontend/pages/img/works/hotel2.jpg" class="fancybox-button" title="Project Name #2" data-rel="fancybox-button"><i class="fa fa-search"></i></a>
                </em>
                <a class="recent-work-description">
                  <strong>夏日花园</strong>
                  <b>主题套房</b>
                </a>
              </div>
              <div class="recent-work-item">
                <em>
                  <img src="resource/assets/frontend/pages/img/works/hotel3.jpg" alt="Amazing Project" class="img-responsive">
                  <a href="resource/assets/frontend/pages/img/works/hotel3.jpg" class="fancybox-button" title="Project Name #3" data-rel="fancybox-button"><i class="fa fa-search"></i></a>
                </em>
                <a class="recent-work-description">
                  <strong>尚客优</strong>
                  <b>标准间</b>
                </a>
              </div>
              <div class="recent-work-item">
                <em>
                  <img src="resource/assets/frontend/pages/img/works/hotel4.jpg" alt="Amazing Project" class="img-responsive">
                  <a href="resource/assets/frontend/pages/img/works/hotel4.jpg" class="fancybox-button" title="Project Name #4" data-rel="fancybox-button"><i class="fa fa-search"></i></a>
                </em>
                <a class="recent-work-description">
                  <strong>银座佳驿</strong>
                  <b>大床房</b>
                </a>
              </div>
              <div class="recent-work-item">
                <em>
                  <img src="resource/assets/frontend/pages/img/works/hotel5.jpg" alt="Amazing Project" class="img-responsive">
                  <a href="resource/assets/frontend/pages/img/works/hotel5.jpg" class="fancybox-button" title="Project Name #5" data-rel="fancybox-button"><i class="fa fa-search"></i></a>
                </em>
                <a class="recent-work-description">
                  <strong>香格里拉</strong>
                  <b>大床房</b>
                </a>
              </div>
              <div class="recent-work-item">
                <em>
                  <img src="resource/assets/frontend/pages/img/works/hotel6.jpg" alt="Amazing Project" class="img-responsive">
                  <a href="resource/assets/frontend/pages/img/works/hotel6.jpg" class="fancybox-button" title="Project Name #6" data-rel="fancybox-button"><i class="fa fa-search"></i></a>
                </em>
                <a class="recent-work-description">
                  <strong>如家</strong>
                  <b>大床房</b>
                </a>
              </div>
            </div>       
          </div>
        </div>   
        <div class="row mix-block margin-bottom-40">
        
        
        
        
        
          <div class="col-md-7 tab-style-1">
            <ul class="nav nav-tabs">
              <li class="active"><a href="#tab-1" data-toggle="tab">广告栏目</a></li>
              <li><a href="#tab-2" data-toggle="tab">广告栏目</a></li>
              <li><a href="#tab-3" data-toggle="tab">广告栏目</a></li>
              <li><a href="#tab-4" data-toggle="tab">广告栏目</a></li>
            </ul>
            <div class="tab-content">
              <div class="tab-pane row fade in active" id="tab-1">
                <div class="col-md-9 col-sm-9">
                  <p class="margin-bottom-10">
                  		${advertisement[0].advertisement_desc }
                  </p>
                </div>
              </div>
              <div class="tab-pane row fade" id="tab-2">
                <div class="col-md-9 col-sm-9">
					<p class="margin-bottom-10">
                  		${advertisement[1].advertisement_desc }
                    </p>                
                </div>
              </div>
              <div class="tab-pane fade" id="tab-3">
 					<div class="col-md-9 col-sm-9">
						<p class="margin-bottom-10">
	                  		${advertisement[2].advertisement_desc }
	                    </p>                
                	</div>              
              </div>
              <div class="tab-pane fade" id="tab-4">
 				<div class="col-md-9 col-sm-9">
					<p class="margin-bottom-10">
                  		${advertisement[3].advertisement_desc }
                    </p>                
                </div>              
              </div>
            </div>
          </div>
          
          
          
          <div class="col-md-5 testimonials-v1">
            <div id="myCarousel" class="carousel slide">
              <div class="carousel-inner">
                <div class="item">
                  <blockquote><p>思念像一首诗，如春之暮野，在春日的阳光中我们卸下沉重的包袱，与家人一起沐浴晨曦，拥抱自然。</p></blockquote>
                  <div class="carousel-info">
                    <img class="pull-left" src="resource/assets/frontend/pages/img/people/people1s.jpg" alt="">
                    <div class="pull-left">
                      <span class="testimonials-name">萌总</span>
                      <span class="testimonials-post">销售总监</span>
                    </div>
                  </div>
                </div>
                <div class="item">
                  <blockquote><p>在晨曦的每个日夜都是那么美好，每天充实而又安逸，欢迎加入我们，晨曦旅行为您服务。</p></blockquote>
                  <div class="carousel-info">
                    <img class="pull-left" src="resource/assets/frontend/pages/img/people/people2s.jpg" alt="">
                    <div class="pull-left">
                      <span class="testimonials-name">帅总</span>
                      <span class="testimonials-post">HR</span>
                    </div>
                  </div>
                </div>
                <div class="active item">
                  <blockquote><p>晨曦旅行自08年成立至今，感谢大家的一路支持。我们当竭尽全力为大家提供最一流的服务，最优惠的价格，给您带来最美好的体验，你与自然只缺一个晨曦。</p></blockquote>
                  <div class="carousel-info">
                    <img class="pull-left" src="resource/assets/frontend/pages/img/people/people3s.jpg" alt="">
                    <div class="pull-left">
                      <span class="testimonials-name">高总</span>
                      <span class="testimonials-post">CEO</span>
                    </div>
                  </div>
                </div>
              </div>
              <a class="left-btn" href="#myCarousel" data-slide="prev"></a>
              <a class="right-btn" href="#myCarousel" data-slide="next"></a>
            </div>
          </div>
        </div>                
        <div class="row margin-bottom-40 front-steps-wrapper front-steps-count-3">
          <div class="col-md-4 col-sm-4 front-step-col">
            <div class="front-step front-step1">
              <h2>爱情</h2>
              <p>与爱人一起享受浪漫的爱情之旅，品味薰衣草的芬芳，享受爱情的甜蜜。</p>
            </div>
          </div>
          <div class="col-md-4 col-sm-4 front-step-col">
            <div class="front-step front-step2">
              <h2>亲情</h2>
              <p>与家人一起享受温馨的亲情之旅，品味郁金香的美妙，享受亲情的美好。</p>
            </div>
          </div>
          <div class="col-md-4 col-sm-4 front-step-col">
            <div class="front-step front-step3">
              <h2>友情</h2>
              <p>与朋友一起享受愉悦的基情之旅，品味百合花的甜美，享受友情的纯真。</p>
            </div>
          </div>
        </div>
        <div class="row margin-bottom-40 our-clients">
          <div class="col-md-3">
            <h2>美食天下</h2>
            <p>各地美食抢先看，让您大饱眼福，还等什么与晨曦一起享受美食，享受生活吧。</p>
          </div>
          <div class="col-md-9">
            <div class="owl-carousel owl-carousel6-brands">
              <div class="client-item">
                  <img src="resource/assets/frontend/pages/img/clients/food1.jpg" class="img-responsive" alt="">
                  <img src="resource/assets/frontend/pages/img/clients/food1.jpg" class="color-img img-responsive" alt="">
              </div>
              <div class="client-item">
                  <img src="resource/assets/frontend/pages/img/clients/food2.jpg" class="img-responsive" alt="">
                  <img src="resource/assets/frontend/pages/img/clients/food2.jpg" class="color-img img-responsive" alt="">
              </div>
              <div class="client-item">
                  <img src="resource/assets/frontend/pages/img/clients/food3.jpg" class="img-responsive" alt="">
                  <img src="resource/assets/frontend/pages/img/clients/food3.jpg" class="color-img img-responsive" alt="">
              </div>
              <div class="client-item">
                  <img src="resource/assets/frontend/pages/img/clients/food4.jpg" class="img-responsive" alt="">
                  <img src="resource/assets/frontend/pages/img/clients/food4.jpg" class="color-img img-responsive" alt="">
              </div>
              <div class="client-item">
                  <img src="resource/assets/frontend/pages/img/clients/food5.jpg" class="img-responsive" alt="">
                  <img src="resource/assets/frontend/pages/img/clients/food5.jpg" class="color-img img-responsive" alt="">
              </div>
              <div class="client-item">
                  <img src="resource/assets/frontend/pages/img/clients/food6.jpg" class="img-responsive" alt="">
                  <img src="resource/assets/frontend/pages/img/clients/food6.jpg" class="color-img img-responsive" alt="">
              </div>
              <div class="client-item">
                  <img src="resource/assets/frontend/pages/img/clients/food7.jpg" class="img-responsive" alt="">
                  <img src="resource/assets/frontend/pages/img/clients/food7.jpg" class="color-img img-responsive" alt="">
              </div>
              <div class="client-item">
                  <img src="resource/assets/frontend/pages/img/clients/food8.jpg" class="img-responsive" alt="">
                  <img src="resource/assets/frontend/pages/img/clients/food8.jpg" class="color-img img-responsive" alt="">
              </div>                  
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
    <script src="resource/assets/global/plugins/fancybox/source/jquery.fancybox.pack.js" type="text/javascript"></script><!-- pop up -->
    <script src="resource/assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.min.js" type="text/javascript"></script><!-- slider for products -->
    <script src="resource/assets/global/plugins/slider-revolution-slider/rs-plugin/js/jquery.themepunch.plugins.min.js" type="text/javascript"></script>
    <script src="resource/assets/global/plugins/slider-revolution-slider/rs-plugin/js/jquery.themepunch.revolution.min.js" type="text/javascript"></script> 
    <script src="resource/assets/global/plugins/slider-revolution-slider/rs-plugin/js/jquery.themepunch.tools.min.js" type="text/javascript"></script> 
    <script src="resource/assets/frontend/pages/scripts/revo-slider-init.js" type="text/javascript"></script>
    <script src="resource/assets/frontend/layout/scripts/layout.js" type="text/javascript"></script>
    <script type="text/javascript">
        jQuery(document).ready(function() {
            Layout.init();    
            Layout.initOWL();
            RevosliderInit.initRevoSlider();
            Layout.initTwitter();
            Layout.initFixHeaderWithPreHeader(); /* Switch On Header Fixing (only if you have pre-header) */
            Layout.initNavScrolling();
        });
    </script>
</body>
</html>