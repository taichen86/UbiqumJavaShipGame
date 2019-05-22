// function getListOfGames(){
//     console.log( "getting list of games... " );
//     fetch("/api/games" ).then( function(response){
//         console.log( "got response: " + response );
//         if( response.ok ){
//             return response.json();
//         }

//     } ).then( function( json ){
//         console.log( "got json: " + json );
//          var data = json;
//         console.log( data );
//         data.forEach( game => {
//            console.log( game );
//            vm.games.push( game );
//         });


//     console.log( vm.games );
//     }).catch( function( error ){
//         console.log( "error: " + error );
//     })
// }
// getListOfGames();

var vm = new Vue({
    el: '#vue-instance',
    data: {
        games: [],
        rows: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
        columns: ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"],
        gameplayerID: 0,
        gameplayers: []
    }
})

getGameView();

function getGameView()
{
    console.log( location.search );
    console.log( paramObj( location.search ))
    const gp = paramObj( location.search ).gp || "1";
    console.log( "game view for gp ... " + gp );
    vm.gameplayerID = gp;
    console.log( vm.gameplayerID );

    const url = "http://localhost:8080/api/game_view/" + gp;
    console.log( url );
    fetch( url ).then( function(response){
        console.log( "got response: " + response );
        if( response.ok ){
            return response.json();
        }

    } ).then( function( json ){
        console.log( "got json: " + json );
         var data = json;
        console.log( data );
        data.gameplayers.forEach( gp => {
            console.log( gp );
            vm.gameplayers.push( gp );
         });       


    }).catch( function( error ){
        console.log( "error: " + error );
    })
}



function paramObj(search) {
    var obj = {};
    var reg = /(?:[?&]([^?&#=]+)(?:=([^&#]*))?)(?:#.*)?/g;
  
    search.replace(reg, function(match, param, val) {
      obj[decodeURIComponent(param)] = val === undefined ? "" : decodeURIComponent(val);
    });
  
    return obj;
  }




//----- plain javascript -----//
