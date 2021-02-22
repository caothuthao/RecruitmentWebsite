function backToListMedia() {
    window.location.href= "/media/list"
}
$(document).ready(function () {
    filterInput($("#mediaCode"));
})
$(function () {

    const arrEmail = $("#email").val().split(";")

    $("#email").tagEditor({
        initialTags: arrEmail,
        delimiter: '; ',
        maxLength: 255,
        onChange: tagChangeColor,
        beforeTagSave: function(field, editor, tags, tag, val) {
            let regexFilterId = /^[^\u3000-\u303f\u3040-\u309f\u30a0-\u30ff\u4e00-\u9faf\uff00-\uffef ]*$/;
            if (!regexFilterId.test(val)) {
                return false
            }
        },
    });
    $(".ui-sortable").click(() => $('.email-error').css("display", "none"))

    tagChangeColor()

})

function tagChangeColor() {
    const regexEmail = /^[_A-Za-z0-9-\+]+(\.[_A-Za-z0-9-]+)*@[_A-Za-z0-9-]+(\.[A-Za-z0-9]+)*(\.[A-Za-z]{2,})$/
    $('.ui-sortable').find('.tag-editor-tag').each(function () {
        console.log(regexEmail.test($(this).text()), $(this).text())
        if (!regexEmail.test($(this).text())){
            $(this).addClass("red-tag")
            $(this).closest('li').find('div.tag-editor-delete').addClass("red-tag")
        } else {
            $(this).removeClass("red-tag")
            $(this).closest('li').find('div.tag-editor-delete').removeClass("red-tag")
        }
    })
}