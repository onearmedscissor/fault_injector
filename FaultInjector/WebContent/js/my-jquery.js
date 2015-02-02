$(document).ready(function(){
    $('table tbody tr').click(function(){
        var selected = $(this).hasClass("highlight");

        $('table tbody tr').removeClass("highlight");
        $('#run').attr("disabled", false);

        if(!selected)
          $(this).addClass("highlight");
    });
});