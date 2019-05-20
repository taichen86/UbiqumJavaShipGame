function getListOfGames(){
    console.log( "getting list of games... " );
    fetch("/api/games" ).then( function(response){
        console.log( "got response: " + response );
        if( response.ok ){
            return response.json();
        }

    } ).then( function( json ){
        console.log( "got json: " + json );
         var data = json;
        console.log( data );
        data.forEach( game => {
           console.log( game );
           vm.games.push( game );
        });


    console.log( vm.games );
    }).catch( function( error ){
        console.log( "error: " + error );
    })
}

getListOfGames();


var vm = new Vue({
    el: '#vue-instance',
    data: {
        games: []
    }
})