
(function ($) {
    "use strict";


     /*==================================================================
    [ Focus input ]*/
    $('.input100').each(function(){
        $(this).on('blur', function(){
            if($(this).val().trim() != "") {
                $(this).addClass('has-val');
            }
            else {
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