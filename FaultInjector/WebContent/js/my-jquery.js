$(document).ready(function(){
    $('#experiments tbody tr').click(function()
    {
        var selected = $(this).hasClass("highlight");

        $('#experiments tbody tr').removeClass("highlight");
        $('#run').attr("disabled", false);

        if(!selected)
          $(this).addClass("highlight");
    });
});