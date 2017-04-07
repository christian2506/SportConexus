<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
    <title>SportConnexus </title>
    <!-- for-mobile-apps -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Lucrative Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
    function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- //for-mobile-apps -->
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <!-- js -->
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <!-- //js -->
    <!-- pop-up-box -->
    <link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />
    <!-- //pop-up-box -->
    <!-- font-awesome icons -->
    <link href="css/font-awesome.css" rel="stylesheet">
    <!-- //font-awesome icons -->
    <link href="//fonts.googleapis.com/css?family=Work+Sans:100,200,300,400,500,600,700,800,900&amp;subset=latin-ext" rel="stylesheet">
    <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
</head>

<body>
<!-- header -->
<div class="header">
    <div class="container">
        <div class="agile_header_grid">
            <div class="w3_agile_logo">
                <h1><a href="index.jsp"><span>Sport</span>Connexus</a></h1>
            </div>
            <div class="agileits_w3layouts_sign_in">
                <ul>

                    <li>Contáctanos : <span>+(01) 543 5225</span></li>
                </ul>
            </div>
            <div class="clearfix"> </div>
        </div>
        <div class="w3_agileits_nav">
            <nav class="navbar navbar-default">
                <div class="navbar-header navbar-left">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
                    <nav>
                        <ul class="nav navbar-nav">
                            <li ><a href="listUser.action" class="hvr-sweep-to-bottom">Usuarios</a></li>
                            <li><a href="listTeam.action" class="hvr-sweep-to-bottom"> Equipos </a></li>
                            <li><a href="listSportSpace.action" class="hvr-sweep-to-bottom">Lugares</a></li>

                            <li><a href="listBusinessPartner.action" class="hvr-sweep-to-bottom">Socios</a></li>
                            <li><a href="listSport.action" class="hvr-sweep-to-bottom">Deportes</a></li>

                            <li><a href="index2.jsp" class="hvr-sweep-to-bottom">Volver</a></li>

                        </ul>

                    </nav>
                </div>
            </nav>
        </div>
    </div>
</div>
<!-- //header -->
<!-- pop-up-box -->

<!-- //pop-up-box -->
<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
<script>
    $(document).ready(function() {
        $('.popup-with-zoom-anim').magnificPopup({
            type: 'inline',
            fixedContentPos: false,
            fixedBgPos: true,
            overflowY: 'auto',
            closeBtnInside: true,
            preloader: false,
            midClick: true,
            removalDelay: 300,
            mainClass: 'my-mfp-zoom-in'
        });

    });
</script>
<!-- banner -->
<div class="banner1">
    <h3>Lugares</h3>
</div>
<!-- //banner -->
<!-- icons -->
<div class="w3_wthree_agileits_icons main-grid-border">
    <div class="container">
        <div class="grid_3 grid_4 w3_agileits_icons_page">
            <div class="icons">
                <h3 class="agileits-icons-title"></h3>
                <section id="new">


                    <div class="row fontawesome-icon-list">


                            <table class="table">
                            <thead>
                            <tr bgcolor="#e7e7e7">
                            <th>Código</th>
                            <th>Nombre del Lugar</th>
                            <th>Capacidad Maxima</th>
                            <th>Estado</th>

                            </tr>
                            <s:iterator value="sportSpaces">
                                <tr>
                                    <th><s:property value="sportSpaceId"/></th>
                                    <th><s:property value="sportSpaceId"/></th>
                                    <th><s:property value="maximumCapacity"/></th>
                                    <th><s:property value="status"/></th>



                                </tr>
                            </s:iterator>
                            </thead>
                            <tbody>
                            </tbody>
                            </table>

x


                            </div>
                </section>
            </div>
        </div>
    </div>
</div>



</section>








<div class="stats">
    <div class="wthree_stat">
        <div class="container">
            <div class="col-md-5 wthree_stat_left">
                <h3>Nuestras Estadisticas</h3>
                <p>Información de actividades Registradas</p>
            </div>
            <div class="col-md-7 wthree_stat_right">
                <ul>
                    <li>
                        <div class="wthree_stat_right1">
                            <i class="fa fa-heart" aria-hidden="true"></i>
                            <h4>Personas que les gusta</h4>
                            <p class="counter">464</p>
                        </div>
                    </li>
                    <li>
                        <div class="wthree_stat_right1">
                            <i class="glyphicon glyphicon-piggy-bank" aria-hidden="true"></i>
                            <h4>Ahorre Dinero</h4>
                            <p class="counter">412</p>
                        </div>
                    </li>
                    <li>
                        <div class="wthree_stat_right1">
                            <i class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></i>
                            <h4>Creativo</h4>
                            <p class="counter">235</p>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
    <div class="w3layouts_newsletter">
        <div class="container">
            <div class="w3layouts_newsletter_left">
                <h3>Suscribete a nuestra web</h3>
            </div>
            <div class="w3layouts_newsletter_right">
                <form action="#" method="post">
                    <input type="email" name="Email" placeholder="Email..." required="">
                    <input type="submit" value="Subscribe">
                </form>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
<!-- //stats -->
<!-- stats -->
<script src="js/waypoints.min.js"></script>
<script src="js/counterup.min.js"></script>
<script>
    jQuery(document).ready(function( $ ) {
        $('.counter').counterUp({
            delay: 20,
            time: 1000
        });
    });
</script>
<!-- stats -->
<!-- footer -->
<div class="footer">
    <div class="container">
        <div class="w3_footer_grids">
            <div class="col-md-4 w3_footer_grid">
                <h2><a href="index.jsp"><span>Sport</span>Conexus</a></h2>
                <p>Nuestra Web <a href="#">http:///SportConexus.com</a> Club Deportivo.</p>
            </div>
            <div class="col-md-3 w3_footer_grid">
                <div class="w3l_footer_grid">
                    <i class="fa fa-home" aria-hidden="true"></i>
                </div>
                <h4>Direccion</h4>
                <p>234 main street west Building, NewYork City,F34 834.</p>
            </div>
            <div class="col-md-2 w3_footer_grid">
                <div class="w3l_footer_grid">
                    <i class="fa fa-phone" aria-hidden="true"></i>
                </div>
                <h4>Llamanos</h4>
                <p>+(123) 456 789 344 <span>+(123) 456 780 344</span></p>
            </div>
            <div class="col-md-3 w3_footer_grid">
                <div class="w3l_footer_grid">
                    <i class="fa fa-envelope" aria-hidden="true"></i>
                </div>
                <h4>E-mail</h4>
                <p><a href="mailto:info@example.com">info@example1.com</a>
                    <span><a href="mailto:info@example.com">info@example2.com</a></span></p>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
<div class="copyright">
    <div class="container">
        <div class="w3ls_copyright_left">
            <ul>
                <li><a href="services.jsp">Servicios</a></li>
                <li><a href="about.jsp">Acerca</a></li>
                <li><a href="portfolio.jsp">Portafolio</a></li>
                <li><a href="contact.jsp">Contactanos</a></li>
            </ul>
            <p>© 2017 SportConexus. Todos los Derechos Reservados </p>
        </div>
        <div class="w3ls_copyright_right">
            <ul>
                <li><a href="#" class="w3_agile_facebook"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                <li><a href="#" class="agile_twitter"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                <li><a href="#" class="w3_agile_dribble"><i class="fa fa-dribbble" aria-hidden="true"></i></a></li>
                <li><a href="#" class="w3_agile_vimeo"><i class="fa fa-vimeo" aria-hidden="true"></i></a></li>
            </ul>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
<!-- //footer -->
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
    jQuery(document).ready(function($) {
        $(".scroll").click(function(event){
            event.preventDefault();
            $('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
        });
    });
</script>
<!-- start-smoth-scrolling -->
<!-- for bootstrap working -->
<script src="js/bootstrap.js"></script>
<!-- //for bootstrap working -->
<!-- here stars scrolling icon -->
<script type="text/javascript">
    $(document).ready(function() {
        /*
         var defaults = {
         containerID: 'toTop', // fading element id
         containerHoverID: 'toTopHover', // fading element hover id
         scrollSpeed: 1200,
         easingType: 'linear'
         };
         */

        $().UItoTop({ easingType: 'easeOutQuart' });

    });
</script>
<!-- //here ends scrolling icon -->




</body>

</html>
