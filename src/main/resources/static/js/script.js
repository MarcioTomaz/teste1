alert("teste")

const urlParams = new URLSearchParams(window.location.search);

console.log(urlParams);

const clientId = urlParams.get("id?=")

console.log("CLIENT ID: ", clientId)