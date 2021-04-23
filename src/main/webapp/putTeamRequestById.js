function putTeamRequestById(data) {
        let t_name = document.getElementById('name').value;
        let name = document.getElementById('captain_name').value;
        let phone = document.getElementById('captain_phone').value;
        let email = document.getElementById('captain_email').value;

    let params = '?name=' + t_name + '&captainName=' + name + '&captainPhone=' + phone + "&captainEmail=" + email;

    let apiUrl = '/submission/' + id + params;
    fetch(apiUrl, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
        body: data
      }
    }).then(function(response) {
      console.log(response);
      if(response.ok) {
          location.pathname = '/admin/tournament/' + tournamentId + '/season/' + seasonId + '/submission';
      }
      else {
          alert('Error');
      }
      return  response.json();
    }).then(function(data) {
      console.log(data);
    })
}