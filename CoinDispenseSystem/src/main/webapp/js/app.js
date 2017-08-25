
function loginUser(userData) {
    //clear existing  msgs	
    $('span.invalid').remove();
    $('span.success').remove();

    // Display the loader widget
    $.mobile.loading("show"); 
    
   // var userName = $("#username").val();
   // var password = $("#password").val();    
   // console.log("User Name:"+userName);
  //  console.log("Password:"+password);
    console.log(JSON.stringify(userData));
    //console.log(JSON.parse(userData));
    console.log(userData);
    
    $.ajax({
        url: 'rest/user/',
        contentType: "application/json",
        dataType: "json",
        type: "GET",
        data: userData,        
        success: function(data) {
            document.location = "http://localhost:8080/CoinDispenseSystem/#dispense";
        },
        error: function(error) {        	
                $('#formMsgs').append($('<span class="invalid">The username or password is incorrect</span>'));            
        },
        complete: function() {
            // Hide the loader widget
            $.mobile.loading("hide");
        }
    });
}

function notesBreakdown(notes) {
    //clear existing  msgs	
	console.log("notesBreadown colled:"+notes);
    $('span.invalid').remove();
    $('span.success').remove();

    // Display the loader widget
    $.mobile.loading("show"); 
    
      
   // console.log("User Name:"+userName);
  //  console.log("Password:"+password);
    console.log(JSON.stringify(notes));
    //console.log(JSON.parse(userData));
    console.log(notes);
    
    $.ajax({
        url: 'rest/notes/',
        contentType: "application/json",
        dataType: "json",
        type: "GET",
        data: notes,        
        success: function(resp) {
        	$('#results').empty();
        	$.each(resp,function(i,item){        		
        		$('#results').append(
        			"<tr>"
        	            +"<td>"+item.name+"</td>"
        	            +"<td>"+item.value+"</td>"
        	        +"</tr>"	
        		);
        	});
        	
            document.location = "http://localhost:8080/CoinDispenseSystem/#Bresults";
        },
        error: function(error) {        	
                $('#formMsgs').append($('<span class="invalid">The rand note is incorrect</span>'));            
        },
        complete: function() {
            // Hide the loader widget
            $.mobile.loading("hide");
        }
    });
}



