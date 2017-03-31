<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SportConexus a Corporate Business </title>
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

                    <li>Contactanos : <span>(+01) 543 5225</span></li>
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
                            <li class="active"><a href="index.jsp">Inicio</a></li>
                            <li><a href="services.jsp" class="hvr-sweep-to-bottom"> ¿Que Ofrecemos? </a></li>
                            <li><a href="about.jsp" class="hvr-sweep-to-bottom">Acerca</a></li>


                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle hvr-sweep-to-bottom" data-toggle="dropdown">Torneo<b class="caret"></b></a>
                                <ul class="dropdown-menu agile_short_dropdown">
                                    <li><a href="icons.jsp">Equipos</a></li>

                                </ul>
                            </li>
                            <li><a href="portfolio.jsp" class="hvr-sweep-to-bottom">Galeria</a></li>
                            <li><a href="contact.jsp" class="hvr-sweep-to-bottom">Contactanos</a></li>
                            <li><a href="newUser.jsp" class="hvr-sweep-to-bottom">Registrate</a></li>
                        </ul>
                        <div class="agileinfo_search">

                        </div>
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

    <center><h1>Iniciar Sesión</h1></center>
    <br><br><br>
    <s:form action="validate">
    <table align="center">
        <tr>

            <th align="right"> Nombre Usuario:</th>

            <td><input  textfield name="userName" placeholder="NombreUsuario"> </td>
        </tr>
        <tr>
            <th align="rigth"> Password:</th>
            <td> <input type="password" name="password" placeholder="Password"> </td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="SUBMIT" value="Log In" class="btn btn-primary" > </td>
        </tr>

    </table>
    </s:form>

</div>
<!-- //banner -->
<!-- bootstrap-pop-up -->
<div class="modal video-modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                SportConexus
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            </div>
            <section>
                <div class="modal-body">
                    <img src="images/banner.jpg" alt=" " class="img-responsive" />
                    <p>Comparte momentos inolvidables con tus amigos gracias a "SportConnexus"
                        SportConnexus te ofrece una gran cantidad de espacios deportivos para elegir
                        la mejor opcion que se adapte a tus necesidades.
                        <i>"Reservar un lugar deportivo disponible nunca ha sido más fácil"</i></p>
                </div>
            </section>
        </div>
    </div>
</div>
<!-- //bootstrap-pop-up -->
<!-- banner-bottom -->

<!-- //two-grids -->
<!-- news -->
<div class="news">
    <div class="container">
        <h3 class="agile_head">ultimas noticias</h3>
        <p class="w3_agile_para">Registro de días de actividades</p>
        <div class="agileits_w3layouts_news_grids">
            <ul id="flexiselDemo1">
                <li>
                    <div class="agileits_w3layouts_news_grid">
                        <div class="w3_agileits_news_grid">
                            <img src="images/3.jpg" alt=" " class="img-responsive" />
                            <div class="w3_agileits_news_grid_pos">
                                <h4>Dia : 15 Noviembre 2016</h4>
                            </div>
                        </div>
                        <h5><a href="#" data-toggle="modal" data-target="#myModal">Hockey Sobre cesped</a></h5>
                        <p>Torneo Interno.</p>
                    </div>
                </li>
                <li>
                    <div class="agileits_w3layouts_news_grid">
                        <div class="w3_agileits_news_grid">
                            <img src="images/4.jpg" alt=" " class="img-responsive" />
                            <div class="w3_agileits_news_grid_pos">
                                <h4>Dia : 18 Noviembre 2016</h4>
                            </div>
                        </div>
                        <h5><a href="#" data-toggle="modal" data-target="#myModal">Entrenamiento</a></h5>
                        <p> Ejercicios de Calentamiento.</p>
                    </div>
                </li>
                <li>
                    <div class="agileits_w3layouts_news_grid">
                        <div class="w3_agileits_news_grid">
                            <img src="images/5.jpg" alt=" " class="img-responsive" />
                            <div class="w3_agileits_news_grid_pos">
                                <h4>Dia : 23 Noviembre 2016</h4>
                            </div>
                        </div>
                        <h5><a href="#" data-toggle="modal" data-target="#myModal">Baskeball</a></h5>
                        <p>Torneo Juvenil.</p>
                    </div>
                </li>
                <li>
                    <div class="agileits_w3layouts_news_grid">
                        <div class="w3_agileits_news_grid">
                            <img src="images/6.jpg" alt=" " class="img-responsive" />
                            <div class="w3_agileits_news_grid_pos">
                                <h4>Dia : 28 Noviembre 2016</h4>
                            </div>
                        </div>
                        <h5><a href="#" data-toggle="modal" data-target="#myModal">Tennis</a></h5>
                        <p>Entrenamiento .</p>
                    </div>
                </li>
                <li>
                    <div class="agileits_w3layouts_news_grid">
                        <div class="w3_agileits_news_grid">
                            <img src="images/1.jpg" alt=" " class="img-responsive" />
                            <div class="w3_agileits_news_grid_pos">
                                <h4>Dia : 30 Noviembre 2016</h4>
                            </div>
                        </div>
                        <h5><a href="#" data-toggle="modal" data-target="#myModal">Futbol</a></h5>
                        <p>Torneo Juvenil.</p>
                    </div>
                </li>
            </ul>
            <script type="text/javascript">
                $(window).load(function() {
                    $("#flexiselDemo1").flexisel({
                        visibleItems: 4,
                        animationSpeed: 1000,
                        autoPlay: true,
                        autoPlaySpeed: 3000,
                        pauseOnHover: true,
                        enableResponsiveBreakpoints: true,
                        responsiveBreakpoints: {
                            portrait: {
                                changePoint:480,
                                visibleItems: 1
                            },
                            landscape: {
                                changePoint:640,
                                visibleItems:2
                            },
                            tablet: {
                                changePoint:768,
                                visibleItems: 3
                            }
                        }
                    });

                });
            </script>
            <script type="text/javascript" src="js/jquery.flexisel.js"></script>
        </div>
    </div>
</div>
<!-- //news -->
<!-- stats -->
<div class="stats">
    <div class="wthree_stat">
        <div class="container">
            <div class="col-md-5 wthree_stat_left">
                <h3>Nuestras Estadisticas</h3>
                <p>Información de actividades registradas.</p>
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
                <h3>Suscríbete a nuestra Web</h3>
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
                <h2><a href="index.jsp"><span>Sport</span>Connexus</a></h2>
                <p>Nuestra Web <a href="#">http:///SportConnexus.com</a> WebSite de reservacion de espacios deportivo.</p>
            </div>
            <div class="col-md-3 w3_footer_grid">
                <div class="w3l_footer_grid">
                    <i class="fa fa-home" aria-hidden="true"></i>
                </div>
                <h4>Dirección</h4>
                <p>Av. José Carlos Mariátegui 375 urb. Lucyana Distrito: Los Olivos</p>
            </div>
            <div class="col-md-2 w3_footer_grid">
                <div class="w3l_footer_grid">
                    <i class="fa fa-phone" aria-hidden="true"></i>
                </div>
                <h4>Llamanos al: </h4>
                <p>+(01) 543 5225 <span>+(51) 982 220 552 </span></p>
            </div>
            <div class="col-md-3 w3_footer_grid">
                <div class="w3l_footer_grid">
                    <i class="fa fa-envelope" aria-hidden="true"></i>
                </div>
                <h4>Correos: </h4>
                <p><a href="mailto:info@example.com">info@SportConnexus.com</a>
                    <span><a href="mailto:info@example.com">administracion@SportConnexus.com</a></span></p>
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
                <li><a href="portfolio.jsp">Galería</a></li>
                <li><a href="contact.jsp">Contáctanos</a></li>
            </ul>
            <p> © 2017 SportConnexus. Todos los Derechos Reservados </p>
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