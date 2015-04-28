$(document).ready(function(){
    if ($('.dynamicTable tbody tr').hasClass("highlight"))	
    	$('.dynamicButton').attr("disabled", false);
	
	$('.dynamicTable tbody tr').click(function()
    {
        var selected = $(this).hasClass("highlight");

        $('.dynamicTable tbody tr').removeClass("highlight");
        $('.dynamicButton').attr("disabled", false);

        if(!selected)
          $(this).addClass("highlight");
    });
	
    $('#all').click(function(event) {  //on click
//        if(this.checked) { // check select status
//            $('.cb').each(function() { //loop through each checkbox
//                this.checked = true;  //select all checkboxes with class "checkbox1"              
//            });
//        }else{
            $('.cb').each(function() { //loop through each checkbox
                this.checked = true; //deselect all checkboxes with class "checkbox1"                      
            });
            
            $('#finish').attr("disabled", false);
//        }
    });
    
    function isEmpty(el)
    {
        return !$.trim(el.html());
    }
});