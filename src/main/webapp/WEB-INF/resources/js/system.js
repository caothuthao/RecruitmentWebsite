'use strict';

$(document).ready(function () {
    $('[data-toggle="tooltip"]').tooltip()
    let $textInput = $('input[type=text]');
    $textInput.on('focus', function () {
        $(this).removeClass('error_input');
        $($(this).next('div')).find("label").remove();
    });
    $textInput.on('blur', function () {
        let value = $(this).val().trim();
        $(this).val(value);
    });
    $('select').on('focus', function () {
        $(this).removeClass('error_input');
        $($(this).next('div')).find("label").remove();
    });

    let $successMessage = $('#success_message');
    if ($successMessage.length) {
        $successMessage.show();
        $successMessage.fadeTo(2000, 1000).slideUp(1000, function(){
            $successMessage.slideUp(500);
            $successMessage.remove();
        });
    } else {
        $successMessage.remove();
    }
});

$(function () {
    $('#btn-logout').click(function (e) {
        e.preventDefault();
        $('#form-logout').submit();
    });

    $('.delete-btn').click(function () {
        return confirm("Are you sure you want to delete?");
    });

    $('#langEn').click(function () {
        changeLanguage("en")
    });

    $('#langJa').click(function () {
        changeLanguage("ja")
    });

    $('#model_source_select').on('change', function () {
        $('#upload_modal_source_id').val($(this).val())
    });

    $('.date-picker').bootstrapMaterialDatePicker({ weekStart : 0, time: false, clearButton: true, lang: 'ja', switchOnClick: true, format: 'YYYY-MM-DD'});
    $('.date-md-picker').bootstrapMaterialDatePicker({ weekStart : 0, time : false, clearButton: true, lang: 'ja', switchOnClick: true, format: 'MM-DD'});
    $('.time-picker').bootstrapMaterialDatePicker({ date: false, clearButton: true, shortTime: false, lang: 'ja', switchOnClick: true, format: 'HH:mm'});
    $('.month-picker').bootstrapMaterialDatePicker({monthPicker: true, time: false, clearButton: true, lang: 'ja', switchOnClick: true, format: 'YYYY-MM'});
    $('.ja-month-picker').bootstrapMaterialDatePicker({monthPicker: true, time: false, clearButton: true, lang: 'ja', switchOnClick: true, format: 'YYYY年MM月'});
    $('input[type=text]').popover({trigger:'focus'});

});

function changeLanguage(lang) {
    var url = '/change_language?lang=' + lang;
    $.ajax({
        url: url,
        type: 'GET',
        data: {'lang': lang}
    }).done(function (data) {
        location.reload();
    }).fail(function (jqXHR) {
    })
}

( function ( document, window, index )
{
    var inputs = document.querySelectorAll( '.input-file' );
    Array.prototype.forEach.call( inputs, function( input )
    {
        let label    = input.nextElementSibling,
            labelVal = label.innerHTML;

        input.addEventListener( 'change', function( e )
        {
            let fileName = '';
            if( this.files && this.files.length > 1 )
                fileName = ( this.getAttribute( 'data-multiple-caption' ) || '' ).replace( '{count}', this.files.length );
            else
                fileName = e.target.value.split( '\\' ).pop();

            let isCsvFile = false;
            if (fileName && this.id === 'csv-file') {
                isCsvFile = true;
                if (!fileName.endsWith(".xlsx")) {
                    fileName = '';
                    $(this).val('');
                }
            }

            if (fileName) {
                label.querySelector('span').innerHTML = fileName;
                if (isCsvFile) {
                    hideAlert();
                }
            } else {
                label.innerHTML = labelVal;
                if (isCsvFile) {
                    showAlert();
                }
            }
        });

        // Firefox bug fix
        input.addEventListener( 'focus', function(){ input.classList.add( 'has-focus' ); });
        input.addEventListener( 'blur', function(){ input.classList.remove( 'has-focus' ); });
    });
}( document, window, 0 ));

function filterInput(item) {
    let regexFilterId = /^[^\u3000-\u303f\u3040-\u309f\u30a0-\u30ff\u4e00-\u9faf\uff00-\uffef ]*$/;
    setInputFilter(item, function (value) {
        return regexFilterId.test(value);
    });

    function setInputFilter(textbox, inputFilter) {
        ["input", "keydown", "keyup", "mousedown", "mouseup", "select", "contextmenu", "drop"].forEach(function(event) {
            textbox.on(event, function() {
                if (inputFilter(this.value)) {
                    this.oldValue = this.value;
                    this.oldSelectionStart = this.selectionStart;
                    this.oldSelectionEnd = this.selectionEnd;
                } else if (this.hasOwnProperty("oldValue")) {
                    this.value = this.oldValue;
                    this.setSelectionRange(this.oldSelectionStart, this.oldSelectionEnd);
                }
            });
        });
    }
}

function backToAccountList() {
    window.location.href= "/account/list"
}


