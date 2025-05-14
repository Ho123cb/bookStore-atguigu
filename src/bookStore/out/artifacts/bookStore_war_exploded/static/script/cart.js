function del(id) {
    window.location.href= 'cart.do?operate=editCart&oop=0&id='+id;
}

function add(id){
    window.location.href = 'cart.do?operate=editCart&oop=1&id='+id;
}