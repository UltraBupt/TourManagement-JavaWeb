<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>海外热门景点</title>
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
                <li><a href="OutboundHotTourism.html">海外热门景点</a></li>
              </ul>
            </li>
            <li class="dropdown dropdown-megamenu">
              <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="#">
               	景点门票
              </a>
              <ul class="dropdown-menu">
                <li><a href="OutboundTouristTicket.html">海外景点门票</a></li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </div>

    <div class="main">
      <div class="container">
        <div class="row margin-bottom-40">
          <div class="col-md-12 sale-product">
            <h2>热门景点推荐</h2>
            <div class="owl-carousel owl-carousel5">
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${outboundHotTourism[0].outboundTourism_url }" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${outboundHotTourism[0].outboundTourism_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <p><center><span style="color:grey">${outboundHotTourism[0].outboundTourism_desc }</span></center></p>
                </div>
              </div>
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${outboundHotTourism[1].outboundTourism_url }" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${outboundHotTourism[1].outboundTourism_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <p><center><span style="color:grey">${outboundHotTourism[1].outboundTourism_desc }</span></center></p>
                </div>
              </div>
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${outboundHotTourism[2].outboundTourism_url }" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${outboundHotTourism[2].outboundTourism_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <p><center><span style="color:grey">${outboundHotTourism[2].outboundTourism_desc }</span></center></p>
                </div>
              </div>
              <div>
                  <div class="product-item">
                    <div class="pi-img-wrapper">
                      <img src="${outboundHotTourism[3].outboundTourism_url }" class="img-responsive" alt="Berry Lace Dress">
                      <div>
                        <a href="${outboundHotTourism[3].outboundTourism_url }" class="btn btn-default fancybox-button">点击放大</a>
                      </div>
                    </div>
                    <p><center><span style="color:grey">${outboundHotTourism[3].outboundTourism_desc }</span></center></p>
                    <div class="sticker sticker-new"></div>
                  </div>
              </div>
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${outboundHotTourism[4].outboundTourism_url }" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${outboundHotTourism[4].outboundTourism_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <p><center><span style="color:grey">${outboundHotTourism[4].outboundTourism_desc }</span></center></p>
                </div>
              </div>
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${outboundHotTourism[5].outboundTourism_url }" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${outboundHotTourism[5].outboundTourism_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <p><center><span style="color:grey">${outboundHotTourism[5].outboundTourism_desc }</span></center></p>
                </div>
              </div>
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${outboundHotTourism[6].outboundTourism_url }" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${outboundHotTourism[6].outboundTourism_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                </div>
                <p><center><span style="color:grey">${outboundHotTourism[6].outboundTourism_desc }</span></center></p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    
     <div class="main">
      <div class="container">
        <div class="row margin-bottom-40">
          <div class="col-md-12 sale-product">
            <h2>热门景点推荐</h2>
            <div class="owl-carousel owl-carousel5">
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${outboundHotTourism[7].outboundTourism_url }" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${outboundHotTourism[7].outboundTourism_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <p><center><span style="color:grey">${outboundHotTourism[7].outboundTourism_desc }</span></center></p>
                  <div class="sticker sticker-sale"></div>
                </div>
              </div>
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${outboundHotTourism[8].outboundTourism_url }" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${outboundHotTourism[8].outboundTourism_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <p><center><span style="color:grey">${outboundHotTourism[8].outboundTourism_desc }</span></center></p>
                </div>
              </div>
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${outboundHotTourism[9].outboundTourism_url }" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${outboundHotTourism[9].outboundTourism_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <p><center><span style="color:grey">${outboundHotTourism[9].outboundTourism_desc }</span></center></p>
                </div>
              </div>
              <div>
                  <div class="product-item">
                    <div class="pi-img-wrapper">
                      <img src="${outboundHotTourism[10].outboundTourism_url }" class="img-responsive" alt="Berry Lace Dress">
                      <div>
                        <a href="${outboundHotTourism[10].outboundTourism_url }" class="btn btn-default fancybox-button">点击放大</a>
                      </div>
                    </div>
                    <p><center><span style="color:grey">${outboundHotTourism[10].outboundTourism_desc }</span></center></p>
                    <div class="sticker sticker-new"></div>
                  </div>
              </div>
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${outboundHotTourism[11].outboundTourism_url }" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${outboundHotTourism[11].outboundTourism_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <p><center><span style="color:grey">${outboundHotTourism[11].outboundTourism_desc }</span></center></p>
                </div>
              </div>
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${outboundHotTourism[12].outboundTourism_url }" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${outboundHotTourism[12].outboundTourism_url }">点击放大</a>
                    </div>
                  </div>
                  <p><center><span style="color:grey">${outboundHotTourism[12].outboundTourism_desc }</span></center></p>
                </div>
              </div>
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${outboundHotTourism[13].outboundTourism_url }" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${outboundHotTourism[13].outboundTourism_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <p><center><span style="color:grey">${outboundHotTourism[13].outboundTourism_desc }</span></center></p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    
     <div class="main">
      <div class="container">
        <div class="row margin-bottom-40">
          <div class="col-md-12 sale-product">
            <h2>热门景点推荐</h2>
            <div class="owl-carousel owl-carousel5">
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${outboundHotTourism[14].outboundTourism_url }" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${outboundHotTourism[14].outboundTourism_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <p><center><span style="color:grey">${outboundHotTourism[14].outboundTourism_desc }</span></center></p>
                  <div class="sticker sticker-sale"></div>
                </div>
              </div>
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${outboundHotTourism[15].outboundTourism_url }" class="img-responsive"  alt="Berry Lace Dress">
                    <div>
                      <a href="${outboundHotTourism[15].outboundTourism_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <p><center><span style="color:grey">${outboundHotTourism[15].outboundTourism_desc }</span></center></p>
                </div>
              </div>
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${outboundHotTourism[16].outboundTourism_url }" class="img-responsive"  alt="Berry Lace Dress">
                    <div>
                      <a href="${outboundHotTourism[16].outboundTourism_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <p><center><span style="color:grey">${outboundHotTourism[16].outboundTourism_desc }</span></center></p>
                </div>
              </div>
              <div>
                  <div class="product-item">
                    <div class="pi-img-wrapper">
                      <img src="${outboundHotTourism[17].outboundTourism_url }" class="img-responsive" alt="Berry Lace Dress">
                      <div>
                        <a href="${outboundHotTourism[17].outboundTourism_url }" class="btn btn-default fancybox-button">点击放大</a>
                      </div>
                    </div>
                    <p><center><span style="color:grey">${outboundHotTourism[17].outboundTourism_desc }</span></center></p>
                  </div>
              </div>
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${outboundHotTourism[18].outboundTourism_url }" class="img-responsive"  alt="Berry Lace Dress">
                    <div>
                      <a href="${outboundHotTourism[18].outboundTourism_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <p><center><span style="color:grey">${outboundHotTourism[18].outboundTourism_desc }</span></center></p>
                </div>
              </div>
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${outboundHotTourism[19].outboundTourism_url }" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${outboundHotTourism[19].outboundTourism_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <p><center><span style="color:grey">${outboundHotTourism[19].outboundTourism_desc }</span></center></p>
                </div>
              </div>
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <img src="${outboundHotTourism[20].outboundTourism_url }" class="img-responsive" alt="Berry Lace Dress">
                    <div>
                      <a href="${outboundHotTourism[20].outboundTourism_url }" class="btn btn-default fancybox-button">点击放大</a>
                    </div>
                  </div>
                  <p><center><span style="color:grey">${outboundHotTourism[20].outboundTourism_desc }</span></center></p>
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