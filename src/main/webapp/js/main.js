
function updateRating(rating){
    let formElement=document.getElementById('ratingForm');
    let inputElement=document.getElementById('rating');

    inputElement.value=rating;//up, down
    //formElement[0].value=rating;

    //event.preventDefault();

       formElement.submit();

};

