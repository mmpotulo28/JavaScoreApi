async function play(type) {
    let result, url;
    switch (type) {
        case "rock":
            result = "tie"
            url = "http://localhost:8080/score/ties"
            break;
        case "paper":
            result = "win"
            url = "http://localhost:8080/score/wins"
            break;
        default:
            result = "lose"
            url = "http://localhost:8080/score/losses"
            break;
    }

    try {
        const response = await fetch(url, {method: "POST"});
        console.log(response)
        const data = await response.json();
        console.log(data)

        document.getElementById("results").innerHTML = `
        <p>It\'s a ${result}!</p>
        <p>Your score is:</p>`;

        document.getElementById("wins").innerHTML = data["wins"];
        document.getElementById("ties").innerHTML = data["ties"];
        document.getElementById("losses").innerHTML = data["losses"];
    } catch (error) {
        console.error("Couldn't get data from server", error);
    }

    document.getElementById("results").style.color = "red";
    document.getElementById("results").style.fontSize = "20px";
}