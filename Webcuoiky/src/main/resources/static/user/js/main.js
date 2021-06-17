/*  ---------------------------------------------------
    Template Name: Ogani
    Description:  Ogani eCommerce  HTML Template
    Author: Colorlib
    Author URI: https://colorlib.com
    Version: 1.0
    Created: Colorlib
---------------------------------------------------------  */

'use strict';

(function ($) {

    /*------------------
        Preloader
    --------------------*/
    $(window).on('load', function () {
        $(".loader").fadeOut();
        $("#preloder").delay(200).fadeOut("slow");

        /*------------------
            Gallery filter
        --------------------*/
        $('.featured__controls li').on('click', function () {
            $('.featured__controls li').removeClass('active');
            $(this).addClass('active');
        });
        if ($('.featured__filter').length > 0) {
            var containerEl = document.querySelector('.featured__filter');
            var mixer = mixitup(containerEl);
        }
    });

    /*------------------
        Background Set
    --------------------*/
    $('.set-bg').each(function () {
        var bg = $(this).data('setbg');
        $(this).css('background-image', 'url(' + bg + ')');
    });

    //Humberger Menu
    $(".humberger__open").on('click', function () {
        $(".humberger__menu__wrapper").addClass("show__humberger__menu__wrapper");
        $(".humberger__menu__overlay").addClass("active");
        $("body").addClass("over_hid");
    });

    $(".humberger__menu__overlay").on('click', function () {
        $(".humberger__menu__wrapper").removeClass("show__humberger__menu__wrapper");
        $(".humberger__menu__overlay").removeClass("active");
        $("body").removeClass("over_hid");
    });

    /*------------------
		Navigation
	--------------------*/
    $(".mobile-menu").slicknav({
        prependTo: '#mobile-menu-wrap',
        allowParentLinks: true
    });

    /*-----------------------
        Categories Slider
    ------------------------*/
    $(".categories__slider").owlCarousel({
        loop: true,
        margin: 0,
        items: 4,
        dots: false,
        nav: true,
        navText: ["<span class='fa fa-angle-left'><span/>", "<span class='fa fa-angle-right'><span/>"],
        animateOut: 'fadeOut',
        animateIn: 'fadeIn',
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true,
        responsive: {

            0: {
                items: 1,
            },

            480: {
                items: 2,
            },

            768: {
                items: 3,
            },

            992: {
                items: 4,
            }
        }
    });


    $('.hero__categories__all').on('click', function () {
        $('.hero__categories  .hero__categories__menu').slideToggle(400);
    });

    /*--------------------------
        Latest Product Slider
    ----------------------------*/
    $(".latest-product__slider").owlCarousel({
        loop: true,
        margin: 0,
        items: 1,
        dots: false,
        nav: true,
        navText: ["<span class='fa fa-angle-left'><span/>", "<span class='fa fa-angle-right'><span/>"],
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true
    });

    /*-----------------------------
        Product Discount Slider
    -------------------------------*/
    $(".product__discount__slider").owlCarousel({
        loop: true,
        margin: 0,
        items: 3,
        dots: true,
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true,
        responsive: {

            320: {
                items: 1,
            },

            480: {
                items: 2,
            },

            768: {
                items: 2,
            },

            992: {
                items: 3,
            }
        }
    });

    /*---------------------------------
        Product Details Pic Slider
    ----------------------------------*/
    $(".product__details__pic__slider").owlCarousel({
        loop: true,
        margin: 20,
        items: 4,
        dots: true,
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true
    });

    /*-----------------------
		Price Range Slider
	------------------------ */
    var rangeSlider = $(".price-range"),
        minamount = $("#minamount"),
        maxamount = $("#maxamount"),
        minPrice = rangeSlider.data('min'),
        maxPrice = rangeSlider.data('max');
    rangeSlider.slider({
        range: true,
        min: minPrice,
        max: maxPrice,
        values: [minPrice, maxPrice],
        slide: function (event, ui) {
            minamount.val('$' + ui.values[0]);
            maxamount.val('$' + ui.values[1]);
        }
    });
    minamount.val('$' + rangeSlider.slider("values", 0));
    maxamount.val('$' + rangeSlider.slider("values", 1));

    /*--------------------------
        Select
    ----------------------------*/
    $("select").niceSelect();

    /*------------------
		Single Product
	--------------------*/
    $('.product__details__pic__slider img').on('click', function () {

        var imgurl = $(this).data('imgbigurl');
        var bigImg = $('.product__details__pic__item--large').attr('src');
        if (imgurl != bigImg) {
            $('.product__details__pic__item--large').attr({
                src: imgurl
            });
        }
    });

    /*-------------------
		Quantity change
	--------------------- */
    var proQty = $('.pro-qty');
    proQty.prepend('<span class="dec qtybtn">-</span>');
    proQty.append('<span class="inc qtybtn">+</span>');
    proQty.on('click', '.qtybtn', function () {
        var $button = $(this);
        var oldValue = $button.parent().find('input').val();
        if ($button.hasClass('inc')) {
            var newVal = parseFloat(oldValue) + 1;
        } else {
            // Don't allow decrementing below zero
            if (oldValue > 0) {
                var newVal = parseFloat(oldValue) - 1;
            } else {
                newVal = 0;
            }
        }
        $button.parent().find('input').val(newVal);
    });

})(jQuery);

/*-------------------

	--------------------- */
// When the user scrolls down 20px from the top of the document, slide down the navbar
window.onscroll = function () {
    scrollFunction()
};

function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        document.getElementById("navbar").style.top = "0";
    } else {
        document.getElementById("navbar").style.top = "0px";
    }
}

var prevScrollpos = window.pageYOffset;
window.onscroll = function () {
    var currentScrollPos = window.pageYOffset;
    if (prevScrollpos > currentScrollPos) {
        document.getElementById("navbar").style.top = "0";
    } else {
        document.getElementById("navbar").style.top = "-50px";
    }
    prevScrollpos = currentScrollPos;
}

$('a').each(function () {
    $(this).click(function () {
        $('a').removeClass('selected');
        $(this).addClass('selected');
    })
});
$('#cart, .shopping-cart').hover(function (e) {
    $(".shopping-cart").stop(true, true).addClass("active");
}, function () {
    $(".shopping-cart").stop(true, true).removeClass("active");
});
// sua tu day


// function myFunction() {
//     var x = document.getElementById("password");
//     var y = document.getElementById("confirm_password");
//     if (x.type === "password" && y.type === "password") {
//         x.type = "text";
//         y.type = "text";
//     } else {
//         x.type = "password";
//         y.type = "password";
//     }
// }

// function check() {
//     let btn = document.getElementById('button-reset');
//     if (document.getElementById('password').value ==
//         document.getElementById('confirm_password').value) {
//         document.getElementById('message').style.color = 'green';
//         document.getElementById('message').innerHTML = '<i class="fa fa-check-circle" aria-hidden="true"></i>';
//         if(document.getElementById('password').value !="" &&
//             document.getElementById('confirm_password').value != ""){
//             btn.disabled = (this.value ==='');
//         }
//
//     } else {
//         document.getElementById('message').style.color = 'red';
//         document.getElementById('message').innerHTML = '<i class="fa fa-times-circle" aria-hidden="true"></i>';
//     }
//     if (document.getElementById('password').value == ""){
//         document.getElementById('check').style.color = 'red';
//         document.getElementById('check').innerHTML = 'Null';
//         if (document.getElementById('confirm_password').value == "")
//             document.getElementById('message').innerHTML = '';
//     }
//     else { document.getElementById('check').innerHTML = '';}
// }
var myIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";
    }
    myIndex++;
    if (myIndex > x.length) {
        myIndex = 1
    }
    x[myIndex - 1].style.display = "block";
    setTimeout(carousel, 2000); // Change image every 2 seconds
}

(function ($) {
    "use strict";


    /*==================================================================
   [ Focus input ]*/
    $('.input100').each(function () {
        $(this).on('blur', function () {
            if ($(this).val().trim() != "") {
                $(this).addClass('has-val');
            } else {
                $(this).removeClass('has-val');
            }
        })
    })


    /*==================================================================
    [ Validate ]*/

    // var inputName = $('.validate-form .input-name');
    // var inputPass =$('.validate-form .input-pass');
    // var inputPassConfirm = $('.validate-form .input-pass-confirm');
    // var inputCheck = $('.validate-form .input-check');
    // $('.validate-form').on('submit',function(){
    //     var check = true;
    //     if(inputName.val().trim() == ''  || inputPass.val().trim() == '' ||
    //         inputPassConfirm.val().trim() == ''){
    //         showValidate();
    //         check = false;
    //     }
    //     else {
    //         if (inputName.val().trim().length < 8) {
    //             showValidateName();
    //             check = false;
    //         }
    //         if (inputPass.val().trim().length < 8) {
    //             showValidatePass();
    //             check = false;
    //         }
    //         if (inputPassConfirm.val().trim().length !== inputPass.val().trim().length) {
    //             showValidatePassConfirm();
    //             check = false;
    //         }
    //         if (inputCheck.prop('checked') == false) {
    //             showValidateCheck();
    //             check = false;
    //         }
    //     }
    //     return check;
    // });
    // function showValidate() {
    //     var thisAlert = $('.input100').parent();
    //     thisAlert.addClass('alert-validate');
    // }
    // function showValidateName() {
    //     var thisAlert = $('.input-name').parent();
    //     thisAlert.addClass('alert-validate-name');
    // }
    // function showValidatePass() {
    //     var thisAlert = $('.input-pass').parent();
    //     thisAlert.addClass('alert-validate-pass');
    // }
    // function showValidatePassConfirm() {
    //     var thisAlert = $('.input-pass-confirm').parent();
    //     thisAlert.addClass('alert-validate-pass-confirm');
    // }
    // function showValidateCheck() {
    //     var thisAlert = $('.input-check').parent().parent();
    //     thisAlert.addClass('alert-validate-check');
    // }
    //
    // $('.validate-form .input100').each(function(){
    //     $(this).focus(function(){
    //        hideValidate(this);
    //     });
    // });
    //
    // function hideValidate(input) {
    //     var thisAlert = $(input).parent();
    //     $(thisAlert).removeClass('alert-validate');
    //     $('.input-name').parent().removeClass('alert-validate-name');
    //     $('.input-pass').parent().removeClass('alert-validate-pass');
    //     $('.input-pass-confirm').parent().removeClass('alert-validate-pass-confirm');
    //     $('.input-check').parent().parent().removeClass('alert-validate-check');
    // }

})(jQuery);