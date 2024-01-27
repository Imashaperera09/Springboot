document.addEventListener("DOMContentLoaded" ,function(){
    //triggering after the content is loaded

    getItems();
});

const getItems = () => { //function getItems(){ }
    fetch("http://localhost:8080/item").then((response) => {
        return response.json();
    }).then((data) => {

        let items = "";

        data.map((item) => {
           items += `<div class="col-lg-3 col-sm-6 col-12">` 
           items +=`<div class="card">`
           items +=`<div class="card-body">`
           items +=` <h5 class="card-title">${item.name}</h5>`
           items +=` <p class="card-text">${item.price}</p>`
           items +=`<p class="card-text">${item.quantity}</p>`
           items +=` <p class="card-text">${item.category}</p>`
           items +=`<a href="#" class="btn btn-primary">View Item</a>`
           items +=`</div></div></div>;`
        });
        

        document.getElementById("items").innerHTML = items;


        console.log(data);
    }).catch((error) => {
        console.log(error);
    })
}