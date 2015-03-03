$(document).ready(function(){
    $('.tableSection tbody tr').click(function()
    {
        var selected = $(this).hasClass("highlight");

        $('.tableSection tbody tr').removeClass("highlight");
        $('.buttonSection').attr("disabled", false);

        if(!selected)
          $(this).addClass("highlight");
    });
});