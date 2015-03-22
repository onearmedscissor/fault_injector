$(document).ready(function(){
    if ($('.tableSection tbody tr').hasClass("highlight"))	
    	$('.buttonSection').attr("disabled", false);
	
	$('.tableSection tbody tr').click(function()
    {
        var selected = $(this).hasClass("highlight");

        $('.tableSection tbody tr').removeClass("highlight");
        $('.buttonSection').attr("disabled", false);

        if(!selected)
          $(this).addClass("highlight");
    });

    $('#all').click(function(event) {  //on click
        if(this.checked) { // check select status
            $('.cb').each(function() { //loop through each checkbox
                this.checked = true;  //select all checkboxes with class "checkbox1"              
            });
        }else{
            $('.cb').each(function() { //loop through each checkbox
                this.checked = false; //deselect all checkboxes with class "checkbox1"                      
            });        
        }
    });
    
    function isEmpty(el)
    {
        return !$.trim(el.html());
    }
});