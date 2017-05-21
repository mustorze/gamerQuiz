$(document).ready( function () {
    
    $(".bntCad").click( function(e) {
       
        e.preventDefault();
        
        window.location.href = "?p=cadastro";
        
    });
    
     $(".bntVoltar").click( function(e) {
       
        e.preventDefault();
        
        window.history.back();
        
    });
    
    $(".bntInit").click( function(e) {
       
        e.preventDefault();
        
        window.location.href = "?p=home";
        
    });
    
    $(".bntRank").click( function(e) {
       
        e.preventDefault();
        
        window.location.href = "?p=rank";
        
    });
    
} );